package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import defpackage.ak;
import defpackage.vp0;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    public int T;
    public int U;
    public int V;
    public int W;
    public boolean X;
    public SeekBar Y;
    public TextView Z;
    public final boolean a0;
    public final boolean b0;
    public final boolean c0;
    public final a d0;
    public final b e0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (z && (seekBarPreference.c0 || !seekBarPreference.X)) {
                seekBarPreference.B(seekBar);
                return;
            }
            int i2 = i + seekBarPreference.U;
            TextView textView = seekBarPreference.Z;
            if (textView != null) {
                textView.setText(String.valueOf(i2));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.X = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            seekBarPreference.X = false;
            if (seekBar.getProgress() + seekBarPreference.U != seekBarPreference.T) {
                seekBarPreference.B(seekBar);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            SeekBar seekBar;
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.a0 && (i == 21 || i == 22)) || i == 23 || i == 66 || (seekBar = seekBarPreference.Y) == null) {
                return false;
            }
            return seekBar.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class c extends Preference.b {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public int b;
        public int c;
        public int d;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Parcelable.Creator<c> {
            @Override // android.os.Parcelable.Creator
            public final c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final c[] newArray(int i) {
                return new c[i];
            }
        }

        public c(Parcel parcel) {
            super(parcel);
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
        }

        public c(AbsSavedState absSavedState) {
            super(absSavedState);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.style.zn);
        this.d0 = new a();
        this.e0 = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ak.k, R.style.zn, 0);
        this.U = typedArrayObtainStyledAttributes.getInt(3, 0);
        int i = typedArrayObtainStyledAttributes.getInt(1, 100);
        int i2 = this.U;
        i = i < i2 ? i2 : i;
        if (i != this.V) {
            this.V = i;
            i();
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(4, 0);
        if (i3 != this.W) {
            this.W = Math.min(this.V - this.U, Math.abs(i3));
            i();
        }
        this.a0 = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.b0 = typedArrayObtainStyledAttributes.getBoolean(5, false);
        this.c0 = typedArrayObtainStyledAttributes.getBoolean(6, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void A(int i, boolean z) {
        int i2 = this.U;
        if (i < i2) {
            i = i2;
        }
        int i3 = this.V;
        if (i > i3) {
            i = i3;
        }
        if (i != this.T) {
            this.T = i;
            TextView textView = this.Z;
            if (textView != null) {
                textView.setText(String.valueOf(i));
            }
            if (z()) {
                int i4 = ~i;
                boolean z2 = z();
                String str = this.r;
                if (z2) {
                    i4 = this.c.d().getInt(str, i4);
                }
                if (i != i4) {
                    SharedPreferences.Editor editorB = this.c.b();
                    editorB.putInt(str, i);
                    if (!this.c.e) {
                        editorB.apply();
                    }
                }
            }
            if (z) {
                i();
            }
        }
    }

    public final void B(SeekBar seekBar) {
        int progress = seekBar.getProgress() + this.U;
        if (progress != this.T) {
            if (a(Integer.valueOf(progress))) {
                A(progress, false);
                return;
            }
            seekBar.setProgress(this.T - this.U);
            int i = this.T;
            TextView textView = this.Z;
            if (textView != null) {
                textView.setText(String.valueOf(i));
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void m(vp0 vp0Var) {
        super.m(vp0Var);
        vp0Var.itemView.setOnKeyListener(this.e0);
        this.Y = (SeekBar) vp0Var.a(R.attr.wn);
        TextView textView = (TextView) vp0Var.a(R.attr.wo);
        this.Z = textView;
        if (this.b0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.Z = null;
        }
        SeekBar seekBar = this.Y;
        if (seekBar == null) {
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.d0);
        this.Y.setMax(this.V - this.U);
        int i = this.W;
        SeekBar seekBar2 = this.Y;
        if (i != 0) {
            seekBar2.setKeyProgressIncrement(i);
        } else {
            this.W = seekBar2.getKeyProgressIncrement();
        }
        this.Y.setProgress(this.T - this.U);
        int i2 = this.T;
        TextView textView2 = this.Z;
        if (textView2 != null) {
            textView2.setText(String.valueOf(i2));
        }
        this.Y.setEnabled(h());
    }

    @Override // androidx.preference.Preference
    public final Object p(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    @Override // androidx.preference.Preference
    public final void q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(c.class)) {
            super.q(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.q(cVar.getSuperState());
        this.T = cVar.b;
        this.U = cVar.c;
        this.V = cVar.d;
        i();
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        this.P = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.x) {
            return absSavedState;
        }
        c cVar = new c(absSavedState);
        cVar.b = this.T;
        cVar.c = this.U;
        cVar.d = this.V;
        return cVar;
    }

    @Override // androidx.preference.Preference
    public final void s(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        int iIntValue = ((Integer) obj).intValue();
        if (z()) {
            iIntValue = this.c.d().getInt(this.r, iIntValue);
        }
        A(iIntValue, true);
    }
}
