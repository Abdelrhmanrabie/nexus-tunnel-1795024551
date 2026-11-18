package defpackage;

import android.app.Application;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class r3 extends zd1 {
    private final Application application;

    public r3(Application application) {
        this.application = application;
    }

    public <T extends Application> T getApplication() {
        return (T) this.application;
    }
}
