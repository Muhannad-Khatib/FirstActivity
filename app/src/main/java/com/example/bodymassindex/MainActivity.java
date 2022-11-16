package com.example.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtheight;
    private EditText txtMass;
    private Switch isMale;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }
    private void setupViews() {
        txtheight = findViewById(R.id.txtheight);
        txtMass = findViewById(R.id.txtmass);
        isMale = findViewById(R.id.switch1);
        result = findViewById(R.id.textBMI);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            String height = txtheight.getText().toString();
            String mass = txtMass.getText().toString();
            if (!height.isEmpty() && !mass.isEmpty()) {
                String IBM = (Double.parseDouble(mass) / (Double.parseDouble(height) * Double.parseDouble(height))) + "";
                if (isMale.isChecked()) {
                    IBM = Double.parseDouble(IBM) + (Double.parseDouble(IBM) * 0.05) +"";
                }
                result.setText(IBM);
            }
        });
    }
}