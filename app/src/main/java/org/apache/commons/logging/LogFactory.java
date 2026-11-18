package org.apache.commons.logging;

import defpackage.d;
import defpackage.qp;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Hashtable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class LogFactory {
    public static /* synthetic */ Class class$org$apache$commons$logging$LogFactory;
    public static final String diagnosticPrefix;
    public static final PrintStream diagnosticsStream;
    public static final Hashtable factories;
    public static final ClassLoader thisClassLoader;

    /* JADX INFO: renamed from: org.apache.commons.logging.LogFactory$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class AnonymousClass1 implements PrivilegedAction {
        @Override // java.security.PrivilegedAction
        public final Object run() {
            Class cls = LogFactory.class$org$apache$commons$logging$LogFactory;
            try {
                return Thread.currentThread().getContextClassLoader();
            } catch (SecurityException unused) {
                return null;
            }
        }
    }

    static {
        String strObjectId;
        PrintStream printStream;
        String str;
        Class<LogFactory> cls = class$org$apache$commons$logging$LogFactory;
        Class<LogFactory> cls2 = LogFactory.class;
        if (cls == null) {
            class$();
            class$org$apache$commons$logging$LogFactory = cls2;
            cls = cls2;
        }
        ClassLoader classLoader = getClassLoader(cls);
        thisClassLoader = classLoader;
        if (classLoader == null) {
            strObjectId = "BOOTLOADER";
        } else {
            try {
                strObjectId = objectId(classLoader);
            } catch (SecurityException unused) {
                strObjectId = "UNKNOWN";
            }
        }
        StringBuffer stringBuffer = new StringBuffer("[LogFactory from ");
        stringBuffer.append(strObjectId);
        stringBuffer.append("] ");
        diagnosticPrefix = stringBuffer.toString();
        Hashtable hashtable = null;
        try {
            String str2 = (String) AccessController.doPrivileged(new qp(2, "org.apache.commons.logging.diagnostics.dest"));
            if (str2 == null) {
                printStream = null;
            } else if (str2.equals("STDOUT")) {
                printStream = System.out;
            } else {
                printStream = str2.equals("STDERR") ? System.err : new PrintStream(new FileOutputStream(str2, true));
            }
        } catch (IOException | SecurityException unused2) {
        }
        diagnosticsStream = printStream;
        Class<LogFactory> cls3 = class$org$apache$commons$logging$LogFactory;
        if (cls3 == null) {
            class$();
            class$org$apache$commons$logging$LogFactory = cls2;
        } else {
            cls2 = cls3;
        }
        if (isDiagnosticsEnabled()) {
            try {
                StringBuffer stringBuffer2 = new StringBuffer("[ENV] Extension directories (java.ext.dir): ");
                stringBuffer2.append(System.getProperty("java.ext.dir"));
                logDiagnostic(stringBuffer2.toString());
                StringBuffer stringBuffer3 = new StringBuffer("[ENV] Application classpath (java.class.path): ");
                stringBuffer3.append(System.getProperty("java.class.path"));
                logDiagnostic(stringBuffer3.toString());
            } catch (SecurityException unused3) {
                logDiagnostic("[ENV] Security setting prevent interrogation of system classpaths.");
            }
            String name = cls2.getName();
            try {
                ClassLoader classLoader2 = getClassLoader(cls2);
                StringBuffer stringBuffer4 = new StringBuffer("[ENV] Class ");
                stringBuffer4.append(name);
                stringBuffer4.append(" was loaded via classloader ");
                stringBuffer4.append(objectId(classLoader2));
                logDiagnostic(stringBuffer4.toString());
                StringBuffer stringBuffer5 = new StringBuffer("[ENV] Ancestry of classloader which loaded ");
                stringBuffer5.append(name);
                stringBuffer5.append(" is ");
                logHierarchy(classLoader2, stringBuffer5.toString());
            } catch (SecurityException unused4) {
                logDiagnostic("[ENV] Security forbids determining the classloader for ".concat(name));
            }
        }
        try {
            str = (String) AccessController.doPrivileged(new qp(2, "org.apache.commons.logging.LogFactory.HashtableImpl"));
        } catch (SecurityException unused5) {
            str = null;
        }
        if (str == null) {
            str = "org.apache.commons.logging.impl.WeakHashtable";
        }
        try {
            hashtable = (Hashtable) Class.forName(str).newInstance();
        } catch (Throwable th) {
            if (th instanceof ThreadDeath) {
                throw ((ThreadDeath) th);
            }
            if (th instanceof VirtualMachineError) {
                throw ((VirtualMachineError) th);
            }
            if (!"org.apache.commons.logging.impl.WeakHashtable".equals(str)) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("[ERROR] LogFactory: Load of custom hashtable failed");
                } else {
                    System.err.println("[ERROR] LogFactory: Load of custom hashtable failed");
                }
            }
        }
        if (hashtable == null) {
            hashtable = new Hashtable();
        }
        factories = hashtable;
        if (isDiagnosticsEnabled()) {
            logDiagnostic("BOOTSTRAP COMPLETED");
        }
    }

    public static /* synthetic */ Class class$() {
        return LogFactory.class;
    }

    public static ClassLoader getClassLoader(Class cls) {
        try {
            return cls.getClassLoader();
        } catch (SecurityException e) {
            if (isDiagnosticsEnabled()) {
                StringBuffer stringBuffer = new StringBuffer("Unable to get classloader for class '");
                stringBuffer.append(cls);
                stringBuffer.append("' due to security restrictions - ");
                stringBuffer.append(e.getMessage());
                logDiagnostic(stringBuffer.toString());
            }
            throw e;
        }
    }

    public static boolean implementsLogFactory(Class cls) {
        StringBuffer stringBuffer;
        String string;
        StringBuffer stringBuffer2;
        String str;
        String string2;
        boolean zIsAssignableFrom = false;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    string2 = "[CUSTOM LOG FACTORY] was loaded by the boot classloader";
                } else {
                    logHierarchy(classLoader, "[CUSTOM LOG FACTORY] ");
                    zIsAssignableFrom = Class.forName("org.apache.commons.logging.LogFactory", false, classLoader).isAssignableFrom(cls);
                    if (zIsAssignableFrom) {
                        stringBuffer2 = new StringBuffer("[CUSTOM LOG FACTORY] ");
                        stringBuffer2.append(cls.getName());
                        str = " implements LogFactory but was loaded by an incompatible classloader.";
                    } else {
                        stringBuffer2 = new StringBuffer("[CUSTOM LOG FACTORY] ");
                        stringBuffer2.append(cls.getName());
                        str = " does not implement LogFactory.";
                    }
                    stringBuffer2.append(str);
                    string2 = stringBuffer2.toString();
                }
                logDiagnostic(string2);
                return zIsAssignableFrom;
            } catch (ClassNotFoundException unused) {
                string = "[CUSTOM LOG FACTORY] LogFactory class cannot be loaded by classloader which loaded the custom LogFactory implementation. Is the custom factory in the right classloader?";
                logDiagnostic(string);
                return zIsAssignableFrom;
            } catch (LinkageError e) {
                e = e;
                stringBuffer = new StringBuffer("[CUSTOM LOG FACTORY] LinkageError thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: ");
                stringBuffer.append(e.getMessage());
                string = stringBuffer.toString();
                logDiagnostic(string);
                return zIsAssignableFrom;
            } catch (SecurityException e2) {
                e = e2;
                stringBuffer = new StringBuffer("[CUSTOM LOG FACTORY] SecurityException thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: ");
                stringBuffer.append(e.getMessage());
                string = stringBuffer.toString();
                logDiagnostic(string);
                return zIsAssignableFrom;
            }
        }
        return zIsAssignableFrom;
    }

    public static boolean isDiagnosticsEnabled() {
        return diagnosticsStream != null;
    }

    public static final void logDiagnostic(String str) {
        PrintStream printStream = diagnosticsStream;
        if (printStream != null) {
            printStream.print(diagnosticPrefix);
            printStream.println(str);
            printStream.flush();
        }
    }

    public static void logHierarchy(ClassLoader classLoader, String str) {
        String string;
        String str2;
        if (!isDiagnosticsEnabled()) {
            return;
        }
        if (classLoader != null) {
            String string2 = classLoader.toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(objectId(classLoader));
            stringBuffer.append(" == '");
            stringBuffer.append(string2);
            stringBuffer.append("'");
            logDiagnostic(stringBuffer.toString());
        }
        try {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            if (classLoader != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(str);
                stringBuffer2.append("ClassLoader tree:");
                StringBuffer stringBuffer3 = new StringBuffer(stringBuffer2.toString());
                do {
                    stringBuffer3.append(objectId(classLoader));
                    if (classLoader == systemClassLoader) {
                        stringBuffer3.append(" (SYSTEM) ");
                    }
                    try {
                        classLoader = classLoader.getParent();
                        stringBuffer3.append(" --> ");
                    } catch (SecurityException unused) {
                        str2 = " --> SECRET";
                    }
                } while (classLoader != null);
                str2 = "BOOT";
                stringBuffer3.append(str2);
                string = stringBuffer3.toString();
                logDiagnostic(string);
            }
        } catch (SecurityException unused2) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(str);
            stringBuffer4.append("Security forbids determining the system classloader.");
            string = stringBuffer4.toString();
        }
    }

    public static void newFactory(final String str, final ClassLoader classLoader, ClassLoader classLoader2) {
        Object objDoPrivileged = AccessController.doPrivileged((PrivilegedAction<Object>) new PrivilegedAction() { // from class: org.apache.commons.logging.LogFactory.2
            /* JADX WARN: Code duplicated, block: B:63:0x0160 A[Catch: Exception -> 0x002a, TryCatch #1 {Exception -> 0x002a, blocks: (B:5:0x001f, B:7:0x0023, B:14:0x0034, B:16:0x003a, B:18:0x0040, B:25:0x00a9, B:28:0x00b0, B:29:0x00b5, B:19:0x0060, B:21:0x0066, B:23:0x008b, B:24:0x0091, B:49:0x010e, B:51:0x0114, B:52:0x0132, B:61:0x015a, B:63:0x0160, B:64:0x0178, B:56:0x0137, B:58:0x013d, B:59:0x0158, B:34:0x00bc, B:36:0x00d1, B:37:0x00d7, B:39:0x00e5, B:41:0x00ee, B:43:0x00f9, B:44:0x0100, B:45:0x0109, B:40:0x00e9), top: B:86:0x0019 }] */
            /* JADX WARN: Code duplicated, block: B:67:0x0182  */
            /* JADX WARN: Code duplicated, block: B:68:0x0183 A[Catch: Exception -> 0x0189, TryCatch #2 {Exception -> 0x0189, blocks: (B:65:0x017c, B:68:0x0183, B:69:0x0188), top: B:87:0x017c }] */
            /* JADX WARN: Code duplicated, block: B:74:0x0192  */
            /* JADX WARN: Code duplicated, block: B:76:0x0199  */
            /* JADX WARN: Code duplicated, block: B:78:0x019d  */
            /* JADX WARN: Code duplicated, block: B:79:0x01a3  */
            /* JADX WARN: Code duplicated, block: B:82:0x01aa  */
            /* JADX WARN: Not initialized variable reg: 13, insn: 0x002b: MOVE (r12 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:9:0x002b */
            @Override // java.security.PrivilegedAction
            public final Object run() {
                Class<?> cls;
                Class<LogFactory> cls2;
                Class<?> clsLoadClass;
                Class<?> cls3;
                ClassLoader classLoader3 = LogFactory.thisClassLoader;
                String str2 = str;
                ClassLoader classLoader4 = classLoader;
                Class<LogFactory> cls4 = LogFactory.class;
                Class<?> cls5 = null;
                try {
                    if (classLoader4 != null) {
                        try {
                            clsLoadClass = classLoader4.loadClass(str2);
                            try {
                                Class<LogFactory> cls6 = LogFactory.class$org$apache$commons$logging$LogFactory;
                                if (cls6 == null) {
                                    LogFactory.class$();
                                    LogFactory.class$org$apache$commons$logging$LogFactory = cls4;
                                    cls6 = cls4;
                                }
                                if (cls6.isAssignableFrom(clsLoadClass)) {
                                    if (LogFactory.isDiagnosticsEnabled()) {
                                        StringBuffer stringBuffer = new StringBuffer("Loaded class ");
                                        stringBuffer.append(clsLoadClass.getName());
                                        stringBuffer.append(" from classloader ");
                                        stringBuffer.append(LogFactory.objectId(classLoader4));
                                        LogFactory.logDiagnostic(stringBuffer.toString());
                                    }
                                } else if (LogFactory.isDiagnosticsEnabled()) {
                                    StringBuffer stringBuffer2 = new StringBuffer("Factory class ");
                                    stringBuffer2.append(clsLoadClass.getName());
                                    stringBuffer2.append(" loaded from classloader ");
                                    stringBuffer2.append(LogFactory.objectId(clsLoadClass.getClassLoader()));
                                    stringBuffer2.append(" does not extend '");
                                    Class<LogFactory> cls7 = LogFactory.class$org$apache$commons$logging$LogFactory;
                                    if (cls7 == null) {
                                        LogFactory.class$();
                                        LogFactory.class$org$apache$commons$logging$LogFactory = cls4;
                                        cls7 = cls4;
                                    }
                                    stringBuffer2.append(cls7.getName());
                                    stringBuffer2.append("' as loaded by this classloader.");
                                    LogFactory.logDiagnostic(stringBuffer2.toString());
                                    LogFactory.logHierarchy(classLoader4, "[BAD CL TREE] ");
                                }
                                if (clsLoadClass.newInstance() == null) {
                                    return null;
                                }
                                throw new ClassCastException();
                            } catch (ClassCastException unused) {
                                if (classLoader4 == classLoader3) {
                                    boolean zImplementsLogFactory = LogFactory.implementsLogFactory(clsLoadClass);
                                    StringBuffer stringBuffer3 = new StringBuffer("The application has specified that a custom LogFactory implementation should be used but Class '");
                                    stringBuffer3.append(str2);
                                    stringBuffer3.append("' cannot be converted to '");
                                    Class<LogFactory> cls8 = LogFactory.class$org$apache$commons$logging$LogFactory;
                                    if (cls8 == null) {
                                        LogFactory.class$();
                                        LogFactory.class$org$apache$commons$logging$LogFactory = cls4;
                                        cls8 = cls4;
                                    }
                                    stringBuffer3.append(cls8.getName());
                                    stringBuffer3.append("'. ");
                                    if (zImplementsLogFactory) {
                                        stringBuffer3.append("The conflict is caused by the presence of multiple LogFactory classes in incompatible classloaders. Background can be found in http://commons.apache.org/logging/tech.html. If you have not explicitly specified a custom LogFactory then it is likely that the container has set one without your knowledge. In this case, consider using the commons-logging-adapters.jar file or specifying the standard LogFactory from the command line. ");
                                    } else {
                                        stringBuffer3.append("Please check the custom implementation. ");
                                    }
                                    stringBuffer3.append("Help can be found @http://commons.apache.org/logging/troubleshooting.html.");
                                    if (LogFactory.isDiagnosticsEnabled()) {
                                        LogFactory.logDiagnostic(stringBuffer3.toString());
                                    }
                                    throw new ClassCastException(stringBuffer3.toString());
                                }
                                if (LogFactory.isDiagnosticsEnabled()) {
                                    StringBuffer stringBuffer4 = new StringBuffer("Unable to load factory class via classloader ");
                                    stringBuffer4.append(LogFactory.objectId(classLoader4));
                                    stringBuffer4.append(" - trying the classloader associated with this LogFactory.");
                                    LogFactory.logDiagnostic(stringBuffer4.toString());
                                }
                                cls3 = Class.forName(str2);
                                if (cls3.newInstance() == null) {
                                    return null;
                                }
                                throw new ClassCastException();
                            } catch (ClassNotFoundException e) {
                                e = e;
                                if (classLoader4 == classLoader3) {
                                    if (LogFactory.isDiagnosticsEnabled()) {
                                        StringBuffer stringBuffer5 = new StringBuffer("Unable to locate any class called '");
                                        stringBuffer5.append(str2);
                                        stringBuffer5.append("' via classloader ");
                                        stringBuffer5.append(LogFactory.objectId(classLoader4));
                                        LogFactory.logDiagnostic(stringBuffer5.toString());
                                    }
                                    throw e;
                                }
                                if (LogFactory.isDiagnosticsEnabled()) {
                                    StringBuffer stringBuffer6 = new StringBuffer("Unable to load factory class via classloader ");
                                    stringBuffer6.append(LogFactory.objectId(classLoader4));
                                    stringBuffer6.append(" - trying the classloader associated with this LogFactory.");
                                    LogFactory.logDiagnostic(stringBuffer6.toString());
                                }
                                cls3 = Class.forName(str2);
                                if (cls3.newInstance() == null) {
                                    return null;
                                }
                                throw new ClassCastException();
                            } catch (NoClassDefFoundError e2) {
                                e = e2;
                                if (classLoader4 == classLoader3) {
                                    if (LogFactory.isDiagnosticsEnabled()) {
                                        StringBuffer stringBuffer7 = new StringBuffer("Class '");
                                        stringBuffer7.append(str2);
                                        stringBuffer7.append("' cannot be loaded via classloader ");
                                        stringBuffer7.append(LogFactory.objectId(classLoader4));
                                        stringBuffer7.append(" - it depends on some other class that cannot be found.");
                                        LogFactory.logDiagnostic(stringBuffer7.toString());
                                    }
                                    throw e;
                                }
                                if (LogFactory.isDiagnosticsEnabled()) {
                                    StringBuffer stringBuffer8 = new StringBuffer("Unable to load factory class via classloader ");
                                    stringBuffer8.append(LogFactory.objectId(classLoader4));
                                    stringBuffer8.append(" - trying the classloader associated with this LogFactory.");
                                    LogFactory.logDiagnostic(stringBuffer8.toString());
                                }
                                cls3 = Class.forName(str2);
                                if (cls3.newInstance() == null) {
                                    return null;
                                }
                                throw new ClassCastException();
                            }
                        } catch (ClassCastException unused2) {
                            clsLoadClass = null;
                        } catch (ClassNotFoundException e3) {
                            e = e3;
                        } catch (Exception e4) {
                            e = e4;
                            if (LogFactory.isDiagnosticsEnabled()) {
                                LogFactory.logDiagnostic("Unable to create LogFactory instance.");
                            }
                            if (cls5 != null) {
                                cls2 = LogFactory.class$org$apache$commons$logging$LogFactory;
                                if (cls2 == null) {
                                    LogFactory.class$();
                                    LogFactory.class$org$apache$commons$logging$LogFactory = cls4;
                                } else {
                                    cls4 = cls2;
                                }
                                if (!cls4.isAssignableFrom(cls5)) {
                                    return new LogConfigurationException("The chosen LogFactory implementation does not extend LogFactory. Please check your configuration.", e);
                                }
                            }
                            return new LogConfigurationException(e.toString(), e);
                        } catch (NoClassDefFoundError e5) {
                            e = e5;
                        }
                    }
                    if (LogFactory.isDiagnosticsEnabled()) {
                        StringBuffer stringBuffer9 = new StringBuffer("Unable to load factory class via classloader ");
                        stringBuffer9.append(LogFactory.objectId(classLoader4));
                        stringBuffer9.append(" - trying the classloader associated with this LogFactory.");
                        LogFactory.logDiagnostic(stringBuffer9.toString());
                    }
                    cls3 = Class.forName(str2);
                    try {
                        if (cls3.newInstance() == null) {
                            return null;
                        }
                        throw new ClassCastException();
                    } catch (Exception e6) {
                        cls5 = cls3;
                        e = e6;
                        if (LogFactory.isDiagnosticsEnabled()) {
                            LogFactory.logDiagnostic("Unable to create LogFactory instance.");
                        }
                        if (cls5 != null) {
                            cls2 = LogFactory.class$org$apache$commons$logging$LogFactory;
                            if (cls2 == null) {
                                LogFactory.class$();
                                LogFactory.class$org$apache$commons$logging$LogFactory = cls4;
                            } else {
                                cls4 = cls2;
                            }
                            if (!cls4.isAssignableFrom(cls5)) {
                                return new LogConfigurationException("The chosen LogFactory implementation does not extend LogFactory. Please check your configuration.", e);
                            }
                        }
                        return new LogConfigurationException(e.toString(), e);
                    }
                } catch (Exception e7) {
                    e = e7;
                    cls5 = cls;
                }
            }
        });
        if (objDoPrivileged instanceof LogConfigurationException) {
            LogConfigurationException logConfigurationException = (LogConfigurationException) objDoPrivileged;
            if (!isDiagnosticsEnabled()) {
                throw logConfigurationException;
            }
            StringBuffer stringBuffer = new StringBuffer("An error occurred while loading the factory class:");
            stringBuffer.append(logConfigurationException.getMessage());
            logDiagnostic(stringBuffer.toString());
            throw logConfigurationException;
        }
        if (isDiagnosticsEnabled()) {
            StringBuffer stringBuffer2 = new StringBuffer("Created object ");
            stringBuffer2.append(objectId(objDoPrivileged));
            stringBuffer2.append(" to manage classloader ");
            stringBuffer2.append(objectId(classLoader2));
            logDiagnostic(stringBuffer2.toString());
        }
        if (objDoPrivileged == null) {
            return;
        }
        d.AnonymousClass0.m$1();
    }

    public static String objectId(Object obj) {
        if (obj == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append("@");
        stringBuffer.append(System.identityHashCode(obj));
        return stringBuffer.toString();
    }
}
