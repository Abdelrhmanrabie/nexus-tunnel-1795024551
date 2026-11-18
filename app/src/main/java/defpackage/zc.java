package defpackage;

import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class zc extends k {
    public final ok g;
    public final t11 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zc(ff0 ff0Var, ok okVar, ij0 ij0Var, t11 t11Var) {
        super(ff0Var, ij0Var);
        if (ff0Var == null) {
            i0(0);
            throw null;
        }
        if (okVar == null) {
            i0(1);
            throw null;
        }
        if (ij0Var == null) {
            i0(2);
            throw null;
        }
        this.g = okVar;
        this.i = t11Var;
    }

    public static /* synthetic */ void i0(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i == 2) {
            objArr[0] = XMLRPC.TAG_NAME;
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 4 && i != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // defpackage.ok
    public final ok b() {
        ok okVar = this.g;
        if (okVar != null) {
            return okVar;
        }
        i0(4);
        throw null;
    }

    public boolean b0() {
        return false;
    }

    @Override // defpackage.qk
    public final t11 g() {
        t11 t11Var = this.i;
        if (t11Var != null) {
            return t11Var;
        }
        i0(5);
        throw null;
    }
}
