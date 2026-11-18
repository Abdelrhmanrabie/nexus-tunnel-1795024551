package com.google.android.material.color;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
final class Hct {
    /* JADX WARN: Code duplicated, block: B:53:0x0132  */
    private Hct(float f, float f2, float f3) {
        int iIntFromLstar;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        ViewingConditions viewingConditions = ViewingConditions.DEFAULT;
        float f9 = f2;
        if (f9 < 1.0d || Math.round(f3) <= 0.0d || Math.round(f3) >= 100.0d) {
            iIntFromLstar = ColorUtils.intFromLstar(f3);
        } else {
            float f10 = 0.0f;
            float f11 = f < 0.0f ? (f % 360.0f) + 360.0f : f >= 360.0f ? f % 360.0f : f;
            float f12 = 0.0f;
            boolean z = true;
            Cam16 cam16 = null;
            float f13 = f9;
            while (Math.abs(f12 - f9) >= 0.4f) {
                float f14 = 100.0f;
                float f15 = 1000.0f;
                float f16 = f10;
                float f17 = 1000.0f;
                Cam16 cam17 = null;
                while (true) {
                    if (Math.abs(f16 - f14) <= 0.01f) {
                        f4 = f9;
                        f5 = f10;
                        f6 = f11;
                        f7 = 2.0f;
                        break;
                    }
                    float f18 = ((f14 - f16) / 2.0f) + f16;
                    f5 = f10;
                    int iViewed = Cam16.fromJch(f18, f13, f11).viewed(ViewingConditions.DEFAULT);
                    float fLstarFromInt = ColorUtils.lstarFromInt(iViewed);
                    float fAbs = Math.abs(f3 - fLstarFromInt);
                    if (fAbs < 0.2f) {
                        Cam16 cam16FromInt = Cam16.fromInt(iViewed);
                        f7 = 2.0f;
                        f4 = f9;
                        Cam16 cam16FromJch = Cam16.fromJch(cam16FromInt.j, cam16FromInt.chroma, f11);
                        f6 = f11;
                        float f19 = cam16FromInt.jstar - cam16FromJch.jstar;
                        float f20 = cam16FromInt.astar - cam16FromJch.astar;
                        float f21 = cam16FromInt.bstar - cam16FromJch.bstar;
                        f8 = fLstarFromInt;
                        float fPow = (float) (Math.pow(Math.sqrt((f21 * f21) + (f20 * f20) + (f19 * f19)), 0.63d) * 1.41d);
                        if (fPow <= 1.0f && fPow <= f15) {
                            f15 = fPow;
                            cam17 = cam16FromInt;
                            f17 = fAbs;
                        }
                    } else {
                        f4 = f9;
                        f6 = f11;
                        f8 = fLstarFromInt;
                        f7 = 2.0f;
                    }
                    if (f17 == f5 && f15 < 1.0E-9f) {
                        break;
                    }
                    if (f8 < f3) {
                        f16 = f18;
                    } else {
                        f14 = f18;
                    }
                    f10 = f5;
                    f9 = f4;
                    f11 = f6;
                }
                if (!z) {
                    if (cam17 == null) {
                        f9 = f13;
                        f13 = f12;
                    } else {
                        cam16 = cam17;
                        f9 = f4;
                    }
                    f12 = f13;
                    f13 = ((f9 - f13) / f7) + f13;
                } else if (cam17 != null) {
                    iIntFromLstar = cam17.viewed(viewingConditions);
                } else {
                    f13 = ((f4 - f12) / f7) + f12;
                    z = false;
                    f9 = f4;
                }
                f10 = f5;
                f11 = f6;
            }
            if (cam16 == null) {
                iIntFromLstar = ColorUtils.intFromLstar(f3);
            } else {
                iIntFromLstar = cam16.viewed(viewingConditions);
            }
        }
        Cam16.fromInt(iIntFromLstar);
        ColorUtils.lstarFromInt(iIntFromLstar);
    }
}
