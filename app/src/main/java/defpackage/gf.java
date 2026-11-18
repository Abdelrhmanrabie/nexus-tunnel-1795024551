package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.n;
import androidx.savedstate.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gf implements a.b {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object a;

    public /* synthetic */ gf(int i, Object obj) {
        this.G0 = i;
        this.a = obj;
    }

    @Override // androidx.savedstate.a.b
    public final Bundle a() {
        Map mapSingletonMap;
        String str;
        int i = this.G0;
        Object obj = this.a;
        if (i == 0) {
            return ComponentActivity.l((ComponentActivity) obj);
        }
        if (i != 1) {
            Bundle bundle = new Bundle();
            ((w4) obj).getDelegate().getClass();
            return bundle;
        }
        n nVar = (n) obj;
        LinkedHashMap linkedHashMap = nVar.b;
        int size = linkedHashMap.size();
        if (size == 0) {
            mapSingletonMap = vq.b;
        } else if (size != 1) {
            mapSingletonMap = new LinkedHashMap(linkedHashMap);
        } else {
            Map.Entry entry = (Map.Entry) linkedHashMap.entrySet().iterator().next();
            mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        }
        Iterator it = mapSingletonMap.entrySet().iterator();
        do {
            boolean zHasNext = it.hasNext();
            LinkedHashMap linkedHashMap2 = nVar.a;
            int i2 = 0;
            if (!zHasNext) {
                Set<String> setKeySet = linkedHashMap2.keySet();
                ArrayList arrayList = new ArrayList(setKeySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String str2 : setKeySet) {
                    arrayList.add(str2);
                    arrayList2.add(linkedHashMap2.get(str2));
                }
                jo0[] jo0VarArr = {new jo0("keys", arrayList), new jo0("values", arrayList2)};
                Bundle bundle2 = new Bundle(2);
                while (i2 < 2) {
                    jo0 jo0Var = jo0VarArr[i2];
                    String str3 = (String) jo0Var.b;
                    Object obj2 = jo0Var.c;
                    if (obj2 == null) {
                        bundle2.putString(str3, null);
                    } else if (obj2 instanceof Boolean) {
                        bundle2.putBoolean(str3, ((Boolean) obj2).booleanValue());
                    } else if (obj2 instanceof Byte) {
                        bundle2.putByte(str3, ((Number) obj2).byteValue());
                    } else if (obj2 instanceof Character) {
                        bundle2.putChar(str3, ((Character) obj2).charValue());
                    } else if (obj2 instanceof Double) {
                        bundle2.putDouble(str3, ((Number) obj2).doubleValue());
                    } else if (obj2 instanceof Float) {
                        bundle2.putFloat(str3, ((Number) obj2).floatValue());
                    } else if (obj2 instanceof Integer) {
                        bundle2.putInt(str3, ((Number) obj2).intValue());
                    } else if (obj2 instanceof Long) {
                        bundle2.putLong(str3, ((Number) obj2).longValue());
                    } else if (obj2 instanceof Short) {
                        bundle2.putShort(str3, ((Number) obj2).shortValue());
                    } else if (obj2 instanceof Bundle) {
                        bundle2.putBundle(str3, (Bundle) obj2);
                    } else if (obj2 instanceof CharSequence) {
                        bundle2.putCharSequence(str3, (CharSequence) obj2);
                    } else if (obj2 instanceof Parcelable) {
                        bundle2.putParcelable(str3, (Parcelable) obj2);
                    } else if (obj2 instanceof boolean[]) {
                        bundle2.putBooleanArray(str3, (boolean[]) obj2);
                    } else if (obj2 instanceof byte[]) {
                        bundle2.putByteArray(str3, (byte[]) obj2);
                    } else if (obj2 instanceof char[]) {
                        bundle2.putCharArray(str3, (char[]) obj2);
                    } else if (obj2 instanceof double[]) {
                        bundle2.putDoubleArray(str3, (double[]) obj2);
                    } else if (obj2 instanceof float[]) {
                        bundle2.putFloatArray(str3, (float[]) obj2);
                    } else if (obj2 instanceof int[]) {
                        bundle2.putIntArray(str3, (int[]) obj2);
                    } else if (obj2 instanceof long[]) {
                        bundle2.putLongArray(str3, (long[]) obj2);
                    } else if (obj2 instanceof short[]) {
                        bundle2.putShortArray(str3, (short[]) obj2);
                    } else if (obj2 instanceof Object[]) {
                        Class<?> componentType = obj2.getClass().getComponentType();
                        if (Parcelable.class.isAssignableFrom(componentType)) {
                            bundle2.putParcelableArray(str3, (Parcelable[]) obj2);
                        } else if (String.class.isAssignableFrom(componentType)) {
                            bundle2.putStringArray(str3, (String[]) obj2);
                        } else if (CharSequence.class.isAssignableFrom(componentType)) {
                            bundle2.putCharSequenceArray(str3, (CharSequence[]) obj2);
                        } else {
                            if (!Serializable.class.isAssignableFrom(componentType)) {
                                throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str3 + '\"');
                            }
                            bundle2.putSerializable(str3, (Serializable) obj2);
                        }
                    } else if (obj2 instanceof Serializable) {
                        bundle2.putSerializable(str3, (Serializable) obj2);
                    } else if (obj2 instanceof IBinder) {
                        bundle2.putBinder(str3, (IBinder) obj2);
                    } else if (obj2 instanceof Size) {
                        bundle2.putSize(str3, (Size) obj2);
                    } else {
                        if (!(obj2 instanceof SizeF)) {
                            throw new IllegalArgumentException("Illegal value type " + obj2.getClass().getCanonicalName() + " for key \"" + str3 + '\"');
                        }
                        bundle2.putSizeF(str3, (SizeF) obj2);
                    }
                    i2++;
                }
                return bundle2;
            }
            Map.Entry entry2 = (Map.Entry) it.next();
            str = (String) entry2.getKey();
            Bundle bundleA = ((a.b) entry2.getValue()).a();
            if (bundleA != null) {
                Class[] clsArr = n.f;
                while (true) {
                    if (i2 >= 29) {
                        throw new IllegalArgumentException("Can't put value with type " + bundleA.getClass() + " into saved state");
                    }
                    if (clsArr[i2].isInstance(bundleA)) {
                        break;
                    }
                    i2++;
                }
            }
            Object obj3 = nVar.c.get(str);
            yi0 yi0Var = obj3 instanceof yi0 ? (yi0) obj3 : null;
            if (yi0Var != null) {
                yi0Var.i(bundleA);
            } else {
                linkedHashMap2.put(str, bundleA);
            }
        } while (nVar.d.get(str) == null);
        d.AnonymousClass0.m$1();
        return null;
    }
}
