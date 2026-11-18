package defpackage;

import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class s80 implements rn {
    public final m80 b;
    public final m80 c;
    public final ju0 d;

    public s80(ju0 ju0Var, ir0 ir0Var, r80 r80Var, int i) {
        ak.r(i, "abiStability");
        m80 m80VarB = m80.b(bt0.a(ju0Var.a));
        wb0 wb0Var = ju0Var.b;
        m80 m80VarC = null;
        String str = wb0Var.a == wb0.a.MULTIFILE_CLASS_PART ? wb0Var.f : null;
        if (str != null && str.length() > 0) {
            m80VarC = m80.c(str);
        }
        this.b = m80VarB;
        this.c = m80VarC;
        this.d = ju0Var;
        Integer num = (Integer) e.z(ir0Var, w80.m);
        if (num == null) {
            return;
        }
        r80Var.getString(num.intValue());
    }

    @Override // defpackage.rn
    public final String a() {
        return "Class '" + d().b().b() + '\'';
    }

    public final dd d() {
        cv cvVar;
        m80 m80Var = this.b;
        String str = m80Var.a;
        int iLastIndexOf = str.lastIndexOf(InternalZipConstants.ZIP_FILE_SEPARATOR);
        if (iLastIndexOf == -1) {
            cvVar = cv.c;
            if (cvVar == null) {
                m80.a(7);
                throw null;
            }
        } else {
            cvVar = new cv(str.substring(0, iLastIndexOf).replace('/', '.'));
        }
        return new dd(cvVar, ij0.f(q31.y0(m80Var.d(), '/')));
    }

    public final String toString() {
        return "s80: " + this.b;
    }
}
