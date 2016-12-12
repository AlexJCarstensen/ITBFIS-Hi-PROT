package com.alexcarstensen.itbfis_hi_prot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button _aflevering;
    private Button _levering;
    private Button _kort;
    private TextView _afleverTil;
    private TextView _infoScreen;
    private int count;
    private ArrayList<customer> _nameList = new ArrayList<customer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _nameList.add(new customer("Peter Ring", DeliveryType.SecurityLevel1));
        _nameList.add(new customer("Kristian Mosen", DeliveryType.SecurityLevel2));
        _nameList.add(new customer("TyreFægteren", DeliveryType.SecurityLevel3));
        _infoScreen = (TextView) findViewById(R.id.textView);


        count = 0;
        _afleverTil = (TextView) findViewById(R.id.textView5);
        _infoScreen.setText("Press \"Levering\" for next delivery");


        _levering = (Button) findViewById(R.id.button2);
        _levering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;

                if(count == _nameList.size()) {
                    count = 0;
                }
                _afleverTil.setText("Aflevere pakke til " + _nameList.get(count).getName());

                switch (_nameList.get(count).getDeliveryType()) {
                    case SecurityLevel1: {
                        _infoScreen.setText("Delivery with digital signature only");
                        break;
                    }
                    case SecurityLevel2: {
                        _infoScreen.setText("Delivery with digital signature and\n" +
                                "Normal signature");

                        break;
                    }
                    case SecurityLevel3: {
                        _infoScreen.setText("Delivery with digital signature,\n" +
                                "normal signature and\n" +
                                "delivery without a signature");
                        break;
                    }
                }

            }
        });



        _aflevering = (Button) findViewById(R.id.button3);

        _aflevering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent afleveringIntent = new Intent(MainActivity.this, Aflevering.class);
                afleveringIntent.putExtra("customer", _nameList.get(count));
                startActivity(afleveringIntent);

            }
        });

        _kort = (Button) findViewById(R.id.button);

        _kort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(MainActivity.this, kort.class);
                mapIntent.putExtra("infoScreenText", _infoScreen.getText());
                startActivity(mapIntent);

            }
        });
    }
}
