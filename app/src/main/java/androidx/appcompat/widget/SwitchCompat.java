package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import defpackage.ak;
import defpackage.b2;
import defpackage.bj;
import defpackage.fp;
import defpackage.g;
import defpackage.g6;
import defpackage.j61;
import defpackage.lq$c;
import defpackage.m6;
import defpackage.md1;
import defpackage.n3;
import defpackage.qd1;
import defpackage.ue1;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    public g mAppCompatEmojiTextHelper;
    public b mEmojiCompatInitCallback;
    public boolean mHasThumbTint;
    public final boolean mHasThumbTintMode;
    public boolean mHasTrackTint;
    public final boolean mHasTrackTintMode;
    public final int mMinFlingVelocity;
    public StaticLayout mOffLayout;
    public StaticLayout mOnLayout;
    public ObjectAnimator mPositionAnimator;
    public final boolean mShowText;
    public final boolean mSplitTrack;
    public int mSwitchBottom;
    public int mSwitchHeight;
    public int mSwitchLeft;
    public final int mSwitchMinWidth;
    public final int mSwitchPadding;
    public int mSwitchRight;
    public int mSwitchTop;
    public final n3 mSwitchTransformationMethod;
    public int mSwitchWidth;
    public final Rect mTempRect;
    public final ColorStateList mTextColors;
    public CharSequence mTextOff;
    public CharSequence mTextOffTransformed;
    public CharSequence mTextOn;
    public CharSequence mTextOnTransformed;
    public final TextPaint mTextPaint;
    public Drawable mThumbDrawable;
    public float mThumbPosition;
    public final int mThumbTextPadding;
    public ColorStateList mThumbTintList;
    public final PorterDuff.Mode mThumbTintMode;
    public int mThumbWidth;
    public int mTouchMode;
    public final int mTouchSlop;
    public float mTouchX;
    public float mTouchY;
    public Drawable mTrackDrawable;
    public ColorStateList mTrackTintList;
    public final PorterDuff.Mode mTrackTintMode;
    public final VelocityTracker mVelocityTracker;
    public static final a THUMB_POS = new a();
    public static final int[] CHECKED_STATE_SET = {R.attr.state_checked};

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a extends Property<SwitchCompat, Float> {
        public a() {
            super(Float.class, "thumbPos");
        }

        @Override // android.util.Property
        public final Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.mThumbPosition);
        }

        @Override // android.util.Property
        public final void set(SwitchCompat switchCompat, Float f) {
            SwitchCompat switchCompat2 = switchCompat;
            switchCompat2.mThumbPosition = f.floatValue();
            switchCompat2.invalidate();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b extends androidx.emoji2.text.c.e {
        public final WeakReference a;

        public b(SwitchCompat switchCompat) {
            this.a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.c.e
        public final void a() {
            SwitchCompat switchCompat = (SwitchCompat) this.a.get();
            if (switchCompat != null) {
                switchCompat.setTextOnInternal(switchCompat.mTextOn);
                switchCompat.setTextOffInternal(switchCompat.mTextOff);
                switchCompat.requestLayout();
            }
        }

        @Override // androidx.emoji2.text.c.e
        public final void b() {
            SwitchCompat switchCompat = (SwitchCompat) this.a.get();
            if (switchCompat != null) {
                switchCompat.setTextOnInternal(switchCompat.mTextOn);
                switchCompat.setTextOffInternal(switchCompat.mTextOff);
                switchCompat.requestLayout();
            }
        }
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, org.hamotunnelplus.xyz.R.style.a2a);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        Typeface typeface;
        int resourceId;
        super(context, attributeSet, i);
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTrackTintList = null;
        this.mTrackTintMode = null;
        this.mHasTrackTint = false;
        this.mHasTrackTintMode = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        j61.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = b2.x;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        m6 m6Var = new m6(context, typedArrayObtainStyledAttributes);
        qd1.k(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i);
        Drawable drawableE = m6Var.e(2);
        this.mThumbDrawable = drawableE;
        if (drawableE != null) {
            drawableE.setCallback(this);
        }
        Drawable drawableE2 = m6Var.e(11);
        this.mTrackDrawable = drawableE2;
        if (drawableE2 != null) {
            drawableE2.setCallback(this);
        }
        setTextOnInternal(typedArrayObtainStyledAttributes.getText(0));
        setTextOffInternal(typedArrayObtainStyledAttributes.getText(1));
        this.mShowText = typedArrayObtainStyledAttributes.getBoolean(3, true);
        this.mThumbTextPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.mSwitchMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.mSwitchPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.mSplitTrack = typedArrayObtainStyledAttributes.getBoolean(4, false);
        ColorStateList colorStateListB = m6Var.b(9);
        if (colorStateListB != null) {
            this.mThumbTintList = colorStateListB;
            this.mHasThumbTint = true;
        }
        PorterDuff.Mode modeD = fp.d(typedArrayObtainStyledAttributes.getInt(10, -1), null);
        if (modeD != null) {
            this.mThumbTintMode = modeD;
            this.mHasThumbTintMode = true;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            applyThumbTint();
        }
        ColorStateList colorStateListB2 = m6Var.b(12);
        if (colorStateListB2 != null) {
            this.mTrackTintList = colorStateListB2;
            this.mHasTrackTint = true;
        }
        PorterDuff.Mode modeD2 = fp.d(typedArrayObtainStyledAttributes.getInt(13, -1), null);
        if (modeD2 != null) {
            this.mTrackTintMode = modeD2;
            this.mHasTrackTintMode = true;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            applyTrackTint();
        }
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        if (resourceId2 != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId2, b2.y);
            ColorStateList colorStateList = (!typedArrayObtainStyledAttributes2.hasValue(3) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(3, 0)) == 0 || (colorStateList = b2.getColorStateList(context, resourceId)) == null) ? typedArrayObtainStyledAttributes2.getColorStateList(3) : colorStateList;
            this.mTextColors = colorStateList == null ? getTextColors() : colorStateList;
            int dimensionPixelSize = typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f = dimensionPixelSize;
                if (f != textPaint.getTextSize()) {
                    textPaint.setTextSize(f);
                    requestLayout();
                }
            }
            int i2 = typedArrayObtainStyledAttributes2.getInt(1, -1);
            int i3 = typedArrayObtainStyledAttributes2.getInt(2, -1);
            if (i2 == 1) {
                typeface = Typeface.SANS_SERIF;
            } else if (i2 != 2) {
                typeface = i2 != 3 ? null : Typeface.MONOSPACE;
            } else {
                typeface = Typeface.SERIF;
            }
            if (i3 > 0) {
                Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i3) : Typeface.create(typeface, i3);
                setSwitchTypeface(typefaceDefaultFromStyle);
                int i4 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i3;
                textPaint.setFakeBoldText((i4 & 1) != 0);
                textPaint.setTextSkewX((2 & i4) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            this.mSwitchTransformationMethod = typedArrayObtainStyledAttributes2.getBoolean(14, false) ? new n3(getContext()) : null;
            setTextOnInternal(this.mTextOn);
            setTextOffInternal(this.mTextOff);
            typedArrayObtainStyledAttributes2.recycle();
        }
        new g6(this).d(attributeSet, i);
        m6Var.n();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i);
        refreshDrawableState();
        setChecked(isChecked());
    }

    public final void applyThumbTint() {
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            boolean z = this.mHasThumbTint;
            boolean z2 = this.mHasThumbTintMode;
            if (z || z2) {
                Drawable drawableMutate = drawable.mutate();
                this.mThumbDrawable = drawableMutate;
                if (this.mHasThumbTint) {
                    drawableMutate.setTintList(this.mThumbTintList);
                }
                if (z2) {
                    this.mThumbDrawable.setTintMode(this.mThumbTintMode);
                }
                if (this.mThumbDrawable.isStateful()) {
                    this.mThumbDrawable.setState(getDrawableState());
                }
            }
        }
    }

    public final void applyTrackTint() {
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            boolean z = this.mHasTrackTint;
            boolean z2 = this.mHasTrackTintMode;
            if (z || z2) {
                Drawable drawableMutate = drawable.mutate();
                this.mTrackDrawable = drawableMutate;
                if (this.mHasTrackTint) {
                    drawableMutate.setTintList(this.mTrackTintList);
                }
                if (z2) {
                    this.mTrackDrawable.setTintMode(this.mTrackTintMode);
                }
                if (this.mTrackDrawable.isStateful()) {
                    this.mTrackDrawable.setState(getDrawableState());
                }
            }
        }
    }

    public final CharSequence doTransformForOnOffText(CharSequence charSequence) {
        g emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod transformationMethodE = this.mSwitchTransformationMethod;
        lq$c lq_c = (lq$c) ((bj) emojiTextViewHelper.b).a;
        lq_c.getClass();
        if (androidx.emoji2.text.c.j != null) {
            transformationMethodE = lq_c.a.e(transformationMethodE);
        }
        return transformationMethodE != null ? transformationMethodE.getTransformation(charSequence, this) : charSequence;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = this.mSwitchLeft;
        int i4 = this.mSwitchTop;
        int i5 = this.mSwitchRight;
        int i6 = this.mSwitchBottom;
        boolean zA = ue1.a(this);
        float f = this.mThumbPosition;
        if (zA) {
            f = 1.0f - f;
        }
        int thumbScrollRange = ((int) ((f * getThumbScrollRange()) + 0.5f)) + i3;
        Drawable drawable = this.mThumbDrawable;
        Rect rectC = drawable != null ? fp.c(drawable) : fp.c;
        Drawable drawable2 = this.mTrackDrawable;
        Rect rect = this.mTempRect;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i7 = rect.left;
            thumbScrollRange += i7;
            if (rectC != null) {
                int i8 = rectC.left;
                if (i8 > i7) {
                    i3 += i8 - i7;
                }
                int i9 = rectC.top;
                int i10 = rect.top;
                i = i9 > i10 ? (i9 - i10) + i4 : i4;
                int i11 = rectC.right;
                int i12 = rect.right;
                if (i11 > i12) {
                    i5 -= i11 - i12;
                }
                int i13 = rectC.bottom;
                int i14 = rect.bottom;
                if (i13 > i14) {
                    i2 = i6 - (i13 - i14);
                }
                this.mTrackDrawable.setBounds(i3, i, i5, i2);
            } else {
                i = i4;
            }
            i2 = i6;
            this.mTrackDrawable.setBounds(i3, i, i5, i2);
        }
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i15 = thumbScrollRange - rect.left;
            int i16 = thumbScrollRange + this.mThumbWidth + rect.right;
            this.mThumbDrawable.setBounds(i15, i4, i16, i6);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i15, i4, i16, i6);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setHotspot(f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mThumbDrawable;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public final int getCompoundPaddingLeft() {
        if (!ue1.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.mSwitchPadding : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public final int getCompoundPaddingRight() {
        if (ue1.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.mSwitchWidth;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.mSwitchPadding : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public final ActionMode.Callback getCustomSelectionActionModeCallback() {
        return ak.e(super.getCustomSelectionActionModeCallback());
    }

    public final g getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new g((TextView) this);
        }
        return this.mAppCompatEmojiTextHelper;
    }

    public final int getThumbScrollRange() {
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.mTempRect;
        drawable.getPadding(rect);
        Drawable drawable2 = this.mThumbDrawable;
        Rect rectC = drawable2 != null ? fp.c(drawable2) : fp.c;
        return ((((this.mSwitchWidth - this.mThumbWidth) - rect.left) - rect.right) - rectC.left) - rectC.right;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.mPositionAnimator.end();
        this.mPositionAnimator = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.mTrackDrawable;
        Rect rect = this.mTempRect;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.mSwitchTop;
        int i2 = this.mSwitchBottom;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable != null) {
            if (!this.mSplitTrack || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectC = fp.c(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectC.left;
                rect.right -= rectC.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = this.mThumbPosition > 0.5f ? this.mOnLayout : this.mOffLayout;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            TextPaint textPaint = this.mTextPaint;
            ColorStateList colorStateList = this.mTextColors;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i3 + i4) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.mTextOn : this.mTextOff;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iMax;
        int width;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z, i, i2, i3, i4);
        int iMax2 = 0;
        if (this.mThumbDrawable != null) {
            Drawable drawable = this.mTrackDrawable;
            Rect rect = this.mTempRect;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectC = fp.c(this.mThumbDrawable);
            iMax = Math.max(0, rectC.left - rect.left);
            iMax2 = Math.max(0, rectC.right - rect.right);
        } else {
            iMax = 0;
        }
        if (ue1.a(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.mSwitchWidth + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.mSwitchWidth) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i5 = this.mSwitchHeight;
            int i6 = height2 - (i5 / 2);
            height = i5 + i6;
            paddingTop = i6;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.mSwitchHeight + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.mSwitchHeight;
        }
        this.mSwitchLeft = paddingLeft;
        this.mSwitchTop = paddingTop;
        this.mSwitchBottom = height;
        this.mSwitchRight = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int iMax;
        boolean z = this.mShowText;
        int intrinsicHeight2 = 0;
        if (z) {
            StaticLayout staticLayout = this.mOnLayout;
            TextPaint textPaint = this.mTextPaint;
            if (staticLayout == null) {
                CharSequence charSequence = this.mTextOnTransformed;
                this.mOnLayout = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.mOffLayout == null) {
                CharSequence charSequence2 = this.mTextOffTransformed;
                this.mOffLayout = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.mThumbDrawable;
        Rect rect = this.mTempRect;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.mThumbDrawable.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.mThumbDrawable.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        if (z) {
            iMax = (this.mThumbTextPadding * 2) + Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth());
        } else {
            iMax = 0;
        }
        this.mThumbWidth = Math.max(iMax, intrinsicWidth);
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.mTrackDrawable.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax2 = rect.left;
        int iMax3 = rect.right;
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            Rect rectC = fp.c(drawable3);
            iMax2 = Math.max(iMax2, rectC.left);
            iMax3 = Math.max(iMax3, rectC.right);
        }
        int iMax4 = Math.max(this.mSwitchMinWidth, (this.mThumbWidth * 2) + iMax2 + iMax3);
        int iMax5 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.mSwitchWidth = iMax4;
        this.mSwitchHeight = iMax5;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < iMax5) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax5);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.mTextOn : this.mTextOff;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x008f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0096  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f3  */
    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        boolean z;
        boolean zIsChecked;
        boolean z2;
        float f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int i2 = this.mTouchSlop;
        float f2 = 1.0f;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (isEnabled() && this.mThumbDrawable != null) {
                boolean zA = ue1.a(this);
                float f3 = this.mThumbPosition;
                if (zA) {
                    f3 = 1.0f - f3;
                }
                int thumbScrollRange = (int) ((f3 * getThumbScrollRange()) + 0.5f);
                Drawable drawable = this.mThumbDrawable;
                Rect rect = this.mTempRect;
                drawable.getPadding(rect);
                int i3 = this.mSwitchTop - i2;
                int i4 = (this.mSwitchLeft + thumbScrollRange) - i2;
                int i5 = this.mThumbWidth + i4 + rect.left + rect.right + i2;
                int i6 = this.mSwitchBottom + i2;
                if (x > i4 && x < i5 && y > i3 && y < i6) {
                    this.mTouchMode = 1;
                    this.mTouchX = x;
                    this.mTouchY = y;
                }
            }
        } else if (actionMasked == 1) {
            i = this.mTouchMode;
            this.mTouchMode = 0;
            if (i == 2) {
                if (motionEvent.getAction() == 1 || !isEnabled()) {
                    z = false;
                } else {
                    z = true;
                }
                zIsChecked = isChecked();
                if (z) {
                    velocityTracker.computeCurrentVelocity(InternalZipConstants.AES_HASH_ITERATIONS);
                    float xVelocity = velocityTracker.getXVelocity();
                    z2 = Math.abs(xVelocity) > ((float) this.mMinFlingVelocity) ? this.mThumbPosition > 0.5f : !(!ue1.a(this) ? xVelocity > 0.0f : xVelocity < 0.0f);
                } else {
                    z2 = zIsChecked;
                }
                if (z2 != zIsChecked) {
                    playSoundEffect(0);
                }
                setChecked(z2);
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                motionEventObtain.setAction(3);
                super.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
                super.onTouchEvent(motionEvent);
                return true;
            }
            velocityTracker.clear();
        } else if (actionMasked == 2) {
            int i7 = this.mTouchMode;
            if (i7 == 1) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float f4 = i2;
                if (Math.abs(x2 - this.mTouchX) > f4 || Math.abs(y2 - this.mTouchY) > f4) {
                    this.mTouchMode = 2;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    this.mTouchX = x2;
                    this.mTouchY = y2;
                    return true;
                }
            } else if (i7 == 2) {
                float x3 = motionEvent.getX();
                int thumbScrollRange2 = getThumbScrollRange();
                float f5 = x3 - this.mTouchX;
                if (thumbScrollRange2 != 0) {
                    f = f5 / thumbScrollRange2;
                } else {
                    f = f5 > 0.0f ? 1.0f : -1.0f;
                }
                if (ue1.a(this)) {
                    f = -f;
                }
                float f6 = this.mThumbPosition;
                float f7 = f + f6;
                if (f7 < 0.0f) {
                    f2 = 0.0f;
                } else if (f7 <= 1.0f) {
                    f2 = f7;
                }
                if (f2 != f6) {
                    this.mTouchX = x3;
                    this.mThumbPosition = f2;
                    invalidate();
                }
                return true;
            }
        } else if (actionMasked == 3) {
            i = this.mTouchMode;
            this.mTouchMode = 0;
            if (i == 2) {
                if (motionEvent.getAction() == 1) {
                    z = false;
                } else {
                    z = false;
                }
                zIsChecked = isChecked();
                if (z) {
                    velocityTracker.computeCurrentVelocity(InternalZipConstants.AES_HASH_ITERATIONS);
                    float xVelocity2 = velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity2) > ((float) this.mMinFlingVelocity)) {
                    }
                } else {
                    z2 = zIsChecked;
                }
                if (z2 != zIsChecked) {
                    playSoundEffect(0);
                }
                setChecked(z2);
                MotionEvent motionEventObtain2 = MotionEvent.obtain(motionEvent);
                motionEventObtain2.setAction(3);
                super.onTouchEvent(motionEventObtain2);
                motionEventObtain2.recycle();
                super.onTouchEvent(motionEvent);
                return true;
            }
            velocityTracker.clear();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public final void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void setChecked(boolean z) {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            setOnStateDescriptionOnRAndAbove();
        } else {
            setOffStateDescriptionOnRAndAbove();
        }
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap = qd1.a;
            if (isLaidOut()) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, THUMB_POS, zIsChecked ? 1.0f : 0.0f);
                this.mPositionAnimator = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(250L);
                this.mPositionAnimator.setAutoCancel(true);
                this.mPositionAnimator.start();
                return;
            }
        }
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.mThumbPosition = zIsChecked ? 1.0f : 0.0f;
        invalidate();
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(ak.f(callback, this));
    }

    @Override // android.widget.TextView
    public final void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public final void setOffStateDescriptionOnRAndAbove() {
        if (Build.VERSION.SDK_INT >= 30) {
            Object string = this.mTextOff;
            if (string == null) {
                string = getResources().getString(org.hamotunnelplus.xyz.R.string.h);
            }
            WeakHashMap weakHashMap = qd1.a;
            new md1(2).e(this, string);
        }
    }

    public final void setOnStateDescriptionOnRAndAbove() {
        if (Build.VERSION.SDK_INT >= 30) {
            Object string = this.mTextOn;
            if (string == null) {
                string = getResources().getString(org.hamotunnelplus.xyz.R.string.i);
            }
            WeakHashMap weakHashMap = qd1.a;
            new md1(2).e(this, string);
        }
    }

    public final void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.mTextPaint;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public final void setTextOffInternal(CharSequence charSequence) {
        this.mTextOff = charSequence;
        this.mTextOffTransformed = doTransformForOnOffText(charSequence);
        this.mOffLayout = null;
        if (this.mShowText) {
            setupEmojiCompatLoadCallback();
        }
    }

    public final void setTextOnInternal(CharSequence charSequence) {
        this.mTextOn = charSequence;
        this.mTextOnTransformed = doTransformForOnOffText(charSequence);
        this.mOnLayout = null;
        if (this.mShowText) {
            setupEmojiCompatLoadCallback();
        }
    }

    public final void setupEmojiCompatLoadCallback() {
        if (this.mEmojiCompatInitCallback == null && ((lq$c) ((bj) this.mAppCompatEmojiTextHelper.b).a).a.c && androidx.emoji2.text.c.j != null) {
            androidx.emoji2.text.c cVarA = androidx.emoji2.text.c.a();
            int iB = cVarA.b();
            if (iB == 3 || iB == 0) {
                b bVar = new b(this);
                this.mEmojiCompatInitCallback = bVar;
                cVarA.g(bVar);
            }
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mThumbDrawable || drawable == this.mTrackDrawable;
    }
}
