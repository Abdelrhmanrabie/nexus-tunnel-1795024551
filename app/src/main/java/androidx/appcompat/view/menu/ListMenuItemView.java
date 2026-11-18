package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import defpackage.b2;
import defpackage.m6;
import defpackage.qd1;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements k.a, AbsListView.SelectionBoundsAdjuster {
    public h b;
    public ImageView c;
    public RadioButton d;
    public TextView f;
    public CheckBox g;
    public TextView i;
    public ImageView j;
    public ImageView n;
    public LinearLayout o;
    public final Drawable p;
    public final int q;
    public final Context r;
    public boolean s;
    public final Drawable t;
    public final boolean u;
    public LayoutInflater v;
    public boolean w;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6 m6VarM = m6.m(getContext(), attributeSet, b2.s, R.style.sc);
        this.p = m6VarM.e(5);
        TypedArray typedArray = (TypedArray) m6VarM.a;
        this.q = typedArray.getResourceId(1, -1);
        this.s = typedArray.getBoolean(7, false);
        this.r = context;
        this.t = m6VarM.e(8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.style.k2, 0);
        this.u = typedArrayObtainStyledAttributes.hasValue(0);
        m6VarM.n();
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.n;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
        rect.top = this.n.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public final h getItemData() {
        return this.b;
    }

    /* JADX WARN: Code duplicated, block: B:70:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:81:0x0110  */
    /* JADX WARN: Code duplicated, block: B:84:0x0115  */
    @Override // androidx.appcompat.view.menu.k.a
    public final void initialize(h hVar) {
        int i;
        CompoundButton compoundButton;
        View view;
        boolean z;
        int i2;
        ImageView imageView;
        int i3;
        String string;
        boolean z2;
        this.b = hVar;
        setVisibility(hVar.isVisible() ? 0 : 8);
        CharSequence charSequence = hVar.e;
        TextView textView = this.f;
        if (charSequence != null) {
            textView.setText(charSequence);
            if (this.f.getVisibility() != 0) {
                i = 0;
                this.f.setVisibility(i);
            }
        } else if (textView.getVisibility() != 8) {
            i = 8;
            this.f.setVisibility(i);
        }
        boolean zIsCheckable = hVar.isCheckable();
        if (zIsCheckable || this.d != null || this.g != null) {
            if ((this.b.x & 4) != 0) {
                if (this.d == null) {
                    if (this.v == null) {
                        this.v = LayoutInflater.from(getContext());
                    }
                    RadioButton radioButton = (RadioButton) this.v.inflate(R.layout.r, (ViewGroup) this, false);
                    this.d = radioButton;
                    LinearLayout linearLayout = this.o;
                    if (linearLayout != null) {
                        linearLayout.addView(radioButton, -1);
                    } else {
                        addView(radioButton, -1);
                    }
                }
                compoundButton = this.d;
                view = this.g;
            } else {
                if (this.g == null) {
                    if (this.v == null) {
                        this.v = LayoutInflater.from(getContext());
                    }
                    CheckBox checkBox = (CheckBox) this.v.inflate(R.layout.o, (ViewGroup) this, false);
                    this.g = checkBox;
                    LinearLayout linearLayout2 = this.o;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(checkBox, -1);
                    } else {
                        addView(checkBox, -1);
                    }
                }
                compoundButton = this.g;
                view = this.d;
            }
            if (zIsCheckable) {
                compoundButton.setChecked(this.b.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (view != null && view.getVisibility() != 8) {
                    view.setVisibility(8);
                }
            } else {
                CheckBox checkBox2 = this.g;
                if (checkBox2 != null) {
                    checkBox2.setVisibility(8);
                }
                RadioButton radioButton2 = this.d;
                if (radioButton2 != null) {
                    radioButton2.setVisibility(8);
                }
            }
        }
        f fVar = hVar.n;
        if (fVar.isShortcutsVisible()) {
            if ((fVar.isQwertyMode() ? hVar.j : hVar.h) != 0) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        fVar.isQwertyMode();
        if (z) {
            h hVar2 = this.b;
            f fVar2 = hVar2.n;
            if (fVar2.isShortcutsVisible()) {
                if ((fVar2.isQwertyMode() ? hVar2.j : hVar2.h) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
        } else {
            i2 = 8;
        }
        if (i2 == 0) {
            TextView textView2 = this.i;
            h hVar3 = this.b;
            char c = hVar3.n.isQwertyMode() ? hVar3.j : hVar3.h;
            if (c == 0) {
                string = AppConfig.CUSTOM;
            } else {
                f fVar3 = hVar3.n;
                Resources resources = fVar3.mContext.getResources();
                StringBuilder sb = new StringBuilder();
                if (ViewConfiguration.get(fVar3.mContext).hasPermanentMenuKey()) {
                    sb.append(resources.getString(R.string.s));
                }
                int i4 = fVar3.isQwertyMode() ? hVar3.k : hVar3.i;
                h.c(resources.getString(R.string.o), i4, 65536, sb);
                h.c(resources.getString(R.string.k), i4, 4096, sb);
                h.c(resources.getString(R.string.j), i4, 2, sb);
                h.c(resources.getString(R.string.p), i4, 1, sb);
                h.c(resources.getString(R.string.r), i4, 4, sb);
                h.c(resources.getString(R.string.n), i4, 8, sb);
                if (c == '\b') {
                    i3 = R.string.l;
                } else if (c != '\n') {
                    if (c != ' ') {
                        sb.append(c);
                    } else {
                        i3 = R.string.q;
                    }
                    string = sb.toString();
                } else {
                    i3 = R.string.m;
                }
                sb.append(resources.getString(i3));
                string = sb.toString();
            }
            textView2.setText(string);
        }
        if (this.i.getVisibility() != i2) {
            this.i.setVisibility(i2);
        }
        Drawable icon = hVar.getIcon();
        this.b.n.getClass();
        boolean z3 = this.w;
        if ((z3 || this.s) && ((imageView = this.c) != null || icon != null || this.s)) {
            if (imageView == null) {
                if (this.v == null) {
                    this.v = LayoutInflater.from(getContext());
                }
                ImageView imageView2 = (ImageView) this.v.inflate(R.layout.p, (ViewGroup) this, false);
                this.c = imageView2;
                LinearLayout linearLayout3 = this.o;
                if (linearLayout3 != null) {
                    linearLayout3.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (icon != null || this.s) {
                ImageView imageView3 = this.c;
                if (!z3) {
                    icon = null;
                }
                imageView3.setImageDrawable(icon);
                if (this.c.getVisibility() != 0) {
                    this.c.setVisibility(0);
                }
            } else {
                this.c.setVisibility(8);
            }
        }
        setEnabled(hVar.isEnabled());
        boolean zHasSubMenu = hVar.hasSubMenu();
        ImageView imageView4 = this.j;
        if (imageView4 != null) {
            imageView4.setVisibility(zHasSubMenu ? 0 : 8);
        }
        setContentDescription(hVar.q);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        WeakHashMap weakHashMap = qd1.a;
        setBackground(this.p);
        TextView textView = (TextView) findViewById(R.attr.a1g);
        this.f = textView;
        int i = this.q;
        if (i != -1) {
            textView.setTextAppearance(this.r, i);
        }
        this.i = (TextView) findViewById(R.attr.y4);
        ImageView imageView = (ImageView) findViewById(R.attr.zv);
        this.j = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.t);
        }
        this.n = (ImageView) findViewById(R.attr.lz);
        this.o = (LinearLayout) findViewById(R.attr.fy);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        if (this.c != null && this.s) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }
}
