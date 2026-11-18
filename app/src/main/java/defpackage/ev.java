package defpackage;

import android.os.Bundle;
import androidx.fragment.app.n;
import androidx.fragment.app.q;
import androidx.savedstate.a;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ev implements a.b {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ev(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // androidx.savedstate.a.b
    public final Bundle a() {
        int i = this.a;
        Object obj = this.b;
        return i != 0 ? ((q) obj).T() : n.s((n) obj);
    }
}
