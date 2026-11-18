package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ha1 {
    public static final ha1 b = new ha1(ea1.a);
    public final ea1 a;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends Exception {
    }

    public ha1(ea1 ea1Var) {
        this.a = ea1Var;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0021 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:56:0x00b8  */
    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (i != 1 && i != 2 && i != 8 && i != 34 && i != 37) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            str = "@NotNull method %s.%s must not return null";
                            break;
                    }
                case 11:
                case 12:
                case 13:
                    str = "@NotNull method %s.%s must not return null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 1 && i != 2 && i != 8 && i != 34 && i != 37) {
            switch (i) {
                case 11:
                case 12:
                case 13:
                    i2 = 2;
                    break;
                default:
                    switch (i) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            i2 = 2;
                            break;
                        default:
                            switch (i) {
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    i2 = 2;
                                    break;
                                default:
                                    switch (i) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            i2 = 2;
                                            break;
                                        default:
                                            i2 = 3;
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                break;
            case 3:
                objArr[0] = "first";
                break;
            case 4:
                objArr[0] = "second";
                break;
            case 5:
                objArr[0] = "substitutionContext";
                break;
            case 6:
                objArr[0] = "context";
                break;
            case 7:
            default:
                objArr[0] = "substitution";
                break;
            case 9:
            case 14:
                objArr[0] = "type";
                break;
            case 10:
            case 15:
                objArr[0] = "howThisTypeIsUsed";
                break;
            case 16:
            case 17:
            case 36:
                objArr[0] = "typeProjection";
                break;
            case 18:
            case 28:
                objArr[0] = "originalProjection";
                break;
            case 26:
                objArr[0] = "originalType";
                break;
            case 27:
                objArr[0] = "substituted";
                break;
            case 33:
                objArr[0] = "annotations";
                break;
            case 35:
            case 38:
                objArr[0] = "typeParameterVariance";
                break;
            case 39:
                objArr[0] = "projectionKind";
                break;
        }
        if (i == 1) {
            objArr[1] = "replaceWithNonApproximatingSubstitution";
        } else if (i == 2) {
            objArr[1] = "replaceWithContravariantApproximatingSubstitution";
        } else if (i == 8) {
            objArr[1] = "getSubstitution";
        } else if (i == 34) {
            objArr[1] = "filterOutUnsafeVariance";
        } else if (i != 37) {
            switch (i) {
                case 11:
                case 12:
                case 13:
                    objArr[1] = "safeSubstitute";
                    break;
                default:
                    switch (i) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            objArr[1] = "unsafeSubstitute";
                            break;
                        default:
                            switch (i) {
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    objArr[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                                    break;
                                default:
                                    switch (i) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            objArr[1] = "combine";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            objArr[1] = "combine";
        }
        switch (i) {
            case 1:
            case 2:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
                break;
            case 3:
            case 4:
                objArr[2] = "createChainedSubstitutor";
                break;
            case 5:
            case 6:
            default:
                objArr[2] = "create";
                break;
            case 7:
                objArr[2] = "<init>";
                break;
            case 9:
            case 10:
                objArr[2] = "safeSubstitute";
                break;
            case 14:
            case 15:
            case 16:
                objArr[2] = "substitute";
                break;
            case 17:
                objArr[2] = "substituteWithoutApproximation";
                break;
            case 18:
                objArr[2] = "unsafeSubstitute";
                break;
            case 26:
            case 27:
            case 28:
                objArr[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                break;
            case 33:
                objArr[2] = "filterOutUnsafeVariance";
                break;
            case 35:
            case 36:
            case 38:
            case 39:
                objArr[2] = "combine";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2 && i != 8 && i != 34 && i != 37) {
            switch (i) {
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    switch (i) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            break;
                        default:
                            switch (i) {
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    break;
                                default:
                                    switch (i) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            break;
                                        default:
                                            throw new IllegalArgumentException(str2);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        throw new IllegalStateException(str2);
    }

    public static ad1 b(ad1 ad1Var, ad1 ad1Var2) {
        if (ad1Var == null) {
            a(38);
            throw null;
        }
        if (ad1Var2 == null) {
            a(39);
            throw null;
        }
        ad1 ad1Var3 = ad1.INVARIANT;
        if (ad1Var != ad1Var3) {
            if (ad1Var2 == ad1Var3) {
                return ad1Var;
            }
            if (ad1Var != ad1Var2) {
                throw new AssertionError("Variance conflict: type parameter variance '" + ad1Var + "' and projection kind '" + ad1Var2 + "' cannot be combined");
            }
        }
        return ad1Var2;
    }

    public static int c(ad1 ad1Var, ad1 ad1Var2) {
        ad1 ad1Var3 = ad1.IN_VARIANCE;
        ad1 ad1Var4 = ad1.OUT_VARIANCE;
        if (ad1Var == ad1Var3 && ad1Var2 == ad1Var4) {
            return 3;
        }
        return (ad1Var == ad1Var4 && ad1Var2 == ad1Var3) ? 2 : 1;
    }

    public static ha1 d(fc0 fc0Var) {
        if (fc0Var != null) {
            return new ha1(ak.b(fc0Var.L0(), fc0Var.K0()));
        }
        a(6);
        throw null;
    }

    public static ha1 f(ea1 ea1Var, ea1 ea1Var2) {
        if (ea1Var == null) {
            a(3);
            throw null;
        }
        if (ea1Var.e()) {
            ea1Var = ea1Var2;
        } else if (!ea1Var2.e()) {
            ea1Var = new po(ea1Var, ea1Var2);
        }
        return new ha1(ea1Var);
    }

    public static String j(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (e.X0(th)) {
                throw th;
            }
            return "[Exception while computing toString(): " + th + "]";
        }
    }

    public final fc0 i(fc0 fc0Var, ad1 ad1Var) {
        if (fc0Var == null) {
            a(9);
            throw null;
        }
        if (this.a.e()) {
            return fc0Var;
        }
        try {
            fc0 type = l(new da1(fc0Var, ad1Var), null, 0).getType();
            if (type != null) {
                return type;
            }
            a(12);
            throw null;
        } catch (a e) {
            return pr.d(e.getMessage());
        }
    }

    public final fc0 k(fc0 fc0Var, ad1 ad1Var) {
        da1 da1Var;
        if (fc0Var == null) {
            a(14);
            throw null;
        }
        if (ad1Var == null) {
            a(15);
            throw null;
        }
        ea1 ea1Var = this.a;
        ca1 da1Var2 = new da1(ea1Var.f(fc0Var, ad1Var), ad1Var);
        if (!ea1Var.e()) {
            try {
                da1Var2 = l(da1Var2, null, 0);
            } catch (a unused) {
                da1Var2 = null;
            }
        }
        if (ea1Var.a() || ea1Var.b()) {
            boolean zB = ea1Var.b();
            if (da1Var2 == null) {
                da1Var2 = null;
            } else if (!da1Var2.b()) {
                fc0 type = da1Var2.getType();
                if (ma1.d(type, ba.b$25, null, null)) {
                    ad1 ad1VarC = da1Var2.c();
                    if (ad1VarC == ad1.OUT_VARIANCE) {
                        da1Var = new da1((fc0) e.t0(type).b, ad1VarC);
                    } else if (zB) {
                        da1Var = new da1((fc0) e.t0(type).a, ad1VarC);
                    } else {
                        lb lbVar = new lb();
                        ha1 ha1Var = new ha1(lbVar);
                        if (!lbVar.e()) {
                            try {
                                da1Var2 = ha1Var.l(da1Var2, null, 0);
                            } catch (a unused2) {
                                da1Var2 = null;
                            }
                        }
                    }
                    da1Var2 = da1Var;
                }
            }
        }
        if (da1Var2 == null) {
            return null;
        }
        return da1Var2.getType();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:106:0x0201  */
    /* JADX WARN: Code duplicated, block: B:107:0x020a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0212  */
    /* JADX WARN: Code duplicated, block: B:113:0x0220  */
    /* JADX WARN: Code duplicated, block: B:116:0x0236  */
    /* JADX WARN: Code duplicated, block: B:118:0x023e  */
    /* JADX WARN: Code duplicated, block: B:119:0x0241  */
    /* JADX WARN: Code duplicated, block: B:121:0x0244  */
    /* JADX WARN: Code duplicated, block: B:122:0x0246  */
    /* JADX WARN: Code duplicated, block: B:125:0x024c  */
    /* JADX WARN: Code duplicated, block: B:127:0x0250  */
    /* JADX WARN: Code duplicated, block: B:130:0x0258  */
    /* JADX WARN: Code duplicated, block: B:131:0x0267  */
    /* JADX WARN: Code duplicated, block: B:136:0x0288  */
    /* JADX WARN: Code duplicated, block: B:138:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:140:0x02af  */
    /* JADX WARN: Code duplicated, block: B:143:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:145:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:151:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:155:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:170:0x02d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x013e  */
    /* JADX WARN: Code duplicated, block: B:67:0x014f  */
    /* JADX WARN: Code duplicated, block: B:69:0x015f  */
    /* JADX WARN: Code duplicated, block: B:71:0x0165 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x0168  */
    /* JADX WARN: Code duplicated, block: B:75:0x0170  */
    /* JADX WARN: Code duplicated, block: B:79:0x018c  */
    /* JADX WARN: Code duplicated, block: B:80:0x018f  */
    /* JADX WARN: Code duplicated, block: B:86:0x019a  */
    /* JADX WARN: Code duplicated, block: B:89:0x01a1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:90:0x01a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:92:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:95:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:97:0x01cd  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12, types: [fc0] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r4v0, types: [ea1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2, types: [fc0, w3] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final ca1 l(ca1 ca1Var, v91 v91Var, int i) throws a {
        int i2;
        fc0 type;
        ad1 ad1VarC;
        cc1 cc1VarO0;
        defpackage.a aVar;
        u01 u01Var;
        ad1 ad1Var;
        List parameters;
        List listK0;
        ArrayList arrayList;
        boolean z;
        fc0 fc0VarV;
        v91 v91Var2;
        ca1 ca1Var2;
        ca1 ca1VarL;
        int iU;
        char c;
        ha1 ha1Var;
        z10 z10Var;
        int iC;
        jc0 jc0VarO0;
        yj yjVar;
        cc1 cc1VarK;
        cc1 cc1VarR0;
        s4 s4VarC;
        t4 t4Var;
        int iU2;
        ?? I0;
        ha1 ha1Var2 = this;
        fc0 fc0VarK = null;
        if (ca1Var == null) {
            a(18);
            throw null;
        }
        ?? r4 = ha1Var2.a;
        if (i > 100) {
            throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + j(ca1Var) + "; substitution: " + j(r4));
        }
        if (!ca1Var.b()) {
            ?? type2 = ca1Var.getType();
            if (type2 instanceof ra1) {
                ra1 ra1Var = (ra1) type2;
                cc1 cc1VarG0 = ra1Var.G0();
                fc0 fc0VarI0 = ra1Var.i0();
                ca1 ca1VarL2 = ha1Var2.l(new da1(cc1VarG0, ca1Var.c()), v91Var, i + 1);
                if (ca1VarL2.b()) {
                    return ca1VarL2;
                }
                jc0 jc0VarK = ha1Var2.k(fc0VarI0, ca1Var.c());
                cc1 cc1VarO1 = ca1VarL2.getType().O0();
                if (jc0VarK instanceof ra1) {
                    I0 = jc0VarK;
                    I0 = ((ra1) jc0VarK).i0();
                }
                I0 = jc0VarK;
                return new da1(e.v1(cc1VarO1, I0), ca1VarL2.c());
            }
            if (!(type2.O0() instanceof op) && !(type2.O0() instanceof ls0)) {
                ca1 ca1VarD = r4.d(type2);
                if (ca1VarD == null) {
                    ca1VarD = null;
                } else if (type2.getAnnotations().f(m21.a.x)) {
                    a91 a91VarL0 = ca1VarD.getType().L0();
                    if (a91VarL0 instanceof vk0) {
                        ca1 ca1Var3 = ((vk0) a91VarL0).a;
                        ad1 ad1VarC2 = ca1Var3.c();
                        if (c(ca1Var.c(), ad1VarC2) == 3) {
                            ca1VarD = new da1(ca1Var3.getType());
                        } else if (v91Var != null && c(v91Var.j(), ad1VarC2) == 3) {
                            ca1VarD = new da1(ca1Var3.getType());
                        }
                    }
                }
                ad1 ad1VarC3 = ca1Var.c();
                int i3 = 0;
                if (ca1VarD == null && (type2.O0() instanceof zt)) {
                    jc0 jc0VarO1 = type2.O0();
                    yj yjVar2 = jc0VarO1 instanceof yj ? (yj) jc0VarO1 : null;
                    if (!(yjVar2 == null ? false : yjVar2.z())) {
                        zt ztVar = (zt) type2.O0();
                        int i4 = i + 1;
                        ca1 ca1VarL3 = ha1Var2.l(new da1(ztVar.c, ad1VarC3), v91Var, i4);
                        u01 u01Var2 = ztVar.d;
                        ca1 ca1VarL4 = ha1Var2.l(new da1(u01Var2, ad1VarC3), v91Var, i4);
                        ad1 ad1VarC4 = ca1VarL3.c();
                        if (ca1VarL3.getType() != ztVar.c || ca1VarL4.getType() != u01Var2) {
                            return new da1(e4.c(e.g(ca1VarL3.getType()), e.g(ca1VarL4.getType())), ad1VarC4);
                        }
                    } else if (!ub0.F(type2)) {
                        i2 = 2;
                        if (ca1VarD != null) {
                            iC = c(ad1VarC3, ca1VarD.c());
                            if (!(type2.L0() instanceof mb)) {
                                iU2 = ak.u(iC);
                                if (iU2 != 1) {
                                    return new da1(type2.L0().k().p(), ad1.OUT_VARIANCE);
                                }
                                if (iU2 == 2) {
                                    throw new a("Out-projection in in-position");
                                }
                            }
                            jc0VarO0 = type2.O0();
                            if (jc0VarO0 instanceof yj) {
                                yjVar = (yj) jc0VarO0;
                            } else {
                                yjVar = null;
                            }
                            if (yjVar != null) {
                                yjVar = null;
                            } else {
                                yjVar = null;
                            }
                            if (ca1VarD.b()) {
                                return ca1VarD;
                            }
                            if (yjVar != null) {
                                cc1VarK = yjVar.W(ca1VarD.getType());
                            } else {
                                cc1VarK = ma1.k(ca1VarD.getType(), type2.M0());
                            }
                            cc1VarR0 = cc1VarK;
                            if (!type2.getAnnotations().isEmpty()) {
                                s4VarC = r4.c(type2.getAnnotations());
                                if (s4VarC != null) {
                                    a(33);
                                    throw null;
                                }
                                if (s4VarC.f(m21.a.x)) {
                                    s4VarC = new gt(s4VarC, new mu(i2));
                                }
                                t4Var = new t4(new s4[]{cc1VarK.getAnnotations(), s4VarC});
                                if (cc1VarK.getAnnotations().isEmpty()) {
                                    cc1VarR0 = cc1VarK;
                                    cc1VarR0 = cc1VarK.O0().R0(t4Var);
                                } else {
                                    cc1VarR0 = cc1VarK;
                                    cc1VarR0 = cc1VarK.O0().R0(t4Var);
                                }
                            }
                            if (iC == 1) {
                                ad1VarC3 = b(ad1VarC3, ca1VarD.c());
                            }
                            return new da1(cc1VarR0, ad1VarC3);
                        }
                        type = ca1Var.getType();
                        ad1VarC = ca1Var.c();
                        if (!(type.L0().b() instanceof v91)) {
                            cc1VarO0 = type.O0();
                            if (cc1VarO0 instanceof defpackage.a) {
                                aVar = (defpackage.a) cc1VarO0;
                            } else {
                                aVar = null;
                            }
                            if (aVar == null) {
                                u01Var = null;
                            } else {
                                u01Var = aVar.d;
                            }
                            ad1Var = ad1.INVARIANT;
                            if (u01Var != null) {
                                if (r4 instanceof z10) {
                                    z10Var = (z10) r4;
                                    if (z10Var.d) {
                                        ha1Var = new ha1(new z10(z10Var.b, z10Var.c, false));
                                    } else {
                                        ha1Var = ha1Var2;
                                    }
                                } else {
                                    ha1Var = ha1Var2;
                                }
                                fc0VarK = ha1Var.k(u01Var, ad1Var);
                            }
                            parameters = type.L0().getParameters();
                            listK0 = type.K0();
                            arrayList = new ArrayList(parameters.size());
                            z = false;
                            while (i3 < parameters.size()) {
                                v91Var2 = (v91) parameters.get(i3);
                                ca1Var2 = (ca1) listK0.get(i3);
                                ca1VarL = ha1Var2.l(ca1Var2, v91Var2, i + 1);
                                iU = ak.u(c(v91Var2.j(), ca1VarL.c()));
                                if (iU != 0) {
                                    if (iU != 1) {
                                        c = 2;
                                        if (iU == 2) {
                                        }
                                    } else {
                                        c = 2;
                                    }
                                    ca1VarL = ma1.m(v91Var2);
                                } else {
                                    c = 2;
                                    if (v91Var2.j() != ad1Var) {
                                        ca1VarL = new da1(ca1VarL.getType(), ad1Var);
                                    }
                                }
                                if (ca1VarL != ca1Var2) {
                                    z = true;
                                }
                                arrayList.add(ca1VarL);
                                i3++;
                                ha1Var2 = this;
                            }
                            if (z) {
                                listK0 = arrayList;
                            }
                            fc0VarV = e.V(type, listK0, r4.c(type.getAnnotations()), 4);
                            if (fc0VarV instanceof u01) {
                                fc0VarV = e.t1((u01) fc0VarV, (u01) fc0VarK);
                            }
                            return new da1(fc0VarV, ad1VarC);
                        }
                    }
                } else if (!ub0.F(type2) && !e.O((fc0) type2)) {
                    i2 = 2;
                    if (ca1VarD != null) {
                        iC = c(ad1VarC3, ca1VarD.c());
                        if (!(type2.L0() instanceof mb)) {
                            iU2 = ak.u(iC);
                            if (iU2 != 1) {
                                return new da1(type2.L0().k().p(), ad1.OUT_VARIANCE);
                            }
                            if (iU2 == 2) {
                                throw new a("Out-projection in in-position");
                            }
                        }
                        jc0VarO0 = type2.O0();
                        if (jc0VarO0 instanceof yj) {
                            yjVar = (yj) jc0VarO0;
                        } else {
                            yjVar = null;
                        }
                        if (yjVar != null || !yjVar.z()) {
                            yjVar = null;
                        }
                        if (ca1VarD.b()) {
                            return ca1VarD;
                        }
                        if (yjVar != null) {
                            cc1VarK = yjVar.W(ca1VarD.getType());
                        } else {
                            cc1VarK = ma1.k(ca1VarD.getType(), type2.M0());
                        }
                        cc1VarR0 = cc1VarK;
                        if (!type2.getAnnotations().isEmpty()) {
                            s4VarC = r4.c(type2.getAnnotations());
                            if (s4VarC != null) {
                                a(33);
                                throw null;
                            }
                            if (s4VarC.f(m21.a.x)) {
                                s4VarC = new gt(s4VarC, new mu(i2));
                            }
                            t4Var = new t4(new s4[]{cc1VarK.getAnnotations(), s4VarC});
                            if (cc1VarK.getAnnotations().isEmpty() || !t4Var.isEmpty()) {
                                cc1VarR0 = cc1VarK;
                                cc1VarR0 = cc1VarK.O0().R0(t4Var);
                            }
                        }
                        if (iC == 1) {
                            ad1VarC3 = b(ad1VarC3, ca1VarD.c());
                        }
                        return new da1(cc1VarR0, ad1VarC3);
                    }
                    type = ca1Var.getType();
                    ad1VarC = ca1Var.c();
                    if (!(type.L0().b() instanceof v91)) {
                        cc1VarO0 = type.O0();
                        if (cc1VarO0 instanceof defpackage.a) {
                            aVar = (defpackage.a) cc1VarO0;
                        } else {
                            aVar = null;
                        }
                        if (aVar == null) {
                            u01Var = null;
                        } else {
                            u01Var = aVar.d;
                        }
                        ad1Var = ad1.INVARIANT;
                        if (u01Var != null) {
                            if (r4 instanceof z10) {
                                z10Var = (z10) r4;
                                if (z10Var.d) {
                                    ha1Var = ha1Var2;
                                } else {
                                    ha1Var = new ha1(new z10(z10Var.b, z10Var.c, false));
                                }
                            } else {
                                ha1Var = ha1Var2;
                            }
                            fc0VarK = ha1Var.k(u01Var, ad1Var);
                        }
                        parameters = type.L0().getParameters();
                        listK0 = type.K0();
                        arrayList = new ArrayList(parameters.size());
                        z = false;
                        while (i3 < parameters.size()) {
                            v91Var2 = (v91) parameters.get(i3);
                            ca1Var2 = (ca1) listK0.get(i3);
                            ca1VarL = ha1Var2.l(ca1Var2, v91Var2, i + 1);
                            iU = ak.u(c(v91Var2.j(), ca1VarL.c()));
                            if (iU != 0) {
                                if (iU != 1) {
                                    c = 2;
                                    if (iU == 2) {
                                    }
                                } else {
                                    c = 2;
                                }
                                ca1VarL = ma1.m(v91Var2);
                            } else {
                                c = 2;
                                if (v91Var2.j() != ad1Var && !ca1VarL.b()) {
                                    ca1VarL = new da1(ca1VarL.getType(), ad1Var);
                                }
                            }
                            if (ca1VarL != ca1Var2) {
                                z = true;
                            }
                            arrayList.add(ca1VarL);
                            i3++;
                            ha1Var2 = this;
                        }
                        if (z) {
                            listK0 = arrayList;
                        }
                        fc0VarV = e.V(type, listK0, r4.c(type.getAnnotations()), 4);
                        if ((fc0VarV instanceof u01) && (fc0VarK instanceof u01)) {
                            fc0VarV = e.t1((u01) fc0VarV, (u01) fc0VarK);
                        }
                        return new da1(fc0VarV, ad1VarC);
                    }
                }
            }
        }
        return ca1Var;
    }
}
