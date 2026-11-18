package defpackage;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class bi0 {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();

    public static final sw0 a(Class cls) {
        List list = bt0.a;
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        lf1 lf1Var = new lf1(classLoader);
        ConcurrentHashMap concurrentHashMap = a;
        WeakReference weakReference = (WeakReference) concurrentHashMap.get(lf1Var);
        if (weakReference != null) {
            sw0 sw0Var = (sw0) weakReference.get();
            if (sw0Var != null) {
                return sw0Var;
            }
            concurrentHashMap.remove(lf1Var, weakReference);
        }
        ku0 ku0Var = new ku0(classLoader);
        ku0 ku0Var2 = new ku0(tb1.class.getClassLoader());
        ku0 ku0Var3 = new ku0(classLoader);
        String strJ = e4.j("runtime module for ", classLoader);
        e eVar = e.f28c;
        ke keVar = ke.a$2;
        ff0 ff0Var = new ff0("RuntimeModuleData");
        w70 w70Var = new w70(ff0Var);
        ji0 ji0Var = new ji0(ij0.h("<" + strJ + '>'), ff0Var, w70Var, 56);
        px pxVar = new px(1, w70Var, ji0Var);
        s01 s01Var = ff0Var.a;
        s01Var.lock();
        try {
            pxVar.invoke();
            s01Var.unlock();
            w70Var.f = new hi0(ji0Var, 2);
            tn tnVar = new tn();
            qz qzVar = new qz(10, false);
            oo ooVar = new oo(ff0Var, ji0Var);
            e eVar2 = e.a$6;
            p60 p60Var = p60.d;
            l4 l4Var = new l4(ff0Var, p60Var);
            zm zmVar = zm.a$3;
            ke keVar2 = new ke(ff0Var);
            ke keVar3 = ke.a;
            ke keVar4 = ke.a$3;
            tu0 tu0Var = new tu0(ji0Var, ooVar);
            e eVar3 = e.a$7;
            m6 m6Var = new m6(l4Var, p60Var, new ke(11));
            e eVar4 = e.a$2;
            xk0.b.getClass();
            yk0 yk0Var = xk0.a.b;
            gd0 gd0Var = new gd0(new c60(ff0Var, ku0Var3, ku0Var, tnVar, k01.a, eVar, zmVar, keVar2, keVar, qzVar, eVar2, keVar3, keVar4, ji0Var, tu0Var, l4Var, m6Var, eVar4, eVar3, yk0Var, p60Var, new e(5)));
            g gVar = new g(ku0Var, tnVar, 26, false);
            v8 v8Var = new v8(ji0Var, ooVar, ff0Var, ku0Var);
            ub0 ub0Var = ji0Var.f;
            w70 w70Var2 = ub0Var instanceof w70 ? (w70) ub0Var : null;
            e eVar5 = e.f22a;
            f3 f3VarL = w70Var2 == null ? e.a$9 : w70Var2.L();
            yo0 yo0VarL = w70Var2 == null ? zm.a$2 : w70Var2.L();
            ps psVar = x80.a;
            new ke(ff0Var);
            fn fnVar = new fn(ff0Var, ji0Var, gVar, v8Var, gd0Var, eVar, eVar5, uq.b, ooVar, f3VarL, yo0VarL, psVar, yk0Var, 262144);
            tnVar.a = fnVar;
            qzVar.a = new bj(17, gd0Var);
            a80 a80VarL = w70Var.L();
            a80 a80VarL2 = w70Var.L();
            new ke(ff0Var);
            k80 k80Var = new k80(ff0Var, ku0Var2, ji0Var, ooVar, a80VarL, a80VarL2, yk0Var);
            ji0Var.j = new fi0(ae.M0(new ji0[]{ji0Var}));
            ji0Var.n = new xf(Arrays.asList(gd0Var, k80Var), e4.j("CompositeProvider@RuntimeModuleData for ", ji0Var));
            sw0 sw0Var2 = new sw0(fnVar, new m6(tnVar, ku0Var));
            while (true) {
                WeakReference weakReference2 = (WeakReference) concurrentHashMap.putIfAbsent(lf1Var, new WeakReference(sw0Var2));
                if (weakReference2 == null) {
                    return sw0Var2;
                }
                sw0 sw0Var3 = (sw0) weakReference2.get();
                if (sw0Var3 != null) {
                    return sw0Var3;
                }
                concurrentHashMap.remove(lf1Var, weakReference2);
            }
        } catch (Throwable th) {
            try {
                ff0Var.b.getClass();
                throw th;
            } catch (Throwable th2) {
                s01Var.unlock();
                throw th2;
            }
        }
    }
}
