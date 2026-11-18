package defpackage;

import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class pl0 {
    public final Bundle a;
    public IconCompat b;
    public final boolean d;
    public final boolean e;
    public final int h;
    public final CharSequence i;
    public final PendingIntent j;

    public pl0(IconCompat iconCompat, String str, PendingIntent pendingIntent, Bundle bundle) {
        this.e = true;
        this.b = iconCompat;
        if (iconCompat != null) {
            int iIntValue = iconCompat.a;
            if (iIntValue == -1) {
                Object obj = iconCompat.b;
                if (Build.VERSION.SDK_INT >= 28) {
                    iIntValue = ((Icon) obj).getType();
                } else {
                    try {
                        iIntValue = ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                        iIntValue = -1;
                    }
                }
            }
            if (iIntValue == 2) {
                this.h = iconCompat.c();
            }
        }
        this.i = sl0.c(str);
        this.j = pendingIntent;
        this.a = bundle;
        this.d = true;
        this.e = true;
    }
}
