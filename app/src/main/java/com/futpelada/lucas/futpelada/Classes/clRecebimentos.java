package com.futpelada.lucas.futpelada.Classes;

public class clRecebimentos {

    private int _id;
    private int id_Treino;
    private int id_Jogador;
    private String mes_Pagamento;
    private String dia_Pagamento;
    private Double valorPago;

    public clRecebimentos() {
        inicializaVariaveis();
    }

    private void inicializaVariaveis() {
        _id = 0;
        id_Treino = 0;
        id_Jogador = 0;
        mes_Pagamento = "";
        dia_Pagamento = "";
        valorPago = 0.00;
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

    public int getId_Jogador() {
        return id_Jogador;
    }

    public void setId_Jogador(int id_Jogador) {
        this.id_Jogador = id_Jogador;
    }

    public String getMes_Pagamento() {
        return mes_Pagamento;
    }

    public void setMes_Pagamento(String mes_Pagamento) {
        this.mes_Pagamento = mes_Pagamento;
    }

    public String getDia_Pagamento() {
        return dia_Pagamento;
    }

    public void setDia_Pagamento(String dia_Pagamento) {
        this.dia_Pagamento = dia_Pagamento;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }
}
