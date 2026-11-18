package com.google.zxing.qrcode.decoder;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v1 com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, still in use, count: 1, list:
  (r1v1 com.google.zxing.qrcode.decoder.ErrorCorrectionLevel) from 0x002f: FILLED_NEW_ARRAY 
  (r1v1 com.google.zxing.qrcode.decoder.ErrorCorrectionLevel)
  (r0v0 com.google.zxing.qrcode.decoder.ErrorCorrectionLevel)
  (r5v1 com.google.zxing.qrcode.decoder.ErrorCorrectionLevel)
  (r4v1 com.google.zxing.qrcode.decoder.ErrorCorrectionLevel)
 A[WRAPPED] elemType: com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ErrorCorrectionLevel {
    L(1),
    /* JADX INFO: Fake field, exist only in values array */
    M(0),
    /* JADX INFO: Fake field, exist only in values array */
    Q(3),
    /* JADX INFO: Fake field, exist only in values array */
    H(2);

    public static final ErrorCorrectionLevel[] FOR_BITS;
    public final int bits;

    static {
        ErrorCorrectionLevel errorCorrectionLevel = L;
        FOR_BITS = new ErrorCorrectionLevel[]{errorCorrectionLevel, errorCorrectionLevel, errorCorrectionLevel, errorCorrectionLevel};
    }

    public ErrorCorrectionLevel(int i) {
        super(str, i);
        this.bits = i;
    }

    public static ErrorCorrectionLevel valueOf(String str) {
        return (ErrorCorrectionLevel) Enum.valueOf(ErrorCorrectionLevel.class, str);
    }

    public static ErrorCorrectionLevel[] values() {
        return (ErrorCorrectionLevel[]) $VALUES.clone();
    }
}
