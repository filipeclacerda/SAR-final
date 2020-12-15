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
import model.TipoDespesa;


public class TipoDespesaDAO extends DAO {
    private static TipoDespesaDAO instance = new TipoDespesaDAO();
    public static TipoDespesaDAO getInstance() {
        return instance;
    }
    private TipoDespesaDAO() {};

    public List<TipoDespesa> obterTipoDespesas()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement st = null;
        List<TipoDespesa> cargos = new ArrayList<TipoDespesa>();
        TipoDespesa tipoDespesa = null;
        try{
            conexao = BD.getInstance().getConexao();
            st = conexao.createStatement();
            ResultSet rs= st.executeQuery("select * from tipoDespesa");
            while (rs.next()) {
                tipoDespesa = instanciarTipoDespesa(rs);
                cargos.add(tipoDespesa);
            }
                
        }finally {
            closeResources(conexao,st);
        }
        return cargos;
    }
    public TipoDespesa obterTipoDespesa(int idTipoDespesa) throws ClassNotFoundException, SQLException{
     Connection conexao = null;
     Statement comando = null;
     TipoDespesa tipoDespesa = null;
     try{
         conexao = BD.getInstance().getConexao();
         comando = conexao.createStatement();
         ResultSet rs= comando.executeQuery("select * from tipoDespesa where idTipoDespesa = "+ idTipoDespesa);
         rs.first();
         tipoDespesa = instanciarTipoDespesa(rs);
         
     }
     finally{
         closeResources(conexao, comando);
         
     }
     return tipoDespesa;
        
    }
    

    private TipoDespesa instanciarTipoDespesa(ResultSet rs) throws SQLException{
        TipoDespesa tipoDespesa = new TipoDespesa(rs.getInt("idTipoDespesa"),
        rs.getString("nomeDespesa"));
        //curso.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador"));
        return tipoDespesa;
    }

   public void gravar(TipoDespesa tipoDespesa) throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       PreparedStatement comando = null;
   try {
    conexao = BD.getInstance().getConexao();
    comando = conexao.prepareStatement("insert into tipoDespesa(idTipoDespesa, NomeDespesa) values("+tipoDespesa.getIdTipoDespesa()+", '"+tipoDespesa.getNomeDespesa()+"')");
    // if (curso.getCoordenador() == null ) {
    // comando.setNull(3, Types.INTEGER);
    // } else {
    // comando.setInt(3, curso.getCoordenador().getMatricula());
    // }
    comando.executeUpdate();
}finally{
       closeResources(conexao, comando);
   }
}
   public void alterar(TipoDespesa tipoDespesa) throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       PreparedStatement comando = null;
   try {
    conexao = BD.getInstance().getConexao();
    comando = conexao.prepareStatement("update tipoDespesa set NomeDespesa= '"+ tipoDespesa.getNomeDespesa()+"' where idTipoDespesa= ?");
    comando.setInt(1, tipoDespesa.getIdTipoDespesa());
    comando.executeUpdate();
    // if (curso.getCoordenador() == null ) {
    // comando.setNull(3, Types.INTEGER);
    // } else {
    // comando.setInt(3, curso.getCoordenador().getMatricula());
    // }

}finally{
       closeResources(conexao, comando);
   }
}
   public void excluir(TipoDespesa tipoDespesa) throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       PreparedStatement comando = null;
   try {
    conexao = BD.getInstance().getConexao();
    comando = conexao.prepareStatement("delete from tipoDespesa where idTipoDespesa=" + tipoDespesa.getIdTipoDespesa());
    comando.executeUpdate();
    // if (curso.getCoordenador() == null ) {
    // comando.setNull(3, Types.INTEGER);
    // } else {
    // comando.setInt(3, curso.getCoordenador().getMatricula());
    // }

}finally{
       closeResources(conexao, comando);
   }
}
}
