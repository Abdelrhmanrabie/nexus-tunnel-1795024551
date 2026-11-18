package defpackage;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.dynamicanimation.animation.a;
import com.google.android.material.progressindicator.DeterminateDrawable;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class h21 {
    public static final np$a l;
    public static final np$a m;
    public static final np$a n;
    public static final np$a o;
    public static final np$a p;
    public static final np$a q;
    public final DeterminateDrawable d;
    public final a e;
    public final float i;
    public i21 r;
    public float s;
    public boolean t;
    public float a = 0.0f;
    public float b = Float.MAX_VALUE;
    public boolean c = false;
    public boolean f = false;
    public long h = 0;
    public final ArrayList j = new ArrayList();
    public final ArrayList k = new ArrayList();

    /* JADX WARN: Type inference failed for: r0v11, types: [np$a] */
    /* JADX WARN: Type inference failed for: r0v3, types: [np$a] */
    /* JADX WARN: Type inference failed for: r0v4, types: [np$a] */
    /* JADX WARN: Type inference failed for: r0v5, types: [np$a] */
    /* JADX WARN: Type inference failed for: r0v6, types: [np$a] */
    /* JADX WARN: Type inference failed for: r0v7, types: [np$a] */
    static {
        final String str = "translationX";
        final int i = 5;
        new a(str) { // from class: np$a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final float getValue(DeterminateDrawable determinateDrawable) {
                View view = (View) determinateDrawable;
                switch (i) {
                    case 0:
                        return view.getY();
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        return view.getZ();
                    case 2:
                        return view.getAlpha();
                    case 3:
                        return view.getScrollX();
                    case 4:
                        return view.getScrollY();
                    case 5:
                        return view.getTranslationX();
                    case 6:
                        return view.getTranslationY();
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        return view.getTranslationZ();
                    case 8:
                        return view.getScaleX();
                    case 9:
                        return view.getScaleY();
                    case 10:
                        return view.getRotation();
                    case 11:
                        return view.getRotationX();
                    case 12:
                        return view.getRotationY();
                    default:
                        return view.getX();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final void setValue(DeterminateDrawable determinateDrawable, float f) {
                View view = (View) determinateDrawable;
                switch (i) {
                    case 0:
                        view.setY(f);
                        break;
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        view.setZ(f);
                        break;
                    case 2:
                        view.setAlpha(f);
                        break;
                    case 3:
                        view.setScrollX((int) f);
                        break;
                    case 4:
                        view.setScrollY((int) f);
                        break;
                    case 5:
                        view.setTranslationX(f);
                        break;
                    case 6:
                        view.setTranslationY(f);
                        break;
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        view.setTranslationZ(f);
                        break;
                    case 8:
                        view.setScaleX(f);
                        break;
                    case 9:
                        view.setScaleY(f);
                        break;
                    case 10:
                        view.setRotation(f);
                        break;
                    case 11:
                        view.setRotationX(f);
                        break;
                    case 12:
                        view.setRotationY(f);
                        break;
                    default:
                        view.setX(f);
                        break;
                }
            }
        };
        final String str2 = "translationY";
        final int i2 = 6;
        new a(str2) { // from class: np$a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final float getValue(DeterminateDrawable determinateDrawable) {
                View view = (View) determinateDrawable;
                switch (i2) {
                    case 0:
                        return view.getY();
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        return view.getZ();
                    case 2:
                        return view.getAlpha();
                    case 3:
                        return view.getScrollX();
                    case 4:
                        return view.getScrollY();
                    case 5:
                        return view.getTranslationX();
                    case 6:
                        return view.getTranslationY();
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        return view.getTranslationZ();
                    case 8:
                        return view.getScaleX();
                    case 9:
                        return view.getScaleY();
                    case 10:
                        return view.getRotation();
                    case 11:
                        return view.getRotationX();
                    case 12:
                        return view.getRotationY();
                    default:
                        return view.getX();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final void setValue(DeterminateDrawable determinateDrawable, float f) {
                View view = (View) determinateDrawable;
                switch (i2) {
                    case 0:
                        view.setY(f);
                        break;
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        view.setZ(f);
                        break;
                    case 2:
                        view.setAlpha(f);
                        break;
                    case 3:
                        view.setScrollX((int) f);
                        break;
                    case 4:
                        view.setScrollY((int) f);
                        break;
                    case 5:
                        view.setTranslationX(f);
                        break;
                    case 6:
                        view.setTranslationY(f);
                        break;
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        view.setTranslationZ(f);
                        break;
                    case 8:
                        view.setScaleX(f);
                        break;
                    case 9:
                        view.setScaleY(f);
                        break;
                    case 10:
                        view.setRotation(f);
                        break;
                    case 11:
                        view.setRotationX(f);
                        break;
                    case 12:
                        view.setRotationY(f);
                        break;
                    default:
                        view.setX(f);
                        break;
                }
            }
        };
        final String str3 = "translationZ";
        final int i3 = 7;
        new a(str3) { // from class: np$a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final float getValue(DeterminateDrawable determinateDrawable) {
                View view = (View) determinateDrawable;
                switch (i3) {
                    case 0:
                        return view.getY();
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        return view.getZ();
                    case 2:
                        return view.getAlpha();
                    case 3:
                        return view.getScrollX();
                    case 4:
                        return view.getScrollY();
                    case 5:
                        return view.getTranslationX();
                    case 6:
                        return view.getTranslationY();
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        return view.getTranslationZ();
                    case 8:
                        return view.getScaleX();
                    case 9:
                        return view.getScaleY();
                    case 10:
                        return view.getRotation();
                    case 11:
                        return view.getRotationX();
                    case 12:
                        return view.getRotationY();
                    default:
                        return view.getX();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final void setValue(DeterminateDrawable determinateDrawable, float f) {
                View view = (View) determinateDrawable;
                switch (i3) {
                    case 0:
                        view.setY(f);
                        break;
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        view.setZ(f);
                        break;
                    case 2:
                        view.setAlpha(f);
                        break;
                    case 3:
                        view.setScrollX((int) f);
                        break;
                    case 4:
                        view.setScrollY((int) f);
                        break;
                    case 5:
                        view.setTranslationX(f);
                        break;
                    case 6:
                        view.setTranslationY(f);
                        break;
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        view.setTranslationZ(f);
                        break;
                    case 8:
                        view.setScaleX(f);
                        break;
                    case 9:
                        view.setScaleY(f);
                        break;
                    case 10:
                        view.setRotation(f);
                        break;
                    case 11:
                        view.setRotationX(f);
                        break;
                    case 12:
                        view.setRotationY(f);
                        break;
                    default:
                        view.setX(f);
                        break;
                }
            }
        };
        final String str4 = "scaleX";
        final int i4 = 8;
        l = new a(str4) { // from class: np$a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final float getValue(DeterminateDrawable determinateDrawable) {
                View view = (View) determinateDrawable;
                switch (i4) {
                    case 0:
                        return view.getY();
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        return view.getZ();
                    case 2:
                        return view.getAlpha();
                    case 3:
                        return view.getScrollX();
                    case 4:
                        return view.getScrollY();
                    case 5:
                        return view.getTranslationX();
                    case 6:
                        return view.getTranslationY();
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        return view.getTranslationZ();
                    case 8:
                        return view.getScaleX();
                    case 9:
                        return view.getScaleY();
                    case 10:
                        return view.getRotation();
                    case 11:
                        return view.getRotationX();
                    case 12:
                        return view.getRotationY();
                    default:
                        return view.getX();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final void setValue(DeterminateDrawable determinateDrawable, float f) {
                View view = (View) determinateDrawable;
                switch (i4) {
                    case 0:
                        view.setY(f);
                        break;
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        view.setZ(f);
                        break;
                    case 2:
                        view.setAlpha(f);
                        break;
                    case 3:
                        view.setScrollX((int) f);
                        break;
                    case 4:
                        view.setScrollY((int) f);
                        break;
                    case 5:
                        view.setTranslationX(f);
                        break;
                    case 6:
                        view.setTranslationY(f);
                        break;
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        view.setTranslationZ(f);
                        break;
                    case 8:
                        view.setScaleX(f);
                        break;
                    case 9:
                        view.setScaleY(f);
                        break;
                    case 10:
                        view.setRotation(f);
                        break;
                    case 11:
                        view.setRotationX(f);
                        break;
                    case 12:
                        view.setRotationY(f);
                        break;
                    default:
                        view.setX(f);
                        break;
                }
            }
        };
        final String str5 = "scaleY";
        final int i5 = 9;
        m = new a(str5) { // from class: np$a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final float getValue(DeterminateDrawable determinateDrawable) {
                View view = (View) determinateDrawable;
                switch (i5) {
                    case 0:
                        return view.getY();
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        return view.getZ();
                    case 2:
                        return view.getAlpha();
                    case 3:
                        return view.getScrollX();
                    case 4:
                        return view.getScrollY();
                    case 5:
                        return view.getTranslationX();
                    case 6:
                        return view.getTranslationY();
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        return view.getTranslationZ();
                    case 8:
                        return view.getScaleX();
                    case 9:
                        return view.getScaleY();
                    case 10:
                        return view.getRotation();
                    case 11:
                        return view.getRotationX();
                    case 12:
                        return view.getRotationY();
                    default:
                        return view.getX();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final void setValue(DeterminateDrawable determinateDrawable, float f) {
                View view = (View) determinateDrawable;
                switch (i5) {
                    case 0:
                        view.setY(f);
                        break;
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        view.setZ(f);
                        break;
                    case 2:
                        view.setAlpha(f);
                        break;
                    case 3:
                        view.setScrollX((int) f);
                        break;
                    case 4:
                        view.setScrollY((int) f);
                        break;
                    case 5:
                        view.setTranslationX(f);
                        break;
                    case 6:
                        view.setTranslationY(f);
                        break;
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        view.setTranslationZ(f);
                        break;
                    case 8:
                        view.setScaleX(f);
                        break;
                    case 9:
                        view.setScaleY(f);
                        break;
                    case 10:
                        view.setRotation(f);
                        break;
                    case 11:
                        view.setRotationX(f);
                        break;
                    case 12:
                        view.setRotationY(f);
                        break;
                    default:
                        view.setX(f);
                        break;
                }
            }
        };
        final String str6 = "rotation";
        final int i6 = 10;
        n = new a(str6) { // from class: np$a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final float getValue(DeterminateDrawable determinateDrawable) {
                View view = (View) determinateDrawable;
                switch (i6) {
                    case 0:
                        return view.getY();
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        return view.getZ();
                    case 2:
                        return view.getAlpha();
                    case 3:
                        return view.getScrollX();
                    case 4:
                        return view.getScrollY();
                    case 5:
                        return view.getTranslationX();
                    case 6:
                        return view.getTranslationY();
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        return view.getTranslationZ();
                    case 8:
                        return view.getScaleX();
                    case 9:
                        return view.getScaleY();
                    case 10:
                        return view.getRotation();
                    case 11:
                        return view.getRotationX();
                    case 12:
                        return view.getRotationY();
                    default:
                        return view.getX();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final void setValue(DeterminateDrawable determinateDrawable, float f) {
                View view = (View) determinateDrawable;
                switch (i6) {
                    case 0:
                        view.setY(f);
                        break;
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        view.setZ(f);
                        break;
                    case 2:
                        view.setAlpha(f);
                        break;
                    case 3:
                        view.setScrollX((int) f);
                        break;
                    case 4:
                        view.setScrollY((int) f);
                        break;
                    case 5:
                        view.setTranslationX(f);
                        break;
                    case 6:
                        view.setTranslationY(f);
                        break;
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        view.setTranslationZ(f);
                        break;
                    case 8:
                        view.setScaleX(f);
                        break;
                    case 9:
                        view.setScaleY(f);
                        break;
                    case 10:
                        view.setRotation(f);
                        break;
                    case 11:
                        view.setRotationX(f);
                        break;
                    case 12:
                        view.setRotationY(f);
                        break;
                    default:
                        view.setX(f);
                        break;
                }
            }
        };
        final String str7 = "rotationX";
        final int i7 = 11;
        o = new a(str7) { // from class: np$a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final float getValue(DeterminateDrawable determinateDrawable) {
                View view = (View) determinateDrawable;
                switch (i7) {
                    case 0:
                        return view.getY();
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        return view.getZ();
                    case 2:
                        return view.getAlpha();
                    case 3:
                        return view.getScrollX();
                    case 4:
                        return view.getScrollY();
                    case 5:
                        return view.getTranslationX();
                    case 6:
                        return view.getTranslationY();
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        return view.getTranslationZ();
                    case 8:
                        return view.getScaleX();
                    case 9:
                        return view.getScaleY();
                    case 10:
                        return view.getRotation();
                    case 11:
                        return view.getRotationX();
                    case 12:
                        return view.getRotationY();
                    default:
                        return view.getX();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final void setValue(DeterminateDrawable determinateDrawable, float f) {
                View view = (View) determinateDrawable;
                switch (i7) {
                    case 0:
                        view.setY(f);
                        break;
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        view.setZ(f);
                        break;
                    case 2:
                        view.setAlpha(f);
                        break;
                    case 3:
                        view.setScrollX((int) f);
                        break;
                    case 4:
                        view.setScrollY((int) f);
                        break;
                    case 5:
                        view.setTranslationX(f);
                        break;
                    case 6:
                        view.setTranslationY(f);
                        break;
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        view.setTranslationZ(f);
                        break;
                    case 8:
                        view.setScaleX(f);
                        break;
                    case 9:
                        view.setScaleY(f);
                        break;
                    case 10:
                        view.setRotation(f);
                        break;
                    case 11:
                        view.setRotationX(f);
                        break;
                    case 12:
                        view.setRotationY(f);
                        break;
                    default:
                        view.setX(f);
                        break;
                }
            }
        };
        final String str8 = "rotationY";
        final int i8 = 12;
        p = new a(str8) { // from class: np$a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final float getValue(DeterminateDrawable determinateDrawable) {
                View view = (View) determinateDrawable;
                switch (i8) {
                    case 0:
                        return view.getY();
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        return view.getZ();
                    case 2:
                        return view.getAlpha();
                    case 3:
                        return view.getScrollX();
                    case 4:
                        return view.getScrollY();
                    case 5:
                        return view.getTranslationX();
                    case 6:
                        return view.getTranslationY();
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        return view.getTranslationZ();
                    case 8:
                        return view.getScaleX();
                    case 9:
                        return view.getScaleY();
                    case 10:
                        return view.getRotation();
                    case 11:
                        return view.getRotationX();
                    case 12:
                        return view.getRotationY();
                    default:
                        return view.getX();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final void setValue(DeterminateDrawable determinateDrawable, float f) {
                View view = (View) determinateDrawable;
                switch (i8) {
                    case 0:
                        view.setY(f);
                        break;
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        view.setZ(f);
                        break;
                    case 2:
                        view.setAlpha(f);
                        break;
                    case 3:
                        view.setScrollX((int) f);
                        break;
                    case 4:
                        view.setScrollY((int) f);
                        break;
                    case 5:
                        view.setTranslationX(f);
                        break;
                    case 6:
                        view.setTranslationY(f);
                        break;
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        view.setTranslationZ(f);
                        break;
                    case 8:
                        view.setScaleX(f);
                        break;
                    case 9:
                        view.setScaleY(f);
                        break;
                    case 10:
                        view.setRotation(f);
                        break;
                    case 11:
                        view.setRotationX(f);
                        break;
                    case 12:
                        view.setRotationY(f);
                        break;
                    default:
                        view.setX(f);
                        break;
                }
            }
        };
        final String str9 = "x";
        final int i9 = 13;
        new a(str9) { // from class: np$a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final float getValue(DeterminateDrawable determinateDrawable) {
                View view = (View) determinateDrawable;
                switch (i9) {
                    case 0:
                        return view.getY();
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        return view.getZ();
                    case 2:
                        return view.getAlpha();
                    case 3:
                        return view.getScrollX();
                    case 4:
                        return view.getScrollY();
                    case 5:
                        return view.getTranslationX();
                    case 6:
                        return view.getTranslationY();
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        return view.getTranslationZ();
                    case 8:
                        return view.getScaleX();
                    case 9:
                        return view.getScaleY();
                    case 10:
                        return view.getRotation();
                    case 11:
                        return view.getRotationX();
                    case 12:
                        return view.getRotationY();
                    default:
                        return view.getX();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final void setValue(DeterminateDrawable determinateDrawable, float f) {
                View view = (View) determinateDrawable;
                switch (i9) {
                    case 0:
                        view.setY(f);
                        break;
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        view.setZ(f);
                        break;
                    case 2:
                        view.setAlpha(f);
                        break;
                    case 3:
                        view.setScrollX((int) f);
                        break;
                    case 4:
                        view.setScrollY((int) f);
                        break;
                    case 5:
                        view.setTranslationX(f);
                        break;
                    case 6:
                        view.setTranslationY(f);
                        break;
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        view.setTranslationZ(f);
                        break;
                    case 8:
                        view.setScaleX(f);
                        break;
                    case 9:
                        view.setScaleY(f);
                        break;
                    case 10:
                        view.setRotation(f);
                        break;
                    case 11:
                        view.setRotationX(f);
                        break;
                    case 12:
                        view.setRotationY(f);
                        break;
                    default:
                        view.setX(f);
                        break;
                }
            }
        };
        final String str10 = "y";
        final int i10 = 0;
        new a(str10) { // from class: np$a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final float getValue(DeterminateDrawable determinateDrawable) {
                View view = (View) determinateDrawable;
                switch (i10) {
                    case 0:
                        return view.getY();
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        return view.getZ();
                    case 2:
                        return view.getAlpha();
                    case 3:
                        return view.getScrollX();
                    case 4:
                        return view.getScrollY();
                    case 5:
                        return view.getTranslationX();
                    case 6:
                        return view.getTranslationY();
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        return view.getTranslationZ();
                    case 8:
                        return view.getScaleX();
                    case 9:
                        return view.getScaleY();
                    case 10:
                        return view.getRotation();
                    case 11:
                        return view.getRotationX();
                    case 12:
                        return view.getRotationY();
                    default:
                        return view.getX();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final void setValue(DeterminateDrawable determinateDrawable, float f) {
                View view = (View) determinateDrawable;
                switch (i10) {
                    case 0:
                        view.setY(f);
                        break;
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        view.setZ(f);
                        break;
                    case 2:
                        view.setAlpha(f);
                        break;
                    case 3:
                        view.setScrollX((int) f);
                        break;
                    case 4:
                        view.setScrollY((int) f);
                        break;
                    case 5:
                        view.setTranslationX(f);
                        break;
                    case 6:
                        view.setTranslationY(f);
                        break;
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        view.setTranslationZ(f);
                        break;
                    case 8:
                        view.setScaleX(f);
                        break;
                    case 9:
                        view.setScaleY(f);
                        break;
                    case 10:
                        view.setRotation(f);
                        break;
                    case 11:
                        view.setRotationX(f);
                        break;
                    case 12:
                        view.setRotationY(f);
                        break;
                    default:
                        view.setX(f);
                        break;
                }
            }
        };
        final String str11 = "z";
        final int i11 = 1;
        new a(str11) { // from class: np$a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final float getValue(DeterminateDrawable determinateDrawable) {
                View view = (View) determinateDrawable;
                switch (i11) {
                    case 0:
                        return view.getY();
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        return view.getZ();
                    case 2:
                        return view.getAlpha();
                    case 3:
                        return view.getScrollX();
                    case 4:
                        return view.getScrollY();
                    case 5:
                        return view.getTranslationX();
                    case 6:
                        return view.getTranslationY();
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        return view.getTranslationZ();
                    case 8:
                        return view.getScaleX();
                    case 9:
                        return view.getScaleY();
                    case 10:
                        return view.getRotation();
                    case 11:
                        return view.getRotationX();
                    case 12:
                        return view.getRotationY();
                    default:
                        return view.getX();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final void setValue(DeterminateDrawable determinateDrawable, float f) {
                View view = (View) determinateDrawable;
                switch (i11) {
                    case 0:
                        view.setY(f);
                        break;
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        view.setZ(f);
                        break;
                    case 2:
                        view.setAlpha(f);
                        break;
                    case 3:
                        view.setScrollX((int) f);
                        break;
                    case 4:
                        view.setScrollY((int) f);
                        break;
                    case 5:
                        view.setTranslationX(f);
                        break;
                    case 6:
                        view.setTranslationY(f);
                        break;
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        view.setTranslationZ(f);
                        break;
                    case 8:
                        view.setScaleX(f);
                        break;
                    case 9:
                        view.setScaleY(f);
                        break;
                    case 10:
                        view.setRotation(f);
                        break;
                    case 11:
                        view.setRotationX(f);
                        break;
                    case 12:
                        view.setRotationY(f);
                        break;
                    default:
                        view.setX(f);
                        break;
                }
            }
        };
        final String str12 = "alpha";
        final int i12 = 2;
        q = new a(str12) { // from class: np$a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final float getValue(DeterminateDrawable determinateDrawable) {
                View view = (View) determinateDrawable;
                switch (i12) {
                    case 0:
                        return view.getY();
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        return view.getZ();
                    case 2:
                        return view.getAlpha();
                    case 3:
                        return view.getScrollX();
                    case 4:
                        return view.getScrollY();
                    case 5:
                        return view.getTranslationX();
                    case 6:
                        return view.getTranslationY();
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        return view.getTranslationZ();
                    case 8:
                        return view.getScaleX();
                    case 9:
                        return view.getScaleY();
                    case 10:
                        return view.getRotation();
                    case 11:
                        return view.getRotationX();
                    case 12:
                        return view.getRotationY();
                    default:
                        return view.getX();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final void setValue(DeterminateDrawable determinateDrawable, float f) {
                View view = (View) determinateDrawable;
                switch (i12) {
                    case 0:
                        view.setY(f);
                        break;
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        view.setZ(f);
                        break;
                    case 2:
                        view.setAlpha(f);
                        break;
                    case 3:
                        view.setScrollX((int) f);
                        break;
                    case 4:
                        view.setScrollY((int) f);
                        break;
                    case 5:
                        view.setTranslationX(f);
                        break;
                    case 6:
                        view.setTranslationY(f);
                        break;
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        view.setTranslationZ(f);
                        break;
                    case 8:
                        view.setScaleX(f);
                        break;
                    case 9:
                        view.setScaleY(f);
                        break;
                    case 10:
                        view.setRotation(f);
                        break;
                    case 11:
                        view.setRotationX(f);
                        break;
                    case 12:
                        view.setRotationY(f);
                        break;
                    default:
                        view.setX(f);
                        break;
                }
            }
        };
        final String str13 = "scrollX";
        final int i13 = 3;
        new a(str13) { // from class: np$a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final float getValue(DeterminateDrawable determinateDrawable) {
                View view = (View) determinateDrawable;
                switch (i13) {
                    case 0:
                        return view.getY();
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        return view.getZ();
                    case 2:
                        return view.getAlpha();
                    case 3:
                        return view.getScrollX();
                    case 4:
                        return view.getScrollY();
                    case 5:
                        return view.getTranslationX();
                    case 6:
                        return view.getTranslationY();
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        return view.getTranslationZ();
                    case 8:
                        return view.getScaleX();
                    case 9:
                        return view.getScaleY();
                    case 10:
                        return view.getRotation();
                    case 11:
                        return view.getRotationX();
                    case 12:
                        return view.getRotationY();
                    default:
                        return view.getX();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final void setValue(DeterminateDrawable determinateDrawable, float f) {
                View view = (View) determinateDrawable;
                switch (i13) {
                    case 0:
                        view.setY(f);
                        break;
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        view.setZ(f);
                        break;
                    case 2:
                        view.setAlpha(f);
                        break;
                    case 3:
                        view.setScrollX((int) f);
                        break;
                    case 4:
                        view.setScrollY((int) f);
                        break;
                    case 5:
                        view.setTranslationX(f);
                        break;
                    case 6:
                        view.setTranslationY(f);
                        break;
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        view.setTranslationZ(f);
                        break;
                    case 8:
                        view.setScaleX(f);
                        break;
                    case 9:
                        view.setScaleY(f);
                        break;
                    case 10:
                        view.setRotation(f);
                        break;
                    case 11:
                        view.setRotationX(f);
                        break;
                    case 12:
                        view.setRotationY(f);
                        break;
                    default:
                        view.setX(f);
                        break;
                }
            }
        };
        final String str14 = "scrollY";
        final int i14 = 4;
        new a(str14) { // from class: np$a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final float getValue(DeterminateDrawable determinateDrawable) {
                View view = (View) determinateDrawable;
                switch (i14) {
                    case 0:
                        return view.getY();
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        return view.getZ();
                    case 2:
                        return view.getAlpha();
                    case 3:
                        return view.getScrollX();
                    case 4:
                        return view.getScrollY();
                    case 5:
                        return view.getTranslationX();
                    case 6:
                        return view.getTranslationY();
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        return view.getTranslationZ();
                    case 8:
                        return view.getScaleX();
                    case 9:
                        return view.getScaleY();
                    case 10:
                        return view.getRotation();
                    case 11:
                        return view.getRotationX();
                    case 12:
                        return view.getRotationY();
                    default:
                        return view.getX();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.dynamicanimation.animation.a
            public final void setValue(DeterminateDrawable determinateDrawable, float f) {
                View view = (View) determinateDrawable;
                switch (i14) {
                    case 0:
                        view.setY(f);
                        break;
                    case 1:
                        WeakHashMap weakHashMap = qd1.a;
                        view.setZ(f);
                        break;
                    case 2:
                        view.setAlpha(f);
                        break;
                    case 3:
                        view.setScrollX((int) f);
                        break;
                    case 4:
                        view.setScrollY((int) f);
                        break;
                    case 5:
                        view.setTranslationX(f);
                        break;
                    case 6:
                        view.setTranslationY(f);
                        break;
                    case 7:
                        WeakHashMap weakHashMap2 = qd1.a;
                        view.setTranslationZ(f);
                        break;
                    case 8:
                        view.setScaleX(f);
                        break;
                    case 9:
                        view.setScaleY(f);
                        break;
                    case 10:
                        view.setRotation(f);
                        break;
                    case 11:
                        view.setRotationX(f);
                        break;
                    case 12:
                        view.setRotationY(f);
                        break;
                    default:
                        view.setX(f);
                        break;
                }
            }
        };
    }

    public h21(DeterminateDrawable determinateDrawable, a aVar) {
        this.d = determinateDrawable;
        this.e = aVar;
        this.i = (aVar == n || aVar == o || aVar == p) ? 0.1f : (aVar == q || aVar == l || aVar == m) ? 0.00390625f : 1.0f;
        this.r = null;
        this.s = Float.MAX_VALUE;
        this.t = false;
    }

    public final void b(float f) {
        this.e.setValue(this.d, f);
        int i = 0;
        while (true) {
            ArrayList arrayList = this.k;
            if (i >= arrayList.size()) {
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        return;
                    }
                    if (arrayList.get(size) == null) {
                        arrayList.remove(size);
                    }
                }
            } else {
                if (arrayList.get(i) != null) {
                    arrayList.get(i).getClass();
                    d.AnonymousClass0.m$1();
                    return;
                }
                i++;
            }
        }
    }

    public final void c() {
        if (this.r.b <= 0.0d) {
            d.AnonymousClass0.m$3("Spring animations can only come to an end when there is damping");
        } else {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new AndroidRuntimeException("Animations may only be started on the main thread");
            }
            if (this.f) {
                this.t = true;
            }
        }
    }
}
