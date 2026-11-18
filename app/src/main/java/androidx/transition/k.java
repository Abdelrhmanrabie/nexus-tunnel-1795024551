package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import defpackage.ak;
import defpackage.g81;
import defpackage.oo;
import defpackage.ro0;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class k extends h {
    public int d;
    public ArrayList b = new ArrayList();
    public boolean c = true;
    public boolean f = false;
    public int g = 0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends i {
        public final /* synthetic */ h b;

        public a(h hVar) {
            this.b = hVar;
        }

        @Override // androidx.transition.h.g
        public final void onTransitionEnd(h hVar) {
            this.b.runAnimators();
            hVar.removeListener(this);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b extends i {
        public final k b;

        public b(k kVar) {
            this.b = kVar;
        }

        @Override // androidx.transition.h.g
        public final void onTransitionEnd(h hVar) {
            k kVar = this.b;
            int i = kVar.d - 1;
            kVar.d = i;
            if (i == 0) {
                kVar.f = false;
                kVar.end();
            }
            hVar.removeListener(this);
        }

        @Override // androidx.transition.i, androidx.transition.h.g
        public final void onTransitionStart(h hVar) {
            k kVar = this.b;
            if (kVar.f) {
                return;
            }
            kVar.start();
            kVar.f = true;
        }
    }

    public final void a(h hVar) {
        this.b.add(hVar);
        hVar.mParent = this;
        long j = this.mDuration;
        if (j >= 0) {
            hVar.setDuration(j);
        }
        if ((this.g & 1) != 0) {
            hVar.setInterpolator(this.mInterpolator);
        }
        if ((this.g & 2) != 0) {
            hVar.setPropagation();
        }
        if ((this.g & 4) != 0) {
            hVar.setPathMotion(this.mPathMotion);
        }
        if ((this.g & 8) != 0) {
            hVar.setEpicenterCallback(this.mEpicenterCallback);
        }
    }

    @Override // androidx.transition.h
    public final void addTarget(View view) {
        for (int i = 0; i < this.b.size(); i++) {
            ((h) this.b.get(i)).addTarget(view);
        }
        this.mTargets.add(view);
    }

    @Override // androidx.transition.h
    public final void cancel() {
        super.cancel();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ((h) this.b.get(i)).cancel();
        }
    }

    @Override // androidx.transition.h
    public final void captureEndValues(g81 g81Var) {
        if (isValidTarget(g81Var.b)) {
            for (h hVar : this.b) {
                if (hVar.isValidTarget(g81Var.b)) {
                    hVar.captureEndValues(g81Var);
                    g81Var.c.add(hVar);
                }
            }
        }
    }

    @Override // androidx.transition.h
    public final void capturePropagationValues(g81 g81Var) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ((h) this.b.get(i)).capturePropagationValues(g81Var);
        }
    }

    @Override // androidx.transition.h
    public final void captureStartValues(g81 g81Var) {
        if (isValidTarget(g81Var.b)) {
            for (h hVar : this.b) {
                if (hVar.isValidTarget(g81Var.b)) {
                    hVar.captureStartValues(g81Var);
                    g81Var.c.add(hVar);
                }
            }
        }
    }

    @Override // androidx.transition.h
    /* JADX INFO: renamed from: clone */
    public final h mo1clone() {
        k kVar = (k) super.mo1clone();
        kVar.b = new ArrayList();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            h hVarMo1clone = ((h) this.b.get(i)).mo1clone();
            kVar.b.add(hVarMo1clone);
            hVarMo1clone.mParent = kVar;
        }
        return kVar;
    }

    @Override // androidx.transition.h
    public final void createAnimators(ViewGroup viewGroup, oo ooVar, oo ooVar2, ArrayList arrayList, ArrayList arrayList2) {
        long j = this.mStartDelay;
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) this.b.get(i);
            if (j > 0 && (this.c || i == 0)) {
                long j2 = hVar.mStartDelay;
                if (j2 > 0) {
                    hVar.setStartDelay(j2 + j);
                } else {
                    hVar.setStartDelay(j);
                }
            }
            hVar.createAnimators(viewGroup, ooVar, ooVar2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.h
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final void setDuration(long j) {
        ArrayList arrayList;
        this.mDuration = j;
        if (j < 0 || (arrayList = this.b) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((h) this.b.get(i)).setDuration(j);
        }
    }

    @Override // androidx.transition.h
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final void setInterpolator(TimeInterpolator timeInterpolator) {
        this.g |= 1;
        ArrayList arrayList = this.b;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((h) this.b.get(i)).setInterpolator(timeInterpolator);
            }
        }
        this.mInterpolator = timeInterpolator;
    }

    public final void f(int i) {
        if (i == 0) {
            this.c = true;
        } else {
            if (i != 1) {
                throw new AndroidRuntimeException(ak.h(i, "Invalid parameter for TransitionSet ordering: "));
            }
            this.c = false;
        }
    }

    @Override // androidx.transition.h
    public final void pause(View view) {
        super.pause(view);
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ((h) this.b.get(i)).pause(view);
        }
    }

    @Override // androidx.transition.h
    public final void removeTarget(View view) {
        for (int i = 0; i < this.b.size(); i++) {
            ((h) this.b.get(i)).removeTarget(view);
        }
        this.mTargets.remove(view);
    }

    @Override // androidx.transition.h
    public final void resume(View view) {
        super.resume(view);
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ((h) this.b.get(i)).resume(view);
        }
    }

    @Override // androidx.transition.h
    public final void runAnimators() {
        ArrayList arrayList;
        if (this.b.isEmpty()) {
            start();
            end();
            return;
        }
        b bVar = new b(this);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((h) it.next()).addListener(bVar);
        }
        this.d = this.b.size();
        if (this.c) {
            Iterator it2 = this.b.iterator();
            while (it2.hasNext()) {
                ((h) it2.next()).runAnimators();
            }
            return;
        }
        int i = 1;
        while (true) {
            int size = this.b.size();
            arrayList = this.b;
            if (i >= size) {
                break;
            }
            ((h) arrayList.get(i - 1)).addListener(new a((h) this.b.get(i)));
            i++;
        }
        h hVar = (h) arrayList.get(0);
        if (hVar != null) {
            hVar.runAnimators();
        }
    }

    @Override // androidx.transition.h
    public final void setEpicenterCallback(h.f fVar) {
        this.mEpicenterCallback = fVar;
        this.g |= 8;
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ((h) this.b.get(i)).setEpicenterCallback(fVar);
        }
    }

    @Override // androidx.transition.h
    public final void setPathMotion(ro0 ro0Var) {
        super.setPathMotion(ro0Var);
        this.g |= 4;
        if (this.b != null) {
            for (int i = 0; i < this.b.size(); i++) {
                ((h) this.b.get(i)).setPathMotion(ro0Var);
            }
        }
    }

    @Override // androidx.transition.h
    public final void setPropagation() {
        this.g |= 2;
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ((h) this.b.get(i)).setPropagation();
        }
    }

    @Override // androidx.transition.h
    public final void setStartDelay(long j) {
        this.mStartDelay = j;
    }

    @Override // androidx.transition.h
    public final String toString(String str) {
        String string = super.toString(str);
        for (int i = 0; i < this.b.size(); i++) {
            StringBuilder sbO = ak.o(string, "\n");
            sbO.append(((h) this.b.get(i)).toString(str.concat("  ")));
            string = sbO.toString();
        }
        return string;
    }
}
