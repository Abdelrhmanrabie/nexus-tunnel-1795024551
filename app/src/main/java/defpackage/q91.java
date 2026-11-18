package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q91 extends ux implements bx {
    public final /* synthetic */ int G0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q91(int i, Object obj, int i2) {
        super(i, obj);
        this.G0 = i2;
    }

    @Override // kotlin.jvm.internal.a, defpackage.a90
    public final String getName() {
        return this.G0 != 0 ? "equalTypes" : "isStrictSupertype";
    }

    @Override // kotlin.jvm.internal.a
    public final o90 getOwner() {
        return ou0.a.b(this.G0 != 0 ? yk0.class : o91.class);
    }

    @Override // kotlin.jvm.internal.a
    public final String getSignature() {
        return this.G0 != 0 ? "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z" : "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }

    @Override // defpackage.bx
    public final Object invoke(Object obj, Object obj2) {
        int i = this.G0;
        fc0 fc0Var = (fc0) obj;
        fc0 fc0Var2 = (fc0) obj2;
        Object obj3 = this.receiver;
        if (i != 0) {
            return Boolean.valueOf(((yk0) obj3).c(fc0Var, fc0Var2));
        }
        ((o91) obj3).getClass();
        xk0.b.getClass();
        yk0 yk0Var = xk0.a.b;
        return Boolean.valueOf(yk0Var.e(fc0Var, fc0Var2) && !yk0Var.e(fc0Var2, fc0Var));
    }
}
