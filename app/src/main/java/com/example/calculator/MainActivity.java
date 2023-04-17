package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button add_btn,sub_btn,mult_btn;
    EditText field1,field2;

    protected String calculation(String value1,String value2,int operator){
     // take both values and first of all check that they are proper numbers...
        long a,b;
        try{
            a=Long.parseLong(value1);
        }catch (NumberFormatException ex){
            return "Field 1 should contain a number";
        }

        try{
            b=Long.parseLong(value2);
        }catch(NumberFormatException ex){
            return "Field 2 should contain a number";
        }

        // now apply the operation...

        if(operator==1)
            return ""+(a+b);
        return "no way";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_btn=findViewById(R.id.button4);


        field1=findViewById(R.id.editTextTextPersonName2);
        field2=findViewById(R.id.editTextTextPersonName);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1=field1.getText().toString();
                String value2=field2.getText().toString();

                Toast.makeText(MainActivity.this, calculation(value1,value2,1), Toast.LENGTH_SHORT).show();
            }
        });
    }


}