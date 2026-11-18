package defpackage;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class p5 extends EditText implements cn0 {
    public final g mAppCompatEmojiEditTextHelper;
    public final y4 mBackgroundTintHelper;
    public final i61 mDefaultOnReceiveContentListener;
    public final g mTextClassifierHelper;
    public final g6 mTextHelper;

    public p5(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.ka);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p5(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        z61.a(context);
        j61.a(this, getContext());
        y4 y4Var = new y4(this);
        this.mBackgroundTintHelper = y4Var;
        y4Var.d(attributeSet, i);
        g6 g6Var = new g6(this);
        this.mTextHelper = g6Var;
        g6Var.d(attributeSet, i);
        g6Var.b();
        this.mTextClassifierHelper = new g(11, (Object) this, false);
        this.mDefaultOnReceiveContentListener = new i61();
        g gVar = new g(this, 20);
        this.mAppCompatEmojiEditTextHelper = gVar;
        gVar.b(attributeSet, i);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = isFocusable();
        int inputType = super.getInputType();
        KeyListener keyListenerA = gVar.a(keyListener);
        if (keyListenerA == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerA);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var != null) {
            y4Var.a();
        }
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            g6Var.b();
        }
    }

    @Override // android.widget.TextView
    public final ActionMode.Callback getCustomSelectionActionModeCallback() {
        return ak.e(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    @Override // android.widget.TextView
    public final TextClassifier getTextClassifier() {
        g gVar;
        if (Build.VERSION.SDK_INT >= 28 || (gVar = this.mTextClassifierHelper) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) gVar.b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) ((TextView) gVar.a).getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0056 A[PHI: r1
      0x0056: PHI (r1v10 java.lang.String[]) = (r1v5 java.lang.String[]), (r1v11 java.lang.String[]) binds: [B:30:0x0069, B:22:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        int i;
        String[] strArrF;
        String[] stringArray;
        l20 l20Var;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.getClass();
        g6.f(editorInfo, inputConnectionOnCreateInputConnection, this);
        e.g1(editorInfo, inputConnectionOnCreateInputConnection, this);
        if (inputConnectionOnCreateInputConnection != null && (i = Build.VERSION.SDK_INT) <= 30 && (strArrF = qd1.f(this)) != null) {
            if (i >= 25) {
                editorInfo.contentMimeTypes = strArrF;
            } else {
                if (editorInfo.extras == null) {
                    editorInfo.extras = new Bundle();
                }
                editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArrF);
                editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArrF);
            }
            bj bjVar = new bj(13, this);
            if (i >= 25) {
                l20Var = new l20(inputConnectionOnCreateInputConnection, bjVar, 0);
            } else {
                String[] strArr = b2.f18a;
                if (i >= 25) {
                    stringArray = editorInfo.contentMimeTypes;
                    if (stringArray != null) {
                        strArr = stringArray;
                    }
                } else {
                    Bundle bundle = editorInfo.extras;
                    if (bundle != null) {
                        stringArray = bundle.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                        if (stringArray == null) {
                            stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                        }
                        if (stringArray != null) {
                            strArr = stringArray;
                        }
                    }
                }
                if (strArr.length != 0) {
                    l20Var = new l20(inputConnectionOnCreateInputConnection, bjVar, 1);
                }
            }
            inputConnectionOnCreateInputConnection = l20Var;
        }
        return this.mAppCompatEmojiEditTextHelper.c(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        int i = Build.VERSION.SDK_INT;
        if (i < 31 && i >= 24 && dragEvent.getLocalState() == null && qd1.f(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                toString();
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                activity.requestDragAndDropPermissions(dragEvent);
                int offsetForPosition = getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
                beginBatchEdit();
                try {
                    Selection.setSelection(getText(), offsetForPosition);
                    ClipData clipData = dragEvent.getClipData();
                    qd1.h(this, (Build.VERSION.SDK_INT >= 31 ? new bj(clipData, 3) : new mh$c(clipData, 3)).build());
                    return true;
                } finally {
                    endBatchEdit();
                }
            }
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // defpackage.cn0
    public final bj onReceiveContent(bj bjVar) {
        this.mDefaultOnReceiveContentListener.getClass();
        return i61.a(this, bjVar);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31 || qd1.f(this) == null || !(i == 16908322 || i == 16908337)) {
            return super.onTextContextMenuItem(i);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            mh$b bjVar = i2 >= 31 ? new bj(primaryClip, 1) : new mh$c(primaryClip, 1);
            bjVar.b(i == 16908322 ? 0 : 1);
            qd1.h(this, bjVar.build());
        }
        return true;
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var != null) {
            y4Var.e();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var != null) {
            y4Var.f(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(ak.f(callback, this));
    }

    @Override // android.widget.TextView
    public final void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.a(keyListener));
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            g6Var.e(context, i);
        }
    }

    @Override // android.widget.TextView
    public final void setTextClassifier(TextClassifier textClassifier) {
        g gVar;
        if (Build.VERSION.SDK_INT >= 28 || (gVar = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            gVar.b = textClassifier;
        }
    }
}
