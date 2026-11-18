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
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    public final CharSequence[] Z;
    public final CharSequence[] a0;
    public String b0;
    public String c0;
    public boolean d0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0018a();
        public String b;

        /* JADX INFO: renamed from: androidx.preference.ListPreference$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class C0018a implements Parcelable.Creator<a> {
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
    public static final class b implements Preference.g<ListPreference> {
        public static b a;

        @Override // androidx.preference.Preference.g
        public final CharSequence a(Preference preference) {
            int length;
            ListPreference listPreference = (ListPreference) preference;
            CharSequence[] charSequenceArr = listPreference.Z;
            CharSequence[] charSequenceArr2 = listPreference.a0;
            String str = listPreference.b0;
            int i = -1;
            if (str == null || charSequenceArr2 == null) {
                length = -1;
                break;
            }
            length = charSequenceArr2.length - 1;
            while (true) {
                if (length < 0) {
                    length = -1;
                    break;
                }
                if (TextUtils.equals(charSequenceArr2[length].toString(), str)) {
                    break;
                }
                length--;
            }
            if (TextUtils.isEmpty((length < 0 || charSequenceArr == null) ? null : charSequenceArr[length])) {
                return listPreference.b.getString(R.string.jz);
            }
            String str2 = listPreference.b0;
            if (str2 != null && charSequenceArr2 != null) {
                for (int length2 = charSequenceArr2.length - 1; length2 >= 0; length2--) {
                    if (TextUtils.equals(charSequenceArr2[length2].toString(), str2)) {
                        i = length2;
                        break;
                    }
                }
            }
            if (i < 0 || charSequenceArr == null) {
                return null;
            }
            return charSequenceArr[i];
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ak.a(context, R.style.j7, android.R.attr.dialogPreferenceStyle));
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ak.e, i, 0);
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(2);
        this.Z = textArray == null ? typedArrayObtainStyledAttributes.getTextArray(0) : textArray;
        CharSequence[] textArray2 = typedArrayObtainStyledAttributes.getTextArray(3);
        this.a0 = textArray2 == null ? typedArrayObtainStyledAttributes.getTextArray(1) : textArray2;
        if (typedArrayObtainStyledAttributes.getBoolean(4, typedArrayObtainStyledAttributes.getBoolean(4, false))) {
            if (b.a == null) {
                b.a = new b();
            }
            this.R = b.a;
            i();
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, ak.g, i, 0);
        String string = typedArrayObtainStyledAttributes2.getString(33);
        this.c0 = string == null ? typedArrayObtainStyledAttributes2.getString(7) : string;
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void C(String str) {
        boolean zEquals = TextUtils.equals(this.b0, str);
        if (zEquals && this.d0) {
            return;
        }
        this.b0 = str;
        this.d0 = true;
        u(str);
        if (zEquals) {
            return;
        }
        i();
    }

    @Override // androidx.preference.Preference
    public final CharSequence g() {
        CharSequence[] charSequenceArr;
        CharSequence[] charSequenceArr2;
        Preference.g gVar = this.R;
        if (gVar != null) {
            return gVar.a(this);
        }
        String str = this.b0;
        int i = -1;
        if (str != null && (charSequenceArr2 = this.a0) != null) {
            for (int length = charSequenceArr2.length - 1; length >= 0; length--) {
                if (TextUtils.equals(charSequenceArr2[length].toString(), str)) {
                    i = length;
                    break;
                }
            }
        }
        CharSequence charSequence = (i < 0 || (charSequenceArr = this.Z) == null) ? null : charSequenceArr[i];
        CharSequence charSequenceG = super.g();
        String str2 = this.c0;
        if (str2 != null) {
            if (charSequence == null) {
                charSequence = AppConfig.CUSTOM;
            }
            String str3 = String.format(str2, charSequence);
            if (!TextUtils.equals(str3, charSequenceG)) {
                return str3;
            }
        }
        return charSequenceG;
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
        C(aVar.b);
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        this.P = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.x) {
            return absSavedState;
        }
        a aVar = new a(absSavedState);
        aVar.b = this.b0;
        return aVar;
    }

    @Override // androidx.preference.Preference
    public final void s(Object obj) {
        C(f((String) obj));
    }

    @Override // androidx.preference.Preference
    public final void x(CharSequence charSequence) {
        super.x(charSequence);
        this.c0 = charSequence == null ? null : ((String) charSequence).toString();
    }
}
