package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.util.Locale;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ha {
    public final /* synthetic */ int G0;
    public final Object a;
    public int b;

    public /* synthetic */ ha(int i, Object obj, int i2) {
        this.G0 = i2;
        this.b = i;
        this.a = obj;
    }

    public ha(ImageView imageView) {
        this.G0 = 5;
        this.b = 0;
        this.a = imageView;
    }

    public /* synthetic */ ha(Object obj, int i, int i2) {
        this.G0 = i2;
        this.b = i;
        this.a = obj;
    }

    public static long a(String str) {
        String[] strArrSplit = str.split("\\.");
        return (Long.parseLong(strArrSplit[0]) << 24) + ((long) (Integer.parseInt(strArrSplit[1]) << 16)) + ((long) (Integer.parseInt(strArrSplit[2]) << 8)) + ((long) Integer.parseInt(strArrSplit[3]));
    }

    public void a() {
        Drawable drawable = ((ImageView) this.a).getDrawable();
        if (drawable != null) {
            fp.b(drawable);
        }
    }

    public void b(AttributeSet attributeSet, int i) {
        int resourceId;
        ImageView imageView = (ImageView) this.a;
        Context context = imageView.getContext();
        int[] iArr = b2.f;
        m6 m6VarM = m6.m(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) m6VarM.a;
        qd1.k(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) m6VarM.a, i);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = e.s(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                fp.b(drawable);
            }
            if (typedArray.hasValue(2)) {
                imageView.setImageTintList(m6VarM.b(2));
            }
            if (typedArray.hasValue(3)) {
                imageView.setImageTintMode(fp.d(typedArray.getInt(3, -1), null));
            }
        } finally {
            m6VarM.n();
        }
    }

    public void c(int i) {
        Drawable drawableS;
        ImageView imageView = (ImageView) this.a;
        if (i != 0) {
            drawableS = e.s(imageView.getContext(), i);
            if (drawableS != null) {
                fp.b(drawableS);
            }
        } else {
            drawableS = null;
        }
        imageView.setImageDrawable(drawableS);
        a();
    }

    public String toString() {
        if (this.G0 != 0) {
            return super.toString();
        }
        Locale locale = Locale.ENGLISH;
        return ((String) this.a) + InternalZipConstants.ZIP_FILE_SEPARATOR + this.b;
    }
}
