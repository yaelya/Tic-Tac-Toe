package com.yaelya.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class GameActivity extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    private  GameBoard board;
    private TextView txvTurn;
    private char changeTurn;
    private int coutX,coutO,coutD;
    private TextView txvXscore;
    private TextView txvOscore;
    private TextView txvDraw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        btn1=(Button) findViewById(R.id.btn1ID);
        btn2=(Button) findViewById(R.id.btn2ID);
        btn3=(Button) findViewById(R.id.btn3ID);
        btn4=(Button) findViewById(R.id.btn4ID);
        btn5=(Button) findViewById(R.id.btn5ID);
        btn6=(Button) findViewById(R.id.btn6ID);
        btn7=(Button) findViewById(R.id.btn7ID);
        btn8=(Button) findViewById(R.id.btn8ID);
        btn9=(Button) findViewById(R.id.btn9ID);
        txvTurn= (TextView) findViewById(R.id.txvTurnID);
        txvXscore= (TextView) findViewById(R.id.txvXscoreID);
        txvOscore= (TextView) findViewById(R.id.txvOscoreID);
        txvDraw= (TextView) findViewById(R.id.txvDrawID);
        board=new GameBoard();

        changeTurn='x';
    }
    public void turn(View v)
    {
        // Toast.makeText(this, "!!", Toast.LENGTH_LONG).show();
        // Toast.makeText(this, "---->"+R.id.btn1ID, Toast.LENGTH_SHORT).show();
        switch(v.getId())
        {

            case R.id.btn1ID:
            {
                btn1.setText(" "+changeTurn+" ");
                btn1.setEnabled(false);
                board.updateBoard(0,0,changeTurn);
                if(winner()==true)
                    return;
                checkTurn();

            }
            break;
            case R.id.btn2ID:
            {
                btn2.setText(" "+changeTurn+" ");
                btn2.setEnabled(false);
                board.updateBoard(0,1,changeTurn);
                if(winner()==true)
                    return;
                checkTurn();
            }
            break;


            case R.id.btn3ID:
            {
                btn3.setText(" "+changeTurn+" ");
                btn3.setEnabled(false);
                board.updateBoard(0,2,changeTurn);
                if(winner()==true)
                    return;
                checkTurn();
            }
            break;

            case R.id.btn4ID:
            {
                btn4.setText(" "+changeTurn+" ");
                btn4.setEnabled(false);
                board.updateBoard(1,0,changeTurn);
                if(winner()==true) {

                    return;
                }
                checkTurn();
            }
            break;
            case R.id.btn5ID:
            {
                btn5.setText(" "+changeTurn+" ");
                btn5.setEnabled(false);
                board.updateBoard(1,1,changeTurn);
                if(winner()==true)
                    return;
                checkTurn();
            }
            break;
            case R.id.btn6ID:
            {
                btn6.setText(" "+changeTurn+" ");
                btn6.setEnabled(false);
                board.updateBoard(1,2,changeTurn);
                if(winner()==true)
                    return;
                checkTurn();
            }
            break;

            case R.id.btn7ID:
            {
                btn7.setText(" "+changeTurn+" ");
                btn7.setEnabled(false);
                board.updateBoard(2,0,changeTurn);
                if(winner()==true)
                    return;
                checkTurn();
            }
            break;
            case R.id.btn8ID:
            {
                btn8.setText(" "+changeTurn+" ");
                btn8.setEnabled(false);
                board.updateBoard(2,1,changeTurn);
                if(winner()==true)
                    return;
                checkTurn();
            }
            break;
            case R.id.btn9ID:
            {
                btn9.setText(" "+changeTurn+" ");
                btn9.setEnabled(false);
                board.updateBoard(2,2,changeTurn);
                if(winner()==true)
                    return;
                checkTurn();
            }
            break;
            default:
                throw new RuntimeException("Unknow button ID");
        }
    }
    public boolean winner() {
        if (board.checkWin() == 'x') {
            coutX++;
            txvXscore.setText(""+coutX);
            txvTurn.setText("X Won!");
            lock();
            paintBlue();
            Toast.makeText(this, "Game Over!", Toast.LENGTH_LONG).show();
            return true;

        }
        if (board.checkWin() == 'o') {
            coutO++;
            txvOscore.setText(""+coutO);
            txvTurn.setText("O Won!");
            lock();
            paintBlue();
            Toast.makeText(this, "Game Over!", Toast.LENGTH_LONG).show();
            return true;
        }
        if (board.checkWin() == 'd') {
            coutD++;
            txvDraw.setText(""+coutD);
            txvTurn.setText("Draw - No Winner!");
            lock();
            paintBlue();
            Toast.makeText(this, "Game Over!", Toast.LENGTH_LONG).show();
            return true;

        }
        if (board.checkWin() == 'n') {
            return false;

        }
        return false;

    }

    public void checkTurn(){
        if(changeTurn=='x') {
            changeTurn = 'o';
            txvTurn.setText("O Turn");
        }
        else if(changeTurn=='o'){
            changeTurn='x';
            txvTurn.setText("X Turn");
        }
    }


    public void playAgain(View v)
    {
        Toast.makeText(this, "play again!", Toast.LENGTH_LONG).show();
        board =new GameBoard();
        emptyButton();
       btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        txvTurn.setText("X Turn");
        changeTurn='x';
        board.emptyArrWin();
        paintBlack();
    }

    private void lock() {
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
    public void paintBlue()
    {
        int []arr =board.getArrWin();
        if(arr[0] == 1 ){
            btn1.setTextColor(Color.parseColor("#0000FF"));
        }
        if(arr[0] == 2 || arr[1] == 2 ){
            btn2.setTextColor(Color.parseColor("#0000FF"));
        }
        if(arr[0] == 3 || arr[2] == 3 ){
            btn3.setTextColor(Color.parseColor("#0000FF"));
        }
        if(arr[0] == 4 || arr[1] == 4 ){
            btn4.setTextColor(Color.parseColor("#0000FF"));
        }
        if(arr[1] == 5 ){
            btn5.setTextColor(Color.parseColor("#0000FF"));
        }
        if(arr[1] == 6 || arr[2] == 6 ){
            btn6.setTextColor(Color.parseColor("#0000FF"));
        }
        if(arr[0] == 7 || arr[2] == 7 ){
            btn7.setTextColor(Color.parseColor("#0000FF"));
        }
        if(arr[1] ==8 || arr[2] == 8 ){
            btn8.setTextColor(Color.parseColor("#0000FF"));
        }
        if(arr[2] == 9 ){
            btn9.setTextColor(Color.parseColor("#0000FF"));
        }
    }
    public void paintBlack(){
        btn1.setTextColor(Color.parseColor("#000000"));
        btn2.setTextColor(Color.parseColor("#000000"));
        btn3.setTextColor(Color.parseColor("#000000"));
        btn4.setTextColor(Color.parseColor("#000000"));
        btn5.setTextColor(Color.parseColor("#000000"));
        btn6.setTextColor(Color.parseColor("#000000"));
        btn7.setTextColor(Color.parseColor("#000000"));
        btn8.setTextColor(Color.parseColor("#000000"));
        btn9.setTextColor(Color.parseColor("#000000"));
    }

    public void emptyButton(){
        Toast.makeText(this, "$$$!", Toast.LENGTH_LONG).show();
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
    }

}
