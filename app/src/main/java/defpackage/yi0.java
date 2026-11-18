package defpackage;

import androidx.lifecycle.LiveData;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class yi0 extends LiveData {
    @Override // androidx.lifecycle.LiveData
    public final void i(Object obj) {
        LiveData.a("setValue");
        this.g++;
        this.e = obj;
        c(null);
    }
}
