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
    Button btn5;


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
        btn5.setOnClickListener(this);
    }

    private void initData(){
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
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
                   /* mPopupWindow.setTouchInterceptor(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if(motionEvent.getAction() == MotionEvent.ACTION_OUTSIDE){
                                mPopupWindow.dismiss();
                                return true;
                            }
                            return false;
                        }
                    });*/
                    Log.v("!","进入btn1的if");
                    mPopupWindow.setTouchable(false);
                    mPopupWindow.setOutsideTouchable(true);
                    mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
                    mPopupWindow.showAsDropDown(view);
                }
                else{
                    Log.v("!","进入btn1的else");
                    mPopupWindow = new PopupWindow(getLayoutInflater().inflate(R.layout.popupwindow_test,null), MATCH_PARENT,MATCH_PARENT,true);
                    /**
                     * setTouchable()参数
                     * true：点击加载出来的view 不消失，点击加载它的控件 view 消失（相当于点击空白区域）
                     * false: 点击加载出来的view 消失，点击加载它的控件 会再次弹出
                     * */
                    mPopupWindow.setTouchable(true);
                    /**
                     * setOutsideTouchable()
                     * true:点击空白区域，加载出的控件会消失，点返回也会消失
                     * false：点击空白区域不会消失，点击返回会消失
                     * */
                    mPopupWindow.setOutsideTouchable(false);
                    mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
                    mPopupWindow.showAsDropDown(view);
                }
                break;
            }
            case R.id.btn2:{
                Log.v("2","点击了btn2");
                if(mPopupWindow !=null) {
                    Log.v("!","进入btn2的if");
                    mPopupWindow.setTouchable(false);
                    mPopupWindow.setOutsideTouchable(false);
                    mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
                    mPopupWindow.showAsDropDown(view);
                }
                break;
            }
            case R.id.btn3:{

            }
            case R.id.btn4:{

            }
            case R.id.btn5:{

            }
        }
    }
}
