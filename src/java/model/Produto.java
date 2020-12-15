/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Filipe Lacerda
 */
public class Produto {
    
     public static Produto obterProduto(int codProduto) throws ClassNotFoundException, SQLException{
        return ProdutoDAO.getInstance().obterProduto(codProduto);
    }
     public static List<Produto> obterProdutos() throws ClassNotFoundException, SQLException {
        return ProdutoDAO.getInstance().obterProdutos();
    }
   private int idProduto;
   private String nomeProduto;
   private float preco;
    /**
     * @return the idProduto
     */
    public Produto(){
        super();
    }
    public Produto(int idProduto, String nomeProduto, Float preco) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
    }
    
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }


    /**
     * @return the unidade
     */
  
   public void gravar() throws SQLException, ClassNotFoundException {
    ProdutoDAO.getInstance().gravar(this);
}
    public void alterar() throws SQLException, ClassNotFoundException {
    ProdutoDAO.getInstance().alterar(this);
    }
    public void excluir() throws SQLException, ClassNotFoundException {
    ProdutoDAO.getInstance().excluir(this);
    
}

}
