package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.transition.Transition;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import defpackage.bw;
import defpackage.cw;
import defpackage.d7;
import defpackage.dg0;
import defpackage.fn0;
import defpackage.gb;
import defpackage.jv;
import defpackage.o01;
import defpackage.qd1;
import defpackage.wv;
import defpackage.yv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class l extends y {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a extends b {
        public final boolean c;
        public boolean d;
        public defpackage.g e;

        public a(y.d dVar, gb gbVar, boolean z) {
            super(dVar, gbVar);
            this.d = false;
            this.c = z;
        }

        /* JADX WARN: Code duplicated, block: B:75:0x00f9 A[Catch: RuntimeException -> 0x00ff, TRY_LEAVE, TryCatch #1 {RuntimeException -> 0x00ff, blocks: (B:73:0x00f3, B:75:0x00f9), top: B:86:0x00f3 }] */
        public final defpackage.g c(Context context) {
            int enterAnim;
            defpackage.g gVar;
            Animator animatorLoadAnimator;
            int i;
            int i2;
            if (this.d) {
                return this.e;
            }
            y.d dVar = this.a;
            Fragment fragment = dVar.c;
            boolean z = dVar.a == y.d.c.VISIBLE;
            int nextTransition = fragment.getNextTransition();
            if (this.c) {
                enterAnim = z ? fragment.getPopEnterAnim() : fragment.getPopExitAnim();
            } else {
                enterAnim = z ? fragment.getEnterAnim() : fragment.getExitAnim();
            }
            fragment.setAnimations(0, 0, 0, 0);
            ViewGroup viewGroup = fragment.mContainer;
            defpackage.g gVar2 = null;
            if (viewGroup != null && viewGroup.getTag(R.attr.a3b) != null) {
                fragment.mContainer.setTag(R.attr.a3b, null);
            }
            ViewGroup viewGroup2 = fragment.mContainer;
            if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
                Animation animationOnCreateAnimation = fragment.onCreateAnimation(nextTransition, z, enterAnim);
                if (animationOnCreateAnimation != null) {
                    gVar2 = new defpackage.g(animationOnCreateAnimation);
                } else {
                    Animator animatorOnCreateAnimator = fragment.onCreateAnimator(nextTransition, z, enterAnim);
                    int i3 = 15;
                    if (animatorOnCreateAnimator != null) {
                        gVar2 = new defpackage.g(i3, animatorOnCreateAnimator);
                    } else {
                        if (enterAnim == 0 && nextTransition != 0) {
                            if (nextTransition == 4097) {
                                i = z ? R.animator.h : R.animator.i;
                            } else if (nextTransition != 8194) {
                                enterAnim = -1;
                                if (nextTransition == 8197) {
                                    i2 = z ? android.R.attr.activityCloseEnterAnimation : android.R.attr.activityCloseExitAnimation;
                                } else if (nextTransition == 4099) {
                                    i = z ? R.animator.f : R.animator.g;
                                } else if (nextTransition == 4100) {
                                    i2 = z ? android.R.attr.activityOpenEnterAnimation : android.R.attr.activityOpenExitAnimation;
                                }
                                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(android.R.style.Animation.Activity, new int[]{i2});
                                enterAnim = typedArrayObtainStyledAttributes.getResourceId(0, -1);
                                typedArrayObtainStyledAttributes.recycle();
                            } else {
                                i = z ? R.animator.d : R.animator.e;
                            }
                            enterAnim = i;
                        }
                        if (enterAnim != 0) {
                            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(enterAnim));
                            if (zEquals) {
                                try {
                                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, enterAnim);
                                    if (animationLoadAnimation != null) {
                                        gVar = new defpackage.g(animationLoadAnimation);
                                        gVar2 = gVar;
                                    }
                                } catch (Resources.NotFoundException e) {
                                    throw e;
                                } catch (RuntimeException unused) {
                                    try {
                                        animatorLoadAnimator = AnimatorInflater.loadAnimator(context, enterAnim);
                                        if (animatorLoadAnimator != null) {
                                            gVar = new defpackage.g(i3, animatorLoadAnimator);
                                            gVar2 = gVar;
                                        }
                                    } catch (RuntimeException e2) {
                                        if (zEquals) {
                                            throw e2;
                                        }
                                        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, enterAnim);
                                        if (animationLoadAnimation2 != null) {
                                            gVar2 = new defpackage.g(animationLoadAnimation2);
                                        }
                                    }
                                }
                            } else {
                                animatorLoadAnimator = AnimatorInflater.loadAnimator(context, enterAnim);
                                if (animatorLoadAnimator != null) {
                                    gVar = new defpackage.g(i3, animatorLoadAnimator);
                                    gVar2 = gVar;
                                }
                            }
                        }
                    }
                }
            }
            this.e = gVar2;
            this.d = true;
            return gVar2;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b {
        public final y.d a;
        public final gb b;

        public b(y.d dVar, gb gbVar) {
            this.a = dVar;
            this.b = gbVar;
        }

        public final void a() {
            y.d dVar = this.a;
            HashSet hashSet = dVar.e;
            if (hashSet.remove(this.b) && hashSet.isEmpty()) {
                dVar.b();
            }
        }

        public final boolean b() {
            y.d dVar = this.a;
            y.d.c cVarC = y.d.c.c(dVar.c.mView);
            y.d.c cVar = dVar.a;
            if (cVarC == cVar) {
                return true;
            }
            y.d.c cVar2 = y.d.c.VISIBLE;
            return (cVarC == cVar2 || cVar == cVar2) ? false : true;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class c extends b {
        public final Object c;
        public final boolean d;
        public final Object e;

        public c(y.d dVar, gb gbVar, boolean z, boolean z2) {
            boolean allowReturnTransitionOverlap;
            super(dVar, gbVar);
            y.d.c cVar = dVar.a;
            y.d.c cVar2 = y.d.c.VISIBLE;
            Fragment fragment = dVar.c;
            if (cVar == cVar2) {
                this.c = z ? fragment.getReenterTransition() : fragment.getEnterTransition();
                allowReturnTransitionOverlap = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
            } else {
                this.c = z ? fragment.getReturnTransition() : fragment.getExitTransition();
                allowReturnTransitionOverlap = true;
            }
            this.d = allowReturnTransitionOverlap;
            this.e = z2 ? z ? fragment.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition() : null;
        }

        public final cw c(Object obj) {
            if (obj == null) {
                return null;
            }
            yv yvVar = wv.a;
            if (obj instanceof Transition) {
                return yvVar;
            }
            cw cwVar = wv.b;
            if (cwVar != null && cwVar.e(obj)) {
                return cwVar;
            }
            StringBuilder sb = new StringBuilder("Transition ");
            sb.append(obj);
            Fragment fragment = this.a.c;
            sb.append(" for fragment ");
            sb.append(fragment);
            sb.append(" is not a valid framework Transition or AndroidX Transition");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public l(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public static void j(View view, ArrayList arrayList) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.isTransitionGroup()) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                j(childAt, arrayList);
            }
        }
    }

    public static void k(View view, d7 d7Var) {
        WeakHashMap weakHashMap = qd1.a;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            d7Var.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    k(childAt, d7Var);
                }
            }
        }
    }

    public static void l(d7 d7Var, Collection collection) {
        Iterator it = ((dg0.b) d7Var.entrySet()).iterator();
        while (true) {
            dg0.d dVar = (dg0.d) it;
            if (!dVar.hasNext()) {
                return;
            }
            dVar.next();
            View view = (View) dVar.getValue();
            WeakHashMap weakHashMap = qd1.a;
            if (!collection.contains(view.getTransitionName())) {
                dVar.remove();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:154:0x0473  */
    /* JADX WARN: Code duplicated, block: B:156:0x0478  */
    /* JADX WARN: Code duplicated, block: B:158:0x047e  */
    /* JADX WARN: Code duplicated, block: B:161:0x048c  */
    /* JADX WARN: Code duplicated, block: B:162:0x0491  */
    /* JADX WARN: Code duplicated, block: B:226:0x061b  */
    /* JADX WARN: Code duplicated, block: B:239:0x0650  */
    /* JADX WARN: Code duplicated, block: B:243:0x065d  */
    /* JADX WARN: Code duplicated, block: B:244:0x0660  */
    /* JADX WARN: Code duplicated, block: B:247:0x0666  */
    /* JADX WARN: Code duplicated, block: B:250:0x0691  */
    /* JADX WARN: Code duplicated, block: B:255:0x06b1  */
    /* JADX WARN: Code duplicated, block: B:260:0x06c5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:263:0x06cd  */
    /* JADX WARN: Code duplicated, block: B:267:0x06ea  */
    /* JADX WARN: Code duplicated, block: B:268:0x06f1  */
    /* JADX WARN: Code duplicated, block: B:270:0x070b  */
    /* JADX WARN: Code duplicated, block: B:275:0x0723 A[LOOP:7: B:273:0x071d->B:275:0x0723, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:278:0x073d  */
    /* JADX WARN: Code duplicated, block: B:311:0x0639 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:312:0x0635 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:313:0x0657 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:314:0x0649 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:319:0x06d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:321:0x06be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:322:0x06c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:356:? A[RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.y
    public final void b(ArrayList arrayList, boolean z) {
        y.d.c cVar;
        ArrayList arrayList2;
        y.d.c cVar2;
        HashMap map;
        y.d dVar;
        String str;
        boolean z2;
        o01 o01Var;
        ArrayList arrayList3;
        int i;
        String str2;
        y.d dVar2;
        ArrayList arrayList4;
        View view;
        y.d.c cVar3;
        View view2;
        y.d dVar3;
        y.d.c cVar4;
        Rect rect;
        HashMap map2;
        View view3;
        ArrayList arrayList5;
        int i2;
        Object obj;
        View view4;
        boolean zContainsValue;
        Context context;
        ArrayList<a> arrayList6;
        boolean z3;
        y.d dVar4;
        Fragment fragment;
        View view5;
        Animation animation;
        defpackage.g gVarC;
        Animator animator;
        y.d dVar5;
        Fragment fragment2;
        y.d.c cVar5;
        boolean z4;
        ArrayList arrayList7;
        Iterator it;
        ArrayList arrayList8;
        ArrayList arrayList9;
        Iterator it2 = arrayList.iterator();
        y.d dVar6 = null;
        y.d dVar7 = null;
        while (true) {
            boolean zHasNext = it2.hasNext();
            cVar = y.d.c.VISIBLE;
            if (!zHasNext) {
                break;
            }
            y.d dVar8 = (y.d) it2.next();
            y.d.c cVarC = y.d.c.c(dVar8.c.mView);
            int iOrdinal = dVar8.a.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal == 2 || iOrdinal == 3) {
                    }
                } else if (cVarC != cVar) {
                    dVar7 = dVar8;
                }
            }
            if (cVarC == cVar && dVar6 == null) {
                dVar6 = dVar8;
            }
        }
        String str3 = "FragmentManager";
        if (Log.isLoggable("FragmentManager", 2)) {
            Objects.toString(dVar6);
            Objects.toString(dVar7);
        }
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList(arrayList);
        Fragment fragment3 = ((y.d) arrayList.get(arrayList.size() - 1)).c;
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            Fragment.j jVar = ((y.d) it3.next()).c.mAnimationInfo;
            Fragment.j jVar2 = fragment3.mAnimationInfo;
            jVar.b = jVar2.b;
            jVar.c = jVar2.c;
            jVar.d = jVar2.d;
            jVar.e = jVar2.e;
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            y.d dVar9 = (y.d) it4.next();
            gb gbVar = new gb();
            dVar9.d();
            HashSet hashSet = dVar9.e;
            hashSet.add(gbVar);
            arrayList10.add(new a(dVar9, gbVar, z));
            gb gbVar2 = new gb();
            dVar9.d();
            hashSet.add(gbVar2);
            arrayList11.add(new c(dVar9, gbVar2, z, !z ? dVar9 != dVar7 : dVar9 != dVar6));
            dVar9.d.add(new androidx.fragment.app.c(this, arrayList12, dVar9));
        }
        HashMap map3 = new HashMap();
        Iterator it5 = arrayList11.iterator();
        cw cwVar = null;
        while (it5.hasNext()) {
            c cVar6 = (c) it5.next();
            if (cVar6.b()) {
                it = it5;
                arrayList8 = arrayList10;
                arrayList9 = arrayList11;
            } else {
                Object obj2 = cVar6.c;
                cw cwVarC = cVar6.c(obj2);
                Object obj3 = cVar6.e;
                it = it5;
                cw cwVarC2 = cVar6.c(obj3);
                y.d dVar10 = cVar6.a;
                arrayList8 = arrayList10;
                arrayList9 = arrayList11;
                if (cwVarC != null && cwVarC2 != null && cwVarC != cwVarC2) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + dVar10.c + " returned Transition " + obj2 + " which uses a different Transition  type than its shared element transition " + obj3);
                }
                if (cwVarC == null) {
                    cwVarC = cwVarC2;
                }
                if (cwVar == null) {
                    cwVar = cwVarC;
                } else if (cwVarC != null && cwVar != cwVarC) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + dVar10.c + " returned Transition " + obj2 + " which uses a different Transition  type than other Fragments.");
                }
            }
            it5 = it;
            arrayList10 = arrayList8;
            arrayList11 = arrayList9;
        }
        ArrayList<a> arrayList13 = arrayList10;
        ArrayList<c> arrayList14 = arrayList11;
        y.d.c cVar7 = y.d.c.GONE;
        ViewGroup viewGroup = this.a;
        if (cwVar == null) {
            for (c cVar8 : arrayList14) {
                map3.put(cVar8.a, Boolean.FALSE);
                cVar8.a();
            }
            map = map3;
            str = "FragmentManager";
            cVar2 = cVar7;
            dVar = dVar6;
            arrayList2 = arrayList12;
        } else {
            View view6 = new View(viewGroup.getContext());
            Rect rect2 = new Rect();
            ArrayList arrayList15 = new ArrayList();
            ArrayList arrayList16 = new ArrayList();
            d7 d7Var = new d7();
            Iterator it6 = arrayList14.iterator();
            y.d dVar11 = dVar6;
            y.d.c cVar9 = cVar;
            arrayList2 = arrayList12;
            Object objR = null;
            View view7 = null;
            boolean z5 = false;
            y.d dVar12 = dVar7;
            while (it6.hasNext()) {
                Object obj4 = objR;
                Object obj5 = ((c) it6.next()).e;
                if (obj5 == null || dVar11 == null || dVar12 == null) {
                    cVar4 = cVar7;
                    rect = rect2;
                    map2 = map3;
                    view3 = view6;
                    arrayList5 = arrayList16;
                    objR = obj4;
                } else {
                    objR = cwVar.r(cwVar.f(obj5));
                    Fragment fragment4 = dVar12.c;
                    cVar4 = cVar7;
                    ArrayList<String> sharedElementSourceNames = fragment4.getSharedElementSourceNames();
                    Fragment fragment5 = dVar11.c;
                    HashMap map4 = map3;
                    ArrayList<String> sharedElementSourceNames2 = fragment5.getSharedElementSourceNames();
                    View view8 = view6;
                    ArrayList<String> sharedElementTargetNames = fragment5.getSharedElementTargetNames();
                    Rect rect3 = rect2;
                    ArrayList arrayList17 = arrayList16;
                    int i3 = 0;
                    while (i3 < sharedElementTargetNames.size()) {
                        int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i3));
                        ArrayList<String> arrayList18 = sharedElementTargetNames;
                        if (iIndexOf != -1) {
                            sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i3));
                        }
                        i3++;
                        sharedElementTargetNames = arrayList18;
                    }
                    ArrayList<String> sharedElementTargetNames2 = fragment4.getSharedElementTargetNames();
                    if (z) {
                        fragment5.getEnterTransitionCallback();
                        fragment4.getExitTransitionCallback();
                    } else {
                        fragment5.getExitTransitionCallback();
                        fragment4.getEnterTransitionCallback();
                    }
                    int i4 = 0;
                    for (int size = sharedElementSourceNames.size(); i4 < size; size = size) {
                        d7Var.put(sharedElementSourceNames.get(i4), sharedElementTargetNames2.get(i4));
                        i4++;
                    }
                    if (Log.isLoggable("FragmentManager", 2)) {
                        for (String str4 : sharedElementTargetNames2) {
                        }
                        for (String str5 : sharedElementSourceNames) {
                        }
                    }
                    d7 d7Var2 = new d7();
                    k(fragment5.mView, d7Var2);
                    dg0.k(d7Var2, sharedElementSourceNames);
                    dg0.k(d7Var, d7Var2.keySet());
                    d7 d7Var3 = new d7();
                    k(fragment4.mView, d7Var3);
                    dg0.k(d7Var3, sharedElementTargetNames2);
                    dg0.k(d7Var3, d7Var.values());
                    yv yvVar = wv.a;
                    int i5 = d7Var.d - 1;
                    while (i5 >= 0) {
                        Fragment fragment6 = fragment5;
                        if (!d7Var3.containsKey((String) d7Var.k(i5))) {
                            d7Var.j(i5);
                        }
                        i5--;
                        fragment5 = fragment6;
                    }
                    Fragment fragment7 = fragment5;
                    l(d7Var2, d7Var.keySet());
                    l(d7Var3, d7Var.values());
                    if (d7Var.isEmpty()) {
                        arrayList15.clear();
                        arrayList17.clear();
                        dVar11 = dVar6;
                        dVar12 = dVar7;
                        arrayList5 = arrayList17;
                        map2 = map4;
                        view3 = view8;
                        rect = rect3;
                        objR = null;
                    } else {
                        if (z) {
                            fragment7.getEnterTransitionCallback();
                        } else {
                            fragment4.getEnterTransitionCallback();
                        }
                        fn0.a(viewGroup, new h(dVar7, dVar6, z, d7Var3));
                        arrayList15.addAll(d7Var2.values());
                        if (sharedElementSourceNames.isEmpty()) {
                            i2 = 0;
                            obj = null;
                        } else {
                            i2 = 0;
                            obj = null;
                            View view9 = (View) d7Var2.getOrDefault(sharedElementSourceNames.get(0), null);
                            cwVar.m(view9, objR);
                            view7 = view9;
                        }
                        arrayList5 = arrayList17;
                        arrayList5.addAll(d7Var3.values());
                        if (sharedElementTargetNames2.isEmpty() || (view4 = (View) d7Var3.getOrDefault(sharedElementTargetNames2.get(i2), obj)) == null) {
                            rect = rect3;
                        } else {
                            rect = rect3;
                            fn0.a(viewGroup, new i(cwVar, view4, rect));
                            z5 = true;
                        }
                        view3 = view8;
                        cwVar.p(objR, view3, arrayList15);
                        cwVar.l(objR, null, null, objR, arrayList5);
                        Boolean bool = Boolean.TRUE;
                        map2 = map4;
                        map2.put(dVar6, bool);
                        map2.put(dVar7, bool);
                        dVar11 = dVar6;
                        dVar12 = dVar7;
                    }
                }
                arrayList16 = arrayList5;
                view6 = view3;
                map3 = map2;
                rect2 = rect;
                cVar7 = cVar4;
            }
            cVar2 = cVar7;
            Rect rect4 = rect2;
            Object obj6 = objR;
            map = map3;
            View view10 = view6;
            ArrayList<View> arrayList19 = arrayList16;
            ArrayList arrayList20 = new ArrayList();
            Iterator it7 = arrayList14.iterator();
            dVar = dVar6;
            Object objJ = null;
            Object objJ2 = null;
            while (it7.hasNext()) {
                Iterator it8 = it7;
                c cVar10 = (c) it7.next();
                boolean zB = cVar10.b();
                d7 d7Var4 = d7Var;
                y.d dVar13 = cVar10.a;
                String str6 = str3;
                if (zB) {
                    map.put(dVar13, Boolean.FALSE);
                    cVar10.a();
                    view = view10;
                    dVar2 = dVar7;
                    dVar3 = dVar12;
                    arrayList15 = arrayList15;
                    view2 = view7;
                    cVar3 = cVar9;
                } else {
                    Object objF = cwVar.f(cVar10.c);
                    boolean z6 = obj6 != null && (dVar13 == dVar11 || dVar13 == dVar12);
                    if (objF == null) {
                        if (!z6) {
                            map.put(dVar13, Boolean.FALSE);
                            cVar10.a();
                        }
                        view = view10;
                        dVar2 = dVar7;
                        arrayList15 = arrayList15;
                        view2 = view7;
                        cVar3 = cVar9;
                    } else {
                        boolean z7 = z6;
                        ArrayList arrayList21 = new ArrayList();
                        dVar2 = dVar7;
                        j(dVar13.c.mView, arrayList21);
                        if (z7) {
                            if (dVar13 == dVar11) {
                                arrayList21.removeAll(arrayList15);
                            } else {
                                arrayList21.removeAll(arrayList19);
                            }
                        }
                        if (arrayList21.isEmpty()) {
                            cwVar.a(view10, objF);
                            view = view10;
                            arrayList4 = arrayList21;
                        } else {
                            cwVar.b(objF, arrayList21);
                            cwVar.l(objF, objF, arrayList21, null, null);
                            arrayList4 = arrayList21;
                            view = view10;
                            y.d.c cVar11 = cVar2;
                            if (dVar13.a == cVar11) {
                                arrayList2.remove(dVar13);
                                ArrayList arrayList22 = new ArrayList(arrayList4);
                                cVar2 = cVar11;
                                Fragment fragment8 = dVar13.c;
                                arrayList22.remove(fragment8.mView);
                                cwVar.k(objF, fragment8.mView, arrayList22);
                                fn0.a(viewGroup, new j(arrayList4));
                            } else {
                                cVar2 = cVar11;
                            }
                            cVar3 = cVar9;
                            if (dVar13.a == cVar3) {
                                arrayList20.addAll(arrayList4);
                                if (z5) {
                                    cwVar.n(objF, rect4);
                                }
                                view2 = view7;
                            } else {
                                view2 = view7;
                                cwVar.m(view2, objF);
                            }
                            map.put(dVar13, Boolean.TRUE);
                            if (cVar10.d) {
                                objJ2 = cwVar.j(objJ2, objF);
                            } else {
                                objJ = cwVar.j(objJ, objF);
                            }
                        }
                        cVar3 = cVar9;
                        if (dVar13.a == cVar3) {
                            arrayList20.addAll(arrayList4);
                            if (z5) {
                                cwVar.n(objF, rect4);
                            }
                            view2 = view7;
                        } else {
                            view2 = view7;
                            cwVar.m(view2, objF);
                        }
                        map.put(dVar13, Boolean.TRUE);
                        if (cVar10.d) {
                            objJ2 = cwVar.j(objJ2, objF);
                        } else {
                            objJ = cwVar.j(objJ, objF);
                        }
                    }
                    dVar3 = dVar2;
                }
                it7 = it8;
                view7 = view2;
                cVar9 = cVar3;
                view10 = view;
                arrayList15 = arrayList15;
                d7Var = d7Var4;
                dVar7 = dVar2;
                dVar12 = dVar3;
                str3 = str6;
            }
            String str7 = str3;
            y.d dVar14 = dVar7;
            ArrayList<View> arrayList23 = arrayList15;
            o01 o01Var2 = d7Var;
            Object objI = cwVar.i(objJ2, objJ, obj6);
            if (objI != null) {
                for (c cVar12 : arrayList14) {
                    if (!cVar12.b()) {
                        y.d dVar15 = cVar12.a;
                        y.d dVar16 = dVar14;
                        boolean z8 = obj6 != null && (dVar15 == dVar11 || dVar15 == dVar16);
                        if (cVar12.c != null || z8) {
                            WeakHashMap weakHashMap = qd1.a;
                            str2 = str7;
                            if (viewGroup.isLaidOut()) {
                                Fragment fragment9 = dVar15.c;
                                cwVar.o(objI, cVar12.b, new k(cVar12, dVar15));
                            } else {
                                if (Log.isLoggable(str2, 2)) {
                                    Objects.toString(viewGroup);
                                    Objects.toString(dVar15);
                                }
                                cVar12.a();
                            }
                        } else {
                            str2 = str7;
                        }
                        dVar14 = dVar16;
                        str7 = str2;
                    }
                }
                str = str7;
                dVar7 = dVar14;
                WeakHashMap weakHashMap2 = qd1.a;
                if (viewGroup.isLaidOut()) {
                    wv.a(arrayList20, 4);
                    ArrayList arrayList24 = new ArrayList();
                    int size2 = arrayList19.size();
                    for (int i6 = 0; i6 < size2; i6++) {
                        View view11 = (View) arrayList19.get(i6);
                        WeakHashMap weakHashMap3 = qd1.a;
                        arrayList24.add(view11.getTransitionName());
                        view11.setTransitionName(null);
                    }
                    if (Log.isLoggable(str, 2)) {
                        for (View view12 : arrayList23) {
                            Objects.toString(view12);
                            view12.getTransitionName();
                        }
                        for (View view13 : arrayList19) {
                            Objects.toString(view13);
                            view13.getTransitionName();
                        }
                    }
                    cwVar.c(viewGroup, objI);
                    int size3 = arrayList19.size();
                    ArrayList arrayList25 = new ArrayList();
                    int i7 = 0;
                    while (i7 < size3) {
                        ArrayList arrayList26 = arrayList23;
                        View view14 = (View) arrayList26.get(i7);
                        WeakHashMap weakHashMap4 = qd1.a;
                        String transitionName = view14.getTransitionName();
                        arrayList25.add(transitionName);
                        if (transitionName == null) {
                            i = size3;
                            arrayList3 = arrayList25;
                            o01Var = o01Var2;
                        } else {
                            view14.setTransitionName(null);
                            o01Var = o01Var2;
                            String str8 = (String) o01Var.getOrDefault(transitionName, null);
                            arrayList3 = arrayList25;
                            int i8 = 0;
                            while (true) {
                                i = size3;
                                if (i8 >= size3) {
                                    break;
                                }
                                if (str8.equals(arrayList24.get(i8))) {
                                    ((View) arrayList19.get(i8)).setTransitionName(transitionName);
                                    break;
                                } else {
                                    i8++;
                                    size3 = i;
                                }
                            }
                        }
                        i7++;
                        arrayList23 = arrayList26;
                        o01Var2 = o01Var;
                        size3 = i;
                        arrayList25 = arrayList3;
                    }
                    fn0.a(viewGroup, new bw(size3, arrayList19, arrayList24, arrayList23, arrayList25));
                    z2 = false;
                    wv.a(arrayList20, 0);
                    cwVar.q(obj6, arrayList23, arrayList19);
                }
                zContainsValue = map.containsValue(Boolean.TRUE);
                context = viewGroup.getContext();
                arrayList6 = new ArrayList();
                z3 = z2;
                for (a aVar : arrayList13) {
                    if (!aVar.b() && (gVarC = aVar.c(context)) != null) {
                        animator = (Animator) gVarC.b;
                        if (animator == null) {
                            arrayList6.add(aVar);
                        } else {
                            dVar5 = aVar.a;
                            fragment2 = dVar5.c;
                            if (Boolean.TRUE.equals(map.get(dVar5))) {
                                cVar5 = cVar2;
                                if (dVar5.a == cVar5) {
                                    z4 = true;
                                } else {
                                    z4 = z2;
                                }
                                arrayList7 = arrayList2;
                                if (z4) {
                                    arrayList7.remove(dVar5);
                                }
                                View view15 = fragment2.mView;
                                viewGroup.startViewTransition(view15);
                                animator.addListener(new d(viewGroup, view15, z4, dVar5, aVar));
                                animator.setTarget(view15);
                                animator.start();
                                if (Log.isLoggable(str, 2)) {
                                    dVar5.toString();
                                }
                                aVar.b.b(new e(animator, dVar5));
                                cVar2 = cVar5;
                                arrayList2 = arrayList7;
                                z3 = true;
                            } else if (Log.isLoggable(str, 2)) {
                                Objects.toString(fragment2);
                            }
                        }
                    }
                    aVar.a();
                }
                ArrayList<y.d> arrayList27 = arrayList2;
                for (a aVar2 : arrayList6) {
                    dVar4 = aVar2.a;
                    fragment = dVar4.c;
                    if (zContainsValue) {
                        if (Log.isLoggable(str, 2)) {
                            Objects.toString(fragment);
                        }
                        aVar2.a();
                    } else if (z3) {
                        if (Log.isLoggable(str, 2)) {
                            Objects.toString(fragment);
                        }
                        aVar2.a();
                    } else {
                        view5 = fragment.mView;
                        defpackage.g gVarC2 = aVar2.c(context);
                        gVarC2.getClass();
                        animation = (Animation) gVarC2.a;
                        animation.getClass();
                        if (dVar4.a != y.d.c.REMOVED) {
                            view5.startAnimation(animation);
                            aVar2.a();
                        } else {
                            viewGroup.startViewTransition(view5);
                            jv jvVar = new jv(animation, viewGroup, view5);
                            jvVar.setAnimationListener(new f(view5, viewGroup, aVar2, dVar4));
                            view5.startAnimation(jvVar);
                            if (Log.isLoggable(str, 2)) {
                                dVar4.toString();
                            }
                        }
                        aVar2.b.b(new g(view5, viewGroup, aVar2, dVar4));
                    }
                }
                for (y.d dVar17 : arrayList27) {
                    dVar17.a.a(dVar17.c.mView);
                }
                arrayList27.clear();
                if (Log.isLoggable(str, 2)) {
                    Objects.toString(dVar);
                    Objects.toString(dVar7);
                }
            }
            str = str7;
            dVar7 = dVar14;
        }
        z2 = false;
        zContainsValue = map.containsValue(Boolean.TRUE);
        context = viewGroup.getContext();
        arrayList6 = new ArrayList();
        z3 = z2;
        while (r4.hasNext()) {
            if (!aVar.b()) {
                animator = (Animator) gVarC.b;
                if (animator == null) {
                    arrayList6.add(aVar);
                } else {
                    dVar5 = aVar.a;
                    fragment2 = dVar5.c;
                    if (Boolean.TRUE.equals(map.get(dVar5))) {
                        cVar5 = cVar2;
                        if (dVar5.a == cVar5) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        arrayList7 = arrayList2;
                        if (z4) {
                            arrayList7.remove(dVar5);
                        }
                        View view16 = fragment2.mView;
                        viewGroup.startViewTransition(view16);
                        animator.addListener(new d(viewGroup, view16, z4, dVar5, aVar));
                        animator.setTarget(view16);
                        animator.start();
                        if (Log.isLoggable(str, 2)) {
                            dVar5.toString();
                        }
                        aVar.b.b(new e(animator, dVar5));
                        cVar2 = cVar5;
                        arrayList2 = arrayList7;
                        z3 = true;
                    } else if (Log.isLoggable(str, 2)) {
                        Objects.toString(fragment2);
                    }
                }
            }
            aVar.a();
        }
        ArrayList<y.d> arrayList28 = arrayList2;
        while (r0.hasNext()) {
            dVar4 = aVar2.a;
            fragment = dVar4.c;
            if (zContainsValue) {
                if (Log.isLoggable(str, 2)) {
                    Objects.toString(fragment);
                }
                aVar2.a();
            } else if (z3) {
                if (Log.isLoggable(str, 2)) {
                    Objects.toString(fragment);
                }
                aVar2.a();
            } else {
                view5 = fragment.mView;
                defpackage.g gVarC3 = aVar2.c(context);
                gVarC3.getClass();
                animation = (Animation) gVarC3.a;
                animation.getClass();
                if (dVar4.a != y.d.c.REMOVED) {
                    view5.startAnimation(animation);
                    aVar2.a();
                } else {
                    viewGroup.startViewTransition(view5);
                    jv jvVar2 = new jv(animation, viewGroup, view5);
                    jvVar2.setAnimationListener(new f(view5, viewGroup, aVar2, dVar4));
                    view5.startAnimation(jvVar2);
                    if (Log.isLoggable(str, 2)) {
                        dVar4.toString();
                    }
                }
                aVar2.b.b(new g(view5, viewGroup, aVar2, dVar4));
            }
        }
        while (r0.hasNext()) {
            dVar17.a.a(dVar17.c.mView);
        }
        arrayList28.clear();
        if (Log.isLoggable(str, 2)) {
            Objects.toString(dVar);
            Objects.toString(dVar7);
        }
    }
}
