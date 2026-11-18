package com.github.guilhe.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.github.guilhe.views.circularprogress.R$styleable;
import defpackage.d;
import defpackage.zk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class CircularProgressView extends View {
    public static final DecelerateInterpolator DEFAULT_INTERPOLATOR = new DecelerateInterpolator();
    public final Paint backgroundPaint;
    public final int defaultMaxWidth;
    public final float defaultShadowPadding;
    public final float defaultViewPadding;
    public boolean initShader;
    public final boolean isBackgroundAlphaEnabled;
    public final boolean isProgressRounded;
    public final boolean isProgressThumbEnabled;
    public final boolean isReverseEnabled;
    public final boolean isShadowEnabled;
    public float lastValidRawMeasuredDim;
    public float lastValidStrokeThickness;
    public float lastValidThumbSize;
    public float lastValidThumbSizeRate;
    public final int max;
    public float progress;
    public ValueAnimator progressAnimator;
    public int progressBackgroundColor;
    public int progressColor;
    public float progressIconThickness;
    public final DecelerateInterpolator progressInterpolator;
    public final float progressMaxThumbSizeRate;
    public final Paint progressPaint;
    public final ArrayList progressPaintList;
    public final RectF progressRectF;
    public float progressStrokeThickness;
    public final ProgressThumbScaleType progressThumbScaleType;
    public float progressThumbSize;
    public float progressThumbSizeRate;
    public final int[] shaderColors;
    public final float[] shaderPositions;
    public final Paint shadowPaint;
    public final RectF shadowRectF;
    public final Paint shadowThumbPaint;
    public final int startingAngle;
    public final Paint thumbPaint;
    public final ArrayList valuesToDrawList;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProgressThumbScaleType.values().length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ProgressThumbScaleType[] progressThumbScaleTypeArr = ProgressThumbScaleType.$VALUES;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CircularProgressView(Context context) {
        this(context, null, 0, 6, null);
    }

    public CircularProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public CircularProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.defaultViewPadding = dpToPx(10.0f);
        this.defaultShadowPadding = dpToPx(5.0f);
        float fDpToPx = dpToPx(10.0f);
        float fDpToPx2 = dpToPx(10.0f);
        this.defaultMaxWidth = dpToPx(100.0f);
        this.valuesToDrawList = new ArrayList();
        new ArrayList();
        this.progressPaintList = new ArrayList();
        this.progressThumbSizeRate = 2.0f;
        this.progressStrokeThickness = fDpToPx;
        this.lastValidStrokeThickness = fDpToPx;
        this.lastValidThumbSize = fDpToPx2;
        this.lastValidThumbSizeRate = 2.0f;
        this.progressInterpolator = DEFAULT_INTERPOLATOR;
        this.shaderColors = new int[0];
        this.shaderPositions = new float[0];
        this.progressThumbScaleType = ProgressThumbScaleType.AUTO;
        this.progressMaxThumbSizeRate = 2.0f;
        this.progressThumbSize = fDpToPx2;
        this.isShadowEnabled = true;
        this.progressColor = -16777216;
        this.progressBackgroundColor = -16777216;
        this.startingAngle = 270;
        this.max = 100;
        this.progressRectF = new RectF();
        this.shadowRectF = new RectF();
        Paint paint = new Paint(1);
        this.backgroundPaint = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint paint2 = new Paint(1);
        this.progressPaint = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.shadowPaint = paint3;
        paint3.setStyle(style);
        Paint paint4 = new Paint(1);
        this.shadowThumbPaint = paint4;
        Paint.Style style2 = Paint.Style.FILL;
        paint4.setStyle(style2);
        Paint paint5 = new Paint(1);
        this.thumbPaint = paint5;
        paint5.setStyle(style2);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.CircularProgressView, 0, 0);
            try {
                this.max = typedArrayObtainStyledAttributes.getInt(1, 100);
                invalidate();
                this.isShadowEnabled = typedArrayObtainStyledAttributes.getBoolean(16, true);
                invalidate();
                this.isProgressThumbEnabled = typedArrayObtainStyledAttributes.getBoolean(10, false);
                invalidate();
                requestLayout();
                this.progressThumbScaleType = ProgressThumbScaleType.values()[typedArrayObtainStyledAttributes.getInteger(11, 0)];
                this.progressMaxThumbSizeRate = typedArrayObtainStyledAttributes.getFloat(13, 2.0f);
                this.startingAngle = typedArrayObtainStyledAttributes.getInteger(17, 270);
                invalidate();
                this.progress = typedArrayObtainStyledAttributes.getFloat(2, 0.0f);
                this.progressStrokeThickness = typedArrayObtainStyledAttributes.getDimension(9, fDpToPx);
                this.progressThumbSize = typedArrayObtainStyledAttributes.getDimension(12, fDpToPx2);
                this.progressThumbSizeRate = typedArrayObtainStyledAttributes.getFloat(14, 2.0f);
                int i2 = typedArrayObtainStyledAttributes.getInt(5, -16777216);
                this.progressColor = i2;
                if (i2 == -1) {
                    this.progressBackgroundColor = i2;
                    resetBackgroundPaint();
                    invalidate();
                }
                paint2.setColor(i2);
                paint2.setShader(null);
                invalidate();
                boolean z = typedArrayObtainStyledAttributes.getBoolean(8, false);
                this.isProgressRounded = z;
                paint2.setStrokeCap(z ? Paint.Cap.ROUND : Paint.Cap.SQUARE);
                paint3.setStrokeCap(paint2.getStrokeCap());
                invalidate();
                this.progressBackgroundColor = typedArrayObtainStyledAttributes.getInt(4, this.progressColor);
                resetBackgroundPaint();
                invalidate();
                this.isBackgroundAlphaEnabled = typedArrayObtainStyledAttributes.getBoolean(3, true);
                resetBackgroundPaint();
                invalidate();
                this.isReverseEnabled = typedArrayObtainStyledAttributes.getBoolean(15, false);
                invalidate();
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(6, -1);
                boolean z2 = typedArrayObtainStyledAttributes.getBoolean(0, false);
                if (resourceId != -1) {
                    int[] intArray = typedArrayObtainStyledAttributes.getResources().getIntArray(resourceId);
                    this.shaderColors = intArray;
                    if (z2) {
                        int[] iArrCopyOf = Arrays.copyOf(intArray, intArray.length + 1);
                        iArrCopyOf[intArray.length] = intArray[0];
                        this.shaderColors = iArrCopyOf;
                    }
                    this.initShader = true;
                }
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(7, -1);
                if (resourceId2 != -1) {
                    TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId2);
                    this.shaderPositions = new float[typedArrayObtainTypedArray.length()];
                    int length = typedArrayObtainTypedArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        this.shaderPositions[i3] = typedArrayObtainTypedArray.getFloat(i3, 0.0f);
                    }
                    typedArrayObtainTypedArray.recycle();
                }
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        resetBackgroundPaint();
        Paint paint6 = this.progressPaint;
        paint6.getClass();
        paint6.setColor(this.progressColor);
        Paint paint7 = this.progressPaint;
        paint7.getClass();
        paint7.setShader(null);
        Paint paint8 = this.progressPaint;
        paint8.getClass();
        paint8.setStrokeCap(this.isProgressRounded ? Paint.Cap.ROUND : Paint.Cap.SQUARE);
        Paint paint9 = this.shadowPaint;
        paint9.getClass();
        paint9.setColor(adjustAlpha(-16777216, 0.2f));
        Paint paint10 = this.shadowPaint;
        paint10.getClass();
        Paint paint11 = this.progressPaint;
        paint11.getClass();
        paint10.setStrokeCap(paint11.getStrokeCap());
        setThickness(this.progressStrokeThickness);
    }

    public /* synthetic */ CircularProgressView(Context context, AttributeSet attributeSet, int i, int i2, zk zkVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static int adjustAlpha(int i, float f) {
        float fAlpha = Color.alpha(i) * f;
        if (!Float.isNaN(fAlpha)) {
            return Color.argb(Math.round(fAlpha), Color.red(i), Color.green(i), Color.blue(i));
        }
        d.AnonymousClass0.m$2("Cannot round NaN value.");
        return 0;
    }

    public static int dpToPx(float f) {
        return (int) Math.ceil(((double) f) * ((double) Resources.getSystem().getDisplayMetrics().density));
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007c A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:4:0x0005, B:6:0x0024, B:8:0x003d, B:27:0x0073, B:29:0x007c, B:31:0x0088, B:32:0x0089, B:34:0x008e, B:36:0x00ac, B:38:0x00b0, B:41:0x00c1, B:43:0x00c5, B:48:0x00cf, B:50:0x00d7, B:52:0x00e1, B:54:0x00ea, B:62:0x00f9, B:64:0x00fd, B:66:0x0101, B:70:0x010b, B:72:0x010f, B:74:0x0118, B:76:0x0120, B:79:0x012c, B:83:0x013b, B:85:0x0145, B:87:0x0149, B:89:0x014d, B:91:0x0168, B:92:0x016a, B:94:0x0170, B:96:0x018c, B:98:0x01a6, B:101:0x01c0, B:103:0x01c4, B:108:0x01ce, B:110:0x01d6, B:112:0x01e0, B:114:0x01e9, B:115:0x01ed, B:116:0x01ee, B:117:0x01ef, B:104:0x01c7, B:105:0x01c8, B:107:0x01cc, B:118:0x01f0, B:119:0x01f1, B:80:0x0138, B:81:0x0139, B:67:0x0106, B:68:0x0107, B:55:0x00f0, B:56:0x00f1, B:57:0x00f2, B:44:0x00c8, B:45:0x00c9, B:47:0x00cd, B:58:0x00f3, B:59:0x00f4, B:60:0x00f5, B:11:0x0047, B:13:0x004b, B:25:0x006e, B:16:0x0056, B:18:0x005a, B:125:0x0201), top: B:128:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0088 A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:4:0x0005, B:6:0x0024, B:8:0x003d, B:27:0x0073, B:29:0x007c, B:31:0x0088, B:32:0x0089, B:34:0x008e, B:36:0x00ac, B:38:0x00b0, B:41:0x00c1, B:43:0x00c5, B:48:0x00cf, B:50:0x00d7, B:52:0x00e1, B:54:0x00ea, B:62:0x00f9, B:64:0x00fd, B:66:0x0101, B:70:0x010b, B:72:0x010f, B:74:0x0118, B:76:0x0120, B:79:0x012c, B:83:0x013b, B:85:0x0145, B:87:0x0149, B:89:0x014d, B:91:0x0168, B:92:0x016a, B:94:0x0170, B:96:0x018c, B:98:0x01a6, B:101:0x01c0, B:103:0x01c4, B:108:0x01ce, B:110:0x01d6, B:112:0x01e0, B:114:0x01e9, B:115:0x01ed, B:116:0x01ee, B:117:0x01ef, B:104:0x01c7, B:105:0x01c8, B:107:0x01cc, B:118:0x01f0, B:119:0x01f1, B:80:0x0138, B:81:0x0139, B:67:0x0106, B:68:0x0107, B:55:0x00f0, B:56:0x00f1, B:57:0x00f2, B:44:0x00c8, B:45:0x00c9, B:47:0x00cd, B:58:0x00f3, B:59:0x00f4, B:60:0x00f5, B:11:0x0047, B:13:0x004b, B:25:0x006e, B:16:0x0056, B:18:0x005a, B:125:0x0201), top: B:128:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x008e A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:4:0x0005, B:6:0x0024, B:8:0x003d, B:27:0x0073, B:29:0x007c, B:31:0x0088, B:32:0x0089, B:34:0x008e, B:36:0x00ac, B:38:0x00b0, B:41:0x00c1, B:43:0x00c5, B:48:0x00cf, B:50:0x00d7, B:52:0x00e1, B:54:0x00ea, B:62:0x00f9, B:64:0x00fd, B:66:0x0101, B:70:0x010b, B:72:0x010f, B:74:0x0118, B:76:0x0120, B:79:0x012c, B:83:0x013b, B:85:0x0145, B:87:0x0149, B:89:0x014d, B:91:0x0168, B:92:0x016a, B:94:0x0170, B:96:0x018c, B:98:0x01a6, B:101:0x01c0, B:103:0x01c4, B:108:0x01ce, B:110:0x01d6, B:112:0x01e0, B:114:0x01e9, B:115:0x01ed, B:116:0x01ee, B:117:0x01ef, B:104:0x01c7, B:105:0x01c8, B:107:0x01cc, B:118:0x01f0, B:119:0x01f1, B:80:0x0138, B:81:0x0139, B:67:0x0106, B:68:0x0107, B:55:0x00f0, B:56:0x00f1, B:57:0x00f2, B:44:0x00c8, B:45:0x00c9, B:47:0x00cd, B:58:0x00f3, B:59:0x00f4, B:60:0x00f5, B:11:0x0047, B:13:0x004b, B:25:0x006e, B:16:0x0056, B:18:0x005a, B:125:0x0201), top: B:128:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:69:0x0108  */
    /* JADX WARN: Code duplicated, block: B:72:0x010f A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:4:0x0005, B:6:0x0024, B:8:0x003d, B:27:0x0073, B:29:0x007c, B:31:0x0088, B:32:0x0089, B:34:0x008e, B:36:0x00ac, B:38:0x00b0, B:41:0x00c1, B:43:0x00c5, B:48:0x00cf, B:50:0x00d7, B:52:0x00e1, B:54:0x00ea, B:62:0x00f9, B:64:0x00fd, B:66:0x0101, B:70:0x010b, B:72:0x010f, B:74:0x0118, B:76:0x0120, B:79:0x012c, B:83:0x013b, B:85:0x0145, B:87:0x0149, B:89:0x014d, B:91:0x0168, B:92:0x016a, B:94:0x0170, B:96:0x018c, B:98:0x01a6, B:101:0x01c0, B:103:0x01c4, B:108:0x01ce, B:110:0x01d6, B:112:0x01e0, B:114:0x01e9, B:115:0x01ed, B:116:0x01ee, B:117:0x01ef, B:104:0x01c7, B:105:0x01c8, B:107:0x01cc, B:118:0x01f0, B:119:0x01f1, B:80:0x0138, B:81:0x0139, B:67:0x0106, B:68:0x0107, B:55:0x00f0, B:56:0x00f1, B:57:0x00f2, B:44:0x00c8, B:45:0x00c9, B:47:0x00cd, B:58:0x00f3, B:59:0x00f4, B:60:0x00f5, B:11:0x0047, B:13:0x004b, B:25:0x006e, B:16:0x0056, B:18:0x005a, B:125:0x0201), top: B:128:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0118 A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:4:0x0005, B:6:0x0024, B:8:0x003d, B:27:0x0073, B:29:0x007c, B:31:0x0088, B:32:0x0089, B:34:0x008e, B:36:0x00ac, B:38:0x00b0, B:41:0x00c1, B:43:0x00c5, B:48:0x00cf, B:50:0x00d7, B:52:0x00e1, B:54:0x00ea, B:62:0x00f9, B:64:0x00fd, B:66:0x0101, B:70:0x010b, B:72:0x010f, B:74:0x0118, B:76:0x0120, B:79:0x012c, B:83:0x013b, B:85:0x0145, B:87:0x0149, B:89:0x014d, B:91:0x0168, B:92:0x016a, B:94:0x0170, B:96:0x018c, B:98:0x01a6, B:101:0x01c0, B:103:0x01c4, B:108:0x01ce, B:110:0x01d6, B:112:0x01e0, B:114:0x01e9, B:115:0x01ed, B:116:0x01ee, B:117:0x01ef, B:104:0x01c7, B:105:0x01c8, B:107:0x01cc, B:118:0x01f0, B:119:0x01f1, B:80:0x0138, B:81:0x0139, B:67:0x0106, B:68:0x0107, B:55:0x00f0, B:56:0x00f1, B:57:0x00f2, B:44:0x00c8, B:45:0x00c9, B:47:0x00cd, B:58:0x00f3, B:59:0x00f4, B:60:0x00f5, B:11:0x0047, B:13:0x004b, B:25:0x006e, B:16:0x0056, B:18:0x005a, B:125:0x0201), top: B:128:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0120 A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:4:0x0005, B:6:0x0024, B:8:0x003d, B:27:0x0073, B:29:0x007c, B:31:0x0088, B:32:0x0089, B:34:0x008e, B:36:0x00ac, B:38:0x00b0, B:41:0x00c1, B:43:0x00c5, B:48:0x00cf, B:50:0x00d7, B:52:0x00e1, B:54:0x00ea, B:62:0x00f9, B:64:0x00fd, B:66:0x0101, B:70:0x010b, B:72:0x010f, B:74:0x0118, B:76:0x0120, B:79:0x012c, B:83:0x013b, B:85:0x0145, B:87:0x0149, B:89:0x014d, B:91:0x0168, B:92:0x016a, B:94:0x0170, B:96:0x018c, B:98:0x01a6, B:101:0x01c0, B:103:0x01c4, B:108:0x01ce, B:110:0x01d6, B:112:0x01e0, B:114:0x01e9, B:115:0x01ed, B:116:0x01ee, B:117:0x01ef, B:104:0x01c7, B:105:0x01c8, B:107:0x01cc, B:118:0x01f0, B:119:0x01f1, B:80:0x0138, B:81:0x0139, B:67:0x0106, B:68:0x0107, B:55:0x00f0, B:56:0x00f1, B:57:0x00f2, B:44:0x00c8, B:45:0x00c9, B:47:0x00cd, B:58:0x00f3, B:59:0x00f4, B:60:0x00f5, B:11:0x0047, B:13:0x004b, B:25:0x006e, B:16:0x0056, B:18:0x005a, B:125:0x0201), top: B:128:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x012b  */
    /* JADX WARN: Code duplicated, block: B:80:0x0138 A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:4:0x0005, B:6:0x0024, B:8:0x003d, B:27:0x0073, B:29:0x007c, B:31:0x0088, B:32:0x0089, B:34:0x008e, B:36:0x00ac, B:38:0x00b0, B:41:0x00c1, B:43:0x00c5, B:48:0x00cf, B:50:0x00d7, B:52:0x00e1, B:54:0x00ea, B:62:0x00f9, B:64:0x00fd, B:66:0x0101, B:70:0x010b, B:72:0x010f, B:74:0x0118, B:76:0x0120, B:79:0x012c, B:83:0x013b, B:85:0x0145, B:87:0x0149, B:89:0x014d, B:91:0x0168, B:92:0x016a, B:94:0x0170, B:96:0x018c, B:98:0x01a6, B:101:0x01c0, B:103:0x01c4, B:108:0x01ce, B:110:0x01d6, B:112:0x01e0, B:114:0x01e9, B:115:0x01ed, B:116:0x01ee, B:117:0x01ef, B:104:0x01c7, B:105:0x01c8, B:107:0x01cc, B:118:0x01f0, B:119:0x01f1, B:80:0x0138, B:81:0x0139, B:67:0x0106, B:68:0x0107, B:55:0x00f0, B:56:0x00f1, B:57:0x00f2, B:44:0x00c8, B:45:0x00c9, B:47:0x00cd, B:58:0x00f3, B:59:0x00f4, B:60:0x00f5, B:11:0x0047, B:13:0x004b, B:25:0x006e, B:16:0x0056, B:18:0x005a, B:125:0x0201), top: B:128:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0139 A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:4:0x0005, B:6:0x0024, B:8:0x003d, B:27:0x0073, B:29:0x007c, B:31:0x0088, B:32:0x0089, B:34:0x008e, B:36:0x00ac, B:38:0x00b0, B:41:0x00c1, B:43:0x00c5, B:48:0x00cf, B:50:0x00d7, B:52:0x00e1, B:54:0x00ea, B:62:0x00f9, B:64:0x00fd, B:66:0x0101, B:70:0x010b, B:72:0x010f, B:74:0x0118, B:76:0x0120, B:79:0x012c, B:83:0x013b, B:85:0x0145, B:87:0x0149, B:89:0x014d, B:91:0x0168, B:92:0x016a, B:94:0x0170, B:96:0x018c, B:98:0x01a6, B:101:0x01c0, B:103:0x01c4, B:108:0x01ce, B:110:0x01d6, B:112:0x01e0, B:114:0x01e9, B:115:0x01ed, B:116:0x01ee, B:117:0x01ef, B:104:0x01c7, B:105:0x01c8, B:107:0x01cc, B:118:0x01f0, B:119:0x01f1, B:80:0x0138, B:81:0x0139, B:67:0x0106, B:68:0x0107, B:55:0x00f0, B:56:0x00f1, B:57:0x00f2, B:44:0x00c8, B:45:0x00c9, B:47:0x00cd, B:58:0x00f3, B:59:0x00f4, B:60:0x00f5, B:11:0x0047, B:13:0x004b, B:25:0x006e, B:16:0x0056, B:18:0x005a, B:125:0x0201), top: B:128:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x013a  */
    /* JADX WARN: Code duplicated, block: B:85:0x0145 A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:4:0x0005, B:6:0x0024, B:8:0x003d, B:27:0x0073, B:29:0x007c, B:31:0x0088, B:32:0x0089, B:34:0x008e, B:36:0x00ac, B:38:0x00b0, B:41:0x00c1, B:43:0x00c5, B:48:0x00cf, B:50:0x00d7, B:52:0x00e1, B:54:0x00ea, B:62:0x00f9, B:64:0x00fd, B:66:0x0101, B:70:0x010b, B:72:0x010f, B:74:0x0118, B:76:0x0120, B:79:0x012c, B:83:0x013b, B:85:0x0145, B:87:0x0149, B:89:0x014d, B:91:0x0168, B:92:0x016a, B:94:0x0170, B:96:0x018c, B:98:0x01a6, B:101:0x01c0, B:103:0x01c4, B:108:0x01ce, B:110:0x01d6, B:112:0x01e0, B:114:0x01e9, B:115:0x01ed, B:116:0x01ee, B:117:0x01ef, B:104:0x01c7, B:105:0x01c8, B:107:0x01cc, B:118:0x01f0, B:119:0x01f1, B:80:0x0138, B:81:0x0139, B:67:0x0106, B:68:0x0107, B:55:0x00f0, B:56:0x00f1, B:57:0x00f2, B:44:0x00c8, B:45:0x00c9, B:47:0x00cd, B:58:0x00f3, B:59:0x00f4, B:60:0x00f5, B:11:0x0047, B:13:0x004b, B:25:0x006e, B:16:0x0056, B:18:0x005a, B:125:0x0201), top: B:128:0x0005 }] */
    @Override // android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        float f;
        boolean z;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i;
        int size;
        int i2;
        RectF rectF;
        Paint paint;
        char c;
        Paint paint2;
        Paint.Style style;
        RectF rectF2;
        float fCenterX;
        RectF rectF3;
        float[] fArr;
        float f7;
        float f8;
        RectF rectF4;
        Paint paint3;
        Paint paint4;
        Paint paint5;
        Paint paint6;
        Paint.Style style2;
        try {
            super.onDraw(canvas);
            this.valuesToDrawList.clear();
            this.valuesToDrawList.add(Float.valueOf(this.progress));
            this.progressPaintList.clear();
            ArrayList arrayList = this.progressPaintList;
            Paint paint7 = this.progressPaint;
            Throwable th = null;
            if (paint7 != null) {
                arrayList.add(paint7);
                float f9 = this.startingAngle;
                char c2 = 2;
                float f10 = 2;
                float width = (getWidth() / f10) - this.defaultViewPadding;
                ProgressThumbScaleType progressThumbScaleType = this.progressThumbScaleType;
                float f11 = 0.0f;
                if (progressThumbScaleType == ProgressThumbScaleType.AUTO) {
                    f = this.progressIconThickness;
                    f2 = (this.progressStrokeThickness / f10) + f;
                } else {
                    if (progressThumbScaleType == ProgressThumbScaleType.POINT) {
                        f = this.progressThumbSize;
                        z = f * f10 > this.progressStrokeThickness;
                    } else {
                        if (progressThumbScaleType == ProgressThumbScaleType.RATE) {
                            float f12 = this.progressStrokeThickness / f10;
                            float f13 = this.progressThumbSizeRate;
                            f = f12 * f13;
                            if (f13 > 1.0f) {
                            }
                        } else {
                            f = 0.0f;
                        }
                    }
                    if (z) {
                        f3 = f;
                    } else {
                        f2 = this.progressStrokeThickness / f10;
                    }
                    f4 = width - f;
                    f5 = -1.0f;
                    if (this.isShadowEnabled) {
                        f7 = (360 * this.progress) / this.max;
                        if (this.isReverseEnabled) {
                            f7 *= -1.0f;
                        }
                        f8 = f7;
                        if (this.isProgressThumbEnabled) {
                            double d = ((double) f9) + ((double) f8);
                            float f14 = f3;
                            double d2 = f4;
                            double dCos = Math.cos(Math.toRadians(d)) * d2;
                            double dSin = Math.sin(Math.toRadians(d)) * d2;
                            paint4 = this.shadowThumbPaint;
                            if (paint4 == null || (paint5 = this.shadowPaint) == null) {
                                throw null;
                            }
                            paint4.set(paint5);
                            int i3 = WhenMappings.$EnumSwitchMapping$0[this.progressThumbScaleType.ordinal()];
                            if (i3 == 1 || i3 == 2) {
                                paint6 = this.shadowThumbPaint;
                                if (paint6 == null) {
                                    throw null;
                                }
                                style2 = Paint.Style.FILL;
                            } else {
                                paint6 = this.shadowThumbPaint;
                                if (paint6 == null) {
                                    throw null;
                                }
                                style2 = Paint.Style.STROKE;
                            }
                            paint6.setStyle(style2);
                            float f15 = (float) dCos;
                            RectF rectF5 = this.shadowRectF;
                            if (rectF5 == null) {
                                throw null;
                            }
                            float fCenterX2 = f15 + rectF5.centerX();
                            float f16 = (float) dSin;
                            RectF rectF6 = this.shadowRectF;
                            if (rectF6 == null) {
                                throw null;
                            }
                            float fCenterY = f16 + rectF6.centerY();
                            Paint paint8 = this.shadowThumbPaint;
                            if (paint8 == null) {
                                throw null;
                            }
                            f6 = f14;
                            canvas.drawCircle(fCenterX2, fCenterY, f6, paint8);
                        } else {
                            f6 = f3;
                        }
                        rectF4 = this.shadowRectF;
                        if (rectF4 == null || (paint3 = this.shadowPaint) == null) {
                            throw null;
                        }
                        canvas.drawArc(rectF4, f9, f8, false, paint3);
                    } else {
                        f6 = f3;
                        f5 = -1.0f;
                    }
                    if (this.initShader) {
                        i = 0;
                        this.initShader = false;
                        rectF2 = this.progressRectF;
                        if (rectF2 != null) {
                            throw null;
                        }
                        fCenterX = rectF2.centerX();
                        rectF3 = this.progressRectF;
                        if (rectF3 != null) {
                            throw null;
                        }
                        float fCenterY2 = rectF3.centerY();
                        int[] iArr = this.shaderColors;
                        fArr = this.shaderPositions;
                        if (fArr.length == 0) {
                            fArr = null;
                        }
                        SweepGradient sweepGradient = new SweepGradient(fCenterX, fCenterY2, iArr, fArr);
                        Paint paint9 = this.progressPaint;
                        paint9.getClass();
                        paint9.setShader(sweepGradient);
                    } else {
                        i = 0;
                    }
                    size = this.valuesToDrawList.size();
                    i2 = i;
                    float f17 = f9;
                    while (i2 < size) {
                        rectF = this.progressRectF;
                        if (rectF == null && (paint = this.backgroundPaint) != null) {
                            canvas.drawOval(rectF, paint);
                            float fFloatValue = (360 * ((Number) this.valuesToDrawList.get(i2)).floatValue()) / this.max;
                            if (this.isReverseEnabled) {
                                fFloatValue *= f5;
                            }
                            RectF rectF7 = this.progressRectF;
                            if (rectF7 != null) {
                                float f18 = fFloatValue;
                                Throwable th2 = th;
                                canvas.drawArc(rectF7, f17 - f11, f18 + f11, false, (Paint) this.progressPaintList.get(i2));
                                if (this.isProgressThumbEnabled) {
                                    double d3 = ((double) f17) + ((double) f18);
                                    double d4 = f4;
                                    double dCos2 = Math.cos(Math.toRadians(d3)) * d4;
                                    double dSin2 = Math.sin(Math.toRadians(d3)) * d4;
                                    Paint paint10 = this.thumbPaint;
                                    if (paint10 == null) {
                                        throw th2;
                                    }
                                    paint10.set((Paint) this.progressPaintList.get(i2));
                                    int i4 = WhenMappings.$EnumSwitchMapping$0[this.progressThumbScaleType.ordinal()];
                                    c = 2;
                                    if (i4 == 1 || i4 == 2) {
                                        paint2 = this.thumbPaint;
                                        if (paint2 == null) {
                                            throw th2;
                                        }
                                        style = Paint.Style.FILL;
                                    } else {
                                        paint2 = this.thumbPaint;
                                        if (paint2 == null) {
                                            throw th2;
                                        }
                                        style = Paint.Style.STROKE;
                                    }
                                    paint2.setStyle(style);
                                    float f19 = (float) dCos2;
                                    RectF rectF8 = this.progressRectF;
                                    if (rectF8 == null) {
                                        throw th2;
                                    }
                                    float fCenterX3 = f19 + rectF8.centerX();
                                    float f20 = (float) dSin2;
                                    RectF rectF9 = this.progressRectF;
                                    if (rectF9 == null) {
                                        throw th2;
                                    }
                                    float fCenterY3 = f20 + rectF9.centerY();
                                    Paint paint11 = this.thumbPaint;
                                    if (paint11 == null) {
                                        throw th2;
                                    }
                                    canvas.drawCircle(fCenterX3, fCenterY3, f6, paint11);
                                } else {
                                    c = c2;
                                }
                                f17 += f18;
                                i2++;
                                c2 = c;
                                th = th2;
                                f11 = 0.0f;
                            }
                        }
                    }
                }
                f3 = f;
                f = f2;
                f4 = width - f;
                f5 = -1.0f;
                if (this.isShadowEnabled) {
                    f7 = (360 * this.progress) / this.max;
                    if (this.isReverseEnabled) {
                        f7 *= -1.0f;
                    }
                    f8 = f7;
                    if (this.isProgressThumbEnabled) {
                        double d5 = ((double) f9) + ((double) f8);
                        float f110 = f3;
                        double d6 = f4;
                        double dCos3 = Math.cos(Math.toRadians(d5)) * d6;
                        double dSin3 = Math.sin(Math.toRadians(d5)) * d6;
                        paint4 = this.shadowThumbPaint;
                        if (paint4 == null) {
                            throw null;
                        }
                        throw null;
                    }
                    f6 = f3;
                    rectF4 = this.shadowRectF;
                    if (rectF4 == null) {
                        throw null;
                    }
                    throw null;
                }
                f6 = f3;
                f5 = -1.0f;
                if (this.initShader) {
                    i = 0;
                    this.initShader = false;
                    rectF2 = this.progressRectF;
                    if (rectF2 != null) {
                        throw null;
                    }
                    fCenterX = rectF2.centerX();
                    rectF3 = this.progressRectF;
                    if (rectF3 != null) {
                        throw null;
                    }
                    float fCenterY4 = rectF3.centerY();
                    int[] iArr2 = this.shaderColors;
                    fArr = this.shaderPositions;
                    if (fArr.length == 0) {
                        fArr = null;
                    }
                    SweepGradient sweepGradient2 = new SweepGradient(fCenterX, fCenterY4, iArr2, fArr);
                    Paint paint12 = this.progressPaint;
                    paint12.getClass();
                    paint12.setShader(sweepGradient2);
                } else {
                    i = 0;
                }
                size = this.valuesToDrawList.size();
                i2 = i;
                float f111 = f9;
                while (i2 < size) {
                    rectF = this.progressRectF;
                    if (rectF == null) {
                    }
                }
            }
            throw th;
        } catch (Throwable th3) {
            throw th3;
        }
    }

    @Override // android.view.View
    public final synchronized void onMeasure(int i, int i2) {
        float f;
        RectF rectF;
        try {
            int iMax = Math.max(Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getMode(i2) != 0 ? View.MeasureSpec.getSize(i2) : this.defaultMaxWidth), 0);
            float f2 = this.progressStrokeThickness;
            int i3 = WhenMappings.$EnumSwitchMapping$0[this.progressThumbScaleType.ordinal()];
            if (i3 != 1) {
                f = this.progressStrokeThickness;
                if (i3 == 2) {
                    f = (f / 2) * this.progressThumbSizeRate;
                }
            } else {
                f = this.progressThumbSize;
            }
            if (this.isProgressThumbEnabled && this.progressThumbScaleType != ProgressThumbScaleType.AUTO) {
                float f3 = 2;
                float f4 = f * f3;
                float f5 = this.progressStrokeThickness;
                f2 = f4 > f5 ? f2 + (f - f5) : f5 / f3;
            }
            float fMax = Math.max(f2, 0.0f) + this.defaultViewPadding;
            RectF rectF2 = this.progressRectF;
            if (rectF2 == null) {
                throw null;
            }
            float f6 = iMax;
            float f7 = f6 - fMax;
            rectF2.set(fMax, fMax, f7, f7);
            RectF rectF3 = this.progressRectF;
            if (rectF3 == null) {
                throw null;
            }
            if (rectF3.width() <= Math.max(f2, f)) {
                float f8 = this.lastValidRawMeasuredDim;
                RectF rectF4 = this.progressRectF;
                if (rectF4 == null) {
                    throw null;
                }
                float f9 = f6 - f8;
                rectF4.set(f8, f8, f9, f9);
                setThickness(this.lastValidStrokeThickness);
                this.progressThumbSize = this.lastValidThumbSize;
                this.progressThumbSizeRate = Math.max(Math.min(this.lastValidThumbSizeRate, this.progressMaxThumbSizeRate), 0.0f);
            } else {
                this.lastValidRawMeasuredDim = fMax;
                this.lastValidStrokeThickness = this.progressStrokeThickness;
                this.lastValidThumbSize = this.progressThumbSize;
                this.lastValidThumbSizeRate = this.progressThumbSizeRate;
            }
            RectF rectF5 = this.shadowRectF;
            if (rectF5 == null || (rectF = this.progressRectF) == null) {
                throw null;
            }
            float f10 = rectF.left;
            float f11 = this.defaultShadowPadding;
            rectF5.set(f10, rectF.top + f11, rectF.right, f11 + rectF.bottom);
            setMeasuredDimension(iMax, iMax);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void resetBackgroundPaint() {
        Paint paint = this.backgroundPaint;
        paint.getClass();
        int iAdjustAlpha = this.progressBackgroundColor;
        if (this.isBackgroundAlphaEnabled) {
            iAdjustAlpha = adjustAlpha(iAdjustAlpha, 0.3f);
        }
        paint.setColor(iAdjustAlpha);
    }

    public final void setThickness(float f) {
        this.progressStrokeThickness = f;
        this.progressIconThickness = f / 2;
        Paint paint = this.backgroundPaint;
        paint.getClass();
        paint.setStrokeWidth(f);
        Paint paint2 = this.progressPaint;
        paint2.getClass();
        paint2.setStrokeWidth(this.progressStrokeThickness);
        Iterator it = this.progressPaintList.iterator();
        while (it.hasNext()) {
            ((Paint) it.next()).setStrokeWidth(this.progressStrokeThickness);
        }
        Paint paint3 = this.shadowPaint;
        paint3.getClass();
        paint3.setStrokeWidth(this.progressStrokeThickness);
    }
}
