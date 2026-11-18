package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class v41 implements rc0, Serializable {
    public lw b;
    public volatile Object c = e.f33d$1;
    public final v41 d = this;

    public v41(lw lwVar) {
        this.b = lwVar;
    }

    @Override // defpackage.rc0
    public final Object getValue() {
        Object objInvoke;
        Object obj = this.c;
        e eVar = e.f33d$1;
        if (obj != eVar) {
            return obj;
        }
        synchronized (this.d) {
            objInvoke = this.c;
            if (objInvoke == eVar) {
                objInvoke = this.b.invoke();
                this.c = objInvoke;
                this.b = null;
            }
        }
        return objInvoke;
    }

    public final String toString() {
        return this.c != e.f33d$1 ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
