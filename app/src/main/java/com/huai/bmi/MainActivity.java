package com.huai.bmi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String s = new String("123");
    private EditText edweight;  //屬性
    private EditText edheight;

    /*View.OnClickListener listener = new View.OnClickListener() {
       @Override
        public void onClick(View view) {

        }
    };*/

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate");
        //  EditText edweight = (EditText) findViewById(R.id.ed_weight);      區域變數(在onCreate裡)
        Button bHelp = findViews();
        bHelp.setOnClickListener( new View.OnClickListener() {//匿名類別
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("BMI說明")
                        .setMessage("BMI 是..........")
                        .setPositiveButton("OK", null)
                        .show();
            }

        });

   //     getResources().getString(R.string.app_name);
    }

    private Button findViews() {
        edweight = (EditText) findViewById(R.id.ed_weight);     //(ctrl + alt + f)區域變數提升為屬性
        edheight = (EditText) findViewById(R.id.ed_height);
        return (Button) findViewById(R.id.b_help);
    }

    public void bmi(View view){
   //     System.out.println("what??");     sout(快速鍵印出system.out.println)
        Log.d("MainActivity","testing bmi method");

        float weight = Float.parseFloat(edweight.getText().toString());
        float height = Float.parseFloat(edheight.getText().toString());
        float bmi = weight / (height * height);

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(getString(R.string.extra_bmi), bmi);
        startActivity(intent);  //轉換到ResultActivity

            /*new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.your_bmi_is)+bmi)  //後面有加其餘字串，不可直接用R.string.your_bmi_is，須加getString
                    .setTitle(R.string.my_title)
                    .setPositiveButton(R.string.ok, null)
                    .show();*/

       /* if(bmi<20) {
            new AlertDialog.Builder(this)
                    .setMessage(bmi+"請多吃點")
                    .setPositiveButton("OK", null)
                    .show();
            }*/

       /* Log.d("MainActivity" , "Your bmi is"+ bmi);
        Toast.makeText(this,
                "Your BMI is " + bmi,
                Toast.LENGTH_SHORT)
                .show();*/

    }
}
