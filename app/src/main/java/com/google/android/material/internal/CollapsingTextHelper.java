package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import defpackage.d61;
import defpackage.e;
import defpackage.qd1;
import defpackage.vs;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class CollapsingTextHelper {
    public boolean boundsChanged;
    public final Rect collapsedBounds;
    public float collapsedDrawX;
    public float collapsedDrawY;
    public CancelableFontCallback collapsedFontCallback;
    public float collapsedLetterSpacing;
    public ColorStateList collapsedShadowColor;
    public float collapsedShadowDx;
    public float collapsedShadowDy;
    public float collapsedShadowRadius;
    public float collapsedTextBlend;
    public ColorStateList collapsedTextColor;
    public float collapsedTextWidth;
    public Typeface collapsedTypeface;
    public final RectF currentBounds;
    public float currentDrawX;
    public float currentDrawY;
    public int currentOffsetY;
    public float currentTextSize;
    public Typeface currentTypeface;
    public boolean drawTitle;
    public final Rect expandedBounds;
    public float expandedDrawX;
    public float expandedDrawY;
    public float expandedFirstLineDrawX;
    public CancelableFontCallback expandedFontCallback;
    public float expandedFraction;
    public float expandedLetterSpacing;
    public int expandedLineCount;
    public ColorStateList expandedShadowColor;
    public float expandedShadowDx;
    public float expandedShadowDy;
    public float expandedShadowRadius;
    public float expandedTextBlend;
    public ColorStateList expandedTextColor;
    public Bitmap expandedTitleTexture;
    public Typeface expandedTypeface;
    public boolean fadeModeEnabled;
    public float fadeModeStartFraction;
    public float fadeModeThresholdFraction;
    public boolean isRtl;
    public TimeInterpolator positionInterpolator;
    public float scale;
    public int[] state;
    public CharSequence text;
    public StaticLayout textLayout;
    public final TextPaint textPaint;
    public TimeInterpolator textSizeInterpolator;
    public CharSequence textToDraw;
    public CharSequence textToDrawCollapsed;
    public final TextPaint tmpPaint;
    public final View view;
    public int expandedTextGravity = 16;
    public int collapsedTextGravity = 16;
    public float expandedTextSize = 15.0f;
    public float collapsedTextSize = 15.0f;
    public boolean isRtlTextDirectionHeuristicsEnabled = true;
    public int maxLines = 1;

    public CollapsingTextHelper(View view) {
        this.view = view;
        TextPaint textPaint = new TextPaint(129);
        this.textPaint = textPaint;
        this.tmpPaint = new TextPaint(textPaint);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        float f = this.fadeModeStartFraction;
        this.fadeModeThresholdFraction = e.a(1.0f, f, 0.5f, f);
    }

    public static int blendColors(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i2) * f) + (Color.alpha(i) * f2)), (int) ((Color.red(i2) * f) + (Color.red(i) * f2)), (int) ((Color.green(i2) * f) + (Color.green(i) * f2)), (int) ((Color.blue(i2) * f) + (Color.blue(i) * f2)));
    }

    public static float lerp(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        DecelerateInterpolator decelerateInterpolator = AnimationUtils.DECELERATE_INTERPOLATOR;
        return e.a(f2, f, f3, f);
    }

    public final boolean calculateIsRtl(CharSequence charSequence) {
        WeakHashMap weakHashMap = qd1.a;
        boolean z = this.view.getLayoutDirection() == 1;
        if (this.isRtlTextDirectionHeuristicsEnabled) {
            return (z ? d61.d : d61.c).b(charSequence, charSequence.length());
        }
        return z;
    }

    public final void calculateUsingTextSize(float f, boolean z) {
        boolean z2;
        float f2;
        StaticLayout staticLayoutBuild;
        if (this.text == null) {
            return;
        }
        float fWidth = this.collapsedBounds.width();
        float fWidth2 = this.expandedBounds.width();
        if (Math.abs(f - this.collapsedTextSize) < 0.001f) {
            f2 = this.collapsedTextSize;
            this.scale = 1.0f;
            Typeface typeface = this.currentTypeface;
            Typeface typeface2 = this.collapsedTypeface;
            if (typeface != typeface2) {
                this.currentTypeface = typeface2;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            float f3 = this.expandedTextSize;
            Typeface typeface3 = this.currentTypeface;
            Typeface typeface4 = this.expandedTypeface;
            if (typeface3 != typeface4) {
                this.currentTypeface = typeface4;
                z2 = true;
            } else {
                z2 = false;
            }
            if (Math.abs(f - f3) < 0.001f) {
                this.scale = 1.0f;
            } else {
                this.scale = f / this.expandedTextSize;
            }
            float f4 = this.collapsedTextSize / this.expandedTextSize;
            fWidth = (!z && fWidth2 * f4 > fWidth) ? Math.min(fWidth / f4, fWidth2) : fWidth2;
            f2 = f3;
        }
        if (fWidth > 0.0f) {
            z2 = this.currentTextSize != f2 || this.boundsChanged || z2;
            this.currentTextSize = f2;
            this.boundsChanged = false;
        }
        if (this.textToDraw == null || z2) {
            float f5 = this.currentTextSize;
            TextPaint textPaint = this.textPaint;
            textPaint.setTextSize(f5);
            textPaint.setTypeface(this.currentTypeface);
            textPaint.setLinearText(this.scale != 1.0f);
            boolean zCalculateIsRtl = calculateIsRtl(this.text);
            this.isRtl = zCalculateIsRtl;
            int i = this.maxLines;
            if (i <= 1 || (zCalculateIsRtl && !this.fadeModeEnabled)) {
                i = 1;
            }
            try {
                StaticLayoutBuilderCompat staticLayoutBuilderCompatObtain = StaticLayoutBuilderCompat.obtain(this.text, textPaint, (int) fWidth);
                staticLayoutBuilderCompatObtain.ellipsize = TextUtils.TruncateAt.END;
                staticLayoutBuilderCompatObtain.isRtl = zCalculateIsRtl;
                staticLayoutBuilderCompatObtain.alignment = Layout.Alignment.ALIGN_NORMAL;
                staticLayoutBuilderCompatObtain.includePad = false;
                staticLayoutBuilderCompatObtain.maxLines = i;
                staticLayoutBuilderCompatObtain.lineSpacingMultiplier = 1.0f;
                staticLayoutBuilderCompatObtain.hyphenationFrequency = 1;
                staticLayoutBuild = staticLayoutBuilderCompatObtain.build();
            } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e) {
                e.getCause().getMessage();
                staticLayoutBuild = null;
            }
            staticLayoutBuild.getClass();
            this.textLayout = staticLayoutBuild;
            this.textToDraw = staticLayoutBuild.getText();
        }
    }

    public final void draw(Canvas canvas) {
        int iSave = canvas.save();
        if (this.textToDraw == null || !this.drawTitle) {
            return;
        }
        int i = this.maxLines;
        StaticLayout staticLayout = this.textLayout;
        float lineStart = (this.currentDrawX + (i > 1 ? staticLayout.getLineStart(0) : staticLayout.getLineLeft(0))) - (this.expandedFirstLineDrawX * 2.0f);
        float f = this.currentTextSize;
        TextPaint textPaint = this.textPaint;
        textPaint.setTextSize(f);
        float f2 = this.currentDrawX;
        float f3 = this.currentDrawY;
        float f4 = this.scale;
        if (f4 != 1.0f && !this.fadeModeEnabled) {
            canvas.scale(f4, f4, f2, f3);
        }
        if (this.maxLines <= 1 || ((this.isRtl && !this.fadeModeEnabled) || (this.fadeModeEnabled && this.expandedFraction <= this.fadeModeThresholdFraction))) {
            canvas.translate(f2, f3);
            this.textLayout.draw(canvas);
        } else {
            int alpha = textPaint.getAlpha();
            canvas.translate(lineStart, f3);
            float f5 = alpha;
            textPaint.setAlpha((int) (this.expandedTextBlend * f5));
            this.textLayout.draw(canvas);
            textPaint.setAlpha((int) (this.collapsedTextBlend * f5));
            int lineBaseline = this.textLayout.getLineBaseline(0);
            CharSequence charSequence = this.textToDrawCollapsed;
            float f6 = lineBaseline;
            canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f6, textPaint);
            if (!this.fadeModeEnabled) {
                String strTrim = this.textToDrawCollapsed.toString().trim();
                if (strTrim.endsWith("…")) {
                    strTrim = strTrim.substring(0, strTrim.length() - 1);
                }
                String str = strTrim;
                textPaint.setAlpha(alpha);
                canvas.drawText(str, 0, Math.min(this.textLayout.getLineEnd(0), str.length()), 0.0f, f6, (Paint) textPaint);
            }
            canvas = canvas;
        }
        canvas.restoreToCount(iSave);
    }

    public final float getCollapsedTextHeight() {
        float f = this.collapsedTextSize;
        TextPaint textPaint = this.tmpPaint;
        textPaint.setTextSize(f);
        textPaint.setTypeface(this.collapsedTypeface);
        textPaint.setLetterSpacing(this.collapsedLetterSpacing);
        return -textPaint.ascent();
    }

    public final int getCurrentColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.state;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    public final void onBoundsChanged() {
        boolean z;
        Rect rect = this.collapsedBounds;
        if (rect.width() <= 0 || rect.height() <= 0) {
            z = false;
        } else {
            Rect rect2 = this.expandedBounds;
            if (rect2.width() <= 0 || rect2.height() <= 0) {
                z = false;
            } else {
                z = true;
            }
        }
        this.drawTitle = z;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:56:0x0106 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x0108  */
    /* JADX WARN: Code duplicated, block: B:58:0x0113  */
    /* JADX WARN: Code duplicated, block: B:59:0x011d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0126 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x0128  */
    /* JADX WARN: Code duplicated, block: B:65:0x012c  */
    /* JADX WARN: Code duplicated, block: B:66:0x0130  */
    /* JADX WARN: Code duplicated, block: B:70:0x013f  */
    /* JADX WARN: Code duplicated, block: B:73:0x014f  */
    /* JADX WARN: Code duplicated, block: B:75:0x0155  */
    /* JADX WARN: Code duplicated, block: B:77:0x015a  */
    /* JADX WARN: Code duplicated, block: B:80:0x0196  */
    /* JADX WARN: Code duplicated, block: B:82:0x019c  */
    /* JADX WARN: Code duplicated, block: B:83:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:84:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:87:0x0208  */
    /* JADX WARN: Code duplicated, block: B:88:0x0217  */
    /* JADX WARN: Code duplicated, block: B:91:0x0226  */
    /* JADX WARN: Code duplicated, block: B:94:0x025c  */
    /* JADX WARN: Code duplicated, block: B:96:0x0266  */
    /* JADX WARN: Code duplicated, block: B:97:0x026d  */
    public final void recalculate(boolean z) {
        float fCenterX;
        float f;
        float f2;
        StaticLayout staticLayout;
        float height;
        StaticLayout staticLayout2;
        int lineCount;
        CharSequence charSequence;
        float width;
        StaticLayout staticLayout3;
        StaticLayout staticLayout4;
        float lineLeft;
        int i;
        Rect rect;
        float fDescent;
        int i2;
        float fCenterX2;
        float f3;
        Bitmap bitmap;
        float f4;
        boolean z2;
        RectF rectF;
        float f5;
        vs vsVar;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        int currentColor;
        float fLerp;
        float f6;
        float f7;
        float fLerp2;
        StaticLayout staticLayout5;
        View view = this.view;
        if ((view.getHeight() <= 0 || view.getWidth() <= 0) && !z) {
            return;
        }
        float f8 = this.currentTextSize;
        calculateUsingTextSize(this.collapsedTextSize, z);
        CharSequence charSequence2 = this.textToDraw;
        TextPaint textPaint = this.textPaint;
        if (charSequence2 != null && (staticLayout5 = this.textLayout) != null) {
            this.textToDrawCollapsed = TextUtils.ellipsize(charSequence2, textPaint, staticLayout5.getWidth(), TextUtils.TruncateAt.END);
        }
        if (this.textToDrawCollapsed != null) {
            TextPaint textPaint2 = new TextPaint(textPaint);
            textPaint2.setLetterSpacing(this.collapsedLetterSpacing);
            CharSequence charSequence3 = this.textToDrawCollapsed;
            this.collapsedTextWidth = textPaint2.measureText(charSequence3, 0, charSequence3.length());
        } else {
            this.collapsedTextWidth = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        int i3 = absoluteGravity & 112;
        Rect rect2 = this.collapsedBounds;
        if (i3 != 48) {
            this.collapsedDrawY = i3 != 80 ? rect2.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f) : textPaint.ascent() + rect2.bottom;
        } else {
            this.collapsedDrawY = rect2.top;
        }
        int i4 = absoluteGravity & 8388615;
        if (i4 != 1) {
            if (i4 != 5) {
                f2 = rect2.left;
            } else {
                fCenterX = rect2.right;
                f = this.collapsedTextWidth;
            }
            this.collapsedDrawX = f2;
            calculateUsingTextSize(this.expandedTextSize, z);
            staticLayout = this.textLayout;
            if (staticLayout != null) {
                height = staticLayout.getHeight();
            } else {
                height = 0.0f;
            }
            staticLayout2 = this.textLayout;
            if (staticLayout2 != null) {
                lineCount = staticLayout2.getLineCount();
            } else {
                lineCount = 0;
            }
            this.expandedLineCount = lineCount;
            charSequence = this.textToDraw;
            if (charSequence != null) {
                width = textPaint.measureText(charSequence, 0, charSequence.length());
            } else {
                width = 0.0f;
            }
            staticLayout3 = this.textLayout;
            if (staticLayout3 != null && this.maxLines > 1) {
                width = staticLayout3.getWidth();
            }
            staticLayout4 = this.textLayout;
            if (staticLayout4 != null) {
                lineLeft = 0.0f;
            } else if (this.maxLines > 1) {
                lineLeft = staticLayout4.getLineStart(0);
            } else {
                lineLeft = staticLayout4.getLineLeft(0);
            }
            this.expandedFirstLineDrawX = lineLeft;
            int absoluteGravity2 = Gravity.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
            i = absoluteGravity2 & 112;
            rect = this.expandedBounds;
            if (i != 48) {
                if (i != 80) {
                    this.expandedDrawY = rect.centerY() - (height / 2.0f);
                } else {
                    fDescent = textPaint.descent() + (rect.bottom - height);
                }
                i2 = absoluteGravity2 & 8388615;
                if (i2 != 1) {
                    if (i2 != 5) {
                        f3 = rect.left;
                    } else {
                        fCenterX2 = rect.right;
                    }
                    this.expandedDrawX = f3;
                    bitmap = this.expandedTitleTexture;
                    if (bitmap != null) {
                        bitmap.recycle();
                        this.expandedTitleTexture = null;
                    }
                    setInterpolatedTextSize(f8);
                    f4 = this.expandedFraction;
                    z2 = this.fadeModeEnabled;
                    rectF = this.currentBounds;
                    if (z2) {
                        if (f4 < this.fadeModeThresholdFraction) {
                            rect2 = rect;
                        }
                        rectF.set(rect2);
                    } else {
                        rectF.left = lerp(rect.left, rect2.left, f4, this.positionInterpolator);
                        rectF.top = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
                        rectF.right = lerp(rect.right, rect2.right, f4, this.positionInterpolator);
                        rectF.bottom = lerp(rect.bottom, rect2.bottom, f4, this.positionInterpolator);
                    }
                    if (this.fadeModeEnabled) {
                        this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f4, this.positionInterpolator);
                        this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
                        setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f4, this.textSizeInterpolator));
                        f5 = f4;
                    } else if (f4 < this.fadeModeThresholdFraction) {
                        this.currentDrawX = this.expandedDrawX;
                        this.currentDrawY = this.expandedDrawY;
                        setInterpolatedTextSize(this.expandedTextSize);
                        f5 = 0.0f;
                    } else {
                        this.currentDrawX = this.collapsedDrawX;
                        this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
                        setInterpolatedTextSize(this.collapsedTextSize);
                        f5 = 1.0f;
                    }
                    vsVar = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
                    this.collapsedTextBlend = 1.0f - lerp(0.0f, 1.0f, 1.0f - f4, vsVar);
                    WeakHashMap weakHashMap = qd1.a;
                    view.postInvalidateOnAnimation();
                    this.expandedTextBlend = lerp(1.0f, 0.0f, f4, vsVar);
                    view.postInvalidateOnAnimation();
                    colorStateList = this.collapsedTextColor;
                    colorStateList2 = this.expandedTextColor;
                    if (colorStateList != colorStateList2) {
                        currentColor = blendColors(getCurrentColor(colorStateList2), getCurrentColor(this.collapsedTextColor), f5);
                    } else {
                        currentColor = getCurrentColor(colorStateList);
                    }
                    textPaint.setColor(currentColor);
                    fLerp = this.collapsedLetterSpacing;
                    f6 = this.expandedLetterSpacing;
                    if (fLerp != f6) {
                        fLerp = lerp(f6, fLerp, f4, vsVar);
                    }
                    textPaint.setLetterSpacing(fLerp);
                    textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f4, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f4, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f4, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f4));
                    if (this.fadeModeEnabled) {
                        int alpha = textPaint.getAlpha();
                        f7 = this.fadeModeThresholdFraction;
                        if (f4 <= f7) {
                            fLerp2 = AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f7, f4);
                        } else {
                            fLerp2 = AnimationUtils.lerp(0.0f, 1.0f, f7, 1.0f, f4);
                        }
                        textPaint.setAlpha((int) (fLerp2 * alpha));
                    }
                    view.postInvalidateOnAnimation();
                }
                fCenterX2 = rect.centerX();
                width /= 2.0f;
                f3 = fCenterX2 - width;
                this.expandedDrawX = f3;
                bitmap = this.expandedTitleTexture;
                if (bitmap != null) {
                    bitmap.recycle();
                    this.expandedTitleTexture = null;
                }
                setInterpolatedTextSize(f8);
                f4 = this.expandedFraction;
                z2 = this.fadeModeEnabled;
                rectF = this.currentBounds;
                if (z2) {
                    if (f4 < this.fadeModeThresholdFraction) {
                        rect2 = rect;
                    }
                    rectF.set(rect2);
                } else {
                    rectF.left = lerp(rect.left, rect2.left, f4, this.positionInterpolator);
                    rectF.top = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
                    rectF.right = lerp(rect.right, rect2.right, f4, this.positionInterpolator);
                    rectF.bottom = lerp(rect.bottom, rect2.bottom, f4, this.positionInterpolator);
                }
                if (this.fadeModeEnabled) {
                    this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f4, this.positionInterpolator);
                    this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
                    setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f4, this.textSizeInterpolator));
                    f5 = f4;
                } else if (f4 < this.fadeModeThresholdFraction) {
                    this.currentDrawX = this.expandedDrawX;
                    this.currentDrawY = this.expandedDrawY;
                    setInterpolatedTextSize(this.expandedTextSize);
                    f5 = 0.0f;
                } else {
                    this.currentDrawX = this.collapsedDrawX;
                    this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
                    setInterpolatedTextSize(this.collapsedTextSize);
                    f5 = 1.0f;
                }
                vsVar = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
                this.collapsedTextBlend = 1.0f - lerp(0.0f, 1.0f, 1.0f - f4, vsVar);
                WeakHashMap weakHashMap2 = qd1.a;
                view.postInvalidateOnAnimation();
                this.expandedTextBlend = lerp(1.0f, 0.0f, f4, vsVar);
                view.postInvalidateOnAnimation();
                colorStateList = this.collapsedTextColor;
                colorStateList2 = this.expandedTextColor;
                if (colorStateList != colorStateList2) {
                    currentColor = blendColors(getCurrentColor(colorStateList2), getCurrentColor(this.collapsedTextColor), f5);
                } else {
                    currentColor = getCurrentColor(colorStateList);
                }
                textPaint.setColor(currentColor);
                fLerp = this.collapsedLetterSpacing;
                f6 = this.expandedLetterSpacing;
                if (fLerp != f6) {
                    fLerp = lerp(f6, fLerp, f4, vsVar);
                }
                textPaint.setLetterSpacing(fLerp);
                textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f4, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f4, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f4, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f4));
                if (this.fadeModeEnabled) {
                    int alpha2 = textPaint.getAlpha();
                    f7 = this.fadeModeThresholdFraction;
                    if (f4 <= f7) {
                        fLerp2 = AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f7, f4);
                    } else {
                        fLerp2 = AnimationUtils.lerp(0.0f, 1.0f, f7, 1.0f, f4);
                    }
                    textPaint.setAlpha((int) (fLerp2 * alpha2));
                }
                view.postInvalidateOnAnimation();
            }
            fDescent = rect.top;
            this.expandedDrawY = fDescent;
            i2 = absoluteGravity2 & 8388615;
            if (i2 != 1) {
                if (i2 != 5) {
                    f3 = rect.left;
                } else {
                    fCenterX2 = rect.right;
                }
                this.expandedDrawX = f3;
                bitmap = this.expandedTitleTexture;
                if (bitmap != null) {
                    bitmap.recycle();
                    this.expandedTitleTexture = null;
                }
                setInterpolatedTextSize(f8);
                f4 = this.expandedFraction;
                z2 = this.fadeModeEnabled;
                rectF = this.currentBounds;
                if (z2) {
                    if (f4 < this.fadeModeThresholdFraction) {
                        rect2 = rect;
                    }
                    rectF.set(rect2);
                } else {
                    rectF.left = lerp(rect.left, rect2.left, f4, this.positionInterpolator);
                    rectF.top = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
                    rectF.right = lerp(rect.right, rect2.right, f4, this.positionInterpolator);
                    rectF.bottom = lerp(rect.bottom, rect2.bottom, f4, this.positionInterpolator);
                }
                if (this.fadeModeEnabled) {
                    this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f4, this.positionInterpolator);
                    this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
                    setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f4, this.textSizeInterpolator));
                    f5 = f4;
                } else if (f4 < this.fadeModeThresholdFraction) {
                    this.currentDrawX = this.expandedDrawX;
                    this.currentDrawY = this.expandedDrawY;
                    setInterpolatedTextSize(this.expandedTextSize);
                    f5 = 0.0f;
                } else {
                    this.currentDrawX = this.collapsedDrawX;
                    this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
                    setInterpolatedTextSize(this.collapsedTextSize);
                    f5 = 1.0f;
                }
                vsVar = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
                this.collapsedTextBlend = 1.0f - lerp(0.0f, 1.0f, 1.0f - f4, vsVar);
                WeakHashMap weakHashMap3 = qd1.a;
                view.postInvalidateOnAnimation();
                this.expandedTextBlend = lerp(1.0f, 0.0f, f4, vsVar);
                view.postInvalidateOnAnimation();
                colorStateList = this.collapsedTextColor;
                colorStateList2 = this.expandedTextColor;
                if (colorStateList != colorStateList2) {
                    currentColor = blendColors(getCurrentColor(colorStateList2), getCurrentColor(this.collapsedTextColor), f5);
                } else {
                    currentColor = getCurrentColor(colorStateList);
                }
                textPaint.setColor(currentColor);
                fLerp = this.collapsedLetterSpacing;
                f6 = this.expandedLetterSpacing;
                if (fLerp != f6) {
                    fLerp = lerp(f6, fLerp, f4, vsVar);
                }
                textPaint.setLetterSpacing(fLerp);
                textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f4, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f4, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f4, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f4));
                if (this.fadeModeEnabled) {
                    int alpha3 = textPaint.getAlpha();
                    f7 = this.fadeModeThresholdFraction;
                    if (f4 <= f7) {
                        fLerp2 = AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f7, f4);
                    } else {
                        fLerp2 = AnimationUtils.lerp(0.0f, 1.0f, f7, 1.0f, f4);
                    }
                    textPaint.setAlpha((int) (fLerp2 * alpha3));
                }
                view.postInvalidateOnAnimation();
            }
            fCenterX2 = rect.centerX();
            width /= 2.0f;
            f3 = fCenterX2 - width;
            this.expandedDrawX = f3;
            bitmap = this.expandedTitleTexture;
            if (bitmap != null) {
                bitmap.recycle();
                this.expandedTitleTexture = null;
            }
            setInterpolatedTextSize(f8);
            f4 = this.expandedFraction;
            z2 = this.fadeModeEnabled;
            rectF = this.currentBounds;
            if (z2) {
                if (f4 < this.fadeModeThresholdFraction) {
                    rect2 = rect;
                }
                rectF.set(rect2);
            } else {
                rectF.left = lerp(rect.left, rect2.left, f4, this.positionInterpolator);
                rectF.top = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
                rectF.right = lerp(rect.right, rect2.right, f4, this.positionInterpolator);
                rectF.bottom = lerp(rect.bottom, rect2.bottom, f4, this.positionInterpolator);
            }
            if (this.fadeModeEnabled) {
                this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f4, this.positionInterpolator);
                this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
                setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f4, this.textSizeInterpolator));
                f5 = f4;
            } else if (f4 < this.fadeModeThresholdFraction) {
                this.currentDrawX = this.expandedDrawX;
                this.currentDrawY = this.expandedDrawY;
                setInterpolatedTextSize(this.expandedTextSize);
                f5 = 0.0f;
            } else {
                this.currentDrawX = this.collapsedDrawX;
                this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
                setInterpolatedTextSize(this.collapsedTextSize);
                f5 = 1.0f;
            }
            vsVar = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
            this.collapsedTextBlend = 1.0f - lerp(0.0f, 1.0f, 1.0f - f4, vsVar);
            WeakHashMap weakHashMap4 = qd1.a;
            view.postInvalidateOnAnimation();
            this.expandedTextBlend = lerp(1.0f, 0.0f, f4, vsVar);
            view.postInvalidateOnAnimation();
            colorStateList = this.collapsedTextColor;
            colorStateList2 = this.expandedTextColor;
            if (colorStateList != colorStateList2) {
                currentColor = blendColors(getCurrentColor(colorStateList2), getCurrentColor(this.collapsedTextColor), f5);
            } else {
                currentColor = getCurrentColor(colorStateList);
            }
            textPaint.setColor(currentColor);
            fLerp = this.collapsedLetterSpacing;
            f6 = this.expandedLetterSpacing;
            if (fLerp != f6) {
                fLerp = lerp(f6, fLerp, f4, vsVar);
            }
            textPaint.setLetterSpacing(fLerp);
            textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f4, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f4, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f4, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f4));
            if (this.fadeModeEnabled) {
                int alpha4 = textPaint.getAlpha();
                f7 = this.fadeModeThresholdFraction;
                if (f4 <= f7) {
                    fLerp2 = AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f7, f4);
                } else {
                    fLerp2 = AnimationUtils.lerp(0.0f, 1.0f, f7, 1.0f, f4);
                }
                textPaint.setAlpha((int) (fLerp2 * alpha4));
            }
            view.postInvalidateOnAnimation();
        }
        fCenterX = rect2.centerX();
        f = this.collapsedTextWidth / 2.0f;
        f2 = fCenterX - f;
        this.collapsedDrawX = f2;
        calculateUsingTextSize(this.expandedTextSize, z);
        staticLayout = this.textLayout;
        if (staticLayout != null) {
            height = staticLayout.getHeight();
        } else {
            height = 0.0f;
        }
        staticLayout2 = this.textLayout;
        if (staticLayout2 != null) {
            lineCount = staticLayout2.getLineCount();
        } else {
            lineCount = 0;
        }
        this.expandedLineCount = lineCount;
        charSequence = this.textToDraw;
        if (charSequence != null) {
            width = textPaint.measureText(charSequence, 0, charSequence.length());
        } else {
            width = 0.0f;
        }
        staticLayout3 = this.textLayout;
        if (staticLayout3 != null) {
            width = staticLayout3.getWidth();
        }
        staticLayout4 = this.textLayout;
        if (staticLayout4 != null) {
            lineLeft = 0.0f;
        } else if (this.maxLines > 1) {
            lineLeft = staticLayout4.getLineStart(0);
        } else {
            lineLeft = staticLayout4.getLineLeft(0);
        }
        this.expandedFirstLineDrawX = lineLeft;
        int absoluteGravity3 = Gravity.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
        i = absoluteGravity3 & 112;
        rect = this.expandedBounds;
        if (i != 48) {
            if (i != 80) {
                this.expandedDrawY = rect.centerY() - (height / 2.0f);
            } else {
                fDescent = textPaint.descent() + (rect.bottom - height);
            }
            i2 = absoluteGravity3 & 8388615;
            if (i2 != 1) {
                if (i2 != 5) {
                    f3 = rect.left;
                } else {
                    fCenterX2 = rect.right;
                }
                this.expandedDrawX = f3;
                bitmap = this.expandedTitleTexture;
                if (bitmap != null) {
                    bitmap.recycle();
                    this.expandedTitleTexture = null;
                }
                setInterpolatedTextSize(f8);
                f4 = this.expandedFraction;
                z2 = this.fadeModeEnabled;
                rectF = this.currentBounds;
                if (z2) {
                    if (f4 < this.fadeModeThresholdFraction) {
                        rect2 = rect;
                    }
                    rectF.set(rect2);
                } else {
                    rectF.left = lerp(rect.left, rect2.left, f4, this.positionInterpolator);
                    rectF.top = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
                    rectF.right = lerp(rect.right, rect2.right, f4, this.positionInterpolator);
                    rectF.bottom = lerp(rect.bottom, rect2.bottom, f4, this.positionInterpolator);
                }
                if (this.fadeModeEnabled) {
                    this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f4, this.positionInterpolator);
                    this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
                    setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f4, this.textSizeInterpolator));
                    f5 = f4;
                } else if (f4 < this.fadeModeThresholdFraction) {
                    this.currentDrawX = this.expandedDrawX;
                    this.currentDrawY = this.expandedDrawY;
                    setInterpolatedTextSize(this.expandedTextSize);
                    f5 = 0.0f;
                } else {
                    this.currentDrawX = this.collapsedDrawX;
                    this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
                    setInterpolatedTextSize(this.collapsedTextSize);
                    f5 = 1.0f;
                }
                vsVar = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
                this.collapsedTextBlend = 1.0f - lerp(0.0f, 1.0f, 1.0f - f4, vsVar);
                WeakHashMap weakHashMap5 = qd1.a;
                view.postInvalidateOnAnimation();
                this.expandedTextBlend = lerp(1.0f, 0.0f, f4, vsVar);
                view.postInvalidateOnAnimation();
                colorStateList = this.collapsedTextColor;
                colorStateList2 = this.expandedTextColor;
                if (colorStateList != colorStateList2) {
                    currentColor = blendColors(getCurrentColor(colorStateList2), getCurrentColor(this.collapsedTextColor), f5);
                } else {
                    currentColor = getCurrentColor(colorStateList);
                }
                textPaint.setColor(currentColor);
                fLerp = this.collapsedLetterSpacing;
                f6 = this.expandedLetterSpacing;
                if (fLerp != f6) {
                    fLerp = lerp(f6, fLerp, f4, vsVar);
                }
                textPaint.setLetterSpacing(fLerp);
                textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f4, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f4, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f4, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f4));
                if (this.fadeModeEnabled) {
                    int alpha5 = textPaint.getAlpha();
                    f7 = this.fadeModeThresholdFraction;
                    if (f4 <= f7) {
                        fLerp2 = AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f7, f4);
                    } else {
                        fLerp2 = AnimationUtils.lerp(0.0f, 1.0f, f7, 1.0f, f4);
                    }
                    textPaint.setAlpha((int) (fLerp2 * alpha5));
                }
                view.postInvalidateOnAnimation();
            }
            fCenterX2 = rect.centerX();
            width /= 2.0f;
            f3 = fCenterX2 - width;
            this.expandedDrawX = f3;
            bitmap = this.expandedTitleTexture;
            if (bitmap != null) {
                bitmap.recycle();
                this.expandedTitleTexture = null;
            }
            setInterpolatedTextSize(f8);
            f4 = this.expandedFraction;
            z2 = this.fadeModeEnabled;
            rectF = this.currentBounds;
            if (z2) {
                if (f4 < this.fadeModeThresholdFraction) {
                    rect2 = rect;
                }
                rectF.set(rect2);
            } else {
                rectF.left = lerp(rect.left, rect2.left, f4, this.positionInterpolator);
                rectF.top = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
                rectF.right = lerp(rect.right, rect2.right, f4, this.positionInterpolator);
                rectF.bottom = lerp(rect.bottom, rect2.bottom, f4, this.positionInterpolator);
            }
            if (this.fadeModeEnabled) {
                this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f4, this.positionInterpolator);
                this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
                setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f4, this.textSizeInterpolator));
                f5 = f4;
            } else if (f4 < this.fadeModeThresholdFraction) {
                this.currentDrawX = this.expandedDrawX;
                this.currentDrawY = this.expandedDrawY;
                setInterpolatedTextSize(this.expandedTextSize);
                f5 = 0.0f;
            } else {
                this.currentDrawX = this.collapsedDrawX;
                this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
                setInterpolatedTextSize(this.collapsedTextSize);
                f5 = 1.0f;
            }
            vsVar = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
            this.collapsedTextBlend = 1.0f - lerp(0.0f, 1.0f, 1.0f - f4, vsVar);
            WeakHashMap weakHashMap6 = qd1.a;
            view.postInvalidateOnAnimation();
            this.expandedTextBlend = lerp(1.0f, 0.0f, f4, vsVar);
            view.postInvalidateOnAnimation();
            colorStateList = this.collapsedTextColor;
            colorStateList2 = this.expandedTextColor;
            if (colorStateList != colorStateList2) {
                currentColor = blendColors(getCurrentColor(colorStateList2), getCurrentColor(this.collapsedTextColor), f5);
            } else {
                currentColor = getCurrentColor(colorStateList);
            }
            textPaint.setColor(currentColor);
            fLerp = this.collapsedLetterSpacing;
            f6 = this.expandedLetterSpacing;
            if (fLerp != f6) {
                fLerp = lerp(f6, fLerp, f4, vsVar);
            }
            textPaint.setLetterSpacing(fLerp);
            textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f4, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f4, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f4, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f4));
            if (this.fadeModeEnabled) {
                int alpha6 = textPaint.getAlpha();
                f7 = this.fadeModeThresholdFraction;
                if (f4 <= f7) {
                    fLerp2 = AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f7, f4);
                } else {
                    fLerp2 = AnimationUtils.lerp(0.0f, 1.0f, f7, 1.0f, f4);
                }
                textPaint.setAlpha((int) (fLerp2 * alpha6));
            }
            view.postInvalidateOnAnimation();
        }
        fDescent = rect.top;
        this.expandedDrawY = fDescent;
        i2 = absoluteGravity3 & 8388615;
        if (i2 != 1) {
            if (i2 != 5) {
                f3 = rect.left;
            } else {
                fCenterX2 = rect.right;
            }
            this.expandedDrawX = f3;
            bitmap = this.expandedTitleTexture;
            if (bitmap != null) {
                bitmap.recycle();
                this.expandedTitleTexture = null;
            }
            setInterpolatedTextSize(f8);
            f4 = this.expandedFraction;
            z2 = this.fadeModeEnabled;
            rectF = this.currentBounds;
            if (z2) {
                if (f4 < this.fadeModeThresholdFraction) {
                    rect2 = rect;
                }
                rectF.set(rect2);
            } else {
                rectF.left = lerp(rect.left, rect2.left, f4, this.positionInterpolator);
                rectF.top = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
                rectF.right = lerp(rect.right, rect2.right, f4, this.positionInterpolator);
                rectF.bottom = lerp(rect.bottom, rect2.bottom, f4, this.positionInterpolator);
            }
            if (this.fadeModeEnabled) {
                this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f4, this.positionInterpolator);
                this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
                setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f4, this.textSizeInterpolator));
                f5 = f4;
            } else if (f4 < this.fadeModeThresholdFraction) {
                this.currentDrawX = this.expandedDrawX;
                this.currentDrawY = this.expandedDrawY;
                setInterpolatedTextSize(this.expandedTextSize);
                f5 = 0.0f;
            } else {
                this.currentDrawX = this.collapsedDrawX;
                this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
                setInterpolatedTextSize(this.collapsedTextSize);
                f5 = 1.0f;
            }
            vsVar = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
            this.collapsedTextBlend = 1.0f - lerp(0.0f, 1.0f, 1.0f - f4, vsVar);
            WeakHashMap weakHashMap7 = qd1.a;
            view.postInvalidateOnAnimation();
            this.expandedTextBlend = lerp(1.0f, 0.0f, f4, vsVar);
            view.postInvalidateOnAnimation();
            colorStateList = this.collapsedTextColor;
            colorStateList2 = this.expandedTextColor;
            if (colorStateList != colorStateList2) {
                currentColor = blendColors(getCurrentColor(colorStateList2), getCurrentColor(this.collapsedTextColor), f5);
            } else {
                currentColor = getCurrentColor(colorStateList);
            }
            textPaint.setColor(currentColor);
            fLerp = this.collapsedLetterSpacing;
            f6 = this.expandedLetterSpacing;
            if (fLerp != f6) {
                fLerp = lerp(f6, fLerp, f4, vsVar);
            }
            textPaint.setLetterSpacing(fLerp);
            textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f4, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f4, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f4, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f4));
            if (this.fadeModeEnabled) {
                int alpha7 = textPaint.getAlpha();
                f7 = this.fadeModeThresholdFraction;
                if (f4 <= f7) {
                    fLerp2 = AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f7, f4);
                } else {
                    fLerp2 = AnimationUtils.lerp(0.0f, 1.0f, f7, 1.0f, f4);
                }
                textPaint.setAlpha((int) (fLerp2 * alpha7));
            }
            view.postInvalidateOnAnimation();
        }
        fCenterX2 = rect.centerX();
        width /= 2.0f;
        f3 = fCenterX2 - width;
        this.expandedDrawX = f3;
        bitmap = this.expandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            this.expandedTitleTexture = null;
        }
        setInterpolatedTextSize(f8);
        f4 = this.expandedFraction;
        z2 = this.fadeModeEnabled;
        rectF = this.currentBounds;
        if (z2) {
            if (f4 < this.fadeModeThresholdFraction) {
                rect2 = rect;
            }
            rectF.set(rect2);
        } else {
            rectF.left = lerp(rect.left, rect2.left, f4, this.positionInterpolator);
            rectF.top = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
            rectF.right = lerp(rect.right, rect2.right, f4, this.positionInterpolator);
            rectF.bottom = lerp(rect.bottom, rect2.bottom, f4, this.positionInterpolator);
        }
        if (this.fadeModeEnabled) {
            this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f4, this.positionInterpolator);
            this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f4, this.positionInterpolator);
            setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f4, this.textSizeInterpolator));
            f5 = f4;
        } else if (f4 < this.fadeModeThresholdFraction) {
            this.currentDrawX = this.expandedDrawX;
            this.currentDrawY = this.expandedDrawY;
            setInterpolatedTextSize(this.expandedTextSize);
            f5 = 0.0f;
        } else {
            this.currentDrawX = this.collapsedDrawX;
            this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
            setInterpolatedTextSize(this.collapsedTextSize);
            f5 = 1.0f;
        }
        vsVar = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        this.collapsedTextBlend = 1.0f - lerp(0.0f, 1.0f, 1.0f - f4, vsVar);
        WeakHashMap weakHashMap8 = qd1.a;
        view.postInvalidateOnAnimation();
        this.expandedTextBlend = lerp(1.0f, 0.0f, f4, vsVar);
        view.postInvalidateOnAnimation();
        colorStateList = this.collapsedTextColor;
        colorStateList2 = this.expandedTextColor;
        if (colorStateList != colorStateList2) {
            currentColor = blendColors(getCurrentColor(colorStateList2), getCurrentColor(this.collapsedTextColor), f5);
        } else {
            currentColor = getCurrentColor(colorStateList);
        }
        textPaint.setColor(currentColor);
        fLerp = this.collapsedLetterSpacing;
        f6 = this.expandedLetterSpacing;
        if (fLerp != f6) {
            fLerp = lerp(f6, fLerp, f4, vsVar);
        }
        textPaint.setLetterSpacing(fLerp);
        textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f4, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f4, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f4, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f4));
        if (this.fadeModeEnabled) {
            int alpha8 = textPaint.getAlpha();
            f7 = this.fadeModeThresholdFraction;
            if (f4 <= f7) {
                fLerp2 = AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f7, f4);
            } else {
                fLerp2 = AnimationUtils.lerp(0.0f, 1.0f, f7, 1.0f, f4);
            }
            textPaint.setAlpha((int) (fLerp2 * alpha8));
        }
        view.postInvalidateOnAnimation();
    }

    public final void setCollapsedTextAppearance(int i) {
        View view = this.view;
        TextAppearance textAppearance = new TextAppearance(view.getContext(), i);
        ColorStateList colorStateList = textAppearance.textColor;
        if (colorStateList != null) {
            this.collapsedTextColor = colorStateList;
        }
        float f = textAppearance.textSize;
        if (f != 0.0f) {
            this.collapsedTextSize = f;
        }
        ColorStateList colorStateList2 = textAppearance.shadowColor;
        if (colorStateList2 != null) {
            this.collapsedShadowColor = colorStateList2;
        }
        this.collapsedShadowDx = textAppearance.shadowDx;
        this.collapsedShadowDy = textAppearance.shadowDy;
        this.collapsedShadowRadius = textAppearance.shadowRadius;
        this.collapsedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        CancelableFontCallback.ApplyFont applyFont = new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.1
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public final void apply(Typeface typeface) {
                CollapsingTextHelper collapsingTextHelper = CollapsingTextHelper.this;
                CancelableFontCallback cancelableFontCallback2 = collapsingTextHelper.collapsedFontCallback;
                if (cancelableFontCallback2 != null) {
                    cancelableFontCallback2.cancelled = true;
                }
                if (collapsingTextHelper.collapsedTypeface != typeface) {
                    collapsingTextHelper.collapsedTypeface = typeface;
                    collapsingTextHelper.recalculate(false);
                }
            }
        };
        textAppearance.createFallbackFont();
        this.collapsedFontCallback = new CancelableFontCallback(applyFont, textAppearance.font);
        textAppearance.getFontAsync(view.getContext(), this.collapsedFontCallback);
        recalculate(false);
    }

    public final void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate(false);
        }
    }

    public final void setExpandedTextAppearance(int i) {
        View view = this.view;
        TextAppearance textAppearance = new TextAppearance(view.getContext(), i);
        ColorStateList colorStateList = textAppearance.textColor;
        if (colorStateList != null) {
            this.expandedTextColor = colorStateList;
        }
        float f = textAppearance.textSize;
        if (f != 0.0f) {
            this.expandedTextSize = f;
        }
        ColorStateList colorStateList2 = textAppearance.shadowColor;
        if (colorStateList2 != null) {
            this.expandedShadowColor = colorStateList2;
        }
        this.expandedShadowDx = textAppearance.shadowDx;
        this.expandedShadowDy = textAppearance.shadowDy;
        this.expandedShadowRadius = textAppearance.shadowRadius;
        this.expandedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        CancelableFontCallback.ApplyFont applyFont = new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.2
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public final void apply(Typeface typeface) {
                CollapsingTextHelper collapsingTextHelper = CollapsingTextHelper.this;
                CancelableFontCallback cancelableFontCallback2 = collapsingTextHelper.expandedFontCallback;
                if (cancelableFontCallback2 != null) {
                    cancelableFontCallback2.cancelled = true;
                }
                if (collapsingTextHelper.expandedTypeface != typeface) {
                    collapsingTextHelper.expandedTypeface = typeface;
                    collapsingTextHelper.recalculate(false);
                }
            }
        };
        textAppearance.createFallbackFont();
        this.expandedFontCallback = new CancelableFontCallback(applyFont, textAppearance.font);
        textAppearance.getFontAsync(view.getContext(), this.expandedFontCallback);
        recalculate(false);
    }

    public final void setExpansionFraction(float f) {
        float f2;
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.expandedFraction) {
            this.expandedFraction = f;
            boolean z = this.fadeModeEnabled;
            Rect rect = this.collapsedBounds;
            Rect rect2 = this.expandedBounds;
            RectF rectF = this.currentBounds;
            if (z) {
                if (f < this.fadeModeThresholdFraction) {
                    rect = rect2;
                }
                rectF.set(rect);
            } else {
                rectF.left = lerp(rect2.left, rect.left, f, this.positionInterpolator);
                rectF.top = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
                rectF.right = lerp(rect2.right, rect.right, f, this.positionInterpolator);
                rectF.bottom = lerp(rect2.bottom, rect.bottom, f, this.positionInterpolator);
            }
            if (!this.fadeModeEnabled) {
                this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f, this.positionInterpolator);
                this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
                setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f, this.textSizeInterpolator));
                f2 = f;
            } else if (f < this.fadeModeThresholdFraction) {
                this.currentDrawX = this.expandedDrawX;
                this.currentDrawY = this.expandedDrawY;
                setInterpolatedTextSize(this.expandedTextSize);
                f2 = 0.0f;
            } else {
                this.currentDrawX = this.collapsedDrawX;
                this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
                setInterpolatedTextSize(this.collapsedTextSize);
                f2 = 1.0f;
            }
            vs vsVar = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
            this.collapsedTextBlend = 1.0f - lerp(0.0f, 1.0f, 1.0f - f, vsVar);
            WeakHashMap weakHashMap = qd1.a;
            View view = this.view;
            view.postInvalidateOnAnimation();
            this.expandedTextBlend = lerp(1.0f, 0.0f, f, vsVar);
            view.postInvalidateOnAnimation();
            ColorStateList colorStateList = this.collapsedTextColor;
            ColorStateList colorStateList2 = this.expandedTextColor;
            TextPaint textPaint = this.textPaint;
            textPaint.setColor(colorStateList != colorStateList2 ? blendColors(getCurrentColor(colorStateList2), getCurrentColor(this.collapsedTextColor), f2) : getCurrentColor(colorStateList));
            float fLerp = this.collapsedLetterSpacing;
            float f3 = this.expandedLetterSpacing;
            if (fLerp != f3) {
                fLerp = lerp(f3, fLerp, f, vsVar);
            }
            textPaint.setLetterSpacing(fLerp);
            textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f));
            if (this.fadeModeEnabled) {
                int alpha = textPaint.getAlpha();
                float f4 = this.fadeModeThresholdFraction;
                textPaint.setAlpha((int) ((f <= f4 ? AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f4, f) : AnimationUtils.lerp(0.0f, 1.0f, f4, 1.0f, f)) * alpha));
            }
            view.postInvalidateOnAnimation();
        }
    }

    public final void setInterpolatedTextSize(float f) {
        calculateUsingTextSize(f, false);
        WeakHashMap weakHashMap = qd1.a;
        this.view.postInvalidateOnAnimation();
    }
}
