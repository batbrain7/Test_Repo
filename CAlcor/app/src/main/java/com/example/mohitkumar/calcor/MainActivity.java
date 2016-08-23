package com.example.mohitkumar.calcor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Double a =0.0;
    int operator  = 0;
    Double result = 0.0;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickbutton(View view){
        Button b = (Button)view;
        final String buttontext = b.getText().toString();
        final EditText etext = (EditText)findViewById(R.id.onechar);
        final TextView textView = (TextView)findViewById((R.id.textv));
        if(buttontext.equals("C")){
            a=0.0;
            textView.setText("");
            etext.setText("");
        }
        if(buttontext.equals("DEL")){
            if(textView.getText().equals(""))
            {
                textView.setText("");
                Toast.makeText(getBaseContext(),"ENTER AN INPUT",Toast.LENGTH_SHORT).show();
            }
            else {
                etext.setText("");
                textView.setText(textView.getText().toString().substring(0, textView.getText().length() - 1));
            }
        }
        if(!buttontext.equals("C") && !buttontext.equals("DEL") && !buttontext.equals("+") && !buttontext.equals("-")
                && !buttontext.equals("/")&& !buttontext.equals("X")&& !buttontext.equals("=")) {
            etext.setText(buttontext);
            textView.setText(textView.getText().toString().concat(etext.getText().toString()));
        }
//        if(!etext.getText().equals("")){
//            textView.setText(textView.getText().toString().concat(etext.getText().toString()));
//            etext.setText("");
     //   }

        if(buttontext.equals("+")) {
        //    if(flag%2 == 0) {
                if (textView.getText().equals("")) {
                    textView.setText("");
                    Toast.makeText(getBaseContext(), "ENTER AN INPUT", Toast.LENGTH_SHORT).show();
                }
                else {
                    a = Double.parseDouble(textView.getText().toString());
                    operator = 1;
                    textView.setText("");
                    flag++;
                }
          //  }
//            else
//            {
//               Double b1 = Double.parseDouble(textView.getText().toString());
//                result = a + b1;
//                textView.setText(""+result);
//             //   flag=0;
//
//            }
       }
        else if(buttontext.equals("-")){
            //if(flag%2==0) {
                if (textView.getText().equals("")) {
                    textView.setText("");
                    Toast.makeText(getBaseContext(), "ENTER AN INPUT", Toast.LENGTH_SHORT).show();
                } else {
                    a = Double.parseDouble(textView.getText().toString());
                    operator = 2;
                    textView.setText("");
                }
            //}
//            else
//            {
//                Double b1 = Double.parseDouble(textView.getText().toString());
//                result = a-b1;
//                textView.setText(""+result);
//
//            }
//            flag++;
        }
        else if (buttontext.equals("X")){
           // if(flag%2==0) {
                if (textView.getText().equals("")) {
                    textView.setText("");
                    Toast.makeText(getBaseContext(), "ENTER AN INPUT", Toast.LENGTH_SHORT).show();
                } else {
                    a = Double.parseDouble(textView.getText().toString());
                    operator = 3;
                    textView.setText("");
                }
         //   }
//            else
//            {
//                Double b1 = Double.parseDouble(textView.getText().toString());
//                result = a*b1;
//                textView.setText(""+result);
//            }
//            flag++;
        }
        else if (buttontext.equals("/")){
          //  if(flag%2==0) {
                if (textView.getText().equals("")) {
                    textView.setText("");
                    Toast.makeText(getBaseContext(), "ENTER AN INPUT", Toast.LENGTH_SHORT).show();
                } else {
                    a = Double.parseDouble(textView.getText().toString());
                    operator = 4;
                    textView.setText("");
                }
            //}
//            else
//            {
//                Double b1 = Double.parseDouble(textView.getText().toString());
//                result = a/b1;
//                textView.setText(""+result);
//
//            }
//            flag++;
        }

        if (buttontext.equals("=")) {
            if (textView.getText().equals("")) {
                textView.setText("");
                Toast.makeText(getBaseContext(), "ENTER AN INPUT", Toast.LENGTH_SHORT).show();
            } else {
                Double two = Double.parseDouble(textView.getText().toString());
                switch (operator) {
                    case 1:
                        result = a + two;
                        break;
                    case 2:
                        result = a - two;
                        break;
                    case 3:
                        result = a * two;
                        break;
                    case 4:
                        result = a / two;
                }
                textView.setText("" + result);
            }
        }
    }
}



