package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.m;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.x;
import com.google.android.material.navigation.NavigationView;
import defpackage.o1;
import defpackage.qd1;
import java.util.ArrayList;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuPresenter implements j {
    public NavigationMenuAdapter adapter;
    public int dividerInsetEnd;
    public int dividerInsetStart;
    public boolean hasCustomItemIconSize;
    public LinearLayout headerLayout;
    public ColorStateList iconTintList;
    public int id;
    public Drawable itemBackground;
    public int itemHorizontalPadding;
    public int itemIconPadding;
    public int itemIconSize;
    public int itemMaxLines;
    public int itemVerticalPadding;
    public LayoutInflater layoutInflater;
    public f menu;
    public NavigationMenuView menuView;
    public int paddingSeparator;
    public int paddingTopDefault;
    public ColorStateList subheaderColor;
    public int subheaderInsetStart;
    public ColorStateList textColor;
    public int subheaderTextAppearance = 0;
    public int textAppearance = 0;
    public boolean isBehindStatusBar = true;
    public int overScrollMode = -1;
    public final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.material.internal.NavigationMenuPresenter.1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean z = true;
            navigationMenuPresenter.setUpdateSuspended(true);
            h hVar = ((NavigationMenuItemView) view).itemData;
            boolean zPerformItemAction = navigationMenuPresenter.menu.performItemAction(hVar, navigationMenuPresenter, 0);
            if (hVar != null && hVar.isCheckable() && zPerformItemAction) {
                navigationMenuPresenter.adapter.setCheckedItem(hVar);
            } else {
                z = false;
            }
            navigationMenuPresenter.setUpdateSuspended(false);
            if (z) {
                navigationMenuPresenter.updateMenuView(false);
            }
        }
    };

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class NavigationMenuAdapter extends RecyclerView.g<ViewHolder> {
        public h checkedItem;
        public final ArrayList items = new ArrayList();
        public boolean updateSuspended;

        public NavigationMenuAdapter() {
            prepareMenuItems();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final int getItemCount() {
            return this.items.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final int getItemViewType(int i) {
            NavigationMenuItem navigationMenuItem = (NavigationMenuItem) this.items.get(i);
            if (navigationMenuItem instanceof NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof NavigationMenuHeaderItem) {
                return 3;
            }
            if (navigationMenuItem instanceof NavigationMenuTextItem) {
                return ((NavigationMenuTextItem) navigationMenuItem).menuItem.hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void onBindViewHolder(RecyclerView.d0 d0Var, int i) {
            View view = ((ViewHolder) d0Var).itemView;
            int itemViewType = getItemViewType(i);
            ArrayList arrayList = this.items;
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType != 2) {
                        return;
                    }
                    NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuSeparatorItem) arrayList.get(i);
                    view.setPadding(navigationMenuPresenter.dividerInsetStart, navigationMenuSeparatorItem.paddingTop, navigationMenuPresenter.dividerInsetEnd, navigationMenuSeparatorItem.paddingBottom);
                    return;
                }
                TextView textView = (TextView) view;
                textView.setText(((NavigationMenuTextItem) arrayList.get(i)).menuItem.e);
                int i2 = navigationMenuPresenter.subheaderTextAppearance;
                if (i2 != 0) {
                    textView.setTextAppearance(i2);
                }
                textView.setPadding(navigationMenuPresenter.subheaderInsetStart, textView.getPaddingTop(), 0, textView.getPaddingBottom());
                ColorStateList colorStateList = navigationMenuPresenter.subheaderColor;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                    return;
                }
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
            ColorStateList colorStateList2 = navigationMenuPresenter.iconTintList;
            navigationMenuItemView.iconTintList = colorStateList2;
            CheckedTextView checkedTextView = navigationMenuItemView.textView;
            navigationMenuItemView.hasIconTintList = colorStateList2 != null;
            h hVar = navigationMenuItemView.itemData;
            if (hVar != null) {
                navigationMenuItemView.setIcon(hVar.getIcon());
            }
            int i3 = navigationMenuPresenter.textAppearance;
            if (i3 != 0) {
                checkedTextView.setTextAppearance(i3);
            }
            ColorStateList colorStateList3 = navigationMenuPresenter.textColor;
            if (colorStateList3 != null) {
                checkedTextView.setTextColor(colorStateList3);
            }
            Drawable drawable = navigationMenuPresenter.itemBackground;
            Drawable drawableNewDrawable = drawable != null ? drawable.getConstantState().newDrawable() : null;
            WeakHashMap weakHashMap = qd1.a;
            navigationMenuItemView.setBackground(drawableNewDrawable);
            NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuTextItem) arrayList.get(i);
            navigationMenuItemView.needsEmptyIcon = navigationMenuTextItem.needsEmptyIcon;
            int i4 = navigationMenuPresenter.itemHorizontalPadding;
            int i5 = navigationMenuPresenter.itemVerticalPadding;
            navigationMenuItemView.setPadding(i4, i5, i4, i5);
            checkedTextView.setCompoundDrawablePadding(navigationMenuPresenter.itemIconPadding);
            if (navigationMenuPresenter.hasCustomItemIconSize) {
                navigationMenuItemView.iconSize = navigationMenuPresenter.itemIconSize;
            }
            checkedTextView.setMaxLines(navigationMenuPresenter.itemMaxLines);
            navigationMenuItemView.initialize(navigationMenuTextItem.menuItem);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            if (i == 0) {
                return new NormalViewHolder(navigationMenuPresenter.layoutInflater, viewGroup, navigationMenuPresenter.onClickListener);
            }
            if (i == 1) {
                return new SubheaderViewHolder(navigationMenuPresenter.layoutInflater, viewGroup);
            }
            if (i == 2) {
                return new SeparatorViewHolder(navigationMenuPresenter.layoutInflater, viewGroup);
            }
            if (i != 3) {
                return null;
            }
            return new HeaderViewHolder(navigationMenuPresenter.headerLayout);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void onViewRecycled(RecyclerView.d0 d0Var) {
            ViewHolder viewHolder = (ViewHolder) d0Var;
            if (viewHolder instanceof NormalViewHolder) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder.itemView;
                FrameLayout frameLayout = navigationMenuItemView.actionArea;
                if (frameLayout != null) {
                    frameLayout.removeAllViews();
                }
                navigationMenuItemView.textView.setCompoundDrawables(null, null, null, null);
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void prepareMenuItems() {
            boolean z;
            if (this.updateSuspended) {
                return;
            }
            this.updateSuspended = true;
            ArrayList arrayList = this.items;
            arrayList.clear();
            arrayList.add(new NavigationMenuHeaderItem());
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            int size = navigationMenuPresenter.menu.getVisibleItems().size();
            boolean z2 = false;
            int i = -1;
            int i2 = 0;
            boolean z3 = false;
            int size2 = 0;
            while (i2 < size) {
                h hVar = (h) navigationMenuPresenter.menu.getVisibleItems().get(i2);
                if (hVar.isChecked()) {
                    setCheckedItem(hVar);
                }
                if (hVar.isCheckable()) {
                    hVar.f(z2);
                }
                if (hVar.hasSubMenu()) {
                    m mVar = hVar.o;
                    if (mVar.hasVisibleItems()) {
                        if (i2 != 0) {
                            arrayList.add(new NavigationMenuSeparatorItem(navigationMenuPresenter.paddingSeparator, z2 ? 1 : 0));
                        }
                        arrayList.add(new NavigationMenuTextItem(hVar));
                        int size3 = mVar.size();
                        int i3 = z2 ? 1 : 0;
                        int i4 = i3;
                        while (i3 < size3) {
                            h hVar2 = (h) mVar.getItem(i3);
                            if (hVar2.isVisible()) {
                                if (i4 == 0 && hVar2.getIcon() != null) {
                                    i4 = 1;
                                }
                                if (hVar2.isCheckable()) {
                                    hVar2.f(z2);
                                }
                                if (hVar.isChecked()) {
                                    setCheckedItem(hVar);
                                }
                                arrayList.add(new NavigationMenuTextItem(hVar2));
                            }
                            i3++;
                            z2 = false;
                        }
                        if (i4 != 0) {
                            int size4 = arrayList.size();
                            for (int size5 = arrayList.size(); size5 < size4; size5++) {
                                ((NavigationMenuTextItem) arrayList.get(size5)).needsEmptyIcon = true;
                            }
                        }
                    }
                    z = true;
                } else {
                    int i5 = hVar.b;
                    if (i5 != i) {
                        size2 = arrayList.size();
                        z3 = hVar.getIcon() != null;
                        if (i2 != 0) {
                            size2++;
                            int i6 = navigationMenuPresenter.paddingSeparator;
                            arrayList.add(new NavigationMenuSeparatorItem(i6, i6));
                        }
                    } else {
                        if (!z3 && hVar.getIcon() != null) {
                            int size6 = arrayList.size();
                            for (int i7 = size2; i7 < size6; i7++) {
                                ((NavigationMenuTextItem) arrayList.get(i7)).needsEmptyIcon = true;
                            }
                            z = true;
                            z3 = true;
                        }
                        NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuTextItem(hVar);
                        navigationMenuTextItem.needsEmptyIcon = z3;
                        arrayList.add(navigationMenuTextItem);
                        i = i5;
                    }
                    z = true;
                    NavigationMenuTextItem navigationMenuTextItem2 = new NavigationMenuTextItem(hVar);
                    navigationMenuTextItem2.needsEmptyIcon = z3;
                    arrayList.add(navigationMenuTextItem2);
                    i = i5;
                }
                i2++;
                z2 = false;
            }
            this.updateSuspended = z2 ? 1 : 0;
        }

        public final void setCheckedItem(h hVar) {
            if (this.checkedItem == hVar || !hVar.isCheckable()) {
                return;
            }
            h hVar2 = this.checkedItem;
            if (hVar2 != null) {
                hVar2.setChecked(false);
            }
            this.checkedItem = hVar;
            hVar.setChecked(true);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class NavigationMenuHeaderItem implements NavigationMenuItem {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface NavigationMenuItem {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class NavigationMenuSeparatorItem implements NavigationMenuItem {
        public final int paddingBottom;
        public final int paddingTop;

        public NavigationMenuSeparatorItem(int i, int i2) {
            this.paddingTop = i;
            this.paddingBottom = i2;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class NavigationMenuTextItem implements NavigationMenuItem {
        public final h menuItem;
        public boolean needsEmptyIcon;

        public NavigationMenuTextItem(h hVar) {
            this.menuItem = hVar;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class NavigationMenuViewAccessibilityDelegate extends x {
        public NavigationMenuViewAccessibilityDelegate(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.x, defpackage.a1
        public final void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
            int i;
            int i2;
            super.onInitializeAccessibilityNodeInfo(view, o1Var);
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            if (navigationMenuPresenter.headerLayout.getChildCount() == 0) {
                i = 0;
                i2 = 0;
            } else {
                i = 1;
                i2 = 0;
            }
            while (i2 < navigationMenuPresenter.adapter.items.size()) {
                if (navigationMenuPresenter.adapter.getItemViewType(i2) == 0) {
                    i++;
                }
                i2++;
            }
            o1Var.a.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(i, 0, false));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.bi, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.bk, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.bl, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class ViewHolder extends RecyclerView.d0 {
        public ViewHolder(View view) {
            super(view);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean collapseItemActionView(h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean expandItemActionView(h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final int getId() {
        return this.id;
    }

    public final NavigationMenuView getMenuView(NavigationView navigationView) {
        if (this.menuView == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.layoutInflater.inflate(R.layout.bm, (ViewGroup) navigationView, false);
            this.menuView = navigationMenuView;
            NavigationMenuViewAccessibilityDelegate navigationMenuViewAccessibilityDelegate = new NavigationMenuViewAccessibilityDelegate(this.menuView);
            navigationMenuView.mAccessibilityDelegate = navigationMenuViewAccessibilityDelegate;
            qd1.l(navigationMenuView, navigationMenuViewAccessibilityDelegate);
            if (this.adapter == null) {
                this.adapter = new NavigationMenuAdapter();
            }
            int i = this.overScrollMode;
            if (i != -1) {
                this.menuView.setOverScrollMode(i);
            }
            this.headerLayout = (LinearLayout) this.layoutInflater.inflate(R.layout.bj, (ViewGroup) this.menuView, false);
            this.menuView.setAdapter(this.adapter);
        }
        return this.menuView;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void initForMenu(Context context, f fVar) {
        this.layoutInflater = LayoutInflater.from(context);
        this.menu = fVar;
        this.paddingSeparator = context.getResources().getDimensionPixelOffset(R.dimen.cx);
    }

    @Override // androidx.appcompat.view.menu.j
    public final void onCloseMenu(f fVar, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.j
    public final void onRestoreInstanceState(Parcelable parcelable) {
        h hVar;
        View actionView;
        ParcelableSparseArray parcelableSparseArray;
        h hVar2;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.menuView.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                NavigationMenuAdapter navigationMenuAdapter = this.adapter;
                ArrayList arrayList = navigationMenuAdapter.items;
                int i = bundle2.getInt("android:menu:checked", 0);
                if (i != 0) {
                    navigationMenuAdapter.updateSuspended = true;
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        NavigationMenuItem navigationMenuItem = (NavigationMenuItem) arrayList.get(i2);
                        if ((navigationMenuItem instanceof NavigationMenuTextItem) && (hVar2 = ((NavigationMenuTextItem) navigationMenuItem).menuItem) != null && hVar2.a == i) {
                            navigationMenuAdapter.setCheckedItem(hVar2);
                            break;
                        }
                    }
                    navigationMenuAdapter.updateSuspended = false;
                    navigationMenuAdapter.prepareMenuItems();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = arrayList.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        NavigationMenuItem navigationMenuItem2 = (NavigationMenuItem) arrayList.get(i3);
                        if ((navigationMenuItem2 instanceof NavigationMenuTextItem) && (hVar = ((NavigationMenuTextItem) navigationMenuItem2).menuItem) != null && (actionView = hVar.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray2.get(hVar.a)) != null) {
                            actionView.restoreHierarchyState(parcelableSparseArray);
                        }
                    }
                }
            }
            SparseArray<Parcelable> sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 != null) {
                this.headerLayout.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.menuView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.menuView.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            ArrayList arrayList = navigationMenuAdapter.items;
            Bundle bundle2 = new Bundle();
            h hVar = navigationMenuAdapter.checkedItem;
            if (hVar != null) {
                bundle2.putInt("android:menu:checked", hVar.a);
            }
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                NavigationMenuItem navigationMenuItem = (NavigationMenuItem) arrayList.get(i);
                if (navigationMenuItem instanceof NavigationMenuTextItem) {
                    h hVar2 = ((NavigationMenuTextItem) navigationMenuItem).menuItem;
                    View actionView = hVar2 != null ? hVar2.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray2.put(hVar2.a, parcelableSparseArray);
                    }
                }
            }
            bundle2.putSparseParcelableArray("android:menu:action_views", sparseArray2);
            bundle.putBundle("android:menu:adapter", bundle2);
        }
        if (this.headerLayout != null) {
            SparseArray<Parcelable> sparseArray3 = new SparseArray<>();
            this.headerLayout.saveHierarchyState(sparseArray3);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray3);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean onSubMenuSelected(m mVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void setCallback(j.a aVar) {
        throw null;
    }

    public final void setUpdateSuspended(boolean z) {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.updateSuspended = z;
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final void updateMenuView(boolean z) {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.prepareMenuItems();
            navigationMenuAdapter.notifyDataSetChanged();
        }
    }
}
