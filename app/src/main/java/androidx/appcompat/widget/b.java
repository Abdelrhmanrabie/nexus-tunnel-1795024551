package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.b2;
import defpackage.e;
import defpackage.qd1;
import defpackage.ue1;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class b extends ViewGroup {
    public boolean mBaselineAligned;
    public final int mBaselineAlignedChildIndex;
    public int mBaselineChildTop;
    public final Drawable mDivider;
    public final int mDividerHeight;
    public final int mDividerPadding;
    public final int mDividerWidth;
    public final int mGravity;
    public int[] mMaxAscent;
    public int[] mMaxDescent;
    public int mOrientation;
    public final int mShowDividers;
    public int mTotalLength;
    public final boolean mUseLargestChild;
    public final float mWeightSum;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a extends LinearLayout.LayoutParams {
        public a(int i, int i2) {
            super(i, i2);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        int resourceId;
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        int[] iArr = b2.o;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        qd1.k(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i);
        int i2 = typedArrayObtainStyledAttributes.getInt(1, -1);
        if (i2 >= 0 && this.mOrientation != i2) {
            this.mOrientation = i2;
            requestLayout();
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(0, -1);
        if (i3 >= 0 && 8388659 != i3) {
            i3 = (8388615 & i3) == 0 ? i3 | 8388611 : i3;
            this.mGravity = (i3 & 112) == 0 ? i3 | 48 : i3;
            requestLayout();
        }
        boolean z = typedArrayObtainStyledAttributes.getBoolean(2, true);
        if (!z) {
            this.mBaselineAligned = z;
        }
        this.mWeightSum = typedArrayObtainStyledAttributes.getFloat(4, -1.0f);
        this.mBaselineAlignedChildIndex = typedArrayObtainStyledAttributes.getInt(3, -1);
        this.mUseLargestChild = typedArrayObtainStyledAttributes.getBoolean(7, false);
        Drawable drawable = (!typedArrayObtainStyledAttributes.hasValue(5) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(5, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(5) : e.s(context, resourceId);
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            setWillNotDraw(drawable == null);
            requestLayout();
        }
        this.mShowDividers = typedArrayObtainStyledAttributes.getInt(8, 0);
        this.mDividerPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public final void drawHorizontalDivider(Canvas canvas, int i) {
        int paddingLeft = getPaddingLeft();
        int i2 = this.mDividerPadding;
        this.mDivider.setBounds(paddingLeft + i2, i, (getWidth() - getPaddingRight()) - i2, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    public final void drawVerticalDivider(Canvas canvas, int i) {
        int paddingTop = getPaddingTop();
        int i2 = this.mDividerPadding;
        this.mDivider.setBounds(i, paddingTop + i2, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - i2);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public a generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new a(-2, -2);
        }
        if (i == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.View
    public final int getBaseline() {
        int i;
        int i2 = this.mBaselineAlignedChildIndex;
        if (i2 < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (i2 == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public final boolean hasDividerBeforeChildAt(int i) {
        int i2 = this.mShowDividers;
        if (i == 0) {
            if ((i2 & 1) == 0) {
                return false;
            }
        } else {
            if (i != getChildCount()) {
                if ((i2 & 2) == 0) {
                    return false;
                }
                for (int i3 = i - 1; i3 >= 0; i3--) {
                    if (getChildAt(i3).getVisibility() == 8) {
                    }
                }
                return false;
            }
            if ((i2 & 4) == 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int paddingRight;
        int bottom;
        if (this.mDivider == null) {
            return;
        }
        int i = 0;
        if (this.mOrientation == 1) {
            int childCount = getChildCount();
            while (i < childCount) {
                View childAt = getChildAt(i);
                if (childAt != null && childAt.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                    drawHorizontalDivider(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin) - this.mDividerHeight);
                }
                i++;
            }
            if (hasDividerBeforeChildAt(childCount)) {
                View childAt2 = getChildAt(childCount - 1);
                if (childAt2 == null) {
                    bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
                } else {
                    bottom = childAt2.getBottom() + ((LinearLayout.LayoutParams) ((a) childAt2.getLayoutParams())).bottomMargin;
                }
                drawHorizontalDivider(canvas, bottom);
                return;
            }
            return;
        }
        int childCount2 = getChildCount();
        boolean zA = ue1.a(this);
        while (i < childCount2) {
            View childAt3 = getChildAt(i);
            if (childAt3 != null && childAt3.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                a aVar = (a) childAt3.getLayoutParams();
                drawVerticalDivider(canvas, zA ? childAt3.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.mDividerWidth);
            }
            i++;
        }
        if (hasDividerBeforeChildAt(childCount2)) {
            View childAt4 = getChildAt(childCount2 - 1);
            if (childAt4 != null) {
                a aVar2 = (a) childAt4.getLayoutParams();
                if (zA) {
                    left = childAt4.getLeft();
                    paddingRight = ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    right = (left - paddingRight) - this.mDividerWidth;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (zA) {
                right = getPaddingLeft();
            } else {
                left = getWidth();
                paddingRight = getPaddingRight();
                right = (left - paddingRight) - this.mDividerWidth;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009c  */
    /* JADX WARN: Code duplicated, block: B:57:0x0154  */
    /* JADX WARN: Code duplicated, block: B:60:0x015e  */
    /* JADX WARN: Code duplicated, block: B:62:0x0162  */
    /* JADX WARN: Code duplicated, block: B:64:0x0166  */
    /* JADX WARN: Code duplicated, block: B:65:0x016a  */
    /* JADX WARN: Code duplicated, block: B:67:0x0172  */
    /* JADX WARN: Code duplicated, block: B:68:0x017d  */
    /* JADX WARN: Code duplicated, block: B:70:0x0184  */
    /* JADX WARN: Code duplicated, block: B:71:0x018b  */
    /* JADX WARN: Code duplicated, block: B:75:0x019e  */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        int i7;
        int baseline;
        int i8;
        int i9;
        int i10;
        int i11;
        int measuredHeight;
        int paddingTop;
        int i12;
        int i13;
        int i14 = this.mOrientation;
        int i15 = this.mGravity;
        int i16 = 8;
        char c = 2;
        char c2 = 1;
        if (i14 == 1) {
            int paddingLeft2 = getPaddingLeft();
            int i17 = i3 - i;
            int paddingRight = i17 - getPaddingRight();
            int paddingRight2 = (i17 - paddingLeft2) - getPaddingRight();
            int childCount = getChildCount();
            int i18 = i15 & 112;
            int i19 = i15 & 8388615;
            if (i18 != 16) {
                paddingTop = i18 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.mTotalLength;
            } else {
                paddingTop = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
            }
            int i20 = 0;
            while (i20 < childCount) {
                View childAt = getChildAt(i20);
                if (childAt != null && childAt.getVisibility() != i16) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    a aVar = (a) childAt.getLayoutParams();
                    int i21 = ((LinearLayout.LayoutParams) aVar).gravity;
                    if (i21 < 0) {
                        i21 = i19;
                    }
                    WeakHashMap weakHashMap = qd1.a;
                    int absoluteGravity = Gravity.getAbsoluteGravity(i21, getLayoutDirection()) & 7;
                    if (absoluteGravity != 1) {
                        if (absoluteGravity != 5) {
                            i13 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft2;
                        } else {
                            i12 = paddingRight - measuredWidth;
                        }
                        if (hasDividerBeforeChildAt(i20)) {
                            paddingTop += this.mDividerHeight;
                        }
                        int i22 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                        childAt.layout(i13, i22, measuredWidth + i13, measuredHeight2 + i22);
                        paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin + i22;
                    } else {
                        i12 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft2 + ((LinearLayout.LayoutParams) aVar).leftMargin;
                    }
                    i13 = i12 - ((LinearLayout.LayoutParams) aVar).rightMargin;
                    if (hasDividerBeforeChildAt(i20)) {
                        paddingTop += this.mDividerHeight;
                    }
                    int i23 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                    childAt.layout(i13, i23, measuredWidth + i13, measuredHeight2 + i23);
                    paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin + i23;
                }
                i20++;
                c = c;
                i16 = 8;
            }
            return;
        }
        boolean zA = ue1.a(this);
        int paddingTop2 = getPaddingTop();
        int i24 = i4 - i2;
        int paddingBottom = i24 - getPaddingBottom();
        int paddingBottom2 = (i24 - paddingTop2) - getPaddingBottom();
        int childCount2 = getChildCount();
        int i25 = 8388615 & i15;
        int i26 = i15 & 112;
        boolean z2 = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        WeakHashMap weakHashMap2 = qd1.a;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i25, getLayoutDirection());
        if (absoluteGravity2 != 1) {
            paddingLeft = absoluteGravity2 != 5 ? getPaddingLeft() : ((getPaddingLeft() + i3) - i) - this.mTotalLength;
        } else {
            paddingLeft = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        }
        if (zA) {
            i6 = childCount2 - 1;
            i5 = -1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i27 = paddingLeft;
        int i28 = 0;
        while (i28 < childCount2) {
            char c3 = c2;
            int i29 = (i5 * i28) + i6;
            View childAt2 = getChildAt(i29);
            if (childAt2 == null || childAt2.getVisibility() == 8) {
                i7 = i26;
                i10 = paddingTop2;
            } else {
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int measuredHeight3 = childAt2.getMeasuredHeight();
                a aVar2 = (a) childAt2.getLayoutParams();
                if (z2) {
                    i7 = i26;
                    baseline = ((LinearLayout.LayoutParams) aVar2).height != -1 ? childAt2.getBaseline() : -1;
                    i8 = ((LinearLayout.LayoutParams) aVar2).gravity;
                    if (i8 < 0) {
                        i8 = i7;
                    }
                    i9 = i8 & 112;
                    i10 = paddingTop2;
                    if (i9 != 16) {
                        if (i9 != 48) {
                            i11 = ((LinearLayout.LayoutParams) aVar2).topMargin + i10;
                            if (baseline != -1) {
                                i11 = (iArr[c3] - baseline) + i11;
                            }
                        } else if (i9 != 80) {
                            i11 = i10;
                        } else {
                            i11 = (paddingBottom - measuredHeight3) - ((LinearLayout.LayoutParams) aVar2).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight = iArr2[2] - (childAt2.getMeasuredHeight() - baseline);
                            }
                        }
                        if (hasDividerBeforeChildAt(i29)) {
                            i27 += this.mDividerWidth;
                        }
                        int i30 = ((LinearLayout.LayoutParams) aVar2).leftMargin + i27;
                        childAt2.layout(i30, i11, measuredWidth2 + i30, measuredHeight3 + i11);
                        i27 = measuredWidth2 + ((LinearLayout.LayoutParams) aVar2).rightMargin + i30;
                    } else {
                        i11 = ((paddingBottom2 - measuredHeight3) / 2) + i10 + ((LinearLayout.LayoutParams) aVar2).topMargin;
                        measuredHeight = ((LinearLayout.LayoutParams) aVar2).bottomMargin;
                    }
                    i11 -= measuredHeight;
                    if (hasDividerBeforeChildAt(i29)) {
                        i27 += this.mDividerWidth;
                    }
                    int i31 = ((LinearLayout.LayoutParams) aVar2).leftMargin + i27;
                    childAt2.layout(i31, i11, measuredWidth2 + i31, measuredHeight3 + i11);
                    i27 = measuredWidth2 + ((LinearLayout.LayoutParams) aVar2).rightMargin + i31;
                } else {
                    i7 = i26;
                }
                i8 = ((LinearLayout.LayoutParams) aVar2).gravity;
                if (i8 < 0) {
                    i8 = i7;
                }
                i9 = i8 & 112;
                i10 = paddingTop2;
                if (i9 != 16) {
                    if (i9 != 48) {
                        i11 = ((LinearLayout.LayoutParams) aVar2).topMargin + i10;
                        if (baseline != -1) {
                            i11 = (iArr[c3] - baseline) + i11;
                        }
                    } else if (i9 != 80) {
                        i11 = i10;
                    } else {
                        i11 = (paddingBottom - measuredHeight3) - ((LinearLayout.LayoutParams) aVar2).bottomMargin;
                        if (baseline != -1) {
                            measuredHeight = iArr2[2] - (childAt2.getMeasuredHeight() - baseline);
                        }
                    }
                    if (hasDividerBeforeChildAt(i29)) {
                        i27 += this.mDividerWidth;
                    }
                    int i32 = ((LinearLayout.LayoutParams) aVar2).leftMargin + i27;
                    childAt2.layout(i32, i11, measuredWidth2 + i32, measuredHeight3 + i11);
                    i27 = measuredWidth2 + ((LinearLayout.LayoutParams) aVar2).rightMargin + i32;
                } else {
                    i11 = ((paddingBottom2 - measuredHeight3) / 2) + i10 + ((LinearLayout.LayoutParams) aVar2).topMargin;
                    measuredHeight = ((LinearLayout.LayoutParams) aVar2).bottomMargin;
                }
                i11 -= measuredHeight;
                if (hasDividerBeforeChildAt(i29)) {
                    i27 += this.mDividerWidth;
                }
                int i33 = ((LinearLayout.LayoutParams) aVar2).leftMargin + i27;
                childAt2.layout(i33, i11, measuredWidth2 + i33, measuredHeight3 + i11);
                i27 = measuredWidth2 + ((LinearLayout.LayoutParams) aVar2).rightMargin + i33;
            }
            i28++;
            i6 = i6;
            i26 = i7;
            c2 = c3;
            paddingTop2 = i10;
        }
    }

    /* JADX WARN: Code duplicated, block: B:135:0x028d  */
    /* JADX WARN: Code duplicated, block: B:365:0x0760  */
    /* JADX WARN: Code duplicated, block: B:64:0x0148 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x014b  */
    /* JADX WARN: Code duplicated, block: B:68:0x0151 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x0154  */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int iMax;
        int i6;
        int baseline;
        int iMax2;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        a aVar;
        View view;
        int i11;
        boolean z2;
        boolean z3;
        int iMax3;
        int i12;
        int iMax4;
        int i13;
        int i14;
        int iMax5;
        int i15;
        int i16;
        int i17;
        float f;
        boolean z4;
        int i18;
        int i19;
        boolean z5;
        int i20;
        int i21;
        View view2;
        boolean z6;
        b bVar = this;
        int i22 = bVar.mOrientation;
        float f2 = bVar.mWeightSum;
        boolean z7 = bVar.mUseLargestChild;
        int i23 = -2;
        int i24 = 8;
        int i25 = 1073741824;
        int iMax6 = 0;
        boolean z8 = true;
        if (i22 == 1) {
            bVar.mTotalLength = 0;
            int childCount = bVar.getChildCount();
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            boolean z9 = true;
            int i26 = 0;
            int iMax7 = 0;
            int iMax8 = 0;
            int iMax9 = 0;
            boolean z10 = false;
            boolean z11 = false;
            int i27 = 0;
            float f3 = 0.0f;
            while (i26 < childCount) {
                int i28 = childCount;
                View childAt = bVar.getChildAt(i26);
                if (childAt == null) {
                    bVar.mTotalLength = bVar.mTotalLength;
                } else {
                    if (childAt.getVisibility() != i24) {
                        if (bVar.hasDividerBeforeChildAt(i26)) {
                            bVar.mTotalLength += bVar.mDividerHeight;
                        }
                        a aVar2 = (a) childAt.getLayoutParams();
                        float f4 = ((LinearLayout.LayoutParams) aVar2).weight;
                        f3 += f4;
                        if (mode2 == i25 && ((LinearLayout.LayoutParams) aVar2).height == 0 && f4 > 0.0f) {
                            int i29 = bVar.mTotalLength;
                            bVar.mTotalLength = Math.max(i29, ((LinearLayout.LayoutParams) aVar2).topMargin + i29 + ((LinearLayout.LayoutParams) aVar2).bottomMargin);
                            view2 = childAt;
                            i18 = mode;
                            f = f2;
                            z4 = z7;
                            i19 = i28;
                            z10 = true;
                            z5 = true;
                            i21 = mode2;
                            i20 = i26;
                        } else {
                            if (((LinearLayout.LayoutParams) aVar2).height != 0 || f4 <= 0.0f) {
                                i15 = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                            } else {
                                ((LinearLayout.LayoutParams) aVar2).height = i23;
                                i15 = 0;
                            }
                            if (f3 == 0.0f) {
                                int i30 = i26;
                                i17 = bVar.mTotalLength;
                                i16 = i30;
                            } else {
                                i16 = i26;
                                i17 = 0;
                            }
                            f = f2;
                            z4 = z7;
                            i18 = mode;
                            i19 = i28;
                            z5 = true;
                            i20 = i16;
                            i21 = mode2;
                            bVar.measureChildWithMargins(childAt, i, 0, i2, i17);
                            if (i15 != Integer.MIN_VALUE) {
                                ((LinearLayout.LayoutParams) aVar2).height = i15;
                            }
                            int measuredHeight = childAt.getMeasuredHeight();
                            int i31 = bVar.mTotalLength;
                            view2 = childAt;
                            bVar.mTotalLength = Math.max(i31, i31 + measuredHeight + ((LinearLayout.LayoutParams) aVar2).topMargin + ((LinearLayout.LayoutParams) aVar2).bottomMargin);
                            if (z4) {
                                iMax9 = Math.max(measuredHeight, iMax9);
                            }
                        }
                        int i32 = bVar.mBaselineAlignedChildIndex;
                        if (i32 >= 0 && i32 == i20 + 1) {
                            bVar.mBaselineChildTop = bVar.mTotalLength;
                        }
                        if (i20 < i32 && ((LinearLayout.LayoutParams) aVar2).weight > 0.0f) {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                        if (i18 == 1073741824 || ((LinearLayout.LayoutParams) aVar2).width != -1) {
                            z6 = false;
                        } else {
                            z6 = z5;
                            z11 = z6;
                        }
                        int i33 = ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                        int measuredWidth = view2.getMeasuredWidth() + i33;
                        iMax7 = Math.max(iMax7, measuredWidth);
                        int measuredState = view2.getMeasuredState();
                        boolean z12 = z6;
                        int iCombineMeasuredStates = View.combineMeasuredStates(i27, measuredState);
                        if (z9) {
                            i27 = iCombineMeasuredStates;
                            boolean z13 = ((LinearLayout.LayoutParams) aVar2).width == -1 ? z5 : false;
                            if (((LinearLayout.LayoutParams) aVar2).weight > 0.0f) {
                                if (!z12) {
                                    i33 = measuredWidth;
                                }
                                iMax8 = Math.max(iMax8, i33);
                            } else {
                                if (!z12) {
                                    i33 = measuredWidth;
                                }
                                iMax6 = Math.max(iMax6, i33);
                            }
                            z9 = z13;
                        } else {
                            i27 = iCombineMeasuredStates;
                        }
                        if (((LinearLayout.LayoutParams) aVar2).weight > 0.0f) {
                            if (!z12) {
                                i33 = measuredWidth;
                            }
                            iMax8 = Math.max(iMax8, i33);
                        } else {
                            if (!z12) {
                                i33 = measuredWidth;
                            }
                            iMax6 = Math.max(iMax6, i33);
                        }
                        z9 = z13;
                    }
                    i26 = i20 + 1;
                    mode2 = i21;
                    mode = i18;
                    childCount = i19;
                    z8 = z5;
                    f2 = f;
                    z7 = z4;
                    i23 = -2;
                    i24 = 8;
                    i25 = 1073741824;
                }
                i18 = mode;
                f = f2;
                z4 = z7;
                i19 = i28;
                z5 = true;
                i21 = mode2;
                i20 = i26;
                i26 = i20 + 1;
                mode2 = i21;
                mode = i18;
                childCount = i19;
                z8 = z5;
                f2 = f;
                z7 = z4;
                i23 = -2;
                i24 = 8;
                i25 = 1073741824;
            }
            int i34 = childCount;
            boolean z14 = z8;
            int i35 = mode;
            float f5 = f2;
            boolean z15 = z7;
            int i36 = i27;
            int i37 = mode2;
            int i38 = i2;
            if (bVar.mTotalLength > 0 && bVar.hasDividerBeforeChildAt(i34)) {
                bVar.mTotalLength += bVar.mDividerHeight;
            }
            if (z15 && (i37 == Integer.MIN_VALUE || i37 == 0)) {
                bVar.mTotalLength = 0;
                for (int i39 = 0; i39 < i34; i39++) {
                    View childAt2 = bVar.getChildAt(i39);
                    if (childAt2 == null) {
                        iMax5 = bVar.mTotalLength;
                    } else {
                        if (childAt2.getVisibility() != 8) {
                            a aVar3 = (a) childAt2.getLayoutParams();
                            int i40 = bVar.mTotalLength;
                            iMax5 = Math.max(i40, i40 + iMax9 + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin);
                        }
                    }
                    bVar.mTotalLength = iMax5;
                }
            }
            int paddingBottom = bVar.getPaddingBottom() + bVar.getPaddingTop() + bVar.mTotalLength;
            bVar.mTotalLength = paddingBottom;
            int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, bVar.getSuggestedMinimumHeight()), i38, 0);
            int i41 = (iResolveSizeAndState & 16777215) - bVar.mTotalLength;
            if (z10 || (i41 != 0 && f3 > 0.0f)) {
                if (f5 <= 0.0f) {
                    f5 = f3;
                }
                bVar.mTotalLength = 0;
                int iCombineMeasuredStates2 = i36;
                int i42 = 0;
                while (i42 < i34) {
                    View childAt3 = bVar.getChildAt(i42);
                    if (childAt3.getVisibility() == 8) {
                        i42 = i42;
                    } else {
                        a aVar4 = (a) childAt3.getLayoutParams();
                        float f6 = ((LinearLayout.LayoutParams) aVar4).weight;
                        if (f6 > 0.0f) {
                            int i43 = (int) ((i41 * f6) / f5);
                            f5 -= f6;
                            i41 -= i43;
                            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, bVar.getPaddingRight() + bVar.getPaddingLeft() + ((LinearLayout.LayoutParams) aVar4).leftMargin + ((LinearLayout.LayoutParams) aVar4).rightMargin, ((LinearLayout.LayoutParams) aVar4).width);
                            if (((LinearLayout.LayoutParams) aVar4).height != 0 || i37 != 1073741824) {
                                int measuredHeight2 = childAt3.getMeasuredHeight() + i43;
                                if (measuredHeight2 < 0) {
                                    i14 = 1073741824;
                                    i43 = 0;
                                } else {
                                    i43 = measuredHeight2;
                                    i14 = 1073741824;
                                }
                            } else if (i43 > 0) {
                                i14 = 1073741824;
                            } else {
                                i14 = 1073741824;
                                i43 = 0;
                            }
                            childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i43, i14));
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, childAt3.getMeasuredState() & (-256));
                        }
                        int i44 = ((LinearLayout.LayoutParams) aVar4).leftMargin + ((LinearLayout.LayoutParams) aVar4).rightMargin;
                        int measuredWidth2 = childAt3.getMeasuredWidth() + i44;
                        iMax7 = Math.max(iMax7, measuredWidth2);
                        if (i35 != 1073741824) {
                            i13 = -1;
                            if (((LinearLayout.LayoutParams) aVar4).width == -1) {
                                measuredWidth2 = i44;
                            }
                        } else {
                            i13 = -1;
                        }
                        int iMax10 = Math.max(iMax6, measuredWidth2);
                        boolean z16 = (z9 && ((LinearLayout.LayoutParams) aVar4).width == i13) ? z14 : false;
                        int i45 = bVar.mTotalLength;
                        bVar.mTotalLength = Math.max(i45, childAt3.getMeasuredHeight() + i45 + ((LinearLayout.LayoutParams) aVar4).topMargin + ((LinearLayout.LayoutParams) aVar4).bottomMargin);
                        z9 = z16;
                        iMax6 = iMax10;
                    }
                    i42++;
                }
                bVar.mTotalLength = bVar.getPaddingBottom() + bVar.getPaddingTop() + bVar.mTotalLength;
                i36 = iCombineMeasuredStates2;
                iMax4 = iMax6;
            } else {
                iMax4 = Math.max(iMax6, iMax8);
                if (z15 && i37 != 1073741824) {
                    for (int i46 = 0; i46 < i34; i46++) {
                        View childAt4 = bVar.getChildAt(i46);
                        if (childAt4 != null && childAt4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) childAt4.getLayoutParams())).weight > 0.0f) {
                            childAt4.measure(View.MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(iMax9, 1073741824));
                        }
                    }
                }
            }
            if (z9 || i35 == 1073741824) {
                iMax4 = iMax7;
            }
            bVar.setMeasuredDimension(View.resolveSizeAndState(Math.max(bVar.getPaddingRight() + bVar.getPaddingLeft() + iMax4, bVar.getSuggestedMinimumWidth()), i, i36), iResolveSizeAndState);
            if (z11) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(bVar.getMeasuredWidth(), 1073741824);
                int i47 = 0;
                while (i47 < i34) {
                    View childAt5 = bVar.getChildAt(i47);
                    if (childAt5.getVisibility() != 8) {
                        a aVar5 = (a) childAt5.getLayoutParams();
                        if (((LinearLayout.LayoutParams) aVar5).width == -1) {
                            int i48 = ((LinearLayout.LayoutParams) aVar5).height;
                            ((LinearLayout.LayoutParams) aVar5).height = childAt5.getMeasuredHeight();
                            bVar.measureChildWithMargins(childAt5, iMakeMeasureSpec, 0, i38, 0);
                            ((LinearLayout.LayoutParams) aVar5).height = i48;
                        }
                    }
                    i47++;
                    i38 = i2;
                }
                return;
            }
            return;
        }
        float f7 = f2;
        int i49 = i;
        bVar.mTotalLength = 0;
        int childCount2 = bVar.getChildCount();
        int mode3 = View.MeasureSpec.getMode(i49);
        int mode4 = View.MeasureSpec.getMode(i2);
        if (bVar.mMaxAscent == null || bVar.mMaxDescent == null) {
            bVar.mMaxAscent = new int[4];
            bVar.mMaxDescent = new int[4];
        }
        int[] iArr = bVar.mMaxAscent;
        int[] iArr2 = bVar.mMaxDescent;
        iArr[3] = -1;
        char c = 2;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z17 = bVar.mBaselineAligned;
        boolean z18 = mode3 == 1073741824;
        float f8 = 0.0f;
        boolean z19 = true;
        int i50 = 0;
        int i51 = 0;
        int i52 = 0;
        int iMax11 = 0;
        int iMax12 = 0;
        int iCombineMeasuredStates3 = 0;
        boolean z20 = false;
        boolean z21 = false;
        while (i50 < childCount2) {
            char c2 = c;
            View childAt6 = bVar.getChildAt(i50);
            if (childAt6 == null) {
                bVar.mTotalLength = bVar.mTotalLength;
                i7 = i51;
            } else {
                i7 = i51;
                if (childAt6.getVisibility() != 8) {
                    if (bVar.hasDividerBeforeChildAt(i50)) {
                        bVar.mTotalLength += bVar.mDividerWidth;
                    }
                    a aVar6 = (a) childAt6.getLayoutParams();
                    float f9 = ((LinearLayout.LayoutParams) aVar6).weight;
                    f8 += f9;
                    int i53 = i50;
                    if (mode3 == 1073741824 && ((LinearLayout.LayoutParams) aVar6).width == 0 && f9 > 0.0f) {
                        int i54 = bVar.mTotalLength;
                        int i55 = ((LinearLayout.LayoutParams) aVar6).leftMargin;
                        int i56 = ((LinearLayout.LayoutParams) aVar6).rightMargin;
                        if (z18) {
                            bVar.mTotalLength = i55 + i56 + i54;
                        } else {
                            bVar.mTotalLength = Math.max(i54, i55 + i54 + i56);
                        }
                        if (z17) {
                            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                            childAt6.measure(iMakeMeasureSpec2, iMakeMeasureSpec2);
                        } else {
                            z20 = true;
                        }
                        view = childAt6;
                        z = z18;
                        i10 = i53;
                        i11 = 1073741824;
                        aVar = aVar6;
                        i49 = i;
                        i9 = iMax11;
                    } else {
                        if (((LinearLayout.LayoutParams) aVar6).width != 0 || f9 <= 0.0f) {
                            i8 = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                        } else {
                            ((LinearLayout.LayoutParams) aVar6).width = -2;
                            i8 = 0;
                        }
                        i9 = iMax11;
                        i10 = i53;
                        z = z18;
                        int i57 = i8;
                        aVar = aVar6;
                        i49 = i;
                        bVar.measureChildWithMargins(childAt6, i49, f8 == 0.0f ? bVar.mTotalLength : 0, i2, 0);
                        if (i57 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) aVar).width = i57;
                        }
                        int measuredWidth3 = childAt6.getMeasuredWidth();
                        int i58 = bVar.mTotalLength;
                        int i59 = ((LinearLayout.LayoutParams) aVar).leftMargin;
                        view = childAt6;
                        int i60 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                        if (z) {
                            bVar.mTotalLength = i59 + measuredWidth3 + i60 + i58;
                        } else {
                            bVar.mTotalLength = Math.max(i58, i58 + measuredWidth3 + i59 + i60);
                        }
                        if (z7) {
                            iMax12 = Math.max(measuredWidth3, iMax12);
                        }
                        i11 = 1073741824;
                    }
                    if (mode4 == i11 || ((LinearLayout.LayoutParams) aVar).height != -1) {
                        z2 = false;
                    } else {
                        z2 = true;
                        z21 = true;
                    }
                    int i61 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                    int measuredHeight3 = view.getMeasuredHeight() + i61;
                    iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, view.getMeasuredState());
                    if (z17 != 0) {
                        int baseline2 = view.getBaseline();
                        z3 = z2;
                        if (baseline2 != -1) {
                            int i62 = ((LinearLayout.LayoutParams) aVar).gravity;
                            if (i62 < 0) {
                                i62 = bVar.mGravity;
                            }
                            int i63 = (((i62 & 112) >> 4) & (-2)) >> 1;
                            iArr[i63] = Math.max(iArr[i63], baseline2);
                            iArr2[i63] = Math.max(iArr2[i63], measuredHeight3 - baseline2);
                        }
                    } else {
                        z3 = z2;
                    }
                    int iMax13 = Math.max(i7, measuredHeight3);
                    boolean z22 = z19 && ((LinearLayout.LayoutParams) aVar).height == -1;
                    if (((LinearLayout.LayoutParams) aVar).weight > 0.0f) {
                        if (!z3) {
                            i61 = measuredHeight3;
                        }
                        iMax11 = Math.max(i9, i61);
                        iMax3 = i52;
                    } else {
                        if (!z3) {
                            i61 = measuredHeight3;
                        }
                        iMax3 = Math.max(i52, i61);
                        iMax11 = i9;
                    }
                    int i64 = iMax3;
                    i51 = iMax13;
                    i12 = i64;
                    z19 = z22;
                }
                i52 = i12;
                i50 = i10 + 1;
                c = c2;
                iArr = iArr;
                iArr2 = iArr2;
                z17 = z17;
                z18 = z;
            }
            i49 = i;
            i10 = i50;
            i12 = i52;
            iArr2 = iArr2;
            z17 = z17;
            z = z18;
            i51 = i7;
            iArr = iArr;
            i52 = i12;
            i50 = i10 + 1;
            c = c2;
            iArr = iArr;
            iArr2 = iArr2;
            z17 = z17;
            z18 = z;
        }
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        char c3 = c;
        boolean z23 = z17;
        boolean z24 = z18;
        int i65 = i51;
        int i66 = i52;
        int i67 = iMax11;
        if (bVar.mTotalLength > 0 && bVar.hasDividerBeforeChildAt(childCount2)) {
            bVar.mTotalLength += bVar.mDividerWidth;
        }
        int i68 = iArr3[1];
        int iMax14 = (i68 == -1 && iArr3[0] == -1 && iArr3[c3] == -1 && iArr3[3] == -1) ? i65 : Math.max(i65, Math.max(iArr4[3], Math.max(iArr4[0], Math.max(iArr4[1], iArr4[c3]))) + Math.max(iArr3[3], Math.max(iArr3[0], Math.max(i68, iArr3[c3]))));
        if (z7 && (mode3 == Integer.MIN_VALUE || mode3 == 0)) {
            bVar.mTotalLength = 0;
            for (int i69 = 0; i69 < childCount2; i69++) {
                View childAt7 = bVar.getChildAt(i69);
                if (childAt7 == null) {
                    iMax2 = bVar.mTotalLength;
                } else {
                    if (childAt7.getVisibility() != 8) {
                        a aVar7 = (a) childAt7.getLayoutParams();
                        int i70 = bVar.mTotalLength;
                        if (z24) {
                            bVar.mTotalLength = ((LinearLayout.LayoutParams) aVar7).leftMargin + iMax12 + ((LinearLayout.LayoutParams) aVar7).rightMargin + i70;
                        } else {
                            iMax2 = Math.max(i70, i70 + iMax12 + ((LinearLayout.LayoutParams) aVar7).leftMargin + ((LinearLayout.LayoutParams) aVar7).rightMargin);
                        }
                    }
                }
                bVar.mTotalLength = iMax2;
            }
        }
        int paddingRight = bVar.getPaddingRight() + bVar.getPaddingLeft() + bVar.mTotalLength;
        bVar.mTotalLength = paddingRight;
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingRight, bVar.getSuggestedMinimumWidth()), i49, 0);
        int i71 = (iResolveSizeAndState2 & 16777215) - bVar.mTotalLength;
        if (z20 || (i71 != 0 && f8 > 0.0f)) {
            if (f7 <= 0.0f) {
                f7 = f8;
            }
            iArr3[3] = -1;
            iArr3[c3] = -1;
            iArr3[1] = -1;
            iArr3[0] = -1;
            iArr4[3] = -1;
            iArr4[c3] = -1;
            iArr4[1] = -1;
            iArr4[0] = -1;
            bVar.mTotalLength = 0;
            iMax14 = -1;
            int i72 = 0;
            while (i72 < childCount2) {
                View childAt8 = bVar.getChildAt(i72);
                if (childAt8 == null || childAt8.getVisibility() == 8) {
                    iResolveSizeAndState2 = iResolveSizeAndState2;
                } else {
                    a aVar8 = (a) childAt8.getLayoutParams();
                    float f10 = ((LinearLayout.LayoutParams) aVar8).weight;
                    if (f10 > 0.0f) {
                        int measuredWidth4 = (int) ((i71 * f10) / f7);
                        f7 -= f10;
                        i71 -= measuredWidth4;
                        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, bVar.getPaddingBottom() + bVar.getPaddingTop() + ((LinearLayout.LayoutParams) aVar8).topMargin + ((LinearLayout.LayoutParams) aVar8).bottomMargin, ((LinearLayout.LayoutParams) aVar8).height);
                        if (((LinearLayout.LayoutParams) aVar8).width != 0 || mode3 != 1073741824 ? (measuredWidth4 = measuredWidth4 + childAt8.getMeasuredWidth()) < 0 : measuredWidth4 <= 0) {
                            measuredWidth4 = 0;
                        }
                        childAt8.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth4, 1073741824), childMeasureSpec2);
                        iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, childAt8.getMeasuredState() & (-16777216));
                    }
                    int i73 = bVar.mTotalLength;
                    int measuredWidth5 = childAt8.getMeasuredWidth();
                    int i74 = ((LinearLayout.LayoutParams) aVar8).leftMargin;
                    int i75 = ((LinearLayout.LayoutParams) aVar8).rightMargin;
                    if (z24) {
                        bVar.mTotalLength = measuredWidth5 + i74 + i75 + i73;
                    } else {
                        bVar.mTotalLength = Math.max(i73, measuredWidth5 + i73 + i74 + i75);
                    }
                    boolean z25 = mode4 != 1073741824 && ((LinearLayout.LayoutParams) aVar8).height == -1;
                    int i76 = ((LinearLayout.LayoutParams) aVar8).topMargin + ((LinearLayout.LayoutParams) aVar8).bottomMargin;
                    int measuredHeight4 = childAt8.getMeasuredHeight() + i76;
                    iMax14 = Math.max(iMax14, measuredHeight4);
                    if (!z25) {
                        i76 = measuredHeight4;
                    }
                    int iMax15 = Math.max(i66, i76);
                    if (z19) {
                        i6 = -1;
                        boolean z26 = ((LinearLayout.LayoutParams) aVar8).height == -1;
                        if (!z23 && (baseline = childAt8.getBaseline()) != i6) {
                            int i77 = ((LinearLayout.LayoutParams) aVar8).gravity;
                            if (i77 < 0) {
                                i77 = bVar.mGravity;
                            }
                            int i78 = (((i77 & 112) >> 4) & (-2)) >> 1;
                            iArr3[i78] = Math.max(iArr3[i78], baseline);
                            iArr4[i78] = Math.max(iArr4[i78], measuredHeight4 - baseline);
                        }
                        i66 = iMax15;
                        z19 = z26;
                    } else {
                        i6 = -1;
                    }
                    if (!z23) {
                    }
                    i66 = iMax15;
                    z19 = z26;
                }
                i72++;
                iResolveSizeAndState2 = iResolveSizeAndState2;
            }
            i3 = iResolveSizeAndState2;
            i4 = -16777216;
            bVar.mTotalLength = bVar.getPaddingRight() + bVar.getPaddingLeft() + bVar.mTotalLength;
            int i79 = iArr3[1];
            if (i79 == -1 && iArr3[0] == -1 && iArr3[c3] == -1 && iArr3[3] == -1) {
                i5 = 0;
            } else {
                i5 = 0;
                iMax14 = Math.max(iMax14, Math.max(iArr4[3], Math.max(iArr4[0], Math.max(iArr4[1], iArr4[c3]))) + Math.max(iArr3[3], Math.max(iArr3[0], Math.max(i79, iArr3[c3]))));
            }
            iMax = i66;
        } else {
            iMax = Math.max(i66, i67);
            if (z7 && mode3 != 1073741824) {
                for (int i80 = 0; i80 < childCount2; i80++) {
                    View childAt9 = bVar.getChildAt(i80);
                    if (childAt9 != null && childAt9.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) childAt9.getLayoutParams())).weight > 0.0f) {
                        childAt9.measure(View.MeasureSpec.makeMeasureSpec(iMax12, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt9.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = iResolveSizeAndState2;
            i4 = -16777216;
            i5 = 0;
        }
        if (!z19 && mode4 != 1073741824) {
            iMax14 = iMax;
        }
        bVar.setMeasuredDimension(i3 | (iCombineMeasuredStates3 & i4), View.resolveSizeAndState(Math.max(bVar.getPaddingBottom() + bVar.getPaddingTop() + iMax14, bVar.getSuggestedMinimumHeight()), i2, iCombineMeasuredStates3 << 16));
        if (z21) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(bVar.getMeasuredHeight(), 1073741824);
            int i81 = i5;
            while (i81 < childCount2) {
                View childAt10 = bVar.getChildAt(i81);
                if (childAt10.getVisibility() != 8) {
                    a aVar9 = (a) childAt10.getLayoutParams();
                    if (((LinearLayout.LayoutParams) aVar9).height == -1) {
                        int i82 = ((LinearLayout.LayoutParams) aVar9).width;
                        ((LinearLayout.LayoutParams) aVar9).width = childAt10.getMeasuredWidth();
                        bVar.measureChildWithMargins(childAt10, i, 0, iMakeMeasureSpec3, 0);
                        ((LinearLayout.LayoutParams) aVar9).width = i82;
                    }
                }
                i81++;
                bVar = this;
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
