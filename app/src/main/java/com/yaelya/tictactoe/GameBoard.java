package com.yaelya.tictactoe;

import android.widget.Toast;

/**
 * Created by yaelya on 15/04/2018.
 */

public class GameBoard {
    private char[][]board;
    private int []arrWin;
    public GameBoard(){
        this.board = new char[3][3];
        this.arrWin=new int[3];
        for(int i =0; i<3 ;i++)
        {
            for(int j = 0; j<3; j++){
                board[i][j]=' ';
            }
        }
    }
    public char checkWin()
    {

        if((board[0][0]== board[0][1]) && (board[0][1]==board[0][2]) &&(board[0][0]!=' '))
        {
            arrWin[0]=1;
            arrWin[1]=2;
            arrWin[2]=3;
            if(board[0][0]=='x')
            {
                return 'x' ;
            }
            else return 'o';
        }

        if((board[1][0]== board[1][1])&& (board[1][1]==board[1][2]) &&( board[1][0]!=' '))
        {
            arrWin[0]=4;
            arrWin[1]=5;
            arrWin[2]=6;
            if(board[1][0]=='x')
            {
                return 'x' ;
            }
            else return 'o';

        }
        if((board[2][0]==board[2][1]) && (board[2][1]==board[2][2]) && (board[2][0]!=' '))
        {
            arrWin[0]=7;
            arrWin[1]=8;
            arrWin[2]=9;
            if(board[2][0]=='x')
            {
                return 'x' ;
            }
            else return 'o';

        }
        if((board[0][0]==board[1][0]) && (board[1][0]==board[2][0]) && (board[0][0]!=' '))
        {
            arrWin[0]=1;
            arrWin[1]=4;
            arrWin[2]=7;
            if(board[0][0]=='x')
            {
                return 'x' ;
            }
            else return 'o';

        }
        if((board[0][1]==board[1][1]) && (board[1][1]==board[2][1])&& (board[0][1]!=' '))
        {
            arrWin[0]=2;
            arrWin[1]=5;
            arrWin[2]=8;
            if(board[0][1]=='x')
            {
                return 'x' ;
            }
            else return 'o';

        }
        if((board[0][2]==board[1][2]) && (board[1][2]==board[2][2]) && (board[0][2]!=' '))
        {
            arrWin[0]=3;
            arrWin[1]=6;
            arrWin[2]=9;
            if(board[0][2]=='x')
            {
                return 'x' ;
            }
            else return 'o';

        }
        if((board[0][0]==board[1][1]) && (board[1][1]==board[2][2]) && (board[2][2]!=' ')) {
            arrWin[0] = 1;
            arrWin[1] = 5;
            arrWin[2] = 9;
            if (board[0][0] == 'x') {
                return 'x';
            } else return 'o';

        }
        if((board[0][2]==board[1][1]) && (board[1][1]==board[2][0]) && (board[0][2]!=' ')) {
            arrWin[0] = 3;
            arrWin[1] = 5;
            arrWin[2] = 7;
            if (board[0][2] == 'x') {
                return 'x';
            } else return 'o';

        }
        if(checkEmpty()==true)
        {
            return 'n';
        }
        return 'd';
    }

    public boolean checkEmpty()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==' ')
                    return true;
            }
        }
        return false;
    }

    public void updateBoard(int row,int col,char player)
    {
        board[row][col]= player;
    }


    public int[] getArrWin(){
        return this.arrWin;
    }
    public void emptyArrWin(){
        for (int i=0;i<3;i++){
            arrWin[i]=' ';
        }
    }
}
