package com.futpelada.lucas.futpelada.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class clFutPelada extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "futpelada.db";
    private static final int VERSAO = 1;


    public clFutPelada(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        criaTabelaTreino(sqLiteDatabase);
        criaTabelaJogador(sqLiteDatabase);
        criaTabelaRecebimentos(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        dropaTabelas(sqLiteDatabase);
        onCreate(sqLiteDatabase);
    }

    private void criaTabelaJogador(SQLiteDatabase db) {
        String sql = "create table jogador (_id integer not null, " +
                "id_Treino integer not null, " +
                "nome text not null, " +
                "valorMensalidade real not null, " +
                "primary key(_id,id_Treino))";

        db.execSQL(sql);
    }

    private void criaTabelaTreino(SQLiteDatabase db) {
        String sql = "create table treino ( _id INTEGER not null primary key autoincrement, " +
                "nome text not null, " +
                "local text )";

        db.execSQL(sql);
    }

    private void criaTabelaRecebimentos(SQLiteDatabase db) {
        String sql = "create table recebimentos ( _id integer not null, " +
                "id_Treino integer not null, " +
                "id_jogador integer not null, " +
                "mes_Pagamento text, " +
                "dia_Pagamento text, " +
                "valorPago real, " +
                "primary key(_id,id_Treino,id_jogador))";

        db.execSQL(sql);
    }

    private void dropaTabelas(SQLiteDatabase db) {
        db.execSQL("drop table if exists jogador");
        db.execSQL("drop table if exists treino");
        db.execSQL("drop table if exists recebimentos");
    }
}
