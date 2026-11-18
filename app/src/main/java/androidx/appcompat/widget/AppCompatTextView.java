package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import defpackage.a71;
import defpackage.ak;
import defpackage.d71;
import defpackage.e;
import defpackage.g;
import defpackage.g6;
import defpackage.i6;
import defpackage.j61;
import defpackage.t7;
import defpackage.ta1;
import defpackage.y4;
import defpackage.z61;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextView extends TextView implements d71, t7 {
    public final y4 mBackgroundTintHelper;
    public g mEmojiTextViewHelper;
    public boolean mIsSetTypefaceProcessing;
    public final g mTextClassifierHelper;
    public final g6 mTextHelper;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        z61.a(context);
        this.mIsSetTypefaceProcessing = false;
        j61.a(this, getContext());
        y4 y4Var = new y4(this);
        this.mBackgroundTintHelper = y4Var;
        y4Var.d(attributeSet, i);
        g6 g6Var = new g6(this);
        this.mTextHelper = g6Var;
        g6Var.d(attributeSet, i);
        g6Var.b();
        this.mTextClassifierHelper = new g(11, (Object) this, false);
        if (this.mEmojiTextViewHelper == null) {
            this.mEmojiTextViewHelper = new g((TextView) this);
        }
        this.mEmojiTextViewHelper.c(attributeSet, i);
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
    public final int getAutoSizeMaxTextSize() {
        if (t7.a) {
            return super.getAutoSizeMaxTextSize();
        }
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            return Math.round(g6Var.i.e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public final int getAutoSizeMinTextSize() {
        if (t7.a) {
            return super.getAutoSizeMinTextSize();
        }
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            return Math.round(g6Var.i.d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public final int getAutoSizeStepGranularity() {
        if (t7.a) {
            return super.getAutoSizeStepGranularity();
        }
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            return Math.round(g6Var.i.c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public final int[] getAutoSizeTextAvailableSizes() {
        if (t7.a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        g6 g6Var = this.mTextHelper;
        return g6Var != null ? g6Var.i.f : new int[0];
    }

    @Override // android.widget.TextView
    public final int getAutoSizeTextType() {
        if (t7.a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            return g6Var.i.a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public final ActionMode.Callback getCustomSelectionActionModeCallback() {
        return ak.e(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public final int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public final int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
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

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.getClass();
        g6.f(editorInfo, inputConnectionOnCreateInputConnection, this);
        e.g1(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        g6 g6Var = this.mTextHelper;
        if (g6Var == null || t7.a) {
            return;
        }
        g6Var.i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        g6 g6Var = this.mTextHelper;
        if (g6Var == null || t7.a) {
            return;
        }
        i6 i6Var = g6Var.i;
        if (!i6Var.h() || i6Var.a == 0) {
            return;
        }
        g6Var.i.a();
    }

    @Override // android.widget.TextView
    public final void setAllCaps(boolean z) {
        super.setAllCaps(z);
        if (this.mEmojiTextViewHelper == null) {
            this.mEmojiTextViewHelper = new g((TextView) this);
        }
        this.mEmojiTextViewHelper.d(z);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (t7.a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            g6Var.g(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (t7.a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            g6Var.h(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeWithDefaults(int i) {
        if (t7.a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            g6Var.i(i);
        }
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
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            g6Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            g6Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? e.s(context, i) : null, i2 != 0 ? e.s(context, i2) : null, i3 != 0 ? e.s(context, i3) : null, i4 != 0 ? e.s(context, i4) : null);
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            g6Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            g6Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? e.s(context, i) : null, i2 != 0 ? e.s(context, i2) : null, i3 != 0 ? e.s(context, i3) : null, i4 != 0 ? e.s(context, i4) : null);
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            g6Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            g6Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(ak.f(callback, this));
    }

    @Override // android.widget.TextView
    public final void setFilters(InputFilter[] inputFilterArr) {
        if (this.mEmojiTextViewHelper == null) {
            this.mEmojiTextViewHelper = new g((TextView) this);
        }
        super.setFilters(this.mEmojiTextViewHelper.a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public final void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            ak.b(this, i);
        }
    }

    @Override // android.widget.TextView
    public final void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            ak.c(this, i);
        }
    }

    @Override // android.widget.TextView
    public final void setLineHeight(int i) {
        e.C0(i);
        int fontMetricsInt = getPaint().getFontMetricsInt(null);
        if (i != fontMetricsInt) {
            setLineSpacing(i - fontMetricsInt, 1.0f);
        }
    }

    @Override // defpackage.d71
    public final void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        g6 g6Var = this.mTextHelper;
        if (g6Var.h == null) {
            g6Var.h = new a71();
        }
        a71 a71Var = g6Var.h;
        a71Var.a = colorStateList;
        a71Var.d = colorStateList != null;
        g6Var.b = a71Var;
        g6Var.c = a71Var;
        g6Var.d = a71Var;
        g6Var.e = a71Var;
        g6Var.f = a71Var;
        g6Var.g = a71Var;
        g6Var.b();
    }

    @Override // defpackage.d71
    public final void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        g6 g6Var = this.mTextHelper;
        if (g6Var.h == null) {
            g6Var.h = new a71();
        }
        a71 a71Var = g6Var.h;
        a71Var.b = mode;
        a71Var.c = mode != null;
        g6Var.b = a71Var;
        g6Var.c = a71Var;
        g6Var.d = a71Var;
        g6Var.e = a71Var;
        g6Var.f = a71Var;
        g6Var.g = a71Var;
        g6Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
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

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        boolean z = t7.a;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        g6 g6Var = this.mTextHelper;
        if (g6Var == null || z) {
            return;
        }
        i6 i6Var = g6Var.i;
        if (!i6Var.h() || i6Var.a == 0) {
            i6Var.e(i, f);
        }
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i) {
        Typeface typefaceCreate;
        if (this.mIsSetTypefaceProcessing) {
            return;
        }
        if (typeface == null || i <= 0) {
            typefaceCreate = null;
        } else {
            Context context = getContext();
            ak akVar = ta1.a;
            if (context == null) {
                defpackage.d.AnonymousClass0.m$2("Context cannot be null");
                return;
            }
            typefaceCreate = Typeface.create(typeface, i);
        }
        this.mIsSetTypefaceProcessing = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.mIsSetTypefaceProcessing = false;
        }
    }
}
