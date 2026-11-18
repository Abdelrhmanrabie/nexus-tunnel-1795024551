package androidx.fragment.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import defpackage.ah0;
import defpackage.ak;
import defpackage.an0;
import defpackage.b21;
import defpackage.cb;
import defpackage.ce1;
import defpackage.dn0;
import defpackage.ev;
import defpackage.f8;
import defpackage.fb$1;
import defpackage.fv;
import defpackage.g30;
import defpackage.he0;
import defpackage.ih;
import defpackage.j2;
import defpackage.k2;
import defpackage.kh0;
import defpackage.kv;
import defpackage.l2;
import defpackage.m2;
import defpackage.mm0;
import defpackage.mv;
import defpackage.nf0;
import defpackage.nv;
import defpackage.ov;
import defpackage.q2;
import defpackage.sv;
import defpackage.t2;
import defpackage.tx0;
import defpackage.u2;
import defpackage.uv;
import defpackage.vm0;
import defpackage.wm0;
import defpackage.zm0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {
    public t2 A;
    public t2 B;
    public t2 C;
    public ArrayDeque D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public ArrayList J;
    public ArrayList K;
    public ArrayList L;
    public s M;
    public final f N;
    public boolean b;
    public ArrayList d;
    public ArrayList e;
    public OnBackPressedDispatcher g;
    public final nv m;
    public final CopyOnWriteArrayList n;
    public final ov o;
    public final fv p;
    public final fv q;
    public final ov r;
    public final c s;
    public int t;
    public mv u;
    public kv v;
    public Fragment w;
    public Fragment x;
    public final d y;
    public final e z;
    public final ArrayList a = new ArrayList();
    public final v c = new v();
    public final p f = new p(this);
    public final b h = new b();
    public final AtomicInteger i = new AtomicInteger();
    public final Map j = Collections.synchronizedMap(new HashMap());
    public final Map k = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements k2 {
        public a() {
        }

        @Override // defpackage.k2
        public final void a(Object obj) {
            Fragment fragmentC;
            Map map = (Map) obj;
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
            }
            q qVar = q.this;
            k kVar = (k) qVar.D.pollFirst();
            if (kVar == null || (fragmentC = qVar.c.c(kVar.b)) == null) {
                return;
            }
            fragmentC.onRequestPermissionsResult(kVar.c, strArr, iArr);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b extends mm0 {
        public b() {
        }

        @Override // defpackage.mm0
        public final void a() {
            q qVar = q.this;
            qVar.y(true);
            if (qVar.h.a) {
                qVar.O(-1, 0);
            } else {
                qVar.g.c();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c implements kh0 {
        public c() {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d extends o {
        public d() {
        }

        @Override // androidx.fragment.app.o
        public final Fragment a(String str) {
            return Fragment.instantiate(q.this.u.c, str, null);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class e implements b21 {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            q.this.y(true);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class g implements sv {
        public final /* synthetic */ Fragment b;

        public g(Fragment fragment) {
            this.b = fragment;
        }

        @Override // defpackage.sv
        public final void a(Fragment fragment) {
            this.b.onAttachFragment(fragment);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class h implements k2 {
        public h() {
        }

        @Override // defpackage.k2
        public final void a(Object obj) {
            Fragment fragmentC;
            j2 j2Var = (j2) obj;
            q qVar = q.this;
            k kVar = (k) qVar.D.pollFirst();
            if (kVar == null || (fragmentC = qVar.c.c(kVar.b)) == null) {
                return;
            }
            fragmentC.onActivityResult(kVar.c, j2Var.b, j2Var.c);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class i implements k2 {
        public i() {
        }

        @Override // defpackage.k2
        public final void a(Object obj) {
            Fragment fragmentC;
            j2 j2Var = (j2) obj;
            q qVar = q.this;
            k kVar = (k) qVar.D.pollFirst();
            if (kVar == null || (fragmentC = qVar.c.c(kVar.b)) == null) {
                return;
            }
            fragmentC.onActivityResult(kVar.c, j2Var.b, j2Var.c);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class j extends l2 {
        @Override // defpackage.l2
        public final Intent a(Object obj) {
            Bundle bundleExtra;
            g30 g30Var = (g30) obj;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intent2 = g30Var.c;
            if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    g30Var = new g30(g30Var.b, null, g30Var.d, g30Var.f);
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", g30Var);
            if (Log.isLoggable("FragmentManager", 2)) {
                intent.toString();
            }
            return intent;
        }

        @Override // defpackage.l2
        public final Object c(Intent intent, int i) {
            return new j2(intent, i);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();
        public final String b;
        public final int c;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Parcelable.Creator<k> {
            @Override // android.os.Parcelable.Creator
            public final k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final k[] newArray(int i) {
                return new k[i];
            }
        }

        public k(Parcel parcel) {
            this.b = parcel.readString();
            this.c = parcel.readInt();
        }

        public k(String str, int i) {
            this.b = str;
            this.c = i;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.b);
            parcel.writeInt(this.c);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface l {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class m implements l {
        public final String a;
        public final int b;

        public m(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // androidx.fragment.app.q.l
        public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = q.this.x;
            if (fragment != null && this.b < 0 && this.a == null && fragment.getChildFragmentManager().O(-1, 0)) {
                return false;
            }
            return q.this.P(arrayList, arrayList2, this.a, this.b, 1);
        }
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [ov] */
    /* JADX WARN: Type inference failed for: r0v15, types: [ov] */
    public q() {
        Collections.synchronizedMap(new HashMap());
        this.m = new nv(this);
        this.n = new CopyOnWriteArrayList();
        final int i2 = 0;
        this.o = new ih(this) { // from class: ov
            public final /* synthetic */ q a;

            {
                this.a = this;
            }

            @Override // defpackage.ih
            public final void accept(Object obj) {
                if (i2 != 0) {
                    boolean z = ((xo0) obj).a;
                    for (Fragment fragment : this.a.c.f()) {
                        if (fragment != null) {
                            fragment.performPictureInPictureModeChanged(z);
                        }
                    }
                    return;
                }
                Configuration configuration = (Configuration) obj;
                for (Fragment fragment2 : this.a.c.f()) {
                    if (fragment2 != null) {
                        fragment2.performConfigurationChanged(configuration);
                    }
                }
            }
        };
        final int i3 = 1;
        this.p = new fv(this, i3, i2);
        this.q = new fv(this, i3, i3);
        this.r = new ih(this) { // from class: ov
            public final /* synthetic */ q a;

            {
                this.a = this;
            }

            @Override // defpackage.ih
            public final void accept(Object obj) {
                if (i3 != 0) {
                    boolean z = ((xo0) obj).a;
                    for (Fragment fragment : this.a.c.f()) {
                        if (fragment != null) {
                            fragment.performPictureInPictureModeChanged(z);
                        }
                    }
                    return;
                }
                Configuration configuration = (Configuration) obj;
                for (Fragment fragment2 : this.a.c.f()) {
                    if (fragment2 != null) {
                        fragment2.performConfigurationChanged(configuration);
                    }
                }
            }
        };
        this.s = new c();
        this.t = -1;
        this.y = new d();
        this.z = new e();
        this.D = new ArrayDeque();
        this.N = new f();
    }

    public static boolean I(Fragment fragment) {
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        boolean zI = false;
        for (Fragment fragment2 : fragment.mChildFragmentManager.c.e()) {
            if (fragment2 != null) {
                zI = I(fragment2);
            }
            if (zI) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        q qVar = fragment.mFragmentManager;
        return fragment.equals(qVar.x) && J(qVar.w);
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0216 A[PHI: r14
      0x0216: PHI (r14v13 int) = (r14v12 int), (r14v14 int) binds: [B:99:0x0204, B:101:0x020a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:64:0x0163  */
    /* JADX WARN: Code duplicated, block: B:65:0x0169  */
    public final void A(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        ViewGroup viewGroup;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        boolean z2;
        Fragment fragment;
        boolean z3 = ((androidx.fragment.app.a) arrayList.get(i2)).p;
        ArrayList arrayList3 = this.L;
        if (arrayList3 == null) {
            this.L = new ArrayList();
        } else {
            arrayList3.clear();
        }
        ArrayList arrayList4 = this.L;
        v vVar = this.c;
        arrayList4.addAll(vVar.f());
        Fragment fragment2 = this.x;
        int i8 = i2;
        boolean z4 = false;
        while (true) {
            int i9 = 1;
            if (i8 >= i3) {
                boolean z5 = z3;
                int i10 = -1;
                this.L.clear();
                if (!z5 && this.t >= 1) {
                    for (int i11 = i2; i11 < i3; i11++) {
                        Iterator it = ((androidx.fragment.app.a) arrayList.get(i11)).a.iterator();
                        while (it.hasNext()) {
                            Fragment fragment3 = ((w.a) it.next()).b;
                            if (fragment3 != null && fragment3.mFragmentManager != null) {
                                vVar.g(g(fragment3));
                            }
                        }
                    }
                }
                int i12 = i2;
                while (i12 < i3) {
                    androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i12);
                    if (((Boolean) arrayList2.get(i12)).booleanValue()) {
                        aVar.e(i10);
                        ArrayList arrayList5 = aVar.a;
                        boolean z6 = true;
                        for (int size = arrayList5.size() - 1; size >= 0; size--) {
                            w.a aVar2 = (w.a) arrayList5.get(size);
                            Fragment fragment4 = aVar2.b;
                            if (fragment4 != null) {
                                fragment4.mBeingSaved = false;
                                fragment4.setPopDirection(z6);
                                int i13 = aVar.f;
                                int i14 = 8194;
                                int i15 = 4097;
                                if (i13 != 4097) {
                                    if (i13 != 8194) {
                                        i14 = 8197;
                                        i15 = 4100;
                                        if (i13 == 8197) {
                                            i14 = i15;
                                        } else if (i13 == 4099) {
                                            i14 = 4099;
                                        } else if (i13 != 4100) {
                                            i14 = 0;
                                        }
                                    } else {
                                        i14 = i15;
                                    }
                                }
                                fragment4.setNextTransition(i14);
                                fragment4.setSharedElementNames(aVar.o, aVar.n);
                            }
                            int i16 = aVar2.a;
                            q qVar = aVar.q;
                            switch (i16) {
                                case 1:
                                    fragment4.setAnimations(aVar2.d, aVar2.e, aVar2.f, aVar2.g);
                                    z6 = true;
                                    qVar.V(fragment4, true);
                                    qVar.Q(fragment4);
                                    break;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + aVar2.a);
                                case 3:
                                    fragment4.setAnimations(aVar2.d, aVar2.e, aVar2.f, aVar2.g);
                                    qVar.a(fragment4);
                                    z6 = true;
                                    break;
                                case 4:
                                    fragment4.setAnimations(aVar2.d, aVar2.e, aVar2.f, aVar2.g);
                                    qVar.getClass();
                                    if (Log.isLoggable("FragmentManager", 2)) {
                                        Objects.toString(fragment4);
                                    }
                                    if (fragment4.mHidden) {
                                        fragment4.mHidden = false;
                                        fragment4.mHiddenChanged = !fragment4.mHiddenChanged;
                                    }
                                    z6 = true;
                                    break;
                                case 5:
                                    fragment4.setAnimations(aVar2.d, aVar2.e, aVar2.f, aVar2.g);
                                    z6 = true;
                                    qVar.V(fragment4, true);
                                    if (Log.isLoggable("FragmentManager", 2)) {
                                        Objects.toString(fragment4);
                                    }
                                    if (!fragment4.mHidden) {
                                        fragment4.mHidden = true;
                                        fragment4.mHiddenChanged = !fragment4.mHiddenChanged;
                                        qVar.Y(fragment4);
                                        z6 = true;
                                    }
                                    break;
                                case 6:
                                    fragment4.setAnimations(aVar2.d, aVar2.e, aVar2.f, aVar2.g);
                                    qVar.d(fragment4);
                                    z6 = true;
                                    break;
                                case 7:
                                    fragment4.setAnimations(aVar2.d, aVar2.e, aVar2.f, aVar2.g);
                                    qVar.V(fragment4, true);
                                    qVar.h(fragment4);
                                    z6 = true;
                                    break;
                                case 8:
                                    qVar.X(null);
                                    z6 = true;
                                    break;
                                case 9:
                                    qVar.X(fragment4);
                                    z6 = true;
                                    break;
                                case 10:
                                    qVar.W(fragment4, aVar2.h);
                                    z6 = true;
                                    break;
                            }
                        }
                    } else {
                        aVar.e(1);
                        ArrayList arrayList6 = aVar.a;
                        int size2 = arrayList6.size();
                        int i17 = 0;
                        while (i17 < size2) {
                            w.a aVar3 = (w.a) arrayList6.get(i17);
                            Fragment fragment5 = aVar3.b;
                            if (fragment5 != null) {
                                fragment5.mBeingSaved = false;
                                fragment5.setPopDirection(false);
                                fragment5.setNextTransition(aVar.f);
                                fragment5.setSharedElementNames(aVar.n, aVar.o);
                            }
                            int i18 = aVar3.a;
                            q qVar2 = aVar.q;
                            switch (i18) {
                                case 1:
                                    i4 = i12;
                                    fragment5.setAnimations(aVar3.d, aVar3.e, aVar3.f, aVar3.g);
                                    qVar2.V(fragment5, false);
                                    qVar2.a(fragment5);
                                    i17++;
                                    i12 = i4;
                                    break;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + aVar3.a);
                                case 3:
                                    i4 = i12;
                                    fragment5.setAnimations(aVar3.d, aVar3.e, aVar3.f, aVar3.g);
                                    qVar2.Q(fragment5);
                                    i17++;
                                    i12 = i4;
                                    break;
                                case 4:
                                    i4 = i12;
                                    fragment5.setAnimations(aVar3.d, aVar3.e, aVar3.f, aVar3.g);
                                    qVar2.getClass();
                                    if (Log.isLoggable("FragmentManager", 2)) {
                                        Objects.toString(fragment5);
                                    }
                                    if (!fragment5.mHidden) {
                                        fragment5.mHidden = true;
                                        fragment5.mHiddenChanged = !fragment5.mHiddenChanged;
                                        qVar2.Y(fragment5);
                                    }
                                    i17++;
                                    i12 = i4;
                                    break;
                                case 5:
                                    i4 = i12;
                                    fragment5.setAnimations(aVar3.d, aVar3.e, aVar3.f, aVar3.g);
                                    qVar2.V(fragment5, false);
                                    if (Log.isLoggable("FragmentManager", 2)) {
                                        Objects.toString(fragment5);
                                    }
                                    if (fragment5.mHidden) {
                                        fragment5.mHidden = false;
                                        fragment5.mHiddenChanged = !fragment5.mHiddenChanged;
                                    }
                                    i17++;
                                    i12 = i4;
                                    break;
                                case 6:
                                    i4 = i12;
                                    fragment5.setAnimations(aVar3.d, aVar3.e, aVar3.f, aVar3.g);
                                    qVar2.h(fragment5);
                                    i17++;
                                    i12 = i4;
                                    break;
                                case 7:
                                    i4 = i12;
                                    fragment5.setAnimations(aVar3.d, aVar3.e, aVar3.f, aVar3.g);
                                    qVar2.V(fragment5, false);
                                    qVar2.d(fragment5);
                                    i17++;
                                    i12 = i4;
                                    break;
                                case 8:
                                    qVar2.X(fragment5);
                                    i4 = i12;
                                    i17++;
                                    i12 = i4;
                                    break;
                                case 9:
                                    qVar2.X(null);
                                    i4 = i12;
                                    i17++;
                                    i12 = i4;
                                    break;
                                case 10:
                                    qVar2.W(fragment5, aVar3.i);
                                    i4 = i12;
                                    i17++;
                                    i12 = i4;
                                    break;
                            }
                        }
                    }
                    i12++;
                    i10 = -1;
                }
                boolean zBooleanValue = ((Boolean) arrayList2.get(i3 - 1)).booleanValue();
                for (int i19 = i2; i19 < i3; i19++) {
                    androidx.fragment.app.a aVar4 = (androidx.fragment.app.a) arrayList.get(i19);
                    if (zBooleanValue) {
                        for (int size3 = aVar4.a.size() - 1; size3 >= 0; size3--) {
                            Fragment fragment6 = ((w.a) aVar4.a.get(size3)).b;
                            if (fragment6 != null) {
                                g(fragment6).i();
                            }
                        }
                    } else {
                        Iterator it2 = aVar4.a.iterator();
                        while (it2.hasNext()) {
                            Fragment fragment7 = ((w.a) it2.next()).b;
                            if (fragment7 != null) {
                                g(fragment7).i();
                            }
                        }
                    }
                }
                L(this.t, true);
                HashSet<y> hashSet = new HashSet();
                for (int i20 = i2; i20 < i3; i20++) {
                    Iterator it3 = ((androidx.fragment.app.a) arrayList.get(i20)).a.iterator();
                    while (it3.hasNext()) {
                        Fragment fragment8 = ((w.a) it3.next()).b;
                        if (fragment8 != null && (viewGroup = fragment8.mContainer) != null) {
                            hashSet.add(y.f(viewGroup, G()));
                        }
                    }
                }
                for (y yVar : hashSet) {
                    yVar.d = zBooleanValue;
                    yVar.h();
                    yVar.c();
                }
                for (int i21 = i2; i21 < i3; i21++) {
                    androidx.fragment.app.a aVar5 = (androidx.fragment.app.a) arrayList.get(i21);
                    if (((Boolean) arrayList2.get(i21)).booleanValue() && aVar5.s >= 0) {
                        aVar5.s = -1;
                    }
                    aVar5.getClass();
                }
                return;
            }
            androidx.fragment.app.a aVar6 = (androidx.fragment.app.a) arrayList.get(i8);
            boolean zBooleanValue2 = ((Boolean) arrayList2.get(i8)).booleanValue();
            ArrayList arrayList7 = this.L;
            if (zBooleanValue2) {
                z = z3;
                i5 = i8;
                int i22 = 1;
                ArrayList arrayList8 = aVar6.a;
                int size4 = arrayList8.size() - 1;
                while (size4 >= 0) {
                    w.a aVar7 = (w.a) arrayList8.get(size4);
                    int i23 = aVar7.a;
                    if (i23 == i22) {
                        arrayList7.remove(aVar7.b);
                    } else if (i23 != 3) {
                        switch (i23) {
                            case 6:
                                arrayList7.add(aVar7.b);
                                break;
                            case 7:
                                arrayList7.remove(aVar7.b);
                                break;
                            case 8:
                                fragment2 = null;
                                break;
                            case 9:
                                fragment2 = aVar7.b;
                                break;
                            case 10:
                                aVar7.i = aVar7.h;
                                break;
                        }
                    } else {
                        arrayList7.add(aVar7.b);
                    }
                    size4--;
                    i22 = 1;
                }
            } else {
                int i24 = 0;
                while (true) {
                    ArrayList arrayList9 = aVar6.a;
                    if (i24 < arrayList9.size()) {
                        w.a aVar8 = (w.a) arrayList9.get(i24);
                        int i25 = aVar8.a;
                        if (i25 != i9) {
                            if (i25 != 2) {
                                if (i25 == 3 || i25 == 6) {
                                    arrayList7.remove(aVar8.b);
                                    Fragment fragment9 = aVar8.b;
                                    if (fragment9 == fragment2) {
                                        arrayList9.add(i24, new w.a(fragment9, 9));
                                        i24++;
                                        z2 = z3;
                                        i7 = i8;
                                        i6 = 1;
                                        fragment2 = null;
                                    }
                                } else if (i25 == 7) {
                                    i6 = 1;
                                } else if (i25 == 8) {
                                    arrayList9.add(i24, new w.a(9, fragment2));
                                    aVar8.c = true;
                                    i24++;
                                    fragment2 = aVar8.b;
                                }
                                z2 = z3;
                                i7 = i8;
                                i6 = 1;
                            } else {
                                Fragment fragment10 = aVar8.b;
                                int i26 = fragment10.mContainerId;
                                z2 = z3;
                                int size5 = arrayList7.size() - 1;
                                boolean z7 = false;
                                while (size5 >= 0) {
                                    int i27 = size5;
                                    Fragment fragment11 = (Fragment) arrayList7.get(size5);
                                    int i28 = i8;
                                    if (fragment11.mContainerId == i26) {
                                        if (fragment11 == fragment10) {
                                            z7 = true;
                                        } else {
                                            if (fragment11 == fragment2) {
                                                arrayList9.add(i24, new w.a(9, fragment11));
                                                i24++;
                                                fragment2 = null;
                                            }
                                            w.a aVar9 = new w.a(3, fragment11);
                                            aVar9.d = aVar8.d;
                                            aVar9.f = aVar8.f;
                                            aVar9.e = aVar8.e;
                                            aVar9.g = aVar8.g;
                                            arrayList9.add(i24, aVar9);
                                            arrayList7.remove(fragment11);
                                            i24++;
                                        }
                                    }
                                    size5 = i27 - 1;
                                    i8 = i28;
                                    fragment10 = fragment10;
                                }
                                Fragment fragment12 = fragment10;
                                i7 = i8;
                                i6 = 1;
                                if (z7) {
                                    arrayList9.remove(i24);
                                    i24--;
                                } else {
                                    aVar8.a = 1;
                                    aVar8.c = true;
                                    fragment = fragment12;
                                    arrayList7.add(fragment);
                                }
                            }
                            i24 += i6;
                            i9 = i6;
                            z3 = z2;
                            i8 = i7;
                        } else {
                            i6 = i9;
                        }
                        z2 = z3;
                        i7 = i8;
                        fragment = aVar8.b;
                        arrayList7.add(fragment);
                        i24 += i6;
                        i9 = i6;
                        z3 = z2;
                        i8 = i7;
                    } else {
                        z = z3;
                        i5 = i8;
                    }
                }
            }
            z4 = z4 || aVar6.g;
            i8 = i5 + 1;
            z3 = z;
        }
    }

    public final Fragment C(int i2) {
        v vVar = this.c;
        ArrayList arrayList = vVar.a;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                for (u uVar : vVar.b.values()) {
                    if (uVar != null) {
                        Fragment fragment = uVar.c;
                        if (fragment.mFragmentId == i2) {
                            return fragment;
                        }
                    }
                }
                return null;
            }
            Fragment fragment2 = (Fragment) arrayList.get(size);
            if (fragment2 != null && fragment2.mFragmentId == i2) {
                return fragment2;
            }
        }
    }

    public final Fragment D(String str) {
        v vVar = this.c;
        ArrayList arrayList = vVar.a;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                for (u uVar : vVar.b.values()) {
                    if (uVar != null) {
                        Fragment fragment = uVar.c;
                        if (str.equals(fragment.mTag)) {
                            return fragment;
                        }
                    }
                }
                return null;
            }
            Fragment fragment2 = (Fragment) arrayList.get(size);
            if (fragment2 != null && str.equals(fragment2.mTag)) {
                return fragment2;
            }
        }
    }

    public final ViewGroup E(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId <= 0 || !this.v.c()) {
            return null;
        }
        View viewB = this.v.b(fragment.mContainerId);
        if (viewB instanceof ViewGroup) {
            return (ViewGroup) viewB;
        }
        return null;
    }

    public final o F() {
        Fragment fragment = this.w;
        return fragment != null ? fragment.mFragmentManager.F() : this.y;
    }

    public final b21 G() {
        Fragment fragment = this.w;
        return fragment != null ? fragment.mFragmentManager.G() : this.z;
    }

    public final boolean K() {
        return this.F || this.G;
    }

    public final void L(int i2, boolean z) {
        HashMap map;
        mv mvVar;
        if (this.u == null && i2 != -1) {
            defpackage.d.AnonymousClass0.m("No activity");
            return;
        }
        if (z || i2 != this.t) {
            this.t = i2;
            v vVar = this.c;
            Iterator it = vVar.a.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                map = vVar.b;
                if (!zHasNext) {
                    break;
                }
                u uVar = (u) map.get(((Fragment) it.next()).mWho);
                if (uVar != null) {
                    uVar.i();
                }
            }
            for (u uVar2 : map.values()) {
                if (uVar2 != null) {
                    uVar2.i();
                    Fragment fragment = uVar2.c;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        if (fragment.mBeingSaved && !vVar.c.containsKey(fragment.mWho)) {
                            uVar2.l();
                        }
                        vVar.h(uVar2);
                    }
                }
            }
            Z();
            if (this.E && (mvVar = this.u) != null && this.t == 7) {
                n.this.invalidateOptionsMenu();
                this.E = false;
            }
        }
    }

    public final void M() {
        if (this.u == null) {
            return;
        }
        this.F = false;
        this.G = false;
        this.M.f = false;
        for (Fragment fragment : this.c.f()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public final boolean O(int i2, int i3) {
        y(false);
        x(true);
        Fragment fragment = this.x;
        if (fragment != null && i2 < 0 && fragment.getChildFragmentManager().O(-1, 0)) {
            return true;
        }
        boolean zP = P(this.J, this.K, null, i2, i3);
        if (zP) {
            this.b = true;
            try {
                R(this.J, this.K);
                e();
            } catch (Throwable th) {
                e();
                throw th;
            }
        }
        a0();
        if (this.I) {
            this.I = false;
            Z();
        }
        this.c.b.values().removeAll(Collections.singleton(null));
        return zP;
    }

    public final boolean P(ArrayList arrayList, ArrayList arrayList2, String str, int i2, int i3) {
        boolean z = (i3 & 1) != 0;
        ArrayList arrayList3 = this.d;
        int size = -1;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            if (str != null || i2 >= 0) {
                int size2 = this.d.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.d.get(size2);
                    if ((str != null && str.equals(aVar.i)) || (i2 >= 0 && i2 == aVar.s)) {
                        break;
                    }
                    size2--;
                }
                if (size2 >= 0) {
                    if (z) {
                        while (size2 > 0) {
                            int i4 = size2 - 1;
                            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) this.d.get(i4);
                            if ((str == null || !str.equals(aVar2.i)) && (i2 < 0 || i2 != aVar2.s)) {
                                break;
                            }
                            size2 = i4;
                        }
                    } else if (size2 != this.d.size() - 1) {
                        size2++;
                    }
                    size = size2;
                } else {
                    size = size2;
                }
            } else {
                size = z ? 0 : (-1) + this.d.size();
            }
        }
        if (size < 0) {
            return false;
        }
        for (int size3 = this.d.size() - 1; size3 >= size; size3--) {
            arrayList.add((androidx.fragment.app.a) this.d.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void Q(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Objects.toString(fragment);
        }
        boolean zIsInBackStack = fragment.isInBackStack();
        if (fragment.mDetached && zIsInBackStack) {
            return;
        }
        v vVar = this.c;
        synchronized (vVar.a) {
            vVar.a.remove(fragment);
        }
        fragment.mAdded = false;
        if (I(fragment)) {
            this.E = true;
        }
        fragment.mRemoving = true;
        Y(fragment);
    }

    public final void R(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            defpackage.d.AnonymousClass0.m("Internal error with the back stack records");
            return;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!((androidx.fragment.app.a) arrayList.get(i2)).p) {
                if (i3 != i2) {
                    A(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                    while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((androidx.fragment.app.a) arrayList.get(i3)).p) {
                        i3++;
                    }
                }
                A(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            A(arrayList, arrayList2, i3, size);
        }
    }

    public final void S(Parcelable parcelable) {
        nv nvVar;
        int i2;
        u uVar;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.u.c.getClassLoader());
                this.k.put(str.substring(7), bundle2);
            }
        }
        ArrayList<t> arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.u.c.getClassLoader());
                arrayList.add((t) bundle.getParcelable("state"));
            }
        }
        v vVar = this.c;
        HashMap map = vVar.c;
        map.clear();
        for (t tVar : arrayList) {
            map.put(tVar.c, tVar);
        }
        r rVar = (r) bundle3.getParcelable("state");
        if (rVar == null) {
            return;
        }
        HashMap map2 = vVar.b;
        map2.clear();
        Iterator it = rVar.b.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            nvVar = this.m;
            if (!zHasNext) {
                break;
            }
            t tVar2 = (t) vVar.c.remove((String) it.next());
            if (tVar2 != null) {
                Fragment fragment = (Fragment) this.M.a.get(tVar2.c);
                if (fragment != null) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        fragment.toString();
                    }
                    uVar = new u(nvVar, vVar, fragment, tVar2);
                } else {
                    uVar = new u(this.m, this.c, this.u.c.getClassLoader(), F(), tVar2);
                }
                Fragment fragment2 = uVar.c;
                fragment2.mFragmentManager = this;
                if (Log.isLoggable("FragmentManager", 2)) {
                    fragment2.toString();
                }
                uVar.j(this.u.c.getClassLoader());
                vVar.g(uVar);
                uVar.e = this.t;
            }
        }
        s sVar = this.M;
        sVar.getClass();
        for (Fragment fragment3 : new ArrayList(sVar.a.values())) {
            if (map2.get(fragment3.mWho) == null) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    fragment3.toString();
                    Objects.toString(rVar.b);
                }
                this.M.c(fragment3);
                fragment3.mFragmentManager = this;
                u uVar2 = new u(nvVar, vVar, fragment3);
                uVar2.e = 1;
                uVar2.i();
                fragment3.mRemoving = true;
                uVar2.i();
            }
        }
        ArrayList<String> arrayList2 = rVar.c;
        vVar.a.clear();
        if (arrayList2 != null) {
            for (String str3 : arrayList2) {
                Fragment fragmentB = vVar.b(str3);
                if (fragmentB == null) {
                    throw new IllegalStateException(defpackage.e.n("No instantiated fragment for (", str3, ")"));
                }
                if (Log.isLoggable("FragmentManager", 2)) {
                    fragmentB.toString();
                }
                vVar.a(fragmentB);
            }
        }
        if (rVar.d != null) {
            this.d = new ArrayList(rVar.d.length);
            int i3 = 0;
            while (true) {
                androidx.fragment.app.b[] bVarArr = rVar.d;
                if (i3 >= bVarArr.length) {
                    break;
                }
                androidx.fragment.app.b bVar = bVarArr[i3];
                bVar.getClass();
                androidx.fragment.app.a aVar = new androidx.fragment.app.a(this);
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    int[] iArr = bVar.b;
                    if (i4 >= iArr.length) {
                        break;
                    }
                    w.a aVar2 = new w.a();
                    int i6 = i4 + 1;
                    aVar2.a = iArr[i4];
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Objects.toString(aVar);
                        int i7 = iArr[i6];
                    }
                    aVar2.h = androidx.lifecycle.e.b.values()[bVar.d[i5]];
                    aVar2.i = androidx.lifecycle.e.b.values()[bVar.f[i5]];
                    int i8 = i4 + 2;
                    aVar2.c = iArr[i6] != 0;
                    int i9 = iArr[i8];
                    aVar2.d = i9;
                    int i10 = iArr[i4 + 3];
                    aVar2.e = i10;
                    int i11 = i4 + 5;
                    int i12 = iArr[i4 + 4];
                    aVar2.f = i12;
                    i4 += 6;
                    int i13 = iArr[i11];
                    aVar2.g = i13;
                    aVar.b = i9;
                    aVar.c = i10;
                    aVar.d = i12;
                    aVar.e = i13;
                    aVar.b(aVar2);
                    i5++;
                }
                aVar.f = bVar.g;
                aVar.i = bVar.i;
                aVar.g = true;
                aVar.j = bVar.n;
                aVar.k = bVar.o;
                aVar.l = bVar.p;
                aVar.m = bVar.q;
                aVar.n = bVar.r;
                aVar.o = bVar.s;
                aVar.p = bVar.t;
                aVar.s = bVar.j;
                int i14 = 0;
                while (true) {
                    ArrayList arrayList3 = bVar.c;
                    if (i14 >= arrayList3.size()) {
                        break;
                    }
                    String str4 = (String) arrayList3.get(i14);
                    if (str4 != null) {
                        ((w.a) aVar.a.get(i14)).b = vVar.b(str4);
                    }
                    i14++;
                }
                aVar.e(1);
                if (Log.isLoggable("FragmentManager", 2)) {
                    aVar.toString();
                    PrintWriter printWriter = new PrintWriter(new nf0());
                    aVar.h("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(aVar);
                i3++;
            }
            i2 = 0;
        } else {
            i2 = 0;
            this.d = null;
        }
        this.i.set(rVar.f);
        String str5 = rVar.g;
        if (str5 != null) {
            Fragment fragmentB2 = vVar.b(str5);
            this.x = fragmentB2;
            r(fragmentB2);
        }
        ArrayList arrayList4 = rVar.i;
        if (arrayList4 != null) {
            for (int i15 = i2; i15 < arrayList4.size(); i15++) {
                this.j.put((String) arrayList4.get(i15), (f8) rVar.j.get(i15));
            }
        }
        this.D = new ArrayDeque(rVar.n);
    }

    public final Bundle T() {
        int i2;
        androidx.fragment.app.b[] bVarArr;
        ArrayList arrayList;
        int size;
        Bundle bundle = new Bundle();
        Iterator it = f().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            y yVar = (y) it.next();
            if (yVar.e) {
                yVar.e = false;
                yVar.c();
            }
        }
        Iterator it2 = f().iterator();
        while (it2.hasNext()) {
            ((y) it2.next()).e();
        }
        y(true);
        this.F = true;
        this.M.f = true;
        v vVar = this.c;
        vVar.getClass();
        HashMap map = vVar.b;
        ArrayList arrayList2 = new ArrayList(map.size());
        for (u uVar : map.values()) {
            if (uVar != null) {
                uVar.l();
                Fragment fragment = uVar.c;
                arrayList2.add(fragment.mWho);
                if (Log.isLoggable("FragmentManager", 2)) {
                    fragment.toString();
                    Objects.toString(fragment.mSavedFragmentState);
                }
            }
        }
        v vVar2 = this.c;
        vVar2.getClass();
        ArrayList<t> arrayList3 = new ArrayList(vVar2.c.values());
        if (!arrayList3.isEmpty()) {
            v vVar3 = this.c;
            synchronized (vVar3.a) {
                try {
                    bVarArr = null;
                    if (vVar3.a.isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(vVar3.a.size());
                        for (Fragment fragment2 : vVar3.a) {
                            arrayList.add(fragment2.mWho);
                            if (Log.isLoggable("FragmentManager", 2)) {
                                fragment2.toString();
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            ArrayList arrayList4 = this.d;
            if (arrayList4 != null && (size = arrayList4.size()) > 0) {
                bVarArr = new androidx.fragment.app.b[size];
                for (i2 = 0; i2 < size; i2++) {
                    bVarArr[i2] = new androidx.fragment.app.b((androidx.fragment.app.a) this.d.get(i2));
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Objects.toString(this.d.get(i2));
                    }
                }
            }
            r rVar = new r();
            rVar.b = arrayList2;
            rVar.c = arrayList;
            rVar.d = bVarArr;
            rVar.f = this.i.get();
            Fragment fragment3 = this.x;
            if (fragment3 != null) {
                rVar.g = fragment3.mWho;
            }
            rVar.i.addAll(this.j.keySet());
            rVar.j.addAll(this.j.values());
            rVar.n = new ArrayList(this.D);
            bundle.putParcelable("state", rVar);
            for (String str : this.k.keySet()) {
                bundle.putBundle(ak.m("result_", str), (Bundle) this.k.get(str));
            }
            for (t tVar : arrayList3) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", tVar);
                bundle.putBundle("fragment_" + tVar.c, bundle2);
            }
        }
        return bundle;
    }

    public final void U() {
        synchronized (this.a) {
            try {
                if (this.a.size() == 1) {
                    this.u.d.removeCallbacks(this.N);
                    this.u.d.post(this.N);
                    a0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void V(Fragment fragment, boolean z) {
        ViewGroup viewGroupE = E(fragment);
        if (viewGroupE == null || !(viewGroupE instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupE).f = !z;
    }

    public final void W(Fragment fragment, androidx.lifecycle.e.b bVar) {
        if (fragment.equals(this.c.b(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = bVar;
        } else {
            defpackage.d.AnonymousClass0.m$1("Fragment ", fragment, " is not an active fragment of FragmentManager ", this);
        }
    }

    public final void X(Fragment fragment) {
        if (fragment != null) {
            if (!fragment.equals(this.c.b(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this)) {
                defpackage.d.AnonymousClass0.m$1("Fragment ", fragment, " is not an active fragment of FragmentManager ", this);
                return;
            }
        }
        Fragment fragment2 = this.x;
        this.x = fragment;
        r(fragment2);
        r(this.x);
    }

    public final void Y(Fragment fragment) {
        ViewGroup viewGroupE = E(fragment);
        if (viewGroupE != null) {
            if (fragment.getPopExitAnim() + fragment.getPopEnterAnim() + fragment.getExitAnim() + fragment.getEnterAnim() > 0) {
                if (viewGroupE.getTag(R.attr.a3b) == null) {
                    viewGroupE.setTag(R.attr.a3b, fragment);
                }
                ((Fragment) viewGroupE.getTag(R.attr.a3b)).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    public final void Z() {
        for (u uVar : this.c.d()) {
            Fragment fragment = uVar.c;
            if (fragment.mDeferStart) {
                if (this.b) {
                    this.I = true;
                } else {
                    fragment.mDeferStart = false;
                    uVar.i();
                }
            }
        }
    }

    public final u a(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            uv.d(fragment, str);
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            fragment.toString();
        }
        u uVarG = g(fragment);
        fragment.mFragmentManager = this;
        v vVar = this.c;
        vVar.g(uVarG);
        if (!fragment.mDetached) {
            vVar.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (I(fragment)) {
                this.E = true;
            }
        }
        return uVarG;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [lw, vx] */
    /* JADX WARN: Type inference failed for: r1v10, types: [lw, vx] */
    public final void a0() {
        synchronized (this.a) {
            try {
                if (!this.a.isEmpty()) {
                    b bVar = this.h;
                    bVar.a = true;
                    ?? r1 = bVar.c;
                    if (r1 != 0) {
                        r1.invoke();
                    }
                    return;
                }
                b bVar2 = this.h;
                ArrayList arrayList = this.d;
                bVar2.a = (arrayList != null ? arrayList.size() : 0) > 0 && J(this.w);
                ?? r0 = bVar2.c;
                if (r0 != 0) {
                    r0.invoke();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0022  */
    /* JADX WARN: Code duplicated, block: B:16:0x0029  */
    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    /* JADX WARN: Code duplicated, block: B:22:0x003d  */
    /* JADX WARN: Code duplicated, block: B:24:0x004d  */
    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0060  */
    /* JADX WARN: Code duplicated, block: B:29:0x0076  */
    /* JADX WARN: Code duplicated, block: B:36:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:46:0x0119  */
    /* JADX WARN: Code duplicated, block: B:49:0x0126  */
    /* JADX WARN: Code duplicated, block: B:52:0x0133  */
    /* JADX WARN: Code duplicated, block: B:55:0x0140  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void c(mv mvVar, kv kvVar, Fragment fragment) {
        Object gVar;
        int i2;
        s sVar;
        Object obj;
        int i3;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        String strM;
        Bundle bundleA;
        s sVar2;
        HashMap map;
        s sVar3;
        vm0 vm0Var;
        he0 he0Var;
        if (this.u != null) {
            defpackage.d.AnonymousClass0.m("Already attached");
            return;
        }
        this.u = mvVar;
        this.v = kvVar;
        this.w = fragment;
        if (fragment == null) {
            if (mvVar instanceof sv) {
                gVar = (sv) mvVar;
            }
            if (this.w != null) {
                a0();
            }
            if (mvVar instanceof vm0) {
                vm0Var = (vm0) mvVar;
                OnBackPressedDispatcher onBackPressedDispatcher = vm0Var.getOnBackPressedDispatcher();
                this.g = onBackPressedDispatcher;
                if (fragment != null) {
                    he0Var = vm0Var;
                    he0Var = fragment;
                }
                he0Var = vm0Var;
                onBackPressedDispatcher.a(he0Var, this.h);
            }
            i2 = 0;
            if (fragment != null) {
                sVar2 = fragment.mFragmentManager.M;
                map = sVar2.b;
                sVar3 = (s) map.get(fragment.mWho);
                if (sVar3 == null) {
                    sVar3 = new s(sVar2.d);
                    map.put(fragment.mWho, sVar3);
                }
                this.M = sVar3;
            } else {
                if (mvVar instanceof ce1) {
                    sVar = (s) new androidx.lifecycle.t(((ce1) mvVar).getViewModelStore(), s.g).a(s.class);
                } else {
                    sVar = new s(false);
                }
                this.M = sVar;
            }
            this.M.f = K();
            this.c.d = this.M;
            obj = this.u;
            i3 = 1;
            if ((obj instanceof tx0) && fragment == null) {
                androidx.savedstate.a savedStateRegistry = ((tx0) obj).getSavedStateRegistry();
                savedStateRegistry.c("android:support:fragments", new ev(1, this));
                bundleA = savedStateRegistry.a("android:support:fragments");
                if (bundleA != null) {
                    S(bundleA);
                }
            }
            obj2 = this.u;
            if (obj2 instanceof u2) {
                q2 activityResultRegistry = ((u2) obj2).getActivityResultRegistry();
                if (fragment != null) {
                    strM = fb$1.m(new StringBuilder(), fragment.mWho, ":");
                } else {
                    strM = AppConfig.CUSTOM;
                }
                String strM2 = ak.m("FragmentManager:", strM);
                this.A = activityResultRegistry.d(ak.j(strM2, "StartActivityForResult"), new m2(i3), new h());
                this.B = activityResultRegistry.d(ak.j(strM2, "StartIntentSenderForResult"), new j(), new i());
                this.C = activityResultRegistry.d(ak.j(strM2, "RequestPermissions"), new m2(i2), new a());
            }
            obj3 = this.u;
            if (obj3 instanceof wm0) {
                ((wm0) obj3).addOnConfigurationChangedListener(this.o);
            }
            obj4 = this.u;
            if (obj4 instanceof dn0) {
                ((dn0) obj4).addOnTrimMemoryListener(this.p);
            }
            obj5 = this.u;
            if (obj5 instanceof zm0) {
                ((zm0) obj5).addOnMultiWindowModeChangedListener(this.q);
            }
            obj6 = this.u;
            if (obj6 instanceof an0) {
                ((an0) obj6).addOnPictureInPictureModeChangedListener(this.r);
            }
            obj7 = this.u;
            if ((obj7 instanceof ah0) || fragment != null) {
            }
            ((ah0) obj7).addMenuProvider(this.s);
            return;
        }
        gVar = new g(fragment);
        this.n.add(gVar);
        if (this.w != null) {
            a0();
        }
        if (mvVar instanceof vm0) {
            vm0Var = (vm0) mvVar;
            OnBackPressedDispatcher onBackPressedDispatcher2 = vm0Var.getOnBackPressedDispatcher();
            this.g = onBackPressedDispatcher2;
            if (fragment != null) {
                he0Var = vm0Var;
                he0Var = fragment;
            }
            he0Var = vm0Var;
            onBackPressedDispatcher2.a(he0Var, this.h);
        }
        i2 = 0;
        if (fragment != null) {
            sVar2 = fragment.mFragmentManager.M;
            map = sVar2.b;
            sVar3 = (s) map.get(fragment.mWho);
            if (sVar3 == null) {
                sVar3 = new s(sVar2.d);
                map.put(fragment.mWho, sVar3);
            }
            this.M = sVar3;
        } else {
            if (mvVar instanceof ce1) {
                sVar = (s) new androidx.lifecycle.t(((ce1) mvVar).getViewModelStore(), s.g).a(s.class);
            } else {
                sVar = new s(false);
            }
            this.M = sVar;
        }
        this.M.f = K();
        this.c.d = this.M;
        obj = this.u;
        i3 = 1;
        if (obj instanceof tx0) {
            androidx.savedstate.a savedStateRegistry2 = ((tx0) obj).getSavedStateRegistry();
            savedStateRegistry2.c("android:support:fragments", new ev(1, this));
            bundleA = savedStateRegistry2.a("android:support:fragments");
            if (bundleA != null) {
                S(bundleA);
            }
        }
        obj2 = this.u;
        if (obj2 instanceof u2) {
            q2 activityResultRegistry2 = ((u2) obj2).getActivityResultRegistry();
            if (fragment != null) {
                strM = fb$1.m(new StringBuilder(), fragment.mWho, ":");
            } else {
                strM = AppConfig.CUSTOM;
            }
            String strM3 = ak.m("FragmentManager:", strM);
            this.A = activityResultRegistry2.d(ak.j(strM3, "StartActivityForResult"), new m2(i3), new h());
            this.B = activityResultRegistry2.d(ak.j(strM3, "StartIntentSenderForResult"), new j(), new i());
            this.C = activityResultRegistry2.d(ak.j(strM3, "RequestPermissions"), new m2(i2), new a());
        }
        obj3 = this.u;
        if (obj3 instanceof wm0) {
            ((wm0) obj3).addOnConfigurationChangedListener(this.o);
        }
        obj4 = this.u;
        if (obj4 instanceof dn0) {
            ((dn0) obj4).addOnTrimMemoryListener(this.p);
        }
        obj5 = this.u;
        if (obj5 instanceof zm0) {
            ((zm0) obj5).addOnMultiWindowModeChangedListener(this.q);
        }
        obj6 = this.u;
        if (obj6 instanceof an0) {
            ((an0) obj6).addOnPictureInPictureModeChangedListener(this.r);
        }
        obj7 = this.u;
        if (obj7 instanceof ah0) {
        }
    }

    public final void d(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Objects.toString(fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.c.a(fragment);
            if (Log.isLoggable("FragmentManager", 2)) {
                fragment.toString();
            }
            if (I(fragment)) {
                this.E = true;
            }
        }
    }

    public final void e() {
        this.b = false;
        this.K.clear();
        this.J.clear();
    }

    public final HashSet f() {
        HashSet hashSet = new HashSet();
        Iterator it = this.c.d().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((u) it.next()).c.mContainer;
            if (viewGroup != null) {
                hashSet.add(y.f(viewGroup, G()));
            }
        }
        return hashSet;
    }

    public final u g(Fragment fragment) {
        String str = fragment.mWho;
        v vVar = this.c;
        u uVar = (u) vVar.b.get(str);
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(this.m, vVar, fragment);
        uVar2.j(this.u.c.getClassLoader());
        uVar2.e = this.t;
        return uVar2;
    }

    public final void h(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Objects.toString(fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (Log.isLoggable("FragmentManager", 2)) {
                fragment.toString();
            }
            v vVar = this.c;
            synchronized (vVar.a) {
                vVar.a.remove(fragment);
            }
            fragment.mAdded = false;
            if (I(fragment)) {
                this.E = true;
            }
            Y(fragment);
        }
    }

    public final boolean j(MenuItem menuItem) {
        if (this.t < 1) {
            return false;
        }
        for (Fragment fragment : this.c.f()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean k(Menu menu, MenuInflater menuInflater) {
        if (this.t < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.c.f()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                Fragment fragment2 = (Fragment) this.e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    public final void l() {
        boolean zIsChangingConfigurations = true;
        this.H = true;
        y(true);
        Iterator it = f().iterator();
        while (it.hasNext()) {
            ((y) it.next()).e();
        }
        mv mvVar = this.u;
        boolean z = mvVar instanceof ce1;
        v vVar = this.c;
        if (z) {
            zIsChangingConfigurations = vVar.d.e;
        } else {
            n nVar = mvVar.c;
            if (nVar != null) {
                zIsChangingConfigurations = true ^ nVar.isChangingConfigurations();
            }
        }
        if (zIsChangingConfigurations) {
            Iterator it2 = this.j.values().iterator();
            while (it2.hasNext()) {
                Iterator it3 = ((f8) it2.next()).b.iterator();
                while (it3.hasNext()) {
                    vVar.d.b((String) it3.next());
                }
            }
        }
        u(-1);
        Object obj = this.u;
        if (obj instanceof dn0) {
            ((dn0) obj).removeOnTrimMemoryListener(this.p);
        }
        Object obj2 = this.u;
        if (obj2 instanceof wm0) {
            ((wm0) obj2).removeOnConfigurationChangedListener(this.o);
        }
        Object obj3 = this.u;
        if (obj3 instanceof zm0) {
            ((zm0) obj3).removeOnMultiWindowModeChangedListener(this.q);
        }
        Object obj4 = this.u;
        if (obj4 instanceof an0) {
            ((an0) obj4).removeOnPictureInPictureModeChangedListener(this.r);
        }
        Object obj5 = this.u;
        if (obj5 instanceof ah0) {
            ((ah0) obj5).removeMenuProvider(this.s);
        }
        this.u = null;
        this.v = null;
        this.w = null;
        if (this.g != null) {
            Iterator it4 = this.h.b.iterator();
            while (it4.hasNext()) {
                ((cb) it4.next()).cancel();
            }
            this.g = null;
        }
        t2 t2Var = this.A;
        if (t2Var != null) {
            t2Var.a.f(t2Var.b);
            t2 t2Var2 = this.B;
            t2Var2.a.f(t2Var2.b);
            t2 t2Var3 = this.C;
            t2Var3.a.f(t2Var3.b);
        }
    }

    public final void o() {
        for (Fragment fragment : this.c.e()) {
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.o();
            }
        }
    }

    public final boolean p(MenuItem menuItem) {
        if (this.t < 1) {
            return false;
        }
        for (Fragment fragment : this.c.f()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void q(Menu menu) {
        if (this.t < 1) {
            return;
        }
        for (Fragment fragment : this.c.f()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void r(Fragment fragment) {
        if (fragment != null) {
            if (fragment.equals(this.c.b(fragment.mWho))) {
                fragment.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final boolean t(Menu menu) {
        boolean z = false;
        if (this.t < 1) {
            return false;
        }
        for (Fragment fragment : this.c.f()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final String toString() {
        String str;
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.w;
        if (fragment == null) {
            mv mvVar = this.u;
            if (mvVar != null) {
                sb.append(mvVar.getClass().getSimpleName());
                sb.append("{");
                obj = this.u;
            } else {
                str = "null";
            }
            sb.append(str);
            sb.append("}}");
            return sb.toString();
        }
        sb.append(fragment.getClass().getSimpleName());
        sb.append("{");
        obj = this.w;
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        str = "}";
        sb.append(str);
        sb.append("}}");
        return sb.toString();
    }

    public final void u(int i2) {
        try {
            this.b = true;
            for (u uVar : this.c.b.values()) {
                if (uVar != null) {
                    uVar.e = i2;
                }
            }
            L(i2, false);
            Iterator it = f().iterator();
            while (it.hasNext()) {
                ((y) it.next()).e();
            }
            this.b = false;
            y(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public final void v(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String strJ = ak.j(str, "    ");
        v vVar = this.c;
        vVar.getClass();
        String str2 = str + "    ";
        HashMap map = vVar.b;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (u uVar : map.values()) {
                printWriter.print(str);
                if (uVar != null) {
                    Fragment fragment = uVar.c;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = vVar.a;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size3; i2++) {
                Fragment fragment2 = (Fragment) arrayList.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList arrayList2 = this.e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                Fragment fragment3 = (Fragment) this.e.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList arrayList3 = this.d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.h(strJ, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.a) {
            try {
                int size4 = this.a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i5 = 0; i5 < size4; i5++) {
                        Object obj = (l) this.a.get(i5);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.u);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.v);
        if (this.w != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.w);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.t);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.F);
        printWriter.print(" mStopped=");
        printWriter.print(this.G);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.H);
        if (this.E) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.E);
        }
    }

    public final void w(l lVar, boolean z) {
        String str;
        if (!z) {
            if (this.u == null) {
                str = this.H ? "FragmentManager has been destroyed" : "FragmentManager has not been attached to a host.";
            } else if (K()) {
                str = "Can not perform this action after onSaveInstanceState";
            }
            defpackage.d.AnonymousClass0.m(str);
            return;
        }
        synchronized (this.a) {
            try {
                if (this.u != null) {
                    this.a.add(lVar);
                    U();
                } else if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void x(boolean z) {
        if (this.b) {
            defpackage.d.AnonymousClass0.m("FragmentManager is already executing transactions");
            return;
        }
        if (this.u == null) {
            if (this.H) {
                defpackage.d.AnonymousClass0.m("FragmentManager has been destroyed");
                return;
            } else {
                defpackage.d.AnonymousClass0.m("FragmentManager has not been attached to a host.");
                return;
            }
        }
        if (Looper.myLooper() != this.u.d.getLooper()) {
            defpackage.d.AnonymousClass0.m("Must be called from main thread of fragment host");
            return;
        }
        if (!z && K()) {
            defpackage.d.AnonymousClass0.m("Can not perform this action after onSaveInstanceState");
        } else if (this.J == null) {
            this.J = new ArrayList();
            this.K = new ArrayList();
        }
    }

    public final void y(boolean z) {
        boolean zA;
        ArrayList arrayList;
        x(z);
        while (true) {
            ArrayList arrayList2 = this.J;
            ArrayList arrayList3 = this.K;
            synchronized (this.a) {
                if (this.a.isEmpty()) {
                    zA = false;
                } else {
                    try {
                        int size = this.a.size();
                        int i2 = 0;
                        zA = false;
                        while (true) {
                            arrayList = this.a;
                            if (i2 >= size) {
                                break;
                            }
                            zA |= ((l) arrayList.get(i2)).a(arrayList2, arrayList3);
                            i2++;
                            throw th;
                        }
                        arrayList.clear();
                        this.u.d.removeCallbacks(this.N);
                    } catch (Throwable th) {
                        this.a.clear();
                        this.u.d.removeCallbacks(this.N);
                        throw th;
                    }
                }
            }
            if (!zA) {
                break;
            }
            this.b = true;
            try {
                R(this.J, this.K);
                e();
            } catch (Throwable th2) {
                e();
                throw th2;
            }
        }
        a0();
        if (this.I) {
            this.I = false;
            Z();
        }
        this.c.b.values().removeAll(Collections.singleton(null));
    }

    public final void z(androidx.fragment.app.a aVar, boolean z) {
        if (z && (this.u == null || this.H)) {
            return;
        }
        x(z);
        aVar.a(this.J, this.K);
        this.b = true;
        try {
            R(this.J, this.K);
            e();
            a0();
            if (this.I) {
                this.I = false;
                Z();
            }
            this.c.b.values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            e();
            throw th;
        }
    }
}
