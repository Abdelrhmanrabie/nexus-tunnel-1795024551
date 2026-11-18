package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.k;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import defpackage.b2;
import defpackage.ip0;
import defpackage.qd1;
import defpackage.qz;
import defpackage.u7;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements k {
    public static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    public static final int[] DISABLED_STATE_SET = {-16842910};
    public SparseArray badgeDrawables;
    public NavigationBarItemView[] buttons;
    public ColorStateList itemActiveIndicatorColor;
    public boolean itemActiveIndicatorEnabled;
    public int itemActiveIndicatorHeight;
    public int itemActiveIndicatorMarginHorizontal;
    public boolean itemActiveIndicatorResizeable;
    public ShapeAppearanceModel itemActiveIndicatorShapeAppearance;
    public int itemActiveIndicatorWidth;
    public Drawable itemBackground;
    public int itemBackgroundRes;
    public int itemIconSize;
    public ColorStateList itemIconTint;
    public int itemPaddingBottom;
    public int itemPaddingTop;
    public final ip0 itemPool;
    public int itemTextAppearanceActive;
    public int itemTextAppearanceInactive;
    public final ColorStateList itemTextColorDefault;
    public ColorStateList itemTextColorFromUser;
    public int labelVisibilityMode;
    public f menu;
    public final View.OnClickListener onClickListener;
    public final SparseArray onTouchListeners;
    public NavigationBarPresenter presenter;
    public int selectedItemId;
    public int selectedItemPosition;
    public final u7 set;

    public NavigationBarMenuView(Context context) {
        super(context);
        this.itemPool = new ip0(5);
        this.onTouchListeners = new SparseArray(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.badgeDrawables = new SparseArray(5);
        this.itemPaddingTop = -1;
        this.itemPaddingBottom = -1;
        this.itemActiveIndicatorResizeable = false;
        this.itemTextColorDefault = createDefaultColorStateList();
        u7 u7Var = new u7();
        this.set = u7Var;
        u7Var.f(0);
        u7Var.setDuration(MotionUtils.resolveThemeDuration(getContext(), org.hamotunnelplus.xyz.R.style.ug, getResources().getInteger(org.hamotunnelplus.xyz.R.integer.a3)));
        u7Var.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), org.hamotunnelplus.xyz.R.style.uq, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        u7Var.a(new TextScale());
        this.onClickListener = new View.OnClickListener() { // from class: com.google.android.material.navigation.NavigationBarMenuView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h hVar = ((NavigationBarItemView) view).itemData;
                NavigationBarMenuView navigationBarMenuView = NavigationBarMenuView.this;
                if (navigationBarMenuView.menu.performItemAction(hVar, navigationBarMenuView.presenter, 0)) {
                    return;
                }
                hVar.setChecked(true);
            }
        };
        WeakHashMap weakHashMap = qd1.a;
        setImportantForAccessibility(1);
    }

    public static boolean isShifting(int i, int i2) {
        if (i == -1) {
            return i2 > 3;
        }
        return i == 0;
    }

    public final void buildMenuView() {
        BadgeDrawable badgeDrawable;
        Drawable drawable;
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        ip0 ip0Var = this.itemPool;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    ip0Var.a(navigationBarItemView);
                    ImageView imageView = navigationBarItemView.icon;
                    if (navigationBarItemView.badgeDrawable != null) {
                        if (imageView != null) {
                            navigationBarItemView.setClipChildren(true);
                            navigationBarItemView.setClipToPadding(true);
                            BadgeDrawable badgeDrawable2 = navigationBarItemView.badgeDrawable;
                            if (badgeDrawable2 != null) {
                                WeakReference weakReference = badgeDrawable2.customBadgeParentRef;
                                if ((weakReference != null ? (FrameLayout) weakReference.get() : null) != null) {
                                    WeakReference weakReference2 = badgeDrawable2.customBadgeParentRef;
                                    (weakReference2 != null ? (FrameLayout) weakReference2.get() : null).setForeground(null);
                                } else {
                                    imageView.getOverlay().remove(badgeDrawable2);
                                }
                            }
                        }
                        navigationBarItemView.badgeDrawable = null;
                    }
                    navigationBarItemView.itemData = null;
                    navigationBarItemView.activeIndicatorProgress = 0.0f;
                    navigationBarItemView.initialized = false;
                }
            }
        }
        if (this.menu.mItems.size() == 0) {
            this.selectedItemId = 0;
            this.selectedItemPosition = 0;
            this.buttons = null;
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < this.menu.mItems.size(); i++) {
            hashSet.add(Integer.valueOf(this.menu.getItem(i).getItemId()));
        }
        for (int i2 = 0; i2 < this.badgeDrawables.size(); i2++) {
            int iKeyAt = this.badgeDrawables.keyAt(i2);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                this.badgeDrawables.delete(iKeyAt);
            }
        }
        this.buttons = new NavigationBarItemView[this.menu.mItems.size()];
        boolean zIsShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        for (int i3 = 0; i3 < this.menu.mItems.size(); i3++) {
            this.presenter.updateSuspended = true;
            this.menu.getItem(i3).setCheckable(true);
            this.presenter.updateSuspended = false;
            NavigationBarItemView navigationBarItemViewCreateNavigationBarItemView = (NavigationBarItemView) ip0Var.b();
            if (navigationBarItemViewCreateNavigationBarItemView == null) {
                navigationBarItemViewCreateNavigationBarItemView = createNavigationBarItemView(getContext());
            }
            View view = navigationBarItemViewCreateNavigationBarItemView.activeIndicatorView;
            TextView textView = navigationBarItemViewCreateNavigationBarItemView.largeLabel;
            TextView textView2 = navigationBarItemViewCreateNavigationBarItemView.smallLabel;
            View view2 = navigationBarItemViewCreateNavigationBarItemView.icon;
            this.buttons[i3] = navigationBarItemViewCreateNavigationBarItemView;
            ColorStateList colorStateList = this.itemIconTint;
            navigationBarItemViewCreateNavigationBarItemView.iconTint = colorStateList;
            if (navigationBarItemViewCreateNavigationBarItemView.itemData != null && (drawable = navigationBarItemViewCreateNavigationBarItemView.wrappedIconDrawable) != null) {
                drawable.setTintList(colorStateList);
                navigationBarItemViewCreateNavigationBarItemView.wrappedIconDrawable.invalidateSelf();
            }
            int i4 = this.itemIconSize;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i4;
            view2.setLayoutParams(layoutParams);
            navigationBarItemViewCreateNavigationBarItemView.setTextColor(this.itemTextColorDefault);
            textView2.setTextAppearance(this.itemTextAppearanceInactive);
            navigationBarItemViewCreateNavigationBarItemView.calculateTextScaleFactors(textView2.getTextSize(), textView.getTextSize());
            textView.setTextAppearance(this.itemTextAppearanceActive);
            navigationBarItemViewCreateNavigationBarItemView.calculateTextScaleFactors(textView2.getTextSize(), textView.getTextSize());
            navigationBarItemViewCreateNavigationBarItemView.setTextColor(this.itemTextColorFromUser);
            int i5 = this.itemPaddingTop;
            if (i5 != -1 && navigationBarItemViewCreateNavigationBarItemView.itemPaddingTop != i5) {
                navigationBarItemViewCreateNavigationBarItemView.itemPaddingTop = i5;
                h hVar = navigationBarItemViewCreateNavigationBarItemView.itemData;
                if (hVar != null) {
                    navigationBarItemViewCreateNavigationBarItemView.setChecked(hVar.isChecked());
                }
            }
            int i6 = this.itemPaddingBottom;
            if (i6 != -1 && navigationBarItemViewCreateNavigationBarItemView.itemPaddingBottom != i6) {
                navigationBarItemViewCreateNavigationBarItemView.itemPaddingBottom = i6;
                h hVar2 = navigationBarItemViewCreateNavigationBarItemView.itemData;
                if (hVar2 != null) {
                    navigationBarItemViewCreateNavigationBarItemView.setChecked(hVar2.isChecked());
                }
            }
            navigationBarItemViewCreateNavigationBarItemView.activeIndicatorDesiredWidth = this.itemActiveIndicatorWidth;
            navigationBarItemViewCreateNavigationBarItemView.updateActiveIndicatorLayoutParams(navigationBarItemViewCreateNavigationBarItemView.getWidth());
            navigationBarItemViewCreateNavigationBarItemView.activeIndicatorDesiredHeight = this.itemActiveIndicatorHeight;
            navigationBarItemViewCreateNavigationBarItemView.updateActiveIndicatorLayoutParams(navigationBarItemViewCreateNavigationBarItemView.getWidth());
            navigationBarItemViewCreateNavigationBarItemView.activeIndicatorMarginHorizontal = this.itemActiveIndicatorMarginHorizontal;
            navigationBarItemViewCreateNavigationBarItemView.updateActiveIndicatorLayoutParams(navigationBarItemViewCreateNavigationBarItemView.getWidth());
            MaterialShapeDrawable materialShapeDrawableCreateItemActiveIndicatorDrawable = createItemActiveIndicatorDrawable();
            if (view != null) {
                view.setBackgroundDrawable(materialShapeDrawableCreateItemActiveIndicatorDrawable);
            }
            navigationBarItemViewCreateNavigationBarItemView.activeIndicatorResizeable = this.itemActiveIndicatorResizeable;
            boolean z = this.itemActiveIndicatorEnabled;
            navigationBarItemViewCreateNavigationBarItemView.activeIndicatorEnabled = z;
            if (view != null) {
                view.setVisibility(z ? 0 : 8);
                navigationBarItemViewCreateNavigationBarItemView.requestLayout();
            }
            Drawable drawable2 = this.itemBackground;
            if (drawable2 == null) {
                int i7 = this.itemBackgroundRes;
                drawable2 = i7 == 0 ? null : navigationBarItemViewCreateNavigationBarItemView.getContext().getDrawable(i7);
            }
            navigationBarItemViewCreateNavigationBarItemView.setItemBackground(drawable2);
            if (navigationBarItemViewCreateNavigationBarItemView.isShifting != zIsShifting) {
                navigationBarItemViewCreateNavigationBarItemView.isShifting = zIsShifting;
                h hVar3 = navigationBarItemViewCreateNavigationBarItemView.itemData;
                if (hVar3 != null) {
                    navigationBarItemViewCreateNavigationBarItemView.setChecked(hVar3.isChecked());
                }
            }
            navigationBarItemViewCreateNavigationBarItemView.setLabelVisibilityMode(this.labelVisibilityMode);
            h hVar4 = (h) this.menu.getItem(i3);
            navigationBarItemViewCreateNavigationBarItemView.initialize(hVar4);
            int i8 = hVar4.a;
            navigationBarItemViewCreateNavigationBarItemView.setOnTouchListener((View.OnTouchListener) this.onTouchListeners.get(i8));
            navigationBarItemViewCreateNavigationBarItemView.setOnClickListener(this.onClickListener);
            int i9 = this.selectedItemId;
            if (i9 != 0 && i8 == i9) {
                this.selectedItemPosition = i3;
            }
            int id = navigationBarItemViewCreateNavigationBarItemView.getId();
            if (id != -1 && (badgeDrawable = (BadgeDrawable) this.badgeDrawables.get(id)) != null) {
                navigationBarItemViewCreateNavigationBarItemView.badgeDrawable = badgeDrawable;
                navigationBarItemViewCreateNavigationBarItemView.setClipChildren(false);
                navigationBarItemViewCreateNavigationBarItemView.setClipToPadding(false);
                BadgeDrawable badgeDrawable3 = navigationBarItemViewCreateNavigationBarItemView.badgeDrawable;
                Rect rect = new Rect();
                view2.getDrawingRect(rect);
                badgeDrawable3.setBounds(rect);
                badgeDrawable3.updateBadgeCoordinates(view2, null);
                WeakReference weakReference3 = badgeDrawable3.customBadgeParentRef;
                if ((weakReference3 != null ? (FrameLayout) weakReference3.get() : null) != null) {
                    WeakReference weakReference4 = badgeDrawable3.customBadgeParentRef;
                    (weakReference4 != null ? (FrameLayout) weakReference4.get() : null).setForeground(badgeDrawable3);
                } else {
                    view2.getOverlay().add(badgeDrawable3);
                }
            }
            addView(navigationBarItemViewCreateNavigationBarItemView);
        }
        int iMin = Math.min(this.menu.mItems.size() - 1, this.selectedItemPosition);
        this.selectedItemPosition = iMin;
        this.menu.getItem(iMin).setChecked(true);
    }

    public final ColorStateList createDefaultColorStateList() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.textColorSecondary, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = b2.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(org.hamotunnelplus.xyz.R.style.gn, typedValue, true)) {
            return null;
        }
        int i = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i, defaultColor});
    }

    public final MaterialShapeDrawable createItemActiveIndicatorDrawable() {
        if (this.itemActiveIndicatorShapeAppearance == null || this.itemActiveIndicatorColor == null) {
            return null;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.itemActiveIndicatorShapeAppearance);
        materialShapeDrawable.setFillColor(this.itemActiveIndicatorColor);
        return materialShapeDrawable;
    }

    public abstract NavigationBarItemView createNavigationBarItemView(Context context);

    @Override // androidx.appcompat.view.menu.k
    public final void initialize(f fVar) {
        this.menu = fVar;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) qz.a(1, this.menu.getVisibleItems().size(), 1).a);
    }

    public final void setItemBackground(Drawable drawable) {
        this.itemBackground = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }
}
