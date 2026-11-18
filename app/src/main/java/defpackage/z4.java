package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class z4 extends Button implements t7, d71 {
    public g mAppCompatEmojiTextHelper;
    public final y4 mBackgroundTintHelper;
    public final g6 mTextHelper;

    public z4(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.dd);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z4(Context context, AttributeSet attributeSet, int i) {
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
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new g((TextView) this);
        }
        this.mAppCompatEmojiTextHelper.c(attributeSet, i);
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

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        g6 g6Var = this.mTextHelper;
        if (g6Var == null || t7.a) {
            return;
        }
        g6Var.i.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
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
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new g((TextView) this);
        }
        this.mAppCompatEmojiTextHelper.d(z);
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
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var != null) {
            y4Var.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
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
    public final void setFilters(InputFilter[] inputFilterArr) {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new g((TextView) this);
        }
        super.setFilters(this.mAppCompatEmojiTextHelper.a(inputFilterArr));
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
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            g6Var.e(context, i);
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
}
