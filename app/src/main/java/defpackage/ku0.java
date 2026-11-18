package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ku0 {
    public final ClassLoader a;

    public qt0 c(y40$a y40_a) {
        Class<?> cls;
        dd ddVar = y40_a.a;
        cv cvVarH = ddVar.h();
        String strReplace = ddVar.i().b().replace('.', '$');
        if (!cvVarH.d()) {
            strReplace = cvVarH.b() + '.' + strReplace;
        }
        try {
            cls = Class.forName(strReplace, false, this.a);
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null) {
            return new qt0(cls);
        }
        return null;
    }

    public qz c(dd ddVar) {
        Class<?> cls;
        ju0 ju0VarA;
        String strReplace = ddVar.i().b().replace('.', '$');
        if (!ddVar.h().d()) {
            strReplace = ddVar.h() + '.' + strReplace;
        }
        try {
            cls = Class.forName(strReplace, false, this.a);
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null || (ju0VarA = e4.a(cls)) == null) {
            return null;
        }
        return new qz(9, ju0VarA);
    }
}
