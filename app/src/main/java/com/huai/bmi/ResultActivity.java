package com.huai.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        float bmi = getIntent().getFloatExtra(getString(R.string.extra_bmi), 0);
        TextView result = (TextView) findViewById(R.id.bmi_result);
        result.setText("YOUR BMI IS "+bmi);
    }
}
