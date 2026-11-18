package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ShapeAppearancePathProvider {
    public final ShapePath[] cornerPaths = new ShapePath[4];
    public final Matrix[] cornerTransforms = new Matrix[4];
    public final Matrix[] edgeTransforms = new Matrix[4];
    public final PointF pointF = new PointF();
    public final Path overlappedEdgePath = new Path();
    public final Path boundsPath = new Path();
    public final ShapePath shapePath = new ShapePath();
    public final float[] scratch = new float[2];
    public final float[] scratch2 = new float[2];
    public final Path edgePath = new Path();
    public final Path cornerPath = new Path();
    public final boolean edgeIntersectionCheckEnabled = true;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class Lazy {
        public static final ShapeAppearancePathProvider INSTANCE = new ShapeAppearancePathProvider();

        private Lazy() {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class ShapeAppearancePathSpec {
        public final RectF bounds;
        public final float interpolation;
        public final Path path;
        public final PathListener pathListener;
        public final ShapeAppearanceModel shapeAppearanceModel;

        public ShapeAppearancePathSpec(ShapeAppearanceModel shapeAppearanceModel, float f, RectF rectF, PathListener pathListener, Path path) {
            this.pathListener = pathListener;
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.interpolation = f;
            this.bounds = rectF;
            this.path = path;
        }
    }

    public ShapeAppearancePathProvider() {
        for (int i = 0; i < 4; i++) {
            this.cornerPaths[i] = new ShapePath();
            this.cornerTransforms[i] = new Matrix();
            this.edgeTransforms[i] = new Matrix();
        }
    }

    public static ShapeAppearancePathProvider getInstance() {
        return Lazy.INSTANCE;
    }

    public final void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f, RectF rectF, PathListener pathListener, Path path) {
        Matrix[] matrixArr;
        float[] fArr;
        ShapePath[] shapePathArr;
        Matrix[] matrixArr2;
        float f2;
        RectF rectF2;
        ShapeAppearanceModel shapeAppearanceModel2;
        int i;
        int i2;
        float fCenterX;
        float f3;
        EdgeTreatment edgeTreatment;
        int i3;
        Matrix matrix;
        CornerSize cornerSize;
        CornerTreatment cornerTreatment;
        float f4;
        float f5;
        path.rewind();
        Path path2 = this.overlappedEdgePath;
        path2.rewind();
        Path path3 = this.boundsPath;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f, rectF, pathListener, path);
        int i4 = 0;
        while (true) {
            matrixArr = this.edgeTransforms;
            fArr = this.scratch;
            shapePathArr = this.cornerPaths;
            matrixArr2 = this.cornerTransforms;
            f2 = shapeAppearancePathSpec.interpolation;
            rectF2 = shapeAppearancePathSpec.bounds;
            shapeAppearanceModel2 = shapeAppearancePathSpec.shapeAppearanceModel;
            i2 = 1;
            if (i4 >= 4) {
                break;
            }
            if (i4 == 1) {
                cornerSize = shapeAppearanceModel2.bottomRightCornerSize;
            } else if (i4 != 2) {
                cornerSize = i4 != 3 ? shapeAppearanceModel2.topRightCornerSize : shapeAppearanceModel2.topLeftCornerSize;
            } else {
                cornerSize = shapeAppearanceModel2.bottomLeftCornerSize;
            }
            if (i4 == 1) {
                cornerTreatment = shapeAppearanceModel2.bottomRightCorner;
            } else if (i4 != 2) {
                cornerTreatment = i4 != 3 ? shapeAppearanceModel2.topRightCorner : shapeAppearanceModel2.topLeftCorner;
            } else {
                cornerTreatment = shapeAppearanceModel2.bottomLeftCorner;
            }
            ShapePath shapePath = shapePathArr[i4];
            cornerTreatment.getClass();
            cornerTreatment.getCornerPath(shapePath, f2, cornerSize.getCornerSize(rectF2));
            int i5 = i4 + 1;
            float f6 = i5 * 90;
            matrixArr2[i4].reset();
            if (i4 != 1) {
                if (i4 != 2) {
                    f4 = i4 != 3 ? rectF2.right : rectF2.left;
                    f5 = rectF2.top;
                } else {
                    f4 = rectF2.left;
                }
                PointF pointF = this.pointF;
                pointF.set(f4, f5);
                matrixArr2[i4].setTranslate(pointF.x, pointF.y);
                matrixArr2[i4].preRotate(f6);
                ShapePath shapePath2 = shapePathArr[i4];
                fArr[0] = shapePath2.endX;
                fArr[1] = shapePath2.endY;
                matrixArr2[i4].mapPoints(fArr);
                matrixArr[i4].reset();
                matrixArr[i4].setTranslate(fArr[0], fArr[1]);
                matrixArr[i4].preRotate(f6);
                i4 = i5;
            } else {
                f4 = rectF2.right;
            }
            f5 = rectF2.bottom;
            PointF pointF2 = this.pointF;
            pointF2.set(f4, f5);
            matrixArr2[i4].setTranslate(pointF2.x, pointF2.y);
            matrixArr2[i4].preRotate(f6);
            ShapePath shapePath3 = shapePathArr[i4];
            fArr[0] = shapePath3.endX;
            fArr[1] = shapePath3.endY;
            matrixArr2[i4].mapPoints(fArr);
            matrixArr[i4].reset();
            matrixArr[i4].setTranslate(fArr[0], fArr[1]);
            matrixArr[i4].preRotate(f6);
            i4 = i5;
        }
        int i6 = 0;
        for (i = 4; i6 < i; i = 4) {
            ShapePath shapePath4 = shapePathArr[i6];
            fArr[0] = shapePath4.startX;
            fArr[i2] = shapePath4.startY;
            matrixArr2[i6].mapPoints(fArr);
            Path path4 = shapeAppearancePathSpec.path;
            if (i6 == 0) {
                path4.moveTo(fArr[0], fArr[i2]);
            } else {
                path4.lineTo(fArr[0], fArr[i2]);
            }
            shapePathArr[i6].applyToPath(matrixArr2[i6], path4);
            PathListener pathListener2 = shapeAppearancePathSpec.pathListener;
            if (pathListener2 != null) {
                pathListener2.onCornerPathCreated(shapePathArr[i6], matrixArr2[i6], i6);
            }
            int i7 = i6 + 1;
            int i8 = i7 % 4;
            ShapePath shapePath5 = shapePathArr[i6];
            ShapeAppearancePathSpec shapeAppearancePathSpec2 = shapeAppearancePathSpec;
            fArr[0] = shapePath5.endX;
            fArr[i2] = shapePath5.endY;
            matrixArr2[i6].mapPoints(fArr);
            ShapePath shapePath6 = shapePathArr[i8];
            float f7 = shapePath6.startX;
            float[] fArr2 = this.scratch2;
            fArr2[0] = f7;
            fArr2[i2] = shapePath6.startY;
            matrixArr2[i8].mapPoints(fArr2);
            Matrix[] matrixArr3 = matrixArr;
            ShapePath[] shapePathArr2 = shapePathArr;
            Matrix[] matrixArr4 = matrixArr2;
            float fMax = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[i2] - fArr2[i2])) - 0.001f, 0.0f);
            ShapePath shapePath7 = shapePathArr2[i6];
            fArr[0] = shapePath7.endX;
            fArr[i2] = shapePath7.endY;
            matrixArr4[i6].mapPoints(fArr);
            int i9 = i2;
            if (i6 == i9 || i6 == 3) {
                fCenterX = rectF2.centerX();
                f3 = fArr[0];
            } else {
                fCenterX = rectF2.centerY();
                f3 = fArr[i9];
            }
            float fAbs = Math.abs(fCenterX - f3);
            ShapePath shapePath8 = this.shapePath;
            shapePath8.reset(0.0f, 0.0f, 270.0f, 0.0f);
            if (i6 == 1) {
                edgeTreatment = shapeAppearanceModel2.bottomEdge;
            } else if (i6 != 2) {
                edgeTreatment = i6 != 3 ? shapeAppearanceModel2.rightEdge : shapeAppearanceModel2.topEdge;
            } else {
                edgeTreatment = shapeAppearanceModel2.leftEdge;
            }
            edgeTreatment.getEdgePath(fMax, fAbs, f2, shapePath8);
            Path path5 = this.edgePath;
            path5.reset();
            shapePath8.applyToPath(matrixArr3[i6], path5);
            if (this.edgeIntersectionCheckEnabled && (edgeTreatment.forceIntersection() || pathOverlapsCorner(path5, i6) || pathOverlapsCorner(path5, i8))) {
                path5.op(path5, path3, Path.Op.DIFFERENCE);
                fArr[0] = shapePath8.startX;
                i3 = 1;
                fArr[1] = shapePath8.startY;
                matrixArr3[i6].mapPoints(fArr);
                path2.moveTo(fArr[0], fArr[1]);
                matrix = matrixArr3[i6];
                path4 = path2;
            } else {
                i3 = 1;
                matrix = matrixArr3[i6];
            }
            shapePath8.applyToPath(matrix, path4);
            if (pathListener2 != null) {
                pathListener2.onEdgePathCreated(shapePath8, matrixArr3[i6], i6);
            }
            i2 = i3;
            i6 = i7;
            shapeAppearancePathSpec = shapeAppearancePathSpec2;
            shapePathArr = shapePathArr2;
            matrixArr2 = matrixArr4;
            matrixArr = matrixArr3;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public final boolean pathOverlapsCorner(Path path, int i) {
        Path path2 = this.cornerPath;
        path2.reset();
        this.cornerPaths[i].applyToPath(this.cornerTransforms[i], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }
}
