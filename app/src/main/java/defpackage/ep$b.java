package defpackage;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ep$b implements Drawable.Callback {
    public final /* synthetic */ int G0 = 0;
    public Object b;

    public /* synthetic */ ep$b() {
    }

    public ep$b(t3 t3Var) {
        this.b = t3Var;
    }

    private final void invalidateDrawable$ep$b(Drawable drawable) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        if (this.G0 != 0) {
            ((t3) this.b).invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        int i = this.G0;
        Object obj = this.b;
        if (i != 0) {
            ((t3) obj).scheduleSelf(runnable, j);
            return;
        }
        Drawable.Callback callback = (Drawable.Callback) obj;
        if (callback != null) {
            callback.scheduleDrawable(drawable, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        int i = this.G0;
        Object obj = this.b;
        if (i != 0) {
            ((t3) obj).unscheduleSelf(runnable);
            return;
        }
        Drawable.Callback callback = (Drawable.Callback) obj;
        if (callback != null) {
            callback.unscheduleDrawable(drawable, runnable);
        }
    }
}
