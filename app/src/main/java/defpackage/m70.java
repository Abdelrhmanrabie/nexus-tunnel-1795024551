package defpackage;

import android.os.AsyncTask;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class m70 extends AsyncTask {
    public static boolean a(String str, String str2) {
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int i = 0;
        while (i < strArrSplit.length && i < strArrSplit2.length && strArrSplit[i].equals(strArrSplit2[i])) {
            i++;
        }
        if (i >= strArrSplit.length || i >= strArrSplit2.length) {
            if (Integer.signum(strArrSplit.length - strArrSplit2.length) > 0) {
                return true;
            }
        } else if (Integer.signum(Integer.valueOf(strArrSplit[i]).compareTo(Integer.valueOf(strArrSplit2[i]))) > 0) {
            return true;
        }
        return false;
    }
}
