package classes;

public class Receita {
    private int id;
    private float valor;
    private String dataRecebimento;
    private String dataRecebimentoEsperado;
    private String descricao;
    private Contas conta;
    private String tipoReceitas;

    public Receita() {
    }

    public Receita(int id, float valor, String dataRecebimento, String dataRecebimentoEsperado, String descricao, Contas conta, String tipoReceitas) {
        this.id = id;
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.descricao = descricao;
        this.conta = conta;
        this.tipoReceitas = tipoReceitas;
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

    public Contas getConta() {
        return conta;
    }

    public void setConta(Contas conta) {
        this.conta = conta;
    }

    public String getTipoReceitas() {
        return tipoReceitas;
    }

    public void setTipoReceitas(String tipoReceitas) {
        this.tipoReceitas = tipoReceitas;
    }

    

    @Override
    public String toString() {
        return "ID Conta: " + this.conta.getId() + " Tipo de Receita: " + this.tipoReceitas + " Valor: " + this.valor;
    }

    
    

    
}
