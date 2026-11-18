package defpackage;

import java.io.Serializable;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class le implements li, Serializable {
    public final li b;
    public final li.b c;

    public le(li.b bVar, li liVar) {
        this.b = liVar;
        this.c = bVar;
    }

    @Override // defpackage.li
    public final li.b a(li.c cVar) {
        le leVar = this;
        while (true) {
            li.b bVarA = leVar.c.a(cVar);
            if (bVarA != null) {
                return bVarA;
            }
            li liVar = leVar.b;
            if (!(liVar instanceof le)) {
                return liVar.a(cVar);
            }
            leVar = (le) liVar;
        }
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (obj instanceof le) {
            le leVar = (le) obj;
            int i = 2;
            le leVar2 = leVar;
            int i2 = 2;
            while (true) {
                li liVar = leVar2.b;
                leVar2 = liVar instanceof le ? (le) liVar : null;
                if (leVar2 == null) {
                    break;
                }
                i2++;
            }
            le leVar3 = this;
            while (true) {
                li liVar2 = leVar3.b;
                leVar3 = liVar2 instanceof le ? (le) liVar2 : null;
                if (leVar3 == null) {
                    break;
                }
                i++;
            }
            if (i2 == i) {
                le leVar4 = this;
                while (true) {
                    li.b bVar = leVar4.c;
                    if (!e4.a(leVar.a(bVar.getKey()), bVar)) {
                        zA = false;
                        break;
                    }
                    li liVar3 = leVar4.b;
                    if (!(liVar3 instanceof le)) {
                        li.b bVar2 = (li.b) liVar3;
                        zA = e4.a(leVar.a(bVar2.getKey()), bVar2);
                        break;
                    }
                    leVar4 = (le) liVar3;
                }
                if (zA) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.li
    public final li f(li.c cVar) {
        li.b bVar = this.c;
        li.b bVarA = bVar.a(cVar);
        li liVar = this.b;
        if (bVarA != null) {
            return liVar;
        }
        li liVarF = liVar.f(cVar);
        if (liVarF == liVar) {
            return this;
        }
        return liVarF == rq.b ? bVar : new le(bVar, liVarF);
    }

    public final int hashCode() {
        return this.c.hashCode() + this.b.hashCode();
    }

    @Override // defpackage.li
    public final Object i(Object obj, bx bxVar) {
        return bxVar.invoke(this.b.i(obj, bxVar), this.c);
    }

    public final String toString() {
        return fb$1.m(new StringBuilder("["), (String) i(AppConfig.CUSTOM, new ke(0)), ']');
    }

    @Override // defpackage.li
    public final li y(li liVar) {
        return ak.a(this, liVar);
    }
}
