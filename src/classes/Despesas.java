package classes;

public class Despesas {
    private int id;
    private float valor;
    private String dataPagamento;
    private String dataPagamentoEsperado;
    private String tipoDespesa;
    private Contas conta;

    public Despesas(int id, float valor, String dataPagamento, String dataPagamentoEsperado, String tipoDespesa, Contas conta) {
        this.id = id;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;
        this.tipoDespesa = tipoDespesa;
        this.conta = conta;
    }

    public Despesas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getDataPagamentoEsperado() {
        return dataPagamentoEsperado;
    }

    public void setDataPagamentoEsperado(String dataPagamentoEsperado) {
        this.dataPagamentoEsperado = dataPagamentoEsperado;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public Contas getConta() {
        return conta;
    }

    public void setConta(Contas conta) {
        this.conta = conta;
    }

    
    @Override
    public String toString() {
        return "Tipo de Despesa: " + this.tipoDespesa + " Conta: " + this.conta.getId() + " Valor: " + this.valor;
    }
    
    
}
