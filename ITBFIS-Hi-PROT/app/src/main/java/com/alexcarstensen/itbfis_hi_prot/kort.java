package com.alexcarstensen.itbfis_hi_prot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class kort extends AppCompatActivity {

    private Button _ankommet;
    private TextView _infoScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kort);

        _ankommet = (Button) findViewById(R.id.button4);
        _infoScreen = (TextView) findViewById(R.id.textView4);

        String text = getIntent().getStringExtra("infoScreenText");
        _infoScreen.setText(text);
        _ankommet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
