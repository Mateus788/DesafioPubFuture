package servicos;

import classes.Contas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ServicoContas {
    private final Conexao conexao = new Conexao();
    public void insert(Contas contas) throws SQLException {
        //Criando variavel conexao
        Connection con = (Connection) conexao.getConexao();

        try(PreparedStatement pst = con.prepareStatement(
                   "insert into Contas(id, saldo, tipoContas, "
                           + "instituicaoFinanceira) "
                           + "values (0, ?, ?, ?)"
           )){
            pst.setFloat(1, contas.getSaldo());
            pst.setString(2, contas.getTipoContas());
            pst.setString(3, contas.getInstituicaoFinanceira());
            pst.executeUpdate();
         }

        Statement st = con.createStatement(); 
        //executa o cod abaixo

    conexao.close();
    }
}
