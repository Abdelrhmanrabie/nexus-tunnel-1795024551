package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import com.google.android.material.progressindicator.DeterminateDrawable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: androidx.dynamicanimation.animation.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class C0011a extends a<Object> {
        public final /* synthetic */ FloatProperty a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0011a(String str, FloatProperty floatProperty) {
            super(str);
            this.a = floatProperty;
        }

        @Override // androidx.dynamicanimation.animation.a
        public final float getValue(DeterminateDrawable determinateDrawable) {
            return ((Float) this.a.get(determinateDrawable)).floatValue();
        }

        @Override // androidx.dynamicanimation.animation.a
        public final void setValue(DeterminateDrawable determinateDrawable, float f) {
            this.a.setValue(determinateDrawable, f);
        }
    }

    public a(String str) {
    }

    public abstract float getValue(DeterminateDrawable determinateDrawable);

    public abstract void setValue(DeterminateDrawable determinateDrawable, float f);
}
