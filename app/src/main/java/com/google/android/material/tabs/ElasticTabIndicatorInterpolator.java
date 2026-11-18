package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    @Override // com.google.android.material.tabs.TabIndicatorInterpolator
    public final void setIndicatorBoundsForOffset(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        float fCos;
        float fCos2;
        RectF rectFCalculateIndicatorWidthForTab = TabIndicatorInterpolator.calculateIndicatorWidthForTab(tabLayout, view);
        RectF rectFCalculateIndicatorWidthForTab2 = TabIndicatorInterpolator.calculateIndicatorWidthForTab(tabLayout, view2);
        if (rectFCalculateIndicatorWidthForTab.left < rectFCalculateIndicatorWidthForTab2.left) {
            double d = (((double) f) * 3.141592653589793d) / 2.0d;
            fCos2 = (float) (1.0d - Math.cos(d));
            fCos = (float) Math.sin(d);
        } else {
            double d2 = (((double) f) * 3.141592653589793d) / 2.0d;
            float fSin = (float) Math.sin(d2);
            fCos = (float) (1.0d - Math.cos(d2));
            fCos2 = fSin;
        }
        int i = (int) rectFCalculateIndicatorWidthForTab.left;
        int i2 = (int) rectFCalculateIndicatorWidthForTab2.left;
        DecelerateInterpolator decelerateInterpolator = AnimationUtils.DECELERATE_INTERPOLATOR;
        int iRound = Math.round(fCos2 * (i2 - i)) + i;
        int i3 = drawable.getBounds().top;
        int i4 = (int) rectFCalculateIndicatorWidthForTab.right;
        drawable.setBounds(iRound, i3, Math.round(fCos * (((int) rectFCalculateIndicatorWidthForTab2.right) - i4)) + i4, drawable.getBounds().bottom);
    }
}
