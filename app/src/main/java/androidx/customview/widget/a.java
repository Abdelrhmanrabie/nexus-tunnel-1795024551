package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.a1;
import defpackage.d;
import defpackage.o1;
import defpackage.qd1;
import defpackage.qz;
import defpackage.z11;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends a1 {
    public static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
    public final View mHost;
    public final AccessibilityManager mManager;
    public c mNodeProvider;
    public final Rect mTempScreenRect = new Rect();
    public final Rect mTempParentRect = new Rect();
    public final Rect mTempVisibleRect = new Rect();
    public final int[] mTempGlobalRect = new int[2];
    public int mAccessibilityFocusedVirtualViewId = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
    public int mKeyboardFocusedVirtualViewId = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
    public int mHoveredVirtualViewId = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;

    /* JADX INFO: renamed from: androidx.customview.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class C0009a implements androidx.customview.widget.b.a<o1> {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements androidx.customview.widget.b.InterfaceC0010b<z11, o1> {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c extends qz {
        public c() {
            super(6);
        }

        @Override // defpackage.qz
        public final o1 a(int i) {
            return new o1(AccessibilityNodeInfo.obtain(a.this.obtainAccessibilityNodeInfo(i).a));
        }

        @Override // defpackage.qz
        public final o1 b(int i) {
            a aVar = a.this;
            int i2 = i == 2 ? aVar.mAccessibilityFocusedVirtualViewId : aVar.mKeyboardFocusedVirtualViewId;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i2);
        }

        @Override // defpackage.qz
        public final boolean c(int i, int i2, Bundle bundle) {
            int i3;
            a aVar = a.this;
            View view = aVar.mHost;
            if (i == -1) {
                WeakHashMap weakHashMap = qd1.a;
                return view.performAccessibilityAction(i2, bundle);
            }
            if (i2 == 1) {
                return aVar.requestKeyboardFocusForVirtualView(i);
            }
            if (i2 == 2) {
                return aVar.clearKeyboardFocusForVirtualView(i);
            }
            if (i2 != 64) {
                if (i2 != 128) {
                    return aVar.onPerformActionForVirtualView(i, i2, bundle);
                }
                if (aVar.mAccessibilityFocusedVirtualViewId != i) {
                    return false;
                }
                aVar.mAccessibilityFocusedVirtualViewId = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                view.invalidate();
                aVar.sendEventForVirtualView(i, 65536);
                return true;
            }
            AccessibilityManager accessibilityManager = aVar.mManager;
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i3 = aVar.mAccessibilityFocusedVirtualViewId) == i) {
                return false;
            }
            if (i3 != Integer.MIN_VALUE) {
                aVar.mAccessibilityFocusedVirtualViewId = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                aVar.mHost.invalidate();
                aVar.sendEventForVirtualView(i3, 65536);
            }
            aVar.mAccessibilityFocusedVirtualViewId = i;
            view.invalidate();
            aVar.sendEventForVirtualView(i, AttribFlags.SSH_FILEXFER_ATTR_CTIME);
            return true;
        }
    }

    static {
        new C0009a();
        new b();
    }

    public a(View view) {
        if (view == null) {
            d.AnonymousClass0.m$2("View may not be null");
            throw null;
        }
        this.mHost = view;
        this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        WeakHashMap weakHashMap = qd1.a;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final AccessibilityEvent createEvent(int i, int i2) {
        View view = this.mHost;
        if (i == -1) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
            return accessibilityEventObtain;
        }
        AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain(i2);
        o1 o1VarObtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
        accessibilityEventObtain2.getText().add(o1VarObtainAccessibilityNodeInfo.g());
        AccessibilityNodeInfo accessibilityNodeInfo = o1VarObtainAccessibilityNodeInfo.a;
        accessibilityEventObtain2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityEventObtain2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityEventObtain2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityEventObtain2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityEventObtain2.setChecked(accessibilityNodeInfo.isChecked());
        if (accessibilityEventObtain2.getText().isEmpty() && accessibilityEventObtain2.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain2.setClassName(accessibilityNodeInfo.getClassName());
        accessibilityEventObtain2.setSource(view, i);
        accessibilityEventObtain2.setPackageName(view.getContext().getPackageName());
        return accessibilityEventObtain2;
    }

    @Override // defpackage.a1
    public final qz getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new c();
        }
        return this.mNodeProvider;
    }

    public abstract void getVisibleVirtualViews(ArrayList arrayList);

    public final o1 obtainAccessibilityNodeInfo(int i) {
        View view = this.mHost;
        if (i == -1) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(view);
            o1 o1Var = new o1(accessibilityNodeInfoObtain);
            WeakHashMap weakHashMap = qd1.a;
            view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
            ArrayList arrayList = new ArrayList();
            getVisibleVirtualViews(arrayList);
            if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
                throw new RuntimeException("Views cannot have both real and virtual children");
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                o1Var.a.addChild(view, ((Integer) arrayList.get(i2)).intValue());
            }
            return o1Var;
        }
        AccessibilityNodeInfo accessibilityNodeInfoObtain2 = AccessibilityNodeInfo.obtain();
        o1 o1Var2 = new o1(accessibilityNodeInfoObtain2);
        accessibilityNodeInfoObtain2.setEnabled(true);
        accessibilityNodeInfoObtain2.setFocusable(true);
        o1Var2.i("android.view.View");
        Rect rect = INVALID_PARENT_BOUNDS;
        accessibilityNodeInfoObtain2.setBoundsInParent(rect);
        accessibilityNodeInfoObtain2.setBoundsInScreen(rect);
        accessibilityNodeInfoObtain2.setParent(view);
        onPopulateNodeForVirtualView(i, o1Var2);
        if (o1Var2.g() == null && accessibilityNodeInfoObtain2.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.mTempParentRect;
        o1Var2.f(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain2.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain2.setPackageName(view.getContext().getPackageName());
        o1Var2.c = i;
        accessibilityNodeInfoObtain2.setSource(view, i);
        if (this.mAccessibilityFocusedVirtualViewId == i) {
            accessibilityNodeInfoObtain2.setAccessibilityFocused(true);
            o1Var2.a(128);
        } else {
            accessibilityNodeInfoObtain2.setAccessibilityFocused(false);
            o1Var2.a(64);
        }
        boolean z = this.mKeyboardFocusedVirtualViewId == i;
        if (z) {
            o1Var2.a(2);
        } else if (accessibilityNodeInfoObtain2.isFocusable()) {
            o1Var2.a(1);
        }
        accessibilityNodeInfoObtain2.setFocused(z);
        int[] iArr = this.mTempGlobalRect;
        view.getLocationOnScreen(iArr);
        Rect rect3 = this.mTempScreenRect;
        accessibilityNodeInfoObtain2.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            o1Var2.f(rect3);
            rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
        }
        Rect rect4 = this.mTempVisibleRect;
        if (view.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
            if (rect3.intersect(rect4)) {
                accessibilityNodeInfoObtain2.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                    do {
                        Object parent = view.getParent();
                        if (!(parent instanceof View)) {
                            if (parent == null) {
                                break;
                            }
                            accessibilityNodeInfoObtain2.setVisibleToUser(true);
                            break;
                        }
                        view = (View) parent;
                        if (view.getAlpha() <= 0.0f) {
                            break;
                        }
                    } while (view.getVisibility() == 0);
                }
            }
        }
        return o1Var2;
    }

    @Override // defpackage.a1
    public final void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, o1Var.a);
        onPopulateNodeForHost(o1Var);
    }

    public abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    public void onPopulateNodeForHost(o1 o1Var) {
    }

    public abstract void onPopulateNodeForVirtualView(int i, o1 o1Var);

    public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        int i2;
        View view = this.mHost;
        if ((!view.isFocused() && !view.requestFocus()) || (i2 = this.mKeyboardFocusedVirtualViewId) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = i;
        onVirtualViewKeyboardFocusChanged(i, true);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final void sendEventForVirtualView(int i, int i2) {
        View view;
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = (view = this.mHost).getParent()) == null) {
            return;
        }
        parent.requestSendAccessibilityEvent(view, createEvent(i, i2));
    }
}
