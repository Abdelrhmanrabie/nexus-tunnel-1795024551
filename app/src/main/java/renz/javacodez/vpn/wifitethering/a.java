package renz.javacodez.vpn.wifitethering;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.bs0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: renz.javacodez.vpn.wifitethering.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class AbstractBinderC0044a extends Binder implements a {
        public AbstractBinderC0044a() {
            attachInterface(this, "renz.javacodez.vpn.wifitethering.IProxyControl");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int iStart;
            if (i == 1) {
                parcel.enforceInterface("renz.javacodez.vpn.wifitethering.IProxyControl");
                iStart = ((ProxyService.a) this).start();
            } else if (i == 2) {
                parcel.enforceInterface("renz.javacodez.vpn.wifitethering.IProxyControl");
                iStart = ((ProxyService.a) this).stop();
            } else if (i == 3) {
                parcel.enforceInterface("renz.javacodez.vpn.wifitethering.IProxyControl");
                iStart = ((ProxyService.a) this).isRunning();
            } else {
                if (i != 4) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("renz.javacodez.vpn.wifitethering.IProxyControl");
                    return true;
                }
                parcel.enforceInterface("renz.javacodez.vpn.wifitethering.IProxyControl");
                iStart = bs0.a().a;
            }
            parcel2.writeNoException();
            parcel2.writeInt(iStart);
            return true;
        }
    }

    boolean isRunning();

    boolean start();

    boolean stop();
}
