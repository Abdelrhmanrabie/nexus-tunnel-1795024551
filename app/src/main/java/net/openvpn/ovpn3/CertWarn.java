package net.openvpn.ovpn3;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.e;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.security.auth.x500.X500Principal;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
abstract class CertWarn implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener {
    public static final int RESPONSE_ACCEPT = 1;
    public static final int RESPONSE_REJECT = 0;
    private static final String TAG = "CertWarn";

    public CertWarn(Context context, X509Certificate x509Certificate, String str) {
        Runnable runnable = new Runnable() { // from class: net.openvpn.ovpn3.CertWarn.1
            @Override // java.lang.Runnable
            public void run() {
                CertWarn.this.done(0);
            }
        };
        try {
            e.a aVar = new e.a(context);
            AlertController.b bVar = aVar.P;
            aVar.setTitle(R.string.bq);
            bVar.y = inflateCertificateView(context, x509Certificate, str);
            bVar.D = false;
            aVar.setPositiveButton(R.string.bo, this);
            aVar.setNegativeButton(R.string.bp, this);
            bVar.r = this;
            aVar.create().show();
        } catch (Exception unused) {
            new Handler().postDelayed(runnable, 0L);
        }
    }

    private static final String fingerprint(byte[] bArr) {
        if (bArr == null) {
            return AppConfig.CUSTOM;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < bArr.length) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[i])));
            i++;
            if (i != bArr.length) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    private static String formatCertificateDate(Date date, DateFormat dateFormat) {
        return date == null ? AppConfig.CUSTOM : dateFormat.format(date);
    }

    private static String getDigest(X509Certificate x509Certificate, String str) {
        if (x509Certificate == null) {
            return AppConfig.CUSTOM;
        }
        try {
            return fingerprint(MessageDigest.getInstance(str).digest(x509Certificate.getEncoded()));
        } catch (NoSuchAlgorithmException | CertificateEncodingException unused) {
            return AppConfig.CUSTOM;
        }
    }

    private static String getSerialNumber(X509Certificate x509Certificate) {
        BigInteger serialNumber;
        return (x509Certificate == null || (serialNumber = x509Certificate.getSerialNumber()) == null) ? AppConfig.CUSTOM : fingerprint(serialNumber.toByteArray());
    }

    private View inflateCertificateView(Context context, X509Certificate x509Certificate, String str) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.b0, (ViewGroup) null);
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context);
        ((TextView) viewInflate.findViewById(R.attr.eo)).setText(str);
        HashMap<String, String> map = parse_dn(x509Certificate.getIssuerX500Principal());
        HashMap<String, String> map2 = parse_dn(x509Certificate.getSubjectX500Principal());
        ((TextView) viewInflate.findViewById(R.attr.a1k)).setText(map2.get("CN"));
        ((TextView) viewInflate.findViewById(R.attr.a1m)).setText(map2.get("O"));
        ((TextView) viewInflate.findViewById(R.attr.a1o)).setText(map2.get("OU"));
        ((TextView) viewInflate.findViewById(R.attr.e4)).setText(map.get("CN"));
        ((TextView) viewInflate.findViewById(R.attr.e6)).setText(map.get("O"));
        ((TextView) viewInflate.findViewById(R.attr.e8)).setText(map.get("OU"));
        ((TextView) viewInflate.findViewById(R.attr.x1)).setText(getSerialNumber(x509Certificate));
        ((TextView) viewInflate.findViewById(R.attr.o3)).setText(formatCertificateDate(x509Certificate.getNotBefore(), dateFormat));
        ((TextView) viewInflate.findViewById(R.attr.kj)).setText(formatCertificateDate(x509Certificate.getNotAfter(), dateFormat));
        ((TextView) viewInflate.findViewById(R.attr.y0)).setText(getDigest(x509Certificate, "SHA256"));
        ((TextView) viewInflate.findViewById(R.attr.xy)).setText(getDigest(x509Certificate, "SHA1"));
        return viewInflate;
    }

    private static HashMap<String, String> parse_dn(String str) {
        HashMap<String, String> map = new HashMap<>();
        StringBuilder[] sbArr = {new StringBuilder(), new StringBuilder()};
        boolean z = false;
        char c = 0;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!z && cCharAt == '\\') {
                z = true;
            } else if (!z && cCharAt == '=') {
                c = 1;
            } else if (z || cCharAt != ',') {
                StringBuilder sb = sbArr[c];
                if (sb.length() > 0 || cCharAt != ' ') {
                    sb.append(cCharAt);
                }
                z = false;
            } else {
                if (sbArr[0].length() > 0 && sbArr[1].length() > 0) {
                    map.put(sbArr[0].toString(), sbArr[1].toString());
                    sbArr[0].setLength(0);
                    sbArr[1].setLength(0);
                }
                c = 0;
            }
        }
        if (sbArr[0].length() > 0 && sbArr[1].length() > 0) {
            map.put(sbArr[0].toString(), sbArr[1].toString());
        }
        return map;
    }

    private static HashMap<String, String> parse_dn(X500Principal x500Principal) {
        return parse_dn(x500Principal.getName("RFC2253"));
    }

    public abstract void done(int i);

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        done(0);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        done(i != -1 ? 0 : 1);
    }
}
