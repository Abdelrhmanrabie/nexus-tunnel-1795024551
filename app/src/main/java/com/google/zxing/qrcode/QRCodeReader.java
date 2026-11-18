package com.google.zxing.qrcode;

import com.android.volley.Response;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.detector.AlignmentPattern;
import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder$CenterComparator;
import defpackage.bj;
import defpackage.d;
import defpackage.fb$1;
import defpackage.g;
import defpackage.m6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class QRCodeReader {
    public static final ResultPoint[] NO_POINTS = new ResultPoint[0];
    public final bj decoder = new bj(10, (byte) 0);

    /* JADX WARN: Code duplicated, block: B:243:0x0490  */
    /* JADX WARN: Code duplicated, block: B:245:0x049b  */
    /* JADX WARN: Code duplicated, block: B:273:0x062c  */
    /* JADX WARN: Code duplicated, block: B:274:0x062f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:275:0x0631  */
    /* JADX WARN: Code duplicated, block: B:295:0x0669  */
    /* JADX WARN: Code duplicated, block: B:296:0x066c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:297:0x066e  */
    /* JADX WARN: Code duplicated, block: B:403:0x0637 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:407:0x0674 A[SYNTHETIC] */
    public final g decode(g gVar, Map map) throws Throwable {
        int i;
        FinderPattern finderPattern;
        FinderPattern finderPattern2;
        FinderPattern finderPattern3;
        float f;
        float f2;
        AlignmentPattern alignmentPatternFindAlignmentInRegion;
        float f3;
        float f4;
        float f5;
        float f6;
        int i2;
        ResultPoint[] resultPointArr;
        DecoderResult decoderResultDecode;
        ResultPoint[] resultPointArr2;
        char c;
        int iAbs;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int[] iArr2;
        int[] iArr3;
        int i6;
        bj bjVar = this.decoder;
        char c2 = 2;
        int i7 = 1;
        int i8 = 0;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            BitMatrix blackMatrix = gVar.getBlackMatrix();
            bj bjVar2 = new bj(11, blackMatrix);
            if (map != null && map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK) != null) {
                d.AnonymousClass0.m$1();
                return null;
            }
            Response response = new Response(blackMatrix, 3);
            ArrayList arrayList = (ArrayList) response.result;
            boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
            boolean z2 = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
            int i9 = blackMatrix.height;
            int i10 = blackMatrix.width;
            int i11 = (i9 * 3) / 228;
            if (i11 < 3 || z) {
                i11 = 3;
            }
            int[] iArr4 = new int[5];
            int i12 = i11 - 1;
            boolean z3 = false;
            while (i12 < i9 && !z3) {
                iArr4[0] = 0;
                iArr4[i7] = 0;
                iArr4[c2] = 0;
                iArr4[3] = 0;
                iArr4[4] = 0;
                int i13 = 0;
                int i14 = 0;
                boolean zHaveMultiplyConfirmedCenters = z3;
                while (i13 < i10) {
                    int i15 = i14 & 1;
                    if (blackMatrix.get(i13, i12)) {
                        if (i15 == i7) {
                            i14++;
                        }
                        iArr4[i14] = iArr4[i14] + i7;
                    } else if (i15 != 0) {
                        iArr4[i14] = iArr4[i14] + 1;
                    } else if (i14 == 4) {
                        if (!Response.foundPatternCross(iArr4)) {
                            int i16 = i7;
                            iArr4[0] = iArr4[2];
                            iArr4[i16] = iArr4[3];
                            iArr4[2] = iArr4[4];
                            iArr4[3] = i16;
                            iArr4[4] = 0;
                        } else if (response.handlePossibleCenter(iArr4, i12, i13, z2)) {
                            if (response.intermediate) {
                                zHaveMultiplyConfirmedCenters = response.haveMultiplyConfirmedCenters();
                            } else {
                                if (arrayList.size() <= i7) {
                                    c = 2;
                                    iAbs = 0;
                                } else {
                                    Iterator it = arrayList.iterator();
                                    FinderPattern finderPattern4 = null;
                                    while (true) {
                                        if (it.hasNext()) {
                                            FinderPattern finderPattern5 = (FinderPattern) it.next();
                                            Iterator it2 = it;
                                            if (finderPattern5.count >= 2) {
                                                if (finderPattern4 == null) {
                                                    finderPattern4 = finderPattern5;
                                                } else {
                                                    response.intermediate = true;
                                                    c = 2;
                                                    iAbs = ((int) (Math.abs(finderPattern4.x - finderPattern5.x) - Math.abs(finderPattern4.y - finderPattern5.y))) / 2;
                                                }
                                            }
                                            it = it2;
                                        } else {
                                            c = 2;
                                            iAbs = 0;
                                        }
                                    }
                                }
                                int i17 = iArr4[c];
                                if (iAbs > i17) {
                                    i12 += (iAbs - i17) - 2;
                                    i13 = i10 - 1;
                                }
                            }
                            iArr4[0] = 0;
                            iArr4[1] = 0;
                            iArr4[2] = 0;
                            iArr4[3] = 0;
                            iArr4[4] = 0;
                            i14 = 0;
                            i11 = 2;
                        } else {
                            int i18 = i7;
                            iArr4[0] = iArr4[2];
                            iArr4[i18] = iArr4[3];
                            iArr4[2] = iArr4[4];
                            iArr4[3] = i18;
                            iArr4[4] = 0;
                        }
                        i14 = 3;
                    } else {
                        i14++;
                        iArr4[i14] = iArr4[i14] + 1;
                    }
                    i13++;
                    i7 = 1;
                }
                if (Response.foundPatternCross(iArr4) && response.handlePossibleCenter(iArr4, i12, i10, z2)) {
                    int i19 = iArr4[0];
                    if (response.intermediate) {
                        zHaveMultiplyConfirmedCenters = response.haveMultiplyConfirmedCenters();
                    }
                    i11 = i19;
                }
                i12 += i11;
                z3 = zHaveMultiplyConfirmedCenters;
                c2 = 2;
                i7 = 1;
            }
            int size = arrayList.size();
            if (size < 3) {
                throw NotFoundException.INSTANCE;
            }
            if (size > 3) {
                Iterator it3 = arrayList.iterator();
                float f7 = 0.0f;
                float f8 = 0.0f;
                while (it3.hasNext()) {
                    float f9 = ((FinderPattern) it3.next()).estimatedModuleSize;
                    f7 += f9;
                    f8 += f9 * f9;
                }
                float f10 = size;
                float f11 = f7 / f10;
                float fSqrt = (float) Math.sqrt((f8 / f10) - (f11 * f11));
                Collections.sort(arrayList, new FinderPatternFinder$CenterComparator(1, f11));
                float fMax = Math.max(0.2f * f11, fSqrt);
                int i20 = 0;
                while (i20 < arrayList.size() && arrayList.size() > 3) {
                    if (Math.abs(((FinderPattern) arrayList.get(i20)).estimatedModuleSize - f11) > fMax) {
                        arrayList.remove(i20);
                        i20--;
                    }
                    i20++;
                }
            }
            int i21 = 3;
            if (arrayList.size() > 3) {
                Iterator it4 = arrayList.iterator();
                float f12 = 0.0f;
                while (it4.hasNext()) {
                    f12 += ((FinderPattern) it4.next()).estimatedModuleSize;
                }
                i = 0;
                Collections.sort(arrayList, new FinderPatternFinder$CenterComparator(0, f12 / arrayList.size()));
                i21 = 3;
                arrayList.subList(3, arrayList.size()).clear();
            } else {
                i = 0;
            }
            FinderPattern finderPattern6 = (FinderPattern) arrayList.get(i);
            FinderPattern finderPattern7 = (FinderPattern) arrayList.get(1);
            FinderPattern finderPattern8 = (FinderPattern) arrayList.get(2);
            FinderPattern[] finderPatternArr = new FinderPattern[i21];
            finderPatternArr[i] = finderPattern6;
            finderPatternArr[1] = finderPattern7;
            finderPatternArr[2] = finderPattern8;
            float fDistance = ResultPoint.distance(finderPattern6, finderPattern7);
            float fDistance2 = ResultPoint.distance(finderPatternArr[1], finderPatternArr[2]);
            float fDistance3 = ResultPoint.distance(finderPatternArr[i], finderPatternArr[2]);
            if (fDistance2 >= fDistance && fDistance2 >= fDistance3) {
                finderPattern = finderPatternArr[i];
                finderPattern2 = finderPatternArr[1];
                finderPattern3 = finderPatternArr[2];
            } else if (fDistance3 < fDistance2 || fDistance3 < fDistance) {
                finderPattern = finderPatternArr[2];
                finderPattern2 = finderPatternArr[i];
                finderPattern3 = finderPatternArr[1];
            } else {
                finderPattern = finderPatternArr[1];
                finderPattern2 = finderPatternArr[i];
                finderPattern3 = finderPatternArr[2];
            }
            float f13 = finderPattern.x;
            float f14 = finderPattern.y;
            if (((finderPattern2.y - f14) * (finderPattern3.x - f13)) - ((finderPattern2.x - f13) * (finderPattern3.y - f14)) < 0.0f) {
                FinderPattern finderPattern9 = finderPattern3;
                finderPattern3 = finderPattern2;
                finderPattern2 = finderPattern9;
            }
            finderPatternArr[0] = finderPattern2;
            finderPatternArr[1] = finderPattern;
            finderPatternArr[2] = finderPattern3;
            m6 m6Var = new m6(finderPatternArr);
            FinderPattern finderPattern10 = (FinderPattern) m6Var.b;
            FinderPattern finderPattern11 = (FinderPattern) m6Var.c;
            FinderPattern finderPattern12 = (FinderPattern) m6Var.a;
            float fCalculateModuleSizeOneWay = bjVar2.calculateModuleSizeOneWay(finderPattern10, finderPattern11);
            float f15 = finderPattern10.y;
            float f16 = finderPattern10.x;
            float f17 = finderPattern11.y;
            float f18 = finderPattern11.x;
            float fCalculateModuleSizeOneWay2 = bjVar2.calculateModuleSizeOneWay(finderPattern10, finderPattern12);
            float f19 = finderPattern12.y;
            float f20 = finderPattern12.x;
            float f21 = (fCalculateModuleSizeOneWay2 + fCalculateModuleSizeOneWay) / 2.0f;
            if (f21 < 1.0f) {
                throw NotFoundException.INSTANCE;
            }
            float fDistance4 = ResultPoint.distance(finderPattern10, finderPattern11) / f21;
            int i22 = (int) (fDistance4 + (fDistance4 < 0.0f ? -0.5f : 0.5f));
            float fDistance5 = ResultPoint.distance(finderPattern10, finderPattern12) / f21;
            int i23 = (((int) (fDistance5 + (fDistance5 >= 0.0f ? 0.5f : -0.5f))) + i22) / 2;
            int i24 = i23 + 7;
            int i25 = i24 & 3;
            if (i25 == 0) {
                i24 = i23 + 8;
            } else if (i25 == 2) {
                i24 = i23 + 6;
            } else if (i25 == 3) {
                throw NotFoundException.INSTANCE;
            }
            int i26 = i24;
            Version[] versionArr = Version.VERSIONS;
            if (i26 % 4 != 1) {
                throw FormatException.getFormatInstance();
            }
            try {
                Version versionForNumber = Version.getVersionForNumber((i26 - 17) / 4);
                int i27 = (versionForNumber.versionNumber * 4) + 10;
                if (versionForNumber.alignmentPatternCenters.length > 0) {
                    float f22 = (f17 - f15) + f19;
                    float f23 = 1.0f - (3.0f / i27);
                    int i28 = (int) (((((f18 - f16) + f20) - f16) * f23) + f16);
                    int i29 = (int) (((f22 - f15) * f23) + f15);
                    f = f16;
                    f2 = f17;
                    int i30 = 4;
                    while (true) {
                        if (i30 <= 16) {
                            try {
                                alignmentPatternFindAlignmentInRegion = bjVar2.findAlignmentInRegion(f21, i30, i28, i29);
                                break;
                            } catch (NotFoundException unused) {
                                i30 <<= 1;
                            }
                        }
                    }
                    f3 = i26 - 3.5f;
                    if (alignmentPatternFindAlignmentInRegion != null) {
                        f4 = alignmentPatternFindAlignmentInRegion.x;
                        f5 = alignmentPatternFindAlignmentInRegion.y;
                        f6 = f3 - 3.0f;
                    } else {
                        f4 = (f18 - f) + f20;
                        f5 = (f2 - f15) + f19;
                        f6 = f3;
                    }
                    float f24 = f5;
                    float f25 = finderPattern10.x;
                    float f26 = finderPattern10.y;
                    float f27 = finderPattern11.x;
                    float f28 = finderPattern11.y;
                    float f29 = finderPattern12.x;
                    float f30 = finderPattern12.y;
                    PerspectiveTransform perspectiveTransformSquareToQuadrilateral = PerspectiveTransform.squareToQuadrilateral(3.5f, 3.5f, f3, 3.5f, f6, f6, 3.5f, f3);
                    AlignmentPattern alignmentPattern = alignmentPatternFindAlignmentInRegion;
                    float f31 = perspectiveTransformSquareToQuadrilateral.a22;
                    float f32 = perspectiveTransformSquareToQuadrilateral.a33;
                    float f33 = f31 * f32;
                    float f34 = perspectiveTransformSquareToQuadrilateral.a23;
                    float f35 = perspectiveTransformSquareToQuadrilateral.a32;
                    float f36 = f33 - (f34 * f35);
                    float f37 = perspectiveTransformSquareToQuadrilateral.a31;
                    float f38 = f34 * f37;
                    float f39 = perspectiveTransformSquareToQuadrilateral.a21;
                    float f40 = f38 - (f39 * f32);
                    float f41 = (f39 * f35) - (f31 * f37);
                    float f42 = perspectiveTransformSquareToQuadrilateral.a13;
                    float f43 = f42 * f35;
                    float f44 = perspectiveTransformSquareToQuadrilateral.a12;
                    float f45 = f43 - (f44 * f32);
                    float f46 = perspectiveTransformSquareToQuadrilateral.a11;
                    float f47 = (f32 * f46) - (f42 * f37);
                    float f48 = (f37 * f44) - (f35 * f46);
                    float f49 = (f44 * f34) - (f42 * f31);
                    float f50 = (f42 * f39) - (f34 * f46);
                    float f51 = (f46 * f31) - (f44 * f39);
                    PerspectiveTransform perspectiveTransformSquareToQuadrilateral2 = PerspectiveTransform.squareToQuadrilateral(f25, f26, f27, f28, f4, f24, f29, f30);
                    float f52 = perspectiveTransformSquareToQuadrilateral2.a11;
                    float f53 = perspectiveTransformSquareToQuadrilateral2.a21;
                    float f54 = perspectiveTransformSquareToQuadrilateral2.a31;
                    float f55 = (f54 * f49) + (f53 * f45) + (f52 * f36);
                    float f56 = (f54 * f50) + (f53 * f47) + (f52 * f40);
                    float f57 = (f54 * f51) + (f53 * f48) + (f52 * f41);
                    float f58 = perspectiveTransformSquareToQuadrilateral2.a12;
                    float f59 = perspectiveTransformSquareToQuadrilateral2.a22;
                    float f60 = perspectiveTransformSquareToQuadrilateral2.a32;
                    float f61 = (f60 * f49) + (f59 * f45) + (f58 * f36);
                    float f62 = (f60 * f50) + (f59 * f47) + (f58 * f40);
                    float f63 = (f60 * f51) + (f59 * f48) + (f58 * f41);
                    float f64 = perspectiveTransformSquareToQuadrilateral2.a13;
                    float f65 = perspectiveTransformSquareToQuadrilateral2.a23;
                    float f66 = perspectiveTransformSquareToQuadrilateral2.a33;
                    PerspectiveTransform perspectiveTransform = new PerspectiveTransform(f55, f56, f57, f61, f62, f63, (f49 * f66) + (f45 * f65) + (f36 * f64), (f50 * f66) + (f47 * f65) + (f40 * f64), (f66 * f51) + (f65 * f48) + (f64 * f41));
                    if (i26 > 0 || i26 <= 0) {
                        throw NotFoundException.INSTANCE;
                    }
                    BitMatrix bitMatrix = new BitMatrix(i26, i26);
                    int i31 = i26 * 2;
                    float[] fArr = new float[i31];
                    int i32 = 0;
                    while (i32 < i26) {
                        float f67 = i32 + 0.5f;
                        for (int i33 = 0; i33 < i31; i33 += 2) {
                            fArr[i33] = (i33 / 2) + 0.5f;
                            fArr[i33 + 1] = f67;
                        }
                        int i34 = 0;
                        while (i34 < i31) {
                            float f68 = fArr[i34];
                            int i35 = i34 + 1;
                            float f69 = fArr[i35];
                            FinderPattern finderPattern13 = finderPattern10;
                            float f70 = (perspectiveTransform.a23 * f69) + (perspectiveTransform.a13 * f68) + perspectiveTransform.a33;
                            fArr[i34] = (((perspectiveTransform.a21 * f69) + (perspectiveTransform.a11 * f68)) + perspectiveTransform.a31) / f70;
                            fArr[i35] = (((f69 * perspectiveTransform.a22) + (f68 * perspectiveTransform.a12)) + perspectiveTransform.a32) / f70;
                            i34 += 2;
                            finderPattern10 = finderPattern13;
                        }
                        FinderPattern finderPattern14 = finderPattern10;
                        int i36 = blackMatrix.height;
                        boolean z4 = true;
                        int i37 = 0;
                        while (i37 < i31 && z4) {
                            int i38 = (int) fArr[i37];
                            int i39 = i37 + 1;
                            PerspectiveTransform perspectiveTransform2 = perspectiveTransform;
                            int i40 = (int) fArr[i39];
                            if (i38 < -1 || i38 > i10 || i40 < -1 || i40 > i36) {
                                throw NotFoundException.INSTANCE;
                            }
                            if (i38 == -1) {
                                fArr[i37] = 0.0f;
                            } else {
                                if (i38 == i10) {
                                    fArr[i37] = i10 - 1;
                                } else {
                                    z4 = false;
                                }
                                if (i40 == -1) {
                                    fArr[i39] = 0.0f;
                                } else {
                                    if (i40 == i36) {
                                        fArr[i39] = i36 - 1;
                                    }
                                    i37 += 2;
                                    perspectiveTransform = perspectiveTransform2;
                                }
                                z4 = true;
                                i37 += 2;
                                perspectiveTransform = perspectiveTransform2;
                            }
                            z4 = true;
                            if (i40 == -1) {
                                fArr[i39] = 0.0f;
                            } else {
                                if (i40 == i36) {
                                    fArr[i39] = i36 - 1;
                                }
                                i37 += 2;
                                perspectiveTransform = perspectiveTransform2;
                            }
                            z4 = true;
                            i37 += 2;
                            perspectiveTransform = perspectiveTransform2;
                        }
                        PerspectiveTransform perspectiveTransform3 = perspectiveTransform;
                        boolean z5 = true;
                        for (int i41 = i31 - 2; i41 >= 0 && z5; i41 -= 2) {
                            int i42 = (int) fArr[i41];
                            int i43 = i41 + 1;
                            int i44 = (int) fArr[i43];
                            if (i42 < -1 || i42 > i10 || i44 < -1 || i44 > i36) {
                                throw NotFoundException.INSTANCE;
                            }
                            if (i42 == -1) {
                                fArr[i41] = 0.0f;
                            } else {
                                if (i42 == i10) {
                                    fArr[i41] = i10 - 1;
                                } else {
                                    z5 = false;
                                }
                                if (i44 == -1) {
                                    fArr[i43] = 0.0f;
                                } else {
                                    if (i44 == i36) {
                                        fArr[i43] = i36 - 1;
                                    }
                                }
                                z5 = true;
                            }
                            z5 = true;
                            if (i44 == -1) {
                                fArr[i43] = 0.0f;
                            } else {
                                if (i44 == i36) {
                                    fArr[i43] = i36 - 1;
                                }
                            }
                            z5 = true;
                        }
                        for (int i45 = 0; i45 < i31; i45 += 2) {
                            try {
                                if (blackMatrix.get((int) fArr[i45], (int) fArr[i45 + 1])) {
                                    bitMatrix.set(i45 / 2, i32);
                                }
                            } catch (ArrayIndexOutOfBoundsException unused2) {
                                throw NotFoundException.INSTANCE;
                            }
                        }
                        i32++;
                        finderPattern10 = finderPattern14;
                        perspectiveTransform = perspectiveTransform3;
                    }
                    FinderPattern finderPattern15 = finderPattern10;
                    if (alignmentPattern == null) {
                        i2 = 3;
                        resultPointArr = new ResultPoint[]{finderPattern12, finderPattern15, finderPattern11};
                    } else {
                        i2 = 3;
                        resultPointArr = new ResultPoint[]{finderPattern12, finderPattern15, finderPattern11, alignmentPattern};
                    }
                    decoderResultDecode = bjVar.decode(bitMatrix, map);
                    resultPointArr2 = resultPointArr;
                } else {
                    f = f16;
                    f2 = f17;
                }
                alignmentPatternFindAlignmentInRegion = null;
                f3 = i26 - 3.5f;
                if (alignmentPatternFindAlignmentInRegion != null) {
                    f4 = alignmentPatternFindAlignmentInRegion.x;
                    f5 = alignmentPatternFindAlignmentInRegion.y;
                    f6 = f3 - 3.0f;
                } else {
                    f4 = (f18 - f) + f20;
                    f5 = (f2 - f15) + f19;
                    f6 = f3;
                }
                float f210 = f5;
                float f211 = finderPattern10.x;
                float f212 = finderPattern10.y;
                float f213 = finderPattern11.x;
                float f214 = finderPattern11.y;
                float f215 = finderPattern12.x;
                float f310 = finderPattern12.y;
                PerspectiveTransform perspectiveTransformSquareToQuadrilateral3 = PerspectiveTransform.squareToQuadrilateral(3.5f, 3.5f, f3, 3.5f, f6, f6, 3.5f, f3);
                AlignmentPattern alignmentPattern2 = alignmentPatternFindAlignmentInRegion;
                float f311 = perspectiveTransformSquareToQuadrilateral3.a22;
                float f312 = perspectiveTransformSquareToQuadrilateral3.a33;
                float f313 = f311 * f312;
                float f314 = perspectiveTransformSquareToQuadrilateral3.a23;
                float f315 = perspectiveTransformSquareToQuadrilateral3.a32;
                float f316 = f313 - (f314 * f315);
                float f317 = perspectiveTransformSquareToQuadrilateral3.a31;
                float f318 = f314 * f317;
                float f319 = perspectiveTransformSquareToQuadrilateral3.a21;
                float f410 = f318 - (f319 * f312);
                float f411 = (f319 * f315) - (f311 * f317);
                float f412 = perspectiveTransformSquareToQuadrilateral3.a13;
                float f413 = f412 * f315;
                float f414 = perspectiveTransformSquareToQuadrilateral3.a12;
                float f415 = f413 - (f414 * f312);
                float f416 = perspectiveTransformSquareToQuadrilateral3.a11;
                float f417 = (f312 * f416) - (f412 * f317);
                float f418 = (f317 * f414) - (f315 * f416);
                float f419 = (f414 * f314) - (f412 * f311);
                float f510 = (f412 * f319) - (f314 * f416);
                float f511 = (f416 * f311) - (f414 * f319);
                PerspectiveTransform perspectiveTransformSquareToQuadrilateral4 = PerspectiveTransform.squareToQuadrilateral(f211, f212, f213, f214, f4, f210, f215, f310);
                float f512 = perspectiveTransformSquareToQuadrilateral4.a11;
                float f513 = perspectiveTransformSquareToQuadrilateral4.a21;
                float f514 = perspectiveTransformSquareToQuadrilateral4.a31;
                float f515 = (f514 * f419) + (f513 * f415) + (f512 * f316);
                float f516 = (f514 * f510) + (f513 * f417) + (f512 * f410);
                float f517 = (f514 * f511) + (f513 * f418) + (f512 * f411);
                float f518 = perspectiveTransformSquareToQuadrilateral4.a12;
                float f519 = perspectiveTransformSquareToQuadrilateral4.a22;
                float f610 = perspectiveTransformSquareToQuadrilateral4.a32;
                float f611 = (f610 * f419) + (f519 * f415) + (f518 * f316);
                float f612 = (f610 * f510) + (f519 * f417) + (f518 * f410);
                float f613 = (f610 * f511) + (f519 * f418) + (f518 * f411);
                float f614 = perspectiveTransformSquareToQuadrilateral4.a13;
                float f615 = perspectiveTransformSquareToQuadrilateral4.a23;
                float f616 = perspectiveTransformSquareToQuadrilateral4.a33;
                PerspectiveTransform perspectiveTransform4 = new PerspectiveTransform(f515, f516, f517, f611, f612, f613, (f419 * f616) + (f415 * f615) + (f316 * f614), (f510 * f616) + (f417 * f615) + (f410 * f614), (f616 * f511) + (f615 * f418) + (f614 * f411));
                if (i26 > 0) {
                }
                throw NotFoundException.INSTANCE;
            } catch (IllegalArgumentException unused3) {
                throw FormatException.getFormatInstance();
            }
        }
        BitMatrix blackMatrix2 = gVar.getBlackMatrix();
        int i46 = 0;
        while (true) {
            iArr = blackMatrix2.bits;
            i4 = blackMatrix2.width;
            i5 = blackMatrix2.rowSize;
            if (i46 >= iArr.length || iArr[i46] != 0) {
                break;
            }
            i46++;
        }
        if (i46 == iArr.length) {
            iArr2 = null;
        } else {
            int i47 = i46 / i5;
            int i48 = (i46 % i5) << 5;
            int i49 = iArr[i46];
            int i50 = 0;
            while ((i49 << (31 - i50)) == 0) {
                i50++;
            }
            iArr2 = new int[]{i48 + i50, i47};
        }
        int[] iArr5 = blackMatrix2.bits;
        int length = iArr5.length - 1;
        while (length >= 0 && iArr5[length] == 0) {
            length--;
        }
        if (length < 0) {
            iArr3 = null;
        } else {
            int i51 = length / i5;
            int i52 = (length % i5) << 5;
            int i53 = iArr5[length];
            int i54 = 31;
            while ((i53 >>> i54) == 0) {
                i54--;
            }
            iArr3 = new int[]{i52 + i54, i51};
        }
        if (iArr2 == null || iArr3 == null) {
            throw NotFoundException.INSTANCE;
        }
        int i55 = blackMatrix2.height;
        int i56 = iArr2[0];
        int i57 = iArr2[1];
        boolean z6 = true;
        int i58 = 0;
        while (true) {
            if (i56 >= i4 || i57 >= i55) {
                i6 = i8;
                break;
            }
            i6 = i8;
            if (z6 != blackMatrix2.get(i56, i57)) {
                int i59 = i58 + 1;
                if (i59 == 5) {
                    break;
                }
                z6 = !z6;
                i58 = i59;
            }
            i56++;
            i57++;
            i8 = i6;
        }
        if (i56 == i4 || i57 == i55) {
            throw NotFoundException.INSTANCE;
        }
        int i60 = iArr2[i6];
        float f71 = (i56 - i60) / 7.0f;
        int i61 = iArr2[1];
        int i62 = iArr3[1];
        int i63 = iArr3[i6];
        if (i60 >= i63 || i61 >= i62) {
            throw NotFoundException.INSTANCE;
        }
        int i64 = i62 - i61;
        if (i64 != i63 - i60 && (i63 = i60 + i64) >= i4) {
            throw NotFoundException.INSTANCE;
        }
        int iRound = Math.round(((i63 - i60) + 1) / f71);
        int iRound2 = Math.round((i64 + 1) / f71);
        if (iRound <= 0 || iRound2 <= 0) {
            throw NotFoundException.INSTANCE;
        }
        if (iRound2 != iRound) {
            throw NotFoundException.INSTANCE;
        }
        int i65 = (int) (f71 / 2.0f);
        int i66 = i61 + i65;
        int i67 = i60 + i65;
        int i68 = (((int) ((iRound - 1) * f71)) + i67) - i63;
        if (i68 > 0) {
            if (i68 > i65) {
                throw NotFoundException.INSTANCE;
            }
            i67 -= i68;
        }
        int i69 = (((int) ((iRound2 - 1) * f71)) + i66) - i62;
        if (i69 > 0) {
            if (i69 > i65) {
                throw NotFoundException.INSTANCE;
            }
            i66 -= i69;
        }
        BitMatrix bitMatrix2 = new BitMatrix(iRound, iRound2);
        for (int i70 = i6; i70 < iRound2; i70++) {
            int i71 = ((int) (i70 * f71)) + i66;
            for (int i72 = i6; i72 < iRound; i72++) {
                if (blackMatrix2.get(((int) (i72 * f71)) + i67, i71)) {
                    bitMatrix2.set(i72, i70);
                }
            }
        }
        decoderResultDecode = bjVar.decode(bitMatrix2, map);
        resultPointArr2 = NO_POINTS;
        i2 = 3;
        int i73 = decoderResultDecode.structuredAppendParity;
        if (fb$1.m(decoderResultDecode.other) && resultPointArr2.length >= i2) {
            ResultPoint resultPoint = resultPointArr2[0];
            resultPointArr2[0] = resultPointArr2[2];
            resultPointArr2[2] = resultPoint;
        }
        String str = decoderResultDecode.text;
        BarcodeFormat[] barcodeFormatArr = BarcodeFormat.$VALUES;
        g gVar2 = new g(str);
        List list = decoderResultDecode.byteSegments;
        if (list != null) {
            gVar2.putMetadata(ResultMetadataType.BYTE_SEGMENTS, list);
        }
        String str2 = decoderResultDecode.ecLevel;
        if (str2 != null) {
            gVar2.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, str2);
        }
        if (i73 >= 0 && (i3 = decoderResultDecode.structuredAppendSequenceNumber) >= 0) {
            gVar2.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(i3));
            gVar2.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(i73));
        }
        return gVar2;
    }
}
