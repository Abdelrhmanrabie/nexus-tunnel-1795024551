package defpackage;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.StateSet;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class s3 extends Drawable implements Drawable.Callback {
    public static final /* synthetic */ int $r8$clinit = 0;
    public b b;
    public Rect c;
    public Drawable d;
    public Drawable f;
    public boolean i;
    public boolean n;
    public as0 o;
    public long p;
    public long q;
    public ep$b r;
    public b t;
    public boolean u;
    public b v;
    public b2 w;
    public boolean z;
    public int g = 255;
    public int j = -1;
    public int x = -1;
    public int y = -1;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends b2 {
        public final /* synthetic */ int G0;
        public final Animatable a;

        public /* synthetic */ a(Animatable animatable, int i) {
            this.G0 = i;
            this.a = animatable;
        }

        @Override // defpackage.b2
        public final void c() {
            int i = this.G0;
            Animatable animatable = this.a;
            if (i != 0) {
                ((t3) animatable).start();
            } else {
                animatable.start();
            }
        }

        @Override // defpackage.b2
        public final void d() {
            int i = this.G0;
            Animatable animatable = this.a;
            if (i != 0) {
                ((t3) animatable).stop();
            } else {
                animatable.stop();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends Drawable.ConstantState {
        public boolean A;
        public ColorFilter B;
        public boolean C;
        public ColorStateList D;
        public PorterDuff.Mode E;
        public boolean F;
        public boolean G;
        public int[][] H;
        public qf0 I;
        public z11 J;
        public final s3 a;
        public Resources b;
        public int c;
        public int d;
        public int e;
        public SparseArray f;
        public Drawable[] g;
        public int h;
        public boolean i;
        public boolean j;
        public Rect k;
        public boolean l;
        public boolean m;
        public int n;
        public int o;
        public int p;
        public int q;
        public boolean r;
        public int s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public int x;
        public int y;
        public int z;

        public b(b bVar, s3 s3Var, Resources resources) {
            z11 z11Var;
            this.i = false;
            this.l = false;
            this.w = true;
            this.y = 0;
            this.z = 0;
            this.a = s3Var;
            this.b = resources != null ? resources : bVar != null ? bVar.b : null;
            int i = bVar != null ? bVar.c : 0;
            int i2 = s3.$r8$clinit;
            i = resources != null ? resources.getDisplayMetrics().densityDpi : i;
            i = i == 0 ? 160 : i;
            this.c = i;
            if (bVar != null) {
                this.d = bVar.d;
                this.e = bVar.e;
                this.u = true;
                this.v = true;
                this.i = bVar.i;
                this.l = bVar.l;
                this.w = bVar.w;
                this.x = bVar.x;
                this.y = bVar.y;
                this.z = bVar.z;
                this.A = bVar.A;
                this.B = bVar.B;
                this.C = bVar.C;
                this.D = bVar.D;
                this.E = bVar.E;
                this.F = bVar.F;
                this.G = bVar.G;
                if (bVar.c == i) {
                    if (bVar.j) {
                        this.k = bVar.k != null ? new Rect(bVar.k) : null;
                        this.j = true;
                    }
                    if (bVar.m) {
                        this.n = bVar.n;
                        this.o = bVar.o;
                        this.p = bVar.p;
                        this.q = bVar.q;
                        this.m = true;
                    }
                }
                if (bVar.r) {
                    this.s = bVar.s;
                    this.r = true;
                }
                if (bVar.t) {
                    this.t = true;
                }
                Drawable[] drawableArr = bVar.g;
                this.g = new Drawable[drawableArr.length];
                this.h = bVar.h;
                SparseArray sparseArray = bVar.f;
                this.f = sparseArray != null ? sparseArray.clone() : new SparseArray(this.h);
                int i3 = this.h;
                for (int i4 = 0; i4 < i3; i4++) {
                    Drawable drawable = drawableArr[i4];
                    if (drawable != null) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState != null) {
                            this.f.put(i4, constantState);
                        } else {
                            this.g[i4] = drawableArr[i4];
                        }
                    }
                }
            } else {
                this.g = new Drawable[10];
                this.h = 0;
            }
            if (bVar != null) {
                this.H = bVar.H;
            } else {
                this.H = new int[this.g.length][];
            }
            if (bVar != null) {
                this.I = bVar.I;
                z11Var = bVar.J;
            } else {
                this.I = new qf0();
                z11Var = new z11();
            }
            this.J = z11Var;
        }

        public final int a(Drawable drawable) {
            int i = this.h;
            Drawable[] drawableArr = this.g;
            if (i >= drawableArr.length) {
                int i2 = i + 10;
                Drawable[] drawableArr2 = new Drawable[i2];
                System.arraycopy(drawableArr, 0, drawableArr2, 0, i);
                this.g = drawableArr2;
                int[][] iArr = new int[i2][];
                System.arraycopy(this.H, 0, iArr, 0, i);
                this.H = iArr;
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.a);
            this.g[i] = drawable;
            this.h++;
            this.e = drawable.getChangingConfigurations() | this.e;
            this.r = false;
            this.t = false;
            this.k = null;
            this.j = false;
            this.m = false;
            this.u = false;
            return i;
        }

        public final void b() {
            this.m = true;
            c();
            int i = this.h;
            Drawable[] drawableArr = this.g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.n) {
                    this.n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                    this.p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                    this.q = minimumHeight;
                }
            }
        }

        public final void c() {
            SparseArray sparseArray = this.f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    int iKeyAt = this.f.keyAt(i);
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.f.valueAt(i);
                    Drawable[] drawableArr = this.g;
                    Drawable drawableNewDrawable = constantState.newDrawable(this.b);
                    drawableNewDrawable.setLayoutDirection(this.x);
                    Drawable drawableMutate = drawableNewDrawable.mutate();
                    drawableMutate.setCallback(this.a);
                    drawableArr[iKeyAt] = drawableMutate;
                }
                this.f = null;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            int i = this.h;
            Drawable[] drawableArr = this.g;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable == null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.f.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (b2.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        public final Drawable d(int i) {
            int iIndexOfKey;
            Drawable drawable = this.g[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray sparseArray = this.f;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f.valueAt(iIndexOfKey)).newDrawable(this.b);
            drawableNewDrawable.setLayoutDirection(this.x);
            Drawable drawableMutate = drawableNewDrawable.mutate();
            drawableMutate.setCallback(this.a);
            this.g[i] = drawableMutate;
            this.f.removeAt(iIndexOfKey);
            if (this.f.size() == 0) {
                this.f = null;
            }
            return drawableMutate;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return this.d | this.e;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new s3(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new s3(this, resources);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d extends b2 {
        public final ObjectAnimator a;
        public final boolean b;

        public d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            e eVar = new e();
            int numberOfFrames2 = animationDrawable.getNumberOfFrames();
            eVar.b = numberOfFrames2;
            int[] iArr = eVar.a;
            if (iArr == null || iArr.length < numberOfFrames2) {
                eVar.a = new int[numberOfFrames2];
            }
            int[] iArr2 = eVar.a;
            int i3 = 0;
            for (int i4 = 0; i4 < numberOfFrames2; i4++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames2 - i4) - 1 : i4);
                iArr2[i4] = duration;
                i3 += duration;
            }
            eVar.c = i3;
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            objectAnimatorOfInt.setAutoCancel(true);
            objectAnimatorOfInt.setDuration(i3);
            objectAnimatorOfInt.setInterpolator(eVar);
            this.b = z2;
            this.a = objectAnimatorOfInt;
        }

        @Override // defpackage.b2
        public final boolean a() {
            return this.b;
        }

        @Override // defpackage.b2
        public final void b() {
            this.a.reverse();
        }

        @Override // defpackage.b2
        public final void c() {
            this.a.start();
        }

        @Override // defpackage.b2
        public final void d() {
            this.a.cancel();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class e implements TimeInterpolator {
        public int[] a;
        public int b;
        public int c;

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = this.c;
            int i = (int) ((f * f2) + 0.5f);
            int i2 = this.b;
            int[] iArr = this.a;
            int i3 = 0;
            while (i3 < i2) {
                int i4 = iArr[i3];
                if (i < i4) {
                    break;
                }
                i -= i4;
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / f2 : 0.0f);
        }
    }

    public s3(b bVar, Resources resources) {
        b bVar2 = new b(bVar, this, resources);
        this.b = bVar2;
        int i = this.j;
        if (i >= 0) {
            Drawable drawableD = bVar2.d(i);
            this.d = drawableD;
            if (drawableD != null) {
                c(drawableD);
            }
        }
        this.f = null;
        this.t = bVar2;
        this.v = bVar2;
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static s3 g(Context context, Resources.Theme theme, Resources resources, AttributeSet attributeSet, XmlResourceParser xmlResourceParser) throws Throwable {
        int depth;
        int next;
        int next2;
        Context context2 = context;
        Resources.Theme theme2 = theme;
        String name = xmlResourceParser.getName();
        if (!name.equals("animated-selector")) {
            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        s3 s3Var = new s3(null, null);
        TypedArray typedArrayH = ak.h(resources, theme2, attributeSet, defpackage.e.f23a);
        int i = 1;
        s3Var.setVisible(typedArrayH.getBoolean(1, true), true);
        b bVar = s3Var.v;
        bVar.d |= typedArrayH.getChangingConfigurations();
        int i2 = 2;
        bVar.i = typedArrayH.getBoolean(2, bVar.i);
        int i3 = 3;
        bVar.l = typedArrayH.getBoolean(3, bVar.l);
        bVar.y = typedArrayH.getInt(4, bVar.y);
        bVar.z = typedArrayH.getInt(5, bVar.z);
        boolean z = false;
        s3Var.setDither(typedArrayH.getBoolean(0, bVar.w));
        b bVar2 = s3Var.b;
        if (resources != null) {
            bVar2.b = resources;
            int i4 = resources.getDisplayMetrics().densityDpi;
            if (i4 == 0) {
                i4 = 160;
            }
            int i5 = bVar2.c;
            bVar2.c = i4;
            if (i5 != i4) {
                bVar2.m = false;
                bVar2.j = false;
            }
        } else {
            bVar2.getClass();
        }
        typedArrayH.recycle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next3 = xmlResourceParser.next();
            if (next3 == i || ((depth = xmlResourceParser.getDepth()) < depth2 && next3 == i3)) {
                break;
            }
            if (next3 == i2 && depth <= depth2) {
                if (xmlResourceParser.getName().equals("item")) {
                    TypedArray typedArrayH2 = ak.h(resources, theme2, attributeSet, defpackage.e.f27b$1);
                    int resourceId = typedArrayH2.getResourceId(z ? 1 : 0, z ? 1 : 0);
                    int resourceId2 = typedArrayH2.getResourceId(i, -1);
                    Drawable drawableF = resourceId2 > 0 ? rv0.d().f(context2, resourceId2) : null;
                    typedArrayH2.recycle();
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr = new int[attributeCount];
                    int i6 = z ? 1 : 0;
                    for (int i7 = i6 == true ? 1 : 0; i7 < attributeCount; i7++) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(i7);
                        if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                            int i8 = (i6 == true ? 1 : 0) + 1;
                            if (!attributeSet.getAttributeBooleanValue(i7, z)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr[i6 == true ? 1 : 0] = attributeNameResource;
                            i6 = i8;
                        }
                    }
                    int[] iArrTrimStateSet = StateSet.trimStateSet(iArr, i6 == true ? 1 : 0);
                    if (drawableF == null) {
                        do {
                            next2 = xmlResourceParser.next();
                        } while (next2 == 4);
                        if (next2 != 2) {
                            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                        if (xmlResourceParser.getName().equals("vector")) {
                            drawableF = new cd1();
                            drawableF.inflate(resources, xmlResourceParser, attributeSet, theme2);
                        } else {
                            drawableF = Drawable.createFromXmlInner(resources, xmlResourceParser, attributeSet, theme2);
                        }
                    }
                    if (drawableF == null) {
                        throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                    b bVar3 = s3Var.v;
                    int iA = bVar3.a(drawableF);
                    bVar3.H[iA] = iArrTrimStateSet;
                    bVar3.J.f(iA, Integer.valueOf(resourceId));
                } else if (xmlResourceParser.getName().equals("transition")) {
                    TypedArray typedArrayH3 = ak.h(resources, theme2, attributeSet, defpackage.e.f30c$1);
                    int resourceId3 = typedArrayH3.getResourceId(2, -1);
                    int resourceId4 = typedArrayH3.getResourceId(1, -1);
                    int resourceId5 = typedArrayH3.getResourceId(z ? 1 : 0, -1);
                    Drawable drawableF2 = resourceId5 > 0 ? rv0.d().f(context2, resourceId5) : null;
                    boolean z2 = typedArrayH3.getBoolean(3, z);
                    typedArrayH3.recycle();
                    if (drawableF2 == null) {
                        do {
                            next = xmlResourceParser.next();
                        } while (next == 4);
                        if (next != 2) {
                            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                        if (xmlResourceParser.getName().equals("animated-vector")) {
                            drawableF2 = new t3(context2);
                            drawableF2.inflate(resources, xmlResourceParser, attributeSet, theme2);
                        } else {
                            drawableF2 = Drawable.createFromXmlInner(resources, xmlResourceParser, attributeSet, theme2);
                        }
                    }
                    if (drawableF2 == null) {
                        throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                    if (resourceId3 == -1 || resourceId4 == -1) {
                        throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
                    }
                    b bVar4 = s3Var.v;
                    int iA2 = bVar4.a(drawableF2);
                    long j = resourceId3;
                    long j2 = resourceId4;
                    long j3 = j2 | (j << 32);
                    long j4 = z2 ? 8589934592L : 0L;
                    long j5 = iA2;
                    bVar4.I.a(j3, Long.valueOf(j5 | j4));
                    if (z2) {
                        bVar4.I.a((j2 << 32) | j, Long.valueOf(j5 | 4294967296L | j4));
                    }
                }
                context2 = context;
                theme2 = theme;
                i = 1;
                z = false;
                i2 = 2;
                i3 = 3;
            }
        }
        s3Var.onStateChange(s3Var.getState());
        return s3Var;
    }

    public final void a(boolean z) {
        boolean z2;
        boolean z3 = true;
        this.i = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable = this.d;
        if (drawable != null) {
            long j = this.p;
            if (j == 0) {
                z2 = false;
            } else if (j <= jUptimeMillis) {
                drawable.setAlpha(this.g);
                this.p = 0L;
                z2 = false;
            } else {
                drawable.setAlpha(((255 - (((int) ((j - jUptimeMillis) * 255)) / this.b.y)) * this.g) / 255);
                z2 = true;
            }
        } else {
            this.p = 0L;
            z2 = false;
        }
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            long j2 = this.q;
            if (j2 == 0) {
                z3 = z2;
            } else if (j2 <= jUptimeMillis) {
                drawable2.setVisible(false, false);
                this.f = null;
                this.q = 0L;
                z3 = z2;
            } else {
                drawable2.setAlpha(((((int) ((j2 - jUptimeMillis) * 255)) / this.b.z) * this.g) / 255);
            }
        } else {
            this.q = 0L;
            z3 = z2;
        }
        if (z && z3) {
            scheduleSelf(this.o, jUptimeMillis + 16);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        applyTheme$ep(theme);
        onStateChange(getState());
    }

    public final void applyTheme$ep(Resources.Theme theme) {
        b bVar = this.b;
        if (theme == null) {
            bVar.getClass();
            return;
        }
        bVar.c();
        int i = bVar.h;
        Drawable[] drawableArr = bVar.g;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            if (drawable != null && drawable.canApplyTheme()) {
                drawableArr[i2].applyTheme(theme);
                bVar.e |= drawableArr[i2].getChangingConfigurations();
            }
        }
        Resources resources = theme.getResources();
        if (resources != null) {
            bVar.b = resources;
            int i3 = resources.getDisplayMetrics().densityDpi;
            if (i3 == 0) {
                i3 = 160;
            }
            int i4 = bVar.c;
            bVar.c = i3;
            if (i4 != i3) {
                bVar.m = false;
                bVar.j = false;
            }
        }
    }

    public final void c(Drawable drawable) {
        if (this.r == null) {
            this.r = new ep$b();
        }
        ep$b ep_b = this.r;
        ep_b.b = drawable.getCallback();
        drawable.setCallback(ep_b);
        try {
            if (this.b.y <= 0 && this.i) {
                drawable.setAlpha(this.g);
            }
            b bVar = this.b;
            if (bVar.C) {
                drawable.setColorFilter(bVar.B);
            } else {
                if (bVar.F) {
                    drawable.setTintList(bVar.D);
                }
                b bVar2 = this.b;
                if (bVar2.G) {
                    drawable.setTintMode(bVar2.E);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.b.w);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            drawable.setLayoutDirection(getLayoutDirection());
            drawable.setAutoMirrored(this.b.A);
            Rect rect = this.c;
            if (rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            ep$b ep_b2 = this.r;
            Drawable.Callback callback = (Drawable.Callback) ep_b2.b;
            ep_b2.b = null;
            drawable.setCallback(callback);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        return this.b.canApplyTheme();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    public final boolean d(int i) {
        if (i == this.j) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.b.z > 0) {
            Drawable drawable = this.f;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.d;
            if (drawable2 != null) {
                this.f = drawable2;
                this.q = ((long) this.b.z) + jUptimeMillis;
            } else {
                this.f = null;
                this.q = 0L;
            }
        } else {
            Drawable drawable3 = this.d;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i >= 0) {
            b bVar = this.b;
            if (i < bVar.h) {
                Drawable drawableD = bVar.d(i);
                this.d = drawableD;
                this.j = i;
                if (drawableD != null) {
                    int i2 = this.b.y;
                    if (i2 > 0) {
                        this.p = jUptimeMillis + ((long) i2);
                    }
                    c(drawableD);
                }
            } else {
                this.d = null;
                this.j = -1;
            }
        } else {
            this.d = null;
            this.j = -1;
        }
        if (this.p != 0 || this.q != 0) {
            as0 as0Var = this.o;
            if (as0Var == null) {
                this.o = new as0(2, this);
            } else {
                unscheduleSelf(as0Var);
            }
            a(true);
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        b bVar = this.b;
        return changingConfigurations | bVar.e | bVar.d;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        boolean z;
        b bVar = this.b;
        if (!bVar.u) {
            bVar.c();
            bVar.u = true;
            int i = bVar.h;
            Drawable[] drawableArr = bVar.g;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    bVar.v = true;
                    z = true;
                    break;
                }
                if (drawableArr[i2].getConstantState() == null) {
                    bVar.v = false;
                    z = false;
                    break;
                }
                i2++;
            }
        } else {
            z = bVar.v;
        }
        if (!z) {
            return null;
        }
        this.b.d = getChangingConfigurations();
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getHotspotBounds(Rect rect) {
        Rect rect2 = this.c;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        b bVar = this.b;
        if (bVar.l) {
            if (!bVar.m) {
                bVar.b();
            }
            return bVar.o;
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        b bVar = this.b;
        if (bVar.l) {
            if (!bVar.m) {
                bVar.b();
            }
            return bVar.n;
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        b bVar = this.b;
        if (bVar.l) {
            if (!bVar.m) {
                bVar.b();
            }
            return bVar.q;
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        b bVar = this.b;
        if (bVar.l) {
            if (!bVar.m) {
                bVar.b();
            }
            return bVar.p;
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.d;
        int opacity = -2;
        if (drawable != null && drawable.isVisible()) {
            b bVar = this.b;
            if (bVar.r) {
                return bVar.s;
            }
            bVar.c();
            int i = bVar.h;
            Drawable[] drawableArr = bVar.g;
            opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            bVar.s = opacity;
            bVar.r = true;
        }
        return opacity;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        b bVar = this.b;
        boolean padding = false;
        Rect rect2 = null;
        if (!bVar.i) {
            Rect rect3 = bVar.k;
            if (rect3 != null || bVar.j) {
                rect2 = rect3;
            } else {
                bVar.c();
                Rect rect4 = new Rect();
                int i = bVar.h;
                Drawable[] drawableArr = bVar.g;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i3 = rect4.left;
                        if (i3 > rect2.left) {
                            rect2.left = i3;
                        }
                        int i4 = rect4.top;
                        if (i4 > rect2.top) {
                            rect2.top = i4;
                        }
                        int i5 = rect4.right;
                        if (i5 > rect2.right) {
                            rect2.right = i5;
                        }
                        int i6 = rect4.bottom;
                        if (i6 > rect2.bottom) {
                            rect2.bottom = i6;
                        }
                    }
                }
                bVar.j = true;
                bVar.k = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            if ((rect2.left | rect2.top | rect2.bottom | rect2.right) != 0) {
                padding = true;
            }
        } else {
            Drawable drawable = this.d;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (this.b.A && getLayoutDirection() == 1) {
            int i7 = rect.left;
            rect.left = rect.right;
            rect.right = i7;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.r = false;
            bVar.t = false;
        }
        if (drawable != this.d || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.b.A;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        jumpToCurrentState$ep();
        b2 b2Var = this.w;
        if (b2Var != null) {
            b2Var.d();
            this.w = null;
            d(this.x);
            this.x = -1;
            this.y = -1;
        }
    }

    public final void jumpToCurrentState$ep() {
        boolean z;
        Drawable drawable = this.f;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.i) {
                this.d.setAlpha(this.g);
            }
        }
        if (this.q != 0) {
            this.q = 0L;
            z = true;
        }
        if (this.p != 0) {
            this.p = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.z) {
            mutate$v21();
            b bVar = this.v;
            bVar.I = bVar.I.clone();
            bVar.J = bVar.J.clone();
            this.z = true;
        }
        return this;
    }

    public final Drawable mutate$ep() {
        if (!this.n && super.mutate() == this) {
            b bVar = new b(this.v, this, null);
            bVar.I = bVar.I.clone();
            bVar.J = bVar.J.clone();
            this.b = bVar;
            int i = this.j;
            if (i >= 0) {
                Drawable drawableD = bVar.d(i);
                this.d = drawableD;
                if (drawableD != null) {
                    c(drawableD);
                }
            }
            this.f = null;
            this.t = bVar;
            this.v = bVar;
            this.n = true;
        }
        return this;
    }

    public final Drawable mutate$v21() {
        if (!this.u) {
            mutate$ep();
            b bVar = this.t;
            bVar.I = bVar.I.clone();
            bVar.J = bVar.J.clone();
            this.u = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        b bVar = this.b;
        int i2 = this.j;
        int i3 = bVar.h;
        Drawable[] drawableArr = bVar.g;
        boolean z = false;
        for (int i4 = 0; i4 < i3; i4++) {
            Drawable drawable = drawableArr[i4];
            if (drawable != null) {
                boolean layoutDirection = drawable.setLayoutDirection(i);
                if (i4 == i2) {
                    z = layoutDirection;
                }
            }
        }
        bVar.x = i;
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0069  */
    /* JADX WARN: Code duplicated, block: B:35:0x006e  */
    /* JADX WARN: Code duplicated, block: B:37:0x007c  */
    /* JADX WARN: Code duplicated, block: B:38:0x007e  */
    /* JADX WARN: Code duplicated, block: B:62:0x0119  */
    /* JADX WARN: Code duplicated, block: B:64:0x011f  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        b bVar;
        int iIntValue;
        int iIntValue2;
        b2 aVar;
        b bVar2 = this.v;
        int[][] iArr2 = bVar2.H;
        int i = bVar2.h;
        boolean z = false;
        z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                i2 = -1;
                break;
            }
            if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                break;
            }
            i2++;
        }
        if (i2 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int[][] iArr4 = bVar2.H;
            int i3 = bVar2.h;
            i2 = 0;
            while (true) {
                if (i2 >= i3) {
                    i2 = -1;
                    break;
                }
                if (StateSet.stateSetMatches(iArr4[i2], iArr3)) {
                    break;
                }
                i2++;
            }
        }
        int i4 = this.j;
        if (i2 != i4) {
            b2 b2Var = this.w;
            int i5 = 1;
            if (b2Var == null) {
                this.w = null;
                this.y = -1;
                this.x = -1;
                bVar = this.v;
                if (i4 < 0) {
                    bVar.getClass();
                    iIntValue = 0;
                } else {
                    iIntValue = ((Integer) bVar.J.e(i4, 0)).intValue();
                }
                if (i2 < 0) {
                    iIntValue2 = 0;
                } else {
                    iIntValue2 = ((Integer) bVar.J.e(i2, 0)).intValue();
                }
                if (iIntValue2 == 0 && iIntValue != 0) {
                    long j = (((long) iIntValue) << 32) | ((long) iIntValue2);
                    int iLongValue = (int) ((Long) bVar.I.f(j, -1L)).longValue();
                    if (iLongValue >= 0) {
                        boolean z2 = (((Long) bVar.I.f(j, -1L)).longValue() & 8589934592L) != 0;
                        d(iLongValue);
                        Drawable drawable = this.d;
                        if (drawable instanceof AnimationDrawable) {
                            aVar = new d((AnimationDrawable) drawable, (((Long) bVar.I.f(j, -1L)).longValue() & 4294967296L) != 0, z2);
                        } else if (drawable instanceof t3) {
                            aVar = new a((t3) drawable, i5);
                        } else if (drawable instanceof Animatable) {
                            aVar = new a((Animatable) drawable, false ? 1 : 0);
                        } else if (d(i2)) {
                            z = true;
                        }
                        aVar.c();
                        this.w = aVar;
                        this.y = i4;
                        this.x = i2;
                        z = true;
                    } else if (d(i2)) {
                        z = true;
                    }
                } else if (d(i2)) {
                    z = true;
                }
            } else {
                if (i2 != this.x) {
                    if (i2 == this.y && b2Var.a()) {
                        b2Var.b();
                        this.x = this.y;
                        this.y = i2;
                    } else {
                        i4 = this.x;
                        b2Var.d();
                        this.w = null;
                        this.y = -1;
                        this.x = -1;
                        bVar = this.v;
                        if (i4 < 0) {
                            bVar.getClass();
                            iIntValue = 0;
                        } else {
                            iIntValue = ((Integer) bVar.J.e(i4, 0)).intValue();
                        }
                        if (i2 < 0) {
                            iIntValue2 = 0;
                        } else {
                            iIntValue2 = ((Integer) bVar.J.e(i2, 0)).intValue();
                        }
                        if (iIntValue2 == 0) {
                            if (d(i2)) {
                            }
                        } else if (d(i2)) {
                        }
                    }
                }
                z = true;
            }
        }
        Drawable drawable2 = this.d;
        return drawable2 != null ? (drawable2.setState(iArr) ? 1 : 0) | z : z;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.d || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.i && this.g == i) {
            return;
        }
        this.i = true;
        this.g = i;
        Drawable drawable = this.d;
        if (drawable != null) {
            if (this.p == 0) {
                drawable.setAlpha(i);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        b bVar = this.b;
        if (bVar.A != z) {
            bVar.A = z;
            Drawable drawable = this.d;
            if (drawable != null) {
                drawable.setAutoMirrored(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        b bVar = this.b;
        bVar.C = true;
        if (bVar.B != colorFilter) {
            bVar.B = colorFilter;
            Drawable drawable = this.d;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        b bVar = this.b;
        if (bVar.w != z) {
            bVar.w = z;
            Drawable drawable = this.d;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f, float f2) {
        Drawable drawable = this.d;
        if (drawable != null) {
            b2.e(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.c;
        if (rect == null) {
            this.c = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            b2.f(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        b bVar = this.b;
        bVar.F = true;
        if (bVar.D != colorStateList) {
            bVar.D = colorStateList;
            this.d.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.b;
        bVar.G = true;
        if (bVar.E != mode) {
            bVar.E = mode;
            this.d.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible$ep = setVisible$ep(z, z2);
        b2 b2Var = this.w;
        if (b2Var != null && (visible$ep || z2)) {
            if (z) {
                b2Var.c();
                return visible$ep;
            }
            jumpToCurrentState();
        }
        return visible$ep;
    }

    public final boolean setVisible$ep(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.d || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
