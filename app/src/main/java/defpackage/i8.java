package defpackage;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class i8 implements ai, wi, Serializable {
    private final ai completion;

    public i8(ai aiVar) {
        this.completion = aiVar;
    }

    public ai create(ai aiVar) {
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public abstract ai create(Object obj, ai aiVar);

    @Override // defpackage.wi
    public wi getCallerFrame() {
        ai aiVar = this.completion;
        if (aiVar instanceof wi) {
            return (wi) aiVar;
        }
        return null;
    }

    public final ai getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        mk mkVar = (mk) getClass().getAnnotation(mk.class);
        String str = null;
        if (mkVar == null) {
            return null;
        }
        int iV = mkVar.v();
        if (iV > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i = iIntValue >= 0 ? mkVar.l()[iIntValue] : -1;
        m6 m6Var = b2.b;
        m6 m6Var2 = b2.f12a;
        if (m6Var == null) {
            try {
                m6 m6Var3 = new m6(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(XMLRPC.TAG_NAME, null));
                b2.b = m6Var3;
                m6Var = m6Var3;
            } catch (Exception unused2) {
                b2.b = m6Var2;
                m6Var = m6Var2;
            }
        }
        if (m6Var != m6Var2 && (method = (Method) m6Var.a) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = (Method) m6Var.b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = (Method) m6Var.c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strC = mkVar.c();
        } else {
            strC = str + '/' + mkVar.c();
        }
        return new StackTraceElement(strC, mkVar.m(), mkVar.f(), i);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    @Override // defpackage.ai
    public final void resumeWith(Object obj) {
        ai aiVar = this;
        while (true) {
            i8 i8Var = (i8) aiVar;
            ai aiVar2 = i8Var.completion;
            try {
                obj = i8Var.invokeSuspend(obj);
                if (obj == vi.b) {
                    return;
                }
            } catch (Throwable th) {
                obj = new bw0.a(th);
            }
            i8Var.releaseIntercepted();
            if (!(aiVar2 instanceof i8)) {
                aiVar2.resumeWith(obj);
                return;
            }
            aiVar = aiVar2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }
}
