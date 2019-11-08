package br.com.fiap.nacfinal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MensagemAdapter extends RecyclerView.Adapter<MensagemAdapter.MensagemViewHolder> {

    private Context context;
    private List<Mensagem> mensagens;

    public MensagemAdapter(Context context, List<Mensagem> mensagens) {
        this.context  = context;
        this.mensagens = mensagens;
    }


    @NonNull
    @Override
    public MensagemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(this.context)
                .inflate(R.layout.recyclerview_mensagens, viewGroup, false);
        return new MensagemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MensagemViewHolder mensagemViewHolder, int i) {
        final Mensagem mensagem = this.mensagens.get(i);

        mensagemViewHolder.txtID.setText(String.valueOf(mensagem.getId()) );
        mensagemViewHolder.txtNome.setText(mensagem.getNome());
        mensagemViewHolder.txtEmail.setText(mensagem.getEmail());
        mensagemViewHolder.txtMensagem.setText(mensagem.getMensagem());

        mensagemViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, FormAddMsgActivity.class);
                it.putExtra("mensagem", mensagem);
                context.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.mensagens.size();
    }

    public static class MensagemViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView txtID;
        TextView txtNome;
        TextView txtEmail;
        TextView txtMensagem;

        public MensagemViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView) itemView;
            txtID    = itemView.findViewById(R.id.txtID);
            txtNome  = itemView.findViewById(R.id.txtNome);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtMensagem = itemView.findViewById(R.id.txtMsg);
        }
    }
}
