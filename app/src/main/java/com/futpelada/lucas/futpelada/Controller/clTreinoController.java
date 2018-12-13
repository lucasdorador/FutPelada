package com.futpelada.lucas.futpelada.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.futpelada.lucas.futpelada.Classes.clTreino;
import com.futpelada.lucas.futpelada.SQLite.clFutPelada;

public class clTreinoController {

    private SQLiteDatabase db;
    private clFutPelada banco;
    private String nomeTabela;

    public clTreinoController(Context context) {
        banco = new clFutPelada(context);
        nomeTabela = "treino";
    }

    public boolean insereTreino(clTreino treino) {
        boolean resultado = false;
        ContentValues valores;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("_id", treino.get_id());
        valores.put("nome", treino.getNome());
        valores.put("local", treino.getLocal());

        resultado = !(db.insert(nomeTabela, null, valores) == -1);
        db.close();

        return resultado;
    }

    public boolean alteraTreino(clTreino treino) {
        ContentValues valores;
        boolean resultado = false;

        db = banco.getWritableDatabase();

        String where = "_id = '" + treino.get_id() + "'";

        valores = new ContentValues();
        valores.put("nome", treino.getNome());
        valores.put("local", treino.getLocal());

        resultado = !(db.update(nomeTabela, valores, where, null) == -1);
        db.close();

        return resultado;
    }

    public boolean deletaTreino(int _id) {
        boolean resultado = true;

        String where = "_id = '" + _id + "'";

        db = banco.getReadableDatabase();
        resultado = !(db.delete(nomeTabela, where, null) == -1);
        db.close();

        return resultado;
    }

    public boolean existeDadosCadastrados(int _id) {
        boolean resultado = true;

        db = banco.getReadableDatabase();

        String where = "_id = '" + _id + "'";

        long numOfEntries = DatabaseUtils.queryNumEntries(db, nomeTabela, where);

        if (numOfEntries == 0l) {
            resultado = false;
        }

        return resultado;
    }
}
