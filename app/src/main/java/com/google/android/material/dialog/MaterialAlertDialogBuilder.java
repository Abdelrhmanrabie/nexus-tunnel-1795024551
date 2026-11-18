package com.google.android.material.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.e;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.qd1;
import defpackage.yh;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MaterialAlertDialogBuilder extends e.a {
    public final MaterialShapeDrawable background;
    public final Rect backgroundInsets;

    public MaterialAlertDialogBuilder(Context context) {
        this(context, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialAlertDialogBuilder(Context context, int i) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, R.style.sr);
        int i2 = typedValueResolve == null ? 0 : typedValueResolve.data;
        Context contextWrap = MaterialThemeOverlay.wrap(context, null, R.style.ar, R.plurals.he);
        contextWrap = i2 != 0 ? new yh(contextWrap, i2) : contextWrap;
        if (i == 0) {
            TypedValue typedValueResolve2 = MaterialAttributes.resolve(context, R.style.sr);
            i = typedValueResolve2 == null ? 0 : typedValueResolve2.data;
        }
        super(contextWrap, i);
        ContextThemeWrapper contextThemeWrapper = this.P.a;
        Resources.Theme theme = contextThemeWrapper.getTheme();
        this.backgroundInsets = MaterialDialogs.getDialogBackgroundInsets(contextThemeWrapper, R.style.ar, R.plurals.he);
        int iResolveOrThrow = MaterialAttributes.resolveOrThrow(contextThemeWrapper, R.style.gx, getClass().getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(contextThemeWrapper, null, R.style.ar, R.plurals.he);
        materialShapeDrawable.initializeElevationOverlay(contextThemeWrapper);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(iResolveOrThrow));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(android.R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(this.P.a.getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                materialShapeDrawable.setCornerSize(dimension);
            }
        }
        this.background = materialShapeDrawable;
    }

    @Override // androidx.appcompat.app.e.a
    public final e create() {
        e eVarCreate = super.create();
        Window window = eVarCreate.getWindow();
        View decorView = window.getDecorView();
        MaterialShapeDrawable materialShapeDrawable = this.background;
        if (materialShapeDrawable != null) {
            WeakHashMap weakHashMap = qd1.a;
            materialShapeDrawable.setElevation(decorView.getElevation());
        }
        Rect rect = this.backgroundInsets;
        window.setBackgroundDrawable(new InsetDrawable((Drawable) materialShapeDrawable, rect.left, rect.top, rect.right, rect.bottom));
        decorView.setOnTouchListener(new InsetDialogOnTouchListener(eVarCreate, rect));
        return eVarCreate;
    }

    @Override // androidx.appcompat.app.e.a
    public final void setCancelable() {
        this.P.q = false;
    }

    @Override // androidx.appcompat.app.e.a
    public final e.a setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        throw null;
    }

    @Override // androidx.appcompat.app.e.a
    public final e.a setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        throw null;
    }

    @Override // androidx.appcompat.app.e.a
    public final void setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        super.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    @Override // androidx.appcompat.app.e.a
    public final e.a setTitle(int i) {
        throw null;
    }
}
