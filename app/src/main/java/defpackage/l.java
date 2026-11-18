package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class l extends s0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(ff0 ff0Var) {
        super(ff0Var);
        if (ff0Var != null) {
        } else {
            o(0);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    public static /* synthetic */ void o(int i) {
        String str = (i == 1 || i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 3 || i == 4) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        } else if (i == 2) {
            objArr[0] = "classifier";
        } else if (i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 1) {
            objArr[1] = "getBuiltIns";
        } else if (i == 3 || i == 4) {
            objArr[1] = "getAdditionalNeighboursInSupertypeGraph";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        }
        if (i != 1) {
            if (i == 2) {
                objArr[2] = "isSameClassifier";
            } else if (i != 3 && i != 4) {
                objArr[2] = "<init>";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 3 && i != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [od, ok] */
    /* JADX WARN: Type inference failed for: r6v3, types: [ok] */
    /* JADX WARN: Type inference failed for: r6v4, types: [ok] */
    @Override // defpackage.s0
    public final boolean e(od odVar) {
        boolean z;
        if (odVar instanceof ai0) {
            ok okVarB = b();
            if (!e4.a(okVarB.getName(), odVar.getName())) {
                z = false;
                break;
            }
            while (true) {
                okVarB = okVarB.b();
                odVar = odVar.b();
                if (okVarB != null && odVar != 0) {
                    if (!(okVarB instanceof gi0)) {
                        if (!(odVar instanceof gi0)) {
                            if (okVarB instanceof wn0) {
                                if (!(odVar instanceof wn0) || !e4.a(((xn0) ((wn0) okVarB)).g, ((xn0) ((wn0) odVar)).g)) {
                                    break;
                                }
                            } else if (!(odVar instanceof wn0) && e4.a(okVarB.getName(), odVar.getName())) {
                            }
                        }
                        z = false;
                        break;
                    }
                    z = odVar instanceof gi0;
                    break;
                }
                z = true;
                break;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.s0
    public final fc0 h() {
        ai0 ai0VarB = b();
        if (ai0VarB == null) {
            ub0.a(107);
            throw null;
        }
        ij0 ij0Var = ub0.e;
        if (ub0.c(ai0VarB, m21.a.a) || ub0.c(ai0VarB, m21.a.b)) {
            return null;
        }
        return k().f();
    }

    @Override // defpackage.a91
    public final ub0 k() {
        ub0 ub0VarE = ym.e(b());
        if (ub0VarE != null) {
            return ub0VarE;
        }
        o(1);
        throw null;
    }

    @Override // defpackage.a91
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public abstract ai0 b();
}
