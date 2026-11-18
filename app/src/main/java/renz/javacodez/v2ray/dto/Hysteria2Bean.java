package renz.javacodez.v2ray.dto;

import defpackage.e4;
import defpackage.fb$1;
import defpackage.zk;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Hysteria2Bean {
    private final String auth;
    private final Socks5Bean http;
    private final Boolean lazy;
    private final ObfsBean obfs;
    private final String server;
    private final Socks5Bean socks5;
    private final TlsBean tls;
    private final TransportBean transport;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class ObfsBean {
        private final SalamanderBean salamander;
        private final String type;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static final class SalamanderBean {
            private final String password;

            public SalamanderBean(String str) {
                this.password = str;
            }

            public static /* synthetic */ SalamanderBean copy$default(SalamanderBean salamanderBean, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = salamanderBean.password;
                }
                return salamanderBean.copy(str);
            }

            public final String component1() {
                return this.password;
            }

            public final SalamanderBean copy(String str) {
                return new SalamanderBean(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SalamanderBean) && e4.a(this.password, ((SalamanderBean) obj).password);
            }

            public final String getPassword() {
                return this.password;
            }

            public int hashCode() {
                String str = this.password;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return fb$1.m(new StringBuilder("SalamanderBean(password="), this.password, ')');
            }
        }

        public ObfsBean(String str, SalamanderBean salamanderBean) {
            this.type = str;
            this.salamander = salamanderBean;
        }

        public static /* synthetic */ ObfsBean copy$default(ObfsBean obfsBean, String str, SalamanderBean salamanderBean, int i, Object obj) {
            if ((i & 1) != 0) {
                str = obfsBean.type;
            }
            if ((i & 2) != 0) {
                salamanderBean = obfsBean.salamander;
            }
            return obfsBean.copy(str, salamanderBean);
        }

        public final String component1() {
            return this.type;
        }

        public final SalamanderBean component2() {
            return this.salamander;
        }

        public final ObfsBean copy(String str, SalamanderBean salamanderBean) {
            return new ObfsBean(str, salamanderBean);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ObfsBean)) {
                return false;
            }
            ObfsBean obfsBean = (ObfsBean) obj;
            return e4.a(this.type, obfsBean.type) && e4.a(this.salamander, obfsBean.salamander);
        }

        public final SalamanderBean getSalamander() {
            return this.salamander;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            String str = this.type;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            SalamanderBean salamanderBean = this.salamander;
            return iHashCode + (salamanderBean != null ? salamanderBean.hashCode() : 0);
        }

        public String toString() {
            return "ObfsBean(type=" + this.type + ", salamander=" + this.salamander + ')';
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class Socks5Bean {
        private final String listen;

        public Socks5Bean(String str) {
            this.listen = str;
        }

        public static /* synthetic */ Socks5Bean copy$default(Socks5Bean socks5Bean, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = socks5Bean.listen;
            }
            return socks5Bean.copy(str);
        }

        public final String component1() {
            return this.listen;
        }

        public final Socks5Bean copy(String str) {
            return new Socks5Bean(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Socks5Bean) && e4.a(this.listen, ((Socks5Bean) obj).listen);
        }

        public final String getListen() {
            return this.listen;
        }

        public int hashCode() {
            String str = this.listen;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return fb$1.m(new StringBuilder("Socks5Bean(listen="), this.listen, ')');
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class TlsBean {
        private final Boolean insecure;
        private final String pinSHA256;
        private final String sni;

        public TlsBean(String str, Boolean bool, String str2) {
            this.sni = str;
            this.insecure = bool;
            this.pinSHA256 = str2;
        }

        public static /* synthetic */ TlsBean copy$default(TlsBean tlsBean, String str, Boolean bool, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tlsBean.sni;
            }
            if ((i & 2) != 0) {
                bool = tlsBean.insecure;
            }
            if ((i & 4) != 0) {
                str2 = tlsBean.pinSHA256;
            }
            return tlsBean.copy(str, bool, str2);
        }

        public final String component1() {
            return this.sni;
        }

        public final Boolean component2() {
            return this.insecure;
        }

        public final String component3() {
            return this.pinSHA256;
        }

        public final TlsBean copy(String str, Boolean bool, String str2) {
            return new TlsBean(str, bool, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TlsBean)) {
                return false;
            }
            TlsBean tlsBean = (TlsBean) obj;
            return e4.a(this.sni, tlsBean.sni) && e4.a(this.insecure, tlsBean.insecure) && e4.a(this.pinSHA256, tlsBean.pinSHA256);
        }

        public final Boolean getInsecure() {
            return this.insecure;
        }

        public final String getPinSHA256() {
            return this.pinSHA256;
        }

        public final String getSni() {
            return this.sni;
        }

        public int hashCode() {
            String str = this.sni;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Boolean bool = this.insecure;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            String str2 = this.pinSHA256;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("TlsBean(sni=");
            sb.append(this.sni);
            sb.append(", insecure=");
            sb.append(this.insecure);
            sb.append(", pinSHA256=");
            return fb$1.m(sb, this.pinSHA256, ')');
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class TransportBean {
        private final String type;
        private final TransportUdpBean udp;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static final class TransportUdpBean {
            private final String hopInterval;

            public TransportUdpBean(String str) {
                this.hopInterval = str;
            }

            public static /* synthetic */ TransportUdpBean copy$default(TransportUdpBean transportUdpBean, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = transportUdpBean.hopInterval;
                }
                return transportUdpBean.copy(str);
            }

            public final String component1() {
                return this.hopInterval;
            }

            public final TransportUdpBean copy(String str) {
                return new TransportUdpBean(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof TransportUdpBean) && e4.a(this.hopInterval, ((TransportUdpBean) obj).hopInterval);
            }

            public final String getHopInterval() {
                return this.hopInterval;
            }

            public int hashCode() {
                String str = this.hopInterval;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return fb$1.m(new StringBuilder("TransportUdpBean(hopInterval="), this.hopInterval, ')');
            }
        }

        public TransportBean(String str, TransportUdpBean transportUdpBean) {
            this.type = str;
            this.udp = transportUdpBean;
        }

        public static /* synthetic */ TransportBean copy$default(TransportBean transportBean, String str, TransportUdpBean transportUdpBean, int i, Object obj) {
            if ((i & 1) != 0) {
                str = transportBean.type;
            }
            if ((i & 2) != 0) {
                transportUdpBean = transportBean.udp;
            }
            return transportBean.copy(str, transportUdpBean);
        }

        public final String component1() {
            return this.type;
        }

        public final TransportUdpBean component2() {
            return this.udp;
        }

        public final TransportBean copy(String str, TransportUdpBean transportUdpBean) {
            return new TransportBean(str, transportUdpBean);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransportBean)) {
                return false;
            }
            TransportBean transportBean = (TransportBean) obj;
            return e4.a(this.type, transportBean.type) && e4.a(this.udp, transportBean.udp);
        }

        public final String getType() {
            return this.type;
        }

        public final TransportUdpBean getUdp() {
            return this.udp;
        }

        public int hashCode() {
            String str = this.type;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            TransportUdpBean transportUdpBean = this.udp;
            return iHashCode + (transportUdpBean != null ? transportUdpBean.hashCode() : 0);
        }

        public String toString() {
            return "TransportBean(type=" + this.type + ", udp=" + this.udp + ')';
        }
    }

    public Hysteria2Bean(String str, String str2, Boolean bool, ObfsBean obfsBean, Socks5Bean socks5Bean, Socks5Bean socks5Bean2, TlsBean tlsBean, TransportBean transportBean) {
        this.server = str;
        this.auth = str2;
        this.lazy = bool;
        this.obfs = obfsBean;
        this.socks5 = socks5Bean;
        this.http = socks5Bean2;
        this.tls = tlsBean;
        this.transport = transportBean;
    }

    public /* synthetic */ Hysteria2Bean(String str, String str2, Boolean bool, ObfsBean obfsBean, Socks5Bean socks5Bean, Socks5Bean socks5Bean2, TlsBean tlsBean, TransportBean transportBean, int i, zk zkVar) {
        this(str, str2, (i & 4) != 0 ? Boolean.TRUE : bool, (i & 8) != 0 ? null : obfsBean, (i & 16) != 0 ? null : socks5Bean, (i & 32) != 0 ? null : socks5Bean2, (i & 64) != 0 ? null : tlsBean, (i & 128) != 0 ? null : transportBean);
    }

    public static /* synthetic */ Hysteria2Bean copy$default(Hysteria2Bean hysteria2Bean, String str, String str2, Boolean bool, ObfsBean obfsBean, Socks5Bean socks5Bean, Socks5Bean socks5Bean2, TlsBean tlsBean, TransportBean transportBean, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hysteria2Bean.server;
        }
        if ((i & 2) != 0) {
            str2 = hysteria2Bean.auth;
        }
        if ((i & 4) != 0) {
            bool = hysteria2Bean.lazy;
        }
        if ((i & 8) != 0) {
            obfsBean = hysteria2Bean.obfs;
        }
        if ((i & 16) != 0) {
            socks5Bean = hysteria2Bean.socks5;
        }
        if ((i & 32) != 0) {
            socks5Bean2 = hysteria2Bean.http;
        }
        if ((i & 64) != 0) {
            tlsBean = hysteria2Bean.tls;
        }
        if ((i & 128) != 0) {
            transportBean = hysteria2Bean.transport;
        }
        TlsBean tlsBean2 = tlsBean;
        TransportBean transportBean2 = transportBean;
        Socks5Bean socks5Bean3 = socks5Bean;
        Socks5Bean socks5Bean4 = socks5Bean2;
        return hysteria2Bean.copy(str, str2, bool, obfsBean, socks5Bean3, socks5Bean4, tlsBean2, transportBean2);
    }

    public final String component1() {
        return this.server;
    }

    public final String component2() {
        return this.auth;
    }

    public final Boolean component3() {
        return this.lazy;
    }

    public final ObfsBean component4() {
        return this.obfs;
    }

    public final Socks5Bean component5() {
        return this.socks5;
    }

    public final Socks5Bean component6() {
        return this.http;
    }

    public final TlsBean component7() {
        return this.tls;
    }

    public final TransportBean component8() {
        return this.transport;
    }

    public final Hysteria2Bean copy(String str, String str2, Boolean bool, ObfsBean obfsBean, Socks5Bean socks5Bean, Socks5Bean socks5Bean2, TlsBean tlsBean, TransportBean transportBean) {
        return new Hysteria2Bean(str, str2, bool, obfsBean, socks5Bean, socks5Bean2, tlsBean, transportBean);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Hysteria2Bean)) {
            return false;
        }
        Hysteria2Bean hysteria2Bean = (Hysteria2Bean) obj;
        return e4.a(this.server, hysteria2Bean.server) && e4.a(this.auth, hysteria2Bean.auth) && e4.a(this.lazy, hysteria2Bean.lazy) && e4.a(this.obfs, hysteria2Bean.obfs) && e4.a(this.socks5, hysteria2Bean.socks5) && e4.a(this.http, hysteria2Bean.http) && e4.a(this.tls, hysteria2Bean.tls) && e4.a(this.transport, hysteria2Bean.transport);
    }

    public final String getAuth() {
        return this.auth;
    }

    public final Socks5Bean getHttp() {
        return this.http;
    }

    public final Boolean getLazy() {
        return this.lazy;
    }

    public final ObfsBean getObfs() {
        return this.obfs;
    }

    public final String getServer() {
        return this.server;
    }

    public final Socks5Bean getSocks5() {
        return this.socks5;
    }

    public final TlsBean getTls() {
        return this.tls;
    }

    public final TransportBean getTransport() {
        return this.transport;
    }

    public int hashCode() {
        String str = this.server;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.auth;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.lazy;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        ObfsBean obfsBean = this.obfs;
        int iHashCode4 = (iHashCode3 + (obfsBean == null ? 0 : obfsBean.hashCode())) * 31;
        Socks5Bean socks5Bean = this.socks5;
        int iHashCode5 = (iHashCode4 + (socks5Bean == null ? 0 : socks5Bean.hashCode())) * 31;
        Socks5Bean socks5Bean2 = this.http;
        int iHashCode6 = (iHashCode5 + (socks5Bean2 == null ? 0 : socks5Bean2.hashCode())) * 31;
        TlsBean tlsBean = this.tls;
        int iHashCode7 = (iHashCode6 + (tlsBean == null ? 0 : tlsBean.hashCode())) * 31;
        TransportBean transportBean = this.transport;
        return iHashCode7 + (transportBean != null ? transportBean.hashCode() : 0);
    }

    public String toString() {
        return "Hysteria2Bean(server=" + this.server + ", auth=" + this.auth + ", lazy=" + this.lazy + ", obfs=" + this.obfs + ", socks5=" + this.socks5 + ", http=" + this.http + ", tls=" + this.tls + ", transport=" + this.transport + ')';
    }
}
