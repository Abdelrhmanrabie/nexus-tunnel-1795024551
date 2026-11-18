package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ut0 extends zt0 implements r60 {
    public final Constructor a;

    public ut0(Constructor constructor) {
        this.a = constructor;
    }

    @Override // defpackage.zt0
    public final Member O() {
        return this.a;
    }

    @Override // defpackage.r60
    public final ArrayList getTypeParameters() {
        TypeVariable[] typeParameters = this.a.getTypeParameters();
        ArrayList arrayList = new ArrayList(typeParameters.length);
        int length = typeParameters.length;
        int i = 0;
        while (i < length) {
            TypeVariable typeVariable = typeParameters[i];
            i++;
            arrayList.add(new gu0(typeVariable));
        }
        return arrayList;
    }
}
