package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class m extends f implements SubMenu {
    public final h mItem;
    public final f mParentMenu;

    public m(Context context, f fVar, h hVar) {
        super(context);
        this.mParentMenu = fVar;
        this.mItem = hVar;
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean collapseItemActionView(h hVar) {
        return this.mParentMenu.collapseItemActionView(hVar);
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean dispatchMenuItemSelected(f fVar, MenuItem menuItem) {
        return super.dispatchMenuItemSelected(fVar, menuItem) || this.mParentMenu.dispatchMenuItemSelected(fVar, menuItem);
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean expandItemActionView(h hVar) {
        return this.mParentMenu.expandItemActionView(hVar);
    }

    @Override // androidx.appcompat.view.menu.f
    public final String getActionViewStatesKey() {
        h hVar = this.mItem;
        int i = hVar != null ? hVar.a : 0;
        if (i == 0) {
            return null;
        }
        return "android:menu:actionviewstates:" + i;
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.mItem;
    }

    @Override // androidx.appcompat.view.menu.f
    public final f getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    @Override // androidx.appcompat.view.menu.f, android.view.Menu
    public final void setGroupDividerEnabled(boolean z) {
        this.mParentMenu.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        setHeaderInternal(0, null, i, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        setHeaderInternal(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        setHeaderInternal(i, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        setHeaderInternal(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        setHeaderInternal(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.mItem.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.mItem.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.f, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.mParentMenu.setQwertyMode(z);
    }
}
