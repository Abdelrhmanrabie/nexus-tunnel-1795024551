package defpackage;

import com.trilead.ssh2.sftp.AttribFlags;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Objects;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class bc {
    public zb a;
    public zb b;

    public final void a(SelectionKey selectionKey) {
        if (!selectionKey.isValid()) {
            zb zbVar = this.a;
            if (zbVar != null) {
                try {
                    zbVar.b.cancel();
                    zbVar.a.close();
                } catch (Exception unused) {
                }
            }
            zb zbVar2 = this.b;
            if (zbVar2 != null) {
                try {
                    zbVar2.b.cancel();
                    zbVar2.a.close();
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            return;
        }
        if (!selectionKey.isAcceptable()) {
            zb zbVar3 = this.a;
            if (zbVar3 != null && selectionKey.equals(zbVar3.b)) {
                this.a.c();
                return;
            }
            zb zbVar4 = this.b;
            if (zbVar4 == null || !selectionKey.equals(zbVar4.b)) {
                return;
            }
            this.b.c();
            this.a.e();
            return;
        }
        try {
            if (selectionKey.isAcceptable()) {
                SocketChannel socketChannelAccept = ((ServerSocketChannel) selectionKey.channel()).accept();
                Objects.toString(socketChannelAccept.socket().getInetAddress());
                zb zbVar5 = new zb(true);
                this.a = zbVar5;
                zbVar5.m = this;
                zbVar5.a = socketChannelAccept;
                socketChannelAccept.configureBlocking(false);
                this.a.b = socketChannelAccept.register(bs0.a().c, 1, this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b(zb zbVar) {
        ByteBuffer byteBuffer;
        zb zbVar2;
        boolean z = zbVar.i;
        if (z && this.b != null) {
            if (zbVar.c == null) {
                zbVar.c = ByteBuffer.allocate(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
            }
            byteBuffer = zbVar.c;
            zbVar2 = this.b;
        } else {
            if (z || this.a == null) {
                return;
            }
            if (zbVar.c == null) {
                zbVar.c = ByteBuffer.allocate(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
            }
            byteBuffer = zbVar.c;
            zbVar2 = this.a;
        }
        zbVar2.getClass();
        try {
            zbVar2.a.write(byteBuffer);
        } catch (IOException unused) {
        }
    }
}
