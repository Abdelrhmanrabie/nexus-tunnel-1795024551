package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import defpackage.ak;
import defpackage.d7;
import defpackage.dg1;
import defpackage.g81;
import defpackage.oo;
import defpackage.qd1;
import defpackage.qf0;
import defpackage.ro0;
import defpackage.te1;
import defpackage.ui;
import defpackage.ye1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import net.openvpn.ovpn3.XMLRPC;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class h implements Cloneable {
    public static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    public static final a STRAIGHT_PATH_MOTION = new a();
    public static final ThreadLocal sRunningAnimators = new ThreadLocal();
    public ArrayList mAnimators;
    public final ArrayList mCurrentAnimators;
    public long mDuration;
    public oo mEndValues;
    public ArrayList mEndValuesList;
    public boolean mEnded;
    public f mEpicenterCallback;
    public TimeInterpolator mInterpolator;
    public ArrayList mListeners;
    public final int[] mMatchOrder;
    public final String mName;
    public int mNumInstances;
    public k mParent;
    public ro0 mPathMotion;
    public boolean mPaused;
    public long mStartDelay;
    public oo mStartValues;
    public ArrayList mStartValuesList;
    public final ArrayList mTargetIds;
    public final ArrayList mTargets;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a extends ro0 {
        @Override // defpackage.ro0
        public final Path getPath(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ d7 b;

        public b(d7 d7Var) {
            this.b = d7Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            this.b.remove(animator);
            h.this.mCurrentAnimators.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            h.this.mCurrentAnimators.add(animator);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            h.this.end();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class d {
        public final View a;
        public final String b;
        public final g81 c;
        public final dg1 d;
        public final h e;

        public d(View view, String str, h hVar, dg1 dg1Var, g81 g81Var) {
            this.a = view;
            this.b = str;
            this.c = g81Var;
            this.d = dg1Var;
            this.e = hVar;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class e {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class f {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface g {
        void onTransitionCancel();

        void onTransitionEnd(h hVar);

        void onTransitionPause();

        void onTransitionResume();

        void onTransitionStart(h hVar);
    }

    public h() {
        this.mName = getClass().getName();
        this.mStartDelay = -1L;
        this.mDuration = -1L;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList();
        this.mTargets = new ArrayList();
        this.mStartValues = new oo(4);
        this.mEndValues = new oo(4);
        this.mParent = null;
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mCurrentAnimators = new ArrayList();
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mListeners = null;
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
    }

    public h(Context context, AttributeSet attributeSet) {
        this.mName = getClass().getName();
        this.mStartDelay = -1L;
        this.mDuration = -1L;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList();
        this.mTargets = new ArrayList();
        this.mStartValues = new oo(4);
        this.mEndValues = new oo(4);
        this.mParent = null;
        int[] iArr = DEFAULT_MATCH_ORDER;
        this.mMatchOrder = iArr;
        this.mCurrentAnimators = new ArrayList();
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mListeners = null;
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ui.a);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long j = !ak.g(xmlResourceParser, "duration") ? -1 : typedArrayObtainStyledAttributes.getInt(1, -1);
        if (j >= 0) {
            setDuration(j);
        }
        long j2 = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "startDelay") != null ? typedArrayObtainStyledAttributes.getInt(2, -1) : -1;
        if (j2 > 0) {
            setStartDelay(j2);
        }
        int resourceId = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "interpolator") != null ? typedArrayObtainStyledAttributes.getResourceId(0, 0) : 0;
        if (resourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        String strE = ak.e(typedArrayObtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (strE != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(strE, ",");
            int[] iArr2 = new int[stringTokenizer.countTokens()];
            int i = 0;
            while (stringTokenizer.hasMoreTokens()) {
                String strTrim = stringTokenizer.nextToken().trim();
                if ("id".equalsIgnoreCase(strTrim)) {
                    iArr2[i] = 3;
                } else if ("instance".equalsIgnoreCase(strTrim)) {
                    iArr2[i] = 1;
                } else if (XMLRPC.TAG_NAME.equalsIgnoreCase(strTrim)) {
                    iArr2[i] = 2;
                } else if ("itemId".equalsIgnoreCase(strTrim)) {
                    iArr2[i] = 4;
                } else {
                    if (!strTrim.isEmpty()) {
                        throw new InflateException(defpackage.e.n("Unknown match type in matchOrder: '", strTrim, "'"));
                    }
                    int[] iArr3 = new int[iArr2.length - 1];
                    System.arraycopy(iArr2, 0, iArr3, 0, i);
                    i--;
                    iArr2 = iArr3;
                }
                i++;
            }
            if (iArr2.length == 0) {
                this.mMatchOrder = iArr;
            } else {
                for (int i2 = 0; i2 < iArr2.length; i2++) {
                    int i3 = iArr2[i2];
                    if (i3 < 1 || i3 > 4) {
                        defpackage.d.AnonymousClass0.m$2("matches contains invalid value");
                        throw null;
                    }
                    for (int i4 = 0; i4 < i2; i4++) {
                        if (iArr2[i4] == i3) {
                            defpackage.d.AnonymousClass0.m$2("matches contains a duplicate value");
                            throw null;
                        }
                    }
                }
                this.mMatchOrder = (int[]) iArr2.clone();
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void addViewValues(oo ooVar, View view, g81 g81Var) {
        ((d7) ooVar.a).put(view, g81Var);
        int id = view.getId();
        if (id >= 0) {
            SparseArray sparseArray = (SparseArray) ooVar.b;
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = qd1.a;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            d7 d7Var = (d7) ooVar.d;
            if (d7Var.containsKey(transitionName)) {
                d7Var.put(transitionName, null);
            } else {
                d7Var.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                qf0 qf0Var = (qf0) ooVar.c;
                if (qf0Var.b) {
                    qf0Var.e();
                }
                if (defpackage.e.e(qf0Var.c, qf0Var.f, itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    qf0Var.g(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) qf0Var.f(itemIdAtPosition, null);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    qf0Var.g(itemIdAtPosition, null);
                }
            }
        }
    }

    public static d7 getRunningAnimators() {
        ThreadLocal threadLocal = sRunningAnimators;
        d7 d7Var = (d7) threadLocal.get();
        if (d7Var != null) {
            return d7Var;
        }
        d7 d7Var2 = new d7();
        threadLocal.set(d7Var2);
        return d7Var2;
    }

    public void addListener(g gVar) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(gVar);
    }

    public void addTarget(View view) {
        this.mTargets.add(view);
    }

    public void cancel() {
        ArrayList arrayList = this.mCurrentAnimators;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else {
                ((Animator) arrayList.get(size)).cancel();
            }
        }
        ArrayList arrayList2 = this.mListeners;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        ArrayList arrayList3 = (ArrayList) this.mListeners.clone();
        int size2 = arrayList3.size();
        for (int i = 0; i < size2; i++) {
            ((g) arrayList3.get(i)).onTransitionCancel();
        }
    }

    public abstract void captureEndValues(g81 g81Var);

    public final void captureHierarchy(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            g81 g81Var = new g81(view);
            if (z) {
                captureStartValues(g81Var);
            } else {
                captureEndValues(g81Var);
            }
            g81Var.c.add(this);
            capturePropagationValues(g81Var);
            addViewValues(z ? this.mStartValues : this.mEndValues, view, g81Var);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                captureHierarchy(viewGroup.getChildAt(i), z);
            }
        }
    }

    public void capturePropagationValues(g81 g81Var) {
    }

    public abstract void captureStartValues(g81 g81Var);

    public final void captureValues(ViewGroup viewGroup, boolean z) {
        clearValues(z);
        ArrayList arrayList = this.mTargetIds;
        int size = arrayList.size();
        ArrayList arrayList2 = this.mTargets;
        if (size <= 0 && arrayList2.size() <= 0) {
            captureHierarchy(viewGroup, z);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            View viewFindViewById = viewGroup.findViewById(((Integer) arrayList.get(i)).intValue());
            if (viewFindViewById != null) {
                g81 g81Var = new g81(viewFindViewById);
                if (z) {
                    captureStartValues(g81Var);
                } else {
                    captureEndValues(g81Var);
                }
                g81Var.c.add(this);
                capturePropagationValues(g81Var);
                addViewValues(z ? this.mStartValues : this.mEndValues, viewFindViewById, g81Var);
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            View view = (View) arrayList2.get(i2);
            g81 g81Var2 = new g81(view);
            if (z) {
                captureStartValues(g81Var2);
            } else {
                captureEndValues(g81Var2);
            }
            g81Var2.c.add(this);
            capturePropagationValues(g81Var2);
            addViewValues(z ? this.mStartValues : this.mEndValues, view, g81Var2);
        }
    }

    public final void clearValues(boolean z) {
        oo ooVar;
        if (z) {
            ((d7) this.mStartValues.a).clear();
            ((SparseArray) this.mStartValues.b).clear();
            ooVar = this.mStartValues;
        } else {
            ((d7) this.mEndValues.a).clear();
            ((SparseArray) this.mEndValues.b).clear();
            ooVar = this.mEndValues;
        }
        ((qf0) ooVar.c).c();
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public h mo1clone() {
        try {
            h hVar = (h) super.clone();
            hVar.mAnimators = new ArrayList();
            hVar.mStartValues = new oo(4);
            hVar.mEndValues = new oo(4);
            hVar.mStartValuesList = null;
            hVar.mEndValuesList = null;
            return hVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, g81 g81Var, g81 g81Var2) {
        return null;
    }

    public void createAnimators(ViewGroup viewGroup, oo ooVar, oo ooVar2, ArrayList arrayList, ArrayList arrayList2) {
        Animator animatorCreateAnimator;
        View view;
        Animator animator;
        g81 g81Var;
        Animator animator2;
        g81 g81Var2;
        h hVar = this;
        d7 runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            g81 g81Var3 = (g81) arrayList.get(i);
            g81 g81Var4 = (g81) arrayList2.get(i);
            if (g81Var3 != null && !g81Var3.c.contains(hVar)) {
                g81Var3 = null;
            }
            if (g81Var4 != null && !g81Var4.c.contains(hVar)) {
                g81Var4 = null;
            }
            if ((g81Var3 != null || g81Var4 != null) && ((g81Var3 == null || g81Var4 == null || hVar.isTransitionRequired(g81Var3, g81Var4)) && (animatorCreateAnimator = hVar.createAnimator(viewGroup, g81Var3, g81Var4)) != null)) {
                String str = hVar.mName;
                if (g81Var4 != null) {
                    view = g81Var4.b;
                    String[] transitionProperties = hVar.getTransitionProperties();
                    if (transitionProperties != null && transitionProperties.length > 0) {
                        g81Var2 = new g81(view);
                        g81 g81Var5 = (g81) ((d7) ooVar2.a).getOrDefault(view, null);
                        if (g81Var5 != null) {
                            int i2 = 0;
                            while (i2 < transitionProperties.length) {
                                String str2 = transitionProperties[i2];
                                g81Var2.a.put(str2, g81Var5.a.get(str2));
                                i2++;
                                transitionProperties = transitionProperties;
                            }
                        }
                        int i3 = runningAnimators.d;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= i3) {
                                animator2 = animatorCreateAnimator;
                                break;
                            }
                            d dVar = (d) runningAnimators.getOrDefault((Animator) runningAnimators.i(i4), null);
                            if (dVar.c != null && dVar.a == view && dVar.b.equals(str) && dVar.c.equals(g81Var2)) {
                                animator2 = null;
                                break;
                            }
                            i4++;
                        }
                    } else {
                        animator2 = animatorCreateAnimator;
                        g81Var2 = null;
                    }
                    animator = animator2;
                    g81Var = g81Var2;
                } else {
                    view = g81Var3.b;
                    animator = animatorCreateAnimator;
                    g81Var = null;
                }
                View view2 = view;
                if (animator != null) {
                    ye1 ye1Var = te1.a;
                    hVar = this;
                    runningAnimators.put(animator, new d(view2, str, hVar, new dg1(viewGroup), g81Var));
                    hVar.mAnimators.add(animator);
                } else {
                    hVar = this;
                }
            }
        }
        if (sparseIntArray.size() != 0) {
            for (int i5 = 0; i5 < sparseIntArray.size(); i5++) {
                Animator animator3 = (Animator) hVar.mAnimators.get(sparseIntArray.keyAt(i5));
                animator3.setStartDelay(animator3.getStartDelay() + (((long) sparseIntArray.valueAt(i5)) - Long.MAX_VALUE));
            }
        }
    }

    public final void end() {
        int i = this.mNumInstances - 1;
        this.mNumInstances = i;
        if (i != 0) {
            return;
        }
        ArrayList arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((g) arrayList2.get(i2)).onTransitionEnd(this);
            }
        }
        int i3 = 0;
        while (true) {
            qf0 qf0Var = (qf0) this.mStartValues.c;
            if (qf0Var.b) {
                qf0Var.e();
            }
            if (i3 >= qf0Var.f) {
                break;
            }
            View view = (View) ((qf0) this.mStartValues.c).h(i3);
            if (view != null) {
                WeakHashMap weakHashMap = qd1.a;
                view.setHasTransientState(false);
            }
            i3++;
        }
        int i4 = 0;
        while (true) {
            qf0 qf0Var2 = (qf0) this.mEndValues.c;
            if (qf0Var2.b) {
                qf0Var2.e();
            }
            if (i4 >= qf0Var2.f) {
                this.mEnded = true;
                return;
            }
            View view2 = (View) ((qf0) this.mEndValues.c).h(i4);
            if (view2 != null) {
                WeakHashMap weakHashMap2 = qd1.a;
                view2.setHasTransientState(false);
            }
            i4++;
        }
    }

    public final g81 getMatchedTransitionValues(View view, boolean z) {
        k kVar = this.mParent;
        if (kVar != null) {
            return kVar.getMatchedTransitionValues(view, z);
        }
        ArrayList arrayList = z ? this.mStartValuesList : this.mEndValuesList;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            g81 g81Var = (g81) arrayList.get(i);
            if (g81Var == null) {
                return null;
            }
            if (g81Var.b == view) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            return (g81) (z ? this.mEndValuesList : this.mStartValuesList).get(i);
        }
        return null;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public final g81 getTransitionValues(View view, boolean z) {
        k kVar = this.mParent;
        if (kVar != null) {
            return kVar.getTransitionValues(view, z);
        }
        return (g81) ((d7) (z ? this.mStartValues : this.mEndValues).a).getOrDefault(view, null);
    }

    public boolean isTransitionRequired(g81 g81Var, g81 g81Var2) {
        if (g81Var != null) {
            HashMap map = g81Var.a;
            if (g81Var2 != null) {
                HashMap map2 = g81Var2.a;
                String[] transitionProperties = getTransitionProperties();
                if (transitionProperties != null) {
                    for (String str : transitionProperties) {
                        Object obj = map.get(str);
                        Object obj2 = map2.get(str);
                        if ((obj == null && obj2 == null) ? false : (obj == null || obj2 == null) ? true : !obj.equals(obj2)) {
                            return true;
                        }
                    }
                } else {
                    for (String str2 : map.keySet()) {
                        Object obj3 = map.get(str2);
                        Object obj4 = map2.get(str2);
                        if ((obj3 == null && obj4 == null) ? false : (obj3 == null || obj4 == null) ? true : !obj3.equals(obj4)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean isValidTarget(View view) {
        int id = view.getId();
        ArrayList arrayList = this.mTargetIds;
        int size = arrayList.size();
        ArrayList arrayList2 = this.mTargets;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    public void pause(View view) {
        if (this.mEnded) {
            return;
        }
        ArrayList arrayList = this.mCurrentAnimators;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Animator) arrayList.get(size)).pause();
        }
        ArrayList arrayList2 = this.mListeners;
        if (arrayList2 != null && arrayList2.size() > 0) {
            ArrayList arrayList3 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList3.size();
            for (int i = 0; i < size2; i++) {
                ((g) arrayList3.get(i)).onTransitionPause();
            }
        }
        this.mPaused = true;
    }

    public void removeListener(g gVar) {
        ArrayList arrayList = this.mListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(gVar);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
    }

    public void removeTarget(View view) {
        this.mTargets.remove(view);
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayList arrayList = this.mCurrentAnimators;
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    } else {
                        ((Animator) arrayList.get(size)).resume();
                    }
                }
                ArrayList arrayList2 = this.mListeners;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    ArrayList arrayList3 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList3.size();
                    for (int i = 0; i < size2; i++) {
                        ((g) arrayList3.get(i)).onTransitionResume();
                    }
                }
            }
            this.mPaused = false;
        }
    }

    public void runAnimators() {
        start();
        d7 runningAnimators = getRunningAnimators();
        for (Animator animator : this.mAnimators) {
            if (runningAnimators.containsKey(animator)) {
                start();
                if (animator != null) {
                    animator.addListener(new b(runningAnimators));
                    long j = this.mDuration;
                    if (j >= 0) {
                        animator.setDuration(j);
                    }
                    long j2 = this.mStartDelay;
                    if (j2 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j2);
                    }
                    TimeInterpolator timeInterpolator = this.mInterpolator;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new c());
                    animator.start();
                }
            }
        }
        this.mAnimators.clear();
        end();
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setEpicenterCallback(f fVar) {
        this.mEpicenterCallback = fVar;
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
    }

    public void setPathMotion(ro0 ro0Var) {
        if (ro0Var == null) {
            ro0Var = STRAIGHT_PATH_MOTION;
        }
        this.mPathMotion = ro0Var;
    }

    public void setPropagation() {
    }

    public void setStartDelay(long j) {
        this.mStartDelay = j;
    }

    public final void start() {
        if (this.mNumInstances == 0) {
            ArrayList arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((g) arrayList2.get(i)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public final String toString() {
        return toString(AppConfig.CUSTOM);
    }

    public String toString(String str) {
        StringBuilder sbD = defpackage.e.d(str);
        sbD.append(getClass().getSimpleName());
        sbD.append("@");
        sbD.append(Integer.toHexString(hashCode()));
        sbD.append(": ");
        String string = sbD.toString();
        if (this.mDuration != -1) {
            StringBuilder sbO = ak.o(string, "dur(");
            sbO.append(this.mDuration);
            sbO.append(") ");
            string = sbO.toString();
        }
        if (this.mStartDelay != -1) {
            StringBuilder sbO2 = ak.o(string, "dly(");
            sbO2.append(this.mStartDelay);
            sbO2.append(") ");
            string = sbO2.toString();
        }
        if (this.mInterpolator != null) {
            StringBuilder sbO3 = ak.o(string, "interp(");
            sbO3.append(this.mInterpolator);
            sbO3.append(") ");
            string = sbO3.toString();
        }
        ArrayList arrayList = this.mTargetIds;
        int size = arrayList.size();
        ArrayList arrayList2 = this.mTargets;
        if (size <= 0 && arrayList2.size() <= 0) {
            return string;
        }
        String strJ = ak.j(string, "tgts(");
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (i > 0) {
                    strJ = ak.j(strJ, ", ");
                }
                StringBuilder sbD2 = defpackage.e.d(strJ);
                sbD2.append(arrayList.get(i));
                strJ = sbD2.toString();
            }
        }
        if (arrayList2.size() > 0) {
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                if (i2 > 0) {
                    strJ = ak.j(strJ, ", ");
                }
                StringBuilder sbD3 = defpackage.e.d(strJ);
                sbD3.append(arrayList2.get(i2));
                strJ = sbD3.toString();
            }
        }
        return ak.j(strJ, ")");
    }
}
