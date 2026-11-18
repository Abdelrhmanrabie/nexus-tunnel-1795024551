package defpackage;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.ContentInfo;
import android.widget.EditText;
import android.widget.TextView;
import androidx.transition.h;
import com.android.volley.ExecutorDelivery$1;
import com.android.volley.Response;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.GenericGFPoly;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.qrcode.decoder.DataMask;
import com.google.zxing.qrcode.decoder.DecodedBitStreamParser;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.FormatInformation;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.detector.AlignmentPattern;
import com.google.zxing.qrcode.detector.AlignmentPatternFinder;
import com.google.zxing.qrcode.detector.FinderPattern;
import com.jcraft.jzlib.GZIPHeader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;
import net.openvpn.ovpn3.XMLRPC;
import renz.javacodez.vpn.service.SSHVPNService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class bj implements g31.a, xb0$c, gb.a, ak.c, s01, bx, mh$b, mh$e, wc, ox.a {
    public static bj b;
    public static final bj zaa = new bj(7, (byte) 0);
    public final /* synthetic */ int G0;
    public Object a;

    public bj(int i) {
        this.G0 = 6;
        setup(i);
    }

    public bj(int i, byte b2) {
        Object hashSet;
        Object bjVar;
        this.G0 = i;
        if (i != 2) {
            if (i != 7) {
                if (i == 10) {
                    bjVar = new bj(8, GenericGF.QR_CODE_FIELD_256);
                } else if (i == 22) {
                    bjVar = new Stack();
                } else if (i == 19) {
                    hashSet = new ReentrantLock();
                } else if (i != 20) {
                    z21$a z21_a = new z21$a();
                    z21_a.e();
                    bjVar = z21_a;
                } else {
                    bjVar = new LinkedHashMap();
                }
                this.a = bjVar;
            }
            return;
        }
        hashSet = new HashSet();
        bjVar = hashSet;
        this.a = bjVar;
    }

    public /* synthetic */ bj(int i, Object obj) {
        this.G0 = i;
        this.a = obj;
    }

    public bj(ClipData clipData, int i) {
        this.G0 = 24;
        this.a = new ContentInfo.Builder(clipData, i);
    }

    public bj(Handler handler) {
        this.G0 = 5;
        this.a = new ExecutorDelivery$1(handler);
    }

    public bj(ContentInfo contentInfo) {
        this.G0 = 25;
        contentInfo.getClass();
        this.a = contentInfo;
    }

    public bj(EditText editText) {
        this.G0 = 16;
        this.a = new g(editText, 9);
    }

    public bj(TextView textView) {
        this.G0 = 21;
        this.a = new lq$c(textView);
    }

    public bj(GenericGF genericGF) {
        this.G0 = 9;
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.add(new GenericGFPoly(genericGF, new int[]{1}));
    }

    public static synchronized bj b() {
        try {
            if (b == null) {
                b = new bj(1, (byte) 0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0030  */
    public static /* synthetic */ void s(int i) {
        String str;
        int i2;
        if (i != 1 && i != 3 && i != 5 && i != 10 && i != 12 && i != 14 && i != 16 && i != 18 && i != 30 && i != 7 && i != 8) {
            switch (i) {
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 1 && i != 3 && i != 5 && i != 10 && i != 12 && i != 14 && i != 16 && i != 18 && i != 30 && i != 7 && i != 8) {
            switch (i) {
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
            case 14:
            case 16:
            case 18:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 30:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 6:
                objArr[0] = "kind";
                break;
            case 9:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 11:
            case 17:
                objArr[0] = "parameters";
                break;
            case 13:
                objArr[0] = "substitution";
                break;
            case 15:
                objArr[0] = "userDataKey";
                break;
            case 19:
                objArr[0] = "type";
                break;
            case 29:
                objArr[0] = "additionalAnnotations";
                break;
            default:
                objArr[0] = "owner";
                break;
        }
        if (i == 1) {
            objArr[1] = "setOwner";
        } else if (i == 3) {
            objArr[1] = "setModality";
        } else if (i == 5) {
            objArr[1] = "setVisibility";
        } else if (i == 10) {
            objArr[1] = "setName";
        } else if (i == 12) {
            objArr[1] = "setValueParameters";
        } else if (i == 14) {
            objArr[1] = "setSubstitution";
        } else if (i == 16) {
            objArr[1] = "putUserData";
        } else if (i == 18) {
            objArr[1] = "setTypeParameters";
        } else if (i == 30) {
            objArr[1] = "setAdditionalAnnotations";
        } else if (i == 7) {
            objArr[1] = "setKind";
        } else if (i != 8) {
            switch (i) {
                case 20:
                    objArr[1] = "setReturnType";
                    break;
                case 21:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 22:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 23:
                    objArr[1] = "setOriginal";
                    break;
                case 24:
                    objArr[1] = "setSignatureChange";
                    break;
                case 25:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 26:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 27:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 28:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                    break;
            }
        } else {
            objArr[1] = "setCopyOverrides";
        }
        switch (i) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
            case 14:
            case 16:
            case 18:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 30:
                break;
            case 2:
                objArr[2] = "setModality";
                break;
            case 4:
                objArr[2] = "setVisibility";
                break;
            case 6:
                objArr[2] = "setKind";
                break;
            case 9:
                objArr[2] = "setName";
                break;
            case 11:
                objArr[2] = "setValueParameters";
                break;
            case 13:
                objArr[2] = "setSubstitution";
                break;
            case 15:
                objArr[2] = "putUserData";
                break;
            case 17:
                objArr[2] = "setTypeParameters";
                break;
            case 19:
                objArr[2] = "setReturnType";
                break;
            case 29:
                objArr[2] = "setAdditionalAnnotations";
                break;
            default:
                objArr[2] = "setOwner";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 3 && i != 5 && i != 10 && i != 12 && i != 14 && i != 16 && i != 18 && i != 30 && i != 7 && i != 8) {
            switch (i) {
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    @Override // ak.c
    public Iterable Q(Object obj) {
        Collection collectionD = ((ai0) obj).h().d();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionD.iterator();
        while (it.hasNext()) {
            od odVarB = ((fc0) it.next()).L0().b();
            od odVarA = odVarB == null ? null : odVarB.a();
            ai0 ai0Var = odVarA instanceof ai0 ? (ai0) odVarA : null;
            xc0 xc0VarF = ai0Var != null ? ((a80) this.a).f(ai0Var) : null;
            if (xc0VarF != null) {
                arrayList.add(xc0VarF);
            }
        }
        return arrayList;
    }

    public ai0 a(qt0 qt0Var) {
        cv cvVarE = qt0Var.e();
        Class cls = qt0Var.a;
        Class<?> declaringClass = cls.getDeclaringClass();
        qt0 qt0Var2 = declaringClass == null ? null : new qt0(declaringClass);
        if (qt0Var2 == null) {
            fd0 fd0Var = (fd0) he.M0(((gd0) this.a).b(cvVarE.e()));
            if (fd0Var != null) {
                hd0 hd0Var = fd0Var.p.d;
                hd0Var.getClass();
                return hd0Var.v(ij0.f(cls.getSimpleName()), qt0Var);
            }
        } else {
            ai0 ai0VarA = a(qt0Var2);
            vg0 vg0VarV = ai0VarA == null ? null : ai0VarA.V();
            od odVarE = vg0VarV == null ? null : vg0VarV.e(ij0.f(cls.getSimpleName()), dl0.n);
            if (odVarE instanceof ai0) {
                return (ai0) odVarE;
            }
        }
        return null;
    }

    @Override // defpackage.mh$e
    public ContentInfo a() {
        return (ContentInfo) this.a;
    }

    @Override // ox.a
    public ox.a a(List list) {
        return this;
    }

    @Override // defpackage.wc
    public vc a(dd ddVar) {
        vc vcVarA;
        cv cvVarH = ddVar.h();
        ao0 ao0Var = (ao0) this.a;
        ArrayList<wn0> arrayList = new ArrayList();
        e.k(ao0Var, cvVarH, arrayList);
        for (wn0 wn0Var : arrayList) {
            if ((wn0Var instanceof v9) && (vcVarA = ((v9) wn0Var).p.a(ddVar)) != null) {
                return vcVarA;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized z21$a m3a() {
        return (z21$a) this.a;
    }

    @Override // defpackage.xb0$c
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo4a() {
    }

    @Override // defpackage.mh$b
    public void a(Uri uri) {
        ((ContentInfo.Builder) this.a).setLinkUri(uri);
    }

    public void a(fa faVar) {
        if (!faVar.i()) {
            if (!(faVar instanceof lw0)) {
                String strValueOf = String.valueOf(faVar.getClass());
                throw new IllegalArgumentException(fb$1.m(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
            }
            lw0 lw0Var = (lw0) faVar;
            a(lw0Var.d);
            a(lw0Var.f);
            return;
        }
        int size = faVar.size();
        int[] iArr = lw0.n;
        int iBinarySearch = Arrays.binarySearch(iArr, size);
        if (iBinarySearch < 0) {
            iBinarySearch = (-(iBinarySearch + 1)) - 1;
        }
        int i = iArr[iBinarySearch + 1];
        Stack stack = (Stack) this.a;
        if (stack.isEmpty() || ((fa) stack.peek()).size() >= i) {
            stack.push(faVar);
            return;
        }
        int i2 = iArr[iBinarySearch];
        fa lw0Var2 = (fa) stack.pop();
        while (!stack.isEmpty() && ((fa) stack.peek()).size() < i2) {
            lw0Var2 = new lw0((fa) stack.pop(), lw0Var2);
        }
        lw0 lw0Var3 = new lw0(lw0Var2, faVar);
        while (!stack.isEmpty()) {
            int[] iArr2 = lw0.n;
            int iBinarySearch2 = Arrays.binarySearch(iArr2, lw0Var3.c);
            if (iBinarySearch2 < 0) {
                iBinarySearch2 = (-(iBinarySearch2 + 1)) - 1;
            }
            if (((fa) stack.peek()).size() >= iArr2[iBinarySearch2 + 1]) {
                break;
            } else {
                lw0Var3 = new lw0((fa) stack.pop(), lw0Var3);
            }
        }
        stack.push(lw0Var3);
    }

    @Override // g31.a
    public void a(String str) {
        SSHVPNService sSHVPNService = ((bk) this.a).c;
        if (sSHVPNService != null) {
            sSHVPNService.e(str);
        }
    }

    public boolean a(qz qzVar, int i, Bundle bundle) {
        p5 p5Var = (p5) this.a;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 25 && (i & 1) != 0) {
            try {
                ((q20$c) qzVar.a).mo20c();
                Parcelable parcelable = (Parcelable) ((q20$c) qzVar.a).a();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception unused) {
                return false;
            }
        }
        ClipDescription description = ((q20$c) qzVar.a).getDescription();
        q20$c q20_c = (q20$c) qzVar.a;
        ClipData clipData = new ClipData(description, new ClipData.Item(q20_c.b()));
        mh$b bjVar = i2 >= 31 ? new bj(clipData, 2) : new mh$c(clipData, 2);
        bjVar.a(q20_c.mo15d());
        bjVar.setExtras(bundle);
        return qd1.h(p5Var, bjVar.build()) == null;
    }

    @Override // defpackage.mh$e
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public ClipData mo5b() {
        return ((ContentInfo) this.a).getClip();
    }

    public Object b(uc ucVar, Object obj) {
        uc ucVarE;
        if (this.G0 == 0) {
            return e(ucVar, obj);
        }
        boolean z = ucVar.J;
        StringBuilder sb = (StringBuilder) obj;
        nm nmVar = (nm) this.a;
        nmVar.G(sb, ucVar, null);
        um umVar = nmVar.c;
        vm vmVar = umVar.z;
        ja0[] ja0VarArr = um.W;
        ja0 ja0Var = ja0VarArr[13];
        boolean z2 = (((Boolean) umVar.o.a).booleanValue() || ucVar.e0().p() != zh0.c) && nmVar.i0(ucVar.getVisibility(), sb);
        nmVar.M(sb, ucVar);
        ja0 ja0Var2 = ja0VarArr[39];
        boolean z3 = ((Boolean) umVar.O.a).booleanValue() || !z || z2;
        if (z3) {
            sb.append(nmVar.L("constructor"));
        }
        pd pdVarB = ucVar.b();
        ja0 ja0Var3 = ja0VarArr[24];
        if (((Boolean) vmVar.a).booleanValue()) {
            if (z3) {
                sb.append(" ");
            }
            nmVar.R(pdVarB, sb, true);
            nmVar.e0(sb, ucVar.getTypeParameters(), false);
        }
        nmVar.h0(sb, ucVar.f(), ucVar.h0());
        ja0 ja0Var4 = ja0VarArr[15];
        if (((Boolean) umVar.q.a).booleanValue() && !z && (ucVarE = ((ai0) pdVarB).E()) != null) {
            List listF = ucVarE.f();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : listF) {
                wc1 wc1Var = (wc1) obj2;
                if (!wc1Var.B0() && wc1Var.p == null) {
                    arrayList.add(obj2);
                }
            }
            if (!arrayList.isEmpty()) {
                sb.append(" : ");
                sb.append(nmVar.L("this"));
                sb.append(he.R0(arrayList, ", ", "(", ")", p0.b$4, 24));
            }
        }
        ja0 ja0Var5 = um.W[24];
        if (((Boolean) vmVar.a).booleanValue()) {
            nmVar.j0(ucVar.getTypeParameters(), sb);
        }
        return tb1.a;
    }

    @Override // ox.a
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public ox.a mo6b() {
        return this;
    }

    @Override // defpackage.xb0$c
    public xb0$a b(dd ddVar, at0 at0Var) {
        if (!ddVar.equals(q70.b)) {
            return null;
        }
        ((xs0) this.a).b = true;
        return null;
    }

    @Override // defpackage.mh$b
    public void b(int i) {
        ((ContentInfo.Builder) this.a).setFlags(i);
    }

    @Override // defpackage.mh$b
    public bj build() {
        return new bj(26, new bj(((ContentInfo.Builder) this.a).build()));
    }

    @Override // ox.a
    /* JADX INFO: renamed from: build, reason: collision with other method in class */
    public ox mo7build() {
        return (nr) this.a;
    }

    @Override // defpackage.mh$e
    public int c() {
        return ((ContentInfo) this.a).getFlags();
    }

    @Override // ox.a
    public ox.a c(cn.d dVar) {
        return this;
    }

    public float calculateModuleSizeOneWay(FinderPattern finderPattern, FinderPattern finderPattern2) {
        int i = (int) finderPattern.x;
        int i2 = (int) finderPattern.y;
        int i3 = (int) finderPattern2.x;
        int i4 = (int) finderPattern2.y;
        float fSizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays(i, i2, i3, i4);
        float fSizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) finderPattern2.x, i4, (int) finderPattern.x, i2);
        if (Float.isNaN(fSizeOfBlackWhiteBlackRunBothWays)) {
            return fSizeOfBlackWhiteBlackRunBothWays2 / 7.0f;
        }
        return Float.isNaN(fSizeOfBlackWhiteBlackRunBothWays2) ? fSizeOfBlackWhiteBlackRunBothWays / 7.0f : (fSizeOfBlackWhiteBlackRunBothWays + fSizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x01e4  */
    public Object d(ai0 ai0Var, StringBuilder sb) {
        StringBuilder sb2;
        uc ucVarE;
        int iV;
        String str;
        nm nmVar = (nm) this.a;
        nmVar.getClass();
        boolean z = ai0Var.v() == 4;
        int i = 2;
        if (!nmVar.z()) {
            nmVar.G(sb, ai0Var, null);
            if (!z) {
                nmVar.i0(ai0Var.getVisibility(), sb);
            }
            if ((ai0Var.v() != 2 || ai0Var.p() != zh0.f) && (((iV = ai0Var.v()) != 6 && iV != 4) || ai0Var.p() != zh0.b)) {
                nmVar.O(ai0Var.p(), sb, nm.D(ai0Var));
            }
            nmVar.N(ai0Var, sb);
            nmVar.Q(sb, nmVar.y().contains(sm.n) && ai0Var.B(), "inner");
            nmVar.Q(sb, nmVar.y().contains(sm.p) && ai0Var.I0(), XMLRPC.TAG_DATA);
            nmVar.Q(sb, nmVar.y().contains(sm.q) && ai0Var.r(), "inline");
            nmVar.Q(sb, nmVar.y().contains(sm.w) && ai0Var.k0(), XMLRPC.TAG_VALUE);
            nmVar.Q(sb, nmVar.y().contains(sm.v) && ai0Var.f0(), "fun");
            if (ai0Var.c0()) {
                str = "companion object";
            } else {
                int iU = ak.u(ai0Var.v());
                if (iU == 0) {
                    str = "class";
                } else if (iU == 1) {
                    str = "interface";
                } else if (iU == 2) {
                    str = "enum class";
                } else if (iU == 3) {
                    str = "enum entry";
                } else if (iU == 4) {
                    str = "annotation class";
                } else {
                    if (iU != 5) {
                        d.AnonymousClass0.m();
                        return null;
                    }
                    str = "object";
                }
            }
            sb.append(nmVar.L(str));
        }
        boolean zL = xm.l(ai0Var);
        um umVar = nmVar.c;
        if (zL) {
            vm vmVar = umVar.F;
            ja0 ja0Var = um.W[30];
            if (((Boolean) vmVar.a).booleanValue()) {
                if (nmVar.z()) {
                    sb.append("companion object");
                }
                nm.Z(sb);
                ok okVarB = ai0Var.b();
                if (okVarB != null) {
                    sb.append("of ");
                    sb.append(nmVar.r(okVarB.getName(), false));
                }
            }
            if (nmVar.C() || !e4.a(ai0Var.getName(), f21.b)) {
                if (!nmVar.z()) {
                    nm.Z(sb);
                }
                sb.append(nmVar.r(ai0Var.getName(), true));
            }
        } else {
            if (!nmVar.z()) {
                nm.Z(sb);
            }
            nmVar.R(ai0Var, sb, true);
        }
        if (!z) {
            List listO = ai0Var.o();
            nmVar.e0(sb, listO, false);
            nmVar.H(ai0Var, sb);
            int iV2 = ai0Var.v();
            if (iV2 != 6 && iV2 != 4) {
                vm vmVar2 = umVar.i;
                ja0 ja0Var2 = um.W[7];
                if (((Boolean) vmVar2.a).booleanValue() && (ucVarE = ai0Var.E()) != null) {
                    sb.append(" ");
                    nmVar.G(sb, ucVarE, null);
                    nmVar.i0(ucVarE.getVisibility(), sb);
                    sb.append(nmVar.L("constructor"));
                    nmVar.h0(sb, ucVarE.f(), ucVarE.h0());
                }
            }
            vm vmVar3 = umVar.w;
            ja0 ja0Var3 = um.W[21];
            if (((Boolean) vmVar3.a).booleanValue() || ub0.F(ai0Var.n())) {
                sb2 = sb;
            } else {
                Collection collectionD = ai0Var.h().d();
                if (collectionD.isEmpty() || (collectionD.size() == 1 && ub0.y((fc0) collectionD.iterator().next()))) {
                    sb2 = sb;
                } else {
                    nm.Z(sb);
                    sb.append(": ");
                    sb2 = sb;
                    he.P0(collectionD, sb2, null, null, new om(nmVar, i), 60);
                }
            }
            nmVar.j0(listO, sb2);
        }
        return tb1.a;
    }

    @Override // ox.a
    public ox.a d(sc0 sc0Var) {
        return this;
    }

    public DecoderResult decode(Response response, Map map) throws ChecksumException, FormatException {
        char c;
        Mode mode;
        Mode mode2;
        Mode mode3;
        Mode mode4;
        int bits;
        int i;
        int i2;
        Version version = response.readVersion();
        ErrorCorrectionLevel errorCorrectionLevel = response.readFormatInformation().errorCorrectionLevel;
        FormatInformation formatInformation = response.readFormatInformation();
        Version version2 = response.readVersion();
        DataMask dataMask = DataMask.values()[formatInformation.dataMask];
        BitMatrix bitMatrix = (BitMatrix) response.cacheEntry;
        int i3 = bitMatrix.height;
        dataMask.getClass();
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            for (int i6 = 0; i6 < i3; i6++) {
                if (dataMask.isMasked(i5, i6)) {
                    bitMatrix.flip(i6, i5);
                }
            }
        }
        int i7 = version2.versionNumber * 4;
        int i8 = i7 + 17;
        int i9 = version2.totalCodewords;
        BitMatrix bitMatrix2 = new BitMatrix(i8, i8);
        bitMatrix2.setRegion(0, 0, 9, 9);
        int i10 = i7 + 9;
        bitMatrix2.setRegion(i10, 0, 8, 9);
        bitMatrix2.setRegion(0, i10, 9, 8);
        int[] iArr = version2.alignmentPatternCenters;
        int length = iArr.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = iArr[i11] - 2;
            for (int i13 = i4; i13 < length; i13++) {
                if ((i11 != 0 || (i13 != 0 && i13 != length - 1)) && (i11 != length - 1 || i13 != 0)) {
                    bitMatrix2.setRegion(iArr[i13] - 2, i12, 5, 5);
                }
            }
            i11++;
            i4 = 0;
        }
        int i14 = 6;
        bitMatrix2.setRegion(6, 9, 1, i7);
        bitMatrix2.setRegion(9, 6, i7, 1);
        if (version2.versionNumber > 6) {
            int i15 = i7 + 6;
            bitMatrix2.setRegion(i15, 0, 3, 6);
            bitMatrix2.setRegion(0, i15, 6, 3);
        }
        byte[] bArr = new byte[i9];
        int i16 = i3 - 1;
        int i17 = i16;
        boolean z = true;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        while (true) {
            int i21 = 2;
            if (i17 <= 0) {
                break;
            }
            if (i17 == i14) {
                i17--;
            }
            int i22 = 0;
            while (i22 < i3) {
                int i23 = z ? i16 - i22 : i22;
                int i24 = 0;
                while (i24 < i21) {
                    int i25 = i17 - i24;
                    if (!bitMatrix2.get(i25, i23)) {
                        i19++;
                        i20 <<= 1;
                        if (bitMatrix.get(i25, i23)) {
                            i20 |= 1;
                        }
                        if (i19 == 8) {
                            bArr[i18] = (byte) i20;
                            i18++;
                            i19 = 0;
                            i20 = 0;
                        }
                    }
                    i24++;
                    i21 = 2;
                }
                i22++;
                i21 = 2;
            }
            z = !z;
            i17 -= 2;
            i14 = 6;
        }
        if (i18 != i9) {
            throw FormatException.getFormatInstance();
        }
        if (i9 != version.totalCodewords) {
            throw new IllegalArgumentException();
        }
        ha haVar = version.ecBlocks[errorCorrectionLevel.ordinal()];
        hk0[] hk0VarArr = (hk0[]) haVar.a;
        int i26 = haVar.b;
        int i27 = 0;
        for (hk0 hk0Var : hk0VarArr) {
            i27 += hk0Var.a;
        }
        ha[] haVarArr = new ha[i27];
        int i28 = 0;
        for (hk0 hk0Var2 : hk0VarArr) {
            int i29 = 0;
            while (i29 < hk0Var2.a) {
                int i30 = hk0Var2.b;
                haVarArr[i28] = new ha(i30, new byte[i26 + i30], 1);
                i29++;
                i28++;
                errorCorrectionLevel = errorCorrectionLevel;
            }
        }
        ErrorCorrectionLevel errorCorrectionLevel2 = errorCorrectionLevel;
        int length2 = ((byte[]) haVarArr[0].a).length;
        int i31 = i27 - 1;
        while (i31 >= 0 && ((byte[]) haVarArr[i31].a).length != length2) {
            i31--;
        }
        int i32 = i31 + 1;
        int i33 = length2 - i26;
        int i34 = 0;
        int i35 = 0;
        while (i34 < i33) {
            int i36 = i35;
            int i37 = 0;
            while (i37 < i28) {
                ((byte[]) haVarArr[i37].a)[i34] = bArr[i36];
                i37++;
                i36++;
            }
            i34++;
            i35 = i36;
        }
        int i38 = i32;
        while (i38 < i28) {
            ((byte[]) haVarArr[i38].a)[i33] = bArr[i35];
            i38++;
            i35++;
        }
        int length3 = ((byte[]) haVarArr[0].a).length;
        while (i33 < length3) {
            int i39 = i35;
            int i40 = 0;
            while (i40 < i28) {
                ((byte[]) haVarArr[i40].a)[i40 < i32 ? i33 : i33 + 1] = bArr[i39];
                i40++;
                i39++;
            }
            i33++;
            i35 = i39;
        }
        int i41 = 0;
        for (int i42 = 0; i42 < i27; i42++) {
            i41 += haVarArr[i42].b;
        }
        byte[] bArr2 = new byte[i41];
        int i43 = 0;
        for (int i44 = 0; i44 < i27; i44++) {
            ha haVar2 = haVarArr[i44];
            byte[] bArr3 = (byte[]) haVar2.a;
            int i45 = haVar2.b;
            int length4 = bArr3.length;
            int[] iArr2 = new int[length4];
            for (int i46 = 0; i46 < length4; i46++) {
                iArr2[i46] = bArr3[i46] & GZIPHeader.OS_UNKNOWN;
            }
            try {
                ((bj) this.a).decode(iArr2, bArr3.length - i45);
                for (int i47 = 0; i47 < i45; i47++) {
                    bArr3[i47] = (byte) iArr2[i47];
                }
                int i48 = 0;
                while (i48 < i45) {
                    bArr2[i43] = bArr3[i48];
                    i48++;
                    i43++;
                }
            } catch (ReedSolomonException unused) {
                ChecksumException checksumException = ChecksumException.INSTANCE;
                if (ReaderException.isStackTrace) {
                    throw new ChecksumException();
                }
                throw ChecksumException.INSTANCE;
            }
        }
        char[] cArr = DecodedBitStreamParser.ALPHANUMERIC_CHARS;
        yg$a yg_a = new yg$a(bArr2);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int bits2 = -1;
        int bits3 = -1;
        boolean z2 = false;
        CharacterSetECI characterSetECI = null;
        do {
            try {
                if (yg_a.available() < 4) {
                    mode2 = Mode.TERMINATOR;
                    c = '\t';
                } else {
                    int bits4 = yg_a.readBits(4);
                    if (bits4 == 0) {
                        c = '\t';
                        mode = Mode.TERMINATOR;
                    } else if (bits4 == 1) {
                        c = '\t';
                        mode = Mode.NUMERIC;
                    } else if (bits4 == 2) {
                        c = '\t';
                        mode = Mode.ALPHANUMERIC;
                    } else if (bits4 == 3) {
                        c = '\t';
                        mode = Mode.STRUCTURED_APPEND;
                    } else if (bits4 == 4) {
                        c = '\t';
                        mode = Mode.BYTE;
                    } else if (bits4 == 5) {
                        c = '\t';
                        mode = Mode.FNC1_FIRST_POSITION;
                    } else if (bits4 == 7) {
                        c = '\t';
                        mode = Mode.ECI;
                    } else if (bits4 != 8) {
                        c = '\t';
                        if (bits4 == 9) {
                            mode = Mode.FNC1_SECOND_POSITION;
                        } else {
                            if (bits4 != 13) {
                                Mode[] modeArr = Mode.$VALUES;
                                throw new IllegalArgumentException();
                            }
                            mode = Mode.HANZI;
                        }
                    } else {
                        c = '\t';
                        mode = Mode.KANJI;
                    }
                    mode2 = mode;
                }
                mode3 = mode2;
                mode4 = Mode.TERMINATOR;
                if (mode3 != mode4) {
                    if (mode3 == Mode.FNC1_FIRST_POSITION || mode3 == Mode.FNC1_SECOND_POSITION) {
                        z2 = true;
                    } else if (mode3 == Mode.STRUCTURED_APPEND) {
                        if (yg_a.available() < 16) {
                            throw FormatException.getFormatInstance();
                        }
                        bits2 = yg_a.readBits(8);
                        bits3 = yg_a.readBits(8);
                    } else if (mode3 == Mode.ECI) {
                        int bits5 = yg_a.readBits(8);
                        if ((bits5 & 128) == 0) {
                            i2 = bits5 & 127;
                        } else {
                            if ((bits5 & 192) == 128) {
                                bits = yg_a.readBits(8);
                                i = (bits5 & 63) << 8;
                            } else {
                                if ((bits5 & 224) != 192) {
                                    throw FormatException.getFormatInstance();
                                }
                                bits = yg_a.readBits(16);
                                i = (bits5 & 31) << 16;
                            }
                            i2 = i | bits;
                        }
                        CharacterSetECI[] characterSetECIArr = CharacterSetECI.$VALUES;
                        if (i2 < 0 || i2 >= 900) {
                            throw FormatException.getFormatInstance();
                        }
                        characterSetECI = (CharacterSetECI) CharacterSetECI.VALUE_TO_ECI.get(Integer.valueOf(i2));
                        if (characterSetECI == null) {
                            throw FormatException.getFormatInstance();
                        }
                    } else if (mode3 == Mode.HANZI) {
                        int bits6 = yg_a.readBits(4);
                        int bits7 = yg_a.readBits(mode3.getCharacterCountBits(version));
                        if (bits6 == 1) {
                            DecodedBitStreamParser.decodeHanziSegment(yg_a, sb, bits7);
                        }
                    } else {
                        int bits8 = yg_a.readBits(mode3.getCharacterCountBits(version));
                        if (mode3 == Mode.NUMERIC) {
                            DecodedBitStreamParser.decodeNumericSegment(yg_a, sb, bits8);
                        } else if (mode3 == Mode.ALPHANUMERIC) {
                            DecodedBitStreamParser.decodeAlphanumericSegment(yg_a, sb, bits8, z2);
                        } else if (mode3 == Mode.BYTE) {
                            DecodedBitStreamParser.decodeByteSegment(yg_a, sb, bits8, characterSetECI, arrayList, map);
                        } else {
                            if (mode3 != Mode.KANJI) {
                                throw FormatException.getFormatInstance();
                            }
                            DecodedBitStreamParser.decodeKanjiSegment(yg_a, sb, bits8);
                        }
                    }
                }
            } catch (IllegalArgumentException unused2) {
                throw FormatException.getFormatInstance();
            }
        } while (mode3 != mode4);
        int i49 = bits2;
        String string = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new DecoderResult(bArr2, string, arrayList, errorCorrectionLevel2.toString(), i49, bits3);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002b A[Catch: ChecksumException -> 0x0043, FormatException -> 0x0045, TryCatch #3 {ChecksumException -> 0x0043, FormatException -> 0x0045, blocks: (B:9:0x0012, B:10:0x0027, B:12:0x002b, B:13:0x002e, B:15:0x0032, B:17:0x003c, B:22:0x0047, B:24:0x004c), top: B:33:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0032 A[Catch: ChecksumException -> 0x0043, FormatException -> 0x0045, TryCatch #3 {ChecksumException -> 0x0043, FormatException -> 0x0045, blocks: (B:9:0x0012, B:10:0x0027, B:12:0x002b, B:13:0x002e, B:15:0x0032, B:17:0x003c, B:22:0x0047, B:24:0x004c), top: B:33:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x003c A[Catch: ChecksumException -> 0x0043, FormatException -> 0x0045, TryCatch #3 {ChecksumException -> 0x0043, FormatException -> 0x0045, blocks: (B:9:0x0012, B:10:0x0027, B:12:0x002b, B:13:0x002e, B:15:0x0032, B:17:0x003c, B:22:0x0047, B:24:0x004c), top: B:33:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x005c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x005e  */
    /* JADX WARN: Code duplicated, block: B:29:0x005f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x0047 A[SYNTHETIC] */
    public DecoderResult decode(BitMatrix bitMatrix, Map map) throws Throwable {
        FormatException formatException;
        ChecksumException e;
        BitMatrix bitMatrix2;
        int i;
        int i2;
        Response response = new Response(bitMatrix, 2);
        try {
            return decode(response, map);
        } catch (ChecksumException e2) {
            e = e2;
            formatException = null;
            try {
                response.remask();
                response.result = null;
                response.error = null;
                response.intermediate = true;
                response.readVersion();
                response.readFormatInformation();
                bitMatrix2 = (BitMatrix) response.cacheEntry;
                i = 0;
                while (i < bitMatrix2.width) {
                    int i3 = i + 1;
                    for (i2 = i3; i2 < bitMatrix2.height; i2++) {
                        if (bitMatrix2.get(i, i2) != bitMatrix2.get(i2, i)) {
                            bitMatrix2.flip(i2, i);
                            bitMatrix2.flip(i, i2);
                        }
                    }
                    i = i3;
                }
                DecoderResult decoderResultDecode = decode(response, map);
                decoderResultDecode.other = new HurlStack(12);
                return decoderResultDecode;
            } catch (ChecksumException e3) {
                e = e3;
                if (formatException == null) {
                    throw formatException;
                }
                if (e != null) {
                    throw e;
                }
                throw e;
            } catch (FormatException e4) {
                e = e4;
                if (formatException == null) {
                    throw formatException;
                }
                if (e != null) {
                    throw e;
                }
                throw e;
            }
        } catch (FormatException e5) {
            formatException = e5;
            e = null;
            response.remask();
            response.result = null;
            response.error = null;
            response.intermediate = true;
            response.readVersion();
            response.readFormatInformation();
            bitMatrix2 = (BitMatrix) response.cacheEntry;
            i = 0;
            while (i < bitMatrix2.width) {
                int i4 = i + 1;
                while (i2 < bitMatrix2.height) {
                    if (bitMatrix2.get(i, i2) != bitMatrix2.get(i2, i)) {
                        bitMatrix2.flip(i2, i);
                        bitMatrix2.flip(i, i2);
                    }
                }
                i = i4;
            }
            DecoderResult decoderResultDecode2 = decode(response, map);
            decoderResultDecode2.other = new HurlStack(12);
            return decoderResultDecode2;
        }
    }

    public void decode(int[] iArr, int i) throws ReedSolomonException {
        int[] iArr2;
        GenericGF genericGF = (GenericGF) this.a;
        GenericGFPoly genericGFPoly = new GenericGFPoly(genericGF, iArr);
        int[] iArr3 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            int iEvaluateAt = genericGFPoly.evaluateAt(genericGF.expTable[genericGF.generatorBase + i2]);
            iArr3[(i - 1) - i2] = iEvaluateAt;
            if (iEvaluateAt != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        GenericGFPoly genericGFPoly2 = new GenericGFPoly(genericGF, iArr3);
        GenericGFPoly genericGFPolyBuildMonomial = genericGF.buildMonomial(i, 1);
        GenericGFPoly genericGFPoly3 = genericGF.zero;
        if (genericGFPolyBuildMonomial.getDegree() < genericGFPoly2.getDegree()) {
            genericGFPolyBuildMonomial = genericGFPoly2;
            genericGFPoly2 = genericGFPolyBuildMonomial;
        }
        GenericGFPoly genericGFPoly4 = genericGF.one;
        GenericGFPoly genericGFPoly5 = genericGFPoly3;
        while (genericGFPoly2.getDegree() >= i / 2) {
            if (genericGFPoly2.isZero()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            int iInverse = genericGF.inverse(genericGFPoly2.getCoefficient(genericGFPoly2.getDegree()));
            GenericGFPoly genericGFPolyAddOrSubtract = genericGFPoly3;
            while (genericGFPolyBuildMonomial.getDegree() >= genericGFPoly2.getDegree() && !genericGFPolyBuildMonomial.isZero()) {
                int degree = genericGFPolyBuildMonomial.getDegree() - genericGFPoly2.getDegree();
                int iMultiply = genericGF.multiply(genericGFPolyBuildMonomial.getCoefficient(genericGFPolyBuildMonomial.getDegree()), iInverse);
                genericGFPolyAddOrSubtract = genericGFPolyAddOrSubtract.addOrSubtract(genericGF.buildMonomial(degree, iMultiply));
                genericGFPolyBuildMonomial = genericGFPolyBuildMonomial.addOrSubtract(genericGFPoly2.multiplyByMonomial(degree, iMultiply));
            }
            GenericGFPoly genericGFPolyAddOrSubtract2 = genericGFPolyAddOrSubtract.multiply(genericGFPoly4).addOrSubtract(genericGFPoly5);
            if (genericGFPolyBuildMonomial.getDegree() >= genericGFPoly2.getDegree()) {
                d.AnonymousClass0.m("Division algorithm failed to reduce polynomial?");
                return;
            }
            GenericGFPoly genericGFPoly6 = genericGFPolyBuildMonomial;
            genericGFPolyBuildMonomial = genericGFPoly2;
            genericGFPoly2 = genericGFPoly6;
            genericGFPoly5 = genericGFPoly4;
            genericGFPoly4 = genericGFPolyAddOrSubtract2;
        }
        int coefficient = genericGFPoly4.getCoefficient(0);
        if (coefficient == 0) {
            throw new ReedSolomonException("sigmaTilde(0) was zero");
        }
        int iInverse2 = genericGF.inverse(coefficient);
        GenericGFPoly[] genericGFPolyArr = {genericGFPoly4.multiply(iInverse2), genericGFPoly2.multiply(iInverse2)};
        GenericGFPoly genericGFPoly7 = genericGFPolyArr[0];
        GenericGFPoly genericGFPoly8 = genericGFPolyArr[1];
        int degree2 = genericGFPoly7.getDegree();
        if (degree2 == 1) {
            iArr2 = new int[]{genericGFPoly7.getCoefficient(1)};
        } else {
            int[] iArr4 = new int[degree2];
            int i3 = 0;
            for (int i4 = 1; i4 < genericGF.size && i3 < degree2; i4++) {
                if (genericGFPoly7.evaluateAt(i4) == 0) {
                    iArr4[i3] = genericGF.inverse(i4);
                    i3++;
                }
            }
            if (i3 != degree2) {
                throw new ReedSolomonException("Error locator degree does not match number of roots");
            }
            iArr2 = iArr4;
        }
        int length = iArr2.length;
        int[] iArr5 = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            int iInverse3 = genericGF.inverse(iArr2[i5]);
            int iMultiply2 = 1;
            for (int i6 = 0; i6 < length; i6++) {
                if (i5 != i6) {
                    int iMultiply3 = genericGF.multiply(iArr2[i6], iInverse3);
                    iMultiply2 = genericGF.multiply(iMultiply2, (iMultiply3 & 1) == 0 ? iMultiply3 | 1 : iMultiply3 & (-2));
                }
            }
            int iMultiply4 = genericGF.multiply(genericGFPoly8.evaluateAt(iInverse3), genericGF.inverse(iMultiply2));
            iArr5[i5] = iMultiply4;
            if (genericGF.generatorBase != 0) {
                iArr5[i5] = genericGF.multiply(iMultiply4, iInverse3);
            }
        }
        for (int i7 = 0; i7 < iArr2.length; i7++) {
            int length2 = iArr.length - 1;
            int i8 = iArr2[i7];
            if (i8 == 0) {
                throw new IllegalArgumentException();
            }
            int i9 = length2 - genericGF.logTable[i8];
            if (i9 < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[i9] = iArr[i9] ^ iArr5[i7];
        }
    }

    public Object e(ox oxVar, Object obj) {
        if (this.G0 != 0) {
            n(oxVar, (StringBuilder) obj);
            return tb1.a;
        }
        return new v90((p90) this.a, oxVar);
    }

    @Override // ox.a
    public ox.a f() {
        return this;
    }

    public AlignmentPattern findAlignmentInRegion(float f, float f2, int i, int i2) throws NotFoundException {
        AlignmentPattern alignmentPatternHandlePossibleCenter;
        AlignmentPattern alignmentPatternHandlePossibleCenter2;
        int i3 = (int) (f2 * f);
        int iMax = Math.max(0, i - i3);
        BitMatrix bitMatrix = (BitMatrix) this.a;
        int iMin = Math.min(bitMatrix.width - 1, i + i3) - iMax;
        float f3 = 3.0f * f;
        if (iMin < f3) {
            throw NotFoundException.INSTANCE;
        }
        int iMax2 = Math.max(0, i2 - i3);
        int iMin2 = Math.min(bitMatrix.height - 1, i2 + i3) - iMax2;
        if (iMin2 < f3) {
            throw NotFoundException.INSTANCE;
        }
        BitMatrix bitMatrix2 = (BitMatrix) this.a;
        AlignmentPatternFinder alignmentPatternFinder = new AlignmentPatternFinder(bitMatrix2, iMax, iMax2, iMin, iMin2, f);
        int i4 = alignmentPatternFinder.width;
        int i5 = alignmentPatternFinder.startX;
        int i6 = i4 + i5;
        int i7 = alignmentPatternFinder.height;
        int i8 = (i7 / 2) + alignmentPatternFinder.startY;
        int[] iArr = new int[3];
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = ((i9 & 1) == 0 ? (i9 + 1) / 2 : -((i9 + 1) / 2)) + i8;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i11 = i5;
            while (i11 < i6 && !bitMatrix2.get(i11, i10)) {
                i11++;
            }
            int i12 = 0;
            while (i11 < i6) {
                if (!bitMatrix2.get(i11, i10)) {
                    if (i12 == 1) {
                        i12++;
                    }
                    iArr[i12] = iArr[i12] + 1;
                } else if (i12 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i12 != 2) {
                    i12++;
                    iArr[i12] = iArr[i12] + 1;
                } else {
                    if (alignmentPatternFinder.foundPatternCross(iArr) && (alignmentPatternHandlePossibleCenter2 = alignmentPatternFinder.handlePossibleCenter(i10, i11, iArr)) != null) {
                        return alignmentPatternHandlePossibleCenter2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i12 = 1;
                }
                i11++;
            }
            if (alignmentPatternFinder.foundPatternCross(iArr) && (alignmentPatternHandlePossibleCenter = alignmentPatternFinder.handlePossibleCenter(i10, i6, iArr)) != null) {
                return alignmentPatternHandlePossibleCenter;
            }
        }
        ArrayList arrayList = alignmentPatternFinder.possibleCenters;
        if (arrayList.isEmpty()) {
            throw NotFoundException.INSTANCE;
        }
        return (AlignmentPattern) arrayList.get(0);
    }

    @Override // defpackage.mh$e
    public int g() {
        return ((ContentInfo) this.a).getSource();
    }

    @Override // ox.a
    public ox.a g(s4 s4Var) {
        return this;
    }

    @Override // ox.a
    public ox.a h() {
        return this;
    }

    @Override // ox.a
    public ox.a i(zh0 zh0Var) {
        return this;
    }

    @Override // defpackage.bx
    public Object invoke(Object obj, Object obj2) {
        int iL0 = q31.l0(((Integer) obj2).intValue(), (CharSequence) obj, false, (char[]) this.a);
        if (iL0 < 0) {
            return null;
        }
        return new jo0(Integer.valueOf(iL0), 1);
    }

    @Override // ox.a
    public ox.a j() {
        return this;
    }

    @Override // ox.a
    public ox.a k() {
        return this;
    }

    @Override // ox.a
    public ox.a l(ok okVar) {
        if (okVar != null) {
            return this;
        }
        s(0);
        throw null;
    }

    @Override // defpackage.s01
    public void lock() {
        ((ReentrantLock) this.a).lock();
    }

    @Override // ox.a
    public ox.a n() {
        la.a aVar = la.a.b;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x008c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0168  */
    /* JADX WARN: Code duplicated, block: B:58:0x016f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0172  */
    public void n(ox oxVar, StringBuilder sb) {
        String strS;
        boolean z;
        nm nmVar = (nm) this.a;
        boolean z2 = nmVar.z();
        um umVar = nmVar.c;
        if (!z2) {
            vm vmVar = umVar.g;
            vm vmVar2 = umVar.N;
            vm vmVar3 = umVar.R;
            ja0[] ja0VarArr = um.W;
            ja0 ja0Var = ja0VarArr[5];
            if (!((Boolean) vmVar.a).booleanValue()) {
                nmVar.G(sb, oxVar, null);
                nmVar.i0(oxVar.getVisibility(), sb);
                nmVar.P(sb, oxVar);
                ja0 ja0Var2 = ja0VarArr[42];
                if (((Boolean) vmVar3.a).booleanValue()) {
                    nmVar.N(oxVar, sb);
                }
                nmVar.U(sb, oxVar);
                ja0 ja0Var3 = ja0VarArr[42];
                if (((Boolean) vmVar3.a).booleanValue()) {
                    boolean z3 = false;
                    if (oxVar.n0()) {
                        Collection collectionD = oxVar.d();
                        if (!collectionD.isEmpty()) {
                            Iterator it = collectionD.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (((ox) it.next()).n0()) {
                                        ja0 ja0Var4 = um.W[38];
                                        if (!((Boolean) vmVar2.a).booleanValue()) {
                                            z = false;
                                        }
                                    }
                                }
                            }
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    if (oxVar.H0()) {
                        Collection collectionD2 = oxVar.d();
                        if (!collectionD2.isEmpty()) {
                            Iterator it2 = collectionD2.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (((ox) it2.next()).H0()) {
                                        ja0 ja0Var5 = um.W[38];
                                        if (!((Boolean) vmVar2.a).booleanValue()) {
                                            break;
                                        } else {
                                            break;
                                        }
                                    }
                                }
                                z3 = true;
                                break;
                            }
                        }
                        z3 = true;
                        break;
                    }
                    nmVar.Q(sb, oxVar.D(), "tailrec");
                    nmVar.Q(sb, oxVar.isSuspend(), "suspend");
                    nmVar.Q(sb, oxVar.r(), "inline");
                    nmVar.Q(sb, z3, "infix");
                    nmVar.Q(sb, z, "operator");
                } else {
                    nmVar.Q(sb, oxVar.isSuspend(), "suspend");
                }
                nmVar.M(sb, oxVar);
                if (nmVar.C()) {
                    if (oxVar.D0()) {
                        sb.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (oxVar.F0()) {
                        sb.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb.append(nmVar.L("fun"));
            sb.append(" ");
            nmVar.e0(sb, oxVar.getTypeParameters(), true);
            nmVar.X(sb, oxVar);
        }
        nmVar.R(oxVar, sb, true);
        nmVar.h0(sb, oxVar.f(), oxVar.h0());
        nmVar.Y(sb, oxVar);
        fc0 returnType = oxVar.getReturnType();
        vm vmVar4 = umVar.l;
        ja0[] ja0VarArr2 = um.W;
        ja0 ja0Var6 = ja0VarArr2[10];
        if (!((Boolean) vmVar4.a).booleanValue()) {
            ja0 ja0Var7 = ja0VarArr2[9];
            if (((Boolean) umVar.k.a).booleanValue() || returnType == null) {
                sb.append(": ");
                if (returnType == null) {
                    strS = "[NULL]";
                } else {
                    strS = nmVar.s(returnType);
                }
                sb.append(strS);
            } else {
                ij0 ij0Var = ub0.e;
                if (!ub0.E(returnType, m21.a.d)) {
                    sb.append(": ");
                    if (returnType == null) {
                        strS = "[NULL]";
                    } else {
                        strS = nmVar.s(returnType);
                    }
                    sb.append(strS);
                }
            }
        }
        nmVar.j0(oxVar.getTypeParameters(), sb);
    }

    @Override // ox.a
    public ox.a o() {
        return this;
    }

    public void o(kq0 kq0Var, StringBuilder sb, String str) {
        nm nmVar = (nm) this.a;
        vm vmVar = nmVar.c.G;
        ja0 ja0Var = um.W[31];
        int iOrdinal = ((lq0) vmVar.a).ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                return;
            }
            n(kq0Var, sb);
        } else {
            nmVar.N(kq0Var, sb);
            sb.append(e4.j(str, " for "));
            nm.u(nmVar, kq0Var.X(), sb);
        }
    }

    @Override // gb.a
    public void onCancel() {
        ((h) this.a).cancel();
    }

    @Override // ox.a
    public ox.a p(fc0 fc0Var) {
        if (fc0Var != null) {
            return this;
        }
        s(19);
        throw null;
    }

    public void postResponse(StringRequest stringRequest, Response response, f2 f2Var) {
        int i;
        synchronized (stringRequest.mLock$1) {
            i = 1;
            stringRequest.mResponseDelivered = true;
        }
        stringRequest.addMarker("post-response");
        ((ExecutorDelivery$1) this.a).execute(new dq(stringRequest, response, f2Var, i));
    }

    @Override // ox.a
    public ox.a q(ij0 ij0Var) {
        if (ij0Var != null) {
            return this;
        }
        s(9);
        throw null;
    }

    @Override // ox.a
    public ox.a r() {
        return this;
    }

    @Override // defpackage.mh$b
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.a).setExtras(bundle);
    }

    public void setup(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public float sizeOfBlackWhiteBlackRun(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        double d;
        int i11 = 1;
        boolean z = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z) {
            i6 = i;
            i5 = i2;
            i8 = i3;
            i7 = i4;
        } else {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
        }
        int iAbs = Math.abs(i7 - i5);
        int i12 = i8 - i6;
        int iAbs2 = Math.abs(i12);
        int i13 = 2;
        int i14 = (-iAbs) / 2;
        int i15 = i5 < i7 ? 1 : -1;
        int i16 = i6 < i8 ? 1 : -1;
        int i17 = i7 + i15;
        int i18 = i5;
        int i19 = i6;
        int i20 = 0;
        while (true) {
            if (i18 == i17) {
                i9 = i5;
                i10 = i13;
                break;
            }
            boolean z2 = z;
            i9 = i5;
            if ((i20 == i11 ? i11 : 0) == ((BitMatrix) this.a).get(z ? i19 : i18, z ? i18 : i19)) {
                if (i20 == 2) {
                    int i21 = i18 - i9;
                    int i22 = i19 - i6;
                    d = (i22 * i22) + (i21 * i21);
                } else {
                    i20++;
                }
                return (float) Math.sqrt(d);
            }
            i14 += iAbs2;
            if (i14 > 0) {
                if (i19 == i8) {
                    i10 = 2;
                    break;
                }
                i19 += i16;
                i14 -= iAbs;
            }
            i18 += i15;
            i5 = i9;
            i6 = i6;
            z = z2;
            i11 = 1;
            i13 = 2;
        }
        if (i20 != i10) {
            return Float.NaN;
        }
        int i23 = i17 - i9;
        d = (i12 * i12) + (i23 * i23);
        return (float) Math.sqrt(d);
    }

    public float sizeOfBlackWhiteBlackRunBothWays(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        BitMatrix bitMatrix = (BitMatrix) this.a;
        float fSizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i, i2, i3, i4);
        int i5 = i - (i3 - i);
        int i6 = 0;
        if (i5 < 0) {
            f = i / (i - i5);
            i5 = 0;
        } else {
            int i7 = bitMatrix.width;
            if (i5 >= i7) {
                int i8 = i7 - 1;
                f = (i8 - i) / (i5 - i);
                i5 = i8;
            } else {
                f = 1.0f;
            }
        }
        float f3 = i2;
        int i9 = (int) (f3 - ((i4 - i2) * f));
        if (i9 < 0) {
            f2 = f3 / (i2 - i9);
        } else {
            int i10 = bitMatrix.height;
            if (i9 >= i10) {
                i6 = i10 - 1;
                f2 = (i6 - i2) / (i9 - i2);
            } else {
                i6 = i9;
                f2 = 1.0f;
            }
        }
        return (sizeOfBlackWhiteBlackRun(i, i2, (int) (((i5 - i) * f2) + i), i6) + fSizeOfBlackWhiteBlackRun) - 1.0f;
    }

    public String toString() {
        int i = this.G0;
        if (i != 25) {
            return i != 26 ? super.toString() : ((mh$e) this.a).toString();
        }
        return "ContentInfoCompat{" + ((ContentInfo) this.a) + "}";
    }

    @Override // defpackage.s01
    public void unlock() {
        ((ReentrantLock) this.a).unlock();
    }
}
