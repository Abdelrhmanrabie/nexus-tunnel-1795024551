package androidx.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import defpackage.ak;
import defpackage.qd1;
import defpackage.vp0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    public boolean A;
    public boolean B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final boolean H;
    public final boolean I;
    public final boolean J;
    public int K;
    public final int L;
    public androidx.preference.c M;
    public ArrayList N;
    public PreferenceGroup O;
    public boolean P;
    public f Q;
    public g R;
    public final a S;
    public final Context b;
    public androidx.preference.e c;
    public long d;
    public boolean f;
    public d g;
    public androidx.preference.d i;
    public int j;
    public CharSequence n;
    public CharSequence o;
    public int p;
    public Drawable q;
    public final String r;
    public Intent s;
    public final String t;
    public Bundle u;
    public boolean v;
    public final boolean w;
    public final boolean x;
    public final String y;
    public final Object z;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Preference.this.t(view);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b extends AbsSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Parcelable.Creator<b> {
            @Override // android.os.Parcelable.Creator
            public final b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(Parcel parcel) {
            super(parcel);
        }

        public b(AbsSavedState absSavedState) {
            super(absSavedState);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface c {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface d {
        boolean a(Preference preference, Serializable serializable);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface e {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class f implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        public final Preference b;

        public f(Preference preference) {
            this.b = preference;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            Preference preference = this.b;
            CharSequence charSequenceG = preference.g();
            if (!preference.I || TextUtils.isEmpty(charSequenceG)) {
                return;
            }
            contextMenu.setHeaderTitle(charSequenceG);
            contextMenu.add(0, 0, 0, R.string.d3).setOnMenuItemClickListener(this);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            Preference preference = this.b;
            ClipboardManager clipboardManager = (ClipboardManager) preference.b.getSystemService("clipboard");
            CharSequence charSequenceG = preference.g();
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", charSequenceG));
            Context context = preference.b;
            Toast.makeText(context, context.getString(R.string.l1, charSequenceG), 0).show();
            return true;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface g<T extends Preference> {
        CharSequence a(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ak.a(context, R.style.x8, android.R.attr.preferenceStyle));
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0103 A[PHI: r7
      0x0103: PHI (r7v33 int) = (r7v32 int), (r7v47 int) binds: [B:18:0x00f8, B:21:0x0101] A[DONT_GENERATE, DONT_INLINE]] */
    public Preference(Context context, AttributeSet attributeSet, int i) {
        this.j = Integer.MAX_VALUE;
        this.v = true;
        this.w = true;
        this.x = true;
        this.A = true;
        this.B = true;
        this.C = true;
        this.D = true;
        this.E = true;
        this.G = true;
        this.J = true;
        this.K = R.layout.el;
        this.S = new a();
        this.b = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ak.g, i, 0);
        this.p = typedArrayObtainStyledAttributes.getResourceId(23, typedArrayObtainStyledAttributes.getResourceId(0, 0));
        String string = typedArrayObtainStyledAttributes.getString(26);
        this.r = string == null ? typedArrayObtainStyledAttributes.getString(6) : string;
        CharSequence text = typedArrayObtainStyledAttributes.getText(34);
        this.n = text == null ? typedArrayObtainStyledAttributes.getText(4) : text;
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(33);
        this.o = text2 == null ? typedArrayObtainStyledAttributes.getText(7) : text2;
        this.j = typedArrayObtainStyledAttributes.getInt(28, typedArrayObtainStyledAttributes.getInt(8, Integer.MAX_VALUE));
        String string2 = typedArrayObtainStyledAttributes.getString(22);
        this.t = string2 == null ? typedArrayObtainStyledAttributes.getString(13) : string2;
        this.K = typedArrayObtainStyledAttributes.getResourceId(27, typedArrayObtainStyledAttributes.getResourceId(3, R.layout.el));
        this.L = typedArrayObtainStyledAttributes.getResourceId(35, typedArrayObtainStyledAttributes.getResourceId(9, 0));
        this.v = typedArrayObtainStyledAttributes.getBoolean(21, typedArrayObtainStyledAttributes.getBoolean(2, true));
        boolean z = typedArrayObtainStyledAttributes.getBoolean(30, typedArrayObtainStyledAttributes.getBoolean(5, true));
        this.w = z;
        this.x = typedArrayObtainStyledAttributes.getBoolean(29, typedArrayObtainStyledAttributes.getBoolean(1, true));
        String string3 = typedArrayObtainStyledAttributes.getString(19);
        this.y = string3 == null ? typedArrayObtainStyledAttributes.getString(10) : string3;
        this.D = typedArrayObtainStyledAttributes.getBoolean(16, typedArrayObtainStyledAttributes.getBoolean(16, z));
        this.E = typedArrayObtainStyledAttributes.getBoolean(17, typedArrayObtainStyledAttributes.getBoolean(17, z));
        int i2 = 18;
        if (typedArrayObtainStyledAttributes.hasValue(18)) {
            this.z = p(typedArrayObtainStyledAttributes, i2);
        } else {
            i2 = 11;
            if (typedArrayObtainStyledAttributes.hasValue(11)) {
                this.z = p(typedArrayObtainStyledAttributes, i2);
            }
        }
        this.J = typedArrayObtainStyledAttributes.getBoolean(31, typedArrayObtainStyledAttributes.getBoolean(12, true));
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(32);
        this.F = zHasValue;
        if (zHasValue) {
            this.G = typedArrayObtainStyledAttributes.getBoolean(32, typedArrayObtainStyledAttributes.getBoolean(14, true));
        }
        this.H = typedArrayObtainStyledAttributes.getBoolean(24, typedArrayObtainStyledAttributes.getBoolean(15, false));
        this.C = typedArrayObtainStyledAttributes.getBoolean(25, typedArrayObtainStyledAttributes.getBoolean(25, true));
        this.I = typedArrayObtainStyledAttributes.getBoolean(20, typedArrayObtainStyledAttributes.getBoolean(20, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void w(View view, boolean z) {
        view.setEnabled(z);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                return;
            } else {
                w(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public final boolean a(Serializable serializable) {
        d dVar = this.g;
        return dVar == null || dVar.a(this, serializable);
    }

    public void b(Bundle bundle) {
        Parcelable parcelable;
        String str = this.r;
        if (TextUtils.isEmpty(str) || (parcelable = bundle.getParcelable(str)) == null) {
            return;
        }
        this.P = false;
        q(parcelable);
        if (this.P) {
            return;
        }
        defpackage.d.AnonymousClass0.m("Derived class did not call super.onRestoreInstanceState()");
    }

    public void c(Bundle bundle) {
        String str = this.r;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.P = false;
        Parcelable parcelableR = r();
        if (!this.P) {
            defpackage.d.AnonymousClass0.m("Derived class did not call super.onSaveInstanceState()");
        } else if (parcelableR != null) {
            bundle.putParcelable(str, parcelableR);
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i = this.j;
        int i2 = preference2.j;
        if (i != i2) {
            return i - i2;
        }
        CharSequence charSequence = this.n;
        CharSequence charSequence2 = preference2.n;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference2.n.toString());
    }

    public long d() {
        return this.d;
    }

    public final String f(String str) {
        return !z() ? str : this.c.d().getString(this.r, str);
    }

    public CharSequence g() {
        g gVar = this.R;
        return gVar != null ? gVar.a(this) : this.o;
    }

    public boolean h() {
        return this.v && this.A && this.B;
    }

    public void i() {
        int iIndexOf;
        androidx.preference.c cVar = this.M;
        if (cVar == null || (iIndexOf = cVar.c.indexOf(this)) == -1) {
            return;
        }
        cVar.mObservable.d(iIndexOf, this);
    }

    public void j(boolean z) {
        ArrayList arrayList = this.N;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Preference preference = (Preference) arrayList.get(i);
            if (preference.A == z) {
                preference.A = !z;
                preference.j(preference.y());
                preference.i();
            }
        }
    }

    public void k() {
        PreferenceScreen preferenceScreen;
        String str = this.y;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        androidx.preference.e eVar = this.c;
        Preference preferenceA = (eVar == null || (preferenceScreen = eVar.g) == null) ? null : preferenceScreen.A(str);
        if (preferenceA == null) {
            StringBuilder sbQ = ak.q("Dependency \"", str, "\" not found for preference \"");
            sbQ.append(this.r);
            sbQ.append("\" (title: \"");
            sbQ.append((Object) this.n);
            sbQ.append("\"");
            throw new IllegalStateException(sbQ.toString());
        }
        if (preferenceA.N == null) {
            preferenceA.N = new ArrayList();
        }
        preferenceA.N.add(this);
        boolean zY = preferenceA.y();
        if (this.A == zY) {
            this.A = !zY;
            j(y());
            i();
        }
    }

    public final void l(androidx.preference.e eVar) {
        this.c = eVar;
        if (!this.f) {
            this.d = eVar.c();
        }
        if (z()) {
            androidx.preference.e eVar2 = this.c;
            if ((eVar2 != null ? eVar2.d() : null).contains(this.r)) {
                s(null);
                return;
            }
        }
        Object obj = this.z;
        if (obj != null) {
            s(obj);
        }
    }

    public void m(vp0 vp0Var) {
        Integer numValueOf;
        View view = vp0Var.itemView;
        view.setOnClickListener(this.S);
        view.setId(0);
        TextView textView = (TextView) vp0Var.a(android.R.id.summary);
        if (textView != null) {
            CharSequence charSequenceG = g();
            if (TextUtils.isEmpty(charSequenceG)) {
                textView.setVisibility(8);
                numValueOf = null;
            } else {
                textView.setText(charSequenceG);
                textView.setVisibility(0);
                numValueOf = Integer.valueOf(textView.getCurrentTextColor());
            }
        } else {
            numValueOf = null;
        }
        TextView textView2 = (TextView) vp0Var.a(android.R.id.title);
        boolean z = this.w;
        if (textView2 != null) {
            CharSequence charSequence = this.n;
            if (TextUtils.isEmpty(charSequence)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequence);
                textView2.setVisibility(0);
                if (this.F) {
                    textView2.setSingleLine(this.G);
                }
                if (!z && h() && numValueOf != null) {
                    textView2.setTextColor(numValueOf.intValue());
                }
            }
        }
        ImageView imageView = (ImageView) vp0Var.a(android.R.id.icon);
        boolean z2 = this.H;
        if (imageView != null) {
            int i = this.p;
            if (i != 0 || this.q != null) {
                if (this.q == null) {
                    this.q = defpackage.e.s(this.b, i);
                }
                Drawable drawable = this.q;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.q != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(z2 ? 4 : 8);
            }
        }
        View viewA = vp0Var.a(R.attr.md);
        if (viewA == null) {
            viewA = vp0Var.a(android.R.id.icon_frame);
        }
        if (viewA != null) {
            if (this.q != null) {
                viewA.setVisibility(0);
            } else {
                viewA.setVisibility(z2 ? 4 : 8);
            }
        }
        w(view, this.J ? h() : true);
        view.setFocusable(z);
        view.setClickable(z);
        vp0Var.d = this.D;
        vp0Var.e = this.E;
        boolean z3 = this.I;
        if (z3 && this.Q == null) {
            this.Q = new f(this);
        }
        view.setOnCreateContextMenuListener(z3 ? this.Q : null);
        view.setLongClickable(z3);
        if (!z3 || z) {
            return;
        }
        WeakHashMap weakHashMap = qd1.a;
        view.setBackground(null);
    }

    public void n() {
    }

    public void o() {
        ArrayList arrayList;
        PreferenceScreen preferenceScreen;
        String str = this.y;
        if (str != null) {
            androidx.preference.e eVar = this.c;
            Preference preferenceA = (eVar == null || (preferenceScreen = eVar.g) == null) ? null : preferenceScreen.A(str);
            if (preferenceA == null || (arrayList = preferenceA.N) == null) {
                return;
            }
            arrayList.remove(this);
        }
    }

    public Object p(TypedArray typedArray, int i) {
        return null;
    }

    public void q(Parcelable parcelable) {
        this.P = true;
        if (parcelable == AbsSavedState.EMPTY_STATE || parcelable == null) {
            return;
        }
        defpackage.d.AnonymousClass0.m$2("Wrong state class -- expecting Preference State");
    }

    public Parcelable r() {
        this.P = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public void s(Object obj) {
    }

    public void t(View view) {
        Intent intent;
        androidx.preference.b bVar;
        if (h() && this.w) {
            n();
            androidx.preference.d dVar = this.i;
            if (dVar != null) {
                dVar.a.Y = Integer.MAX_VALUE;
                androidx.preference.c cVar = dVar.b;
                Handler handler = cVar.e;
                androidx.preference.c.a aVar = cVar.f;
                handler.removeCallbacks(aVar);
                handler.post(aVar);
                return;
            }
            androidx.preference.e eVar = this.c;
            if ((eVar == null || (bVar = eVar.h) == null || !bVar.onPreferenceTreeClick(this)) && (intent = this.s) != null) {
                this.b.startActivity(intent);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.n;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence charSequenceG = g();
        if (!TextUtils.isEmpty(charSequenceG)) {
            sb.append(charSequenceG);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public final void u(String str) {
        if (z() && !TextUtils.equals(str, f(null))) {
            SharedPreferences.Editor editorB = this.c.b();
            editorB.putString(this.r, str);
            if (this.c.e) {
                return;
            }
            editorB.apply();
        }
    }

    public final void v(boolean z) {
        if (this.v != z) {
            this.v = z;
            j(y());
            i();
        }
    }

    public void x(CharSequence charSequence) {
        if (this.R != null) {
            defpackage.d.AnonymousClass0.m("Preference already has a SummaryProvider set.");
        } else {
            if (TextUtils.equals(this.o, charSequence)) {
                return;
            }
            this.o = charSequence;
            i();
        }
    }

    public boolean y() {
        return !h();
    }

    public final boolean z() {
        return (this.c == null || !this.x || TextUtils.isEmpty(this.r)) ? false : true;
    }
}
