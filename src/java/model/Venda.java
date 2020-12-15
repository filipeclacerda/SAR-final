/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.FuncionarioDAO;
import dao.VendaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class Venda {

    private Integer numero;
    private Funcionario funcionario;
    private Date dataVenda;
    private Float valorTotal;
    private ArrayList<ItemVenda> itensVenda;

    private Integer codFuncionario = 0;

    public Venda() {
        this.itensVenda = new ArrayList<ItemVenda>();
    }

    public Venda(Integer numero, Funcionario funcionario, Date dataVenda, Float valorTotal, ArrayList<ItemVenda> itensVenda) {
        this.numero = numero;
        this.funcionario = funcionario;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.itensVenda = itensVenda;

    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Funcionario getFuncionario() {
        if ((this.codFuncionario != 0) && (this.funcionario == null)) {
            try {
                this.funcionario = FuncionarioDAO.getInstance().obterFuncionario(this.codFuncionario);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ArrayList<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ArrayList<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }
    
    public void adicionarItem(ItemVenda item) {
        this.itensVenda.add(item);
    }

    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }


    public static Venda obterVenda(int numero)
            throws ClassNotFoundException, SQLException {
        return VendaDAO.getInstance().obterVenda(numero);
    }

    public static List<Venda> obterVendas()
            throws ClassNotFoundException, SQLException {
        return VendaDAO.getInstance().obterVendas();
    }


    public int gravar() throws ClassNotFoundException, SQLException {
        return VendaDAO.getInstance().gravar(this);
    }
    
    
}
