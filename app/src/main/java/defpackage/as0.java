package defpackage;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import androidx.appcompat.view.menu.f;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.vpn.service.SSHVPNService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class as0 implements Runnable {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object b;

    public /* synthetic */ as0(int i, Object obj) {
        this.G0 = i;
        this.b = obj;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        bs0 bs0Var;
        Selector selector;
        int i = this.G0;
        Object obj = this.b;
        switch (i) {
            case 0:
                break;
            case 1:
                SSHVPNService sSHVPNService = (SSHVPNService) obj;
                sSHVPNService.v = true;
                sSHVPNService.w = false;
                sSHVPNService.x = new CountDownLatch(1);
                int i2 = 0;
                while (!sSHVPNService.w) {
                    if (i2 > 0) {
                        try {
                            sSHVPNService.e(uh.a(-119070109367582L) + sSHVPNService.getString(R.string.qd) + uh.a(-119108764073246L));
                        } catch (Exception unused) {
                            sSHVPNService.b();
                            try {
                                Thread.sleep(100L);
                                i2++;
                            } catch (InterruptedException unused2) {
                                sSHVPNService.h();
                            }
                        }
                    }
                    try {
                        Thread.sleep(100L);
                        sSHVPNService.g();
                    } catch (InterruptedException unused3) {
                        sSHVPNService.h();
                    }
                    sSHVPNService.v = false;
                    if (sSHVPNService.w) {
                        return;
                    }
                    try {
                        sSHVPNService.x.await();
                        return;
                    } catch (InterruptedException unused4) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                sSHVPNService.v = false;
                if (sSHVPNService.w) {
                    sSHVPNService.x.await();
                    return;
                }
                return;
            case 2:
                s3 s3Var = (s3) obj;
                s3Var.a(true);
                s3Var.invalidateSelf();
                return;
            case 3:
                f71 f71Var = (f71) obj;
                f5.f fVar = f71Var.b;
                f fVarT = f71Var.t();
                f fVar2 = fVarT != null ? fVarT : null;
                if (fVar2 != null) {
                    fVar2.stopDispatchingItemsChanged();
                }
                try {
                    fVarT.clear();
                    if (!fVar.onCreatePanelMenu(0, fVarT) || !fVar.onPreparePanel(0, null, fVarT)) {
                        fVarT.clear();
                    }
                    if (fVar2 != null) {
                        return;
                    } else {
                        return;
                    }
                } finally {
                    if (fVar2 != null) {
                        fVar2.startDispatchingItemsChanged();
                    }
                }
                break;
            case 4:
                jp jpVar = (jp) obj;
                jpVar.s = null;
                jpVar.drawableStateChanged();
                return;
            case 5:
                ((lb1) obj).interrupt();
                return;
            case 6:
                ue0 ue0Var = (ue0) obj;
                if (ue0Var.u) {
                    boolean z = ue0Var.s;
                    s7$a s7_a = ue0Var.b;
                    if (z) {
                        ue0Var.s = false;
                        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        s7_a.e = jCurrentAnimationTimeMillis;
                        s7_a.g = -1L;
                        s7_a.f = jCurrentAnimationTimeMillis;
                        s7_a.h = 0.5f;
                    }
                    if ((s7_a.g > 0 && AnimationUtils.currentAnimationTimeMillis() > s7_a.g + ((long) s7_a.i)) || !ue0Var.e()) {
                        ue0Var.u = false;
                        return;
                    }
                    boolean z2 = ue0Var.t;
                    jp jpVar2 = ue0Var.d;
                    if (z2) {
                        ue0Var.t = false;
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                        jpVar2.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (s7_a.f == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float fA = s7_a.a(jCurrentAnimationTimeMillis2);
                    long j = jCurrentAnimationTimeMillis2 - s7_a.f;
                    s7_a.f = jCurrentAnimationTimeMillis2;
                    ue0Var.x.scrollListBy((int) (j * ((fA * 4.0f) + ((-4.0f) * fA * fA)) * s7_a.d));
                    WeakHashMap weakHashMap = qd1.a;
                    jpVar2.postOnAnimation(this);
                    return;
                }
                return;
            case 7:
                ((vd1) obj).p(0);
                return;
            default:
                ((zp) obj).f();
                return;
        }
        while (true) {
            bs0Var = (bs0) obj;
            if (bs0Var.d != null && (selector = bs0Var.c) != null) {
                try {
                    selector.select();
                    if (bs0Var.c.isOpen()) {
                        for (SelectionKey selectionKey : bs0Var.c.selectedKeys()) {
                            Object objAttachment = selectionKey.attachment();
                            try {
                                (objAttachment instanceof bc ? (bc) objAttachment : new bc()).a(selectionKey);
                            } catch (Exception unused5) {
                            }
                        }
                    }
                } catch (Exception unused6) {
                }
            }
        }
        bs0Var.b = false;
    }
}
