package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class jd extends l {
    public final ai0 c;
    public final List d;
    public final Collection e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jd(ai0 ai0Var, List list, Collection collection, ff0 ff0Var) {
        super(ff0Var);
        if (list == null) {
            o(1);
            throw null;
        }
        if (collection == null) {
            o(2);
            throw null;
        }
        if (ff0Var == null) {
            o(3);
            throw null;
        }
        this.c = ai0Var;
        this.d = Collections.unmodifiableList(new ArrayList(list));
        this.e = Collections.unmodifiableCollection(collection);
    }

    public static /* synthetic */ void o(int i) {
        String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i == 4) {
            objArr[1] = "getParameters";
        } else if (i == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // defpackage.a91
    public final boolean c() {
        return true;
    }

    @Override // defpackage.s0
    public final Collection g() {
        Collection collection = this.e;
        if (collection != null) {
            return collection;
        }
        o(6);
        throw null;
    }

    @Override // defpackage.a91
    public final List getParameters() {
        List list = this.d;
        if (list != null) {
            return list;
        }
        o(4);
        throw null;
    }

    @Override // defpackage.s0
    public final ke j() {
        return ke.a;
    }

    @Override // defpackage.l
    /* JADX INFO: renamed from: p */
    public final ai0 b() {
        ai0 ai0Var = this.c;
        if (ai0Var != null) {
            return ai0Var;
        }
        o(5);
        throw null;
    }

    public final String toString() {
        String str = xm.g(this.c).a;
        if (str != null) {
            return str;
        }
        dv.a(4);
        throw null;
    }
}
