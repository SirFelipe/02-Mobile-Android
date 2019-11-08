package br.com.fiap.nacfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MeuDB db;
    RecyclerView rvMensagem;
    List<Mensagem> mensagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new MeuDB(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        rvMensagem = findViewById(R.id.rvMensagem);
        rvMensagem.setHasFixedSize(true);
        rvMensagem.setLayoutManager(layoutManager);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mensagens = db.buscarTudo();

        MensagemAdapter adapter = new MensagemAdapter(this, mensagens);

        rvMensagem.setAdapter(adapter);
    }

    public void inserir(View view) {
        Intent it = new Intent(this, FormAddMsgActivity.class);
        startActivity(it);
    }

}
