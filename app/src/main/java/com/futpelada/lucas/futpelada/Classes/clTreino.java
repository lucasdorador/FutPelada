package com.futpelada.lucas.futpelada.Classes;

public class clTreino {

    private int _id;
    private String Nome;
    private String Local;

    public clTreino() {
        inicializaVariaveis();
    }

    private void inicializaVariaveis(){
        _id = 0;
        Nome = "";
        Local = "";
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        Local = local;
    }
}
