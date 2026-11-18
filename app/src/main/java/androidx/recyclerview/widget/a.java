package androidx.recyclerview.widget;

import defpackage.gp0;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class a implements r.a {
    public final RecyclerView.f d;
    public final gp0 a = new gp0(30);
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public int f = 0;
    public final r e = new r(this);

    /* JADX INFO: renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface InterfaceC0025a {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class b {
        public int a;
        public int b;
        public Object c;
        public int d;

        public b(int i, int i2, int i3, Object obj) {
            this.a = i;
            this.b = i2;
            this.d = i3;
            this.c = obj;
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                int i = this.a;
                if (i != bVar.a) {
                    return false;
                }
                if (i != 8 || Math.abs(this.d - this.b) != 1 || this.d != bVar.b || this.b != bVar.d) {
                    if (this.d != bVar.d || this.b != bVar.b) {
                        return false;
                    }
                    Object obj2 = this.c;
                    Object obj3 = bVar.c;
                    if (obj2 != null) {
                        if (!obj2.equals(obj3)) {
                            return false;
                        }
                    } else if (obj3 != null) {
                        return false;
                    }
                }
            }
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.d;
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i = this.a;
            if (i == 1) {
                str = "add";
            } else if (i == 2) {
                str = "rm";
            } else if (i != 4) {
                str = i != 8 ? "??" : "mv";
            } else {
                str = "up";
            }
            sb.append(str);
            sb.append(",s:");
            sb.append(this.b);
            sb.append("c:");
            sb.append(this.d);
            sb.append(",p:");
            sb.append(this.c);
            sb.append("]");
            return sb.toString();
        }
    }

    public a(RecyclerView.f fVar) {
        this.d = fVar;
    }

    public final boolean a(int i) {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) arrayList.get(i2);
            int i3 = bVar.a;
            if (i3 != 8) {
                if (i3 == 1) {
                    int i4 = bVar.b;
                    int i5 = bVar.d + i4;
                    while (i4 < i5) {
                        if (f(i4, i2 + 1) == i) {
                            return true;
                        }
                        i4++;
                    }
                } else {
                    continue;
                }
            } else {
                if (f(bVar.d, i2 + 1) == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void b() {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.d.a((b) arrayList.get(i));
        }
        l(arrayList);
        this.f = 0;
    }

    public final void c() {
        RecyclerView recyclerView;
        b();
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) arrayList.get(i);
            int i2 = bVar.a;
            RecyclerView.f fVar = this.d;
            if (i2 != 1) {
                if (i2 == 2) {
                    fVar.a(bVar);
                    int i3 = bVar.b;
                    int i4 = bVar.d;
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.offsetPositionRecordsForRemove(i3, i4, true);
                    recyclerView2.mItemsAddedOrRemoved = true;
                    recyclerView2.mState.c += i4;
                } else if (i2 == 4) {
                    fVar.a(bVar);
                    int i5 = bVar.b;
                    int i6 = bVar.d;
                    Object obj = bVar.c;
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.viewRangeUpdate(i5, i6, obj);
                    recyclerView3.mItemsChanged = true;
                } else if (i2 == 8) {
                    fVar.a(bVar);
                    int i7 = bVar.b;
                    int i8 = bVar.d;
                    recyclerView = RecyclerView.this;
                    recyclerView.offsetPositionRecordsForMove(i7, i8);
                }
            } else {
                fVar.a(bVar);
                int i9 = bVar.b;
                int i10 = bVar.d;
                recyclerView = RecyclerView.this;
                recyclerView.offsetPositionRecordsForInsert(i9, i10);
            }
            recyclerView.mItemsAddedOrRemoved = true;
        }
        l(arrayList);
        this.f = 0;
    }

    public final void d(b bVar) {
        int i;
        gp0 gp0Var;
        int i2 = bVar.a;
        if (i2 == 1 || i2 == 8) {
            defpackage.d.AnonymousClass0.m$2("should not dispatch add or move for pre layout");
            return;
        }
        int iM = m(bVar.b, i2);
        int i3 = bVar.b;
        int i4 = bVar.a;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                defpackage.d.AnonymousClass0.m("op should be remove or update.", bVar);
                return;
            }
            i = 1;
        }
        int i5 = 1;
        int i6 = 1;
        while (true) {
            int i7 = bVar.d;
            gp0Var = this.a;
            if (i5 >= i7) {
                break;
            }
            int iM2 = m((i * i5) + bVar.b, bVar.a);
            int i8 = bVar.a;
            if (i8 == 2 ? iM2 != iM : !(i8 == 4 && iM2 == iM + 1)) {
                b bVarH = h(i8, iM, i6, bVar.c);
                e(bVarH, i3);
                bVarH.c = null;
                gp0Var.a(bVarH);
                if (bVar.a == 4) {
                    i3 += i6;
                }
                i6 = 1;
                iM = iM2;
            } else {
                i6++;
            }
            i5++;
        }
        Object obj = bVar.c;
        bVar.c = null;
        gp0Var.a(bVar);
        if (i6 > 0) {
            b bVarH2 = h(bVar.a, iM, i6, obj);
            e(bVarH2, i3);
            bVarH2.c = null;
            gp0Var.a(bVarH2);
        }
    }

    public final void e(b bVar, int i) {
        RecyclerView.f fVar = this.d;
        fVar.a(bVar);
        RecyclerView recyclerView = RecyclerView.this;
        int i2 = bVar.a;
        if (i2 != 2) {
            if (i2 != 4) {
                defpackage.d.AnonymousClass0.m$2("only remove and update ops can be dispatched in first pass");
                return;
            } else {
                recyclerView.viewRangeUpdate(i, bVar.d, bVar.c);
                recyclerView.mItemsChanged = true;
                return;
            }
        }
        int i3 = bVar.d;
        recyclerView.offsetPositionRecordsForRemove(i, i3, true);
        recyclerView.mItemsAddedOrRemoved = true;
        recyclerView.mState.c += i3;
    }

    public final int f(int i, int i2) {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        while (i2 < size) {
            b bVar = (b) arrayList.get(i2);
            int i3 = bVar.a;
            int i4 = bVar.b;
            if (i3 == 8) {
                if (i4 == i) {
                    i = bVar.d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.d <= i) {
                        i++;
                    }
                }
            } else if (i4 > i) {
                continue;
            } else if (i3 == 2) {
                int i5 = bVar.d;
                if (i < i4 + i5) {
                    return -1;
                }
                i -= i5;
            } else if (i3 == 1) {
                i += bVar.d;
            }
            i2++;
        }
        return i;
    }

    public final boolean g() {
        return this.b.size() > 0;
    }

    public final b h(int i, int i2, int i3, Object obj) {
        b bVar = (b) this.a.b();
        if (bVar == null) {
            return new b(i, i2, i3, obj);
        }
        bVar.a = i;
        bVar.b = i2;
        bVar.d = i3;
        bVar.c = obj;
        return bVar;
    }

    public final void i(b bVar) {
        this.c.add(bVar);
        int i = bVar.a;
        RecyclerView.f fVar = this.d;
        if (i == 1) {
            int i2 = bVar.b;
            int i3 = bVar.d;
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.offsetPositionRecordsForInsert(i2, i3);
            recyclerView.mItemsAddedOrRemoved = true;
            return;
        }
        if (i == 2) {
            int i4 = bVar.b;
            int i5 = bVar.d;
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.offsetPositionRecordsForRemove(i4, i5, false);
            recyclerView2.mItemsAddedOrRemoved = true;
            return;
        }
        if (i == 4) {
            int i6 = bVar.b;
            int i7 = bVar.d;
            Object obj = bVar.c;
            RecyclerView recyclerView3 = RecyclerView.this;
            recyclerView3.viewRangeUpdate(i6, i7, obj);
            recyclerView3.mItemsChanged = true;
            return;
        }
        if (i != 8) {
            defpackage.d.AnonymousClass0.m("Unknown update op type for ", bVar);
            return;
        }
        int i8 = bVar.b;
        int i9 = bVar.d;
        RecyclerView recyclerView4 = RecyclerView.this;
        recyclerView4.offsetPositionRecordsForMove(i8, i9);
        recyclerView4.mItemsAddedOrRemoved = true;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0197  */
    /* JADX WARN: Code duplicated, block: B:103:0x019b  */
    /* JADX WARN: Code duplicated, block: B:137:0x0210  */
    /* JADX WARN: Code duplicated, block: B:165:0x0282  */
    /* JADX WARN: Code duplicated, block: B:198:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:199:0x0134 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x01a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:212:0x0007 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x0007 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x006c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0071  */
    /* JADX WARN: Code duplicated, block: B:33:0x0076  */
    /* JADX WARN: Code duplicated, block: B:37:0x0090  */
    /* JADX WARN: Code duplicated, block: B:38:0x0094  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:74:0x0136  */
    /* JADX WARN: Code duplicated, block: B:75:0x0138  */
    /* JADX WARN: Code duplicated, block: B:77:0x013e  */
    /* JADX WARN: Code duplicated, block: B:80:0x0149  */
    /* JADX WARN: Code duplicated, block: B:83:0x0154  */
    /* JADX WARN: Code duplicated, block: B:87:0x0160  */
    /* JADX WARN: Code duplicated, block: B:88:0x0162  */
    /* JADX WARN: Code duplicated, block: B:90:0x0168  */
    /* JADX WARN: Code duplicated, block: B:93:0x0173  */
    /* JADX WARN: Code duplicated, block: B:96:0x017e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0189 A[PHI: r5
      0x0189: PHI (r5v28 int) = (r5v22 int), (r5v32 int) binds: [B:98:0x0187, B:85:0x015d] A[DONT_GENERATE, DONT_INLINE]] */
    public final void j() {
        ArrayList arrayList;
        int i;
        byte b2;
        int i2;
        int i3;
        Object obj;
        int i4;
        Object obj2;
        boolean z;
        byte b3;
        b bVarH;
        int i5;
        int i6;
        int i7;
        b bVarH2;
        boolean z2;
        boolean z3;
        b bVarH3;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        r rVar = this.e;
        rVar.getClass();
        while (true) {
            arrayList = this.b;
            int size = arrayList.size() - 1;
            boolean z4 = false;
            while (true) {
                i = 8;
                b2 = -1;
                if (size < 0) {
                    size = -1;
                    break;
                }
                if (((b) arrayList.get(size)).a != 8) {
                    z4 = true;
                } else if (z4) {
                    break;
                }
                size--;
            }
            i2 = 4;
            i3 = 2;
            obj = null;
            if (size == -1) {
                break;
            }
            int i15 = size + 1;
            b bVar = (b) arrayList.get(size);
            b bVar2 = (b) arrayList.get(i15);
            int i16 = bVar2.a;
            if (i16 != 1) {
                r.a aVar = rVar.a;
                if (i16 == 2) {
                    int i17 = bVar.b;
                    int i18 = bVar.d;
                    int i19 = bVar2.b;
                    if (i17 < i18) {
                        if (i19 == i17 && bVar2.d == i18 - i17) {
                            z3 = true;
                            z2 = false;
                        } else {
                            z3 = false;
                            z2 = z3;
                        }
                    } else if (i19 == i18 + 1 && bVar2.d == i17 - i18) {
                        z3 = true;
                        z2 = z3;
                    } else {
                        z2 = true;
                        z3 = false;
                    }
                    if (i18 < i19) {
                        bVar2.b = i19 - 1;
                    } else {
                        int i20 = bVar2.d;
                        if (i18 < i19 + i20) {
                            bVar2.d = i20 - 1;
                            bVar.a = 2;
                            bVar.d = 1;
                            if (bVar2.d == 0) {
                                arrayList.remove(i15);
                                a aVar2 = (a) aVar;
                                aVar2.getClass();
                                bVar2.c = null;
                                aVar2.a.a(bVar2);
                            }
                        }
                    }
                    int i21 = bVar.b;
                    int i22 = bVar2.b;
                    if (i21 <= i22) {
                        bVar2.b = i22 + 1;
                    } else {
                        int i23 = i22 + bVar2.d;
                        if (i21 < i23) {
                            bVarH3 = ((a) aVar).h(2, i21 + 1, i23 - i21, null);
                            bVar2.d = bVar.b - bVar2.b;
                        }
                        if (z3) {
                            arrayList.set(size, bVar2);
                            arrayList.remove(i15);
                            a aVar3 = (a) aVar;
                            aVar3.getClass();
                            bVar.c = null;
                            aVar3.a.a(bVar);
                        } else {
                            if (z2) {
                                if (bVarH3 != null) {
                                    i13 = bVar.b;
                                    if (i13 > bVarH3.b) {
                                        bVar.b = i13 - bVarH3.d;
                                    }
                                    i14 = bVar.d;
                                    if (i14 > bVarH3.b) {
                                        bVar.d = i14 - bVarH3.d;
                                    }
                                }
                                i12 = bVar.b;
                                if (i12 > bVar2.b) {
                                    bVar.b = i12 - bVar2.d;
                                }
                                i9 = bVar.d;
                                if (i9 > bVar2.b) {
                                    bVar.d = i9 - bVar2.d;
                                }
                            } else {
                                if (bVarH3 != null) {
                                    i10 = bVar.b;
                                    if (i10 >= bVarH3.b) {
                                        bVar.b = i10 - bVarH3.d;
                                    }
                                    i11 = bVar.d;
                                    if (i11 >= bVarH3.b) {
                                        bVar.d = i11 - bVarH3.d;
                                    }
                                }
                                i8 = bVar.b;
                                if (i8 >= bVar2.b) {
                                    bVar.b = i8 - bVar2.d;
                                }
                                i9 = bVar.d;
                                if (i9 >= bVar2.b) {
                                    bVar.d = i9 - bVar2.d;
                                }
                            }
                            arrayList.set(size, bVar2);
                            if (bVar.b != bVar.d) {
                                arrayList.set(i15, bVar);
                            } else {
                                arrayList.remove(i15);
                            }
                            if (bVarH3 != null) {
                                arrayList.add(size, bVarH3);
                            }
                        }
                    }
                    bVarH3 = null;
                    if (z3) {
                        arrayList.set(size, bVar2);
                        arrayList.remove(i15);
                        a aVar4 = (a) aVar;
                        aVar4.getClass();
                        bVar.c = null;
                        aVar4.a.a(bVar);
                    } else {
                        if (z2) {
                            if (bVarH3 != null) {
                                i13 = bVar.b;
                                if (i13 > bVarH3.b) {
                                    bVar.b = i13 - bVarH3.d;
                                }
                                i14 = bVar.d;
                                if (i14 > bVarH3.b) {
                                    bVar.d = i14 - bVarH3.d;
                                }
                            }
                            i12 = bVar.b;
                            if (i12 > bVar2.b) {
                                bVar.b = i12 - bVar2.d;
                            }
                            i9 = bVar.d;
                            if (i9 > bVar2.b) {
                                bVar.d = i9 - bVar2.d;
                            }
                        } else {
                            if (bVarH3 != null) {
                                i10 = bVar.b;
                                if (i10 >= bVarH3.b) {
                                    bVar.b = i10 - bVarH3.d;
                                }
                                i11 = bVar.d;
                                if (i11 >= bVarH3.b) {
                                    bVar.d = i11 - bVarH3.d;
                                }
                            }
                            i8 = bVar.b;
                            if (i8 >= bVar2.b) {
                                bVar.b = i8 - bVar2.d;
                            }
                            i9 = bVar.d;
                            if (i9 >= bVar2.b) {
                                bVar.d = i9 - bVar2.d;
                            }
                        }
                        arrayList.set(size, bVar2);
                        if (bVar.b != bVar.d) {
                            arrayList.set(i15, bVar);
                        } else {
                            arrayList.remove(i15);
                        }
                        if (bVarH3 != null) {
                            arrayList.add(size, bVarH3);
                        }
                    }
                } else if (i16 == 4) {
                    int i24 = bVar.d;
                    int i25 = bVar2.b;
                    if (i24 < i25) {
                        bVar2.b = i25 - 1;
                    } else {
                        int i26 = bVar2.d;
                        if (i24 < i25 + i26) {
                            bVar2.d = i26 - 1;
                            bVarH = ((a) aVar).h(4, bVar.b, 1, bVar2.c);
                        }
                        i5 = bVar.b;
                        i6 = bVar2.b;
                        if (i5 <= i6) {
                            bVar2.b = i6 + 1;
                        } else {
                            i7 = i6 + bVar2.d;
                            if (i5 < i7) {
                                int i27 = i7 - i5;
                                bVarH2 = ((a) aVar).h(4, i5 + 1, i27, bVar2.c);
                                bVar2.d -= i27;
                            }
                            arrayList.set(i15, bVar);
                            if (bVar2.d > 0) {
                                arrayList.set(size, bVar2);
                            } else {
                                arrayList.remove(size);
                                a aVar5 = (a) aVar;
                                aVar5.getClass();
                                bVar2.c = null;
                                aVar5.a.a(bVar2);
                            }
                            if (bVarH != null) {
                                arrayList.add(size, bVarH);
                            }
                            if (bVarH2 != null) {
                                arrayList.add(size, bVarH2);
                            }
                        }
                        bVarH2 = null;
                        arrayList.set(i15, bVar);
                        if (bVar2.d > 0) {
                            arrayList.set(size, bVar2);
                        } else {
                            arrayList.remove(size);
                            a aVar6 = (a) aVar;
                            aVar6.getClass();
                            bVar2.c = null;
                            aVar6.a.a(bVar2);
                        }
                        if (bVarH != null) {
                            arrayList.add(size, bVarH);
                        }
                        if (bVarH2 != null) {
                            arrayList.add(size, bVarH2);
                        }
                    }
                    bVarH = null;
                    i5 = bVar.b;
                    i6 = bVar2.b;
                    if (i5 <= i6) {
                        bVar2.b = i6 + 1;
                    } else {
                        i7 = i6 + bVar2.d;
                        if (i5 < i7) {
                            int i28 = i7 - i5;
                            bVarH2 = ((a) aVar).h(4, i5 + 1, i28, bVar2.c);
                            bVar2.d -= i28;
                        }
                        arrayList.set(i15, bVar);
                        if (bVar2.d > 0) {
                            arrayList.set(size, bVar2);
                        } else {
                            arrayList.remove(size);
                            a aVar7 = (a) aVar;
                            aVar7.getClass();
                            bVar2.c = null;
                            aVar7.a.a(bVar2);
                        }
                        if (bVarH != null) {
                            arrayList.add(size, bVarH);
                        }
                        if (bVarH2 != null) {
                            arrayList.add(size, bVarH2);
                        }
                    }
                    bVarH2 = null;
                    arrayList.set(i15, bVar);
                    if (bVar2.d > 0) {
                        arrayList.set(size, bVar2);
                    } else {
                        arrayList.remove(size);
                        a aVar8 = (a) aVar;
                        aVar8.getClass();
                        bVar2.c = null;
                        aVar8.a.a(bVar2);
                    }
                    if (bVarH != null) {
                        arrayList.add(size, bVarH);
                    }
                    if (bVarH2 != null) {
                        arrayList.add(size, bVarH2);
                    }
                }
            } else {
                int i29 = bVar.d;
                int i30 = bVar2.b;
                int i31 = i29 < i30 ? -1 : 0;
                int i32 = bVar.b;
                if (i32 < i30) {
                    i31++;
                }
                if (i30 <= i32) {
                    bVar.b = i32 + bVar2.d;
                }
                int i33 = bVar2.b;
                if (i33 <= i29) {
                    bVar.d = i29 + bVar2.d;
                }
                bVar2.b = i33 + i31;
                arrayList.set(size, bVar2);
                arrayList.set(i15, bVar);
            }
        }
        int size2 = arrayList.size();
        int i34 = 0;
        while (i34 < size2) {
            b bVarH4 = (b) arrayList.get(i34);
            int i35 = bVarH4.a;
            if (i35 != 1) {
                gp0 gp0Var = this.a;
                RecyclerView.f fVar = this.d;
                if (i35 == i3) {
                    int i36 = bVarH4.b;
                    int i37 = bVarH4.d + i36;
                    int i38 = i36;
                    int i39 = 0;
                    byte b4 = -1;
                    while (i38 < i37) {
                        RecyclerView recyclerView = RecyclerView.this;
                        RecyclerView.d0 d0VarFindViewHolderForPosition = recyclerView.findViewHolderForPosition(i38);
                        if (d0VarFindViewHolderForPosition == null) {
                            d0VarFindViewHolderForPosition = null;
                        } else {
                            if (recyclerView.mChildHelper.c.contains(d0VarFindViewHolderForPosition.itemView)) {
                                d0VarFindViewHolderForPosition = null;
                            }
                        }
                        if (d0VarFindViewHolderForPosition != null || a(i38)) {
                            if (b4 == 0) {
                                d(h(2, i36, i39, null));
                                z = true;
                            } else {
                                z = false;
                            }
                            b3 = 1;
                        } else {
                            if (b4 == 1) {
                                i(h(2, i36, i39, null));
                                z = true;
                            } else {
                                z = false;
                            }
                            b3 = 0;
                        }
                        if (z) {
                            i38 -= i39;
                            i37 -= i39;
                            i39 = 1;
                        } else {
                            i39++;
                        }
                        i38++;
                        b4 = b3;
                    }
                    if (i39 != bVarH4.d) {
                        obj2 = null;
                        bVarH4.c = null;
                        gp0Var.a(bVarH4);
                        i4 = 2;
                        bVarH4 = h(2, i36, i39, null);
                    } else {
                        i4 = 2;
                        obj2 = null;
                    }
                    if (b4 == 0) {
                        d(bVarH4);
                    }
                } else if (i35 != i2) {
                    if (i35 == i) {
                        i(bVarH4);
                    }
                    i4 = i3;
                    obj2 = obj;
                } else {
                    int i40 = bVarH4.b;
                    int i41 = bVarH4.d + i40;
                    int i42 = i40;
                    int i43 = 0;
                    while (i40 < i41) {
                        RecyclerView recyclerView2 = RecyclerView.this;
                        RecyclerView.d0 d0VarFindViewHolderForPosition2 = recyclerView2.findViewHolderForPosition(i40);
                        if (d0VarFindViewHolderForPosition2 == null) {
                            d0VarFindViewHolderForPosition2 = null;
                        } else {
                            if (recyclerView2.mChildHelper.c.contains(d0VarFindViewHolderForPosition2.itemView)) {
                                d0VarFindViewHolderForPosition2 = null;
                            }
                        }
                        if (d0VarFindViewHolderForPosition2 != null || a(i40)) {
                            if (b2 == 0) {
                                d(h(4, i42, i43, bVarH4.c));
                                i42 = i40;
                                i43 = 0;
                            }
                            b2 = 1;
                        } else {
                            if (b2 == 1) {
                                i(h(4, i42, i43, bVarH4.c));
                                i42 = i40;
                                i43 = 0;
                            }
                            b2 = 0;
                        }
                        i43++;
                        i40++;
                    }
                    if (i43 != bVarH4.d) {
                        Object obj3 = bVarH4.c;
                        bVarH4.c = null;
                        gp0Var.a(bVarH4);
                        bVarH4 = h(4, i42, i43, obj3);
                    }
                    if (b2 == 0) {
                        d(bVarH4);
                    } else {
                        i(bVarH4);
                    }
                    i4 = 2;
                    obj2 = null;
                }
                i34++;
                obj = obj2;
                i = 8;
                b2 = -1;
                i3 = i4;
                i2 = 4;
            } else {
                i4 = i3;
                obj2 = obj;
            }
            i(bVarH4);
            i34++;
            obj = obj2;
            i = 8;
            b2 = -1;
            i3 = i4;
            i2 = 4;
        }
        arrayList.clear();
    }

    public final void l(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) arrayList.get(i);
            bVar.c = null;
            this.a.a(bVar);
        }
        arrayList.clear();
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    public final int m(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            b bVar = (b) arrayList.get(size);
            int i9 = bVar.a;
            int i10 = bVar.b;
            if (i9 == 8) {
                int i11 = bVar.d;
                if (i10 < i11) {
                    i5 = i11;
                    i4 = i10;
                } else {
                    i4 = i11;
                    i5 = i10;
                }
                if (i < i4 || i > i5) {
                    if (i < i10) {
                        if (i2 == 1) {
                            bVar.b = i10 + 1;
                            i6 = i11 + 1;
                        } else if (i2 == 2) {
                            bVar.b = i10 - 1;
                            i6 = i11 - 1;
                        }
                        bVar.d = i6;
                    }
                } else if (i4 == i10) {
                    if (i2 == 1) {
                        i8 = i11 + 1;
                    } else {
                        if (i2 == 2) {
                            i8 = i11 - 1;
                        }
                        i++;
                    }
                    bVar.d = i8;
                    i++;
                } else {
                    if (i2 == 1) {
                        i7 = i10 + 1;
                    } else {
                        if (i2 == 2) {
                            i7 = i10 - 1;
                        }
                        i--;
                    }
                    bVar.b = i7;
                    i--;
                }
            } else if (i10 > i) {
                if (i2 == 1) {
                    i3 = i10 + 1;
                } else if (i2 == 2) {
                    i3 = i10 - 1;
                }
                bVar.b = i3;
            } else if (i9 == 1) {
                i -= bVar.d;
            } else if (i9 == 2) {
                i += bVar.d;
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) arrayList.get(size2);
            int i12 = bVar2.a;
            int i13 = bVar2.d;
            if (i12 == 8) {
                if (i13 == bVar2.b || i13 < 0) {
                    arrayList.remove(size2);
                    bVar2.c = null;
                    this.a.a(bVar2);
                }
            } else if (i13 <= 0) {
                arrayList.remove(size2);
                bVar2.c = null;
                this.a.a(bVar2);
            }
        }
        return i;
    }
}
