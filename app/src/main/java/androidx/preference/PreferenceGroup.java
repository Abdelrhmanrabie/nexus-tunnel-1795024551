package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import defpackage.ak;
import defpackage.o01;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    public final o01 T;
    public final ArrayList U;
    public boolean V;
    public int W;
    public boolean X;
    public int Y;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface a {
        int a(Preference preference);

        int b(String str);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b extends Preference.b {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public final int b;

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
            this.b = parcel.readInt();
        }

        public b(AbsSavedState absSavedState, int i) {
            super(absSavedState);
            this.b = i;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
        }
    }

    public PreferenceGroup() {
        throw null;
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.T = new o01();
        new Handler(Looper.getMainLooper());
        this.V = true;
        this.W = 0;
        this.X = false;
        this.Y = Integer.MAX_VALUE;
        this.U = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ak.i, i, 0);
        this.V = typedArrayObtainStyledAttributes.getBoolean(2, typedArrayObtainStyledAttributes.getBoolean(2, true));
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            int i2 = typedArrayObtainStyledAttributes.getInt(1, typedArrayObtainStyledAttributes.getInt(1, Integer.MAX_VALUE));
            if (i2 != Integer.MAX_VALUE) {
                TextUtils.isEmpty(this.r);
            }
            this.Y = i2;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final Preference A(CharSequence charSequence) {
        Preference preferenceA;
        if (charSequence == null) {
            defpackage.d.AnonymousClass0.m$2("Key cannot be null");
            return null;
        }
        if (TextUtils.equals(this.r, charSequence)) {
            return this;
        }
        int size = this.U.size();
        for (int i = 0; i < size; i++) {
            Preference preferenceB = B(i);
            if (TextUtils.equals(preferenceB.r, charSequence)) {
                return preferenceB;
            }
            if ((preferenceB instanceof PreferenceGroup) && (preferenceA = ((PreferenceGroup) preferenceB).A(charSequence)) != null) {
                return preferenceA;
            }
        }
        return null;
    }

    public final Preference B(int i) {
        return (Preference) this.U.get(i);
    }

    @Override // androidx.preference.Preference
    public final void b(Bundle bundle) {
        super.b(bundle);
        int size = this.U.size();
        for (int i = 0; i < size; i++) {
            B(i).b(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void c(Bundle bundle) {
        super.c(bundle);
        int size = this.U.size();
        for (int i = 0; i < size; i++) {
            B(i).c(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void j(boolean z) {
        super.j(z);
        int size = this.U.size();
        for (int i = 0; i < size; i++) {
            Preference preferenceB = B(i);
            if (preferenceB.B == z) {
                preferenceB.B = !z;
                preferenceB.j(preferenceB.y());
                preferenceB.i();
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void k() {
        super.k();
        this.X = true;
        int size = this.U.size();
        for (int i = 0; i < size; i++) {
            B(i).k();
        }
    }

    @Override // androidx.preference.Preference
    public final void o() {
        super.o();
        this.X = false;
        int size = this.U.size();
        for (int i = 0; i < size; i++) {
            B(i).o();
        }
    }

    @Override // androidx.preference.Preference
    public final void q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(b.class)) {
            super.q(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        this.Y = bVar.b;
        super.q(bVar.getSuperState());
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        this.P = true;
        return new b(AbsSavedState.EMPTY_STATE, this.Y);
    }
}
