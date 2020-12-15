/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Despesa;


public class DespesaDAO extends DAO {
    private static DespesaDAO instance = new DespesaDAO();
    public static DespesaDAO getInstance() {
        return instance;
    }
    private DespesaDAO() {};

    public List<Despesa> obterDespesas()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement st = null;
        List<Despesa> despesas = new ArrayList<Despesa>();
        Despesa despesa = null;
        try{
            conexao = BD.getInstance().getConexao();
            st = conexao.createStatement();
            ResultSet rs= st.executeQuery("select * from despesa");
            while (rs.next()) {
                despesa = instanciarDespesa(rs);
                despesas.add(despesa);
            }
                
        }finally {
            closeResources(conexao,st);
        }
        return despesas;
    }
    public Despesa obterDespesa(int codDespesa) throws ClassNotFoundException, SQLException{
     Connection conexao = null;
     Statement comando = null;
     Despesa despesa = null;
     try{
         conexao = BD.getInstance().getConexao();
         comando = conexao.createStatement();
         ResultSet rs= comando.executeQuery("select * from despesa where idDespesa = "+ codDespesa);
         rs.first();
         despesa = instanciarDespesa(rs);
         
     }
     finally{
         closeResources(conexao, comando);
         
     }
     return despesa;
        
    }

    
    private Despesa instanciarDespesa(ResultSet rs) throws SQLException{
        Despesa despesa = new Despesa(rs.getInt("idDespesa"),
        rs.getFloat("valorDespesa"),
        rs.getFloat("valorPago"),
        rs.getString("dataVencimento"),
        rs.getString("dataPagamento"),
        null,
        null);
        despesa.setIdFuncionario(rs.getInt("Funcionario_idFuncionario"));
        despesa.setIdTipoDespesa(rs.getInt("TipoDespesa_idTipoDespesa"));
        return despesa;
    }

   public void gravar(Despesa despesa) throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       PreparedStatement comando = null;
   try {
    conexao = BD.getInstance().getConexao();
    comando = conexao.prepareStatement("insert into despesa(idDespesa, valorDespesa, valorPago, dataVencimento, dataPagamento, Funcionario_idFuncionario, TipoDespesa_idTipoDespesa) values("+despesa.getIdDespesa()+", "+despesa.getValorDespesa()+", "+ despesa.getValorPago() + ", '"+ despesa.getDataVencimento() + "', '"+ despesa.getDataPagamento() +"', "+ despesa.getFuncionario().getIdFuncionario() + ", "+ despesa.getTipoDespesa().getIdTipoDespesa() + ")");
    comando.executeUpdate();
}finally{
       closeResources(conexao, comando);
   }
}
   public void alterar(Despesa despesa) throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       PreparedStatement comando = null;
   try {
    conexao = BD.getInstance().getConexao();
    comando = conexao.prepareStatement("update despesa set valorDespesa= "+ despesa.getValorDespesa()+", valorPago= "+ despesa.getValorPago() + ", dataVencimento= '" + despesa.getDataVencimento() + "', dataPagamento= '" + despesa.getDataPagamento() + "', Funcionario_idFuncionario= " + despesa.getFuncionario().getIdFuncionario() + ", TipoDespesa_idTipoDespesa= " + despesa.getTipoDespesa().getIdTipoDespesa() + " where idDespesa="+ despesa.getIdDespesa());
    comando.executeUpdate();
}finally{
       closeResources(conexao, comando);
   }
}
   public void excluir(Despesa despesa) throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       PreparedStatement comando = null;
   try {
    conexao = BD.getInstance().getConexao();
    comando = conexao.prepareStatement("delete from despesa where idDespesa= " + despesa.getIdDespesa());
    comando.executeUpdate();

}finally{
       closeResources(conexao, comando);
   }
}
}