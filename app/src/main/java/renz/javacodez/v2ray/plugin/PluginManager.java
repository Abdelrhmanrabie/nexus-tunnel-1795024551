package renz.javacodez.v2ray.plugin;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.system.Os;
import android.widget.Toast;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.ak;
import defpackage.cz0;
import defpackage.d;
import defpackage.e;
import defpackage.e4;
import defpackage.et;
import defpackage.fb$1;
import defpackage.ft;
import defpackage.he;
import defpackage.q31;
import defpackage.tb1;
import defpackage.uh0;
import defpackage.we;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import renz.javacodez.v2ray.V2RAYApp;
import renz.javacodez.v2ray.extension._ExtKt;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class PluginManager {
    public static final PluginManager INSTANCE = new PluginManager();
    private static PluginList cachedPlugins;
    private static BroadcastReceiver receiver;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class InitResult {
        private final String path;

        public InitResult(String str) {
            this.path = str;
        }

        public static /* synthetic */ InitResult copy$default(InitResult initResult, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = initResult.path;
            }
            return initResult.copy(str);
        }

        public final String component1() {
            return this.path;
        }

        public final InitResult copy(String str) {
            return new InitResult(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InitResult) && e4.a(this.path, ((InitResult) obj).path);
        }

        public final String getPath() {
            return this.path;
        }

        public int hashCode() {
            return this.path.hashCode();
        }

        public String toString() {
            return fb$1.m(new StringBuilder("InitResult(path="), this.path, ')');
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class PluginNotFoundException extends FileNotFoundException {
        private final String plugin;

        public PluginNotFoundException(String str) {
            super(str);
            this.plugin = str;
        }

        public final String getPlugin() {
            return this.plugin;
        }
    }

    private PluginManager() {
    }

    private final Uri buildUri(String str, String str2) {
        return new Uri.Builder().scheme(PluginContract.SCHEME).authority(str2).path(InternalZipConstants.ZIP_FILE_SEPARATOR + str).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tb1 fetchPlugins$lambda$2$lambda$1() {
        synchronized (INSTANCE) {
            receiver = null;
            cachedPlugins = null;
        }
        return tb1.a;
    }

    private final InitResult initNative(String str) {
        Throwable th;
        int i = Build.VERSION.SDK_INT >= 24 ? 786560 : 128;
        List<ResolveInfo> listQueryIntentContentProviders = V2RAYApp.Companion.getApplication().getPackageManager().queryIntentContentProviders(new Intent(PluginContract.ACTION_NATIVE_PLUGIN, buildUri(str, "com.github.dyhkwong.AngApplication")), i);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listQueryIntentContentProviders) {
            if (((ResolveInfo) obj).providerInfo.exported) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            List<ResolveInfo> listQueryIntentContentProviders2 = V2RAYApp.Companion.getApplication().getPackageManager().queryIntentContentProviders(new Intent(PluginContract.ACTION_NATIVE_PLUGIN, buildUri(str, "io.nekohasekai.AngApplication")), i);
            arrayList = new ArrayList();
            for (Object obj2 : listQueryIntentContentProviders2) {
                if (((ResolveInfo) obj2).providerInfo.exported) {
                    arrayList.add(obj2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            List<ResolveInfo> listQueryIntentContentProviders3 = V2RAYApp.Companion.getApplication().getPackageManager().queryIntentContentProviders(new Intent(PluginContract.ACTION_NATIVE_PLUGIN, buildUri(str, "moe.matsuri.lite")), i);
            arrayList = new ArrayList();
            for (Object obj3 : listQueryIntentContentProviders3) {
                if (((ResolveInfo) obj3).providerInfo.exported) {
                    arrayList.add(obj3);
                }
            }
        }
        if (arrayList.isEmpty()) {
            List<ResolveInfo> listQueryIntentContentProviders4 = V2RAYApp.Companion.getApplication().getPackageManager().queryIntentContentProviders(new Intent(PluginContract.ACTION_NATIVE_PLUGIN, buildUri(str, "fr.husi")), i);
            arrayList = new ArrayList();
            for (Object obj4 : listQueryIntentContentProviders4) {
                if (((ResolveInfo) obj4).providerInfo.exported) {
                    arrayList.add(obj4);
                }
            }
        }
        boolean zIsEmpty = arrayList.isEmpty();
        int i2 = 1;
        List listSingletonList = arrayList;
        if (zIsEmpty) {
            List<ResolveInfo> listQueryIntentContentProviders5 = V2RAYApp.Companion.getApplication().getPackageManager().queryIntentContentProviders(new Intent(PluginContract.ACTION_NATIVE_PLUGIN), 128);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj5 : listQueryIntentContentProviders5) {
                ResolveInfo resolveInfo = (ResolveInfo) obj5;
                ProviderInfo providerInfo = resolveInfo.providerInfo;
                if (providerInfo.exported && providerInfo.metaData.containsKey(PluginContract.METADATA_KEY_ID) && e4.a(resolveInfo.providerInfo.metaData.getString(PluginContract.METADATA_KEY_ID), str)) {
                    arrayList2.add(obj5);
                }
            }
            int size = arrayList2.size();
            listSingletonList = arrayList2;
            if (size > 1) {
                listSingletonList = Collections.singletonList(arrayList2.get(0));
            }
        }
        List list = listSingletonList;
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() > 1) {
            String strConcat = "Conflicting plugins found from: ".concat(he.R0(list, null, null, null, new cz0(i2), 31));
            Toast.makeText(V2RAYApp.Companion.getApplication(), strConcat, 1).show();
            d.AnonymousClass0.m(strConcat);
            return null;
        }
        ProviderInfo providerInfo2 = ((ResolveInfo) he.a1(list)).providerInfo;
        try {
            String strInitNativeFaster = initNativeFaster(providerInfo2);
            if (strInitNativeFaster != null) {
                return new InitResult(strInitNativeFaster);
            }
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(providerInfo2.authority);
        Uri uriBuild = builder.build();
        try {
            String strInitNativeFast = initNativeFast(V2RAYApp.Companion.getApplication().getContentResolver(), str, uriBuild);
            if (strInitNativeFast != null) {
                return new InitResult(strInitNativeFast);
            }
            return null;
        } catch (Throwable th3) {
            if (th != null) {
                e.e(th3, th);
            }
            try {
                String strInitNativeSlow = initNativeSlow(V2RAYApp.Companion.getApplication().getContentResolver(), str, uriBuild);
                if (strInitNativeSlow != null) {
                    return new InitResult(strInitNativeSlow);
                }
                return null;
            } catch (Throwable th4) {
                e.e(th4, th3);
                throw th4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence initNative$lambda$8(ResolveInfo resolveInfo) {
        return resolveInfo.providerInfo.packageName;
    }

    private final String initNativeFast(ContentResolver contentResolver, String str, Uri uri) {
        String string;
        Bundle bundleCall = contentResolver.call(uri, PluginContract.METHOD_GET_EXECUTABLE, (String) null, new Bundle(0));
        if (bundleCall != null && (string = bundleCall.getString(PluginContract.EXTRA_ENTRY)) != null) {
            if (new File(string).canExecute()) {
                return string;
            }
            d.AnonymousClass0.m("Check failed.");
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004f A[PHI: r6
      0x004f: PHI (r6v2 int) = (r6v0 int), (r6v12 int) binds: [B:19:0x004d, B:13:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x005a  */
    private final String initNativeFaster(ProviderInfo providerInfo) {
        int length;
        File file;
        int iJ0;
        String strLoadString = loadString(providerInfo, PluginContract.METADATA_KEY_EXECUTABLE_PATH);
        if (strLoadString != null) {
            File file2 = new File(providerInfo.applicationInfo.nativeLibraryDir);
            File file3 = new File(strLoadString);
            String path = file3.getPath();
            char c = File.separatorChar;
            int iJ1 = q31.j0(path, c, 0, 4);
            if (iJ1 == 0) {
                if (path.length() <= 1 || path.charAt(1) != c || (iJ0 = q31.j0(path, c, 2, 4)) < 0) {
                    length = 1;
                } else {
                    iJ1 = q31.j0(path, c, iJ0 + 1, 4);
                    if (iJ1 >= 0) {
                        length = iJ1 + 1;
                    } else {
                        length = path.length();
                    }
                }
            } else if (iJ1 > 0 && path.charAt(iJ1 - 1) == ':') {
                length = iJ1 + 1;
            } else if (iJ1 == -1 && q31.f0(path, ':')) {
                length = path.length();
            } else {
                length = 0;
            }
            if (!(length > 0)) {
                String string = file2.toString();
                if ((string.length() == 0) || q31.f0(string, c)) {
                    file = new File(string + file3);
                } else {
                    StringBuilder sbD = e.d(string);
                    sbD.append(c);
                    sbD.append(file3);
                    file = new File(sbD.toString());
                }
                file3 = file;
            }
            if (file3.canExecute()) {
                return file3.getAbsolutePath();
            }
            d.AnonymousClass0.m("Check failed.");
        }
        return null;
    }

    private final String initNativeSlow(ContentResolver contentResolver, String str, Uri uri) throws IOException {
        int i;
        File file = new File(V2RAYApp.Companion.getApplication().getNoBackupFilesDir(), PluginContract.SCHEME);
        Cursor cursorQuery = contentResolver.query(uri, new String[]{PluginContract.COLUMN_PATH, PluginContract.COLUMN_MODE}, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (!cursorQuery.moveToFirst()) {
                initNativeSlow$entryNotFound();
                throw new we(1);
            }
            ft ftVar = ft.b;
            et.b bVar = new et.b(new et(file));
            loop0: while (true) {
                boolean z = true;
                while (true) {
                    if (!bVar.hasNext()) {
                        break loop0;
                    }
                    File file2 = (File) bVar.next();
                    if (file2.delete() || !file2.exists()) {
                        if (z) {
                            break;
                        }
                    }
                    z = false;
                }
            }
            if (!file.mkdirs()) {
                throw new FileNotFoundException("Unable to create plugin directory");
            }
            String str2 = file.getAbsolutePath() + '/';
            boolean z2 = false;
            do {
                String string = cursorQuery.getString(0);
                File file3 = new File(file, string);
                if (!file3.getAbsolutePath().startsWith(str2)) {
                    throw new IllegalStateException("Check failed.");
                }
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri.buildUpon().path(string).build());
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    try {
                        byte[] bArr = new byte[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
                        while (true) {
                            int i2 = inputStreamOpenInputStream.read(bArr);
                            if (i2 < 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i2);
                            try {
                                throw th;
                            } catch (Throwable th) {
                                e.F0(inputStreamOpenInputStream, th);
                                throw th;
                            }
                        }
                        fileOutputStream.close();
                        inputStreamOpenInputStream.close();
                        String absolutePath = file3.getAbsolutePath();
                        int type = cursorQuery.getType(1);
                        if (type == 1) {
                            i = cursorQuery.getInt(1);
                        } else {
                            if (type != 3) {
                                throw new IllegalArgumentException("File mode should be of type int");
                            }
                            String string2 = cursorQuery.getString(1);
                            e.c(8);
                            i = Integer.parseInt(string2, 8);
                        }
                        Os.chmod(absolutePath, i);
                        if (e4.a(string, str)) {
                            z2 = true;
                        }
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            e.F0(fileOutputStream, th2);
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    throw th4;
                }
            } while (cursorQuery.moveToNext());
            cursorQuery.close();
            if (z2) {
                return new File(file, str).getAbsolutePath();
            }
            initNativeSlow$entryNotFound();
            throw new we(1);
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                e.F0(cursorQuery, th5);
                throw th6;
            }
        }
    }

    private static final Void initNativeSlow$entryNotFound() {
        throw new IndexOutOfBoundsException("Plugin entry binary not found");
    }

    public final PluginList fetchPlugins() {
        PluginList pluginList;
        synchronized (this) {
            try {
                if (receiver == null) {
                    receiver = _ExtKt.listenForPackageChanges$default(V2RAYApp.Companion.getApplication(), false, new uh0(2, 3), 1, null);
                }
                if (cachedPlugins == null) {
                    cachedPlugins = new PluginList();
                }
                pluginList = cachedPlugins;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pluginList;
    }

    public final InitResult init(String str) throws Throwable {
        Throwable th = null;
        if (str.length() == 0) {
            return null;
        }
        try {
            InitResult initResultInitNative = initNative(str);
            if (initResultInitNative != null) {
                return initResultInitNative;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (th == null) {
            throw new PluginNotFoundException(str);
        }
        throw th;
    }

    public final String loadString(ComponentInfo componentInfo, String str) {
        Object obj = componentInfo.metaData.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Integer) {
            return V2RAYApp.Companion.getApplication().getPackageManager().getResourcesForApplication(componentInfo.applicationInfo).getString(((Number) obj).intValue());
        }
        if (obj == null) {
            return null;
        }
        StringBuilder sbQ = ak.q("meta-data ", str, " has invalid type ");
        sbQ.append(obj.getClass());
        throw new IllegalStateException(sbQ.toString().toString());
    }
}
