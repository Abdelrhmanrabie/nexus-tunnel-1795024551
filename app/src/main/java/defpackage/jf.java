package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Trace;
import android.view.MenuItem;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.emoji2.text.f;
import androidx.emoji2.text.g;
import androidx.fragment.app.q;
import androidx.lifecycle.e;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import androidx.profileinstaller.c;
import com.blacksquircle.ui.editorkit.widget.TextScroller;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import renz.javacodez.v2ray.service.V2RayVpnService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jf implements Runnable {
    public final /* synthetic */ int G0;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ jf(Object obj, int i, int i2) {
        this.G0 = i2;
        this.b = i;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        Object obj;
        int i = this.G0;
        int i2 = this.b;
        Object obj2 = this.c;
        if (i != 0) {
            if (i == 1) {
                if (i2 == 1) {
                    throw null;
                }
                if (i2 != 2) {
                    d.AnonymousClass0.m$1();
                    return;
                } else {
                    int i3 = TextScroller.$r8$clinit;
                    ((TextScroller) obj2).setState(TextScroller.State.EXITING);
                    return;
                }
            }
            if (i2 == 0) {
                pf.a((pf) obj2);
                return;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    ((f.b) obj2).c();
                    return;
                }
                if (i2 != 3) {
                    V2RayVpnService.runTun2socks$lambda$6((V2RayVpnService) obj2);
                    return;
                }
                k kVar = (k) obj2;
                k kVar2 = k.o;
                int i4 = kVar.c;
                i iVar = kVar.i;
                if (i4 == 0) {
                    kVar.d = true;
                    iVar.f(e.a.ON_PAUSE);
                }
                if (kVar.b == 0 && kVar.d) {
                    iVar.f(e.a.ON_STOP);
                    kVar.f = true;
                    return;
                }
                return;
            }
            Toolbar toolbar = (Toolbar) obj2;
            Iterator it = toolbar.mProvidedMenuItems.iterator();
            while (it.hasNext()) {
                toolbar.getMenu().removeItem(((MenuItem) it.next()).getItemId());
            }
            ArrayList arrayList = new ArrayList();
            androidx.appcompat.view.menu.f menu = toolbar.getMenu();
            for (int i5 = 0; i5 < menu.size(); i5++) {
                arrayList.add(menu.getItem(i5));
            }
            dh0 dh0Var = toolbar.mMenuHostHelper;
            androidx.appcompat.view.menu.f menu2 = toolbar.getMenu();
            l41 l41Var = new l41(toolbar.getContext());
            Iterator it2 = dh0Var.b.iterator();
            while (it2.hasNext()) {
                q.this.k(menu2, l41Var);
            }
            ArrayList arrayList2 = new ArrayList();
            androidx.appcompat.view.menu.f menu3 = toolbar.getMenu();
            for (int i6 = 0; i6 < menu3.size(); i6++) {
                arrayList2.add(menu3.getItem(i6));
            }
            arrayList2.removeAll(arrayList);
            toolbar.mProvidedMenuItems = arrayList2;
            return;
        }
        if (i2 == 0) {
            ComponentActivity.e eVar = (ComponentActivity.e) obj2;
            Runnable runnable = eVar.c;
            if (runnable != null) {
                runnable.run();
                eVar.c = null;
                return;
            }
            return;
        }
        if (i2 == 1) {
            Activity activity = (Activity) obj2;
            if (activity.isFinishing()) {
                return;
            }
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 28) {
                Class cls = i2.a;
            } else {
                Class cls2 = i2.a;
                boolean z = i7 == 26 || i7 == 27;
                Method method = i2.f;
                if ((!z || method != null) && (i2.e != null || i2.d != null)) {
                    Object obj3 = i2.c.get(activity);
                    if (obj3 != null && (obj = i2.b.get(activity)) != null) {
                        Application application = activity.getApplication();
                        i2.a aVar = new i2.a(activity);
                        application.registerActivityLifecycleCallbacks(aVar);
                        Handler handler = i2.g;
                        handler.post(new f2(aVar, obj3, 0, false));
                        try {
                            if (i7 == 26 || i7 == 27) {
                                Boolean bool = Boolean.FALSE;
                                method.invoke(obj, obj3, null, null, 0, bool, null, null, bool, bool);
                            } else {
                                activity.recreate();
                            }
                            handler.post(new f2(3, application, aVar));
                            return;
                        } catch (Throwable th) {
                            handler.post(new f2(3, application, aVar));
                            throw th;
                        }
                    }
                }
            }
            activity.recreate();
            return;
        }
        if (i2 != 2) {
            c.b((Context) obj2, new jg0(3), c.a, false);
            return;
        }
        f.b bVar = (f.b) obj2;
        synchronized (bVar.d) {
            try {
                if (bVar.h == null) {
                    return;
                }
                try {
                    xu xuVarD = bVar.d();
                    int i8 = xuVarD.e;
                    if (i8 == 2) {
                        synchronized (bVar.d) {
                        }
                    }
                    if (i8 != 0) {
                        throw new RuntimeException("fetchFonts result is not OK. (" + i8 + ")");
                    }
                    try {
                        int i9 = t71.$r8$clinit;
                        Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                        f.a aVar2 = bVar.c;
                        Context context = bVar.a;
                        aVar2.getClass();
                        Typeface typefaceB = ta1.a.b(context, new xu[]{xuVarD}, 0);
                        MappedByteBuffer mappedByteBufferE = e4.e(bVar.a, xuVarD.a);
                        if (mappedByteBufferE == null || typefaceB == null) {
                            throw new RuntimeException("Unable to open file.");
                        }
                        try {
                            Trace.beginSection("EmojiCompat.MetadataRepo.create");
                            g gVar = new g(typefaceB, ak.a(mappedByteBufferE));
                            Trace.endSection();
                            Trace.endSection();
                            synchronized (bVar.d) {
                                try {
                                    androidx.emoji2.text.c.h hVar = bVar.h;
                                    if (hVar != null) {
                                        hVar.b(gVar);
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                            bVar.b();
                        } catch (Throwable th3) {
                            int i10 = t71.$r8$clinit;
                            Trace.endSection();
                            throw th3;
                        }
                    } catch (Throwable th4) {
                        int i11 = t71.$r8$clinit;
                        Trace.endSection();
                        throw th4;
                    }
                } catch (Throwable th5) {
                    synchronized (bVar.d) {
                        try {
                            androidx.emoji2.text.c.h hVar2 = bVar.h;
                            if (hVar2 != null) {
                                hVar2.a(th5);
                            }
                            bVar.b();
                        } catch (Throwable th6) {
                            throw th6;
                        }
                    }
                }
            } catch (Throwable th7) {
                throw th7;
            }
        }
    }
}
