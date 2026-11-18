package defpackage;

import android.os.Parcel;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class we extends RuntimeException {
    public final /* synthetic */ int G0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public we() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.G0 = 4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ we(String str, int i) {
        super(str);
        this.G0 = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public we(String str, Parcel parcel) {
        super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        this.G0 = 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ we(String str, Throwable th) {
        super(str, th);
        this.G0 = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ we(Throwable th) {
        super(th);
        this.G0 = 3;
    }

    private final synchronized Throwable fillInStackTrace$wf$a() {
        return this;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        if (this.G0 != 5) {
            return super.fillInStackTrace();
        }
        fillInStackTrace$wf$a();
        return this;
    }
}
