package com.alexcarstensen.itbfis_hi_prot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Aflevering extends AppCompatActivity {

    private Button _buttonAflever;
    private Button _buttonSignature;
    private Button _buttonDigitalSignature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aflever);

        customer customer = (com.alexcarstensen.itbfis_hi_prot.customer) getIntent().getSerializableExtra("customer");


        _buttonAflever = (Button) findViewById(R.id.button3);
        _buttonSignature = (Button) findViewById(R.id.button5);
        _buttonDigitalSignature = (Button) findViewById(R.id.button6);

        _buttonAflever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        _buttonSignature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        _buttonDigitalSignature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        switch (customer.getDeliveryType()) {
            case SecurityLevel1: {
                _buttonAflever.setEnabled(false);
                _buttonSignature.setEnabled(false);
                break;
            }
            case SecurityLevel2: {
                _buttonAflever.setEnabled(false);
                break;
            }
            case SecurityLevel3: {
                break;
            }
        }


    }
}
