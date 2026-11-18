package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import defpackage.hh0;
import defpackage.k41;
import defpackage.ud1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class f implements k41 {
    public static final int[] sCategoryToOrder = {1, 4, 5, 3, 2, 0};
    public final ArrayList mActionItems;
    public a mCallback;
    public final Context mContext;
    public h mExpandedItem;
    public Drawable mHeaderIcon;
    public CharSequence mHeaderTitle;
    public View mHeaderView;
    public boolean mIsActionItemsStale;
    public boolean mIsVisibleItemsStale;
    public final ArrayList mItems;
    public final ArrayList mNonActionItems;
    public boolean mOverrideVisibleItems;
    public boolean mQwertyMode;
    public final Resources mResources;
    public final boolean mShortcutsVisible;
    public final ArrayList mVisibleItems;
    public int mDefaultShowAsAction = 0;
    public boolean mPreventDispatchingItemsChanged = false;
    public boolean mItemsChangedWhileDispatchPrevented = false;
    public boolean mStructureChangedWhileDispatchPrevented = false;
    public boolean mIsClosing = false;
    public final ArrayList mTempShortcutItemList = new ArrayList();
    public final CopyOnWriteArrayList mPresenters = new CopyOnWriteArrayList();
    public boolean mGroupDividerEnabled = false;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface a {
        boolean onMenuItemSelected(f fVar, MenuItem menuItem);

        void onMenuModeChange(f fVar);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface b {
        boolean a(h hVar);
    }

    public f(Context context) {
        boolean zShouldShowMenuShortcutsWhenKeyboardPresent;
        boolean z = false;
        this.mContext = context;
        Resources resources = context.getResources();
        this.mResources = resources;
        this.mItems = new ArrayList();
        this.mVisibleItems = new ArrayList();
        this.mIsVisibleItemsStale = true;
        this.mActionItems = new ArrayList();
        this.mNonActionItems = new ArrayList();
        this.mIsActionItemsStale = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = ud1.a;
            if (Build.VERSION.SDK_INT >= 28) {
                zShouldShowMenuShortcutsWhenKeyboardPresent = viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                zShouldShowMenuShortcutsWhenKeyboardPresent = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (zShouldShowMenuShortcutsWhenKeyboardPresent) {
                z = true;
            }
        }
        this.mShortcutsVisible = z;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return addInternal(0, 0, 0, this.mResources.getString(i));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, int i4) {
        return addInternal(i, i2, i3, this.mResources.getString(i4));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return addInternal(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            h hVarAddInternal = addInternal(i, i2, i3, resolveInfo.loadLabel(packageManager));
            hVarAddInternal.setIcon(resolveInfo.loadIcon(packageManager));
            hVarAddInternal.g = intent2;
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = hVarAddInternal;
            }
        }
        return size;
    }

    public h addInternal(int i, int i2, int i3, CharSequence charSequence) {
        int i4 = ((-65536) & i3) >> 16;
        if (i4 < 0 || i4 >= 6) {
            defpackage.d.AnonymousClass0.m$2("order does not contain a valid category.");
            return null;
        }
        int i5 = (65535 & i3) | (sCategoryToOrder[i4] << 16);
        h hVar = new h(this, i, i2, i3, i5, charSequence, this.mDefaultShowAsAction);
        ArrayList arrayList = this.mItems;
        int size = arrayList.size();
        while (true) {
            int i6 = size - 1;
            if (i6 < 0) {
                size = 0;
                break;
            }
            if (((h) arrayList.get(i6)).d <= i5) {
                break;
            }
            size = i6;
        }
        arrayList.add(size, hVar);
        onItemsChanged(true);
        return hVar;
    }

    public final void addMenuPresenter(j jVar, Context context) {
        this.mPresenters.add(new WeakReference(jVar));
        jVar.initForMenu(context, this);
        this.mIsActionItemsStale = true;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.mResources.getString(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.mResources.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        h hVarAddInternal = addInternal(i, i2, i3, charSequence);
        m mVar = new m(this.mContext, this, hVarAddInternal);
        hVarAddInternal.o = mVar;
        mVar.setHeaderTitle(hVarAddInternal.e);
        return mVar;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        h hVar = this.mExpandedItem;
        if (hVar != null) {
            collapseItemActionView(hVar);
        }
        this.mItems.clear();
        onItemsChanged(true);
    }

    public final void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public final void close() {
        close(true);
    }

    public final void close(boolean z) {
        if (this.mIsClosing) {
            return;
        }
        this.mIsClosing = true;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.mPresenters;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                jVar.onCloseMenu(this, z);
            }
        }
        this.mIsClosing = false;
    }

    public boolean collapseItemActionView(h hVar) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.mPresenters;
        boolean zCollapseItemActionView = false;
        if (!copyOnWriteArrayList.isEmpty() && this.mExpandedItem == hVar) {
            stopDispatchingItemsChanged();
            for (WeakReference weakReference : copyOnWriteArrayList) {
                j jVar = (j) weakReference.get();
                if (jVar != null) {
                    zCollapseItemActionView = jVar.collapseItemActionView(hVar);
                    if (zCollapseItemActionView) {
                        break;
                    }
                } else {
                    copyOnWriteArrayList.remove(weakReference);
                }
            }
            startDispatchingItemsChanged();
            if (zCollapseItemActionView) {
                this.mExpandedItem = null;
            }
        }
        return zCollapseItemActionView;
    }

    public boolean dispatchMenuItemSelected(f fVar, MenuItem menuItem) {
        a aVar = this.mCallback;
        return aVar != null && aVar.onMenuItemSelected(fVar, menuItem);
    }

    public boolean expandItemActionView(h hVar) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.mPresenters;
        boolean zExpandItemActionView = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            j jVar = (j) weakReference.get();
            if (jVar != null) {
                zExpandItemActionView = jVar.expandItemActionView(hVar);
                if (zExpandItemActionView) {
                    break;
                }
            } else {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
        startDispatchingItemsChanged();
        if (zExpandItemActionView) {
            this.mExpandedItem = hVar;
        }
        return zExpandItemActionView;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.mItems;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) arrayList.get(i2);
            if (hVar.a == i) {
                return hVar;
            }
            if (hVar.hasSubMenu() && (menuItemFindItem = hVar.o.findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final h findItemWithShortcutForKey(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.mTempShortcutItemList;
        arrayList.clear();
        findItemsWithShortcutForKey(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (h) arrayList.get(0);
        }
        boolean zIsQwertyMode = isQwertyMode();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) arrayList.get(i2);
            char c = zIsQwertyMode ? hVar.j : hVar.h;
            char[] cArr = keyData.meta;
            if ((c == cArr[0] && (metaState & 2) == 0) || ((c == cArr[2] && (metaState & 2) != 0) || (zIsQwertyMode && c == '\b' && i == 67))) {
                return hVar;
            }
        }
        return null;
    }

    public final void findItemsWithShortcutForKey(List list, int i, KeyEvent keyEvent) {
        boolean zIsQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            ArrayList arrayList = this.mItems;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = (h) arrayList.get(i2);
                if (hVar.hasSubMenu()) {
                    hVar.o.findItemsWithShortcutForKey(list, i, keyEvent);
                }
                char c = zIsQwertyMode ? hVar.j : hVar.h;
                if ((modifiers & 69647) == ((zIsQwertyMode ? hVar.k : hVar.i) & 69647) && c != 0) {
                    char[] cArr = keyData.meta;
                    if ((c == cArr[0] || c == cArr[2] || (zIsQwertyMode && c == '\b' && i == 67)) && hVar.isEnabled()) {
                        list.add(hVar);
                    }
                }
            }
        }
    }

    public final void flagActionItems() {
        ArrayList visibleItems = getVisibleItems();
        if (this.mIsActionItemsStale) {
            CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.mPresenters;
            boolean zFlagActionItems = false;
            for (WeakReference weakReference : copyOnWriteArrayList) {
                j jVar = (j) weakReference.get();
                if (jVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zFlagActionItems |= jVar.flagActionItems();
                }
            }
            ArrayList arrayList = this.mActionItems;
            ArrayList arrayList2 = this.mNonActionItems;
            arrayList.clear();
            arrayList2.clear();
            if (zFlagActionItems) {
                int size = visibleItems.size();
                for (int i = 0; i < size; i++) {
                    h hVar = (h) visibleItems.get(i);
                    ((hVar.x & 32) == 32 ? arrayList : arrayList2).add(hVar);
                }
            } else {
                arrayList2.addAll(getVisibleItems());
            }
            this.mIsActionItemsStale = false;
        }
    }

    public String getActionViewStatesKey() {
        return "android:menu:actionviewstates";
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return (MenuItem) this.mItems.get(i);
    }

    public f getRootMenu() {
        return this;
    }

    public final ArrayList getVisibleItems() {
        boolean z = this.mIsVisibleItemsStale;
        ArrayList arrayList = this.mVisibleItems;
        if (!z) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.mItems;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) arrayList2.get(i);
            if (hVar.isVisible()) {
                arrayList.add(hVar);
            }
        }
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return arrayList;
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems) {
            return true;
        }
        ArrayList arrayList = this.mItems;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((h) arrayList.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    public boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return findItemWithShortcutForKey(i, keyEvent) != null;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    public void onItemsChanged(boolean z) {
        if (this.mPreventDispatchingItemsChanged) {
            this.mItemsChangedWhileDispatchPrevented = true;
            if (z) {
                this.mStructureChangedWhileDispatchPrevented = true;
                return;
            }
            return;
        }
        if (z) {
            this.mIsVisibleItemsStale = true;
            this.mIsActionItemsStale = true;
        }
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.mPresenters;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        stopDispatchingItemsChanged();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                jVar.updateMenuView(z);
            }
        }
        startDispatchingItemsChanged();
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i2) {
        return performItemAction(findItem(i), null, i2);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0038  */
    /* JADX WARN: Code duplicated, block: B:30:0x0049  */
    /* JADX WARN: Code duplicated, block: B:33:0x0050  */
    /* JADX WARN: Code duplicated, block: B:36:0x0059  */
    /* JADX WARN: Code duplicated, block: B:43:0x0067  */
    /* JADX WARN: Code duplicated, block: B:45:0x006b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0074  */
    /* JADX WARN: Code duplicated, block: B:51:0x0086  */
    /* JADX WARN: Code duplicated, block: B:55:0x0096 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x0098  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c2 A[PHI: r1
      0x00c2: PHI (r1v10 boolean) = (r1v9 boolean), (r1v8 boolean), (r1v12 boolean) binds: [B:66:0x00c0, B:41:0x0064, B:34:0x0055] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:74:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x00a0 A[SYNTHETIC] */
    public final boolean performItemAction(MenuItem menuItem, j jVar, int i) {
        hh0.b bVar;
        boolean zExpandActionView;
        hh0.b bVar2;
        boolean z;
        m mVar;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList;
        j jVar2;
        h hVar = (h) menuItem;
        boolean zOnSubMenuSelected = false;
        if (hVar == null || !hVar.isEnabled()) {
            return false;
        }
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = hVar.p;
        if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(hVar)) {
            f fVar = hVar.n;
            if (fVar.dispatchMenuItemSelected(fVar, hVar)) {
                zExpandActionView = true;
            } else {
                Intent intent = hVar.g;
                if (intent != null) {
                    try {
                        fVar.mContext.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        bVar = hVar.A;
                        if (bVar == null) {
                        }
                        zExpandActionView = false;
                        bVar2 = hVar.A;
                        if (bVar2 == null) {
                            z = false;
                        } else {
                            z = false;
                        }
                        if (hVar.e()) {
                            zExpandActionView |= hVar.expandActionView();
                            if (zExpandActionView) {
                                close(true);
                            }
                        } else if (hVar.hasSubMenu()) {
                            if ((i & 4) == 0) {
                                close(false);
                            }
                            if (!hVar.hasSubMenu()) {
                                m mVar2 = new m(this.mContext, this, hVar);
                                hVar.o = mVar2;
                                mVar2.setHeaderTitle(hVar.e);
                            }
                            mVar = hVar.o;
                            if (z) {
                                hh0 hh0Var = hh0.this;
                                bVar2.a.onPrepareSubMenu(mVar);
                            }
                            copyOnWriteArrayList = this.mPresenters;
                            if (!copyOnWriteArrayList.isEmpty()) {
                                if (jVar != null) {
                                }
                                for (WeakReference weakReference : copyOnWriteArrayList) {
                                    jVar2 = (j) weakReference.get();
                                    if (jVar2 == null) {
                                        copyOnWriteArrayList.remove(weakReference);
                                    } else if (!zOnSubMenuSelected) {
                                        zOnSubMenuSelected = jVar2.onSubMenuSelected(mVar);
                                    }
                                }
                            }
                            zExpandActionView |= zOnSubMenuSelected;
                            if (!zExpandActionView) {
                                close(true);
                            }
                        } else {
                            if ((i & 4) == 0) {
                                close(false);
                            }
                            if (!hVar.hasSubMenu()) {
                                m mVar3 = new m(this.mContext, this, hVar);
                                hVar.o = mVar3;
                                mVar3.setHeaderTitle(hVar.e);
                            }
                            mVar = hVar.o;
                            if (z) {
                                hh0 hh0Var2 = hh0.this;
                                bVar2.a.onPrepareSubMenu(mVar);
                            }
                            copyOnWriteArrayList = this.mPresenters;
                            if (!copyOnWriteArrayList.isEmpty()) {
                                zOnSubMenuSelected = jVar != null ? jVar.onSubMenuSelected(mVar) : false;
                                while (r8.hasNext()) {
                                    jVar2 = (j) weakReference.get();
                                    if (jVar2 == null) {
                                        copyOnWriteArrayList.remove(weakReference);
                                    } else if (!zOnSubMenuSelected) {
                                        zOnSubMenuSelected = jVar2.onSubMenuSelected(mVar);
                                    }
                                }
                            }
                            zExpandActionView |= zOnSubMenuSelected;
                            if (!zExpandActionView) {
                                close(true);
                            }
                        }
                        return zExpandActionView;
                    }
                    zExpandActionView = true;
                } else {
                    bVar = hVar.A;
                    if (bVar == null && bVar.a.onPerformDefaultAction()) {
                        zExpandActionView = true;
                    } else {
                        zExpandActionView = false;
                    }
                }
            }
        } else {
            zExpandActionView = true;
        }
        bVar2 = hVar.A;
        if (bVar2 == null && bVar2.a.hasSubMenu()) {
            z = true;
        } else {
            z = false;
        }
        if (hVar.e()) {
            zExpandActionView |= hVar.expandActionView();
            if (zExpandActionView) {
                close(true);
            }
        } else if (hVar.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                close(false);
            }
            if (!hVar.hasSubMenu()) {
                m mVar4 = new m(this.mContext, this, hVar);
                hVar.o = mVar4;
                mVar4.setHeaderTitle(hVar.e);
            }
            mVar = hVar.o;
            if (z) {
                hh0 hh0Var3 = hh0.this;
                bVar2.a.onPrepareSubMenu(mVar);
            }
            copyOnWriteArrayList = this.mPresenters;
            if (!copyOnWriteArrayList.isEmpty()) {
                if (jVar != null) {
                }
                while (r8.hasNext()) {
                    jVar2 = (j) weakReference.get();
                    if (jVar2 == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else if (!zOnSubMenuSelected) {
                        zOnSubMenuSelected = jVar2.onSubMenuSelected(mVar);
                    }
                }
            }
            zExpandActionView |= zOnSubMenuSelected;
            if (!zExpandActionView) {
                close(true);
            }
        } else if ((i & 1) == 0) {
            close(true);
        }
        return zExpandActionView;
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        h hVarFindItemWithShortcutForKey = findItemWithShortcutForKey(i, keyEvent);
        boolean zPerformItemAction = hVarFindItemWithShortcutForKey != null ? performItemAction(hVarFindItemWithShortcutForKey, null, i2) : false;
        if ((i2 & 2) != 0) {
            close(true);
        }
        return zPerformItemAction;
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        ArrayList arrayList = this.mItems;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (((h) arrayList.get(i3)).b == i) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int size2 = arrayList.size() - i3;
            while (true) {
                int i4 = i2 + 1;
                if (i2 >= size2 || ((h) arrayList.get(i3)).b != i) {
                    break;
                }
                if (i3 >= 0 && i3 < arrayList.size()) {
                    arrayList.remove(i3);
                }
                i2 = i4;
            }
            onItemsChanged(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        ArrayList arrayList = this.mItems;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (((h) arrayList.get(i2)).a == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= arrayList.size()) {
            return;
        }
        arrayList.remove(i2);
        onItemsChanged(true);
    }

    public final void removeMenuPresenter(j jVar) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.mPresenters;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            j jVar2 = (j) weakReference.get();
            if (jVar2 == null || jVar2 == jVar) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    public final void restoreActionViewStates(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
        int size = this.mItems.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).restoreActionViewStates(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (menuItemFindItem = findItem(i2)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public final void restorePresenterStates(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null) {
            CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.mPresenters;
            if (copyOnWriteArrayList.isEmpty()) {
                return;
            }
            for (WeakReference weakReference : copyOnWriteArrayList) {
                j jVar = (j) weakReference.get();
                if (jVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    int id = jVar.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        jVar.onRestoreInstanceState(parcelable);
                    }
                }
            }
        }
    }

    public final void saveActionViewStates(Bundle bundle) {
        int size = this.mItems.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public final void savePresenterStates(Bundle bundle) {
        Parcelable parcelableOnSaveInstanceState;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.mPresenters;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                int id = jVar.getId();
                if (id > 0 && (parcelableOnSaveInstanceState = jVar.onSaveInstanceState()) != null) {
                    sparseArray.put(id, parcelableOnSaveInstanceState);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z, boolean z2) {
        ArrayList arrayList = this.mItems;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) arrayList.get(i2);
            if (hVar.b == i) {
                hVar.f(z2);
                hVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.mGroupDividerEnabled = z;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z) {
        ArrayList arrayList = this.mItems;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) arrayList.get(i2);
            if (hVar.b == i) {
                hVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z) {
        ArrayList arrayList = this.mItems;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) arrayList.get(i2);
            if (hVar.b == i) {
                int i3 = hVar.x;
                int i4 = (i3 & (-9)) | (z ? 0 : 8);
                hVar.x = i4;
                if (i3 != i4) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            onItemsChanged(true);
        }
    }

    public final void setHeaderInternal(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        if (view != null) {
            this.mHeaderView = view;
            this.mHeaderTitle = null;
            this.mHeaderIcon = null;
        } else {
            if (i > 0) {
                this.mHeaderTitle = this.mResources.getText(i);
            } else if (charSequence != null) {
                this.mHeaderTitle = charSequence;
            }
            if (i2 > 0) {
                this.mHeaderIcon = this.mContext.getDrawable(i2);
            } else if (drawable != null) {
                this.mHeaderIcon = drawable;
            }
            this.mHeaderView = null;
        }
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.mQwertyMode = z;
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.mItems.size();
    }

    public final void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if (this.mItemsChangedWhileDispatchPrevented) {
            this.mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        }
    }

    public final void stopDispatchingItemsChanged() {
        if (this.mPreventDispatchingItemsChanged) {
            return;
        }
        this.mPreventDispatchingItemsChanged = true;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
    }
}
