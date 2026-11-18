package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.Build;
import defpackage.ov0;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final ov0 a = new ov0();
    public static final Object b = new Object();
    public static c c = null;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b {
        public final int a;
        public final int b;
        public final long c;
        public final long d;

        public b(int i, int i2, long j, long j2) {
            this.a = i;
            this.b = i2;
            this.c = j;
            this.d = j2;
        }

        public static b a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }

        public final void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.a);
                dataOutputStream.writeInt(this.b);
                dataOutputStream.writeLong(this.c);
                dataOutputStream.writeLong(this.d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.c == bVar.c && this.a == bVar.a && this.d == bVar.d;
        }

        public final int hashCode() {
            return Objects.hash(Integer.valueOf(this.b), Long.valueOf(this.c), Integer.valueOf(this.a), Long.valueOf(this.d));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class c {
    }

    public static void a() {
        c cVar = new c();
        c = cVar;
        ov0 ov0Var = a;
        ov0Var.getClass();
        if (androidx.concurrent.futures.a.ATOMIC_HELPER.b(ov0Var, null, cVar)) {
            androidx.concurrent.futures.a.complete(ov0Var);
        }
    }

    public static void b(Context context, boolean z) {
        boolean z2;
        int i;
        if (z || c == null) {
            synchronized (b) {
                if (!z) {
                    if (c != null) {
                        return;
                    }
                }
                int i2 = 0;
                try {
                    AssetFileDescriptor assetFileDescriptorOpenFd = context.getAssets().openFd("dexopt/baseline.prof");
                    try {
                        z2 = assetFileDescriptorOpenFd.getLength() > 0;
                        assetFileDescriptorOpenFd.close();
                    } catch (Throwable th) {
                        if (assetFileDescriptorOpenFd == null) {
                            throw th;
                        }
                        try {
                            assetFileDescriptorOpenFd.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                } catch (IOException unused) {
                    z2 = false;
                }
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 28 && i3 != 30) {
                    File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                    long length = file.length();
                    boolean z3 = file.exists() && length > 0;
                    File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                    long length2 = file2.length();
                    boolean z4 = file2.exists() && length2 > 0;
                    try {
                        PackageManager packageManager = context.getApplicationContext().getPackageManager();
                        long j = (i3 >= 33 ? packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L)) : packageManager.getPackageInfo(context.getPackageName(), 0)).lastUpdateTime;
                        File file3 = new File(context.getFilesDir(), "profileInstalled");
                        b bVarA = file3.exists() ? b.a(file3) : null;
                        if (bVarA != null && bVarA.c == j && (i = bVarA.b) != 2) {
                            i2 = i;
                        } else if (!z2) {
                            i2 = 327680;
                        } else if (z3) {
                            i2 = 1;
                        } else if (z4) {
                            i2 = 2;
                        }
                        if (z && z4 && i2 != 1) {
                            i2 = 2;
                        }
                        if (bVarA != null && bVarA.b == 2 && i2 == 1 && length < bVarA.d) {
                            i2 = 3;
                        }
                        b bVar = new b(1, i2, j, length2);
                        if (bVarA == null || !bVarA.equals(bVar)) {
                            bVar.b(file3);
                        }
                    } catch (PackageManager.NameNotFoundException | IOException unused2) {
                    }
                }
                a();
            }
        }
    }
}
