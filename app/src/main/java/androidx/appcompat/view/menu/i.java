package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import defpackage.ih0;
import defpackage.qd1;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class i {
    public final Context a;
    public final f b;
    public final boolean c;
    public final int d;
    public final int e;
    public View f;
    public int g;
    public boolean h;
    public j.a i;
    public ih0 j;
    public PopupWindow.OnDismissListener k;
    public final a l;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            i.this.c();
        }
    }

    public i(int i, int i2, Context context, View view, f fVar, boolean z) {
        this.g = 8388611;
        this.l = new a();
        this.a = context;
        this.b = fVar;
        this.f = view;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    public i(Context context, f fVar, View view, boolean z) {
        this(R.style.ac, 0, context, view, fVar, z);
    }

    public final ih0 a() {
        if (this.j == null) {
            Context context = this.a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            int iMin = Math.min(point.x, point.y);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.w);
            Context context2 = this.a;
            View view = this.f;
            int i = this.e;
            boolean z = this.c;
            ih0 bVar = iMin >= dimensionPixelSize ? new b(context2, view, this.d, i, z) : new l(this.d, i, context2, view, this.b, z);
            bVar.b(this.b);
            bVar.h(this.l);
            bVar.d(this.f);
            bVar.setCallback(this.i);
            bVar.e(this.h);
            bVar.f(this.g);
            this.j = bVar;
        }
        return this.j;
    }

    public final boolean b() {
        ih0 ih0Var = this.j;
        return ih0Var != null && ih0Var.a();
    }

    public void c() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i, int i2, boolean z, boolean z2) {
        ih0 ih0VarA = a();
        ih0VarA.i(z2);
        if (z) {
            int i3 = this.g;
            View view = this.f;
            WeakHashMap weakHashMap = qd1.a;
            if ((Gravity.getAbsoluteGravity(i3, view.getLayoutDirection()) & 7) == 5) {
                i -= this.f.getWidth();
            }
            ih0VarA.g(i);
            ih0VarA.j(i2);
            int i4 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            ih0VarA.b = new Rect(i - i4, i2 - i4, i + i4, i2 + i4);
        }
        ih0VarA.show();
    }
}
