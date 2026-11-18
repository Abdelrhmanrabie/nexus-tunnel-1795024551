package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.trilead.ssh2.sftp.AttribFlags;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements Shapeable {
    public final Paint borderPaint;
    public final int bottomContentPadding;
    public final Paint clearPaint;
    public final RectF destination;
    public final int endContentPadding;
    public boolean hasAdjustedPaddingAfterLayoutDirectionResolved;
    public final int leftContentPadding;
    public final Path maskPath;
    public final RectF maskRect;
    public final Path path;
    public final ShapeAppearancePathProvider pathProvider;
    public final int rightContentPadding;
    public MaterialShapeDrawable shadowDrawable;
    public ShapeAppearanceModel shapeAppearanceModel;
    public final int startContentPadding;
    public final ColorStateList strokeColor;
    public final float strokeWidth;
    public final int topContentPadding;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class OutlineProvider extends ViewOutlineProvider {
        public final Rect rect = new Rect();

        public OutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View view, Outline outline) {
            ShapeableImageView shapeableImageView = ShapeableImageView.this;
            if (shapeableImageView.shapeAppearanceModel == null) {
                return;
            }
            if (shapeableImageView.shadowDrawable == null) {
                shapeableImageView.shadowDrawable = new MaterialShapeDrawable(shapeableImageView.shapeAppearanceModel);
            }
            RectF rectF = shapeableImageView.destination;
            Rect rect = this.rect;
            rectF.round(rect);
            shapeableImageView.shadowDrawable.setBounds(rect);
            shapeableImageView.shadowDrawable.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, R.plurals.a2r), attributeSet, i);
        this.pathProvider = ShapeAppearancePathProvider.getInstance();
        this.path = new Path();
        this.hasAdjustedPaddingAfterLayoutDirectionResolved = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.clearPaint = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.destination = new RectF();
        this.maskRect = new RectF();
        this.maskPath = new Path();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.ShapeableImageView, i, R.plurals.a2r);
        this.strokeColor = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 9);
        this.strokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.leftContentPadding = dimensionPixelSize;
        this.topContentPadding = dimensionPixelSize;
        this.rightContentPadding = dimensionPixelSize;
        this.bottomContentPadding = dimensionPixelSize;
        this.leftContentPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, dimensionPixelSize);
        this.topContentPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, dimensionPixelSize);
        this.rightContentPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
        this.bottomContentPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize);
        this.startContentPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
        this.endContentPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.borderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(context2, attributeSet, i, R.plurals.a2r).build();
        setOutlineProvider(new OutlineProvider());
    }

    public final int getContentPaddingLeft() {
        int i = this.endContentPadding;
        int i2 = this.startContentPadding;
        if (i2 != Integer.MIN_VALUE || i != Integer.MIN_VALUE) {
            if (isRtl() && i != Integer.MIN_VALUE) {
                return i;
            }
            if (!isRtl() && i2 != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.leftContentPadding;
    }

    public final int getContentPaddingRight() {
        int i = this.endContentPadding;
        int i2 = this.startContentPadding;
        if (i2 != Integer.MIN_VALUE || i != Integer.MIN_VALUE) {
            if (isRtl() && i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (!isRtl() && i != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.rightContentPadding;
    }

    @Override // android.view.View
    public final int getPaddingBottom() {
        return super.getPaddingBottom() - this.bottomContentPadding;
    }

    @Override // android.view.View
    public final int getPaddingEnd() {
        int paddingEnd = super.getPaddingEnd();
        int i = this.endContentPadding;
        if (i == Integer.MIN_VALUE) {
            i = isRtl() ? this.leftContentPadding : this.rightContentPadding;
        }
        return paddingEnd - i;
    }

    @Override // android.view.View
    public final int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public final int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public final int getPaddingStart() {
        int paddingStart = super.getPaddingStart();
        int i = this.startContentPadding;
        if (i == Integer.MIN_VALUE) {
            i = isRtl() ? this.rightContentPadding : this.leftContentPadding;
        }
        return paddingStart - i;
    }

    @Override // android.view.View
    public final int getPaddingTop() {
        return super.getPaddingTop() - this.topContentPadding;
    }

    @Override // com.google.android.material.shape.Shapeable
    public final ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    public final boolean isRtl() {
        return getLayoutDirection() == 1;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.maskPath, this.clearPaint);
        ColorStateList colorStateList = this.strokeColor;
        if (colorStateList == null) {
            return;
        }
        Paint paint = this.borderPaint;
        float f = this.strokeWidth;
        paint.setStrokeWidth(f);
        int colorForState = colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
        if (f <= 0.0f || colorForState == 0) {
            return;
        }
        paint.setColor(colorForState);
        canvas.drawPath(this.path, paint);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.hasAdjustedPaddingAfterLayoutDirectionResolved && isLayoutDirectionResolved()) {
            this.hasAdjustedPaddingAfterLayoutDirectionResolved = true;
            if (!isPaddingRelative() && this.startContentPadding == Integer.MIN_VALUE && this.endContentPadding == Integer.MIN_VALUE) {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            } else {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateShapeMask(i, i2);
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(getContentPaddingLeft() + i, this.topContentPadding + i2, getContentPaddingRight() + i3, this.bottomContentPadding + i4);
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i2, int i3, int i4) {
        int i5 = this.leftContentPadding;
        int i6 = this.rightContentPadding;
        int i7 = this.startContentPadding;
        if (i7 == Integer.MIN_VALUE) {
            i7 = isRtl() ? i6 : i5;
        }
        int i8 = i7 + i;
        int i9 = this.topContentPadding + i2;
        int i10 = this.endContentPadding;
        if (i10 != Integer.MIN_VALUE) {
            i5 = i10;
        } else if (!isRtl()) {
            i5 = i6;
        }
        super.setPaddingRelative(i8, i9, i5 + i3, this.bottomContentPadding + i4);
    }

    @Override // com.google.android.material.shape.Shapeable
    public final void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.shadowDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        updateShapeMask(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public final void updateShapeMask(int i, int i2) {
        float paddingLeft = getPaddingLeft();
        float paddingTop = getPaddingTop();
        float paddingRight = i - getPaddingRight();
        float paddingBottom = i2 - getPaddingBottom();
        RectF rectF = this.destination;
        rectF.set(paddingLeft, paddingTop, paddingRight, paddingBottom);
        ShapeAppearanceModel shapeAppearanceModel = this.shapeAppearanceModel;
        ShapeAppearancePathProvider shapeAppearancePathProvider = this.pathProvider;
        Path path = this.path;
        shapeAppearancePathProvider.calculatePath(shapeAppearanceModel, 1.0f, rectF, null, path);
        Path path2 = this.maskPath;
        path2.rewind();
        path2.addPath(path);
        RectF rectF2 = this.maskRect;
        rectF2.set(0.0f, 0.0f, i, i2);
        path2.addRect(rectF2, Path.Direction.CCW);
    }
}
