package renz.javacodez.v2ray.plugin;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import defpackage.ae;
import defpackage.he;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import renz.javacodez.v2ray.V2RAYApp;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class PluginList extends ArrayList<Plugin> {
    private final Map<String, Plugin> lookup;

    public PluginList() {
        List<ResolveInfo> listQueryIntentContentProviders = V2RAYApp.Companion.getApplication().getPackageManager().queryIntentContentProviders(new Intent(PluginContract.ACTION_NATIVE_PLUGIN), 128);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listQueryIntentContentProviders) {
            if (((ResolveInfo) obj).providerInfo.exported) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(ae.y0(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new NativePlugin((ResolveInfo) it.next()));
        }
        addAll(arrayList2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Plugin plugin : he.g1(this)) {
            lookup$lambda$2$check(plugin, this, (Plugin) linkedHashMap.put(plugin.getId(), plugin));
        }
        this.lookup = linkedHashMap;
    }

    private static final void lookup$lambda$2$check(Plugin plugin, PluginList pluginList, Plugin plugin2) {
        if (plugin2 == null || plugin2.equals(plugin)) {
            return;
        }
        pluginList.remove((Object) plugin2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Plugin) {
            return contains((Plugin) obj);
        }
        return false;
    }

    public /* bridge */ boolean contains(Plugin plugin) {
        return super.contains((Object) plugin);
    }

    public final Map<String, Plugin> getLookup() {
        return this.lookup;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Plugin) {
            return indexOf((Plugin) obj);
        }
        return -1;
    }

    public /* bridge */ int indexOf(Plugin plugin) {
        return super.indexOf((Object) plugin);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Plugin) {
            return lastIndexOf((Plugin) obj);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(Plugin plugin) {
        return super.lastIndexOf((Object) plugin);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ Plugin remove(int i) {
        return removeAt(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Plugin) {
            return remove((Plugin) obj);
        }
        return false;
    }

    public /* bridge */ boolean remove(Plugin plugin) {
        return super.remove((Object) plugin);
    }

    public /* bridge */ Plugin removeAt(int i) {
        return remove(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
