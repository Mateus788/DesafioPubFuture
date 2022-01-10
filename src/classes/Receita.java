package classes;

import java.util.Date;

public class Receita {
    private float valor;
    private Date dataRecebimento;
    private Date dataRecebimentoEsperado;
    private String descricao;
    private String conta;
    private String tipoReceitas;

    public Receita(float valor, Date dataRecebimento, Date dataRecebimentoEsperado, String descricao, String conta, String tipoReceitas) {
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.descricao = descricao;
        this.conta = conta;
        this.tipoReceitas = tipoReceitas;
    }

    public Receita() {
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Date getDataRecebimentoEsperado() {
        return dataRecebimentoEsperado;
    }

    public void setDataRecebimentoEsperado(Date dataRecebimentoEsperado) {
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
