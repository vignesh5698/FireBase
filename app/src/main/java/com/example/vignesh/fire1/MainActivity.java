package com.example.vignesh.fire1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button bt1;
    TextView tv1;
    String name,pass;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=mAuth.getCurrentUser();
        ed1=findViewById(R.id.editText);
        ed2=findViewById(R.id.editText2);
        bt1=findViewById(R.id.button);
        tv1=findViewById(R.id.textView2);

        name=ed1.getText().toString();
        pass=ed2.getText().toString();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate(name,pass)){
                    Toast.makeText(MainActivity.this,"Validated",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Enter All Details",Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Signup.class);
                startActivity(intent);
            }
        });

    }

    public boolean validate(String s1, String s2) {
        Boolean a;
        if (s1.isEmpty() && s2.isEmpty())
            a=false;
        else
            a=true;
        return a;
    }
}
