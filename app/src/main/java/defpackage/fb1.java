package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class fb1 extends bc1 {
    public final /* synthetic */ int G0 = 0;

    public fb1(byte b) {
        super(Byte.valueOf(b));
    }

    public fb1(int i) {
        super(Integer.valueOf(i));
    }

    public fb1(long j) {
        super(Long.valueOf(j));
    }

    public fb1(short s) {
        super(Short.valueOf(s));
    }

    @Override // defpackage.qg
    public final fc0 a(gi0 gi0Var) {
        String str;
        int i = this.G0;
        if (i == 0) {
            ai0 ai0VarA = e4.a(gi0Var, m21.a.Q);
            if (ai0VarA != null) {
                return ai0VarA.n();
            }
            str = "Unsigned type UByte not found";
        } else if (i == 1) {
            ai0 ai0VarA2 = e4.a(gi0Var, m21.a.S);
            if (ai0VarA2 != null) {
                return ai0VarA2.n();
            }
            str = "Unsigned type UInt not found";
        } else if (i != 2) {
            ai0 ai0VarA3 = e4.a(gi0Var, m21.a.R);
            if (ai0VarA3 != null) {
                return ai0VarA3.n();
            }
            str = "Unsigned type UShort not found";
        } else {
            ai0 ai0VarA4 = e4.a(gi0Var, m21.a.T);
            if (ai0VarA4 != null) {
                return ai0VarA4.n();
            }
            str = "Unsigned type ULong not found";
        }
        return pr.d(str);
    }

    @Override // defpackage.qg
    public final String toString() {
        StringBuilder sb;
        String str;
        int i = this.G0;
        if (i == 0) {
            sb = new StringBuilder();
            sb.append(((Number) this.a).intValue());
            str = ".toUByte()";
        } else if (i == 1) {
            sb = new StringBuilder();
            sb.append(((Number) this.a).intValue());
            str = ".toUInt()";
        } else if (i != 2) {
            sb = new StringBuilder();
            sb.append(((Number) this.a).intValue());
            str = ".toUShort()";
        } else {
            sb = new StringBuilder();
            sb.append(((Number) this.a).longValue());
            str = ".toULong()";
        }
        sb.append(str);
        return sb.toString();
    }
}
