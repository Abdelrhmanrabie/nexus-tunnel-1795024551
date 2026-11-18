package defpackage;

import java.util.HashMap;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ns0 implements xb0$c {
    public static final boolean i = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
    public static final HashMap j;
    public int[] a;
    public String b;
    public int c;
    public String[] d;
    public String[] e;
    public String[] f;
    public wb0.a g;
    public String[] h;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b implements xb0$a {
        public final /* synthetic */ int G0;
        public final /* synthetic */ ns0 a;

        public /* synthetic */ b(ns0 ns0Var, int i) {
            this.G0 = i;
            this.a = ns0Var;
        }

        private final void a$ns0$b() {
        }

        private final void a$ns0$c() {
        }

        private final void b$ns0$b(ij0 ij0Var, ed edVar) {
        }

        private final void b$ns0$c(ij0 ij0Var, ed edVar) {
        }

        private final void d$ns0$b(ij0 ij0Var, dd ddVar, ij0 ij0Var2) {
        }

        private final void d$ns0$c(ij0 ij0Var, dd ddVar, ij0 ij0Var2) {
        }

        @Override // defpackage.xb0$a
        /* JADX INFO: renamed from: a */
        public final void mo57a() {
        }

        @Override // defpackage.xb0$a
        public final void b(ij0 ij0Var, ed edVar) {
        }

        @Override // defpackage.xb0$a
        public final xb0$b c(ij0 ij0Var) {
            int i = this.G0;
            String strB = ij0Var.b();
            if (i != 0) {
                if (XMLRPC.TAG_DATA.equals(strB) || "filePartClassNames".equals(strB)) {
                    return new rs0(this, 0);
                }
                if ("strings".equals(strB)) {
                    return new rs0(this, 1);
                }
                return null;
            }
            if ("d1".equals(strB)) {
                return new os0(this, 0);
            }
            if ("d2".equals(strB)) {
                return new os0(this, 1);
            }
            if ("si".equals(strB)) {
                return new os0(this, 2);
            }
            return null;
        }

        @Override // defpackage.xb0$a
        public final void d(ij0 ij0Var, dd ddVar, ij0 ij0Var2) {
        }

        @Override // defpackage.xb0$a
        public final xb0$a e(dd ddVar, ij0 ij0Var) {
            return null;
        }

        @Override // defpackage.xb0$a
        public final void f(Object obj, ij0 ij0Var) {
            int i = this.G0;
            String strB = ij0Var.b();
            if (i != 0) {
                boolean zEquals = "version".equals(strB);
                ns0 ns0Var = this.a;
                if (zEquals) {
                    if (obj instanceof int[]) {
                        ns0Var.a = (int[]) obj;
                        return;
                    }
                    return;
                } else {
                    if ("multifileClassName".equals(strB)) {
                        ns0Var.b = obj instanceof String ? (String) obj : null;
                        return;
                    }
                    return;
                }
            }
            boolean zEquals2 = "k".equals(strB);
            ns0 ns0Var2 = this.a;
            if (zEquals2) {
                if (obj instanceof Integer) {
                    wb0.a aVar = (wb0.a) wb0.a.c.get((Integer) obj);
                    if (aVar == null) {
                        aVar = wb0.a.UNKNOWN;
                    }
                    ns0Var2.g = aVar;
                    return;
                }
                return;
            }
            if ("mv".equals(strB)) {
                if (obj instanceof int[]) {
                    ns0Var2.a = (int[]) obj;
                }
            } else if ("xs".equals(strB)) {
                if (obj instanceof String) {
                    ns0Var2.b = (String) obj;
                }
            } else if (!"xi".equals(strB)) {
                "pn".equals(strB);
            } else if (obj instanceof Integer) {
                ns0Var2.c = ((Integer) obj).intValue();
            }
        }
    }

    static {
        HashMap map = new HashMap();
        j = map;
        map.put(dd.l(new cv("kotlin.jvm.internal.KotlinClass")), wb0.a.CLASS);
        map.put(dd.l(new cv("kotlin.jvm.internal.KotlinFileFacade")), wb0.a.FILE_FACADE);
        map.put(dd.l(new cv("kotlin.jvm.internal.KotlinMultifileClass")), wb0.a.MULTIFILE_CLASS);
        map.put(dd.l(new cv("kotlin.jvm.internal.KotlinMultifileClassPart")), wb0.a.MULTIFILE_CLASS_PART);
        map.put(dd.l(new cv("kotlin.jvm.internal.KotlinSyntheticClass")), wb0.a.SYNTHETIC_CLASS);
    }

    @Override // defpackage.xb0$c
    /* JADX INFO: renamed from: a */
    public final void mo4a() {
    }

    @Override // defpackage.xb0$c
    public final xb0$a b(dd ddVar, at0 at0Var) {
        wb0.a aVar;
        if (ddVar.b().equals(r70.a)) {
            return new b(this, 0);
        }
        if (i || this.g != null || (aVar = (wb0.a) j.get(ddVar)) == null) {
            return null;
        }
        this.g = aVar;
        return new b(this, 1);
    }
}
