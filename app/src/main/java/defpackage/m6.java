package defpackage;

import android.app.Notification;
import android.app.Service;
import android.content.ClipDescription;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Choreographer;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.IconCompat;
import com.google.crypto.tink.internal.Ed25519$XYZT;
import com.google.crypto.tink.subtle.Hex;
import com.google.zxing.qrcode.detector.FinderPattern;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.SequencedCollection;
import java.util.concurrent.ConcurrentHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class m6 implements xb0$c, q20$c, w1$a, wc {
    public static volatile m6 d;
    public static m6 d$1;
    public final Object a;
    public Object b;
    public Object c;
    public static final byte[] EMPTY = new byte[0];
    public static final Object e = new Object();

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m6(int i) {
        this(new long[10], new long[10], new long[10]);
        if (i == 3) {
            return;
        }
        this.a = new gp0();
        this.b = new gp0();
        this.c = new q11[32];
    }

    public m6(Context context) {
        this.c = context.getApplicationContext();
        this.b = new HashSet();
        this.a = new HashMap();
    }

    public m6(Context context, TypedArray typedArray) {
        this.c = context;
        this.a = typedArray;
    }

    public m6(Context context, LocationManager locationManager) {
        this.b = new n81$a();
        this.c = context;
        this.a = locationManager;
    }

    public m6(Toolbar toolbar) {
        this.a = toolbar;
        this.b = toolbar.getNavigationIcon();
        s5 s5Var = toolbar.mNavButtonView;
        this.c = s5Var != null ? s5Var.getContentDescription() : null;
    }

    public m6(Ed25519$XYZT ed25519$XYZT) {
        this(3);
        fromPartialXYZT(ed25519$XYZT, this);
    }

    public m6(dh dhVar) {
        this.a = new ArrayList();
        this.b = new n8$a();
        this.c = dhVar;
    }

    public m6(g gVar, xg0 xg0Var) {
        this.c = gVar;
        this.a = xg0Var;
        this.b = new ArrayList();
    }

    public /* synthetic */ m6(Object obj, Object obj2, Object obj3) {
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    public m6(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int iIndexOf = str.indexOf(" ");
            if (iIndexOf == -1) {
                return;
            }
            this.a = str.substring(0, iIndexOf);
            String strSubstring = str.substring(iIndexOf + 1);
            int iIndexOf2 = strSubstring.indexOf(" ");
            if (iIndexOf2 == -1) {
                return;
            }
            this.b = strSubstring.substring(0, iIndexOf2);
            String strSubstring2 = strSubstring.substring(iIndexOf2 + 1);
            if (TextUtils.isEmpty(strSubstring2)) {
                return;
            }
            this.c = strSubstring2;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public m6(jr0 jr0Var, g gVar, r9 r9Var, p0 p0Var) {
        this.a = gVar;
        this.b = r9Var;
        List list = jr0Var.j;
        int iE = ye1.e(ae.y0(list));
        LinkedHashMap linkedHashMap = new LinkedHashMap(iE < 16 ? 16 : iE);
        for (Object obj : list) {
            g gVar2 = (g) this.a;
            int i = ((zq0) obj).g;
            linkedHashMap.put(dd.f(gVar2.b(i), gVar2.a(i)), obj);
        }
        this.c = linkedHashMap;
    }

    public m6(js0 js0Var) {
        ff0 ff0Var = new ff0("Type parameter upper bound erasion results");
        this.a = new v41(new yn$a(1, this));
        this.b = js0Var == null ? new js0(this) : js0Var;
        this.c = ff0Var.g(new i(20, this));
    }

    public m6(m6 m6Var) {
        this.a = Arrays.copyOf((long[]) m6Var.a, 10);
        this.b = Arrays.copyOf((long[]) m6Var.b, 10);
        this.c = Arrays.copyOf((long[]) m6Var.c, 10);
    }

    public m6(qz qzVar) {
        this.a = qzVar;
        this.b = Choreographer.getInstance();
        this.c = new dq0(this);
    }

    /* JADX WARN: Code duplicated, block: B:75:0x0225  */
    public m6(sl0 sl0Var) throws Throwable {
        String str;
        int i;
        ArrayList arrayList;
        char c;
        Icon icon;
        Bitmap bitmapCreateBitmap;
        String resPackage;
        Icon iconCreateWithResource;
        Icon iconCreateWithData;
        PorterDuff.Mode mode;
        int i2;
        new ArrayList();
        this.c = new Bundle();
        this.b = sl0Var;
        Service service = sl0Var.a;
        String str2 = sl0Var.q;
        int i3 = 26;
        Notification.Builder builder = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(service, str2) : new Notification.Builder(service);
        this.a = builder;
        Notification notification = sl0Var.s;
        Throwable th = null;
        char c2 = 2;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(sl0Var.e).setContentText(sl0Var.f).setContentInfo(null).setContentIntent(sl0Var.g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(0).setProgress(0, 0, false);
        builder.setLargeIcon((Icon) null);
        builder.setSubText(null).setUsesChronometer(false).setPriority(sl0Var.j);
        Iterator it = sl0Var.b.iterator();
        while (it.hasNext()) {
            pl0 pl0Var = (pl0) it.next();
            if (pl0Var.b == null && (i2 = pl0Var.h) != 0) {
                pl0Var.b = IconCompat.b(i2);
            }
            IconCompat iconCompat = pl0Var.b;
            if (iconCompat != null) {
                int i4 = iconCompat.a;
                switch (i4) {
                    case -1:
                        str2 = str2;
                        it = it;
                        c = c2;
                        icon = (Icon) iconCompat.b;
                        break;
                    case 0:
                    default:
                        d.AnonymousClass0.m$2("Unknown type");
                        throw th;
                    case 1:
                        c = c2;
                        bitmapCreateBitmap = (Bitmap) iconCompat.b;
                        iconCreateWithResource = Icon.createWithBitmap(bitmapCreateBitmap);
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                            iconCreateWithResource.setTintMode(mode);
                        }
                        icon = iconCreateWithResource;
                        break;
                    case 2:
                        str2 = str2;
                        it = it;
                        if (i4 == -1) {
                            Object obj = iconCompat.b;
                            if (Build.VERSION.SDK_INT >= 28) {
                                resPackage = ((Icon) obj).getResPackage();
                            } else {
                                try {
                                    resPackage = (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
                                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                                    resPackage = null;
                                }
                            }
                            c = 2;
                        } else {
                            c = 2;
                            if (i4 != 2) {
                                d.AnonymousClass0.m$3("called getResPackage() on ", iconCompat);
                                throw null;
                            }
                            String str3 = iconCompat.j;
                            resPackage = (str3 == null || TextUtils.isEmpty(str3)) ? iconCompat.b.split(":", -1)[0] : iconCompat.j;
                        }
                        iconCreateWithResource = Icon.createWithResource(resPackage, iconCompat.e);
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                            iconCreateWithResource.setTintMode(mode);
                        }
                        icon = iconCreateWithResource;
                        break;
                    case 3:
                        iconCreateWithData = Icon.createWithData((byte[]) iconCompat.b, iconCompat.e, 0);
                        iconCreateWithResource = iconCreateWithData;
                        c = 2;
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                            iconCreateWithResource.setTintMode(mode);
                        }
                        icon = iconCreateWithResource;
                        break;
                    case 4:
                        iconCreateWithData = Icon.createWithContentUri(iconCompat.b);
                        iconCreateWithResource = iconCreateWithData;
                        c = 2;
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                            iconCreateWithResource.setTintMode(mode);
                        }
                        icon = iconCreateWithResource;
                        break;
                    case 5:
                        int i5 = Build.VERSION.SDK_INT;
                        Bitmap bitmap = (Bitmap) iconCompat.b;
                        if (i5 >= i3) {
                            iconCreateWithResource = Icon.createWithAdaptiveBitmap(bitmap);
                            str2 = str2;
                            it = it;
                            c = c2;
                            mode = iconCompat.h;
                            if (mode != IconCompat.k) {
                                iconCreateWithResource.setTintMode(mode);
                            }
                            icon = iconCreateWithResource;
                        } else {
                            int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
                            bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(bitmapCreateBitmap);
                            Paint paint = new Paint(3);
                            float f = iMin * 0.5f;
                            paint.setColor(-16777216);
                            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
                            Matrix matrix = new Matrix();
                            matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
                            bitmapShader.setLocalMatrix(matrix);
                            paint.setShader(bitmapShader);
                            canvas.drawCircle(f, f, f * 0.9166667f, paint);
                            canvas.setBitmap(null);
                            c = 2;
                            iconCreateWithResource = Icon.createWithBitmap(bitmapCreateBitmap);
                            mode = iconCompat.h;
                            if (mode != IconCompat.k) {
                                iconCreateWithResource.setTintMode(mode);
                            }
                            icon = iconCreateWithResource;
                        }
                        break;
                    case 6:
                        if (Build.VERSION.SDK_INT < 30) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.d());
                        }
                        iconCreateWithResource = Icon.createWithAdaptiveBitmapContentUri(iconCompat.d());
                        str2 = str2;
                        it = it;
                        c = c2;
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                            iconCreateWithResource.setTintMode(mode);
                        }
                        icon = iconCreateWithResource;
                        break;
                        break;
                }
            } else {
                str2 = str2;
                it = it;
                c = c2;
                icon = null;
            }
            Notification.Action.Builder builder2 = new Notification.Action.Builder(icon, pl0Var.i, pl0Var.j);
            Bundle bundle = pl0Var.a;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            boolean z = pl0Var.d;
            bundle2.putBoolean("android.support.allowGeneratedReplies", z);
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 24) {
                builder2.setAllowGeneratedReplies(z);
            }
            bundle2.putInt("android.support.action.semanticAction", 0);
            if (i6 >= 28) {
                builder2.setSemanticAction(0);
            }
            if (i6 >= 29) {
                builder2.setContextual(false);
            }
            if (i6 >= 31) {
                builder2.setAuthenticationRequired(false);
            }
            bundle2.putBoolean("android.support.action.showsUserInterface", pl0Var.e);
            builder2.addExtras(bundle2);
            ((Notification.Builder) this.a).addAction(builder2.build());
            c2 = c;
            str2 = str2;
            it = it;
            i3 = 26;
            th = null;
        }
        String str4 = str2;
        Bundle bundle3 = sl0Var.n;
        if (bundle3 != null) {
            ((Bundle) this.c).putAll(bundle3);
        }
        int i7 = Build.VERSION.SDK_INT;
        ((Notification.Builder) this.a).setShowWhen(sl0Var.k);
        ((Notification.Builder) this.a).setLocalOnly(false);
        ((Notification.Builder) this.a).setGroup(null);
        ((Notification.Builder) this.a).setSortKey(null);
        ((Notification.Builder) this.a).setGroupSummary(false);
        ((Notification.Builder) this.a).setCategory(null);
        ((Notification.Builder) this.a).setColor(0);
        ((Notification.Builder) this.a).setVisibility(0);
        ((Notification.Builder) this.a).setPublicVersion(null);
        ((Notification.Builder) this.a).setSound(notification.sound, notification.audioAttributes);
        ArrayList arrayList2 = sl0Var.c;
        ArrayList arrayList3 = sl0Var.t;
        if (i7 < 28) {
            if (arrayList2 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList2.size());
                Iterator it2 = arrayList2.iterator();
                if (it2.hasNext()) {
                    throw fb$1.m(it2);
                }
            }
            if (arrayList != null) {
                if (arrayList3 != null) {
                    g7 g7Var = new g7(arrayList3.size() + arrayList.size());
                    g7Var.addAll(arrayList);
                    g7Var.addAll(arrayList3);
                    arrayList = new ArrayList(g7Var);
                }
                arrayList3 = arrayList;
            }
        }
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                ((Notification.Builder) this.a).addPerson((String) it3.next());
            }
        }
        ArrayList arrayList4 = sl0Var.d;
        if (arrayList4.size() > 0) {
            if (sl0Var.n == null) {
                sl0Var.n = new Bundle();
            }
            Bundle bundle4 = sl0Var.n.getBundle("android.car.EXTENSIONS");
            bundle4 = bundle4 == null ? new Bundle() : bundle4;
            Bundle bundle5 = new Bundle(bundle4);
            Bundle bundle6 = new Bundle();
            for (int i8 = 0; i8 < arrayList4.size(); i8++) {
                String string = Integer.toString(i8);
                pl0 pl0Var2 = (pl0) arrayList4.get(i8);
                Bundle bundle7 = new Bundle();
                if (pl0Var2.b == null && (i = pl0Var2.h) != 0) {
                    pl0Var2.b = IconCompat.b(i);
                }
                IconCompat iconCompat2 = pl0Var2.b;
                bundle7.putInt("icon", iconCompat2 != null ? iconCompat2.c() : 0);
                bundle7.putCharSequence("title", pl0Var2.i);
                bundle7.putParcelable("actionIntent", pl0Var2.j);
                Bundle bundle8 = pl0Var2.a;
                Bundle bundle9 = bundle8 != null ? new Bundle(bundle8) : new Bundle();
                bundle9.putBoolean("android.support.allowGeneratedReplies", pl0Var2.d);
                bundle7.putBundle("extras", bundle9);
                bundle7.putParcelableArray("remoteInputs", null);
                bundle7.putBoolean("showsUserInterface", pl0Var2.e);
                bundle7.putInt("semanticAction", 0);
                bundle6.putBundle(string, bundle7);
            }
            bundle4.putBundle("invisible_actions", bundle6);
            bundle5.putBundle("invisible_actions", bundle6);
            if (sl0Var.n == null) {
                sl0Var.n = new Bundle();
            }
            sl0Var.n.putBundle("android.car.EXTENSIONS", bundle4);
            ((Bundle) this.c).putBundle("android.car.EXTENSIONS", bundle5);
        }
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 24) {
            ((Notification.Builder) this.a).setExtras(sl0Var.n);
            str = null;
            ((Notification.Builder) this.a).setRemoteInputHistory(null);
        } else {
            str = null;
        }
        if (i9 >= 26) {
            ((Notification.Builder) this.a).setBadgeIconType(0);
            ((Notification.Builder) this.a).setSettingsText(str);
            ((Notification.Builder) this.a).setShortcutId(str);
            ((Notification.Builder) this.a).setTimeoutAfter(0L);
            ((Notification.Builder) this.a).setGroupAlertBehavior(0);
            if (!TextUtils.isEmpty(str4)) {
                ((Notification.Builder) this.a).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i9 >= 28) {
            Iterator it4 = arrayList2.iterator();
            if (it4.hasNext()) {
                throw fb$1.m(it4);
            }
        }
        if (i9 >= 29) {
            ((Notification.Builder) this.a).setAllowSystemGeneratedContextualActions(sl0Var.r);
            ((Notification.Builder) this.a).setBubbleMetadata(null);
        }
    }

    public m6(tn tnVar, ku0 ku0Var) {
        this.a = tnVar;
        this.b = ku0Var;
        this.c = new ConcurrentHashMap();
    }

    public m6(xt.c cVar) {
        this.a = cVar;
        this.c = EMPTY;
        this.b = new int[32];
    }

    public m6(FinderPattern[] finderPatternArr) {
        this.a = finderPatternArr[0];
        this.b = finderPatternArr[1];
        this.c = finderPatternArr[2];
    }

    public static m6 c(Context context) {
        if (d == null) {
            synchronized (e) {
                try {
                    if (d == null) {
                        d = new m6(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public static void fromPartialXYZT(Ed25519$XYZT ed25519$XYZT, m6 m6Var) {
        long[] jArr = (long[]) m6Var.a;
        m6 m6Var2 = ed25519$XYZT.xyz;
        long[] jArr2 = (long[]) m6Var2.a;
        long[] jArr3 = ed25519$XYZT.t;
        Hex.mult(jArr, jArr2, jArr3);
        long[] jArr4 = (long[]) m6Var.b;
        long[] jArr5 = (long[]) m6Var2.b;
        long[] jArr6 = (long[]) m6Var2.c;
        Hex.mult(jArr4, jArr5, jArr6);
        Hex.mult((long[]) m6Var.c, jArr6, jArr3);
    }

    public static m6 m(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new m6(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    @Override // defpackage.q20$c, defpackage.w1$a
    public Context a() {
        return ((Toolbar) this.a).getContext();
    }

    public fc0 a(v91 v91Var, boolean z, n60 n60Var) {
        return (fc0) ((ff0.c) this.c).invoke(new z91$a(v91Var, z, n60Var));
    }

    @Override // defpackage.q20$c, defpackage.w1$a
    public Object a() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01db  */
    /* JADX WARN: Code duplicated, block: B:106:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:107:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:12:0x003a  */
    /* JADX WARN: Code duplicated, block: B:144:0x024c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:145:0x024e  */
    /* JADX WARN: Code duplicated, block: B:146:0x025d  */
    /* JADX WARN: Code duplicated, block: B:148:0x0261  */
    /* JADX WARN: Code duplicated, block: B:149:0x0264  */
    /* JADX WARN: Code duplicated, block: B:153:0x027a  */
    /* JADX WARN: Code duplicated, block: B:155:0x0282 A[LOOP:3: B:151:0x0274->B:155:0x0282, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:162:0x029e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x02a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:83:0x017b  */
    /* JADX WARN: Code duplicated, block: B:85:0x0188  */
    /* JADX WARN: Code duplicated, block: B:86:0x018a  */
    /* JADX WARN: Code duplicated, block: B:89:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:94:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:95:0x01cd  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [ja] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r18v0, types: [m6] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v2, types: [ja, la, ok] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [t40] */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r7v10, types: [ja] */
    public ArrayList a(v8 v8Var, SequencedCollection sequencedCollection) {
        Iterator it;
        s4 annotations;
        int i;
        d01$a d01_aD;
        boolean z;
        ArrayList arrayList;
        d01$a d01_a;
        op0 op0Var;
        ?? r2;
        nq0 nq0Var;
        j4 j4Var;
        ?? r7;
        j91 j91Var;
        d01$a d01_aD2;
        boolean z2;
        jo0 jo0Var;
        fc0 fc0Var;
        ArrayList arrayList2;
        int i2;
        int i3;
        v8 v8VarC;
        op0 op0Var2;
        j91 j91Var2;
        pq0 pq0Var;
        ArrayList arrayList3 = new ArrayList(ae.y0(sequencedCollection));
        Iterator it2 = sequencedCollection.iterator();
        while (it2.hasNext()) {
            ?? A0 = (la) it2.next();
            if (A0 instanceof t40) {
                t40 t40Var = (t40) A0;
                if (t40Var.getKind() == la.a.c && t40Var.a().d().size() == 1) {
                    it = it2;
                } else {
                    od odVarH = e.H((ok) A0);
                    int i4 = 0;
                    if (odVarH != null) {
                        xc0 xc0Var = odVarH instanceof xc0 ? (xc0) odVarH : null;
                        List list = xc0Var == null ? null : (List) xc0Var.r.getValue();
                        if (list == null || list.isEmpty()) {
                            annotations = ((j0) A0).getAnnotations();
                        } else {
                            ArrayList arrayList4 = new ArrayList(ae.y0(list));
                            Iterator it3 = list.iterator();
                            while (it3.hasNext()) {
                                arrayList4.add(new vc0(v8Var, (ct0) it3.next(), true));
                            }
                            ArrayList arrayListV0 = he.V0(((j0) A0).getAnnotations(), arrayList4);
                            annotations = arrayListV0.isEmpty() ? e4.f47a : new t4(i4, arrayListV0);
                        }
                    } else {
                        annotations = ((j0) A0).getAnnotations();
                    }
                    v8 v8VarC2 = uh.c(v8Var, annotations);
                    ?? r15 = (!(A0 instanceof y50) || (pq0Var = ((y50) A0).B) == null || pq0Var.g) ? A0 : pq0Var;
                    sc0 sc0VarQ = t40Var.Q();
                    j4 j4Var2 = j4.VALUE_PARAMETER;
                    if (sc0VarQ != null) {
                        ox oxVar = (ox) (!(r15 instanceof ox) ? 0 : r15);
                        wc1 wc1Var = oxVar == null ? null : (wc1) oxVar.m0(q50.L);
                        i = 3;
                        d01_aD = d01$b.d(d(t40Var, wc1Var, false, wc1Var == null ? v8VarC2 : uh.c(v8VarC2, wc1Var.getAnnotations()), j4Var2, ba.b$14), null, 3);
                    } else {
                        i = 3;
                        d01_aD = null;
                    }
                    q50 q50Var = A0 instanceof q50 ? (q50) A0 : null;
                    op0 op0Var3 = q50Var == null ? null : (op0) np0.d.get(e.q1((ai0) q50Var.b(), e.o(q50Var, i)));
                    if (op0Var3 != null) {
                        op0Var3.b.size();
                        t40Var.f().size();
                    }
                    p60 p60Var = (p60) this.b;
                    cv cvVar = u50.a;
                    p60Var.getClass();
                    if (p60.a.d.invoke(cvVar) == gv0.f) {
                        if ((A0 instanceof ox) && e4.a(A0.m0(q50.M), Boolean.TRUE)) {
                            z = true;
                        }
                        List<wc1> listF = r15.f();
                        arrayList = new ArrayList(ae.y0(listF));
                        for (wc1 wc1Var2 : listF) {
                            i iVar = new i(i, wc1Var2);
                            if (wc1Var2 == null) {
                                v8VarC = v8VarC2;
                            } else {
                                v8VarC = uh.c(v8VarC2, wc1Var2.getAnnotations());
                            }
                            Iterator it4 = it2;
                            boolean z3 = z;
                            v8 v8Var2 = v8VarC;
                            op0Var2 = op0Var3;
                            d01$a d01_a2 = d01_aD;
                            d01$b d01_bD = d(t40Var, wc1Var2, false, v8Var2, j4Var2, iVar);
                            if (op0Var2 == null) {
                                j91Var2 = null;
                            } else {
                                j91Var2 = (j91) he.N0(op0Var2.b, wc1Var2.i);
                            }
                            arrayList.add(d01_bD.c(j91Var2, z3));
                            d01_aD = d01_a2;
                            z = z3;
                            op0Var3 = op0Var2;
                            it2 = it4;
                            i = 3;
                        }
                        it = it2;
                        d01_a = d01_aD;
                        op0Var = op0Var3;
                        if (A0 instanceof nq0) {
                            r2 = A0;
                        } else {
                            r2 = 0;
                        }
                        nq0Var = (nq0) r2;
                        if (nq0Var == null && nq0Var.B == null) {
                            j4Var = j4.FIELD;
                        } else {
                            j4Var = j4.METHOD_RETURN_TYPE;
                        }
                        r7 = r15;
                        d01$b d01_bD2 = d(t40Var, r7, true, v8VarC2, j4Var, ba.b$16);
                        if (op0Var == null) {
                            j91Var = null;
                        } else {
                            j91Var = op0Var.a;
                        }
                        d01_aD2 = d01$b.d(d01_bD2, j91Var, 2);
                        if ((d01_a != null || !d01_a.c) && !d01_aD2.c) {
                            if (!arrayList.isEmpty()) {
                                Iterator it5 = arrayList.iterator();
                                while (true) {
                                    if (it5.hasNext()) {
                                        if (((d01$a) it5.next()).c) {
                                        }
                                    }
                                }
                            }
                            z2 = false;
                        }
                        if ((d01_a == null && d01_a.b) || d01_aD2.b) {
                            if (z2) {
                                jo0Var = new jo0(b2.f10a, new e(22));
                            } else {
                                jo0Var = null;
                            }
                            if (d01_a == null) {
                                fc0Var = null;
                            } else {
                                fc0Var = d01_a.a;
                            }
                            arrayList2 = new ArrayList(ae.y0(arrayList));
                            i2 = 0;
                            for (Object obj : arrayList) {
                                i3 = i2 + 1;
                                if (i2 < 0) {
                                    e.q0();
                                    throw null;
                                }
                                arrayList2.add(new tc1(((d01$a) obj).a, ((wc1) r7.f().get(i2)).B0()));
                                i2 = i3;
                            }
                            A0 = t40Var.a0(fc0Var, arrayList2, d01_aD2.a, jo0Var);
                        } else if (!arrayList.isEmpty()) {
                            Iterator it6 = arrayList.iterator();
                            while (true) {
                                if (it6.hasNext()) {
                                    if (((d01$a) it6.next()).b) {
                                    }
                                } else if (z2) {
                                    continue;
                                }
                                if (z2) {
                                    jo0Var = new jo0(b2.f10a, new e(22));
                                } else {
                                    jo0Var = null;
                                }
                                if (d01_a == null) {
                                    fc0Var = null;
                                } else {
                                    fc0Var = d01_a.a;
                                }
                                arrayList2 = new ArrayList(ae.y0(arrayList));
                                i2 = 0;
                                while (r4.hasNext()) {
                                    i3 = i2 + 1;
                                    if (i2 < 0) {
                                        e.q0();
                                        throw null;
                                    }
                                    arrayList2.add(new tc1(((d01$a) obj).a, ((wc1) r7.f().get(i2)).B0()));
                                    i2 = i3;
                                }
                                A0 = t40Var.a0(fc0Var, arrayList2, d01_aD2.a, jo0Var);
                            }
                        } else if (z2) {
                            continue;
                        } else {
                            if (z2) {
                                jo0Var = new jo0(b2.f10a, new e(22));
                            } else {
                                jo0Var = null;
                            }
                            if (d01_a == null) {
                                fc0Var = null;
                            } else {
                                fc0Var = d01_a.a;
                            }
                            arrayList2 = new ArrayList(ae.y0(arrayList));
                            i2 = 0;
                            while (r4.hasNext()) {
                                i3 = i2 + 1;
                                if (i2 < 0) {
                                    e.q0();
                                    throw null;
                                }
                                arrayList2.add(new tc1(((d01$a) obj).a, ((wc1) r7.f().get(i2)).B0()));
                                i2 = i3;
                            }
                            A0 = t40Var.a0(fc0Var, arrayList2, d01_aD2.a, jo0Var);
                        }
                    } else {
                        ((c60) v8VarC2.a).t.getClass();
                    }
                    z = false;
                    List<wc1> listF2 = r15.f();
                    arrayList = new ArrayList(ae.y0(listF2));
                    while (r12.hasNext()) {
                        i iVar2 = new i(i, wc1Var2);
                        if (wc1Var2 == null) {
                            v8VarC = v8VarC2;
                        } else {
                            v8VarC = uh.c(v8VarC2, wc1Var2.getAnnotations());
                        }
                        Iterator it7 = it2;
                        boolean z4 = z;
                        v8 v8Var3 = v8VarC;
                        op0Var2 = op0Var3;
                        d01$a d01_a3 = d01_aD;
                        d01$b d01_bD3 = d(t40Var, wc1Var2, false, v8Var3, j4Var2, iVar2);
                        if (op0Var2 == null) {
                            j91Var2 = null;
                        } else {
                            j91Var2 = (j91) he.N0(op0Var2.b, wc1Var2.i);
                        }
                        arrayList.add(d01_bD3.c(j91Var2, z4));
                        d01_aD = d01_a3;
                        z = z4;
                        op0Var3 = op0Var2;
                        it2 = it7;
                        i = 3;
                    }
                    it = it2;
                    d01_a = d01_aD;
                    op0Var = op0Var3;
                    if (A0 instanceof nq0) {
                        r2 = 0;
                    } else {
                        r2 = A0;
                    }
                    nq0Var = (nq0) r2;
                    if (nq0Var == null) {
                        j4Var = j4.METHOD_RETURN_TYPE;
                    } else {
                        j4Var = j4.FIELD;
                    }
                    r7 = r15;
                    d01$b d01_bD4 = d(t40Var, r7, true, v8VarC2, j4Var, ba.b$16);
                    if (op0Var == null) {
                        j91Var = null;
                    } else {
                        j91Var = op0Var.a;
                    }
                    d01_aD2 = d01$b.d(d01_bD4, j91Var, 2);
                    z2 = d01_a != null ? true : true;
                    if (d01_a == null) {
                        if (z2) {
                            jo0Var = new jo0(b2.f10a, new e(22));
                        } else {
                            jo0Var = null;
                        }
                        if (d01_a == null) {
                            fc0Var = null;
                        } else {
                            fc0Var = d01_a.a;
                        }
                        arrayList2 = new ArrayList(ae.y0(arrayList));
                        i2 = 0;
                        while (r4.hasNext()) {
                            i3 = i2 + 1;
                            if (i2 < 0) {
                                e.q0();
                                throw null;
                            }
                            arrayList2.add(new tc1(((d01$a) obj).a, ((wc1) r7.f().get(i2)).B0()));
                            i2 = i3;
                        }
                        A0 = t40Var.a0(fc0Var, arrayList2, d01_aD2.a, jo0Var);
                    } else {
                        if (z2) {
                            jo0Var = new jo0(b2.f10a, new e(22));
                        } else {
                            jo0Var = null;
                        }
                        if (d01_a == null) {
                            fc0Var = null;
                        } else {
                            fc0Var = d01_a.a;
                        }
                        arrayList2 = new ArrayList(ae.y0(arrayList));
                        i2 = 0;
                        while (r4.hasNext()) {
                            i3 = i2 + 1;
                            if (i2 < 0) {
                                e.q0();
                                throw null;
                            }
                            arrayList2.add(new tc1(((d01$a) obj).a, ((wc1) r7.f().get(i2)).B0()));
                            i2 = i3;
                        }
                        A0 = t40Var.a0(fc0Var, arrayList2, d01_aD2.a, jo0Var);
                    }
                }
            } else {
                it = it2;
            }
            arrayList3.add(A0);
            it2 = it;
        }
        return arrayList3;
    }

    @Override // defpackage.wc
    public vc a(dd ddVar) {
        zq0 zq0Var = (zq0) ((LinkedHashMap) this.c).get(ddVar);
        if (zq0Var == null) {
            return null;
        }
        return new vc((g) this.a, zq0Var, (r9) this.b, t11.a);
    }

    @Override // defpackage.xb0$c
    /* JADX INFO: renamed from: a */
    public void mo4a() {
        ArrayList arrayList = (ArrayList) this.b;
        if (arrayList.isEmpty()) {
            return;
        }
        ((HashMap) ((g) this.c).b).put((xg0) this.a, arrayList);
    }

    public void a(Bundle bundle) {
        HashSet hashSet;
        String string = ((Context) this.c).getString(R.string.af);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    hashSet = (HashSet) this.b;
                    if (!zHasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (e20.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b(hashSet2, (Class) it2.next());
                }
            } catch (ClassNotFoundException e2) {
                throw new we(e2);
            }
        }
    }

    public boolean a(int i, ch chVar, n8$b n8_b) {
        int[] iArr = chVar.V;
        int i2 = iArr[0];
        n8$a n8_a = (n8$a) this.b;
        n8_a.a = i2;
        n8_a.b = iArr[1];
        n8_a.c = chVar.n();
        n8_a.d = chVar.i();
        n8_a.i = false;
        n8_a.j = i;
        boolean z = n8_a.a == 3;
        boolean z2 = n8_a.b == 3;
        boolean z3 = z && chVar.Z > 0.0f;
        boolean z4 = z2 && chVar.Z > 0.0f;
        int[] iArr2 = chVar.u;
        if (z3 && iArr2[0] == 4) {
            n8_a.a = 1;
        }
        if (z4 && iArr2[1] == 4) {
            n8_a.b = 1;
        }
        ((ConstraintLayout.b) n8_b).b(chVar, n8_a);
        chVar.J(n8_a.e);
        chVar.G(n8_a.f);
        chVar.F = n8_a.h;
        int i3 = n8_a.g;
        chVar.d0 = i3;
        chVar.F = i3 > 0;
        n8_a.j = 0;
        return n8_a.i;
    }

    public ColorStateList b(int i) {
        int resourceId;
        ColorStateList colorStateList;
        TypedArray typedArray = (TypedArray) this.a;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateList = b2.getColorStateList((Context) this.c, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateList;
    }

    @Override // defpackage.q20$c
    public Uri b() {
        return (Uri) this.a;
    }

    public bm0 b(g4 g4Var, boolean z) {
        bm0 bm0VarC;
        bm0 bm0VarC2 = c(g4Var, z);
        if (bm0VarC2 != null) {
            return bm0VarC2;
        }
        l4 l4Var = (l4) this.a;
        g4 g4VarD = l4Var.d(g4Var);
        if (g4VarD == null) {
            return null;
        }
        gv0 gv0VarC = l4Var.c(g4Var);
        if (gv0VarC == null) {
            gv0VarC = l4Var.a.a.a;
        }
        gv0VarC.getClass();
        if (gv0VarC == gv0.c || (bm0VarC = c(g4VarD, z)) == null) {
            return null;
        }
        return bm0.a(bm0VarC, gv0VarC == gv0.d, 1);
    }

    public Object b(HashSet hashSet, Class cls) {
        Object objA;
        if (ak.a()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        HashMap map = (HashMap) this.a;
        if (map.containsKey(cls)) {
            objA = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                e20 e20Var = (e20) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listDependencies = e20Var.dependencies();
                if (!listDependencies.isEmpty()) {
                    for (Class cls2 : listDependencies) {
                        if (!map.containsKey(cls2)) {
                            b(hashSet, cls2);
                        }
                    }
                }
                objA = e20Var.a((Context) this.c);
                hashSet.remove(cls);
                map.put(cls, objA);
            } catch (Throwable th2) {
                throw new we(th2);
            }
        }
        Trace.endSection();
        return objA;
    }

    @Override // defpackage.xb0$c
    public xb0$a b(dd ddVar, at0 at0Var) {
        v8 v8Var = (v8) ((g) this.c).a;
        ArrayList arrayList = (ArrayList) this.b;
        if (e21.a.contains(ddVar)) {
            return null;
        }
        return new hg(v8Var, e4.c((ji0) v8Var.c, ddVar, (oo) v8Var.d), ddVar, arrayList, at0Var);
    }

    public void b(dh dhVar, int i, int i2, int i3) {
        int i4 = dhVar.e0;
        int i5 = dhVar.f0;
        dhVar.e0 = 0;
        dhVar.f0 = 0;
        dhVar.J(i2);
        dhVar.G(i3);
        if (i4 < 0) {
            i4 = 0;
        }
        dhVar.e0 = i4;
        if (i5 < 0) {
            i5 = 0;
        }
        dhVar.f0 = i5;
        dh dhVar2 = (dh) this.c;
        dhVar2.v0 = i;
        dhVar2.M();
    }

    @Override // defpackage.w1$a
    public void b(hp hpVar, int i) {
        ((Toolbar) this.a).setNavigationIcon(hpVar);
        mo16e(i);
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00e7  */
    public bm0 c(g4 g4Var, boolean z) {
        bm0 bm0Var;
        cv cvVarE = g4Var.e();
        if (cvVarE != null) {
            boolean z2 = true;
            boolean z3 = (g4Var instanceof vc0) && (((vc0) g4Var).h || z);
            ((p60) this.b).getClass();
            gv0 gv0Var = (gv0) p60.a.d.invoke(cvVarE);
            gv0Var.getClass();
            if (gv0Var == gv0.c) {
                bm0Var = null;
            } else {
                if (gv0Var != gv0.d && !z3) {
                    z2 = false;
                }
                boolean zContains = s70.d.contains(cvVarE);
                am0 am0Var = am0.c;
                if (zContains) {
                    bm0Var = new bm0(am0Var, z2);
                } else {
                    boolean zContains2 = s70.g.contains(cvVarE);
                    am0 am0Var2 = am0.d;
                    if (zContains2) {
                        bm0Var = new bm0(am0Var2, z2);
                    } else if (cvVarE.equals(s70.a)) {
                        bm0Var = new bm0(am0Var, z2);
                    } else {
                        boolean zEquals = cvVarE.equals(s70.b);
                        am0 am0Var3 = am0.b;
                        if (zEquals) {
                            bm0Var = new bm0(am0Var3, z2);
                        } else if (cvVarE.equals(s70.e)) {
                            int i = ym.$r8$clinit;
                            qg qgVar = (qg) he.L0(g4Var.h().values());
                            kr krVar = qgVar instanceof kr ? (kr) qgVar : null;
                            if (krVar != null) {
                                switch (krVar.c.b()) {
                                    case "MAYBE":
                                    case "NEVER":
                                        bm0Var = new bm0(am0Var, z2);
                                        break;
                                    case "UNKNOWN":
                                        bm0Var = new bm0(am0Var3, z2);
                                        break;
                                    case "ALWAYS":
                                        bm0Var = new bm0(am0Var2, z2);
                                        break;
                                    default:
                                        bm0Var = null;
                                        break;
                                }
                            } else {
                                bm0Var = new bm0(am0Var2, z2);
                            }
                        } else if (cvVarE.equals(s70.h)) {
                            bm0Var = new bm0(am0Var, z2);
                        } else if (cvVarE.equals(s70.i) || cvVarE.equals(s70.k)) {
                            bm0Var = new bm0(am0Var2, z2);
                        } else {
                            bm0Var = cvVarE.equals(s70.j) ? new bm0(am0Var, z2) : null;
                        }
                    }
                }
            }
            if (bm0Var != null) {
                if (!bm0Var.b && (g4Var instanceof kp0)) {
                }
                return bm0Var;
            }
        }
        return null;
    }

    @Override // defpackage.q20$c
    /* JADX INFO: renamed from: c */
    public void mo20c() {
    }

    public void c(dh dhVar) {
        ArrayList arrayList = (ArrayList) this.a;
        arrayList.clear();
        int size = dhVar.s0.size();
        for (int i = 0; i < size; i++) {
            ch chVar = (ch) dhVar.s0.get(i);
            int[] iArr = chVar.V;
            if (iArr[0] == 3 || iArr[1] == 3) {
                arrayList.add(chVar);
            }
        }
        dhVar.u0.b = true;
    }

    @Override // defpackage.w1$a
    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean mo14c() {
        return true;
    }

    @Override // defpackage.w1$a
    public Drawable d() {
        return (Drawable) this.b;
    }

    @Override // defpackage.q20$c
    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public Uri mo15d() {
        return (Uri) this.c;
    }

    public d01$b d(t40 t40Var, ja jaVar, boolean z, v8 v8Var, j4 j4Var, nw nwVar) {
        fc0 fc0Var = (fc0) nwVar.invoke(t40Var);
        Collection collectionD = t40Var.d();
        ArrayList arrayList = new ArrayList(ae.y0(collectionD));
        Iterator it = collectionD.iterator();
        while (it.hasNext()) {
            arrayList.add((fc0) nwVar.invoke((la) it.next()));
        }
        return new d01$b(this, jaVar, fc0Var, arrayList, z, uh.c(v8Var, ((fc0) nwVar.invoke(t40Var)).getAnnotations()), j4Var, 192);
    }

    public Drawable e(int i) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.a;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) ? typedArray.getDrawable(i) : e.s((Context) this.c, resourceId);
    }

    @Override // defpackage.w1$a
    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public void mo16e(int i) {
        Toolbar toolbar = (Toolbar) this.a;
        if (i == 0) {
            toolbar.setNavigationContentDescription((CharSequence) this.c);
        } else {
            toolbar.setNavigationContentDescription(i != 0 ? toolbar.getContext().getText(i) : null);
        }
    }

    public Drawable f(int i) {
        int resourceId;
        Drawable drawableG;
        if (!((TypedArray) this.a).hasValue(i) || (resourceId = ((TypedArray) this.a).getResourceId(i, 0)) == 0) {
            return null;
        }
        o5 o5VarA = o5.a();
        Context context = (Context) this.c;
        synchronized (o5VarA) {
            drawableG = o5VarA.a.g(context, resourceId, true);
        }
        return drawableG;
    }

    public Typeface g(int i, int i2, g6.a aVar) {
        int resourceId = ((TypedArray) this.a).getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.b) == null) {
            this.b = new TypedValue();
        }
        TypedValue typedValue = (TypedValue) this.b;
        ThreadLocal threadLocal = sv0.a;
        Context context = (Context) this.c;
        if (context.isRestricted()) {
            return null;
        }
        return sv0.c(context, resourceId, typedValue, i2, aVar, true, false);
    }

    @Override // defpackage.q20$c
    public ClipDescription getDescription() {
        return (ClipDescription) this.b;
    }

    public void n() {
        ((TypedArray) this.a).recycle();
    }

    public byte[] toBytes() {
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        long[] jArr3 = new long[10];
        Hex.inverse(jArr, (long[]) this.c);
        Hex.mult(jArr2, (long[]) this.a, jArr);
        Hex.mult(jArr3, (long[]) this.b, jArr);
        byte[] bArrContract = Hex.contract(jArr3);
        bArrContract[31] = (byte) (((Hex.contract(jArr2)[0] & 1) << 7) ^ bArrContract[31]);
        return bArrContract;
    }
}
