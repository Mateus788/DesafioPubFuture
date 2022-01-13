package servicos;

import classes.Receita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    
    
    
    public ArrayList<Receita> getListaReceita() throws SQLException{
        Connection con = conexao.getConexao();
        ArrayList<Receita> lista = new ArrayList<>();
        
        Statement st = conexao.getConexao().createStatement();
        ResultSet rs = st.executeQuery(
                "Select * from receitas order by valor"
        );
        
        while (rs.next()){
          lista.add(new Receita(rs.getInt("id"), rs.getFloat("valor"), rs.getString("dataRecebimento"), 
                  rs.getString("dataRecebimentoEsperado"), rs.getString("descricao"), rs.getString("conta"), 
                  rs.getString("tipoReceitas")));
        }
        conexao.close();
        return lista;
    }
    
    public void update(Receita receita) throws SQLException {
        Connection con = conexao.getConexao();    
        try (PreparedStatement pst = con.prepareStatement
            ("update receitas set valor = ?, dataRecebimento = ?, dataRecebimentoEsperado = ?, descricao = ?, conta = ?, tipoReceitas = ? where id = ?")) {
        pst.setFloat(1, receita.getValor());
        pst.setString(2, receita.getDataRecebimento());
        pst.setString(3, receita.getDataRecebimentoEsperado());
        pst.setString(4, receita.getDescricao());
        pst.setString(5, receita.getConta());
        pst.setString(6, receita.getTipoReceitas());
        pst.setInt(7, receita.getId());
        pst.executeUpdate();
        }
        conexao.close();
    }
    
    
    
}
