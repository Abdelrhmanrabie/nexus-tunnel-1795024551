package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import defpackage.e;
import defpackage.qd1;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MaterialDividerItemDecoration extends RecyclerView.n {
    public final int color;
    public final ShapeDrawable dividerDrawable;
    public final int insetEnd;
    public final int insetStart;
    public final int orientation;
    public final Rect tempRect;
    public final int thickness;

    public MaterialDividerItemDecoration(Context context, int i) {
        this(context, null, i);
    }

    public MaterialDividerItemDecoration(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, R.style.tk, i);
    }

    public MaterialDividerItemDecoration(Context context, AttributeSet attributeSet, int i, int i2) {
        this.tempRect = new Rect();
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, com.google.android.material.R.styleable.MaterialDivider, i, R.plurals.a2f, new int[0]);
        int defaultColor = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, 0).getDefaultColor();
        this.color = defaultColor;
        this.thickness = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, context.getResources().getDimensionPixelSize(R.dimen.in));
        this.insetStart = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0);
        this.insetEnd = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        this.color = defaultColor;
        this.dividerDrawable = shapeDrawable;
        shapeDrawable.setTint(defaultColor);
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException(e.i(i2, "Invalid orientation: ", ". It should be either HORIZONTAL or VERTICAL"));
        }
        this.orientation = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
        int i = this.thickness;
        int i2 = this.orientation;
        ShapeDrawable shapeDrawable = this.dividerDrawable;
        if (i2 == 1) {
            rect.bottom = shapeDrawable.getIntrinsicHeight() + i;
        } else {
            rect.right = shapeDrawable.getIntrinsicWidth() + i;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public final void onDraw(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int paddingTop;
        int width;
        int paddingLeft;
        if (recyclerView.mLayout == null) {
            return;
        }
        ShapeDrawable shapeDrawable = this.dividerDrawable;
        int i = this.thickness;
        int i2 = this.insetEnd;
        int i3 = this.insetStart;
        int i4 = this.orientation;
        Rect rect = this.tempRect;
        canvas.save();
        boolean z = recyclerView.mClipToPadding;
        int i5 = 0;
        if (i4 != 1) {
            if (z) {
                paddingTop = recyclerView.getPaddingTop();
                height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
            } else {
                height = recyclerView.getHeight();
                paddingTop = 0;
            }
            int i6 = paddingTop + i3;
            int i7 = height - i2;
            int childCount = recyclerView.getChildCount();
            while (i5 < childCount) {
                View childAt = recyclerView.getChildAt(i5);
                recyclerView.mLayout.getClass();
                RecyclerView.getDecoratedBoundsWithMarginsInt(childAt, rect);
                int iRound = Math.round(childAt.getTranslationX()) + rect.right;
                shapeDrawable.setBounds((iRound - shapeDrawable.getIntrinsicWidth()) - i, i6, iRound, i7);
                shapeDrawable.draw(canvas);
                i5++;
            }
            canvas.restore();
            return;
        }
        if (z) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        WeakHashMap weakHashMap = qd1.a;
        boolean z2 = recyclerView.getLayoutDirection() == 1;
        int i8 = paddingLeft + (z2 ? i2 : i3);
        if (z2) {
            i2 = i3;
        }
        int i9 = width - i2;
        int childCount2 = recyclerView.getChildCount();
        while (i5 < childCount2) {
            View childAt2 = recyclerView.getChildAt(i5);
            RecyclerView.getDecoratedBoundsWithMarginsInt(childAt2, rect);
            int iRound2 = Math.round(childAt2.getTranslationY()) + rect.bottom;
            shapeDrawable.setBounds(i8, (iRound2 - shapeDrawable.getIntrinsicHeight()) - i, i9, iRound2);
            shapeDrawable.draw(canvas);
            i5++;
        }
        canvas.restore();
    }
}
