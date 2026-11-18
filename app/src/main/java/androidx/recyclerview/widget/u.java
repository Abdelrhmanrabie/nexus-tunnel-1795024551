package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    public final RecyclerView.o a;
    public int b = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
    public final Rect c = new Rect();

    public u(RecyclerView.o oVar) {
        this.a = oVar;
    }

    public static u a(RecyclerView.o oVar, int i) {
        if (i == 0) {
            return new s(oVar);
        }
        if (i == 1) {
            return new t(oVar);
        }
        defpackage.d.AnonymousClass0.m$2("invalid orientation");
        return null;
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m(View view);

    public abstract int n(View view);

    public abstract void o(int i);
}
