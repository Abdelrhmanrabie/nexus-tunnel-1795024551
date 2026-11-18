package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class rv0 {
    public static rv0 i;
    public WeakHashMap a;
    public o01 b;
    public z11 c;
    public final WeakHashMap d = new WeakHashMap(0);
    public TypedValue e;
    public boolean f;
    public hg g;
    public static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    public static final c j = new c(6);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends vf0 {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d {
        public final /* synthetic */ int G0;

        public /* synthetic */ d(int i) {
            this.G0 = i;
        }

        public final Drawable a(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws Throwable {
            int i = this.G0;
            try {
                if (i == 0) {
                    String classAttribute = attributeSet.getClassAttribute();
                    if (classAttribute != null) {
                        Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(null).newInstance(null);
                        drawable.inflate(context.getResources(), xmlResourceParser, attributeSet, theme);
                        return drawable;
                    }
                    return null;
                }
                if (i == 1) {
                    return s3.g(context, theme, context.getResources(), attributeSet, xmlResourceParser);
                }
                if (i != 2) {
                    Resources resources = context.getResources();
                    cd1 cd1Var = new cd1();
                    cd1Var.inflate(resources, xmlResourceParser, attributeSet, theme);
                    return cd1Var;
                }
                Resources resources2 = context.getResources();
                t3 t3Var = new t3(context);
                t3Var.inflate(resources2, xmlResourceParser, attributeSet, theme);
                return t3Var;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized rv0 d() {
        try {
            if (i == null) {
                rv0 rv0Var = new rv0();
                i = rv0Var;
                j(rv0Var);
            }
        } catch (Throwable th) {
            throw th;
        }
        return i;
    }

    public static synchronized PorterDuffColorFilter h(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        c cVar = j;
        cVar.getClass();
        int i3 = (i2 + 31) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) cVar.get(Integer.valueOf(mode.hashCode() + i3));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
        }
        return porterDuffColorFilter;
    }

    public static void j(rv0 rv0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            rv0Var.a("vector", new d(3));
            rv0Var.a("animated-vector", new d(2));
            rv0Var.a("animated-selector", new d(1));
            rv0Var.a("drawable", new d(0));
        }
    }

    public final void a(String str, d dVar) {
        if (this.b == null) {
            this.b = new o01();
        }
        this.b.put(str, dVar);
    }

    public final synchronized void b(Context context, long j2, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                qf0 qf0Var = (qf0) this.d.get(context);
                if (qf0Var == null) {
                    qf0Var = new qf0();
                    this.d.put(context, qf0Var);
                }
                qf0Var.g(j2, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0104  */
    public final Drawable c(Context context, int i2) {
        LayerDrawable layerDrawable;
        int i3;
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        context.getResources().getValue(i2, typedValue, true);
        long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable drawableE = e(context, j2);
        if (drawableE != null) {
            return drawableE;
        }
        if (this.g == null) {
            layerDrawable = null;
        } else if (i2 == R.drawable.s) {
            layerDrawable = new LayerDrawable(new Drawable[]{f(context, R.drawable.r), f(context, R.drawable.t)});
        } else {
            if (i2 == R.drawable.aq) {
                i3 = R.dimen.aw;
            } else if (i2 == R.drawable.ap) {
                i3 = R.dimen.ax;
            } else if (i2 == R.drawable.ar) {
                i3 = R.dimen.ay;
            } else {
                layerDrawable = null;
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i3);
            Drawable drawableF = f(context, R.drawable.b2);
            Drawable drawableF2 = f(context, R.drawable.b3);
            if ((drawableF instanceof BitmapDrawable) && drawableF.getIntrinsicWidth() == dimensionPixelSize && drawableF.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableF;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableF.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableF.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableF2 instanceof BitmapDrawable) && drawableF2.getIntrinsicWidth() == dimensionPixelSize && drawableF2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableF2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableF2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableF2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, android.R.id.background);
            layerDrawable.setId(1, android.R.id.secondaryProgress);
            layerDrawable.setId(2, android.R.id.progress);
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, j2, layerDrawable);
        }
        return layerDrawable;
    }

    public final synchronized Drawable e(Context context, long j2) {
        qf0 qf0Var = (qf0) this.d.get(context);
        if (qf0Var == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) qf0Var.f(j2, null);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int iE = e.e(qf0Var.c, qf0Var.f, j2);
            if (iE >= 0) {
                Object[] objArr = qf0Var.d;
                Object obj = objArr[iE];
                Object obj2 = qf0.g;
                if (obj != obj2) {
                    objArr[iE] = obj2;
                    qf0Var.b = true;
                }
            }
        }
        return null;
    }

    public final synchronized Drawable f(Context context, int i2) {
        return g(context, i2, false);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:86:0x0174 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:3:0x0001, B:15:0x002a, B:17:0x002f, B:19:0x0035, B:21:0x003b, B:24:0x0049, B:28:0x005a, B:30:0x005e, B:31:0x0065, B:55:0x00dc, B:57:0x00e2, B:59:0x00e8, B:61:0x00ee, B:63:0x00f4, B:64:0x00f8, B:71:0x0109, B:69:0x0105, B:73:0x010e, B:77:0x0122, B:85:0x0162, B:84:0x014a, B:86:0x0174, B:91:0x017f, B:34:0x007f, B:36:0x0083, B:38:0x008f, B:39:0x0097, B:44:0x00a3, B:46:0x00b6, B:48:0x00c0, B:49:0x00c9, B:50:0x00d0, B:52:0x00d3, B:27:0x0053, B:6:0x0007, B:8:0x0012, B:10:0x0016, B:95:0x0185, B:96:0x018e), top: B:100:0x0001 }] */
    public final synchronized Drawable g(Context context, int i2, boolean z) {
        Drawable drawableMutate;
        LayerDrawable layerDrawable;
        PorterDuff.Mode mode;
        Drawable drawableFindDrawableByLayerId;
        int iC;
        int next;
        try {
            if (!this.f) {
                this.f = true;
                Drawable drawableF = f(context, R.drawable.bg);
                if (drawableF == null || (!(drawableF instanceof cd1) && !"android.graphics.drawable.VectorDrawable".equals(drawableF.getClass().getName()))) {
                    this.f = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            o01 o01Var = this.b;
            PorterDuff.Mode mode2 = null;
            if (o01Var == null || o01Var.isEmpty()) {
                drawableMutate = null;
            } else {
                z11 z11Var = this.c;
                if (z11Var != null) {
                    String str = (String) z11Var.e(i2, null);
                    if ("appcompat_skip_skip".equals(str) || (str != null && this.b.getOrDefault(str, null) == null)) {
                        drawableMutate = null;
                    }
                } else {
                    this.c = new z11();
                }
                if (this.e == null) {
                    this.e = new TypedValue();
                }
                TypedValue typedValue = this.e;
                Resources resources = context.getResources();
                resources.getValue(i2, typedValue, true);
                long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
                drawableMutate = e(context, j2);
                if (drawableMutate == null) {
                    CharSequence charSequence = typedValue.string;
                    if (charSequence != null && charSequence.toString().endsWith(".xml")) {
                        try {
                            XmlResourceParser xml = resources.getXml(i2);
                            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                            do {
                                next = xml.next();
                                if (next == 2) {
                                    break;
                                }
                            } while (next != 1);
                            if (next != 2) {
                                throw new XmlPullParserException("No start tag found");
                            }
                            String name = xml.getName();
                            this.c.a(i2, name);
                            d dVar = (d) this.b.getOrDefault(name, null);
                            if (dVar != null) {
                                drawableMutate = dVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                            }
                            if (drawableMutate != null) {
                                drawableMutate.setChangingConfigurations(typedValue.changingConfigurations);
                                b(context, j2, drawableMutate);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (drawableMutate == null) {
                        this.c.a(i2, "appcompat_skip_skip");
                    }
                }
            }
            if (drawableMutate == null) {
                drawableMutate = c(context, i2);
            }
            if (drawableMutate == null) {
                drawableMutate = context.getDrawable(i2);
            }
            if (drawableMutate != null) {
                ColorStateList colorStateListI = i(context, i2);
                if (colorStateListI != null) {
                    if (fp.a(drawableMutate)) {
                        drawableMutate = drawableMutate.mutate();
                    }
                    drawableMutate.setTintList(colorStateListI);
                    if (this.g != null && i2 == R.drawable.b4) {
                        mode2 = PorterDuff.Mode.MULTIPLY;
                    }
                    if (mode2 != null) {
                        drawableMutate.setTintMode(mode2);
                    }
                } else {
                    if (this.g != null) {
                        if (i2 == R.drawable.az) {
                            layerDrawable = (LayerDrawable) drawableMutate;
                            Drawable drawableFindDrawableByLayerId2 = layerDrawable.findDrawableByLayerId(android.R.id.background);
                            int iC2 = j61.c(context, R.style.g6);
                            mode = o5.b;
                            hg.d(drawableFindDrawableByLayerId2, iC2, mode);
                            drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress);
                            iC = j61.c(context, R.style.g6);
                        } else if (i2 == R.drawable.aq || i2 == R.drawable.ap || i2 == R.drawable.ar) {
                            layerDrawable = (LayerDrawable) drawableMutate;
                            Drawable drawableFindDrawableByLayerId3 = layerDrawable.findDrawableByLayerId(android.R.id.background);
                            int iB = j61.b(context, R.style.g6);
                            mode = o5.b;
                            hg.d(drawableFindDrawableByLayerId3, iB, mode);
                            drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress);
                            iC = j61.c(context, R.style.g4);
                        } else if (!m(context, drawableMutate, i2)) {
                        }
                        hg.d(drawableFindDrawableByLayerId, iC, mode);
                        hg.d(layerDrawable.findDrawableByLayerId(android.R.id.progress), j61.c(context, R.style.g4), mode);
                    } else if (!m(context, drawableMutate, i2) || !z) {
                    }
                    drawableMutate = mode2;
                }
                mode2 = drawableMutate;
                drawableMutate = mode2;
            }
            if (drawableMutate != null) {
                fp.b(drawableMutate);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableMutate;
    }

    public final synchronized ColorStateList i(Context context, int i2) {
        ColorStateList colorStateList;
        z11 z11Var;
        try {
            WeakHashMap weakHashMap = this.a;
            ColorStateList colorStateListC = null;
            colorStateList = (weakHashMap == null || (z11Var = (z11) weakHashMap.get(context)) == null) ? null : (ColorStateList) z11Var.e(i2, null);
            if (colorStateList == null) {
                hg hgVar = this.g;
                if (hgVar != null) {
                    colorStateListC = hgVar.c(context, i2);
                }
                if (colorStateListC != null) {
                    if (this.a == null) {
                        this.a = new WeakHashMap();
                    }
                    z11 z11Var2 = (z11) this.a.get(context);
                    if (z11Var2 == null) {
                        z11Var2 = new z11();
                        this.a.put(context, z11Var2);
                    }
                    z11Var2.a(i2, colorStateListC);
                }
                colorStateList = colorStateListC;
            }
        } catch (Throwable th) {
            throw th;
        }
        return colorStateList;
    }

    public final synchronized void k(Context context) {
        qf0 qf0Var = (qf0) this.d.get(context);
        if (qf0Var != null) {
            qf0Var.c();
        }
    }

    public final synchronized void l(hg hgVar) {
        this.g = hgVar;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0058  */
    /* JADX WARN: Code duplicated, block: B:25:0x005e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0073  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final boolean m(Context context, Drawable drawable, int i2) {
        boolean z;
        int i3;
        PorterDuff.Mode mode;
        int i4;
        int iRound;
        int i5;
        int iC;
        hg hgVar = this.g;
        if (hgVar != null) {
            PorterDuff.Mode mode2 = o5.b;
            if (hg.a((int[]) hgVar.a, i2)) {
                i5 = R.style.g6;
            } else if (hg.a((int[]) hgVar.c, i2)) {
                i5 = R.style.g4;
            } else {
                if (hg.a((int[]) hgVar.d, i2)) {
                    mode2 = PorterDuff.Mode.MULTIPLY;
                } else {
                    if (i2 == R.drawable.ac) {
                        mode = mode2;
                        i4 = 16842800;
                        iRound = Math.round(40.8f);
                        z = true;
                    } else {
                        if (i2 != R.drawable.v) {
                            z = false;
                            i3 = 0;
                        }
                        mode = mode2;
                        i4 = i3;
                        iRound = -1;
                    }
                    if (z) {
                        if (fp.a(drawable)) {
                            drawable = drawable.mutate();
                        }
                        iC = j61.c(context, i4);
                        synchronized (o5.class) {
                            PorterDuffColorFilter porterDuffColorFilterH = h(iC, mode);
                        }
                        drawable.setColorFilter(porterDuffColorFilterH);
                        if (iRound != -1) {
                            drawable.setAlpha(iRound);
                        }
                        return true;
                    }
                }
                i5 = android.R.attr.colorBackground;
            }
            i3 = i5;
            z = true;
            mode = mode2;
            i4 = i3;
            iRound = -1;
            if (z) {
                if (fp.a(drawable)) {
                    drawable = drawable.mutate();
                }
                iC = j61.c(context, i4);
                synchronized (o5.class) {
                    PorterDuffColorFilter porterDuffColorFilterH2 = h(iC, mode);
                    drawable.setColorFilter(porterDuffColorFilterH2);
                    if (iRound != -1) {
                        drawable.setAlpha(iRound);
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
