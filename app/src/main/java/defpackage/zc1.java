package defpackage;

import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class zc1 extends yc1 {
    public final boolean i;
    public ff0.f j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zc1(ok okVar, s4 s4Var, ij0 ij0Var, boolean z, t11 t11Var) {
        super(okVar, s4Var, ij0Var, null, t11Var);
        if (okVar == null) {
            z(0);
            throw null;
        }
        if (ij0Var == null) {
            z(2);
            throw null;
        }
        this.i = z;
    }

    public static /* synthetic */ void z(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "annotations";
        } else if (i == 2) {
            objArr[0] = XMLRPC.TAG_NAME;
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i != 4) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "compileTimeInitializer";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i != 4) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // defpackage.yc1
    public final boolean P() {
        return this.i;
    }

    @Override // defpackage.yc1
    public final qg q0() {
        ff0.f fVar = this.j;
        if (fVar != null) {
            return (qg) fVar.invoke();
        }
        return null;
    }
}
