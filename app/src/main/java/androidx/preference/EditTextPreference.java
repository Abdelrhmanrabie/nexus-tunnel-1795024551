package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import defpackage.ak;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    public String Z;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0017a();
        public String b;

        /* JADX INFO: renamed from: androidx.preference.EditTextPreference$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class C0017a implements Parcelable.Creator<a> {
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
            this.b = parcel.readString();
        }

        public a(AbsSavedState absSavedState) {
            super(absSavedState);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.b);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class b implements Preference.g<EditTextPreference> {
        public static b a;

        @Override // androidx.preference.Preference.g
        public final CharSequence a(Preference preference) {
            EditTextPreference editTextPreference = (EditTextPreference) preference;
            return TextUtils.isEmpty(editTextPreference.Z) ? editTextPreference.b.getString(R.string.jz) : editTextPreference.Z;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public EditTextPreference(Context context, AttributeSet attributeSet) {
        int iA = ak.a(context, R.style.k_, android.R.attr.editTextPreferenceStyle);
        super(context, attributeSet, iA);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ak.f8d, iA, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(0, typedArrayObtainStyledAttributes.getBoolean(0, false))) {
            if (b.a == null) {
                b.a = new b();
            }
            this.R = b.a;
            i();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void A(String str) {
        boolean zY = y();
        this.Z = str;
        u(str);
        boolean zY2 = y();
        if (zY2 != zY) {
            j(zY2);
        }
        i();
    }

    @Override // androidx.preference.Preference
    public final Object p(TypedArray typedArray, int i) {
        return typedArray.getString(i);
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
        aVar.b = this.Z;
        return aVar;
    }

    @Override // androidx.preference.Preference
    public final void s(Object obj) {
        A(f((String) obj));
    }

    @Override // androidx.preference.Preference
    public final boolean y() {
        return TextUtils.isEmpty(this.Z) || super.y();
    }
}
