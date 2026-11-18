package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.b2;
import defpackage.qd1;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {
    public final boolean b;
    public boolean c;
    public int d;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = -1;
        int[] iArr = b2.k;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        qd1.k(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, true);
        this.b = z;
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(z);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        boolean z;
        int i3;
        int paddingBottom;
        int size = View.MeasureSpec.getSize(i);
        boolean z2 = this.b;
        int measuredHeight = 0;
        if (z2) {
            if (size > this.d && this.c) {
                setStacked(false);
            }
            this.d = size;
        }
        if (this.c || View.MeasureSpec.getMode(i) != 1073741824) {
            iMakeMeasureSpec = i;
            z = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
            z = true;
        }
        super.onMeasure(iMakeMeasureSpec, i2);
        if (z2 && !this.c && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z = true;
        }
        if (z) {
            super.onMeasure(i, i2);
        }
        int childCount = getChildCount();
        int i4 = 0;
        while (true) {
            i3 = -1;
            if (i4 >= childCount) {
                i4 = -1;
                break;
            } else if (getChildAt(i4).getVisibility() == 0) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 >= 0) {
            View childAt = getChildAt(i4);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            measuredHeight = layoutParams.bottomMargin + childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin;
            if (this.c) {
                int childCount2 = getChildCount();
                for (int i5 = i4 + 1; i5 < childCount2; i5++) {
                    if (getChildAt(i5).getVisibility() == 0) {
                        i3 = i5;
                        break;
                    }
                }
                if (i3 >= 0) {
                    paddingBottom = getChildAt(i3).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
            } else {
                paddingBottom = getPaddingBottom();
            }
            measuredHeight += paddingBottom;
        }
        WeakHashMap weakHashMap = qd1.a;
        if (getMinimumHeight() != measuredHeight) {
            setMinimumHeight(measuredHeight);
            if (i2 == 0) {
                super.onMeasure(i, i2);
            }
        }
    }

    public final void setStacked(boolean z) {
        if (this.c != z) {
            if (!z || this.b) {
                this.c = z;
                setOrientation(z ? 1 : 0);
                setGravity(z ? 8388613 : 80);
                View viewFindViewById = findViewById(R.attr.yx);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }
}
