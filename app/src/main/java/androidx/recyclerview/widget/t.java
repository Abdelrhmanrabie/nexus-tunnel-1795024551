package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class t extends u {
    public t(RecyclerView.o oVar) {
        super(oVar);
    }

    @Override // androidx.recyclerview.widget.u
    public final int b(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        this.a.getClass();
        return RecyclerView.o.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.u
    public final int c(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        this.a.getClass();
        Rect rect = ((RecyclerView.p) view.getLayoutParams()).b;
        return view.getMeasuredHeight() + rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.u
    public final int d(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        this.a.getClass();
        Rect rect = ((RecyclerView.p) view.getLayoutParams()).b;
        return view.getMeasuredWidth() + rect.left + rect.right + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
    }

    @Override // androidx.recyclerview.widget.u
    public final int e(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        this.a.getClass();
        return RecyclerView.o.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) pVar).topMargin;
    }

    @Override // androidx.recyclerview.widget.u
    public final int f() {
        return this.a.mHeight;
    }

    @Override // androidx.recyclerview.widget.u
    public final int g() {
        RecyclerView.o oVar = this.a;
        return oVar.mHeight - oVar.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.u
    public final int h() {
        return this.a.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.u
    public final int i() {
        return this.a.mHeightMode;
    }

    @Override // androidx.recyclerview.widget.u
    public final int j() {
        return this.a.mWidthMode;
    }

    @Override // androidx.recyclerview.widget.u
    public final int k() {
        return this.a.getPaddingTop();
    }

    @Override // androidx.recyclerview.widget.u
    public final int l() {
        RecyclerView.o oVar = this.a;
        return (oVar.mHeight - oVar.getPaddingTop()) - oVar.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.u
    public final int m(View view) {
        RecyclerView.o oVar = this.a;
        Rect rect = this.c;
        oVar.getTransformedBoundingBox(view, rect);
        return rect.bottom;
    }

    @Override // androidx.recyclerview.widget.u
    public final int n(View view) {
        RecyclerView.o oVar = this.a;
        Rect rect = this.c;
        oVar.getTransformedBoundingBox(view, rect);
        return rect.top;
    }

    @Override // androidx.recyclerview.widget.u
    public final void o(int i) {
        this.a.offsetChildrenVertical(i);
    }
}
