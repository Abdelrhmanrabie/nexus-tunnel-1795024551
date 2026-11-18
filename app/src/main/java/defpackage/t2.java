package defpackage;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class t2 extends o2 {
    public final /* synthetic */ q2 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ l2 c;

    public t2(q2 q2Var, String str, l2 l2Var) {
        this.a = q2Var;
        this.b = str;
        this.c = l2Var;
    }

    public final void a(Object obj) {
        q2 q2Var = this.a;
        LinkedHashMap linkedHashMap = q2Var.b;
        String str = this.b;
        Object obj2 = linkedHashMap.get(str);
        l2 l2Var = this.c;
        if (obj2 == null) {
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + l2Var + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }
        int iIntValue = ((Number) obj2).intValue();
        ArrayList arrayList = q2Var.d;
        arrayList.add(str);
        try {
            q2Var.b(iIntValue, l2Var, obj);
        } catch (Exception e) {
            arrayList.remove(str);
            throw e;
        }
    }
}
