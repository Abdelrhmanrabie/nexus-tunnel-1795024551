package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class q9 {
    public static final q9 m = new q9();
    public final ps a;
    public final yx.e b;
    public final yx.e c;
    public final yx.e d;
    public final yx.e e;
    public final yx.e f;
    public final yx.e g;
    public final yx.e h;
    public final yx.e i;
    public final yx.e j;
    public final yx.e k;
    public final yx.e l;

    public q9() {
        ps psVar = new ps();
        psVar.a(w9.a);
        yx.e eVar = w9.b;
        psVar.a(eVar);
        yx.e eVar2 = w9.c;
        psVar.a(eVar2);
        yx.e eVar3 = w9.d;
        psVar.a(eVar3);
        yx.e eVar4 = w9.e;
        psVar.a(eVar4);
        yx.e eVar5 = w9.f;
        psVar.a(eVar5);
        yx.e eVar6 = w9.g;
        psVar.a(eVar6);
        yx.e eVar7 = w9.h;
        psVar.a(eVar7);
        yx.e eVar8 = w9.i;
        psVar.a(eVar8);
        yx.e eVar9 = w9.j;
        psVar.a(eVar9);
        yx.e eVar10 = w9.k;
        psVar.a(eVar10);
        yx.e eVar11 = w9.l;
        psVar.a(eVar11);
        this.a = psVar;
        this.b = eVar2;
        this.c = eVar;
        this.d = eVar3;
        this.e = eVar4;
        this.f = eVar5;
        this.g = eVar6;
        this.h = eVar8;
        this.i = eVar7;
        this.j = eVar9;
        this.k = eVar10;
        this.l = eVar11;
    }

    public static String a(cv cvVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(cvVar.b().replace('.', '/'));
        sb.append('/');
        sb.append(e4.j(cvVar.d() ? "default-package" : cvVar.a.g().b(), ".kotlin_builtins"));
        return sb.toString();
    }
}
