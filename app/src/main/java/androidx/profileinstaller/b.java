package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import defpackage.e4;
import defpackage.go;
import defpackage.jg0;
import defpackage.lf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final AssetManager a;
    public final jg0 b;
    public final c.InterfaceC0023c c;
    public final byte[] d;
    public final File e;
    public final String f;
    public boolean g = false;
    public go[] h;
    public byte[] i;

    /* JADX WARN: Code duplicated, block: B:9:0x0021  */
    public b(AssetManager assetManager, jg0 jg0Var, c.InterfaceC0023c interfaceC0023c, String str, File file) {
        byte[] bArr;
        this.a = assetManager;
        this.b = jg0Var;
        this.c = interfaceC0023c;
        this.f = str;
        this.e = file;
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            bArr = null;
        } else if (i < 31) {
            switch (i) {
                case 24:
                case 25:
                    bArr = e4.e;
                    break;
                case 26:
                    bArr = e4.d;
                    break;
                case 27:
                    bArr = e4.c;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = e4.f50b;
                    break;
                default:
                    bArr = null;
                    break;
            }
        } else {
            bArr = e4.f49a;
        }
        this.d = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.c.getClass();
            return null;
        }
    }

    public final void b(int i, Serializable serializable) {
        this.b.execute(new lf(this, i, 1, serializable));
    }
}
