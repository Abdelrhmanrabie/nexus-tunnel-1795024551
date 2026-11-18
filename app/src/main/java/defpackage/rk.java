package defpackage;

import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class rk extends pk implements qk {
    public final ok d;
    public final t11 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rk(ok okVar, s4 s4Var, ij0 ij0Var, t11 t11Var) {
        super(s4Var, ij0Var);
        if (okVar == null) {
            z(0);
            throw null;
        }
        if (s4Var == null) {
            z(1);
            throw null;
        }
        if (ij0Var == null) {
            z(2);
            throw null;
        }
        if (t11Var == null) {
            z(3);
            throw null;
        }
        this.d = okVar;
        this.f = t11Var;
    }

    public static /* synthetic */ void z(int i) {
        String str = (i == 4 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 4) {
            objArr[1] = "getOriginal";
        } else if (i == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 4 && i != 5 && i != 6) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public ok b() {
        ok okVar = this.d;
        if (okVar != null) {
            return okVar;
        }
        z(5);
        throw null;
    }

    public t11 g() {
        t11 t11Var = this.f;
        if (t11Var != null) {
            return t11Var;
        }
        z(6);
        throw null;
    }

    @Override // defpackage.pk, defpackage.ok, defpackage.od
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public qk a() {
        return this;
    }
}
