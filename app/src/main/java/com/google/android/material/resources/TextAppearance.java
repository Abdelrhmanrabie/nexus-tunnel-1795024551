package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.TypedValue;
import com.google.android.material.R;
import defpackage.ak;
import defpackage.sv0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class TextAppearance {
    public Typeface font;
    public final String fontFamily;
    public final int fontFamilyResourceId;
    public boolean fontResolved = false;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public ColorStateList textColor;
    public float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearance);
        this.textSize = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        this.textColor = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, 3);
        MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, 4);
        MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, 5);
        this.textStyle = typedArrayObtainStyledAttributes.getInt(2, 0);
        this.typeface = typedArrayObtainStyledAttributes.getInt(1, 1);
        int i2 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.fontFamilyResourceId = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
        this.fontFamily = typedArrayObtainStyledAttributes.getString(i2);
        typedArrayObtainStyledAttributes.getBoolean(14, false);
        this.shadowColor = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, 6);
        this.shadowDx = typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
        this.shadowDy = typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
        this.shadowRadius = typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i, R.styleable.MaterialTextAppearance);
        this.hasLetterSpacing = typedArrayObtainStyledAttributes2.hasValue(0);
        this.letterSpacing = typedArrayObtainStyledAttributes2.getFloat(0, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void createFallbackFont() {
        Typeface typeface;
        String str;
        Typeface typeface2 = this.font;
        int i = this.textStyle;
        if (typeface2 == null && (str = this.fontFamily) != null) {
            this.font = Typeface.create(str, i);
        }
        if (this.font == null) {
            int i2 = this.typeface;
            if (i2 == 1) {
                typeface = Typeface.SANS_SERIF;
            } else if (i2 != 2) {
                typeface = i2 != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE;
            } else {
                typeface = Typeface.SERIF;
            }
            this.font = typeface;
            this.font = Typeface.create(typeface, i);
        }
    }

    public final Typeface getFont(Context context) {
        if (this.fontResolved) {
            return this.font;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceB = sv0.b(context, this.fontFamilyResourceId);
                this.font = typefaceB;
                if (typefaceB != null) {
                    this.font = Typeface.create(typefaceB, this.textStyle);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException | Exception unused) {
            }
        }
        createFallbackFont();
        this.fontResolved = true;
        return this.font;
    }

    public final void getFontAsync(Context context, final TextAppearanceFontCallback textAppearanceFontCallback) {
        if (shouldLoadFontSynchronously(context)) {
            getFont(context);
        } else {
            createFallbackFont();
        }
        int i = this.fontFamilyResourceId;
        if (i == 0) {
            this.fontResolved = true;
        }
        if (this.fontResolved) {
            textAppearanceFontCallback.onFontRetrieved(this.font, true);
            return;
        }
        try {
            ak akVar = new ak() { // from class: com.google.android.material.resources.TextAppearance.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(29, false);
                }

                @Override // defpackage.ak
                public final void onFontRetrievalFailed(int i2) {
                    TextAppearance.this.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrievalFailed(i2);
                }

                @Override // defpackage.ak
                public final void onFontRetrieved(Typeface typeface) {
                    TextAppearance textAppearance = TextAppearance.this;
                    Typeface typefaceCreate = Typeface.create(typeface, textAppearance.textStyle);
                    textAppearance.font = typefaceCreate;
                    textAppearance.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrieved(typefaceCreate, false);
                }
            };
            ThreadLocal threadLocal = sv0.a;
            if (context.isRestricted()) {
                akVar.callbackFailAsync(-4);
            } else {
                sv0.c(context, i, new TypedValue(), 0, akVar, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(1);
        } catch (Exception unused2) {
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(-3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    public final boolean shouldLoadFontSynchronously(Context context) {
        Typeface typefaceC;
        int i = this.fontFamilyResourceId;
        if (i != 0) {
            ThreadLocal threadLocal = sv0.a;
            if (context.isRestricted()) {
                typefaceC = null;
            } else {
                typefaceC = sv0.c(context, i, new TypedValue(), 0, null, false, true);
            }
        } else {
            typefaceC = null;
        }
        return typefaceC != null;
    }

    public final void updateDrawState(Context context, TextPaint textPaint, TextAppearanceFontCallback textAppearanceFontCallback) {
        updateMeasureState(context, textPaint, textAppearanceFontCallback);
        ColorStateList colorStateList = this.textColor;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.shadowColor;
        textPaint.setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void updateMeasureState(Context context, final TextPaint textPaint, final TextAppearanceFontCallback textAppearanceFontCallback) {
        if (shouldLoadFontSynchronously(context)) {
            updateTextPaintMeasureState(textPaint, getFont(context));
            return;
        }
        createFallbackFont();
        updateTextPaintMeasureState(textPaint, this.font);
        getFontAsync(context, new TextAppearanceFontCallback() { // from class: com.google.android.material.resources.TextAppearance.2
            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public final void onFontRetrievalFailed(int i) {
                textAppearanceFontCallback.onFontRetrievalFailed(i);
            }

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public final void onFontRetrieved(Typeface typeface, boolean z) {
                TextAppearance.this.updateTextPaintMeasureState(textPaint, typeface);
                textAppearanceFontCallback.onFontRetrieved(typeface, z);
            }
        });
    }

    public final void updateTextPaintMeasureState(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.textStyle;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.textSize);
        if (this.hasLetterSpacing) {
            textPaint.setLetterSpacing(this.letterSpacing);
        }
    }
}
