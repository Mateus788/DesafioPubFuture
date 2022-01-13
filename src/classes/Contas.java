package classes;

public class Contas {
    private float Saldo;
    private String tipoContas;
    private String instituicaoFinanceira;
   
    public Contas() {
    }

    public Contas(float Saldo, String tipoContas, String instituicaoFinanceira) {
        this.Saldo = Saldo;
        this.tipoContas = tipoContas;
        this.instituicaoFinanceira = instituicaoFinanceira;
    }

    public float getSaldo() {
        return Saldo;
    }

    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
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
    
}
