package com.limox.jesus.monksresurrection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

public class StartSignUp_Activity extends AppCompatActivity {

    TextView mTxvSignUp;
    AdapterView.OnClickListener mClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_sign_up);
        mTxvSignUp = (TextView) findViewById(R.id.ssu_txvSignUp);

        mClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){

                    case R.id.ssu_txvSignUp:
                        startActivity(new Intent(StartSignUp_Activity.this,SignUpEmail_Activity.class));
                        break;
                }
            }
        };

        mTxvSignUp.setOnClickListener(mClickListener);
    }
}
