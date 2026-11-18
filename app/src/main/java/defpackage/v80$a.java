package defpackage;

import java.lang.reflect.Field;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class v80$a extends uh {
    public final Field a;

    public v80$a(Field field) {
        this.a = field;
    }

    @Override // defpackage.uh
    public final String a() {
        StringBuilder sb = new StringBuilder();
        Field field = this.a;
        sb.append(q70.a(field.getName()));
        sb.append("()");
        sb.append(bt0.b(field.getType()));
        return sb.toString();
    }
}
