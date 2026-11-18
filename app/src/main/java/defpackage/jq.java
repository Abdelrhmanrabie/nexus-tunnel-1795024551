package defpackage;

import androidx.emoji2.text.g;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class jq {
    public static final ThreadLocal d = new ThreadLocal();
    public final int a;
    public final g b;
    public volatile int c = 0;

    public jq(g gVar, int i) {
        this.b = gVar;
        this.a = i;
    }

    public final int a(int i) {
        ph0 ph0VarC = c();
        int iA = ph0VarC.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) ph0VarC.b;
        int i2 = iA + ph0VarC.a;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i2) + i2 + 4);
    }

    public final int b() {
        ph0 ph0VarC = c();
        int iA = ph0VarC.a(16);
        if (iA == 0) {
            return 0;
        }
        int i = iA + ph0VarC.a;
        return ((ByteBuffer) ph0VarC.b).getInt(((ByteBuffer) ph0VarC.b).getInt(i) + i);
    }

    public final ph0 c() {
        short s;
        ThreadLocal threadLocal = d;
        ph0 ph0Var = (ph0) threadLocal.get();
        if (ph0Var == null) {
            ph0Var = new ph0();
            threadLocal.set(ph0Var);
        }
        qh0 qh0Var = this.b.a;
        int iA = qh0Var.a(6);
        if (iA != 0) {
            int i = iA + qh0Var.a;
            int i2 = (this.a * 4) + ((ByteBuffer) qh0Var.b).getInt(i) + i + 4;
            int i3 = ((ByteBuffer) qh0Var.b).getInt(i2) + i2;
            ByteBuffer byteBuffer = (ByteBuffer) qh0Var.b;
            ph0Var.b = byteBuffer;
            if (byteBuffer != null) {
                ph0Var.a = i3;
                int i4 = i3 - byteBuffer.getInt(i3);
                ph0Var.c = i4;
                s = ((ByteBuffer) ph0Var.b).getShort(i4);
            } else {
                s = 0;
                ph0Var.a = 0;
                ph0Var.c = 0;
            }
            ph0Var.d = s;
        }
        return ph0Var;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        ph0 ph0VarC = c();
        int iA = ph0VarC.a(4);
        sb.append(Integer.toHexString(iA != 0 ? ((ByteBuffer) ph0VarC.b).getInt(iA + ph0VarC.a) : 0));
        sb.append(", codepoints:");
        int iB = b();
        for (int i = 0; i < iB; i++) {
            sb.append(Integer.toHexString(a(i)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
