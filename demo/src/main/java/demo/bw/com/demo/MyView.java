package demo.bw.com.demo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    private Paint mPaint;
    private int circleX;
    private  int circleY;
    private int mRaduis=100;
    private int mColor =Color.RED;
    public MyView( Context context ) {
        this(context,null);
    }

    public MyView( Context context,  AttributeSet attrs ) {
        this(context, attrs,0);
    }

    public MyView( Context context,  AttributeSet attrs, int defStyleAttr ) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init( Context context, AttributeSet attrs ) {
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.MyView);
        mRaduis=typedArray.getDimensionPixelSize(R.styleable.MyView_radius,100);
        mColor=typedArray.getColor(R.styleable.MyView_color,Color.RED);
        if (typedArray!=null){
            typedArray.recycle();
        }
        mPaint=new Paint();
        mPaint.setColor(mColor);
        mPaint.setAntiAlias(true);
        //mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
    }

    @Override
    protected void onMeasure( int widthMeasureSpec, int heightMeasureSpec ) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged( int w, int h, int oldw, int oldh ) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onLayout( boolean changed, int left, int top, int right, int bottom ) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onDraw( Canvas canvas ) {
        super.onDraw(canvas);
        canvas.drawCircle(circleX,circleY,mRaduis,mPaint);
    }

}
