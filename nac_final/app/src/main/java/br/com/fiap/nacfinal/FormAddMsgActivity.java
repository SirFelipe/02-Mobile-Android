package br.com.fiap.nacfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormAddMsgActivity extends AppCompatActivity {
    EditText edtNome;
    EditText edtEmail;
    EditText edtMensagem;
    MeuDB meuDB;
    Mensagem mensagem;
    Button btnExcluir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_add_msg);

        edtNome    = findViewById(R.id.edtNome);
        edtEmail   = findViewById(R.id.edtEmail);
        edtMensagem = findViewById(R.id.edtMsg);
        btnExcluir = findViewById(R.id.btnExcluir);

        meuDB = new MeuDB(this);

        Bundle bundle = getIntent().getExtras();
        if ( bundle != null ) {
            mensagem = (Mensagem) bundle.get("mensagem");

            // É uma edição do cliente
            if (mensagem != null) {
                edtNome.setText(mensagem.getNome());
                edtEmail.setText(mensagem.getEmail());
                edtMensagem.setText(mensagem.getMensagem());

                btnExcluir.setVisibility(View.VISIBLE);
            }
        }
    }

    public void salvar(View view) {
        String nome  = edtNome.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String msg = edtMensagem.getText().toString().trim();

        if ( nome.isEmpty() || email.isEmpty() ) { Toast.makeText(this, getString(R.string.informe_os_campos), Toast.LENGTH_SHORT).show();
            return;
        }//if

        // Editar...
        if ( mensagem != null ) {
            mensagem.setNome(nome);
            mensagem.setEmail(email);
            mensagem.setMensagem(msg);

            meuDB.atualizar(mensagem);
        } else { // Inserção
            mensagem = new Mensagem();
            mensagem.setNome(nome);
            mensagem.setEmail(email);
            mensagem.setMensagem(msg);

            meuDB.inserir(mensagem);
        }

        Toast.makeText(this, getString(R.string.mensagem_inserida), Toast.LENGTH_SHORT).show();
        finish();
    }

    public void excluir(View view){
        meuDB.excluir(mensagem.getId() );

        Toast.makeText(
                this,
                getString(R.string.mensagem_removida_com_sucesso),
                Toast.LENGTH_SHORT
        ).show();

        finish();
    }

}
