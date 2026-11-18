package com.android.volley;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.DataMask;
import com.google.zxing.qrcode.decoder.FormatInformation;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.detector.FinderPattern;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Response {
    public final Object cacheEntry;
    public Object error;
    public boolean intermediate;
    public Object result;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface ErrorListener {
        void onErrorResponse(VolleyError volleyError);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface Listener {
        void onResponse(Object obj);
    }

    public Response(VolleyError volleyError) {
        this.intermediate = false;
        this.result = null;
        this.cacheEntry = null;
        this.error = volleyError;
    }

    public Response(BitMatrix bitMatrix, int i) throws FormatException {
        if (i == 3) {
            this.error = bitMatrix;
            this.result = new ArrayList();
            this.cacheEntry = new int[5];
        } else {
            int i2 = bitMatrix.height;
            if (i2 < 21 || (i2 & 3) != 1) {
                throw FormatException.getFormatInstance();
            }
            this.cacheEntry = bitMatrix;
        }
    }

    public Response(String str, Cache$Entry cache$Entry) {
        this.intermediate = false;
        this.result = str;
        this.cacheEntry = cache$Entry;
        this.error = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public Response(byte[] bArr, Map map) {
        ?? arrayList;
        if (map == null) {
            arrayList = 0;
        } else if (map.isEmpty()) {
            arrayList = Collections.EMPTY_LIST;
        } else {
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new Header((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(bArr, map, arrayList, false);
    }

    public Response(byte[] bArr, Map map, List list, boolean z) {
        this.error = bArr;
        this.result = map;
        this.cacheEntry = list == null ? null : Collections.unmodifiableList(list);
        this.intermediate = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public Response(byte[] bArr, boolean z, List list) {
        ?? treeMap;
        if (list == null) {
            treeMap = 0;
        } else if (list.isEmpty()) {
            treeMap = Collections.EMPTY_MAP;
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Header header = (Header) it.next();
                treeMap.put(header.mName, header.mValue);
            }
        }
        this(bArr, treeMap, list, z);
    }

    public static float centerFromEnd(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static boolean foundPatternCross(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i >= 7) {
            float f = i / 7.0f;
            float f2 = f / 2.0f;
            if (Math.abs(f - iArr[0]) < f2 && Math.abs(f - iArr[1]) < f2 && Math.abs((f * 3.0f) - iArr[2]) < 3.0f * f2 && Math.abs(f - iArr[3]) < f2 && Math.abs(f - iArr[4]) < f2) {
                return true;
            }
        }
        return false;
    }

    public int copyBit(int i, int i2, int i3) {
        boolean z = this.intermediate;
        BitMatrix bitMatrix = (BitMatrix) this.cacheEntry;
        return z ? bitMatrix.get(i2, i) : bitMatrix.get(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    public int[] getCrossCheckStateCount() {
        int[] iArr = (int[]) this.cacheEntry;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    /* JADX WARN: Code duplicated, block: B:65:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:71:0x0112  */
    /* JADX WARN: Code duplicated, block: B:72:0x0116 A[LOOP:9: B:72:0x0116->B:77:0x0124, LOOP_START, PHI: r6 r15
      0x0116: PHI (r6v2 char) = (r6v1 char), (r6v24 char) binds: [B:70:0x0110, B:77:0x0124] A[DONT_GENERATE, DONT_INLINE]
      0x0116: PHI (r15v21 int) = (r15v20 int), (r15v27 int) binds: [B:70:0x0110, B:77:0x0124] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v14, types: [int] */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [int] */
    /* JADX WARN: Type inference failed for: r14v4, types: [int] */
    /* JADX WARN: Type inference failed for: r14v5, types: [int] */
    /* JADX WARN: Type inference failed for: r15v34, types: [int] */
    /* JADX WARN: Type inference failed for: r15v35, types: [int] */
    /* JADX WARN: Type inference failed for: r15v36, types: [int] */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v13 */
    /* JADX WARN: Type inference failed for: r17v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [int] */
    /* JADX WARN: Type inference failed for: r7v11, types: [int] */
    /* JADX WARN: Type inference failed for: r7v15, types: [int] */
    /* JADX WARN: Type inference failed for: r7v19, types: [int] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:72:0x0116
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public boolean handlePossibleCenter(int[] r21, int r22, int r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.Response.handlePossibleCenter(int[], int, int, boolean):boolean");
    }

    public boolean haveMultiplyConfirmedCenters() {
        ArrayList<FinderPattern> arrayList = (ArrayList) this.result;
        int size = arrayList.size();
        float fAbs = 0.0f;
        int i = 0;
        float f = 0.0f;
        for (FinderPattern finderPattern : arrayList) {
            if (finderPattern.count >= 2) {
                i++;
                f += finderPattern.estimatedModuleSize;
            }
        }
        if (i >= 3) {
            float f2 = f / size;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                fAbs += Math.abs(((FinderPattern) it.next()).estimatedModuleSize - f2);
            }
            if (fAbs <= f * 0.05f) {
                return true;
            }
        }
        return false;
    }

    public FormatInformation readFormatInformation() {
        FormatInformation formatInformation = (FormatInformation) this.error;
        if (formatInformation != null) {
            return formatInformation;
        }
        int iCopyBit = 0;
        int iCopyBit2 = 0;
        for (int i = 0; i < 6; i++) {
            iCopyBit2 = copyBit(i, 8, iCopyBit2);
        }
        int iCopyBit3 = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, iCopyBit2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iCopyBit3 = copyBit(8, i2, iCopyBit3);
        }
        int i3 = ((BitMatrix) this.cacheEntry).height;
        int i4 = i3 - 7;
        for (int i5 = i3 - 1; i5 >= i4; i5--) {
            iCopyBit = copyBit(8, i5, iCopyBit);
        }
        for (int i6 = i3 - 8; i6 < i3; i6++) {
            iCopyBit = copyBit(i6, 8, iCopyBit);
        }
        FormatInformation formatInformationDoDecodeFormatInformation = FormatInformation.doDecodeFormatInformation(iCopyBit3, iCopyBit);
        if (formatInformationDoDecodeFormatInformation == null) {
            formatInformationDoDecodeFormatInformation = FormatInformation.doDecodeFormatInformation(iCopyBit3 ^ 21522, iCopyBit ^ 21522);
        }
        this.error = formatInformationDoDecodeFormatInformation;
        if (formatInformationDoDecodeFormatInformation != null) {
            return formatInformationDoDecodeFormatInformation;
        }
        throw FormatException.getFormatInstance();
    }

    public Version readVersion() {
        Version version = (Version) this.result;
        if (version != null) {
            return version;
        }
        int i = ((BitMatrix) this.cacheEntry).height;
        int i2 = (i - 17) / 4;
        if (i2 <= 6) {
            return Version.getVersionForNumber(i2);
        }
        int i3 = i - 11;
        int iCopyBit = 0;
        int iCopyBit2 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (int i5 = i - 9; i5 >= i3; i5--) {
                iCopyBit2 = copyBit(i5, i4, iCopyBit2);
            }
        }
        Version versionDecodeVersionInformation = Version.decodeVersionInformation(iCopyBit2);
        if (versionDecodeVersionInformation != null && (versionDecodeVersionInformation.versionNumber * 4) + 17 == i) {
            this.result = versionDecodeVersionInformation;
            return versionDecodeVersionInformation;
        }
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = i - 9; i7 >= i3; i7--) {
                iCopyBit = copyBit(i6, i7, iCopyBit);
            }
        }
        Version versionDecodeVersionInformation2 = Version.decodeVersionInformation(iCopyBit);
        if (versionDecodeVersionInformation2 == null || (versionDecodeVersionInformation2.versionNumber * 4) + 17 != i) {
            throw FormatException.getFormatInstance();
        }
        this.result = versionDecodeVersionInformation2;
        return versionDecodeVersionInformation2;
    }

    public void remask() {
        if (((FormatInformation) this.error) == null) {
            return;
        }
        DataMask dataMask = DataMask.values()[((FormatInformation) this.error).dataMask];
        BitMatrix bitMatrix = (BitMatrix) this.cacheEntry;
        int i = bitMatrix.height;
        dataMask.getClass();
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (dataMask.isMasked(i2, i3)) {
                    bitMatrix.flip(i3, i2);
                }
            }
        }
    }
}
