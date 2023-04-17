package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button add_btn,sub_btn,mult_btn,div_btn,fact_btn,gcd_btn;
    EditText field1,field2;
    TextView result_view;

    protected long find_factorial(long value){
        long answer=1;

        // 1*2*3*4*5*6*7*8
        for(long i=2;i<=value;i++){
            answer*=i;
        }

        return  answer;
    }

    protected long find_gcd(long a,long b){
        return b==0?a:find_gcd(b,a % b);
    }

    protected String calculation(String value1,String value2,int operator){
     // take both values and first of all check that they are proper numbers...
        long a=0,b=0;
        try{
            a=Long.parseLong(value1);
            if(operator==5){
                return "Factorial for first field is "+find_factorial(a);
            }
        }catch (NumberFormatException ex){
            // in case we want to find factorial then don't return instead check for other value..
            if(operator!=5) {
                return "Incorrect Input! Field 1 should contain a number";
            }
        }

        try{
            b=Long.parseLong(value2);
            if(operator==5){
                return "Factorial for second value is "+find_factorial(b);
            }
        }catch(NumberFormatException ex){
            return "Incorrect Input! Field 2 should contain a number";
        }

        // now apply the operation...

        if(operator==1)
            return ""+(a+b);
        if(operator==2)
            return ""+(a-b);
        if(operator==3)
            return ""+(a*b);
        if(operator==4){
            if(b==0)
                return "Denominator can not be zero";
            return ""+((double) a/ (double)b);
        }

       return ""+find_gcd(a,b);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_btn=findViewById(R.id.button4);
        sub_btn=findViewById(R.id.button5);
        mult_btn=findViewById(R.id.button6);
        div_btn=findViewById(R.id.button7);
        fact_btn=findViewById(R.id.button8);
        gcd_btn=findViewById(R.id.button9);

        field1=findViewById(R.id.editTextTextPersonName2);
        field2=findViewById(R.id.editTextTextPersonName);

        result_view=findViewById(R.id.textView2);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1=field1.getText().toString();
                String value2=field2.getText().toString();
                String result=calculation(value1,value2,1);
                result_view.setText("Addition : "+result);

            }
        });

       sub_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String value1=field1.getText().toString();
               String value2=field2.getText().toString();

               result_view.setText( "Substraction : "+calculation(value1,value2,2));
           }
       });

        mult_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1=field1.getText().toString();
                String value2=field2.getText().toString();

                result_view.setText( "Multiplication : "+calculation(value1,value2,3));
            }
        });

        div_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1=field1.getText().toString();
                String value2=field2.getText().toString();
                result_view.setText("Division : "+calculation(value1,value2,4));
            }
        });

        fact_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1=field1.getText().toString();
                String value2=field2.getText().toString();
                result_view.setText( calculation(value1,value2,5));
            }
        });

        gcd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1=field1.getText().toString();
                String value2=field2.getText().toString();

                result_view.setText("GCD : "+calculation(value1,value2,6));

            }
        });
    }


}