package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import defpackage.ha;
import defpackage.j61;
import defpackage.y4;
import defpackage.z61;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageView extends ImageView {
    public final y4 mBackgroundTintHelper;
    public boolean mHasLevel;
    public final ha mImageHelper;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        z61.a(context);
        this.mHasLevel = false;
        j61.a(this, getContext());
        y4 y4Var = new y4(this);
        this.mBackgroundTintHelper = y4Var;
        y4Var.d(attributeSet, i);
        ha haVar = new ha(this);
        this.mImageHelper = haVar;
        haVar.b(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var != null) {
            y4Var.a();
        }
        ha haVar = this.mImageHelper;
        if (haVar != null) {
            haVar.a();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.mImageHelper.a).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var != null) {
            y4Var.e();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var != null) {
            y4Var.f(i);
        }
    }

    @Override // android.widget.ImageView
    public final void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        ha haVar = this.mImageHelper;
        if (haVar != null) {
            haVar.a();
        }
    }

    @Override // android.widget.ImageView
    public final void setImageDrawable(Drawable drawable) {
        ha haVar = this.mImageHelper;
        if (haVar != null && drawable != null && !this.mHasLevel) {
            haVar.b = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (haVar != null) {
            haVar.a();
            if (this.mHasLevel) {
                return;
            }
            ImageView imageView = (ImageView) haVar.a;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(haVar.b);
            }
        }
    }

    @Override // android.widget.ImageView
    public final void setImageLevel(int i) {
        super.setImageLevel(i);
        this.mHasLevel = true;
    }

    @Override // android.widget.ImageView
    public final void setImageResource(int i) {
        ha haVar = this.mImageHelper;
        if (haVar != null) {
            haVar.c(i);
        }
    }

    @Override // android.widget.ImageView
    public final void setImageURI(Uri uri) {
        super.setImageURI(uri);
        ha haVar = this.mImageHelper;
        if (haVar != null) {
            haVar.a();
        }
    }
}
