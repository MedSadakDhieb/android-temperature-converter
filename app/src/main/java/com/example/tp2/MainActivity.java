package com.example.tp2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText txtC;
    private EditText txtF;
    private Button btnDC_DF;
    private Button btnDF_DC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initialiser();
        ecouteurs();
    }

    private void initialiser() {
        txtC = findViewById(R.id.txt_c);
        txtF = findViewById(R.id.txt_F);
        btnDC_DF = findViewById(R.id.btn_cf);
        btnDF_DC = findViewById(R.id.btn_fc);
    }
    private void ecouteurs() {
        btnDC_DF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertirDC_DF();
            }
        });

        btnDF_DC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertirDF_DC();
            }
        });
    }

    private void convertirDC_DF() {
        try {
            Float valC = Float .parseFloat (txtC.getText().toString());
            Float tempF = (valC * 9) / 5 + 32;

            txtF.setText(String.valueOf(tempF));
            colorer(tempF);
        }catch (NumberFormatException e) {

            Toast.makeText(this, "Erreur de saisie : Veuillez entrer un nombre valide", Toast.LENGTH_SHORT).show();

        }




    }

    private void convertirDF_DC() {
        try{
            Float valF = Float .parseFloat( txtF.getText().toString());
            Float tempC = (valF - 32) * 5 / 9;

            txtC.setText(String.valueOf(tempC));
            colorer(tempC);
        }catch (NumberFormatException e) {

            Toast.makeText(this, "Erreur de saisie : Veuillez entrer un nombre valide", Toast.LENGTH_SHORT).show();

        }

    }
    private void colorer(double temp_dc) {

        int textColor;
        int bgColor;
        if (temp_dc <= 0) {
            textColor = Color.WHITE;
            bgColor = Color.BLACK;
        } else if (temp_dc <= 20) {
            textColor = Color.BLUE;
            bgColor = Color.WHITE;
        } else if (temp_dc <= 30) {
            textColor = Color.YELLOW;
            bgColor = Color.GREEN;
        } else {
            textColor = Color.RED;
            bgColor = Color.GRAY;
        }

        txtC.setTextColor(textColor);

        txtC.setBackgroundColor(bgColor);

        txtF.setTextColor(textColor);

        txtF.setBackgroundColor(bgColor);

    }
}
