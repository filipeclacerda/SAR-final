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
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import model.ItemVenda;
import model.Venda;

/**
 *
 * @author Marco
 */
public class VendaDAO extends DAO {

    private static VendaDAO instancia = new VendaDAO();

    public static VendaDAO getInstance() {
        return instancia;
    }

    public Venda obterVenda(int numero) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Venda venda = null;
        try {
            conexao = BD.getInstance().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from venda where idvenda = " + numero);
            rs.first();
            venda = instanciarVenda(rs);
        } finally {
            closeResources(conexao, comando);
        }
        return venda;
    }

    public List<Venda> obterVendas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Venda> vendas = new ArrayList<Venda>();
        Venda venda = null;
        try {
            conexao = BD.getInstance().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from venda");
            while (rs.next()) {
                venda = instanciarVenda(rs);
                vendas.add(venda);
            }
        } finally {
            closeResources(conexao, comando);
        }
        return vendas;
    }

    public Venda instanciarVenda(ResultSet rs) throws SQLException {
        Class classe = null;
        Object objeto = null;
        try {
            objeto = classe.newInstance();
        } catch (Exception ex) {
        }

        Venda venda = new Venda(
                rs.getInt("idvenda"),
                null,
                rs.getDate("datavenda"),
                rs.getFloat("valortotal"),
                null);
        venda.setCodFuncionario(rs.getInt("idfuncionario"));
        return venda;
    }

    public int gravar(Venda venda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        int id = 0;
        try {
            conexao = BD.getInstance().getConexao();
            conexao.setAutoCommit(false);
            comando = conexao.prepareStatement(
                    "insert into venda (idfuncionario, datavenda, valortotal) values (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            comando.setInt(1, venda.getFuncionario().getIdFuncionario());
            comando.setDate(2, new java.sql.Date(venda.getDataVenda().getTime()));
            comando.setFloat(3, venda.getValorTotal());
            comando.executeUpdate();

            ResultSet rs = comando.getGeneratedKeys();
            id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            int num_item = 0;
            for (ItemVenda item : venda.getItensVenda()) {
                comando = conexao.prepareStatement(
                        "insert into item_venda (num_venda, num_item, idproduto, quantidade, valor) values (?,?,?,?,?)");
                num_item = num_item + 1;
                comando.setInt(1, id);
                comando.setInt(2, num_item);
                comando.setInt(3, item.getProduto().getIdProduto());
                comando.setFloat(4, item.getQuantidade());
                comando.setFloat(5, item.getPrecoUnitario());
                comando.executeUpdate();
            }
            conexao.commit();
        } catch (SQLException e) {
            conexao.rollback();
        } finally {
            closeResources(conexao, comando);
        }
        return id;
    }
        

    
}
