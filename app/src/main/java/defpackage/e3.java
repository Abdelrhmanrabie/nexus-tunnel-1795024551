package defpackage;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import org.hamotunnelplus.xyz.R;
import org.json.JSONObject;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class e3 extends RecyclerView.g {
    public final HamoTunnelPlusMain a;
    public final ArrayList b;
    public f00 c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends RecyclerView.d0 {
        public final TextView a;
        public final ImageView b;
        public final TextView c;
        public final TextView d;
        public final ImageView e;

        public b(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.attr.xc);
            this.b = (ImageView) view.findViewById(R.attr.xa);
            this.c = (TextView) view.findViewById(R.attr.xt);
            this.d = (TextView) view.findViewById(R.attr.xb);
            this.e = (ImageView) view.findViewById(R.attr.x5);
        }
    }

    public e3(HamoTunnelPlusMain hamoTunnelPlusMain, ArrayList arrayList) {
        this.a = hamoTunnelPlusMain;
        this.b = arrayList;
    }

    public final Drawable c(String str) {
        try {
            return Drawable.createFromStream(this.a.getAssets().open("flags/flag_" + str + ".png"), null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final void onBindViewHolder(RecyclerView.d0 d0Var, int i) {
        b bVar = (b) d0Var;
        HamoTunnelPlusMain hamoTunnelPlusMain = this.a;
        TextView textView = bVar.a;
        TextView textView2 = bVar.c;
        View view = bVar.itemView;
        view.setOnClickListener(new d3(this, i));
        try {
            JSONObject jSONObject = (JSONObject) this.b.get(i);
            String strB = mc1.b(hamoTunnelPlusMain, jSONObject.getString("Name"));
            textView2.setText(mc1.b(hamoTunnelPlusMain, jSONObject.getString("Subname")));
            bVar.d.setText(strB.contains("Auto") ? "Auto" : new String[]{uh.a(-141275090287902L), uh.a(-141296565124382L), uh.a(-141313744993566L), uh.a(-141330924862750L), uh.a(-141356694666526L)}[jSONObject.getInt("Protocol")]);
            ig igVarH = ig.h(hamoTunnelPlusMain);
            igVarH.getClass();
            int i2 = igVarH.a.getInt(uh.a(-127054453570846L), 0);
            ImageView imageView = bVar.e;
            if (i == i2 && strB.equalsIgnoreCase(ig.h(hamoTunnelPlusMain).p())) {
                view.findViewById(R.attr.x4).setForeground(hamoTunnelPlusMain.getResources().getDrawable(R.drawable.cu));
                imageView.setImageResource(R.drawable.fe);
            } else {
                imageView.setImageResource(R.drawable.kt);
                view.findViewById(R.attr.x4).setForeground(null);
            }
            textView.setText(strB);
            Drawable drawableC = c(mc1.b(hamoTunnelPlusMain, jSONObject.getString("flag")));
            ImageView imageView2 = bVar.b;
            if (drawableC != null) {
                imageView2.setImageDrawable(drawableC);
            } else {
                imageView2.setImageResource(R.drawable.ic_app_icon);
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.a).inflate(R.layout.fa, viewGroup, false));
    }
}
