package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.b01;
import defpackage.b2;
import defpackage.bv;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements k.a, View.OnClickListener, ActionMenuView.a {
    public h b;
    public CharSequence c;
    public Drawable d;
    public f.b f;
    public a g;
    public b i;
    public boolean j;
    public final int o;
    public int p;
    public final int q;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a extends bv {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // defpackage.bv
        public final b01 b() {
            androidx.appcompat.widget.a.C0001a c0001a;
            b bVar = ActionMenuItemView.this.i;
            if (bVar == null || (c0001a = androidx.appcompat.widget.a.this.A) == null) {
                return null;
            }
            return c0001a.a();
        }

        @Override // defpackage.bv
        public final boolean c() {
            b01 b01VarB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            f.b bVar = actionMenuItemView.f;
            return bVar != null && bVar.a(actionMenuItemView.b) && (b01VarB = b()) != null && b01VarB.a();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class b {
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.j = d();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b2.c, 0, 0);
        this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.q = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.p = -1;
        setSaveEnabled(false);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public final boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public final boolean b() {
        return !TextUtils.isEmpty(getText()) && this.b.getIcon() == null;
    }

    public final boolean d() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (i < 480) {
            return (i >= 640 && i2 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    public final void e() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.c);
        if (this.d != null && ((this.b.y & 4) != 4 || !this.j)) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.c : null);
        CharSequence charSequence = this.b.q;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = z3 ? null : this.b.e;
        }
        setContentDescription(charSequence);
        CharSequence charSequence2 = this.b.r;
        if (TextUtils.isEmpty(charSequence2)) {
            b2.a(z3 ? null : this.b.e, this);
        } else {
            b2.a(charSequence2, this);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public final h getItemData() {
        return this.b;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public final void initialize(h hVar) {
        this.b = hVar;
        Drawable icon = hVar.getIcon();
        this.d = icon;
        if (icon != null) {
            int intrinsicWidth = icon.getIntrinsicWidth();
            int intrinsicHeight = icon.getIntrinsicHeight();
            int i = this.q;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            icon.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(icon, null, null, null);
        e();
        this.c = hVar.getTitleCondensed();
        e();
        setId(hVar.a);
        setVisibility(hVar.isVisible() ? 0 : 8);
        setEnabled(hVar.isEnabled());
        if (hVar.hasSubMenu() && this.g == null) {
            this.g = new a();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        f.b bVar = this.f;
        if (bVar != null) {
            bVar.a(this.b);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.j = d();
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        boolean zIsEmpty = TextUtils.isEmpty(getText());
        if (!zIsEmpty && (i3 = this.p) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int i4 = this.o;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i4) : i4;
        if (mode != 1073741824 && i4 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i2);
        }
        if (!zIsEmpty || this.d == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.d.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (this.b.hasSubMenu() && (aVar = this.g) != null && aVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        this.p = i;
        super.setPadding(i, i2, i3, i4);
    }
}
