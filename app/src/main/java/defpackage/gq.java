package defpackage;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import androidx.emoji2.text.c;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class gq extends InputConnectionWrapper {
    public final EditText a;
    public final e b;

    public gq(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        e eVar = new e(28);
        super(inputConnection, false);
        this.a = editText;
        this.b = eVar;
        if (c.j != null) {
            c cVarA = c.a();
            if (cVarA.b() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            c.a aVar = cVarA.e;
            aVar.getClass();
            Bundle bundle = editorInfo.extras;
            qh0 qh0Var = aVar.c.a;
            int iA = qh0Var.a(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", iA != 0 ? ((ByteBuffer) qh0Var.b).getInt(iA + qh0Var.a) : 0);
            Bundle bundle2 = editorInfo.extras;
            aVar.a.getClass();
            bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        Editable editableText = this.a.getEditableText();
        this.b.getClass();
        return e.a(this, editableText, i, i2, false) || super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        Editable editableText = this.a.getEditableText();
        this.b.getClass();
        return e.a(this, editableText, i, i2, true) || super.deleteSurroundingTextInCodePoints(i, i2);
    }
}
