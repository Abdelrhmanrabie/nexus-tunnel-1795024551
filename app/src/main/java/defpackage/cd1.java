package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import renz.javacodez.v2ray.plugin.PluginContract;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class cd1 extends bd1 {
    public static final PorterDuff.Mode p = PorterDuff.Mode.SRC_IN;
    public g c;
    public PorterDuffColorFilter d;
    public ColorFilter f;
    public boolean g;
    public boolean i;
    public final float[] j;
    public final Matrix n;
    public final Rect o;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends e {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends e {
        public gj e;
        public float f;
        public gj g;
        public float h;
        public float i;
        public float j;
        public float k;
        public float l;
        public Paint.Cap m;
        public Paint.Join n;
        public float o;

        @Override // cd1.d
        public final boolean a() {
            return this.g.b() || this.e.b();
        }

        /* JADX WARN: Code duplicated, block: B:13:0x003a  */
        /* JADX WARN: Code duplicated, block: B:7:0x001e  */
        @Override // cd1.d
        public final boolean b(int[] iArr) {
            boolean z;
            gj gjVar = this.g;
            boolean z2 = true;
            if (gjVar.b()) {
                ColorStateList colorStateList = (ColorStateList) gjVar.c;
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (colorForState != gjVar.b) {
                    gjVar.b = colorForState;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            gj gjVar2 = this.e;
            if (gjVar2.b()) {
                ColorStateList colorStateList2 = (ColorStateList) gjVar2.c;
                int colorForState2 = colorStateList2.getColorForState(iArr, colorStateList2.getDefaultColor());
                if (colorForState2 != gjVar2.b) {
                    gjVar2.b = colorForState2;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            return z2 | z;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends d {
        public final Matrix a;
        public final ArrayList b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public final Matrix j;
        public String l;

        public c() {
            this.a = new Matrix();
            this.b = new ArrayList();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.l = null;
        }

        public c(c cVar, d7 d7Var) {
            e aVar;
            this.a = new Matrix();
            this.b = new ArrayList();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            Matrix matrix = new Matrix();
            this.j = matrix;
            this.l = null;
            this.c = cVar.c;
            this.d = cVar.d;
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.h = cVar.h;
            this.i = cVar.i;
            String str = cVar.l;
            this.l = str;
            if (str != null) {
                d7Var.put(str, this);
            }
            matrix.set(cVar.j);
            ArrayList arrayList = cVar.b;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof c) {
                    this.b.add(new c((c) obj, d7Var));
                } else {
                    if (obj instanceof b) {
                        b bVar = (b) obj;
                        b bVar2 = new b(bVar);
                        bVar2.f = 0.0f;
                        bVar2.h = 1.0f;
                        bVar2.i = 1.0f;
                        bVar2.j = 0.0f;
                        bVar2.k = 1.0f;
                        bVar2.l = 0.0f;
                        bVar2.m = Paint.Cap.BUTT;
                        bVar2.n = Paint.Join.MITER;
                        bVar2.o = 4.0f;
                        bVar2.e = bVar.e;
                        bVar2.f = bVar.f;
                        bVar2.h = bVar.h;
                        bVar2.g = bVar.g;
                        bVar2.c = bVar.c;
                        bVar2.i = bVar.i;
                        bVar2.j = bVar.j;
                        bVar2.k = bVar.k;
                        bVar2.l = bVar.l;
                        bVar2.m = bVar.m;
                        bVar2.n = bVar.n;
                        bVar2.o = bVar.o;
                        aVar = bVar2;
                    } else {
                        if (!(obj instanceof a)) {
                            defpackage.d.AnonymousClass0.m("Unknown object in the tree!");
                            throw null;
                        }
                        aVar = new a((a) obj);
                    }
                    this.b.add(aVar);
                    Object obj2 = aVar.b;
                    if (obj2 != null) {
                        d7Var.put(obj2, aVar);
                    }
                }
            }
        }

        @Override // cd1.d
        public final boolean a() {
            int i = 0;
            while (true) {
                ArrayList arrayList = this.b;
                if (i >= arrayList.size()) {
                    return false;
                }
                if (((d) arrayList.get(i)).a()) {
                    return true;
                }
                i++;
            }
        }

        @Override // cd1.d
        public final boolean b(int[] iArr) {
            int i = 0;
            boolean zB = false;
            while (true) {
                ArrayList arrayList = this.b;
                if (i >= arrayList.size()) {
                    return zB;
                }
                zB |= ((d) arrayList.get(i)).b(iArr);
                i++;
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class d {
        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class e extends d {
        public so0$a[] a;
        public String b;
        public int c;

        public e() {
            this.a = null;
            this.c = 0;
        }

        public e(e eVar) {
            this.a = null;
            this.c = 0;
            this.b = eVar.b;
            so0$a[] so0_aArr = eVar.a;
            so0$a[] so0_aArr2 = new so0$a[so0_aArr.length];
            for (int i = 0; i < so0_aArr.length; i++) {
                so0_aArr2[i] = new so0$a(so0_aArr[i]);
            }
            this.a = so0_aArr2;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class f {
        public static final Matrix p = new Matrix();
        public final Path a;
        public final Path b;
        public final Matrix c;
        public Paint d;
        public Paint e;
        public PathMeasure f;
        public final c g;
        public float h;
        public float i;
        public float j;
        public float k;
        public int l;
        public String m;
        public Boolean n;
        public final d7 o;

        public f() {
            this.c = new Matrix();
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 255;
            this.m = null;
            this.n = null;
            this.o = new d7();
            this.g = new c();
            this.a = new Path();
            this.b = new Path();
        }

        public f(f fVar) {
            this.c = new Matrix();
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 255;
            this.m = null;
            this.n = null;
            d7 d7Var = new d7();
            this.o = d7Var;
            this.g = new c(fVar.g, d7Var);
            this.a = new Path(fVar.a);
            this.b = new Path(fVar.b);
            this.h = fVar.h;
            this.i = fVar.i;
            this.j = fVar.j;
            this.k = fVar.k;
            this.l = fVar.l;
            this.m = fVar.m;
            String str = fVar.m;
            if (str != null) {
                d7Var.put(str, this);
            }
            this.n = fVar.n;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2) {
            int i3;
            float f;
            int i4;
            cVar.a.set(matrix);
            Matrix matrix2 = cVar.a;
            matrix2.preConcat(cVar.j);
            canvas.save();
            char c = 0;
            int i5 = 0;
            while (true) {
                ArrayList arrayList = cVar.b;
                if (i5 >= arrayList.size()) {
                    canvas.restore();
                    return;
                }
                d dVar = (d) arrayList.get(i5);
                if (dVar instanceof c) {
                    a((c) dVar, matrix2, canvas, i, i2);
                } else {
                    if (dVar instanceof e) {
                        e eVar = (e) dVar;
                        float f2 = i / this.j;
                        float f3 = i2 / this.k;
                        float fMin = Math.min(f2, f3);
                        Matrix matrix3 = this.c;
                        matrix3.set(matrix2);
                        matrix3.postScale(f2, f3);
                        float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                        matrix2.mapVectors(fArr);
                        float fHypot = (float) Math.hypot(fArr[c], fArr[1]);
                        boolean z = c;
                        i3 = i5;
                        float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                        float f4 = (fArr[z ? 1 : 0] * fArr[3]) - (fArr[1] * fArr[2]);
                        float fMax = Math.max(fHypot, fHypot2);
                        float fAbs = fMax > 0.0f ? Math.abs(f4) / fMax : 0.0f;
                        if (fAbs != 0.0f) {
                            Path path = this.a;
                            path.reset();
                            so0$a[] so0_aArr = eVar.a;
                            if (so0_aArr != null) {
                                so0$a.b(so0_aArr, path);
                            }
                            Path path2 = this.b;
                            path2.reset();
                            if (eVar instanceof a) {
                                path2.setFillType(eVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                path2.addPath(path, matrix3);
                                canvas.clipPath(path2);
                            } else {
                                b bVar = (b) eVar;
                                float f5 = bVar.j;
                                if (f5 != 0.0f || bVar.k != 1.0f) {
                                    float f6 = bVar.l;
                                    float f7 = (f5 + f6) % 1.0f;
                                    float f8 = (bVar.k + f6) % 1.0f;
                                    if (this.f == null) {
                                        this.f = new PathMeasure();
                                    }
                                    this.f.setPath(path, z);
                                    float length = this.f.getLength();
                                    float f9 = f7 * length;
                                    float f10 = f8 * length;
                                    path.reset();
                                    PathMeasure pathMeasure = this.f;
                                    if (f9 > f10) {
                                        pathMeasure.getSegment(f9, length, path, true);
                                        f = 0.0f;
                                        this.f.getSegment(0.0f, f10, path, true);
                                    } else {
                                        f = 0.0f;
                                        pathMeasure.getSegment(f9, f10, path, true);
                                    }
                                    path.rLineTo(f, f);
                                }
                                path2.addPath(path, matrix3);
                                gj gjVar = bVar.g;
                                float f11 = 255.0f;
                                if ((((Shader) gjVar.a) == null && gjVar.b == 0) ? false : true) {
                                    if (this.e == null) {
                                        i4 = 16777215;
                                        Paint paint = new Paint(1);
                                        this.e = paint;
                                        paint.setStyle(Paint.Style.FILL);
                                    } else {
                                        i4 = 16777215;
                                    }
                                    Paint paint2 = this.e;
                                    Shader shader = (Shader) gjVar.a;
                                    if (shader != null) {
                                        shader.setLocalMatrix(matrix3);
                                        paint2.setShader(shader);
                                        paint2.setAlpha(Math.round(bVar.i * 255.0f));
                                    } else {
                                        paint2.setShader(null);
                                        paint2.setAlpha(255);
                                        int i6 = gjVar.b;
                                        float f12 = bVar.i;
                                        PorterDuff.Mode mode = cd1.p;
                                        paint2.setColor((i6 & i4) | (((int) (Color.alpha(i6) * f12)) << 24));
                                    }
                                    paint2.setColorFilter(null);
                                    path2.setFillType(bVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                    canvas.drawPath(path2, paint2);
                                } else {
                                    f11 = 255.0f;
                                    i4 = 16777215;
                                }
                                gj gjVar2 = bVar.e;
                                if (((Shader) gjVar2.a) != null || gjVar2.b != 0) {
                                    if (this.d == null) {
                                        Paint paint3 = new Paint(1);
                                        this.d = paint3;
                                        paint3.setStyle(Paint.Style.STROKE);
                                    }
                                    Paint paint4 = this.d;
                                    Paint.Join join = bVar.n;
                                    if (join != null) {
                                        paint4.setStrokeJoin(join);
                                    }
                                    Paint.Cap cap = bVar.m;
                                    if (cap != null) {
                                        paint4.setStrokeCap(cap);
                                    }
                                    paint4.setStrokeMiter(bVar.o);
                                    Shader shader2 = (Shader) gjVar2.a;
                                    if (shader2 != null) {
                                        shader2.setLocalMatrix(matrix3);
                                        paint4.setShader(shader2);
                                        paint4.setAlpha(Math.round(bVar.h * f11));
                                    } else {
                                        paint4.setShader(null);
                                        paint4.setAlpha(255);
                                        int i7 = gjVar2.b;
                                        float f13 = bVar.h;
                                        PorterDuff.Mode mode2 = cd1.p;
                                        paint4.setColor((i7 & i4) | (((int) (Color.alpha(i7) * f13)) << 24));
                                    }
                                    paint4.setColorFilter(null);
                                    paint4.setStrokeWidth(bVar.f * fAbs * fMin);
                                    canvas.drawPath(path2, paint4);
                                }
                            }
                        }
                    }
                    i5 = i3 + 1;
                    c = 0;
                }
                i3 = i5;
                i5 = i3 + 1;
                c = 0;
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class g extends Drawable.ConstantState {
        public int a;
        public f b;
        public ColorStateList c;
        public PorterDuff.Mode d;
        public boolean e;
        public Bitmap f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public int i;
        public boolean j;
        public boolean k;
        public Paint l;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new cd1(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new cd1(this);
        }
    }

    public cd1() {
        this.i = true;
        this.j = new float[9];
        this.n = new Matrix();
        this.o = new Rect();
        g gVar = new g();
        gVar.c = null;
        gVar.d = p;
        gVar.b = new f();
        this.c = gVar;
    }

    public cd1(g gVar) {
        this.i = true;
        this.j = new float[9];
        this.n = new Matrix();
        this.o = new Rect();
        this.c = gVar;
        this.d = a(gVar.c, gVar.d);
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.b;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.o;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f;
        if (colorFilter == null) {
            colorFilter = this.d;
        }
        Matrix matrix = this.n;
        canvas.getMatrix(matrix);
        float[] fArr = this.j;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iHeight = (int) (rect.height() * fAbs2);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, iHeight);
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && getLayoutDirection() == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        g gVar = this.c;
        Bitmap bitmap = gVar.f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != gVar.f.getHeight()) {
            gVar.f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            gVar.k = true;
        }
        boolean z = this.i;
        g gVar2 = this.c;
        if (!z) {
            gVar2.f.eraseColor(0);
            Canvas canvas2 = new Canvas(gVar2.f);
            f fVar = gVar2.b;
            fVar.a(fVar.g, f.p, canvas2, iMin, iMin2);
        } else if (gVar2.k || gVar2.g != gVar2.c || gVar2.h != gVar2.d || gVar2.j != gVar2.e || gVar2.i != gVar2.b.l) {
            gVar2.f.eraseColor(0);
            Canvas canvas3 = new Canvas(gVar2.f);
            f fVar2 = gVar2.b;
            fVar2.a(fVar2.g, f.p, canvas3, iMin, iMin2);
            g gVar3 = this.c;
            gVar3.g = gVar3.c;
            gVar3.h = gVar3.d;
            gVar3.i = gVar3.b.l;
            gVar3.j = gVar3.e;
            gVar3.k = false;
        }
        g gVar4 = this.c;
        if ((gVar4.b.l < 255) || colorFilter != null) {
            if (gVar4.l == null) {
                Paint paint2 = new Paint();
                gVar4.l = paint2;
                paint2.setFilterBitmap(true);
            }
            gVar4.l.setAlpha(gVar4.b.l);
            gVar4.l.setColorFilter(colorFilter);
            paint = gVar4.l;
        } else {
            paint = null;
        }
        canvas.drawBitmap(gVar4.f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getAlpha() : this.c.b.l;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.c.a;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getColorFilter() : this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.b != null && Build.VERSION.SDK_INT >= 24) {
            return new t3.c(this.b.getConstantState(), 1);
        }
        this.c.a = getChangingConfigurations();
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.c.b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.c.b.h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        ColorStateList colorStateListA;
        f fVar;
        boolean z;
        int i;
        boolean z2;
        char c2;
        int i2;
        Paint.Cap cap;
        Paint.Join join;
        Resources resources2 = resources;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.inflate(resources2, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.c;
        gVar.b = new f();
        TypedArray typedArrayH = ak.h(resources2, theme, attributeSet, ak.a$2);
        g gVar2 = this.c;
        f fVar2 = gVar2.b;
        int i3 = !ak.g(xmlPullParser, "tintMode") ? -1 : typedArrayH.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (i3 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i3 != 5) {
            if (i3 != 9) {
                switch (i3) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        gVar2.d = mode;
        boolean z3 = false;
        int i4 = 1;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "tint") != null) {
            TypedValue typedValue = new TypedValue();
            typedArrayH.getValue(1, typedValue);
            int i5 = typedValue.type;
            if (i5 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i5 < 28 || i5 > 31) {
                Resources resources3 = typedArrayH.getResources();
                int resourceId = typedArrayH.getResourceId(1, 0);
                ThreadLocal threadLocal = ie.a;
                try {
                    colorStateListA = ie.a(resources3, resources3.getXml(resourceId), theme);
                } catch (Exception unused) {
                    colorStateListA = null;
                }
            } else {
                colorStateListA = ColorStateList.valueOf(typedValue.data);
            }
        } else {
            colorStateListA = null;
        }
        if (colorStateListA != null) {
            gVar2.c = colorStateListA;
        }
        boolean z4 = gVar2.e;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null) {
            z4 = typedArrayH.getBoolean(5, z4);
        }
        gVar2.e = z4;
        float f2 = fVar2.j;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportWidth") != null) {
            f2 = typedArrayH.getFloat(7, f2);
        }
        fVar2.j = f2;
        float f3 = fVar2.k;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportHeight") != null) {
            f3 = typedArrayH.getFloat(8, f3);
        }
        fVar2.k = f3;
        boolean z5 = false;
        if (fVar2.j <= 0.0f) {
            throw new XmlPullParserException(typedArrayH.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f3 <= 0.0f) {
            throw new XmlPullParserException(typedArrayH.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        fVar2.h = typedArrayH.getDimension(3, fVar2.h);
        float dimension = typedArrayH.getDimension(2, fVar2.i);
        fVar2.i = dimension;
        if (fVar2.h <= 0.0f) {
            throw new XmlPullParserException(typedArrayH.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArrayH.getPositionDescription() + "<vector> tag requires height > 0");
        }
        float f4 = fVar2.l / 255.0f;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "alpha") != null) {
            f4 = typedArrayH.getFloat(4, f4);
        }
        fVar2.l = (int) (f4 * 255.0f);
        String string = typedArrayH.getString(0);
        if (string != null) {
            fVar2.m = string;
            fVar2.o.put(string, fVar2);
        }
        typedArrayH.recycle();
        gVar.a = getChangingConfigurations();
        gVar.k = true;
        g gVar3 = this.c;
        f fVar3 = gVar3.b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar3.g);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z6 = true;
        while (eventType != i4 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                boolean zEquals = PluginContract.COLUMN_PATH.equals(name);
                d7 d7Var = fVar3.o;
                fVar = fVar3;
                if (zEquals) {
                    b bVar = new b();
                    bVar.f = 0.0f;
                    bVar.h = 1.0f;
                    bVar.i = 1.0f;
                    i = depth;
                    bVar.j = 0.0f;
                    bVar.k = 1.0f;
                    bVar.l = 0.0f;
                    Paint.Cap cap2 = Paint.Cap.BUTT;
                    bVar.m = cap2;
                    Paint.Join join2 = Paint.Join.MITER;
                    bVar.n = join2;
                    bVar.o = 4.0f;
                    TypedArray typedArrayH2 = ak.h(resources2, theme, attributeSet, ak.c$1);
                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                        String string2 = typedArrayH2.getString(0);
                        if (string2 != null) {
                            bVar.b = string2;
                        }
                        String string3 = typedArrayH2.getString(2);
                        if (string3 != null) {
                            bVar.a = e4.c(string3);
                        }
                        bVar.g = ak.b(typedArrayH2, xmlPullParser, theme, "fillColor", 1);
                        float f5 = bVar.i;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillAlpha") != null) {
                            f5 = typedArrayH2.getFloat(12, f5);
                        }
                        bVar.i = f5;
                        int i6 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineCap") != null ? typedArrayH2.getInt(8, -1) : -1;
                        Paint.Cap cap3 = bVar.m;
                        if (i6 == 0) {
                            cap = cap2;
                        } else if (i6 != 1) {
                            cap = i6 != 2 ? cap3 : Paint.Cap.SQUARE;
                        } else {
                            cap = Paint.Cap.ROUND;
                        }
                        bVar.m = cap;
                        int i7 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineJoin") != null ? typedArrayH2.getInt(9, -1) : -1;
                        Paint.Join join3 = bVar.n;
                        if (i7 == 0) {
                            join = join2;
                        } else if (i7 != 1) {
                            join = i7 != 2 ? join3 : Paint.Join.BEVEL;
                        } else {
                            join = Paint.Join.ROUND;
                        }
                        bVar.n = join;
                        float f6 = bVar.o;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeMiterLimit") != null) {
                            f6 = typedArrayH2.getFloat(10, f6);
                        }
                        bVar.o = f6;
                        bVar.e = ak.b(typedArrayH2, xmlPullParser, theme, "strokeColor", 3);
                        float f7 = bVar.h;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeAlpha") != null) {
                            f7 = typedArrayH2.getFloat(11, f7);
                        }
                        bVar.h = f7;
                        float f8 = bVar.f;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeWidth") != null) {
                            f8 = typedArrayH2.getFloat(4, f8);
                        }
                        bVar.f = f8;
                        float f9 = bVar.k;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathEnd") != null) {
                            f9 = typedArrayH2.getFloat(6, f9);
                        }
                        bVar.k = f9;
                        float f10 = bVar.l;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathOffset") != null) {
                            f10 = typedArrayH2.getFloat(7, f10);
                        }
                        bVar.l = f10;
                        float f11 = bVar.j;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathStart") != null) {
                            f11 = typedArrayH2.getFloat(5, f11);
                        }
                        bVar.j = f11;
                        int i8 = bVar.c;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null) {
                            i8 = typedArrayH2.getInt(13, i8);
                        }
                        bVar.c = i8;
                    }
                    typedArrayH2.recycle();
                    cVar.b.add(bVar);
                    String str = bVar.b;
                    if (str != null) {
                        d7Var.put(str, bVar);
                    }
                    gVar3.a = gVar3.a;
                    z6 = false;
                    c2 = '\b';
                } else {
                    i = depth;
                    c2 = '\b';
                    if ("clip-path".equals(name)) {
                        a aVar = new a();
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                            TypedArray typedArrayH3 = ak.h(resources2, theme, attributeSet, ak.d$1);
                            String string4 = typedArrayH3.getString(0);
                            if (string4 != null) {
                                aVar.b = string4;
                            }
                            String string5 = typedArrayH3.getString(1);
                            if (string5 != null) {
                                aVar.a = e4.c(string5);
                            }
                            aVar.c = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null ? typedArrayH3.getInt(2, 0) : 0;
                            typedArrayH3.recycle();
                        }
                        cVar.b.add(aVar);
                        String str2 = aVar.b;
                        if (str2 != null) {
                            d7Var.put(str2, aVar);
                        }
                        gVar3.a = gVar3.a;
                    } else if ("group".equals(name)) {
                        c cVar2 = new c();
                        TypedArray typedArrayH4 = ak.h(resources2, theme, attributeSet, ak.f6b$1);
                        float f12 = cVar2.c;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "rotation") != null) {
                            f12 = typedArrayH4.getFloat(5, f12);
                        }
                        cVar2.c = f12;
                        cVar2.d = typedArrayH4.getFloat(1, cVar2.d);
                        cVar2.e = typedArrayH4.getFloat(2, cVar2.e);
                        float f13 = cVar2.f;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleX") != null) {
                            f13 = typedArrayH4.getFloat(3, f13);
                        }
                        cVar2.f = f13;
                        float f14 = cVar2.g;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleY") != null) {
                            f14 = typedArrayH4.getFloat(4, f14);
                        }
                        cVar2.g = f14;
                        float f15 = cVar2.h;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateX") != null) {
                            f15 = typedArrayH4.getFloat(6, f15);
                        }
                        cVar2.h = f15;
                        float f16 = cVar2.i;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateY") != null) {
                            f16 = typedArrayH4.getFloat(7, f16);
                        }
                        cVar2.i = f16;
                        String string6 = typedArrayH4.getString(0);
                        if (string6 != null) {
                            cVar2.l = string6;
                        }
                        Matrix matrix = cVar2.j;
                        matrix.reset();
                        matrix.postTranslate(-cVar2.d, -cVar2.e);
                        matrix.postScale(cVar2.f, cVar2.g);
                        matrix.postRotate(cVar2.c, 0.0f, 0.0f);
                        matrix.postTranslate(cVar2.h + cVar2.d, cVar2.i + cVar2.e);
                        typedArrayH4.recycle();
                        cVar.b.add(cVar2);
                        arrayDeque.push(cVar2);
                        String str3 = cVar2.l;
                        if (str3 != null) {
                            d7Var.put(str3, cVar2);
                        }
                        gVar3.a = gVar3.a;
                    }
                }
                i2 = 1;
                z = false;
                z2 = false;
            } else {
                fVar = fVar3;
                z = z3;
                i = depth;
                z2 = z5;
                c2 = '\b';
                i2 = 1;
                if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                    arrayDeque.pop();
                }
            }
            eventType = xmlPullParser.next();
            resources2 = resources;
            i4 = i2;
            z3 = z;
            z5 = z2;
            fVar3 = fVar;
            depth = i;
        }
        if (z6) {
            throw new XmlPullParserException("no path defined");
        }
        this.d = a(gVar.c, gVar.d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.isAutoMirrored() : this.c.e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        g gVar = this.c;
        if (gVar == null) {
            return false;
        }
        f fVar = gVar.b;
        if (fVar.n == null) {
            fVar.n = Boolean.valueOf(fVar.g.a());
        }
        if (fVar.n.booleanValue()) {
            return true;
        }
        ColorStateList colorStateList = this.c.c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.g && super.mutate() == this) {
            g gVar = this.c;
            g gVar2 = new g();
            gVar2.c = null;
            gVar2.d = p;
            if (gVar != null) {
                gVar2.a = gVar.a;
                f fVar = new f(gVar.b);
                gVar2.b = fVar;
                if (gVar.b.e != null) {
                    fVar.e = new Paint(gVar.b.e);
                }
                if (gVar.b.d != null) {
                    gVar2.b.d = new Paint(gVar.b.d);
                }
                gVar2.c = gVar.c;
                gVar2.d = gVar.d;
                gVar2.e = gVar.e;
            }
            this.c = gVar2;
            this.g = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        g gVar = this.c;
        ColorStateList colorStateList = gVar.c;
        if (colorStateList == null || (mode = gVar.d) == null) {
            z = false;
        } else {
            this.d = a(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        f fVar = gVar.b;
        if (fVar.n == null) {
            fVar.n = Boolean.valueOf(fVar.g.a());
        }
        if (fVar.n.booleanValue()) {
            boolean zB = gVar.b.g.b(iArr);
            gVar.k |= zB;
            if (zB) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAlpha(i);
            return;
        }
        f fVar = this.c.b;
        if (fVar.l != i) {
            fVar.l = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.c.e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setTint(i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
            return;
        }
        g gVar = this.c;
        if (gVar.c != colorStateList) {
            gVar.c = colorStateList;
            this.d = a(colorStateList, gVar.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.b;
        if (drawable != null) {
            b2.i(drawable, mode);
            return;
        }
        g gVar = this.c;
        if (gVar.d != mode) {
            gVar.d = mode;
            this.d = a(gVar.c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.b;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
