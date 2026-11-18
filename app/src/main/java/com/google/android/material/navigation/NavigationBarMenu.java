package com.google.android.material.navigation;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import defpackage.ak;
import defpackage.fb$1;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class NavigationBarMenu extends f {
    public final int maxItemCount;
    public final Class viewClass;

    public NavigationBarMenu(Context context, Class<?> cls, int i) {
        super(context);
        this.viewClass = cls;
        this.maxItemCount = i;
    }

    @Override // androidx.appcompat.view.menu.f
    public final h addInternal(int i, int i2, int i3, CharSequence charSequence) {
        int size = this.mItems.size() + 1;
        int i4 = this.maxItemCount;
        if (size <= i4) {
            stopDispatchingItemsChanged();
            h hVarAddInternal = super.addInternal(i, i2, i3, charSequence);
            hVarAddInternal.f(true);
            startDispatchingItemsChanged();
            return hVarAddInternal;
        }
        String simpleName = this.viewClass.getSimpleName();
        StringBuilder sbQ = ak.q("Maximum number of items supported by ", simpleName, " is ");
        sbQ.append(i4);
        sbQ.append(". Limit can be checked with ");
        throw new IllegalArgumentException(fb$1.m(sbQ, simpleName, "#getMaxItemCount()"));
    }

    @Override // androidx.appcompat.view.menu.f, android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.viewClass.getSimpleName().concat(" does not support submenus"));
    }
}
