package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class rs0 extends j0 {
    public final /* synthetic */ int G0;
    public final /* synthetic */ ns0.b b;

    public /* synthetic */ rs0(ns0.b bVar, int i) {
        this.G0 = i;
        this.b = bVar;
    }

    @Override // defpackage.j0
    public final void f(String[] strArr) {
        if (this.G0 != 0) {
            if (strArr != null) {
                this.b.a.e = strArr;
                return;
            } else {
                d.AnonymousClass0.m$4("Argument for @NotNull parameter 'data' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2.visitEnd must not be null");
                return;
            }
        }
        if (strArr != null) {
            this.b.a.d = strArr;
        } else {
            d.AnonymousClass0.m$4("Argument for @NotNull parameter 'data' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1.visitEnd must not be null");
        }
    }
}
