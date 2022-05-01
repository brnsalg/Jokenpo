package com.brnsalg.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }


    public void opcaoSelecionada(String escolhaUsuario) {
        ImageView imgEscolhaApp = findViewById(R.id.imgEscolhaApp);
        TextView txtResultado = findViewById(R.id.txtResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "Pedra" :
                imgEscolhaApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel" :
                imgEscolhaApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura" :
                imgEscolhaApp.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaApp.equals("Tesoura") && escolhaUsuario.equals("Papel")) ||
                (escolhaApp.equals("Papel") && escolhaUsuario.equals("Pedra")) ||
                (escolhaApp.equals("Pedra") && escolhaUsuario.equals("Tesoura"))
        ) { txtResultado.setText("Você perdeu :("); }
        else if (
                (escolhaUsuario.equals("Tesoura") && escolhaApp.equals("Papel")) ||
                (escolhaUsuario.equals("Papel") && escolhaApp.equals("Pedra")) ||
                (escolhaUsuario.equals("Pedra") && escolhaApp.equals("Tesoura"))
        ) { txtResultado.setText("Você ganhou :)");
        } else { txtResultado.setText("Empatamos :O"); }
    }
}