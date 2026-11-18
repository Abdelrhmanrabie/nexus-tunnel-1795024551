package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class os0 extends j0 {
    public final /* synthetic */ int G0;
    public final /* synthetic */ ns0.b b;

    public /* synthetic */ os0(ns0.b bVar, int i) {
        this.G0 = i;
        this.b = bVar;
    }

    @Override // defpackage.j0
    public final void f(String[] strArr) {
        int i = this.G0;
        if (i == 0) {
            if (strArr != null) {
                this.b.a.d = strArr;
                return;
            } else {
                d.AnonymousClass0.m$4("Argument for @NotNull parameter 'result' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1.visitEnd must not be null");
                return;
            }
        }
        if (i != 1) {
            if (strArr != null) {
                this.b.a.h = strArr;
                return;
            } else {
                d.AnonymousClass0.m$4("Argument for @NotNull parameter 'result' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$3.visitEnd must not be null");
                return;
            }
        }
        if (strArr != null) {
            this.b.a.e = strArr;
        } else {
            d.AnonymousClass0.m$4("Argument for @NotNull parameter 'result' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2.visitEnd must not be null");
        }
    }
}
