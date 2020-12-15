/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

/**
 *
 * @author Filipe Lacerda
 */
public class FuncionarioDAO extends DAO{
      private static FuncionarioDAO instance = new FuncionarioDAO();

    public static FuncionarioDAO getInstance() {
        return instance;
    }

    private FuncionarioDAO() {
    }

    public List<Funcionario> obterFuncionarios()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement st = null;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = null;
        try {
            conexao = BD.getInstance().getConexao();
            st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from funcionario");
            while (rs.next()) {
                funcionario = instanciarFuncionario(rs);
                funcionarios.add(funcionario);
            }

        } finally {
            closeResources(conexao, st);
        }
        return funcionarios;
    }
    
    public Funcionario obterFuncionario(int codFuncionario) throws ClassNotFoundException, SQLException{
     Connection conexao = null;
     Statement comando = null;
     Funcionario funcionario = null;
     try{
         conexao = BD.getInstance().getConexao();
         comando = conexao.createStatement();
         ResultSet rs= comando.executeQuery("select * from funcionario where idFuncionario = "+ codFuncionario);
         rs.first();
         funcionario = instanciarFuncionario(rs);
         
     }
     finally{
         closeResources(conexao, comando);
         
     }
     return funcionario;
        
    }

    private Funcionario instanciarFuncionario(ResultSet rs) throws SQLException{
        Funcionario funcionario = new Funcionario(
                rs.getInt("idFuncionario"),
                rs.getString("Nome"),
                rs.getFloat("Salario"),
                rs.getString("Logradouro"),
                rs.getInt("Numero"),
                rs.getString("Bairro"),
                rs.getString("Cidade"),
                rs.getString("Estado"),
                rs.getString("telefone"),
                null);
        funcionario.setIdCargo(rs.getInt("Cargo_idCargo"));
        return funcionario;
    }
   public void gravar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       PreparedStatement comando = null;
   try {
    conexao = BD.getInstance().getConexao();
    comando = conexao.prepareStatement("insert into funcionario(idFuncionario, Nome, salario, logradouro, numero, bairro, cidade, estado, telefone, cargo_idcargo) values("+funcionario.getIdFuncionario()+", '"+funcionario.getNome()+"', "+ funcionario.getSalario() + ", '"+ funcionario.getLogradouro() + "', "+ funcionario.getNumero() +", '"+ funcionario.getBairro() + "', '"+ funcionario.getCidade()+ "', '"+ funcionario.getEstado() +"', '"+ funcionario.getTelefone() +"', "+ funcionario.getCargo().getIdCargo() + ")");
    comando.executeUpdate();
}finally{
       closeResources(conexao, comando);
   }
}
   public void alterar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       PreparedStatement comando = null;
   try {
    conexao = BD.getInstance().getConexao();
    comando = conexao.prepareStatement("update funcionario set Nome= '"+ funcionario.getNome()+"', salario= "+ funcionario.getSalario() + ", logradouro= '" + funcionario.getLogradouro() + "', numero= " + funcionario.getNumero() + ", bairro= '" + funcionario.getBairro() + "', cidade= '" + funcionario.getCidade() + "', estado= '" + funcionario.getEstado() + "', telefone= '" + funcionario.getTelefone() + "', cargo_idcargo= " + funcionario.getCargo().getIdCargo() + " where idFuncionario=" + funcionario.getIdFuncionario());
    comando.executeUpdate();
}finally{
       closeResources(conexao, comando);
   }
}
   public void excluir(Funcionario funcionario) throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       PreparedStatement comando = null;
   try {
    conexao = BD.getInstance().getConexao();
    comando = conexao.prepareStatement("delete from funcionario where idFuncionario=" + funcionario.getIdFuncionario());
    comando.executeUpdate();

}finally{
       closeResources(conexao, comando);
   }
}
}
