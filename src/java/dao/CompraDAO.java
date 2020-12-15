/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Compra;

/**
 *
 * @author Filipe Lacerda
 */
public class CompraDAO extends DAO {

    private static CompraDAO instance = new CompraDAO();

    public static CompraDAO getInstance() {
        return instance;
    }

    private CompraDAO() {
    }

    public List<Compra> obterCompras()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement st = null;
        List<Compra> compras = new ArrayList<Compra>();
        Compra compra = null;
        try {
            conexao = BD.getInstance().getConexao();
            st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from compra");
            while (rs.next()) {
                compra = instanciarCompra(rs);
                compras.add(compra);
            }

        } finally {
            closeResources(conexao, st);
        }
        return compras;
    }
    public Compra obterCompra(int codCompra) throws ClassNotFoundException, SQLException{
     Connection conexao = null;
     Statement comando = null;
     Compra compra = null;
     try{
         conexao = BD.getInstance().getConexao();
         comando = conexao.createStatement();
         ResultSet rs= comando.executeQuery("select * from compra where idCompra = "+ codCompra);
         rs.first();
         compra = instanciarCompra(rs);
         
     }
     finally{
         closeResources(conexao, comando);
         
     }
     return compra;
        
    }

    private Compra instanciarCompra(ResultSet rs) throws SQLException{
        Compra compra = new Compra(rs.getInt("idCompra"),
        rs.getString("DataCompra"));
        //curso.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador"));
        return compra;
    }

}
