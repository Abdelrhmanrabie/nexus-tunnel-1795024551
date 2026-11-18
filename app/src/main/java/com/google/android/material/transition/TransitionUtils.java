package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import defpackage.ak;
import defpackage.e;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class TransitionUtils {
    public static final RectF transformAlphaRectF = new RectF();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface CanvasOperation {
        void run(Canvas canvas);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface CornerSizeBinaryOperator {
    }

    private TransitionUtils() {
    }

    public static View findAncestorById(View view, int i) {
        String resourceName = view.getResources().getResourceName(i);
        while (view != null) {
            if (view.getId() != i) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(ak.j(resourceName, " is not a valid ancestor"));
    }

    public static RectF getLocationOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new RectF(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    public static float lerp(float f, float f2, float f3, float f4, float f5, boolean z) {
        if (z && (f5 < 0.0f || f5 > 1.0f)) {
            return e.a(f2, f, f5, f);
        }
        if (f5 < f3) {
            return f;
        }
        return f5 > f4 ? f2 : e.a(f2, f, (f5 - f3) / (f4 - f3), f);
    }

    public static int lerp(int i, int i2, float f, float f2, float f3) {
        if (f3 < f) {
            return i;
        }
        if (f3 > f2) {
            return i2;
        }
        float f4 = i;
        return (int) e.a(i2, f4, (f3 - f) / (f2 - f), f4);
    }

    public static void transform(Canvas canvas, Rect rect, float f, float f2, float f3, int i, CanvasOperation canvasOperation) {
        if (i <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(f, f2);
        canvas.scale(f3, f3);
        if (i < 255) {
            RectF rectF = transformAlphaRectF;
            rectF.set(rect);
            canvas.saveLayerAlpha(rectF, i);
        }
        canvasOperation.run(canvas);
        canvas.restoreToCount(iSave);
    }
}
