package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import defpackage.g81;
import defpackage.qd1;
import defpackage.te1;
import defpackage.uh;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class a extends androidx.transition.h {
    public static final String[] b = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final b c;
    public static final c d;
    public static final d f;
    public static final e g;
    public static final f i;

    /* JADX INFO: renamed from: androidx.transition.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class C0028a extends Property<Drawable, PointF> {
        public final Rect a;

        public C0028a() {
            super(PointF.class, "boundsOrigin");
            this.a = new Rect();
        }

        @Override // android.util.Property
        public final PointF get(Drawable drawable) {
            Rect rect = this.a;
            drawable.copyBounds(rect);
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        public final void set(Drawable drawable, PointF pointF) {
            Drawable drawable2 = drawable;
            PointF pointF2 = pointF;
            Rect rect = this.a;
            drawable2.copyBounds(rect);
            rect.offsetTo(Math.round(pointF2.x), Math.round(pointF2.y));
            drawable2.setBounds(rect);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b extends Property<i, PointF> {
        public b() {
            super(PointF.class, "topLeft");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        public final void set(i iVar, PointF pointF) {
            i iVar2 = iVar;
            PointF pointF2 = pointF;
            iVar2.getClass();
            iVar2.a = Math.round(pointF2.x);
            int iRound = Math.round(pointF2.y);
            iVar2.b = iRound;
            int i = iVar2.f + 1;
            iVar2.f = i;
            if (i == iVar2.g) {
                te1.a(iVar2.e, iVar2.a, iRound, iVar2.c, iVar2.d);
                iVar2.f = 0;
                iVar2.g = 0;
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c extends Property<i, PointF> {
        public c() {
            super(PointF.class, "bottomRight");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        public final void set(i iVar, PointF pointF) {
            i iVar2 = iVar;
            PointF pointF2 = pointF;
            iVar2.getClass();
            iVar2.c = Math.round(pointF2.x);
            int iRound = Math.round(pointF2.y);
            iVar2.d = iRound;
            int i = iVar2.g + 1;
            iVar2.g = i;
            if (iVar2.f == i) {
                te1.a(iVar2.e, iVar2.a, iVar2.b, iVar2.c, iRound);
                iVar2.f = 0;
                iVar2.g = 0;
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d extends Property<View, PointF> {
        public d() {
            super(PointF.class, "bottomRight");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            te1.a(view2, view2.getLeft(), view2.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class e extends Property<View, PointF> {
        public e() {
            super(PointF.class, "topLeft");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            te1.a(view2, Math.round(pointF2.x), Math.round(pointF2.y), view2.getRight(), view2.getBottom());
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class f extends Property<View, PointF> {
        public f() {
            super(PointF.class, "position");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int iRound = Math.round(pointF2.x);
            int iRound2 = Math.round(pointF2.y);
            te1.a(view2, iRound, iRound2, view2.getWidth() + iRound, view2.getHeight() + iRound2);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class g extends AnimatorListenerAdapter {
        public g(i iVar) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class h extends androidx.transition.i {
        public boolean b = false;
        public final /* synthetic */ ViewGroup c;

        public h(ViewGroup viewGroup) {
            this.c = viewGroup;
        }

        @Override // androidx.transition.i, androidx.transition.h.g
        public final void onTransitionCancel() {
            uh.a(this.c, false);
            this.b = true;
        }

        @Override // androidx.transition.h.g
        public final void onTransitionEnd(androidx.transition.h hVar) {
            if (!this.b) {
                uh.a(this.c, false);
            }
            hVar.removeListener(this);
        }

        @Override // androidx.transition.i, androidx.transition.h.g
        public final void onTransitionPause() {
            uh.a(this.c, false);
        }

        @Override // androidx.transition.i, androidx.transition.h.g
        public final void onTransitionResume() {
            uh.a(this.c, true);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class i {
        public int a;
        public int b;
        public int c;
        public int d;
        public final View e;
        public int f;
        public int g;

        public i(View view) {
            this.e = view;
        }
    }

    static {
        new C0028a();
        c = new b();
        d = new c();
        f = new d();
        g = new e();
        i = new f();
    }

    public static void a(g81 g81Var) {
        View view = g81Var.b;
        WeakHashMap weakHashMap = qd1.a;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        HashMap map = g81Var.a;
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", g81Var.b.getParent());
    }

    @Override // androidx.transition.h
    public final void captureEndValues(g81 g81Var) {
        a(g81Var);
    }

    @Override // androidx.transition.h
    public final void captureStartValues(g81 g81Var) {
        a(g81Var);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0110  */
    @Override // androidx.transition.h
    public final Animator createAnimator(ViewGroup viewGroup, g81 g81Var, g81 g81Var2) {
        int i2;
        a aVar;
        Path path;
        Property property;
        Animator animatorOfObject;
        if (g81Var != null && g81Var2 != null) {
            HashMap map = g81Var.a;
            HashMap map2 = g81Var2.a;
            ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
            ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
            if (viewGroup2 != null && viewGroup3 != null) {
                View view = g81Var2.b;
                Rect rect = (Rect) map.get("android:changeBounds:bounds");
                Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
                int i3 = rect.left;
                int i4 = rect2.left;
                int i5 = rect.top;
                int i6 = rect2.top;
                int i7 = rect.right;
                int i8 = rect2.right;
                int i9 = rect.bottom;
                int i10 = rect2.bottom;
                int i11 = i7 - i3;
                int i12 = i9 - i5;
                int i13 = i8 - i4;
                int i14 = i10 - i6;
                Rect rect3 = (Rect) map.get("android:changeBounds:clip");
                Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
                if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                    i2 = 0;
                } else {
                    i2 = (i3 == i4 && i5 == i6) ? 0 : 1;
                    if (i7 != i8 || i9 != i10) {
                        i2++;
                    }
                }
                if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                    i2++;
                }
                int i15 = i2;
                if (i15 > 0) {
                    te1.a(view, i3, i5, i7, i9);
                    if (i15 == 2) {
                        if (i11 == i13 && i12 == i14) {
                            aVar = this;
                            path = aVar.mPathMotion.getPath(i3, i5, i4, i6);
                            property = i;
                        } else {
                            aVar = this;
                            i iVar = new i(view);
                            ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(iVar, c, (TypeConverter) null, aVar.mPathMotion.getPath(i3, i5, i4, i6));
                            ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(iVar, d, (TypeConverter) null, aVar.mPathMotion.getPath(i7, i9, i8, i10));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(objectAnimatorOfObject, objectAnimatorOfObject2);
                            animatorSet.addListener(new g(iVar));
                            animatorOfObject = animatorSet;
                        }
                        if (view.getParent() instanceof ViewGroup) {
                            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                            uh.a(viewGroup4, true);
                            aVar.addListener(new h(viewGroup4));
                        }
                        return animatorOfObject;
                    }
                    aVar = this;
                    if (i3 == i4 && i5 == i6) {
                        path = aVar.mPathMotion.getPath(i7, i9, i8, i10);
                        property = f;
                    } else {
                        path = aVar.mPathMotion.getPath(i3, i5, i4, i6);
                        property = g;
                    }
                    animatorOfObject = ObjectAnimator.ofObject(view, (Property<View, V>) property, (TypeConverter) null, path);
                    if (view.getParent() instanceof ViewGroup) {
                        ViewGroup viewGroup5 = (ViewGroup) view.getParent();
                        uh.a(viewGroup5, true);
                        aVar.addListener(new h(viewGroup5));
                    }
                    return animatorOfObject;
                }
            }
        }
        return null;
    }

    @Override // androidx.transition.h
    public final String[] getTransitionProperties() {
        return b;
    }
}
