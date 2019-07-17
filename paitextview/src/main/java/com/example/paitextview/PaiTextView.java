package com.example.paitextview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class PaiTextView extends TextView {
    //private int backColor=Color.WHITE;//背景颜色
    private int fillColor=Color.WHITE;//设置填充颜色
    private int strokeWidth=0;//设置边框宽度
    private int strokeColor=Color.WHITE;//设置边框颜色
    private int topRadius=0;//左上圆角半径
    private int rightRadius=0;//右上圆角半径
    private int bottomRadius=0;//右下圆角半径
    private int leftRadius=0;//左下圆角半径
    private int gradientType=GradientDrawable.SWEEP_GRADIENT;//设置渐变形状
    private int gradientX=0;//设置渐变X坐标
    private int gradientY=0;//设置渐变Y坐标
    private GradientDrawable.Orientation gradientOrientation= GradientDrawable.Orientation.LEFT_RIGHT;//设置渐变方向
    private int[] gradientColors;//设置渐变颜色数组
    private GradientDrawable gradientDrawable;
    private boolean isAre=false;//是否是圆形

    private float[] radius;

    private onClickListener onClickListener;

    public PaiTextView(Context context) {
        super(context);
    }

    public PaiTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PaiTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PaiTextView setOnClickListener(PaiTextView.onClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }

    public PaiTextView setAre(boolean are) {
        isAre = are;
        return this;
    }

    public PaiTextView setGradientColors(int[] gradientColors) {
        this.gradientColors = gradientColors;
        return this;
    }

    public PaiTextView setGradientType(int gradientType) {
        this.gradientType = gradientType;
        return this;
    }

    public PaiTextView setGradientOrientation(GradientDrawable.Orientation gradientOrientation) {
        this.gradientOrientation = gradientOrientation;
        return this;
    }

    public PaiTextView setGradientCenter(int gradientX, int gradientY){
        this.gradientX=gradientX;
        this.gradientY=gradientY;
        return this;
    }

    public PaiTextView setRadius(int topRadius,int rightRadius,int bottomRadius,int leftRadius){
        this.topRadius=topRadius;
        this.rightRadius=rightRadius;
        this.bottomRadius=bottomRadius;
        this.leftRadius=leftRadius;
        return this;
    }

    public PaiTextView setFillColor(int fillColor) {
        this.fillColor = fillColor;
        return this;
    }

    public PaiTextView setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
        return this;
    }

    public PaiTextView setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        return this;
    }

//    public PaiTextView setBackColor(int backColor){
//        this.backColor=backColor;
//        return this;
//    }

    public PaiTextView init() {
        if(gradientColors!=null){
            gradientDrawable=new GradientDrawable(gradientOrientation,gradientColors);
        }else{
            gradientDrawable=new GradientDrawable();
        }
        radius=new float[]{topRadius,topRadius,rightRadius,rightRadius,bottomRadius,bottomRadius,leftRadius,leftRadius};
        gradientDrawable.setCornerRadii(radius);
        gradientDrawable.setColor(fillColor);
        gradientDrawable.setGradientType(gradientType);
        gradientDrawable.setGradientCenter(gradientX,gradientY);
        gradientDrawable.setStroke(strokeWidth,strokeColor);
        if(isAre) {
            gradientDrawable.setShape(GradientDrawable.OVAL);
        }
        this.setBackground(gradientDrawable);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //PaiTextView.this.setBackgroundColor(Color.RED);
                onClickListener.onClick(v);
            }
        });
        return this;
    }

    public interface onClickListener{
        void onClick(View v);
    }
}