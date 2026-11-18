package com.github.jorgecastilloprz;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.github.jorgecastilloprz.library.R$styleable;
import com.github.jorgecastilloprz.progressarc.ProgressArcDrawable;
import com.github.jorgecastilloprz.progressarc.ProgressArcView;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class FABProgressCircle extends FrameLayout {
    public int arcColor;
    public int arcWidth;
    public int circleSize;
    public boolean roundedStroke;
    public boolean viewsAdded;

    public FABProgressCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public FABProgressCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    public final int getFabDimension() {
        Resources resources;
        int i;
        if (this.circleSize == 1) {
            resources = getResources();
            i = R.dimen.di;
        } else {
            resources = getResources();
            i = R.dimen.dh;
        }
        return resources.getDimensionPixelSize(i);
    }

    public final void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.FABProgressCircle, 0, 0);
            try {
                this.arcColor = typedArrayObtainStyledAttributes.getColor(0, getResources().getColor(R.color.d5));
                this.arcWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, getResources().getDimensionPixelSize(R.dimen.pa));
                typedArrayObtainStyledAttributes.getDrawable(3);
                this.circleSize = typedArrayObtainStyledAttributes.getInt(2, 1);
                this.roundedStroke = typedArrayObtainStyledAttributes.getBoolean(5, false);
                typedArrayObtainStyledAttributes.getBoolean(4, false);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() != 1) {
            throw new IllegalStateException(getResources().getString(R.string.bw));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.viewsAdded) {
            return;
        }
        setClipChildren(false);
        Context context = getContext();
        int i3 = this.arcColor;
        int i4 = this.arcWidth;
        boolean z = this.roundedStroke;
        ProgressArcView progressArcView = new ProgressArcView(context);
        progressArcView.setAlpha(0.0f);
        progressArcView.setIndeterminateDrawable(new ProgressArcDrawable(i4, i3, z));
        addView(progressArcView, new FrameLayout.LayoutParams(getFabDimension() + this.arcWidth, getFabDimension() + this.arcWidth, 17));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getChildAt(0).getLayoutParams();
        layoutParams.gravity = 17;
        if (getChildAt(0).getClass().getCanonicalName().startsWith("com.getbase")) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.dn);
        }
        this.viewsAdded = true;
    }
}
