package defpackage;

import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.a;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class qu0 extends pu0 {
    public static p90 i(a aVar) {
        o90 owner = aVar.getOwner();
        return owner instanceof p90 ? (p90) owner : qq.c;
    }

    @Override // defpackage.pu0
    public final u90 a(ux uxVar) {
        return new v90(i(uxVar), uxVar.getName(), uxVar.getSignature(), null, uxVar.receiver);
    }

    @Override // defpackage.pu0
    public final h90 b(Class cls) {
        Object obj;
        j90 j90Var;
        b10 b10VarA;
        b10 b10Var = i90.a;
        String name = cls.getName();
        b10 b10Var2 = i90.a;
        b10Var2.getClass();
        pg pgVar = (pg) b10Var2.a.a.a(name.hashCode());
        if (pgVar == null) {
            pgVar = pg.f;
        }
        while (true) {
            if (pgVar == null || pgVar.d <= 0) {
                obj = null;
                break;
            }
            eg0 eg0Var = (eg0) pgVar.b;
            if (eg0Var.b.equals(name)) {
                obj = eg0Var.c;
                break;
            }
            pgVar = pgVar.c;
        }
        if (!(obj instanceof WeakReference)) {
            if (obj != null) {
                WeakReference[] weakReferenceArr = (WeakReference[]) obj;
                int length = weakReferenceArr.length;
                int i = 0;
                while (i < length) {
                    WeakReference weakReference = weakReferenceArr[i];
                    i++;
                    j90 j90Var2 = (j90) weakReference.get();
                    if (e4.a(j90Var2 == null ? null : j90Var2.c, cls)) {
                        return j90Var2;
                    }
                }
                int length2 = ((Object[]) obj).length;
                WeakReference[] weakReferenceArr2 = new WeakReference[length2 + 1];
                System.arraycopy(obj, 0, weakReferenceArr2, 0, length2);
                j90Var = new j90(cls);
                weakReferenceArr2[length2] = new WeakReference(j90Var);
                b10VarA = i90.a.a(name, weakReferenceArr2);
            }
            i90.a = b10VarA;
            return j90Var;
        }
        j90 j90Var3 = (j90) ((WeakReference) obj).get();
        if (e4.a(j90Var3 != null ? j90Var3.c : null, cls)) {
            return j90Var3;
        }
        j90Var = new j90(cls);
        b10VarA = i90.a.a(name, new WeakReference(j90Var));
        i90.a = b10VarA;
        return j90Var;
    }

    @Override // defpackage.pu0
    public final o90 c(Class cls, String str) {
        return new ea0(cls);
    }

    @Override // defpackage.pu0
    public final z90 d(aj0 aj0Var) {
        return new aa0(i(aj0Var), aj0Var.name, aj0Var.signature, aj0Var.receiver);
    }

    @Override // defpackage.pu0
    public final ka0 e(kf0.b bVar) {
        return new la0(i(bVar), bVar.name, bVar.signature, bVar.receiver);
    }

    @Override // defpackage.pu0
    public final ma0 f(tq0 tq0Var) {
        return new na0(i(tq0Var), tq0Var.name, tq0Var.signature, tq0Var.receiver);
    }

    @Override // defpackage.pu0
    public final String g(kx kxVar) throws t30 {
        v90 v90VarA;
        Metadata metadata = (Metadata) kxVar.getClass().getAnnotation(Metadata.class);
        v90 v90Var = null;
        if (metadata != null) {
            String[] strArrD1 = metadata.d1();
            if (strArrD1.length == 0) {
                strArrD1 = null;
            }
            if (strArrD1 != null) {
                String[] strArrD2 = metadata.d2();
                ps psVar = x80.a;
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(z8.b(strArrD1));
                ar0.a aVar = w80.d.n;
                ps psVar2 = x80.a;
                r80 r80Var = new r80((w80.d) aVar.c(byteArrayInputStream, psVar2), strArrD2);
                fr0.y.getClass();
                xd xdVar = new xd(byteArrayInputStream);
                fr0 fr0Var = new fr0(xdVar, psVar2);
                try {
                    xdVar.a(0);
                    ar0.a.b(fr0Var);
                    v90Var = new v90(qq.c, (q01) lc1.d(kxVar.getClass(), fr0Var, r80Var, new fi0(fr0Var.s), new q80(metadata.mv(), (metadata.xi() & 8) != 0), mu0.d));
                } catch (t30 e) {
                    e.b = fr0Var;
                    throw e;
                }
            }
        }
        if (v90Var == null || (v90VarA = lc1.a(v90Var)) == null) {
            return super.g(kxVar);
        }
        nm nmVar = ru0.a;
        ox oxVarP = v90VarA.l();
        StringBuilder sb = new StringBuilder();
        ru0.a(sb, oxVarP);
        he.P0(oxVarP.f(), sb, "(", ")", p0.b$8, 48);
        sb.append(" -> ");
        sb.append(ru0.a.s(oxVarP.getReturnType()));
        return sb.toString();
    }

    @Override // defpackage.pu0
    public final String h(oc0 oc0Var) {
        return g(oc0Var);
    }
}
