package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import defpackage.b2;
import defpackage.e;
import defpackage.go;
import defpackage.jg0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final a a = new a();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements InterfaceC0023c {
        @Override // androidx.profileinstaller.c.InterfaceC0023c
        public final void b(int i, Serializable serializable) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements InterfaceC0023c {
        @Override // androidx.profileinstaller.c.InterfaceC0023c
        public final void b(int i, Serializable serializable) {
            if (i == 6 || i == 7 || i == 8) {
            }
        }
    }

    /* JADX INFO: renamed from: androidx.profileinstaller.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface InterfaceC0023c {
        void b(int i, Serializable serializable);
    }

    static {
        new b();
    }

    public static void a(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0154  */
    /* JADX WARN: Code duplicated, block: B:114:0x016d A[Catch: all -> 0x0182, TRY_LEAVE, TryCatch #19 {all -> 0x0182, blocks: (B:112:0x0161, B:114:0x016d, B:125:0x0185, B:126:0x018a), top: B:305:0x0161 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0185 A[Catch: all -> 0x0182, TRY_ENTER, TryCatch #19 {all -> 0x0182, blocks: (B:112:0x0161, B:114:0x016d, B:125:0x0185, B:126:0x018a), top: B:305:0x0161 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x0194 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:133:0x0196 A[Catch: IllegalStateException -> 0x017c, IOException -> 0x017e, FileNotFoundException -> 0x0180, TRY_LEAVE, TryCatch #37 {FileNotFoundException -> 0x0180, IOException -> 0x017e, IllegalStateException -> 0x017c, blocks: (B:110:0x0159, B:115:0x0177, B:133:0x0196, B:131:0x0193, B:130:0x0190), top: B:327:0x0159 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:152:0x01ca A[Catch: all -> 0x01d8, TRY_LEAVE, TryCatch #34 {all -> 0x01d8, blocks: (B:150:0x01be, B:152:0x01ca, B:161:0x01db), top: B:321:0x01be }] */
    /* JADX WARN: Code duplicated, block: B:161:0x01db A[Catch: all -> 0x01d8, TRY_ENTER, TRY_LEAVE, TryCatch #34 {all -> 0x01d8, blocks: (B:150:0x01be, B:152:0x01ca, B:161:0x01db), top: B:321:0x01be }] */
    /* JADX WARN: Code duplicated, block: B:173:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:177:0x0200  */
    /* JADX WARN: Code duplicated, block: B:178:0x0203  */
    /* JADX WARN: Code duplicated, block: B:187:0x0223  */
    /* JADX WARN: Code duplicated, block: B:190:0x0228  */
    /* JADX WARN: Code duplicated, block: B:192:0x022b A[Catch: all -> 0x0225, TryCatch #3 {all -> 0x0225, blocks: (B:185:0x021d, B:192:0x022b, B:193:0x022f, B:195:0x0235), top: B:286:0x021d }] */
    /* JADX WARN: Code duplicated, block: B:195:0x0235 A[Catch: all -> 0x0225, LOOP:0: B:193:0x022f->B:195:0x0235, LOOP_END, TRY_LEAVE, TryCatch #3 {all -> 0x0225, blocks: (B:185:0x021d, B:192:0x022b, B:193:0x022f, B:195:0x0235), top: B:286:0x021d }] */
    /* JADX WARN: Code duplicated, block: B:200:0x0240 A[Catch: all -> 0x0244, TRY_ENTER, TRY_LEAVE, TryCatch #22 {all -> 0x0244, blocks: (B:200:0x0240, B:228:0x0277, B:227:0x0274, B:224:0x026f), top: B:308:0x021b, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:220:0x0264  */
    /* JADX WARN: Code duplicated, block: B:264:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:268:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:273:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:275:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:286:0x021d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:297:0x026f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:305:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:324:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:326:0x0207 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:327:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:328:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:329:0x01b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:331:0x023a A[EDGE_INSN: B:331:0x023a->B:197:0x023a BREAK  A[LOOP:0: B:193:0x022f->B:195:0x0235], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:336:? A[Catch: all -> 0x0244, SYNTHETIC, TRY_LEAVE, TryCatch #22 {all -> 0x0244, blocks: (B:200:0x0240, B:228:0x0277, B:227:0x0274, B:224:0x026f), top: B:308:0x021b, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f9 A[Catch: all -> 0x010f, IllegalStateException -> 0x0111, IOException -> 0x0113, TRY_LEAVE, TryCatch #36 {IOException -> 0x0113, IllegalStateException -> 0x0111, blocks: (B:62:0x00ef, B:64:0x00f9, B:76:0x0116, B:77:0x011b), top: B:328:0x00ef, outer: #29 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0116 A[Catch: all -> 0x010f, IllegalStateException -> 0x0111, IOException -> 0x0113, TRY_ENTER, TryCatch #36 {IOException -> 0x0113, IllegalStateException -> 0x0111, blocks: (B:62:0x00ef, B:64:0x00f9, B:76:0x0116, B:77:0x011b), top: B:328:0x00ef, outer: #29 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0142  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v4 */
    public static void b(Context context, jg0 jg0Var, InterfaceC0023c interfaceC0023c, boolean z) {
        boolean z2;
        AssetManager assetManager;
        byte[] bArr;
        int i;
        FileInputStream fileInputStreamA;
        int i2;
        go[] goVarArr;
        go[] goVarArr2;
        int i3;
        boolean z3;
        int i4;
        androidx.profileinstaller.b bVar;
        FileInputStream fileInputStreamA2;
        InterfaceC0023c interfaceC0023c2;
        go[] goVarArr3;
        byte[] bArr2;
        int i5;
        ?? r7;
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        Throwable th2;
        FileChannel channel;
        FileLock fileLockTryLock;
        boolean z4;
        Throwable th3;
        Throwable th4;
        byte[] bArr3;
        int i6;
        ?? r8;
        boolean z5;
        ?? r9;
        byte[] bArr4;
        int i7;
        ByteArrayOutputStream byteArrayOutputStream;
        ?? r10;
        boolean z6;
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z) {
                File file = new File(filesDir, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
                if (file.exists()) {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                        try {
                            long j = dataInputStream.readLong();
                            dataInputStream.close();
                            z6 = j == packageInfo.lastUpdateTime;
                            if (z6) {
                                interfaceC0023c.b(2, null);
                            }
                        } catch (Throwable th5) {
                            try {
                                dataInputStream.close();
                                throw th5;
                            } catch (Throwable th6) {
                                th5.addSuppressed(th6);
                                throw th5;
                            }
                        }
                    } catch (IOException unused) {
                        z6 = false;
                    }
                } else {
                    z6 = false;
                }
                if (z6) {
                    context.getPackageName();
                    d.b(context, false);
                    return;
                }
            }
            context.getPackageName();
            File file2 = new File(new File("/data/misc/profiles/cur/0", packageName), "primary.prof");
            androidx.profileinstaller.b bVar2 = new androidx.profileinstaller.b(assets, jg0Var, interfaceC0023c, name, file2);
            byte[] bArr5 = bVar2.d;
            if (bArr5 != null) {
                if (!file2.exists()) {
                    try {
                        if (file2.createNewFile()) {
                            bVar2.g = true;
                            z2 = true;
                        } else {
                            bVar2.b(4, null);
                        }
                    } catch (IOException unused2) {
                        bVar2.b(4, null);
                    }
                } else if (file2.canWrite()) {
                    bVar2.g = true;
                    z2 = true;
                } else {
                    bVar2.b(4, null);
                }
                if (z2) {
                    assetManager = bVar2.a;
                    InterfaceC0023c interfaceC0023c3 = bVar2.c;
                    ?? r11 = "This device doesn't support aot. Did you call deviceSupportsAotProfile()?";
                    if (bVar2.g) {
                        defpackage.d.AnonymousClass0.m("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                        return;
                    }
                    bArr = b2.f16a;
                    if (bArr5 != null) {
                        try {
                            fileInputStreamA = bVar2.a(assetManager, "dexopt/baseline.prof");
                        } catch (FileNotFoundException e) {
                            e = e;
                            i = 6;
                            interfaceC0023c3.b(i, e);
                            fileInputStreamA = null;
                        } catch (IOException e2) {
                            e = e2;
                            i = 7;
                            interfaceC0023c3.b(i, e);
                            fileInputStreamA = null;
                        }
                        try {
                            if (fileInputStreamA != null) {
                                try {
                                    if (Arrays.equals(bArr, e.n(fileInputStreamA, 4))) {
                                        throw new IllegalStateException("Invalid magic");
                                    }
                                    go[] goVarArrH = b2.h(fileInputStreamA, e.n(fileInputStreamA, 4), bVar2.f);
                                    try {
                                        fileInputStreamA.close();
                                    } catch (IOException e3) {
                                        interfaceC0023c3.b(7, e3);
                                    }
                                    goVarArr = goVarArrH;
                                    bVar2.h = goVarArr;
                                } catch (IOException e4) {
                                    i2 = 7;
                                    try {
                                        interfaceC0023c3.b(7, e4);
                                        try {
                                            fileInputStreamA.close();
                                        } catch (IOException e5) {
                                            interfaceC0023c3.b(i2, e5);
                                        }
                                        goVarArr = null;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        Throwable th8 = th;
                                        try {
                                            fileInputStreamA.close();
                                            throw th8;
                                        } catch (IOException e6) {
                                            interfaceC0023c3.b(i2, e6);
                                            throw th8;
                                        }
                                    }
                                } catch (IllegalStateException e7) {
                                    interfaceC0023c3.b(8, e7);
                                    i2 = 7;
                                    fileInputStreamA.close();
                                    goVarArr = null;
                                }
                            }
                            goVarArr2 = bVar2.h;
                            if (goVarArr2 != null) {
                                i3 = Build.VERSION.SDK_INT;
                                if (i3 < 24 && (i3 >= 31 || i3 == 24 || i3 == 25)) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    try {
                                        fileInputStreamA2 = bVar2.a(assetManager, "dexopt/baseline.profm");
                                        if (fileInputStreamA2 == null) {
                                            try {
                                                if (Arrays.equals(b2.f20b, e.n(fileInputStreamA2, 4))) {
                                                    throw new IllegalStateException("Invalid magic");
                                                }
                                                bVar2.h = b2.e(fileInputStreamA2, e.n(fileInputStreamA2, 4), bArr5, goVarArr2);
                                                fileInputStreamA2.close();
                                                bVar = bVar2;
                                            } catch (Throwable th9) {
                                                try {
                                                    fileInputStreamA2.close();
                                                    throw th9;
                                                } catch (Throwable th10) {
                                                    th9.addSuppressed(th10);
                                                    throw th9;
                                                }
                                            }
                                        } else {
                                            if (fileInputStreamA2 != null) {
                                                fileInputStreamA2.close();
                                            }
                                            bVar = null;
                                        }
                                    } catch (FileNotFoundException e8) {
                                        e = e8;
                                        i4 = 9;
                                        interfaceC0023c3.b(i4, e);
                                    } catch (IOException e9) {
                                        e = e9;
                                        i4 = 7;
                                        interfaceC0023c3.b(i4, e);
                                    } catch (IllegalStateException e10) {
                                        e = e10;
                                        bVar2.h = null;
                                        i4 = 8;
                                        interfaceC0023c3.b(i4, e);
                                    }
                                    if (bVar != null) {
                                        bVar2 = bVar;
                                    }
                                }
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            i2 = 7;
                        }
                    }
                    interfaceC0023c2 = bVar2.c;
                    goVarArr3 = bVar2.h;
                    if (goVarArr3 != null && (bArr4 = bVar2.d) != null) {
                        if (bVar2.g) {
                            defpackage.d.AnonymousClass0.m("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                            return;
                        }
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                byteArrayOutputStream.write(bArr);
                                byteArrayOutputStream.write(bArr4);
                                if (b2.j(byteArrayOutputStream, bArr4, goVarArr3)) {
                                    bVar2.i = byteArrayOutputStream.toByteArray();
                                    byteArrayOutputStream.close();
                                    bVar2.h = null;
                                } else {
                                    interfaceC0023c2.b(5, null);
                                    bVar2.h = null;
                                    byteArrayOutputStream.close();
                                }
                            } catch (Throwable th12) {
                                try {
                                    byteArrayOutputStream.close();
                                    throw th12;
                                } catch (Throwable th13) {
                                    th12.addSuppressed(th13);
                                    throw th12;
                                }
                            }
                        } catch (IOException e11) {
                            e = e11;
                            i7 = 7;
                            interfaceC0023c2.b(i7, e);
                        } catch (IllegalStateException e12) {
                            e = e12;
                            i7 = 8;
                            interfaceC0023c2.b(i7, e);
                        }
                    }
                    bArr2 = bVar2.i;
                    if (bArr2 == null) {
                        r9 = 1;
                    } else {
                        try {
                            if (bVar2.g) {
                                defpackage.d.AnonymousClass0.m("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                return;
                            }
                            try {
                                try {
                                    byteArrayInputStream = new ByteArrayInputStream(bArr2);
                                    try {
                                        try {
                                            fileOutputStream = new FileOutputStream(bVar2.e);
                                            try {
                                                try {
                                                    channel = fileOutputStream.getChannel();
                                                    try {
                                                        fileLockTryLock = channel.tryLock();
                                                        try {
                                                            if (fileLockTryLock != null) {
                                                                try {
                                                                    if (fileLockTryLock.isValid()) {
                                                                        z4 = true;
                                                                    } else {
                                                                        z4 = false;
                                                                    }
                                                                    try {
                                                                        if (z4) {
                                                                            throw new IOException("Unable to acquire a lock on the underlying file channel.");
                                                                        }
                                                                        bArr3 = new byte[512];
                                                                        while (true) {
                                                                            i6 = byteArrayInputStream.read(bArr3);
                                                                            if (i6 > 0) {
                                                                                break;
                                                                            } else {
                                                                                fileOutputStream.write(bArr3, 0, i6);
                                                                            }
                                                                        }
                                                                        r8 = 1;
                                                                        bVar2.b(1, null);
                                                                        if (fileLockTryLock != null) {
                                                                            fileLockTryLock.close();
                                                                        }
                                                                        channel.close();
                                                                        fileOutputStream.close();
                                                                        byteArrayInputStream.close();
                                                                        bVar2.i = null;
                                                                        bVar2.h = null;
                                                                        z5 = true;
                                                                        if (z5) {
                                                                            a(packageInfo, filesDir);
                                                                        }
                                                                    } catch (Throwable th14) {
                                                                        th3 = th14;
                                                                        th4 = th3;
                                                                        if (fileLockTryLock != null) {
                                                                            throw th4;
                                                                        }
                                                                        try {
                                                                            fileLockTryLock.close();
                                                                            throw th4;
                                                                        } catch (Throwable th15) {
                                                                            th4.addSuppressed(th15);
                                                                            throw th4;
                                                                        }
                                                                    }
                                                                } catch (Throwable th16) {
                                                                    th3 = th16;
                                                                    th4 = th3;
                                                                    if (fileLockTryLock != null) {
                                                                        throw th4;
                                                                    }
                                                                    fileLockTryLock.close();
                                                                    throw th4;
                                                                }
                                                            } else {
                                                                z4 = false;
                                                                if (z4) {
                                                                    throw new IOException("Unable to acquire a lock on the underlying file channel.");
                                                                }
                                                                bArr3 = new byte[512];
                                                                while (true) {
                                                                    i6 = byteArrayInputStream.read(bArr3);
                                                                    if (i6 > 0) {
                                                                        break;
                                                                        break;
                                                                    }
                                                                    fileOutputStream.write(bArr3, 0, i6);
                                                                }
                                                                r8 = 1;
                                                                bVar2.b(1, null);
                                                                if (fileLockTryLock != null) {
                                                                    fileLockTryLock.close();
                                                                }
                                                                channel.close();
                                                                fileOutputStream.close();
                                                                byteArrayInputStream.close();
                                                                bVar2.i = null;
                                                                bVar2.h = null;
                                                                z5 = true;
                                                                if (z5) {
                                                                    a(packageInfo, filesDir);
                                                                }
                                                            }
                                                        } catch (Throwable th17) {
                                                            th = th17;
                                                            Throwable th18 = th;
                                                            if (channel == null) {
                                                                throw th18;
                                                            }
                                                            try {
                                                                channel.close();
                                                                throw th18;
                                                            } catch (Throwable th19) {
                                                                th18.addSuppressed(th19);
                                                                throw th18;
                                                            }
                                                        }
                                                    } catch (Throwable th20) {
                                                        th = th20;
                                                    }
                                                } catch (Throwable th21) {
                                                    th = th21;
                                                    th2 = th;
                                                    try {
                                                        fileOutputStream.close();
                                                        throw th2;
                                                    } catch (Throwable th22) {
                                                        th2.addSuppressed(th22);
                                                        throw th2;
                                                    }
                                                }
                                            } catch (Throwable th23) {
                                                th = th23;
                                                th2 = th;
                                                fileOutputStream.close();
                                                throw th2;
                                            }
                                        } catch (Throwable th24) {
                                            th = th24;
                                            th = th;
                                            try {
                                                byteArrayInputStream.close();
                                                throw th;
                                            } catch (Throwable th25) {
                                                th.addSuppressed(th25);
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th26) {
                                        th = th26;
                                        th = th;
                                        byteArrayInputStream.close();
                                        throw th;
                                    }
                                } catch (FileNotFoundException e13) {
                                    e = e13;
                                    i5 = 6;
                                    r7 = r11;
                                    bVar2.b(i5, e);
                                    bVar2.i = null;
                                    bVar2.h = null;
                                    r9 = r7;
                                    z5 = false;
                                    r8 = r9;
                                } catch (IOException e14) {
                                    e = e14;
                                    i5 = 7;
                                    r7 = r11;
                                    bVar2.b(i5, e);
                                    bVar2.i = null;
                                    bVar2.h = null;
                                    r9 = r7;
                                    z5 = false;
                                    r8 = r9;
                                }
                            } catch (FileNotFoundException e15) {
                                e = e15;
                                r11 = 1;
                                i5 = 6;
                                r7 = r11;
                                bVar2.b(i5, e);
                                bVar2.i = null;
                                bVar2.h = null;
                                r9 = r7;
                                z5 = false;
                                r8 = r9;
                            } catch (IOException e16) {
                                e = e16;
                                r11 = 1;
                                i5 = 7;
                                r7 = r11;
                                bVar2.b(i5, e);
                                bVar2.i = null;
                                bVar2.h = null;
                                r9 = r7;
                                z5 = false;
                                r8 = r9;
                            }
                        } catch (Throwable th27) {
                            bVar2.i = null;
                            bVar2.h = null;
                            throw th27;
                        }
                    }
                    z5 = false;
                    r8 = r9;
                    if (z5) {
                        a(packageInfo, filesDir);
                    }
                } else {
                    r8 = 1;
                    z5 = false;
                }
                if (z5 || !z) {
                    r10 = 0;
                } else {
                    r10 = r8;
                }
                d.b(context, r10);
            }
            bVar2.b(3, Integer.valueOf(Build.VERSION.SDK_INT));
            z2 = false;
            if (z2) {
                r8 = 1;
                z5 = false;
            } else {
                assetManager = bVar2.a;
                InterfaceC0023c interfaceC0023c4 = bVar2.c;
                ?? r12 = "This device doesn't support aot. Did you call deviceSupportsAotProfile()?";
                if (bVar2.g) {
                    defpackage.d.AnonymousClass0.m("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                    return;
                }
                bArr = b2.f16a;
                if (bArr5 != null) {
                    fileInputStreamA = bVar2.a(assetManager, "dexopt/baseline.prof");
                    if (fileInputStreamA != null) {
                        if (Arrays.equals(bArr, e.n(fileInputStreamA, 4))) {
                            throw new IllegalStateException("Invalid magic");
                        }
                        go[] goVarArrH2 = b2.h(fileInputStreamA, e.n(fileInputStreamA, 4), bVar2.f);
                        fileInputStreamA.close();
                        goVarArr = goVarArrH2;
                        bVar2.h = goVarArr;
                    }
                    goVarArr2 = bVar2.h;
                    if (goVarArr2 != null) {
                        i3 = Build.VERSION.SDK_INT;
                        if (i3 < 24) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (z3) {
                            fileInputStreamA2 = bVar2.a(assetManager, "dexopt/baseline.profm");
                            if (fileInputStreamA2 == null) {
                                if (fileInputStreamA2 != null) {
                                    fileInputStreamA2.close();
                                }
                                bVar = null;
                            } else {
                                if (Arrays.equals(b2.f20b, e.n(fileInputStreamA2, 4))) {
                                    throw new IllegalStateException("Invalid magic");
                                }
                                bVar2.h = b2.e(fileInputStreamA2, e.n(fileInputStreamA2, 4), bArr5, goVarArr2);
                                fileInputStreamA2.close();
                                bVar = bVar2;
                            }
                            if (bVar != null) {
                                bVar2 = bVar;
                            }
                        }
                    }
                }
                interfaceC0023c2 = bVar2.c;
                goVarArr3 = bVar2.h;
                if (goVarArr3 != null) {
                    if (bVar2.g) {
                        defpackage.d.AnonymousClass0.m("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                        return;
                    }
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    byteArrayOutputStream.write(bArr);
                    byteArrayOutputStream.write(bArr4);
                    if (b2.j(byteArrayOutputStream, bArr4, goVarArr3)) {
                        interfaceC0023c2.b(5, null);
                        bVar2.h = null;
                        byteArrayOutputStream.close();
                    } else {
                        bVar2.i = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        bVar2.h = null;
                    }
                }
                bArr2 = bVar2.i;
                if (bArr2 == null) {
                    r9 = 1;
                } else {
                    if (bVar2.g) {
                        defpackage.d.AnonymousClass0.m("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                        return;
                    }
                    byteArrayInputStream = new ByteArrayInputStream(bArr2);
                    fileOutputStream = new FileOutputStream(bVar2.e);
                    channel = fileOutputStream.getChannel();
                    fileLockTryLock = channel.tryLock();
                    if (fileLockTryLock != null) {
                        if (fileLockTryLock.isValid()) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            throw new IOException("Unable to acquire a lock on the underlying file channel.");
                        }
                        bArr3 = new byte[512];
                        while (true) {
                            i6 = byteArrayInputStream.read(bArr3);
                            if (i6 > 0) {
                                break;
                                break;
                            }
                            fileOutputStream.write(bArr3, 0, i6);
                        }
                        r8 = 1;
                        bVar2.b(1, null);
                        if (fileLockTryLock != null) {
                            fileLockTryLock.close();
                        }
                        channel.close();
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        bVar2.i = null;
                        bVar2.h = null;
                        z5 = true;
                        if (z5) {
                            a(packageInfo, filesDir);
                        }
                    } else {
                        z4 = false;
                        if (z4) {
                            throw new IOException("Unable to acquire a lock on the underlying file channel.");
                        }
                        bArr3 = new byte[512];
                        while (true) {
                            i6 = byteArrayInputStream.read(bArr3);
                            if (i6 > 0) {
                                break;
                                break;
                            }
                            fileOutputStream.write(bArr3, 0, i6);
                        }
                        r8 = 1;
                        bVar2.b(1, null);
                        if (fileLockTryLock != null) {
                            fileLockTryLock.close();
                        }
                        channel.close();
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        bVar2.i = null;
                        bVar2.h = null;
                        z5 = true;
                        if (z5) {
                            a(packageInfo, filesDir);
                        }
                    }
                }
                z5 = false;
                r8 = r9;
                if (z5) {
                    a(packageInfo, filesDir);
                }
            }
            if (z5) {
                r10 = 0;
            } else {
                r10 = 0;
            }
            d.b(context, r10);
        } catch (PackageManager.NameNotFoundException e17) {
            interfaceC0023c.b(7, e17);
            d.b(context, false);
        }
    }
}
