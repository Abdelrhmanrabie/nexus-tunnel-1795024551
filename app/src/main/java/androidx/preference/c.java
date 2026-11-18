package androidx.preference;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.ak;
import defpackage.ms;
import defpackage.qd1;
import defpackage.vp0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c extends RecyclerView.g<vp0> implements Preference.c, PreferenceGroup.a {
    public final PreferenceGroup a;
    public ArrayList b;
    public ArrayList c;
    public final ArrayList d;
    public final a f = new a();
    public final Handler e = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.g();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b {
        public final int a;
        public final int b;
        public final String c;

        public b(Preference preference) {
            this.c = preference.getClass().getName();
            this.a = preference.K;
            this.b = preference.L;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && TextUtils.equals(this.c, bVar.c);
        }

        public final int hashCode() {
            return this.c.hashCode() + ((((this.a + 527) * 31) + this.b) * 31);
        }
    }

    public c(PreferenceGroup preferenceGroup) {
        this.a = preferenceGroup;
        preferenceGroup.M = this;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        boolean z = preferenceGroup instanceof PreferenceScreen ? ((PreferenceScreen) preferenceGroup).Z : true;
        if (this.mObservable.a()) {
            defpackage.d.AnonymousClass0.m("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            throw null;
        }
        this.mHasStableIds = z;
        g();
    }

    @Override // androidx.preference.PreferenceGroup.a
    public final int a(Preference preference) {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            Preference preference2 = (Preference) this.c.get(i);
            if (preference2 != null && preference2.equals(preference)) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.preference.PreferenceGroup.a
    public final int b(String str) {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(str, ((Preference) this.c.get(i)).r)) {
                return i;
            }
        }
        return -1;
    }

    public final ArrayList c(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = preferenceGroup.U.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Preference preferenceB = preferenceGroup.B(i2);
            if (preferenceB.C) {
                int i3 = preferenceGroup.Y;
                if (i3 == Integer.MAX_VALUE || i < i3) {
                    arrayList.add(preferenceB);
                } else {
                    arrayList2.add(preferenceB);
                }
                if (preferenceB instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceB;
                    if (preferenceGroup2 instanceof PreferenceScreen) {
                        continue;
                    } else {
                        if (preferenceGroup.Y != Integer.MAX_VALUE && preferenceGroup2.Y != Integer.MAX_VALUE) {
                            defpackage.d.AnonymousClass0.m("Nesting an expandable group inside of another expandable group is not supported!");
                            return null;
                        }
                        for (Preference preference : c(preferenceGroup2)) {
                            int i4 = preferenceGroup.Y;
                            if (i4 == Integer.MAX_VALUE || i < i4) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i++;
                        }
                    }
                } else {
                    i++;
                }
            }
        }
        int i5 = preferenceGroup.Y;
        if (i5 != Integer.MAX_VALUE && i > i5) {
            ms msVar = new ms(preferenceGroup.b, arrayList2, preferenceGroup.d);
            msVar.i = new d(this, preferenceGroup);
            arrayList.add(msVar);
        }
        return arrayList;
    }

    public final void d(PreferenceGroup preferenceGroup, ArrayList arrayList) {
        synchronized (preferenceGroup) {
            Collections.sort(preferenceGroup.U);
        }
        int size = preferenceGroup.U.size();
        for (int i = 0; i < size; i++) {
            Preference preferenceB = preferenceGroup.B(i);
            arrayList.add(preferenceB);
            b bVar = new b(preferenceB);
            if (!this.d.contains(bVar)) {
                this.d.add(bVar);
            }
            if (preferenceB instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceB;
                if (!(preferenceGroup2 instanceof PreferenceScreen)) {
                    d(preferenceGroup2, arrayList);
                }
            }
            preferenceB.M = this;
        }
    }

    public final Preference e(int i) {
        if (i < 0 || i >= this.c.size()) {
            return null;
        }
        return (Preference) this.c.get(i);
    }

    public final void g() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((Preference) it.next()).M = null;
        }
        ArrayList arrayList = new ArrayList(this.b.size());
        this.b = arrayList;
        PreferenceGroup preferenceGroup = this.a;
        d(preferenceGroup, arrayList);
        this.c = c(preferenceGroup);
        notifyDataSetChanged();
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            ((Preference) it2.next()).getClass();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final long getItemId(int i) {
        if (this.mHasStableIds) {
            return e(i).d();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final int getItemViewType(int i) {
        b bVar = new b(e(i));
        ArrayList arrayList = this.d;
        int iIndexOf = arrayList.indexOf(bVar);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = arrayList.size();
        arrayList.add(bVar);
        return size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final void onBindViewHolder(RecyclerView.d0 d0Var, int i) {
        ColorStateList colorStateList;
        vp0 vp0Var = (vp0) d0Var;
        Preference preferenceE = e(i);
        View view = vp0Var.itemView;
        Drawable background = view.getBackground();
        Drawable drawable = vp0Var.a;
        if (background != drawable) {
            WeakHashMap weakHashMap = qd1.a;
            view.setBackground(drawable);
        }
        TextView textView = (TextView) vp0Var.a(R.id.title);
        if (textView != null && (colorStateList = vp0Var.b) != null && !textView.getTextColors().equals(colorStateList)) {
            textView.setTextColor(colorStateList);
        }
        preferenceE.m(vp0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        b bVar = (b) this.d.get(i);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, ak.f3a);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = defpackage.e.s(viewGroup.getContext(), R.drawable.list_selector_background);
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = layoutInflaterFrom.inflate(bVar.a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            WeakHashMap weakHashMap = qd1.a;
            viewInflate.setBackground(drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.widget_frame);
        if (viewGroup2 != null) {
            int i2 = bVar.b;
            if (i2 != 0) {
                layoutInflaterFrom.inflate(i2, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new vp0(viewInflate);
    }
}
