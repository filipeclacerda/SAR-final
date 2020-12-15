/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MotivoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Filipe Lacerda
 */
public class Motivo {
          public static Motivo obterMotivo(int idMotivo) throws ClassNotFoundException, SQLException{
        return MotivoDAO.getInstance().obterMotivo(idMotivo);
    }
     public static List<Motivo> obterMotivos() throws ClassNotFoundException, SQLException {
        return MotivoDAO.getInstance().obterMotivos();
    }
   
     private int idMotivo;
     private String nomeMotivo;
    /**
     * @return the idMotivo
     */
      public Motivo(){
        super();
    }
    public Motivo(int idMotivo, String nomeMotivo) {
        this.idMotivo = idMotivo;
        this.nomeMotivo = nomeMotivo;
    }
    public int getIdMotivo() {
        return idMotivo;
    }

    /**
     * @param idMotivo the idMotivo to set
     */
    public void setIdMotivo(int idMotivo) {
        this.idMotivo = idMotivo;
    }
 /**
     * @return the nomeMotivo
     */
    public String getNomeMotivo() {
        return nomeMotivo;
    }

    public void setNomeMotivo(String nomeMotivo) {
        this.nomeMotivo = nomeMotivo;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
    MotivoDAO.getInstance().gravar(this);
}
    public void alterar() throws SQLException, ClassNotFoundException {
    MotivoDAO.getInstance().alterar(this);
    }
    public void excluir() throws SQLException, ClassNotFoundException {
    MotivoDAO.getInstance().excluir(this);
    }
}
