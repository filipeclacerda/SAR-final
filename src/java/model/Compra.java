/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import dao.CompraDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Filipe Lacerda
 */
public class Compra {

     public static Compra obterCompra(int codCardapio) throws ClassNotFoundException, SQLException{
        return CompraDAO.getInstance().obterCompra(codCardapio);
    }
    public static List<Compra> obterCompras() throws ClassNotFoundException, SQLException {
        return CompraDAO.getInstance().obterCompras();
    }



    private int idCompra;
    private Funcionario funcionario;
    private String dataCompra;
    private Date dataPedido;
    private Float valorTotal;
    private ArrayList<ItemCompra> itensPedido;    
    
    /**
     * @return the idCompra
     */
      public Compra(){
        super();
    }
    public Compra(int idCompra, String dataCompra) {
        this.idCompra = idCompra;
        this.dataCompra = dataCompra;
       
    }

    public int getIdCompra() {
        return idCompra;
    }

    /**
     * @param idCompra the idCompra to set
     */
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
 /**
     * @return the dataCompra
     */
    public String getDataCompra() {
        return dataCompra;
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    
    
   
}
