package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public interface CircularRevealWidget extends CircularRevealHelper.Delegate {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {
        public static final CircularRevealEvaluator CIRCULAR_REVEAL = new CircularRevealEvaluator();
        public final RevealInfo revealInfo = new RevealInfo();

        @Override // android.animation.TypeEvaluator
        public final RevealInfo evaluate(float f, RevealInfo revealInfo, RevealInfo revealInfo2) {
            RevealInfo revealInfo3 = revealInfo;
            RevealInfo revealInfo4 = revealInfo2;
            float f2 = revealInfo3.centerX;
            float f3 = 1.0f - f;
            float f4 = (revealInfo4.centerX * f) + (f2 * f3);
            float f5 = revealInfo3.centerY;
            float f6 = (revealInfo4.centerY * f) + (f5 * f3);
            float f7 = revealInfo3.radius;
            float f8 = (f * revealInfo4.radius) + (f3 * f7);
            RevealInfo revealInfo5 = this.revealInfo;
            revealInfo5.centerX = f4;
            revealInfo5.centerY = f6;
            revealInfo5.radius = f8;
            return revealInfo5;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {
        public static final CircularRevealProperty CIRCULAR_REVEAL = new CircularRevealProperty("circularReveal");

        private CircularRevealProperty(String str) {
            super(RevealInfo.class, str);
        }

        @Override // android.util.Property
        public final RevealInfo get(CircularRevealWidget circularRevealWidget) {
            return circularRevealWidget.getRevealInfo();
        }

        @Override // android.util.Property
        public final void set(CircularRevealWidget circularRevealWidget, RevealInfo revealInfo) {
            circularRevealWidget.setRevealInfo(revealInfo);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {
        public static final CircularRevealScrimColorProperty CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty("circularRevealScrimColor");

        private CircularRevealScrimColorProperty(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        public final Integer get(CircularRevealWidget circularRevealWidget) {
            return Integer.valueOf(circularRevealWidget.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public final void set(CircularRevealWidget circularRevealWidget, Integer num) {
            circularRevealWidget.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class RevealInfo {
        public float centerX;
        public float centerY;
        public float radius;

        private RevealInfo() {
        }

        public RevealInfo(float f, float f2, float f3) {
            this.centerX = f;
            this.centerY = f2;
            this.radius = f3;
        }

        public RevealInfo(RevealInfo revealInfo) {
            this(revealInfo.centerX, revealInfo.centerY, revealInfo.radius);
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    int getCircularRevealScrimColor();

    RevealInfo getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(RevealInfo revealInfo);
}
