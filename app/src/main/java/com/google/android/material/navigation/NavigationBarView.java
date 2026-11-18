package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.d;
import defpackage.je;
import defpackage.l41;
import defpackage.m6;
import defpackage.qd1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavigationBarView extends FrameLayout {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final ColorStateList itemRippleColor;
    public final NavigationBarMenu menu;
    public final l41 menuInflater;
    public final NavigationBarMenuView menuView;
    public final NavigationBarPresenter presenter;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface LabelVisibility {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnItemReselectedListener {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnItemSelectedListener {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class SavedState extends d {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationBarView.SavedState.1
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public Bundle menuPresenterState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuPresenterState = parcel.readBundle(classLoader == null ? getClass().getClassLoader() : classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // defpackage.d, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.menuPresenterState);
        }
    }

    /* JADX WARN: Code duplicated, block: B:110:0x024a  */
    public NavigationBarView(Context context, AttributeSet attributeSet, int i, int i2) {
        Drawable drawable;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.presenter = navigationBarPresenter;
        Context context2 = getContext();
        m6 m6VarObtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.NavigationBarView, i, i2, 10, 9);
        NavigationBarMenu navigationBarMenu = new NavigationBarMenu(context2, getClass(), getMaxItemCount());
        this.menu = navigationBarMenu;
        NavigationBarMenuView navigationBarMenuViewCreateNavigationBarMenuView = createNavigationBarMenuView(context2);
        this.menuView = navigationBarMenuViewCreateNavigationBarMenuView;
        navigationBarPresenter.menuView = navigationBarMenuViewCreateNavigationBarMenuView;
        navigationBarPresenter.id = 1;
        navigationBarMenuViewCreateNavigationBarMenuView.presenter = navigationBarPresenter;
        navigationBarMenu.addMenuPresenter(navigationBarPresenter, navigationBarMenu.mContext);
        getContext();
        navigationBarPresenter.menuView.menu = navigationBarMenu;
        TypedArray typedArray = (TypedArray) m6VarObtainTintedStyledAttributes.a;
        ColorStateList colorStateListB = typedArray.hasValue(5) ? m6VarObtainTintedStyledAttributes.b(5) : navigationBarMenuViewCreateNavigationBarMenuView.createDefaultColorStateList();
        navigationBarMenuViewCreateNavigationBarMenuView.itemIconTint = colorStateListB;
        NavigationBarItemView[] navigationBarItemViewArr = navigationBarMenuViewCreateNavigationBarMenuView.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.iconTint = colorStateListB;
                if (navigationBarItemView.itemData != null && (drawable = navigationBarItemView.wrappedIconDrawable) != null) {
                    drawable.setTintList(colorStateListB);
                    navigationBarItemView.wrappedIconDrawable.invalidateSelf();
                }
            }
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(4, getResources().getDimensionPixelSize(org.hamotunnelplus.xyz.R.dimen.mq));
        NavigationBarMenuView navigationBarMenuView = this.menuView;
        navigationBarMenuView.itemIconSize = dimensionPixelSize;
        NavigationBarItemView[] navigationBarItemViewArr2 = navigationBarMenuView.buttons;
        if (navigationBarItemViewArr2 != null) {
            for (NavigationBarItemView navigationBarItemView2 : navigationBarItemViewArr2) {
                ImageView imageView = navigationBarItemView2.icon;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = dimensionPixelSize;
                imageView.setLayoutParams(layoutParams);
            }
        }
        if (typedArray.hasValue(10)) {
            int resourceId = typedArray.getResourceId(10, 0);
            NavigationBarMenuView navigationBarMenuView2 = this.menuView;
            navigationBarMenuView2.itemTextAppearanceInactive = resourceId;
            NavigationBarItemView[] navigationBarItemViewArr3 = navigationBarMenuView2.buttons;
            if (navigationBarItemViewArr3 != null) {
                for (NavigationBarItemView navigationBarItemView3 : navigationBarItemViewArr3) {
                    TextView textView = navigationBarItemView3.smallLabel;
                    textView.setTextAppearance(resourceId);
                    navigationBarItemView3.calculateTextScaleFactors(textView.getTextSize(), navigationBarItemView3.largeLabel.getTextSize());
                    ColorStateList colorStateList = navigationBarMenuView2.itemTextColorFromUser;
                    if (colorStateList != null) {
                        navigationBarItemView3.setTextColor(colorStateList);
                    }
                }
            }
        }
        if (typedArray.hasValue(9)) {
            int resourceId2 = typedArray.getResourceId(9, 0);
            NavigationBarMenuView navigationBarMenuView3 = this.menuView;
            navigationBarMenuView3.itemTextAppearanceActive = resourceId2;
            NavigationBarItemView[] navigationBarItemViewArr4 = navigationBarMenuView3.buttons;
            if (navigationBarItemViewArr4 != null) {
                for (NavigationBarItemView navigationBarItemView4 : navigationBarItemViewArr4) {
                    TextView textView2 = navigationBarItemView4.largeLabel;
                    textView2.setTextAppearance(resourceId2);
                    navigationBarItemView4.calculateTextScaleFactors(navigationBarItemView4.smallLabel.getTextSize(), textView2.getTextSize());
                    ColorStateList colorStateList2 = navigationBarMenuView3.itemTextColorFromUser;
                    if (colorStateList2 != null) {
                        navigationBarItemView4.setTextColor(colorStateList2);
                    }
                }
            }
        }
        if (typedArray.hasValue(11)) {
            ColorStateList colorStateListB2 = m6VarObtainTintedStyledAttributes.b(11);
            NavigationBarMenuView navigationBarMenuView4 = this.menuView;
            navigationBarMenuView4.itemTextColorFromUser = colorStateListB2;
            NavigationBarItemView[] navigationBarItemViewArr5 = navigationBarMenuView4.buttons;
            if (navigationBarItemViewArr5 != null) {
                for (NavigationBarItemView navigationBarItemView5 : navigationBarItemViewArr5) {
                    navigationBarItemView5.setTextColor(colorStateListB2);
                }
            }
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            Drawable background = getBackground();
            if (background instanceof ColorDrawable) {
                materialShapeDrawable.setFillColor(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            materialShapeDrawable.initializeElevationOverlay(context2);
            WeakHashMap weakHashMap = qd1.a;
            setBackground(materialShapeDrawable);
        }
        if (typedArray.hasValue(7)) {
            int dimensionPixelSize2 = typedArray.getDimensionPixelSize(7, 0);
            NavigationBarMenuView navigationBarMenuView5 = this.menuView;
            navigationBarMenuView5.itemPaddingTop = dimensionPixelSize2;
            NavigationBarItemView[] navigationBarItemViewArr6 = navigationBarMenuView5.buttons;
            if (navigationBarItemViewArr6 != null) {
                for (NavigationBarItemView navigationBarItemView6 : navigationBarItemViewArr6) {
                    if (navigationBarItemView6.itemPaddingTop != dimensionPixelSize2) {
                        navigationBarItemView6.itemPaddingTop = dimensionPixelSize2;
                        h hVar = navigationBarItemView6.itemData;
                        if (hVar != null) {
                            navigationBarItemView6.setChecked(hVar.isChecked());
                        }
                    }
                }
            }
        }
        if (typedArray.hasValue(6)) {
            int dimensionPixelSize3 = typedArray.getDimensionPixelSize(6, 0);
            NavigationBarMenuView navigationBarMenuView6 = this.menuView;
            navigationBarMenuView6.itemPaddingBottom = dimensionPixelSize3;
            NavigationBarItemView[] navigationBarItemViewArr7 = navigationBarMenuView6.buttons;
            if (navigationBarItemViewArr7 != null) {
                for (NavigationBarItemView navigationBarItemView7 : navigationBarItemViewArr7) {
                    if (navigationBarItemView7.itemPaddingBottom != dimensionPixelSize3) {
                        navigationBarItemView7.itemPaddingBottom = dimensionPixelSize3;
                        h hVar2 = navigationBarItemView7.itemData;
                        if (hVar2 != null) {
                            navigationBarItemView7.setChecked(hVar2.isChecked());
                        }
                    }
                }
            }
        }
        if (typedArray.hasValue(1)) {
            setElevation(typedArray.getDimensionPixelSize(1, 0));
        }
        getBackground().mutate().setTintList(MaterialResources.getColorStateList(context2, m6VarObtainTintedStyledAttributes, 0));
        int integer = typedArray.getInteger(12, -1);
        NavigationBarMenuView navigationBarMenuView7 = this.menuView;
        if (navigationBarMenuView7.labelVisibilityMode != integer) {
            navigationBarMenuView7.labelVisibilityMode = integer;
            this.presenter.updateMenuView(false);
        }
        int resourceId3 = typedArray.getResourceId(3, 0);
        if (resourceId3 != 0) {
            navigationBarMenuViewCreateNavigationBarMenuView.itemBackgroundRes = resourceId3;
            NavigationBarItemView[] navigationBarItemViewArr8 = navigationBarMenuViewCreateNavigationBarMenuView.buttons;
            if (navigationBarItemViewArr8 != null) {
                for (NavigationBarItemView navigationBarItemView8 : navigationBarItemViewArr8) {
                    navigationBarItemView8.setItemBackground(resourceId3 == 0 ? null : navigationBarItemView8.getContext().getDrawable(resourceId3));
                }
            }
        } else {
            ColorStateList colorStateList3 = MaterialResources.getColorStateList(context2, m6VarObtainTintedStyledAttributes, 8);
            NavigationBarMenuView navigationBarMenuView8 = this.menuView;
            if (this.itemRippleColor != colorStateList3) {
                this.itemRippleColor = colorStateList3;
                if (colorStateList3 == null) {
                    navigationBarMenuView8.setItemBackground(null);
                } else {
                    int colorForState = colorStateList3.getColorForState(RippleUtils.SELECTED_PRESSED_STATE_SET, colorStateList3.getDefaultColor());
                    int iC = je.c(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
                    int[][] iArr = {RippleUtils.SELECTED_STATE_SET, StateSet.NOTHING};
                    int colorForState2 = colorStateList3.getColorForState(RippleUtils.PRESSED_STATE_SET, colorStateList3.getDefaultColor());
                    navigationBarMenuView8.setItemBackground(new RippleDrawable(new ColorStateList(iArr, new int[]{iC, je.c(colorForState2, Math.min(Color.alpha(colorForState2) * 2, 255))}), null, null));
                }
            } else if (colorStateList3 == null) {
                NavigationBarItemView[] navigationBarItemViewArr9 = navigationBarMenuView8.buttons;
                if (((navigationBarItemViewArr9 == null || navigationBarItemViewArr9.length <= 0) ? navigationBarMenuView8.itemBackground : navigationBarItemViewArr9[0].getBackground()) != null) {
                    navigationBarMenuView8.setItemBackground(null);
                }
            }
        }
        int resourceId4 = typedArray.getResourceId(2, 0);
        if (resourceId4 != 0) {
            NavigationBarMenuView navigationBarMenuView9 = this.menuView;
            boolean z = true;
            navigationBarMenuView9.itemActiveIndicatorEnabled = true;
            NavigationBarItemView[] navigationBarItemViewArr10 = navigationBarMenuView9.buttons;
            if (navigationBarItemViewArr10 != null) {
                int length = navigationBarItemViewArr10.length;
                int i3 = 0;
                while (i3 < length) {
                    NavigationBarItemView navigationBarItemView9 = navigationBarItemViewArr10[i3];
                    navigationBarItemView9.activeIndicatorEnabled = z;
                    View view = navigationBarItemView9.activeIndicatorView;
                    if (view != null) {
                        view.setVisibility(0);
                        navigationBarItemView9.requestLayout();
                    }
                    i3++;
                    z = true;
                }
            }
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId4, R.styleable.NavigationBarActiveIndicator);
            int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
            NavigationBarMenuView navigationBarMenuView10 = this.menuView;
            navigationBarMenuView10.itemActiveIndicatorWidth = dimensionPixelSize4;
            NavigationBarItemView[] navigationBarItemViewArr11 = navigationBarMenuView10.buttons;
            if (navigationBarItemViewArr11 != null) {
                for (NavigationBarItemView navigationBarItemView10 : navigationBarItemViewArr11) {
                    navigationBarItemView10.activeIndicatorDesiredWidth = dimensionPixelSize4;
                    navigationBarItemView10.updateActiveIndicatorLayoutParams(navigationBarItemView10.getWidth());
                }
            }
            int dimensionPixelSize5 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            NavigationBarMenuView navigationBarMenuView11 = this.menuView;
            navigationBarMenuView11.itemActiveIndicatorHeight = dimensionPixelSize5;
            NavigationBarItemView[] navigationBarItemViewArr12 = navigationBarMenuView11.buttons;
            if (navigationBarItemViewArr12 != null) {
                for (NavigationBarItemView navigationBarItemView11 : navigationBarItemViewArr12) {
                    navigationBarItemView11.activeIndicatorDesiredHeight = dimensionPixelSize5;
                    navigationBarItemView11.updateActiveIndicatorLayoutParams(navigationBarItemView11.getWidth());
                }
            }
            int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0);
            NavigationBarMenuView navigationBarMenuView12 = this.menuView;
            navigationBarMenuView12.itemActiveIndicatorMarginHorizontal = dimensionPixelOffset;
            NavigationBarItemView[] navigationBarItemViewArr13 = navigationBarMenuView12.buttons;
            if (navigationBarItemViewArr13 != null) {
                for (NavigationBarItemView navigationBarItemView12 : navigationBarItemViewArr13) {
                    navigationBarItemView12.activeIndicatorMarginHorizontal = dimensionPixelOffset;
                    navigationBarItemView12.updateActiveIndicatorLayoutParams(navigationBarItemView12.getWidth());
                }
            }
            ColorStateList colorStateList4 = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 2);
            NavigationBarMenuView navigationBarMenuView13 = this.menuView;
            navigationBarMenuView13.itemActiveIndicatorColor = colorStateList4;
            NavigationBarItemView[] navigationBarItemViewArr14 = navigationBarMenuView13.buttons;
            if (navigationBarItemViewArr14 != null) {
                for (NavigationBarItemView navigationBarItemView13 : navigationBarItemViewArr14) {
                    MaterialShapeDrawable materialShapeDrawableCreateItemActiveIndicatorDrawable = navigationBarMenuView13.createItemActiveIndicatorDrawable();
                    View view2 = navigationBarItemView13.activeIndicatorView;
                    if (view2 != null) {
                        view2.setBackgroundDrawable(materialShapeDrawableCreateItemActiveIndicatorDrawable);
                    }
                }
            }
            ShapeAppearanceModel shapeAppearanceModelBuild = ShapeAppearanceModel.builder(context2, typedArrayObtainStyledAttributes.getResourceId(4, 0), 0).build();
            NavigationBarMenuView navigationBarMenuView14 = this.menuView;
            navigationBarMenuView14.itemActiveIndicatorShapeAppearance = shapeAppearanceModelBuild;
            NavigationBarItemView[] navigationBarItemViewArr15 = navigationBarMenuView14.buttons;
            if (navigationBarItemViewArr15 != null) {
                for (NavigationBarItemView navigationBarItemView14 : navigationBarItemViewArr15) {
                    MaterialShapeDrawable materialShapeDrawableCreateItemActiveIndicatorDrawable2 = navigationBarMenuView14.createItemActiveIndicatorDrawable();
                    View view3 = navigationBarItemView14.activeIndicatorView;
                    if (view3 != null) {
                        view3.setBackgroundDrawable(materialShapeDrawableCreateItemActiveIndicatorDrawable2);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (typedArray.hasValue(13)) {
            int resourceId5 = typedArray.getResourceId(13, 0);
            NavigationBarPresenter navigationBarPresenter2 = this.presenter;
            navigationBarPresenter2.updateSuspended = true;
            if (this.menuInflater == null) {
                this.menuInflater = new l41(getContext());
            }
            this.menuInflater.inflate(resourceId5, this.menu);
            navigationBarPresenter2.updateSuspended = false;
            navigationBarPresenter2.updateMenuView(true);
        }
        m6VarObtainTintedStyledAttributes.n();
        addView(navigationBarMenuViewCreateNavigationBarMenuView);
        navigationBarMenu.mCallback = new f.a() { // from class: com.google.android.material.navigation.NavigationBarView.1
            @Override // androidx.appcompat.view.menu.f.a
            public final boolean onMenuItemSelected(f fVar, MenuItem menuItem) {
                int i4 = NavigationBarView.$r8$clinit;
                NavigationBarView.this.getClass();
                return false;
            }

            @Override // androidx.appcompat.view.menu.f.a
            public final void onMenuModeChange(f fVar) {
            }
        };
    }

    public abstract NavigationBarMenuView createNavigationBarMenuView(Context context);

    public abstract int getMaxItemCount();

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        this.menu.restorePresenterStates(savedState.menuPresenterState);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuPresenterState = bundle;
        this.menu.savePresenterStates(bundle);
        return savedState;
    }

    @Override // android.view.View
    public final void setElevation(float f) {
        super.setElevation(f);
        MaterialShapeUtils.setElevation(this, f);
    }
}
