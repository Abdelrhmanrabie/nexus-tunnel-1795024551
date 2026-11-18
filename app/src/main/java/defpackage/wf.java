package defpackage;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class wf extends RuntimeException {
    public final List b;
    public final String c;
    public Throwable d;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends v3 {
        public final /* synthetic */ int G0;
        public final Object a;

        public /* synthetic */ c(int i, Object obj) {
            this.G0 = i;
            this.a = obj;
        }

        @Override // defpackage.v3
        public final v3 a(Serializable serializable) {
            int i = this.G0;
            Object obj = this.a;
            if (i != 0) {
                ((PrintWriter) obj).print(serializable);
                return this;
            }
            ((PrintStream) obj).print(serializable);
            return this;
        }
    }

    public wf(List list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (list != null) {
            for (Object obj : list) {
                if (obj instanceof wf) {
                    linkedHashSet.addAll(((wf) obj).b);
                } else {
                    linkedHashSet.add(obj == null ? new NullPointerException("Throwable was null!") : obj);
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty()) {
            d.AnonymousClass0.m$2("errors is empty");
            throw null;
        }
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(linkedHashSet));
        this.b = listUnmodifiableList;
        this.c = listUnmodifiableList.size() + " exceptions occurred. ";
    }

    public static void a(v3 v3Var, Throwable th, String str) {
        v3Var.a((Serializable) str).a((Serializable) th).a((Serializable) '\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            v3Var.a("\t\tat ").a((Serializable) stackTraceElement).a((Serializable) '\n');
        }
        if (th.getCause() != null) {
            v3Var.a("\tCaused by: ");
            a(v3Var, th.getCause(), AppConfig.CUSTOM);
        }
    }

    public final void b(v3 v3Var) {
        v3Var.a((Serializable) this).a("\n");
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            v3Var.a("\tat ").a((Serializable) stackTraceElement).a("\n");
        }
        int i = 1;
        for (Throwable th : this.b) {
            v3Var.a("  ComposedException ").a((Serializable) Integer.valueOf(i)).a(" :\n");
            a(v3Var, th, "\t");
            i++;
        }
        v3Var.a("\n");
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable getCause() {
        Throwable weVar;
        int i;
        try {
            if (this.d == null) {
                String property = System.getProperty("line.separator");
                if (this.b.size() > 1) {
                    IdentityHashMap identityHashMap = new IdentityHashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Multiple exceptions (");
                    sb.append(this.b.size());
                    sb.append(")");
                    sb.append(property);
                    for (Throwable cause : this.b) {
                        int i2 = 0;
                        while (cause != null) {
                            for (int i3 = 0; i3 < i2; i3++) {
                                sb.append("  ");
                            }
                            sb.append("|-- ");
                            sb.append(cause.getClass().getCanonicalName());
                            sb.append(": ");
                            String message = cause.getMessage();
                            if (message == null || !message.contains(property)) {
                                sb.append(message);
                                sb.append(property);
                            } else {
                                sb.append(property);
                                for (String str : message.split(property)) {
                                    for (int i4 = 0; i4 < i2 + 2; i4++) {
                                        sb.append("  ");
                                    }
                                    sb.append(str);
                                    sb.append(property);
                                }
                            }
                            int i5 = 0;
                            while (true) {
                                i = i2 + 2;
                                if (i5 >= i) {
                                    break;
                                }
                                sb.append("  ");
                                i5++;
                            }
                            StackTraceElement[] stackTrace = cause.getStackTrace();
                            if (stackTrace.length > 0) {
                                sb.append("at ");
                                sb.append(stackTrace[0]);
                                sb.append(property);
                            }
                            if (identityHashMap.containsKey(cause)) {
                                Throwable cause2 = cause.getCause();
                                if (cause2 == null) {
                                    break;
                                }
                                for (int i6 = 0; i6 < i; i6++) {
                                    sb.append("  ");
                                }
                                sb.append("|-- ");
                                sb.append("(cause not expanded again) ");
                                sb.append(cause2.getClass().getCanonicalName());
                                sb.append(": ");
                                sb.append(cause2.getMessage());
                                sb.append(property);
                                break;
                            }
                            identityHashMap.put(cause, Boolean.TRUE);
                            cause = cause.getCause();
                            i2++;
                        }
                    }
                    weVar = new we(sb.toString().trim(), 5);
                } else {
                    weVar = (Throwable) this.b.get(0);
                }
                this.d = weVar;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.d;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.c;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        b(new c(0, printStream));
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        b(new c(1, printWriter));
    }
}
