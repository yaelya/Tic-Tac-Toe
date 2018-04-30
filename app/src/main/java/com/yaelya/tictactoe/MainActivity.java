package com.yaelya.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void start(View view) {
        Intent t = new Intent(this,GameActivity.class);
        startActivity(t);
    }
    public void Instructions(View view) {
        Intent t = new Intent(this,Instructions_Activity.class);
        startActivity(t);
    }
}
