package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import defpackage.qd1;
import java.util.HashMap;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class RadialViewGroup extends ConstraintLayout {
    public final MaterialShapeDrawable background;
    public int radius;
    public final Runnable updateLayoutParametersRunnable;

    public RadialViewGroup(Context context) {
        this(context, null);
    }

    public RadialViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RadialViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.d1, this);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.background = materialShapeDrawable;
        materialShapeDrawable.setCornerSize(new RelativeCornerSize(0.5f));
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(-1));
        WeakHashMap weakHashMap = qd1.a;
        setBackground(materialShapeDrawable);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.RadialViewGroup, i, 0);
        this.radius = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.updateLayoutParametersRunnable = new Runnable() { // from class: com.google.android.material.timepicker.RadialViewGroup.1
            @Override // java.lang.Runnable
            public final void run() {
                RadialViewGroup.this.updateLayoutParams();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            WeakHashMap weakHashMap = qd1.a;
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            Runnable runnable = this.updateLayoutParametersRunnable;
            handler.removeCallbacks(runnable);
            handler.post(runnable);
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        updateLayoutParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            Runnable runnable = this.updateLayoutParametersRunnable;
            handler.removeCallbacks(runnable);
            handler.post(runnable);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        this.background.setFillColor(ColorStateList.valueOf(i));
    }

    public final void updateLayoutParams() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            if ("skip".equals(getChildAt(i2).getTag())) {
                i++;
            }
        }
        b bVar = new b();
        bVar.e(this);
        float f = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getId() != R.attr.f8 && !"skip".equals(childAt.getTag())) {
                int id = childAt.getId();
                int i4 = this.radius;
                Integer numValueOf = Integer.valueOf(id);
                HashMap map = bVar.e;
                if (!map.containsKey(numValueOf)) {
                    map.put(Integer.valueOf(id), new b.a());
                }
                b.C0008b c0008b = ((b.a) map.get(Integer.valueOf(id))).e;
                c0008b.A = R.attr.f8;
                c0008b.B = i4;
                c0008b.C = f;
                f = (360.0f / (childCount - i)) + f;
            }
        }
        bVar.c(this);
        this.mConstraintSet = null;
        requestLayout();
    }
}
