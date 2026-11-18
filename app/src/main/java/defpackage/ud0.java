package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ud0 implements y91 {
    public final v8 a;
    public final qk b;
    public final int c;
    public final LinkedHashMap d;
    public final ff0.j e;

    public ud0(v8 v8Var, qk qkVar, r60 r60Var, int i) {
        this.a = v8Var;
        this.b = qkVar;
        this.c = i;
        ArrayList typeParameters = r60Var.getTypeParameters();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = typeParameters.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i2));
            i2++;
        }
        this.d = linkedHashMap;
        this.e = ((c60) this.a.a).a.d(new i(14, this));
    }

    @Override // defpackage.y91
    public final v91 a(gu0 gu0Var) {
        td0 td0Var = (td0) this.e.invoke(gu0Var);
        return td0Var == null ? ((y91) this.a.b).a(gu0Var) : td0Var;
    }
}
