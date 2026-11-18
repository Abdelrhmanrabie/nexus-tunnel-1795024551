package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class o5 {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public static o5 c;
    public rv0 a;

    public static synchronized o5 a() {
        try {
            if (c == null) {
                d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return c;
    }

    public static synchronized void d() {
        if (c == null) {
            o5 o5Var = new o5();
            c = o5Var;
            o5Var.a = rv0.d();
            c.a.l(new hg(1));
        }
    }

    public static void e(Drawable drawable, a71 a71Var, int[] iArr) {
        PorterDuff.Mode mode = rv0.h;
        if (!fp.a(drawable) || drawable.mutate() == drawable) {
            boolean z = a71Var.d;
            if (z || a71Var.c) {
                PorterDuffColorFilter porterDuffColorFilterH = null;
                ColorStateList colorStateList = z ? a71Var.a : null;
                PorterDuff.Mode mode2 = a71Var.c ? a71Var.b : rv0.h;
                if (colorStateList != null && mode2 != null) {
                    porterDuffColorFilterH = rv0.h(colorStateList.getColorForState(iArr, 0), mode2);
                }
                drawable.setColorFilter(porterDuffColorFilterH);
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public final synchronized Drawable b(Context context, int i) {
        return this.a.f(context, i);
    }
}
