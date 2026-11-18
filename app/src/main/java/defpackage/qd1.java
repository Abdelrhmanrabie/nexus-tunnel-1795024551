package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class qd1 {
    public static WeakHashMap a = null;
    public static Field b = null;
    public static boolean c = false;
    public static final int[] d = {R.attr.af, R.attr.ag, R.attr.ar, R.attr.b2, R.attr.b5, R.attr.b6, R.attr.b7, R.attr.b8, R.attr.b9, R.attr.b_, R.attr.ah, R.attr.ai, R.attr.aj, R.attr.ak, R.attr.al, R.attr.am, R.attr.an, R.attr.ao, R.attr.ap, R.attr.aq, R.attr.as, R.attr.at, R.attr.au, R.attr.av, R.attr.aw, R.attr.ax, R.attr.ay, R.attr.az, R.attr.b0, R.attr.b1, R.attr.b3, R.attr.b4};
    public static final a f = new a();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        public final WeakHashMap b = new WeakHashMap();

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry entry : this.b.entrySet()) {
                    View view = (View) entry.getKey();
                    boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
                    boolean z = view.isShown() && view.getWindowVisibility() == 0;
                    if (zBooleanValue != z) {
                        qd1.g(view, z ? 16 : 32);
                        entry.setValue(Boolean.valueOf(z));
                    }
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: renamed from: qd1$d$a, reason: case insensitive filesystem */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class ViewOnApplyWindowInsetsListenerC0049a implements View.OnApplyWindowInsetsListener {
        public fg1 a = null;
        public final /* synthetic */ View b;
        public final /* synthetic */ lm0 c;

        public ViewOnApplyWindowInsetsListenerC0049a(View view, lm0 lm0Var) {
            this.b = view;
            this.c = lm0Var;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            fg1 fg1VarG = fg1.g(view, windowInsets);
            int i = Build.VERSION.SDK_INT;
            lm0 lm0Var = this.c;
            if (i < 30) {
                View view2 = this.b;
                View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view2.getTag(R.attr.a0g);
                if (onApplyWindowInsetsListener != null) {
                    onApplyWindowInsetsListener.onApplyWindowInsets(view2, windowInsets);
                }
                if (fg1VarG.equals(this.a)) {
                    return lm0Var.onApplyWindowInsets(view, fg1VarG).f();
                }
            }
            this.a = fg1VarG;
            fg1 fg1VarOnApplyWindowInsets = lm0Var.onApplyWindowInsets(view, fg1VarG);
            if (i >= 30) {
                return fg1VarOnApplyWindowInsets.f();
            }
            WeakHashMap weakHashMap = qd1.a;
            view.requestApplyInsets();
            return fg1VarOnApplyWindowInsets.f();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class n {
        public static final ArrayList d = new ArrayList();
        public WeakHashMap a = null;
        public SparseArray b = null;
        public WeakReference c = null;

        public final View a(View view) {
            int size;
            View viewA;
            WeakHashMap weakHashMap = this.a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    do {
                        childCount--;
                        if (childCount >= 0) {
                            viewA = a(viewGroup.getChildAt(childCount));
                        }
                    } while (viewA == null);
                    return viewA;
                }
                ArrayList arrayList = (ArrayList) view.getTag(R.attr.a0f);
                if (arrayList != null && (size = arrayList.size() - 1) >= 0) {
                    arrayList.get(size).getClass();
                    d.AnonymousClass0.m$1();
                }
            }
            return null;
        }
    }

    public static je1 a(View view) {
        if (a == null) {
            a = new WeakHashMap();
        }
        je1 je1Var = (je1) a.get(view);
        if (je1Var != null) {
            return je1Var;
        }
        je1 je1Var2 = new je1(view);
        a.put(view, je1Var2);
        return je1Var2;
    }

    public static void b(View view, fg1 fg1Var) {
        WindowInsets windowInsetsF = fg1Var.f();
        if (windowInsetsF != null) {
            WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsetsF);
            if (windowInsetsDispatchApplyWindowInsets.equals(windowInsetsF)) {
                return;
            }
            fg1.g(view, windowInsetsDispatchApplyWindowInsets);
        }
    }

    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = n.d;
        n nVar = (n) view.getTag(R.attr.a0e);
        if (nVar == null) {
            nVar = new n();
            view.setTag(R.attr.a0e, nVar);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = nVar.a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = n.d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (nVar.a == null) {
                            nVar.a = new WeakHashMap();
                        }
                        int size = arrayList2.size();
                        while (true) {
                            size--;
                            if (size < 0) {
                                break;
                            }
                            ArrayList arrayList3 = n.d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                nVar.a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    nVar.a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        View viewA = nVar.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewA != null && !KeyEvent.isModifierKey(keyCode)) {
                if (nVar.b == null) {
                    nVar.b = new SparseArray();
                }
                nVar.b.put(keyCode, new WeakReference(viewA));
            }
        }
        return viewA != null;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        if (c) {
            return null;
        }
        if (b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                c = true;
                return null;
            }
        }
        Object obj = b.get(view);
        if (obj instanceof View.AccessibilityDelegate) {
            return (View.AccessibilityDelegate) obj;
        }
        return null;
    }

    public static ArrayList e(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.attr.a05);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.attr.a05, arrayList2);
        return arrayList2;
    }

    public static String[] f(p5 p5Var) {
        return Build.VERSION.SDK_INT >= 31 ? p5Var.getReceiveContentMimeTypes() : (String[]) p5Var.getTag(R.attr.a0a);
    }

    public static void g(View view, int i) {
        Object tag;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            int i2 = Build.VERSION.SDK_INT;
            boolean z = false;
            Object accessibilityPaneTitle = null;
            if (i2 >= 28) {
                tag = view.getAccessibilityPaneTitle();
            } else {
                tag = view.getTag(R.attr.a08);
                if (!CharSequence.class.isInstance(tag)) {
                    tag = null;
                }
            }
            if (((CharSequence) tag) != null && view.isShown() && view.getWindowVisibility() == 0) {
                z = true;
            }
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z) {
                    List<CharSequence> text = accessibilityEventObtain.getText();
                    if (i2 >= 28) {
                        accessibilityPaneTitle = view.getAccessibilityPaneTitle();
                    } else {
                        Object tag2 = view.getTag(R.attr.a08);
                        if (CharSequence.class.isInstance(tag2)) {
                            accessibilityPaneTitle = tag2;
                        }
                    }
                    text.add((CharSequence) accessibilityPaneTitle);
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError unused) {
                        view.getParent().getClass();
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            List<CharSequence> text2 = accessibilityEventObtain2.getText();
            if (i2 >= 28) {
                accessibilityPaneTitle = view.getAccessibilityPaneTitle();
            } else {
                Object tag3 = view.getTag(R.attr.a08);
                if (CharSequence.class.isInstance(tag3)) {
                    accessibilityPaneTitle = tag3;
                }
            }
            text2.add((CharSequence) accessibilityPaneTitle);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static bj h(p5 p5Var, bj bjVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Objects.toString(bjVar);
            p5Var.getId();
        }
        if (Build.VERSION.SDK_INT < 31) {
            if (((i61) p5Var.getTag(R.attr.a0_)) == null) {
                return p5Var.onReceiveContent(bjVar);
            }
            bj bjVarA = i61.a(p5Var, bjVar);
            if (bjVarA == null) {
                return null;
            }
            return p5Var.onReceiveContent(bjVarA);
        }
        ContentInfo contentInfoA = ((mh$e) bjVar.a).a();
        Objects.requireNonNull(contentInfoA);
        ContentInfo contentInfoPerformReceiveContent = p5Var.performReceiveContent(contentInfoA);
        if (contentInfoPerformReceiveContent == null) {
            return null;
        }
        if (contentInfoPerformReceiveContent == contentInfoA) {
            return bjVar;
        }
        return new bj(26, new bj(contentInfoPerformReceiveContent));
    }

    public static void i(View view, int i) {
        ArrayList arrayListE = e(view);
        for (int i2 = 0; i2 < arrayListE.size(); i2++) {
            if (((o1.a) arrayListE.get(i2)).a() == i) {
                arrayListE.remove(i2);
                return;
            }
        }
    }

    public static void j(View view, o1.a aVar, s1 s1Var) {
        a1 a1Var;
        if (s1Var == null) {
            i(view, aVar.a());
        } else {
            o1.a aVar2 = new o1.a(null, aVar.b, null, s1Var, aVar.c);
            View.AccessibilityDelegate accessibilityDelegateD = d(view);
            if (accessibilityDelegateD == null) {
                a1Var = null;
            } else {
                a1Var = accessibilityDelegateD instanceof a1.a ? ((a1.a) accessibilityDelegateD).a : new a1(accessibilityDelegateD);
            }
            if (a1Var == null) {
                a1Var = new a1();
            }
            l(view, a1Var);
            i(view, aVar2.a());
            e(view).add(aVar2);
        }
        g(view, 0);
    }

    public static void k(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    public static void l(View view, a1 a1Var) {
        if (a1Var == null && (d(view) instanceof a1.a)) {
            a1Var = new a1();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(a1Var == null ? null : a1Var.mBridge);
    }

    public static void m(CharSequence charSequence, View view) {
        new md1(R.attr.a08, CharSequence.class, 8, 28, 1).e(view, charSequence);
        a aVar = f;
        if (charSequence == null) {
            aVar.b.remove(view);
            view.removeOnAttachStateChangeListener(aVar);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(aVar);
        } else {
            aVar.b.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(aVar);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
            }
        }
    }
}
