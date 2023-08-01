package com.example.xogame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String name1 , name2;
    int counter = 0;
    ArrayList<String> XOList;

    TextView tv_scoreX ,tv_scoreO , tv_player_name1 , tv_player_name2;
    int scoreX = 0 ,scoreO = 0;
    ConstraintLayout layout;
    Button btn1  , btn2 , btn3 , btn4 ,btn5 ,btn6 , btn7 ,btn8 , btn9 , btn_reset ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_scoreX = findViewById(R.id.tv_player1_score);
        tv_scoreO = findViewById(R.id.tv_player2_score);
        layout = findViewById(R.id.Constraint_layout);
        tv_player_name1 = findViewById(R.id.tv_player1_label);
        tv_player_name2 = findViewById(R.id.tv_player2_label);
        btn1 = findViewById(R.id.bnt_1);
        btn2 = findViewById(R.id.bnt_2);
        btn3 = findViewById(R.id.bnt_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btn_reset = findViewById(R.id.btn_reset);
        XOList = new ArrayList<>(9);
        for (int i=0; i<9 ;i++)
        {
            XOList.add("");
        }
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clearButtonGame();
                enableAllButtons();

            }
        });

        Intent intent = getIntent();
        tv_player_name1.setText(intent.getStringExtra("name1"));
        tv_player_name2.setText(intent.getStringExtra("name2"));

    }

    public void clickedButton(View view)
    {
        if(view instanceof Button)
        {
            Button btn_clicked = (Button) view;
            if(!btn_clicked.getText().toString().isEmpty())
                return;
            if(counter % 2 == 0) {
                int textColor_x = Color.BLACK;
                btn_clicked.setTextColor(textColor_x);
                btn_clicked.setText("X");
                initialXOList(btn_clicked.getId(),"X");
                if (checkWinner("X"))
                {
                    disableAllButtons();
                    scoreX += 5;
                    tv_scoreX.setText(""+scoreX);
                    if (scoreX == 20) {
                        Intent intent = new Intent(MainActivity.this, Win.class);
                        startActivity(intent);
                        Toast.makeText(this,tv_player_name1.getText()+" is Winner", Toast.LENGTH_LONG).show();
                    }
                }
            }
            else {
                int textColor_o = Color.WHITE;
                btn_clicked.setTextColor(textColor_o);
                btn_clicked.setText("O");
                initialXOList(btn_clicked.getId(),"O");
                if(checkWinner("O")) {
                    disableAllButtons();
                    scoreO += 5;
                    tv_scoreO.setText(""+scoreO);
                    if (scoreO == 20) {
                        Intent intent = new Intent(MainActivity.this, Win.class);
                        startActivity(intent);
                        Toast.makeText(this, tv_player_name2.getText()+" is Winner", Toast.LENGTH_LONG).show();
                    }
                }
            }
            counter++;
        }


    }


    public void initialXOList(int id , String playerSymbol)
    {
        if (id == R.id.bnt_1)
        {
            XOList.set(0 , playerSymbol);
        }
        else if(id == R.id.bnt_2)
        {
            XOList.set(1 , playerSymbol);
        }
        else if(id == R.id.bnt_3)
        {
            XOList.set(2 , playerSymbol);
        }
        else if(id == R.id.btn_4)
        {
            XOList.set(3 , playerSymbol);
        }
        else if(id == R.id.btn_5)
        {
            XOList.set(4 , playerSymbol);
        }
        else if(id == R.id.btn_6)
        {
            XOList.set(5 , playerSymbol);
        }
        else if(id == R.id.btn_7)
        {
            XOList.set(6 , playerSymbol);
        }
        else if ((id == R.id.btn_8)) {
            XOList.set(7 , playerSymbol);
        }
        else if ((id == R.id.btn_9)) {
            XOList.set(8 , playerSymbol);
        }
    }


    public boolean checkWinner(String symbol)
    {
        for (int i=0; i<9 ; i+=3)
        {
            if(XOList.get(i).equals(symbol) && XOList.get(i+1).equals(symbol) && XOList.get(i+2).equals(symbol))
                return true;

        }
        for (int i=0; i<3 ; i++)
        {
            if(XOList.get(i).equals(symbol) && XOList.get(i+3).equals(symbol) && XOList.get(i+6).equals(symbol))
                return true;
        }
        if(XOList.get(0).equals(symbol) && XOList.get(4).equals(symbol) && XOList.get(8).equals(symbol))
            return true;

        if(XOList.get(2).equals(symbol) && XOList.get(4).equals(symbol) && XOList.get(6).equals(symbol))
            return true;

        return false;
    }

    public void clearButtonGame(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        counter = 0;
        XOList.clear();
        for (int i = 0; i < 9; i++) {
            XOList.add("");
        }
    }
    public void enableAllButtons() {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
    }
    public void disableAllButtons() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);

    }
}
