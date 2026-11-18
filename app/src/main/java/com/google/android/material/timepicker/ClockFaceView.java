package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.google.android.material.resources.MaterialResources;
import defpackage.a1;
import defpackage.b2;
import defpackage.o1;
import defpackage.qd1;
import defpackage.qz;
import java.util.Arrays;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.OnRotateListener {
    public final int clockHandPadding;
    public final ClockHandView clockHandView;
    public final int clockSize;
    public float currentHandRotation;
    public final int[] gradientColors;
    public final float[] gradientPositions;
    public final int minimumHeight;
    public final int minimumWidth;
    public final RectF scratch;
    public final ColorStateList textColor;
    public final SparseArray textViewPool;
    public final Rect textViewRect;
    public final a1 valueAccessibilityDelegate;
    public String[] values;

    public ClockFaceView(Context context) {
        this(context, null);
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.th);
    }

    public ClockFaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.textViewRect = new Rect();
        this.scratch = new RectF();
        this.textViewPool = new SparseArray();
        this.gradientPositions = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.ClockFaceView, i, R.plurals.a3d);
        Resources resources = getResources();
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, 1);
        this.textColor = colorStateList;
        LayoutInflater.from(context).inflate(R.layout.d0, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.attr.q3);
        this.clockHandView = clockHandView;
        this.clockHandPadding = resources.getDimensionPixelSize(R.dimen.id);
        int colorForState = colorStateList.getColorForState(new int[]{android.R.attr.state_selected}, colorStateList.getDefaultColor());
        this.gradientColors = new int[]{colorForState, colorForState, colorStateList.getDefaultColor()};
        clockHandView.listeners.add(this);
        int defaultColor = b2.getColorStateList(context, R.color.os).getDefaultColor();
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, 0);
        setBackgroundColor(colorStateList2 != null ? colorStateList2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.timepicker.ClockFaceView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                ClockFaceView clockFaceView = ClockFaceView.this;
                if (clockFaceView.isShown()) {
                    clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
                    int height = ((clockFaceView.getHeight() / 2) - clockFaceView.clockHandView.selectorRadius) - clockFaceView.clockHandPadding;
                    if (height != clockFaceView.radius) {
                        clockFaceView.radius = height;
                        clockFaceView.updateLayoutParams();
                        ClockHandView clockHandView2 = clockFaceView.clockHandView;
                        clockHandView2.circleRadius = clockFaceView.radius;
                        clockHandView2.invalidate();
                    }
                }
                return true;
            }
        });
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.valueAccessibilityDelegate = new a1() { // from class: com.google.android.material.timepicker.ClockFaceView.2
            @Override // defpackage.a1
            public final void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
                AccessibilityNodeInfo accessibilityNodeInfo = o1Var.a;
                this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                int iIntValue = ((Integer) view.getTag(R.attr.qi)).intValue();
                if (iIntValue > 0) {
                    accessibilityNodeInfo.setTraversalAfter((View) ClockFaceView.this.textViewPool.get(iIntValue - 1));
                }
                accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) qz.a(view.isSelected(), 0, 1, iIntValue, 1).a);
            }
        };
        String[] strArr = new String[12];
        Arrays.fill(strArr, AppConfig.CUSTOM);
        setValues(strArr, 0);
        this.minimumHeight = resources.getDimensionPixelSize(R.dimen.j7);
        this.minimumWidth = resources.getDimensionPixelSize(R.dimen.j8);
        this.clockSize = resources.getDimensionPixelSize(R.dimen.ij);
    }

    public final void findIntersectingTextView() {
        RadialGradient radialGradient;
        RectF rectF = this.clockHandView.selectorBox;
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.textViewPool;
            if (i >= sparseArray.size()) {
                return;
            }
            TextView textView = (TextView) sparseArray.get(i);
            if (textView != null) {
                Rect rect = this.textViewRect;
                textView.getDrawingRect(rect);
                rect.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, rect);
                RectF rectF2 = this.scratch;
                rectF2.set(rect);
                if (RectF.intersects(rectF, rectF2)) {
                    radialGradient = new RadialGradient(rectF.centerX() - rectF2.left, rectF.centerY() - rectF2.top, 0.5f * rectF.width(), this.gradientColors, this.gradientPositions, Shader.TileMode.CLAMP);
                } else {
                    radialGradient = null;
                }
                textView.getPaint().setShader(radialGradient);
                textView.invalidate();
            }
            i++;
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) qz.a(1, this.values.length, 1).a);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        findIntersectingTextView();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = (int) (this.clockSize / Math.max(Math.max(this.minimumHeight / displayMetrics.heightPixels, this.minimumWidth / displayMetrics.widthPixels), 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
        setMeasuredDimension(iMax, iMax);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public final void onRotate(float f, boolean z) {
        if (Math.abs(this.currentHandRotation - f) > 0.001f) {
            this.currentHandRotation = f;
            findIntersectingTextView();
        }
    }

    public final void setValues(String[] strArr, int i) {
        this.values = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        SparseArray sparseArray = this.textViewPool;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < Math.max(this.values.length, size); i2++) {
            TextView textView = (TextView) sparseArray.get(i2);
            if (i2 >= this.values.length) {
                removeView(textView);
                sparseArray.remove(i2);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.cz, (ViewGroup) this, false);
                    sparseArray.put(i2, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.values[i2]);
                textView.setTag(R.attr.qi, Integer.valueOf(i2));
                qd1.l(textView, this.valueAccessibilityDelegate);
                textView.setTextColor(this.textColor);
                if (i != 0) {
                    textView.setContentDescription(getResources().getString(i, this.values[i2]));
                }
            }
        }
    }
}
