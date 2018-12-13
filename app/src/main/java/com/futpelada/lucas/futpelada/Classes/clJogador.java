package com.futpelada.lucas.futpelada.Classes;

public class clJogador {

    private int _id;
    private int id_Treino;
    private String Nome;
    private Double valorMensalidade;

    public clJogador() {
        inicializaVariaveis();

    }

    private void inicializaVariaveis() {
        _id = 0;
        id_Treino = 0;
        Nome = "";
        valorMensalidade = 0.00;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getId_Treino() {
        return id_Treino;
    }

    public void setId_Treino(int id_Treino) {
        this.id_Treino = id_Treino;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Double getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(Double valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }
}
