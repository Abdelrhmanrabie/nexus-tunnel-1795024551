package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.view.menu.g;
import androidx.core.widget.NestedScrollView;
import defpackage.qd1;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class e extends f implements DialogInterface {
    public final AlertController b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a {
        public final AlertController.b P;
        public final int mTheme;

        public a(Context context) {
            this(context, e.a(context, 0));
        }

        public a(Context context, int i) {
            this.P = new AlertController.b(new ContextThemeWrapper(context, e.a(context, i)));
            this.mTheme = i;
        }

        /* JADX WARN: Code duplicated, block: B:52:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:53:0x00b7  */
        /* JADX WARN: Code duplicated, block: B:55:0x00bb  */
        public e create() {
            ListAdapter aVar;
            AdapterView.OnItemClickListener dVar;
            AlertController.b bVar = this.P;
            e eVar = new e(bVar.a, this.mTheme);
            View view = bVar.f;
            ContextThemeWrapper contextThemeWrapper = bVar.a;
            AlertController alertController = eVar.b;
            if (view != null) {
                alertController.G = view;
            } else {
                CharSequence charSequence = bVar.e;
                if (charSequence != null) {
                    alertController.e = charSequence;
                    TextView textView = alertController.E;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = bVar.d;
                if (drawable != null) {
                    alertController.C = drawable;
                    ImageView imageView = alertController.D;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        alertController.D.setImageDrawable(drawable);
                    }
                }
            }
            CharSequence charSequence2 = bVar.g;
            if (charSequence2 != null) {
                alertController.f = charSequence2;
                TextView textView2 = alertController.F;
                if (textView2 != null) {
                    textView2.setText(charSequence2);
                }
            }
            CharSequence charSequence3 = bVar.h;
            if (charSequence3 != null) {
                alertController.c(-1, charSequence3, bVar.j);
            }
            CharSequence charSequence4 = bVar.k;
            if (charSequence4 != null) {
                alertController.c(-2, charSequence4, bVar.m);
            }
            if (bVar.u != null || bVar.v != null) {
                AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) bVar.b.inflate(alertController.K, (ViewGroup) null);
                if (bVar.F) {
                    aVar = new androidx.appcompat.app.a(bVar, contextThemeWrapper, alertController.L, bVar.u, recycleListView);
                } else {
                    int i = bVar.G ? alertController.M : alertController.N;
                    ListAdapter dVar2 = bVar.v;
                    if (dVar2 == null) {
                        dVar2 = new AlertController.d(contextThemeWrapper, i, bVar.u);
                    }
                    aVar = dVar2;
                }
                alertController.H = aVar;
                alertController.I = bVar.H;
                if (bVar.w != null) {
                    dVar = new c(bVar, alertController);
                } else {
                    if (bVar.I != null) {
                        dVar = new d(bVar, recycleListView, alertController);
                    }
                    if (bVar.G) {
                        recycleListView.setChoiceMode(1);
                    } else if (bVar.F) {
                        recycleListView.setChoiceMode(2);
                    }
                    alertController.g = recycleListView;
                }
                recycleListView.setOnItemClickListener(dVar);
                if (bVar.G) {
                    recycleListView.setChoiceMode(1);
                } else if (bVar.F) {
                    recycleListView.setChoiceMode(2);
                }
                alertController.g = recycleListView;
            }
            View view2 = bVar.y;
            if (view2 != null) {
                if (bVar.D) {
                    int i2 = bVar.z;
                    int i3 = bVar.B;
                    alertController.h = view2;
                    alertController.n = true;
                    alertController.j = i2;
                    alertController.l = i3;
                } else {
                    alertController.h = view2;
                    alertController.n = false;
                }
            }
            eVar.setCancelable(bVar.q);
            if (bVar.q) {
                eVar.setCanceledOnTouchOutside(true);
            }
            eVar.setOnCancelListener(bVar.r);
            eVar.setOnDismissListener(null);
            g gVar = bVar.t;
            if (gVar != null) {
                eVar.setOnKeyListener(gVar);
            }
            return eVar;
        }

        public void setCancelable() {
            this.P.q = false;
        }

        public a setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.P;
            bVar.k = bVar.a.getText(i);
            bVar.m = onClickListener;
            return this;
        }

        public a setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.P;
            bVar.h = bVar.a.getText(i);
            bVar.j = onClickListener;
            return this;
        }

        public void setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.P;
            bVar.h = charSequence;
            bVar.j = onClickListener;
        }

        public a setTitle(int i) {
            AlertController.b bVar = this.P;
            bVar.e = bVar.a.getText(i);
            return this;
        }

        public final void show() {
            create().show();
        }
    }

    public e(Context context, int i) {
        super(context, a(context, i));
        this.b = new AlertController(getContext(), this, getWindow());
    }

    public static int a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.style.as, typedValue, true);
        return typedValue.resourceId;
    }

    public final void b(View view) {
        AlertController alertController = this.b;
        alertController.h = view;
        alertController.n = false;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x026c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0275 A[PHI: r4
      0x0275: PHI (r4v5 android.view.View) = (r4v4 android.view.View), (r4v11 android.view.View) binds: [B:102:0x0273, B:99:0x0269] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:110:0x0286  */
    /* JADX WARN: Code duplicated, block: B:111:0x028b  */
    /* JADX WARN: Code duplicated, block: B:114:0x0293  */
    /* JADX WARN: Code duplicated, block: B:115:0x0298  */
    /* JADX WARN: Code duplicated, block: B:118:0x029f  */
    /* JADX WARN: Code duplicated, block: B:121:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:123:0x02a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:124:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:127:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:129:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:73:0x0228  */
    /* JADX WARN: Code duplicated, block: B:74:0x022a  */
    /* JADX WARN: Code duplicated, block: B:79:0x0235  */
    /* JADX WARN: Code duplicated, block: B:82:0x023c  */
    /* JADX WARN: Code duplicated, block: B:83:0x023e  */
    /* JADX WARN: Code duplicated, block: B:89:0x024f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0253  */
    /* JADX WARN: Code duplicated, block: B:98:0x0262  */
    @Override // androidx.appcompat.app.f, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int i;
        View viewFindViewById;
        boolean z;
        int i2;
        boolean z2;
        View viewFindViewById2;
        AlertController.RecycleListView recycleListView;
        AlertController.RecycleListView recycleListView2;
        ListAdapter listAdapter;
        View view;
        View viewFindViewById3;
        View viewFindViewById4;
        int paddingTop;
        int paddingBottom;
        NestedScrollView nestedScrollView;
        View viewFindViewById5;
        Button button;
        super.onCreate(bundle);
        AlertController alertController = this.b;
        alertController.b.setContentView(alertController.J);
        Window window = alertController.c;
        View viewFindViewById6 = window.findViewById(R.attr.tq);
        View viewFindViewById7 = viewFindViewById6.findViewById(R.attr.a1u);
        View viewFindViewById8 = viewFindViewById6.findViewById(R.attr.fz);
        View viewFindViewById9 = viewFindViewById6.findViewById(R.attr.e1);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById6.findViewById(R.attr.gq);
        View view2 = alertController.h;
        Context context = alertController.a;
        if (view2 == null) {
            view2 = null;
        }
        boolean z3 = view2 != null;
        if (!z3 || !AlertController.a(view2)) {
            window.setFlags(131072, 131072);
        }
        if (z3) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.attr.gp);
            frameLayout.addView(view2, new ViewGroup.LayoutParams(-1, -1));
            if (alertController.n) {
                frameLayout.setPadding(alertController.j, 0, alertController.l, 0);
            }
            if (alertController.g != null) {
                ((LinearLayout.LayoutParams) ((androidx.appcompat.widget.b.a) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View viewFindViewById10 = viewGroup.findViewById(R.attr.a1u);
        View viewFindViewById11 = viewGroup.findViewById(R.attr.fz);
        View viewFindViewById12 = viewGroup.findViewById(R.attr.e1);
        ViewGroup viewGroupB = AlertController.b(viewFindViewById10, viewFindViewById7);
        ViewGroup viewGroupB2 = AlertController.b(viewFindViewById11, viewFindViewById8);
        ViewGroup viewGroupB3 = AlertController.b(viewFindViewById12, viewFindViewById9);
        NestedScrollView nestedScrollView2 = (NestedScrollView) window.findViewById(R.attr.w9);
        alertController.A = nestedScrollView2;
        nestedScrollView2.setFocusable(false);
        alertController.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupB2.findViewById(android.R.id.message);
        alertController.F = textView;
        if (textView != null) {
            CharSequence charSequence = alertController.f;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                alertController.A.removeView(alertController.F);
                if (alertController.g != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.A.getParent();
                    int iIndexOfChild = viewGroup2.indexOfChild(alertController.A);
                    viewGroup2.removeViewAt(iIndexOfChild);
                    viewGroup2.addView(alertController.g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroupB2.setVisibility(8);
                }
            }
        }
        Button button2 = (Button) viewGroupB3.findViewById(android.R.id.button1);
        alertController.o = button2;
        AlertController.a aVar = alertController.Q;
        button2.setOnClickListener(aVar);
        boolean zIsEmpty = TextUtils.isEmpty(alertController.p);
        Button button3 = alertController.o;
        if (zIsEmpty) {
            button3.setVisibility(8);
            i = 0;
        } else {
            button3.setText(alertController.p);
            alertController.o.setVisibility(0);
            i = 1;
        }
        Button button4 = (Button) viewGroupB3.findViewById(android.R.id.button2);
        alertController.s = button4;
        button4.setOnClickListener(aVar);
        boolean zIsEmpty2 = TextUtils.isEmpty(alertController.t);
        Button button5 = alertController.s;
        if (zIsEmpty2) {
            button5.setVisibility(8);
        } else {
            button5.setText(alertController.t);
            alertController.s.setVisibility(0);
            i |= 2;
        }
        Button button6 = (Button) viewGroupB3.findViewById(android.R.id.button3);
        alertController.w = button6;
        button6.setOnClickListener(aVar);
        boolean zIsEmpty3 = TextUtils.isEmpty(alertController.x);
        Button button7 = alertController.w;
        if (zIsEmpty3) {
            button7.setVisibility(8);
        } else {
            button7.setText(alertController.x);
            alertController.w.setVisibility(0);
            i |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.style.aq, typedValue, true);
        if (typedValue.data != 0) {
            if (i == 1) {
                button = alertController.o;
            } else if (i == 2) {
                button = alertController.s;
            } else if (i == 4) {
                button = alertController.w;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.gravity = 1;
            layoutParams.weight = 0.5f;
            button.setLayoutParams(layoutParams);
        }
        if (i == 0) {
            viewGroupB3.setVisibility(8);
        }
        if (alertController.G == null) {
            alertController.D = (ImageView) window.findViewById(android.R.id.icon);
            if (TextUtils.isEmpty(alertController.e) || !alertController.O) {
                window.findViewById(R.attr.a1j).setVisibility(8);
                alertController.D.setVisibility(8);
                viewFindViewById = viewGroupB;
            } else {
                TextView textView2 = (TextView) window.findViewById(R.attr.ci);
                alertController.E = textView2;
                textView2.setText(alertController.e);
                Drawable drawable = alertController.C;
                if (drawable != null) {
                    alertController.D.setImageDrawable(drawable);
                } else {
                    alertController.E.setPadding(alertController.D.getPaddingLeft(), alertController.D.getPaddingTop(), alertController.D.getPaddingRight(), alertController.D.getPaddingBottom());
                    alertController.D.setVisibility(8);
                }
            }
            if (viewGroup.getVisibility() != 8) {
                z = true;
            } else {
                z = false;
            }
            if (viewGroupB != null || viewGroupB.getVisibility() == 8) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (viewGroupB3.getVisibility() != 8) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && (viewFindViewById5 = viewGroupB2.findViewById(R.attr.a0o)) != null) {
                viewFindViewById5.setVisibility(0);
            }
            if (i2 != 0) {
                nestedScrollView = alertController.A;
                if (nestedScrollView != null) {
                    nestedScrollView.setClipToPadding(true);
                }
                if (alertController.f == null || alertController.g != null) {
                    viewFindViewById2 = viewGroupB.findViewById(R.attr.a1h);
                } else {
                    viewFindViewById2 = null;
                }
                if (viewFindViewById2 != null) {
                    viewFindViewById2.setVisibility(0);
                }
            } else {
                viewFindViewById2 = viewGroupB2.findViewById(R.attr.a0p);
                if (viewFindViewById2 != null) {
                    viewFindViewById2.setVisibility(0);
                }
            }
            recycleListView = alertController.g;
            if (recycleListView != null && (!z2 || i2 == 0)) {
                int paddingLeft = recycleListView.getPaddingLeft();
                if (i2 != 0) {
                    paddingTop = recycleListView.getPaddingTop();
                } else {
                    paddingTop = recycleListView.b;
                }
                int paddingRight = recycleListView.getPaddingRight();
                if (z2) {
                    paddingBottom = recycleListView.getPaddingBottom();
                } else {
                    paddingBottom = recycleListView.c;
                }
                recycleListView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
            if (!z) {
                view = alertController.g;
                if (view == null) {
                    view = alertController.A;
                }
                if (view != null) {
                    int i3 = z2 ? 2 : 0;
                    viewFindViewById3 = window.findViewById(R.attr.w8);
                    viewFindViewById4 = window.findViewById(R.attr.w7);
                    WeakHashMap weakHashMap = qd1.a;
                    view.setScrollIndicators(i2 | i3, 3);
                    if (viewFindViewById3 != null) {
                        viewGroupB2.removeView(viewFindViewById3);
                    }
                    if (viewFindViewById4 != null) {
                        viewGroupB2.removeView(viewFindViewById4);
                    }
                }
            }
            recycleListView2 = alertController.g;
            if (recycleListView2 != null || (listAdapter = alertController.H) == null) {
            }
            recycleListView2.setAdapter(listAdapter);
            int i4 = alertController.I;
            if (i4 > -1) {
                recycleListView2.setItemChecked(i4, true);
                recycleListView2.setSelection(i4);
                return;
            }
            return;
        }
        viewGroupB.addView(alertController.G, 0, new ViewGroup.LayoutParams(-1, -2));
        viewFindViewById = window.findViewById(R.attr.a1j);
        viewFindViewById.setVisibility(8);
        if (viewGroup.getVisibility() != 8) {
            z = true;
        } else {
            z = false;
        }
        if (viewGroupB != null) {
            i2 = 0;
        } else {
            i2 = 0;
        }
        if (viewGroupB3.getVisibility() != 8) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            viewFindViewById5.setVisibility(0);
        }
        if (i2 != 0) {
            nestedScrollView = alertController.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            if (alertController.f == null) {
                viewFindViewById2 = viewGroupB.findViewById(R.attr.a1h);
            } else {
                viewFindViewById2 = viewGroupB.findViewById(R.attr.a1h);
            }
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(0);
            }
        } else {
            viewFindViewById2 = viewGroupB2.findViewById(R.attr.a0p);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(0);
            }
        }
        recycleListView = alertController.g;
        if (recycleListView != null) {
            int paddingLeft2 = recycleListView.getPaddingLeft();
            if (i2 != 0) {
                paddingTop = recycleListView.getPaddingTop();
            } else {
                paddingTop = recycleListView.b;
            }
            int paddingRight2 = recycleListView.getPaddingRight();
            if (z2) {
                paddingBottom = recycleListView.getPaddingBottom();
            } else {
                paddingBottom = recycleListView.c;
            }
            recycleListView.setPadding(paddingLeft2, paddingTop, paddingRight2, paddingBottom);
        }
        if (!z) {
            view = alertController.g;
            if (view == null) {
                view = alertController.A;
            }
            if (view != null) {
                if (z2) {
                }
                viewFindViewById3 = window.findViewById(R.attr.w8);
                viewFindViewById4 = window.findViewById(R.attr.w7);
                WeakHashMap weakHashMap2 = qd1.a;
                view.setScrollIndicators(i2 | i3, 3);
                if (viewFindViewById3 != null) {
                    viewGroupB2.removeView(viewFindViewById3);
                }
                if (viewFindViewById4 != null) {
                    viewGroupB2.removeView(viewFindViewById4);
                }
            }
        }
        recycleListView2 = alertController.g;
        if (recycleListView2 != null) {
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.b.A;
        if (nestedScrollView == null || !nestedScrollView.e(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.b.A;
        if (nestedScrollView == null || !nestedScrollView.e(keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.app.f, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AlertController alertController = this.b;
        alertController.e = charSequence;
        TextView textView = alertController.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
