package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class da1 extends ca1 {
    public final /* synthetic */ int G0;
    public final Object a;
    public final Object b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public da1(fc0 fc0Var) {
        this(fc0Var, ad1.INVARIANT);
        this.G0 = 0;
        if (fc0Var != null) {
        } else {
            d(2);
            throw null;
        }
    }

    public da1(fc0 fc0Var, ad1 ad1Var) {
        this.G0 = 0;
        if (ad1Var == null) {
            d(0);
            throw null;
        }
        if (fc0Var == null) {
            d(1);
            throw null;
        }
        this.a = ad1Var;
        this.b = fc0Var;
    }

    public da1(v91 v91Var) {
        this.G0 = 1;
        this.a = v91Var;
        this.b = e.V(be0.b, new ca0(11, this));
    }

    public static /* synthetic */ void d(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i == 3) {
            objArr[2] = "replaceType";
        } else if (i != 4 && i != 5) {
            if (i != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // defpackage.ca1
    public final ca1 a(lc0$a lc0_a) {
        if (this.G0 != 0) {
            return this;
        }
        if (lc0_a != null) {
            return new da1((fc0) this.b, (ad1) this.a);
        }
        d(6);
        throw null;
    }

    @Override // defpackage.ca1
    public final boolean b() {
        return this.G0 != 0;
    }

    @Override // defpackage.ca1
    public final ad1 c() {
        if (this.G0 != 0) {
            return ad1.OUT_VARIANCE;
        }
        ad1 ad1Var = (ad1) this.a;
        if (ad1Var != null) {
            return ad1Var;
        }
        d(4);
        throw null;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, rc0] */
    @Override // defpackage.ca1
    public final fc0 getType() {
        int i = this.G0;
        ?? r1 = this.b;
        if (i != 0) {
            return (fc0) r1.getValue();
        }
        fc0 fc0Var = (fc0) r1;
        if (fc0Var != null) {
            return fc0Var;
        }
        d(5);
        throw null;
    }
}
