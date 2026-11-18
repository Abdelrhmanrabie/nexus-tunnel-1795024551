package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import defpackage.ak;
import defpackage.g81;
import defpackage.te1;
import defpackage.uh;
import defpackage.ui;
import java.util.HashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class l extends h {
    public static final String[] sTransitionProperties = {"android:visibility:visibility", "android:visibility:parent"};
    public int mMode;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends i {
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ View c;
        public final /* synthetic */ View d;

        public a(ViewGroup viewGroup, View view, View view2) {
            this.b = viewGroup;
            this.c = view;
            this.d = view2;
        }

        @Override // androidx.transition.h.g
        public final void onTransitionEnd(h hVar) {
            this.d.setTag(R.attr.w1, null);
            this.b.getOverlay().remove(this.c);
            hVar.removeListener(this);
        }

        @Override // androidx.transition.i, androidx.transition.h.g
        public final void onTransitionPause() {
            this.b.getOverlay().remove(this.c);
        }

        @Override // androidx.transition.i, androidx.transition.h.g
        public final void onTransitionResume() {
            View view = this.c;
            if (view.getParent() == null) {
                this.b.getOverlay().add(view);
            } else {
                l.this.cancel();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b extends AnimatorListenerAdapter implements h.g {
        public final View b;
        public final int c;
        public final ViewGroup d;
        public boolean g;
        public boolean i = false;
        public final boolean f = true;

        public b(View view, int i) {
            this.b = view;
            this.c = i;
            this.d = (ViewGroup) view.getParent();
            a(true);
        }

        public final void a(boolean z) {
            ViewGroup viewGroup;
            if (!this.f || this.g == z || (viewGroup = this.d) == null) {
                return;
            }
            this.g = z;
            uh.a(viewGroup, z);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.i = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (!this.i) {
                te1.a.d(this.b, this.c);
                ViewGroup viewGroup = this.d;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationPause(Animator animator) {
            if (this.i) {
                return;
            }
            te1.a.d(this.b, this.c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationResume(Animator animator) {
            if (this.i) {
                return;
            }
            te1.a.d(this.b, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
        }

        @Override // androidx.transition.h.g
        public final void onTransitionCancel() {
        }

        @Override // androidx.transition.h.g
        public final void onTransitionEnd(h hVar) {
            if (!this.i) {
                te1.a.d(this.b, this.c);
                ViewGroup viewGroup = this.d;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
            hVar.removeListener(this);
        }

        @Override // androidx.transition.h.g
        public final void onTransitionPause() {
            a(false);
        }

        @Override // androidx.transition.h.g
        public final void onTransitionResume() {
            a(true);
        }

        @Override // androidx.transition.h.g
        public final void onTransitionStart(h hVar) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class c {
        public boolean a;
        public boolean b;
        public int c;
        public int d;
        public ViewGroup e;
        public ViewGroup f;
    }

    public l() {
        this.mMode = 3;
    }

    public l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ui.b);
        int i = ak.g((XmlResourceParser) attributeSet, "transitionVisibilityMode") ? typedArrayObtainStyledAttributes.getInt(0, 0) : 0;
        typedArrayObtainStyledAttributes.recycle();
        if (i != 0) {
            if ((i & (-4)) == 0) {
                this.mMode = i;
            } else {
                defpackage.d.AnonymousClass0.m$2("Only MODE_IN and MODE_OUT flags are allowed");
                throw null;
            }
        }
    }

    public static void captureValues(g81 g81Var) {
        Integer numValueOf = Integer.valueOf(g81Var.b.getVisibility());
        HashMap map = g81Var.a;
        map.put("android:visibility:visibility", numValueOf);
        map.put("android:visibility:parent", g81Var.b.getParent());
        int[] iArr = new int[2];
        g81Var.b.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0052  */
    /* JADX WARN: Code duplicated, block: B:39:0x0089  */
    /* JADX WARN: Code duplicated, block: B:7:0x002f  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
    
        if (r9 == 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
    
        if (r0.e == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
    
        if (r0.c == 0) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.transition.l.c getVisibilityChangeInfo(defpackage.g81 r8, defpackage.g81 r9) {
        /*
            androidx.transition.l$c r0 = new androidx.transition.l$c
            r0.<init>()
            r1 = 0
            r0.a = r1
            r0.b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.c = r7
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.e = r6
            goto L33
        L2f:
            r0.c = r4
            r0.e = r3
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r3 = r6.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.d = r3
            java.lang.Object r2 = r6.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f = r2
            goto L56
        L52:
            r0.d = r4
            r0.f = r3
        L56:
            r2 = 1
            if (r8 == 0) goto L7a
            if (r9 == 0) goto L7a
            int r8 = r0.c
            int r9 = r0.d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.e
            android.view.ViewGroup r4 = r0.f
            if (r3 != r4) goto L68
            goto L8d
        L68:
            if (r8 == r9) goto L70
            if (r8 != 0) goto L6d
            goto L89
        L6d:
            if (r9 != 0) goto L8d
            goto L80
        L70:
            android.view.ViewGroup r8 = r0.f
            if (r8 != 0) goto L75
            goto L89
        L75:
            android.view.ViewGroup r8 = r0.e
            if (r8 != 0) goto L8d
            goto L80
        L7a:
            if (r8 != 0) goto L83
            int r8 = r0.d
            if (r8 != 0) goto L83
        L80:
            r0.b = r2
            goto L8b
        L83:
            if (r9 != 0) goto L8d
            int r8 = r0.c
            if (r8 != 0) goto L8d
        L89:
            r0.b = r1
        L8b:
            r0.a = r2
        L8d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.l.getVisibilityChangeInfo(g81, g81):androidx.transition.l$c");
    }

    @Override // androidx.transition.h
    public final void captureEndValues(g81 g81Var) {
        captureValues(g81Var);
    }

    @Override // androidx.transition.h
    public void captureStartValues(g81 g81Var) {
        captureValues(g81Var);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0094  */
    /* JADX WARN: Code duplicated, block: B:50:0x009a  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:57:0x0120  */
    /* JADX WARN: Code duplicated, block: B:60:0x0129  */
    /* JADX WARN: Code duplicated, block: B:61:0x012e  */
    /* JADX WARN: Code duplicated, block: B:65:0x0136 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:69:0x0158  */
    /* JADX WARN: Code duplicated, block: B:72:0x0172 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:77:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:79:0x01ce A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:82:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:86:0x0209  */
    /* JADX WARN: Code duplicated, block: B:89:0x0210  */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
    
        if (getVisibilityChangeInfo(getMatchedTransitionValues(r4, false), getTransitionValues(r4, false)).a != false) goto L9;
     */
    @Override // androidx.transition.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator createAnimator(android.view.ViewGroup r25, defpackage.g81 r26, defpackage.g81 r27) {
        /*
            Method dump skipped, instruction units count: 671
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.l.createAnimator(android.view.ViewGroup, g81, g81):android.animation.Animator");
    }

    @Override // androidx.transition.h
    public final String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override // androidx.transition.h
    public final boolean isTransitionRequired(g81 g81Var, g81 g81Var2) {
        if (g81Var == null && g81Var2 == null) {
            return false;
        }
        if (g81Var != null && g81Var2 != null && g81Var2.a.containsKey("android:visibility:visibility") != g81Var.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c visibilityChangeInfo = getVisibilityChangeInfo(g81Var, g81Var2);
        if (visibilityChangeInfo.a) {
            return visibilityChangeInfo.c == 0 || visibilityChangeInfo.d == 0;
        }
        return false;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, g81 g81Var) {
        return null;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, g81 g81Var) {
        return null;
    }
}
