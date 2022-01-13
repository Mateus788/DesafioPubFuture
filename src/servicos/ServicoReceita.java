package servicos;

import classes.Receita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ServicoReceita {
    private final Conexao conexao = new Conexao();
    public void insert(Receita receita) throws SQLException {
        //Criando variavel conexao
        Connection con = conexao.getConexao();

        try(PreparedStatement pst = con.prepareStatement(
                   "insert into receitas(id, valor, dataRecebimento, "
                           + "dataRecebimentoEsperado, descricao, conta, "
                           + "tipoReceitas) values (0, ?, ?, ?, ?, ?, ?)"
           )){
            pst.setFloat(1, receita.getValor());
            pst.setString(2, receita.getDataRecebimento());
            pst.setString(3, receita.getDataRecebimentoEsperado());
            pst.setString(4, receita.getDescricao());
            pst.setString(5, receita.getConta());
            pst.setString(6, receita.getTipoReceitas());
            pst.executeUpdate();
         }

        Statement st = con.createStatement(); 
        //executa o cod abaixo

    conexao.close();
    }
}
