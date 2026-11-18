package defpackage;

import net.openvpn.ovpn3.XMLRPC;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class y extends y0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(ff0 ff0Var, ok okVar, s4 s4Var, ij0 ij0Var, ad1 ad1Var, boolean z, int i, ke keVar) {
        super(ff0Var, okVar, s4Var, ij0Var, ad1Var, z, i, keVar);
        if (ff0Var == null) {
            z(0);
            throw null;
        }
        if (okVar == null) {
            z(1);
            throw null;
        }
        if (keVar != null) {
        } else {
            z(6);
            throw null;
        }
    }

    public static /* synthetic */ void z(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // defpackage.pk
    public final String toString() {
        boolean z = this.i;
        String str = AppConfig.CUSTOM;
        String str2 = z ? "reified " : AppConfig.CUSTOM;
        if (j() != ad1.INVARIANT) {
            str = j() + " ";
        }
        return str2 + str + getName();
    }
}
