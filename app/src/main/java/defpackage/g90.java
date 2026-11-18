package defpackage;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class g90 extends oc0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ b90 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g90(b90 b90Var, int i) {
        super(0);
        this.G0 = i;
        this.b = b90Var;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        Type[] lowerBounds;
        int i;
        int i2 = this.G0;
        b90 b90Var = this.b;
        Type type = null;
        type = null;
        type = null;
        type = null;
        type = null;
        int i3 = 1;
        if (i2 == 0) {
            la laVarL = b90Var.l();
            ox oxVar = laVarL instanceof ox ? (ox) laVarL : null;
            if (oxVar != null && oxVar.isSuspend()) {
                Object objU0 = he.U0(b90Var.i().a());
                ParameterizedType parameterizedType = objU0 instanceof ParameterizedType ? (ParameterizedType) objU0 : null;
                if (e4.a(parameterizedType == null ? null : parameterizedType.getRawType(), ai.class)) {
                    Object objL0 = ae.L0(parameterizedType.getActualTypeArguments());
                    WildcardType wildcardType = objL0 instanceof WildcardType ? (WildcardType) objL0 : null;
                    if (wildcardType != null && (lowerBounds = wildcardType.getLowerBounds()) != null) {
                        type = (Type) ae.E0(lowerBounds);
                    }
                }
            }
            return type == null ? b90Var.i().getReturnType() : type;
        }
        if (i2 == 1) {
            return lc1.b(b90Var.l());
        }
        int i4 = 0;
        if (i2 != 2) {
            if (i2 == 3) {
                return new wa0(b90Var.l().getReturnType(), new g90(b90Var, i4));
            }
            List typeParameters = b90Var.l().getTypeParameters();
            ArrayList arrayList = new ArrayList(ae.y0(typeParameters));
            Iterator it = typeParameters.iterator();
            while (it.hasNext()) {
                arrayList.add(new ya0(b90Var, (v91) it.next()));
            }
            return arrayList;
        }
        la laVarL2 = b90Var.l();
        ArrayList arrayList2 = new ArrayList();
        if (b90Var.n()) {
            i = 0;
        } else {
            cv cvVar = lc1.a;
            sc0 sc0VarJ0 = laVarL2.N() != null ? ((ai0) laVarL2.b()).J0() : null;
            if (sc0VarJ0 != null) {
                arrayList2.add(new ha0(b90Var, 0, ga0$a.b, new c90(sc0VarJ0, 0)));
                i = 1;
            } else {
                i = 0;
            }
            sc0 sc0VarQ = laVarL2.Q();
            if (sc0VarQ != null) {
                arrayList2.add(new ha0(b90Var, i, ga0$a.c, new c90(sc0VarQ, 1)));
                i++;
            }
        }
        int size = laVarL2.f().size();
        while (i4 < size) {
            arrayList2.add(new ha0(b90Var, i, ga0$a.d, new e90(laVarL2, i4)));
            i4++;
            i++;
        }
        if (e4.a(b90Var.getName(), "<init>") && b90Var.j().d().isAnnotation() && (laVarL2 instanceof t40) && arrayList2.size() > 1) {
            nu nuVar = new nu(i3);
            if (arrayList2.size() > 1) {
                Collections.sort(arrayList2, nuVar);
            }
        }
        arrayList2.trimToSize();
        return arrayList2;
    }
}
