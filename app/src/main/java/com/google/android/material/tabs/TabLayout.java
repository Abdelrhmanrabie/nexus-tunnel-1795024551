package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.b2;
import defpackage.bj;
import defpackage.d;
import defpackage.e;
import defpackage.ee1;
import defpackage.gp0;
import defpackage.ip0;
import defpackage.je;
import defpackage.o1;
import defpackage.qd1;
import defpackage.qz;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {
    public static final ip0 tabPool = new ip0(16);
    public final boolean inlineLabel;
    public final int mode;
    public final int requestedTabMaxWidth;
    public final int requestedTabMinWidth;
    public ValueAnimator scrollAnimator;
    public final int scrollableTabMinWidth;
    public final ArrayList selectedListeners;
    public Tab selectedTab;
    public final SlidingTabIndicator slidingTabIndicator;
    public final int tabBackgroundResId;
    public int tabGravity;
    public final ColorStateList tabIconTint;
    public final PorterDuff.Mode tabIconTintMode;
    public final int tabIndicatorAnimationDuration;
    public final boolean tabIndicatorFullWidth;
    public final int tabIndicatorGravity;
    public final TabIndicatorInterpolator tabIndicatorInterpolator;
    public int tabMaxWidth;
    public final int tabPaddingBottom;
    public final int tabPaddingEnd;
    public final int tabPaddingStart;
    public final int tabPaddingTop;
    public final ColorStateList tabRippleColorStateList;
    public final Drawable tabSelectedIndicator;
    public final int tabSelectedIndicatorColor;
    public final int tabTextAppearance;
    public final ColorStateList tabTextColors;
    public final float tabTextMultiLineSize;
    public final float tabTextSize;
    public final gp0 tabViewPool;
    public final ArrayList tabs;
    public final boolean unboundedRipple;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class AdapterChangeListener {
        public AdapterChangeListener(TabLayout tabLayout) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void onTabSelected(Tab tab);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public @interface LabelVisibility {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class PagerAdapterObserver extends DataSetObserver {
        public PagerAdapterObserver() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            TabLayout.this.removeAllTabs();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            TabLayout.this.removeAllTabs();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class SlidingTabIndicator extends LinearLayout {
        public static final /* synthetic */ int $r8$clinit = 0;
        public ValueAnimator indicatorAnimator;
        public int selectedPosition;

        public SlidingTabIndicator(Context context) {
            super(context);
            this.selectedPosition = -1;
            setWillNotDraw(false);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0049  */
        /* JADX WARN: Code duplicated, block: B:21:0x005e  */
        /* JADX WARN: Code duplicated, block: B:22:0x0062  */
        @Override // android.view.View
        public final void draw(Canvas canvas) {
            int height;
            Drawable drawable;
            int i;
            TabLayout tabLayout = TabLayout.this;
            int iHeight = tabLayout.tabSelectedIndicator.getBounds().height();
            if (iHeight < 0) {
                iHeight = tabLayout.tabSelectedIndicator.getIntrinsicHeight();
            }
            int i2 = tabLayout.tabIndicatorGravity;
            if (i2 != 0) {
                if (i2 != 1) {
                    height = 0;
                    if (i2 != 2) {
                        if (i2 != 3) {
                            iHeight = 0;
                        }
                    }
                } else {
                    height = (getHeight() - iHeight) / 2;
                    iHeight = (getHeight() + iHeight) / 2;
                }
                if (tabLayout.tabSelectedIndicator.getBounds().width() > 0) {
                    Rect bounds = tabLayout.tabSelectedIndicator.getBounds();
                    tabLayout.tabSelectedIndicator.setBounds(bounds.left, height, bounds.right, iHeight);
                    drawable = tabLayout.tabSelectedIndicator;
                    i = tabLayout.tabSelectedIndicatorColor;
                    if (i != 0) {
                        drawable.setTint(i);
                    } else {
                        drawable.setTintList(null);
                    }
                    drawable.draw(canvas);
                }
                super.draw(canvas);
            }
            height = getHeight() - iHeight;
            iHeight = getHeight();
            if (tabLayout.tabSelectedIndicator.getBounds().width() > 0) {
                Rect bounds2 = tabLayout.tabSelectedIndicator.getBounds();
                tabLayout.tabSelectedIndicator.setBounds(bounds2.left, height, bounds2.right, iHeight);
                drawable = tabLayout.tabSelectedIndicator;
                i = tabLayout.tabSelectedIndicatorColor;
                if (i != 0) {
                    drawable.setTint(i);
                } else {
                    drawable.setTintList(null);
                }
                drawable.draw(canvas);
            }
            super.draw(canvas);
        }

        public final void jumpIndicatorToSelectedPosition() {
            View childAt = getChildAt(this.selectedPosition);
            TabLayout tabLayout = TabLayout.this;
            TabIndicatorInterpolator tabIndicatorInterpolator = tabLayout.tabIndicatorInterpolator;
            Drawable drawable = tabLayout.tabSelectedIndicator;
            tabIndicatorInterpolator.getClass();
            RectF rectFCalculateIndicatorWidthForTab = TabIndicatorInterpolator.calculateIndicatorWidthForTab(tabLayout, childAt);
            drawable.setBounds((int) rectFCalculateIndicatorWidthForTab.left, drawable.getBounds().top, (int) rectFCalculateIndicatorWidthForTab.right, drawable.getBounds().bottom);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                jumpIndicatorToSelectedPosition();
            } else {
                updateOrRecreateIndicatorAnimation(this.selectedPosition, -1, false);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                    boolean z2 = false;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    tabLayout.tabGravity = 0;
                    tabLayout.updateTabViews(false);
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        public final void tweenIndicatorPosition(View view, View view2, float f) {
            TabLayout tabLayout = TabLayout.this;
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = tabLayout.tabSelectedIndicator;
                drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout.tabSelectedIndicator.getBounds().bottom);
            } else {
                tabLayout.tabIndicatorInterpolator.setIndicatorBoundsForOffset(tabLayout, view, view2, f, tabLayout.tabSelectedIndicator);
            }
            WeakHashMap weakHashMap = qd1.a;
            postInvalidateOnAnimation();
        }

        public final void updateOrRecreateIndicatorAnimation(final int i, int i2, boolean z) {
            final View childAt = getChildAt(this.selectedPosition);
            final View childAt2 = getChildAt(i);
            if (childAt2 == null) {
                jumpIndicatorToSelectedPosition();
                return;
            }
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    int i3 = SlidingTabIndicator.$r8$clinit;
                    SlidingTabIndicator.this.tweenIndicatorPosition(childAt, childAt2, animatedFraction);
                }
            };
            if (!z) {
                this.indicatorAnimator.removeAllUpdateListeners();
                this.indicatorAnimator.addUpdateListener(animatorUpdateListener);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.indicatorAnimator = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            valueAnimator.setDuration(i2);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(animatorUpdateListener);
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    SlidingTabIndicator.this.selectedPosition = i;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    SlidingTabIndicator.this.selectedPosition = i;
                }
            });
            valueAnimator.start();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class Tab {
        public CharSequence contentDesc;
        public View customView;
        public Drawable icon;
        public TabLayout parent;
        public int position = -1;
        public CharSequence text;
        public TabView view;
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorAnimationMode {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorGravity {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class TabLayoutOnPageChangeListener {
        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            new WeakReference(tabLayout);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class TabView extends LinearLayout {
        public static final /* synthetic */ int $r8$clinit = 0;
        public final Drawable baseBackgroundDrawable;
        public TextView customTextView;
        public View customView;
        public int defaultMaxLines;
        public ImageView iconView;
        public Tab tab;
        public TextView textView;

        public TabView(Context context) {
            GradientDrawable gradientDrawable;
            super(context);
            this.defaultMaxLines = 2;
            int i = TabLayout.this.tabBackgroundResId;
            ColorStateList colorStateList = TabLayout.this.tabRippleColorStateList;
            Object obj = null;
            if (i != 0) {
                Drawable drawableS = e.s(context, i);
                this.baseBackgroundDrawable = drawableS;
                if (drawableS != null && drawableS.isStateful()) {
                    drawableS.setState(getDrawableState());
                }
            } else {
                this.baseBackgroundDrawable = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            Drawable rippleDrawable = gradientDrawable2;
            if (colorStateList != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                int colorForState = colorStateList.getColorForState(RippleUtils.SELECTED_PRESSED_STATE_SET, colorStateList.getDefaultColor());
                int iC = je.c(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
                int[][] iArr = {RippleUtils.SELECTED_STATE_SET, StateSet.NOTHING};
                int colorForState2 = colorStateList.getColorForState(RippleUtils.PRESSED_STATE_SET, colorStateList.getDefaultColor());
                ColorStateList colorStateList2 = new ColorStateList(iArr, new int[]{iC, je.c(colorForState2, Math.min(Color.alpha(colorForState2) * 2, 255))});
                boolean z = TabLayout.this.unboundedRipple;
                if (z) {
                    gradientDrawable = gradientDrawable2;
                    gradientDrawable = null;
                }
                rippleDrawable = new RippleDrawable(colorStateList2, gradientDrawable, z ? null : gradientDrawable3);
            }
            WeakHashMap weakHashMap = qd1.a;
            setBackground(rippleDrawable);
            TabLayout.this.invalidate();
            setPaddingRelative(TabLayout.this.tabPaddingStart, TabLayout.this.tabPaddingTop, TabLayout.this.tabPaddingEnd, TabLayout.this.tabPaddingBottom);
            setGravity(17);
            setOrientation(!TabLayout.this.inlineLabel ? 1 : 0);
            setClickable(true);
            Context context2 = getContext();
            int i2 = Build.VERSION.SDK_INT;
            int i3 = 15;
            bj bjVar = i2 >= 24 ? new bj(i3, PointerIcon.getSystemIcon(context2, 1002)) : new bj(i3, obj);
            if (i2 >= 24) {
                setPointerIcon((PointerIcon) bjVar.a);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.baseBackgroundDrawable;
            if ((drawable == null || !drawable.isStateful()) ? false : this.baseBackgroundDrawable.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) qz.a(isSelected(), 0, 1, this.tab.position, 1).a);
            if (isSelected()) {
                accessibilityNodeInfo.setClickable(false);
                accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) o1.a.g.a);
            }
            accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(R.string.fy));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            TabLayout tabLayout = TabLayout.this;
            int i3 = tabLayout.tabMaxWidth;
            if (i3 > 0 && (mode == 0 || size > i3)) {
                i = View.MeasureSpec.makeMeasureSpec(i3, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
            }
            super.onMeasure(i, i2);
            if (this.textView != null) {
                float f = tabLayout.tabTextSize;
                int i4 = this.defaultMaxLines;
                ImageView imageView = this.iconView;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.textView;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = tabLayout.tabTextMultiLineSize;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.textView.getTextSize();
                int lineCount = this.textView.getLineCount();
                int maxLines = this.textView.getMaxLines();
                if (f != textSize || (maxLines >= 0 && i4 != maxLines)) {
                    if (tabLayout.mode == 1 && f > textSize && lineCount == 1) {
                        Layout layout = this.textView.getLayout();
                        if (layout == null) {
                            return;
                        }
                        if ((f / layout.getPaint().getTextSize()) * layout.getLineWidth(0) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) {
                            return;
                        }
                    }
                    this.textView.setTextSize(0, f);
                    this.textView.setMaxLines(i4);
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.view.View
        public final boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.tab == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            Tab tab = this.tab;
            TabLayout tabLayout = tab.parent;
            if (tabLayout == null) {
                d.AnonymousClass0.m$2("Tab not attached to a TabLayout");
                return false;
            }
            ArrayList arrayList = tabLayout.selectedListeners;
            Tab tab2 = tabLayout.selectedTab;
            if (tab2 == tab) {
                if (tab2 == null) {
                    return true;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((BaseOnTabSelectedListener) arrayList.get(size)).getClass();
                }
                tabLayout.animateToTab(tab.position);
                return true;
            }
            int i = tab.position;
            if ((tab2 == null || tab2.position == -1) && i != -1) {
                tabLayout.setScrollPosition(i);
            } else {
                tabLayout.animateToTab(i);
            }
            if (i != -1) {
                tabLayout.setSelectedTabView(i);
            }
            tabLayout.selectedTab = tab;
            if (tab2 != null) {
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    ((BaseOnTabSelectedListener) arrayList.get(size2)).getClass();
                }
            }
            int size3 = arrayList.size() - 1;
            if (size3 < 0) {
                return true;
            }
            ((BaseOnTabSelectedListener) arrayList.get(size3)).onTabSelected(tab);
            throw null;
        }

        @Override // android.view.View
        public final void setSelected(boolean z) {
            isSelected();
            super.setSelected(z);
            TextView textView = this.textView;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.iconView;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.customView;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public final void update() {
            Tab tab = this.tab;
            ImageView imageView = null;
            View view = tab != null ? tab.customView : null;
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.customView = view;
                TextView textView = this.textView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView2 = this.iconView;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.iconView.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(android.R.id.text1);
                this.customTextView = textView2;
                if (textView2 != null) {
                    this.defaultMaxLines = textView2.getMaxLines();
                }
                imageView = (ImageView) view.findViewById(android.R.id.icon);
            } else {
                View view2 = this.customView;
                if (view2 != null) {
                    removeView(view2);
                    this.customView = null;
                }
                this.customTextView = null;
            }
            boolean z = false;
            if (this.customView == null) {
                if (this.iconView == null) {
                    ImageView imageView3 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.bf, (ViewGroup) this, false);
                    this.iconView = imageView3;
                    addView(imageView3, 0);
                }
                if (this.textView == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.bg, (ViewGroup) this, false);
                    this.textView = textView3;
                    addView(textView3);
                    this.defaultMaxLines = this.textView.getMaxLines();
                }
                TextView textView4 = this.textView;
                TabLayout tabLayout = TabLayout.this;
                textView4.setTextAppearance(tabLayout.tabTextAppearance);
                ColorStateList colorStateList = tabLayout.tabTextColors;
                if (colorStateList != null) {
                    this.textView.setTextColor(colorStateList);
                }
                updateTextAndIcon(this.textView, this.iconView);
                final ImageView imageView4 = this.iconView;
                if (imageView4 != null) {
                    imageView4.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                        @Override // android.view.View.OnLayoutChangeListener
                        public final void onLayoutChange(View view3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                            if (imageView4.getVisibility() == 0) {
                                int i9 = TabView.$r8$clinit;
                                TabView.this.getClass();
                            }
                        }
                    });
                }
                final TextView textView5 = this.textView;
                if (textView5 != null) {
                    textView5.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                        @Override // android.view.View.OnLayoutChangeListener
                        public final void onLayoutChange(View view3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                            if (textView5.getVisibility() == 0) {
                                int i9 = TabView.$r8$clinit;
                                TabView.this.getClass();
                            }
                        }
                    });
                }
            } else {
                TextView textView6 = this.customTextView;
                if (textView6 != null || imageView != null) {
                    updateTextAndIcon(textView6, imageView);
                }
            }
            if (tab != null && !TextUtils.isEmpty(tab.contentDesc)) {
                setContentDescription(tab.contentDesc);
            }
            if (tab != null) {
                TabLayout tabLayout2 = tab.parent;
                if (tabLayout2 == null) {
                    d.AnonymousClass0.m$2("Tab not attached to a TabLayout");
                    return;
                }
                Tab tab2 = tabLayout2.selectedTab;
                int i = tab2 != null ? tab2.position : -1;
                if (i != -1 && i == tab.position) {
                    z = true;
                }
            }
            setSelected(z);
        }

        public final void updateTextAndIcon(TextView textView, ImageView imageView) {
            Drawable drawable;
            Tab tab = this.tab;
            Drawable drawableMutate = (tab == null || (drawable = tab.icon) == null) ? null : drawable.mutate();
            TabLayout tabLayout = TabLayout.this;
            if (drawableMutate != null) {
                drawableMutate.setTintList(tabLayout.tabIconTint);
                PorterDuff.Mode mode = tabLayout.tabIconTintMode;
                if (mode != null) {
                    drawableMutate.setTintMode(mode);
                }
            }
            Tab tab2 = this.tab;
            CharSequence charSequence = tab2 != null ? tab2.text : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean zIsEmpty = TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (zIsEmpty) {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                } else {
                    textView.setText(charSequence);
                    this.tab.getClass();
                    textView.setVisibility(0);
                    setVisibility(0);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iDpToPx = (zIsEmpty || imageView.getVisibility() != 0) ? 0 : (int) ViewUtils.dpToPx(getContext(), 8);
                if (tabLayout.inlineLabel) {
                    if (iDpToPx != marginLayoutParams.getMarginEnd()) {
                        marginLayoutParams.setMarginEnd(iDpToPx);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iDpToPx != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iDpToPx;
                    marginLayoutParams.setMarginEnd(0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            Tab tab3 = this.tab;
            CharSequence charSequence2 = tab3 != null ? tab3.contentDesc : null;
            if (Build.VERSION.SDK_INT > 23) {
                if (zIsEmpty) {
                    charSequence = charSequence2;
                }
                b2.a(charSequence, this);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        public ViewPagerOnTabSelectedListener(ee1 ee1Var) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(Tab tab) {
            throw null;
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.a32);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0235, code lost:
    
        if (r12 != 2) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TabLayout(android.content.Context r12, android.util.AttributeSet r13, int r14) {
        /*
            Method dump skipped, instruction units count: 586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public final void addViewInternal(View view) {
        float f;
        if (!(view instanceof TabItem)) {
            d.AnonymousClass0.m$2("Only TabItem instances can be added to TabLayout");
            return;
        }
        TabItem tabItem = (TabItem) view;
        Tab tab = (Tab) tabPool.b();
        if (tab == null) {
            tab = new Tab();
        }
        tab.parent = this;
        gp0 gp0Var = this.tabViewPool;
        TabView tabView = gp0Var != null ? (TabView) gp0Var.b() : null;
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        if (tab != tabView.tab) {
            tabView.tab = tab;
            tabView.update();
        }
        tabView.setFocusable(true);
        int i = this.mode;
        int i2 = this.requestedTabMinWidth;
        if (i2 == -1) {
            i2 = (i == 0 || i == 2) ? this.scrollableTabMinWidth : 0;
        }
        tabView.setMinimumWidth(i2);
        tabView.setContentDescription(TextUtils.isEmpty(tab.contentDesc) ? tab.text : tab.contentDesc);
        tab.view = tabView;
        CharSequence charSequence = tabItem.text;
        if (charSequence != null) {
            if (TextUtils.isEmpty(tab.contentDesc) && !TextUtils.isEmpty(charSequence)) {
                tab.view.setContentDescription(charSequence);
            }
            tab.text = charSequence;
            TabView tabView2 = tab.view;
            if (tabView2 != null) {
                tabView2.update();
            }
        }
        Drawable drawable = tabItem.icon;
        if (drawable != null) {
            tab.icon = drawable;
            TabLayout tabLayout = tab.parent;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                tabLayout.updateTabViews(true);
            }
            TabView tabView3 = tab.view;
            if (tabView3 != null) {
                tabView3.update();
            }
        }
        int i3 = tabItem.customLayout;
        if (i3 != 0) {
            tab.customView = LayoutInflater.from(tab.view.getContext()).inflate(i3, (ViewGroup) tab.view, false);
            TabView tabView4 = tab.view;
            if (tabView4 != null) {
                tabView4.update();
            }
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            tab.contentDesc = tabItem.getContentDescription();
            TabView tabView5 = tab.view;
            if (tabView5 != null) {
                tabView5.update();
            }
        }
        ArrayList arrayList = this.tabs;
        boolean zIsEmpty = arrayList.isEmpty();
        int size = arrayList.size();
        if (tab.parent != this) {
            d.AnonymousClass0.m$2("Tab belongs to a different TabLayout.");
            return;
        }
        tab.position = size;
        arrayList.add(size, tab);
        int size2 = arrayList.size();
        while (true) {
            size++;
            if (size >= size2) {
                break;
            } else {
                ((Tab) arrayList.get(size)).position = size;
            }
        }
        TabView tabView6 = tab.view;
        tabView6.setSelected(false);
        tabView6.setActivated(false);
        int i4 = tab.position;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (i == 1 && this.tabGravity == 0) {
            layoutParams.width = 0;
            f = 1.0f;
        } else {
            layoutParams.width = -2;
            f = 0.0f;
        }
        layoutParams.weight = f;
        this.slidingTabIndicator.addView(tabView6, i4, layoutParams);
        if (zIsEmpty) {
            TabLayout tabLayout2 = tab.parent;
            if (tabLayout2 == null) {
                d.AnonymousClass0.m$2("Tab not attached to a TabLayout");
                return;
            }
            ArrayList arrayList2 = tabLayout2.selectedListeners;
            Tab tab2 = tabLayout2.selectedTab;
            if (tab2 == tab) {
                if (tab2 != null) {
                    for (int size3 = arrayList2.size() - 1; size3 >= 0; size3--) {
                        ((BaseOnTabSelectedListener) arrayList2.get(size3)).getClass();
                    }
                    tabLayout2.animateToTab(tab.position);
                    return;
                }
                return;
            }
            int i5 = tab.position;
            if ((tab2 == null || tab2.position == -1) && i5 != -1) {
                tabLayout2.setScrollPosition(i5);
            } else {
                tabLayout2.animateToTab(i5);
            }
            if (i5 != -1) {
                tabLayout2.setSelectedTabView(i5);
            }
            tabLayout2.selectedTab = tab;
            if (tab2 != null) {
                for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                    ((BaseOnTabSelectedListener) arrayList2.get(size4)).getClass();
                }
            }
            int size5 = arrayList2.size() - 1;
            if (size5 < 0) {
                return;
            }
            ((BaseOnTabSelectedListener) arrayList2.get(size5)).onTabSelected(tab);
            throw null;
        }
    }

    public final void animateToTab(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap = qd1.a;
            if (isLaidOut()) {
                SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
                int childCount = slidingTabIndicator.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (slidingTabIndicator.getChildAt(i2).getWidth() > 0) {
                    }
                }
                int scrollX = getScrollX();
                int iCalculateScrollXForTab = calculateScrollXForTab(i);
                int i3 = this.tabIndicatorAnimationDuration;
                if (scrollX != iCalculateScrollXForTab) {
                    if (this.scrollAnimator == null) {
                        ValueAnimator valueAnimator = new ValueAnimator();
                        this.scrollAnimator = valueAnimator;
                        valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                        this.scrollAnimator.setDuration(i3);
                        this.scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                                TabLayout.this.scrollTo(((Integer) valueAnimator2.getAnimatedValue()).intValue(), 0);
                            }
                        });
                    }
                    this.scrollAnimator.setIntValues(scrollX, iCalculateScrollXForTab);
                    this.scrollAnimator.start();
                }
                ValueAnimator valueAnimator2 = slidingTabIndicator.indicatorAnimator;
                if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                    slidingTabIndicator.indicatorAnimator.cancel();
                }
                slidingTabIndicator.updateOrRecreateIndicatorAnimation(i, i3, true);
                return;
            }
        }
        setScrollPosition(i);
    }

    public final int calculateScrollXForTab(int i) {
        SlidingTabIndicator slidingTabIndicator;
        View childAt;
        int i2 = this.mode;
        if ((i2 != 0 && i2 != 2) || (childAt = (slidingTabIndicator = this.slidingTabIndicator).getChildAt(i)) == null) {
            return 0;
        }
        int i3 = i + 1;
        View childAt2 = i3 < slidingTabIndicator.getChildCount() ? slidingTabIndicator.getChildAt(i3) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i4 = (int) ((width + width2) * 0.5f * 0.0f);
        WeakHashMap weakHashMap = qd1.a;
        return getLayoutDirection() == 0 ? left + i4 : left - i4;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        getParent();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        TabView tabView;
        Drawable drawable;
        int i = 0;
        while (true) {
            SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
            if (i >= slidingTabIndicator.getChildCount()) {
                super.onDraw(canvas);
                return;
            }
            View childAt = slidingTabIndicator.getChildAt(i);
            if ((childAt instanceof TabView) && (drawable = (tabView = (TabView) childAt).baseBackgroundDrawable) != null) {
                drawable.setBounds(tabView.getLeft(), tabView.getTop(), tabView.getRight(), tabView.getBottom());
                tabView.baseBackgroundDrawable.draw(canvas);
            }
            i++;
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) qz.a(1, this.tabs.size(), 1).a);
    }

    /* JADX WARN: Code duplicated, block: B:54:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        Context context = getContext();
        ArrayList arrayList = this.tabs;
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            if (i4 < size) {
                Tab tab = (Tab) arrayList.get(i4);
                if (tab != null && tab.icon != null && !TextUtils.isEmpty(tab.text)) {
                    if (!this.inlineLabel) {
                        i3 = 72;
                        break;
                    }
                } else {
                    i4++;
                }
            }
            i3 = 48;
            break;
        }
        int iRound = Math.round(ViewUtils.dpToPx(context, i3));
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + iRound, 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i2) >= iRound) {
            getChildAt(0).setMinimumHeight(iRound);
        }
        int size2 = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            int iDpToPx = this.requestedTabMaxWidth;
            if (iDpToPx <= 0) {
                iDpToPx = (int) (size2 - ViewUtils.dpToPx(getContext(), 56));
            }
            this.tabMaxWidth = iDpToPx;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i5 = this.mode;
            if (i5 == 0) {
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    return;
                }
            } else if (i5 != 1) {
                if (i5 != 2) {
                    return;
                }
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    return;
                }
            } else if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
        }
    }

    public final void removeAllTabs() {
        SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
        for (int childCount = slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
            TabView tabView = (TabView) slidingTabIndicator.getChildAt(childCount);
            slidingTabIndicator.removeViewAt(childCount);
            if (tabView != null) {
                if (tabView.tab != null) {
                    tabView.tab = null;
                    tabView.update();
                }
                tabView.setSelected(false);
                this.tabViewPool.a(tabView);
            }
            requestLayout();
        }
        Iterator it = this.tabs.iterator();
        while (it.hasNext()) {
            Tab tab = (Tab) it.next();
            it.remove();
            tab.parent = null;
            tab.view = null;
            tab.icon = null;
            tab.text = null;
            tab.contentDesc = null;
            tab.position = -1;
            tab.customView = null;
            tabPool.a(tab);
        }
        this.selectedTab = null;
    }

    @Override // android.view.View
    public final void setElevation(float f) {
        super.setElevation(f);
        MaterialShapeUtils.setElevation(this, f);
    }

    public final void setScrollPosition(int i) {
        int iRound = Math.round(i + 0.0f);
        if (iRound >= 0) {
            SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
            if (iRound >= slidingTabIndicator.getChildCount()) {
                return;
            }
            ValueAnimator valueAnimator = slidingTabIndicator.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                slidingTabIndicator.indicatorAnimator.cancel();
            }
            slidingTabIndicator.selectedPosition = i;
            slidingTabIndicator.tweenIndicatorPosition(slidingTabIndicator.getChildAt(i), slidingTabIndicator.getChildAt(slidingTabIndicator.selectedPosition + 1), 0.0f);
            ValueAnimator valueAnimator2 = this.scrollAnimator;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.scrollAnimator.cancel();
            }
            scrollTo(i < 0 ? 0 : calculateScrollXForTab(i), 0);
            setSelectedTabView(iRound);
        }
    }

    public final void setSelectedTabView(int i) {
        SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
        int childCount = slidingTabIndicator.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = slidingTabIndicator.getChildAt(i2);
                boolean z = true;
                childAt.setSelected(i2 == i);
                if (i2 != i) {
                    z = false;
                }
                childAt.setActivated(z);
                i2++;
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight()) > 0;
    }

    public final void updateTabViews(boolean z) {
        float f;
        int i = 0;
        while (true) {
            SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
            if (i >= slidingTabIndicator.getChildCount()) {
                return;
            }
            View childAt = slidingTabIndicator.getChildAt(i);
            int i2 = this.mode;
            int i3 = this.requestedTabMinWidth;
            if (i3 == -1) {
                i3 = (i2 == 0 || i2 == 2) ? this.scrollableTabMinWidth : 0;
            }
            childAt.setMinimumWidth(i3);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (i2 == 1 && this.tabGravity == 0) {
                layoutParams.width = 0;
                f = 1.0f;
            } else {
                layoutParams.width = -2;
                f = 0.0f;
            }
            layoutParams.weight = f;
            if (z) {
                childAt.requestLayout();
            }
            i++;
        }
    }
}
