package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class vu0 implements Serializable {
    public final /* synthetic */ int G0 = 1;
    public Object b;

    public /* synthetic */ vu0() {
    }

    public vu0(String str) {
        this.b = Pattern.compile(str);
    }

    public List a(String str) {
        int iEnd = 0;
        q31.q0(0);
        Matcher matcher = ((Pattern) this.b).matcher(str);
        if (!matcher.find()) {
            return Collections.singletonList(str.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        do {
            arrayList.add(str.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
        } while (matcher.find());
        arrayList.add(str.subSequence(iEnd, str.length()).toString());
        return arrayList;
    }

    public final String toString() {
        int i = this.G0;
        Object obj = this.b;
        return i != 0 ? String.valueOf(obj) : ((Pattern) obj).toString();
    }
}
