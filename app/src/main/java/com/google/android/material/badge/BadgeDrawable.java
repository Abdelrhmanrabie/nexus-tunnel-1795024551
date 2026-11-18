package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import defpackage.qd1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    public WeakReference anchorViewRef;
    public final Rect badgeBounds;
    public float badgeCenterX;
    public float badgeCenterY;
    public final float badgeRadius;
    public final float badgeWidePadding;
    public final float badgeWithTextRadius;
    public final WeakReference contextRef;
    public float cornerRadius;
    public WeakReference customBadgeParentRef;
    public float halfBadgeHeight;
    public float halfBadgeWidth;
    public int maxBadgeNumber;
    public final SavedState savedState;
    public final MaterialShapeDrawable shapeDrawable;
    public final TextDrawableHelper textDrawableHelper;

    /* JADX INFO: renamed from: com.google.android.material.badge.BadgeDrawable$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    class AnonymousClass1 implements Runnable {
        public final /* synthetic */ View val$anchorView;
        public final /* synthetic */ FrameLayout val$frameLayout;

        public AnonymousClass1(View view, FrameLayout frameLayout) {
            this.val$anchorView = view;
            this.val$frameLayout = frameLayout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BadgeDrawable.this.updateBadgeCoordinates(this.val$anchorView, this.val$frameLayout);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.material.badge.BadgeDrawable.SavedState.1
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int additionalHorizontalOffset;
        public int additionalVerticalOffset;
        public int alpha;
        public int backgroundColor;
        public int badgeGravity;
        public int badgeTextColor;
        public final int contentDescriptionExceedsMaxBadgeNumberRes;
        public final String contentDescriptionNumberless;
        public final int contentDescriptionQuantityStrings;
        public int horizontalOffsetWithText;
        public int horizontalOffsetWithoutText;
        public boolean isVisible;
        public int maxCharacterCount;
        public int number;
        public int verticalOffsetWithText;
        public int verticalOffsetWithoutText;

        public SavedState(Context context) {
            this.alpha = 255;
            this.number = -1;
            this.badgeTextColor = new TextAppearance(context, R.plurals.oc).textColor.getDefaultColor();
            this.contentDescriptionNumberless = context.getString(R.string.in);
            this.contentDescriptionQuantityStrings = R.plurals.e_res_0x7f100004;
            this.contentDescriptionExceedsMaxBadgeNumberRes = R.string.ip;
            this.isVisible = true;
        }

        public SavedState(Parcel parcel) {
            this.alpha = 255;
            this.number = -1;
            this.backgroundColor = parcel.readInt();
            this.badgeTextColor = parcel.readInt();
            this.alpha = parcel.readInt();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = parcel.readInt();
            this.horizontalOffsetWithoutText = parcel.readInt();
            this.verticalOffsetWithoutText = parcel.readInt();
            this.horizontalOffsetWithText = parcel.readInt();
            this.verticalOffsetWithText = parcel.readInt();
            this.additionalHorizontalOffset = parcel.readInt();
            this.additionalVerticalOffset = parcel.readInt();
            this.isVisible = parcel.readInt() != 0;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.backgroundColor);
            parcel.writeInt(this.badgeTextColor);
            parcel.writeInt(this.alpha);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            parcel.writeString(this.contentDescriptionNumberless.toString());
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeInt(this.badgeGravity);
            parcel.writeInt(this.horizontalOffsetWithoutText);
            parcel.writeInt(this.verticalOffsetWithoutText);
            parcel.writeInt(this.horizontalOffsetWithText);
            parcel.writeInt(this.verticalOffsetWithText);
            parcel.writeInt(this.additionalHorizontalOffset);
            parcel.writeInt(this.additionalVerticalOffset);
            parcel.writeInt(this.isVisible ? 1 : 0);
        }
    }

    private BadgeDrawable(Context context) {
        TextAppearance textAppearance;
        Context context2;
        WeakReference weakReference = new WeakReference(context);
        this.contextRef = weakReference;
        ThemeEnforcement.checkTheme(context, ThemeEnforcement.MATERIAL_CHECK_ATTRS, "Theme.MaterialComponents");
        Resources resources = context.getResources();
        this.badgeBounds = new Rect();
        this.shapeDrawable = new MaterialShapeDrawable();
        this.badgeRadius = resources.getDimensionPixelSize(R.dimen.jg);
        this.badgeWidePadding = resources.getDimensionPixelSize(R.dimen.jf);
        this.badgeWithTextRadius = resources.getDimensionPixelSize(R.dimen.jl);
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        textDrawableHelper.textPaint.setTextAlign(Paint.Align.CENTER);
        this.savedState = new SavedState(context);
        Context context3 = (Context) weakReference.get();
        if (context3 == null || textDrawableHelper.textAppearance == (textAppearance = new TextAppearance(context3, R.plurals.oc)) || (context2 = (Context) weakReference.get()) == null) {
            return;
        }
        textDrawableHelper.setTextAppearance(textAppearance, context2);
        updateCenterAndBounds();
    }

    public static BadgeDrawable createFromSavedState(Context context, SavedState savedState) {
        int iMax;
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        int i = savedState.maxCharacterCount;
        SavedState savedState2 = badgeDrawable.savedState;
        int i2 = savedState2.maxCharacterCount;
        TextDrawableHelper textDrawableHelper = badgeDrawable.textDrawableHelper;
        if (i2 != i) {
            savedState2.maxCharacterCount = i;
            badgeDrawable.maxBadgeNumber = ((int) Math.pow(10.0d, ((double) i) - 1.0d)) - 1;
            textDrawableHelper.textWidthDirty = true;
            badgeDrawable.updateCenterAndBounds();
            badgeDrawable.invalidateSelf();
        }
        int i3 = savedState.number;
        if (i3 != -1 && savedState2.number != (iMax = Math.max(0, i3))) {
            savedState2.number = iMax;
            textDrawableHelper.textWidthDirty = true;
            badgeDrawable.updateCenterAndBounds();
            badgeDrawable.invalidateSelf();
        }
        int i4 = savedState.backgroundColor;
        savedState2.backgroundColor = i4;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i4);
        MaterialShapeDrawable materialShapeDrawable = badgeDrawable.shapeDrawable;
        if (materialShapeDrawable.getFillColor() != colorStateListValueOf) {
            materialShapeDrawable.setFillColor(colorStateListValueOf);
            badgeDrawable.invalidateSelf();
        }
        int i5 = savedState.badgeTextColor;
        savedState2.badgeTextColor = i5;
        if (textDrawableHelper.textPaint.getColor() != i5) {
            textDrawableHelper.textPaint.setColor(i5);
            badgeDrawable.invalidateSelf();
        }
        int i6 = savedState.badgeGravity;
        if (savedState2.badgeGravity != i6) {
            savedState2.badgeGravity = i6;
            WeakReference weakReference = badgeDrawable.anchorViewRef;
            if (weakReference != null && weakReference.get() != null) {
                View view = (View) badgeDrawable.anchorViewRef.get();
                WeakReference weakReference2 = badgeDrawable.customBadgeParentRef;
                badgeDrawable.updateBadgeCoordinates(view, weakReference2 != null ? (FrameLayout) weakReference2.get() : null);
            }
        }
        savedState2.horizontalOffsetWithoutText = savedState.horizontalOffsetWithoutText;
        badgeDrawable.updateCenterAndBounds();
        savedState2.verticalOffsetWithoutText = savedState.verticalOffsetWithoutText;
        badgeDrawable.updateCenterAndBounds();
        savedState2.horizontalOffsetWithText = savedState.horizontalOffsetWithText;
        badgeDrawable.updateCenterAndBounds();
        savedState2.verticalOffsetWithText = savedState.verticalOffsetWithText;
        badgeDrawable.updateCenterAndBounds();
        savedState2.additionalHorizontalOffset = savedState.additionalHorizontalOffset;
        badgeDrawable.updateCenterAndBounds();
        savedState2.additionalVerticalOffset = savedState.additionalVerticalOffset;
        badgeDrawable.updateCenterAndBounds();
        boolean z = savedState.isVisible;
        badgeDrawable.setVisible(z, false);
        savedState2.isVisible = z;
        return badgeDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (getBounds().isEmpty() || this.savedState.alpha == 0 || !isVisible()) {
            return;
        }
        this.shapeDrawable.draw(canvas);
        if (hasNumber()) {
            Rect rect = new Rect();
            String badgeText = getBadgeText();
            TextDrawableHelper textDrawableHelper = this.textDrawableHelper;
            textDrawableHelper.textPaint.getTextBounds(badgeText, 0, badgeText.length(), rect);
            canvas.drawText(badgeText, this.badgeCenterX, this.badgeCenterY + (rect.height() / 2), textDrawableHelper.textPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.savedState.alpha;
    }

    public final String getBadgeText() {
        if (getNumber() <= this.maxBadgeNumber) {
            return NumberFormat.getInstance().format(getNumber());
        }
        Context context = (Context) this.contextRef.get();
        return context == null ? AppConfig.CUSTOM : context.getString(R.string.iq, Integer.valueOf(this.maxBadgeNumber), "+");
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    public final int getNumber() {
        if (hasNumber()) {
            return this.savedState.number;
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final boolean hasNumber() {
        return this.savedState.number != -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.savedState.alpha = i;
        this.textDrawableHelper.textPaint.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final void updateBadgeCoordinates(View view, FrameLayout frameLayout) {
        this.anchorViewRef = new WeakReference(view);
        this.customBadgeParentRef = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        updateCenterAndBounds();
        invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d8  */
    public final void updateCenterAndBounds() {
        float f;
        Context context = (Context) this.contextRef.get();
        WeakReference weakReference = this.anchorViewRef;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        Rect rect2 = this.badgeBounds;
        rect.set(rect2);
        Rect rect3 = new Rect();
        view.getDrawingRect(rect3);
        WeakReference weakReference2 = this.customBadgeParentRef;
        FrameLayout frameLayout = weakReference2 != null ? (FrameLayout) weakReference2.get() : null;
        if (frameLayout != null) {
            frameLayout.offsetDescendantRectToMyCoords(view, rect3);
        }
        boolean zHasNumber = hasNumber();
        SavedState savedState = this.savedState;
        int i = savedState.additionalVerticalOffset + (zHasNumber ? savedState.verticalOffsetWithText : savedState.verticalOffsetWithoutText);
        int i2 = savedState.badgeGravity;
        this.badgeCenterY = (i2 == 8388691 || i2 == 8388693) ? rect3.bottom - i : rect3.top + i;
        int number = getNumber();
        float textWidth = this.badgeWithTextRadius;
        if (number <= 9) {
            if (!hasNumber()) {
                textWidth = this.badgeRadius;
            }
            this.cornerRadius = textWidth;
            this.halfBadgeHeight = textWidth;
        } else {
            this.cornerRadius = textWidth;
            this.halfBadgeHeight = textWidth;
            textWidth = this.badgeWidePadding + (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f);
        }
        this.halfBadgeWidth = textWidth;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(hasNumber() ? R.dimen.jh : R.dimen.je);
        int i3 = savedState.additionalHorizontalOffset + (hasNumber() ? savedState.horizontalOffsetWithText : savedState.horizontalOffsetWithoutText);
        int i4 = savedState.badgeGravity;
        if (i4 == 8388659 || i4 == 8388691) {
            WeakHashMap weakHashMap = qd1.a;
            if (view.getLayoutDirection() == 0) {
                f = (rect3.left - this.halfBadgeWidth) + dimensionPixelSize + i3;
            } else {
                f = ((rect3.right + this.halfBadgeWidth) - dimensionPixelSize) - i3;
            }
        } else {
            WeakHashMap weakHashMap2 = qd1.a;
            if (view.getLayoutDirection() == 0) {
                f = ((rect3.right + this.halfBadgeWidth) - dimensionPixelSize) - i3;
            } else {
                f = (rect3.left - this.halfBadgeWidth) + dimensionPixelSize + i3;
            }
        }
        this.badgeCenterX = f;
        float f2 = this.badgeCenterY;
        float f3 = this.halfBadgeWidth;
        float f4 = this.halfBadgeHeight;
        rect2.set((int) (f - f3), (int) (f2 - f4), (int) (f + f3), (int) (f2 + f4));
        float f5 = this.cornerRadius;
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        materialShapeDrawable.setCornerSize(f5);
        if (rect.equals(rect2)) {
            return;
        }
        materialShapeDrawable.setBounds(rect2);
    }
}
