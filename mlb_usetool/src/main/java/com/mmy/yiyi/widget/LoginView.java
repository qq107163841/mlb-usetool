package com.mmy.yiyi.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.mmy.yiyi.R;


/**
 * 创建自帅气的 清川 on 2020/6/19
 * 显示滑动多少的进度条
 */
public class LoginView extends View {

    private Paint mPaint;
    private float mCurrentValue;
    private int mRadius=100;
    private int mSelectColor;
    private String texttop="";
    private String textdown="";
    public LoginView(Context context) {
        super(context);
    }

    public LoginView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta =  context.obtainStyledAttributes(attrs, R.styleable.LoginView);
        mRadius =(int) ta.getDimension(R.styleable.LoginView_loginradius,100);
        mSelectColor = ta.getColor(R.styleable.LoginView_logincolor, getResources().getColor(R.color.b));
        texttop = ta.getString(R.styleable.LoginView_logintop);
        textdown = ta.getString(R.styleable.LoginView_logindown);
    }

    public LoginView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta =  context.obtainStyledAttributes(attrs, R.styleable.LoginView);
        mRadius =(int) ta.getDimension(R.styleable.LoginView_loginradius,100);
        mSelectColor = ta.getColor(R.styleable.LoginView_logincolor, getResources().getColor(R.color.b));
        texttop = ta.getString(R.styleable.LoginView_logintop);
        textdown = ta.getString(R.styleable.LoginView_logindown);
    }

    @SuppressLint("NewApi")
    @Override
    public void draw(Canvas canvas) {
        Path path = new Path();
        path.addRoundRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mRadius, mRadius, Path.Direction.CW);
        canvas.clipPath(path);
        super.draw(canvas);
    }

    public void setmCurrentValue(float mCurrentValue) {
        this.mCurrentValue = getMeasuredWidth()/3*mCurrentValue;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
        mPaint.setColor(mSelectColor);
        canvas.drawRect(0, 0, mCurrentValue, getMeasuredHeight(), mPaint);
        //
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(1);
        mPaint.setTextSize(50);
        Rect bounds = new Rect();
        mPaint.getTextBounds(texttop ,0, texttop.length(), bounds);
        canvas.drawText(texttop,getMeasuredWidth()/2 - bounds.width()/2, getMeasuredHeight()/3*1 + bounds.height()/3*1, mPaint);

        //
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(1);
        mPaint.setTextSize(30);
        Rect boundss = new Rect();
        mPaint.getTextBounds(textdown ,0, textdown.length(), boundss);
        canvas.drawText(textdown,getMeasuredWidth()/2 - boundss.width()/2, getMeasuredHeight()/6*4 + boundss.height()/6*4, mPaint);
        if(mCurrentValue>=getMeasuredWidth()){
            if(loginView!=null){
                loginView.onOk();
            }
        }
    }

    public void setTexttop(String t1){
        this.texttop=t1;

    }

    public void setTextdown(String textdown) {
        this.textdown = textdown;
    }

    public interface loginView{
        void onOk();
    }
    loginView loginView;

    public void setLoginView(LoginView.loginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN|| event.getAction()==MotionEvent.ACTION_MOVE ) {
            mCurrentValue = ((int) event.getX());
        }
        invalidate();
        Log.i("mlb","X = "+getX() );
        return true;

    }



}
