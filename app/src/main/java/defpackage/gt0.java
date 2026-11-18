package defpackage;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class gt0 extends dt0 {
    public final Object[] b;

    public gt0(ij0 ij0Var, Object[] objArr) {
        super(ij0Var);
        this.b = objArr;
    }

    public final ArrayList getElements() {
        dt0 st0Var;
        Object[] objArr = this.b;
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            Class<?> cls = obj.getClass();
            List list = bt0.a;
            if (Enum.class.isAssignableFrom(cls)) {
                st0Var = new wt0(null, (Enum) obj);
            } else if (obj instanceof Annotation) {
                st0Var = new et0(null, (Annotation) obj);
            } else if (obj instanceof Object[]) {
                st0Var = new gt0(null, (Object[]) obj);
            } else {
                st0Var = obj instanceof Class ? new st0(null, (Class) obj) : new yt0(obj, null);
            }
            arrayList.add(st0Var);
        }
        return arrayList;
    }
}
