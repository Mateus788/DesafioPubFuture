package servicos;

import classes.Despesas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class ServicoDespesas {
    private final Conexao conexao = new Conexao();
    public void insert(Despesas despesas) throws SQLException {
        //Criando variavel conexao
        Connection con = conexao.getConexao();

        try(PreparedStatement pst = con.prepareStatement(
                   "insert into Despesas(id, valor, dataPagamento, "
                           + "dataPagamentoEsperado,tipoDespesa,Conta) "
                           + "values (0, ?, ?, ?, ?, ?)"
           )){
            pst.setFloat(1, despesas.getValor());
            pst.setString(2, despesas.getDataPagamento());
            pst.setString(3, despesas.getDataPagamentoEsperado());
            pst.setString(4, despesas.getTipoDespesa());
            pst.setString(5, despesas.getConta());
            pst.executeUpdate();
         }

        Statement st = con.createStatement(); 
        //executa o cod abaixo

    conexao.close();
    }
}
