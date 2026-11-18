package defpackage;

import android.transition.Transition;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class zv implements Transition.TransitionListener {
    public final /* synthetic */ Object a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ Object e;
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ yv g;

    public zv(yv yvVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.g = yvVar;
        this.a = obj;
        this.b = arrayList;
        this.e = obj2;
        this.f = arrayList2;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        yv yvVar = this.g;
        Object obj = this.a;
        if (obj != null) {
            yvVar.t(obj, this.b, null);
        }
        Object obj2 = this.e;
        if (obj2 != null) {
            yvVar.t(obj2, this.f, null);
        }
    }
}
