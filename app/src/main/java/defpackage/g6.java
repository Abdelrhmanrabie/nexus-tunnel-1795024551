package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class g6 {
    public final TextView a;
    public a71 b;
    public a71 c;
    public a71 d;
    public a71 e;
    public a71 f;
    public a71 g;
    public a71 h;
    public final i6 i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends ak {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ WeakReference c;
        public final /* synthetic */ g6 d;

        public a(g6 g6Var, int i, int i2, WeakReference weakReference) {
            super(29, false);
            this.d = g6Var;
            this.a = i;
            this.b = i2;
            this.c = weakReference;
        }

        @Override // defpackage.ak
        public final void onFontRetrievalFailed(int i) {
        }

        @Override // defpackage.ak
        public final void onFontRetrieved(Typeface typeface) {
            int i;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.a) != -1) {
                typeface = Typeface.create(typeface, i, (this.b & 2) != 0);
            }
            g6 g6Var = this.d;
            if (g6Var.m) {
                g6Var.l = typeface;
                TextView textView = (TextView) this.c.get();
                if (textView != null) {
                    WeakHashMap weakHashMap = qd1.a;
                    boolean zIsAttachedToWindow = textView.isAttachedToWindow();
                    int i2 = g6Var.j;
                    if (zIsAttachedToWindow) {
                        textView.post(new h6(textView, typeface, i2));
                    } else {
                        textView.setTypeface(typeface, i2);
                    }
                }
            }
        }
    }

    public g6(TextView textView) {
        this.a = textView;
        this.i = new i6(textView);
    }

    public static a71 c(Context context, o5 o5Var, int i) {
        ColorStateList colorStateListI;
        synchronized (o5Var) {
            colorStateListI = o5Var.a.i(context, i);
        }
        if (colorStateListI == null) {
            return null;
        }
        a71 a71Var = new a71();
        a71Var.d = true;
        a71Var.a = colorStateListI;
        return a71Var;
    }

    public static void f(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i2 >= 30) {
            editorInfo.setInitialSurroundingSubText(text, 0);
            return;
        }
        text.getClass();
        if (i2 >= 30) {
            editorInfo.setInitialSurroundingSubText(text, 0);
            return;
        }
        int i3 = editorInfo.initialSelStart;
        int i4 = editorInfo.initialSelEnd;
        int i5 = i3 > i4 ? i4 : i3;
        if (i3 <= i4) {
            i3 = i4;
        }
        int length = text.length();
        if (i5 < 0 || i3 > length || (i = editorInfo.inputType & 4095) == 129 || i == 225 || i == 18) {
            b2.a(editorInfo, (CharSequence) null, 0, 0);
            return;
        }
        if (length <= 2048) {
            b2.a(editorInfo, text, i5, i3);
            return;
        }
        int i6 = i3 - i5;
        int i7 = i6 > 1024 ? 0 : i6;
        int i8 = 2048 - i7;
        int iMin = Math.min(text.length() - i3, i8 - Math.min(i5, (int) (((double) i8) * 0.8d)));
        int iMin2 = Math.min(i5, i8 - iMin);
        int i9 = i5 - iMin2;
        if (Character.isLowSurrogate(text.charAt(i9))) {
            i9++;
            iMin2--;
        }
        if (Character.isHighSurrogate(text.charAt((i3 + iMin) - 1))) {
            iMin--;
        }
        int i10 = iMin2 + i7;
        b2.a(editorInfo, i7 != i6 ? TextUtils.concat(text.subSequence(i9, i9 + iMin2), text.subSequence(i3, iMin + i3)) : text.subSequence(i9, i10 + iMin + i9), iMin2, i10);
    }

    public final void a(Drawable drawable, a71 a71Var) {
        if (drawable == null || a71Var == null) {
            return;
        }
        o5.e(drawable, a71Var, this.a.getDrawableState());
    }

    public final void b() {
        a71 a71Var = this.b;
        TextView textView = this.a;
        if (a71Var != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f == null && this.g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f);
        a(compoundDrawablesRelative[2], this.g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        String string;
        String string2;
        int i2;
        int resourceId;
        TextView textView = this.a;
        Context context = textView.getContext();
        o5 o5VarA = o5.a();
        int[] iArr = b2.h;
        m6 m6VarM = m6.m(context, attributeSet, iArr, i);
        qd1.k(textView, textView.getContext(), iArr, attributeSet, (TypedArray) m6VarM.a, i);
        TypedArray typedArray = (TypedArray) m6VarM.a;
        int resourceId2 = typedArray.getResourceId(0, -1);
        if (typedArray.hasValue(3)) {
            this.b = c(context, o5VarA, typedArray.getResourceId(3, 0));
        }
        if (typedArray.hasValue(1)) {
            this.c = c(context, o5VarA, typedArray.getResourceId(1, 0));
        }
        if (typedArray.hasValue(4)) {
            this.d = c(context, o5VarA, typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(2)) {
            this.e = c(context, o5VarA, typedArray.getResourceId(2, 0));
        }
        int i3 = Build.VERSION.SDK_INT;
        if (typedArray.hasValue(5)) {
            this.f = c(context, o5VarA, typedArray.getResourceId(5, 0));
        }
        if (typedArray.hasValue(6)) {
            this.g = c(context, o5VarA, typedArray.getResourceId(6, 0));
        }
        m6VarM.n();
        boolean z3 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] iArr2 = b2.y;
        if (resourceId2 != -1) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId2, iArr2);
            m6 m6Var = new m6(context, typedArrayObtainStyledAttributes);
            if (z3 || !typedArrayObtainStyledAttributes.hasValue(14)) {
                z = false;
                z2 = false;
            } else {
                z2 = typedArrayObtainStyledAttributes.getBoolean(14, false);
                z = true;
            }
            j(context, m6Var);
            string2 = typedArrayObtainStyledAttributes.hasValue(15) ? typedArrayObtainStyledAttributes.getString(15) : null;
            string = (i3 < 26 || !typedArrayObtainStyledAttributes.hasValue(13)) ? null : typedArrayObtainStyledAttributes.getString(13);
            m6Var.n();
        } else {
            z = false;
            z2 = false;
            string = null;
            string2 = null;
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        m6 m6Var2 = new m6(context, typedArrayObtainStyledAttributes2);
        if (!z3 && typedArrayObtainStyledAttributes2.hasValue(14)) {
            z2 = typedArrayObtainStyledAttributes2.getBoolean(14, false);
            z = true;
        }
        boolean z4 = z2;
        if (typedArrayObtainStyledAttributes2.hasValue(15)) {
            string2 = typedArrayObtainStyledAttributes2.getString(15);
        }
        String str = string2;
        if (i3 >= 26 && typedArrayObtainStyledAttributes2.hasValue(13)) {
            string = typedArrayObtainStyledAttributes2.getString(13);
        }
        if (i3 >= 28 && typedArrayObtainStyledAttributes2.hasValue(0) && typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        j(context, m6Var2);
        m6Var2.n();
        if (!z3 && z) {
            textView.setAllCaps(z4);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                textView.setTypeface(typeface, this.j);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (string != null) {
            textView.setFontVariationSettings(string);
        }
        if (str != null) {
            if (i3 >= 24) {
                textView.setTextLocales(LocaleList.forLanguageTags(str));
            } else {
                textView.setTextLocale(Locale.forLanguageTag(str.substring(0, str.indexOf(44))));
            }
        }
        int[] iArr3 = b2.i;
        i6 i6Var = this.i;
        Context context2 = i6Var.j;
        TypedArray typedArrayObtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr3, i, 0);
        TextView textView2 = i6Var.i;
        qd1.k(textView2, textView2.getContext(), iArr3, attributeSet, typedArrayObtainStyledAttributes3, i);
        if (typedArrayObtainStyledAttributes3.hasValue(5)) {
            i6Var.a = typedArrayObtainStyledAttributes3.getInt(5, 0);
        }
        float dimension = typedArrayObtainStyledAttributes3.hasValue(4) ? typedArrayObtainStyledAttributes3.getDimension(4, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes3.hasValue(2) ? typedArrayObtainStyledAttributes3.getDimension(2, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes3.hasValue(1) ? typedArrayObtainStyledAttributes3.getDimension(1, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes3.hasValue(3) && (resourceId = typedArrayObtainStyledAttributes3.getResourceId(3, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes3.getResources().obtainTypedArray(resourceId);
            int length = typedArrayObtainTypedArray.length();
            int[] iArr4 = new int[length];
            if (length > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    iArr4[i4] = typedArrayObtainTypedArray.getDimensionPixelSize(i4, -1);
                }
                i6Var.f = i6.b(iArr4);
                i6Var.g();
            }
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes3.recycle();
        if (!i6Var.h()) {
            i6Var.a = 0;
        } else if (i6Var.a == 1) {
            if (!i6Var.g) {
                DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    i2 = 2;
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                } else {
                    i2 = 2;
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(i2, 112.0f, displayMetrics);
                }
                float f = dimension3;
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                i6Var.i(dimension2, f, dimension);
            }
            i6Var.f();
        }
        if (t7.a && i6Var.a != 0) {
            int[] iArr5 = i6Var.f;
            if (iArr5.length > 0) {
                if (textView.getAutoSizeStepGranularity() != -1.0f) {
                    textView.setAutoSizeTextTypeUniformWithConfiguration(Math.round(i6Var.d), Math.round(i6Var.e), Math.round(i6Var.c), 0);
                } else {
                    textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr5, 0);
                }
            }
        }
        TypedArray typedArrayObtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr3);
        m6 m6Var3 = new m6(context, typedArrayObtainStyledAttributes4);
        int resourceId3 = typedArrayObtainStyledAttributes4.getResourceId(8, -1);
        Drawable drawableB = resourceId3 != -1 ? o5VarA.b(context, resourceId3) : null;
        int resourceId4 = typedArrayObtainStyledAttributes4.getResourceId(13, -1);
        Drawable drawableB2 = resourceId4 != -1 ? o5VarA.b(context, resourceId4) : null;
        int resourceId5 = typedArrayObtainStyledAttributes4.getResourceId(9, -1);
        Drawable drawableB3 = resourceId5 != -1 ? o5VarA.b(context, resourceId5) : null;
        int resourceId6 = typedArrayObtainStyledAttributes4.getResourceId(6, -1);
        Drawable drawableB4 = resourceId6 != -1 ? o5VarA.b(context, resourceId6) : null;
        int resourceId7 = typedArrayObtainStyledAttributes4.getResourceId(10, -1);
        Drawable drawableB5 = resourceId7 != -1 ? o5VarA.b(context, resourceId7) : null;
        int resourceId8 = typedArrayObtainStyledAttributes4.getResourceId(7, -1);
        Drawable drawableB6 = resourceId8 != -1 ? o5VarA.b(context, resourceId8) : null;
        if (drawableB5 != null || drawableB6 != null) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            if (drawableB5 == null) {
                drawableB5 = compoundDrawablesRelative[0];
            }
            if (drawableB2 == null) {
                drawableB2 = compoundDrawablesRelative[1];
            }
            if (drawableB6 == null) {
                drawableB6 = compoundDrawablesRelative[2];
            }
            if (drawableB4 == null) {
                drawableB4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableB5, drawableB2, drawableB6, drawableB4);
        } else if (drawableB != null || drawableB2 != null || drawableB3 != null || drawableB4 != null) {
            Drawable[] compoundDrawablesRelative2 = textView.getCompoundDrawablesRelative();
            Drawable drawable = compoundDrawablesRelative2[0];
            if (drawable == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                if (drawableB == null) {
                    drawableB = compoundDrawables[0];
                }
                if (drawableB2 == null) {
                    drawableB2 = compoundDrawables[1];
                }
                if (drawableB3 == null) {
                    drawableB3 = compoundDrawables[2];
                }
                if (drawableB4 == null) {
                    drawableB4 = compoundDrawables[3];
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawableB, drawableB2, drawableB3, drawableB4);
            } else {
                if (drawableB2 == null) {
                    drawableB2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable2 = compoundDrawablesRelative2[2];
                if (drawableB4 == null) {
                    drawableB4 = compoundDrawablesRelative2[3];
                }
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawableB2, drawable2, drawableB4);
            }
        }
        if (typedArrayObtainStyledAttributes4.hasValue(11)) {
            ColorStateList colorStateListB = m6Var3.b(11);
            if (Build.VERSION.SDK_INT >= 24) {
                textView.setCompoundDrawableTintList(colorStateListB);
            } else if (textView instanceof d71) {
                ((d71) textView).setSupportCompoundDrawablesTintList(colorStateListB);
            }
        }
        if (typedArrayObtainStyledAttributes4.hasValue(12)) {
            PorterDuff.Mode modeD = fp.d(typedArrayObtainStyledAttributes4.getInt(12, -1), null);
            if (Build.VERSION.SDK_INT >= 24) {
                textView.setCompoundDrawableTintMode(modeD);
            } else if (textView instanceof d71) {
                ((d71) textView).setSupportCompoundDrawablesTintMode(modeD);
            }
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes4.getDimensionPixelSize(15, -1);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(18, -1);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(19, -1);
        m6Var3.n();
        if (dimensionPixelSize != -1) {
            ak.b(textView, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != -1) {
            ak.c(textView, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != -1) {
            e.C0(dimensionPixelSize3);
            int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
            if (dimensionPixelSize3 != fontMetricsInt) {
                textView.setLineSpacing(dimensionPixelSize3 - fontMetricsInt, 1.0f);
            }
        }
    }

    public final void e(Context context, int i) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, b2.y);
        m6 m6Var = new m6(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = this.a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        j(context, m6Var);
        if (i2 >= 26 && typedArrayObtainStyledAttributes.hasValue(13) && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
            textView.setFontVariationSettings(string);
        }
        m6Var.n();
        Typeface typeface = this.l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.j);
        }
    }

    public final void g(int i, int i2, int i3, int i4) {
        i6 i6Var = this.i;
        if (i6Var.h()) {
            DisplayMetrics displayMetrics = i6Var.j.getResources().getDisplayMetrics();
            i6Var.i(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (i6Var.f()) {
                i6Var.a();
            }
        }
    }

    public final void h(int[] iArr, int i) {
        i6 i6Var = this.i;
        if (i6Var.h()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = i6Var.j.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                i6Var.f = i6.b(iArrCopyOf);
                if (!i6Var.g()) {
                    throw new IllegalArgumentException(ak.AnonymousClass0.m("None of the preset sizes is valid: ", Arrays.toString(iArr)));
                }
            } else {
                i6Var.g = false;
            }
            if (i6Var.f()) {
                i6Var.a();
            }
        }
    }

    public final void i(int i) {
        i6 i6Var = this.i;
        if (i6Var.h()) {
            if (i == 0) {
                i6Var.a = 0;
                i6Var.d = -1.0f;
                i6Var.e = -1.0f;
                i6Var.c = -1.0f;
                i6Var.f = new int[0];
                i6Var.b = false;
                return;
            }
            if (i != 1) {
                throw new IllegalArgumentException(ak.h(i, "Unknown auto-size text type: "));
            }
            DisplayMetrics displayMetrics = i6Var.j.getResources().getDisplayMetrics();
            i6Var.i(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (i6Var.f()) {
                i6Var.a();
            }
        }
    }

    public final void j(Context context, m6 m6Var) {
        String string;
        Typeface typefaceCreate;
        Typeface typeface;
        int i = this.j;
        TypedArray typedArray = (TypedArray) m6Var.a;
        this.j = typedArray.getInt(2, i);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int i3 = typedArray.getInt(11, -1);
            this.k = i3;
            if (i3 != -1) {
                this.j &= 2;
            }
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.m = false;
                int i4 = typedArray.getInt(1, 1);
                if (i4 == 1) {
                    typeface = Typeface.SANS_SERIF;
                } else if (i4 == 2) {
                    typeface = Typeface.SERIF;
                } else if (i4 != 3) {
                    return;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
                this.l = typeface;
                return;
            }
            return;
        }
        this.l = null;
        int i5 = typedArray.hasValue(12) ? 12 : 10;
        int i6 = this.k;
        int i7 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceG = m6Var.g(i5, this.j, new a(this, i6, i7, new WeakReference(this.a)));
                if (typefaceG != null) {
                    if (i2 >= 28 && this.k != -1) {
                        typefaceG = Typeface.create(Typeface.create(typefaceG, 0), this.k, (this.j & 2) != 0);
                    }
                    this.l = typefaceG;
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (string = typedArray.getString(i5)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
            typefaceCreate = Typeface.create(string, this.j);
        } else {
            typefaceCreate = Typeface.create(Typeface.create(string, 0), this.k, (this.j & 2) != 0);
        }
        this.l = typefaceCreate;
    }
}
