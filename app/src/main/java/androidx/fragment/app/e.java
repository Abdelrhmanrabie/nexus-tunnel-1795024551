package androidx.fragment.app;

import android.animation.Animator;
import android.util.Log;
import defpackage.gb;
import java.util.Objects;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class e implements gb.a {
    public final /* synthetic */ Animator a;
    public final /* synthetic */ y.d b;

    public e(Animator animator, y.d dVar) {
        this.a = animator;
        this.b = dVar;
    }

    @Override // gb.a
    public final void onCancel() {
        this.a.end();
        if (Log.isLoggable("FragmentManager", 2)) {
            Objects.toString(this.b);
        }
    }
}
