package defpackage;

import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class pk extends j0 implements ok {
    public final ij0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pk(s4 s4Var, ij0 ij0Var) {
        super(s4Var);
        if (s4Var == null) {
            z(0);
            throw null;
        }
        if (ij0Var == null) {
            z(1);
            throw null;
        }
        this.c = ij0Var;
    }

    public static String W(ok okVar) {
        try {
            return mm.b.E(okVar) + "[" + okVar.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(okVar)) + "]";
        } catch (Throwable unused) {
            return okVar.getClass().getSimpleName() + " " + okVar.getName();
        }
    }

    public static /* synthetic */ void z(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 5 || i == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (i != 2 && i != 3) {
            if (i == 4) {
                objArr[2] = "toString";
            } else if (i != 5 && i != 6) {
                objArr[2] = "<init>";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public ok a() {
        return this;
    }

    @Override // defpackage.ok
    public final ij0 getName() {
        ij0 ij0Var = this.c;
        if (ij0Var != null) {
            return ij0Var;
        }
        z(2);
        throw null;
    }

    public String toString() {
        return W(this);
    }
}
