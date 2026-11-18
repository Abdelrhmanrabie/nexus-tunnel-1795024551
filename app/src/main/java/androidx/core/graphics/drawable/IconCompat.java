package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.lang.reflect.InvocationTargetException;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    public static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;
    public final int a;
    public String b;
    public int e;
    public final PorterDuff.Mode h;
    public String j;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class c {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class d {
    }

    public IconCompat() {
        this.a = -1;
        this.e = 0;
        this.h = k;
    }

    public IconCompat(int i) {
        this.e = 0;
        this.h = k;
        this.a = i;
    }

    public static IconCompat b(int i) {
        if (i == 0) {
            defpackage.d.AnonymousClass0.m$2("Drawable resource ID must not be 0");
            return null;
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.e = i;
        iconCompat.b = AppConfig.CUSTOM;
        iconCompat.j = AppConfig.CUSTOM;
        return iconCompat;
    }

    public final int c() {
        int i = this.a;
        if (i != -1) {
            if (i == 2) {
                return this.e;
            }
            defpackage.d.AnonymousClass0.m$3("called getResId() on ", this);
            return 0;
        }
        Object obj = this.b;
        if (Build.VERSION.SDK_INT >= 28) {
            return ((Icon) obj).getResId();
        }
        try {
            return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return 0;
        }
    }

    public final Uri d() {
        int i = this.a;
        if (i == -1) {
            Object obj = this.b;
            if (Build.VERSION.SDK_INT >= 28) {
                return ((Icon) obj).getUri();
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
        if (i == 4 || i == 6) {
            return Uri.parse(this.b);
        }
        defpackage.d.AnonymousClass0.m$3("called getUri() on ", this);
        return null;
    }

    public final String toString() {
        String str;
        int height;
        int i = this.a;
        if (i == -1) {
            return String.valueOf(this.b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (i) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (i) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.b).getWidth());
                sb.append("x");
                height = ((Bitmap) this.b).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(c())));
                break;
            case 3:
                sb.append(" len=");
                height = this.e;
                sb.append(height);
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append((Object) this.b);
                break;
        }
        PorterDuff.Mode mode = k;
        PorterDuff.Mode mode2 = this.h;
        if (mode2 != mode) {
            sb.append(" mode=");
            sb.append(mode2);
        }
        sb.append(")");
        return sb.toString();
    }
}
