package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import defpackage.e;
import defpackage.e4;
import defpackage.mw0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {
    public static final int[] COLOR_BACKGROUND_ATTR = {R.attr.colorBackground};
    public final a mCardViewDelegate;
    public final boolean mCompatPadding;
    public final Rect mContentPadding;
    public final boolean mPreventCornerOverlap;
    public final Rect mShadowBounds;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a {
        public mw0 a;

        public a() {
        }

        public final void a(int i, int i2, int i3, int i4) {
            CardView cardView = CardView.this;
            cardView.mShadowBounds.set(i, i2, i3, i4);
            Rect rect = cardView.mContentPadding;
            CardView.super.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
        }
    }

    public CardView(Context context) {
        this(context, null);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, org.hamotunnelplus.xyz.R.style.do_res_0x7f0400a2);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        Resources resources;
        int i2;
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i);
        Rect rect = new Rect();
        this.mContentPadding = rect;
        this.mShadowBounds = new Rect();
        a aVar = new a();
        this.mCardViewDelegate = aVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f44l, i, org.hamotunnelplus.xyz.R.plurals.gy);
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i2 = org.hamotunnelplus.xyz.R.color.at;
            } else {
                resources = getResources();
                i2 = org.hamotunnelplus.xyz.R.color.as;
            }
            colorStateListValueOf = ColorStateList.valueOf(resources.getColor(i2));
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
        this.mCompatPadding = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.mPreventCornerOverlap = typedArrayObtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        mw0 mw0Var = new mw0(dimension, colorStateListValueOf);
        aVar.a = mw0Var;
        CardView cardView = CardView.this;
        cardView.setBackgroundDrawable(mw0Var);
        cardView.setClipToOutline(true);
        cardView.setElevation(dimension2);
        mw0 mw0Var2 = aVar.a;
        boolean z = cardView.mCompatPadding;
        boolean z2 = cardView.mPreventCornerOverlap;
        if (dimension3 != mw0Var2.e || mw0Var2.f != z || mw0Var2.g != z2) {
            mw0Var2.e = dimension3;
            mw0Var2.f = z;
            mw0Var2.g = z2;
            mw0Var2.c(null);
            mw0Var2.invalidateSelf();
        }
        e4.b(aVar);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i2, int i3, int i4) {
    }
}
