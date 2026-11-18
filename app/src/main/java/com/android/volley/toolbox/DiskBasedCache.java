package com.android.volley.toolbox;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.Cache$Entry;
import com.android.volley.Header;
import com.android.volley.VolleyLog;
import defpackage.ak;
import defpackage.e;
import defpackage.g;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class DiskBasedCache {
    public final g mRootDirectorySupplier;
    public final LinkedHashMap mEntries = new LinkedHashMap(16, 0.75f, true);
    public long mTotalSize = 0;
    public final int mMaxCacheSizeInBytes = 5242880;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class CacheHeader {
        public final List allResponseHeaders;
        public final String etag;
        public final String key;
        public final long lastModified;
        public final long serverDate;
        public long size;
        public final long softTtl;
        public final long ttl;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.util.List] */
        public CacheHeader(String str, Cache$Entry cache$Entry) {
            String str2 = cache$Entry.etag;
            long j = cache$Entry.serverDate;
            long j2 = cache$Entry.lastModified;
            long j3 = cache$Entry.ttl;
            long j4 = cache$Entry.softTtl;
            ?? arrayList = cache$Entry.allResponseHeaders;
            if (arrayList == 0) {
                Map map = cache$Entry.responseHeaders;
                arrayList = new ArrayList(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    arrayList.add(new Header((String) entry.getKey(), (String) entry.getValue()));
                }
            }
            this(str, str2, j, j2, j3, j4, arrayList);
        }

        public CacheHeader(String str, String str2, long j, long j2, long j3, long j4, List list) {
            this.key = str;
            this.etag = AppConfig.CUSTOM.equals(str2) ? null : str2;
            this.serverDate = j;
            this.lastModified = j2;
            this.ttl = j3;
            this.softTtl = j4;
            this.allResponseHeaders = list;
        }

        public static CacheHeader readHeader(CountingInputStream countingInputStream) throws IOException {
            if (DiskBasedCache.readInt(countingInputStream) != 538247942) {
                throw new IOException();
            }
            String string = DiskBasedCache.readString(countingInputStream);
            String string2 = DiskBasedCache.readString(countingInputStream);
            long j = DiskBasedCache.readLong(countingInputStream);
            long j2 = DiskBasedCache.readLong(countingInputStream);
            long j3 = DiskBasedCache.readLong(countingInputStream);
            long j4 = DiskBasedCache.readLong(countingInputStream);
            int i = DiskBasedCache.readInt(countingInputStream);
            if (i < 0) {
                throw new IOException(ak.h(i, "readHeaderList size="));
            }
            List arrayList = i == 0 ? Collections.EMPTY_LIST : new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new Header(DiskBasedCache.readString(countingInputStream).intern(), DiskBasedCache.readString(countingInputStream).intern()));
            }
            return new CacheHeader(string, string2, j, j2, j3, j4, arrayList);
        }

        public final Cache$Entry toCacheEntry(byte[] bArr) {
            Cache$Entry cache$Entry = new Cache$Entry();
            cache$Entry.data = bArr;
            cache$Entry.etag = this.etag;
            cache$Entry.serverDate = this.serverDate;
            cache$Entry.lastModified = this.lastModified;
            cache$Entry.ttl = this.ttl;
            cache$Entry.softTtl = this.softTtl;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            List<Header> list = this.allResponseHeaders;
            for (Header header : list) {
                treeMap.put(header.mName, header.mValue);
            }
            cache$Entry.responseHeaders = treeMap;
            cache$Entry.allResponseHeaders = Collections.unmodifiableList(list);
            return cache$Entry;
        }

        public final boolean writeHeader(BufferedOutputStream bufferedOutputStream) {
            try {
                DiskBasedCache.writeInt(bufferedOutputStream, 538247942);
                DiskBasedCache.writeString(bufferedOutputStream, this.key);
                String str = this.etag;
                if (str == null) {
                    str = AppConfig.CUSTOM;
                }
                DiskBasedCache.writeString(bufferedOutputStream, str);
                DiskBasedCache.writeLong(bufferedOutputStream, this.serverDate);
                DiskBasedCache.writeLong(bufferedOutputStream, this.lastModified);
                DiskBasedCache.writeLong(bufferedOutputStream, this.ttl);
                DiskBasedCache.writeLong(bufferedOutputStream, this.softTtl);
                List<Header> list = this.allResponseHeaders;
                if (list != null) {
                    DiskBasedCache.writeInt(bufferedOutputStream, list.size());
                    for (Header header : list) {
                        DiskBasedCache.writeString(bufferedOutputStream, header.mName);
                        DiskBasedCache.writeString(bufferedOutputStream, header.mValue);
                    }
                } else {
                    DiskBasedCache.writeInt(bufferedOutputStream, 0);
                }
                bufferedOutputStream.flush();
                return true;
            } catch (IOException e) {
                VolleyLog.buildMessage("%s", e.toString());
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class CountingInputStream extends FilterInputStream {
        public long bytesRead;
        public final long length;

        public CountingInputStream(BufferedInputStream bufferedInputStream, long j) {
            super(bufferedInputStream);
            this.length = j;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read() throws IOException {
            int i = super.read();
            if (i != -1) {
                this.bytesRead++;
            }
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = super.read(bArr, i, i2);
            if (i3 != -1) {
                this.bytesRead += (long) i3;
            }
            return i3;
        }
    }

    public DiskBasedCache(g gVar) {
        this.mRootDirectorySupplier = gVar;
    }

    public static String getFilenameForKey(String str) {
        int length = str.length() / 2;
        StringBuilder sbD = e.d(String.valueOf(str.substring(0, length).hashCode()));
        sbD.append(String.valueOf(str.substring(length).hashCode()));
        return sbD.toString();
    }

    public static int read(CountingInputStream countingInputStream) throws IOException {
        int i = countingInputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    public static int readInt(CountingInputStream countingInputStream) {
        return (read(countingInputStream) << 24) | read(countingInputStream) | (read(countingInputStream) << 8) | (read(countingInputStream) << 16);
    }

    public static long readLong(CountingInputStream countingInputStream) {
        return (((long) read(countingInputStream)) & 255) | ((((long) read(countingInputStream)) & 255) << 8) | ((((long) read(countingInputStream)) & 255) << 16) | ((((long) read(countingInputStream)) & 255) << 24) | ((((long) read(countingInputStream)) & 255) << 32) | ((((long) read(countingInputStream)) & 255) << 40) | ((((long) read(countingInputStream)) & 255) << 48) | ((255 & ((long) read(countingInputStream))) << 56);
    }

    public static String readString(CountingInputStream countingInputStream) {
        return new String(streamToBytes(countingInputStream, readLong(countingInputStream)), "UTF-8");
    }

    public static byte[] streamToBytes(CountingInputStream countingInputStream, long j) throws IOException {
        long j2 = countingInputStream.length - countingInputStream.bytesRead;
        if (j >= 0 && j <= j2) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(countingInputStream).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + j2);
    }

    public static void writeInt(BufferedOutputStream bufferedOutputStream, int i) throws IOException {
        bufferedOutputStream.write(i & 255);
        bufferedOutputStream.write((i >> 8) & 255);
        bufferedOutputStream.write((i >> 16) & 255);
        bufferedOutputStream.write((i >> 24) & 255);
    }

    public static void writeLong(BufferedOutputStream bufferedOutputStream, long j) throws IOException {
        bufferedOutputStream.write((byte) j);
        bufferedOutputStream.write((byte) (j >>> 8));
        bufferedOutputStream.write((byte) (j >>> 16));
        bufferedOutputStream.write((byte) (j >>> 24));
        bufferedOutputStream.write((byte) (j >>> 32));
        bufferedOutputStream.write((byte) (j >>> 40));
        bufferedOutputStream.write((byte) (j >>> 48));
        bufferedOutputStream.write((byte) (j >>> 56));
    }

    public static void writeString(BufferedOutputStream bufferedOutputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        writeLong(bufferedOutputStream, bytes.length);
        bufferedOutputStream.write(bytes, 0, bytes.length);
    }

    public final synchronized Cache$Entry get(String str) {
        CacheHeader cacheHeader = (CacheHeader) this.mEntries.get(str);
        if (cacheHeader == null) {
            return null;
        }
        File fileForKey = getFileForKey(str);
        try {
            CountingInputStream countingInputStream = new CountingInputStream(new BufferedInputStream(new FileInputStream(fileForKey)), fileForKey.length());
            try {
                CacheHeader header = CacheHeader.readHeader(countingInputStream);
                if (TextUtils.equals(str, header.key)) {
                    Cache$Entry cacheEntry = cacheHeader.toCacheEntry(streamToBytes(countingInputStream, countingInputStream.length - countingInputStream.bytesRead));
                    countingInputStream.close();
                    return cacheEntry;
                }
                VolleyLog.buildMessage("%s: key=%s, found=%s", fileForKey.getAbsolutePath(), str, header.key);
                CacheHeader cacheHeader2 = (CacheHeader) this.mEntries.remove(str);
                if (cacheHeader2 != null) {
                    this.mTotalSize -= cacheHeader2.size;
                }
                countingInputStream.close();
                return null;
            } catch (Throwable th) {
                countingInputStream.close();
                throw th;
            }
        } catch (IOException e) {
            VolleyLog.buildMessage("%s: %s", fileForKey.getAbsolutePath(), e.toString());
            remove(str);
            return null;
        }
    }

    public final File getFileForKey(String str) {
        return new File(this.mRootDirectorySupplier.get(), getFilenameForKey(str));
    }

    public final synchronized void initialize() {
        File file = this.mRootDirectorySupplier.get();
        if (!file.exists()) {
            if (!file.mkdirs()) {
                VolleyLog.buildMessage("Unable to create cache dir %s", file.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            try {
                long length = file2.length();
                CountingInputStream countingInputStream = new CountingInputStream(new BufferedInputStream(new FileInputStream(file2)), length);
                try {
                    CacheHeader header = CacheHeader.readHeader(countingInputStream);
                    header.size = length;
                    putEntry(header.key, header);
                    countingInputStream.close();
                } catch (Throwable th) {
                    countingInputStream.close();
                    throw th;
                }
            } catch (IOException unused) {
                file2.delete();
            }
        }
    }

    public final void pruneIfNeeded() {
        long j = this.mTotalSize;
        int i = this.mMaxCacheSizeInBytes;
        if (j < i) {
            return;
        }
        if (VolleyLog.DEBUG) {
            VolleyLog.v("Pruning old cache entries.", new Object[0]);
        }
        long j2 = this.mTotalSize;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator it = this.mEntries.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            CacheHeader cacheHeader = (CacheHeader) ((Map.Entry) it.next()).getValue();
            if (getFileForKey(cacheHeader.key).delete()) {
                this.mTotalSize -= cacheHeader.size;
            } else {
                String str = cacheHeader.key;
                VolleyLog.buildMessage("Could not delete cache entry for key=%s, filename=%s", str, getFilenameForKey(str));
            }
            it.remove();
            i2++;
            if (this.mTotalSize < i * 0.9f) {
                break;
            }
        }
        if (VolleyLog.DEBUG) {
            VolleyLog.v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.mTotalSize - j2), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    public final synchronized void put(String str, Cache$Entry cache$Entry) {
        long j = this.mTotalSize;
        byte[] bArr = cache$Entry.data;
        long length = j + ((long) bArr.length);
        int i = this.mMaxCacheSizeInBytes;
        if (length > i && bArr.length > i * 0.9f) {
            return;
        }
        File fileForKey = getFileForKey(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileForKey));
            CacheHeader cacheHeader = new CacheHeader(str, cache$Entry);
            if (!cacheHeader.writeHeader(bufferedOutputStream)) {
                bufferedOutputStream.close();
                VolleyLog.buildMessage("Failed to write header for %s", fileForKey.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(cache$Entry.data);
            bufferedOutputStream.close();
            cacheHeader.size = fileForKey.length();
            putEntry(str, cacheHeader);
            pruneIfNeeded();
        } catch (IOException unused) {
            if (!fileForKey.delete()) {
                VolleyLog.buildMessage("Could not clean up file %s", fileForKey.getAbsolutePath());
            }
            if (!this.mRootDirectorySupplier.get().exists()) {
                VolleyLog.buildMessage("Re-initializing cache after external clearing.", new Object[0]);
                this.mEntries.clear();
                this.mTotalSize = 0L;
                initialize();
            }
        }
    }

    public final void putEntry(String str, CacheHeader cacheHeader) {
        LinkedHashMap linkedHashMap = this.mEntries;
        if (linkedHashMap.containsKey(str)) {
            this.mTotalSize = (cacheHeader.size - ((CacheHeader) linkedHashMap.get(str)).size) + this.mTotalSize;
        } else {
            this.mTotalSize += cacheHeader.size;
        }
        linkedHashMap.put(str, cacheHeader);
    }

    public final synchronized void remove(String str) {
        try {
            boolean zDelete = getFileForKey(str).delete();
            CacheHeader cacheHeader = (CacheHeader) this.mEntries.remove(str);
            if (cacheHeader != null) {
                this.mTotalSize -= cacheHeader.size;
            }
            if (!zDelete) {
                VolleyLog.buildMessage("Could not delete cache entry for key=%s, filename=%s", str, getFilenameForKey(str));
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
