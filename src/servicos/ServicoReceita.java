package servicos;

import classes.Contas;
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
                   "insert into receitas(id_receitas, valor, dataRecebimento, "
                           + "dataRecebimentoEsperado, descricao, conta_id, "
                           + "tipoReceitas) values (0, ?, ?, ?, ?, ?, ?)"
           )){
            pst.setFloat(1, receita.getValor());
            pst.setString(2, receita.getDataRecebimento());
            pst.setString(3, receita.getDataRecebimentoEsperado());
            pst.setString(4, receita.getDescricao());
            pst.setInt(5, receita.getConta().getId());
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
                "select * from receitas, contas where receitas.conta_id = contas.id_contas"
        );
        
        while (rs.next()){
          lista.add(new Receita(rs.getInt("id_receitas"), rs.getFloat("valor"), rs.getString("dataRecebimento"), 
                  rs.getString("dataRecebimentoEsperado"), rs.getString("descricao"),new Contas(rs.getInt("id_contas"), rs.getFloat("saldo"), rs.getString("tipoContas"), rs.getString("instituicaoFinanceira")), 
                  rs.getString("tipoReceitas")));
        }
        conexao.close();
        return lista;
    }
    
    public void update(Receita receita) throws SQLException {
        Connection con = conexao.getConexao();    
        try (PreparedStatement pst = con.prepareStatement
            ("update receitas set valor = ?, dataRecebimento = ?, dataRecebimentoEsperado = ?, descricao = ?, tipoReceitas = ? where id_receitas = ?")) {
        pst.setFloat(1, receita.getValor());
        pst.setString(2, receita.getDataRecebimento());
        pst.setString(3, receita.getDataRecebimentoEsperado());
        pst.setString(4, receita.getDescricao());
        pst.setString(5, receita.getTipoReceitas());
        pst.setInt(6, receita.getId());
        pst.executeUpdate();
        }
        conexao.close();
    }
    
    public void delete(Receita receita) throws SQLException{
        Connection con = conexao.getConexao();  
        try(PreparedStatement pst = con.prepareStatement
            ("delete from receitas where id_receitas = ?")){
            pst.setInt(1, receita.getId());
            pst.executeUpdate();            
    }
        
    }
    
    public ArrayList<Receita> getReceitasByDate(String primeiroperiodo, String segundoperiodo) throws SQLException{
        Connection con = conexao.getConexao();
        ArrayList<Receita> lista = new ArrayList<>();
        
        Statement st = conexao.getConexao().createStatement();
        ResultSet rs = st.executeQuery(
                "select * from receitas, contas where dataRecebimento between '" + primeiroperiodo + "' and '" + segundoperiodo + "' and receitas.conta_id = contas.id_contas" 
        );
        
        while (rs.next()){
          lista.add(new Receita(rs.getInt("id_receitas"), rs.getFloat("valor"), rs.getString("dataRecebimento"), 
                  rs.getString("dataRecebimentoEsperado"), rs.getString("descricao"),new Contas(rs.getInt("id_contas"), rs.getFloat("saldo"), rs.getString("tipoContas"), rs.getString("instituicaoFinanceira")), 
                  rs.getString("tipoReceitas")));
        }
        conexao.close();
        return lista;  
      
        
        
    }
        
    
}
