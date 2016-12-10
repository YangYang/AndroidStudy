package com.imudges.AndroidStudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity implements Button.OnClickListener {
    /**
     * Called when the activity is first created.
     */

    /**
     * for visiblity test
     * */
    public TextView mTextView = null;
    public Button btn_vis;
    public Button btn_invis;
    public Button btn_gone;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visiblity_test);
        initData();
        btn_vis.setOnClickListener(this);
        btn_invis.setOnClickListener(this);
        btn_gone.setOnClickListener(this);
    }

    private void initData(){
        btn_vis = (Button) findViewById(R.id.btn_vis);
        btn_invis = (Button) findViewById(R.id.btn_invis);
        btn_gone = (Button) findViewById(R.id.btn_gone);
        mTextView = (TextView) findViewById(R.id.TextView2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_vis: {
                mTextView.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.btn_invis:{
                mTextView.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.btn_gone:{
                mTextView.setVisibility(View.GONE);
                break;
            }
        }
    }
}
