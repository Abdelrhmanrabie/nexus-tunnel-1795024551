package defpackage;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.github.ybq.android.spinkit.animation.SpriteAnimatorBuilder$FloatFrameData;
import com.github.ybq.android.spinkit.animation.SpriteAnimatorBuilder$FrameData;
import com.github.ybq.android.spinkit.animation.SpriteAnimatorBuilder$IntFrameData;
import com.github.ybq.android.spinkit.animation.interpolator.KeyFrameInterpolator;
import com.github.ybq.android.spinkit.sprite.Sprite;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class z20 {
    public static final z20 f = new z20();
    public long a;
    public final Object b;
    public Object c;
    public final Object d;
    public int e;

    public z20() {
        this.e = 0;
        this.a = 0L;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    public z20(long j, Object obj, z20 z20Var, z20 z20Var2) {
        this.a = j;
        this.b = obj;
        this.c = z20Var;
        this.d = z20Var2;
        this.e = z20Var.e + 1 + z20Var2.e;
    }

    public z20(Sprite sprite) {
        this.a = 2000L;
        this.e = 0;
        this.b = new HashMap();
        this.d = sprite;
    }

    public Object a(long j) {
        Object obj;
        if (this.e == 0) {
            return null;
        }
        long j2 = this.a;
        if (j < j2) {
            obj = this.c;
        } else {
            if (j <= j2) {
                return this.b;
            }
            obj = this.d;
        }
        return ((z20) obj).a(j - j2);
    }

    public z20 b(long j, pg pgVar) {
        if (this.e == 0) {
            return new z20(j, pgVar, this, this);
        }
        long j2 = this.a;
        z20 z20Var = (z20) this.d;
        z20 z20Var2 = (z20) this.c;
        if (j < j2) {
            return c(z20Var2.b(j - j2, pgVar), z20Var);
        }
        if (j > j2) {
            return c(z20Var2, z20Var.b(j - j2, pgVar));
        }
        return pgVar == this.b ? this : new z20(j, pgVar, z20Var2, z20Var);
    }

    public ObjectAnimator build() {
        HashMap map = (HashMap) this.b;
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[map.size()];
        Iterator it = map.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            SpriteAnimatorBuilder$FrameData spriteAnimatorBuilder$FrameData = (SpriteAnimatorBuilder$FrameData) ((Map.Entry) it.next()).getValue();
            float[] fArr = spriteAnimatorBuilder$FrameData.fractions;
            Keyframe[] keyframeArr = new Keyframe[fArr.length];
            int i2 = this.e;
            float f2 = fArr[i2];
            while (true) {
                int i3 = this.e;
                Object[] objArr = spriteAnimatorBuilder$FrameData.values;
                if (i2 < objArr.length + i3) {
                    int i4 = i2 - i3;
                    int length = i2 % objArr.length;
                    float f3 = fArr[length] - f2;
                    if (f3 < 0.0f) {
                        f3 += fArr[fArr.length - 1];
                    }
                    if (spriteAnimatorBuilder$FrameData instanceof SpriteAnimatorBuilder$IntFrameData) {
                        keyframeArr[i4] = Keyframe.ofInt(f3, ((Integer) objArr[length]).intValue());
                    } else if (spriteAnimatorBuilder$FrameData instanceof SpriteAnimatorBuilder$FloatFrameData) {
                        keyframeArr[i4] = Keyframe.ofFloat(f3, ((Float) objArr[length]).floatValue());
                    } else {
                        keyframeArr[i4] = Keyframe.ofObject(f3, objArr[length]);
                    }
                    i2++;
                }
            }
            propertyValuesHolderArr[i] = PropertyValuesHolder.ofKeyframe(spriteAnimatorBuilder$FrameData.property, keyframeArr);
            i++;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((Sprite) this.d, propertyValuesHolderArr);
        objectAnimatorOfPropertyValuesHolder.setDuration(this.a);
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
        objectAnimatorOfPropertyValuesHolder.setInterpolator((Interpolator) this.c);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public z20 c(z20 z20Var, z20 z20Var2) {
        z20 z20Var3;
        if (z20Var == ((z20) this.c) && z20Var2 == ((z20) this.d)) {
            return this;
        }
        long j = this.a;
        int i = z20Var.e;
        int i2 = z20Var2.e;
        int i3 = i + i2;
        Object obj = this.b;
        if (i3 <= 1) {
            z20Var3 = z20Var2;
        } else {
            if (i >= i2 * 5) {
                z20 z20Var4 = (z20) z20Var.d;
                int i4 = z20Var4.e;
                z20 z20Var5 = (z20) z20Var.c;
                int i5 = z20Var5.e * 2;
                long j2 = z20Var.a;
                long j3 = z20Var4.a;
                if (i4 < i5) {
                    return new z20(j2 + j, z20Var.b, z20Var5, new z20(-j2, obj, z20Var4.d(j3 + j2), z20Var2));
                }
                long j4 = j3 + j2 + j;
                Object obj2 = z20Var4.b;
                Object obj3 = z20Var.b;
                z20 z20Var6 = (z20) z20Var4.c;
                z20 z20Var7 = new z20(-j3, obj3, z20Var5, z20Var6.d(z20Var6.a + j3));
                z20 z20Var8 = (z20) z20Var4.d;
                return new z20(j4, obj2, z20Var7, new z20((-j2) - j3, obj, z20Var8.d(z20Var8.a + j3 + j2), z20Var2));
            }
            z20Var3 = z20Var2;
            if (i2 >= i * 5) {
                z20 z20Var9 = (z20) z20Var3.c;
                int i6 = z20Var9.e;
                z20 z20Var10 = (z20) z20Var3.d;
                int i7 = z20Var10.e * 2;
                long j5 = z20Var3.a;
                long j6 = z20Var9.a;
                if (i6 < i7) {
                    return new z20(j5 + j, z20Var3.b, new z20(-j5, obj, z20Var, z20Var9.d(j6 + j5)), z20Var10);
                }
                long j7 = j6 + j5 + j;
                Object obj4 = z20Var9.b;
                z20 z20Var11 = (z20) z20Var9.c;
                z20 z20Var12 = new z20((-j5) - j6, obj, z20Var, z20Var11.d(z20Var11.a + j6 + j5));
                Object obj5 = z20Var3.b;
                z20 z20Var13 = (z20) z20Var9.d;
                return new z20(j7, obj4, z20Var12, new z20(-j6, obj5, z20Var13.d(z20Var13.a + j6), z20Var10));
            }
        }
        return new z20(j, obj, z20Var, z20Var3);
    }

    public z20 d(long j) {
        if (this.e == 0 || j == this.a) {
            return this;
        }
        return new z20(j, this.b, (z20) this.c, (z20) this.d);
    }

    public void easeInOut(float... fArr) {
        KeyFrameInterpolator keyFrameInterpolator = new KeyFrameInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f), new float[0]);
        keyFrameInterpolator.fractions = fArr;
        this.c = keyFrameInterpolator;
    }

    public void holder(float[] fArr, Property property, Float[] fArr2) {
        int length = fArr.length;
        int length2 = fArr2.length;
        if (length != length2) {
            throw new IllegalStateException(String.format(Locale.getDefault(), "The fractions.length must equal values.length, fraction.length[%d], values.length[%d]", Integer.valueOf(length), Integer.valueOf(length2)));
        }
        ((HashMap) this.b).put(property.getName(), new SpriteAnimatorBuilder$FloatFrameData(fArr, property, fArr2));
    }

    public void holder(float[] fArr, Property property, Integer[] numArr) {
        int length = fArr.length;
        int length2 = numArr.length;
        if (length != length2) {
            throw new IllegalStateException(String.format(Locale.getDefault(), "The fractions.length must equal values.length, fraction.length[%d], values.length[%d]", Integer.valueOf(length), Integer.valueOf(length2)));
        }
        ((HashMap) this.b).put(property.getName(), new SpriteAnimatorBuilder$IntFrameData(fArr, property, numArr));
    }
}
