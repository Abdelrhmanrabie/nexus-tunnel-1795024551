package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class wl$a implements Iterator, w90 {
    public int b = -1;
    public int c;
    public int d;
    public y20 f;
    public int g;
    public final /* synthetic */ et i;

    public wl$a(et etVar) {
        this.i = etVar;
        int length = ((CharSequence) etVar.a).length();
        if (length < 0) {
            throw new IllegalArgumentException(e.i(length, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
        }
        length = length >= 0 ? 0 : length;
        this.c = length;
        this.d = length;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001e  */
    /* JADX WARN: Code duplicated, block: B:12:0x0024  */
    /* JADX WARN: Code duplicated, block: B:13:0x0030  */
    /* JADX WARN: Code duplicated, block: B:15:0x0042  */
    /* JADX WARN: Code duplicated, block: B:17:0x0053  */
    /* JADX WARN: Code duplicated, block: B:19:0x0070  */
    public final void a() {
        jo0 jo0Var;
        y20 y20Var;
        int i = this.d;
        if (i < 0) {
            this.b = 0;
            this.f = null;
            return;
        }
        et etVar = this.i;
        int i2 = etVar.c;
        CharSequence charSequence = (CharSequence) etVar.a;
        if (i2 > 0) {
            int i3 = this.g + 1;
            this.g = i3;
            if (i3 < i2) {
                if (i > charSequence.length()) {
                    y20Var = new y20(this.c, q31.g0(charSequence), 1);
                } else {
                    jo0Var = (jo0) ((bx) etVar.b).invoke(charSequence, Integer.valueOf(this.d));
                    if (jo0Var == null) {
                        y20Var = new y20(this.c, charSequence.length() - 1, 1);
                    } else {
                        int iIntValue = ((Number) jo0Var.b).intValue();
                        int iIntValue2 = ((Number) jo0Var.c).intValue();
                        this.f = fz0.u(this.c, iIntValue);
                        int i4 = iIntValue + iIntValue2;
                        this.c = i4;
                        this.d = i4 + (iIntValue2 == 0 ? 1 : 0);
                    }
                }
                this.f = y20Var;
                this.d = -1;
            } else {
                y20Var = new y20(this.c, q31.g0(charSequence), 1);
                this.f = y20Var;
                this.d = -1;
            }
        } else {
            if (i > charSequence.length()) {
                y20Var = new y20(this.c, q31.g0(charSequence), 1);
            } else {
                jo0Var = (jo0) ((bx) etVar.b).invoke(charSequence, Integer.valueOf(this.d));
                if (jo0Var == null) {
                    y20Var = new y20(this.c, charSequence.length() - 1, 1);
                } else {
                    int iIntValue3 = ((Number) jo0Var.b).intValue();
                    int iIntValue4 = ((Number) jo0Var.c).intValue();
                    this.f = fz0.u(this.c, iIntValue3);
                    int i5 = iIntValue3 + iIntValue4;
                    this.c = i5;
                    this.d = i5 + (iIntValue4 == 0 ? 1 : 0);
                }
            }
            this.f = y20Var;
            this.d = -1;
        }
        this.b = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.b == -1) {
            a();
        }
        return this.b == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.b == -1) {
            a();
        }
        if (this.b == 0) {
            throw new NoSuchElementException();
        }
        y20 y20Var = this.f;
        this.f = null;
        this.b = -1;
        return y20Var;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
