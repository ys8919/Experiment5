package com.example.experiment5;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    private Button btn_1;
    private Button btn_2;
    private TextView textView5;
    private TextView textView6;

    private EditText EditText1;
    private EditText EditText;

    String test1, test2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_1=findViewById(R.id.button);
        btn_2=findViewById(R.id.button2);
        EditText=findViewById(R.id.editText);
        EditText1=findViewById(R.id.editText1);

        ScrollView mScrollView = findViewById(R.id.scrollContent);
        mScrollView.setVerticalScrollBarEnabled(false);
        mScrollView.setHorizontalScrollBarEnabled(false);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);


    }


    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button:
                test1=EditText.getText().toString();
                test2=EditText1.getText().toString();
                if(!test1.equals("")&&!test2.equals("")) {
                    Intent intent=new Intent(MainActivity.this,B_activity.class);
                    intent.putExtra("test1", test1);
                    intent.putExtra("test2", test2);
                    startActivityForResult(intent, 0);
                }else{
                    Toast toast = new Toast(MainActivity.this);
                    Toast toast1 = toast.makeText(MainActivity.this, "输入框不能为空", Toast.LENGTH_LONG);
                    toast1.show();
                }

                break;
            case R.id.button2:
                Intent intent1=new Intent(MainActivity.this,C_activity.class);
                test1=EditText.getText().toString();
                test2=EditText1.getText().toString();
                if(!test1.equals("")&&!test2.equals("")&&!test2.equals("0")){
                    intent1.putExtra("test1",test1);
                    intent1.putExtra("test2",test2);
                    startActivityForResult(intent1,1);
                }else if(test2.equals("0")){
                    Toast toast = new Toast(MainActivity.this);
                    Toast toast1 = toast.makeText(MainActivity.this, "除数不能为0", Toast.LENGTH_LONG);
                    toast1.show();
            }else{
                    Toast toast = new Toast(MainActivity.this);
                    Toast toast1 = toast.makeText(MainActivity.this, "输入框不能为空", Toast.LENGTH_LONG);
                    toast1.show();
                }

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Log.d(TAG, "onActivityResult: 返回");
        if(requestCode==0 && resultCode==RESULT_OK){
            Bundle bundle=intent.getExtras();
            if(!bundle.equals("")){
               // Log.d(TAG, "onActivityResult: bundle"+bundle.getString("Tsum"));
               // Log.d(TAG, "onActivityResult: bundle:"+bundle.getInt("sum"));
                textView5=findViewById(R.id.textView5);
                textView6=findViewById(R.id.textView6);
                textView5.setText(bundle.getString("Tsum"));
                String ssum=""+bundle.getInt("sum");
                textView6.setText(ssum);
            }
        }

        if(requestCode==1 && resultCode==RESULT_OK){
            Bundle bundle=intent.getExtras();
            if(!bundle.equals("")){
              //  Log.d(TAG, "onActivityResult: bundle"+bundle.getString("Tsum"));
               // Log.d(TAG, "onActivityResult: bundle:"+bundle.getInt("sum"));
                textView5=findViewById(R.id.textView5);
                textView6=findViewById(R.id.textView6);
                textView5.setText(bundle.getString("Tsum"));
                String ssum=""+bundle.getFloat("sum");
                textView6.setText(ssum);
            }
        }
    }
}
