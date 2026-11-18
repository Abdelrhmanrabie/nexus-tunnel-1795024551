package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class ViewOverlayApi14 implements ViewOverlayImpl {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class OverlayViewGroup extends ViewGroup {
        public final ArrayList drawables;
        public final ViewGroup hostView;
        public final View requestingView;

        static {
            try {
                Class cls = Integer.TYPE;
                ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        public OverlayViewGroup(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 viewOverlayApi14) {
            super(context);
            this.drawables = null;
            this.hostView = viewGroup;
            this.requestingView = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.hostView.getLocationOnScreen(iArr);
            View view = this.requestingView;
            view.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, view.getWidth(), view.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList arrayList = this.drawables;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Drawable) this.drawables.get(i)).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public final ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            ViewGroup viewGroup = this.hostView;
            if (viewGroup == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            this.requestingView.getLocationOnScreen(iArr3);
            int[] iArr4 = {iArr3[0] - iArr2[0], iArr3[1] - iArr2[1]};
            rect.offset(iArr4[0], iArr4[1]);
            return super.invalidateChildInParent(iArr, rect);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        @Override // android.view.View
        public final boolean verifyDrawable(Drawable drawable) {
            if (super.verifyDrawable(drawable)) {
                return true;
            }
            ArrayList arrayList = this.drawables;
            return arrayList != null && arrayList.contains(drawable);
        }
    }

    public ViewOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        new OverlayViewGroup(context, viewGroup, view, this);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public final void add(Drawable drawable) {
        throw null;
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public final void remove(Drawable drawable) {
        throw null;
    }
}
