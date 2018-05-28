package com.example.vignesh.fire1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by vignesh on 28/5/18.
 */

public class Signup extends MainActivity {

    EditText ed3, ed4, ed5;
    Button btn;
    String name,pass,mail;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        ed3 = findViewById(R.id.editText);
        ed4 = findViewById(R.id.editText2);
        ed5 = findViewById(R.id.editText3);
        btn=findViewById(R.id.button);
        tv=findViewById(R.id.textView2);
        name=ed3.getText().toString();
        pass=ed4.getText().toString();
        mail=ed5.getText().toString();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate(name,pass,mail)){
                    Toast.makeText(Signup.this,"Validated",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Signup.this,"Please Fill All Details",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Signup.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public boolean validate(String s1, String s2, String s3) {
        Boolean a;
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty())
            a=false;
        else
            a=true;
        return a;
    }

}