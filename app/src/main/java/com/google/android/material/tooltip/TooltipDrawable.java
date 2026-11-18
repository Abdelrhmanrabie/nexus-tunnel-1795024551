package com.google.android.material.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import defpackage.je;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableHelper.TextDrawableDelegate {
    public static final /* synthetic */ int $r8$clinit = 0;
    public int arrowSize;
    public final View.OnLayoutChangeListener attachedViewLayoutChangeListener;
    public final Context context;
    public final Rect displayFrame;
    public final Paint.FontMetrics fontMetrics;
    public float labelOpacity;
    public int layoutMargin;
    public int locationOnScreenX;
    public int minHeight;
    public int minWidth;
    public int padding;
    public CharSequence text;
    public final TextDrawableHelper textDrawableHelper;
    public float tooltipPivotY;
    public float tooltipScaleX;
    public float tooltipScaleY;

    private TooltipDrawable(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.fontMetrics = new Paint.FontMetrics();
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        this.attachedViewLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.google.android.material.tooltip.TooltipDrawable.1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                int i11 = TooltipDrawable.$r8$clinit;
                TooltipDrawable tooltipDrawable = TooltipDrawable.this;
                tooltipDrawable.getClass();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                tooltipDrawable.locationOnScreenX = iArr[0];
                view.getWindowVisibleDisplayFrame(tooltipDrawable.displayFrame);
            }
        };
        this.displayFrame = new Rect();
        this.tooltipScaleX = 1.0f;
        this.tooltipScaleY = 1.0f;
        this.tooltipPivotY = 0.5f;
        this.labelOpacity = 1.0f;
        this.context = context;
        float f = context.getResources().getDisplayMetrics().density;
        TextPaint textPaint = textDrawableHelper.textPaint;
        textPaint.density = f;
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    public static TooltipDrawable createFromAttributes(Context context, int i) {
        int resourceId;
        TooltipDrawable tooltipDrawable = new TooltipDrawable(context, null, 0, i);
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(tooltipDrawable.context, null, R.styleable.Tooltip, 0, i, new int[0]);
        Context context2 = tooltipDrawable.context;
        tooltipDrawable.arrowSize = context2.getResources().getDimensionPixelSize(org.hamotunnelplus.xyz.R.dimen.od);
        ShapeAppearanceModel shapeAppearanceModel = tooltipDrawable.getShapeAppearanceModel();
        shapeAppearanceModel.getClass();
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(shapeAppearanceModel);
        builder.bottomEdge = tooltipDrawable.createMarkerEdge();
        tooltipDrawable.setShapeAppearanceModel(builder.build());
        CharSequence text = typedArrayObtainStyledAttributes.getText(6);
        boolean zEquals = TextUtils.equals(tooltipDrawable.text, text);
        TextDrawableHelper textDrawableHelper = tooltipDrawable.textDrawableHelper;
        if (!zEquals) {
            tooltipDrawable.text = text;
            textDrawableHelper.textWidthDirty = true;
            tooltipDrawable.invalidateSelf();
        }
        TextAppearance textAppearance = (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? null : new TextAppearance(context2, resourceId);
        if (textAppearance != null && typedArrayObtainStyledAttributes.hasValue(1)) {
            textAppearance.textColor = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 1);
        }
        textDrawableHelper.setTextAppearance(textAppearance, context2);
        tooltipDrawable.setFillColor(ColorStateList.valueOf(typedArrayObtainStyledAttributes.getColor(7, je.b(je.c(MaterialAttributes.resolveOrThrow(context2, org.hamotunnelplus.xyz.R.style.g9, TooltipDrawable.class.getCanonicalName()), 153), je.c(MaterialAttributes.resolveOrThrow(context2, android.R.attr.colorBackground, TooltipDrawable.class.getCanonicalName()), 229)))));
        tooltipDrawable.setStrokeColor(ColorStateList.valueOf(MaterialAttributes.resolveOrThrow(context2, org.hamotunnelplus.xyz.R.style.gx, TooltipDrawable.class.getCanonicalName())));
        tooltipDrawable.padding = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        tooltipDrawable.minWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0);
        tooltipDrawable.minHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 0);
        tooltipDrawable.layoutMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0);
        typedArrayObtainStyledAttributes.recycle();
        return tooltipDrawable;
    }

    public final float calculatePointerOffset() {
        int i;
        Rect rect = this.displayFrame;
        if (((rect.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin < 0) {
            i = ((rect.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin;
        } else {
            if (((rect.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin <= 0) {
                return 0.0f;
            }
            i = ((rect.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin;
        }
        return i;
    }

    public final OffsetEdgeTreatment createMarkerEdge() {
        float f = -calculatePointerOffset();
        float fWidth = ((float) (((double) getBounds().width()) - (Math.sqrt(2.0d) * ((double) this.arrowSize)))) / 2.0f;
        return new OffsetEdgeTreatment(new MarkerEdgeTreatment(this.arrowSize), Math.min(Math.max(f, -fWidth), fWidth));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Canvas canvas2;
        canvas.save();
        float fCalculatePointerOffset = calculatePointerOffset();
        float f = (float) (-((Math.sqrt(2.0d) * ((double) this.arrowSize)) - ((double) this.arrowSize)));
        canvas.scale(this.tooltipScaleX, this.tooltipScaleY, (getBounds().width() * 0.5f) + getBounds().left, (getBounds().height() * this.tooltipPivotY) + getBounds().top);
        canvas.translate(fCalculatePointerOffset, f);
        super.draw(canvas);
        if (this.text == null) {
            canvas2 = canvas;
        } else {
            Rect bounds = getBounds();
            float fCenterY = bounds.centerY();
            TextDrawableHelper textDrawableHelper = this.textDrawableHelper;
            TextPaint textPaint = textDrawableHelper.textPaint;
            Paint.FontMetrics fontMetrics = this.fontMetrics;
            textPaint.getFontMetrics(fontMetrics);
            int i = (int) (fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f));
            if (textDrawableHelper.textAppearance != null) {
                textPaint.drawableState = getState();
                textDrawableHelper.textAppearance.updateDrawState(this.context, textDrawableHelper.textPaint, textDrawableHelper.fontCallback);
                textPaint.setAlpha((int) (this.labelOpacity * 255.0f));
            }
            CharSequence charSequence = this.text;
            canvas2 = canvas;
            canvas2.drawText(charSequence, 0, charSequence.length(), bounds.centerX(), i, textPaint);
        }
        canvas2.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) Math.max(this.textDrawableHelper.textPaint.getTextSize(), this.minHeight);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float f = this.padding * 2;
        CharSequence charSequence = this.text;
        return (int) Math.max(f + (charSequence == null ? 0.0f : this.textDrawableHelper.getTextWidth(charSequence.toString())), this.minWidth);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        ShapeAppearanceModel shapeAppearanceModel = getShapeAppearanceModel();
        shapeAppearanceModel.getClass();
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(shapeAppearanceModel);
        builder.bottomEdge = createMarkerEdge();
        setShapeAppearanceModel(builder.build());
    }
}
