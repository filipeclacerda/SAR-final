/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DespesaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Filipe Lacerda
 */
public class Despesa {

 

    

    
    private int idDespesa;
    private float valorDespesa;
    private float valorPago;
    private String dataVencimento;
    private String dataPagamento;
    private Funcionario funcionario;
    private TipoDespesa tipoDespesa;
    
    private int idFuncionario;
    private int idTipoDespesa;
  
    public Despesa(){
        super();
    }
    
    public Despesa(int idDespesa, float valorDespesa, float valorPago, String dataVencimento, String dataPagamento, Funcionario funcionario, TipoDespesa tipoDespesa){
        this.idDespesa = idDespesa;
        this.valorDespesa = valorDespesa;
        this.valorPago = valorPago;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.funcionario = funcionario;
        this.tipoDespesa = tipoDespesa;
        
    }
     public static Despesa obterDespesa(int idDespesa) throws ClassNotFoundException, SQLException{
        return DespesaDAO.getInstance().obterDespesa(idDespesa);
    }

   public static List<Despesa> obterDespesas() throws ClassNotFoundException, SQLException {
        return DespesaDAO.getInstance().obterDespesas();
    }
    
    /**
     * @return the idDespesa
     */
    public int getIdDespesa() {
        return idDespesa;
    }

    /**
     * @param idDespesa the idDespesa to set
     */
    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
    }

    /**
     * @return the valorDespesa
     */
    public float getValorDespesa() {
        return valorDespesa;
    }

    /**
     * @param valorDespesa the valorDespesa to set
     */
    public void setValorDespesa(float valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    /**
     * @return the valorPago
     */
    public float getValorPago() {
        return valorPago;
    }

    /**
     * @param valorPago the valorPago to set
     */
    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    /**
     * @return the dataVencimento
     */
    public String getDataVencimento() {
        return dataVencimento;
    }

    /**
     * @param dataVencimento the dataVencimento to set
     */
    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    /**
     * @return the dataPagamento
     */
    public String getDataPagamento() {
        return dataPagamento;
    }

    /**
     * @param dataPagamento the dataPagamento to set
     */
    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() throws ClassNotFoundException, SQLException{
        if((this.idFuncionario != 0) && (this.funcionario == null)){
            this.funcionario = Funcionario.obterFuncionario(this.idFuncionario);
            
        }
        return this.funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the tipoDespesa
     */
    public TipoDespesa getTipoDespesa() throws ClassNotFoundException, SQLException{
        if((this.idTipoDespesa != 0) && (this.tipoDespesa == null)){
            this.tipoDespesa = TipoDespesa.obterTipoDespesa(this.idTipoDespesa);
            
        }
        return this.tipoDespesa;
    }
       /**
     * @return the idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the idTipoDespesa
     */
    public int getIdTipoDespesa() {
        return idTipoDespesa;
    }

    /**
     * @param idTipoDespesa the idTipoDespesa to set
     */
    public void setIdTipoDespesa(int idTipoDespesa) {
        this.idTipoDespesa = idTipoDespesa;
    }

    /**
     * @param tipoDespesa the tipoDespesa to set
     */
    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
    DespesaDAO.getInstance().gravar(this);
}
    public void alterar() throws SQLException, ClassNotFoundException {
    DespesaDAO.getInstance().alterar(this);
    }
    public void excluir() throws SQLException, ClassNotFoundException {
    DespesaDAO.getInstance().excluir(this);
    
}
   
   
}
