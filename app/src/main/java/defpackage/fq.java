package defpackage;

import android.text.Editable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class fq extends Editable.Factory {
    public static final Object a = new Object();
    public static volatile fq b;
    public static Class c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = c;
        return cls != null ? new y11(charSequence, cls) : super.newEditable(charSequence);
    }
}
