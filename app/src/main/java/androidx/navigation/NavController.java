package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import defpackage.ck0;
import defpackage.d;
import defpackage.e2;
import defpackage.he0;
import defpackage.mm0;
import java.util.ArrayDeque;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class NavController {
    public final Context a;
    public final ArrayDeque h = new ArrayDeque();
    public final ck0 k = new ck0();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a extends mm0 {
        public a() {
        }

        @Override // defpackage.mm0
        public final void a() {
            ArrayDeque arrayDeque = NavController.this.h;
            if (arrayDeque.isEmpty()) {
                return;
            }
            if (arrayDeque.isEmpty() || arrayDeque.getLast() == null) {
                throw null;
            }
            d.AnonymousClass0.m$1();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface b {
    }

    public NavController(Context context) {
        new CopyOnWriteArrayList();
        new h() { // from class: androidx.navigation.NavController.1
            @Override // androidx.lifecycle.h
            public final void a(he0 he0Var, e.a aVar) {
                NavController.this.getClass();
            }
        };
        new a();
        this.a = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        this.k.a(new e2());
        ck0 ck0Var = this.k;
        e2 e2Var = new e2();
        for (Context baseContext = this.a; baseContext instanceof ContextWrapper; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof Activity) {
                break;
            }
        }
        ck0Var.a(e2Var);
    }
}
