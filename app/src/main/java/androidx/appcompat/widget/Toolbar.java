package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.m;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.ah0;
import defpackage.b2;
import defpackage.c5;
import defpackage.dh0;
import defpackage.f71;
import defpackage.jf;
import defpackage.kh0;
import defpackage.l41;
import defpackage.m6;
import defpackage.pw0;
import defpackage.qd1;
import defpackage.s5;
import defpackage.t1;
import defpackage.ue1;
import defpackage.zd;
import java.util.ArrayList;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements ah0 {
    public c5 mActionMenuPresenterCallback;
    public final int mButtonGravity;
    public s5 mCollapseButtonView;
    public final CharSequence mCollapseDescription;
    public final Drawable mCollapseIcon;
    public final int mContentInsetEndWithActions;
    public final int mContentInsetStartWithNavigation;
    public pw0 mContentInsets;
    public boolean mEatingHover;
    public boolean mEatingTouch;
    public View mExpandedActionView;
    public d mExpandedMenuPresenter;
    public final int mGravity;
    public final ArrayList mHiddenViews;
    public AppCompatImageView mLogoView;
    public final int mMaxButtonHeight;
    public f71.b mMenuBuilderCallback;
    public final dh0 mMenuHostHelper;
    public ActionMenuView mMenuView;
    public final a mMenuViewItemClickListener;
    public s5 mNavButtonView;
    public f71.b mOnMenuItemClickListener;
    public androidx.appcompat.widget.a mOuterActionMenuPresenter;
    public Context mPopupContext;
    public int mPopupTheme;
    public ArrayList mProvidedMenuItems;
    public final b mShowOverflowMenuRunnable;
    public CharSequence mSubtitleText;
    public int mSubtitleTextAppearance;
    public final ColorStateList mSubtitleTextColor;
    public AppCompatTextView mSubtitleTextView;
    public final int[] mTempMargins;
    public final ArrayList mTempViews;
    public final int mTitleMarginBottom;
    public final int mTitleMarginEnd;
    public final int mTitleMarginStart;
    public final int mTitleMarginTop;
    public CharSequence mTitleText;
    public int mTitleTextAppearance;
    public final ColorStateList mTitleTextColor;
    public AppCompatTextView mTitleTextView;
    public androidx.appcompat.widget.d mWrapper;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements ActionMenuView.e {
        public a() {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toolbar.this.showOverflowMenu();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d dVar = Toolbar.this.mExpandedMenuPresenter;
            h hVar = dVar == null ? null : dVar.c;
            if (hVar != null) {
                hVar.collapseActionView();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d implements j {
        public androidx.appcompat.view.menu.f b;
        public h c;

        public d() {
        }

        @Override // androidx.appcompat.view.menu.j
        public final boolean collapseItemActionView(h hVar) {
            Toolbar toolbar = Toolbar.this;
            KeyEvent.Callback callback = toolbar.mExpandedActionView;
            if (callback instanceof zd) {
                ((zd) callback).onActionViewCollapsed();
            }
            toolbar.removeView(toolbar.mExpandedActionView);
            toolbar.removeView(toolbar.mCollapseButtonView);
            toolbar.mExpandedActionView = null;
            ArrayList arrayList = toolbar.mHiddenViews;
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    arrayList.clear();
                    this.c = null;
                    toolbar.requestLayout();
                    hVar.C = false;
                    hVar.n.onItemsChanged(false);
                    return true;
                }
                toolbar.addView((View) arrayList.get(size));
            }
        }

        @Override // androidx.appcompat.view.menu.j
        public final boolean expandItemActionView(h hVar) {
            Toolbar toolbar = Toolbar.this;
            s5 s5Var = toolbar.mCollapseButtonView;
            int i = toolbar.mButtonGravity;
            if (s5Var == null) {
                s5 s5Var2 = new s5(toolbar.getContext(), null, R.style.a65);
                toolbar.mCollapseButtonView = s5Var2;
                s5Var2.setImageDrawable(toolbar.mCollapseIcon);
                toolbar.mCollapseButtonView.setContentDescription(toolbar.mCollapseDescription);
                e eVar = new e();
                eVar.a = (i & 112) | 8388611;
                eVar.b = 2;
                toolbar.mCollapseButtonView.setLayoutParams(eVar);
                toolbar.mCollapseButtonView.setOnClickListener(toolbar.new c());
            }
            ViewParent parent = toolbar.mCollapseButtonView.getParent();
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.mCollapseButtonView);
                }
                toolbar.addView(toolbar.mCollapseButtonView);
            }
            View actionView = hVar.getActionView();
            toolbar.mExpandedActionView = actionView;
            this.c = hVar;
            ViewParent parent2 = actionView.getParent();
            if (parent2 != toolbar) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar.mExpandedActionView);
                }
                e eVar2 = new e();
                eVar2.a = (i & 112) | 8388611;
                eVar2.b = 2;
                toolbar.mExpandedActionView.setLayoutParams(eVar2);
                toolbar.addView(toolbar.mExpandedActionView);
            }
            int childCount = toolbar.getChildCount();
            while (true) {
                childCount--;
                if (childCount < 0) {
                    break;
                }
                View childAt = toolbar.getChildAt(childCount);
                if (((e) childAt.getLayoutParams()).b != 2 && childAt != toolbar.mMenuView) {
                    toolbar.removeViewAt(childCount);
                    toolbar.mHiddenViews.add(childAt);
                }
            }
            toolbar.requestLayout();
            hVar.C = true;
            hVar.n.onItemsChanged(false);
            KeyEvent.Callback callback = toolbar.mExpandedActionView;
            if (callback instanceof zd) {
                ((zd) callback).onActionViewExpanded();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public final boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public final int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.j
        public final void initForMenu(Context context, androidx.appcompat.view.menu.f fVar) {
            h hVar;
            androidx.appcompat.view.menu.f fVar2 = this.b;
            if (fVar2 != null && (hVar = this.c) != null) {
                fVar2.collapseItemActionView(hVar);
            }
            this.b = fVar;
        }

        @Override // androidx.appcompat.view.menu.j
        public final void onCloseMenu(androidx.appcompat.view.menu.f fVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.j
        public final void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.j
        public final Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.j
        public final boolean onSubMenuSelected(m mVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public final void updateMenuView(boolean z) {
            if (this.c != null) {
                androidx.appcompat.view.menu.f fVar = this.b;
                if (fVar != null) {
                    int size = fVar.mItems.size();
                    for (int i = 0; i < size; i++) {
                        if (this.b.getItem(i) == this.c) {
                            return;
                        }
                    }
                }
                collapseItemActionView(this.c);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class e extends t1.a {
        public int b;

        public e() {
            super(-2, -2);
            this.b = 0;
            this.a = 8388627;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = 0;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(e eVar) {
            super((t1.a) eVar);
            this.b = 0;
            this.b = eVar.b;
        }

        public e(t1.a aVar) {
            super(aVar);
            this.b = 0;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface f {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class g extends defpackage.d {
        public static final Parcelable.Creator<g> CREATOR = new a();
        public int b;
        public boolean c;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Parcelable.ClassLoaderCreator<g> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i) {
                return new g[i];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = parcel.readInt();
            this.c = parcel.readInt() != 0;
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // defpackage.d, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.a66);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuHostHelper = new dh0(new jf(this, 1, 2));
        this.mProvidedMenuItems = new ArrayList();
        this.mMenuViewItemClickListener = new a();
        this.mShowOverflowMenuRunnable = new b();
        Context context2 = getContext();
        int[] iArr = b2.z;
        m6 m6VarM = m6.m(context2, attributeSet, iArr, i);
        qd1.k(this, context, iArr, attributeSet, (TypedArray) m6VarM.a, i);
        TypedArray typedArray = (TypedArray) m6VarM.a;
        this.mTitleTextAppearance = typedArray.getResourceId(28, 0);
        this.mSubtitleTextAppearance = typedArray.getResourceId(19, 0);
        this.mGravity = typedArray.getInteger(0, 8388627);
        this.mButtonGravity = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.mTitleMarginBottom = dimensionPixelOffset;
        this.mTitleMarginTop = dimensionPixelOffset;
        this.mTitleMarginEnd = dimensionPixelOffset;
        this.mTitleMarginStart = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.mTitleMarginStart = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.mTitleMarginEnd = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.mTitleMarginTop = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.mTitleMarginBottom = dimensionPixelOffset5;
        }
        this.mMaxButtonHeight = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        ensureContentInsets();
        pw0 pw0Var = this.mContentInsets;
        pw0Var.h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            pw0Var.e = dimensionPixelSize;
            pw0Var.a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            pw0Var.f = dimensionPixelSize2;
            pw0Var.b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            pw0Var.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.mContentInsetStartWithNavigation = typedArray.getDimensionPixelOffset(10, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
        this.mContentInsetEndWithActions = typedArray.getDimensionPixelOffset(6, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
        this.mCollapseIcon = m6VarM.e(4);
        this.mCollapseDescription = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.mPopupContext = getContext();
        int resourceId = typedArray.getResourceId(17, 0);
        if (this.mPopupTheme != resourceId) {
            this.mPopupTheme = resourceId;
            if (resourceId == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), resourceId);
            }
        }
        Drawable drawableE = m6VarM.e(16);
        if (drawableE != null) {
            setNavigationIcon(drawableE);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableE2 = m6VarM.e(11);
        if (drawableE2 != null) {
            setLogo(drawableE2);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            if (!TextUtils.isEmpty(text4) && this.mLogoView == null) {
                this.mLogoView = new AppCompatImageView(getContext());
            }
            AppCompatImageView appCompatImageView = this.mLogoView;
            if (appCompatImageView != null) {
                appCompatImageView.setContentDescription(text4);
            }
        }
        if (typedArray.hasValue(29)) {
            ColorStateList colorStateListB = m6VarM.b(29);
            this.mTitleTextColor = colorStateListB;
            AppCompatTextView appCompatTextView = this.mTitleTextView;
            if (appCompatTextView != null) {
                appCompatTextView.setTextColor(colorStateListB);
            }
        }
        if (typedArray.hasValue(20)) {
            ColorStateList colorStateListB2 = m6VarM.b(20);
            this.mSubtitleTextColor = colorStateListB2;
            AppCompatTextView appCompatTextView2 = this.mSubtitleTextView;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setTextColor(colorStateListB2);
            }
        }
        if (typedArray.hasValue(14)) {
            new l41(getContext()).inflate(typedArray.getResourceId(14, 0), getMenu());
        }
        m6VarM.n();
    }

    public static e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        if (layoutParams instanceof t1.a) {
            return new e((t1.a) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public static int getHorizontalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int getVerticalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void addCustomViewsWithGravity(ArrayList arrayList, int i) {
        WeakHashMap weakHashMap = qd1.a;
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.b == 0 && shouldLayout(childAt)) {
                    int i3 = eVar.a;
                    WeakHashMap weakHashMap2 = qd1.a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i3, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.b == 0 && shouldLayout(childAt2)) {
                int i5 = eVar2.a;
                WeakHashMap weakHashMap3 = qd1.a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i5, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    @Override // defpackage.ah0
    public final void addMenuProvider(kh0 kh0Var) {
        dh0 dh0Var = this.mMenuHostHelper;
        dh0Var.b.add(kh0Var);
        dh0Var.a.run();
    }

    public final void addSystemView(View view, boolean z) {
        e eVarGenerateLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            eVarGenerateLayoutParams = new e();
        } else {
            eVarGenerateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        }
        eVarGenerateLayoutParams.b = 1;
        if (!z || this.mExpandedActionView == null) {
            addView(view, eVarGenerateLayoutParams);
        } else {
            view.setLayoutParams(eVarGenerateLayoutParams);
            this.mHiddenViews.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public final void ensureContentInsets() {
        if (this.mContentInsets == null) {
            pw0 pw0Var = new pw0();
            pw0Var.a = 0;
            pw0Var.b = 0;
            pw0Var.c = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            pw0Var.d = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            pw0Var.e = 0;
            pw0Var.f = 0;
            pw0Var.g = false;
            pw0Var.h = false;
            this.mContentInsets = pw0Var;
        }
    }

    public final void ensureMenuView() {
        if (this.mMenuView == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.mMenuView = actionMenuView;
            int i = this.mPopupTheme;
            if (actionMenuView.d != i) {
                actionMenuView.d = i;
                if (i == 0) {
                    actionMenuView.c = actionMenuView.getContext();
                } else {
                    actionMenuView.c = new ContextThemeWrapper(actionMenuView.getContext(), i);
                }
            }
            ActionMenuView actionMenuView2 = this.mMenuView;
            actionMenuView2.r = this.mMenuViewItemClickListener;
            c5 c5Var = this.mActionMenuPresenterCallback;
            f71.b bVar = this.mMenuBuilderCallback;
            actionMenuView2.i = c5Var;
            actionMenuView2.j = bVar;
            e eVar = new e();
            eVar.a = (this.mButtonGravity & 112) | 8388613;
            this.mMenuView.setLayoutParams(eVar);
            addSystemView(this.mMenuView, false);
        }
    }

    public final void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new s5(getContext(), null, R.style.a65);
            e eVar = new e();
            eVar.a = (this.mButtonGravity & 112) | 8388611;
            this.mNavButtonView.setLayoutParams(eVar);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateLayoutParams(layoutParams);
    }

    public final int getChildTop(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i3 = eVar.a & 112;
        if (i3 != 16 && i3 != 48 && i3 != 80) {
            i3 = this.mGravity & 112;
        }
        if (i3 == 48) {
            return getPaddingTop() - i2;
        }
        if (i3 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        if (iMax < i4) {
            iMax = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i6 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            if (i5 < i6) {
                iMax = Math.max(0, iMax - (i6 - i5));
            }
        }
        return paddingTop + iMax;
    }

    public final int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.f fVar;
        int i;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView == null || (fVar = actionMenuView.b) == null || !fVar.hasVisibleItems()) {
            pw0 pw0Var = this.mContentInsets;
            if (pw0Var != null) {
                return pw0Var.g ? pw0Var.a : pw0Var.b;
            }
            return 0;
        }
        pw0 pw0Var2 = this.mContentInsets;
        if (pw0Var2 != null) {
            i = pw0Var2.g ? pw0Var2.a : pw0Var2.b;
        } else {
            i = 0;
        }
        return Math.max(i, Math.max(this.mContentInsetEndWithActions, 0));
    }

    public final int getCurrentContentInsetStart() {
        int i;
        Drawable navigationIcon = getNavigationIcon();
        pw0 pw0Var = this.mContentInsets;
        if (navigationIcon == null) {
            if (pw0Var != null) {
                return pw0Var.g ? pw0Var.b : pw0Var.a;
            }
            return 0;
        }
        if (pw0Var != null) {
            i = pw0Var.g ? pw0Var.b : pw0Var.a;
        } else {
            i = 0;
        }
        return Math.max(i, Math.max(this.mContentInsetStartWithNavigation, 0));
    }

    public final androidx.appcompat.view.menu.f getMenu() {
        ensureMenuView();
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView.b == null) {
            androidx.appcompat.view.menu.f menu = actionMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new d();
            }
            this.mMenuView.g.x = true;
            menu.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
        return this.mMenuView.getMenu();
    }

    public final Drawable getNavigationIcon() {
        s5 s5Var = this.mNavButtonView;
        if (s5Var != null) {
            return s5Var.getDrawable();
        }
        return null;
    }

    public final boolean isChildOrHidden(View view) {
        return view.getParent() == this || this.mHiddenViews.contains(view);
    }

    public final boolean isOverflowMenuShowing() {
        androidx.appcompat.widget.a aVar;
        ActionMenuView actionMenuView = this.mMenuView;
        return (actionMenuView == null || (aVar = actionMenuView.g) == null || !aVar.c()) ? false : true;
    }

    public final int layoutChildLeft(View view, int i, int i2, int[] iArr) {
        e eVar = (e) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int iMax = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, childTop, iMax + measuredWidth, view.getMeasuredHeight() + childTop);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin + iMax;
    }

    public final int layoutChildRight(View view, int i, int i2, int[] iArr) {
        e eVar = (e) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, childTop, iMax, view.getMeasuredHeight() + childTop);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    public final int measureChildCollapseMargins(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i6) + Math.max(0, i5);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + iMax + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void measureChildConstrained(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.mEatingHover = false;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0214  */
    /* JADX WARN: Code duplicated, block: B:102:0x0217  */
    /* JADX WARN: Code duplicated, block: B:103:0x021c  */
    /* JADX WARN: Code duplicated, block: B:105:0x0221 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0225  */
    /* JADX WARN: Code duplicated, block: B:110:0x0239  */
    /* JADX WARN: Code duplicated, block: B:111:0x025a  */
    /* JADX WARN: Code duplicated, block: B:113:0x025d  */
    /* JADX WARN: Code duplicated, block: B:114:0x027d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0280  */
    /* JADX WARN: Code duplicated, block: B:117:0x0287  */
    /* JADX WARN: Code duplicated, block: B:120:0x0298 A[LOOP:0: B:119:0x0296->B:120:0x0298, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:123:0x02b1 A[LOOP:1: B:122:0x02af->B:123:0x02b1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:126:0x02d2 A[LOOP:2: B:125:0x02d0->B:126:0x02d2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:130:0x0314 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:131:0x0316  */
    /* JADX WARN: Code duplicated, block: B:132:0x031a  */
    /* JADX WARN: Code duplicated, block: B:135:0x0321 A[LOOP:3: B:134:0x031f->B:135:0x0321, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:20:0x005f  */
    /* JADX WARN: Code duplicated, block: B:22:0x0063  */
    /* JADX WARN: Code duplicated, block: B:23:0x0068  */
    /* JADX WARN: Code duplicated, block: B:26:0x0074  */
    /* JADX WARN: Code duplicated, block: B:28:0x0078  */
    /* JADX WARN: Code duplicated, block: B:29:0x007d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0087  */
    /* JADX WARN: Code duplicated, block: B:33:0x008c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0096  */
    /* JADX WARN: Code duplicated, block: B:38:0x009d  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:43:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:47:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:54:0x010d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0110  */
    /* JADX WARN: Code duplicated, block: B:57:0x0128  */
    /* JADX WARN: Code duplicated, block: B:60:0x012e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x0130  */
    /* JADX WARN: Code duplicated, block: B:62:0x0133  */
    /* JADX WARN: Code duplicated, block: B:64:0x0137  */
    /* JADX WARN: Code duplicated, block: B:65:0x013a  */
    /* JADX WARN: Code duplicated, block: B:68:0x014a  */
    /* JADX WARN: Code duplicated, block: B:70:0x0152 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:78:0x0171  */
    /* JADX WARN: Code duplicated, block: B:80:0x0179  */
    /* JADX WARN: Code duplicated, block: B:82:0x0185  */
    /* JADX WARN: Code duplicated, block: B:83:0x0187  */
    /* JADX WARN: Code duplicated, block: B:85:0x0191  */
    /* JADX WARN: Code duplicated, block: B:87:0x019e  */
    /* JADX WARN: Code duplicated, block: B:88:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:91:0x01b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:96:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:97:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:99:0x01f2  */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iLayoutChildLeft;
        int iLayoutChildRight;
        int currentContentInsetStart;
        int currentContentInsetEnd;
        boolean z2;
        int iMax;
        int iMin;
        boolean zShouldLayout;
        boolean zShouldLayout2;
        int measuredHeight;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        e eVar;
        e eVar2;
        boolean z3;
        int i5;
        int i6;
        int i7;
        int paddingTop;
        int i8;
        int i9;
        int iMax2;
        int i10;
        int i11;
        int iMax3;
        int iMax4;
        int i12;
        int i13;
        int i14;
        int iMax5;
        int i15;
        int i16;
        ArrayList arrayList;
        int size;
        int iLayoutChildLeft2;
        int i17;
        int size2;
        int iLayoutChildRight2;
        int i18;
        int size3;
        int i19;
        int i20;
        int i21;
        int measuredWidth;
        int i22;
        int i23;
        int i24;
        int size4;
        AppCompatImageView appCompatImageView;
        View view;
        ActionMenuView actionMenuView;
        s5 s5Var;
        WeakHashMap weakHashMap = qd1.a;
        boolean z4 = getLayoutDirection() == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i25 = width - paddingRight;
        int[] iArr = this.mTempMargins;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeight = getMinimumHeight();
        int iMin2 = minimumHeight >= 0 ? Math.min(minimumHeight, i4 - i2) : 0;
        if (shouldLayout(this.mNavButtonView)) {
            s5 s5Var2 = this.mNavButtonView;
            if (z4) {
                iLayoutChildRight = layoutChildRight(s5Var2, i25, iMin2, iArr);
                iLayoutChildLeft = paddingLeft;
            } else {
                iLayoutChildLeft = layoutChildLeft(s5Var2, paddingLeft, iMin2, iArr);
            }
            if (shouldLayout(this.mCollapseButtonView)) {
                s5Var = this.mCollapseButtonView;
                if (z4) {
                    iLayoutChildRight = layoutChildRight(s5Var, iLayoutChildRight, iMin2, iArr);
                } else {
                    iLayoutChildLeft = layoutChildLeft(s5Var, iLayoutChildLeft, iMin2, iArr);
                }
            }
            if (shouldLayout(this.mMenuView)) {
                actionMenuView = this.mMenuView;
                if (z4) {
                    iLayoutChildLeft = layoutChildLeft(actionMenuView, iLayoutChildLeft, iMin2, iArr);
                } else {
                    iLayoutChildRight = layoutChildRight(actionMenuView, iLayoutChildRight, iMin2, iArr);
                }
            }
            if (getLayoutDirection() == 1) {
                currentContentInsetStart = getCurrentContentInsetEnd();
            } else {
                currentContentInsetStart = getCurrentContentInsetStart();
            }
            if (getLayoutDirection() == 1) {
                currentContentInsetEnd = getCurrentContentInsetStart();
            } else {
                currentContentInsetEnd = getCurrentContentInsetEnd();
            }
            z2 = z4;
            iArr[0] = Math.max(0, currentContentInsetStart - iLayoutChildLeft);
            iArr[1] = Math.max(0, currentContentInsetEnd - (i25 - iLayoutChildRight));
            iMax = Math.max(iLayoutChildLeft, currentContentInsetStart);
            iMin = Math.min(iLayoutChildRight, i25 - currentContentInsetEnd);
            if (shouldLayout(this.mExpandedActionView)) {
                view = this.mExpandedActionView;
                if (z2) {
                    iMin = layoutChildRight(view, iMin, iMin2, iArr);
                } else {
                    iMax = layoutChildLeft(view, iMax, iMin2, iArr);
                }
            }
            if (shouldLayout(this.mLogoView)) {
                appCompatImageView = this.mLogoView;
                if (z2) {
                    iMin = layoutChildRight(appCompatImageView, iMin, iMin2, iArr);
                } else {
                    iMax = layoutChildLeft(appCompatImageView, iMax, iMin2, iArr);
                }
            }
            zShouldLayout = shouldLayout(this.mTitleTextView);
            zShouldLayout2 = shouldLayout(this.mSubtitleTextView);
            if (zShouldLayout) {
                e eVar3 = (e) this.mTitleTextView.getLayoutParams();
                measuredHeight = ((ViewGroup.MarginLayoutParams) eVar3).bottomMargin + this.mTitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar3).topMargin;
            } else {
                measuredHeight = 0;
            }
            if (zShouldLayout2) {
                e eVar4 = (e) this.mSubtitleTextView.getLayoutParams();
                measuredHeight += this.mSubtitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar4).topMargin + ((ViewGroup.MarginLayoutParams) eVar4).bottomMargin;
            }
            if (!zShouldLayout || zShouldLayout2) {
                if (zShouldLayout) {
                    appCompatTextView = this.mTitleTextView;
                } else {
                    appCompatTextView = this.mSubtitleTextView;
                }
                if (zShouldLayout2) {
                    appCompatTextView2 = this.mSubtitleTextView;
                } else {
                    appCompatTextView2 = this.mTitleTextView;
                }
                eVar = (e) appCompatTextView.getLayoutParams();
                eVar2 = (e) appCompatTextView2.getLayoutParams();
                z3 = (!zShouldLayout && this.mTitleTextView.getMeasuredWidth() > 0) || (zShouldLayout2 && this.mSubtitleTextView.getMeasuredWidth() > 0);
                i5 = iMin;
                i6 = this.mGravity & 112;
                i7 = this.mTitleMarginTop;
                if (i6 != 48) {
                    i14 = this.mTitleMarginBottom;
                    if (i6 != 80) {
                        iMax5 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                        i15 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + i7;
                        if (iMax5 < i15) {
                            iMax5 = i15;
                        } else {
                            i16 = (((height - paddingBottom) - measuredHeight) - iMax5) - paddingTop2;
                            if (i16 < ((ViewGroup.MarginLayoutParams) eVar).bottomMargin + i14) {
                                iMax5 = Math.max(0, iMax5 - ((((ViewGroup.MarginLayoutParams) eVar2).bottomMargin + i14) - i16));
                            }
                        }
                        paddingTop = paddingTop2 + iMax5;
                    } else {
                        paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin) - i14) - measuredHeight;
                    }
                } else {
                    paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + i7;
                }
                i8 = this.mTitleMarginStart;
                i9 = this.mTitleMarginEnd;
                if (z2) {
                    if (!z3) {
                        i8 = 0;
                    }
                    int i26 = i8 - iArr[1];
                    iMax4 = i5 - Math.max(0, i26);
                    iArr[1] = Math.max(0, -i26);
                    if (zShouldLayout) {
                        e eVar5 = (e) this.mTitleTextView.getLayoutParams();
                        int measuredWidth2 = iMax4 - this.mTitleTextView.getMeasuredWidth();
                        int measuredHeight2 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                        this.mTitleTextView.layout(measuredWidth2, paddingTop, iMax4, measuredHeight2);
                        i12 = measuredWidth2 - i9;
                        paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) eVar5).bottomMargin;
                    } else {
                        i12 = iMax4;
                    }
                    if (zShouldLayout2) {
                        int i27 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.mSubtitleTextView.getLayoutParams())).topMargin;
                        this.mSubtitleTextView.layout(iMax4 - this.mSubtitleTextView.getMeasuredWidth(), i27, iMax4, this.mSubtitleTextView.getMeasuredHeight() + i27);
                        i13 = iMax4 - i9;
                    } else {
                        i13 = iMax4;
                    }
                    if (z3) {
                        iMin = Math.min(i12, i13);
                    } else {
                        iMin = iMax4;
                    }
                    iMax3 = iMax;
                } else {
                    if (!z3) {
                        i8 = 0;
                    }
                    int i28 = i8 - iArr[0];
                    iMax2 = Math.max(0, i28) + iMax;
                    iArr[0] = Math.max(0, -i28);
                    if (zShouldLayout) {
                        e eVar6 = (e) this.mTitleTextView.getLayoutParams();
                        int measuredWidth3 = this.mTitleTextView.getMeasuredWidth() + iMax2;
                        int measuredHeight3 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                        this.mTitleTextView.layout(iMax2, paddingTop, measuredWidth3, measuredHeight3);
                        i10 = measuredWidth3 + i9;
                        paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) eVar6).bottomMargin;
                    } else {
                        i10 = iMax2;
                    }
                    if (zShouldLayout2) {
                        int i29 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.mSubtitleTextView.getLayoutParams())).topMargin;
                        int measuredWidth4 = this.mSubtitleTextView.getMeasuredWidth() + iMax2;
                        this.mSubtitleTextView.layout(iMax2, i29, measuredWidth4, this.mSubtitleTextView.getMeasuredHeight() + i29);
                        i11 = measuredWidth4 + i9;
                    } else {
                        i11 = iMax2;
                    }
                    if (z3) {
                        iMax3 = Math.max(i10, i11);
                        iMin = i5;
                    } else {
                        iMin = i5;
                        iMax3 = iMax2;
                    }
                }
            } else {
                iMax3 = iMax;
            }
            arrayList = this.mTempViews;
            addCustomViewsWithGravity(arrayList, 3);
            size = arrayList.size();
            iLayoutChildLeft2 = iMax3;
            for (i17 = 0; i17 < size; i17++) {
                iLayoutChildLeft2 = layoutChildLeft((View) arrayList.get(i17), iLayoutChildLeft2, iMin2, iArr);
            }
            addCustomViewsWithGravity(arrayList, 5);
            size2 = arrayList.size();
            iLayoutChildRight2 = iMin;
            for (i18 = 0; i18 < size2; i18++) {
                iLayoutChildRight2 = layoutChildRight((View) arrayList.get(i18), iLayoutChildRight2, iMin2, iArr);
            }
            addCustomViewsWithGravity(arrayList, 1);
            int i30 = iArr[0];
            int i31 = iArr[1];
            size3 = arrayList.size();
            i19 = i31;
            i20 = i30;
            i21 = 0;
            measuredWidth = 0;
            while (i21 < size3) {
                View view2 = (View) arrayList.get(i21);
                e eVar7 = (e) view2.getLayoutParams();
                int i32 = i21;
                int i33 = ((ViewGroup.MarginLayoutParams) eVar7).leftMargin - i20;
                int i34 = ((ViewGroup.MarginLayoutParams) eVar7).rightMargin - i19;
                int iMax6 = Math.max(0, i33);
                int iMax7 = Math.max(0, i34);
                int iMax8 = Math.max(0, -i33);
                int iMax9 = Math.max(0, -i34);
                measuredWidth += view2.getMeasuredWidth() + iMax6 + iMax7;
                i19 = iMax9;
                i20 = iMax8;
                i21 = i32 + 1;
            }
            i23 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
            i24 = measuredWidth + i23;
            if (i23 >= iLayoutChildLeft2) {
                if (i24 > iLayoutChildRight2) {
                    iLayoutChildLeft2 = i23 - (i24 - iLayoutChildRight2);
                } else {
                    iLayoutChildLeft2 = i23;
                }
            }
            size4 = arrayList.size();
            for (i22 = 0; i22 < size4; i22++) {
                iLayoutChildLeft2 = layoutChildLeft((View) arrayList.get(i22), iLayoutChildLeft2, iMin2, iArr);
            }
            arrayList.clear();
        }
        iLayoutChildLeft = paddingLeft;
        iLayoutChildRight = i25;
        if (shouldLayout(this.mCollapseButtonView)) {
            s5Var = this.mCollapseButtonView;
            if (z4) {
                iLayoutChildRight = layoutChildRight(s5Var, iLayoutChildRight, iMin2, iArr);
            } else {
                iLayoutChildLeft = layoutChildLeft(s5Var, iLayoutChildLeft, iMin2, iArr);
            }
        }
        if (shouldLayout(this.mMenuView)) {
            actionMenuView = this.mMenuView;
            if (z4) {
                iLayoutChildLeft = layoutChildLeft(actionMenuView, iLayoutChildLeft, iMin2, iArr);
            } else {
                iLayoutChildRight = layoutChildRight(actionMenuView, iLayoutChildRight, iMin2, iArr);
            }
        }
        if (getLayoutDirection() == 1) {
            currentContentInsetStart = getCurrentContentInsetEnd();
        } else {
            currentContentInsetStart = getCurrentContentInsetStart();
        }
        if (getLayoutDirection() == 1) {
            currentContentInsetEnd = getCurrentContentInsetStart();
        } else {
            currentContentInsetEnd = getCurrentContentInsetEnd();
        }
        z2 = z4;
        iArr[0] = Math.max(0, currentContentInsetStart - iLayoutChildLeft);
        iArr[1] = Math.max(0, currentContentInsetEnd - (i25 - iLayoutChildRight));
        iMax = Math.max(iLayoutChildLeft, currentContentInsetStart);
        iMin = Math.min(iLayoutChildRight, i25 - currentContentInsetEnd);
        if (shouldLayout(this.mExpandedActionView)) {
            view = this.mExpandedActionView;
            if (z2) {
                iMin = layoutChildRight(view, iMin, iMin2, iArr);
            } else {
                iMax = layoutChildLeft(view, iMax, iMin2, iArr);
            }
        }
        if (shouldLayout(this.mLogoView)) {
            appCompatImageView = this.mLogoView;
            if (z2) {
                iMin = layoutChildRight(appCompatImageView, iMin, iMin2, iArr);
            } else {
                iMax = layoutChildLeft(appCompatImageView, iMax, iMin2, iArr);
            }
        }
        zShouldLayout = shouldLayout(this.mTitleTextView);
        zShouldLayout2 = shouldLayout(this.mSubtitleTextView);
        if (zShouldLayout) {
            e eVar8 = (e) this.mTitleTextView.getLayoutParams();
            measuredHeight = ((ViewGroup.MarginLayoutParams) eVar8).bottomMargin + this.mTitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar8).topMargin;
        } else {
            measuredHeight = 0;
        }
        if (zShouldLayout2) {
            e eVar9 = (e) this.mSubtitleTextView.getLayoutParams();
            measuredHeight += this.mSubtitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar9).topMargin + ((ViewGroup.MarginLayoutParams) eVar9).bottomMargin;
        }
        if (zShouldLayout) {
            if (zShouldLayout) {
                appCompatTextView = this.mTitleTextView;
            } else {
                appCompatTextView = this.mSubtitleTextView;
            }
            if (zShouldLayout2) {
                appCompatTextView2 = this.mSubtitleTextView;
            } else {
                appCompatTextView2 = this.mTitleTextView;
            }
            eVar = (e) appCompatTextView.getLayoutParams();
            eVar2 = (e) appCompatTextView2.getLayoutParams();
            if (zShouldLayout) {
            }
            i5 = iMin;
            i6 = this.mGravity & 112;
            i7 = this.mTitleMarginTop;
            if (i6 != 48) {
                i14 = this.mTitleMarginBottom;
                if (i6 != 80) {
                    iMax5 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    i15 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + i7;
                    if (iMax5 < i15) {
                        iMax5 = i15;
                    } else {
                        i16 = (((height - paddingBottom) - measuredHeight) - iMax5) - paddingTop2;
                        if (i16 < ((ViewGroup.MarginLayoutParams) eVar).bottomMargin + i14) {
                            iMax5 = Math.max(0, iMax5 - ((((ViewGroup.MarginLayoutParams) eVar2).bottomMargin + i14) - i16));
                        }
                    }
                    paddingTop = paddingTop2 + iMax5;
                } else {
                    paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin) - i14) - measuredHeight;
                }
            } else {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + i7;
            }
            i8 = this.mTitleMarginStart;
            i9 = this.mTitleMarginEnd;
            if (z2) {
                if (!z3) {
                    i8 = 0;
                }
                int i210 = i8 - iArr[1];
                iMax4 = i5 - Math.max(0, i210);
                iArr[1] = Math.max(0, -i210);
                if (zShouldLayout) {
                    e eVar10 = (e) this.mTitleTextView.getLayoutParams();
                    int measuredWidth5 = iMax4 - this.mTitleTextView.getMeasuredWidth();
                    int measuredHeight4 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                    this.mTitleTextView.layout(measuredWidth5, paddingTop, iMax4, measuredHeight4);
                    i12 = measuredWidth5 - i9;
                    paddingTop = measuredHeight4 + ((ViewGroup.MarginLayoutParams) eVar10).bottomMargin;
                } else {
                    i12 = iMax4;
                }
                if (zShouldLayout2) {
                    int i211 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.mSubtitleTextView.getLayoutParams())).topMargin;
                    this.mSubtitleTextView.layout(iMax4 - this.mSubtitleTextView.getMeasuredWidth(), i211, iMax4, this.mSubtitleTextView.getMeasuredHeight() + i211);
                    i13 = iMax4 - i9;
                } else {
                    i13 = iMax4;
                }
                if (z3) {
                    iMin = Math.min(i12, i13);
                } else {
                    iMin = iMax4;
                }
                iMax3 = iMax;
            } else {
                if (!z3) {
                    i8 = 0;
                }
                int i212 = i8 - iArr[0];
                iMax2 = Math.max(0, i212) + iMax;
                iArr[0] = Math.max(0, -i212);
                if (zShouldLayout) {
                    e eVar11 = (e) this.mTitleTextView.getLayoutParams();
                    int measuredWidth6 = this.mTitleTextView.getMeasuredWidth() + iMax2;
                    int measuredHeight5 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                    this.mTitleTextView.layout(iMax2, paddingTop, measuredWidth6, measuredHeight5);
                    i10 = measuredWidth6 + i9;
                    paddingTop = measuredHeight5 + ((ViewGroup.MarginLayoutParams) eVar11).bottomMargin;
                } else {
                    i10 = iMax2;
                }
                if (zShouldLayout2) {
                    int i213 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.mSubtitleTextView.getLayoutParams())).topMargin;
                    int measuredWidth7 = this.mSubtitleTextView.getMeasuredWidth() + iMax2;
                    this.mSubtitleTextView.layout(iMax2, i213, measuredWidth7, this.mSubtitleTextView.getMeasuredHeight() + i213);
                    i11 = measuredWidth7 + i9;
                } else {
                    i11 = iMax2;
                }
                if (z3) {
                    iMax3 = Math.max(i10, i11);
                    iMin = i5;
                } else {
                    iMin = i5;
                    iMax3 = iMax2;
                }
            }
        } else {
            if (zShouldLayout) {
                appCompatTextView = this.mTitleTextView;
            } else {
                appCompatTextView = this.mSubtitleTextView;
            }
            if (zShouldLayout2) {
                appCompatTextView2 = this.mSubtitleTextView;
            } else {
                appCompatTextView2 = this.mTitleTextView;
            }
            eVar = (e) appCompatTextView.getLayoutParams();
            eVar2 = (e) appCompatTextView2.getLayoutParams();
            if (zShouldLayout) {
            }
            i5 = iMin;
            i6 = this.mGravity & 112;
            i7 = this.mTitleMarginTop;
            if (i6 != 48) {
                i14 = this.mTitleMarginBottom;
                if (i6 != 80) {
                    iMax5 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    i15 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + i7;
                    if (iMax5 < i15) {
                        iMax5 = i15;
                    } else {
                        i16 = (((height - paddingBottom) - measuredHeight) - iMax5) - paddingTop2;
                        if (i16 < ((ViewGroup.MarginLayoutParams) eVar).bottomMargin + i14) {
                            iMax5 = Math.max(0, iMax5 - ((((ViewGroup.MarginLayoutParams) eVar2).bottomMargin + i14) - i16));
                        }
                    }
                    paddingTop = paddingTop2 + iMax5;
                } else {
                    paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin) - i14) - measuredHeight;
                }
            } else {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + i7;
            }
            i8 = this.mTitleMarginStart;
            i9 = this.mTitleMarginEnd;
            if (z2) {
                if (!z3) {
                    i8 = 0;
                }
                int i214 = i8 - iArr[1];
                iMax4 = i5 - Math.max(0, i214);
                iArr[1] = Math.max(0, -i214);
                if (zShouldLayout) {
                    e eVar12 = (e) this.mTitleTextView.getLayoutParams();
                    int measuredWidth8 = iMax4 - this.mTitleTextView.getMeasuredWidth();
                    int measuredHeight6 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                    this.mTitleTextView.layout(measuredWidth8, paddingTop, iMax4, measuredHeight6);
                    i12 = measuredWidth8 - i9;
                    paddingTop = measuredHeight6 + ((ViewGroup.MarginLayoutParams) eVar12).bottomMargin;
                } else {
                    i12 = iMax4;
                }
                if (zShouldLayout2) {
                    int i215 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.mSubtitleTextView.getLayoutParams())).topMargin;
                    this.mSubtitleTextView.layout(iMax4 - this.mSubtitleTextView.getMeasuredWidth(), i215, iMax4, this.mSubtitleTextView.getMeasuredHeight() + i215);
                    i13 = iMax4 - i9;
                } else {
                    i13 = iMax4;
                }
                if (z3) {
                    iMin = Math.min(i12, i13);
                } else {
                    iMin = iMax4;
                }
                iMax3 = iMax;
            } else {
                if (!z3) {
                    i8 = 0;
                }
                int i216 = i8 - iArr[0];
                iMax2 = Math.max(0, i216) + iMax;
                iArr[0] = Math.max(0, -i216);
                if (zShouldLayout) {
                    e eVar13 = (e) this.mTitleTextView.getLayoutParams();
                    int measuredWidth9 = this.mTitleTextView.getMeasuredWidth() + iMax2;
                    int measuredHeight7 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                    this.mTitleTextView.layout(iMax2, paddingTop, measuredWidth9, measuredHeight7);
                    i10 = measuredWidth9 + i9;
                    paddingTop = measuredHeight7 + ((ViewGroup.MarginLayoutParams) eVar13).bottomMargin;
                } else {
                    i10 = iMax2;
                }
                if (zShouldLayout2) {
                    int i217 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.mSubtitleTextView.getLayoutParams())).topMargin;
                    int measuredWidth10 = this.mSubtitleTextView.getMeasuredWidth() + iMax2;
                    this.mSubtitleTextView.layout(iMax2, i217, measuredWidth10, this.mSubtitleTextView.getMeasuredHeight() + i217);
                    i11 = measuredWidth10 + i9;
                } else {
                    i11 = iMax2;
                }
                if (z3) {
                    iMax3 = Math.max(i10, i11);
                    iMin = i5;
                } else {
                    iMin = i5;
                    iMax3 = iMax2;
                }
            }
        }
        arrayList = this.mTempViews;
        addCustomViewsWithGravity(arrayList, 3);
        size = arrayList.size();
        iLayoutChildLeft2 = iMax3;
        while (i17 < size) {
            iLayoutChildLeft2 = layoutChildLeft((View) arrayList.get(i17), iLayoutChildLeft2, iMin2, iArr);
        }
        addCustomViewsWithGravity(arrayList, 5);
        size2 = arrayList.size();
        iLayoutChildRight2 = iMin;
        while (i18 < size2) {
            iLayoutChildRight2 = layoutChildRight((View) arrayList.get(i18), iLayoutChildRight2, iMin2, iArr);
        }
        addCustomViewsWithGravity(arrayList, 1);
        int i35 = iArr[0];
        int i36 = iArr[1];
        size3 = arrayList.size();
        i19 = i36;
        i20 = i35;
        i21 = 0;
        measuredWidth = 0;
        while (i21 < size3) {
            View view3 = (View) arrayList.get(i21);
            e eVar14 = (e) view3.getLayoutParams();
            int i37 = i21;
            int i38 = ((ViewGroup.MarginLayoutParams) eVar14).leftMargin - i20;
            int i39 = ((ViewGroup.MarginLayoutParams) eVar14).rightMargin - i19;
            int iMax10 = Math.max(0, i38);
            int iMax11 = Math.max(0, i39);
            int iMax12 = Math.max(0, -i38);
            int iMax13 = Math.max(0, -i39);
            measuredWidth += view3.getMeasuredWidth() + iMax10 + iMax11;
            i19 = iMax13;
            i20 = iMax12;
            i21 = i37 + 1;
        }
        i23 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        i24 = measuredWidth + i23;
        if (i23 >= iLayoutChildLeft2) {
            if (i24 > iLayoutChildRight2) {
                iLayoutChildLeft2 = i23 - (i24 - iLayoutChildRight2);
            } else {
                iLayoutChildLeft2 = i23;
            }
        }
        size4 = arrayList.size();
        while (i22 < size4) {
            iLayoutChildLeft2 = layoutChildLeft((View) arrayList.get(i22), iLayoutChildLeft2, iMin2, iArr);
        }
        arrayList.clear();
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int horizontalMargins;
        int iMax;
        int iCombineMeasuredStates;
        int horizontalMargins2;
        int iCombineMeasuredStates2;
        int iMax2;
        boolean zA = ue1.a(this);
        int i3 = !zA ? 1 : 0;
        int verticalMargins = 0;
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i, 0, i2, this.mMaxButtonHeight);
            horizontalMargins = getHorizontalMargins(this.mNavButtonView) + this.mNavButtonView.getMeasuredWidth();
            iMax = Math.max(0, getVerticalMargins(this.mNavButtonView) + this.mNavButtonView.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
        } else {
            horizontalMargins = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i, 0, i2, this.mMaxButtonHeight);
            horizontalMargins = getHorizontalMargins(this.mCollapseButtonView) + this.mCollapseButtonView.getMeasuredWidth();
            iMax = Math.max(iMax, getVerticalMargins(this.mCollapseButtonView) + this.mCollapseButtonView.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.mCollapseButtonView.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, horizontalMargins);
        int iMax4 = Math.max(0, currentContentInsetStart - horizontalMargins);
        int[] iArr = this.mTempMargins;
        iArr[zA ? 1 : 0] = iMax4;
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i, iMax3, i2, this.mMaxButtonHeight);
            horizontalMargins2 = getHorizontalMargins(this.mMenuView) + this.mMenuView.getMeasuredWidth();
            iMax = Math.max(iMax, getVerticalMargins(this.mMenuView) + this.mMenuView.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.mMenuView.getMeasuredState());
        } else {
            horizontalMargins2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, horizontalMargins2);
        iArr[i3] = Math.max(0, currentContentInsetEnd - horizontalMargins2);
        if (shouldLayout(this.mExpandedActionView)) {
            iMax5 += measureChildCollapseMargins(this.mExpandedActionView, i, iMax5, i2, 0, iArr);
            iMax = Math.max(iMax, getVerticalMargins(this.mExpandedActionView) + this.mExpandedActionView.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.mExpandedActionView.getMeasuredState());
        }
        if (shouldLayout(this.mLogoView)) {
            iMax5 += measureChildCollapseMargins(this.mLogoView, i, iMax5, i2, 0, iArr);
            iMax = Math.max(iMax, getVerticalMargins(this.mLogoView) + this.mLogoView.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.mLogoView.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (((e) childAt.getLayoutParams()).b == 0 && shouldLayout(childAt)) {
                iMax5 += measureChildCollapseMargins(childAt, i, iMax5, i2, 0, iArr);
                int iMax6 = Math.max(iMax, getVerticalMargins(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax6;
            } else {
                iMax5 = iMax5;
            }
        }
        int i5 = iMax5;
        int i6 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i7 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, i, i5 + i7, i2, i6, iArr);
            int horizontalMargins3 = getHorizontalMargins(this.mTitleTextView) + this.mTitleTextView.getMeasuredWidth();
            int measuredHeight = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.mTitleTextView.getMeasuredState());
            iMax2 = horizontalMargins3;
            verticalMargins = measuredHeight;
        } else {
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            iMax2 = Math.max(iMax2, measureChildCollapseMargins(this.mSubtitleTextView, i, i5 + i7, i2, i6 + verticalMargins, iArr));
            verticalMargins += getVerticalMargins(this.mSubtitleTextView) + this.mSubtitleTextView.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.mSubtitleTextView.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + i5 + iMax2, getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + Math.max(iMax, verticalMargins), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.mSuperState);
        ActionMenuView actionMenuView = this.mMenuView;
        androidx.appcompat.view.menu.f fVar = actionMenuView != null ? actionMenuView.b : null;
        int i = gVar.b;
        if (i != 0 && this.mExpandedMenuPresenter != null && fVar != null && (menuItemFindItem = fVar.findItem(i)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (gVar.c) {
            b bVar = this.mShowOverflowMenuRunnable;
            removeCallbacks(bVar);
            post(bVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        int i2;
        super.onRtlPropertiesChanged(i);
        ensureContentInsets();
        pw0 pw0Var = this.mContentInsets;
        boolean z = i == 1;
        if (z == pw0Var.g) {
            return;
        }
        pw0Var.g = z;
        if (pw0Var.h) {
            if (z) {
                int i3 = pw0Var.d;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = pw0Var.e;
                }
                pw0Var.a = i3;
                i2 = pw0Var.c;
                if (i2 == Integer.MIN_VALUE) {
                }
            } else {
                int i4 = pw0Var.c;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = pw0Var.e;
                }
                pw0Var.a = i4;
                i2 = pw0Var.d;
                if (i2 == Integer.MIN_VALUE) {
                }
            }
            pw0Var.b = i2;
        }
        pw0Var.a = pw0Var.e;
        i2 = pw0Var.f;
        pw0Var.b = i2;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar;
        g gVar = new g(super.onSaveInstanceState());
        d dVar = this.mExpandedMenuPresenter;
        if (dVar != null && (hVar = dVar.c) != null) {
            gVar.b = hVar.a;
        }
        gVar.c = isOverflowMenuShowing();
        return gVar;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.mEatingTouch = false;
        return true;
    }

    @Override // defpackage.ah0
    public final void removeMenuProvider(kh0 kh0Var) {
        this.mMenuHostHelper.c(kh0Var);
    }

    public final void setLogo(Drawable drawable) {
        AppCompatImageView appCompatImageView = this.mLogoView;
        if (drawable != null) {
            if (appCompatImageView == null) {
                this.mLogoView = new AppCompatImageView(getContext());
            }
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else if (appCompatImageView != null && isChildOrHidden(appCompatImageView)) {
            removeView(this.mLogoView);
            this.mHiddenViews.remove(this.mLogoView);
        }
        AppCompatImageView appCompatImageView2 = this.mLogoView;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageDrawable(drawable);
        }
    }

    public final void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        s5 s5Var = this.mNavButtonView;
        if (s5Var != null) {
            s5Var.setContentDescription(charSequence);
            b2.a(charSequence, this.mNavButtonView);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else {
            s5 s5Var = this.mNavButtonView;
            if (s5Var != null && isChildOrHidden(s5Var)) {
                removeView(this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
            }
        }
        s5 s5Var2 = this.mNavButtonView;
        if (s5Var2 != null) {
            s5Var2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        AppCompatTextView appCompatTextView = this.mSubtitleTextView;
        if (!zIsEmpty) {
            if (appCompatTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context);
                this.mSubtitleTextView = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.mSubtitleTextAppearance;
                if (i != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.mSubtitleTextColor;
                if (colorStateList != null) {
                    this.mSubtitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else if (appCompatTextView != null && isChildOrHidden(appCompatTextView)) {
            removeView(this.mSubtitleTextView);
            this.mHiddenViews.remove(this.mSubtitleTextView);
        }
        AppCompatTextView appCompatTextView3 = this.mSubtitleTextView;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setTitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        AppCompatTextView appCompatTextView = this.mTitleTextView;
        if (!zIsEmpty) {
            if (appCompatTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context);
                this.mTitleTextView = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.mTitleTextAppearance;
                if (i != 0) {
                    this.mTitleTextView.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.mTitleTextColor;
                if (colorStateList != null) {
                    this.mTitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else if (appCompatTextView != null && isChildOrHidden(appCompatTextView)) {
            removeView(this.mTitleTextView);
            this.mHiddenViews.remove(this.mTitleTextView);
        }
        AppCompatTextView appCompatTextView3 = this.mTitleTextView;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public final boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final boolean showOverflowMenu() {
        androidx.appcompat.widget.a aVar;
        ActionMenuView actionMenuView = this.mMenuView;
        return (actionMenuView == null || (aVar = actionMenuView.g) == null || !aVar.d()) ? false : true;
    }
}
