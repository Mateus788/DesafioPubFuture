package servicos;

import classes.Contas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public ArrayList<Contas> getListaContas() throws SQLException{
        Connection con = conexao.getConexao();
        ArrayList<Contas> lista = new ArrayList<>();
        
        Statement st = conexao.getConexao().createStatement();
        ResultSet rs = st.executeQuery(
                "Select * from contas"
        );
        
        while (rs.next()){
          lista.add(new Contas(rs.getInt("id"), rs.getFloat("saldo"), rs.getString("tipoContas"), 
                  rs.getString("instituicaoFinanceira")));
        }
        conexao.close();
        return lista;
    }
    
    public void update(Contas contas) throws SQLException {
        Connection con = conexao.getConexao();    
        try (PreparedStatement pst = con.prepareStatement
            ("update contas set saldo = ?, tipoContas = ?, instituicaoFinanceira = ? where id = ?")) {
        pst.setFloat(1, contas.getSaldo());
        pst.setString(2, contas.getTipoContas());
        pst.setString(3, contas.getInstituicaoFinanceira());
        pst.setInt(4, contas.getId());
        pst.executeUpdate();
        }
        conexao.close();
    }
    
    public void delete(Contas contas) throws SQLException{
        Connection con = conexao.getConexao();  
        try(PreparedStatement pst = con.prepareStatement
            ("delete from contas where id = ?")){
            pst.setInt(1, contas.getId());
            pst.executeUpdate();            
    }
        
    }
}

       