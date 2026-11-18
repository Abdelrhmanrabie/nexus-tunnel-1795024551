package defpackage;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class m2 extends l2 {
    public final /* synthetic */ int G0;

    public /* synthetic */ m2(int i) {
        this.G0 = i;
    }

    @Override // defpackage.l2
    public final Intent a(Object obj) {
        if (this.G0 != 0) {
            return (Intent) obj;
        }
        return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", (String[]) obj);
    }

    @Override // defpackage.l2
    public o6 b(ComponentActivity componentActivity, Object obj) {
        if (this.G0 != 0) {
            return super.b(componentActivity, obj);
        }
        String[] strArr = (String[]) obj;
        if (strArr.length == 0) {
            return new o6(vq.b);
        }
        for (String str : strArr) {
            if (b2.checkSelfPermission(componentActivity, str) != 0) {
                return null;
            }
        }
        int iE = ye1.e(strArr.length);
        if (iE < 16) {
            iE = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iE);
        for (String str2 : strArr) {
            linkedHashMap.put(str2, Boolean.TRUE);
        }
        return new o6(linkedHashMap);
    }

    @Override // defpackage.l2
    public final Object c(Intent intent, int i) {
        if (this.G0 != 0) {
            return new j2(intent, i);
        }
        if (i == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra != null && stringArrayExtra != null) {
                ArrayList arrayList = new ArrayList(intArrayExtra.length);
                for (int i2 : intArrayExtra) {
                    arrayList.add(Boolean.valueOf(i2 == 0));
                }
                return ye1.j(he.k1(ae.D0(stringArrayExtra), arrayList));
            }
        }
        return vq.b;
    }
}
