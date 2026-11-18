package renz.javacodez.vpn.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import androidx.appcompat.app.AlertController;
import com.google.android.material.navigation.NavigationView;
import defpackage.m00;
import defpackage.m70;
import defpackage.mc1;
import defpackage.oz;
import defpackage.sy;
import defpackage.uh;
import java.io.File;
import java.io.FileOutputStream;
import net.lingala.zip4j.ZipFile;
import org.hamotunnelplus.xyz.R;
import org.json.JSONObject;
import renz.javacodez.v2ray.ui.SettingsActivity;
import renz.javacodez.vpn.wifitethering.MainActivityWifi;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class e implements NavigationView.OnNavigationItemSelectedListener {
    public final /* synthetic */ HamoTunnelPlusMain a;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            String strA;
            e eVar = e.this;
            ClipboardManager clipboardManager = (ClipboardManager) eVar.a.getSystemService(uh.a(-11725991738654L));
            HamoTunnelPlusMain hamoTunnelPlusMain = eVar.a;
            if (clipboardManager == null || clipboardManager.getText() == null) {
                hamoTunnelPlusMain.H(uh.a(-11768941411614L));
                return;
            }
            String strTrim = clipboardManager.getText().toString().trim();
            if (strTrim.isEmpty()) {
                strA = uh.a(-11884905528606L);
            } else {
                try {
                    String string = new JSONObject(mc1.b(hamoTunnelPlusMain, strTrim)).getString(uh.a(-11970804874526L));
                    int i2 = HamoTunnelPlusMain.b1;
                    if (!m70.a(string, hamoTunnelPlusMain.x().getString(uh.a(-62586994457886L)))) {
                        hamoTunnelPlusMain.H(uh.a(-12176963304734L));
                        return;
                    }
                    File file = new File(hamoTunnelPlusMain.getFilesDir(), uh.a(-12005164612894L));
                    ZipFile zipFile = new ZipFile(file);
                    if (file.exists()) {
                        zipFile.removeFile(uh.a(-12056704220446L));
                    }
                    File file2 = new File(hamoTunnelPlusMain.getFilesDir(), uh.a(-12082474024222L));
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    fileOutputStream.write(strTrim.getBytes());
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    zipFile.addFile(file2);
                    file2.delete();
                    hamoTunnelPlusMain.H(uh.a(-12108243827998L));
                    hamoTunnelPlusMain.r0();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    strA = uh.a(-12249977748766L) + e.getMessage();
                }
            }
            hamoTunnelPlusMain.H(strA);
        }
    }

    public e(HamoTunnelPlusMain hamoTunnelPlusMain) {
        this.a = hamoTunnelPlusMain;
    }

    @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        androidx.appcompat.app.e.a aVar;
        Intent intent;
        int itemId = menuItem.getItemId();
        HamoTunnelPlusMain hamoTunnelPlusMain = this.a;
        switch (itemId) {
            case R.attr.ql /* 2131362432 */:
                int i = HamoTunnelPlusMain.b1;
                hamoTunnelPlusMain.getClass();
                aVar = new androidx.appcompat.app.e.a(hamoTunnelPlusMain);
                String strA = uh.a(-51815216479518L);
                AlertController.b bVar = aVar.P;
                bVar.e = strA;
                bVar.g = uh.a(-51862461119774L);
                aVar.setPositiveButton(uh.a(-52940497911070L), new sy(1, hamoTunnelPlusMain));
                bVar.k = uh.a(-52987742551326L);
                bVar.m = null;
                aVar.show();
                break;
            case R.attr.qq /* 2131362437 */:
                hamoTunnelPlusMain.finish();
                break;
            case R.attr.qr /* 2131362438 */:
                intent = new Intent(hamoTunnelPlusMain, (Class<?>) IPHunterActivity.class);
                hamoTunnelPlusMain.startActivity(intent);
                break;
            case R.attr.qs /* 2131362439 */:
                aVar = new androidx.appcompat.app.e.a(hamoTunnelPlusMain);
                String strA2 = uh.a(-12554920426782L);
                AlertController.b bVar2 = aVar.P;
                bVar2.e = strA2;
                bVar2.g = uh.a(-12773963758878L);
                aVar.setPositiveButton(uh.a(-15604347206942L), new a());
                bVar2.k = uh.a(-15677361650974L);
                bVar2.m = null;
                aVar.show();
                break;
            case R.attr.qt /* 2131362440 */:
                int i2 = HamoTunnelPlusMain.b1;
                View viewInflate = hamoTunnelPlusMain.getLayoutInflater().inflate(R.layout.b7, (ViewGroup) null);
                androidx.appcompat.app.e eVarCreate = new androidx.appcompat.app.e.a(hamoTunnelPlusMain).create();
                eVarCreate.setTitle(uh.a(-44084275346718L));
                Switch r4 = (Switch) viewInflate.findViewById(R.attr.jc);
                EditText editText = (EditText) viewInflate.findViewById(R.attr.h5);
                EditText editText2 = (EditText) viewInflate.findViewById(R.attr.h9);
                View viewFindViewById = viewInflate.findViewById(R.attr.vz);
                editText.setText(hamoTunnelPlusMain.i0.d());
                editText2.setText(hamoTunnelPlusMain.i0.f());
                r4.setChecked(hamoTunnelPlusMain.i0.v());
                editText.setEnabled(hamoTunnelPlusMain.i0.v());
                editText2.setEnabled(hamoTunnelPlusMain.i0.v());
                r4.setOnCheckedChangeListener(new oz(editText, editText2));
                viewFindViewById.setOnClickListener(new m00(hamoTunnelPlusMain, editText, editText2, r4, eVarCreate));
                eVarCreate.b(viewInflate);
                eVarCreate.show();
                break;
            case R.attr.qu /* 2131362441 */:
                int i3 = HamoTunnelPlusMain.b1;
                hamoTunnelPlusMain.B0();
                break;
            case R.attr.qv /* 2131362442 */:
                hamoTunnelPlusMain.startActivityForResult(new Intent(uh.a(-12391711669534L)).setType(uh.a(-12537740557598L)), 1996);
                break;
            case R.attr.qw /* 2131362443 */:
                intent = new Intent(hamoTunnelPlusMain.getApplicationContext(), (Class<?>) SettingsActivity.class);
                hamoTunnelPlusMain.startActivity(intent);
                break;
            case R.attr.qy /* 2131362445 */:
                hamoTunnelPlusMain.H(uh.a(-12310107290910L));
                hamoTunnelPlusMain.j0 = true;
                hamoTunnelPlusMain.R();
                break;
            case R.attr.qz /* 2131362446 */:
                int i4 = HamoTunnelPlusMain.b1;
                hamoTunnelPlusMain.getClass();
                intent = new Intent(hamoTunnelPlusMain, (Class<?>) MainActivityWifi.class);
                hamoTunnelPlusMain.startActivity(intent);
                break;
            case R.attr.r0 /* 2131362447 */:
                intent = new Intent(uh.a(-15707426422046L), Uri.parse(uh.a(-15823390539038L)));
                hamoTunnelPlusMain.startActivity(intent);
                break;
        }
        hamoTunnelPlusMain.C0.c(false);
        return false;
    }
}
