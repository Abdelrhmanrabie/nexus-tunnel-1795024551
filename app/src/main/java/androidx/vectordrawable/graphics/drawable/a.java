package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: androidx.vectordrawable.graphics.drawable.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class C0030a extends Animatable2.AnimationCallback {
        public C0030a() {
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public final void onAnimationEnd(Drawable drawable) {
            a.this.onAnimationEnd();
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public final void onAnimationStart(Drawable drawable) {
            a.this.getClass();
        }
    }

    public void onAnimationEnd() {
    }
}
