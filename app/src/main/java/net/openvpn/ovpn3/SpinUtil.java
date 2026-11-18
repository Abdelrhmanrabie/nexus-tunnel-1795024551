package net.openvpn.ovpn3;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SpinUtil {
    public static int get_spinner_count(Spinner spinner) {
        ArrayAdapter arrayAdapter = (ArrayAdapter) spinner.getAdapter();
        if (arrayAdapter == null) {
            return 0;
        }
        return arrayAdapter.getCount();
    }

    public static String[] get_spinner_list(Spinner spinner) {
        ArrayAdapter arrayAdapter = (ArrayAdapter) spinner.getAdapter();
        if (arrayAdapter == null) {
            return null;
        }
        int count = arrayAdapter.getCount();
        String[] strArr = new String[count];
        for (int i = 0; i < count; i++) {
            strArr[i] = (String) arrayAdapter.getItem(i);
        }
        return strArr;
    }

    public static String get_spinner_list_item(Spinner spinner, int i) {
        ArrayAdapter arrayAdapter = (ArrayAdapter) spinner.getAdapter();
        if (arrayAdapter == null) {
            return null;
        }
        return (String) arrayAdapter.getItem(i);
    }

    public static JSONObject get_spinner_selected_item(Spinner spinner) {
        return (JSONObject) spinner.getSelectedItem();
    }

    public static void set_spinner_selected_item(Spinner spinner, String str) {
        String string;
        if (str != null) {
            try {
                string = get_spinner_selected_item(spinner).getString("Name");
            } catch (JSONException e) {
                e.printStackTrace();
                string = null;
            }
            if (string == null || !str.equals(string)) {
                ArrayAdapter arrayAdapter = (ArrayAdapter) spinner.getAdapter();
                int count = arrayAdapter.getCount();
                for (int i = 0; i < count; i++) {
                    if (str.equals(arrayAdapter.getItem(i))) {
                        spinner.setSelection(i);
                    }
                }
            }
        }
    }

    public static void show_spinner(Context context, Spinner spinner, String[] strArr) {
        if (strArr != null) {
            get_spinner_list(spinner);
        }
    }
}
