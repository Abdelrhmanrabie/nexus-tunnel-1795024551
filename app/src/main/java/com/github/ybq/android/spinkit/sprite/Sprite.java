package com.github.ybq.android.spinkit.sprite;

import android.animation.ValueAnimator;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.github.ybq.android.spinkit.animation.IntProperty;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class Sprite extends Drawable implements ValueAnimator.AnimatorUpdateListener, Animatable, Drawable.Callback {
    public static final AnonymousClass1 ALPHA;
    public static final AnonymousClass1 ROTATE;
    public static final AnonymousClass1 ROTATE_X;
    public static final AnonymousClass1 ROTATE_Y;
    public static final AnonymousClass6 SCALE;
    public static final AnonymousClass6 SCALE_Y;
    public static final AnonymousClass6 TRANSLATE_X_PERCENTAGE;
    public static final AnonymousClass6 TRANSLATE_Y_PERCENTAGE;
    public static final Rect ZERO_BOUNDS_RECT = new Rect();
    public int animationDelay;
    public ValueAnimator animator;
    public float pivotX;
    public float pivotY;
    public int rotate;
    public int rotateX;
    public int rotateY;
    public int translateX;
    public float translateXPercentage;
    public int translateY;
    public float translateYPercentage;
    public float scale = 1.0f;
    public float scaleX = 1.0f;
    public float scaleY = 1.0f;
    public int alpha = 255;
    public Rect drawBounds = ZERO_BOUNDS_RECT;
    public final Camera mCamera = new Camera();
    public final Matrix mMatrix = new Matrix();

    /* JADX WARN: Type inference failed for: r0v1, types: [com.github.ybq.android.spinkit.sprite.Sprite$1] */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.github.ybq.android.spinkit.sprite.Sprite$6] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.github.ybq.android.spinkit.sprite.Sprite$1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.github.ybq.android.spinkit.sprite.Sprite$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.github.ybq.android.spinkit.sprite.Sprite$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.github.ybq.android.spinkit.sprite.Sprite$6] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.github.ybq.android.spinkit.sprite.Sprite$6] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.github.ybq.android.spinkit.sprite.Sprite$6] */
    static {
        final int i = 0;
        ROTATE_X = new IntProperty("rotateX") { // from class: com.github.ybq.android.spinkit.sprite.Sprite.1
            @Override // android.util.Property
            public final Object get(Object obj) {
                int i2;
                int i3 = i;
                Sprite sprite = (Sprite) obj;
                if (i3 == 0) {
                    i2 = sprite.rotateX;
                } else if (i3 == 1) {
                    i2 = sprite.alpha;
                } else if (i3 == 2) {
                    i2 = sprite.rotate;
                } else if (i3 != 3) {
                    i2 = i3 != 4 ? sprite.translateY : sprite.translateX;
                } else {
                    i2 = sprite.rotateY;
                }
                return Integer.valueOf(i2);
            }

            @Override // com.github.ybq.android.spinkit.animation.IntProperty
            public final void setValue(int i2, Object obj) {
                int i3 = i;
                Sprite sprite = (Sprite) obj;
                if (i3 == 0) {
                    sprite.rotateX = i2;
                    return;
                }
                if (i3 == 1) {
                    sprite.setAlpha(i2);
                    return;
                }
                if (i3 == 2) {
                    sprite.rotate = i2;
                    return;
                }
                if (i3 == 3) {
                    sprite.rotateY = i2;
                } else if (i3 != 4) {
                    sprite.translateY = i2;
                } else {
                    sprite.translateX = i2;
                }
            }
        };
        final int i2 = 2;
        ROTATE = new IntProperty("rotate") { // from class: com.github.ybq.android.spinkit.sprite.Sprite.1
            @Override // android.util.Property
            public final Object get(Object obj) {
                int i3;
                int i4 = i2;
                Sprite sprite = (Sprite) obj;
                if (i4 == 0) {
                    i3 = sprite.rotateX;
                } else if (i4 == 1) {
                    i3 = sprite.alpha;
                } else if (i4 == 2) {
                    i3 = sprite.rotate;
                } else if (i4 != 3) {
                    i3 = i4 != 4 ? sprite.translateY : sprite.translateX;
                } else {
                    i3 = sprite.rotateY;
                }
                return Integer.valueOf(i3);
            }

            @Override // com.github.ybq.android.spinkit.animation.IntProperty
            public final void setValue(int i3, Object obj) {
                int i4 = i2;
                Sprite sprite = (Sprite) obj;
                if (i4 == 0) {
                    sprite.rotateX = i3;
                    return;
                }
                if (i4 == 1) {
                    sprite.setAlpha(i3);
                    return;
                }
                if (i4 == 2) {
                    sprite.rotate = i3;
                    return;
                }
                if (i4 == 3) {
                    sprite.rotateY = i3;
                } else if (i4 != 4) {
                    sprite.translateY = i3;
                } else {
                    sprite.translateX = i3;
                }
            }
        };
        final int i3 = 3;
        ROTATE_Y = new IntProperty("rotateY") { // from class: com.github.ybq.android.spinkit.sprite.Sprite.1
            @Override // android.util.Property
            public final Object get(Object obj) {
                int i4;
                int i5 = i3;
                Sprite sprite = (Sprite) obj;
                if (i5 == 0) {
                    i4 = sprite.rotateX;
                } else if (i5 == 1) {
                    i4 = sprite.alpha;
                } else if (i5 == 2) {
                    i4 = sprite.rotate;
                } else if (i5 != 3) {
                    i4 = i5 != 4 ? sprite.translateY : sprite.translateX;
                } else {
                    i4 = sprite.rotateY;
                }
                return Integer.valueOf(i4);
            }

            @Override // com.github.ybq.android.spinkit.animation.IntProperty
            public final void setValue(int i4, Object obj) {
                int i5 = i3;
                Sprite sprite = (Sprite) obj;
                if (i5 == 0) {
                    sprite.rotateX = i4;
                    return;
                }
                if (i5 == 1) {
                    sprite.setAlpha(i4);
                    return;
                }
                if (i5 == 2) {
                    sprite.rotate = i4;
                    return;
                }
                if (i5 == 3) {
                    sprite.rotateY = i4;
                } else if (i5 != 4) {
                    sprite.translateY = i4;
                } else {
                    sprite.translateX = i4;
                }
            }
        };
        final int i4 = 4;
        new IntProperty("translateX") { // from class: com.github.ybq.android.spinkit.sprite.Sprite.1
            @Override // android.util.Property
            public final Object get(Object obj) {
                int i5;
                int i6 = i4;
                Sprite sprite = (Sprite) obj;
                if (i6 == 0) {
                    i5 = sprite.rotateX;
                } else if (i6 == 1) {
                    i5 = sprite.alpha;
                } else if (i6 == 2) {
                    i5 = sprite.rotate;
                } else if (i6 != 3) {
                    i5 = i6 != 4 ? sprite.translateY : sprite.translateX;
                } else {
                    i5 = sprite.rotateY;
                }
                return Integer.valueOf(i5);
            }

            @Override // com.github.ybq.android.spinkit.animation.IntProperty
            public final void setValue(int i5, Object obj) {
                int i6 = i4;
                Sprite sprite = (Sprite) obj;
                if (i6 == 0) {
                    sprite.rotateX = i5;
                    return;
                }
                if (i6 == 1) {
                    sprite.setAlpha(i5);
                    return;
                }
                if (i6 == 2) {
                    sprite.rotate = i5;
                    return;
                }
                if (i6 == 3) {
                    sprite.rotateY = i5;
                } else if (i6 != 4) {
                    sprite.translateY = i5;
                } else {
                    sprite.translateX = i5;
                }
            }
        };
        final int i5 = 5;
        new IntProperty("translateY") { // from class: com.github.ybq.android.spinkit.sprite.Sprite.1
            @Override // android.util.Property
            public final Object get(Object obj) {
                int i6;
                int i7 = i5;
                Sprite sprite = (Sprite) obj;
                if (i7 == 0) {
                    i6 = sprite.rotateX;
                } else if (i7 == 1) {
                    i6 = sprite.alpha;
                } else if (i7 == 2) {
                    i6 = sprite.rotate;
                } else if (i7 != 3) {
                    i6 = i7 != 4 ? sprite.translateY : sprite.translateX;
                } else {
                    i6 = sprite.rotateY;
                }
                return Integer.valueOf(i6);
            }

            @Override // com.github.ybq.android.spinkit.animation.IntProperty
            public final void setValue(int i6, Object obj) {
                int i7 = i5;
                Sprite sprite = (Sprite) obj;
                if (i7 == 0) {
                    sprite.rotateX = i6;
                    return;
                }
                if (i7 == 1) {
                    sprite.setAlpha(i6);
                    return;
                }
                if (i7 == 2) {
                    sprite.rotate = i6;
                    return;
                }
                if (i7 == 3) {
                    sprite.rotateY = i6;
                } else if (i7 != 4) {
                    sprite.translateY = i6;
                } else {
                    sprite.translateX = i6;
                }
            }
        };
        TRANSLATE_X_PERCENTAGE = new IntProperty("translateXPercentage") { // from class: com.github.ybq.android.spinkit.sprite.Sprite.6
            @Override // android.util.Property
            public final Object get(Object obj) {
                float f;
                int i6 = i;
                Sprite sprite = (Sprite) obj;
                if (i6 == 0) {
                    f = sprite.translateXPercentage;
                } else if (i6 == 1) {
                    f = sprite.scale;
                } else if (i6 != 2) {
                    f = i6 != 3 ? sprite.scaleY : sprite.scaleX;
                } else {
                    f = sprite.translateYPercentage;
                }
                return Float.valueOf(f);
            }

            @Override // com.github.ybq.android.spinkit.animation.IntProperty
            public final void setValue(Object obj, float f) {
                int i6 = i;
                Sprite sprite = (Sprite) obj;
                if (i6 == 0) {
                    sprite.translateXPercentage = f;
                    return;
                }
                if (i6 == 1) {
                    sprite.setScale(f);
                    return;
                }
                if (i6 == 2) {
                    sprite.translateYPercentage = f;
                } else if (i6 != 3) {
                    sprite.scaleY = f;
                } else {
                    sprite.scaleX = f;
                }
            }
        };
        TRANSLATE_Y_PERCENTAGE = new IntProperty("translateYPercentage") { // from class: com.github.ybq.android.spinkit.sprite.Sprite.6
            @Override // android.util.Property
            public final Object get(Object obj) {
                float f;
                int i6 = i2;
                Sprite sprite = (Sprite) obj;
                if (i6 == 0) {
                    f = sprite.translateXPercentage;
                } else if (i6 == 1) {
                    f = sprite.scale;
                } else if (i6 != 2) {
                    f = i6 != 3 ? sprite.scaleY : sprite.scaleX;
                } else {
                    f = sprite.translateYPercentage;
                }
                return Float.valueOf(f);
            }

            @Override // com.github.ybq.android.spinkit.animation.IntProperty
            public final void setValue(Object obj, float f) {
                int i6 = i2;
                Sprite sprite = (Sprite) obj;
                if (i6 == 0) {
                    sprite.translateXPercentage = f;
                    return;
                }
                if (i6 == 1) {
                    sprite.setScale(f);
                    return;
                }
                if (i6 == 2) {
                    sprite.translateYPercentage = f;
                } else if (i6 != 3) {
                    sprite.scaleY = f;
                } else {
                    sprite.scaleX = f;
                }
            }
        };
        new IntProperty("scaleX") { // from class: com.github.ybq.android.spinkit.sprite.Sprite.6
            @Override // android.util.Property
            public final Object get(Object obj) {
                float f;
                int i6 = i3;
                Sprite sprite = (Sprite) obj;
                if (i6 == 0) {
                    f = sprite.translateXPercentage;
                } else if (i6 == 1) {
                    f = sprite.scale;
                } else if (i6 != 2) {
                    f = i6 != 3 ? sprite.scaleY : sprite.scaleX;
                } else {
                    f = sprite.translateYPercentage;
                }
                return Float.valueOf(f);
            }

            @Override // com.github.ybq.android.spinkit.animation.IntProperty
            public final void setValue(Object obj, float f) {
                int i6 = i3;
                Sprite sprite = (Sprite) obj;
                if (i6 == 0) {
                    sprite.translateXPercentage = f;
                    return;
                }
                if (i6 == 1) {
                    sprite.setScale(f);
                    return;
                }
                if (i6 == 2) {
                    sprite.translateYPercentage = f;
                } else if (i6 != 3) {
                    sprite.scaleY = f;
                } else {
                    sprite.scaleX = f;
                }
            }
        };
        SCALE_Y = new IntProperty("scaleY") { // from class: com.github.ybq.android.spinkit.sprite.Sprite.6
            @Override // android.util.Property
            public final Object get(Object obj) {
                float f;
                int i6 = i4;
                Sprite sprite = (Sprite) obj;
                if (i6 == 0) {
                    f = sprite.translateXPercentage;
                } else if (i6 == 1) {
                    f = sprite.scale;
                } else if (i6 != 2) {
                    f = i6 != 3 ? sprite.scaleY : sprite.scaleX;
                } else {
                    f = sprite.translateYPercentage;
                }
                return Float.valueOf(f);
            }

            @Override // com.github.ybq.android.spinkit.animation.IntProperty
            public final void setValue(Object obj, float f) {
                int i6 = i4;
                Sprite sprite = (Sprite) obj;
                if (i6 == 0) {
                    sprite.translateXPercentage = f;
                    return;
                }
                if (i6 == 1) {
                    sprite.setScale(f);
                    return;
                }
                if (i6 == 2) {
                    sprite.translateYPercentage = f;
                } else if (i6 != 3) {
                    sprite.scaleY = f;
                } else {
                    sprite.scaleX = f;
                }
            }
        };
        final int i6 = 1;
        SCALE = new IntProperty("scale") { // from class: com.github.ybq.android.spinkit.sprite.Sprite.6
            @Override // android.util.Property
            public final Object get(Object obj) {
                float f;
                int i7 = i6;
                Sprite sprite = (Sprite) obj;
                if (i7 == 0) {
                    f = sprite.translateXPercentage;
                } else if (i7 == 1) {
                    f = sprite.scale;
                } else if (i7 != 2) {
                    f = i7 != 3 ? sprite.scaleY : sprite.scaleX;
                } else {
                    f = sprite.translateYPercentage;
                }
                return Float.valueOf(f);
            }

            @Override // com.github.ybq.android.spinkit.animation.IntProperty
            public final void setValue(Object obj, float f) {
                int i7 = i6;
                Sprite sprite = (Sprite) obj;
                if (i7 == 0) {
                    sprite.translateXPercentage = f;
                    return;
                }
                if (i7 == 1) {
                    sprite.setScale(f);
                    return;
                }
                if (i7 == 2) {
                    sprite.translateYPercentage = f;
                } else if (i7 != 3) {
                    sprite.scaleY = f;
                } else {
                    sprite.scaleX = f;
                }
            }
        };
        ALPHA = new IntProperty("alpha") { // from class: com.github.ybq.android.spinkit.sprite.Sprite.1
            @Override // android.util.Property
            public final Object get(Object obj) {
                int i7;
                int i8 = i6;
                Sprite sprite = (Sprite) obj;
                if (i8 == 0) {
                    i7 = sprite.rotateX;
                } else if (i8 == 1) {
                    i7 = sprite.alpha;
                } else if (i8 == 2) {
                    i7 = sprite.rotate;
                } else if (i8 != 3) {
                    i7 = i8 != 4 ? sprite.translateY : sprite.translateX;
                } else {
                    i7 = sprite.rotateY;
                }
                return Integer.valueOf(i7);
            }

            @Override // com.github.ybq.android.spinkit.animation.IntProperty
            public final void setValue(int i7, Object obj) {
                int i8 = i6;
                Sprite sprite = (Sprite) obj;
                if (i8 == 0) {
                    sprite.rotateX = i7;
                    return;
                }
                if (i8 == 1) {
                    sprite.setAlpha(i7);
                    return;
                }
                if (i8 == 2) {
                    sprite.rotate = i7;
                    return;
                }
                if (i8 == 3) {
                    sprite.rotateY = i7;
                } else if (i8 != 4) {
                    sprite.translateY = i7;
                } else {
                    sprite.translateX = i7;
                }
            }
        };
    }

    public static Rect clipSquare(Rect rect) {
        int iMin = Math.min(rect.width(), rect.height());
        int iCenterX = rect.centerX();
        int iCenterY = rect.centerY();
        int i = iMin / 2;
        return new Rect(iCenterX - i, iCenterY - i, iCenterX + i, iCenterY + i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iWidth = this.translateX;
        if (iWidth == 0) {
            iWidth = (int) (this.translateXPercentage * getBounds().width());
        }
        int iHeight = this.translateY;
        if (iHeight == 0) {
            iHeight = (int) (this.translateYPercentage * getBounds().height());
        }
        canvas.translate(iWidth, iHeight);
        canvas.scale(this.scaleX, this.scaleY, this.pivotX, this.pivotY);
        canvas.rotate(this.rotate, this.pivotX, this.pivotY);
        if (this.rotateX != 0 || this.rotateY != 0) {
            Camera camera = this.mCamera;
            camera.save();
            camera.rotateX(this.rotateX);
            camera.rotateY(this.rotateY);
            Matrix matrix = this.mMatrix;
            camera.getMatrix(matrix);
            matrix.preTranslate(-this.pivotX, -this.pivotY);
            matrix.postTranslate(this.pivotX, this.pivotY);
            camera.restore();
            canvas.concat(matrix);
        }
        drawSelf(canvas);
    }

    public abstract void drawSelf(Canvas canvas);

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.alpha;
    }

    public abstract int getColor();

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ValueAnimator valueAnimator = this.animator;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        setDrawBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public abstract ValueAnimator onCreateAnimation();

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.alpha = i;
    }

    public abstract void setColor(int i);

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public final void setDrawBounds(int i, int i2, int i3, int i4) {
        Rect rect = new Rect(i, i2, i3, i4);
        this.drawBounds = rect;
        this.pivotX = rect.centerX();
        this.pivotY = this.drawBounds.centerY();
    }

    public final void setScale(float f) {
        this.scale = f;
        this.scaleX = f;
        this.scaleY = f;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator == null || !valueAnimator.isStarted()) {
            if (this.animator == null) {
                this.animator = onCreateAnimation();
            }
            ValueAnimator valueAnimator2 = this.animator;
            if (valueAnimator2 != null) {
                valueAnimator2.addUpdateListener(this);
                this.animator.setStartDelay(this.animationDelay);
            }
            ValueAnimator valueAnimator3 = this.animator;
            this.animator = valueAnimator3;
            if (valueAnimator3 == null) {
                return;
            }
            if (!valueAnimator3.isStarted()) {
                valueAnimator3.start();
            }
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator == null || !valueAnimator.isStarted()) {
            return;
        }
        this.animator.removeAllUpdateListeners();
        this.animator.end();
        this.scale = 1.0f;
        this.rotateX = 0;
        this.rotateY = 0;
        this.translateX = 0;
        this.translateY = 0;
        this.rotate = 0;
        this.translateXPercentage = 0.0f;
        this.translateYPercentage = 0.0f;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }
}
