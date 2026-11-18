package com.google.android.material.transition.platform;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import defpackage.ak;
import defpackage.d;
import defpackage.e;
import defpackage.e4;
import defpackage.qd1;
import defpackage.vs;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialContainerTransform extends Transition {
    public static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS;
    public static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS_ARC;
    public final boolean appliedThemeValues;
    public final int drawingViewId;
    public final boolean elevationShadowEnabled;
    public final float endElevation;
    public final int endViewId;
    public boolean holdAtEndEnabled;
    public boolean pathMotionCustom;
    public final int scrimColor;
    public final float startElevation;
    public final int startViewId;
    public static final String[] TRANSITION_PROPS = {"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};
    public static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f));
    public static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f));

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FadeMode {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FitMode {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class ProgressThresholds {
        public final float end;
        public final float start;

        public ProgressThresholds(float f, float f2) {
            this.start = f;
            this.end = f2;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class ProgressThresholdsGroup {
        public final ProgressThresholds fade;
        public final ProgressThresholds scale;
        public final ProgressThresholds scaleMask;
        public final ProgressThresholds shapeMask;

        private ProgressThresholdsGroup(ProgressThresholds progressThresholds, ProgressThresholds progressThresholds2, ProgressThresholds progressThresholds3, ProgressThresholds progressThresholds4) {
            this.fade = progressThresholds;
            this.scale = progressThresholds2;
            this.scaleMask = progressThresholds3;
            this.shapeMask = progressThresholds4;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TransitionDirection {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class TransitionDrawable extends Drawable {
        public final MaterialShapeDrawable compatShadowDrawable;
        public final Paint containerPaint;
        public float currentElevation;
        public float currentElevationDy;
        public final RectF currentEndBounds;
        public final RectF currentEndBoundsMasked;
        public RectF currentMaskBounds;
        public final RectF currentStartBounds;
        public final RectF currentStartBoundsMasked;
        public final Paint debugPaint;
        public final Path debugPath;
        public final float displayHeight;
        public final float displayWidth;
        public final boolean drawDebugEnabled;
        public final boolean elevationShadowEnabled;
        public final RectF endBounds;
        public final Paint endContainerPaint;
        public final float endElevation;
        public final ShapeAppearanceModel endShapeAppearanceModel;
        public final View endView;
        public final boolean entering;
        public final FadeModeEvaluator fadeModeEvaluator;
        public FadeModeResult fadeModeResult;
        public final FitModeEvaluator fitModeEvaluator;
        public FitModeResult fitModeResult;
        public final MaskEvaluator maskEvaluator;
        public final float motionPathLength;
        public final PathMeasure motionPathMeasure;
        public final float[] motionPathPosition;
        public float progress;
        public final ProgressThresholdsGroup progressThresholds;
        public final Paint scrimPaint;
        public final Paint shadowPaint;
        public final RectF startBounds;
        public final Paint startContainerPaint;
        public final float startElevation;
        public final ShapeAppearanceModel startShapeAppearanceModel;
        public final View startView;

        private TransitionDrawable(PathMotion pathMotion, View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float f, View view2, RectF rectF2, ShapeAppearanceModel shapeAppearanceModel2, float f2, int i, int i2, int i3, int i4, boolean z, boolean z2, FadeModeEvaluator fadeModeEvaluator, FitModeEvaluator fitModeEvaluator, ProgressThresholdsGroup progressThresholdsGroup, boolean z3) {
            Paint paint = new Paint();
            this.containerPaint = paint;
            Paint paint2 = new Paint();
            this.startContainerPaint = paint2;
            Paint paint3 = new Paint();
            this.endContainerPaint = paint3;
            this.shadowPaint = new Paint();
            Paint paint4 = new Paint();
            this.scrimPaint = paint4;
            this.maskEvaluator = new MaskEvaluator();
            this.motionPathPosition = new float[]{rectF.centerX(), rectF.top};
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            this.compatShadowDrawable = materialShapeDrawable;
            Paint paint5 = new Paint();
            this.debugPaint = paint5;
            this.debugPath = new Path();
            this.startView = view;
            this.startBounds = rectF;
            this.startShapeAppearanceModel = shapeAppearanceModel;
            this.startElevation = f;
            this.endView = view2;
            this.endBounds = rectF2;
            this.endShapeAppearanceModel = shapeAppearanceModel2;
            this.endElevation = f2;
            this.entering = z;
            this.elevationShadowEnabled = z2;
            this.fadeModeEvaluator = fadeModeEvaluator;
            this.fitModeEvaluator = fitModeEvaluator;
            this.progressThresholds = progressThresholdsGroup;
            this.drawDebugEnabled = z3;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.displayWidth = displayMetrics.widthPixels;
            this.displayHeight = displayMetrics.heightPixels;
            paint.setColor(i);
            paint2.setColor(i2);
            paint3.setColor(i3);
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(0));
            materialShapeDrawable.setShadowCompatibilityMode();
            materialShapeDrawable.shadowBitmapDrawingEnable = false;
            materialShapeDrawable.setShadowColor(-7829368);
            RectF rectF3 = new RectF(rectF);
            this.currentStartBounds = rectF3;
            this.currentStartBoundsMasked = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.currentEndBounds = rectF4;
            this.currentEndBoundsMasked = new RectF(rectF4);
            PointF pointF = new PointF(rectF.centerX(), rectF.top);
            PointF pointF2 = new PointF(rectF2.centerX(), rectF2.top);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(pointF.x, pointF.y, pointF2.x, pointF2.y), false);
            this.motionPathMeasure = pathMeasure;
            this.motionPathLength = pathMeasure.getLength();
            paint4.setStyle(Paint.Style.FILL);
            RectF rectF5 = TransitionUtils.transformAlphaRectF;
            paint4.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i4, i4, Shader.TileMode.CLAMP));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            updateProgress(0.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            Paint paint = this.scrimPaint;
            if (paint.getAlpha() > 0) {
                canvas.drawRect(getBounds(), paint);
            }
            boolean z = this.drawDebugEnabled;
            int iSave = z ? canvas.save() : -1;
            boolean z2 = this.elevationShadowEnabled;
            MaskEvaluator maskEvaluator = this.maskEvaluator;
            if (z2 && this.currentElevation > 0.0f) {
                canvas.save();
                canvas.clipPath(maskEvaluator.path, Region.Op.DIFFERENCE);
                if (Build.VERSION.SDK_INT > 28) {
                    ShapeAppearanceModel shapeAppearanceModel = maskEvaluator.currentShapeAppearanceModel;
                    boolean zIsRoundRect = shapeAppearanceModel.isRoundRect(this.currentMaskBounds);
                    Paint paint2 = this.shadowPaint;
                    if (zIsRoundRect) {
                        float cornerSize = shapeAppearanceModel.topLeftCornerSize.getCornerSize(this.currentMaskBounds);
                        canvas.drawRoundRect(this.currentMaskBounds, cornerSize, cornerSize, paint2);
                    } else {
                        canvas.drawPath(maskEvaluator.path, paint2);
                    }
                } else {
                    RectF rectF = this.currentMaskBounds;
                    int i = (int) rectF.left;
                    int i2 = (int) rectF.top;
                    int i3 = (int) rectF.right;
                    int i4 = (int) rectF.bottom;
                    MaterialShapeDrawable materialShapeDrawable = this.compatShadowDrawable;
                    materialShapeDrawable.setBounds(i, i2, i3, i4);
                    materialShapeDrawable.setElevation(this.currentElevation);
                    materialShapeDrawable.setShadowVerticalOffset((int) this.currentElevationDy);
                    materialShapeDrawable.setShapeAppearanceModel(maskEvaluator.currentShapeAppearanceModel);
                    materialShapeDrawable.draw(canvas);
                }
                canvas.restore();
            }
            canvas.clipPath(maskEvaluator.path);
            maybeDrawContainerColor(canvas, this.containerPaint);
            if (this.fadeModeResult.endOnTop) {
                drawStartView(canvas);
                drawEndView(canvas);
            } else {
                drawEndView(canvas);
                drawStartView(canvas);
            }
            if (z) {
                canvas.restoreToCount(iSave);
                RectF rectF2 = this.currentStartBounds;
                PointF pointF = new PointF(rectF2.centerX(), rectF2.top);
                float f = this.progress;
                Paint paint3 = this.debugPaint;
                Path path = this.debugPath;
                if (f == 0.0f) {
                    path.reset();
                    path.moveTo(pointF.x, pointF.y);
                } else {
                    path.lineTo(pointF.x, pointF.y);
                    paint3.setColor(-65281);
                    canvas.drawPath(path, paint3);
                }
                paint3.setColor(-256);
                canvas.drawRect(this.currentStartBoundsMasked, paint3);
                paint3.setColor(-16711936);
                canvas.drawRect(rectF2, paint3);
                paint3.setColor(-16711681);
                canvas.drawRect(this.currentEndBoundsMasked, paint3);
                paint3.setColor(-16776961);
                canvas.drawRect(this.currentEndBounds, paint3);
            }
        }

        public final void drawEndView(Canvas canvas) {
            maybeDrawContainerColor(canvas, this.endContainerPaint);
            Rect bounds = getBounds();
            RectF rectF = this.currentEndBounds;
            TransitionUtils.transform(canvas, bounds, rectF.left, rectF.top, this.fitModeResult.endScale, this.fadeModeResult.endAlpha, new TransitionUtils.CanvasOperation() { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.TransitionDrawable.2
                @Override // com.google.android.material.transition.platform.TransitionUtils.CanvasOperation
                public final void run(Canvas canvas2) {
                    TransitionDrawable.this.endView.draw(canvas2);
                }
            });
        }

        public final void drawStartView(Canvas canvas) {
            maybeDrawContainerColor(canvas, this.startContainerPaint);
            Rect bounds = getBounds();
            RectF rectF = this.currentStartBounds;
            TransitionUtils.transform(canvas, bounds, rectF.left, rectF.top, this.fitModeResult.startScale, this.fadeModeResult.startAlpha, new TransitionUtils.CanvasOperation() { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.TransitionDrawable.1
                @Override // com.google.android.material.transition.platform.TransitionUtils.CanvasOperation
                public final void run(Canvas canvas2) {
                    TransitionDrawable.this.startView.draw(canvas2);
                }
            });
        }

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return -3;
        }

        public final void maybeDrawContainerColor(Canvas canvas, Paint paint) {
            if (paint.getColor() == 0 || paint.getAlpha() <= 0) {
                return;
            }
            canvas.drawRect(getBounds(), paint);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        public final void updateProgress(float f) {
            float fA;
            float f2;
            float f3;
            RectF rectF;
            float f4;
            this.progress = f;
            if (this.entering) {
                RectF rectF2 = TransitionUtils.transformAlphaRectF;
                fA = e.a(255.0f, 0.0f, f, 0.0f);
            } else {
                RectF rectF3 = TransitionUtils.transformAlphaRectF;
                fA = e.a(0.0f, 255.0f, f, 255.0f);
            }
            this.scrimPaint.setAlpha((int) fA);
            float f5 = this.motionPathLength;
            PathMeasure pathMeasure = this.motionPathMeasure;
            float[] fArr = this.motionPathPosition;
            pathMeasure.getPosTan(f5 * f, fArr, null);
            float fA2 = fArr[0];
            float fA3 = fArr[1];
            if (f > 1.0f || f < 0.0f) {
                if (f > 1.0f) {
                    f3 = (f - 1.0f) / 0.00999999f;
                    f2 = 0.99f;
                } else {
                    f2 = 0.01f;
                    f3 = (f / 0.01f) * (-1.0f);
                }
                pathMeasure.getPosTan(f5 * f2, fArr, null);
                float f6 = fArr[0];
                float f7 = fArr[1];
                fA2 = e.a(fA2, f6, f3, fA2);
                fA3 = e.a(fA3, f7, f3, fA3);
            }
            float f8 = fA3;
            float f9 = fA2;
            ProgressThresholdsGroup progressThresholdsGroup = this.progressThresholds;
            ProgressThresholds progressThresholds = progressThresholdsGroup.scale;
            float f10 = progressThresholds.start;
            float f11 = progressThresholds.end;
            RectF rectF4 = this.startBounds;
            float fWidth = rectF4.width();
            float fHeight = rectF4.height();
            RectF rectF5 = this.endBounds;
            FitModeResult fitModeResultEvaluate = this.fitModeEvaluator.evaluate(f, f10, f11, fWidth, fHeight, rectF5.width(), rectF5.height());
            this.fitModeResult = fitModeResultEvaluate;
            float f12 = fitModeResultEvaluate.currentStartWidth / 2.0f;
            float f13 = fitModeResultEvaluate.currentStartHeight + f8;
            RectF rectF6 = this.currentStartBounds;
            rectF6.set(f9 - f12, f8, f12 + f9, f13);
            FitModeResult fitModeResult = this.fitModeResult;
            float f14 = fitModeResult.currentEndWidth / 2.0f;
            float f15 = fitModeResult.currentEndHeight + f8;
            RectF rectF7 = this.currentEndBounds;
            rectF7.set(f9 - f14, f8, f14 + f9, f15);
            RectF rectF8 = this.currentStartBoundsMasked;
            rectF8.set(rectF6);
            RectF rectF9 = this.currentEndBoundsMasked;
            rectF9.set(rectF7);
            ProgressThresholds progressThresholds2 = progressThresholdsGroup.scaleMask;
            float f16 = progressThresholds2.start;
            float f17 = progressThresholds2.end;
            FitModeResult fitModeResult2 = this.fitModeResult;
            FitModeEvaluator fitModeEvaluator = this.fitModeEvaluator;
            boolean zShouldMaskStartBounds = fitModeEvaluator.shouldMaskStartBounds(fitModeResult2);
            RectF rectF10 = zShouldMaskStartBounds ? rectF8 : rectF9;
            float fLerp = TransitionUtils.lerp(0.0f, 1.0f, f16, f17, f, false);
            if (!zShouldMaskStartBounds) {
                fLerp = 1.0f - fLerp;
            }
            fitModeEvaluator.applyMask(rectF10, fLerp, this.fitModeResult);
            this.currentMaskBounds = new RectF(Math.min(rectF8.left, rectF9.left), Math.min(rectF8.top, rectF9.top), Math.max(rectF8.right, rectF9.right), Math.max(rectF8.bottom, rectF9.bottom));
            ProgressThresholds progressThresholds3 = progressThresholdsGroup.shapeMask;
            MaskEvaluator maskEvaluator = this.maskEvaluator;
            Path path = maskEvaluator.endPath;
            Path path2 = maskEvaluator.startPath;
            float f18 = progressThresholds3.start;
            float f19 = progressThresholds3.end;
            ShapeAppearanceModel shapeAppearanceModelBuild = this.startShapeAppearanceModel;
            if (f < f18) {
                f4 = f;
                rectF = rectF9;
            } else {
                ShapeAppearanceModel shapeAppearanceModel = this.endShapeAppearanceModel;
                if (f > f19) {
                    shapeAppearanceModelBuild = shapeAppearanceModel;
                    rectF = rectF9;
                    f4 = f;
                } else {
                    rectF = rectF9;
                    TransitionUtils.AnonymousClass2 anonymousClass2 = new TransitionUtils.CornerSizeBinaryOperator() { // from class: com.google.android.material.transition.platform.TransitionUtils.2
                        public final /* synthetic */ RectF val$endBounds;
                        public final /* synthetic */ float val$endFraction;
                        public final /* synthetic */ float val$fraction;
                        public final /* synthetic */ RectF val$startBounds;
                        public final /* synthetic */ float val$startFraction;

                        public AnonymousClass2() {
                            rectF = rectF6;
                            rectF = rectF;
                            f = f18;
                            f = f19;
                            f = f;
                        }

                        public final AbsoluteCornerSize apply(CornerSize cornerSize, CornerSize cornerSize2) {
                            return new AbsoluteCornerSize(TransitionUtils.lerp(cornerSize.getCornerSize(rectF), cornerSize2.getCornerSize(rectF), f, f, f, false));
                        }
                    };
                    f4 = f;
                    CornerSize cornerSize = shapeAppearanceModelBuild.topLeftCornerSize;
                    CornerSize cornerSize2 = shapeAppearanceModelBuild.bottomLeftCornerSize;
                    CornerSize cornerSize3 = shapeAppearanceModelBuild.bottomRightCornerSize;
                    CornerSize cornerSize4 = shapeAppearanceModelBuild.topRightCornerSize;
                    ShapeAppearanceModel shapeAppearanceModel2 = (cornerSize.getCornerSize(rectF6) == 0.0f && cornerSize4.getCornerSize(rectF6) == 0.0f && cornerSize3.getCornerSize(rectF6) == 0.0f && cornerSize2.getCornerSize(rectF6) == 0.0f) ? shapeAppearanceModel : shapeAppearanceModelBuild;
                    shapeAppearanceModel2.getClass();
                    ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(shapeAppearanceModel2);
                    builder.topLeftCornerSize = anonymousClass2.apply(shapeAppearanceModelBuild.topLeftCornerSize, shapeAppearanceModel.topLeftCornerSize);
                    builder.topRightCornerSize = anonymousClass2.apply(cornerSize4, shapeAppearanceModel.topRightCornerSize);
                    builder.bottomLeftCornerSize = anonymousClass2.apply(cornerSize2, shapeAppearanceModel.bottomLeftCornerSize);
                    builder.bottomRightCornerSize = anonymousClass2.apply(cornerSize3, shapeAppearanceModel.bottomRightCornerSize);
                    shapeAppearanceModelBuild = builder.build();
                }
            }
            maskEvaluator.currentShapeAppearanceModel = shapeAppearanceModelBuild;
            maskEvaluator.pathProvider.calculatePath(shapeAppearanceModelBuild, 1.0f, rectF8, null, path2);
            maskEvaluator.pathProvider.calculatePath(maskEvaluator.currentShapeAppearanceModel, 1.0f, rectF, null, path);
            maskEvaluator.path.op(path2, path, Path.Op.UNION);
            float f20 = this.startElevation;
            this.currentElevation = e.a(this.endElevation, f20, f4, f20);
            float fCenterX = ((this.currentMaskBounds.centerX() / (this.displayWidth / 2.0f)) - 1.0f) * 0.3f;
            float fCenterY = (this.currentMaskBounds.centerY() / this.displayHeight) * 1.5f;
            float f21 = this.currentElevation;
            float f22 = (int) (fCenterY * f21);
            this.currentElevationDy = f22;
            this.shadowPaint.setShadowLayer(f21, (int) (fCenterX * f21), f22, 754974720);
            ProgressThresholds progressThresholds4 = progressThresholdsGroup.fade;
            this.fadeModeResult = this.fadeModeEvaluator.evaluate(f4, progressThresholds4.start, progressThresholds4.end);
            Paint paint = this.startContainerPaint;
            if (paint.getColor() != 0) {
                paint.setAlpha(this.fadeModeResult.startAlpha);
            }
            Paint paint2 = this.endContainerPaint;
            if (paint2.getColor() != 0) {
                paint2.setAlpha(this.fadeModeResult.endAlpha);
            }
            invalidateSelf();
        }
    }

    static {
        DEFAULT_RETURN_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f));
        DEFAULT_RETURN_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f));
    }

    public MaterialContainerTransform() {
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = R.id.content;
        this.startViewId = -1;
        this.endViewId = -1;
        this.scrimColor = 1375731712;
        this.elevationShadowEnabled = Build.VERSION.SDK_INT >= 28;
        this.startElevation = -1.0f;
        this.endElevation = -1.0f;
    }

    public MaterialContainerTransform(Context context, boolean z) {
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = R.id.content;
        this.startViewId = -1;
        this.endViewId = -1;
        this.scrimColor = 1375731712;
        this.elevationShadowEnabled = Build.VERSION.SDK_INT >= 28;
        this.startElevation = -1.0f;
        this.endElevation = -1.0f;
        maybeApplyThemeValues(context, z);
        this.appliedThemeValues = true;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004f  */
    /* JADX WARN: Code duplicated, block: B:23:0x006b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0080  */
    /* JADX WARN: Code duplicated, block: B:27:0x0087  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b0  */
    /* JADX WARN: Multi-variable type inference failed */
    public static void captureValues(TransitionValues transitionValues, int i) {
        View viewFindViewById;
        View view;
        RectF locationOnScreen;
        Context context;
        int resourceId;
        ShapeAppearanceModel.Builder builder;
        ShapeAppearanceModel shapeAppearanceModel;
        if (i == -1) {
            if (transitionValues.view.getTag(org.hamotunnelplus.xyz.R.attr.rn) instanceof View) {
                viewFindViewById = (View) transitionValues.view.getTag(org.hamotunnelplus.xyz.R.attr.rn);
                transitionValues.view.setTag(org.hamotunnelplus.xyz.R.attr.rn, null);
            }
            view = transitionValues.view;
            WeakHashMap weakHashMap = qd1.a;
            if (view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
                return;
            }
            if (view.getParent() == null) {
                RectF rectF = TransitionUtils.transformAlphaRectF;
                locationOnScreen = new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                locationOnScreen = TransitionUtils.getLocationOnScreen(view);
            }
            transitionValues.values.put("materialContainerTransition:bounds", locationOnScreen);
            Map map = transitionValues.values;
            if (view.getTag(org.hamotunnelplus.xyz.R.attr.rn) instanceof ShapeAppearanceModel) {
                shapeAppearanceModel = (ShapeAppearanceModel) view.getTag(org.hamotunnelplus.xyz.R.attr.rn);
            } else {
                context = view.getContext();
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{org.hamotunnelplus.xyz.R.style.a6t});
                resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
                typedArrayObtainStyledAttributes.recycle();
                if (resourceId != -1) {
                    builder = ShapeAppearanceModel.builder(context, resourceId, 0);
                } else if (view instanceof Shapeable) {
                    shapeAppearanceModel = ((Shapeable) view).getShapeAppearanceModel();
                } else {
                    RelativeCornerSize relativeCornerSize = ShapeAppearanceModel.PILL;
                    builder = new ShapeAppearanceModel.Builder();
                }
                shapeAppearanceModel = builder.build();
            }
            map.put("materialContainerTransition:shapeAppearance", shapeAppearanceModel.withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.transition.platform.TransitionUtils.1
                public final /* synthetic */ RectF val$bounds;

                public AnonymousClass1() {
                    rectF = locationOnScreen;
                }

                @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
                public final CornerSize apply(CornerSize cornerSize) {
                    if (cornerSize instanceof RelativeCornerSize) {
                        return cornerSize;
                    }
                    RectF rectF2 = rectF;
                    return new RelativeCornerSize(cornerSize.getCornerSize(rectF2) / rectF2.height());
                }
            }));
        }
        View view2 = transitionValues.view;
        RectF rectF2 = TransitionUtils.transformAlphaRectF;
        viewFindViewById = view2.findViewById(i);
        if (viewFindViewById == null) {
            viewFindViewById = TransitionUtils.findAncestorById(view2, i);
        }
        transitionValues.view = viewFindViewById;
        view = transitionValues.view;
        WeakHashMap weakHashMap2 = qd1.a;
        if (view.isLaidOut()) {
        }
        if (view.getParent() == null) {
            RectF rectF3 = TransitionUtils.transformAlphaRectF;
            locationOnScreen = new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            locationOnScreen = TransitionUtils.getLocationOnScreen(view);
        }
        transitionValues.values.put("materialContainerTransition:bounds", locationOnScreen);
        Map map2 = transitionValues.values;
        if (view.getTag(org.hamotunnelplus.xyz.R.attr.rn) instanceof ShapeAppearanceModel) {
            shapeAppearanceModel = (ShapeAppearanceModel) view.getTag(org.hamotunnelplus.xyz.R.attr.rn);
        } else {
            context = view.getContext();
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(new int[]{org.hamotunnelplus.xyz.R.style.a6t});
            resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, -1);
            typedArrayObtainStyledAttributes2.recycle();
            if (resourceId != -1) {
                builder = ShapeAppearanceModel.builder(context, resourceId, 0);
            } else if (view instanceof Shapeable) {
                shapeAppearanceModel = ((Shapeable) view).getShapeAppearanceModel();
            } else {
                RelativeCornerSize relativeCornerSize2 = ShapeAppearanceModel.PILL;
                builder = new ShapeAppearanceModel.Builder();
            }
            shapeAppearanceModel = builder.build();
        }
        map2.put("materialContainerTransition:shapeAppearance", shapeAppearanceModel.withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.transition.platform.TransitionUtils.1
            public final /* synthetic */ RectF val$bounds;

            public AnonymousClass1() {
                rectF = locationOnScreen;
            }

            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            public final CornerSize apply(CornerSize cornerSize) {
                if (cornerSize instanceof RelativeCornerSize) {
                    return cornerSize;
                }
                RectF rectF4 = rectF;
                return new RelativeCornerSize(cornerSize.getCornerSize(rectF4) / rectF4.height());
            }
        }));
    }

    @Override // android.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues, this.endViewId);
    }

    @Override // android.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues, this.startViewId);
    }

    @Override // android.transition.Transition
    public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View viewFindAncestorById;
        RectF rectF;
        ProgressThresholdsGroup progressThresholdsGroup;
        ProgressThresholdsGroup progressThresholdsGroup2;
        View view = null;
        if (transitionValues != null && transitionValues2 != null) {
            RectF rectF2 = (RectF) transitionValues.values.get("materialContainerTransition:bounds");
            ShapeAppearanceModel shapeAppearanceModel = (ShapeAppearanceModel) transitionValues.values.get("materialContainerTransition:shapeAppearance");
            if (rectF2 != null && shapeAppearanceModel != null) {
                RectF rectF3 = (RectF) transitionValues2.values.get("materialContainerTransition:bounds");
                ShapeAppearanceModel shapeAppearanceModel2 = (ShapeAppearanceModel) transitionValues2.values.get("materialContainerTransition:shapeAppearance");
                if (rectF3 != null && shapeAppearanceModel2 != null) {
                    final View view2 = transitionValues.view;
                    final View view3 = transitionValues2.view;
                    View view4 = view3.getParent() != null ? view3 : view2;
                    int id = view4.getId();
                    int i = this.drawingViewId;
                    if (i == id) {
                        viewFindAncestorById = (View) view4.getParent();
                        view = view4;
                    } else {
                        viewFindAncestorById = TransitionUtils.findAncestorById(view4, i);
                    }
                    RectF locationOnScreen = TransitionUtils.getLocationOnScreen(viewFindAncestorById);
                    float f = -locationOnScreen.left;
                    float f2 = -locationOnScreen.top;
                    if (view != null) {
                        rectF = TransitionUtils.getLocationOnScreen(view);
                        rectF.offset(f, f2);
                    } else {
                        rectF = new RectF(0.0f, 0.0f, viewFindAncestorById.getWidth(), viewFindAncestorById.getHeight());
                    }
                    rectF2.offset(f, f2);
                    rectF3.offset(f, f2);
                    boolean z = rectF3.height() * rectF3.width() > rectF2.height() * rectF2.width();
                    if (!this.appliedThemeValues) {
                        maybeApplyThemeValues(view4.getContext(), z);
                    }
                    PathMotion pathMotion = getPathMotion();
                    float elevation = this.startElevation;
                    if (elevation == -1.0f) {
                        WeakHashMap weakHashMap = qd1.a;
                        elevation = view2.getElevation();
                    }
                    float f3 = elevation;
                    float elevation2 = this.endElevation;
                    if (elevation2 == -1.0f) {
                        WeakHashMap weakHashMap2 = qd1.a;
                        elevation2 = view3.getElevation();
                    }
                    float f4 = elevation2;
                    FadeModeEvaluator fadeModeEvaluator = z ? FadeModeEvaluators.IN : FadeModeEvaluators.OUT;
                    FitModeEvaluators.AnonymousClass1 anonymousClass1 = FitModeEvaluators.WIDTH;
                    FitModeEvaluators.AnonymousClass2 anonymousClass2 = FitModeEvaluators.HEIGHT;
                    float fWidth = rectF2.width();
                    float fHeight = rectF2.height();
                    float fWidth2 = rectF3.width();
                    float fHeight2 = rectF3.height();
                    FitModeEvaluator fitModeEvaluator = (!z ? (fWidth2 * fHeight) / fWidth >= fHeight2 : (fHeight2 * fWidth) / fWidth2 >= fHeight) ? anonymousClass2 : anonymousClass1;
                    PathMotion pathMotion2 = getPathMotion();
                    if ((pathMotion2 instanceof ArcMotion) || (pathMotion2 instanceof MaterialArcMotion)) {
                        progressThresholdsGroup = DEFAULT_ENTER_THRESHOLDS_ARC;
                        progressThresholdsGroup2 = DEFAULT_RETURN_THRESHOLDS_ARC;
                    } else {
                        progressThresholdsGroup = DEFAULT_ENTER_THRESHOLDS;
                        progressThresholdsGroup2 = DEFAULT_RETURN_THRESHOLDS;
                    }
                    if (!z) {
                        progressThresholdsGroup = progressThresholdsGroup2;
                    }
                    final View view5 = viewFindAncestorById;
                    final TransitionDrawable transitionDrawable = new TransitionDrawable(pathMotion, view2, rectF2, shapeAppearanceModel, f3, view3, rectF3, shapeAppearanceModel2, f4, 0, 0, 0, this.scrimColor, z, this.elevationShadowEnabled, fadeModeEvaluator, fitModeEvaluator, new ProgressThresholdsGroup(progressThresholdsGroup.fade, progressThresholdsGroup.scale, progressThresholdsGroup.scaleMask, progressThresholdsGroup.shapeMask), false);
                    transitionDrawable.setBounds(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float animatedFraction = valueAnimator.getAnimatedFraction();
                            TransitionDrawable transitionDrawable2 = transitionDrawable;
                            if (transitionDrawable2.progress != animatedFraction) {
                                transitionDrawable2.updateProgress(animatedFraction);
                            }
                        }
                    });
                    addListener(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.2
                        @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                        public final void onTransitionEnd(Transition transition) {
                            MaterialContainerTransform materialContainerTransform = MaterialContainerTransform.this;
                            materialContainerTransform.removeListener(this);
                            if (materialContainerTransform.holdAtEndEnabled) {
                                return;
                            }
                            view2.setAlpha(1.0f);
                            view3.setAlpha(1.0f);
                            ViewUtils.getOverlay(view5).remove(transitionDrawable);
                        }

                        @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                        public final void onTransitionStart(Transition transition) {
                            ViewUtils.getOverlay(view5).add(transitionDrawable);
                            view2.setAlpha(0.0f);
                            view3.setAlpha(0.0f);
                        }
                    });
                    return valueAnimatorOfFloat;
                }
            }
        }
        return null;
    }

    @Override // android.transition.Transition
    public final String[] getTransitionProperties() {
        return TRANSITION_PROPS;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0082  */
    public final void maybeApplyThemeValues(Context context, boolean z) {
        PathMotion patternPathMotion;
        int iResolveThemeDuration;
        vs vsVar = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        RectF rectF = TransitionUtils.transformAlphaRectF;
        if (getInterpolator() == null) {
            setInterpolator(MotionUtils.resolveThemeInterpolator(context, org.hamotunnelplus.xyz.R.style.uq, vsVar));
        }
        int i = z ? org.hamotunnelplus.xyz.R.style.ug : org.hamotunnelplus.xyz.R.style.uj;
        if (getDuration() == -1 && (iResolveThemeDuration = MotionUtils.resolveThemeDuration(context, i, -1)) != -1) {
            setDuration(iResolveThemeDuration);
        }
        if (this.pathMotionCustom) {
            return;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(org.hamotunnelplus.xyz.R.style.v0, typedValue, true)) {
            int i2 = typedValue.type;
            if (i2 == 16) {
                int i3 = typedValue.data;
                if (i3 == 0) {
                    patternPathMotion = null;
                } else {
                    if (i3 != 1) {
                        throw new IllegalArgumentException(ak.h(i3, "Invalid motion path type: "));
                    }
                    patternPathMotion = new MaterialArcMotion();
                }
            } else {
                if (i2 != 3) {
                    d.AnonymousClass0.m$2("Motion path theme attribute must either be an enum value or path data string");
                    return;
                }
                patternPathMotion = new PatternPathMotion(e4.d(String.valueOf(typedValue.string)));
            }
        } else {
            patternPathMotion = null;
        }
        if (patternPathMotion != null) {
            setPathMotion(patternPathMotion);
        }
    }

    @Override // android.transition.Transition
    public final void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.pathMotionCustom = true;
    }
}
