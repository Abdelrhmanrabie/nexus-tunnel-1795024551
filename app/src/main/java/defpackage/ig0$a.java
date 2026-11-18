package defpackage;

import java.util.regex.Matcher;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ig0$a extends z {
    public final /* synthetic */ g b;

    public ig0$a(g gVar) {
        this.b = gVar;
    }

    @Override // defpackage.z
    public final int b() {
        return ((Matcher) this.b.a).groupCount() + 1;
    }

    @Override // defpackage.z, java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof String) {
            return super.contains((String) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        String strGroup = ((Matcher) this.b.a).group(i);
        return strGroup == null ? AppConfig.CUSTOM : strGroup;
    }

    @Override // defpackage.z, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof String) {
            return super.indexOf((String) obj);
        }
        return -1;
    }

    @Override // defpackage.z, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return super.lastIndexOf((String) obj);
        }
        return -1;
    }
}
