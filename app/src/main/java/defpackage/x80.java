package defpackage;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class x80 {
    public static final ps a;

    static {
        ps psVar = new ps();
        psVar.a(w80.a);
        psVar.a(w80.b);
        psVar.a(w80.c);
        psVar.a(w80.d);
        psVar.a(w80.e);
        psVar.a(w80.f);
        psVar.a(w80.g);
        psVar.a(w80.h);
        psVar.a(w80.i);
        psVar.a(w80.j);
        psVar.a(w80.k);
        psVar.a(w80.l);
        psVar.a(w80.m);
        psVar.a(w80.n);
        a = psVar;
    }

    public static p80$b a(ar0 ar0Var, jj0 jj0Var, fi0 fi0Var) {
        String strR0;
        w80.b bVar = (w80.b) e.z(ar0Var, w80.a);
        String string = (bVar == null || (bVar.c & 1) != 1) ? "<init>" : jj0Var.getString(bVar.d);
        if (bVar == null || (bVar.c & 2) != 2) {
            List list = ar0Var.g;
            ArrayList arrayList = new ArrayList(ae.y0(list));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String strE = e(e.w0((rr0) it.next(), fi0Var), jj0Var);
                if (strE == null) {
                    return null;
                }
                arrayList.add(strE);
            }
            strR0 = he.R0(arrayList, AppConfig.CUSTOM, "(", ")V", null, 56);
        } else {
            strR0 = jj0Var.getString(bVar.f);
        }
        return new p80$b(string, strR0);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r4v2 java.lang.String, still in use, count: 2, list:
          (r4v2 java.lang.String) from 0x003e: IF  (r4v2 java.lang.String) == (null java.lang.String)  -> B:23:0x0040 A[HIDDEN]
          (r4v2 java.lang.String) from 0x0041: PHI (r4 I:??) = (r4v2 java.lang.String), (r4v5 java.lang.String) binds: [B:22:0x003e, B:20:0x002f] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public static defpackage.p80$a b(defpackage.kr0 r4, defpackage.jj0 r5, defpackage.fi0 r6, boolean r7) {
        /*
            yx$e r0 = defpackage.w80.d
            java.lang.Object r0 = defpackage.e.z(r4, r0)
            w80$c r0 = (w80.c) r0
            r1 = 0
            if (r0 != 0) goto Lc
            goto L40
        Lc:
            int r2 = r0.c
            r3 = 1
            r2 = r2 & r3
            if (r2 != r3) goto L15
            w80$a r0 = r0.d
            goto L16
        L15:
            r0 = r1
        L16:
            if (r0 != 0) goto L1b
            if (r7 == 0) goto L1b
            goto L40
        L1b:
            if (r0 == 0) goto L25
            int r7 = r0.c
            r7 = r7 & r3
            if (r7 != r3) goto L25
            int r7 = r0.d
            goto L27
        L25:
            int r7 = r4.i
        L27:
            if (r0 == 0) goto L36
            int r2 = r0.c
            r3 = 2
            r2 = r2 & r3
            if (r2 != r3) goto L36
            int r4 = r0.f
            java.lang.String r4 = r5.getString(r4)
            goto L41
        L36:
            nr0 r4 = defpackage.e.l0(r4, r6)
            java.lang.String r4 = e(r4, r5)
            if (r4 != 0) goto L41
        L40:
            return r1
        L41:
            p80$a r6 = new p80$a
            java.lang.String r5 = r5.getString(r7)
            r6.<init>(r5, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x80.b(kr0, jj0, fi0, boolean):p80$a");
    }

    public static p80$b c(fr0 fr0Var, jj0 jj0Var, fi0 fi0Var) {
        nr0 nr0VarA;
        String strJ;
        w80.b bVar = (w80.b) e.z(fr0Var, w80.b);
        int i = (bVar == null || (bVar.c & 1) != 1) ? fr0Var.i : bVar.d;
        if (bVar == null || (bVar.c & 2) != 2) {
            int i2 = fr0Var.d;
            if ((i2 & 32) == 32) {
                nr0VarA = fr0Var.p;
            } else {
                nr0VarA = (i2 & 64) == 64 ? fi0Var.a(fr0Var.q) : null;
            }
            List listZ = e.Z(nr0VarA);
            List list = fr0Var.r;
            ArrayList arrayList = new ArrayList(ae.y0(list));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(e.w0((rr0) it.next(), fi0Var));
            }
            ArrayList arrayListX0 = he.X0(arrayList, listZ);
            ArrayList arrayList2 = new ArrayList(ae.y0(arrayListX0));
            Iterator it2 = arrayListX0.iterator();
            while (it2.hasNext()) {
                String strE = e((nr0) it2.next(), jj0Var);
                if (strE == null) {
                    return null;
                }
                arrayList2.add(strE);
            }
            String strE2 = e(e.k0(fr0Var, fi0Var), jj0Var);
            if (strE2 != null) {
                strJ = e4.j(he.R0(arrayList2, AppConfig.CUSTOM, "(", ")", null, 56), strE2);
            }
            return null;
        }
        strJ = jj0Var.getString(bVar.f);
        return new p80$b(jj0Var.getString(i), strJ);
    }

    public static final boolean d(kr0 kr0Var) {
        return e4.f48a.c(((Number) kr0Var.g(w80.e)).intValue()).booleanValue();
    }

    public static String e(nr0 nr0Var, jj0 jj0Var) {
        if (nr0Var.m()) {
            return fd.b(jj0Var.b(nr0Var.o));
        }
        return null;
    }

    public static final jo0 f(String[] strArr, String[] strArr2) throws t30 {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(z8.b(strArr));
        ar0.a aVar = w80.d.n;
        ps psVar = a;
        r80 r80Var = new r80((w80.d) aVar.c(byteArrayInputStream, psVar), strArr2);
        zq0.I.getClass();
        xd xdVar = new xd(byteArrayInputStream);
        zq0 zq0Var = new zq0(xdVar, psVar);
        try {
            xdVar.a(0);
            ar0.a.b(zq0Var);
            return new jo0(r80Var, zq0Var);
        } catch (t30 e) {
            e.b = zq0Var;
            throw e;
        }
    }

    public static final jo0 h(String[] strArr, String[] strArr2) throws t30 {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(z8.b(strArr));
        ar0.a aVar = w80.d.n;
        ps psVar = a;
        r80 r80Var = new r80((w80.d) aVar.c(byteArrayInputStream, psVar), strArr2);
        ir0.r.getClass();
        xd xdVar = new xd(byteArrayInputStream);
        ir0 ir0Var = new ir0(xdVar, psVar);
        try {
            xdVar.a(0);
            ar0.a.b(ir0Var);
            return new jo0(r80Var, ir0Var);
        } catch (t30 e) {
            e.b = ir0Var;
            throw e;
        }
    }
}
