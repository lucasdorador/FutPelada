package com.futpelada.lucas.futpelada.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.futpelada.lucas.futpelada.Classes.clJogador;
import com.futpelada.lucas.futpelada.SQLite.clFutPelada;

public class clJogadorController {

    private SQLiteDatabase db;
    private clFutPelada banco;

    public clJogadorController(Context context) {
        banco = new clFutPelada(context);
    }

    public boolean insereJogador(clJogador jogador) {
        boolean resultado = false;
        ContentValues valores;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("_id", jogador.get_id());
        valores.put("id_Treino", jogador.getId_Treino());
        valores.put("nome", jogador.getNome());
        valores.put("valorMensalidade", jogador.getValorMensalidade());

        resultado = !(db.insert("jogador", null, valores) == -1);
        db.close();

        return resultado;
    }

    public boolean alteraJogador(clJogador jogador) {
        ContentValues valores;
        boolean resultado = false;

        db = banco.getWritableDatabase();

        String where = "_id = '" + jogador.get_id() +
                       "' and id_Treino = '" + jogador.getId_Treino() + "'";

        valores = new ContentValues();
        valores.put("nome", jogador.getNome());
        valores.put("valorMensalidade", jogador.getValorMensalidade());

        resultado = !(db.update("jogador", valores, where, null) == -1);
        db.close();

        return resultado;
    }

    public boolean deletaJogador(int _id, int id_Treino) {
        boolean resultado = true;

        String where = "_id = '" + _id +
                "' and id_Treino = '" + id_Treino + "'";

        db = banco.getReadableDatabase();
        resultado = !(db.delete("jogador", where, null) == -1);
        db.close();

        return resultado;
    }

    public boolean existeDadosCadastrados(int _id, int id_Treino) {
        boolean resultado = true;

        db = banco.getReadableDatabase();

        String where = "_id = '" + _id +
                "' and id_Treino = '" + id_Treino + "'";


        long numOfEntries = DatabaseUtils.queryNumEntries(db, "jogador", where);

        if (numOfEntries == 0l) {
            resultado = false;
        }

        return resultado;
    }

}
