package com.example.experiment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class B_activity extends AppCompatActivity {

    private static final String TAG = "B_activity";
    private TextView textView8;
    private Button Button3;
    private  int sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_activity);
        textView8=findViewById(R.id.textView8);
        Button3=findViewById(R.id.button3);

        Intent intent =getIntent();
      //  Log.d(TAG, "onCreate: 进入");
        String text1 =intent.getStringExtra("test1");
        String text2 =intent.getStringExtra("test2");
        if(!text1.equals("")&&!text2.equals("")){
            //Log.d(TAG, "onCreate: text1:"+text1);
            sum=Integer.parseInt(text1)*Integer.parseInt(text2);
          //  Log.d(TAG, "onCreate: sum:"+sum);
            String text=text1+"*"+text2+"="+sum;
            textView8.setText(text);
        }

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =getIntent();
                Bundle bundle =new Bundle();
                bundle.putInt("sum",sum);
                bundle.putString("Tsum","乘法");
                intent.putExtras(bundle);
                Log.d(TAG, "onClick: Button3 ");
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}
