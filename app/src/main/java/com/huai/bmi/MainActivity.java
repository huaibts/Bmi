package com.huai.bmi;

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
    /*View.OnClickListener listener = new View.OnClickListener() {
       @Override
        public void onClick(View view) {

        }
    };*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bHelp = (Button) findViewById(R.id.b_help);
        bHelp.setOnClickListener( new View.OnClickListener() {
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
    public void bmi(View view){
   //     System.out.println("what??");     sout(快速鍵印出system.out.println)
        Log.d("MainActivity","testing bmi method");
        EditText edweight = (EditText) findViewById(R.id.ed_weight);
        EditText edheight = (EditText) findViewById(R.id.ed_height);
        float weight = Float.parseFloat(edweight.getText().toString());
        float height = Float.parseFloat(edheight.getText().toString());
        float bmi = weight / (height * height);

        if (height>3) {
            new AlertDialog.Builder(this)
                    .setMessage( "身高單位應為公尺")  //後面有加其餘字串，不可直接用R.string.your_bmi_is，須加getString
                    .setTitle(R.string.my_title)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        }
        /*if(bmi<20) {
            new AlertDialog.Builder(this)
                    .setMessage("請多吃點")
                    .setMessage("Your bmi is" + bmi)
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
