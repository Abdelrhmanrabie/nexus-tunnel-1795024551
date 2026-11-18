package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.trilead.ssh2.sftp.AttribFlags;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class se0 implements b01 {
    public static final Method F;
    public static final Method G;
    public static final Method H;
    public final Handler A;
    public Rect C;
    public boolean D;
    public final v5 E;
    public final Context b;
    public ListAdapter c;
    public jp d;
    public int i;
    public int j;
    public boolean o;
    public boolean p;
    public boolean q;
    public b t;
    public View u;
    public AdapterView.OnItemClickListener v;
    public int g = -2;
    public int r = 0;
    public final a w = new a(this, 1);
    public final d x = new d();
    public final c y = new c();
    public final a z = new a(this, 0);
    public final Rect B = new Rect();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Runnable {
        public final /* synthetic */ int G0;
        public final /* synthetic */ se0 b;

        public /* synthetic */ a(se0 se0Var, int i) {
            this.G0 = i;
            this.b = se0Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.G0;
            se0 se0Var = this.b;
            if (i == 0) {
                jp jpVar = se0Var.d;
                if (jpVar != null) {
                    jpVar.o = true;
                    jpVar.requestLayout();
                    return;
                }
                return;
            }
            jp jpVar2 = se0Var.d;
            if (jpVar2 != null) {
                WeakHashMap weakHashMap = qd1.a;
                if (!jpVar2.isAttachedToWindow() || se0Var.d.getCount() <= se0Var.d.getChildCount() || se0Var.d.getChildCount() > Integer.MAX_VALUE) {
                    return;
                }
                se0Var.E.setInputMethodMode(2);
                se0Var.show();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            se0 se0Var = se0.this;
            if (se0Var.E.isShowing()) {
                se0Var.show();
            }
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            se0.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c implements AbsListView.OnScrollListener {
        public c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                se0 se0Var = se0.this;
                v5 v5Var = se0Var.E;
                if (v5Var.getInputMethodMode() == 2 || v5Var.getContentView() == null) {
                    return;
                }
                Handler handler = se0Var.A;
                a aVar = se0Var.w;
                handler.removeCallbacks(aVar);
                aVar.run();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            se0 se0Var = se0.this;
            a aVar = se0Var.w;
            Handler handler = se0Var.A;
            v5 v5Var = se0Var.E;
            if (action == 0 && v5Var != null && v5Var.isShowing() && x >= 0 && x < v5Var.getWidth() && y >= 0 && y < v5Var.getHeight()) {
                handler.postDelayed(aVar, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            handler.removeCallbacks(aVar);
            return false;
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                F = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            try {
                H = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                G = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public se0(Context context, AttributeSet attributeSet, int i, int i2) {
        int resourceId;
        this.b = context;
        this.A = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b2.p, i, i2);
        this.i = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.j = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.o = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        v5 v5Var = new v5(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b2.t, i, i2);
        if (typedArrayObtainStyledAttributes2.hasValue(2)) {
            v5Var.setOverlapAnchor(typedArrayObtainStyledAttributes2.getBoolean(2, false));
        }
        v5Var.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : e.s(context, resourceId));
        typedArrayObtainStyledAttributes2.recycle();
        this.E = v5Var;
        v5Var.setInputMethodMode(1);
    }

    @Override // defpackage.b01
    public final boolean a() {
        return this.E.isShowing();
    }

    public final int b() {
        return this.i;
    }

    public final void d(int i) {
        this.i = i;
    }

    @Override // defpackage.b01
    public final void dismiss() {
        v5 v5Var = this.E;
        v5Var.dismiss();
        v5Var.setContentView(null);
        this.d = null;
        this.A.removeCallbacks(this.w);
    }

    public final Drawable f() {
        return this.E.getBackground();
    }

    public final void h(int i) {
        this.j = i;
        this.o = true;
    }

    public final int k() {
        if (this.o) {
            return this.j;
        }
        return 0;
    }

    public void l(ListAdapter listAdapter) {
        b bVar = this.t;
        if (bVar == null) {
            this.t = new b();
        } else {
            ListAdapter listAdapter2 = this.c;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(bVar);
            }
        }
        this.c = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.t);
        }
        jp jpVar = this.d;
        if (jpVar != null) {
            jpVar.setAdapter(this.c);
        }
    }

    @Override // defpackage.b01
    public final jp n() {
        return this.d;
    }

    public jp o(Context context, boolean z) {
        return new jp(context, z);
    }

    public final void p(int i) {
        Drawable background = this.E.getBackground();
        if (background == null) {
            this.g = i;
            return;
        }
        Rect rect = this.B;
        background.getPadding(rect);
        this.g = rect.left + rect.right + i;
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.E.setBackgroundDrawable(drawable);
    }

    @Override // defpackage.b01
    public final void show() {
        int i;
        int maxAvailableHeight;
        int iMakeMeasureSpec;
        jp jpVar;
        jp jpVar2 = this.d;
        v5 v5Var = this.E;
        Context context = this.b;
        if (jpVar2 == null) {
            jp jpVarO = o(context, !this.D);
            this.d = jpVarO;
            jpVarO.setAdapter(this.c);
            this.d.setOnItemClickListener(this.v);
            this.d.setFocusable(true);
            this.d.setFocusableInTouchMode(true);
            this.d.setOnItemSelectedListener(new re0(this));
            this.d.setOnScrollListener(this.y);
            v5Var.setContentView(this.d);
        }
        Drawable background = v5Var.getBackground();
        Rect rect = this.B;
        if (background != null) {
            background.getPadding(rect);
            int i2 = rect.top;
            i = rect.bottom + i2;
            if (!this.o) {
                this.j = -i2;
            }
        } else {
            rect.setEmpty();
            i = 0;
        }
        boolean z = v5Var.getInputMethodMode() == 2;
        View view = this.u;
        int i3 = this.j;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = G;
            if (method != null) {
                try {
                    maxAvailableHeight = ((Integer) method.invoke(v5Var, view, Integer.valueOf(i3), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                    maxAvailableHeight = v5Var.getMaxAvailableHeight(view, i3);
                }
            } else {
                maxAvailableHeight = v5Var.getMaxAvailableHeight(view, i3);
            }
        } else {
            maxAvailableHeight = v5Var.getMaxAvailableHeight(view, i3, z);
        }
        int i4 = this.g;
        if (i4 != -2) {
            iMakeMeasureSpec = i4 != -1 ? View.MeasureSpec.makeMeasureSpec(i4, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
        }
        int iA = this.d.a(iMakeMeasureSpec, maxAvailableHeight);
        int paddingBottom = iA + (iA > 0 ? this.d.getPaddingBottom() + this.d.getPaddingTop() + i : 0);
        v5Var.getInputMethodMode();
        v5Var.setWindowLayoutType(1002);
        if (v5Var.isShowing()) {
            View view2 = this.u;
            WeakHashMap weakHashMap = qd1.a;
            if (view2.isAttachedToWindow()) {
                int width = this.g;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.u.getWidth();
                }
                v5Var.setOutsideTouchable(true);
                int i5 = width;
                View view3 = this.u;
                int i6 = this.i;
                int i7 = i5;
                int i8 = this.j;
                if (i7 < 0) {
                    i7 = -1;
                }
                v5Var.update(view3, i6, i8, i7, paddingBottom < 0 ? -1 : paddingBottom);
                return;
            }
            return;
        }
        int width2 = this.g;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.u.getWidth();
        }
        v5Var.setWidth(width2);
        v5Var.setHeight(paddingBottom);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = F;
            if (method2 != null) {
                try {
                    method2.invoke(v5Var, Boolean.TRUE);
                } catch (Exception unused2) {
                }
            }
        } else {
            v5Var.setIsClippedToScreen(true);
        }
        v5Var.setOutsideTouchable(true);
        v5Var.setTouchInterceptor(this.x);
        if (this.q) {
            v5Var.setOverlapAnchor(this.p);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method3 = H;
            if (method3 != null) {
                try {
                    method3.invoke(v5Var, this.C);
                } catch (Exception unused3) {
                }
            }
        } else {
            v5Var.setEpicenterBounds(this.C);
        }
        v5Var.showAsDropDown(this.u, this.i, this.j, this.r);
        this.d.setSelection(-1);
        if ((!this.D || this.d.isInTouchMode()) && (jpVar = this.d) != null) {
            jpVar.o = true;
            jpVar.requestLayout();
        }
        if (this.D) {
            return;
        }
        this.A.post(this.z);
    }
}
