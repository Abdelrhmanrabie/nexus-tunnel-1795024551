package libv2ray;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public interface V2RayVPNServiceSupportsSet {
    long onEmitStatus(long j, String str);

    long prepare();

    boolean protect(long j);

    long setup(String str);

    long shutdown();
}
