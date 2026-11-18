package org.apache.http.conn.ssl;

import defpackage.e;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.util.InetAddressUtils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractVerifier implements HostnameVerifier {
    static {
        Arrays.sort(new String[]{"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"});
    }

    public static boolean matchIdentity(String str, String str2) {
        boolean zEndsWith;
        if (str != null) {
            Locale locale = Locale.ROOT;
            String lowerCase = str.toLowerCase(locale);
            String lowerCase2 = str2.toLowerCase(locale);
            String[] strArrSplit = lowerCase2.split("\\.");
            if (strArrSplit.length < 3 || !strArrSplit[0].endsWith("*")) {
                return lowerCase.equals(lowerCase2);
            }
            String str3 = strArrSplit[0];
            if (str3.length() > 1) {
                String strSubstring = str3.substring(0, str3.length() - 1);
                zEndsWith = lowerCase.startsWith(strSubstring) && lowerCase.substring(strSubstring.length()).endsWith(lowerCase2.substring(str3.length()));
            } else {
                zEndsWith = lowerCase.endsWith(lowerCase2.substring(1));
            }
            if (zEndsWith) {
                return true;
            }
        }
        return false;
    }

    public static void verify(X509Certificate x509Certificate, String str) throws SSLException {
        List<SubjectName> list;
        String lowerCase;
        String hostAddress;
        List<String> listAsList = null;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                list = Collections.EMPTY_LIST;
            } else {
                ArrayList arrayList = new ArrayList();
                for (List<?> list2 : subjectAlternativeNames) {
                    Integer num = list2.size() >= 2 ? (Integer) list2.get(0) : null;
                    if (num != null && (num.intValue() == 2 || num.intValue() == 7)) {
                        Object obj = list2.get(1);
                        if (obj instanceof String) {
                            arrayList.add(new SubjectName((String) obj, num.intValue()));
                        }
                    }
                }
                list = arrayList;
            }
        } catch (CertificateParsingException unused) {
            list = Collections.EMPTY_LIST;
        }
        ArrayList arrayList2 = new ArrayList();
        if (InetAddressUtils.IPV4_PATTERN.matcher(str).matches() || InetAddressUtils.isIPv6Address(str)) {
            for (SubjectName subjectName : list) {
                if (subjectName.type == 7) {
                    arrayList2.add(subjectName.value);
                }
            }
        } else {
            for (SubjectName subjectName2 : list) {
                if (subjectName2.type == 2) {
                    arrayList2.add(subjectName2.value);
                }
            }
        }
        String strExtractCN = DefaultHostnameVerifier.extractCN(x509Certificate.getSubjectX500Principal().getName("RFC2253"));
        String[] strArr = strExtractCN != null ? new String[]{strExtractCN} : null;
        String[] strArr2 = !arrayList2.isEmpty() ? (String[]) arrayList2.toArray(new String[arrayList2.size()]) : null;
        String str2 = (strArr == null || strArr.length <= 0) ? null : strArr[0];
        if (strArr2 != null && strArr2.length > 0) {
            listAsList = Arrays.asList(strArr2);
        }
        if (InetAddressUtils.isIPv6Address(str)) {
            lowerCase = str.toLowerCase(Locale.ROOT);
            if (lowerCase != null) {
                try {
                    lowerCase = InetAddress.getByName(lowerCase).getHostAddress();
                } catch (UnknownHostException unused2) {
                }
            }
        } else {
            lowerCase = str;
        }
        if (listAsList != null) {
            for (String hostAddress2 : listAsList) {
                if (InetAddressUtils.isIPv6Address(hostAddress2) && hostAddress2 != null) {
                    try {
                        hostAddress2 = InetAddress.getByName(hostAddress2).getHostAddress();
                    } catch (UnknownHostException unused3) {
                    }
                }
                if (matchIdentity(lowerCase, hostAddress2)) {
                    return;
                }
            }
            throw new SSLException("Certificate for <" + str + "> doesn't match any of the subject alternative names: " + listAsList);
        }
        if (str2 == null) {
            throw new SSLException(e.n("Certificate subject for <", str, "> doesn't contain a common name and does not have alternative names"));
        }
        if (InetAddressUtils.isIPv6Address(str2)) {
            try {
                hostAddress = InetAddress.getByName(str2).getHostAddress();
            } catch (UnknownHostException unused4) {
                hostAddress = str2;
            }
        } else {
            hostAddress = str2;
        }
        if (matchIdentity(lowerCase, hostAddress)) {
            return;
        }
        throw new SSLException("Certificate for <" + str + "> doesn't match common name of the certificate subject: " + str2);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            verify((X509Certificate) sSLSession.getPeerCertificates()[0], str);
            return true;
        } catch (SSLException unused) {
            throw null;
        }
    }
}
