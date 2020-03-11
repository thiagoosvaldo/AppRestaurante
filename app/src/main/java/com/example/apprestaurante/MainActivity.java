package com.example.apprestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private EditText edtConsumo,edtDiv,edtCouvert;
    private TextView txtTaxa,txtUni,txtTotal;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Relacionamento java + xml

        edtConsumo = (EditText) findViewById(R.id.edtConsumo);
        edtCouvert = (EditText)findViewById(R.id.edtCouvert);
        edtDiv = (EditText)findViewById(R.id.edtDiv);
        txtTaxa = (TextView)findViewById(R.id.txtTaxa);
        txtTotal = (TextView) findViewById(R.id.txtTotal);
        txtUni = (TextView)findViewById(R.id.txtUni);
        btnCalc = (Button)findViewById(R.id.btnCalc);


        //programando o botão calc

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Verificação de campo vazio ou não
                if(edtConsumo.getText().toString().isEmpty() ||
                        edtCouvert.getText().toString().isEmpty() ||
                        edtDiv.getText().toString().isEmpty()) {

                    Toast.makeText(MainActivity.this,"Por Favor, Preencha todos os campos",
                            Toast.LENGTH_LONG).show();return;

                }

                double consumo = Double.parseDouble(edtConsumo.getText().toString());
                double couvert = Double.parseDouble(edtCouvert.getText().toString());
                double div = Double.parseDouble(edtDiv.getText().toString());
                double total,uni,taxa;

                taxa = consumo *0.10;
                total = consumo + taxa + couvert;
                uni = total / div;

                DecimalFormat dec = new DecimalFormat("0.##");

                    txtTaxa.setText(String.valueOf(dec.format(taxa)));
                    txtTotal.setText(String.valueOf(dec.format(total)));
                    txtUni.setText(String.valueOf(dec.format(uni)));




            }
        });






    }
}
