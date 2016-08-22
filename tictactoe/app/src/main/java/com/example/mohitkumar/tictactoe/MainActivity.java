package com.example.mohitkumar.tictactoe;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Boolean crossturn = true;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
   // Button[][] buttons = {{b1,b2,b3},{b4,b5,b6},{b7,b8,b9}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickevent(View view)
    {
        String s = ((Button)view).getText().toString();
        if(s.equals("")) {
            makemove(view);
            int gamestatus = getgamestatus();
            if (gamestatus == 3) {
                crossturn = !crossturn;
            } else {
                declarewinner(gamestatus);
                Intent homeintent = new Intent(this,MainActivity.class);
                startActivity(homeintent);
                MainActivity.this.finish();
            }
        }
        else
            Toast.makeText(getBaseContext(),"INVALID ARGUEMENT",Toast.LENGTH_SHORT).show();
    }

    public void makemove(View view)
    {
        if(crossturn)
        {
            ((Button)view).setText("X");
        }
        else
        {
            ((Button)view).setText("0");
        }
    }

    public int getgamestatus()
    {

        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        b6 = (Button)findViewById(R.id.b6);
        b7 = (Button)findViewById(R.id.b7);
        b8 = (Button)findViewById(R.id.b8);
        b9 = (Button)findViewById(R.id.b9);
        Button[][] buttons = {{b1,b2,b3},{b4,b5,b6},{b7,b8,b9}};

        int row = 0;
        int col = 0;

        String text1 = "";
        String text2 = "";
        for(row=0;row<3;row++)
        {
            while(col<2)
            {
                text1 = buttons[row][col].getText().toString();
                text2 = buttons[row][col+1].getText().toString();
                if(text1.equals("")||!text1.equals(text2))
                {
                    break;
                }
                else
                    col++;
            }
            if(col == 2)
            {
                if(buttons[row][col].getText().toString().equals("X"))
                {
                    return 0;
                }
                else
                    return 1;
            }
        }
        row = 0;
        col =0;
        //row check
        for(col=0;col<3;col++)
        {
            while(row<2)
            {
                text1 = buttons[row][col].getText().toString();
                text2 = buttons[row+1][col].getText().toString();
                if(!text1.equals(text2)||text1.equals(""))
                {
                    break;
                }
                else
                    row++;
            }
            if(row == 2)
            {
                if(buttons[row][col].getText().toString().equals("X"))
                {
                    return 0;
                }
                else
                    return 1;
            }
        }
        row = 0;
        col =0;
        //	for(row = 0;row<board_size;row++)
        //{
        while(row<2)
        {
            text1 = buttons[row][col].getText().toString();
            text2 = buttons[row+1][col+1].getText().toString();
            if(!text1.equals(text2) || text1.equals(""))
            {
                break;
            }
            row++;
            col++;
        }
        if(row == 2)
        {
            if(buttons[row][col].getText().toString().equals("X") && buttons[1][1].getText().toString().equals("X") &&
                    buttons[row][col].equals("X"))
            {
                return 0;
            }
            else if(buttons[row][col].getText().equals("0") && buttons[1][1].equals("0") &&
                    buttons[row][col].equals("0"))
                return 1;
        }
        //}
        row = 0;
        col = 2;
        while(row<2)
        {
            text1 = buttons[row][col].getText().toString();
            text2 = buttons[row+1][col-1].getText().toString();
            if(!text1.equals(text2)||buttons[row][col].getText().toString().equals(""))
            {
                break;
            }
            row++;
            col--;
        }
        if(row == 2)
        {
            if(buttons[row][col].getText().equals("X"))
            {
                return 0;
            }
            else
                return 1;
        }
        row = 0;
        col = 0;
        for(row = 0;row<3;row++)
        {
            for(col = 0;col<3;col++)
            {
                if(buttons[row][col].getText().equals(""))
                {
                    return 3;
                }
            }
        }
        return 4;


    }

    public void declarewinner(int gamestatus)
    {
        if(gamestatus == 0)
        {
            Toast.makeText(getBaseContext(),"X WINS",Toast.LENGTH_SHORT).show();
        }
        else if(gamestatus ==1)
        {
            Toast.makeText(getBaseContext(),"ZERO WINS",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getBaseContext(),"THE GAME WAS A TIE",Toast.LENGTH_SHORT).show();
        }
    }
}
