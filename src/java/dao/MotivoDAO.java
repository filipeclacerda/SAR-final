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
import model.Motivo;


public class MotivoDAO extends DAO {
    private static MotivoDAO instance = new MotivoDAO();
    public static MotivoDAO getInstance() {
        return instance;
    }
    private MotivoDAO() {};

    public List<Motivo> obterMotivos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement st = null;
        List<Motivo> cargos = new ArrayList<Motivo>();
        Motivo motivo = null;
        try{
            conexao = BD.getInstance().getConexao();
            st = conexao.createStatement();
            ResultSet rs= st.executeQuery("select * from motivo");
            while (rs.next()) {
                motivo = instanciarMotivo(rs);
                cargos.add(motivo);
            }
                
        }finally {
            closeResources(conexao,st);
        }
        return cargos;
    }
    public Motivo obterMotivo(int idMotivo) throws ClassNotFoundException, SQLException{
     Connection conexao = null;
     Statement comando = null;
     Motivo motivo = null;
     try{
         conexao = BD.getInstance().getConexao();
         comando = conexao.createStatement();
         ResultSet rs= comando.executeQuery("select * from motivo where idMotivo = "+ idMotivo);
         rs.first();
         motivo = instanciarMotivo(rs);
         
     }
     finally{
         closeResources(conexao, comando);
         
     }
     return motivo;
        
    }
    

    private Motivo instanciarMotivo(ResultSet rs) throws SQLException{
        Motivo motivo = new Motivo(rs.getInt("idMotivo"),
        rs.getString("nomeMotivo"));
        //curso.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador"));
        return motivo;
    }

   public void gravar(Motivo motivo) throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       PreparedStatement comando = null;
   try {
    conexao = BD.getInstance().getConexao();
    comando = conexao.prepareStatement("insert into motivo(idMotivo, NomeMotivo) values("+motivo.getIdMotivo()+", '"+motivo.getNomeMotivo()+"')");
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
   public void alterar(Motivo motivo) throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       PreparedStatement comando = null;
   try {
    conexao = BD.getInstance().getConexao();
    comando = conexao.prepareStatement("update motivo set NomeMotivo= '"+ motivo.getNomeMotivo()+"' where idMotivo= ?");
    comando.setInt(1, motivo.getIdMotivo());
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
   public void excluir(Motivo motivo) throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       PreparedStatement comando = null;
   try {
    conexao = BD.getInstance().getConexao();
    comando = conexao.prepareStatement("delete from motivo where idMotivo=" + motivo.getIdMotivo());
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
