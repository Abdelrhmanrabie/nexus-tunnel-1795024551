package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.view.Choreographer;
import defpackage.dq0;
import defpackage.e20;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements e20 {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a {
    }

    @Override // defpackage.e20
    public final Object a(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new a();
        }
        Choreographer.getInstance().postFrameCallback(new dq0(this, context.getApplicationContext()));
        return new a();
    }

    @Override // defpackage.e20
    public final List dependencies() {
        return Collections.EMPTY_LIST;
    }
}
