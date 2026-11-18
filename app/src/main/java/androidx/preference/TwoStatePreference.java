package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    public boolean T;
    public String U;
    public String V;
    public boolean W;
    public boolean X;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0020a();
        public boolean b;

        /* JADX INFO: renamed from: androidx.preference.TwoStatePreference$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class C0020a implements Parcelable.Creator<a> {
            @Override // android.os.Parcelable.Creator
            public final a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final a[] newArray(int i) {
                return new a[i];
            }
        }

        public a(Parcel parcel) {
            super(parcel);
            this.b = parcel.readInt() == 1;
        }

        public a(AbsSavedState absSavedState) {
            super(absSavedState);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void A(boolean z) {
        boolean z2 = this.T != z;
        if (z2 || !this.W) {
            this.T = z;
            this.W = true;
            if (z()) {
                boolean z3 = !z;
                boolean z4 = z();
                String str = this.r;
                if (z4) {
                    z3 = this.c.d().getBoolean(str, z3);
                }
                if (z != z3) {
                    SharedPreferences.Editor editorB = this.c.b();
                    editorB.putBoolean(str, z);
                    if (!this.c.e) {
                        editorB.apply();
                    }
                }
            }
            if (z2) {
                j(y());
                i();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x002d  */
    /* JADX WARN: Code duplicated, block: B:20:0x0037  */
    /* JADX WARN: Code duplicated, block: B:23:0x003e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0046  */
    /* JADX WARN: Code duplicated, block: B:28:? A[RETURN, SYNTHETIC] */
    public final void B(View view) {
        boolean z;
        String str;
        int i;
        CharSequence charSequenceG;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (!this.T || TextUtils.isEmpty(this.U)) {
                if (this.T || TextUtils.isEmpty(this.V)) {
                    z = true;
                } else {
                    str = this.V;
                }
                if (z) {
                    charSequenceG = g();
                    if (!TextUtils.isEmpty(charSequenceG)) {
                        textView.setText(charSequenceG);
                        z = false;
                    }
                }
                i = z ? 8 : 0;
                if (i != textView.getVisibility()) {
                    textView.setVisibility(i);
                }
            }
            str = this.U;
            textView.setText(str);
            z = false;
            if (z) {
                charSequenceG = g();
                if (!TextUtils.isEmpty(charSequenceG)) {
                    textView.setText(charSequenceG);
                    z = false;
                }
            }
            if (z) {
            }
            if (i != textView.getVisibility()) {
                textView.setVisibility(i);
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void n() {
        boolean z = !this.T;
        if (a(Boolean.valueOf(z))) {
            A(z);
        }
    }

    @Override // androidx.preference.Preference
    public final Object p(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    @Override // androidx.preference.Preference
    public final void q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(a.class)) {
            super.q(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.q(aVar.getSuperState());
        A(aVar.b);
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        this.P = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.x) {
            return absSavedState;
        }
        a aVar = new a(absSavedState);
        aVar.b = this.T;
        return aVar;
    }

    @Override // androidx.preference.Preference
    public final void s(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (z()) {
            zBooleanValue = this.c.d().getBoolean(this.r, zBooleanValue);
        }
        A(zBooleanValue);
    }

    @Override // androidx.preference.Preference
    public final boolean y() {
        boolean z = this.X;
        boolean z2 = this.T;
        if (!z) {
            z2 = !z2;
        }
        return z2 || super.y();
    }
}
