package org.apache.http.conn.ssl;

import defpackage.qp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.commons.logging.LogFactory;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class BrowserCompatHostnameVerifier extends AbstractVerifier {
    static {
        new BrowserCompatHostnameVerifier();
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:113:0x028f  */
    /* JADX WARN: Code duplicated, block: B:123:0x02c4 A[Catch: Exception -> 0x02af, TryCatch #1 {Exception -> 0x02af, blocks: (B:114:0x0294, B:116:0x02a2, B:121:0x02bb, B:123:0x02c4, B:125:0x02cc, B:127:0x02d2, B:128:0x02e8, B:129:0x02ec, B:131:0x02f2, B:120:0x02b1), top: B:165:0x0294, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x02d2 A[Catch: Exception -> 0x02af, TryCatch #1 {Exception -> 0x02af, blocks: (B:114:0x0294, B:116:0x02a2, B:121:0x02bb, B:123:0x02c4, B:125:0x02cc, B:127:0x02d2, B:128:0x02e8, B:129:0x02ec, B:131:0x02f2, B:120:0x02b1), top: B:165:0x0294, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x02ec A[Catch: Exception -> 0x02af, TryCatch #1 {Exception -> 0x02af, blocks: (B:114:0x0294, B:116:0x02a2, B:121:0x02bb, B:123:0x02c4, B:125:0x02cc, B:127:0x02d2, B:128:0x02e8, B:129:0x02ec, B:131:0x02f2, B:120:0x02b1), top: B:165:0x0294, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x02f2 A[Catch: Exception -> 0x02af, TRY_LEAVE, TryCatch #1 {Exception -> 0x02af, blocks: (B:114:0x0294, B:116:0x02a2, B:121:0x02bb, B:123:0x02c4, B:125:0x02cc, B:127:0x02d2, B:128:0x02e8, B:129:0x02ec, B:131:0x02f2, B:120:0x02b1), top: B:165:0x0294, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x0323 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x0325  */
    /* JADX WARN: Code duplicated, block: B:146:0x0330  */
    /* JADX WARN: Code duplicated, block: B:148:0x0336  */
    /* JADX WARN: Code duplicated, block: B:150:0x034e  */
    /* JADX WARN: Code duplicated, block: B:152:0x0354  */
    /* JADX WARN: Code duplicated, block: B:153:0x0357 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:154:0x0359  */
    /* JADX WARN: Code duplicated, block: B:158:0x0364  */
    /* JADX WARN: Code duplicated, block: B:168:0x02a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x01be  */
    /* JADX WARN: Code duplicated, block: B:69:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:70:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:73:0x01de  */
    /* JADX WARN: Code duplicated, block: B:78:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:81:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:84:0x020d A[Catch: RuntimeException -> 0x0226, SecurityException -> 0x0228, TryCatch #11 {SecurityException -> 0x0228, RuntimeException -> 0x0226, blocks: (B:82:0x01ff, B:84:0x020d, B:86:0x0213, B:91:0x022a, B:92:0x022e, B:94:0x0234), top: B:182:0x01ff }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0213 A[Catch: RuntimeException -> 0x0226, SecurityException -> 0x0228, TryCatch #11 {SecurityException -> 0x0228, RuntimeException -> 0x0226, blocks: (B:82:0x01ff, B:84:0x020d, B:86:0x0213, B:91:0x022a, B:92:0x022e, B:94:0x0234), top: B:182:0x01ff }] */
    /* JADX WARN: Code duplicated, block: B:92:0x022e A[Catch: RuntimeException -> 0x0226, SecurityException -> 0x0228, TryCatch #11 {SecurityException -> 0x0228, RuntimeException -> 0x0226, blocks: (B:82:0x01ff, B:84:0x020d, B:86:0x0213, B:91:0x022a, B:92:0x022e, B:94:0x0234), top: B:182:0x01ff }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0234 A[Catch: RuntimeException -> 0x0226, SecurityException -> 0x0228, TRY_LEAVE, TryCatch #11 {SecurityException -> 0x0228, RuntimeException -> 0x0226, blocks: (B:82:0x01ff, B:84:0x020d, B:86:0x0213, B:91:0x022a, B:92:0x022e, B:94:0x0234), top: B:182:0x01ff }] */
    /* JADX WARN: Multi-variable type inference failed */
    public BrowserCompatHostnameVerifier() throws Throwable {
        ClassLoader classLoader;
        String str;
        Throwable th;
        URL url;
        Properties properties;
        StringBuffer stringBuffer;
        ClassLoader classLoader2;
        boolean zIsDiagnosticsEnabled;
        String str2;
        String property;
        InputStream inputStream;
        BufferedReader bufferedReader;
        String line;
        String str3;
        String property2;
        Properties properties2;
        ClassLoader classLoader3 = LogFactory.thisClassLoader;
        String str4 = " as specified by file 'META-INF/services/org.apache.commons.logging.LogFactory' which was present in the path of the context classloader.";
        String str5 = "[LOOKUP]  Creating an instance of LogFactory class ";
        ClassLoader classLoader4 = (ClassLoader) AccessController.doPrivileged(new LogFactory.AnonymousClass1());
        if (classLoader4 == null && LogFactory.isDiagnosticsEnabled()) {
            LogFactory.logDiagnostic("Context classloader is null.");
        }
        if (classLoader4 != null && LogFactory.factories.get(classLoader4) != null) {
            throw new ClassCastException();
        }
        if (LogFactory.isDiagnosticsEnabled()) {
            StringBuffer stringBuffer2 = new StringBuffer("[LOOKUP] LogFactory implementation requested for the first time for context classloader ");
            stringBuffer2.append(LogFactory.objectId(classLoader4));
            LogFactory.logDiagnostic(stringBuffer2.toString());
            LogFactory.logHierarchy(classLoader4, "[LOOKUP] ");
        }
        try {
            Enumeration enumeration = (Enumeration) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.commons.logging.LogFactory.3
                public final /* synthetic */ int G0;
                public final /* synthetic */ ClassLoader val$loader;

                public /* synthetic */ AnonymousClass3() {
                    i = i;
                    classLoader = classLoader4;
                }

                @Override // java.security.PrivilegedAction
                public final Object run() {
                    int i = i;
                    ClassLoader classLoader5 = classLoader;
                    if (i == 0) {
                        return classLoader5 != null ? classLoader5.getResourceAsStream("META-INF/services/org.apache.commons.logging.LogFactory") : ClassLoader.getSystemResourceAsStream("META-INF/services/org.apache.commons.logging.LogFactory");
                    }
                    try {
                        return classLoader5 != null ? classLoader5.getResources("commons-logging.properties") : ClassLoader.getSystemResources("commons-logging.properties");
                    } catch (IOException e) {
                        if (!LogFactory.isDiagnosticsEnabled()) {
                            return null;
                        }
                        StringBuffer stringBuffer3 = new StringBuffer("Exception while trying to find configuration file commons-logging.properties:");
                        stringBuffer3.append(e.getMessage());
                        LogFactory.logDiagnostic(stringBuffer3.toString());
                        return null;
                    } catch (NoSuchMethodError unused) {
                        return null;
                    }
                }
            });
            if (enumeration == null) {
                classLoader = classLoader3;
                str = " as specified by file 'META-INF/services/org.apache.commons.logging.LogFactory' which was present in the path of the context classloader.";
                str5 = "[LOOKUP]  Creating an instance of LogFactory class ";
                properties = null;
                th = null;
            } else {
                url = null;
                double d = 0.0d;
                properties = null;
                th = null;
                while (enumeration.hasMoreElements()) {
                    try {
                        URL url2 = (URL) enumeration.nextElement();
                        Enumeration enumeration2 = enumeration;
                        properties2 = properties;
                        try {
                            Properties properties3 = (Properties) AccessController.doPrivileged(new qp(1, url2));
                            if (properties3 != null) {
                                classLoader = classLoader3;
                                if (properties2 == null) {
                                    try {
                                        String property3 = properties3.getProperty("priority");
                                        d = property3 != null ? Double.parseDouble(property3) : 0.0d;
                                        if (LogFactory.isDiagnosticsEnabled()) {
                                            StringBuffer stringBuffer3 = new StringBuffer();
                                            stringBuffer3.append("[LOOKUP] Properties file found at '");
                                            stringBuffer3.append(url2);
                                            stringBuffer3.append("'");
                                            stringBuffer3.append(" with priority ");
                                            stringBuffer3.append(d);
                                            LogFactory.logDiagnostic(stringBuffer3.toString());
                                        }
                                        str = str4;
                                        str5 = str5;
                                        properties = properties3;
                                        url = url2;
                                    } catch (SecurityException unused) {
                                        str = str4;
                                        str5 = str5;
                                        properties = properties3;
                                        url = url2;
                                        if (LogFactory.isDiagnosticsEnabled()) {
                                            LogFactory.logDiagnostic("SecurityException thrown while trying to find/read config files.");
                                        }
                                        if (LogFactory.isDiagnosticsEnabled()) {
                                            if (properties == null) {
                                                stringBuffer = new StringBuffer("[LOOKUP] No properties file of name 'commons-logging.properties' found.");
                                            } else {
                                                stringBuffer = new StringBuffer("[LOOKUP] Properties file of name 'commons-logging.properties' found at '");
                                                stringBuffer.append(url);
                                                stringBuffer.append('\"');
                                            }
                                            LogFactory.logDiagnostic(stringBuffer.toString());
                                        }
                                        if (properties != null) {
                                            classLoader2 = classLoader4;
                                        } else {
                                            classLoader2 = classLoader4;
                                        }
                                        if (LogFactory.isDiagnosticsEnabled()) {
                                            LogFactory.logDiagnostic("[LOOKUP] Looking for system property [org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
                                        }
                                        str3 = (String) AccessController.doPrivileged(new qp(2, "org.apache.commons.logging.LogFactory"));
                                        if (str3 != null) {
                                            if (LogFactory.isDiagnosticsEnabled()) {
                                                StringBuffer stringBuffer4 = new StringBuffer("[LOOKUP] Creating an instance of LogFactory class '");
                                                stringBuffer4.append(str3);
                                                stringBuffer4.append("' as specified by system property org.apache.commons.logging.LogFactory");
                                                LogFactory.logDiagnostic(stringBuffer4.toString());
                                            }
                                            LogFactory.newFactory(str3, classLoader2, classLoader4);
                                        } else if (LogFactory.isDiagnosticsEnabled()) {
                                            LogFactory.logDiagnostic("[LOOKUP] No system property [org.apache.commons.logging.LogFactory] defined.");
                                        }
                                        if (LogFactory.isDiagnosticsEnabled()) {
                                            LogFactory.logDiagnostic("[LOOKUP] Looking for a resource file of name [META-INF/services/org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
                                        }
                                        inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.commons.logging.LogFactory.3
                                            public final /* synthetic */ int G0;
                                            public final /* synthetic */ ClassLoader val$loader;

                                            public /* synthetic */ AnonymousClass3() {
                                                i = i;
                                                classLoader = classLoader4;
                                            }

                                            @Override // java.security.PrivilegedAction
                                            public final Object run() {
                                                int i = i;
                                                ClassLoader classLoader5 = classLoader;
                                                if (i == 0) {
                                                    return classLoader5 != null ? classLoader5.getResourceAsStream("META-INF/services/org.apache.commons.logging.LogFactory") : ClassLoader.getSystemResourceAsStream("META-INF/services/org.apache.commons.logging.LogFactory");
                                                }
                                                try {
                                                    return classLoader5 != null ? classLoader5.getResources("commons-logging.properties") : ClassLoader.getSystemResources("commons-logging.properties");
                                                } catch (IOException e) {
                                                    if (!LogFactory.isDiagnosticsEnabled()) {
                                                        return null;
                                                    }
                                                    StringBuffer stringBuffer5 = new StringBuffer("Exception while trying to find configuration file commons-logging.properties:");
                                                    stringBuffer5.append(e.getMessage());
                                                    LogFactory.logDiagnostic(stringBuffer5.toString());
                                                    return null;
                                                } catch (NoSuchMethodError unused2) {
                                                    return null;
                                                }
                                            }
                                        });
                                        if (inputStream != null) {
                                            try {
                                                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                                            } catch (UnsupportedEncodingException unused2) {
                                                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                                            }
                                            line = bufferedReader.readLine();
                                            bufferedReader.close();
                                            if (line != null) {
                                                if (LogFactory.isDiagnosticsEnabled()) {
                                                    StringBuffer stringBuffer5 = new StringBuffer(str5);
                                                    stringBuffer5.append(line);
                                                    stringBuffer5.append(str);
                                                    LogFactory.logDiagnostic(stringBuffer5.toString());
                                                }
                                                LogFactory.newFactory(line, classLoader2, classLoader4);
                                            }
                                        } else if (LogFactory.isDiagnosticsEnabled()) {
                                            LogFactory.logDiagnostic("[LOOKUP] No resource file with name 'META-INF/services/org.apache.commons.logging.LogFactory' found.");
                                        }
                                        zIsDiagnosticsEnabled = LogFactory.isDiagnosticsEnabled();
                                        if (properties != null) {
                                            if (zIsDiagnosticsEnabled) {
                                                LogFactory.logDiagnostic("[LOOKUP] Looking in properties file for entry with key 'org.apache.commons.logging.LogFactory' to define the LogFactory subclass to use...");
                                            }
                                            property = properties.getProperty("org.apache.commons.logging.LogFactory");
                                            if (property != null) {
                                                if (LogFactory.isDiagnosticsEnabled()) {
                                                    StringBuffer stringBuffer6 = new StringBuffer("[LOOKUP] Properties file specifies LogFactory subclass '");
                                                    stringBuffer6.append(property);
                                                    stringBuffer6.append("'");
                                                    LogFactory.logDiagnostic(stringBuffer6.toString());
                                                }
                                                LogFactory.newFactory(property, classLoader2, classLoader4);
                                            } else if (LogFactory.isDiagnosticsEnabled()) {
                                                str2 = "[LOOKUP] Properties file has no entry specifying LogFactory subclass.";
                                                LogFactory.logDiagnostic(str2);
                                            }
                                        } else if (zIsDiagnosticsEnabled) {
                                            str2 = "[LOOKUP] No properties file available to determine LogFactory subclass from..";
                                            LogFactory.logDiagnostic(str2);
                                        }
                                        if (LogFactory.isDiagnosticsEnabled()) {
                                            LogFactory.logDiagnostic("[LOOKUP] Loading the default LogFactory implementation 'org.apache.commons.logging.impl.LogFactoryImpl' via the same classloader that loaded this LogFactory class (ie not looking in the context classloader).");
                                        }
                                        LogFactory.newFactory("org.apache.commons.logging.impl.LogFactoryImpl", classLoader, classLoader4);
                                        throw th;
                                    }
                                } else {
                                    try {
                                        String property4 = properties3.getProperty("priority");
                                        double d2 = property4 != null ? Double.parseDouble(property4) : 0.0d;
                                        if (d2 > d) {
                                            try {
                                                if (LogFactory.isDiagnosticsEnabled()) {
                                                    str = str4;
                                                    try {
                                                        StringBuffer stringBuffer7 = new StringBuffer();
                                                        stringBuffer7.append("[LOOKUP] Properties file at '");
                                                        stringBuffer7.append(url2);
                                                        stringBuffer7.append("'");
                                                        stringBuffer7.append(" with priority ");
                                                        stringBuffer7.append(d2);
                                                        stringBuffer7.append(" overrides file at '");
                                                        stringBuffer7.append(url);
                                                        stringBuffer7.append("'");
                                                        stringBuffer7.append(" with priority ");
                                                        stringBuffer7.append(d);
                                                        LogFactory.logDiagnostic(stringBuffer7.toString());
                                                    } catch (SecurityException unused3) {
                                                        properties = properties2;
                                                        if (LogFactory.isDiagnosticsEnabled()) {
                                                            LogFactory.logDiagnostic("SecurityException thrown while trying to find/read config files.");
                                                        }
                                                        if (LogFactory.isDiagnosticsEnabled()) {
                                                            if (properties == null) {
                                                                stringBuffer = new StringBuffer("[LOOKUP] No properties file of name 'commons-logging.properties' found.");
                                                            } else {
                                                                stringBuffer = new StringBuffer("[LOOKUP] Properties file of name 'commons-logging.properties' found at '");
                                                                stringBuffer.append(url);
                                                                stringBuffer.append('\"');
                                                            }
                                                            LogFactory.logDiagnostic(stringBuffer.toString());
                                                        }
                                                        if (properties != null) {
                                                            classLoader2 = classLoader4;
                                                        } else {
                                                            classLoader2 = classLoader4;
                                                        }
                                                        if (LogFactory.isDiagnosticsEnabled()) {
                                                            LogFactory.logDiagnostic("[LOOKUP] Looking for system property [org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
                                                        }
                                                        str3 = (String) AccessController.doPrivileged(new qp(2, "org.apache.commons.logging.LogFactory"));
                                                        if (str3 != null) {
                                                            if (LogFactory.isDiagnosticsEnabled()) {
                                                                StringBuffer stringBuffer8 = new StringBuffer("[LOOKUP] Creating an instance of LogFactory class '");
                                                                stringBuffer8.append(str3);
                                                                stringBuffer8.append("' as specified by system property org.apache.commons.logging.LogFactory");
                                                                LogFactory.logDiagnostic(stringBuffer8.toString());
                                                            }
                                                            LogFactory.newFactory(str3, classLoader2, classLoader4);
                                                        } else if (LogFactory.isDiagnosticsEnabled()) {
                                                            LogFactory.logDiagnostic("[LOOKUP] No system property [org.apache.commons.logging.LogFactory] defined.");
                                                        }
                                                        if (LogFactory.isDiagnosticsEnabled()) {
                                                            LogFactory.logDiagnostic("[LOOKUP] Looking for a resource file of name [META-INF/services/org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
                                                        }
                                                        inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.commons.logging.LogFactory.3
                                                            public final /* synthetic */ int G0;
                                                            public final /* synthetic */ ClassLoader val$loader;

                                                            public /* synthetic */ AnonymousClass3() {
                                                                i = i;
                                                                classLoader = classLoader4;
                                                            }

                                                            @Override // java.security.PrivilegedAction
                                                            public final Object run() {
                                                                int i = i;
                                                                ClassLoader classLoader5 = classLoader;
                                                                if (i == 0) {
                                                                    return classLoader5 != null ? classLoader5.getResourceAsStream("META-INF/services/org.apache.commons.logging.LogFactory") : ClassLoader.getSystemResourceAsStream("META-INF/services/org.apache.commons.logging.LogFactory");
                                                                }
                                                                try {
                                                                    return classLoader5 != null ? classLoader5.getResources("commons-logging.properties") : ClassLoader.getSystemResources("commons-logging.properties");
                                                                } catch (IOException e) {
                                                                    if (!LogFactory.isDiagnosticsEnabled()) {
                                                                        return null;
                                                                    }
                                                                    StringBuffer stringBuffer9 = new StringBuffer("Exception while trying to find configuration file commons-logging.properties:");
                                                                    stringBuffer9.append(e.getMessage());
                                                                    LogFactory.logDiagnostic(stringBuffer9.toString());
                                                                    return null;
                                                                } catch (NoSuchMethodError unused4) {
                                                                    return null;
                                                                }
                                                            }
                                                        });
                                                        if (inputStream != null) {
                                                            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                                                            line = bufferedReader.readLine();
                                                            bufferedReader.close();
                                                            if (line != null) {
                                                                if (LogFactory.isDiagnosticsEnabled()) {
                                                                    StringBuffer stringBuffer9 = new StringBuffer(str5);
                                                                    stringBuffer9.append(line);
                                                                    stringBuffer9.append(str);
                                                                    LogFactory.logDiagnostic(stringBuffer9.toString());
                                                                }
                                                                LogFactory.newFactory(line, classLoader2, classLoader4);
                                                            }
                                                        } else if (LogFactory.isDiagnosticsEnabled()) {
                                                            LogFactory.logDiagnostic("[LOOKUP] No resource file with name 'META-INF/services/org.apache.commons.logging.LogFactory' found.");
                                                        }
                                                        zIsDiagnosticsEnabled = LogFactory.isDiagnosticsEnabled();
                                                        if (properties != null) {
                                                            if (zIsDiagnosticsEnabled) {
                                                                LogFactory.logDiagnostic("[LOOKUP] Looking in properties file for entry with key 'org.apache.commons.logging.LogFactory' to define the LogFactory subclass to use...");
                                                            }
                                                            property = properties.getProperty("org.apache.commons.logging.LogFactory");
                                                            if (property != null) {
                                                                if (LogFactory.isDiagnosticsEnabled()) {
                                                                    StringBuffer stringBuffer10 = new StringBuffer("[LOOKUP] Properties file specifies LogFactory subclass '");
                                                                    stringBuffer10.append(property);
                                                                    stringBuffer10.append("'");
                                                                    LogFactory.logDiagnostic(stringBuffer10.toString());
                                                                }
                                                                LogFactory.newFactory(property, classLoader2, classLoader4);
                                                            } else if (LogFactory.isDiagnosticsEnabled()) {
                                                                str2 = "[LOOKUP] Properties file has no entry specifying LogFactory subclass.";
                                                                LogFactory.logDiagnostic(str2);
                                                            }
                                                        } else if (zIsDiagnosticsEnabled) {
                                                            str2 = "[LOOKUP] No properties file available to determine LogFactory subclass from..";
                                                            LogFactory.logDiagnostic(str2);
                                                        }
                                                        if (LogFactory.isDiagnosticsEnabled()) {
                                                            LogFactory.logDiagnostic("[LOOKUP] Loading the default LogFactory implementation 'org.apache.commons.logging.impl.LogFactoryImpl' via the same classloader that loaded this LogFactory class (ie not looking in the context classloader).");
                                                        }
                                                        LogFactory.newFactory("org.apache.commons.logging.impl.LogFactoryImpl", classLoader, classLoader4);
                                                        throw th;
                                                    }
                                                } else {
                                                    str = str4;
                                                }
                                                d = d2;
                                                url = url2;
                                                properties = properties3;
                                            } catch (SecurityException unused4) {
                                                str = str4;
                                            }
                                        } else {
                                            str = str4;
                                            if (LogFactory.isDiagnosticsEnabled()) {
                                                StringBuffer stringBuffer11 = new StringBuffer();
                                                stringBuffer11.append("[LOOKUP] Properties file at '");
                                                stringBuffer11.append(url2);
                                                stringBuffer11.append("'");
                                                stringBuffer11.append(" with priority ");
                                                stringBuffer11.append(d2);
                                                stringBuffer11.append(" does not override file at '");
                                                stringBuffer11.append(url);
                                                stringBuffer11.append("'");
                                                stringBuffer11.append(" with priority ");
                                                stringBuffer11.append(d);
                                                LogFactory.logDiagnostic(stringBuffer11.toString());
                                            }
                                        }
                                    } catch (SecurityException unused5) {
                                        str = str4;
                                        str5 = str5;
                                        properties = properties2;
                                        if (LogFactory.isDiagnosticsEnabled()) {
                                            LogFactory.logDiagnostic("SecurityException thrown while trying to find/read config files.");
                                        }
                                        if (LogFactory.isDiagnosticsEnabled()) {
                                            if (properties == null) {
                                                stringBuffer = new StringBuffer("[LOOKUP] No properties file of name 'commons-logging.properties' found.");
                                            } else {
                                                stringBuffer = new StringBuffer("[LOOKUP] Properties file of name 'commons-logging.properties' found at '");
                                                stringBuffer.append(url);
                                                stringBuffer.append('\"');
                                            }
                                            LogFactory.logDiagnostic(stringBuffer.toString());
                                        }
                                        if (properties != null) {
                                            classLoader2 = classLoader4;
                                        } else {
                                            classLoader2 = classLoader4;
                                        }
                                        if (LogFactory.isDiagnosticsEnabled()) {
                                            LogFactory.logDiagnostic("[LOOKUP] Looking for system property [org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
                                        }
                                        str3 = (String) AccessController.doPrivileged(new qp(2, "org.apache.commons.logging.LogFactory"));
                                        if (str3 != null) {
                                            if (LogFactory.isDiagnosticsEnabled()) {
                                                StringBuffer stringBuffer12 = new StringBuffer("[LOOKUP] Creating an instance of LogFactory class '");
                                                stringBuffer12.append(str3);
                                                stringBuffer12.append("' as specified by system property org.apache.commons.logging.LogFactory");
                                                LogFactory.logDiagnostic(stringBuffer12.toString());
                                            }
                                            LogFactory.newFactory(str3, classLoader2, classLoader4);
                                        } else if (LogFactory.isDiagnosticsEnabled()) {
                                            LogFactory.logDiagnostic("[LOOKUP] No system property [org.apache.commons.logging.LogFactory] defined.");
                                        }
                                        if (LogFactory.isDiagnosticsEnabled()) {
                                            LogFactory.logDiagnostic("[LOOKUP] Looking for a resource file of name [META-INF/services/org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
                                        }
                                        inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.commons.logging.LogFactory.3
                                            public final /* synthetic */ int G0;
                                            public final /* synthetic */ ClassLoader val$loader;

                                            public /* synthetic */ AnonymousClass3() {
                                                i = i;
                                                classLoader = classLoader4;
                                            }

                                            @Override // java.security.PrivilegedAction
                                            public final Object run() {
                                                int i = i;
                                                ClassLoader classLoader5 = classLoader;
                                                if (i == 0) {
                                                    return classLoader5 != null ? classLoader5.getResourceAsStream("META-INF/services/org.apache.commons.logging.LogFactory") : ClassLoader.getSystemResourceAsStream("META-INF/services/org.apache.commons.logging.LogFactory");
                                                }
                                                try {
                                                    return classLoader5 != null ? classLoader5.getResources("commons-logging.properties") : ClassLoader.getSystemResources("commons-logging.properties");
                                                } catch (IOException e) {
                                                    if (!LogFactory.isDiagnosticsEnabled()) {
                                                        return null;
                                                    }
                                                    StringBuffer stringBuffer13 = new StringBuffer("Exception while trying to find configuration file commons-logging.properties:");
                                                    stringBuffer13.append(e.getMessage());
                                                    LogFactory.logDiagnostic(stringBuffer13.toString());
                                                    return null;
                                                } catch (NoSuchMethodError unused6) {
                                                    return null;
                                                }
                                            }
                                        });
                                        if (inputStream != null) {
                                            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                                            line = bufferedReader.readLine();
                                            bufferedReader.close();
                                            if (line != null) {
                                                if (LogFactory.isDiagnosticsEnabled()) {
                                                    StringBuffer stringBuffer13 = new StringBuffer(str5);
                                                    stringBuffer13.append(line);
                                                    stringBuffer13.append(str);
                                                    LogFactory.logDiagnostic(stringBuffer13.toString());
                                                }
                                                LogFactory.newFactory(line, classLoader2, classLoader4);
                                            }
                                        } else if (LogFactory.isDiagnosticsEnabled()) {
                                            LogFactory.logDiagnostic("[LOOKUP] No resource file with name 'META-INF/services/org.apache.commons.logging.LogFactory' found.");
                                        }
                                        zIsDiagnosticsEnabled = LogFactory.isDiagnosticsEnabled();
                                        if (properties != null) {
                                            if (zIsDiagnosticsEnabled) {
                                                LogFactory.logDiagnostic("[LOOKUP] Looking in properties file for entry with key 'org.apache.commons.logging.LogFactory' to define the LogFactory subclass to use...");
                                            }
                                            property = properties.getProperty("org.apache.commons.logging.LogFactory");
                                            if (property != null) {
                                                if (LogFactory.isDiagnosticsEnabled()) {
                                                    StringBuffer stringBuffer14 = new StringBuffer("[LOOKUP] Properties file specifies LogFactory subclass '");
                                                    stringBuffer14.append(property);
                                                    stringBuffer14.append("'");
                                                    LogFactory.logDiagnostic(stringBuffer14.toString());
                                                }
                                                LogFactory.newFactory(property, classLoader2, classLoader4);
                                            } else if (LogFactory.isDiagnosticsEnabled()) {
                                                str2 = "[LOOKUP] Properties file has no entry specifying LogFactory subclass.";
                                                LogFactory.logDiagnostic(str2);
                                            }
                                        } else if (zIsDiagnosticsEnabled) {
                                            str2 = "[LOOKUP] No properties file available to determine LogFactory subclass from..";
                                            LogFactory.logDiagnostic(str2);
                                        }
                                        if (LogFactory.isDiagnosticsEnabled()) {
                                            LogFactory.logDiagnostic("[LOOKUP] Loading the default LogFactory implementation 'org.apache.commons.logging.impl.LogFactoryImpl' via the same classloader that loaded this LogFactory class (ie not looking in the context classloader).");
                                        }
                                        LogFactory.newFactory("org.apache.commons.logging.impl.LogFactoryImpl", classLoader, classLoader4);
                                        throw th;
                                    }
                                }
                                enumeration = enumeration2;
                                classLoader3 = classLoader;
                                str5 = str5;
                                str4 = str;
                            } else {
                                classLoader = classLoader3;
                                str = str4;
                                str5 = str5;
                            }
                            properties = properties2;
                            enumeration = enumeration2;
                            classLoader3 = classLoader;
                            str5 = str5;
                            str4 = str;
                        } catch (SecurityException unused6) {
                            classLoader = classLoader3;
                        }
                    } catch (SecurityException unused7) {
                        classLoader = classLoader3;
                        str = str4;
                        str5 = str5;
                        properties2 = properties;
                    }
                }
                classLoader = classLoader3;
                str = str4;
                str5 = str5;
                if (LogFactory.isDiagnosticsEnabled()) {
                    if (properties == null) {
                        stringBuffer = new StringBuffer("[LOOKUP] No properties file of name 'commons-logging.properties' found.");
                    } else {
                        stringBuffer = new StringBuffer("[LOOKUP] Properties file of name 'commons-logging.properties' found at '");
                        stringBuffer.append(url);
                        stringBuffer.append('\"');
                    }
                    LogFactory.logDiagnostic(stringBuffer.toString());
                }
            }
        } catch (SecurityException unused8) {
            classLoader = classLoader3;
            str = " as specified by file 'META-INF/services/org.apache.commons.logging.LogFactory' which was present in the path of the context classloader.";
            str5 = "[LOOKUP]  Creating an instance of LogFactory class ";
            th = null;
            url = null;
            properties = null;
        }
        if (properties != null || (property2 = properties.getProperty("use_tccl")) == null || Boolean.valueOf(property2).booleanValue()) {
            classLoader2 = classLoader4;
        } else {
            classLoader2 = classLoader;
        }
        if (LogFactory.isDiagnosticsEnabled()) {
            LogFactory.logDiagnostic("[LOOKUP] Looking for system property [org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
        }
        try {
            str3 = (String) AccessController.doPrivileged(new qp(2, "org.apache.commons.logging.LogFactory"));
            if (str3 != null) {
                if (LogFactory.isDiagnosticsEnabled()) {
                    StringBuffer stringBuffer15 = new StringBuffer("[LOOKUP] Creating an instance of LogFactory class '");
                    stringBuffer15.append(str3);
                    stringBuffer15.append("' as specified by system property org.apache.commons.logging.LogFactory");
                    LogFactory.logDiagnostic(stringBuffer15.toString());
                }
                LogFactory.newFactory(str3, classLoader2, classLoader4);
            } else if (LogFactory.isDiagnosticsEnabled()) {
                LogFactory.logDiagnostic("[LOOKUP] No system property [org.apache.commons.logging.LogFactory] defined.");
            }
        } catch (SecurityException e) {
            if (LogFactory.isDiagnosticsEnabled()) {
                StringBuffer stringBuffer16 = new StringBuffer("[LOOKUP] A security exception occurred while trying to create an instance of the custom factory class: [");
                String message = e.getMessage();
                stringBuffer16.append(message == null ? th : message.trim());
                stringBuffer16.append("]. Trying alternative implementations...");
                LogFactory.logDiagnostic(stringBuffer16.toString());
            }
        } catch (RuntimeException e2) {
            if (LogFactory.isDiagnosticsEnabled()) {
                StringBuffer stringBuffer17 = new StringBuffer("[LOOKUP] An exception occurred while trying to create an instance of the custom factory class: [");
                String message2 = e2.getMessage();
                stringBuffer17.append(message2 == null ? th : message2.trim());
                stringBuffer17.append("] as specified by a system property.");
                LogFactory.logDiagnostic(stringBuffer17.toString());
            }
            throw e2;
        }
        if (LogFactory.isDiagnosticsEnabled()) {
            LogFactory.logDiagnostic("[LOOKUP] Looking for a resource file of name [META-INF/services/org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
        }
        try {
            inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.commons.logging.LogFactory.3
                public final /* synthetic */ int G0;
                public final /* synthetic */ ClassLoader val$loader;

                public /* synthetic */ AnonymousClass3() {
                    i = i;
                    classLoader = classLoader4;
                }

                @Override // java.security.PrivilegedAction
                public final Object run() {
                    int i = i;
                    ClassLoader classLoader5 = classLoader;
                    if (i == 0) {
                        return classLoader5 != null ? classLoader5.getResourceAsStream("META-INF/services/org.apache.commons.logging.LogFactory") : ClassLoader.getSystemResourceAsStream("META-INF/services/org.apache.commons.logging.LogFactory");
                    }
                    try {
                        return classLoader5 != null ? classLoader5.getResources("commons-logging.properties") : ClassLoader.getSystemResources("commons-logging.properties");
                    } catch (IOException e3) {
                        if (!LogFactory.isDiagnosticsEnabled()) {
                            return null;
                        }
                        StringBuffer stringBuffer18 = new StringBuffer("Exception while trying to find configuration file commons-logging.properties:");
                        stringBuffer18.append(e3.getMessage());
                        LogFactory.logDiagnostic(stringBuffer18.toString());
                        return null;
                    } catch (NoSuchMethodError unused9) {
                        return null;
                    }
                }
            });
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                line = bufferedReader.readLine();
                bufferedReader.close();
                if (line != null && !AppConfig.CUSTOM.equals(line)) {
                    if (LogFactory.isDiagnosticsEnabled()) {
                        StringBuffer stringBuffer18 = new StringBuffer(str5);
                        stringBuffer18.append(line);
                        stringBuffer18.append(str);
                        LogFactory.logDiagnostic(stringBuffer18.toString());
                    }
                    LogFactory.newFactory(line, classLoader2, classLoader4);
                }
            } else if (LogFactory.isDiagnosticsEnabled()) {
                LogFactory.logDiagnostic("[LOOKUP] No resource file with name 'META-INF/services/org.apache.commons.logging.LogFactory' found.");
            }
        } catch (Exception e3) {
            if (LogFactory.isDiagnosticsEnabled()) {
                StringBuffer stringBuffer19 = new StringBuffer("[LOOKUP] A security exception occurred while trying to create an instance of the custom factory class: [");
                String message3 = e3.getMessage();
                stringBuffer19.append(message3 == null ? th : message3.trim());
                stringBuffer19.append("]. Trying alternative implementations...");
                LogFactory.logDiagnostic(stringBuffer19.toString());
            }
        }
        zIsDiagnosticsEnabled = LogFactory.isDiagnosticsEnabled();
        if (properties != null) {
            if (zIsDiagnosticsEnabled) {
                LogFactory.logDiagnostic("[LOOKUP] Looking in properties file for entry with key 'org.apache.commons.logging.LogFactory' to define the LogFactory subclass to use...");
            }
            property = properties.getProperty("org.apache.commons.logging.LogFactory");
            if (property != null) {
                if (LogFactory.isDiagnosticsEnabled()) {
                    StringBuffer stringBuffer110 = new StringBuffer("[LOOKUP] Properties file specifies LogFactory subclass '");
                    stringBuffer110.append(property);
                    stringBuffer110.append("'");
                    LogFactory.logDiagnostic(stringBuffer110.toString());
                }
                LogFactory.newFactory(property, classLoader2, classLoader4);
            } else if (LogFactory.isDiagnosticsEnabled()) {
                str2 = "[LOOKUP] Properties file has no entry specifying LogFactory subclass.";
                LogFactory.logDiagnostic(str2);
            }
        } else if (zIsDiagnosticsEnabled) {
            str2 = "[LOOKUP] No properties file available to determine LogFactory subclass from..";
            LogFactory.logDiagnostic(str2);
        }
        if (LogFactory.isDiagnosticsEnabled()) {
            LogFactory.logDiagnostic("[LOOKUP] Loading the default LogFactory implementation 'org.apache.commons.logging.impl.LogFactoryImpl' via the same classloader that loaded this LogFactory class (ie not looking in the context classloader).");
        }
        LogFactory.newFactory("org.apache.commons.logging.impl.LogFactoryImpl", classLoader, classLoader4);
        throw th;
    }

    public final String toString() {
        return "BROWSER_COMPATIBLE";
    }
}
