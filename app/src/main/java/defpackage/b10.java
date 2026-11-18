package defpackage;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class b10 {
    public static final b10 c = new b10(a30.b, 0);
    public final a30 a;
    public final int b;

    public b10(a30 a30Var, int i) {
        this.a = a30Var;
        this.b = i;
    }

    public final b10 a(String str, Object obj) {
        int iHashCode = str.hashCode();
        a30 a30Var = this.a;
        z20 z20Var = a30Var.a;
        pg pgVarB = (pg) z20Var.a(iHashCode);
        if (pgVarB == null) {
            pgVarB = pg.f;
        }
        int i = pgVarB.d;
        int i2 = 0;
        pg pgVar = pgVarB;
        while (true) {
            if (pgVar == null || pgVar.d <= 0) {
                i2 = -1;
                break;
            }
            if (((eg0) pgVar.b).b.equals(str)) {
                break;
            }
            i2++;
            pgVar = pgVar.c;
        }
        if (i2 != -1) {
            if (i2 < 0 || i2 > i) {
                throw new IndexOutOfBoundsException();
            }
            try {
                pgVarB = pgVarB.b(pgVarB.d(i2).b);
            } catch (NoSuchElementException unused) {
                throw new IndexOutOfBoundsException(ak.h(i2, "Index: "));
            }
        }
        eg0 eg0Var = new eg0(str, obj);
        pgVarB.getClass();
        pg pgVar2 = new pg(eg0Var, pgVarB);
        z20 z20VarB = z20Var.b(str.hashCode(), pgVar2);
        if (z20VarB != z20Var) {
            a30Var = new a30(z20VarB);
        }
        return new b10(a30Var, (this.b - i) + pgVar2.d);
    }
}
