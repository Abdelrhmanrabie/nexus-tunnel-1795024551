package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class v8 implements xb0$a, a4 {
    public final Object a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;

    public v8(c60 c60Var, y91 y91Var, rc0 rc0Var) {
        this.a = c60Var;
        this.b = y91Var;
        this.c = rc0Var;
        this.d = rc0Var;
        this.e = new oo(this, y91Var);
    }

    public v8(hg hgVar, hg hgVar2, ij0 ij0Var, ArrayList arrayList) {
        this.b = hgVar;
        this.c = hgVar2;
        this.d = ij0Var;
        this.e = arrayList;
        this.a = hgVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v8(ji0 ji0Var, oo ooVar, ff0 ff0Var, ku0 ku0Var) {
        this.a = ku0Var;
        this.b = ff0Var.g(new i(0, this));
        this.c = ji0Var;
        this.d = ooVar;
        this.e = new g(ji0Var, ooVar, 13, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ List m(v8 v8Var, dg0 dg0Var, xg0 xg0Var, Boolean bool, boolean z, int i) {
        boolean z2 = (i & 4) == 0;
        if ((i & 16) != 0) {
            bool = null;
        }
        return v8Var.l(dg0Var, xg0Var, z2, false, bool, (i & 32) != 0 ? false : z);
    }

    public static xg0 n(b0 b0Var, jj0 jj0Var, fi0 fi0Var, x3 x3Var, boolean z) {
        w80.c cVar;
        p80$b p80_bC;
        if (b0Var instanceof ar0) {
            p80_bC = x80.a((ar0) b0Var, jj0Var, fi0Var);
            if (p80_bC == null) {
                return null;
            }
        } else {
            if (!(b0Var instanceof fr0)) {
                if (!(b0Var instanceof kr0) || (cVar = (w80.c) e.z((yx.c) b0Var, w80.d)) == null) {
                    return null;
                }
                int iOrdinal = x3Var.ordinal();
                if (iOrdinal == 1) {
                    return o((kr0) b0Var, jj0Var, fi0Var, true, true, z);
                }
                if (iOrdinal == 2) {
                    if ((cVar.c & 4) != 4) {
                        return null;
                    }
                    w80.b bVar = cVar.g;
                    return new xg0(e4.j(jj0Var.getString(bVar.d), jj0Var.getString(bVar.f)));
                }
                if (iOrdinal != 3 || (cVar.c & 8) != 8) {
                    return null;
                }
                w80.b bVar2 = cVar.i;
                return new xg0(e4.j(jj0Var.getString(bVar2.d), jj0Var.getString(bVar2.f)));
            }
            p80_bC = x80.c((fr0) b0Var, jj0Var, fi0Var);
            if (p80_bC == null) {
                return null;
            }
        }
        return ui.a(p80_bC);
    }

    public static xg0 o(kr0 kr0Var, jj0 jj0Var, fi0 fi0Var, boolean z, boolean z2, boolean z3) {
        w80.c cVar = (w80.c) e.z(kr0Var, w80.d);
        if (cVar == null) {
            return null;
        }
        if (z) {
            p80$a p80_aB = x80.b(kr0Var, jj0Var, fi0Var, z3);
            if (p80_aB == null) {
                return null;
            }
            return ui.a(p80_aB);
        }
        if (!z2 || (cVar.c & 2) != 2) {
            return null;
        }
        w80.b bVar = cVar.f;
        return new xg0(e4.j(jj0Var.getString(bVar.d), jj0Var.getString(bVar.f)));
    }

    public static /* synthetic */ xg0 p(v8 v8Var, kr0 kr0Var, jj0 jj0Var, fi0 fi0Var, int i) {
        return o(kr0Var, jj0Var, fi0Var, (i & 8) == 0, (i & 16) == 0, true);
    }

    public static ju0 u(vr0$a vr0_a) {
        t11 t11Var = (t11) vr0_a.c;
        zb0 zb0Var = t11Var instanceof zb0 ? (zb0) t11Var : null;
        if (zb0Var == null) {
            return null;
        }
        return zb0Var.b;
    }

    @Override // defpackage.a4
    public List a(dg0 dg0Var, b0 b0Var, x3 x3Var) {
        xg0 xg0VarN = n(b0Var, (jj0) dg0Var.a, (fi0) dg0Var.b, x3Var, false);
        return xg0VarN != null ? m(this, dg0Var, new xg0(xg0VarN.a.concat("@0")), null, false, 60) : uq.b;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, rc0] */
    public t60 a() {
        return (t60) this.d.getValue();
    }

    @Override // defpackage.xb0$a
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo57a() {
        ((hg) this.b).mo57a();
        ((HashMap) ((hg) this.c).e).put((ij0) this.d, new r4((g4) he.a1((ArrayList) this.e)));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0048  */
    @Override // defpackage.a4
    public List b(dg0 dg0Var, b0 b0Var, x3 x3Var, int i, rr0 rr0Var) {
        int i2 = 0;
        xg0 xg0VarN = n(b0Var, (jj0) dg0Var.a, (fi0) dg0Var.b, x3Var, false);
        if (xg0VarN == null) {
            return uq.b;
        }
        if (b0Var instanceof fr0) {
            int i3 = ((fr0) b0Var).d;
            if ((i3 & 32) == 32 || (i3 & 64) == 64) {
                i2 = 1;
            }
        } else if (b0Var instanceof kr0) {
            int i4 = ((kr0) b0Var).d;
            if ((i4 & 32) == 32 || (i4 & 64) == 64) {
                i2 = 1;
            }
        } else {
            if (!(b0Var instanceof ar0)) {
                throw new UnsupportedOperationException(e4.j("Unsupported message: ", b0Var.getClass()));
            }
            vr0$a vr0_a = (vr0$a) dg0Var;
            if (vr0_a.g == zq0.c.f) {
                i2 = 2;
            } else if (vr0_a.h) {
                i2 = 1;
            }
        }
        return m(this, dg0Var, new xg0(xg0VarN.a + '@' + (i + i2)), null, false, 60);
    }

    @Override // defpackage.xb0$a
    public void b(ij0 ij0Var, ed edVar) {
        ((hg) this.a).b(ij0Var, edVar);
    }

    @Override // defpackage.a4
    public ArrayList c(nr0 nr0Var, jj0 jj0Var) {
        Iterable iterable = (Iterable) nr0Var.g(w80.f);
        ArrayList arrayList = new ArrayList(ae.y0(iterable));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((g) this.e).a((yq0) it.next(), jj0Var));
        }
        return arrayList;
    }

    @Override // defpackage.xb0$a
    public xb0$b c(ij0 ij0Var) {
        return ((hg) this.a).c(ij0Var);
    }

    @Override // defpackage.a4
    public List d(dg0 dg0Var, b0 b0Var, x3 x3Var) {
        if (x3Var == x3.c) {
            return t(dg0Var, (kr0) b0Var, 1);
        }
        xg0 xg0VarN = n(b0Var, (jj0) dg0Var.a, (fi0) dg0Var.b, x3Var, false);
        return xg0VarN == null ? uq.b : m(this, dg0Var, xg0VarN, null, false, 60);
    }

    @Override // defpackage.xb0$a
    public void d(ij0 ij0Var, dd ddVar, ij0 ij0Var2) {
        ((hg) this.a).d(ij0Var, ddVar, ij0Var2);
    }

    @Override // defpackage.a4
    public ArrayList e(pr0 pr0Var, jj0 jj0Var) {
        Iterable iterable = (Iterable) pr0Var.g(w80.h);
        ArrayList arrayList = new ArrayList(ae.y0(iterable));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((g) this.e).a((yq0) it.next(), jj0Var));
        }
        return arrayList;
    }

    @Override // defpackage.xb0$a
    public xb0$a e(dd ddVar, ij0 ij0Var) {
        return ((hg) this.a).e(ddVar, ij0Var);
    }

    @Override // defpackage.a4
    public List f(dg0 dg0Var, kr0 kr0Var) {
        return t(dg0Var, kr0Var, 2);
    }

    @Override // defpackage.xb0$a
    public void f(Object obj, ij0 ij0Var) {
        ((hg) this.a).f(obj, ij0Var);
    }

    @Override // defpackage.a4
    public ArrayList g(vr0$a vr0_a) throws InvocationTargetException {
        ju0 ju0VarU = u(vr0_a);
        if (ju0VarU == null) {
            throw new IllegalStateException(e4.j("Class for loading annotations is not found: ", vr0_a.f.b()).toString());
        }
        ArrayList arrayList = new ArrayList(1);
        e.C(ju0VarU.a, new g(this, arrayList, 12, false));
        return arrayList;
    }

    @Override // defpackage.a4
    public List h(vr0$a vr0_a, dr0 dr0Var) {
        return m(this, vr0_a, new xg0(((jj0) vr0_a.a).getString(dr0Var.f) + '#' + fd.b(vr0_a.f.c())), null, false, 60);
    }

    @Override // defpackage.a4
    public List i(dg0 dg0Var, kr0 kr0Var) {
        return t(dg0Var, kr0Var, 3);
    }

    @Override // defpackage.a4
    public Object j(dg0 dg0Var, kr0 kr0Var, fc0 fc0Var) {
        Object obj;
        ju0 ju0VarQ = q(dg0Var, true, true, xt.A.c(kr0Var.f), x80.d(kr0Var));
        if (ju0VarQ == null) {
            ju0VarQ = dg0Var instanceof vr0$a ? u((vr0$a) dg0Var) : null;
        }
        if (ju0VarQ != null) {
            q80 q80Var = ju0VarQ.b.b;
            q80 q80Var2 = tn.e;
            xg0 xg0VarN = n(kr0Var, (jj0) dg0Var.a, (fi0) dg0Var.b, x3.c, q80Var.a(q80Var2.b, q80Var2.c, q80Var2.d));
            if (xg0VarN != null && (obj = ((f$a) ((ff0.c) this.b).invoke(ju0VarQ)).b.get(xg0VarN)) != null) {
                if (ac1.a(fc0Var)) {
                    obj = (qg) obj;
                    if (obj instanceof ga) {
                        return new fb1(((Number) ((ga) obj).a).byteValue());
                    }
                    if (obj instanceof a01) {
                        return new fb1(((Number) ((a01) obj).a).shortValue());
                    }
                    if (obj instanceof b30) {
                        return new fb1(((Number) ((b30) obj).a).intValue());
                    }
                    if (obj instanceof rf0) {
                        return new fb1(((Number) ((rf0) obj).a).longValue());
                    }
                }
                return obj;
            }
        }
        return null;
    }

    public List l(dg0 dg0Var, xg0 xg0Var, boolean z, boolean z2, Boolean bool, boolean z3) {
        List list;
        ju0 ju0VarQ = q(dg0Var, z, z2, bool, z3);
        if (ju0VarQ == null) {
            ju0VarQ = dg0Var instanceof vr0$a ? u((vr0$a) dg0Var) : null;
        }
        return (ju0VarQ == null || (list = (List) ((f$a) ((ff0.c) this.b).invoke(ju0VarQ)).a.get(xg0Var)) == null) ? uq.b : list;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        if (r5 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00be, code lost:
    
        if (r5 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c5, code lost:
    
        return (defpackage.ju0) r5.a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.ju0 q(defpackage.dg0 r5, boolean r6, boolean r7, java.lang.Boolean r8, boolean r9) {
        /*
            r4 = this;
            zq0$c r0 = zq0.c.d
            java.lang.Object r1 = r4.a
            ku0 r1 = (defpackage.ku0) r1
            r2 = 0
            if (r6 == 0) goto L7a
            if (r8 == 0) goto L5d
            boolean r6 = r5 instanceof defpackage.vr0$a
            if (r6 == 0) goto L23
            r6 = r5
            vr0$a r6 = (defpackage.vr0$a) r6
            zq0$c r3 = r6.g
            if (r3 != r0) goto L23
            java.lang.String r5 = "DefaultImpls"
            ij0 r5 = defpackage.ij0.f(r5)
            dd r6 = r6.f
            dd r5 = r6.d(r5)
            goto L56
        L23:
            boolean r6 = r8.booleanValue()
            if (r6 == 0) goto L7a
            boolean r6 = r5 instanceof defpackage.vr0$b
            if (r6 == 0) goto L7a
            java.lang.Object r6 = r5.c
            t11 r6 = (defpackage.t11) r6
            boolean r8 = r6 instanceof defpackage.s80
            if (r8 == 0) goto L38
            s80 r6 = (defpackage.s80) r6
            goto L39
        L38:
            r6 = r2
        L39:
            if (r6 != 0) goto L3d
            r6 = r2
            goto L3f
        L3d:
            m80 r6 = r6.c
        L3f:
            if (r6 == 0) goto L7a
            cv r5 = new cv
            java.lang.String r6 = r6.d()
            r7 = 47
            r8 = 46
            java.lang.String r6 = r6.replace(r7, r8)
            r5.<init>(r6)
            dd r5 = defpackage.dd.l(r5)
        L56:
            qz r5 = r1.c(r5)
            if (r5 != 0) goto Lc1
            goto Lc7
        L5d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "isConst should not be null for property (container="
            r6.<init>(r7)
            r6.append(r5)
            r5 = 41
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        L7a:
            if (r7 == 0) goto La4
            boolean r6 = r5 instanceof defpackage.vr0$a
            if (r6 == 0) goto La4
            r6 = r5
            vr0$a r6 = (defpackage.vr0$a) r6
            zq0$c r7 = r6.g
            zq0$c r8 = zq0.c.i
            if (r7 != r8) goto La4
            vr0$a r6 = r6.e
            if (r6 == 0) goto La4
            zq0$c r7 = zq0.c.c
            zq0$c r8 = r6.g
            if (r8 == r7) goto L9f
            zq0$c r7 = zq0.c.f
            if (r8 == r7) goto L9f
            if (r9 == 0) goto La4
            if (r8 == r0) goto L9f
            zq0$c r7 = zq0.c.g
            if (r8 != r7) goto La4
        L9f:
            ju0 r5 = u(r6)
            return r5
        La4:
            boolean r6 = r5 instanceof defpackage.vr0$b
            if (r6 == 0) goto Lc7
            java.lang.Object r5 = r5.c
            t11 r5 = (defpackage.t11) r5
            boolean r6 = r5 instanceof defpackage.s80
            if (r6 == 0) goto Lc7
            s80 r5 = (defpackage.s80) r5
            ju0 r6 = r5.d
            if (r6 != 0) goto Lc6
            dd r5 = r5.d()
            qz r5 = r1.c(r5)
            if (r5 != 0) goto Lc1
            goto Lc7
        Lc1:
            java.lang.Object r5 = r5.a
            ju0 r5 = (defpackage.ju0) r5
            return r5
        Lc6:
            return r6
        Lc7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v8.q(dg0, boolean, boolean, java.lang.Boolean, boolean):ju0");
    }

    public boolean r(dd ddVar) throws InvocationTargetException {
        if (ddVar.g() == null || !ddVar.j().b().equals("Container")) {
            return false;
        }
        qz qzVarC = ((ku0) this.a).c(ddVar);
        ju0 ju0Var = qzVarC == null ? null : (ju0) qzVarC.a;
        if (ju0Var == null) {
            return false;
        }
        LinkedHashSet linkedHashSet = e21.a;
        xs0 xs0Var = new xs0();
        e.C(ju0Var.a, new bj(12, xs0Var));
        return xs0Var.b;
    }

    public List t(dg0 dg0Var, kr0 kr0Var, int i) {
        fi0 fi0Var = (fi0) dg0Var.b;
        boolean zI = e.i(xt.A, kr0Var.f);
        boolean zD = x80.d(kr0Var);
        jj0 jj0Var = (jj0) dg0Var.a;
        if (i == 1) {
            xg0 xg0VarP = p(this, kr0Var, jj0Var, fi0Var, 40);
            if (xg0VarP != null) {
                return m(this, dg0Var, xg0VarP, Boolean.valueOf(zI), zD, 8);
            }
        } else {
            boolean z = true;
            xg0 xg0VarP2 = p(this, kr0Var, jj0Var, fi0Var, 48);
            if (xg0VarP2 != null) {
                boolean zE0 = q31.e0(xg0VarP2.a, "$delegate");
                if (i != 3) {
                    z = false;
                }
                if (zE0 == z) {
                    return l(dg0Var, xg0VarP2, true, true, Boolean.valueOf(zI), zD);
                }
            }
        }
        return uq.b;
    }
}
