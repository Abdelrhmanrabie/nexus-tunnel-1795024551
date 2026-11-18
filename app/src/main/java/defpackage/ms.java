package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.c;
import java.util.ArrayList;
import java.util.Iterator;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ms extends Preference {
    public final long T;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ms(Context context, ArrayList arrayList, long j) {
        super(context, null);
        CharSequence string = null;
        this.K = R.layout.bv;
        Context context2 = this.b;
        Drawable drawableS = e.s(context2, R.drawable.er);
        if (this.q != drawableS) {
            this.q = drawableS;
            this.p = 0;
            i();
        }
        this.p = R.drawable.er;
        String string2 = context2.getString(R.string.e9);
        if (!TextUtils.equals(string2, this.n)) {
            this.n = string2;
            i();
        }
        if (999 != this.j) {
            this.j = 999;
            c cVar = this.M;
            if (cVar != null) {
                Handler handler = cVar.e;
                c.a aVar = cVar.f;
                handler.removeCallbacks(aVar);
                handler.post(aVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Preference preference = (Preference) it.next();
            CharSequence charSequence = preference.n;
            boolean z = preference instanceof PreferenceGroup;
            if (z && !TextUtils.isEmpty(charSequence)) {
                arrayList2.add((PreferenceGroup) preference);
            }
            if (arrayList2.contains(preference.O)) {
                if (z) {
                    arrayList2.add((PreferenceGroup) preference);
                }
            } else if (!TextUtils.isEmpty(charSequence)) {
                string = string == null ? charSequence : this.b.getString(R.string.qp, string, charSequence);
            }
        }
        x(string);
        this.T = j + 1000000;
    }

    @Override // androidx.preference.Preference
    public final long d() {
        return this.T;
    }

    @Override // androidx.preference.Preference
    public final void m(vp0 vp0Var) {
        super.m(vp0Var);
        vp0Var.d = false;
    }
}
