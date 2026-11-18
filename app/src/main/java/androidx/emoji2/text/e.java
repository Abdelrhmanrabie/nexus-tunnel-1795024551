package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.SparseArray;
import android.view.KeyEvent;
import defpackage.cb1;
import defpackage.io0;
import defpackage.jq;
import defpackage.ph0;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final c.i a;
    public final g b;
    public final a c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a implements c.d {
        public static final ThreadLocal b = new ThreadLocal();
        public final TextPaint a;

        public a() {
            TextPaint textPaint = new TextPaint();
            this.a = textPaint;
            textPaint.setTextSize(10.0f);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class b {
        public int a = 1;
        public final g.a b;
        public g.a c;
        public g.a d;
        public int e;
        public int f;

        public b(g.a aVar) {
            this.b = aVar;
            this.c = aVar;
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0054  */
        public final int a(int i) {
            SparseArray sparseArray = this.c.a;
            g.a aVar = sparseArray == null ? null : (g.a) sparseArray.get(i);
            int i2 = this.a;
            g.a aVar2 = this.b;
            int i3 = 1;
            if (i2 == 2) {
                if (aVar != null) {
                    this.c = aVar;
                    this.f++;
                } else if (i == 65038) {
                    this.a = 1;
                    this.c = aVar2;
                    this.f = 0;
                } else if (i != 65039) {
                    g.a aVar3 = this.c;
                    if (aVar3.b == null) {
                        this.a = 1;
                        this.c = aVar2;
                        this.f = 0;
                    } else {
                        if (this.f == 1) {
                            if (c()) {
                                aVar3 = this.c;
                            } else {
                                this.a = 1;
                                this.c = aVar2;
                                this.f = 0;
                            }
                        }
                        this.d = aVar3;
                        this.a = 1;
                        this.c = aVar2;
                        this.f = 0;
                        i3 = 3;
                    }
                }
                i3 = 2;
            } else if (aVar == null) {
                this.a = 1;
                this.c = aVar2;
                this.f = 0;
            } else {
                this.a = 2;
                this.c = aVar;
                this.f = 1;
                i3 = 2;
            }
            this.e = i;
            return i3;
        }

        public final boolean c() {
            ph0 ph0VarC = this.c.b.c();
            int iA = ph0VarC.a(6);
            return !(iA == 0 || ((ByteBuffer) ph0VarC.b).get(iA + ph0VarC.a) == 0) || this.e == 65039;
        }
    }

    public e(g gVar, c.i iVar, a aVar) {
        this.a = iVar;
        this.b = gVar;
        this.c = aVar;
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z) {
        cb1[] cb1VarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (cb1VarArr = (cb1[]) editable.getSpans(selectionStart, selectionEnd, cb1.class)) != null && cb1VarArr.length > 0) {
                for (cb1 cb1Var : cb1VarArr) {
                    int spanStart = editable.getSpanStart(cb1Var);
                    int spanEnd = editable.getSpanEnd(cb1Var);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean b(CharSequence charSequence, int i, int i2, jq jqVar) {
        if (jqVar.c == 0) {
            a aVar = this.c;
            ph0 ph0VarC = jqVar.c();
            int iA = ph0VarC.a(8);
            if (iA != 0) {
                ((ByteBuffer) ph0VarC.b).getShort(iA + ph0VarC.a);
            }
            aVar.getClass();
            ThreadLocal threadLocal = a.b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i < i2) {
                sb.append(charSequence.charAt(i));
                i++;
            }
            TextPaint textPaint = aVar.a;
            String string = sb.toString();
            int i3 = io0.$r8$clinit;
            jqVar.c = textPaint.hasGlyph(string) ? 2 : 1;
        }
        return jqVar.c == 2;
    }
}
