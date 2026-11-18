package defpackage;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class vp0 extends RecyclerView.d0 {
    public final Drawable a;
    public final ColorStateList b;
    public final SparseArray c;
    public boolean d;
    public boolean e;

    public vp0(View view) {
        super(view);
        SparseArray sparseArray = new SparseArray(4);
        this.c = sparseArray;
        TextView textView = (TextView) view.findViewById(R.id.title);
        sparseArray.put(R.id.title, textView);
        sparseArray.put(R.id.summary, view.findViewById(R.id.summary));
        sparseArray.put(R.id.icon, view.findViewById(R.id.icon));
        sparseArray.put(org.hamotunnelplus.xyz.R.attr.md, view.findViewById(org.hamotunnelplus.xyz.R.attr.md));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
        this.a = view.getBackground();
        if (textView != null) {
            this.b = textView.getTextColors();
        }
    }

    public final View a(int i) {
        SparseArray sparseArray = this.c;
        View view = (View) sparseArray.get(i);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.itemView.findViewById(i);
        if (viewFindViewById != null) {
            sparseArray.put(i, viewFindViewById);
        }
        return viewFindViewById;
    }
}
