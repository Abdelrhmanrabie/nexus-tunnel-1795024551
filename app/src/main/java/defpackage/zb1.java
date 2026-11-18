package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public enum zb1 {
    /* JADX INFO: Fake field, exist only in values array */
    UBYTE(dd.f("kotlin/UByte", false)),
    /* JADX INFO: Fake field, exist only in values array */
    USHORT(dd.f("kotlin/UShort", false)),
    /* JADX INFO: Fake field, exist only in values array */
    UINT(dd.f("kotlin/UInt", false)),
    /* JADX INFO: Fake field, exist only in values array */
    ULONG(dd.f("kotlin/ULong", false));

    public final dd b;
    public final ij0 c;
    public final dd d;

    zb1(dd ddVar) {
        this.b = ddVar;
        ij0 ij0VarJ = ddVar.j();
        this.c = ij0VarJ;
        this.d = new dd(ddVar.h(), ij0.f(e4.j(ij0VarJ.b(), "Array")));
    }
}
