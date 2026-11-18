package defpackage;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.trilead.ssh2.packets.TypesWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import net.lingala.zip4j.util.InternalZipConstants;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ak {
    public static long a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f2a = false;
    public static Method b = null;
    public static Method b$1 = null;
    public static boolean c = false;
    public static Field d;
    public final /* synthetic */ int G0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f3a = {R.attr.selectableItemBackground, org.hamotunnelplus.xyz.R.style.zq};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f5b = {R.attr.summaryOn, R.attr.summaryOff, R.attr.disableDependentsState, org.hamotunnelplus.xyz.R.style.ja, org.hamotunnelplus.xyz.R.style.a25, org.hamotunnelplus.xyz.R.style.a26};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int[] f7c = {R.attr.dialogTitle, R.attr.dialogMessage, R.attr.dialogIcon, R.attr.positiveButtonText, R.attr.negativeButtonText, R.attr.dialogLayout, org.hamotunnelplus.xyz.R.style.j4, org.hamotunnelplus.xyz.R.style.j5, org.hamotunnelplus.xyz.R.style.j6, org.hamotunnelplus.xyz.R.style.j_, org.hamotunnelplus.xyz.R.style.vf, org.hamotunnelplus.xyz.R.style.wz};

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final int[] f8d = {org.hamotunnelplus.xyz.R.style.a73};
    public static final int[] e = {R.attr.entries, R.attr.entryValues, org.hamotunnelplus.xyz.R.style.kt, org.hamotunnelplus.xyz.R.style.ku, org.hamotunnelplus.xyz.R.style.a73};
    public static final int[] f = {R.attr.entries, R.attr.entryValues, org.hamotunnelplus.xyz.R.style.kt, org.hamotunnelplus.xyz.R.style.ku};
    public static final int[] g = {R.attr.icon, R.attr.persistent, R.attr.enabled, R.attr.layout, R.attr.title, R.attr.selectable, R.attr.key, R.attr.summary, R.attr.order, R.attr.widgetLayout, R.attr.dependency, R.attr.defaultValue, R.attr.shouldDisableView, R.attr.fragment, R.attr.singleLineTitle, R.attr.iconSpaceReserved, org.hamotunnelplus.xyz.R.style.at, org.hamotunnelplus.xyz.R.style.av, org.hamotunnelplus.xyz.R.style.ix, org.hamotunnelplus.xyz.R.style.j0, org.hamotunnelplus.xyz.R.style.kg, org.hamotunnelplus.xyz.R.style.ki, org.hamotunnelplus.xyz.R.style.n7, org.hamotunnelplus.xyz.R.style.ny, org.hamotunnelplus.xyz.R.style.o4, org.hamotunnelplus.xyz.R.style.ow, org.hamotunnelplus.xyz.R.style.pq, org.hamotunnelplus.xyz.R.style.q2, org.hamotunnelplus.xyz.R.style.vt, org.hamotunnelplus.xyz.R.style.wj, org.hamotunnelplus.xyz.R.style.zp, org.hamotunnelplus.xyz.R.style.a02, org.hamotunnelplus.xyz.R.style.a0g, org.hamotunnelplus.xyz.R.style.a24, org.hamotunnelplus.xyz.R.style.a5q, org.hamotunnelplus.xyz.R.style.a7k};
    public static final int[] h = {R.attr.layout, R.attr.divider, R.attr.dividerHeight, org.hamotunnelplus.xyz.R.style.au};
    public static final int[] i = {R.attr.orderingFromXml, org.hamotunnelplus.xyz.R.style.or, org.hamotunnelplus.xyz.R.style.vu};
    public static final int[] j = {R.attr.maxWidth, R.attr.maxHeight, org.hamotunnelplus.xyz.R.style.tu, org.hamotunnelplus.xyz.R.style.ty};
    public static final int[] k = {R.attr.layout, R.attr.max, org.hamotunnelplus.xyz.R.style.ao, org.hamotunnelplus.xyz.R.style.u4, org.hamotunnelplus.xyz.R.style.zm, org.hamotunnelplus.xyz.R.style.a0_, org.hamotunnelplus.xyz.R.style.a6z};
    public static final int[] l = {R.attr.summaryOn, R.attr.summaryOff, R.attr.disableDependentsState, R.attr.switchTextOn, R.attr.switchTextOff, org.hamotunnelplus.xyz.R.style.ja, org.hamotunnelplus.xyz.R.style.a25, org.hamotunnelplus.xyz.R.style.a26, org.hamotunnelplus.xyz.R.style.a2c, org.hamotunnelplus.xyz.R.style.a2d};
    public static final int[] m = {R.attr.summaryOn, R.attr.summaryOff, R.attr.disableDependentsState, R.attr.switchTextOn, R.attr.switchTextOff, org.hamotunnelplus.xyz.R.style.ja, org.hamotunnelplus.xyz.R.style.a25, org.hamotunnelplus.xyz.R.style.a26, org.hamotunnelplus.xyz.R.style.a2c, org.hamotunnelplus.xyz.R.style.a2d};
    public static final int[] n = {R.attr.orientation, R.attr.id, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.alpha, R.attr.transformPivotX, R.attr.transformPivotY, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.translationZ, R.attr.elevation, org.hamotunnelplus.xyz.R.style.b1, org.hamotunnelplus.xyz.R.style.b2, org.hamotunnelplus.xyz.R.style.c2, org.hamotunnelplus.xyz.R.style.c3, org.hamotunnelplus.xyz.R.style.c4, org.hamotunnelplus.xyz.R.style.dz, org.hamotunnelplus.xyz.R.style.h8, org.hamotunnelplus.xyz.R.style.h9, org.hamotunnelplus.xyz.R.style.jn, org.hamotunnelplus.xyz.R.style.ma, org.hamotunnelplus.xyz.R.style.mb, org.hamotunnelplus.xyz.R.style.mc, org.hamotunnelplus.xyz.R.style.md, org.hamotunnelplus.xyz.R.style.me, org.hamotunnelplus.xyz.R.style.mf, org.hamotunnelplus.xyz.R.style.mg, org.hamotunnelplus.xyz.R.style.mh, org.hamotunnelplus.xyz.R.style.mi, org.hamotunnelplus.xyz.R.style.mj, org.hamotunnelplus.xyz.R.style.mk, org.hamotunnelplus.xyz.R.style.ml, org.hamotunnelplus.xyz.R.style.mm, org.hamotunnelplus.xyz.R.style.mo, org.hamotunnelplus.xyz.R.style.mp, org.hamotunnelplus.xyz.R.style.mq, org.hamotunnelplus.xyz.R.style.mr, org.hamotunnelplus.xyz.R.style.ms, org.hamotunnelplus.xyz.R.style.nc, org.hamotunnelplus.xyz.R.style.qa, org.hamotunnelplus.xyz.R.style.qb, org.hamotunnelplus.xyz.R.style.qc, org.hamotunnelplus.xyz.R.style.qd, org.hamotunnelplus.xyz.R.style.qe, org.hamotunnelplus.xyz.R.style.qf, org.hamotunnelplus.xyz.R.style.qg, org.hamotunnelplus.xyz.R.style.qh, org.hamotunnelplus.xyz.R.style.qi, org.hamotunnelplus.xyz.R.style.qj, org.hamotunnelplus.xyz.R.style.qk, org.hamotunnelplus.xyz.R.style.ql, org.hamotunnelplus.xyz.R.style.qm, org.hamotunnelplus.xyz.R.style.qn, org.hamotunnelplus.xyz.R.style.qo, org.hamotunnelplus.xyz.R.style.qp, org.hamotunnelplus.xyz.R.style.qq, org.hamotunnelplus.xyz.R.style.qr, org.hamotunnelplus.xyz.R.style.qs, org.hamotunnelplus.xyz.R.style.qt, org.hamotunnelplus.xyz.R.style.qu, org.hamotunnelplus.xyz.R.style.qv, org.hamotunnelplus.xyz.R.style.qw, org.hamotunnelplus.xyz.R.style.qx, org.hamotunnelplus.xyz.R.style.qy, org.hamotunnelplus.xyz.R.style.qz, org.hamotunnelplus.xyz.R.style.r0, org.hamotunnelplus.xyz.R.style.r1, org.hamotunnelplus.xyz.R.style.r2, org.hamotunnelplus.xyz.R.style.r3, org.hamotunnelplus.xyz.R.style.r4, org.hamotunnelplus.xyz.R.style.r5, org.hamotunnelplus.xyz.R.style.r6, org.hamotunnelplus.xyz.R.style.r7, org.hamotunnelplus.xyz.R.style.r8, org.hamotunnelplus.xyz.R.style.r9, org.hamotunnelplus.xyz.R.style.r_, org.hamotunnelplus.xyz.R.style.ra, org.hamotunnelplus.xyz.R.style.rb, org.hamotunnelplus.xyz.R.style.rc, org.hamotunnelplus.xyz.R.style.rd, org.hamotunnelplus.xyz.R.style.re, org.hamotunnelplus.xyz.R.style.rf, org.hamotunnelplus.xyz.R.style.rg, org.hamotunnelplus.xyz.R.style.rh, org.hamotunnelplus.xyz.R.style.ri, org.hamotunnelplus.xyz.R.style.rk, org.hamotunnelplus.xyz.R.style.rl, org.hamotunnelplus.xyz.R.style.rm, org.hamotunnelplus.xyz.R.style.rn, org.hamotunnelplus.xyz.R.style.ro, org.hamotunnelplus.xyz.R.style.rp, org.hamotunnelplus.xyz.R.style.rq, org.hamotunnelplus.xyz.R.style.rr, org.hamotunnelplus.xyz.R.style.rs, org.hamotunnelplus.xyz.R.style.rv, org.hamotunnelplus.xyz.R.style.s0, org.hamotunnelplus.xyz.R.style.v2, org.hamotunnelplus.xyz.R.style.v3, org.hamotunnelplus.xyz.R.style.wc, org.hamotunnelplus.xyz.R.style.wk, org.hamotunnelplus.xyz.R.style.wq, org.hamotunnelplus.xyz.R.style.y2, org.hamotunnelplus.xyz.R.style.y3, org.hamotunnelplus.xyz.R.style.y4, org.hamotunnelplus.xyz.R.style.a6o, org.hamotunnelplus.xyz.R.style.a6q, org.hamotunnelplus.xyz.R.style.a6s, org.hamotunnelplus.xyz.R.style.a7b};
    public static final int[] o = {R.attr.orientation, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.paddingStart, R.attr.paddingEnd, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.elevation, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical, org.hamotunnelplus.xyz.R.style.c2, org.hamotunnelplus.xyz.R.style.c3, org.hamotunnelplus.xyz.R.style.c4, org.hamotunnelplus.xyz.R.style.dz, org.hamotunnelplus.xyz.R.style.f1, org.hamotunnelplus.xyz.R.style.f2, org.hamotunnelplus.xyz.R.style.f3, org.hamotunnelplus.xyz.R.style.f4, org.hamotunnelplus.xyz.R.style.f5, org.hamotunnelplus.xyz.R.style.h5, org.hamotunnelplus.xyz.R.style.h8, org.hamotunnelplus.xyz.R.style.h9, org.hamotunnelplus.xyz.R.style.ma, org.hamotunnelplus.xyz.R.style.mb, org.hamotunnelplus.xyz.R.style.mc, org.hamotunnelplus.xyz.R.style.md, org.hamotunnelplus.xyz.R.style.me, org.hamotunnelplus.xyz.R.style.mf, org.hamotunnelplus.xyz.R.style.mg, org.hamotunnelplus.xyz.R.style.mh, org.hamotunnelplus.xyz.R.style.mi, org.hamotunnelplus.xyz.R.style.mj, org.hamotunnelplus.xyz.R.style.mk, org.hamotunnelplus.xyz.R.style.ml, org.hamotunnelplus.xyz.R.style.mm, org.hamotunnelplus.xyz.R.style.mo, org.hamotunnelplus.xyz.R.style.mp, org.hamotunnelplus.xyz.R.style.mq, org.hamotunnelplus.xyz.R.style.mr, org.hamotunnelplus.xyz.R.style.ms, org.hamotunnelplus.xyz.R.style.nc, org.hamotunnelplus.xyz.R.style.q3, org.hamotunnelplus.xyz.R.style.qa, org.hamotunnelplus.xyz.R.style.qb, org.hamotunnelplus.xyz.R.style.qc, org.hamotunnelplus.xyz.R.style.qd, org.hamotunnelplus.xyz.R.style.qe, org.hamotunnelplus.xyz.R.style.qf, org.hamotunnelplus.xyz.R.style.qg, org.hamotunnelplus.xyz.R.style.qh, org.hamotunnelplus.xyz.R.style.qi, org.hamotunnelplus.xyz.R.style.qj, org.hamotunnelplus.xyz.R.style.qk, org.hamotunnelplus.xyz.R.style.ql, org.hamotunnelplus.xyz.R.style.qm, org.hamotunnelplus.xyz.R.style.qn, org.hamotunnelplus.xyz.R.style.qo, org.hamotunnelplus.xyz.R.style.qp, org.hamotunnelplus.xyz.R.style.qq, org.hamotunnelplus.xyz.R.style.qr, org.hamotunnelplus.xyz.R.style.qs, org.hamotunnelplus.xyz.R.style.qt, org.hamotunnelplus.xyz.R.style.qu, org.hamotunnelplus.xyz.R.style.qv, org.hamotunnelplus.xyz.R.style.qw, org.hamotunnelplus.xyz.R.style.qx, org.hamotunnelplus.xyz.R.style.qy, org.hamotunnelplus.xyz.R.style.qz, org.hamotunnelplus.xyz.R.style.r0, org.hamotunnelplus.xyz.R.style.r1, org.hamotunnelplus.xyz.R.style.r2, org.hamotunnelplus.xyz.R.style.r3, org.hamotunnelplus.xyz.R.style.r4, org.hamotunnelplus.xyz.R.style.r5, org.hamotunnelplus.xyz.R.style.r6, org.hamotunnelplus.xyz.R.style.r7, org.hamotunnelplus.xyz.R.style.r8, org.hamotunnelplus.xyz.R.style.r9, org.hamotunnelplus.xyz.R.style.r_, org.hamotunnelplus.xyz.R.style.ra, org.hamotunnelplus.xyz.R.style.rb, org.hamotunnelplus.xyz.R.style.rc, org.hamotunnelplus.xyz.R.style.rd, org.hamotunnelplus.xyz.R.style.re, org.hamotunnelplus.xyz.R.style.rf, org.hamotunnelplus.xyz.R.style.rg, org.hamotunnelplus.xyz.R.style.rh, org.hamotunnelplus.xyz.R.style.ri, org.hamotunnelplus.xyz.R.style.rk, org.hamotunnelplus.xyz.R.style.rl, org.hamotunnelplus.xyz.R.style.rm, org.hamotunnelplus.xyz.R.style.rn, org.hamotunnelplus.xyz.R.style.ro, org.hamotunnelplus.xyz.R.style.rp, org.hamotunnelplus.xyz.R.style.rq, org.hamotunnelplus.xyz.R.style.rr, org.hamotunnelplus.xyz.R.style.rs, org.hamotunnelplus.xyz.R.style.rv, org.hamotunnelplus.xyz.R.style.rw, org.hamotunnelplus.xyz.R.style.s0};
    public static final int[] p = {R.attr.orientation, R.attr.id, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.alpha, R.attr.transformPivotX, R.attr.transformPivotY, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.translationZ, R.attr.elevation, org.hamotunnelplus.xyz.R.style.b1, org.hamotunnelplus.xyz.R.style.b2, org.hamotunnelplus.xyz.R.style.c2, org.hamotunnelplus.xyz.R.style.c3, org.hamotunnelplus.xyz.R.style.c4, org.hamotunnelplus.xyz.R.style.dz, org.hamotunnelplus.xyz.R.style.h8, org.hamotunnelplus.xyz.R.style.jn, org.hamotunnelplus.xyz.R.style.ma, org.hamotunnelplus.xyz.R.style.mb, org.hamotunnelplus.xyz.R.style.mc, org.hamotunnelplus.xyz.R.style.md, org.hamotunnelplus.xyz.R.style.me, org.hamotunnelplus.xyz.R.style.mf, org.hamotunnelplus.xyz.R.style.mg, org.hamotunnelplus.xyz.R.style.mh, org.hamotunnelplus.xyz.R.style.mi, org.hamotunnelplus.xyz.R.style.mj, org.hamotunnelplus.xyz.R.style.mk, org.hamotunnelplus.xyz.R.style.ml, org.hamotunnelplus.xyz.R.style.mm, org.hamotunnelplus.xyz.R.style.mo, org.hamotunnelplus.xyz.R.style.mp, org.hamotunnelplus.xyz.R.style.mq, org.hamotunnelplus.xyz.R.style.mr, org.hamotunnelplus.xyz.R.style.ms, org.hamotunnelplus.xyz.R.style.nc, org.hamotunnelplus.xyz.R.style.qa, org.hamotunnelplus.xyz.R.style.qb, org.hamotunnelplus.xyz.R.style.qc, org.hamotunnelplus.xyz.R.style.qg, org.hamotunnelplus.xyz.R.style.qk, org.hamotunnelplus.xyz.R.style.ql, org.hamotunnelplus.xyz.R.style.qm, org.hamotunnelplus.xyz.R.style.qp, org.hamotunnelplus.xyz.R.style.qq, org.hamotunnelplus.xyz.R.style.qr, org.hamotunnelplus.xyz.R.style.qs, org.hamotunnelplus.xyz.R.style.qt, org.hamotunnelplus.xyz.R.style.qu, org.hamotunnelplus.xyz.R.style.qv, org.hamotunnelplus.xyz.R.style.qw, org.hamotunnelplus.xyz.R.style.qx, org.hamotunnelplus.xyz.R.style.qy, org.hamotunnelplus.xyz.R.style.qz, org.hamotunnelplus.xyz.R.style.r0, org.hamotunnelplus.xyz.R.style.r3, org.hamotunnelplus.xyz.R.style.r8, org.hamotunnelplus.xyz.R.style.r9, org.hamotunnelplus.xyz.R.style.rb, org.hamotunnelplus.xyz.R.style.rc, org.hamotunnelplus.xyz.R.style.rd, org.hamotunnelplus.xyz.R.style.re, org.hamotunnelplus.xyz.R.style.rf, org.hamotunnelplus.xyz.R.style.rg, org.hamotunnelplus.xyz.R.style.rh, org.hamotunnelplus.xyz.R.style.ri, org.hamotunnelplus.xyz.R.style.rk, org.hamotunnelplus.xyz.R.style.rl, org.hamotunnelplus.xyz.R.style.rm, org.hamotunnelplus.xyz.R.style.rn, org.hamotunnelplus.xyz.R.style.ro, org.hamotunnelplus.xyz.R.style.rp, org.hamotunnelplus.xyz.R.style.rq, org.hamotunnelplus.xyz.R.style.rr, org.hamotunnelplus.xyz.R.style.rs, org.hamotunnelplus.xyz.R.style.rv, org.hamotunnelplus.xyz.R.style.s0, org.hamotunnelplus.xyz.R.style.v2, org.hamotunnelplus.xyz.R.style.v3, org.hamotunnelplus.xyz.R.style.v4, org.hamotunnelplus.xyz.R.style.wc, org.hamotunnelplus.xyz.R.style.wk, org.hamotunnelplus.xyz.R.style.wq, org.hamotunnelplus.xyz.R.style.y2, org.hamotunnelplus.xyz.R.style.y3, org.hamotunnelplus.xyz.R.style.y4, org.hamotunnelplus.xyz.R.style.a6o, org.hamotunnelplus.xyz.R.style.a6q, org.hamotunnelplus.xyz.R.style.a6s, org.hamotunnelplus.xyz.R.style.a7b};
    public static final int[] q = {R.attr.orientation, R.attr.id, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.pivotX, R.attr.pivotY, R.attr.alpha, R.attr.transformPivotX, R.attr.transformPivotY, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.translationZ, R.attr.elevation, org.hamotunnelplus.xyz.R.style.b1, org.hamotunnelplus.xyz.R.style.b2, org.hamotunnelplus.xyz.R.style.c2, org.hamotunnelplus.xyz.R.style.c3, org.hamotunnelplus.xyz.R.style.c4, org.hamotunnelplus.xyz.R.style.dz, org.hamotunnelplus.xyz.R.style.h4, org.hamotunnelplus.xyz.R.style.h8, org.hamotunnelplus.xyz.R.style.h9, org.hamotunnelplus.xyz.R.style.j1, org.hamotunnelplus.xyz.R.style.jn, org.hamotunnelplus.xyz.R.style.ma, org.hamotunnelplus.xyz.R.style.mb, org.hamotunnelplus.xyz.R.style.mc, org.hamotunnelplus.xyz.R.style.md, org.hamotunnelplus.xyz.R.style.me, org.hamotunnelplus.xyz.R.style.mf, org.hamotunnelplus.xyz.R.style.mg, org.hamotunnelplus.xyz.R.style.mh, org.hamotunnelplus.xyz.R.style.mi, org.hamotunnelplus.xyz.R.style.mj, org.hamotunnelplus.xyz.R.style.mk, org.hamotunnelplus.xyz.R.style.ml, org.hamotunnelplus.xyz.R.style.mm, org.hamotunnelplus.xyz.R.style.mo, org.hamotunnelplus.xyz.R.style.mp, org.hamotunnelplus.xyz.R.style.mq, org.hamotunnelplus.xyz.R.style.mr, org.hamotunnelplus.xyz.R.style.ms, org.hamotunnelplus.xyz.R.style.nc, org.hamotunnelplus.xyz.R.style.qa, org.hamotunnelplus.xyz.R.style.qb, org.hamotunnelplus.xyz.R.style.qc, org.hamotunnelplus.xyz.R.style.qd, org.hamotunnelplus.xyz.R.style.qe, org.hamotunnelplus.xyz.R.style.qf, org.hamotunnelplus.xyz.R.style.qg, org.hamotunnelplus.xyz.R.style.qh, org.hamotunnelplus.xyz.R.style.qi, org.hamotunnelplus.xyz.R.style.qj, org.hamotunnelplus.xyz.R.style.qk, org.hamotunnelplus.xyz.R.style.ql, org.hamotunnelplus.xyz.R.style.qm, org.hamotunnelplus.xyz.R.style.qn, org.hamotunnelplus.xyz.R.style.qo, org.hamotunnelplus.xyz.R.style.qp, org.hamotunnelplus.xyz.R.style.qq, org.hamotunnelplus.xyz.R.style.qr, org.hamotunnelplus.xyz.R.style.qt, org.hamotunnelplus.xyz.R.style.qu, org.hamotunnelplus.xyz.R.style.qv, org.hamotunnelplus.xyz.R.style.qw, org.hamotunnelplus.xyz.R.style.qx, org.hamotunnelplus.xyz.R.style.qy, org.hamotunnelplus.xyz.R.style.qz, org.hamotunnelplus.xyz.R.style.r0, org.hamotunnelplus.xyz.R.style.r1, org.hamotunnelplus.xyz.R.style.r2, org.hamotunnelplus.xyz.R.style.r3, org.hamotunnelplus.xyz.R.style.r4, org.hamotunnelplus.xyz.R.style.r5, org.hamotunnelplus.xyz.R.style.r6, org.hamotunnelplus.xyz.R.style.r7, org.hamotunnelplus.xyz.R.style.r8, org.hamotunnelplus.xyz.R.style.r9, org.hamotunnelplus.xyz.R.style.r_, org.hamotunnelplus.xyz.R.style.ra, org.hamotunnelplus.xyz.R.style.rb, org.hamotunnelplus.xyz.R.style.rc, org.hamotunnelplus.xyz.R.style.rd, org.hamotunnelplus.xyz.R.style.rf, org.hamotunnelplus.xyz.R.style.rg, org.hamotunnelplus.xyz.R.style.rh, org.hamotunnelplus.xyz.R.style.ri, org.hamotunnelplus.xyz.R.style.rk, org.hamotunnelplus.xyz.R.style.rl, org.hamotunnelplus.xyz.R.style.rm, org.hamotunnelplus.xyz.R.style.rn, org.hamotunnelplus.xyz.R.style.ro, org.hamotunnelplus.xyz.R.style.rp, org.hamotunnelplus.xyz.R.style.rq, org.hamotunnelplus.xyz.R.style.rr, org.hamotunnelplus.xyz.R.style.rs, org.hamotunnelplus.xyz.R.style.rv, org.hamotunnelplus.xyz.R.style.s0, org.hamotunnelplus.xyz.R.style.v2, org.hamotunnelplus.xyz.R.style.v3, org.hamotunnelplus.xyz.R.style.wc, org.hamotunnelplus.xyz.R.style.wk, org.hamotunnelplus.xyz.R.style.wq, org.hamotunnelplus.xyz.R.style.y4, org.hamotunnelplus.xyz.R.style.a6q, org.hamotunnelplus.xyz.R.style.a6s};
    public static final int[] r = {org.hamotunnelplus.xyz.R.style.bb, org.hamotunnelplus.xyz.R.style.id, org.hamotunnelplus.xyz.R.style.ie, org.hamotunnelplus.xyz.R.style.if_res_0x7f040152, org.hamotunnelplus.xyz.R.style.ig, org.hamotunnelplus.xyz.R.style.ih, org.hamotunnelplus.xyz.R.style.ii, org.hamotunnelplus.xyz.R.style.ik, org.hamotunnelplus.xyz.R.style.il, org.hamotunnelplus.xyz.R.style.im, org.hamotunnelplus.xyz.R.style.u2};
    public static final int[] x = {R.attr.orientation, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.layout_marginStart, R.attr.layout_marginEnd, org.hamotunnelplus.xyz.R.style.c2, org.hamotunnelplus.xyz.R.style.c3, org.hamotunnelplus.xyz.R.style.c4, org.hamotunnelplus.xyz.R.style.dz, org.hamotunnelplus.xyz.R.style.h8, org.hamotunnelplus.xyz.R.style.h9, org.hamotunnelplus.xyz.R.style.nc, org.hamotunnelplus.xyz.R.style.qa, org.hamotunnelplus.xyz.R.style.qb, org.hamotunnelplus.xyz.R.style.qc, org.hamotunnelplus.xyz.R.style.qd, org.hamotunnelplus.xyz.R.style.qe, org.hamotunnelplus.xyz.R.style.qf, org.hamotunnelplus.xyz.R.style.qg, org.hamotunnelplus.xyz.R.style.qh, org.hamotunnelplus.xyz.R.style.qi, org.hamotunnelplus.xyz.R.style.qj, org.hamotunnelplus.xyz.R.style.qk, org.hamotunnelplus.xyz.R.style.ql, org.hamotunnelplus.xyz.R.style.qm, org.hamotunnelplus.xyz.R.style.qn, org.hamotunnelplus.xyz.R.style.qo, org.hamotunnelplus.xyz.R.style.qp, org.hamotunnelplus.xyz.R.style.qq, org.hamotunnelplus.xyz.R.style.qr, org.hamotunnelplus.xyz.R.style.qs, org.hamotunnelplus.xyz.R.style.qt, org.hamotunnelplus.xyz.R.style.qu, org.hamotunnelplus.xyz.R.style.qv, org.hamotunnelplus.xyz.R.style.qw, org.hamotunnelplus.xyz.R.style.qx, org.hamotunnelplus.xyz.R.style.qy, org.hamotunnelplus.xyz.R.style.qz, org.hamotunnelplus.xyz.R.style.r0, org.hamotunnelplus.xyz.R.style.r1, org.hamotunnelplus.xyz.R.style.r2, org.hamotunnelplus.xyz.R.style.r3, org.hamotunnelplus.xyz.R.style.r4, org.hamotunnelplus.xyz.R.style.r5, org.hamotunnelplus.xyz.R.style.r6, org.hamotunnelplus.xyz.R.style.r7, org.hamotunnelplus.xyz.R.style.r9, org.hamotunnelplus.xyz.R.style.r_, org.hamotunnelplus.xyz.R.style.ra, org.hamotunnelplus.xyz.R.style.rb, org.hamotunnelplus.xyz.R.style.rc, org.hamotunnelplus.xyz.R.style.rd, org.hamotunnelplus.xyz.R.style.re, org.hamotunnelplus.xyz.R.style.rf, org.hamotunnelplus.xyz.R.style.rg, org.hamotunnelplus.xyz.R.style.rh, org.hamotunnelplus.xyz.R.style.ri, org.hamotunnelplus.xyz.R.style.rk, org.hamotunnelplus.xyz.R.style.rl, org.hamotunnelplus.xyz.R.style.rm, org.hamotunnelplus.xyz.R.style.rn, org.hamotunnelplus.xyz.R.style.ro, org.hamotunnelplus.xyz.R.style.rp, org.hamotunnelplus.xyz.R.style.rq, org.hamotunnelplus.xyz.R.style.rr, org.hamotunnelplus.xyz.R.style.rs, org.hamotunnelplus.xyz.R.style.rv, org.hamotunnelplus.xyz.R.style.s0, org.hamotunnelplus.xyz.R.style.tu, org.hamotunnelplus.xyz.R.style.ty, org.hamotunnelplus.xyz.R.style.u5, org.hamotunnelplus.xyz.R.style.u9};
    public static final int[] y = {org.hamotunnelplus.xyz.R.style.b1, org.hamotunnelplus.xyz.R.style.b2, org.hamotunnelplus.xyz.R.style.jn, org.hamotunnelplus.xyz.R.style.v1, org.hamotunnelplus.xyz.R.style.v3, org.hamotunnelplus.xyz.R.style.wc, org.hamotunnelplus.xyz.R.style.y2, org.hamotunnelplus.xyz.R.style.y3, org.hamotunnelplus.xyz.R.style.y4, org.hamotunnelplus.xyz.R.style.a6q};
    public static final int[] D = {R.attr.visibility, R.attr.alpha, org.hamotunnelplus.xyz.R.style.r8, org.hamotunnelplus.xyz.R.style.v2, org.hamotunnelplus.xyz.R.style.a7b};
    public static final int[] E = {R.attr.id, org.hamotunnelplus.xyz.R.style.h_};
    public static final int[] G = {R.attr.transformPivotX, R.attr.transformPivotY, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.translationZ, R.attr.elevation, org.hamotunnelplus.xyz.R.style.a6o};
    public static final int[] I = {org.hamotunnelplus.xyz.R.style.h_, org.hamotunnelplus.xyz.R.style.yh, org.hamotunnelplus.xyz.R.style.yi, org.hamotunnelplus.xyz.R.style.yj, org.hamotunnelplus.xyz.R.style.yk};
    public static final int[] L = {R.attr.name, R.attr.id, R.attr.tag};
    public static final int[] M = {R.attr.name, R.attr.tag};
    public static final /* synthetic */ int[] a$1 = {1, 2, 3, 4, 5, 6, 7, 8};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final n11.a f1a = new n11.a(1);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final m11$a$b f4b = new m11$a$b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ci0 f0a = new ci0("ResolutionAnchorProvider", 0);
    public static final int[] a$2 = {R.attr.name, R.attr.tint, R.attr.height, R.attr.width, R.attr.alpha, R.attr.autoMirrored, R.attr.tintMode, R.attr.viewportWidth, R.attr.viewportHeight};

    /* JADX INFO: renamed from: b$1, reason: collision with other field name */
    public static final int[] f6b$1 = {R.attr.name, R.attr.pivotX, R.attr.pivotY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.translateX, R.attr.translateY};
    public static final int[] c$1 = {R.attr.name, R.attr.fillColor, R.attr.pathData, R.attr.strokeColor, R.attr.strokeWidth, R.attr.trimPathStart, R.attr.trimPathEnd, R.attr.trimPathOffset, R.attr.strokeLineCap, R.attr.strokeLineJoin, R.attr.strokeMiterLimit, R.attr.strokeAlpha, R.attr.fillAlpha, R.attr.fillType};
    public static final int[] d$1 = {R.attr.name, R.attr.pathData, R.attr.fillType};
    public static final int[] e$1 = {R.attr.drawable};
    public static final int[] f$1 = {R.attr.name, R.attr.animation};
    public static final int[] g$1 = {R.attr.interpolator, R.attr.duration, R.attr.startOffset, R.attr.repeatCount, R.attr.repeatMode, R.attr.valueFrom, R.attr.valueTo, R.attr.valueType};
    public static final int[] h$1 = {R.attr.ordering};
    public static final int[] i$1 = {R.attr.valueFrom, R.attr.valueTo, R.attr.valueType, R.attr.propertyName};
    public static final int[] j$1 = {R.attr.value, R.attr.interpolator, R.attr.valueType, R.attr.fraction};
    public static final int[] k$1 = {R.attr.propertyName, R.attr.pathData, R.attr.propertyXName, R.attr.propertyYName};

    /* JADX INFO: renamed from: ak$0, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract /* synthetic */ class AnonymousClass0 {
        public static String m(String str, String str2) {
            return str + str2;
        }

        public static String m(String str, String str2, String str3) {
            return str + str2 + str3;
        }
    }

    /* JADX INFO: renamed from: ak$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ void m(String str) {
            throw new IllegalArgumentException(str);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface c {
        Iterable Q(Object obj);
    }

    public ak(int i2) {
        this.G0 = i2;
        if (i2 != 9) {
            new ConcurrentHashMap();
        } else {
            new fg1();
        }
    }

    public /* synthetic */ ak(int i2, boolean z) {
        this.G0 = i2;
    }

    public /* synthetic */ ak(boolean z) {
        this.G0 = 9;
    }

    public static int a(Context context, int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId != 0 ? i2 : i3;
    }

    public static final ca1 a(ca1 ca1Var, v91 v91Var) {
        if (v91Var == null || ca1Var.c() == ad1.INVARIANT) {
            return ca1Var;
        }
        if (v91Var.j() == ca1Var.c()) {
            return ca1Var.b() ? new da1(new de0(ff0.e, new ca0(13, ca1Var))) : new da1(ca1Var.getType());
        }
        return new da1(new jb(ca1Var, new nb(ca1Var), false, e4.f47a));
    }

    public static cv a(g4 g4Var) {
        ai0 ai0VarD = ym.d(g4Var);
        if (ai0VarD != null) {
            if (pr.h(ai0VarD)) {
                ai0VarD = null;
            }
            if (ai0VarD != null) {
                return ym.c(ai0VarD);
            }
        }
        return null;
    }

    public static gd1 a(tr0 tr0Var) {
        return tr0Var.c.size() == 0 ? gd1.b : new gd1(tr0Var.c);
    }

    public static Object a(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 34) {
            return bundle.getParcelable(str, j2.class);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (j2.class.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    public static li a(li liVar, li liVar2) {
        return liVar2 == rq.b ? liVar : (li) liVar2.i(liVar, new ke(5));
    }

    public static final li a(li liVar, li liVar2, boolean z) {
        Boolean bool = Boolean.FALSE;
        gm gmVar = gm.b$7;
        boolean zBooleanValue = ((Boolean) liVar.i(bool, gmVar)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) liVar2.i(bool, gmVar)).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return liVar.y(liVar2);
        }
        vu0 vu0Var = new vu0();
        vu0Var.b = liVar2;
        gm gmVar2 = new gm(2, 4);
        rq rqVar = rq.b;
        li liVar3 = (li) liVar.i(rqVar, gmVar2);
        if (zBooleanValue2) {
            vu0Var.b = ((li) vu0Var.b).i(rqVar, gm.b$3);
        }
        return liVar3.y((li) vu0Var.b);
    }

    public static qh0 a(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j2;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        qz qzVar = new qz(byteBufferDuplicate);
        ByteBuffer byteBuffer = (ByteBuffer) qzVar.a;
        qzVar.m19b(4);
        int i2 = byteBufferDuplicate.getShort() & 65535;
        if (i2 <= 100) {
            qzVar.m19b(6);
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    j2 = -1;
                    break;
                }
                int i4 = byteBuffer.getInt();
                qzVar.m19b(4);
                j2 = ((long) byteBuffer.getInt()) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                qzVar.m19b(4);
                if (1835365473 == i4) {
                    break;
                }
                i3++;
            }
            if (j2 != -1) {
                qzVar.m19b((int) (j2 - ((long) byteBufferDuplicate.position())));
                qzVar.m19b(12);
                long j3 = ((long) byteBuffer.getInt()) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                for (int i5 = 0; i5 < j3; i5++) {
                    int i6 = byteBuffer.getInt();
                    long j4 = ((long) byteBuffer.getInt()) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                    byteBuffer.getInt();
                    if (1164798569 == i6 || 1701669481 == i6) {
                        byteBufferDuplicate.position((int) (j4 + j2));
                        qh0 qh0Var = new qh0();
                        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                        int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                        qh0Var.b = byteBufferDuplicate;
                        qh0Var.a = iPosition;
                        int i7 = iPosition - byteBufferDuplicate.getInt(iPosition);
                        qh0Var.c = i7;
                        qh0Var.d = ((ByteBuffer) qh0Var.b).getShort(i7);
                        return qh0Var;
                    }
                }
            }
        }
        d.AnonymousClass0.m$6("Cannot read metadata.");
        return null;
    }

    public static void a(Window window) {
        if (Build.VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(false);
        } else {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1792);
        }
    }

    public static boolean a() {
        try {
            if (b$1 == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (b$1 == null) {
                a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                b$1 = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) b$1.invoke(null, Long.valueOf(a))).booleanValue();
        } catch (Exception e2) {
            if (!(e2 instanceof InvocationTargetException)) {
                return false;
            }
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        WeakReference weakReference;
        ArrayList arrayList;
        int size;
        int iIndexOfKey;
        WeakHashMap weakHashMap = qd1.a;
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList arrayList2 = qd1.n.d;
            qd1.n nVar = (qd1.n) view.getTag(org.hamotunnelplus.xyz.R.attr.a0e);
            if (nVar == null) {
                nVar = new qd1.n();
                view.setTag(org.hamotunnelplus.xyz.R.attr.a0e, nVar);
            }
            WeakReference weakReference2 = nVar.c;
            if (weakReference2 == null || weakReference2.get() != keyEvent) {
                nVar.c = new WeakReference(keyEvent);
                if (nVar.b == null) {
                    nVar.b = new SparseArray();
                }
                SparseArray sparseArray = nVar.b;
                if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) < 0) {
                    weakReference = null;
                } else {
                    weakReference = (WeakReference) sparseArray.valueAt(iIndexOfKey);
                    sparseArray.removeAt(iIndexOfKey);
                }
                if (weakReference == null) {
                    weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
                }
                if (weakReference != null) {
                    View view2 = (View) weakReference.get();
                    if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(org.hamotunnelplus.xyz.R.attr.a0f)) == null || (size = arrayList.size() - 1) < 0) {
                        return true;
                    }
                    arrayList.get(size).getClass();
                    d.AnonymousClass0.m$1();
                    return false;
                }
            }
        }
        return false;
    }

    public static Certificate[] a(String str) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        Vector vector = new Vector();
        if (str == null || (!str.startsWith("[[INLINE]]") && !str.startsWith("[[NAME]]"))) {
            return new Certificate[]{certificateFactory.generateCertificate(new FileInputStream(str))};
        }
        int iIndexOf = str.indexOf("-----BEGIN CERTIFICATE-----");
        do {
            int iMax = Math.max(0, iIndexOf);
            vector.add(certificateFactory.generateCertificate(new ByteArrayInputStream(str.substring(iMax).getBytes())));
            iIndexOf = str.indexOf("-----BEGIN CERTIFICATE-----", iMax + 1);
        } while (iIndexOf > 0);
        return (Certificate[]) vector.toArray(new Certificate[vector.size()]);
    }

    public static ea1 b(a91 a91Var, List list) {
        List parameters = a91Var.getParameters();
        v91 v91Var = (v91) he.U0(parameters);
        int i2 = 0;
        if (v91Var != null && v91Var.S()) {
            List parameters2 = a91Var.getParameters();
            ArrayList arrayList = new ArrayList(ae.y0(parameters2));
            Iterator it = parameters2.iterator();
            while (it.hasNext()) {
                arrayList.add(((v91) it.next()).h());
            }
            return new c91(i2, ye1.j(he.k1(arrayList, list)));
        }
        Object[] array = parameters.toArray(new v91[0]);
        if (array == null) {
            d.AnonymousClass0.m$1("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return null;
        }
        v91[] v91VarArr = (v91[]) array;
        Object[] array2 = list.toArray(new ca1[0]);
        if (array2 != null) {
            return new z10(v91VarArr, (ca1[]) array2, false);
        }
        d.AnonymousClass0.m$1("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return null;
    }

    public static ea1 b(ea1 ea1Var) {
        int i2 = 0;
        if (!(ea1Var instanceof z10)) {
            return new pb(ea1Var, i2);
        }
        z10 z10Var = (z10) ea1Var;
        ca1[] ca1VarArr = z10Var.c;
        v91[] v91VarArr = z10Var.b;
        int iMin = Math.min(ca1VarArr.length, v91VarArr.length);
        ArrayList<jo0> arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(new jo0(ca1VarArr[i3], v91VarArr[i3]));
        }
        ArrayList arrayList2 = new ArrayList(ae.y0(arrayList));
        for (jo0 jo0Var : arrayList) {
            arrayList2.add(a((ca1) jo0Var.b, (v91) jo0Var.c));
        }
        Object[] array = arrayList2.toArray(new ca1[0]);
        if (array != null) {
            return new z10(v91VarArr, (ca1[]) array, true);
        }
        d.AnonymousClass0.m$1("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return null;
    }

    public static gj b(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i2) {
        gj gjVarA;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            int i3 = typedValue.type;
            if (i3 >= 28 && i3 <= 31) {
                return new gj((Shader) null, (ColorStateList) null, typedValue.data);
            }
            try {
                gjVarA = gj.a(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
            } catch (Exception unused) {
                gjVarA = null;
            }
            if (gjVarA != null) {
                return gjVarA;
            }
        }
        return new gj((Shader) null, (ColorStateList) null, 0);
    }

    public static Object b(Collection collection, c cVar, b2 b2Var) {
        bj bjVar = new bj(2, (byte) 0);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            c(it.next(), cVar, bjVar, b2Var);
        }
        return b2Var.result();
    }

    public static final qb1 b(ai aiVar, li liVar, Object obj) {
        qb1 qb1Var = null;
        if ((aiVar instanceof wi) && liVar.a(rb1.b) != null) {
            wi callerFrame = (wi) aiVar;
            while (!(callerFrame instanceof ro) && (callerFrame = callerFrame.getCallerFrame()) != null) {
                if (callerFrame instanceof qb1) {
                    qb1Var = (qb1) callerFrame;
                    break;
                }
            }
            if (qb1Var != null) {
                qb1Var.threadLocalIsSet = true;
                qb1Var.g.set(new jo0(liVar, obj));
            }
        }
        return qb1Var;
    }

    public static void b(TextView textView, int i2) {
        e.C0(i2);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static boolean b(jb0$a jb0_a, View view, Window.Callback callback, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener;
        boolean zBooleanValue = false;
        if (jb0_a != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return jb0_a.superDispatchKeyEvent(keyEvent);
            }
            if (callback instanceof Activity) {
                Activity activity = (Activity) callback;
                activity.onUserInteraction();
                Window window = activity.getWindow();
                if (window.hasFeature(8)) {
                    ActionBar actionBar = activity.getActionBar();
                    if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                        if (!f2a) {
                            try {
                                b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                            } catch (NoSuchMethodException unused) {
                            }
                            f2a = true;
                        }
                        Method method = b;
                        if (method != null) {
                            try {
                                Object objInvoke = method.invoke(actionBar, keyEvent);
                                if (objInvoke != null) {
                                    zBooleanValue = ((Boolean) objInvoke).booleanValue();
                                }
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        }
                        if (zBooleanValue) {
                            return true;
                        }
                    }
                }
                if (window.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView = window.getDecorView();
                if (qd1.c(decorView, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
            }
            if (callback instanceof Dialog) {
                Dialog dialog = (Dialog) callback;
                if (!c) {
                    try {
                        Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                        d = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused3) {
                    }
                    c = true;
                }
                Field field = d;
                if (field != null) {
                    try {
                        onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
                    } catch (IllegalAccessException unused4) {
                        onKeyListener = null;
                    }
                } else {
                    onKeyListener = null;
                }
                if (onKeyListener != null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                    return true;
                }
                Window window2 = dialog.getWindow();
                if (window2.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView2 = window2.getDecorView();
                if (qd1.c(decorView2, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(dialog, decorView2 != null ? decorView2.getKeyDispatcherState() : null, dialog);
            }
            if ((view != null && qd1.c(view, keyEvent)) || jb0_a.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public static nu0$a c(lw lwVar) {
        if (lwVar != null) {
            return new nu0$a(null, lwVar);
        }
        d.AnonymousClass0.m$4("Argument for @NotNull parameter 'initializer' of kotlin/reflect/jvm/internal/ReflectProperties.lazySoft must not be null");
        return null;
    }

    public static void c(TextView textView, int i2) {
        e.C0(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static void c(Object obj, c cVar, bj bjVar, b2 b2Var) {
        if (obj == null) {
            AnonymousClass1.m("Argument for @NotNull parameter 'current' of kotlin/reflect/jvm/internal/impl/utils/DFS.doDfs must not be null");
            return;
        }
        if (((HashSet) bjVar.a).add(obj) && b2Var.mo2b(obj)) {
            Iterator it = cVar.Q(obj).iterator();
            while (it.hasNext()) {
                c(it.next(), cVar, bjVar, b2Var);
            }
            b2Var.a(obj);
        }
    }

    public static ActionMode.Callback e(ActionMode.Callback callback) {
        return (!(callback instanceof h61$d) || Build.VERSION.SDK_INT < 26) ? callback : ((h61$d) callback).a;
    }

    public static String e(TypedArray typedArray, XmlResourceParser xmlResourceParser, String str, int i2) {
        if (g(xmlResourceParser, str)) {
            return typedArray.getString(i2);
        }
        return null;
    }

    public static ActionMode.Callback f(ActionMode.Callback callback, TextView textView) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof h61$d) || callback == null) ? callback : new h61$d(callback, textView);
    }

    public static String f(int i2, int i3, String str) {
        StringBuilder sb = new StringBuilder(i2);
        sb.append(str);
        sb.append(i3);
        return sb.toString();
    }

    public static String g(long j2, StringBuilder sb, Intent intent) {
        sb.append(uh.a(j2));
        return intent.getStringExtra(sb.toString());
    }

    public static boolean g(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static String h(int i2, String str) {
        return str + i2;
    }

    public static TypesWriter i(int i2) {
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeByte(i2);
        return typesWriter;
    }

    public static String i(int i2, int i3, String str, String str2) {
        return str + i2 + str2 + i3;
    }

    public static String j(String str, String str2) {
        return str + str2;
    }

    public static String l(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String m(String str, String str2) {
        return AnonymousClass0.m(str, str2);
    }

    public static StringBuilder n(int i2, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i2);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder o(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder q(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static void r(int i2, String str) {
        if (i2 != 0) {
            return;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = e4.class.getName();
        int i3 = 0;
        while (!stackTrace[i3].getClassName().equals(name)) {
            i3++;
        }
        while (stackTrace[i3].getClassName().equals(name)) {
            i3++;
        }
        StackTraceElement stackTraceElement = stackTrace[i3];
        throw new NullPointerException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str);
    }

    public static /* synthetic */ int u(int i2) {
        if (i2 != 0) {
            return i2 - 1;
        }
        throw null;
    }

    public abstract Typeface a(Context context, vu$c vu_c, Resources resources, int i2);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract String mo0a();

    public abstract Typeface b(Context context, xu[] xuVarArr, int i2);

    public abstract fg1 b();

    public abstract void c(t20 t20Var);

    public void callbackFailAsync(int i2) {
        new Handler(Looper.getMainLooper()).post(new df(this, i2, 3));
    }

    public Typeface d(Context context, Resources resources, int i2, String str, int i3) {
        File fileD = e4.d(context);
        if (fileD == null) {
            return null;
        }
        try {
            if (e4.b(fileD, resources, i2)) {
                return Typeface.createFromFile(fileD.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileD.delete();
        }
    }

    public abstract void d(t20 t20Var);

    public xu f(int i2, xu[] xuVarArr) {
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z = (i2 & 2) != 0;
        xu xuVar = null;
        int i4 = Integer.MAX_VALUE;
        for (xu xuVar2 : xuVarArr) {
            int iAbs = (Math.abs(xuVar2.c - i3) * 2) + (xuVar2.d == z ? 0 : 1);
            if (xuVar == null || i4 > iAbs) {
                xuVar = xuVar2;
                i4 = iAbs;
            }
        }
        return xuVar;
    }

    public abstract void onFontRetrievalFailed(int i2);

    public abstract void onFontRetrieved(Typeface typeface);

    public String toString() {
        return this.G0 != 23 ? super.toString() : mo0a();
    }
}
