package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import defpackage.ak;
import defpackage.ch;
import defpackage.h8;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Barrier extends a {
    public int o;
    public int p;
    public h8 q;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.a
    public final void j(AttributeSet attributeSet) {
        super.j(attributeSet);
        h8 h8Var = new h8();
        h8Var.s0 = new ch[4];
        h8Var.t0 = 0;
        h8Var.u0 = 0;
        h8Var.v0 = true;
        h8Var.w0 = 0;
        h8Var.x0 = false;
        this.q = h8Var;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, ak.o);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 26) {
                    this.o = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 25) {
                    this.q.v0 = typedArrayObtainStyledAttributes.getBoolean(index, true);
                } else if (index == 27) {
                    this.q.w0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f = this.q;
        l();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0012, code lost:
    
        if (r0 == 6) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
    
        if (r0 == 6) goto L9;
     */
    @Override // androidx.constraintlayout.widget.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(defpackage.ch r4, boolean r5) {
        /*
            r3 = this;
            int r0 = r3.o
            r3.p = r0
            r1 = 6
            r2 = 5
            if (r5 == 0) goto Le
            if (r0 != r2) goto Lb
            goto L14
        Lb:
            if (r0 != r1) goto L17
            goto L10
        Le:
            if (r0 != r2) goto L12
        L10:
            r5 = 0
            goto L15
        L12:
            if (r0 != r1) goto L17
        L14:
            r5 = 1
        L15:
            r3.p = r5
        L17:
            boolean r5 = r4 instanceof defpackage.h8
            if (r5 == 0) goto L21
            h8 r4 = (defpackage.h8) r4
            int r5 = r3.p
            r4.u0 = r5
        L21:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.Barrier.k(ch, boolean):void");
    }
}
