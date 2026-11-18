package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class j5 extends e {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j5(int i, Object obj) {
        super(4);
        this.G0 = i;
        this.o = obj;
    }

    @Override // defpackage.e, defpackage.le1
    public void a() {
        int i = this.G0;
        Object obj = this.o;
        if (i != 0) {
            if (i != 2) {
                return;
            }
            ((i5) obj).b.v.setVisibility(0);
            return;
        }
        f5 f5Var = (f5) obj;
        f5Var.v.setVisibility(0);
        if (f5Var.v.getParent() instanceof View) {
            View view = (View) f5Var.v.getParent();
            WeakHashMap weakHashMap = qd1.a;
            view.requestApplyInsets();
        }
    }

    @Override // defpackage.le1
    public final void onAnimationEnd() {
        int i = this.G0;
        Object obj = this.o;
        if (i == 0) {
            f5 f5Var = (f5) obj;
            f5Var.v.setAlpha(1.0f);
            f5Var.y.d(null);
            f5Var.y = null;
            return;
        }
        if (i != 1) {
            f5 f5Var2 = ((i5) obj).b;
            f5Var2.v.setAlpha(1.0f);
            f5Var2.y.d(null);
            f5Var2.y = null;
            return;
        }
        f5 f5Var3 = (f5) ((g) obj).b;
        f5Var3.v.setVisibility(8);
        PopupWindow popupWindow = f5Var3.w;
        if (popupWindow != null) {
            popupWindow.dismiss();
        } else if (f5Var3.v.getParent() instanceof View) {
            View view = (View) f5Var3.v.getParent();
            WeakHashMap weakHashMap = qd1.a;
            view.requestApplyInsets();
        }
        f5Var3.v.h();
        f5Var3.y.d(null);
        f5Var3.y = null;
        ViewGroup viewGroup = f5Var3.B;
        WeakHashMap weakHashMap2 = qd1.a;
        viewGroup.requestApplyInsets();
    }
}
