package com.blacksquircle.ui.editorkit.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.blacksquircle.ui.editorkit.R$styleable;
import defpackage.d;
import defpackage.jf;
import defpackage.v41;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class TextScroller extends View {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final v41 draggingBitmap$delegate;
    public final jf hideCallback;
    public final Handler hideHandler;
    public final v41 normalBitmap$delegate;
    public State state;
    public final Drawable thumbDragging;
    public final int thumbHeight;
    public final Drawable thumbNormal;
    public final Paint thumbPaint;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static final State DRAGGING;
        public static final State EXITING;
        public static final State HIDDEN;
        public static final State VISIBLE;

        static {
            State state = new State("HIDDEN", 0);
            HIDDEN = state;
            State state2 = new State("VISIBLE", 1);
            VISIBLE = state2;
            State state3 = new State("DRAGGING", 2);
            DRAGGING = state3;
            State state4 = new State("EXITING", 3);
            EXITING = state4;
            $VALUES = new State[]{state, state2, state3, state4};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TextScroller(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextScroller(Context context, AttributeSet attributeSet, int i) {
        Drawable drawable;
        Drawable drawable2;
        super(context, attributeSet, i);
        this.state = State.HIDDEN;
        this.normalBitmap$delegate = new v41(new TextScroller$normalBitmap$2(this, 0));
        this.draggingBitmap$delegate = new v41(new TextScroller$normalBitmap$2(this, 1));
        this.hideHandler = new Handler(Looper.getMainLooper());
        this.hideCallback = new jf(this, 2, 1);
        Paint paint = new Paint();
        this.thumbPaint = paint;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.TextScroller, 0, 0);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(1);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(0);
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(2);
        if (!zHasValue) {
            drawable = context.getDrawable(R.drawable.e6);
        } else {
            if (!typedArrayObtainStyledAttributes.hasValue(1)) {
                d.AnonymousClass0.m$2("Attribute not defined in set.");
                throw null;
            }
            drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        this.thumbNormal = drawable;
        if (!zHasValue2) {
            drawable2 = context.getDrawable(R.drawable.e7);
        } else {
            if (!typedArrayObtainStyledAttributes.hasValue(0)) {
                d.AnonymousClass0.m$2("Attribute not defined in set.");
                throw null;
            }
            drawable2 = typedArrayObtainStyledAttributes.getDrawable(0);
        }
        this.thumbDragging = drawable2;
        if (zHasValue3) {
            if (!typedArrayObtainStyledAttributes.hasValue(2)) {
                d.AnonymousClass0.m$2("Attribute not defined in set.");
                throw null;
            }
            int color = typedArrayObtainStyledAttributes.getColor(2, 0);
            drawable.setTint(color);
            drawable2.setTint(color);
        }
        this.thumbHeight = drawable.getIntrinsicHeight();
        paint.setAntiAlias(true);
        paint.setDither(false);
        paint.setAlpha(225);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Object value;
        super.onDraw(canvas);
        int i = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
        v41 v41Var = this.normalBitmap$delegate;
        Paint paint = this.thumbPaint;
        if (i == 2) {
            paint.setAlpha(225);
            value = v41Var.getValue();
        } else {
            if (i != 3) {
                if (i != 4) {
                    return;
                }
                if (paint.getAlpha() <= 25) {
                    paint.setAlpha(0);
                    setState(State.HIDDEN);
                    return;
                } else {
                    paint.setAlpha(paint.getAlpha() - 25);
                    canvas.drawBitmap((Bitmap) v41Var.getValue(), 0.0f, 0.0f, paint);
                    getHandler().postDelayed(this.hideCallback, 17L);
                    return;
                }
            }
            paint.setAlpha(225);
            value = this.draggingBitmap$delegate.getValue();
        }
        canvas.drawBitmap((Bitmap) value, 0.0f, 0.0f, paint);
    }

    @Override // android.view.View
    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.state != State.DRAGGING) {
            setState(State.VISIBLE);
            this.hideHandler.postDelayed(this.hideCallback, 2000L);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void setState(State state) {
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3 && i != 4) {
                    return;
                }
            } else if (0.0f / 0 < 1.5d) {
                return;
            }
        }
        this.hideHandler.removeCallbacks(this.hideCallback);
        this.state = state;
        invalidate();
    }
}
