package defpackage;

import android.view.View;
import android.view.animation.BaseInterpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ke1 {
    public BaseInterpolator c;
    public e d;
    public boolean e;
    public long b = -1;
    public final a f = new a(this);
    public final ArrayList a = new ArrayList();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends e {
        public boolean o;
        public int p;
        public final /* synthetic */ ke1 q;

        public a(ke1 ke1Var) {
            super(4);
            this.q = ke1Var;
            this.o = false;
            this.p = 0;
        }

        @Override // defpackage.e, defpackage.le1
        public final void a() {
            if (this.o) {
                return;
            }
            this.o = true;
            e eVar = this.q.d;
            if (eVar != null) {
                eVar.a();
            }
        }

        @Override // defpackage.le1
        public final void onAnimationEnd() {
            int i = this.p + 1;
            this.p = i;
            ke1 ke1Var = this.q;
            if (i == ke1Var.a.size()) {
                e eVar = ke1Var.d;
                if (eVar != null) {
                    eVar.onAnimationEnd();
                }
                this.p = 0;
                this.o = false;
                ke1Var.e = false;
            }
        }
    }

    public final void a() {
        if (this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((je1) it.next()).b();
            }
            this.e = false;
        }
    }

    public final void b() {
        View view;
        if (this.e) {
            return;
        }
        for (je1 je1Var : this.a) {
            long j = this.b;
            if (j >= 0) {
                je1Var.c(j);
            }
            BaseInterpolator baseInterpolator = this.c;
            if (baseInterpolator != null && (view = (View) je1Var.a.get()) != null) {
                view.animate().setInterpolator(baseInterpolator);
            }
            if (this.d != null) {
                je1Var.d(this.f);
            }
            View view2 = (View) je1Var.a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.e = true;
    }
}
