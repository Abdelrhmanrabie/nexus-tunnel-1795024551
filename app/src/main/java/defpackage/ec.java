package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ec extends bc1 {
    @Override // defpackage.qg
    public final fc0 a(gi0 gi0Var) {
        ub0 ub0VarK = gi0Var.k();
        ub0VarK.getClass();
        return ub0VarK.t(wp0.CHAR);
    }

    @Override // defpackage.qg
    public final String toString() {
        String strValueOf;
        Character ch = (Character) this.a;
        Integer numValueOf = Integer.valueOf(ch.charValue());
        char cCharValue = ch.charValue();
        if (cCharValue == '\b') {
            strValueOf = "\\b";
        } else if (cCharValue == '\t') {
            strValueOf = "\\t";
        } else if (cCharValue == '\n') {
            strValueOf = "\\n";
        } else if (cCharValue == '\f') {
            strValueOf = "\\f";
        } else if (cCharValue == '\r') {
            strValueOf = "\\r";
        } else {
            byte type = (byte) Character.getType(cCharValue);
            strValueOf = (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? "?" : String.valueOf(cCharValue);
        }
        return String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{numValueOf, strValueOf}, 2));
    }
}
