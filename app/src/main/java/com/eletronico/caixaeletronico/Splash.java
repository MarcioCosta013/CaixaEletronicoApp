package com.eletronico.caixaeletronico;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (getSupportActionBar() != null){ //para verificar se tem ou não o cabeçalho
            getSupportActionBar().hide(); //para ocutar o cabeçalho da aplicação.
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ActivitySenha();
            }
        },3000); //3 segundos para passar para tela de senha.
    }

    private void ActivitySenha (){
        Intent intent = new Intent(Splash.this, Senha.class); //indica a intenção de navegar entre activity's.
        startActivity(intent); //inicia a activity.
        finish(); //finaliza a activity.

    }
}