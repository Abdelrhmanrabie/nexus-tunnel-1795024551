package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import androidx.customview.widget.a;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.b2;
import defpackage.d;
import defpackage.e;
import defpackage.o1;
import defpackage.qd1;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    public static final /* synthetic */ int $r8$clinit = 0;
    public AccessibilityEventSender accessibilityEventSender;
    public final AccessibilityHelper accessibilityHelper;
    public final AccessibilityManager accessibilityManager;
    public int activeThumbIdx;
    public final Paint activeTicksPaint;
    public final Paint activeTrackPaint;
    public final ArrayList changeListeners;
    public final int defaultThumbRadius;
    public boolean dirtyConfig;
    public int focusedThumbIdx;
    public ColorStateList haloColor;
    public final Paint haloPaint;
    public int haloRadius;
    public final Paint inactiveTicksPaint;
    public final Paint inactiveTrackPaint;
    public boolean isLongPress;
    public final int labelBehavior;
    public final AnonymousClass1 labelMaker;
    public final int labelPadding;
    public final ArrayList labels;
    public boolean labelsAreAnimatedIn;
    public ValueAnimator labelsInAnimator;
    public ValueAnimator labelsOutAnimator;
    public MotionEvent lastEvent;
    public final int minTrackSidePadding;
    public final int scaledTouchSlop;
    public int separationUnit;
    public float stepSize;
    public final MaterialShapeDrawable thumbDrawable;
    public boolean thumbIsPressed;
    public final Paint thumbPaint;
    public int thumbRadius;
    public ColorStateList tickColorActive;
    public ColorStateList tickColorInactive;
    public final boolean tickVisible;
    public float[] ticksCoordinates;
    public float touchDownX;
    public final ArrayList touchListeners;
    public float touchPosition;
    public ColorStateList trackColorActive;
    public ColorStateList trackColorInactive;
    public int trackHeight;
    public int trackSidePadding;
    public final int trackTop;
    public int trackWidth;
    public float valueFrom;
    public float valueTo;
    public ArrayList values;
    public final int widgetHeight;

    /* JADX INFO: renamed from: com.google.android.material.slider.BaseSlider$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class AnonymousClass1 implements TooltipDrawableFactory {
        public final /* synthetic */ AttributeSet val$attrs;
        public final /* synthetic */ int val$defStyleAttr;

        public AnonymousClass1(AttributeSet attributeSet, int i) {
            this.val$attrs = attributeSet;
            this.val$defStyleAttr = i;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class AccessibilityEventSender implements Runnable {
        public int virtualViewId;

        private AccessibilityEventSender() {
            this.virtualViewId = -1;
        }

        public /* synthetic */ AccessibilityEventSender(BaseSlider baseSlider, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseSlider.this.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class AccessibilityHelper extends a {
        public final BaseSlider slider;
        public final Rect virtualViewBounds;

        public AccessibilityHelper(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.virtualViewBounds = new Rect();
            this.slider = baseSlider;
        }

        @Override // androidx.customview.widget.a
        public final void getVisibleVirtualViews(ArrayList arrayList) {
            for (int i = 0; i < this.slider.getValues().size(); i++) {
                arrayList.add(Integer.valueOf(i));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        
            if (r0.snapThumbToValue(r7, r8) != false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
        
            if (r0.snapThumbToValue(r7, r8) != false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:
        
            r0.updateHaloHotspot();
            r0.postInvalidate();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x008d, code lost:
        
            if (r7 == Integer.MIN_VALUE) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0095, code lost:
        
            if (r6.mManager.isEnabled() == false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0097, code lost:
        
            r8 = r6.mHost;
            r9 = r8.getParent();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x009d, code lost:
        
            if (r9 == null) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x009f, code lost:
        
            r7 = createEvent(r7, 2048);
            r7.setContentChangeTypes(0);
            r9.requestSendAccessibilityEvent(r8, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00ab, code lost:
        
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:?, code lost:
        
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
        
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
        
            return true;
         */
        @Override // androidx.customview.widget.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean onPerformActionForVirtualView(int r7, int r8, android.os.Bundle r9) {
            /*
                r6 = this;
                com.google.android.material.slider.BaseSlider r0 = r6.slider
                boolean r1 = r0.isEnabled()
                r2 = 0
                if (r1 != 0) goto Lb
                goto Lad
            Lb:
                r1 = 4096(0x1000, float:5.74E-42)
                r3 = 8192(0x2000, float:1.14794E-41)
                if (r8 == r1) goto L33
                if (r8 == r3) goto L33
                r1 = 16908349(0x102003d, float:2.38774E-38)
                if (r8 == r1) goto L1a
                goto Lad
            L1a:
                if (r9 == 0) goto Lad
                java.lang.String r8 = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"
                boolean r1 = r9.containsKey(r8)
                if (r1 != 0) goto L26
                goto Lad
            L26:
                float r8 = r9.getFloat(r8)
                int r9 = com.google.android.material.slider.BaseSlider.$r8$clinit
                boolean r8 = r0.snapThumbToValue(r7, r8)
                if (r8 == 0) goto Lad
                goto L85
            L33:
                int r9 = com.google.android.material.slider.BaseSlider.$r8$clinit
                float r9 = r0.stepSize
                r1 = 0
                int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
                if (r1 != 0) goto L3e
                r9 = 1065353216(0x3f800000, float:1.0)
            L3e:
                float r1 = r0.valueTo
                float r4 = r0.valueFrom
                float r1 = r1 - r4
                float r1 = r1 / r9
                r4 = 20
                float r4 = (float) r4
                int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                if (r5 > 0) goto L4c
                goto L53
            L4c:
                float r1 = r1 / r4
                int r1 = java.lang.Math.round(r1)
                float r1 = (float) r1
                float r9 = r9 * r1
            L53:
                if (r8 != r3) goto L56
                float r9 = -r9
            L56:
                boolean r8 = r0.isRtl()
                if (r8 == 0) goto L5d
                float r9 = -r9
            L5d:
                java.util.ArrayList r8 = r0.getValues()
                java.lang.Object r8 = r8.get(r7)
                java.lang.Float r8 = (java.lang.Float) r8
                float r8 = r8.floatValue()
                float r8 = r8 + r9
                float r9 = r0.getValueFrom()
                float r1 = r0.getValueTo()
                int r3 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
                if (r3 >= 0) goto L7a
                r8 = r9
                goto L7f
            L7a:
                int r9 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r9 <= 0) goto L7f
                r8 = r1
            L7f:
                boolean r8 = r0.snapThumbToValue(r7, r8)
                if (r8 == 0) goto Lad
            L85:
                r0.updateHaloHotspot()
                r0.postInvalidate()
                r8 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r7 == r8) goto Lab
                android.view.accessibility.AccessibilityManager r8 = r6.mManager
                boolean r8 = r8.isEnabled()
                if (r8 == 0) goto Lab
                android.view.View r8 = r6.mHost
                android.view.ViewParent r9 = r8.getParent()
                if (r9 == 0) goto Lab
                r0 = 2048(0x800, float:2.87E-42)
                android.view.accessibility.AccessibilityEvent r7 = r6.createEvent(r7, r0)
                r7.setContentChangeTypes(r2)
                r9.requestSendAccessibilityEvent(r8, r7)
            Lab:
                r7 = 1
                return r7
            Lad:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.AccessibilityHelper.onPerformActionForVirtualView(int, int, android.os.Bundle):boolean");
        }

        @Override // androidx.customview.widget.a
        public final void onPopulateNodeForVirtualView(int i, o1 o1Var) {
            String string;
            Context context;
            int i2;
            AccessibilityNodeInfo accessibilityNodeInfo = o1Var.a;
            o1Var.b(o1.a.o);
            BaseSlider baseSlider = this.slider;
            ArrayList values = baseSlider.getValues();
            float fFloatValue = ((Float) values.get(i)).floatValue();
            float valueFrom = baseSlider.getValueFrom();
            float valueTo = baseSlider.getValueTo();
            if (baseSlider.isEnabled()) {
                if (fFloatValue > valueFrom) {
                    o1Var.a(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
                }
                if (fFloatValue < valueTo) {
                    o1Var.a(4096);
                }
            }
            accessibilityNodeInfo.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(1, valueFrom, valueTo, fFloatValue));
            o1Var.i(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (baseSlider.getContentDescription() != null) {
                sb.append(baseSlider.getContentDescription());
                sb.append(",");
            }
            if (values.size() > 1) {
                if (i == baseSlider.getValues().size() - 1) {
                    context = baseSlider.getContext();
                    i2 = R.string.hb;
                } else {
                    if (i == 0) {
                        context = baseSlider.getContext();
                        i2 = R.string.hc;
                    } else {
                        string = AppConfig.CUSTOM;
                    }
                    sb.append(string);
                    sb.append(baseSlider.formatValue(fFloatValue));
                }
                string = context.getString(i2);
                sb.append(string);
                sb.append(baseSlider.formatValue(fFloatValue));
            }
            accessibilityNodeInfo.setContentDescription(sb.toString());
            Rect rect = this.virtualViewBounds;
            baseSlider.updateBoundsForVirturalViewId(i, rect);
            accessibilityNodeInfo.setBoundsInParent(rect);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator<SliderState>() { // from class: com.google.android.material.slider.BaseSlider.SliderState.1
            @Override // android.os.Parcelable.Creator
            public final SliderState createFromParcel(Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public final SliderState[] newArray(int i) {
                return new SliderState[i];
            }
        };
        public boolean hasFocus;
        public float stepSize;
        public float valueFrom;
        public float valueTo;
        public ArrayList values;

        private SliderState(Parcel parcel) {
            super(parcel);
            this.valueFrom = parcel.readFloat();
            this.valueTo = parcel.readFloat();
            ArrayList arrayList = new ArrayList();
            this.values = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.stepSize = parcel.readFloat();
            this.hasFocus = parcel.createBooleanArray()[0];
        }

        public /* synthetic */ SliderState(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        public SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.valueFrom);
            parcel.writeFloat(this.valueTo);
            parcel.writeList(this.values);
            parcel.writeFloat(this.stepSize);
            parcel.writeBooleanArray(new boolean[]{this.hasFocus});
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface TooltipDrawableFactory {
    }

    public BaseSlider(Context context) {
        this(context, null);
    }

    public BaseSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.a0m);
    }

    public BaseSlider(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, R.plurals.a2s), attributeSet, i);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.labelsAreAnimatedIn = false;
        this.thumbIsPressed = false;
        this.values = new ArrayList();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.tickVisible = true;
        this.isLongPress = false;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.thumbDrawable = materialShapeDrawable;
        this.separationUnit = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.inactiveTrackPaint = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint paint2 = new Paint();
        this.activeTrackPaint = paint2;
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        Paint paint3 = new Paint(1);
        this.thumbPaint = paint3;
        Paint.Style style2 = Paint.Style.FILL;
        paint3.setStyle(style2);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.haloPaint = paint4;
        paint4.setStyle(style2);
        Paint paint5 = new Paint();
        this.inactiveTicksPaint = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        Paint paint6 = new Paint();
        this.activeTicksPaint = paint6;
        paint6.setStyle(style);
        paint6.setStrokeCap(cap);
        Resources resources = context2.getResources();
        this.widgetHeight = resources.getDimensionPixelSize(R.dimen.nw);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.nu);
        this.minTrackSidePadding = dimensionPixelOffset;
        this.trackSidePadding = dimensionPixelOffset;
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ns);
        this.defaultThumbRadius = dimensionPixelSize;
        this.trackTop = resources.getDimensionPixelOffset(R.dimen.nv);
        this.labelPadding = resources.getDimensionPixelSize(R.dimen.no);
        this.labelMaker = new AnonymousClass1(attributeSet, i);
        ThemeEnforcement.checkCompatibleTheme(context2, attributeSet, i, R.plurals.a2s);
        int[] iArr = com.google.android.material.R.styleable.Slider;
        ThemeEnforcement.checkTextAppearance(context2, attributeSet, iArr, i, R.plurals.a2s, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i, R.plurals.a2s);
        this.valueFrom = typedArrayObtainStyledAttributes.getFloat(3, 0.0f);
        this.valueTo = typedArrayObtainStyledAttributes.getFloat(4, 1.0f);
        setValues(Float.valueOf(this.valueFrom));
        this.stepSize = typedArrayObtainStyledAttributes.getFloat(2, 0.0f);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(18);
        int i2 = zHasValue ? 18 : 20;
        int i3 = zHasValue ? 18 : 19;
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, i2);
        colorStateList = colorStateList == null ? b2.getColorStateList(context2, R.color.on) : colorStateList;
        if (!colorStateList.equals(this.trackColorInactive)) {
            this.trackColorInactive = colorStateList;
            paint.setColor(getColorForState(colorStateList));
            invalidate();
        }
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, i3);
        colorStateList2 = colorStateList2 == null ? b2.getColorStateList(context2, R.color.ok) : colorStateList2;
        if (!colorStateList2.equals(this.trackColorActive)) {
            this.trackColorActive = colorStateList2;
            paint2.setColor(getColorForState(colorStateList2));
            invalidate();
        }
        materialShapeDrawable.setFillColor(MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 9));
        if (typedArrayObtainStyledAttributes.hasValue(12)) {
            materialShapeDrawable.setStrokeColor(MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 12));
            postInvalidate();
        }
        materialShapeDrawable.setStrokeWidth(typedArrayObtainStyledAttributes.getDimension(13, 0.0f));
        postInvalidate();
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 5);
        colorStateList3 = colorStateList3 == null ? b2.getColorStateList(context2, R.color.ol) : colorStateList3;
        if (!colorStateList3.equals(this.haloColor)) {
            this.haloColor = colorStateList3;
            Drawable background = getBackground();
            if ((getBackground() instanceof RippleDrawable) && (background instanceof RippleDrawable)) {
                ((RippleDrawable) background).setColor(colorStateList3);
            } else {
                paint4.setColor(getColorForState(colorStateList3));
                paint4.setAlpha(63);
                invalidate();
            }
        }
        this.tickVisible = typedArrayObtainStyledAttributes.getBoolean(17, true);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(14);
        int i4 = zHasValue2 ? 14 : 16;
        int i5 = zHasValue2 ? 14 : 15;
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, i4);
        colorStateList4 = colorStateList4 == null ? b2.getColorStateList(context2, R.color.om) : colorStateList4;
        if (!colorStateList4.equals(this.tickColorInactive)) {
            this.tickColorInactive = colorStateList4;
            paint5.setColor(getColorForState(colorStateList4));
            invalidate();
        }
        ColorStateList colorStateList5 = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, i5);
        colorStateList5 = colorStateList5 == null ? b2.getColorStateList(context2, R.color.oj) : colorStateList5;
        if (!colorStateList5.equals(this.tickColorActive)) {
            this.tickColorActive = colorStateList5;
            paint6.setColor(getColorForState(colorStateList5));
            invalidate();
        }
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, 0);
        if (dimensionPixelSize2 != this.thumbRadius) {
            this.thumbRadius = dimensionPixelSize2;
            this.trackSidePadding = Math.max(dimensionPixelSize2 - dimensionPixelSize, 0) + dimensionPixelOffset;
            WeakHashMap weakHashMap = qd1.a;
            if (isLaidOut()) {
                this.trackWidth = Math.max(getWidth() - (this.trackSidePadding * 2), 0);
                maybeCalculateTicksCoordinates();
            }
            RelativeCornerSize relativeCornerSize = ShapeAppearanceModel.PILL;
            ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
            float f = this.thumbRadius;
            CornerTreatment cornerTreatmentCreateCornerTreatment = MaterialShapeUtils.createCornerTreatment(0);
            builder.topLeftCorner = cornerTreatmentCreateCornerTreatment;
            float fCompatCornerTreatmentSize = ShapeAppearanceModel.Builder.compatCornerTreatmentSize(cornerTreatmentCreateCornerTreatment);
            if (fCompatCornerTreatmentSize != -1.0f) {
                builder.topLeftCornerSize = new AbsoluteCornerSize(fCompatCornerTreatmentSize);
            }
            builder.topRightCorner = cornerTreatmentCreateCornerTreatment;
            float fCompatCornerTreatmentSize2 = ShapeAppearanceModel.Builder.compatCornerTreatmentSize(cornerTreatmentCreateCornerTreatment);
            if (fCompatCornerTreatmentSize2 != -1.0f) {
                builder.topRightCornerSize = new AbsoluteCornerSize(fCompatCornerTreatmentSize2);
            }
            builder.bottomRightCorner = cornerTreatmentCreateCornerTreatment;
            float fCompatCornerTreatmentSize3 = ShapeAppearanceModel.Builder.compatCornerTreatmentSize(cornerTreatmentCreateCornerTreatment);
            if (fCompatCornerTreatmentSize3 != -1.0f) {
                builder.bottomRightCornerSize = new AbsoluteCornerSize(fCompatCornerTreatmentSize3);
            }
            builder.bottomLeftCorner = cornerTreatmentCreateCornerTreatment;
            float fCompatCornerTreatmentSize4 = ShapeAppearanceModel.Builder.compatCornerTreatmentSize(cornerTreatmentCreateCornerTreatment);
            if (fCompatCornerTreatmentSize4 != -1.0f) {
                builder.bottomLeftCornerSize = new AbsoluteCornerSize(fCompatCornerTreatmentSize4);
            }
            builder.setAllCornerSizes(f);
            materialShapeDrawable.setShapeAppearanceModel(builder.build());
            int i6 = this.thumbRadius * 2;
            materialShapeDrawable.setBounds(0, 0, i6, i6);
            postInvalidate();
        }
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
        if (dimensionPixelSize3 != this.haloRadius) {
            this.haloRadius = dimensionPixelSize3;
            Drawable background2 = getBackground();
            if ((getBackground() instanceof RippleDrawable) && (background2 instanceof RippleDrawable)) {
                ((RippleDrawable) background2).setRadius(this.haloRadius);
            } else {
                postInvalidate();
            }
        }
        materialShapeDrawable.setElevation(typedArrayObtainStyledAttributes.getDimension(10, 0.0f));
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(21, 0);
        if (this.trackHeight != dimensionPixelSize4) {
            this.trackHeight = dimensionPixelSize4;
            paint.setStrokeWidth(dimensionPixelSize4);
            paint2.setStrokeWidth(this.trackHeight);
            paint5.setStrokeWidth(this.trackHeight / 2.0f);
            paint6.setStrokeWidth(this.trackHeight / 2.0f);
            postInvalidate();
        }
        this.labelBehavior = typedArrayObtainStyledAttributes.getInt(7, 0);
        if (!typedArrayObtainStyledAttributes.getBoolean(0, true)) {
            setEnabled(false);
        }
        typedArrayObtainStyledAttributes.recycle();
        setFocusable(true);
        setClickable(true);
        materialShapeDrawable.setShadowCompatibilityMode();
        this.scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        AccessibilityHelper accessibilityHelper = new AccessibilityHelper(this);
        this.accessibilityHelper = accessibilityHelper;
        qd1.l(this, accessibilityHelper);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public final int calculateTop() {
        return this.trackTop + (this.labelBehavior == 1 ? ((TooltipDrawable) this.labels.get(0)).getIntrinsicHeight() : 0);
    }

    public final ValueAnimator createLabelAnimator(boolean z) {
        float fFloatValue = z ? 0.0f : 1.0f;
        ValueAnimator valueAnimator = z ? this.labelsOutAnimator : this.labelsInAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, z ? 1.0f : 0.0f);
        valueAnimatorOfFloat.setDuration(z ? 83L : 117L);
        valueAnimatorOfFloat.setInterpolator(z ? AnimationUtils.DECELERATE_INTERPOLATOR : AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.slider.BaseSlider.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float fFloatValue2 = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                BaseSlider baseSlider = BaseSlider.this;
                for (TooltipDrawable tooltipDrawable : baseSlider.labels) {
                    tooltipDrawable.tooltipPivotY = 1.2f;
                    tooltipDrawable.tooltipScaleX = fFloatValue2;
                    tooltipDrawable.tooltipScaleY = fFloatValue2;
                    tooltipDrawable.labelOpacity = AnimationUtils.lerp(0.0f, 1.0f, 0.19f, 1.0f, fFloatValue2);
                    tooltipDrawable.invalidateSelf();
                }
                WeakHashMap weakHashMap = qd1.a;
                baseSlider.postInvalidateOnAnimation();
            }
        });
        return valueAnimatorOfFloat;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int i;
        AccessibilityHelper accessibilityHelper = this.accessibilityHelper;
        AccessibilityManager accessibilityManager = accessibilityHelper.mManager;
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = accessibilityHelper.virtualViewBounds;
                BaseSlider baseSlider = accessibilityHelper.slider;
                int i2 = 0;
                while (true) {
                    if (i2 >= baseSlider.getValues().size()) {
                        i2 = -1;
                        break;
                    }
                    baseSlider.updateBoundsForVirturalViewId(i2, rect);
                    if (rect.contains((int) x, (int) y)) {
                        break;
                    }
                    i2++;
                }
                int i3 = accessibilityHelper.mHoveredVirtualViewId;
                if (i3 != i2) {
                    accessibilityHelper.mHoveredVirtualViewId = i2;
                    accessibilityHelper.sendEventForVirtualView(i2, 128);
                    accessibilityHelper.sendEventForVirtualView(i3, 256);
                }
                if (i2 != Integer.MIN_VALUE) {
                    return true;
                }
            } else if (action == 10 && (i = accessibilityHelper.mHoveredVirtualViewId) != Integer.MIN_VALUE) {
                if (i == Integer.MIN_VALUE) {
                    return true;
                }
                accessibilityHelper.mHoveredVirtualViewId = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                accessibilityHelper.sendEventForVirtualView(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, 128);
                accessibilityHelper.sendEventForVirtualView(i, 256);
                return true;
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        for (TooltipDrawable tooltipDrawable : this.labels) {
            if (tooltipDrawable.isStateful()) {
                tooltipDrawable.setState(getDrawableState());
            }
        }
        MaterialShapeDrawable materialShapeDrawable = this.thumbDrawable;
        if (materialShapeDrawable.isStateful()) {
            materialShapeDrawable.setState(getDrawableState());
        }
        int colorForState = getColorForState(this.haloColor);
        Paint paint = this.haloPaint;
        paint.setColor(colorForState);
        paint.setAlpha(63);
    }

    public final void ensureLabelsRemoved() {
        if (this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = false;
            ValueAnimator valueAnimatorCreateLabelAnimator = createLabelAnimator(false);
            this.labelsOutAnimator = valueAnimatorCreateLabelAnimator;
            this.labelsInAnimator = null;
            valueAnimatorCreateLabelAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.slider.BaseSlider.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    BaseSlider baseSlider = BaseSlider.this;
                    Iterator it = baseSlider.labels.iterator();
                    while (it.hasNext()) {
                        ViewUtils.getOverlay(ViewUtils.getContentView(baseSlider)).remove((TooltipDrawable) it.next());
                    }
                }
            });
            this.labelsOutAnimator.start();
        }
    }

    public final String formatValue(float f) {
        return String.format(((float) ((int) f)) == f ? "%.0f" : "%.2f", Float.valueOf(f));
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public final float[] getActiveRange() {
        float fFloatValue = ((Float) Collections.max(getValues())).floatValue();
        float fFloatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.values.size() == 1) {
            fFloatValue2 = this.valueFrom;
        }
        float fNormalizeValue = normalizeValue(fFloatValue2);
        float fNormalizeValue2 = normalizeValue(fFloatValue);
        return isRtl() ? new float[]{fNormalizeValue2, fNormalizeValue} : new float[]{fNormalizeValue, fNormalizeValue2};
    }

    public final int getColorForState(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    public ArrayList getValues() {
        return new ArrayList(this.values);
    }

    public final boolean isInVerticalScrollingContainer() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isMultipleOfStepSize(float f) {
        double dDoubleValue = new BigDecimal(Float.toString(f)).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < 1.0E-4d;
    }

    public final boolean isRtl() {
        WeakHashMap weakHashMap = qd1.a;
        return getLayoutDirection() == 1;
    }

    public final void maybeCalculateTicksCoordinates() {
        if (this.stepSize <= 0.0f) {
            return;
        }
        validateConfigurationIfDirty();
        int iMin = Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
        float[] fArr = this.ticksCoordinates;
        if (fArr == null || fArr.length != iMin * 2) {
            this.ticksCoordinates = new float[iMin * 2];
        }
        float f = this.trackWidth / (iMin - 1);
        for (int i = 0; i < iMin * 2; i += 2) {
            float[] fArr2 = this.ticksCoordinates;
            fArr2[i] = ((i / 2) * f) + this.trackSidePadding;
            fArr2[i + 1] = calculateTop();
        }
    }

    public final boolean moveFocus(int i) {
        int i2 = this.focusedThumbIdx;
        long j = ((long) i2) + ((long) i);
        long size = this.values.size() - 1;
        if (j < 0) {
            j = 0;
        } else if (j > size) {
            j = size;
        }
        int i3 = (int) j;
        this.focusedThumbIdx = i3;
        if (i3 == i2) {
            return false;
        }
        if (this.activeThumbIdx != -1) {
            this.activeThumbIdx = i3;
        }
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    public final void moveFocusInAbsoluteDirection(int i) {
        if (isRtl()) {
            i = i == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i;
        }
        moveFocus(i);
    }

    public final float normalizeValue(float f) {
        float f2 = this.valueFrom;
        float f3 = (f - f2) / (this.valueTo - f2);
        return isRtl() ? 1.0f - f3 : f3;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (TooltipDrawable tooltipDrawable : this.labels) {
            ViewGroup contentView = ViewUtils.getContentView(this);
            tooltipDrawable.getClass();
            if (contentView != null) {
                int[] iArr = new int[2];
                contentView.getLocationOnScreen(iArr);
                tooltipDrawable.locationOnScreenX = iArr[0];
                contentView.getWindowVisibleDisplayFrame(tooltipDrawable.displayFrame);
                contentView.addOnLayoutChangeListener(tooltipDrawable.attachedViewLayoutChangeListener);
            }
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        this.labelsAreAnimatedIn = false;
        for (TooltipDrawable tooltipDrawable : this.labels) {
            ViewOverlayImpl overlay = ViewUtils.getOverlay(ViewUtils.getContentView(this));
            if (overlay != null) {
                overlay.remove(tooltipDrawable);
                ViewGroup contentView = ViewUtils.getContentView(this);
                if (contentView == null) {
                    tooltipDrawable.getClass();
                } else {
                    contentView.removeOnLayoutChangeListener(tooltipDrawable.attachedViewLayoutChangeListener);
                }
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.dirtyConfig) {
            validateConfigurationIfDirty();
            maybeCalculateTicksCoordinates();
        }
        super.onDraw(canvas);
        int iCalculateTop = calculateTop();
        int i = this.trackWidth;
        float[] activeRange = getActiveRange();
        int i2 = this.trackSidePadding;
        float f = i;
        float f2 = (activeRange[1] * f) + i2;
        float f3 = i2 + i;
        Paint paint = this.inactiveTrackPaint;
        if (f2 < f3) {
            float f4 = iCalculateTop;
            canvas.drawLine(f2, f4, f3, f4, paint);
        }
        float f5 = this.trackSidePadding;
        float f6 = (activeRange[0] * f) + f5;
        if (f6 > f5) {
            float f7 = iCalculateTop;
            canvas.drawLine(f5, f7, f6, f7, paint);
        }
        if (((Float) Collections.max(getValues())).floatValue() > this.valueFrom) {
            int i3 = this.trackWidth;
            float[] activeRange2 = getActiveRange();
            float f8 = this.trackSidePadding;
            float f9 = i3;
            float f10 = (activeRange2[1] * f9) + f8;
            float f11 = (activeRange2[0] * f9) + f8;
            float f12 = iCalculateTop;
            canvas.drawLine(f11, f12, f10, f12, this.activeTrackPaint);
        }
        if (this.tickVisible && this.stepSize > 0.0f) {
            float[] activeRange3 = getActiveRange();
            int iRound = Math.round(activeRange3[0] * ((this.ticksCoordinates.length / 2) - 1));
            int iRound2 = Math.round(activeRange3[1] * ((this.ticksCoordinates.length / 2) - 1));
            float[] fArr = this.ticksCoordinates;
            int i4 = iRound * 2;
            Paint paint2 = this.inactiveTicksPaint;
            canvas.drawPoints(fArr, 0, i4, paint2);
            int i5 = iRound2 * 2;
            canvas.drawPoints(this.ticksCoordinates, i4, i5 - i4, this.activeTicksPaint);
            float[] fArr2 = this.ticksCoordinates;
            canvas.drawPoints(fArr2, i5, fArr2.length - i5, paint2);
        }
        if ((this.thumbIsPressed || isFocused()) && isEnabled()) {
            int i6 = this.trackWidth;
            if (!(getBackground() instanceof RippleDrawable)) {
                int iNormalizeValue = (int) ((normalizeValue(((Float) this.values.get(this.focusedThumbIdx)).floatValue()) * i6) + this.trackSidePadding);
                if (Build.VERSION.SDK_INT < 28) {
                    int i7 = this.haloRadius;
                    canvas.clipRect(iNormalizeValue - i7, iCalculateTop - i7, iNormalizeValue + i7, i7 + iCalculateTop, Region.Op.UNION);
                }
                canvas.drawCircle(iNormalizeValue, iCalculateTop, this.haloRadius, this.haloPaint);
            }
            if (this.activeThumbIdx != -1 && this.labelBehavior != 2) {
                if (!this.labelsAreAnimatedIn) {
                    this.labelsAreAnimatedIn = true;
                    ValueAnimator valueAnimatorCreateLabelAnimator = createLabelAnimator(true);
                    this.labelsInAnimator = valueAnimatorCreateLabelAnimator;
                    this.labelsOutAnimator = null;
                    valueAnimatorCreateLabelAnimator.start();
                }
                ArrayList arrayList = this.labels;
                Iterator it = arrayList.iterator();
                for (int i8 = 0; i8 < this.values.size() && it.hasNext(); i8++) {
                    if (i8 != this.focusedThumbIdx) {
                        setValueForLabel((TooltipDrawable) it.next(), ((Float) this.values.get(i8)).floatValue());
                    }
                }
                if (!it.hasNext()) {
                    throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(arrayList.size()), Integer.valueOf(this.values.size())));
                }
                setValueForLabel((TooltipDrawable) it.next(), ((Float) this.values.get(this.focusedThumbIdx)).floatValue());
            }
        }
        int i9 = this.trackWidth;
        if (!isEnabled()) {
            Iterator it2 = this.values.iterator();
            while (it2.hasNext()) {
                canvas.drawCircle((normalizeValue(((Float) it2.next()).floatValue()) * i9) + this.trackSidePadding, iCalculateTop, this.thumbRadius, this.thumbPaint);
            }
        }
        for (Float f13 : this.values) {
            canvas.save();
            int iNormalizeValue2 = this.trackSidePadding + ((int) (normalizeValue(f13.floatValue()) * i9));
            int i10 = this.thumbRadius;
            canvas.translate(iNormalizeValue2 - i10, iCalculateTop - i10);
            this.thumbDrawable.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        AccessibilityHelper accessibilityHelper = this.accessibilityHelper;
        if (!z) {
            this.activeThumbIdx = -1;
            ensureLabelsRemoved();
            accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
            return;
        }
        if (i == 1) {
            moveFocus(Integer.MAX_VALUE);
        } else if (i == 2) {
            moveFocus(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
        } else if (i == 17) {
            moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
        } else if (i == 66) {
            moveFocusInAbsoluteDirection(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
        }
        accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0041  */
    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ca  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean zMoveFocus;
        if (!isEnabled()) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.values.size() == 1) {
            this.activeThumbIdx = 0;
        }
        Float fValueOf = null;
        Boolean boolValueOf = null;
        if (this.activeThumbIdx == -1) {
            if (i == 61) {
                if (keyEvent.hasNoModifiers()) {
                    zMoveFocus = moveFocus(1);
                } else if (keyEvent.isShiftPressed()) {
                    zMoveFocus = moveFocus(-1);
                } else {
                    boolValueOf = Boolean.FALSE;
                }
                boolValueOf = Boolean.valueOf(zMoveFocus);
            } else if (i == 66) {
                this.activeThumbIdx = this.focusedThumbIdx;
                postInvalidate();
                boolValueOf = Boolean.TRUE;
            } else if (i == 81) {
                moveFocus(1);
                boolValueOf = Boolean.TRUE;
            } else {
                if (i == 69) {
                    moveFocus(-1);
                } else if (i != 70) {
                    switch (i) {
                        case 21:
                            moveFocusInAbsoluteDirection(-1);
                            break;
                        case 22:
                            moveFocusInAbsoluteDirection(1);
                            break;
                        case 23:
                            this.activeThumbIdx = this.focusedThumbIdx;
                            postInvalidate();
                            break;
                    }
                } else {
                    moveFocus(1);
                }
                boolValueOf = Boolean.TRUE;
            }
            return boolValueOf != null ? boolValueOf.booleanValue() : super.onKeyDown(i, keyEvent);
        }
        boolean zIsLongPress = this.isLongPress | keyEvent.isLongPress();
        this.isLongPress = zIsLongPress;
        float fRound = this.stepSize;
        if (zIsLongPress) {
            if (fRound == 0.0f) {
                fRound = 1.0f;
            }
            float f = (this.valueTo - this.valueFrom) / fRound;
            float f2 = 20;
            if (f > f2) {
                fRound *= Math.round(f / f2);
            }
        } else if (fRound == 0.0f) {
            fRound = 1.0f;
        }
        if (i != 21) {
            if (i != 22) {
                if (i == 69) {
                    fValueOf = Float.valueOf(-fRound);
                } else if (i == 70 || i == 81) {
                }
            } else if (isRtl()) {
                fRound = -fRound;
            }
            fValueOf = Float.valueOf(fRound);
        } else {
            if (!isRtl()) {
                fRound = -fRound;
            }
            fValueOf = Float.valueOf(fRound);
        }
        if (fValueOf != null) {
            if (!snapThumbToValue(this.activeThumbIdx, fValueOf.floatValue() + ((Float) this.values.get(this.activeThumbIdx)).floatValue())) {
                return true;
            }
            updateHaloHotspot();
        } else {
            if (i != 23) {
                if (i == 61) {
                    if (keyEvent.hasNoModifiers()) {
                        return moveFocus(1);
                    }
                    if (keyEvent.isShiftPressed()) {
                        return moveFocus(-1);
                    }
                    return false;
                }
                if (i != 66) {
                    return super.onKeyDown(i, keyEvent);
                }
            }
            this.activeThumbIdx = -1;
            ensureLabelsRemoved();
        }
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        this.isLongPress = false;
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.widgetHeight + (this.labelBehavior == 1 ? ((TooltipDrawable) this.labels.get(0)).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.valueFrom = sliderState.valueFrom;
        this.valueTo = sliderState.valueTo;
        setValuesInternal(sliderState.values);
        this.stepSize = sliderState.stepSize;
        if (sliderState.hasFocus) {
            requestFocus();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.valueFrom = this.valueFrom;
        sliderState.valueTo = this.valueTo;
        sliderState.values = new ArrayList(this.values);
        sliderState.stepSize = this.stepSize;
        sliderState.hasFocus = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        this.trackWidth = Math.max(i - (this.trackSidePadding * 2), 0);
        maybeCalculateTicksCoordinates();
        updateHaloHotspot();
    }

    public final void onStartTrackingTouch() {
        Iterator it = this.touchListeners.iterator();
        while (it.hasNext()) {
            ((BaseOnSliderTouchListener) it.next()).onStartTrackingTouch();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            float x = motionEvent.getX();
            float f = (x - this.trackSidePadding) / this.trackWidth;
            this.touchPosition = f;
            float fMax = Math.max(0.0f, f);
            this.touchPosition = fMax;
            this.touchPosition = Math.min(1.0f, fMax);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                int i = this.scaledTouchSlop;
                if (actionMasked == 1) {
                    this.thumbIsPressed = false;
                    MotionEvent motionEvent2 = this.lastEvent;
                    if (motionEvent2 != null && motionEvent2.getActionMasked() == 0) {
                        float f2 = i;
                        if (Math.abs(this.lastEvent.getX() - motionEvent.getX()) <= f2 && Math.abs(this.lastEvent.getY() - motionEvent.getY()) <= f2 && pickActiveThumb()) {
                            onStartTrackingTouch();
                        }
                    }
                    if (this.activeThumbIdx != -1) {
                        snapTouchPosition();
                        this.activeThumbIdx = -1;
                        Iterator it = this.touchListeners.iterator();
                        while (it.hasNext()) {
                            ((BaseOnSliderTouchListener) it.next()).onStopTrackingTouch();
                        }
                    }
                    ensureLabelsRemoved();
                } else if (actionMasked == 2) {
                    if (!this.thumbIsPressed) {
                        if (!isInVerticalScrollingContainer() || Math.abs(x - this.touchDownX) >= i) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            onStartTrackingTouch();
                        }
                    }
                    if (pickActiveThumb()) {
                        this.thumbIsPressed = true;
                        snapTouchPosition();
                        updateHaloHotspot();
                    }
                }
                invalidate();
            } else {
                this.touchDownX = x;
                if (!isInVerticalScrollingContainer()) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (pickActiveThumb()) {
                        requestFocus();
                        this.thumbIsPressed = true;
                        snapTouchPosition();
                        updateHaloHotspot();
                        invalidate();
                        onStartTrackingTouch();
                    }
                }
            }
            setPressed(this.thumbIsPressed);
            this.lastEvent = MotionEvent.obtain(motionEvent);
            return true;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00aa  */
    public boolean pickActiveThumb() {
        if (this.activeThumbIdx == -1) {
            float f = this.touchPosition;
            if (isRtl()) {
                f = 1.0f - f;
            }
            float f2 = this.valueTo;
            float f3 = this.valueFrom;
            float fA = e.a(f2, f3, f, f3);
            float fNormalizeValue = (normalizeValue(fA) * this.trackWidth) + this.trackSidePadding;
            this.activeThumbIdx = 0;
            float fAbs = Math.abs(((Float) this.values.get(0)).floatValue() - fA);
            for (int i = 1; i < this.values.size(); i++) {
                float fAbs2 = Math.abs(((Float) this.values.get(i)).floatValue() - fA);
                float fNormalizeValue2 = (normalizeValue(((Float) this.values.get(i)).floatValue()) * this.trackWidth) + this.trackSidePadding;
                if (Float.compare(fAbs2, fAbs) > 1) {
                    break;
                }
                boolean z = !isRtl() ? fNormalizeValue2 - fNormalizeValue >= 0.0f : fNormalizeValue2 - fNormalizeValue <= 0.0f;
                if (Float.compare(fAbs2, fAbs) < 0) {
                    this.activeThumbIdx = i;
                    fAbs = fAbs2;
                } else if (Float.compare(fAbs2, fAbs) != 0) {
                    continue;
                } else {
                    if (Math.abs(fNormalizeValue2 - fNormalizeValue) < this.scaledTouchSlop) {
                        this.activeThumbIdx = -1;
                        return false;
                    }
                    if (z) {
                        this.activeThumbIdx = i;
                        fAbs = fAbs2;
                    }
                }
            }
            if (this.activeThumbIdx == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    public final void setValueForLabel(TooltipDrawable tooltipDrawable, float f) {
        String value = formatValue(f);
        if (!TextUtils.equals(tooltipDrawable.text, value)) {
            tooltipDrawable.text = value;
            tooltipDrawable.textDrawableHelper.textWidthDirty = true;
            tooltipDrawable.invalidateSelf();
        }
        int iNormalizeValue = (this.trackSidePadding + ((int) (normalizeValue(f) * this.trackWidth))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int iCalculateTop = calculateTop() - (this.labelPadding + this.thumbRadius);
        tooltipDrawable.setBounds(iNormalizeValue, iCalculateTop - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + iNormalizeValue, iCalculateTop);
        Rect rect = new Rect(tooltipDrawable.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
        tooltipDrawable.setBounds(rect);
        ViewUtils.getOverlay(ViewUtils.getContentView(this)).add(tooltipDrawable);
    }

    public void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public final void setValuesInternal(ArrayList arrayList) {
        ViewGroup contentView;
        ViewOverlayImpl overlay;
        if (arrayList.isEmpty()) {
            d.AnonymousClass0.m$2("At least one value must be set");
            return;
        }
        Collections.sort(arrayList);
        if (this.values.size() == arrayList.size() && this.values.equals(arrayList)) {
            return;
        }
        this.values = arrayList;
        this.dirtyConfig = true;
        this.focusedThumbIdx = 0;
        updateHaloHotspot();
        ArrayList arrayList2 = this.labels;
        if (arrayList2.size() > this.values.size()) {
            List<TooltipDrawable> listSubList = arrayList2.subList(this.values.size(), arrayList2.size());
            for (TooltipDrawable tooltipDrawable : listSubList) {
                WeakHashMap weakHashMap = qd1.a;
                if (isAttachedToWindow() && (overlay = ViewUtils.getOverlay(ViewUtils.getContentView(this))) != null) {
                    overlay.remove(tooltipDrawable);
                    ViewGroup contentView2 = ViewUtils.getContentView(this);
                    if (contentView2 == null) {
                        tooltipDrawable.getClass();
                    } else {
                        contentView2.removeOnLayoutChangeListener(tooltipDrawable.attachedViewLayoutChangeListener);
                    }
                }
            }
            listSubList.clear();
        }
        while (arrayList2.size() < this.values.size()) {
            AnonymousClass1 anonymousClass1 = this.labelMaker;
            BaseSlider baseSlider = BaseSlider.this;
            TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(baseSlider.getContext(), anonymousClass1.val$attrs, com.google.android.material.R.styleable.Slider, anonymousClass1.val$defStyleAttr, R.plurals.a2s, new int[0]);
            TooltipDrawable tooltipDrawableCreateFromAttributes = TooltipDrawable.createFromAttributes(baseSlider.getContext(), typedArrayObtainStyledAttributes.getResourceId(8, R.plurals.a3p));
            typedArrayObtainStyledAttributes.recycle();
            arrayList2.add(tooltipDrawableCreateFromAttributes);
            WeakHashMap weakHashMap2 = qd1.a;
            if (isAttachedToWindow() && (contentView = ViewUtils.getContentView(this)) != null) {
                int[] iArr = new int[2];
                contentView.getLocationOnScreen(iArr);
                tooltipDrawableCreateFromAttributes.locationOnScreenX = iArr[0];
                contentView.getWindowVisibleDisplayFrame(tooltipDrawableCreateFromAttributes.displayFrame);
                contentView.addOnLayoutChangeListener(tooltipDrawableCreateFromAttributes.attachedViewLayoutChangeListener);
            }
        }
        int i = arrayList2.size() == 1 ? 0 : 1;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((TooltipDrawable) it.next()).setStrokeWidth(i);
        }
        for (BaseOnChangeListener baseOnChangeListener : this.changeListeners) {
            Iterator it2 = this.values.iterator();
            while (it2.hasNext()) {
                ((Float) it2.next()).getClass();
                baseOnChangeListener.onValueChange();
            }
        }
        postInvalidate();
    }

    public final boolean snapThumbToValue(int i, float f) {
        this.focusedThumbIdx = i;
        if (Math.abs(f - ((Float) this.values.get(i)).floatValue()) < 1.0E-4d) {
            return false;
        }
        float minSeparation = getMinSeparation();
        if (this.separationUnit == 0) {
            if (minSeparation == 0.0f) {
                minSeparation = 0.0f;
            } else {
                float f2 = (minSeparation - this.trackSidePadding) / this.trackWidth;
                float f3 = this.valueFrom;
                minSeparation = e.a(f3, this.valueTo, f2, f3);
            }
        }
        if (isRtl()) {
            minSeparation = -minSeparation;
        }
        int i2 = i + 1;
        float fFloatValue = i2 >= this.values.size() ? this.valueTo : ((Float) this.values.get(i2)).floatValue() - minSeparation;
        int i3 = i - 1;
        float fFloatValue2 = i3 < 0 ? this.valueFrom : minSeparation + ((Float) this.values.get(i3)).floatValue();
        if (f < fFloatValue2) {
            f = fFloatValue2;
        } else if (f > fFloatValue) {
            f = fFloatValue;
        }
        this.values.set(i, Float.valueOf(f));
        for (BaseOnChangeListener baseOnChangeListener : this.changeListeners) {
            ((Float) this.values.get(i)).getClass();
            baseOnChangeListener.onValueChange();
        }
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
            if (accessibilityEventSender == null) {
                this.accessibilityEventSender = new AccessibilityEventSender(this, null);
            } else {
                removeCallbacks(accessibilityEventSender);
            }
            AccessibilityEventSender accessibilityEventSender2 = this.accessibilityEventSender;
            accessibilityEventSender2.virtualViewId = i;
            postDelayed(accessibilityEventSender2, 200L);
        }
        return true;
    }

    public final void snapTouchPosition() {
        double dRound;
        float f = this.touchPosition;
        float f2 = this.stepSize;
        if (f2 > 0.0f) {
            int i = (int) ((this.valueTo - this.valueFrom) / f2);
            dRound = ((double) Math.round(f * i)) / ((double) i);
        } else {
            dRound = f;
        }
        if (isRtl()) {
            dRound = 1.0d - dRound;
        }
        float f3 = this.valueTo;
        float f4 = this.valueFrom;
        snapThumbToValue(this.activeThumbIdx, (float) ((dRound * ((double) (f3 - f4))) + ((double) f4)));
    }

    public final void updateBoundsForVirturalViewId(int i, Rect rect) {
        int iNormalizeValue = this.trackSidePadding + ((int) (normalizeValue(((Float) getValues().get(i)).floatValue()) * this.trackWidth));
        int iCalculateTop = calculateTop();
        int i2 = this.thumbRadius;
        rect.set(iNormalizeValue - i2, iCalculateTop - i2, iNormalizeValue + i2, iCalculateTop + i2);
    }

    public final void updateHaloHotspot() {
        if (!(getBackground() instanceof RippleDrawable) || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iNormalizeValue = (int) ((normalizeValue(((Float) this.values.get(this.focusedThumbIdx)).floatValue()) * this.trackWidth) + this.trackSidePadding);
            int iCalculateTop = calculateTop();
            int i = this.haloRadius;
            background.setHotspotBounds(iNormalizeValue - i, iCalculateTop - i, iNormalizeValue + i, iCalculateTop + i);
        }
    }

    public final void validateConfigurationIfDirty() {
        if (this.dirtyConfig) {
            float f = this.valueFrom;
            float f2 = this.valueTo;
            if (f >= f2) {
                throw new IllegalStateException("valueFrom(" + this.valueFrom + ") must be smaller than valueTo(" + this.valueTo + ")");
            }
            if (f2 <= f) {
                throw new IllegalStateException("valueTo(" + this.valueTo + ") must be greater than valueFrom(" + this.valueFrom + ")");
            }
            if (this.stepSize > 0.0f && !isMultipleOfStepSize(f2 - f)) {
                throw new IllegalStateException("The stepSize(" + this.stepSize + ") must be 0, or a factor of the valueFrom(" + this.valueFrom + ")-valueTo(" + this.valueTo + ") range");
            }
            for (Float f3 : this.values) {
                if (f3.floatValue() < this.valueFrom || f3.floatValue() > this.valueTo) {
                    throw new IllegalStateException("Slider value(" + f3 + ") must be greater or equal to valueFrom(" + this.valueFrom + "), and lower or equal to valueTo(" + this.valueTo + ")");
                }
                if (this.stepSize > 0.0f && !isMultipleOfStepSize(f3.floatValue() - this.valueFrom)) {
                    float f4 = this.valueFrom;
                    float f5 = this.stepSize;
                    throw new IllegalStateException("Value(" + f3 + ") must be equal to valueFrom(" + f4 + ") plus a multiple of stepSize(" + f5 + ") when using stepSize(" + f5 + ")");
                }
            }
            float minSeparation = getMinSeparation();
            if (minSeparation < 0.0f) {
                throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal to 0");
            }
            float f6 = this.stepSize;
            if (f6 > 0.0f && minSeparation > 0.0f) {
                if (this.separationUnit != 1) {
                    throw new IllegalStateException("minSeparation(" + minSeparation + ") cannot be set as a dimension when using stepSize(" + this.stepSize + ")");
                }
                if (minSeparation < f6 || !isMultipleOfStepSize(minSeparation)) {
                    float f7 = this.stepSize;
                    throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal and a multiple of stepSize(" + f7 + ") when using stepSize(" + f7 + ")");
                }
            }
            float f8 = this.stepSize;
            if (f8 != 0.0f) {
                if (((int) f8) != f8) {
                }
                float f9 = this.valueFrom;
                if (((int) f9) != f9) {
                }
                float f10 = this.valueTo;
                if (((int) f10) != f10) {
                }
            }
            this.dirtyConfig = false;
        }
    }
}
