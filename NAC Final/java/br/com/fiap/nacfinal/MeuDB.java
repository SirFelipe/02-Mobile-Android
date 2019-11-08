package br.com.fiap.nacfinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MeuDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "MeuDB";
    public static final int DB_VERSION = 1;

    public MeuDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE mensagem (" +
                    " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    " nome TEXT NOT NULL," +
                    " email TEXT NOT NULL," +
                    " mensagem TEXT NOT NULL" +
                    ")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void inserir(Mensagem mensagem) {
        // TODO Implementar lógica para inserir aqui
    }

    public void atualizar(Mensagem mensagem) {
        // TODO Implementar lógica para atualizar aqui
    }

    public void excluir(int id) {
        // TODO Implementar lógica para excluir uma mensagem aqui
    }

    public List<Mensagem> buscarTudo() {
        List<Mensagem> mensagens = new ArrayList<>();

        // TODO Implementar lógica para buscar tudo aqui.

        return mensagens;
    }
}
