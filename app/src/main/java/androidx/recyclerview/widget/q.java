package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class q extends RecyclerView.z {
    public final DisplayMetrics mDisplayMetrics;
    public float mMillisPerPixel;
    public PointF mTargetVector;
    public final LinearInterpolator mLinearInterpolator = new LinearInterpolator();
    public final DecelerateInterpolator mDecelerateInterpolator = new DecelerateInterpolator();
    public boolean mHasCalculatedMillisPerPixel = false;
    public int mInterimTargetDx = 0;
    public int mInterimTargetDy = 0;

    public q(Context context) {
        this.mDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    public static int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            defpackage.d.AnonymousClass0.m$2("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            return 0;
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int calculateTimeForScrolling(int i) {
        float fAbs = Math.abs(i);
        if (!this.mHasCalculatedMillisPerPixel) {
            this.mMillisPerPixel = calculateSpeedPerPixel(this.mDisplayMetrics);
            this.mHasCalculatedMillisPerPixel = true;
        }
        return (int) Math.ceil(fAbs * this.mMillisPerPixel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    public final void onSeekTargetStep(int i, int i2, RecyclerView.z.a aVar) {
        if (this.mRecyclerView.mLayout.getChildCount() == 0) {
            stop();
            return;
        }
        int i3 = this.mInterimTargetDx;
        int i4 = i3 - i;
        if (i3 * i4 <= 0) {
            i4 = 0;
        }
        this.mInterimTargetDx = i4;
        int i5 = this.mInterimTargetDy;
        int i6 = i5 - i2;
        int i7 = i5 * i6 > 0 ? i6 : 0;
        this.mInterimTargetDy = i7;
        if (i4 == 0 && i7 == 0) {
            int i8 = this.mTargetPosition;
            Object obj = this.mLayoutManager;
            PointF pointFComputeScrollVectorForPosition = obj instanceof RecyclerView.z.b ? ((RecyclerView.z.b) obj).computeScrollVectorForPosition(i8) : null;
            if (pointFComputeScrollVectorForPosition != null) {
                float f = pointFComputeScrollVectorForPosition.x;
                if (f != 0.0f || pointFComputeScrollVectorForPosition.y != 0.0f) {
                    float f2 = pointFComputeScrollVectorForPosition.y;
                    float fSqrt = (float) Math.sqrt((f2 * f2) + (f * f));
                    float f3 = pointFComputeScrollVectorForPosition.x / fSqrt;
                    pointFComputeScrollVectorForPosition.x = f3;
                    float f4 = pointFComputeScrollVectorForPosition.y / fSqrt;
                    pointFComputeScrollVectorForPosition.y = f4;
                    this.mTargetVector = pointFComputeScrollVectorForPosition;
                    this.mInterimTargetDx = (int) (f3 * 10000.0f);
                    this.mInterimTargetDy = (int) (f4 * 10000.0f);
                    int iCalculateTimeForScrolling = calculateTimeForScrolling(10000);
                    int i9 = (int) (this.mInterimTargetDx * 1.2f);
                    int i10 = (int) (this.mInterimTargetDy * 1.2f);
                    aVar.a = i9;
                    aVar.b = i10;
                    aVar.c = (int) (iCalculateTimeForScrolling * 1.2f);
                    aVar.e = this.mLinearInterpolator;
                    aVar.f = true;
                    return;
                }
            }
            aVar.d = this.mTargetPosition;
            stop();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    public final void onStop() {
        this.mInterimTargetDy = 0;
        this.mInterimTargetDx = 0;
        this.mTargetVector = null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0015  */
    /* JADX WARN: Code duplicated, block: B:25:0x0055  */
    @Override // androidx.recyclerview.widget.RecyclerView.z
    public void onTargetFound(View view, RecyclerView.z.a aVar) {
        int i;
        int iCalculateDtToFit;
        PointF pointF = this.mTargetVector;
        int i2 = -1;
        int iCalculateDtToFit2 = 0;
        if (pointF != null) {
            float f = pointF.x;
            if (f == 0.0f) {
                i = 0;
            } else {
                i = f > 0.0f ? 1 : -1;
            }
        } else {
            i = 0;
        }
        RecyclerView.o oVar = this.mLayoutManager;
        if (oVar == null || !oVar.canScrollHorizontally()) {
            iCalculateDtToFit = 0;
        } else {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            iCalculateDtToFit = calculateDtToFit(RecyclerView.o.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, RecyclerView.o.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, oVar.getPaddingLeft(), oVar.mWidth - oVar.getPaddingRight(), i);
        }
        PointF pointF2 = this.mTargetVector;
        if (pointF2 != null) {
            float f2 = pointF2.y;
            if (f2 == 0.0f) {
                i2 = 0;
            } else if (f2 > 0.0f) {
                i2 = 1;
            }
        } else {
            i2 = 0;
        }
        RecyclerView.o oVar2 = this.mLayoutManager;
        if (oVar2 != null && oVar2.canScrollVertically()) {
            RecyclerView.p pVar2 = (RecyclerView.p) view.getLayoutParams();
            iCalculateDtToFit2 = calculateDtToFit(RecyclerView.o.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) pVar2).topMargin, RecyclerView.o.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) pVar2).bottomMargin, oVar2.getPaddingTop(), oVar2.mHeight - oVar2.getPaddingBottom(), i2);
        }
        int iCeil = (int) Math.ceil(((double) calculateTimeForScrolling((int) Math.sqrt((iCalculateDtToFit2 * iCalculateDtToFit2) + (iCalculateDtToFit * iCalculateDtToFit)))) / 0.3356d);
        if (iCeil > 0) {
            aVar.a = -iCalculateDtToFit;
            aVar.b = -iCalculateDtToFit2;
            aVar.c = iCeil;
            aVar.e = this.mDecelerateInterpolator;
            aVar.f = true;
        }
    }
}
