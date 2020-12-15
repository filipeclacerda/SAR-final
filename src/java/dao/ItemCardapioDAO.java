
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ItemCardapio;

public class ItemCardapioDAO extends DAO {

    private static ItemCardapioDAO instance = new ItemCardapioDAO();

    public static ItemCardapioDAO getInstance() {
        return instance;
    }

    private ItemCardapioDAO() {
    }

    public List<ItemCardapio> obterItemCardapios()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement st = null;
        List<ItemCardapio> itemCardapios = new ArrayList<ItemCardapio>();
        ItemCardapio itemCardapio = null;
        try {
            conexao = BD.getInstance().getConexao();
            st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from itemCardapio");
            while (rs.next()) {
            //    itemCardapio = instanciarItemCardapio(rs);
                itemCardapios.add(itemCardapio);
            }

        } finally {
            closeResources(conexao, st);
        }
        return itemCardapios;
    }
    public ItemCardapio obterItemCardapio(int codItemCardapio) throws ClassNotFoundException, SQLException{
     Connection conexao = null;
     Statement comando = null;
     ItemCardapio itemCardapio = null;
     try{
         conexao = BD.getInstance().getConexao();
         comando = conexao.createStatement();
         ResultSet rs= comando.executeQuery("select * from itemCardapio where idItemCardapio = "+ codItemCardapio);
         rs.first();
        // itemCardapio = instanciarItemCardapio(rs);
         
     }
     finally{
         closeResources(conexao, comando);
         
     }
     return itemCardapio;
        
    }

  //  private ItemCardapio instanciarItemCardapio(ResultSet rs) throws SQLException{
      //  ItemCardapio itemCardapio = new ItemCardapio(rs.getInt("idItemCardapio"),
        //rs.getString("Quantidade"),
        //itemCardapio.setProdutoID(rs.getInt("produtoid")),
      //  itemCardapio.setCardapioID(rs.getInt("cardapioid"));
       // return itemCardapio;
 //   }

}

