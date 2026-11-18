package net.openvpn.ovpn3;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class CPUUsage {
    private double end_time = 0.0d;
    private boolean halted = false;
    private double start_time = cpu_usage();

    private static native double cpu_usage();

    public void stop() {
        if (this.halted) {
            return;
        }
        this.end_time = cpu_usage();
        this.halted = true;
    }

    public double usage() {
        return (this.halted ? this.end_time : cpu_usage()) - this.start_time;
    }
}
