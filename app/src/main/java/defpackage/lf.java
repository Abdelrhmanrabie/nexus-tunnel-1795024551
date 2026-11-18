package defpackage;

import android.content.Intent;
import android.content.IntentSender;
import androidx.activity.ComponentActivity;
import androidx.profileinstaller.b;
import java.io.Serializable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lf implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Serializable f;

    public /* synthetic */ lf(Object obj, int i, int i2, Serializable serializable) {
        this.b = i2;
        this.d = obj;
        this.c = i;
        this.f = serializable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        int i2 = this.c;
        Serializable serializable = this.f;
        Object obj = this.d;
        if (i != 0) {
            ((b) obj).c.b(i2, serializable);
        } else {
            ((ComponentActivity.f) obj).a(i2, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) serializable));
        }
    }
}
