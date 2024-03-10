package org.prebid.mobile.rendering.views.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import org.prebid.mobile.core.R;

public class RoundedImageView extends ImageView {
    private float mCornerRadius = 0;

    private final Path path = new Path();
    private RectF rectF = new RectF(0, 0, 0, 0);

    public RoundedImageView(Context context) {
        super(context);
        init(null, 0);
    }

    public RoundedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public RoundedImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.RoundedImageView, defStyle, 0);

        mCornerRadius = a.getDimension(
                R.styleable.RoundedImageView_cornerRadius,
                mCornerRadius);

        a.recycle();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF = new RectF(0, 0, w, h);
        resetPath();
    }

    @Override
    public void draw(Canvas canvas) {
        int save = canvas.save();
        canvas.clipPath(path);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        int save = canvas.save();
        canvas.clipPath(path);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    private void resetPath() {
        path.reset();
        path.addRoundRect(rectF, mCornerRadius, mCornerRadius, Path.Direction.CW);
        path.close();
    }

    public float getCornerRadius() {
        return mCornerRadius;
    }

    public void setCornerRadius(float cornerRadius) {
        this.mCornerRadius = cornerRadius;
    }
}