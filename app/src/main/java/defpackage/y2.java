package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.vpn.activities.IPHunterActivity;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class y2 extends RecyclerView.g {
    public final IPHunterActivity a;
    public final ArrayList b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends RecyclerView.d0 {
        public final TextView a;

        public a(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.attr.ns);
        }
    }

    public y2(IPHunterActivity iPHunterActivity, ArrayList arrayList) {
        this.a = iPHunterActivity;
        this.b = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final void onBindViewHolder(RecyclerView.d0 d0Var, int i) {
        ((a) d0Var).a.setText((CharSequence) this.b.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.a).inflate(R.layout.c9, viewGroup, false));
    }
}
