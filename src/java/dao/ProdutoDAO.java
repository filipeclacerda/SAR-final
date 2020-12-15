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
import model.Produto;

public class ProdutoDAO extends DAO {
    private static ProdutoDAO instance = new ProdutoDAO();
    public static ProdutoDAO getInstance() {
        return instance;
    }
    private ProdutoDAO() {};

    public List<Produto> obterProdutos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement st = null;
        List<Produto> produtos = new ArrayList<Produto>();
        Produto produto = null;
        try{
            conexao = BD.getInstance().getConexao();
            st = conexao.createStatement();
            ResultSet rs= st.executeQuery("select * from produto");
            while (rs.next()) {
                produto = instanciarProduto(rs);
                produtos.add(produto);
            }
                
        }finally {
            closeResources(conexao,st);
        }
        return produtos;
    }
    public Produto obterProduto(int codProduto) throws ClassNotFoundException, SQLException{
     Connection conexao = null;
     Statement comando = null;
     Produto produto = null;
     try{
         conexao = BD.getInstance().getConexao();
         comando = conexao.createStatement();
         ResultSet rs= comando.executeQuery("select * from produto where idProduto = "+ codProduto);
         rs.first();
         produto = instanciarProduto(rs);
         
     }
     finally{
         closeResources(conexao, comando);
         
     }
     return produto;
        
    }
    

    private Produto instanciarProduto(ResultSet rs) throws SQLException{
        Produto produto = new Produto(rs.getInt("idProduto"),
        rs.getString("nomeProduto"),
                rs.getFloat("preco"));
        //curso.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador"));
        return produto;
    }

   public void gravar(Produto produto) throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       PreparedStatement comando = null;
   try {
    conexao = BD.getInstance().getConexao();
    comando = conexao.prepareStatement("insert into produto(idProduto, NomeProduto, preco) values(?,?,?)");
    comando.setInt(1, produto.getIdProduto());
    comando.setString(2, produto.getNomeProduto());
    comando.setFloat(1, produto.getPreco());
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
   public void alterar(Produto produto) throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       PreparedStatement comando = null;
   try {
    conexao = BD.getInstance().getConexao();
    comando = conexao.prepareStatement("update produto set NomeProduto= '"+ produto.getNomeProduto()+"' where idProduto= ?");
    comando.setInt(1, produto.getIdProduto());
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
   public void excluir(Produto produto) throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       PreparedStatement comando = null;
   try {
    conexao = BD.getInstance().getConexao();
    comando = conexao.prepareStatement("delete from produto where idProduto=" + produto.getIdProduto());
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