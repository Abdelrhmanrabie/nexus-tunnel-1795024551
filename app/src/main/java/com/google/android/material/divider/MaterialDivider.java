package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.qd1;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MaterialDivider extends View {
    public final int color;
    public final MaterialShapeDrawable dividerDrawable;
    public final int insetEnd;
    public final int insetStart;
    public final int thickness;

    public MaterialDivider(Context context) {
        this(context, null);
    }

    public MaterialDivider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.tk);
    }

    public MaterialDivider(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, R.plurals.a2f), attributeSet, i);
        Context context2 = getContext();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.dividerDrawable = materialShapeDrawable;
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.MaterialDivider, i, R.plurals.a2f, new int[0]);
        this.thickness = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, getResources().getDimensionPixelSize(R.dimen.in));
        this.insetStart = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0);
        this.insetEnd = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        int defaultColor = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 0).getDefaultColor();
        if (this.color != defaultColor) {
            this.color = defaultColor;
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(defaultColor));
            invalidate();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        WeakHashMap weakHashMap = qd1.a;
        boolean z = getLayoutDirection() == 1;
        int i = this.insetStart;
        int i2 = this.insetEnd;
        int i3 = z ? i2 : i;
        if (z) {
            width = getWidth();
        } else {
            width = getWidth();
            i = i2;
        }
        int i4 = width - i;
        int bottom = getBottom() - getTop();
        MaterialShapeDrawable materialShapeDrawable = this.dividerDrawable;
        materialShapeDrawable.setBounds(i3, 0, i4, bottom);
        materialShapeDrawable.draw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i3 = this.thickness;
            if (i3 > 0 && measuredHeight != i3) {
                measuredHeight = i3;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }
}
