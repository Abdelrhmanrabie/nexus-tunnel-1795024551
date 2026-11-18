package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.j;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c5 implements j.a {
    public final /* synthetic */ int G0;
    public final Object a;
    public boolean f;

    public /* synthetic */ c5(int i, Object obj) {
        this.G0 = i;
        this.a = obj;
    }

    public /* synthetic */ c5(int i, Object obj, boolean z) {
        this.G0 = i;
        this.a = obj;
        this.f = z;
    }

    public void a() {
        ((CompoundButton) this.a).getButtonDrawable();
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean a(f fVar) {
        ((f71) this.a).b.onMenuOpened(108, fVar);
        return true;
    }

    public void b(AttributeSet attributeSet, int i) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = (CompoundButton) this.a;
        Context context = compoundButton.getContext();
        int[] iArr = b2.m;
        m6 m6VarM = m6.m(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) m6VarM.a;
        qd1.k(compoundButton, compoundButton.getContext(), iArr, attributeSet, (TypedArray) m6VarM.a, i);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(e.s(compoundButton.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        compoundButton.setButtonDrawable(e.s(compoundButton.getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                compoundButton.setButtonDrawable(e.s(compoundButton.getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                compoundButton.setButtonTintList(m6VarM.b(2));
            }
            if (typedArray.hasValue(3)) {
                compoundButton.setButtonTintMode(fp.d(typedArray.getInt(3, -1), null));
            }
        } finally {
            m6VarM.n();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0034  */
    public boolean b(CharSequence charSequence, int i) {
        boolean z = this.f;
        if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
            throw new IllegalArgumentException();
        }
        if (((e) this.a) != null) {
            char c = 0;
            c = 2;
            for (int i2 = 0; i2 < i && c == 2; i2++) {
                byte directionality = Character.getDirectionality(charSequence.charAt(i2));
                c5 c5Var = d61.a;
                if (directionality == 0) {
                    c = 1;
                } else if (directionality != 1 && directionality != 2) {
                    switch (directionality) {
                        case 14:
                        case 15:
                            c = 1;
                            break;
                        case 16:
                        case 17:
                            break;
                        default:
                            c = 2;
                            break;
                    }
                }
            }
            if (c == 0) {
                return true;
            }
            if (c == 1) {
                return false;
            }
        }
        return z;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void onCloseMenu(f fVar, boolean z) {
        if (this.f) {
            return;
        }
        this.f = true;
        f71 f71Var = (f71) this.a;
        f71Var.a.o();
        f71Var.b.onPanelClosed(108, fVar);
        this.f = false;
    }

    public String toString() {
        if (this.G0 != 4) {
            return super.toString();
        }
        return this.f ? "FALL_THROUGH" : String.valueOf(this.a);
    }
}
