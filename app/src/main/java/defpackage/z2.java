package defpackage;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.vpn.service.RenzOpenVPNservice;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class z2 extends RecyclerView.g {
    public final ArrayList a;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends RecyclerView.d0 {
        public final TextView a;

        public a(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.attr.pk);
        }
    }

    public z2(ArrayList arrayList) {
        this.a = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final void onBindViewHolder(RecyclerView.d0 d0Var, int i) {
        ((a) d0Var).a.setText(Html.fromHtml(((RenzOpenVPNservice.j) this.a.get(i)).a));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cp, viewGroup, false));
    }
}
