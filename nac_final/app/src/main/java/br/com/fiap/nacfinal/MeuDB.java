package br.com.fiap.nacfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nome", mensagem.getNome());
        cv.put("email", mensagem.getEmail());
        cv.put("mensagem", mensagem.getEmail());

        db.insert("mensagem", null, cv);
    }

    public void atualizar(Mensagem mensagem) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nome", mensagem.getNome());
        cv.put("email", mensagem.getEmail());
        cv.put("mensagem", mensagem.getEmail());

        db.update("mensagem", cv, "id = ?", new String[]{ String.valueOf(mensagem.getId()) }
        );
    }

    public void excluir(int id) {
        SQLiteDatabase db = getWritableDatabase();

        db.delete("mensagem", "id = ?", new String[]{ String.valueOf(id) });
    }

    public List<Mensagem> buscarTudo() {
        List<Mensagem> mensagens = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(
                "mensagem",
                new String[]{"id", "nome", "email", "mensagem"},
                null,
                null,
                null,
                null,
                "nome"
        );

        if ( cursor.moveToFirst() ) {
            do {
                Mensagem mensagem = new Mensagem();
                mensagem.setId( cursor.getInt( 0 ) );
                mensagem.setNome( cursor.getString( 1 ) );
                mensagem.setEmail( cursor.getString( 2 ) );

                mensagens.add(mensagem);
            } while ( cursor.moveToNext() );
        }

        return mensagens;
    }
}
