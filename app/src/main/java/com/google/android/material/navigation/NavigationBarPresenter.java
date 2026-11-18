package com.google.android.material.navigation;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.m;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ParcelableSparseArray;
import defpackage.d;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class NavigationBarPresenter implements j {
    public int id;
    public NavigationBarMenuView menuView;
    public boolean updateSuspended = false;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.material.navigation.NavigationBarPresenter.SavedState.1
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public ParcelableSparseArray badgeSavedStates;
        public int selectedItemId;

        public SavedState() {
        }

        public SavedState(Parcel parcel) {
            this.selectedItemId = parcel.readInt();
            this.badgeSavedStates = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.selectedItemId);
            parcel.writeParcelable(this.badgeSavedStates, 0);
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

    @Override // androidx.appcompat.view.menu.j
    public final void initForMenu(Context context, f fVar) {
        this.menuView.menu = fVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void onCloseMenu(f fVar, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.j
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            NavigationBarMenuView navigationBarMenuView = this.menuView;
            SavedState savedState = (SavedState) parcelable;
            int i = savedState.selectedItemId;
            int size = navigationBarMenuView.menu.mItems.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = navigationBarMenuView.menu.getItem(i2);
                if (i == item.getItemId()) {
                    navigationBarMenuView.selectedItemId = i;
                    navigationBarMenuView.selectedItemPosition = i2;
                    item.setChecked(true);
                    break;
                }
            }
            Context context = this.menuView.getContext();
            ParcelableSparseArray parcelableSparseArray = savedState.badgeSavedStates;
            SparseArray sparseArray = new SparseArray(parcelableSparseArray.size());
            for (int i3 = 0; i3 < parcelableSparseArray.size(); i3++) {
                int iKeyAt = parcelableSparseArray.keyAt(i3);
                BadgeDrawable.SavedState savedState2 = (BadgeDrawable.SavedState) parcelableSparseArray.valueAt(i3);
                if (savedState2 == null) {
                    d.AnonymousClass0.m$2("BadgeDrawable's savedState cannot be null");
                    return;
                }
                sparseArray.put(iKeyAt, BadgeDrawable.createFromSavedState(context, savedState2));
            }
            NavigationBarMenuView navigationBarMenuView2 = this.menuView;
            navigationBarMenuView2.badgeDrawables = sparseArray;
            NavigationBarItemView[] navigationBarItemViewArr = navigationBarMenuView2.buttons;
            if (navigationBarItemViewArr != null) {
                for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                    BadgeDrawable badgeDrawable = (BadgeDrawable) sparseArray.get(navigationBarItemView.getId());
                    navigationBarItemView.badgeDrawable = badgeDrawable;
                    ImageView imageView = navigationBarItemView.icon;
                    if (imageView != null && badgeDrawable != null) {
                        navigationBarItemView.setClipChildren(false);
                        navigationBarItemView.setClipToPadding(false);
                        BadgeDrawable badgeDrawable2 = navigationBarItemView.badgeDrawable;
                        Rect rect = new Rect();
                        imageView.getDrawingRect(rect);
                        badgeDrawable2.setBounds(rect);
                        badgeDrawable2.updateBadgeCoordinates(imageView, null);
                        WeakReference weakReference = badgeDrawable2.customBadgeParentRef;
                        if ((weakReference != null ? (FrameLayout) weakReference.get() : null) != null) {
                            WeakReference weakReference2 = badgeDrawable2.customBadgeParentRef;
                            (weakReference2 != null ? (FrameLayout) weakReference2.get() : null).setForeground(badgeDrawable2);
                        } else {
                            imageView.getOverlay().add(badgeDrawable2);
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        NavigationBarMenuView navigationBarMenuView = this.menuView;
        savedState.selectedItemId = navigationBarMenuView.selectedItemId;
        SparseArray sparseArray = navigationBarMenuView.badgeDrawables;
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            int iKeyAt = sparseArray.keyAt(i);
            BadgeDrawable badgeDrawable = (BadgeDrawable) sparseArray.valueAt(i);
            if (badgeDrawable == null) {
                d.AnonymousClass0.m$2("badgeDrawable cannot be null");
                return null;
            }
            parcelableSparseArray.put(iKeyAt, badgeDrawable.savedState);
        }
        savedState.badgeSavedStates = parcelableSparseArray;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean onSubMenuSelected(m mVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void setCallback(j.a aVar) {
        throw null;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void updateMenuView(boolean z) {
        if (this.updateSuspended) {
            return;
        }
        NavigationBarMenuView navigationBarMenuView = this.menuView;
        if (z) {
            navigationBarMenuView.buildMenuView();
            return;
        }
        f fVar = navigationBarMenuView.menu;
        if (fVar == null || navigationBarMenuView.buttons == null) {
            return;
        }
        int size = fVar.mItems.size();
        if (size != navigationBarMenuView.buttons.length) {
            navigationBarMenuView.buildMenuView();
            return;
        }
        int i = navigationBarMenuView.selectedItemId;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = navigationBarMenuView.menu.getItem(i2);
            if (item.isChecked()) {
                navigationBarMenuView.selectedItemId = item.getItemId();
                navigationBarMenuView.selectedItemPosition = i2;
            }
        }
        if (i != navigationBarMenuView.selectedItemId) {
            androidx.transition.j.a(navigationBarMenuView, navigationBarMenuView.set);
        }
        boolean zIsShifting = NavigationBarMenuView.isShifting(navigationBarMenuView.labelVisibilityMode, navigationBarMenuView.menu.getVisibleItems().size());
        for (int i3 = 0; i3 < size; i3++) {
            navigationBarMenuView.presenter.updateSuspended = true;
            navigationBarMenuView.buttons[i3].setLabelVisibilityMode(navigationBarMenuView.labelVisibilityMode);
            NavigationBarItemView navigationBarItemView = navigationBarMenuView.buttons[i3];
            if (navigationBarItemView.isShifting != zIsShifting) {
                navigationBarItemView.isShifting = zIsShifting;
                h hVar = navigationBarItemView.itemData;
                if (hVar != null) {
                    navigationBarItemView.setChecked(hVar.isChecked());
                }
            }
            navigationBarMenuView.buttons[i3].initialize((h) navigationBarMenuView.menu.getItem(i3));
            navigationBarMenuView.presenter.updateSuspended = false;
        }
    }
}
