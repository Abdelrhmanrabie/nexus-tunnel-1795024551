package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.f;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.b2;
import defpackage.d;
import defpackage.fg1;
import defpackage.l41;
import defpackage.m6;
import defpackage.qd1;
import java.util.WeakHashMap;
import renz.javacodez.vpn.activities.e;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    public static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    public static final int[] DISABLED_STATE_SET = {-16842910};
    public final boolean bottomInsetScrimEnabled;
    public final int drawerLayoutCornerSize;
    public final int layoutGravity;
    public e listener;
    public final int maxWidth;
    public final NavigationMenu menu;
    public final l41 menuInflater;
    public final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    public final NavigationMenuPresenter presenter;
    public final RectF shapeClipBounds;
    public Path shapeClipPath;
    public final int[] tmpLocation;
    public final boolean topInsetScrimEnabled;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem menuItem);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class SavedState extends d {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationView.SavedState.1
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
        public Bundle menuState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // defpackage.d, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.menuState);
        }
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, org.hamotunnelplus.xyz.R.style.ve);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        int dimensionPixelSize;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, org.hamotunnelplus.xyz.R.plurals.wj), attributeSet, i);
        NavigationMenuPresenter navigationMenuPresenter = new NavigationMenuPresenter();
        this.presenter = navigationMenuPresenter;
        this.tmpLocation = new int[2];
        this.topInsetScrimEnabled = true;
        this.bottomInsetScrimEnabled = true;
        this.layoutGravity = 0;
        this.drawerLayoutCornerSize = 0;
        this.shapeClipBounds = new RectF();
        Context context2 = getContext();
        NavigationMenu navigationMenu = new NavigationMenu(context2);
        this.menu = navigationMenu;
        m6 m6VarObtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.NavigationView, i, org.hamotunnelplus.xyz.R.plurals.wj, new int[0]);
        TypedArray typedArray = (TypedArray) m6VarObtainTintedStyledAttributes.a;
        if (typedArray.hasValue(1)) {
            Drawable drawableE = m6VarObtainTintedStyledAttributes.e(1);
            WeakHashMap weakHashMap = qd1.a;
            setBackground(drawableE);
        }
        this.drawerLayoutCornerSize = typedArray.getDimensionPixelSize(7, 0);
        this.layoutGravity = typedArray.getInt(0, 0);
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            ShapeAppearanceModel shapeAppearanceModelBuild = ShapeAppearanceModel.builder(context2, attributeSet, i, org.hamotunnelplus.xyz.R.plurals.wj).build();
            Drawable background = getBackground();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModelBuild);
            if (background instanceof ColorDrawable) {
                materialShapeDrawable.setFillColor(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            materialShapeDrawable.initializeElevationOverlay(context2);
            WeakHashMap weakHashMap2 = qd1.a;
            setBackground(materialShapeDrawable);
        }
        if (typedArray.hasValue(8)) {
            setElevation(typedArray.getDimensionPixelSize(8, 0));
        }
        setFitsSystemWindows(typedArray.getBoolean(2, false));
        this.maxWidth = typedArray.getDimensionPixelSize(3, 0);
        ColorStateList colorStateListB = typedArray.hasValue(29) ? m6VarObtainTintedStyledAttributes.b(29) : null;
        int resourceId = typedArray.hasValue(32) ? typedArray.getResourceId(32, 0) : 0;
        if (resourceId == 0 && colorStateListB == null) {
            colorStateListB = createDefaultColorStateList(R.attr.textColorSecondary);
        }
        ColorStateList colorStateListB2 = typedArray.hasValue(14) ? m6VarObtainTintedStyledAttributes.b(14) : createDefaultColorStateList(R.attr.textColorSecondary);
        int resourceId2 = typedArray.hasValue(23) ? typedArray.getResourceId(23, 0) : 0;
        if (typedArray.hasValue(13) && navigationMenuPresenter.itemIconSize != (dimensionPixelSize = typedArray.getDimensionPixelSize(13, 0))) {
            navigationMenuPresenter.itemIconSize = dimensionPixelSize;
            navigationMenuPresenter.hasCustomItemIconSize = true;
            navigationMenuPresenter.updateMenuView(false);
        }
        ColorStateList colorStateListB3 = typedArray.hasValue(24) ? m6VarObtainTintedStyledAttributes.b(24) : null;
        if (resourceId2 == 0 && colorStateListB3 == null) {
            colorStateListB3 = createDefaultColorStateList(R.attr.textColorPrimary);
        }
        Drawable drawableE2 = m6VarObtainTintedStyledAttributes.e(10);
        if (drawableE2 == null && (typedArray.hasValue(16) || typedArray.hasValue(17))) {
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), typedArray.getResourceId(16, 0), typedArray.getResourceId(17, 0)).build());
            materialShapeDrawable2.setFillColor(MaterialResources.getColorStateList(getContext(), m6VarObtainTintedStyledAttributes, 18));
            drawableE2 = new InsetDrawable((Drawable) materialShapeDrawable2, typedArray.getDimensionPixelSize(21, 0), typedArray.getDimensionPixelSize(22, 0), typedArray.getDimensionPixelSize(20, 0), typedArray.getDimensionPixelSize(19, 0));
        }
        if (typedArray.hasValue(11)) {
            navigationMenuPresenter.itemHorizontalPadding = typedArray.getDimensionPixelSize(11, 0);
            navigationMenuPresenter.updateMenuView(false);
        }
        if (typedArray.hasValue(25)) {
            navigationMenuPresenter.itemVerticalPadding = typedArray.getDimensionPixelSize(25, 0);
            navigationMenuPresenter.updateMenuView(false);
        }
        navigationMenuPresenter.dividerInsetStart = typedArray.getDimensionPixelSize(6, 0);
        navigationMenuPresenter.updateMenuView(false);
        navigationMenuPresenter.dividerInsetEnd = typedArray.getDimensionPixelSize(5, 0);
        navigationMenuPresenter.updateMenuView(false);
        navigationMenuPresenter.subheaderInsetStart = typedArray.getDimensionPixelSize(31, 0);
        navigationMenuPresenter.updateMenuView(false);
        navigationMenuPresenter.subheaderInsetStart = typedArray.getDimensionPixelSize(30, 0);
        navigationMenuPresenter.updateMenuView(false);
        this.topInsetScrimEnabled = typedArray.getBoolean(33, true);
        this.bottomInsetScrimEnabled = typedArray.getBoolean(4, true);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(12, 0);
        navigationMenuPresenter.itemMaxLines = typedArray.getInt(15, 1);
        navigationMenuPresenter.updateMenuView(false);
        navigationMenu.mCallback = new f.a() { // from class: com.google.android.material.navigation.NavigationView.1
            @Override // androidx.appcompat.view.menu.f.a
            public final boolean onMenuItemSelected(f fVar, MenuItem menuItem) {
                e eVar = NavigationView.this.listener;
                return eVar != null && eVar.onNavigationItemSelected(menuItem);
            }

            @Override // androidx.appcompat.view.menu.f.a
            public final void onMenuModeChange(f fVar) {
            }
        };
        navigationMenuPresenter.id = 1;
        navigationMenuPresenter.initForMenu(context2, navigationMenu);
        if (resourceId != 0) {
            navigationMenuPresenter.subheaderTextAppearance = resourceId;
            navigationMenuPresenter.updateMenuView(false);
        }
        navigationMenuPresenter.subheaderColor = colorStateListB;
        navigationMenuPresenter.updateMenuView(false);
        navigationMenuPresenter.iconTintList = colorStateListB2;
        navigationMenuPresenter.updateMenuView(false);
        int overScrollMode = getOverScrollMode();
        navigationMenuPresenter.overScrollMode = overScrollMode;
        NavigationMenuView navigationMenuView = navigationMenuPresenter.menuView;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(overScrollMode);
        }
        if (resourceId2 != 0) {
            navigationMenuPresenter.textAppearance = resourceId2;
            navigationMenuPresenter.updateMenuView(false);
        }
        navigationMenuPresenter.textColor = colorStateListB3;
        navigationMenuPresenter.updateMenuView(false);
        navigationMenuPresenter.itemBackground = drawableE2;
        navigationMenuPresenter.updateMenuView(false);
        navigationMenuPresenter.itemIconPadding = dimensionPixelSize2;
        navigationMenuPresenter.updateMenuView(false);
        navigationMenu.addMenuPresenter(navigationMenuPresenter, navigationMenu.mContext);
        addView(navigationMenuPresenter.getMenuView(this));
        if (typedArray.hasValue(26)) {
            int resourceId3 = typedArray.getResourceId(26, 0);
            navigationMenuPresenter.setUpdateSuspended(true);
            if (this.menuInflater == null) {
                this.menuInflater = new l41(getContext());
            }
            this.menuInflater.inflate(resourceId3, navigationMenu);
            navigationMenuPresenter.setUpdateSuspended(false);
            navigationMenuPresenter.updateMenuView(false);
        }
        if (typedArray.hasValue(9)) {
            navigationMenuPresenter.headerLayout.addView(navigationMenuPresenter.layoutInflater.inflate(typedArray.getResourceId(9, 0), (ViewGroup) navigationMenuPresenter.headerLayout, false));
            NavigationMenuView navigationMenuView2 = navigationMenuPresenter.menuView;
            navigationMenuView2.setPadding(0, 0, 0, navigationMenuView2.getPaddingBottom());
        }
        m6VarObtainTintedStyledAttributes.n();
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.navigation.NavigationView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                Activity activity;
                NavigationView navigationView = NavigationView.this;
                navigationView.getLocationOnScreen(navigationView.tmpLocation);
                boolean z = navigationView.tmpLocation[1] == 0;
                NavigationMenuPresenter navigationMenuPresenter2 = navigationView.presenter;
                if (navigationMenuPresenter2.isBehindStatusBar != z) {
                    navigationMenuPresenter2.isBehindStatusBar = z;
                    int i2 = (navigationMenuPresenter2.headerLayout.getChildCount() == 0 && navigationMenuPresenter2.isBehindStatusBar) ? navigationMenuPresenter2.paddingTopDefault : 0;
                    NavigationMenuView navigationMenuView3 = navigationMenuPresenter2.menuView;
                    navigationMenuView3.setPadding(0, i2, 0, navigationMenuView3.getPaddingBottom());
                }
                navigationView.drawTopInsetForeground = z && navigationView.topInsetScrimEnabled;
                Context context3 = navigationView.getContext();
                while (true) {
                    if (!(context3 instanceof ContextWrapper)) {
                        activity = null;
                        break;
                    } else {
                        if (context3 instanceof Activity) {
                            activity = (Activity) context3;
                            break;
                        }
                        context3 = ((ContextWrapper) context3).getBaseContext();
                    }
                }
                if (activity != null) {
                    navigationView.drawBottomInsetForeground = (activity.findViewById(R.id.content).getHeight() == navigationView.getHeight()) && (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0) && navigationView.bottomInsetScrimEnabled;
                }
            }
        };
        this.onGlobalLayoutListener = onGlobalLayoutListener;
        getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public final ColorStateList createDefaultColorStateList(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = b2.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(org.hamotunnelplus.xyz.R.style.gn, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (this.shapeClipPath == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.clipPath(this.shapeClipPath);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    public final void onInsetsChanged(fg1 fg1Var) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.getClass();
        int iD = fg1Var.d();
        if (navigationMenuPresenter.paddingTopDefault != iD) {
            navigationMenuPresenter.paddingTopDefault = iD;
            int i = (navigationMenuPresenter.headerLayout.getChildCount() == 0 && navigationMenuPresenter.isBehindStatusBar) ? navigationMenuPresenter.paddingTopDefault : 0;
            NavigationMenuView navigationMenuView = navigationMenuPresenter.menuView;
            navigationMenuView.setPadding(0, i, 0, navigationMenuView.getPaddingBottom());
        }
        NavigationMenuView navigationMenuView2 = navigationMenuPresenter.menuView;
        navigationMenuView2.setPadding(0, navigationMenuView2.getPaddingTop(), 0, fg1Var.a());
        qd1.b(navigationMenuPresenter.headerLayout, fg1Var);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int iMin = this.maxWidth;
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
            }
            super.onMeasure(i, i2);
        }
        iMin = Math.min(View.MeasureSpec.getSize(i), iMin);
        i = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        this.menu.restorePresenterStates(savedState.menuState);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuState = bundle;
        this.menu.savePresenterStates(bundle);
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        boolean z = getParent() instanceof DrawerLayout;
        RectF rectF = this.shapeClipBounds;
        if (!z || (i5 = this.drawerLayoutCornerSize) <= 0 || !(getBackground() instanceof MaterialShapeDrawable)) {
            this.shapeClipPath = null;
            rectF.setEmpty();
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
        ShapeAppearanceModel shapeAppearanceModel = materialShapeDrawable.getShapeAppearanceModel();
        shapeAppearanceModel.getClass();
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(shapeAppearanceModel);
        WeakHashMap weakHashMap = qd1.a;
        float f = i5;
        if (Gravity.getAbsoluteGravity(this.layoutGravity, getLayoutDirection()) == 3) {
            builder.topRightCornerSize = new AbsoluteCornerSize(f);
            builder.bottomRightCornerSize = new AbsoluteCornerSize(f);
        } else {
            builder.topLeftCornerSize = new AbsoluteCornerSize(f);
            builder.bottomLeftCornerSize = new AbsoluteCornerSize(f);
        }
        materialShapeDrawable.setShapeAppearanceModel(builder.build());
        if (this.shapeClipPath == null) {
            this.shapeClipPath = new Path();
        }
        this.shapeClipPath.reset();
        rectF.set(0.0f, 0.0f, i, i2);
        ShapeAppearancePathProvider.getInstance().calculatePath(materialShapeDrawable.getShapeAppearanceModel(), materialShapeDrawable.getInterpolation(), rectF, null, this.shapeClipPath);
        invalidate();
    }

    @Override // android.view.View
    public final void setElevation(float f) {
        super.setElevation(f);
        MaterialShapeUtils.setElevation(this, f);
    }

    @Override // android.view.View
    public final void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.overScrollMode = i;
            NavigationMenuView navigationMenuView = navigationMenuPresenter.menuView;
            if (navigationMenuView != null) {
                navigationMenuView.setOverScrollMode(i);
            }
        }
    }
}
