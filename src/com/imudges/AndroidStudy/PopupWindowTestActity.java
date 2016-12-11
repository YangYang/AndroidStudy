package com.imudges.AndroidStudy;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by yangyang on 2016/12/10.
 */
public class PopupWindowTestActity extends Activity implements Button.OnClickListener{
    /**
     * for PopupWindow test
     * */
    PopupWindow mPopupWindow = null;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow);
        initData();
        setButtonClick();
    }

    private void setButtonClick(){
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    private void initData(){
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        /**
         * .inflate()，查找layout/res 下的一个xml布局
         * */
        mPopupWindow = new PopupWindow(getLayoutInflater().inflate(R.layout.popupwindow_test,null), WRAP_CONTENT,WRAP_CONTENT,true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:{
                Log.v("1","点击了btn1");
                if(mPopupWindow !=null){
                    Log.v("!","进入btn1的if");
                    mPopupWindow.setTouchable(false);//控件可被点击
                    mPopupWindow.setOutsideTouchable(true);
                    mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
                    mPopupWindow.showAsDropDown(view);
                }
                else{
                    Log.v("!","进入btn1的else");
                    mPopupWindow = new PopupWindow(getLayoutInflater().inflate(R.layout.popupwindow_test,null), MATCH_PARENT,MATCH_PARENT,true);
                    mPopupWindow.setTouchable(true);
                    mPopupWindow.setOutsideTouchable(true);
                    mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
                    mPopupWindow.showAsDropDown(view);
                }
                break;
            }
            case R.id.btn2:{
                Log.v("2","点击了btn2");
                if(mPopupWindow !=null) {
                    Log.v("!","进入btn2的if");
                    mPopupWindow.setTouchable(false);//控件不可被点击
                    mPopupWindow.setOutsideTouchable(false);
                    mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
                    mPopupWindow.update();
                    mPopupWindow.showAsDropDown(view);
                }
                else{
                    Log.v("!","进入btn2的else");
                    mPopupWindow = new PopupWindow(getLayoutInflater().inflate(R.layout.popupwindow_test,null), MATCH_PARENT,MATCH_PARENT,true);
                    mPopupWindow.setTouchable(false);
                    mPopupWindow.setOutsideTouchable(false);
                    mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
                    mPopupWindow.showAsDropDown(view);
                }
                break;
            }
            case R.id.btn3:{
                Log.v("3","点击了btn3");
                if(mPopupWindow !=null) {
                    Log.v("!","进入btn3的if");
                    mPopupWindow.setTouchable(false);
                    mPopupWindow.setOutsideTouchable(true);
                    mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
                    mPopupWindow.showAsDropDown(view);
                }
                else{
                    Log.v("!","进入btn3的else");
                    mPopupWindow = new PopupWindow(getLayoutInflater().inflate(R.layout.popupwindow_test,null), MATCH_PARENT,MATCH_PARENT,true);
                    mPopupWindow.setTouchable(false);
                    mPopupWindow.setOutsideTouchable(true);
                    mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
                    mPopupWindow.showAsDropDown(view);
                }
                break;
            }
            case R.id.btn4:{
                Log.v("4","点击了btn4");
                if(mPopupWindow !=null) {
                    Log.v("!","进入btn4的if");
                    mPopupWindow.setFocusable(false);
                    /**
                     * 点击返回会直接结束Activity，程序报错，对于setTouchable和setOutsideTouchable，与之前总结的结果相同
                     * */
                    mPopupWindow.setTouchable(false);
                    mPopupWindow.setOutsideTouchable(false);
                    mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
                    mPopupWindow.showAsDropDown(view);
                }
                else{
                    Log.v("!","进入btn4的else");
                    mPopupWindow = new PopupWindow(getLayoutInflater().inflate(R.layout.popupwindow_test,null), MATCH_PARENT,MATCH_PARENT,false);
                    mPopupWindow.setTouchable(false);
                    mPopupWindow.setOutsideTouchable(true);
                    mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
                    mPopupWindow.showAsDropDown(view);
                }
                break;
            }
        }
    }
    public void _onClick(View view){
        Log.v("PopupWindow","Button被点击");
    }
}
