package com.yaelya.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Instructions_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_);
    }
    public void start(View view) {
        Intent t = new Intent(this, GameActivity.class);
        startActivity(t);

    }
}
