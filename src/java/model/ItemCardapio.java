/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import dao.ItemCardapioDAO;
import java.sql.SQLException;
/**
 *
 * @author Filipe Lacerda
 */
public class ItemCardapio {

    /**
     * @return the produtoID
     */
 
       public static ItemCardapio obterItemCardapio(int codCardapio) throws ClassNotFoundException, SQLException{
        return ItemCardapioDAO.getInstance().obterItemCardapio(codCardapio);
    }
    public static List<ItemCardapio> obterCardapios() throws ClassNotFoundException, SQLException {
        return ItemCardapioDAO.getInstance().obterItemCardapios();
    }
    
    private int quantidade;
    private String unidade;
    private Produto produto;
    private int produtoID;
    private int cardapioID;
    private Cardapio cardapio;
     /**
     * @return the quantidade
     */
    
    public ItemCardapio(){
        super();
    }
    public ItemCardapio(int quantidade, String unidade, int produtoID, int cardapioID) {
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.produtoID = produtoID;
        this.cardapioID = cardapioID;
        
        
       
    }
       public int getProdutoID() {
        return produtoID;
    }

    /**
     * @param produtoID the produtoID to set
     */
    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    /**
     * @return the cardapioID
     */
    public int getCardapioID() {
        return cardapioID;
    }

    /**
     * @param cardapioID the cardapioID to set
     */
    public void setCardapioID(int cardapioID) {
        this.cardapioID = cardapioID;
    }

    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the cardapio
     */
    public Cardapio getCardapio() {
        return cardapio;
    }

    /**
     * @param cardapio the cardapio to set
     */
    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    
}
