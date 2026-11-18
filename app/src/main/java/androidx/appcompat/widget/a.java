package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.m;
import defpackage.b01;
import defpackage.b2;
import defpackage.bv;
import defpackage.hh0;
import defpackage.ih0;
import java.util.ArrayList;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class a extends androidx.appcompat.view.menu.a {
    public C0001a A;
    public c B;
    public b C;
    public final f D;
    public int E;
    public d p;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public final SparseBooleanArray y;
    public e z;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class C0001a extends i {
        public C0001a(Context context, m mVar, View view) {
            super(context, mVar, view, false);
            if ((mVar.mItem.x & 32) != 32) {
                View view2 = a.this.p;
                this.f = view2 == null ? (View) a.this.n : view2;
            }
            f fVar = a.this.D;
            this.i = fVar;
            ih0 ih0Var = this.j;
            if (ih0Var != null) {
                ih0Var.setCallback(fVar);
            }
        }

        @Override // androidx.appcompat.view.menu.i
        public final void c() {
            a aVar = a.this;
            aVar.A = null;
            aVar.E = 0;
            super.c();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b extends ActionMenuItemView.b {
        public b() {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c implements Runnable {
        public final e b;

        public c(e eVar) {
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            androidx.appcompat.view.menu.f.a aVar;
            a aVar2 = a.this;
            androidx.appcompat.view.menu.f fVar = aVar2.d;
            if (fVar != null && (aVar = fVar.mCallback) != null) {
                aVar.onMenuModeChange(fVar);
            }
            View view = (View) aVar2.n;
            if (view != null && view.getWindowToken() != null) {
                e eVar = this.b;
                if (eVar.b()) {
                    aVar2.z = eVar;
                } else if (eVar.f != null) {
                    eVar.d(0, 0, false, false);
                    aVar2.z = eVar;
                }
            }
            aVar2.B = null;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d extends AppCompatImageView implements ActionMenuView.a {

        /* JADX INFO: renamed from: androidx.appcompat.widget.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class C0002a extends bv {
            public C0002a(View view) {
                super(view);
            }

            @Override // defpackage.bv
            public final b01 b() {
                e eVar = a.this.z;
                if (eVar == null) {
                    return null;
                }
                return eVar.a();
            }

            @Override // defpackage.bv
            public final boolean c() {
                a.this.d();
                return true;
            }

            @Override // defpackage.bv
            public final boolean d() {
                a aVar = a.this;
                if (aVar.B != null) {
                    return false;
                }
                aVar.b();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, R.style.ab);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            b2.a(getContentDescription(), this);
            setOnTouchListener(new C0002a(this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public final boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public final boolean b() {
            return false;
        }

        @Override // android.view.View
        public final boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            a.this.d();
            return true;
        }

        @Override // android.widget.ImageView
        public final boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                background.setHotspotBounds(paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class e extends i {
        public e(Context context, androidx.appcompat.view.menu.f fVar, d dVar) {
            super(context, fVar, dVar, true);
            this.g = 8388613;
            f fVar2 = a.this.D;
            this.i = fVar2;
            ih0 ih0Var = this.j;
            if (ih0Var != null) {
                ih0Var.setCallback(fVar2);
            }
        }

        @Override // androidx.appcompat.view.menu.i
        public final void c() {
            a aVar = a.this;
            androidx.appcompat.view.menu.f fVar = aVar.d;
            if (fVar != null) {
                fVar.close(true);
            }
            aVar.z = null;
            super.c();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class f implements j.a {
        public f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final boolean a(androidx.appcompat.view.menu.f fVar) {
            a aVar = a.this;
            if (fVar == aVar.d) {
                return false;
            }
            aVar.E = ((m) fVar).mItem.a;
            j.a aVar2 = aVar.g;
            if (aVar2 != null) {
                return aVar2.a(fVar);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final void onCloseMenu(androidx.appcompat.view.menu.f fVar, boolean z) {
            if (fVar instanceof m) {
                ((m) fVar).mParentMenu.getRootMenu().close(false);
            }
            j.a aVar = a.this.g;
            if (aVar != null) {
                aVar.onCloseMenu(fVar, z);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new C0003a();
        public int b;

        /* JADX INFO: renamed from: androidx.appcompat.widget.a$g$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class C0003a implements Parcelable.Creator<g> {
            @Override // android.os.Parcelable.Creator
            public final g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final g[] newArray(int i) {
                return new g[i];
            }
        }

        public g() {
        }

        public g(Parcel parcel) {
            this.b = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.b);
        }
    }

    public a(Context context) {
        super(context);
        this.y = new SparseBooleanArray();
        this.D = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View a(h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.e()) {
            boolean z = view instanceof k.a;
            Object objInflate = view;
            if (!z) {
                objInflate = this.f.inflate(this.j, viewGroup, false);
            }
            k.a aVar = (k.a) objInflate;
            aVar.initialize(hVar);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
            actionMenuItemView.f = (ActionMenuView) this.n;
            if (this.C == null) {
                this.C = new b();
            }
            actionMenuItemView.i = this.C;
            actionView = (View) aVar;
        }
        actionView.setVisibility(hVar.C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof ActionMenuView.c)) {
            actionView.setLayoutParams(ActionMenuView.b(layoutParams));
        }
        return actionView;
    }

    public final boolean b() {
        Object obj;
        c cVar = this.B;
        if (cVar != null && (obj = this.n) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.B = null;
            return true;
        }
        e eVar = this.z;
        if (eVar == null) {
            return false;
        }
        if (eVar.b()) {
            eVar.j.dismiss();
        }
        return true;
    }

    public final boolean c() {
        e eVar = this.z;
        return eVar != null && eVar.b();
    }

    public final boolean d() {
        androidx.appcompat.view.menu.f fVar;
        if (!this.s || c() || (fVar = this.d) == null || this.n == null || this.B != null) {
            return false;
        }
        fVar.flagActionItems();
        if (fVar.mNonActionItems.isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.c, this.d, this.p));
        this.B = cVar;
        ((View) this.n).post(cVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean flagActionItems() {
        int size;
        ArrayList visibleItems;
        int i;
        boolean z;
        a aVar = this;
        androidx.appcompat.view.menu.f fVar = aVar.d;
        if (fVar != null) {
            visibleItems = fVar.getVisibleItems();
            size = visibleItems.size();
        } else {
            size = 0;
            visibleItems = null;
        }
        int i2 = aVar.w;
        int i3 = aVar.v;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) aVar.n;
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = 2;
            z = true;
            if (i4 >= size) {
                break;
            }
            h hVar = (h) visibleItems.get(i4);
            int i7 = hVar.y;
            if ((i7 & 2) == 2) {
                i5++;
            } else if ((i7 & 1) == 1) {
                i6++;
            } else {
                z2 = true;
            }
            if (aVar.x && hVar.C) {
                i2 = 0;
            }
            i4++;
        }
        if (aVar.s && (z2 || i6 + i5 > i2)) {
            i2--;
        }
        int i8 = i2 - i5;
        SparseBooleanArray sparseBooleanArray = aVar.y;
        sparseBooleanArray.clear();
        int i9 = 0;
        int i10 = 0;
        while (i9 < size) {
            h hVar2 = (h) visibleItems.get(i9);
            int i11 = hVar2.y;
            boolean z3 = (i11 & 2) == i ? z : false;
            int i12 = hVar2.b;
            if (z3) {
                View viewA = aVar.a(hVar2, null, viewGroup);
                viewA.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewA.getMeasuredWidth();
                i3 -= measuredWidth;
                if (i10 == 0) {
                    i10 = measuredWidth;
                }
                if (i12 != 0) {
                    sparseBooleanArray.put(i12, z);
                }
                hVar2.g(z);
            } else {
                if ((i11 & 1) == z) {
                    boolean z4 = sparseBooleanArray.get(i12);
                    boolean z5 = ((i8 > 0 || z4) && i3 > 0) ? z : false;
                    if (z5) {
                        View viewA2 = aVar.a(hVar2, null, viewGroup);
                        viewA2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        int measuredWidth2 = viewA2.getMeasuredWidth();
                        i3 -= measuredWidth2;
                        if (i10 == 0) {
                            i10 = measuredWidth2;
                        }
                        z5 &= i3 + i10 > 0;
                    }
                    if (z5 && i12 != 0) {
                        sparseBooleanArray.put(i12, true);
                    } else if (z4) {
                        sparseBooleanArray.put(i12, false);
                        for (int i13 = 0; i13 < i9; i13++) {
                            h hVar3 = (h) visibleItems.get(i13);
                            if (hVar3.b == i12) {
                                if ((hVar3.x & 32) == 32) {
                                    i8++;
                                }
                                hVar3.g(false);
                            }
                        }
                    }
                    if (z5) {
                        i8--;
                    }
                    hVar2.g(z5);
                } else {
                    hVar2.g(false);
                }
                i9++;
                i = 2;
                aVar = this;
                z = true;
            }
            i9++;
            i = 2;
            aVar = this;
            z = true;
        }
        return z;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void initForMenu(Context context, androidx.appcompat.view.menu.f fVar) {
        this.c = context;
        LayoutInflater.from(context);
        this.d = fVar;
        Resources resources = context.getResources();
        if (!this.t) {
            this.s = true;
        }
        int i = 2;
        this.u = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
            i = 5;
        } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
            i = 4;
        } else if (i2 >= 360) {
            i = 3;
        }
        this.w = i;
        int measuredWidth = this.u;
        if (this.s) {
            if (this.p == null) {
                this.p = new d(this.b);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.p.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.p.getMeasuredWidth();
        } else {
            this.p = null;
        }
        this.v = measuredWidth;
        float f2 = resources.getDisplayMetrics().density;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void onCloseMenu(androidx.appcompat.view.menu.f fVar, boolean z) {
        b();
        C0001a c0001a = this.A;
        if (c0001a != null && c0001a.b()) {
            c0001a.j.dismiss();
        }
        j.a aVar = this.g;
        if (aVar != null) {
            aVar.onCloseMenu(fVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof g) && (i = ((g) parcelable).b) > 0 && (menuItemFindItem = this.d.findItem(i)) != null) {
            onSubMenuSelected((m) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final Parcelable onSaveInstanceState() {
        g gVar = new g();
        gVar.b = this.E;
        return gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.j
    public final boolean onSubMenuSelected(m mVar) {
        View childAt;
        boolean z;
        if (mVar.hasVisibleItems()) {
            m mVar2 = mVar;
            while (true) {
                androidx.appcompat.view.menu.f fVar = mVar2.mParentMenu;
                if (fVar == this.d) {
                    break;
                }
                mVar2 = (m) fVar;
            }
            h hVar = mVar2.mItem;
            ViewGroup viewGroup = (ViewGroup) this.n;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        childAt = 0;
                        break;
                    }
                    childAt = viewGroup.getChildAt(i);
                    if ((childAt instanceof k.a) && ((k.a) childAt).getItemData() == hVar) {
                        break;
                    }
                    i++;
                }
            } else {
                childAt = 0;
                break;
            }
            if (childAt != 0) {
                this.E = mVar.mItem.a;
                int size = mVar.mItems.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        break;
                    }
                    MenuItem item = mVar.getItem(i2);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                C0001a c0001a = new C0001a(this.c, mVar, childAt);
                this.A = c0001a;
                c0001a.h = z;
                ih0 ih0Var = c0001a.j;
                if (ih0Var != null) {
                    ih0Var.e(z);
                }
                C0001a c0001a2 = this.A;
                if (!c0001a2.b()) {
                    if (c0001a2.f == null) {
                        defpackage.d.AnonymousClass0.m("MenuPopupHelper cannot be used without an anchor");
                        return false;
                    }
                    c0001a2.d(0, 0, false, false);
                }
                j.a aVar = this.g;
                if (aVar != null) {
                    aVar.a(mVar);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.j
    public final void updateMenuView(boolean z) {
        int i;
        ViewGroup viewGroup = (ViewGroup) this.n;
        ArrayList arrayList = null;
        boolean z2 = false;
        if (viewGroup != null) {
            androidx.appcompat.view.menu.f fVar = this.d;
            if (fVar != null) {
                fVar.flagActionItems();
                ArrayList visibleItems = this.d.getVisibleItems();
                int size = visibleItems.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    h hVar = (h) visibleItems.get(i2);
                    if ((hVar.x & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i);
                        h itemData = childAt instanceof k.a ? ((k.a) childAt).getItemData() : null;
                        View viewA = a(hVar, childAt, viewGroup);
                        if (hVar != itemData) {
                            viewA.setPressed(false);
                            viewA.jumpDrawablesToCurrentState();
                        }
                        if (viewA != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) viewA.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(viewA);
                            }
                            ((ViewGroup) this.n).addView(viewA, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i) == this.p) {
                    i++;
                } else {
                    viewGroup.removeViewAt(i);
                }
            }
        }
        ((View) this.n).requestLayout();
        androidx.appcompat.view.menu.f fVar2 = this.d;
        if (fVar2 != null) {
            fVar2.flagActionItems();
            ArrayList arrayList2 = fVar2.mActionItems;
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                hh0.b bVar = ((h) arrayList2.get(i3)).A;
            }
        }
        androidx.appcompat.view.menu.f fVar3 = this.d;
        if (fVar3 != null) {
            fVar3.flagActionItems();
            arrayList = fVar3.mNonActionItems;
        }
        if (this.s && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z2 = !((h) arrayList.get(0)).C;
            } else if (size3 > 0) {
                z2 = true;
            }
        }
        d dVar = this.p;
        if (z2) {
            if (dVar == null) {
                this.p = new d(this.b);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.p.getParent();
            if (viewGroup3 != this.n) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.p);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.n;
                d dVar2 = this.p;
                actionMenuView.getClass();
                ActionMenuView.c cVar = new ActionMenuView.c();
                ((LinearLayout.LayoutParams) cVar).gravity = 16;
                cVar.a = true;
                actionMenuView.addView(dVar2, cVar);
            }
        } else if (dVar != null) {
            Object parent = dVar.getParent();
            Object obj = this.n;
            if (parent == obj) {
                ((ViewGroup) obj).removeView(this.p);
            }
        }
        ((ActionMenuView) this.n).f = this.s;
    }
}
