package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;
import androidx.preference.c;
import androidx.preference.e;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class sp0 {
    public static final Class[] e = {Context.class, AttributeSet.class};
    public static final HashMap f = new HashMap();
    public final Context a;
    public final e c;
    public final Object[] b = new Object[2];
    public final String[] d = {Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."};

    public sp0(Context context, e eVar) {
        this.a = context;
        this.c = eVar;
    }

    public final Preference a(String str, String[] strArr, AttributeSet attributeSet) throws ClassNotFoundException {
        Class<?> cls;
        HashMap map = f;
        Constructor<?> constructor = (Constructor) map.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.a.getClassLoader();
                    if (strArr == null || strArr.length == 0) {
                        cls = Class.forName(str, false, classLoader);
                    } else {
                        cls = null;
                        ClassNotFoundException e2 = null;
                        for (String str2 : strArr) {
                            try {
                                cls = Class.forName(str2 + str, false, classLoader);
                                break;
                            } catch (ClassNotFoundException e3) {
                                e2 = e3;
                            }
                        }
                        if (cls == null) {
                            if (e2 != null) {
                                throw e2;
                            }
                            throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                        }
                    }
                    constructor = cls.getConstructor(e);
                    constructor.setAccessible(true);
                    map.put(str, constructor);
                } catch (Exception e4) {
                    InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                    inflateException.initCause(e4);
                    throw inflateException;
                }
            } catch (ClassNotFoundException e5) {
                throw e5;
            }
        }
        Object[] objArr = this.b;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    public final Preference b(String str, AttributeSet attributeSet) {
        try {
            return -1 == str.indexOf(46) ? a(str, this.d, attributeSet) : a(str, null, attributeSet);
        } catch (InflateException e2) {
            throw e2;
        } catch (ClassNotFoundException e3) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e3);
            throw inflateException;
        } catch (Exception e4) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e4);
            throw inflateException2;
        }
    }

    public final PreferenceGroup c(XmlResourceParser xmlResourceParser, PreferenceScreen preferenceScreen) {
        int next;
        PreferenceGroup preferenceGroup;
        synchronized (this.b) {
            try {
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                this.b[0] = this.a;
                do {
                    try {
                        next = xmlResourceParser.next();
                        if (next == 2) {
                            break;
                        }
                    } catch (InflateException e2) {
                        throw e2;
                    } catch (IOException e3) {
                        InflateException inflateException = new InflateException(xmlResourceParser.getPositionDescription() + ": " + e3.getMessage());
                        inflateException.initCause(e3);
                        throw inflateException;
                    } catch (XmlPullParserException e4) {
                        InflateException inflateException2 = new InflateException(e4.getMessage());
                        inflateException2.initCause(e4);
                        throw inflateException2;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new InflateException(xmlResourceParser.getPositionDescription() + ": No start tag found!");
                }
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) b(xmlResourceParser.getName(), attributeSetAsAttributeSet);
                if (preferenceScreen == null) {
                    preferenceGroup = preferenceScreen;
                    preferenceGroup2.l(this.c);
                    preferenceGroup = preferenceGroup2;
                }
                preferenceGroup = preferenceScreen;
                d(xmlResourceParser, preferenceGroup, attributeSetAsAttributeSet);
            } catch (Throwable th) {
                throw th;
            }
        }
        return preferenceGroup;
    }

    public final void d(XmlResourceParser xmlResourceParser, Preference preference, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        long jC;
        int depth = xmlResourceParser.getDepth();
        while (true) {
            int next = xmlResourceParser.next();
            if ((next == 3 && xmlResourceParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlResourceParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.s = Intent.parseIntent(this.a.getResources(), xmlResourceParser, attributeSet);
                    } catch (IOException e2) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e2);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    Resources resources = this.a.getResources();
                    if (preference.u == null) {
                        preference.u = new Bundle();
                    }
                    resources.parseBundleExtra("extra", attributeSet, preference.u);
                    try {
                        int depth2 = xmlResourceParser.getDepth();
                        while (true) {
                            int next2 = xmlResourceParser.next();
                            if (next2 == 1 || (next2 == 3 && xmlResourceParser.getDepth() <= depth2)) {
                                break;
                            }
                        }
                    } catch (IOException e3) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e3);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference preferenceB = b(name, attributeSet);
                    PreferenceGroup preferenceGroup = (PreferenceGroup) preference;
                    if (!preferenceGroup.U.contains(preferenceB)) {
                        if (preferenceB.r != null) {
                            PreferenceGroup preferenceGroup2 = preferenceGroup;
                            while (true) {
                                PreferenceGroup preferenceGroup3 = preferenceGroup2.O;
                                if (preferenceGroup3 == null) {
                                    break;
                                } else {
                                    preferenceGroup2 = preferenceGroup3;
                                }
                            }
                            preferenceGroup2.A(preferenceB.r);
                        }
                        int i = preferenceB.j;
                        if (i == Integer.MAX_VALUE) {
                            if (preferenceGroup.V) {
                                int i2 = preferenceGroup.W;
                                preferenceGroup.W = i2 + 1;
                                if (i2 != i) {
                                    preferenceB.j = i2;
                                    c cVar = preferenceB.M;
                                    if (cVar != null) {
                                        Handler handler = cVar.e;
                                        c.a aVar = cVar.f;
                                        handler.removeCallbacks(aVar);
                                        handler.post(aVar);
                                    }
                                }
                            }
                            if (preferenceB instanceof PreferenceGroup) {
                                ((PreferenceGroup) preferenceB).V = preferenceGroup.V;
                            }
                        }
                        int iBinarySearch = Collections.binarySearch(preferenceGroup.U, preferenceB);
                        if (iBinarySearch < 0) {
                            iBinarySearch = (iBinarySearch * (-1)) - 1;
                        }
                        boolean zY = preferenceGroup.y();
                        if (preferenceB.B == zY) {
                            preferenceB.B = !zY;
                            preferenceB.j(preferenceB.y());
                            preferenceB.i();
                        }
                        synchronized (preferenceGroup) {
                            preferenceGroup.U.add(iBinarySearch, preferenceB);
                        }
                        e eVar = preferenceGroup.c;
                        String str = preferenceB.r;
                        if (str == null || !preferenceGroup.T.containsKey(str)) {
                            jC = eVar.c();
                        } else {
                            jC = ((Long) preferenceGroup.T.getOrDefault(str, null)).longValue();
                            preferenceGroup.T.remove(str);
                        }
                        preferenceB.d = jC;
                        preferenceB.f = true;
                        try {
                            preferenceB.l(eVar);
                            preferenceB.f = false;
                            if (preferenceB.O != null) {
                                d.AnonymousClass0.m("This preference already has a parent. You must remove the existing parent before assigning a new one.");
                                return;
                            }
                            preferenceB.O = preferenceGroup;
                            if (preferenceGroup.X) {
                                preferenceB.k();
                            }
                            c cVar2 = preferenceGroup.M;
                            if (cVar2 != null) {
                                Handler handler2 = cVar2.e;
                                c.a aVar2 = cVar2.f;
                                handler2.removeCallbacks(aVar2);
                                handler2.post(aVar2);
                            }
                        } catch (Throwable th) {
                            preferenceB.f = false;
                            throw th;
                        }
                    }
                    d(xmlResourceParser, preferenceB, attributeSet);
                }
            }
        }
    }
}
