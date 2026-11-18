package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class s extends u {
    public s(RecyclerView.o oVar) {
        super(oVar);
    }

    @Override // androidx.recyclerview.widget.u
    public final int b(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        this.a.getClass();
        return RecyclerView.o.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
    }

    @Override // androidx.recyclerview.widget.u
    public final int c(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        this.a.getClass();
        Rect rect = ((RecyclerView.p) view.getLayoutParams()).b;
        return view.getMeasuredWidth() + rect.left + rect.right + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
    }

    @Override // androidx.recyclerview.widget.u
    public final int d(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        this.a.getClass();
        Rect rect = ((RecyclerView.p) view.getLayoutParams()).b;
        return view.getMeasuredHeight() + rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.u
    public final int e(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        this.a.getClass();
        return RecyclerView.o.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin;
    }

    @Override // androidx.recyclerview.widget.u
    public final int f() {
        return this.a.mWidth;
    }

    @Override // androidx.recyclerview.widget.u
    public final int g() {
        RecyclerView.o oVar = this.a;
        return oVar.mWidth - oVar.getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.u
    public final int h() {
        return this.a.getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.u
    public final int i() {
        return this.a.mWidthMode;
    }

    @Override // androidx.recyclerview.widget.u
    public final int j() {
        return this.a.mHeightMode;
    }

    @Override // androidx.recyclerview.widget.u
    public final int k() {
        return this.a.getPaddingLeft();
    }

    @Override // androidx.recyclerview.widget.u
    public final int l() {
        RecyclerView.o oVar = this.a;
        return (oVar.mWidth - oVar.getPaddingLeft()) - oVar.getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.u
    public final int m(View view) {
        RecyclerView.o oVar = this.a;
        Rect rect = this.c;
        oVar.getTransformedBoundingBox(view, rect);
        return rect.right;
    }

    @Override // androidx.recyclerview.widget.u
    public final int n(View view) {
        RecyclerView.o oVar = this.a;
        Rect rect = this.c;
        oVar.getTransformedBoundingBox(view, rect);
        return rect.left;
    }

    @Override // androidx.recyclerview.widget.u
    public final void o(int i) {
        this.a.offsetChildrenHorizontal(i);
    }
}
