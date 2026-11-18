package defpackage;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.AlertController;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class e6 extends Spinner {
    public static final int[] o = {R.attr.spinnerMode};
    public final y4 b;
    public final Context c;
    public final d6 d;
    public SpinnerAdapter f;
    public final boolean g;
    public final f i;
    public int j;
    public final Rect n;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ int G0;
        public final /* synthetic */ Object b;

        public /* synthetic */ a(int i, Object obj) {
            this.G0 = i;
            this.b = obj;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            int i = this.G0;
            Object obj = this.b;
            if (i == 0) {
                e6 e6Var = (e6) obj;
                f fVar = e6Var.i;
                if (!fVar.a()) {
                    fVar.j(e6Var.getTextDirection(), e6Var.getTextAlignment());
                }
                ViewTreeObserver viewTreeObserver = e6Var.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                    return;
                }
                return;
            }
            d dVar = (d) obj;
            e6 e6Var2 = e6.this;
            WeakHashMap weakHashMap = qd1.a;
            if (!e6Var2.isAttachedToWindow() || !e6Var2.getGlobalVisibleRect(dVar.K)) {
                dVar.dismiss();
            } else {
                dVar.q();
                dVar.show();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b implements f, DialogInterface.OnClickListener {
        public androidx.appcompat.app.e b;
        public c c;
        public CharSequence d;

        public b() {
        }

        @Override // e6.f
        public final boolean a() {
            androidx.appcompat.app.e eVar = this.b;
            if (eVar != null) {
                return eVar.isShowing();
            }
            return false;
        }

        @Override // e6.f
        public final int b() {
            return 0;
        }

        @Override // e6.f
        public final void d(int i) {
        }

        @Override // e6.f
        public final void dismiss() {
            androidx.appcompat.app.e eVar = this.b;
            if (eVar != null) {
                eVar.dismiss();
                this.b = null;
            }
        }

        @Override // e6.f
        public final CharSequence e() {
            return this.d;
        }

        @Override // e6.f
        public final Drawable f() {
            return null;
        }

        @Override // e6.f
        public final void g(CharSequence charSequence) {
            this.d = charSequence;
        }

        @Override // e6.f
        public final void h(int i) {
        }

        @Override // e6.f
        public final void i(int i) {
        }

        @Override // e6.f
        public final void j(int i, int i2) {
            if (this.c == null) {
                return;
            }
            e6 e6Var = e6.this;
            androidx.appcompat.app.e.a aVar = new androidx.appcompat.app.e.a(e6Var.c);
            CharSequence charSequence = this.d;
            AlertController.b bVar = aVar.P;
            if (charSequence != null) {
                bVar.e = charSequence;
            }
            c cVar = this.c;
            int selectedItemPosition = e6Var.getSelectedItemPosition();
            bVar.v = cVar;
            bVar.w = this;
            bVar.H = selectedItemPosition;
            bVar.G = true;
            androidx.appcompat.app.e eVarCreate = aVar.create();
            this.b = eVarCreate;
            AlertController.RecycleListView recycleListView = eVarCreate.b.g;
            recycleListView.setTextDirection(i);
            recycleListView.setTextAlignment(i2);
            this.b.show();
        }

        @Override // e6.f
        public final int k() {
            return 0;
        }

        @Override // e6.f
        public final void l(ListAdapter listAdapter) {
            this.c = (c) listAdapter;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            e6 e6Var = e6.this;
            e6Var.setSelection(i);
            if (e6Var.getOnItemClickListener() != null) {
                e6Var.performItemClick(null, i, this.c.getItemId(i));
            }
            dismiss();
        }

        @Override // e6.f
        public final void setBackgroundDrawable(Drawable drawable) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c implements ListAdapter, SpinnerAdapter {
        public final SpinnerAdapter b;
        public final ListAdapter c;

        public c(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.b = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.c = (ListAdapter) spinnerAdapter;
            }
            if (theme == null || !(spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                return;
            }
            ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
            if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }

        @Override // android.widget.ListAdapter
        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.c;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public final int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public final boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.b;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public final boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public final boolean isEnabled(int i) {
            ListAdapter listAdapter = this.c;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d extends se0 implements f {
        public CharSequence I;
        public c J;
        public final Rect K;
        public int L;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class a implements AdapterView.OnItemClickListener {
            public a() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                d dVar = d.this;
                e6 e6Var = e6.this;
                e6Var.setSelection(i);
                if (e6Var.getOnItemClickListener() != null) {
                    e6Var.performItemClick(view, i, dVar.J.getItemId(i));
                }
                dVar.dismiss();
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class c implements PopupWindow.OnDismissListener {
            public final /* synthetic */ a b;

            public c(a aVar) {
                this.b = aVar;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                ViewTreeObserver viewTreeObserver = e6.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.b);
                }
            }
        }

        public d(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i, 0);
            this.K = new Rect();
            this.u = e6.this;
            this.D = true;
            this.E.setFocusable(true);
            this.v = new a();
        }

        @Override // e6.f
        public final CharSequence e() {
            return this.I;
        }

        @Override // e6.f
        public final void g(CharSequence charSequence) {
            this.I = charSequence;
        }

        @Override // e6.f
        public final void i(int i) {
            this.L = i;
        }

        @Override // e6.f
        public final void j(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            v5 v5Var = this.E;
            boolean zIsShowing = v5Var.isShowing();
            q();
            v5Var.setInputMethodMode(2);
            show();
            jp jpVar = this.d;
            int i3 = 1;
            jpVar.setChoiceMode(1);
            jpVar.setTextDirection(i);
            jpVar.setTextAlignment(i2);
            e6 e6Var = e6.this;
            int selectedItemPosition = e6Var.getSelectedItemPosition();
            jp jpVar2 = this.d;
            if (v5Var.isShowing() && jpVar2 != null) {
                jpVar2.o = false;
                jpVar2.setSelection(selectedItemPosition);
                if (jpVar2.getChoiceMode() != 0) {
                    jpVar2.setItemChecked(selectedItemPosition, true);
                }
            }
            if (zIsShowing || (viewTreeObserver = e6Var.getViewTreeObserver()) == null) {
                return;
            }
            a aVar = new a(i3, this);
            viewTreeObserver.addOnGlobalLayoutListener(aVar);
            v5Var.setOnDismissListener(new c(aVar));
        }

        @Override // defpackage.se0, e6.f
        public final void l(ListAdapter listAdapter) {
            super.l(listAdapter);
            this.J = (c) listAdapter;
        }

        public final void q() {
            int i;
            v5 v5Var = this.E;
            Drawable background = v5Var.getBackground();
            e6 e6Var = e6.this;
            Rect rect = e6Var.n;
            if (background != null) {
                background.getPadding(rect);
                i = ue1.a(e6Var) ? rect.right : -rect.left;
            } else {
                i = 0;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = e6Var.getPaddingLeft();
            int paddingRight = e6Var.getPaddingRight();
            int width = e6Var.getWidth();
            int iMax = e6Var.j;
            if (iMax == -2) {
                int iA = e6Var.a(this.J, v5Var.getBackground());
                int i2 = (e6Var.getContext().getResources().getDisplayMetrics().widthPixels - rect.left) - rect.right;
                if (iA > i2) {
                    iA = i2;
                }
                iMax = Math.max(iA, (width - paddingLeft) - paddingRight);
            } else if (iMax == -1) {
                iMax = (width - paddingLeft) - paddingRight;
            }
            p(iMax);
            this.i = ue1.a(e6Var) ? (((width - paddingRight) - this.g) - this.L) + i : paddingLeft + this.L + i;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new f8.a(1);
        public boolean b;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface f {
        boolean a();

        int b();

        void d(int i);

        void dismiss();

        CharSequence e();

        Drawable f();

        void g(CharSequence charSequence);

        void h(int i);

        void i(int i);

        void j(int i, int i2);

        int k();

        void l(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x005a  */
    /* JADX WARN: Code duplicated, block: B:26:0x008d  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ba  */
    public e6(Context context, AttributeSet attributeSet, int i) throws Throwable {
        TypedArray typedArrayObtainStyledAttributes;
        CharSequence[] textArray;
        SpinnerAdapter spinnerAdapter;
        super(context, attributeSet, i);
        this.n = new Rect();
        j61.a(this, getContext());
        int[] iArr = b2.w;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        this.b = new y4(this);
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(4, 0);
        if (resourceId != 0) {
            this.c = new yh(context, resourceId);
        } else {
            this.c = context;
        }
        int i2 = -1;
        TypedArray typedArray = null;
        try {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o, i, 0);
            try {
                if (typedArrayObtainStyledAttributes.hasValue(0)) {
                    i2 = typedArrayObtainStyledAttributes.getInt(0, 0);
                }
            } catch (Exception unused) {
                if (typedArrayObtainStyledAttributes != null) {
                }
                if (i2 != 0) {
                    b bVar = new b();
                    this.i = bVar;
                    bVar.d = typedArrayObtainStyledAttributes2.getString(2);
                } else if (i2 == 1) {
                    d dVar = new d(this.c, attributeSet, i);
                    m6 m6VarM = m6.m(this.c, attributeSet, iArr, i);
                    this.j = ((TypedArray) m6VarM.a).getLayoutDimension(3, -2);
                    dVar.setBackgroundDrawable(m6VarM.e(1));
                    dVar.I = typedArrayObtainStyledAttributes2.getString(2);
                    m6VarM.n();
                    this.i = dVar;
                    this.d = new d6(this, this, dVar);
                }
                textArray = typedArrayObtainStyledAttributes2.getTextArray(0);
                if (textArray != null) {
                    ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, textArray);
                    arrayAdapter.setDropDownViewResource(org.hamotunnelplus.xyz.R.layout.fk);
                    setAdapter((SpinnerAdapter) arrayAdapter);
                }
                typedArrayObtainStyledAttributes2.recycle();
                this.g = true;
                spinnerAdapter = this.f;
                if (spinnerAdapter != null) {
                    setAdapter(spinnerAdapter);
                    this.f = null;
                }
                this.b.d(attributeSet, i);
            } catch (Throwable th) {
                th = th;
                typedArray = typedArrayObtainStyledAttributes;
                if (typedArray != null) {
                    typedArray.recycle();
                }
                throw th;
            }
        } catch (Exception unused2) {
            typedArrayObtainStyledAttributes = null;
        } catch (Throwable th2) {
            th = th2;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (i2 != 0) {
            b bVar2 = new b();
            this.i = bVar2;
            bVar2.d = typedArrayObtainStyledAttributes2.getString(2);
        } else if (i2 == 1) {
            d dVar2 = new d(this.c, attributeSet, i);
            m6 m6VarM2 = m6.m(this.c, attributeSet, iArr, i);
            this.j = ((TypedArray) m6VarM2.a).getLayoutDimension(3, -2);
            dVar2.setBackgroundDrawable(m6VarM2.e(1));
            dVar2.I = typedArrayObtainStyledAttributes2.getString(2);
            m6VarM2.n();
            this.i = dVar2;
            this.d = new d6(this, this, dVar2);
        }
        textArray = typedArrayObtainStyledAttributes2.getTextArray(0);
        if (textArray != null) {
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, R.layout.simple_spinner_item, textArray);
            arrayAdapter2.setDropDownViewResource(org.hamotunnelplus.xyz.R.layout.fk);
            setAdapter((SpinnerAdapter) arrayAdapter2);
        }
        typedArrayObtainStyledAttributes2.recycle();
        this.g = true;
        spinnerAdapter = this.f;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.f = null;
        }
        this.b.d(attributeSet, i);
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        Rect rect = this.n;
        drawable.getPadding(rect);
        return rect.left + rect.right + iMax2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        y4 y4Var = this.b;
        if (y4Var != null) {
            y4Var.a();
        }
    }

    @Override // android.widget.Spinner
    public final int getDropDownHorizontalOffset() {
        f fVar = this.i;
        return fVar != null ? fVar.b() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public final int getDropDownVerticalOffset() {
        f fVar = this.i;
        return fVar != null ? fVar.k() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public final int getDropDownWidth() {
        return this.i != null ? this.j : super.getDropDownWidth();
    }

    @Override // android.widget.Spinner
    public final Drawable getPopupBackground() {
        f fVar = this.i;
        return fVar != null ? fVar.f() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public final Context getPopupContext() {
        return this.c;
    }

    @Override // android.widget.Spinner
    public final CharSequence getPrompt() {
        f fVar = this.i;
        return fVar != null ? fVar.e() : super.getPrompt();
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.i;
        if (fVar == null || !fVar.a()) {
            return;
        }
        fVar.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.i == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        if (!eVar.b || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new a(0, this));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        f fVar = this.i;
        eVar.b = fVar != null && fVar.a();
        return eVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        d6 d6Var = this.d;
        if (d6Var == null || !d6Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        f fVar = this.i;
        if (fVar == null) {
            return super.performClick();
        }
        if (fVar.a()) {
            return true;
        }
        fVar.j(getTextDirection(), getTextAlignment());
        return true;
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.g) {
            this.f = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        f fVar = this.i;
        if (fVar != null) {
            Context context = this.c;
            if (context == null) {
                context = getContext();
            }
            fVar.l(new c(spinnerAdapter, context.getTheme()));
        }
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        y4 y4Var = this.b;
        if (y4Var != null) {
            y4Var.e();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        y4 y4Var = this.b;
        if (y4Var != null) {
            y4Var.f(i);
        }
    }

    @Override // android.widget.Spinner
    public final void setDropDownHorizontalOffset(int i) {
        f fVar = this.i;
        if (fVar == null) {
            super.setDropDownHorizontalOffset(i);
        } else {
            fVar.i(i);
            fVar.d(i);
        }
    }

    @Override // android.widget.Spinner
    public final void setDropDownVerticalOffset(int i) {
        f fVar = this.i;
        if (fVar != null) {
            fVar.h(i);
        } else {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public final void setDropDownWidth(int i) {
        if (this.i != null) {
            this.j = i;
        } else {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public final void setPopupBackgroundDrawable(Drawable drawable) {
        f fVar = this.i;
        if (fVar != null) {
            fVar.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public final void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(defpackage.e.s(this.c, i));
    }

    @Override // android.widget.Spinner
    public final void setPrompt(CharSequence charSequence) {
        f fVar = this.i;
        if (fVar != null) {
            fVar.g(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }
}
