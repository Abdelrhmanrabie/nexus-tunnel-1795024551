package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import defpackage.jq;
import defpackage.ph0;
import defpackage.qh0;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public final qh0 a;
    public final char[] b;
    public final a c = new a(1024);
    public final Typeface d;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a {
        public final SparseArray a;
        public jq b;

        public a() {
            this(1);
        }

        public a(int i) {
            this.a = new SparseArray(i);
        }

        public final void a(jq jqVar, int i, int i2) {
            int iA = jqVar.a(i);
            SparseArray sparseArray = this.a;
            a aVar = sparseArray == null ? null : (a) sparseArray.get(iA);
            if (aVar == null) {
                aVar = new a();
                sparseArray.put(jqVar.a(i), aVar);
            }
            if (i2 > i) {
                aVar.a(jqVar, i + 1, i2);
            } else {
                aVar.b = jqVar;
            }
        }
    }

    public g(Typeface typeface, qh0 qh0Var) {
        int i;
        int i2;
        this.d = typeface;
        this.a = qh0Var;
        int iA = qh0Var.a(6);
        if (iA != 0) {
            int i3 = iA + qh0Var.a;
            i = ((ByteBuffer) qh0Var.b).getInt(((ByteBuffer) qh0Var.b).getInt(i3) + i3);
        } else {
            i = 0;
        }
        this.b = new char[i * 2];
        int iA2 = qh0Var.a(6);
        if (iA2 != 0) {
            int i4 = iA2 + qh0Var.a;
            i2 = ((ByteBuffer) qh0Var.b).getInt(((ByteBuffer) qh0Var.b).getInt(i4) + i4);
        } else {
            i2 = 0;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            jq jqVar = new jq(this, i5);
            ph0 ph0VarC = jqVar.c();
            int iA3 = ph0VarC.a(4);
            Character.toChars(iA3 != 0 ? ((ByteBuffer) ph0VarC.b).getInt(iA3 + ph0VarC.a) : 0, this.b, i5 * 2);
            if (jqVar.b() <= 0) {
                defpackage.d.AnonymousClass0.m$2("invalid metadata codepoint length");
                throw null;
            }
            this.c.a(jqVar, 0, jqVar.b() - 1);
        }
    }
}
