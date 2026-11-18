package com.google.android.material.internal;

import android.content.Context;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.m;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class NavigationSubMenu extends m {
    public NavigationSubMenu(Context context, NavigationMenu navigationMenu, h hVar) {
        super(context, navigationMenu, hVar);
    }

    @Override // androidx.appcompat.view.menu.f
    public final void onItemsChanged(boolean z) {
        super.onItemsChanged(z);
        this.mParentMenu.onItemsChanged(z);
    }
}
