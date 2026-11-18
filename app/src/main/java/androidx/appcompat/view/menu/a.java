package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements j {
    public final Context b;
    public Context c;
    public f d;
    public final LayoutInflater f;
    public j.a g;
    public final int i = R.layout.d;
    public final int j = R.layout.c;
    public k n;
    public int o;

    public a(Context context) {
        this.b = context;
        this.f = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean collapseItemActionView(h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean expandItemActionView(h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final int getId() {
        return this.o;
    }
}
