package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import defpackage.ak;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {
    public final CharSequence[] Z;
    public final CharSequence[] a0;
    public final HashSet b0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0019a();
        public HashSet b;

        /* JADX INFO: renamed from: androidx.preference.MultiSelectListPreference$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class C0019a implements Parcelable.Creator<a> {
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
            int i = parcel.readInt();
            this.b = new HashSet();
            String[] strArr = new String[i];
            parcel.readStringArray(strArr);
            Collections.addAll(this.b, strArr);
        }

        public a(AbsSavedState absSavedState) {
            super(absSavedState);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b.size());
            HashSet hashSet = this.b;
            parcel.writeStringArray((String[]) hashSet.toArray(new String[hashSet.size()]));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        int iA = ak.a(context, R.style.j7, android.R.attr.dialogPreferenceStyle);
        super(context, attributeSet, iA);
        this.b0 = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ak.f, iA, 0);
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(2);
        this.Z = textArray == null ? typedArrayObtainStyledAttributes.getTextArray(0) : textArray;
        CharSequence[] textArray2 = typedArrayObtainStyledAttributes.getTextArray(3);
        this.a0 = textArray2 == null ? typedArrayObtainStyledAttributes.getTextArray(1) : textArray2;
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void A(Set set) {
        HashSet hashSet = this.b0;
        hashSet.clear();
        hashSet.addAll(set);
        if (z()) {
            boolean z = z();
            String str = this.r;
            if (!set.equals(z ? this.c.d().getStringSet(str, null) : null)) {
                SharedPreferences.Editor editorB = this.c.b();
                editorB.putStringSet(str, set);
                if (!this.c.e) {
                    editorB.apply();
                }
            }
        }
        i();
    }

    @Override // androidx.preference.Preference
    public final Object p(TypedArray typedArray, int i) {
        CharSequence[] textArray = typedArray.getTextArray(i);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
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
        aVar.b = this.b0;
        return aVar;
    }

    @Override // androidx.preference.Preference
    public final void s(Object obj) {
        Set<String> stringSet = (Set) obj;
        if (z()) {
            stringSet = this.c.d().getStringSet(this.r, stringSet);
        }
        A(stringSet);
    }
}
