package defpackage;

import android.graphics.Rect;
import android.transition.Transition;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class xv extends Transition.EpicenterCallback {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Rect a;

    public /* synthetic */ xv(int i, Rect rect) {
        this.G0 = i;
        this.a = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public final Rect onGetEpicenter(Transition transition) {
        int i = this.G0;
        Rect rect = this.a;
        if (i == 0 || !rect.isEmpty()) {
            return rect;
        }
        return null;
    }
}
