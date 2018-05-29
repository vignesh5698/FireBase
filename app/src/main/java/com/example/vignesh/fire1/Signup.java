package com.example.vignesh.fire1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by vignesh on 28/5/18.
 */

public class Signup extends MainActivity {
    private FirebaseAuth mAuth;
    EditText ed3, ed4, ed5;
    Button btn;
    String name1,pass1,mail1;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        mAuth = FirebaseAuth.getInstance();
        ed3 = findViewById(R.id.editText);
        ed4 = findViewById(R.id.editText2);
        ed5 = findViewById(R.id.editText3);
        btn = findViewById(R.id.button);
        tv = findViewById(R.id.textView2);
        name1 = ed3.getText().toString();
        pass1 = ed4.getText().toString();
        mail1 = ed5.getText().toString();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String mail = ed5.getText().toString().trim();
                    String pass = ed4.getText().toString().trim();

                    mAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Signup.this, "Registraton Successful", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(Signup.this, MainActivity.class
                                        // }
                                ));
                            } else {
                                Toast.makeText(Signup.this, "Registraton Failed", Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }

            else{
              Toast.makeText(Signup.this,"Please Fill All Details",Toast.LENGTH_SHORT).show();
            }

        }});

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Signup.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public boolean validate() {
        Boolean a;
        if (ed3.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()
                || ed4.getText().toString().isEmpty())
            a=false;
        else
            a=true;
        return a;
    }

}