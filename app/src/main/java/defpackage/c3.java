package defpackage;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import org.hamotunnelplus.xyz.R;
import org.json.JSONException;
import org.json.JSONObject;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c3 extends RecyclerView.g {
    public final HamoTunnelPlusMain a;
    public final ArrayList b;
    public f00 c;
    public final ArrayList d;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends RecyclerView.d0 {
        public final TextView a;
        public final TextView b;
        public final ImageView d;
        public final View e;

        public a(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.attr.se);
            this.b = (TextView) view.findViewById(R.attr.sd);
            this.d = (ImageView) view.findViewById(R.attr.x5);
            this.e = view.findViewById(R.attr.oa);
        }
    }

    public c3(HamoTunnelPlusMain hamoTunnelPlusMain, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        this.d = arrayList2;
        this.a = hamoTunnelPlusMain;
        this.b = arrayList;
        arrayList2.addAll(arrayList);
    }

    public final void c(String str) {
        ArrayList arrayList = this.d;
        arrayList.clear();
        boolean zIsEmpty = str.isEmpty();
        ArrayList<JSONObject> arrayList2 = this.b;
        if (zIsEmpty) {
            arrayList.addAll(arrayList2);
        } else {
            String strTrim = str.toLowerCase().trim();
            for (JSONObject jSONObject : arrayList2) {
                try {
                    if (mc1.b(this.a, jSONObject.getString("Name")).toLowerCase().trim().contains(strTrim)) {
                        arrayList.add(jSONObject);
                    }
                } catch (JSONException unused) {
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final int getItemCount() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final void onBindViewHolder(RecyclerView.d0 d0Var, int i) {
        a aVar = (a) d0Var;
        HamoTunnelPlusMain hamoTunnelPlusMain = this.a;
        JSONObject jSONObject = (JSONObject) this.d.get(i);
        TextView textView = aVar.a;
        View view = aVar.itemView;
        view.setOnClickListener(new a3(this, jSONObject, 0));
        try {
            String strB = mc1.b(hamoTunnelPlusMain, jSONObject.getString("Info"));
            boolean zIsEmpty = strB.isEmpty();
            TextView textView2 = aVar.b;
            if (zIsEmpty) {
                strB = "No info added";
            }
            textView2.setText(strB);
            boolean zHas = jSONObject.has("Type");
            View view2 = aVar.e;
            if (zHas) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
            view2.setOnClickListener(new a3(this, jSONObject, 1));
            String strB2 = mc1.b(hamoTunnelPlusMain, jSONObject.getString("Name"));
            ig igVarH = ig.h(hamoTunnelPlusMain);
            igVarH.getClass();
            int i2 = igVarH.a.getInt(uh.a(-127273496902942L), 0);
            ImageView imageView = aVar.d;
            if (i == i2 && strB2.equalsIgnoreCase(ig.h(hamoTunnelPlusMain).i())) {
                view.findViewById(R.attr.s_).setForeground(hamoTunnelPlusMain.getResources().getDrawable(R.drawable.cu));
                imageView.setImageResource(R.drawable.fe);
            } else {
                imageView.setImageResource(R.drawable.kt);
                view.findViewById(R.attr.s_).setForeground(null);
            }
            textView.setText(Html.fromHtml(strB2));
            strB2.toLowerCase();
        } catch (Exception e) {
            Toast.makeText(hamoTunnelPlusMain, "Network Adapter" + e.getMessage(), 0).show();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.a).inflate(R.layout.e2, viewGroup, false));
    }
}
