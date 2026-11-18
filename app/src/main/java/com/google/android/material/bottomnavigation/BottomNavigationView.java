package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import defpackage.fg1;
import defpackage.m6;
import defpackage.qd1;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationView extends NavigationBarView {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnNavigationItemReselectedListener extends NavigationBarView.OnItemReselectedListener {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnNavigationItemSelectedListener extends NavigationBarView.OnItemSelectedListener {
    }

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.cp);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R.plurals.wf);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m6 m6VarObtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(getContext(), attributeSet, com.google.android.material.R.styleable.BottomNavigationView, i, i2, new int[0]);
        TypedArray typedArray = (TypedArray) m6VarObtainTintedStyledAttributes.a;
        boolean z = typedArray.getBoolean(1, true);
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) this.menuView;
        if (bottomNavigationMenuView.itemHorizontalTranslationEnabled != z) {
            bottomNavigationMenuView.itemHorizontalTranslationEnabled = z;
            this.presenter.updateMenuView(false);
        }
        if (typedArray.hasValue(0)) {
            setMinimumHeight(typedArray.getDimensionPixelSize(0, 0));
        }
        m6VarObtainTintedStyledAttributes.n();
        ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener(this) { // from class: com.google.android.material.bottomnavigation.BottomNavigationView.1
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public final fg1 onApplyWindowInsets(View view, fg1 fg1Var, ViewUtils.RelativePadding relativePadding) {
                relativePadding.bottom = fg1Var.a() + relativePadding.bottom;
                WeakHashMap weakHashMap = qd1.a;
                boolean z2 = view.getLayoutDirection() == 1;
                int iB = fg1Var.b();
                int iC = fg1Var.c();
                int i3 = relativePadding.start + (z2 ? iC : iB);
                relativePadding.start = i3;
                int i4 = relativePadding.end;
                if (!z2) {
                    iB = iC;
                }
                int i5 = i4 + iB;
                relativePadding.end = i5;
                view.setPaddingRelative(i3, relativePadding.top, i5, relativePadding.bottom);
                return fg1Var;
            }
        });
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public final NavigationBarMenuView createNavigationBarMenuView(Context context) {
        return new BottomNavigationMenuView(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public final int getMaxItemCount() {
        return 5;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i2) != 1073741824 && suggestedMinimumHeight > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), getPaddingBottom() + getPaddingTop() + suggestedMinimumHeight), 1073741824);
        }
        super.onMeasure(i, i2);
    }
}
