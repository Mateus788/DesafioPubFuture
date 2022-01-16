package servicos;

import classes.Despesas;
import classes.Contas;
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
                   "insert into Despesas(id_despesas, valor, dataPagamento, "
                           + "dataPagamentoEsperado,tipoDespesa,conta_id) "
                           + "values (0, ?, ?, ?, ?, ?)"
           )){
            pst.setFloat(1, despesas.getValor());
            pst.setString(2, despesas.getDataPagamento());
            pst.setString(3, despesas.getDataPagamentoEsperado());
            pst.setString(4, despesas.getTipoDespesa());
            pst.setInt(5, despesas.getConta().getId());
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
                "select * from despesas, contas where despesas.conta_id = contas.id_contas"
        );
        
        while (rs.next()){
          lista.add(new Despesas(rs.getInt("id_despesas"), rs.getFloat("valor"), rs.getString("dataPagamento"), 
                  rs.getString("dataPagamentoEsperado"), rs.getString("tipoDespesa"), new Contas(rs.getInt("id_contas"), rs.getFloat("saldo"), rs.getString("tipoContas"), rs.getString("instituicaoFinanceira"))));
        }
        conexao.close();
        return lista;
    }
    
    public void update(Despesas depesas) throws SQLException {
        Connection con = conexao.getConexao();    
        try (PreparedStatement pst = con.prepareStatement
            ("update despesas set valor = ?, dataPagamento = ?, "
                    + "dataPagamentoEsperado = ?, tipoDespesa = ?, conta_id = ?"
                    + " where id_despesas = ?")) {
        pst.setFloat(1, depesas.getValor());
        pst.setString(2, depesas.getDataPagamento());
        pst.setString(3, depesas.getDataPagamentoEsperado());
        pst.setString(4, depesas.getTipoDespesa());
        pst.setInt(5, depesas.getConta().getId());
        pst.setInt(6, depesas.getId());
        pst.executeUpdate();
        }
        conexao.close();
    }
    
    public void delete(Despesas despesas) throws SQLException{
            Connection con = conexao.getConexao();  
            try(PreparedStatement pst = con.prepareStatement
                ("delete from despesas where id_despesas = ?")){
                pst.setInt(1, despesas.getId());
                pst.executeUpdate();            
        }

        }
    }



    
