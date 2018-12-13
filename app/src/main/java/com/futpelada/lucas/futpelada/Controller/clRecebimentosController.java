package com.futpelada.lucas.futpelada.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.futpelada.lucas.futpelada.Classes.clRecebimentos;
import com.futpelada.lucas.futpelada.SQLite.clFutPelada;

public class clRecebimentosController {

    private SQLiteDatabase db;
    private clFutPelada banco;
    private String nomeTabela;

    public clRecebimentosController(Context context) {
        banco = new clFutPelada(context);
        nomeTabela = "recebimentos";
    }

    public boolean insereRecebimentos(clRecebimentos recebimentos) {
        boolean resultado = false;
        ContentValues valores;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("_id", recebimentos.get_id());
        valores.put("id_Treino", recebimentos.getId_Treino());
        valores.put("id_jogador", recebimentos.getId_Jogador());
        valores.put("mes_Pagamento", recebimentos.getMes_Pagamento());
        valores.put("dia_Pagamento", recebimentos.getDia_Pagamento());
        valores.put("valorPago", recebimentos.getValorPago());

        resultado = !(db.insert(nomeTabela, null, valores) == -1);
        db.close();

        return resultado;
    }

    public boolean alteraRecebimentos(clRecebimentos recebimentos) {
        ContentValues valores;
        boolean resultado = false;

        db = banco.getWritableDatabase();

        String where = "_id = '" + recebimentos.get_id() +
                "' and id_Treino = '" + recebimentos.getId_Treino() +
                "' and id_jogador = '" + recebimentos.getId_Jogador() + "'";

        valores = new ContentValues();
        valores.put("mes_Pagamento", recebimentos.getMes_Pagamento());
        valores.put("dia_Pagamento", recebimentos.getDia_Pagamento());
        valores.put("valorPago", recebimentos.getValorPago());
        resultado = !(db.update(nomeTabela, valores, where, null) == -1);
        db.close();

        return resultado;
    }

    public boolean deletaRecebimentos(int _id, int id_Treino, int id_Jogador) {
        boolean resultado = true;

        String where = "_id = '" + _id +
                "' and id_Treino = '" + id_Treino +
                "' and id_jogador = '" + id_Jogador + "'";

        db = banco.getReadableDatabase();
        resultado = !(db.delete(nomeTabela, where, null) == -1);
        db.close();

        return resultado;
    }

    public boolean existeDadosCadastrados(int _id, int id_Treino, int id_Jogador) {
        boolean resultado = true;

        db = banco.getReadableDatabase();

        String where = "_id = '" + _id +
                "' and id_Treino = '" + id_Treino +
                "' and id_jogador = '" + id_Jogador + "'";

        long numOfEntries = DatabaseUtils.queryNumEntries(db, nomeTabela, where);

        if (numOfEntries == 0l) {
            resultado = false;
        }

        return resultado;
    }
}
