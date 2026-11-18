package de.hdodenhof.circleimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import defpackage.d;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class CircleImageView extends ImageView {
    public Bitmap mBitmap;
    public int mBitmapHeight;
    public final Paint mBitmapPaint;
    public BitmapShader mBitmapShader;
    public int mBitmapWidth;
    public final int mBorderColor;
    public final boolean mBorderOverlay;
    public final Paint mBorderPaint;
    public float mBorderRadius;
    public final RectF mBorderRect;
    public final int mBorderWidth;
    public final int mCircleBackgroundColor;
    public final Paint mCircleBackgroundPaint;
    public ColorFilter mColorFilter;
    public float mDrawableRadius;
    public final RectF mDrawableRect;
    public final boolean mReady;
    public boolean mSetupPending;
    public final Matrix mShaderMatrix;
    public static final ImageView.ScaleType SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
    public static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class OutlineProvider extends ViewOutlineProvider {
        public OutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View view, Outline outline) {
            Bitmap.Config config = CircleImageView.BITMAP_CONFIG;
            Rect rect = new Rect();
            CircleImageView.this.mBorderRect.roundOut(rect);
            outline.setRoundRect(rect, rect.width() / 2.0f);
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mCircleBackgroundPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        this.mCircleBackgroundColor = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleImageView, i, 0);
        this.mBorderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.mBorderColor = typedArrayObtainStyledAttributes.getColor(0, -16777216);
        this.mBorderOverlay = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.mCircleBackgroundColor = typedArrayObtainStyledAttributes.getColor(3, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setScaleType(SCALE_TYPE);
        this.mReady = true;
        setOutlineProvider(new OutlineProvider());
        if (this.mSetupPending) {
            setup();
            this.mSetupPending = false;
        }
    }

    @Override // android.widget.ImageView
    public final ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    @Override // android.widget.ImageView
    public final ImageView.ScaleType getScaleType() {
        return SCALE_TYPE;
    }

    public final void initializeBitmap() {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            bitmap = null;
        } else if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            try {
                boolean z = drawable instanceof ColorDrawable;
                Bitmap.Config config = BITMAP_CONFIG;
                Bitmap bitmapCreateBitmap = z ? Bitmap.createBitmap(2, 2, config) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), config);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                bitmap = bitmapCreateBitmap;
            } catch (Exception e) {
                e.printStackTrace();
                bitmap = null;
            }
        }
        this.mBitmap = bitmap;
        setup();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.mBitmap == null) {
            return;
        }
        int i = this.mCircleBackgroundColor;
        RectF rectF = this.mDrawableRect;
        if (i != 0) {
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), this.mDrawableRadius, this.mCircleBackgroundPaint);
        }
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), this.mDrawableRadius, this.mBitmapPaint);
        if (this.mBorderWidth > 0) {
            RectF rectF2 = this.mBorderRect;
            canvas.drawCircle(rectF2.centerX(), rectF2.centerY(), this.mBorderRadius, this.mBorderPaint);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RectF rectF = this.mBorderRect;
        if (!rectF.isEmpty()) {
            if (Math.pow(y - rectF.centerY(), 2.0d) + Math.pow(x - rectF.centerX(), 2.0d) > Math.pow(this.mBorderRadius, 2.0d)) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    public final void setAdjustViewBounds(boolean z) {
        if (z) {
            d.AnonymousClass0.m$2("adjustViewBounds not supported.");
        }
    }

    @Override // android.widget.ImageView
    public final void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.mColorFilter) {
            return;
        }
        this.mColorFilter = colorFilter;
        Paint paint = this.mBitmapPaint;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
        invalidate();
    }

    @Override // android.widget.ImageView
    public final void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        initializeBitmap();
    }

    @Override // android.widget.ImageView
    public final void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        initializeBitmap();
    }

    @Override // android.widget.ImageView
    public final void setImageResource(int i) {
        super.setImageResource(i);
        initializeBitmap();
    }

    @Override // android.widget.ImageView
    public final void setImageURI(Uri uri) {
        super.setImageURI(uri);
        initializeBitmap();
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        setup();
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        setup();
    }

    @Override // android.widget.ImageView
    public final void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == SCALE_TYPE) {
            return;
        }
        d.AnonymousClass0.m$1("ScaleType ", scaleType, " not supported.");
    }

    public final void setup() {
        float fWidth;
        float fHeight;
        if (!this.mReady) {
            this.mSetupPending = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.mBitmap == null) {
            invalidate();
            return;
        }
        Bitmap bitmap = this.mBitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Paint paint = this.mBitmapPaint;
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        paint.setShader(this.mBitmapShader);
        Paint.Style style = Paint.Style.STROKE;
        Paint paint2 = this.mBorderPaint;
        paint2.setStyle(style);
        paint2.setAntiAlias(true);
        paint2.setColor(this.mBorderColor);
        int i = this.mBorderWidth;
        float f = i;
        paint2.setStrokeWidth(f);
        Paint.Style style2 = Paint.Style.FILL;
        Paint paint3 = this.mCircleBackgroundPaint;
        paint3.setStyle(style2);
        paint3.setAntiAlias(true);
        paint3.setColor(this.mCircleBackgroundColor);
        this.mBitmapHeight = this.mBitmap.getHeight();
        this.mBitmapWidth = this.mBitmap.getWidth();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int iMin = Math.min(width, height);
        float paddingLeft = ((width - iMin) / 2.0f) + getPaddingLeft();
        float paddingTop = ((height - iMin) / 2.0f) + getPaddingTop();
        float f2 = iMin;
        RectF rectF = new RectF(paddingLeft, paddingTop, paddingLeft + f2, f2 + paddingTop);
        RectF rectF2 = this.mBorderRect;
        rectF2.set(rectF);
        this.mBorderRadius = Math.min((rectF2.height() - f) / 2.0f, (rectF2.width() - f) / 2.0f);
        RectF rectF3 = this.mDrawableRect;
        rectF3.set(rectF2);
        if (!this.mBorderOverlay && i > 0) {
            float f3 = f - 1.0f;
            rectF3.inset(f3, f3);
        }
        this.mDrawableRadius = Math.min(rectF3.height() / 2.0f, rectF3.width() / 2.0f);
        paint.setColorFilter(this.mColorFilter);
        Matrix matrix = this.mShaderMatrix;
        matrix.set(null);
        float fWidth2 = 0.0f;
        if (rectF3.height() * this.mBitmapWidth > rectF3.width() * this.mBitmapHeight) {
            fWidth = rectF3.height() / this.mBitmapHeight;
            fHeight = 0.0f;
            fWidth2 = (rectF3.width() - (this.mBitmapWidth * fWidth)) * 0.5f;
        } else {
            fWidth = rectF3.width() / this.mBitmapWidth;
            fHeight = (rectF3.height() - (this.mBitmapHeight * fWidth)) * 0.5f;
        }
        matrix.setScale(fWidth, fWidth);
        matrix.postTranslate(((int) (fWidth2 + 0.5f)) + rectF3.left, ((int) (fHeight + 0.5f)) + rectF3.top);
        this.mBitmapShader.setLocalMatrix(matrix);
        invalidate();
    }
}
