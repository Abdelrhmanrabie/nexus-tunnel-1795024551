package defpackage;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class hu0 extends ui implements o40 {
    public final fu0 a;
    public final Annotation[] b;
    public final String c;
    public final boolean d;

    public hu0(fu0 fu0Var, Annotation[] annotationArr, String str, boolean z) {
        this.a = fu0Var;
        this.b = annotationArr;
        this.c = str;
        this.d = z;
    }

    @Override // defpackage.o40
    public final ct0 c(cv cvVar) {
        return e.N0(this.b, cvVar);
    }

    @Override // defpackage.o40
    public final Collection getAnnotations() {
        Annotation[] annotationArr = this.b;
        ArrayList arrayList = new ArrayList(annotationArr.length);
        int length = annotationArr.length;
        int i = 0;
        while (i < length) {
            Annotation annotation = annotationArr[i];
            i++;
            arrayList.add(new ct0(annotation));
        }
        return arrayList;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(hu0.class.getName());
        sb.append(": ");
        sb.append(this.d ? "vararg " : AppConfig.CUSTOM);
        String str = this.c;
        sb.append(str == null ? null : ij0.d(str));
        sb.append(": ");
        sb.append(this.a);
        return sb.toString();
    }
}
