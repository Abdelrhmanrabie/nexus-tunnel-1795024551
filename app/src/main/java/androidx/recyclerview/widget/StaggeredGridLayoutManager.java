package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.qd1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    public final int a;
    public final f[] b;
    public final u c;
    public final u d;
    public final int e;
    public int f;
    public final p g;
    public boolean h;
    public final BitSet j;
    public final d m;
    public final int n;
    public boolean o;
    public boolean p;
    public e q;
    public final Rect r;
    public final b s;
    public final boolean t;
    public int[] u;
    public final a v;
    public boolean i = false;
    public int k = -1;
    public int l = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            StaggeredGridLayoutManager.this.b();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b {
        public int a;
        public int b;
        public boolean c;
        public boolean d;
        public boolean e;
        public int[] f;

        public b() {
            a();
        }

        public final void a() {
            this.a = -1;
            this.b = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class c extends RecyclerView.p {
        public f e;

        public c(int i, int i2) {
            super(i, i2);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class d {
        public int[] a;
        public ArrayList b;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0024a();
            public int b;
            public final int c;
            public final int[] d;
            public final boolean f;

            /* JADX INFO: renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public class C0024a implements Parcelable.Creator<a> {
                @Override // android.os.Parcelable.Creator
                public final a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                public final a[] newArray(int i) {
                    return new a[i];
                }
            }

            public a() {
            }

            public a(Parcel parcel) {
                this.b = parcel.readInt();
                this.c = parcel.readInt();
                this.f = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    int[] iArr = new int[i];
                    this.d = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            public final String toString() {
                return "FullSpanItem{mPosition=" + this.b + ", mGapDir=" + this.c + ", mHasUnwantedGapAfter=" + this.f + ", mGapPerSpan=" + Arrays.toString(this.d) + '}';
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.b);
                parcel.writeInt(this.c);
                parcel.writeInt(this.f ? 1 : 0);
                int[] iArr = this.d;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(iArr);
                }
            }
        }

        public final void a() {
            int[] iArr = this.a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.b = null;
        }

        public final void b(int i) {
            int[] iArr = this.a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int length = iArr.length;
                while (length <= i) {
                    length *= 2;
                }
                int[] iArr3 = new int[length];
                this.a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public final void d(int i, int i2) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            b(i3);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.a, i, i3, -1);
            ArrayList arrayList = this.b;
            if (arrayList == null) {
                return;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                a aVar = (a) this.b.get(size);
                int i4 = aVar.b;
                if (i4 >= i) {
                    aVar.b = i4 + i2;
                }
            }
        }

        public final void e(int i, int i2) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            b(i3);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            ArrayList arrayList = this.b;
            if (arrayList == null) {
                return;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                a aVar = (a) this.b.get(size);
                int i4 = aVar.b;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.b.remove(size);
                    } else {
                        aVar.b = i4 - i2;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();
        public int b;
        public int c;
        public int d;
        public int[] f;
        public int g;
        public int[] i;
        public ArrayList j;
        public boolean n;
        public boolean o;
        public boolean p;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Parcelable.Creator<e> {
            @Override // android.os.Parcelable.Creator
            public final e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final e[] newArray(int i) {
                return new e[i];
            }
        }

        public e() {
        }

        public e(Parcel parcel) {
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            int i = parcel.readInt();
            this.d = i;
            if (i > 0) {
                int[] iArr = new int[i];
                this.f = iArr;
                parcel.readIntArray(iArr);
            }
            int i2 = parcel.readInt();
            this.g = i2;
            if (i2 > 0) {
                int[] iArr2 = new int[i2];
                this.i = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.n = parcel.readInt() == 1;
            this.o = parcel.readInt() == 1;
            this.p = parcel.readInt() == 1;
            this.j = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.d = eVar.d;
            this.b = eVar.b;
            this.c = eVar.c;
            this.f = eVar.f;
            this.g = eVar.g;
            this.i = eVar.i;
            this.n = eVar.n;
            this.o = eVar.o;
            this.p = eVar.p;
            this.j = eVar.j;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            if (this.d > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.g);
            if (this.g > 0) {
                parcel.writeIntArray(this.i);
            }
            parcel.writeInt(this.n ? 1 : 0);
            parcel.writeInt(this.o ? 1 : 0);
            parcel.writeInt(this.p ? 1 : 0);
            parcel.writeList(this.j);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class f {
        public final ArrayList a = new ArrayList();
        public int b = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        public int c = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        public int d = 0;
        public final int e;

        public f(int i) {
            this.e = i;
        }

        public final void a() {
            ArrayList arrayList = this.a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            c cVar = (c) view.getLayoutParams();
            this.c = StaggeredGridLayoutManager.this.c.b(view);
            cVar.getClass();
        }

        public final void b() {
            this.a.clear();
            this.b = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.c = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.d = 0;
        }

        public final int c() {
            boolean z = StaggeredGridLayoutManager.this.h;
            ArrayList arrayList = this.a;
            return z ? e(arrayList.size() - 1, -1) : e(0, arrayList.size());
        }

        public final int d() {
            boolean z = StaggeredGridLayoutManager.this.h;
            ArrayList arrayList = this.a;
            return z ? e(0, arrayList.size()) : e(arrayList.size() - 1, -1);
        }

        public final int e(int i, int i2) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            int iK = staggeredGridLayoutManager.c.k();
            u uVar = staggeredGridLayoutManager.c;
            int iG = uVar.g();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = (View) this.a.get(i);
                int iE = uVar.e(view);
                int iB = uVar.b(view);
                boolean z = iE <= iG;
                boolean z2 = iB >= iK;
                if (z && z2 && (iE < iK || iB > iG)) {
                    return RecyclerView.o.getPosition(view);
                }
                i += i3;
            }
            return -1;
        }

        public final int f(int i) {
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.a.size() == 0) {
                return i;
            }
            a();
            return this.c;
        }

        public final View g(int i, int i2) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            ArrayList arrayList = this.a;
            View view = null;
            if (i2 != -1) {
                int size = arrayList.size() - 1;
                while (size >= 0) {
                    View view2 = (View) arrayList.get(size);
                    if ((staggeredGridLayoutManager.h && RecyclerView.o.getPosition(view2) >= i) || ((!staggeredGridLayoutManager.h && RecyclerView.o.getPosition(view2) <= i) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
                return view;
            }
            int size2 = arrayList.size();
            int i3 = 0;
            while (i3 < size2) {
                View view3 = (View) arrayList.get(i3);
                if ((staggeredGridLayoutManager.h && RecyclerView.o.getPosition(view3) <= i) || ((!staggeredGridLayoutManager.h && RecyclerView.o.getPosition(view3) >= i) || !view3.hasFocusable())) {
                    break;
                }
                i3++;
                view = view3;
            }
            return view;
        }

        public final int i(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            ArrayList arrayList = this.a;
            if (arrayList.size() == 0) {
                return i;
            }
            View view = (View) arrayList.get(0);
            c cVar = (c) view.getLayoutParams();
            this.b = StaggeredGridLayoutManager.this.c.e(view);
            cVar.getClass();
            return this.b;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.a = -1;
        this.h = false;
        d dVar = new d();
        this.m = dVar;
        this.n = 2;
        this.r = new Rect();
        this.s = new b();
        this.t = true;
        this.v = new a();
        RecyclerView.o.d properties = RecyclerView.o.getProperties(context, attributeSet, i, i2);
        int i3 = properties.a;
        if (i3 != 0 && i3 != 1) {
            defpackage.d.AnonymousClass0.m$2("invalid orientation.");
            throw null;
        }
        assertNotInLayoutOrScroll(null);
        if (i3 != this.e) {
            this.e = i3;
            u uVar = this.c;
            this.c = this.d;
            this.d = uVar;
            requestLayout();
        }
        int i4 = properties.b;
        assertNotInLayoutOrScroll(null);
        if (i4 != -1) {
            dVar.a();
            requestLayout();
            this.a = i4;
            this.j = new BitSet(i4);
            this.b = new f[i4];
            for (int i5 = 0; i5 < this.a; i5++) {
                this.b[i5] = new f(i5);
            }
            requestLayout();
        }
        boolean z = properties.c;
        assertNotInLayoutOrScroll(null);
        e eVar = this.q;
        if (eVar != null && eVar.n != z) {
            eVar.n = z;
        }
        this.h = z;
        requestLayout();
        this.g = new p();
        this.c = u.a(this, this.e);
        this.d = u.a(this, 1 - this.e);
    }

    public static int w(int i, int i2, int i3) {
        int mode;
        return (!(i2 == 0 && i3 == 0) && ((mode = View.MeasureSpec.getMode(i)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void assertNotInLayoutOrScroll(String str) {
        if (this.q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public final boolean b() {
        int iH;
        if (getChildCount() == 0 || this.n == 0 || !this.mIsAttachedToWindow) {
            return false;
        }
        if (this.i) {
            iH = i();
            h();
        } else {
            iH = h();
            i();
        }
        if (iH != 0 || m() == null) {
            return false;
        }
        this.m.a();
        this.mRequestedSimpleAnimations = true;
        requestLayout();
        return true;
    }

    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v20 */
    public final int c(RecyclerView.v vVar, p pVar, RecyclerView.a0 a0Var) {
        f[] fVarArr;
        int iG;
        int i;
        f[] fVarArr2;
        f fVar;
        ?? r11;
        int childMeasureSpec;
        int i2;
        int childMeasureSpec2;
        int i3;
        int iC;
        int i4;
        int iC2;
        int iG2;
        int i5;
        int i6;
        int i7;
        BitSet bitSet;
        int i8;
        int i9;
        BitSet bitSet2 = this.j;
        int i10 = this.a;
        int i11 = 0;
        int i12 = 1;
        bitSet2.set(0, i10, true);
        p pVar2 = this.g;
        int i13 = pVar2.i ? pVar.e == 1 ? Integer.MAX_VALUE : AttribFlags.SSH_FILEXFER_ATTR_EXTENDED : pVar.e == 1 ? pVar.g + pVar.b : pVar.f - pVar.b;
        int i14 = pVar.e;
        int i15 = 0;
        while (true) {
            fVarArr = this.b;
            if (i15 >= i10) {
                break;
            }
            if (!fVarArr[i15].a.isEmpty()) {
                v(fVarArr[i15], i14, i13);
            }
            i15++;
        }
        boolean z = this.i;
        u uVar = this.c;
        int iG3 = z ? uVar.g() : uVar.k();
        boolean z2 = false;
        while (true) {
            int i16 = pVar.c;
            int i17 = (i16 < 0 || i16 >= a0Var.b()) ? i11 : i12;
            int i18 = -1;
            if (i17 == 0 || (!pVar2.i && bitSet2.isEmpty())) {
                break;
            }
            int i19 = iG3;
            View view = vVar.j(pVar.c, Long.MAX_VALUE).itemView;
            pVar.c += pVar.d;
            c cVar = (c) view.getLayoutParams();
            int layoutPosition = cVar.a.getLayoutPosition();
            d dVar = this.m;
            int[] iArr = dVar.a;
            int i20 = (iArr == null || layoutPosition >= iArr.length) ? -1 : iArr[layoutPosition];
            if (i20 == -1) {
                if (o(pVar.e)) {
                    i9 = i10 - 1;
                    i8 = -1;
                } else {
                    i18 = i10;
                    i8 = 1;
                    i9 = 0;
                }
                f fVar2 = null;
                int i21 = i8;
                if (pVar.e == 1) {
                    int iK = uVar.k();
                    fVarArr2 = fVarArr;
                    int i22 = i9;
                    int i23 = Integer.MAX_VALUE;
                    while (i22 != i18) {
                        int i24 = i22;
                        f fVar3 = fVarArr2[i24];
                        int i25 = i10;
                        int iF = fVar3.f(iK);
                        if (iF < i23) {
                            i23 = iF;
                            fVar2 = fVar3;
                        }
                        i22 = i24 + i21;
                        i10 = i25;
                    }
                    i = i10;
                } else {
                    i = i10;
                    fVarArr2 = fVarArr;
                    int iG4 = uVar.g();
                    int i26 = i9;
                    int i27 = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                    while (i26 != i18) {
                        f fVar4 = fVarArr2[i26];
                        int i28 = i26;
                        int i29 = fVar4.i(iG4);
                        if (i29 > i27) {
                            i27 = i29;
                            fVar2 = fVar4;
                        }
                        i26 = i28 + i21;
                    }
                }
                fVar = fVar2;
                dVar.b(layoutPosition);
                dVar.a[layoutPosition] = fVar.e;
            } else {
                i = i10;
                fVarArr2 = fVarArr;
                fVar = fVarArr2[i20];
            }
            cVar.e = fVar;
            if (pVar.e == 1) {
                r11 = 0;
                addViewInt(view, -1, false);
            } else {
                r11 = 0;
                addViewInt(view, 0, false);
            }
            int i30 = this.e;
            if (i30 == 1) {
                int childMeasureSpec3 = RecyclerView.o.getChildMeasureSpec(r11, this.f, this.mWidthMode, r11, ((ViewGroup.MarginLayoutParams) cVar).width);
                childMeasureSpec2 = RecyclerView.o.getChildMeasureSpec(true, this.mHeight, this.mHeightMode, getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) cVar).height);
                childMeasureSpec = childMeasureSpec3;
                i2 = 0;
            } else {
                childMeasureSpec = RecyclerView.o.getChildMeasureSpec(true, this.mWidth, this.mWidthMode, getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) cVar).width);
                i2 = 0;
                childMeasureSpec2 = RecyclerView.o.getChildMeasureSpec(false, this.f, this.mHeightMode, 0, ((ViewGroup.MarginLayoutParams) cVar).height);
            }
            RecyclerView recyclerView = this.mRecyclerView;
            Rect rect = this.r;
            if (recyclerView == null) {
                rect.set(i2, i2, i2, i2);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
            c cVar2 = (c) view.getLayoutParams();
            BitSet bitSet3 = bitSet2;
            int iW = w(childMeasureSpec, ((ViewGroup.MarginLayoutParams) cVar2).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) cVar2).rightMargin + rect.right);
            int iW2 = w(childMeasureSpec2, ((ViewGroup.MarginLayoutParams) cVar2).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) cVar2).bottomMargin + rect.bottom);
            if (shouldMeasureChild(view, iW, iW2, cVar2)) {
                view.measure(iW, iW2);
            }
            iG3 = i19;
            if (pVar.e == 1) {
                iC = fVar.f(iG3);
                i3 = uVar.c(view) + iC;
            } else {
                i3 = fVar.i(iG3);
                iC = i3 - uVar.c(view);
            }
            int i31 = pVar.e;
            f fVar5 = cVar.e;
            fVar5.getClass();
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            ArrayList arrayList = fVar5.a;
            int i32 = iC;
            if (i31 == 1) {
                c cVar3 = (c) view.getLayoutParams();
                cVar3.e = fVar5;
                arrayList.add(view);
                fVar5.c = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                i4 = i3;
                if (arrayList.size() == 1) {
                    fVar5.b = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                }
                if (cVar3.a.isRemoved() || cVar3.a.isUpdated()) {
                    fVar5.d = staggeredGridLayoutManager.c.c(view) + fVar5.d;
                }
            } else {
                i4 = i3;
                c cVar4 = (c) view.getLayoutParams();
                cVar4.e = fVar5;
                arrayList.add(0, view);
                fVar5.b = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                if (arrayList.size() == 1) {
                    fVar5.c = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                }
                if (cVar4.a.isRemoved() || cVar4.a.isUpdated()) {
                    fVar5.d = staggeredGridLayoutManager.c.c(view) + fVar5.d;
                }
            }
            boolean zIsLayoutRTL = isLayoutRTL();
            u uVar2 = this.d;
            if (zIsLayoutRTL && i30 == 1) {
                iG2 = uVar2.g() - (((i - 1) - fVar.e) * this.f);
                iC2 = iG2 - uVar2.c(view);
            } else {
                int iK2 = (fVar.e * this.f) + uVar2.k();
                int iC3 = uVar2.c(view) + iK2;
                iC2 = iK2;
                iG2 = iC3;
            }
            if (i30 == 1) {
                i7 = iG2;
                i6 = iC2;
                iC2 = i32;
                i5 = i4;
            } else {
                i5 = iG2;
                i6 = i32;
                i7 = i4;
            }
            RecyclerView.o.layoutDecoratedWithMargins(view, i6, iC2, i7, i5);
            v(fVar, pVar2.e, i13);
            q(vVar, pVar2);
            if (pVar2.h && view.hasFocusable()) {
                int i33 = fVar.e;
                bitSet = bitSet3;
                bitSet.set(i33, false);
            } else {
                bitSet = bitSet3;
            }
            bitSet2 = bitSet;
            i12 = 1;
            z2 = true;
            fVarArr = fVarArr2;
            i10 = i;
            i11 = 0;
        }
        int i34 = i10;
        int i35 = i12;
        f[] fVarArr3 = fVarArr;
        if (!z2) {
            q(vVar, pVar2);
        }
        if (pVar2.e == -1) {
            int iK3 = uVar.k();
            int i36 = fVarArr3[0].i(iK3);
            for (int i37 = i35; i37 < i34; i37++) {
                int i38 = fVarArr3[i37].i(iK3);
                if (i38 < i36) {
                    i36 = i38;
                }
            }
            iG = uVar.k() - i36;
        } else {
            int iG5 = uVar.g();
            int iF2 = fVarArr3[0].f(iG5);
            for (int i39 = i35; i39 < i34; i39++) {
                int iF3 = fVarArr3[i39].f(iG5);
                if (iF3 > iF2) {
                    iF2 = iF3;
                }
            }
            iG = iF2 - uVar.g();
        }
        if (iG > 0) {
            return Math.min(pVar.b, iG);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean canScrollHorizontally() {
        return this.e == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean canScrollVertically() {
        return this.e == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean checkLayoutParams(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.a0 a0Var, m.b bVar) {
        p pVar;
        int i3;
        int i4;
        if (this.e != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        p(i, a0Var);
        int[] iArr = this.u;
        int i5 = this.a;
        if (iArr == null || iArr.length < i5) {
            this.u = new int[i5];
        }
        int i6 = 0;
        int i7 = 0;
        while (true) {
            pVar = this.g;
            if (i6 >= i5) {
                break;
            }
            int i8 = pVar.d;
            f[] fVarArr = this.b;
            if (i8 == -1) {
                i4 = pVar.f;
                i3 = fVarArr[i6].i(i4);
            } else {
                int iF = fVarArr[i6].f(pVar.g);
                i3 = pVar.g;
                i4 = iF;
            }
            int i9 = i4 - i3;
            if (i9 >= 0) {
                this.u[i7] = i9;
                i7++;
            }
            i6++;
        }
        Arrays.sort(this.u, 0, i7);
        for (int i10 = 0; i10 < i7; i10++) {
            int i11 = pVar.c;
            if (i11 < 0 || i11 >= a0Var.b()) {
                return;
            }
            bVar.a(pVar.c, this.u[i10]);
            pVar.c += pVar.d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int computeHorizontalScrollExtent(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.t;
        return y.a(a0Var, this.c, e(z), d(z), this, this.t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int computeHorizontalScrollOffset(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.t;
        return y.b(a0Var, this.c, e(z), d(z), this, this.t, this.i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int computeHorizontalScrollRange(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.t;
        return y.c(a0Var, this.c, e(z), d(z), this, this.t);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0019  */
    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public final PointF computeScrollVectorForPosition(int i) {
        int i2 = 1;
        if (getChildCount() != 0) {
            if ((i < h()) != this.i) {
                i2 = -1;
            }
        } else if (!this.i) {
            i2 = -1;
        }
        PointF pointF = new PointF();
        if (i2 == 0) {
            return null;
        }
        if (this.e == 0) {
            pointF.x = i2;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = i2;
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int computeVerticalScrollExtent(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.t;
        return y.a(a0Var, this.c, e(z), d(z), this, this.t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int computeVerticalScrollOffset(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.t;
        return y.b(a0Var, this.c, e(z), d(z), this, this.t, this.i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int computeVerticalScrollRange(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.t;
        return y.c(a0Var, this.c, e(z), d(z), this, this.t);
    }

    public final View d(boolean z) {
        u uVar = this.c;
        int iK = uVar.k();
        int iG = uVar.g();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int iE = uVar.e(childAt);
            int iB = uVar.b(childAt);
            if (iB > iK && iE < iG) {
                if (iB <= iG || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final View e(boolean z) {
        u uVar = this.c;
        int iK = uVar.k();
        int iG = uVar.g();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int iE = uVar.e(childAt);
            if (uVar.b(childAt) > iK && iE < iG) {
                if (iE >= iK || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final void f(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        f[] fVarArr = this.b;
        int iF = fVarArr[0].f(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
        for (int i = 1; i < this.a; i++) {
            int iF2 = fVarArr[i].f(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
            if (iF2 > iF) {
                iF = iF2;
            }
        }
        if (iF == Integer.MIN_VALUE) {
            return;
        }
        u uVar = this.c;
        int iG = uVar.g() - iF;
        if (iG > 0) {
            int i2 = iG - (-scrollBy(-iG, vVar, a0Var));
            if (!z || i2 <= 0) {
                return;
            }
            uVar.o(i2);
        }
    }

    public final void g(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        f[] fVarArr = this.b;
        int i = fVarArr[0].i(Integer.MAX_VALUE);
        for (int i2 = 1; i2 < this.a; i2++) {
            int i3 = fVarArr[i2].i(Integer.MAX_VALUE);
            if (i3 < i) {
                i = i3;
            }
        }
        if (i == Integer.MAX_VALUE) {
            return;
        }
        u uVar = this.c;
        int iK = i - uVar.k();
        if (iK > 0) {
            int iScrollBy = iK - scrollBy(iK, vVar, a0Var);
            if (!z || iScrollBy <= 0) {
                return;
            }
            uVar.o(-iScrollBy);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final RecyclerView.p generateDefaultLayoutParams() {
        return this.e == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final RecyclerView.p generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final RecyclerView.p generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public final int h() {
        if (getChildCount() == 0) {
            return 0;
        }
        return RecyclerView.o.getPosition(getChildAt(0));
    }

    public final int i() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return RecyclerView.o.getPosition(getChildAt(childCount - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean isAutoMeasureEnabled() {
        return this.n != 0;
    }

    public final boolean isLayoutRTL() {
        RecyclerView recyclerView = this.mRecyclerView;
        WeakHashMap weakHashMap = qd1.a;
        return recyclerView.getLayoutDirection() == 1;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0031  */
    /* JADX WARN: Code duplicated, block: B:24:0x0038  */
    /* JADX WARN: Code duplicated, block: B:27:0x0045 A[LOOP:0: B:23:0x0036->B:27:0x0045, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x004b  */
    /* JADX WARN: Code duplicated, block: B:33:0x0059  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066 A[LOOP:1: B:32:0x0057->B:36:0x0066, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:40:0x007c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0081  */
    /* JADX WARN: Code duplicated, block: B:44:0x0089  */
    /* JADX WARN: Code duplicated, block: B:46:0x0096  */
    /* JADX WARN: Code duplicated, block: B:48:0x0099 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x009c  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:62:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0049 A[EDGE_INSN: B:63:0x0049->B:29:0x0049 BREAK  A[LOOP:0: B:23:0x0036->B:27:0x0045], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x006a A[EDGE_INSN: B:65:0x006a->B:38:0x006a BREAK  A[LOOP:1: B:32:0x0057->B:36:0x0066], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:? A[RETURN, SYNTHETIC] */
    public final void l(int i, int i2, int i3) {
        int i4;
        int i5;
        d dVar;
        int[] iArr;
        int i6;
        ArrayList arrayList;
        int i7;
        int[] iArr2;
        int size;
        d.a aVar;
        int size2;
        int i8;
        int i9 = this.i ? i() : h();
        if (i3 == 8) {
            if (i < i2) {
                i4 = i2 + 1;
            } else {
                i4 = i + 1;
                i5 = i2;
            }
            dVar = this.m;
            iArr = dVar.a;
            if (iArr != null && i5 < iArr.length) {
                arrayList = dVar.b;
                if (arrayList == null) {
                    i7 = -1;
                } else {
                    size = arrayList.size() - 1;
                    while (true) {
                        if (size >= 0) {
                            aVar = null;
                            break;
                        }
                        aVar = (d.a) dVar.b.get(size);
                        if (aVar.b == i5) {
                            break;
                        } else {
                            size--;
                        }
                    }
                    if (aVar != null) {
                        dVar.b.remove(aVar);
                    }
                    size2 = dVar.b.size();
                    i8 = 0;
                    while (true) {
                        if (i8 < size2) {
                            i8 = -1;
                            break;
                        } else if (((d.a) dVar.b.get(i8)).b >= i5) {
                            break;
                        } else {
                            i8++;
                        }
                    }
                    if (i8 != -1) {
                        d.a aVar2 = (d.a) dVar.b.get(i8);
                        dVar.b.remove(i8);
                        i7 = aVar2.b;
                    } else {
                        i7 = -1;
                    }
                }
                iArr2 = dVar.a;
                if (i7 == -1) {
                    Arrays.fill(iArr2, i5, iArr2.length, -1);
                    int length = dVar.a.length;
                } else {
                    Arrays.fill(dVar.a, i5, Math.min(i7 + 1, iArr2.length), -1);
                }
            }
            if (i3 != 1) {
                dVar.d(i, i2);
            } else if (i3 != 2) {
                dVar.e(i, i2);
            } else if (i3 == 8) {
                dVar.e(i, 1);
                dVar.d(i2, 1);
            }
            if (i4 <= i9) {
                return;
            }
            if (this.i) {
                i6 = h();
            } else {
                i6 = i();
            }
            if (i5 <= i6) {
                requestLayout();
            }
        }
        i4 = i + i2;
        i5 = i;
        dVar = this.m;
        iArr = dVar.a;
        if (iArr != null) {
            arrayList = dVar.b;
            if (arrayList == null) {
                i7 = -1;
            } else {
                size = arrayList.size() - 1;
                while (true) {
                    if (size >= 0) {
                        aVar = null;
                        break;
                    }
                    aVar = (d.a) dVar.b.get(size);
                    if (aVar.b == i5) {
                        break;
                        break;
                    }
                    size--;
                }
                if (aVar != null) {
                    dVar.b.remove(aVar);
                }
                size2 = dVar.b.size();
                i8 = 0;
                while (true) {
                    if (i8 < size2) {
                        i8 = -1;
                        break;
                    } else {
                        if (((d.a) dVar.b.get(i8)).b >= i5) {
                            break;
                            break;
                        }
                        i8++;
                    }
                }
                if (i8 != -1) {
                    d.a aVar3 = (d.a) dVar.b.get(i8);
                    dVar.b.remove(i8);
                    i7 = aVar3.b;
                } else {
                    i7 = -1;
                }
            }
            iArr2 = dVar.a;
            if (i7 == -1) {
                Arrays.fill(iArr2, i5, iArr2.length, -1);
                int length2 = dVar.a.length;
            } else {
                Arrays.fill(dVar.a, i5, Math.min(i7 + 1, iArr2.length), -1);
            }
        }
        if (i3 != 1) {
            dVar.d(i, i2);
        } else if (i3 != 2) {
            dVar.e(i, i2);
        } else if (i3 == 8) {
            dVar.e(i, 1);
            dVar.d(i2, 1);
        }
        if (i4 <= i9) {
            return;
        }
        if (this.i) {
            i6 = h();
        } else {
            i6 = i();
        }
        if (i5 <= i6) {
            requestLayout();
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00df  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x002a A[SYNTHETIC] */
    public final View m() {
        boolean z;
        boolean z2;
        Object obj;
        int childCount = getChildCount();
        int i = childCount - 1;
        int i2 = this.a;
        BitSet bitSet = new BitSet(i2);
        bitSet.set(0, i2, true);
        byte b2 = (this.e == 1 && isLayoutRTL()) ? (byte) 1 : (byte) -1;
        if (this.i) {
            childCount = -1;
        } else {
            i = 0;
        }
        int i3 = i < childCount ? 1 : -1;
        while (i != childCount) {
            View childAt = getChildAt(i);
            c cVar = (c) childAt.getLayoutParams();
            boolean z3 = bitSet.get(cVar.e.e);
            u uVar = this.c;
            if (z3) {
                f fVar = cVar.e;
                if (this.i) {
                    int i4 = fVar.c;
                    if (i4 == Integer.MIN_VALUE) {
                        fVar.a();
                        i4 = fVar.c;
                    }
                    if (i4 < uVar.g()) {
                        ArrayList arrayList = fVar.a;
                        obj = arrayList.get(arrayList.size() - 1);
                        fVar.getClass();
                        ((c) ((View) obj).getLayoutParams()).getClass();
                        return childAt;
                    }
                    bitSet.clear(cVar.e.e);
                } else {
                    int i5 = fVar.b;
                    ArrayList arrayList2 = fVar.a;
                    if (i5 == Integer.MIN_VALUE) {
                        View view = (View) arrayList2.get(0);
                        c cVar2 = (c) view.getLayoutParams();
                        fVar.b = StaggeredGridLayoutManager.this.c.e(view);
                        cVar2.getClass();
                        i5 = fVar.b;
                    }
                    if (i5 > uVar.k()) {
                        obj = arrayList2.get(0);
                        fVar.getClass();
                        ((c) ((View) obj).getLayoutParams()).getClass();
                        return childAt;
                    }
                    bitSet.clear(cVar.e.e);
                }
            }
            i += i3;
            if (i != childCount) {
                View childAt2 = getChildAt(i);
                if (this.i) {
                    int iB = uVar.b(childAt);
                    int iB2 = uVar.b(childAt2);
                    if (iB >= iB2) {
                        if (iB == iB2) {
                            if (cVar.e.e - ((c) childAt2.getLayoutParams()).e.e < 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (b2 < 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z != z2) {
                            }
                        } else {
                            continue;
                        }
                    }
                    return childAt;
                }
                int iE = uVar.e(childAt);
                int iE2 = uVar.e(childAt2);
                if (iE <= iE2) {
                    if (iE == iE2) {
                        if (cVar.e.e - ((c) childAt2.getLayoutParams()).e.e < 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (b2 < 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z != z2) {
                        }
                    } else {
                        continue;
                    }
                }
                return childAt;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x017d  */
    /* JADX WARN: Code duplicated, block: B:107:0x017f  */
    /* JADX WARN: Code duplicated, block: B:256:0x03c6  */
    public final void n(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int i;
        boolean z2;
        boolean z3;
        int i2;
        e eVar;
        int i3;
        int position;
        boolean z4;
        int iG;
        boolean z5;
        int iG2;
        int iG3;
        int iK;
        int iE;
        boolean z6;
        e eVar2 = this.q;
        b bVar = this.s;
        if (!(eVar2 == null && this.k == -1) && a0Var.b() == 0) {
            removeAndRecycleAllViews(vVar);
            bVar.a();
            return;
        }
        boolean z7 = (bVar.e && this.k == -1 && this.q == null) ? false : true;
        StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
        f[] fVarArr = this.b;
        int i4 = this.a;
        d dVar = this.m;
        if (z7) {
            bVar.a();
            e eVar3 = this.q;
            u uVar = this.c;
            if (eVar3 != null) {
                int i5 = eVar3.d;
                if (i5 > 0) {
                    if (i5 == i4) {
                        for (int i6 = 0; i6 < i4; i6++) {
                            fVarArr[i6].b();
                            e eVar4 = this.q;
                            int iG4 = eVar4.f[i6];
                            if (iG4 != Integer.MIN_VALUE) {
                                iG4 += eVar4.o ? uVar.g() : uVar.k();
                            }
                            f fVar = fVarArr[i6];
                            fVar.b = iG4;
                            fVar.c = iG4;
                        }
                    } else {
                        eVar3.f = null;
                        eVar3.d = 0;
                        eVar3.g = 0;
                        eVar3.i = null;
                        eVar3.j = null;
                        eVar3.b = eVar3.c;
                    }
                }
                e eVar5 = this.q;
                this.p = eVar5.p;
                boolean z8 = eVar5.n;
                assertNotInLayoutOrScroll(null);
                e eVar6 = this.q;
                if (eVar6 != null && eVar6.n != z8) {
                    eVar6.n = z8;
                }
                this.h = z8;
                requestLayout();
                resolveShouldLayoutReverse$1();
                e eVar7 = this.q;
                int i7 = eVar7.b;
                if (i7 != -1) {
                    this.k = i7;
                    z6 = eVar7.o;
                } else {
                    z6 = this.i;
                }
                bVar.c = z6;
                if (eVar7.g > 1) {
                    dVar.a = eVar7.i;
                    dVar.b = eVar7.j;
                }
            } else {
                resolveShouldLayoutReverse$1();
                bVar.c = this.i;
            }
            if (a0Var.g) {
                i3 = -1;
            } else {
                int i8 = this.k;
                i3 = -1;
                if (i8 != -1) {
                    if (i8 < 0 || i8 >= a0Var.b()) {
                        this.k = -1;
                        this.l = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                    } else {
                        e eVar8 = this.q;
                        if (eVar8 == null || eVar8.b == -1 || eVar8.d < 1) {
                            View viewFindViewByPosition = findViewByPosition(this.k);
                            if (viewFindViewByPosition != null) {
                                bVar.a = this.i ? i() : h();
                                if (this.l != Integer.MIN_VALUE) {
                                    if (bVar.c) {
                                        iK = uVar.g() - this.l;
                                        iE = uVar.b(viewFindViewByPosition);
                                    } else {
                                        iK = uVar.k() + this.l;
                                        iE = uVar.e(viewFindViewByPosition);
                                    }
                                    iG2 = iK - iE;
                                } else {
                                    if (uVar.c(viewFindViewByPosition) > uVar.l()) {
                                        iG3 = bVar.c ? uVar.g() : uVar.k();
                                    } else {
                                        int iE2 = uVar.e(viewFindViewByPosition) - uVar.k();
                                        if (iE2 < 0) {
                                            iG3 = -iE2;
                                        } else {
                                            iG2 = uVar.g() - uVar.b(viewFindViewByPosition);
                                            if (iG2 >= 0) {
                                                bVar.b = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                                            }
                                        }
                                    }
                                    bVar.b = iG3;
                                }
                                bVar.b = iG2;
                            } else {
                                int i9 = this.k;
                                bVar.a = i9;
                                int i10 = this.l;
                                if (i10 == Integer.MIN_VALUE) {
                                    if (getChildCount() != 0) {
                                        if ((i9 < h()) != this.i) {
                                            z5 = false;
                                        } else {
                                            z5 = true;
                                        }
                                    } else if (this.i) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    bVar.c = z5;
                                    iG = z5 ? staggeredGridLayoutManager.c.g() : staggeredGridLayoutManager.c.k();
                                } else {
                                    iG = bVar.c ? staggeredGridLayoutManager.c.g() - i10 : staggeredGridLayoutManager.c.k() + i10;
                                }
                                bVar.b = iG;
                                z4 = true;
                                bVar.d = true;
                            }
                        } else {
                            bVar.b = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                            bVar.a = this.k;
                        }
                        z4 = true;
                    }
                }
                bVar.e = z4;
            }
            boolean z9 = this.o;
            int iB = a0Var.b();
            if (!z9) {
                int childCount = getChildCount();
                int i11 = 0;
                while (true) {
                    if (i11 >= childCount) {
                        position = 0;
                        break;
                    }
                    int position2 = RecyclerView.o.getPosition(getChildAt(i11));
                    if (position2 >= 0 && position2 < iB) {
                        position = position2;
                        break;
                    }
                    i11++;
                }
            } else {
                int childCount2 = getChildCount();
                while (true) {
                    childCount2 += i3;
                    if (childCount2 < 0) {
                        position = 0;
                        break;
                    }
                    position = RecyclerView.o.getPosition(getChildAt(childCount2));
                    if (position >= 0 && position < iB) {
                        break;
                    } else {
                        i3 = -1;
                    }
                }
            }
            bVar.a = position;
            bVar.b = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            z4 = true;
            bVar.e = z4;
        }
        if (this.q == null && this.k == -1 && !(bVar.c == this.o && isLayoutRTL() == this.p)) {
            dVar.a();
            i = 1;
            bVar.d = true;
        } else {
            i = 1;
        }
        if (getChildCount() > 0 && ((eVar = this.q) == null || eVar.d < i)) {
            if (bVar.d) {
                for (int i12 = 0; i12 < i4; i12++) {
                    fVarArr[i12].b();
                    int i13 = bVar.b;
                    if (i13 != Integer.MIN_VALUE) {
                        f fVar2 = fVarArr[i12];
                        fVar2.b = i13;
                        fVar2.c = i13;
                    }
                }
            } else if (z7 || bVar.f == null) {
                for (int i14 = 0; i14 < i4; i14++) {
                    f fVar3 = fVarArr[i14];
                    boolean z10 = this.i;
                    int i15 = bVar.b;
                    int iF = z10 ? fVar3.f(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED) : fVar3.i(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
                    fVar3.b();
                    if (iF != Integer.MIN_VALUE) {
                        StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                        if ((!z10 || iF >= staggeredGridLayoutManager2.c.g()) && (z10 || iF <= staggeredGridLayoutManager2.c.k())) {
                            if (i15 != Integer.MIN_VALUE) {
                                iF += i15;
                            }
                            fVar3.c = iF;
                            fVar3.b = iF;
                        }
                    }
                }
                int length = fVarArr.length;
                int[] iArr = bVar.f;
                if (iArr == null || iArr.length < length) {
                    bVar.f = new int[staggeredGridLayoutManager.b.length];
                }
                for (int i16 = 0; i16 < length; i16++) {
                    bVar.f[i16] = fVarArr[i16].i(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
                }
            } else {
                for (int i17 = 0; i17 < i4; i17++) {
                    f fVar4 = fVarArr[i17];
                    fVar4.b();
                    int i18 = bVar.f[i17];
                    fVar4.b = i18;
                    fVar4.c = i18;
                }
            }
        }
        detachAndScrapAttachedViews(vVar);
        p pVar = this.g;
        pVar.a = false;
        u uVar2 = this.d;
        int iL = uVar2.l();
        this.f = iL / i4;
        View.MeasureSpec.makeMeasureSpec(iL, uVar2.i());
        u(bVar.a, a0Var);
        if (bVar.c) {
            t(-1);
            c(vVar, pVar, a0Var);
            t(1);
        } else {
            t(1);
            c(vVar, pVar, a0Var);
            t(-1);
        }
        pVar.c = bVar.a + pVar.d;
        c(vVar, pVar, a0Var);
        if (uVar2.i() != 1073741824) {
            int childCount3 = getChildCount();
            float fMax = 0.0f;
            for (int i19 = 0; i19 < childCount3; i19++) {
                View childAt = getChildAt(i19);
                float fC = uVar2.c(childAt);
                if (fC >= fMax) {
                    ((c) childAt.getLayoutParams()).getClass();
                    fMax = Math.max(fMax, fC);
                }
            }
            int i20 = this.f;
            int iRound = Math.round(fMax * i4);
            if (uVar2.i() == Integer.MIN_VALUE) {
                iRound = Math.min(iRound, uVar2.l());
            }
            this.f = iRound / i4;
            View.MeasureSpec.makeMeasureSpec(iRound, uVar2.i());
            if (this.f != i20) {
                for (int i21 = 0; i21 < childCount3; i21++) {
                    View childAt2 = getChildAt(i21);
                    c cVar = (c) childAt2.getLayoutParams();
                    cVar.getClass();
                    boolean zIsLayoutRTL = isLayoutRTL();
                    int i22 = this.e;
                    if (zIsLayoutRTL && i22 == 1) {
                        int i23 = -((i4 - 1) - cVar.e.e);
                        i2 = (this.f * i23) - (i23 * i20);
                    } else {
                        int i24 = cVar.e.e;
                        i2 = (this.f * i24) - (i24 * i20);
                        if (i22 != 1) {
                            childAt2.offsetTopAndBottom(i2);
                        }
                    }
                    childAt2.offsetLeftAndRight(i2);
                }
            }
        }
        if (getChildCount() > 0) {
            z2 = true;
            if (this.i) {
                f(vVar, a0Var, true);
                g(vVar, a0Var, false);
            } else {
                g(vVar, a0Var, true);
                f(vVar, a0Var, false);
            }
        } else {
            z2 = true;
        }
        if (!z || a0Var.g || this.n == 0 || getChildCount() <= 0 || m() == null) {
            z3 = false;
        } else {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.removeCallbacks(this.v);
            }
            if (b()) {
                z3 = z2;
            } else {
                z3 = false;
            }
        }
        if (a0Var.g) {
            bVar.a();
        }
        this.o = bVar.c;
        this.p = isLayoutRTL();
        if (z3) {
            bVar.a();
            n(vVar, a0Var, false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0023 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0024 A[RETURN] */
    public final boolean o(int i) {
        if (this.e == 0) {
            if ((i == -1) != this.i) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.i) == isLayoutRTL()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.a; i2++) {
            f fVar = this.b[i2];
            int i3 = fVar.b;
            if (i3 != Integer.MIN_VALUE) {
                fVar.b = i3 + i;
            }
            int i4 = fVar.c;
            if (i4 != Integer.MIN_VALUE) {
                fVar.c = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.a; i2++) {
            f fVar = this.b[i2];
            int i3 = fVar.b;
            if (i3 != Integer.MIN_VALUE) {
                fVar.b = i3 + i;
            }
            int i4 = fVar.c;
            if (i4 != Integer.MIN_VALUE) {
                fVar.c = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onAdapterChanged() {
        this.m.a();
        for (int i = 0; i < this.a; i++) {
            this.b[i].b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onDetachedFromWindow(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.v);
        }
        for (int i = 0; i < this.a; i++) {
            this.b[i].b();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0064  */
    /* JADX WARN: Code duplicated, block: B:48:0x0066  */
    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final View onFocusSearchFailed(View view, int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View viewFindContainingItemView;
        int i2;
        if (getChildCount() != 0) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (viewFindContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.c.contains(viewFindContainingItemView)) {
                viewFindContainingItemView = null;
            }
            if (viewFindContainingItemView != null) {
                resolveShouldLayoutReverse$1();
                int i3 = this.e;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 17) {
                            if (i != 33) {
                                if (i == 66 ? i3 == 0 : !(i != 130 || i3 != 1)) {
                                    i2 = 1;
                                }
                            } else if (i3 == 1) {
                                i2 = -1;
                            }
                            i2 = Integer.MIN_VALUE;
                        } else if (i3 == 0) {
                            i2 = -1;
                        } else {
                            i2 = Integer.MIN_VALUE;
                        }
                    } else if (i3 != 1 && isLayoutRTL()) {
                        i2 = -1;
                    } else {
                        i2 = 1;
                    }
                } else if (i3 != 1 && isLayoutRTL()) {
                    i2 = 1;
                } else {
                    i2 = -1;
                }
                if (i2 != Integer.MIN_VALUE) {
                    c cVar = (c) viewFindContainingItemView.getLayoutParams();
                    cVar.getClass();
                    f fVar = cVar.e;
                    int i4 = i2 == 1 ? i() : h();
                    u(i4, a0Var);
                    t(i2);
                    p pVar = this.g;
                    pVar.c = pVar.d + i4;
                    pVar.b = (int) (this.c.l() * 0.33333334f);
                    pVar.h = true;
                    pVar.a = false;
                    c(vVar, pVar, a0Var);
                    this.o = this.i;
                    View viewG = fVar.g(i4, i2);
                    if (viewG != null && viewG != viewFindContainingItemView) {
                        return viewG;
                    }
                    boolean zO = o(i2);
                    f[] fVarArr = this.b;
                    int i5 = this.a;
                    if (zO) {
                        for (int i6 = i5 - 1; i6 >= 0; i6--) {
                            View viewG2 = fVarArr[i6].g(i4, i2);
                            if (viewG2 != null && viewG2 != viewFindContainingItemView) {
                                return viewG2;
                            }
                        }
                    } else {
                        for (int i7 = 0; i7 < i5; i7++) {
                            View viewG3 = fVarArr[i7].g(i4, i2);
                            if (viewG3 != null && viewG3 != viewFindContainingItemView) {
                                return viewG3;
                            }
                        }
                    }
                    boolean z = (this.h ^ true) == (i2 == -1);
                    View viewFindViewByPosition = findViewByPosition(z ? fVar.c() : fVar.d());
                    if (viewFindViewByPosition != null && viewFindViewByPosition != viewFindContainingItemView) {
                        return viewFindViewByPosition;
                    }
                    if (o(i2)) {
                        for (int i8 = i5 - 1; i8 >= 0; i8--) {
                            if (i8 != fVar.e) {
                                View viewFindViewByPosition2 = findViewByPosition(z ? fVarArr[i8].c() : fVarArr[i8].d());
                                if (viewFindViewByPosition2 != null && viewFindViewByPosition2 != viewFindContainingItemView) {
                                    return viewFindViewByPosition2;
                                }
                            }
                        }
                    } else {
                        for (int i9 = 0; i9 < i5; i9++) {
                            View viewFindViewByPosition3 = findViewByPosition(z ? fVarArr[i9].c() : fVarArr[i9].d());
                            if (viewFindViewByPosition3 != null && viewFindViewByPosition3 != viewFindContainingItemView) {
                                return viewFindViewByPosition3;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View viewE = e(false);
            View viewD = d(false);
            if (viewE == null || viewD == null) {
                return;
            }
            int position = RecyclerView.o.getPosition(viewE);
            int position2 = RecyclerView.o.getPosition(viewD);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onItemsAdded(int i, int i2) {
        l(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onItemsChanged() {
        this.m.a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onItemsMoved(int i, int i2) {
        l(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onItemsRemoved(int i, int i2) {
        l(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onItemsUpdated(int i, int i2) {
        l(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onLayoutChildren(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        n(vVar, a0Var, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onLayoutCompleted(RecyclerView.a0 a0Var) {
        this.k = -1;
        this.l = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        this.q = null;
        this.s.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof e) {
            e eVar = (e) parcelable;
            this.q = eVar;
            if (this.k != -1) {
                eVar.b = -1;
                eVar.c = -1;
                eVar.f = null;
                eVar.d = 0;
                eVar.g = 0;
                eVar.i = null;
                eVar.j = null;
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final Parcelable onSaveInstanceState() {
        int i;
        int iK;
        int[] iArr;
        e eVar = this.q;
        if (eVar != null) {
            return new e(eVar);
        }
        e eVar2 = new e();
        eVar2.n = this.h;
        eVar2.o = this.o;
        eVar2.p = this.p;
        d dVar = this.m;
        if (dVar == null || (iArr = dVar.a) == null) {
            eVar2.g = 0;
        } else {
            eVar2.i = iArr;
            eVar2.g = iArr.length;
            eVar2.j = dVar.b;
        }
        if (getChildCount() <= 0) {
            eVar2.b = -1;
            eVar2.c = -1;
            eVar2.d = 0;
            return eVar2;
        }
        eVar2.b = this.o ? i() : h();
        View viewD = this.i ? d(true) : e(true);
        eVar2.c = viewD != null ? RecyclerView.o.getPosition(viewD) : -1;
        int i2 = this.a;
        eVar2.d = i2;
        eVar2.f = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            boolean z = this.o;
            u uVar = this.c;
            f[] fVarArr = this.b;
            if (z) {
                i = fVarArr[i3].f(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
                if (i != Integer.MIN_VALUE) {
                    iK = uVar.g();
                    i -= iK;
                }
            } else {
                i = fVarArr[i3].i(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
                if (i != Integer.MIN_VALUE) {
                    iK = uVar.k();
                    i -= iK;
                }
            }
            eVar2.f[i3] = i;
        }
        return eVar2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onScrollStateChanged(int i) {
        if (i == 0) {
            b();
        }
    }

    public final void p(int i, RecyclerView.a0 a0Var) {
        int iH;
        int i2;
        if (i > 0) {
            iH = i();
            i2 = 1;
        } else {
            iH = h();
            i2 = -1;
        }
        p pVar = this.g;
        pVar.a = true;
        u(iH, a0Var);
        t(i2);
        pVar.c = iH + pVar.d;
        pVar.b = Math.abs(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        if (r1 == (-1)) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(androidx.recyclerview.widget.RecyclerView.v r12, androidx.recyclerview.widget.p r13) {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.q(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.p):void");
    }

    public final void resolveShouldLayoutReverse$1() {
        this.i = (this.e == 1 || !isLayoutRTL()) ? this.h : !this.h;
    }

    public final int scrollBy(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        p(i, a0Var);
        p pVar = this.g;
        int iC = c(vVar, pVar, a0Var);
        if (pVar.b >= iC) {
            i = i < 0 ? -iC : iC;
        }
        this.c.o(-i);
        this.o = this.i;
        pVar.b = 0;
        q(vVar, pVar);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int scrollHorizontallyBy(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return scrollBy(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void scrollToPosition(int i) {
        e eVar = this.q;
        if (eVar != null && eVar.b != i) {
            eVar.f = null;
            eVar.d = 0;
            eVar.b = -1;
            eVar.c = -1;
        }
        this.k = i;
        this.l = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int scrollVerticallyBy(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return scrollBy(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void setMeasuredDimension(Rect rect, int i, int i2) {
        int iChooseSize;
        int iChooseSize2;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int i3 = this.e;
        int i4 = this.a;
        if (i3 == 1) {
            int iHeight = rect.height() + paddingBottom;
            RecyclerView recyclerView = this.mRecyclerView;
            WeakHashMap weakHashMap = qd1.a;
            iChooseSize2 = RecyclerView.o.chooseSize(i2, iHeight, recyclerView.getMinimumHeight());
            iChooseSize = RecyclerView.o.chooseSize(i, (this.f * i4) + paddingRight, this.mRecyclerView.getMinimumWidth());
        } else {
            int iWidth = rect.width() + paddingRight;
            RecyclerView recyclerView2 = this.mRecyclerView;
            WeakHashMap weakHashMap2 = qd1.a;
            iChooseSize = RecyclerView.o.chooseSize(i, iWidth, recyclerView2.getMinimumWidth());
            iChooseSize2 = RecyclerView.o.chooseSize(i2, (this.f * i4) + paddingBottom, this.mRecyclerView.getMinimumHeight());
        }
        this.mRecyclerView.setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void smoothScrollToPosition(RecyclerView recyclerView, int i) {
        q qVar = new q(recyclerView.getContext());
        qVar.mTargetPosition = i;
        startSmoothScroll(qVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean supportsPredictiveItemAnimations() {
        return this.q == null;
    }

    public final void t(int i) {
        p pVar = this.g;
        pVar.e = i;
        pVar.d = this.i != (i == -1) ? -1 : 1;
    }

    public final void u(int i, RecyclerView.a0 a0Var) {
        int iL;
        int iL2;
        int i2;
        p pVar = this.g;
        boolean z = false;
        pVar.b = 0;
        pVar.c = i;
        q qVar = this.mSmoothScroller;
        boolean z2 = qVar != null && qVar.mRunning;
        u uVar = this.c;
        if (!z2 || (i2 = a0Var.a) == -1) {
            iL = 0;
            iL2 = 0;
        } else {
            if (this.i == (i2 < i)) {
                iL = uVar.l();
                iL2 = 0;
            } else {
                iL2 = uVar.l();
                iL = 0;
            }
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || !recyclerView.mClipToPadding) {
            pVar.g = uVar.f() + iL;
            pVar.f = -iL2;
        } else {
            pVar.f = uVar.k() - iL2;
            pVar.g = uVar.g() + iL;
        }
        pVar.h = false;
        pVar.a = true;
        if (uVar.i() == 0 && uVar.f() == 0) {
            z = true;
        }
        pVar.i = z;
    }

    public final void v(f fVar, int i, int i2) {
        int i3 = fVar.d;
        if (i == -1) {
            int i4 = fVar.b;
            if (i4 == Integer.MIN_VALUE) {
                View view = (View) fVar.a.get(0);
                c cVar = (c) view.getLayoutParams();
                fVar.b = StaggeredGridLayoutManager.this.c.e(view);
                cVar.getClass();
                i4 = fVar.b;
            }
            if (i4 + i3 > i2) {
                return;
            }
        } else {
            int i5 = fVar.c;
            if (i5 == Integer.MIN_VALUE) {
                fVar.a();
                i5 = fVar.c;
            }
            if (i5 - i3 < i2) {
                return;
            }
        }
        this.j.set(fVar.e, false);
    }
}
