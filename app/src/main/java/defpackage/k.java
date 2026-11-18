package defpackage;

import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class k extends ai0 {
    public final ij0 b;
    public final ff0.h c;
    public final ff0.h d;
    public final ff0.h f;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements lw {
        public final /* synthetic */ int G0;
        public final /* synthetic */ k b;

        public /* synthetic */ a(k kVar, int i) {
            this.G0 = i;
            this.b = kVar;
        }

        @Override // defpackage.lw
        public final Object invoke() {
            int i = this.G0;
            k kVar = this.b;
            if (i != 0) {
                return i != 1 ? new sc0(kVar) : new k20(kVar.Y());
            }
            return ma1.n(kVar, kVar.Y(), new j(0, this));
        }
    }

    public k(ff0 ff0Var, ij0 ij0Var) {
        int i = 0;
        if (ff0Var == null) {
            i0(0);
            throw null;
        }
        int i2 = 1;
        if (ij0Var == null) {
            i0(1);
            throw null;
        }
        this.b = ij0Var;
        this.c = new ff0.h(ff0Var, new a(this, i));
        this.d = new ff0.h(ff0Var, new a(this, i2));
        this.f = new ff0.h(ff0Var, new a(this, 2));
    }

    public static /* synthetic */ void i0(int i) {
        String str = (i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13 || i == 15 || i == 16 || i == 18 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13 || i == 15 || i == 16 || i == 18 || i == 19) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 6:
            case 12:
                objArr[0] = "typeArguments";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 9:
            case 14:
                objArr[0] = "typeSubstitution";
                break;
            case 17:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i == 8 || i == 11 || i == 13 || i == 15) {
            objArr[1] = "getMemberScope";
        } else if (i == 16) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i == 18) {
            objArr[1] = "substitute";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
                objArr[2] = "getMemberScope";
                break;
            case 17:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 4 && i != 5 && i != 8 && i != 11 && i != 13 && i != 15 && i != 16 && i != 18 && i != 19) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // defpackage.b41
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public ai0 c(ha1 ha1Var) {
        if (ha1Var != null) {
            return ha1Var.a.e() ? this : new ae0(this, ha1Var);
        }
        i0(17);
        throw null;
    }

    @Override // defpackage.ai0
    public final vg0 J(ea1 ea1Var) {
        ym.i(xm.d(this));
        return z(ea1Var, lc0$a.a);
    }

    @Override // defpackage.ai0
    public final sc0 J0() {
        return (sc0) this.f.invoke();
    }

    @Override // defpackage.ai0
    public vg0 V() {
        return (vg0) this.d.invoke();
    }

    @Override // defpackage.ai0
    public vg0 Y() {
        ym.i(xm.d(this));
        vg0 vg0VarW = W(lc0$a.a);
        if (vg0VarW != null) {
            return vg0VarW;
        }
        i0(16);
        throw null;
    }

    @Override // defpackage.ai0, defpackage.ok, defpackage.od
    public final ai0 a() {
        return this;
    }

    @Override // defpackage.ai0, defpackage.ok, defpackage.od
    public final od a() {
        return this;
    }

    @Override // defpackage.ai0, defpackage.ok, defpackage.od
    public final ok a() {
        return this;
    }

    @Override // defpackage.ok
    public final ij0 getName() {
        ij0 ij0Var = this.b;
        if (ij0Var != null) {
            return ij0Var;
        }
        i0(2);
        throw null;
    }

    @Override // defpackage.ai0, defpackage.od
    public final u01 n() {
        return (u01) this.c.invoke();
    }

    @Override // defpackage.ok
    public final Object r0(bj bjVar, Object obj) {
        return bjVar.d(this, (StringBuilder) obj);
    }

    @Override // defpackage.ai0
    public vg0 z(ea1 ea1Var, lc0$a lc0_a) {
        if (!ea1Var.e()) {
            return new c41(W(lc0_a), new ha1(ea1Var));
        }
        vg0 vg0VarW = W(lc0_a);
        if (vg0VarW != null) {
            return vg0VarW;
        }
        i0(11);
        throw null;
    }
}
