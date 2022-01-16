package classes;

public class Contas {
    private int id;
    private float saldo;
    private String tipoContas;
    private String instituicaoFinanceira;

    public Contas(int id, float saldo, String tipoContas, String instituicaoFinanceira) {
        this.id = id;
        this.saldo = saldo;
        this.tipoContas = tipoContas;
        this.instituicaoFinanceira = instituicaoFinanceira;
    }

    public Contas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getTipoContas() {
        return tipoContas;
    }

    public void setTipoContas(String tipoContas) {
        this.tipoContas = tipoContas;
    }

    public String getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    public void setInstituicaoFinanceira(String instituicaoFinanceira) {
        this.instituicaoFinanceira = instituicaoFinanceira;
    }


    
    @Override
    public String toString() {
        return "ID da conta: " + this.id + " Saldo: " + this.saldo + " Tipo Conta: " + this.tipoContas;
    }
    
    
    
}
