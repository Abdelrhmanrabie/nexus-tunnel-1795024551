package defpackage;

import java.util.regex.Pattern;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class v80$c extends uh {
    public final ao a;
    public final kr0 b;
    public final w80.c c;
    public final jj0 d;
    public final fi0 e;
    public final String f;

    public v80$c(ao aoVar, kr0 kr0Var, w80.c cVar, jj0 jj0Var, fi0 fi0Var) {
        String strJ;
        String string;
        String strB;
        this.a = aoVar;
        this.b = kr0Var;
        this.c = cVar;
        this.d = jj0Var;
        this.e = fi0Var;
        if ((cVar.c & 4) == 4) {
            string = e4.j(jj0Var.getString(cVar.g.d), jj0Var.getString(cVar.g.f));
        } else {
            p80$a p80_aB = x80.b(kr0Var, jj0Var, fi0Var, true);
            if (p80_aB == null) {
                throw new yi(e4.j("No field signature for property: ", aoVar));
            }
            StringBuilder sb = new StringBuilder();
            sb.append(q70.a(p80_aB.a));
            ok okVarB = aoVar.b();
            if (aoVar.getVisibility().equals(cn.d) && (okVarB instanceof on)) {
                Integer num = (Integer) e.z(((on) okVarB).g, w80.i);
                strB = ((Pattern) lj0.a.b).matcher(num == null ? "main" : jj0Var.getString(num.intValue())).replaceAll("_");
            } else {
                if (aoVar.getVisibility().equals(cn.a) && (okVarB instanceof wn0)) {
                    rn rnVar = aoVar.J;
                    if (rnVar instanceof s80) {
                        s80 s80Var = (s80) rnVar;
                        strB = s80Var.c != null ? ij0.f(q31.y0(s80Var.b.d(), '/')).b() : strB;
                        sb.append(strJ);
                        sb.append("()");
                        sb.append(p80_aB.b);
                        string = sb.toString();
                    }
                }
                strJ = AppConfig.CUSTOM;
                sb.append(strJ);
                sb.append("()");
                sb.append(p80_aB.b);
                string = sb.toString();
            }
            strJ = e4.j("$", strB);
            sb.append(strJ);
            sb.append("()");
            sb.append(p80_aB.b);
            string = sb.toString();
        }
        this.f = string;
    }

    @Override // defpackage.uh
    public final String a() {
        return this.f;
    }
}
