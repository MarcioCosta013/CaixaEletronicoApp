package com.eletronico.caixaeletronico;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView text_Saldo;
    private Button btn_sacar;
    private EditText edit_Dinheiro;

    double saldoEmConta = 3000.00;

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

        iniciarComponentes();
        text_Saldo.setText("Saldo em Conta:" + "R$ " + saldoEmConta);

        //Evento de click no botão:
        btn_sacar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double dinheiro;
                dinheiro = Double.parseDouble(edit_Dinheiro.getText().toString());

                if(dinheiro <= 20){
                    saldoEmConta -= dinheiro;
                    Toast.makeText(MainActivity.this,"Digite um valor Maior",Toast.LENGTH_SHORT).show();
                } else if (dinheiro == 20) {
                    saldoEmConta-=dinheiro;
                    text_Saldo.setText("Saldo em Conta:" + "R$ " + saldoEmConta);
                    Toast.makeText(MainActivity.this,"R$ 20,00 sacados!",Toast.LENGTH_SHORT).show();
                } else if (dinheiro == 50) {
                    saldoEmConta-=dinheiro;
                    text_Saldo.setText("Saldo em Conta:" + "R$ " + saldoEmConta);
                    Toast.makeText(MainActivity.this,"R$ 50,00 sacados!",Toast.LENGTH_SHORT).show();
                } else if (dinheiro == 100) {
                    saldoEmConta-=dinheiro;
                    text_Saldo.setText("Saldo em Conta:" + "R$ " + saldoEmConta);
                    Toast.makeText(MainActivity.this,"R$" + " 100,00" + " sacados!",Toast.LENGTH_SHORT).show();
                } else {
                    saldoEmConta-=dinheiro;
                    text_Saldo.setText("Saldo em Conta:" + "R$ " + saldoEmConta);
                    Toast.makeText(MainActivity.this, "R$" + dinheiro + "0 sacados!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void iniciarComponentes (){
        edit_Dinheiro = findViewById(R.id.edit_Dinheiro);
        btn_sacar = findViewById(R.id.btn_Sacar);
        text_Saldo = findViewById(R.id.text_Saldo);


    }
}