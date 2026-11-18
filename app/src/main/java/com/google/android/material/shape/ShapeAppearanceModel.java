package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ShapeAppearanceModel {
    public static final RelativeCornerSize PILL = new RelativeCornerSize(0.5f);
    public final EdgeTreatment bottomEdge;
    public final CornerTreatment bottomLeftCorner;
    public final CornerSize bottomLeftCornerSize;
    public final CornerTreatment bottomRightCorner;
    public final CornerSize bottomRightCornerSize;
    public final EdgeTreatment leftEdge;
    public final EdgeTreatment rightEdge;
    public final EdgeTreatment topEdge;
    public final CornerTreatment topLeftCorner;
    public final CornerSize topLeftCornerSize;
    public final CornerTreatment topRightCorner;
    public final CornerSize topRightCornerSize;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class Builder {
        public EdgeTreatment bottomEdge;
        public CornerTreatment bottomLeftCorner;
        public CornerSize bottomLeftCornerSize;
        public CornerTreatment bottomRightCorner;
        public CornerSize bottomRightCornerSize;
        public final EdgeTreatment leftEdge;
        public final EdgeTreatment rightEdge;
        public EdgeTreatment topEdge;
        public CornerTreatment topLeftCorner;
        public CornerSize topLeftCornerSize;
        public CornerTreatment topRightCorner;
        public CornerSize topRightCornerSize;

        public Builder() {
            this.topLeftCorner = new RoundedCornerTreatment();
            this.topRightCorner = new RoundedCornerTreatment();
            this.bottomRightCorner = new RoundedCornerTreatment();
            this.bottomLeftCorner = new RoundedCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topEdge = new EdgeTreatment();
            this.rightEdge = new EdgeTreatment();
            this.bottomEdge = new EdgeTreatment();
            this.leftEdge = new EdgeTreatment();
        }

        public Builder(ShapeAppearanceModel shapeAppearanceModel) {
            this.topLeftCorner = new RoundedCornerTreatment();
            this.topRightCorner = new RoundedCornerTreatment();
            this.bottomRightCorner = new RoundedCornerTreatment();
            this.bottomLeftCorner = new RoundedCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topEdge = new EdgeTreatment();
            this.rightEdge = new EdgeTreatment();
            this.bottomEdge = new EdgeTreatment();
            this.leftEdge = new EdgeTreatment();
            this.topLeftCorner = shapeAppearanceModel.topLeftCorner;
            this.topRightCorner = shapeAppearanceModel.topRightCorner;
            this.bottomRightCorner = shapeAppearanceModel.bottomRightCorner;
            this.bottomLeftCorner = shapeAppearanceModel.bottomLeftCorner;
            this.topLeftCornerSize = shapeAppearanceModel.topLeftCornerSize;
            this.topRightCornerSize = shapeAppearanceModel.topRightCornerSize;
            this.bottomRightCornerSize = shapeAppearanceModel.bottomRightCornerSize;
            this.bottomLeftCornerSize = shapeAppearanceModel.bottomLeftCornerSize;
            this.topEdge = shapeAppearanceModel.topEdge;
            this.rightEdge = shapeAppearanceModel.rightEdge;
            this.bottomEdge = shapeAppearanceModel.bottomEdge;
            this.leftEdge = shapeAppearanceModel.leftEdge;
        }

        public static float compatCornerTreatmentSize(CornerTreatment cornerTreatment) {
            if (cornerTreatment instanceof RoundedCornerTreatment) {
                return ((RoundedCornerTreatment) cornerTreatment).radius;
            }
            if (cornerTreatment instanceof CutCornerTreatment) {
                return ((CutCornerTreatment) cornerTreatment).size;
            }
            return -1.0f;
        }

        public final ShapeAppearanceModel build() {
            return new ShapeAppearanceModel(this);
        }

        public final void setAllCornerSizes(float f) {
            this.topLeftCornerSize = new AbsoluteCornerSize(f);
            this.topRightCornerSize = new AbsoluteCornerSize(f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(f);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface CornerSizeUnaryOperator {
        CornerSize apply(CornerSize cornerSize);
    }

    public ShapeAppearanceModel() {
        this.topLeftCorner = new RoundedCornerTreatment();
        this.topRightCorner = new RoundedCornerTreatment();
        this.bottomRightCorner = new RoundedCornerTreatment();
        this.bottomLeftCorner = new RoundedCornerTreatment();
        this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topEdge = new EdgeTreatment();
        this.rightEdge = new EdgeTreatment();
        this.bottomEdge = new EdgeTreatment();
        this.leftEdge = new EdgeTreatment();
    }

    private ShapeAppearanceModel(Builder builder) {
        this.topLeftCorner = builder.topLeftCorner;
        this.topRightCorner = builder.topRightCorner;
        this.bottomRightCorner = builder.bottomRightCorner;
        this.bottomLeftCorner = builder.bottomLeftCorner;
        this.topLeftCornerSize = builder.topLeftCornerSize;
        this.topRightCornerSize = builder.topRightCornerSize;
        this.bottomRightCornerSize = builder.bottomRightCornerSize;
        this.bottomLeftCornerSize = builder.bottomLeftCornerSize;
        this.topEdge = builder.topEdge;
        this.rightEdge = builder.rightEdge;
        this.bottomEdge = builder.bottomEdge;
        this.leftEdge = builder.leftEdge;
    }

    public static Builder builder(Context context, int i, int i2) {
        return builder(context, i, i2, new AbsoluteCornerSize(0));
    }

    public static Builder builder(Context context, int i, int i2, CornerSize cornerSize) {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.ShapeAppearance);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(0, 0);
            int i4 = typedArrayObtainStyledAttributes.getInt(3, i3);
            int i5 = typedArrayObtainStyledAttributes.getInt(4, i3);
            int i6 = typedArrayObtainStyledAttributes.getInt(2, i3);
            int i7 = typedArrayObtainStyledAttributes.getInt(1, i3);
            CornerSize cornerSize2 = getCornerSize(typedArrayObtainStyledAttributes, 5, cornerSize);
            CornerSize cornerSize3 = getCornerSize(typedArrayObtainStyledAttributes, 8, cornerSize2);
            CornerSize cornerSize4 = getCornerSize(typedArrayObtainStyledAttributes, 9, cornerSize2);
            CornerSize cornerSize5 = getCornerSize(typedArrayObtainStyledAttributes, 7, cornerSize2);
            CornerSize cornerSize6 = getCornerSize(typedArrayObtainStyledAttributes, 6, cornerSize2);
            Builder builder = new Builder();
            CornerTreatment cornerTreatmentCreateCornerTreatment = MaterialShapeUtils.createCornerTreatment(i4);
            builder.topLeftCorner = cornerTreatmentCreateCornerTreatment;
            float fCompatCornerTreatmentSize = Builder.compatCornerTreatmentSize(cornerTreatmentCreateCornerTreatment);
            if (fCompatCornerTreatmentSize != -1.0f) {
                builder.topLeftCornerSize = new AbsoluteCornerSize(fCompatCornerTreatmentSize);
            }
            builder.topLeftCornerSize = cornerSize3;
            CornerTreatment cornerTreatmentCreateCornerTreatment2 = MaterialShapeUtils.createCornerTreatment(i5);
            builder.topRightCorner = cornerTreatmentCreateCornerTreatment2;
            float fCompatCornerTreatmentSize2 = Builder.compatCornerTreatmentSize(cornerTreatmentCreateCornerTreatment2);
            if (fCompatCornerTreatmentSize2 != -1.0f) {
                builder.topRightCornerSize = new AbsoluteCornerSize(fCompatCornerTreatmentSize2);
            }
            builder.topRightCornerSize = cornerSize4;
            CornerTreatment cornerTreatmentCreateCornerTreatment3 = MaterialShapeUtils.createCornerTreatment(i6);
            builder.bottomRightCorner = cornerTreatmentCreateCornerTreatment3;
            float fCompatCornerTreatmentSize3 = Builder.compatCornerTreatmentSize(cornerTreatmentCreateCornerTreatment3);
            if (fCompatCornerTreatmentSize3 != -1.0f) {
                builder.bottomRightCornerSize = new AbsoluteCornerSize(fCompatCornerTreatmentSize3);
            }
            builder.bottomRightCornerSize = cornerSize5;
            CornerTreatment cornerTreatmentCreateCornerTreatment4 = MaterialShapeUtils.createCornerTreatment(i7);
            builder.bottomLeftCorner = cornerTreatmentCreateCornerTreatment4;
            float fCompatCornerTreatmentSize4 = Builder.compatCornerTreatmentSize(cornerTreatmentCreateCornerTreatment4);
            if (fCompatCornerTreatmentSize4 != -1.0f) {
                builder.bottomLeftCornerSize = new AbsoluteCornerSize(fCompatCornerTreatmentSize4);
            }
            builder.bottomLeftCornerSize = cornerSize6;
            return builder;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static Builder builder(Context context, AttributeSet attributeSet, int i, int i2) {
        return builder(context, attributeSet, i, i2, new AbsoluteCornerSize(0));
    }

    public static Builder builder(Context context, AttributeSet attributeSet, int i, int i2, CornerSize cornerSize) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return builder(context, resourceId, resourceId2, cornerSize);
    }

    public static CornerSize getCornerSize(TypedArray typedArray, int i, CornerSize cornerSize) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue != null) {
            int i2 = typedValuePeekValue.type;
            if (i2 == 5) {
                return new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i2 == 6) {
                return new RelativeCornerSize(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return cornerSize;
    }

    public final boolean isRoundRect(RectF rectF) {
        boolean z = this.leftEdge.getClass().equals(EdgeTreatment.class) && this.rightEdge.getClass().equals(EdgeTreatment.class) && this.topEdge.getClass().equals(EdgeTreatment.class) && this.bottomEdge.getClass().equals(EdgeTreatment.class);
        float cornerSize = this.topLeftCornerSize.getCornerSize(rectF);
        return z && ((this.topRightCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.topRightCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.bottomLeftCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.bottomLeftCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.bottomRightCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.bottomRightCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0) && ((this.topRightCorner instanceof RoundedCornerTreatment) && (this.topLeftCorner instanceof RoundedCornerTreatment) && (this.bottomRightCorner instanceof RoundedCornerTreatment) && (this.bottomLeftCorner instanceof RoundedCornerTreatment));
    }

    public final ShapeAppearanceModel withTransformedCornerSizes(CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        Builder builder = new Builder(this);
        builder.topLeftCornerSize = cornerSizeUnaryOperator.apply(this.topLeftCornerSize);
        builder.topRightCornerSize = cornerSizeUnaryOperator.apply(this.topRightCornerSize);
        builder.bottomLeftCornerSize = cornerSizeUnaryOperator.apply(this.bottomLeftCornerSize);
        builder.bottomRightCornerSize = cornerSizeUnaryOperator.apply(this.bottomRightCornerSize);
        return builder.build();
    }
}
