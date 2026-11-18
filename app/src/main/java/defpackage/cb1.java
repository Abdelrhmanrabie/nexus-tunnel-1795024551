package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import androidx.emoji2.text.c;
import androidx.emoji2.text.g;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class cb1 extends ReplacementSpan {
    public final jq c;
    public final Paint.FontMetricsInt b = new Paint.FontMetricsInt();
    public float d = 1.0f;

    public cb1(jq jqVar) {
        if (jqVar != null) {
            this.c = jqVar;
        } else {
            d.AnonymousClass0.m$1("metadata cannot be null");
            throw null;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        c.a().getClass();
        jq jqVar = this.c;
        g gVar = jqVar.b;
        Typeface typeface = gVar.d;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText(gVar.b, jqVar.a * 2, 2, f, i4, paint);
        paint.setTypeface(typeface2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.b;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        jq jqVar = this.c;
        ph0 ph0VarC = jqVar.c();
        int iA = ph0VarC.a(14);
        this.d = fAbs / (iA != 0 ? ((ByteBuffer) ph0VarC.b).getShort(iA + ph0VarC.a) : (short) 0);
        ph0 ph0VarC2 = jqVar.c();
        int iA2 = ph0VarC2.a(14);
        if (iA2 != 0) {
            ((ByteBuffer) ph0VarC2.b).getShort(iA2 + ph0VarC2.a);
        }
        ph0 ph0VarC3 = jqVar.c();
        int iA3 = ph0VarC3.a(12);
        short s = (short) ((iA3 != 0 ? ((ByteBuffer) ph0VarC3.b).getShort(iA3 + ph0VarC3.a) : (short) 0) * this.d);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s;
    }
}
