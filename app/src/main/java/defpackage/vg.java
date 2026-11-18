package defpackage;

import com.trilead.ssh2.sftp.AttribFlags;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class vg {
    public int b;
    public boolean c;
    public final ch d;
    public final a e;
    public vg f;
    public q11 i;
    public HashSet a = null;
    public int g = 0;
    public int h = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a f;
        public static final a g;
        public static final a i;
        public static final a j;
        public static final a n;
        public static final /* synthetic */ a[] o;

        /* JADX INFO: Fake field, exist only in values array */
        a EF0;

        static {
            a aVar = new a("NONE", 0);
            a aVar2 = new a("LEFT", 1);
            b = aVar2;
            a aVar3 = new a("TOP", 2);
            c = aVar3;
            a aVar4 = new a("RIGHT", 3);
            d = aVar4;
            a aVar5 = new a("BOTTOM", 4);
            f = aVar5;
            a aVar6 = new a("BASELINE", 5);
            g = aVar6;
            a aVar7 = new a("CENTER", 6);
            i = aVar7;
            a aVar8 = new a("CENTER_X", 7);
            j = aVar8;
            a aVar9 = new a("CENTER_Y", 8);
            n = aVar9;
            o = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) o.clone();
        }
    }

    public vg(ch chVar, a aVar) {
        this.d = chVar;
        this.e = aVar;
    }

    public final void a(vg vgVar, int i, int i2) {
        if (vgVar == null) {
            g();
            return;
        }
        this.f = vgVar;
        if (vgVar.a == null) {
            vgVar.a = new HashSet();
        }
        HashSet hashSet = this.f.a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.g = i;
        this.h = i2;
    }

    public final void b(int i, xf1 xf1Var, ArrayList arrayList) {
        HashSet hashSet = this.a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                e4.a(((vg) it.next()).d, i, arrayList, xf1Var);
            }
        }
    }

    public final int c() {
        if (this.c) {
            return this.b;
        }
        return 0;
    }

    public final int d() {
        vg vgVar;
        if (this.d.j0 == 8) {
            return 0;
        }
        int i = this.h;
        return (i == Integer.MIN_VALUE || (vgVar = this.f) == null || vgVar.d.j0 != 8) ? this.g : i;
    }

    public final boolean e() {
        vg vgVar;
        HashSet<vg> hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        for (vg vgVar2 : hashSet) {
            a aVar = vgVar2.e;
            int iOrdinal = aVar.ordinal();
            ch chVar = vgVar2.d;
            switch (iOrdinal) {
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                    vgVar = null;
                    break;
                case 1:
                    vgVar = chVar.M;
                    break;
                case 2:
                    vgVar = chVar.N;
                    break;
                case 3:
                    vgVar = chVar.K;
                    break;
                case 4:
                    vgVar = chVar.L;
                    break;
                default:
                    throw new AssertionError(aVar.name());
            }
            if (vgVar.f()) {
                return true;
            }
        }
        return false;
    }

    public final boolean f() {
        return this.f != null;
    }

    public final void g() {
        HashSet hashSet;
        vg vgVar = this.f;
        if (vgVar != null && (hashSet = vgVar.a) != null) {
            hashSet.remove(this);
            if (this.f.a.size() == 0) {
                this.f.a = null;
            }
        }
        this.a = null;
        this.f = null;
        this.g = 0;
        this.h = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        this.c = false;
        this.b = 0;
    }

    public final void h() {
        q11 q11Var = this.i;
        if (q11Var == null) {
            this.i = new q11(1);
        } else {
            q11Var.c();
        }
    }

    public final void i(int i) {
        this.b = i;
        this.c = true;
    }

    public final String toString() {
        return this.d.k0 + ":" + this.e.toString();
    }
}
