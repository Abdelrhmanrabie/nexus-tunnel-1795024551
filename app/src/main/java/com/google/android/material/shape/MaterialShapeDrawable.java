package com.google.android.material.shape;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import defpackage.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Objects;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MaterialShapeDrawable extends Drawable implements Shapeable {
    public static final Paint clearPaint;
    public final BitSet containsIncompatibleShadowOp;
    public final ShapePath.ShadowCompatOperation[] cornerShadowOperation;
    public MaterialShapeDrawableState drawableState;
    public final ShapePath.ShadowCompatOperation[] edgeShadowOperation;
    public final Paint fillPaint;
    public final RectF insetRectF;
    public final Matrix matrix;
    public final Path path;
    public final RectF pathBounds;
    public boolean pathDirty;
    public final Path pathInsetByStroke;
    public final ShapeAppearancePathProvider pathProvider;
    public final ShapeAppearancePathProvider.PathListener pathShadowListener;
    public final RectF rectF;
    public final Region scratchRegion;
    public boolean shadowBitmapDrawingEnable;
    public final ShadowRenderer shadowRenderer;
    public final Paint strokePaint;
    public ShapeAppearanceModel strokeShapeAppearance;
    public PorterDuffColorFilter strokeTintFilter;
    public PorterDuffColorFilter tintFilter;
    public final Region transparentRegion;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class MaterialShapeDrawableState extends Drawable.ConstantState {
        public int alpha;
        public float elevation;
        public ElevationOverlayProvider elevationOverlayProvider;
        public ColorStateList fillColor;
        public float interpolation;
        public Rect padding;
        public Paint.Style paintStyle;
        public float parentAbsoluteElevation;
        public final float scale;
        public int shadowCompatMode;
        public int shadowCompatOffset;
        public int shadowCompatRadius;
        public int shadowCompatRotation;
        public ShapeAppearanceModel shapeAppearanceModel;
        public ColorStateList strokeColor;
        public float strokeWidth;
        public ColorStateList tintList;
        public PorterDuff.Mode tintMode;

        public MaterialShapeDrawableState(MaterialShapeDrawableState materialShapeDrawableState) {
            this.fillColor = null;
            this.strokeColor = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = materialShapeDrawableState.shapeAppearanceModel;
            this.elevationOverlayProvider = materialShapeDrawableState.elevationOverlayProvider;
            this.strokeWidth = materialShapeDrawableState.strokeWidth;
            this.fillColor = materialShapeDrawableState.fillColor;
            this.strokeColor = materialShapeDrawableState.strokeColor;
            this.tintMode = materialShapeDrawableState.tintMode;
            this.tintList = materialShapeDrawableState.tintList;
            this.alpha = materialShapeDrawableState.alpha;
            this.scale = materialShapeDrawableState.scale;
            this.shadowCompatOffset = materialShapeDrawableState.shadowCompatOffset;
            this.shadowCompatMode = materialShapeDrawableState.shadowCompatMode;
            this.interpolation = materialShapeDrawableState.interpolation;
            this.parentAbsoluteElevation = materialShapeDrawableState.parentAbsoluteElevation;
            this.elevation = materialShapeDrawableState.elevation;
            this.shadowCompatRadius = materialShapeDrawableState.shadowCompatRadius;
            this.shadowCompatRotation = materialShapeDrawableState.shadowCompatRotation;
            this.paintStyle = materialShapeDrawableState.paintStyle;
            if (materialShapeDrawableState.padding != null) {
                this.padding = new Rect(materialShapeDrawableState.padding);
            }
        }

        public MaterialShapeDrawableState(ShapeAppearanceModel shapeAppearanceModel, ElevationOverlayProvider elevationOverlayProvider) {
            this.fillColor = null;
            this.strokeColor = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.elevationOverlayProvider = elevationOverlayProvider;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
            materialShapeDrawable.pathDirty = true;
            return materialShapeDrawable;
        }
    }

    static {
        Paint paint = new Paint(1);
        clearPaint = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    public MaterialShapeDrawable(Context context, AttributeSet attributeSet, int i, int i2) {
        this(ShapeAppearanceModel.builder(context, attributeSet, i, i2).build());
    }

    private MaterialShapeDrawable(MaterialShapeDrawableState materialShapeDrawableState) {
        this.cornerShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.edgeShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint paint = new Paint(1);
        this.fillPaint = paint;
        Paint paint2 = new Paint(1);
        this.strokePaint = paint2;
        this.shadowRenderer = new ShadowRenderer();
        this.pathProvider = Looper.getMainLooper().getThread() == Thread.currentThread() ? ShapeAppearancePathProvider.Lazy.INSTANCE : new ShapeAppearancePathProvider();
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = materialShapeDrawableState;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new ShapeAppearancePathProvider.PathListener() { // from class: com.google.android.material.shape.MaterialShapeDrawable.1
            @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
            public final void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i) {
                MaterialShapeDrawable materialShapeDrawable = MaterialShapeDrawable.this;
                BitSet bitSet = materialShapeDrawable.containsIncompatibleShadowOp;
                shapePath.getClass();
                bitSet.set(i, false);
                ShapePath.ShadowCompatOperation[] shadowCompatOperationArr = materialShapeDrawable.cornerShadowOperation;
                shapePath.addConnectingShadowIfNecessary(shapePath.endShadowAngle);
                shadowCompatOperationArr[i] = new ShapePath.AnonymousClass1(shapePath, new ArrayList(shapePath.shadowCompatOperations), new Matrix(matrix));
            }

            @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
            public final void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i) {
                MaterialShapeDrawable materialShapeDrawable = MaterialShapeDrawable.this;
                shapePath.getClass();
                materialShapeDrawable.containsIncompatibleShadowOp.set(i + 4, false);
                ShapePath.ShadowCompatOperation[] shadowCompatOperationArr = materialShapeDrawable.edgeShadowOperation;
                shapePath.addConnectingShadowIfNecessary(shapePath.endShadowAngle);
                shadowCompatOperationArr[i] = new ShapePath.AnonymousClass1(shapePath, new ArrayList(shapePath.shadowCompatOperations), new Matrix(matrix));
            }
        };
    }

    public MaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        this(new MaterialShapeDrawableState(shapeAppearanceModel, null));
    }

    public MaterialShapeDrawable(ShapePathModel shapePathModel) {
        this((ShapeAppearanceModel) shapePathModel);
    }

    public final void calculatePath(RectF rectF, Path path) {
        calculatePathForSize(rectF, path);
        if (this.drawableState.scale != 1.0f) {
            Matrix matrix = this.matrix;
            matrix.reset();
            float f = this.drawableState.scale;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.pathBounds, true);
    }

    public final void calculatePathForSize(RectF rectF, Path path) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        this.pathProvider.calculatePath(materialShapeDrawableState.shapeAppearanceModel, materialShapeDrawableState.interpolation, rectF, this.pathShadowListener, path);
    }

    public final int compositeElevationOverlayIfNeeded(int i) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        float f = materialShapeDrawableState.parentAbsoluteElevation + materialShapeDrawableState.elevation + 0.0f;
        ElevationOverlayProvider elevationOverlayProvider = materialShapeDrawableState.elevationOverlayProvider;
        return elevationOverlayProvider != null ? elevationOverlayProvider.compositeOverlayIfNeeded(i, f) : i;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:26:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:27:0x00da  */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iWidth;
        PorterDuffColorFilter porterDuffColorFilter = this.tintFilter;
        Paint paint = this.fillPaint;
        paint.setColorFilter(porterDuffColorFilter);
        int alpha = paint.getAlpha();
        int i = this.drawableState.alpha;
        paint.setAlpha(((i + (i >>> 7)) * alpha) >>> 8);
        PorterDuffColorFilter porterDuffColorFilter2 = this.strokeTintFilter;
        Paint paint2 = this.strokePaint;
        paint2.setColorFilter(porterDuffColorFilter2);
        paint2.setStrokeWidth(this.drawableState.strokeWidth);
        int alpha2 = paint2.getAlpha();
        int i2 = this.drawableState.alpha;
        paint2.setAlpha(((i2 + (i2 >>> 7)) * alpha2) >>> 8);
        boolean z = this.pathDirty;
        Path path = this.path;
        if (z) {
            final float f = -(hasStroke() ? paint2.getStrokeWidth() / 2.0f : 0.0f);
            ShapeAppearanceModel shapeAppearanceModelWithTransformedCornerSizes = this.drawableState.shapeAppearanceModel.withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator(this) { // from class: com.google.android.material.shape.MaterialShapeDrawable.2
                @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
                public final CornerSize apply(CornerSize cornerSize) {
                    return cornerSize instanceof RelativeCornerSize ? cornerSize : new AdjustedCornerSize(f, cornerSize);
                }
            });
            this.strokeShapeAppearance = shapeAppearanceModelWithTransformedCornerSizes;
            float f2 = this.drawableState.interpolation;
            RectF boundsAsRectF$1 = getBoundsAsRectF$1();
            RectF rectF = this.insetRectF;
            rectF.set(boundsAsRectF$1);
            float strokeWidth = hasStroke() ? paint2.getStrokeWidth() / 2.0f : 0.0f;
            rectF.inset(strokeWidth, strokeWidth);
            this.pathProvider.calculatePath(shapeAppearanceModelWithTransformedCornerSizes, f2, rectF, null, this.pathInsetByStroke);
            calculatePath(getBoundsAsRectF$1(), path);
            this.pathDirty = false;
        }
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        int i3 = materialShapeDrawableState.shadowCompatMode;
        if (i3 != 1 && materialShapeDrawableState.shadowCompatRadius > 0) {
            if (i3 != 2) {
                int i4 = Build.VERSION.SDK_INT;
                if (!isRoundRect() && !path.isConvex() && i4 < 29) {
                    canvas.save();
                    MaterialShapeDrawableState materialShapeDrawableState2 = this.drawableState;
                    canvas.translate((int) (Math.sin(Math.toRadians(materialShapeDrawableState2.shadowCompatRotation)) * ((double) materialShapeDrawableState2.shadowCompatOffset)), getShadowOffsetY());
                    if (!this.shadowBitmapDrawingEnable) {
                        RectF rectF2 = this.pathBounds;
                        iWidth = (int) (rectF2.width() - getBounds().width());
                        int iHeight = (int) (rectF2.height() - getBounds().height());
                        if (iWidth >= 0 || iHeight < 0) {
                            d.AnonymousClass0.m("Invalid shadow bounds. Check that the treatments result in a valid path.");
                            return;
                        }
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.drawableState.shadowCompatRadius * 2) + ((int) rectF2.width()) + iWidth, (this.drawableState.shadowCompatRadius * 2) + ((int) rectF2.height()) + iHeight, Bitmap.Config.ARGB_8888);
                        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                        float f3 = (getBounds().left - this.drawableState.shadowCompatRadius) - iWidth;
                        float f4 = (getBounds().top - this.drawableState.shadowCompatRadius) - iHeight;
                        canvas2.translate(-f3, -f4);
                        drawCompatShadow(canvas2);
                        canvas.drawBitmap(bitmapCreateBitmap, f3, f4, (Paint) null);
                        bitmapCreateBitmap.recycle();
                    } else {
                        drawCompatShadow(canvas);
                    }
                    canvas.restore();
                }
            } else {
                canvas.save();
                MaterialShapeDrawableState materialShapeDrawableState3 = this.drawableState;
                canvas.translate((int) (Math.sin(Math.toRadians(materialShapeDrawableState3.shadowCompatRotation)) * ((double) materialShapeDrawableState3.shadowCompatOffset)), getShadowOffsetY());
                if (!this.shadowBitmapDrawingEnable) {
                    RectF rectF3 = this.pathBounds;
                    iWidth = (int) (rectF3.width() - getBounds().width());
                    int iHeight2 = (int) (rectF3.height() - getBounds().height());
                    if (iWidth >= 0) {
                    }
                    d.AnonymousClass0.m("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    return;
                }
                drawCompatShadow(canvas);
                canvas.restore();
            }
        }
        MaterialShapeDrawableState materialShapeDrawableState4 = this.drawableState;
        Paint.Style style = materialShapeDrawableState4.paintStyle;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            drawShape(canvas, paint, path, materialShapeDrawableState4.shapeAppearanceModel, getBoundsAsRectF$1());
        }
        if (hasStroke()) {
            drawStrokeShape(canvas);
        }
        paint.setAlpha(alpha);
        paint2.setAlpha(alpha2);
    }

    public final void drawCompatShadow(Canvas canvas) {
        this.containsIncompatibleShadowOp.cardinality();
        int i = this.drawableState.shadowCompatOffset;
        Path path = this.path;
        ShadowRenderer shadowRenderer = this.shadowRenderer;
        if (i != 0) {
            canvas.drawPath(path, shadowRenderer.shadowPaint);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            ShapePath.ShadowCompatOperation shadowCompatOperation = this.cornerShadowOperation[i2];
            int i3 = this.drawableState.shadowCompatRadius;
            Matrix matrix = ShapePath.ShadowCompatOperation.IDENTITY_MATRIX;
            shadowCompatOperation.draw(matrix, shadowRenderer, i3, canvas);
            this.edgeShadowOperation[i2].draw(matrix, shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
        }
        if (this.shadowBitmapDrawingEnable) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            int iSin = (int) (Math.sin(Math.toRadians(materialShapeDrawableState.shadowCompatRotation)) * ((double) materialShapeDrawableState.shadowCompatOffset));
            int shadowOffsetY = getShadowOffsetY();
            canvas.translate(-iSin, -shadowOffsetY);
            canvas.drawPath(path, clearPaint);
            canvas.translate(iSin, shadowOffsetY);
        }
    }

    public final void drawShape(Canvas canvas, Paint paint, Path path, RectF rectF) {
        drawShape(canvas, paint, path, this.drawableState.shapeAppearanceModel, rectF);
    }

    public final void drawShape(Canvas canvas, Paint paint, Path path, ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        if (!shapeAppearanceModel.isRoundRect(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float cornerSize = shapeAppearanceModel.topRightCornerSize.getCornerSize(rectF) * this.drawableState.interpolation;
            canvas.drawRoundRect(rectF, cornerSize, cornerSize, paint);
        }
    }

    public void drawStrokeShape(Canvas canvas) {
        ShapeAppearanceModel shapeAppearanceModel = this.strokeShapeAppearance;
        RectF boundsAsRectF$1 = getBoundsAsRectF$1();
        RectF rectF = this.insetRectF;
        rectF.set(boundsAsRectF$1);
        boolean zHasStroke = hasStroke();
        Paint paint = this.strokePaint;
        float strokeWidth = zHasStroke ? paint.getStrokeWidth() / 2.0f : 0.0f;
        rectF.inset(strokeWidth, strokeWidth);
        drawShape(canvas, paint, this.pathInsetByStroke, shapeAppearanceModel, rectF);
    }

    public final float getBottomLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(getBoundsAsRectF$1());
    }

    public final float getBottomRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(getBoundsAsRectF$1());
    }

    public final RectF getBoundsAsRectF$1() {
        Rect bounds = getBounds();
        RectF rectF = this.rectF;
        rectF.set(bounds);
        return rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public final float getElevation() {
        return this.drawableState.elevation;
    }

    public final ColorStateList getFillColor() {
        return this.drawableState.fillColor;
    }

    public final float getInterpolation() {
        return this.drawableState.interpolation;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.drawableState.shadowCompatMode == 2) {
            return;
        }
        if (isRoundRect()) {
            outline.setRoundRect(getBounds(), getTopLeftCornerResolvedSize() * this.drawableState.interpolation);
            return;
        }
        RectF boundsAsRectF$1 = getBoundsAsRectF$1();
        Path path = this.path;
        calculatePath(boundsAsRectF$1, path);
        if (path.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(path);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.drawableState.padding;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public final int getShadowOffsetY() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        return (int) (Math.cos(Math.toRadians(materialShapeDrawableState.shadowCompatRotation)) * ((double) materialShapeDrawableState.shadowCompatOffset));
    }

    public final int getShadowRadius() {
        return this.drawableState.shadowCompatRadius;
    }

    @Override // com.google.android.material.shape.Shapeable
    public final ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.shapeAppearanceModel;
    }

    public final float getTopLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.topLeftCornerSize.getCornerSize(getBoundsAsRectF$1());
    }

    public final float getTopRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.topRightCornerSize.getCornerSize(getBoundsAsRectF$1());
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.transparentRegion;
        region.set(bounds);
        RectF boundsAsRectF$1 = getBoundsAsRectF$1();
        Path path = this.path;
        calculatePath(boundsAsRectF$1, path);
        Region region2 = this.scratchRegion;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final boolean hasStroke() {
        Paint.Style style = this.drawableState.paintStyle;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.strokePaint.getStrokeWidth() > 0.0f;
    }

    public final void initializeElevationOverlay(Context context) {
        this.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context);
        updateZ();
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    public final boolean isRoundRect() {
        return this.drawableState.shapeAppearanceModel.isRoundRect(getBoundsAsRectF$1());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.drawableState.tintList;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.drawableState.getClass();
        ColorStateList colorStateList2 = this.drawableState.strokeColor;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.drawableState.fillColor;
        return colorStateList3 != null && colorStateList3.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.drawableState = new MaterialShapeDrawableState(this.drawableState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.pathDirty = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        boolean z = updateColorsForState(iArr) || updateTintFilter();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.alpha != i) {
            materialShapeDrawableState.alpha = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.drawableState.getClass();
        super.invalidateSelf();
    }

    public final void setCornerSize(float f) {
        ShapeAppearanceModel shapeAppearanceModel = this.drawableState.shapeAppearanceModel;
        shapeAppearanceModel.getClass();
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(shapeAppearanceModel);
        builder.setAllCornerSizes(f);
        setShapeAppearanceModel(builder.build());
    }

    public final void setCornerSize(RelativeCornerSize relativeCornerSize) {
        ShapeAppearanceModel shapeAppearanceModel = this.drawableState.shapeAppearanceModel;
        shapeAppearanceModel.getClass();
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(shapeAppearanceModel);
        builder.topLeftCornerSize = relativeCornerSize;
        builder.topRightCornerSize = relativeCornerSize;
        builder.bottomRightCornerSize = relativeCornerSize;
        builder.bottomLeftCornerSize = relativeCornerSize;
        setShapeAppearanceModel(builder.build());
    }

    public final void setElevation(float f) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.elevation != f) {
            materialShapeDrawableState.elevation = f;
            updateZ();
        }
    }

    public final void setFillColor(ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.fillColor != colorStateList) {
            materialShapeDrawableState.fillColor = colorStateList;
            onStateChange(getState());
        }
    }

    public final void setInterpolation(float f) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.interpolation != f) {
            materialShapeDrawableState.interpolation = f;
            this.pathDirty = true;
            invalidateSelf();
        }
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.padding == null) {
            materialShapeDrawableState.padding = new Rect();
        }
        this.drawableState.padding.set(0, i2, 0, i4);
        invalidateSelf();
    }

    public final void setPaintStyle(Paint.Style style) {
        this.drawableState.paintStyle = style;
        super.invalidateSelf();
    }

    public final void setShadowColor(int i) {
        this.shadowRenderer.setShadowColor(i);
        this.drawableState.getClass();
        super.invalidateSelf();
    }

    public final void setShadowCompatRotation(int i) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.shadowCompatRotation != i) {
            materialShapeDrawableState.shadowCompatRotation = i;
            super.invalidateSelf();
        }
    }

    public final void setShadowCompatibilityMode() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.shadowCompatMode != 2) {
            materialShapeDrawableState.shadowCompatMode = 2;
            super.invalidateSelf();
        }
    }

    public final void setShadowVerticalOffset(int i) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.shadowCompatOffset != i) {
            materialShapeDrawableState.shadowCompatOffset = i;
            super.invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public final void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.drawableState.shapeAppearanceModel = shapeAppearanceModel;
        invalidateSelf();
    }

    public final void setStrokeColor(ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.strokeColor != colorStateList) {
            materialShapeDrawableState.strokeColor = colorStateList;
            onStateChange(getState());
        }
    }

    public final void setStrokeWidth(float f) {
        this.drawableState.strokeWidth = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.drawableState.tintList = colorStateList;
        updateTintFilter();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.tintMode != mode) {
            materialShapeDrawableState.tintMode = mode;
            updateTintFilter();
            super.invalidateSelf();
        }
    }

    public final boolean updateColorsForState(int[] iArr) {
        boolean z;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.drawableState.fillColor == null || color2 == (colorForState2 = this.drawableState.fillColor.getColorForState(iArr, (color2 = (paint2 = this.fillPaint).getColor())))) {
            z = false;
        } else {
            paint2.setColor(colorForState2);
            z = true;
        }
        if (this.drawableState.strokeColor == null || color == (colorForState = this.drawableState.strokeColor.getColorForState(iArr, (color = (paint = this.strokePaint).getColor())))) {
            return z;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final boolean updateTintFilter() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.tintFilter;
        PorterDuffColorFilter porterDuffColorFilter3 = this.strokeTintFilter;
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        ColorStateList colorStateList = materialShapeDrawableState.tintList;
        PorterDuff.Mode mode = materialShapeDrawableState.tintMode;
        if (colorStateList == null || mode == null) {
            int color = this.fillPaint.getColor();
            int iCompositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(color);
            porterDuffColorFilter = iCompositeElevationOverlayIfNeeded != color ? new PorterDuffColorFilter(iCompositeElevationOverlayIfNeeded, PorterDuff.Mode.SRC_IN) : null;
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(compositeElevationOverlayIfNeeded(colorStateList.getColorForState(getState(), 0)), mode);
        }
        this.tintFilter = porterDuffColorFilter;
        this.drawableState.getClass();
        this.strokeTintFilter = null;
        this.drawableState.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.tintFilter) && Objects.equals(porterDuffColorFilter3, this.strokeTintFilter)) ? false : true;
    }

    public final void updateZ() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        float f = materialShapeDrawableState.elevation + 0.0f;
        materialShapeDrawableState.shadowCompatRadius = (int) Math.ceil(0.75f * f);
        this.drawableState.shadowCompatOffset = (int) Math.ceil(f * 0.25f);
        updateTintFilter();
        super.invalidateSelf();
    }
}
