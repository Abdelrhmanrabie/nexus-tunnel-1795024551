package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class jv extends AnimationSet implements Runnable {
    public final ViewGroup b;
    public final View c;
    public boolean d;
    public boolean f;
    public boolean g;

    public jv(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.g = true;
        this.b = viewGroup;
        this.c = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation) {
        this.g = true;
        if (this.d) {
            return !this.f;
        }
        if (!super.getTransformation(j, transformation)) {
            this.d = true;
            fn0.a(this.b, this);
        }
        return true;
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation, float f) {
        this.g = true;
        if (this.d) {
            return !this.f;
        }
        if (!super.getTransformation(j, transformation, f)) {
            this.d = true;
            fn0.a(this.b, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.d;
        ViewGroup viewGroup = this.b;
        if (z || !this.g) {
            viewGroup.endViewTransition(this.c);
            this.f = true;
        } else {
            this.g = false;
            viewGroup.post(this);
        }
    }
}
