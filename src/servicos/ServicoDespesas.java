package servicos;

import classes.Despesas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


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
    
    public ArrayList<Despesas> getListaDespesas() throws SQLException{
        Connection con = conexao.getConexao();
        ArrayList<Despesas> lista = new ArrayList<>();
        
        Statement st = conexao.getConexao().createStatement();
        ResultSet rs = st.executeQuery(
                "Select * from despesas"
        );
        
        while (rs.next()){
          lista.add(new Despesas(rs.getInt("id"), rs.getFloat("valor"), rs.getString("dataPagamento"), 
                  rs.getString("dataPagamentoEsperado"), rs.getString("tipoDespesa"), rs.getString("conta")));
        }
        conexao.close();
        return lista;
    }
    
    public void update(Despesas depesas) throws SQLException {
        Connection con = conexao.getConexao();    
        try (PreparedStatement pst = con.prepareStatement
            ("update despesas set valor = ?, dataPagamento = ?, dataPagamentoEsperado = ?, tipoDespesa = ?, conta = ? where id = ?")) {
        pst.setFloat(1, depesas.getValor());
        pst.setString(2, depesas.getDataPagamento());
        pst.setString(3, depesas.getDataPagamentoEsperado());
        pst.setString(4, depesas.getTipoDespesa());
        pst.setString(5, depesas.getConta());
        pst.setInt(6, depesas.getId());
        pst.executeUpdate();
        }
        conexao.close();
    }
    



}


    
    
