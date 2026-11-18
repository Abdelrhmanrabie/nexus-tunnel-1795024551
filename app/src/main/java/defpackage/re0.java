package defpackage;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class re0 implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ se0 b;

    public re0(se0 se0Var) {
        this.b = se0Var;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        jp jpVar;
        if (i == -1 || (jpVar = this.b.d) == null) {
            return;
        }
        jpVar.o = false;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
