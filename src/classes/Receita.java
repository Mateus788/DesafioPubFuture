package classes;

import java.util.Date;

public class Receita {
    private float valor;
    private String dataRecebimento;
    private String dataRecebimentoEsperado;
    private String descricao;
    private String conta;
    private String tipoReceitas;

    public Receita() {
    }

    public Receita(float valor, String dataRecebimento, String dataRecebimentoEsperado, String descricao, String conta, String tipoReceitas) {
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.descricao = descricao;
        this.conta = conta;
        this.tipoReceitas = tipoReceitas;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getDataRecebimentoEsperado() {
        return dataRecebimentoEsperado;
    }

    public void setDataRecebimentoEsperado(String dataRecebimentoEsperado) {
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getTipoReceitas() {
        return tipoReceitas;
    }

    public void setTipoReceitas(String tipoReceitas) {
        this.tipoReceitas = tipoReceitas;
    }

}