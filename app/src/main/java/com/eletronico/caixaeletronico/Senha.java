package com.eletronico.caixaeletronico;

import android.content.Intent;
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

public class Senha extends AppCompatActivity {

    private Button botaoCorfirmar;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_senha);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            /*
            Este código ajusta dinamicamente o preenchimento de uma View (R.id.main)
            com base nas margens ocupadas pelas barras do sistema
            (como a barra de status e a barra de navegação). Ele garante
            que o conteúdo da View não seja sobreposto por essas barras,
            tornando a interface do usuário mais responsiva e
            adaptável a diferentes dispositivos e configurações de tela.
             */
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        senha = findViewById(R.id.edit_senha);
        botaoCorfirmar = findViewById(R.id.btn_confirmar);

        if (getSupportActionBar() != null){ //para verificar se tem ou não o cabeçalho
            getSupportActionBar().hide(); //para ocutar o cabeçalho da aplicação.
        }

        botaoCorfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int senhaCadastrada = 3102024;
                int senhaDigitada;

                senhaDigitada = Integer.parseInt(senha.getText().toString());

                if(senhaDigitada == senhaCadastrada){
                    Toast.makeText(Senha.this, "Senha OK!", Toast.LENGTH_SHORT).show();
                    irParaActivityPrincipal();
                } else {
                    Toast.makeText(Senha.this, "Senha errada! Tente novamente..."+ senhaDigitada, Toast.LENGTH_SHORT).show();
                    System.out.println(senhaDigitada);
                }
            }
        });
    }

    private void irParaActivityPrincipal (){
        Intent intent = new Intent(Senha.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}