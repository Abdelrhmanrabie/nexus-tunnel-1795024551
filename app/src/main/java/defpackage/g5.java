package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import com.trilead.ssh2.sftp.AttribFlags;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class g5 implements w1$a, j.a, lm0, ContentFrameLayout.a {
    public final /* synthetic */ int G0;
    public final /* synthetic */ f5 a;

    public /* synthetic */ g5(f5 f5Var, int i) {
        this.G0 = i;
        this.a = f5Var;
    }

    @Override // defpackage.w1$a
    public Context a() {
        return this.a.M();
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean a(f fVar) {
        Window.Callback callback;
        if (this.G0 == 2) {
            Window.Callback callback2 = this.a.i.getCallback();
            if (callback2 != null) {
                callback2.onMenuOpened(108, fVar);
            }
        } else if (fVar == fVar.getRootMenu()) {
            f5 f5Var = this.a;
            if (f5Var.G && (callback = f5Var.i.getCallback()) != null && !f5Var.R) {
                callback.onMenuOpened(108, fVar);
                return true;
            }
        }
        return true;
    }

    @Override // defpackage.w1$a
    public void b(hp hpVar, int i) {
        f5 f5Var = this.a;
        f5Var.Q();
        t1 t1Var = f5Var.o;
        if (t1Var != null) {
            t1Var.p(hpVar);
            t1Var.o(i);
        }
    }

    @Override // defpackage.w1$a
    /* JADX INFO: renamed from: c */
    public boolean mo14c() {
        f5 f5Var = this.a;
        f5Var.Q();
        t1 t1Var = f5Var.o;
        return (t1Var == null || (t1Var.d() & 4) == 0) ? false : true;
    }

    @Override // defpackage.w1$a
    public Drawable d() {
        int resourceId;
        Context contextM = this.a.M();
        TypedArray typedArrayObtainStyledAttributes = contextM.obtainStyledAttributes((AttributeSet) null, new int[]{R.style.nt});
        Drawable drawable = (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : e.s(contextM, resourceId);
        typedArrayObtainStyledAttributes.recycle();
        return drawable;
    }

    @Override // defpackage.w1$a
    /* JADX INFO: renamed from: e */
    public void mo16e(int i) {
        f5 f5Var = this.a;
        f5Var.Q();
        t1 t1Var = f5Var.o;
        if (t1Var != null) {
            t1Var.o(i);
        }
    }

    @Override // defpackage.lm0
    public fg1 onApplyWindowInsets(View view, fg1 fg1Var) {
        boolean z;
        ak cVar;
        boolean z2;
        boolean z3;
        fg1 fg1VarB = fg1Var;
        int iD = fg1VarB.d();
        int iD2 = fg1VarB.d();
        f5 f5Var = this.a;
        ActionBarContextView actionBarContextView = f5Var.v;
        boolean z4 = false;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) f5Var.v.getLayoutParams();
            if (f5Var.v.isShown()) {
                if (f5Var.d0 == null) {
                    f5Var.d0 = new Rect();
                    f5Var.e0 = new Rect();
                }
                Rect rect = f5Var.d0;
                Rect rect2 = f5Var.e0;
                rect.set(fg1VarB.b(), fg1VarB.d(), fg1VarB.c(), fg1VarB.a());
                ViewGroup viewGroup = f5Var.B;
                Method method = ue1.a;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, rect, rect2);
                    } catch (Exception unused) {
                    }
                }
                int i = rect.top;
                int i2 = rect.left;
                int i3 = rect.right;
                ViewGroup viewGroup2 = f5Var.B;
                WeakHashMap weakHashMap = qd1.a;
                WindowInsets rootWindowInsets = viewGroup2.getRootWindowInsets();
                fg1 fg1VarG = null;
                if (rootWindowInsets != null) {
                    fg1VarG = fg1.g(null, rootWindowInsets);
                    fg1.k kVar = fg1VarG.a;
                    kVar.p(fg1VarG);
                    kVar.d(viewGroup2.getRootView());
                }
                int iB = fg1VarG == null ? 0 : fg1VarG.b();
                int iC = fg1VarG == null ? 0 : fg1VarG.c();
                if (marginLayoutParams.topMargin == i && marginLayoutParams.leftMargin == i2 && marginLayoutParams.rightMargin == i3) {
                    z3 = false;
                } else {
                    marginLayoutParams.topMargin = i;
                    marginLayoutParams.leftMargin = i2;
                    marginLayoutParams.rightMargin = i3;
                    z3 = true;
                }
                Context context = f5Var.g;
                if (i <= 0 || f5Var.D != null) {
                    View view2 = f5Var.D;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i4 = marginLayoutParams2.height;
                        int i5 = marginLayoutParams.topMargin;
                        if (i4 != i5 || marginLayoutParams2.leftMargin != iB || marginLayoutParams2.rightMargin != iC) {
                            marginLayoutParams2.height = i5;
                            marginLayoutParams2.leftMargin = iB;
                            marginLayoutParams2.rightMargin = iC;
                            f5Var.D.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(context);
                    f5Var.D = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iB;
                    layoutParams.rightMargin = iC;
                    f5Var.B.addView(f5Var.D, -1, layoutParams);
                }
                View view4 = f5Var.D;
                boolean z5 = view4 != null;
                if (z5 && view4.getVisibility() != 0) {
                    View view5 = f5Var.D;
                    view5.setBackgroundColor(context.getColor((view5.getWindowSystemUiVisibility() & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0 ? R.color.g : R.color.f));
                }
                if (!f5Var.I && z5) {
                    iD2 = 0;
                }
                z = z5;
                z2 = z3;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            if (z2) {
                f5Var.v.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = f5Var.D;
        if (view6 != null) {
            view6.setVisibility(z ? 0 : 8);
        }
        if (iD != iD2) {
            int iB2 = fg1VarB.b();
            int iC2 = fg1VarB.c();
            int iA = fg1VarB.a();
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 30) {
                cVar = new fg1.d(fg1VarB);
            } else if (i6 >= 29) {
                cVar = new fg1.c(fg1VarB);
            } else {
                fg1.b bVar = new fg1.b(z4);
                bVar.a = fg1VarB.f();
                cVar = bVar;
            }
            cVar.d(t20.a(iB2, iD2, iC2, iA));
            fg1VarB = cVar.b();
        }
        WeakHashMap weakHashMap2 = qd1.a;
        WindowInsets windowInsetsF = fg1VarB.f();
        if (windowInsetsF == null) {
            return fg1VarB;
        }
        WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsF);
        return !windowInsetsOnApplyWindowInsets.equals(windowInsetsF) ? fg1.g(view, windowInsetsOnApplyWindowInsets) : fg1VarB;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void onCloseMenu(f fVar, boolean z) {
        f5.k kVar;
        if (this.G0 == 2) {
            this.a.F(fVar);
            return;
        }
        f rootMenu = fVar.getRootMenu();
        int i = 0;
        boolean z2 = rootMenu != fVar;
        if (z2) {
            fVar = rootMenu;
        }
        f5 f5Var = this.a;
        f5.k[] kVarArr = f5Var.M;
        int length = kVarArr != null ? kVarArr.length : 0;
        while (true) {
            if (i < length) {
                kVar = kVarArr[i];
                if (kVar != null && kVar.h == fVar) {
                    break;
                } else {
                    i++;
                }
            } else {
                kVar = null;
                break;
            }
        }
        if (kVar != null) {
            if (!z2) {
                f5Var.G(kVar, z);
            } else {
                f5Var.E(kVar.a, kVar, rootMenu);
                f5Var.G(kVar, true);
            }
        }
    }
}
