/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;
import model.ItemVenda;
import model.Produto;
import model.Venda;


/**
 *
 * @author Marco
 */
public class EfetuarPedidoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("preparar")) {
            preparar(request, response);
        } else {
            if (acao.equals("confirmar")) {
                confirmar(request, response);
            }
        }
    }

    public void preparar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        try {
            request.setAttribute("funcionarios", Funcionario.obterFuncionarios());
            request.setAttribute("produtos", Produto.obterProdutos());
            RequestDispatcher view = request.getRequestDispatcher("/realizarPedido.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EfetuarPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EfetuarPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void confirmar(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            Integer codFuncionario = Integer.parseInt(request.getParameter("funcionario"));
            Funcionario funcionario = Funcionario.obterFuncionario(codFuncionario);    
            String itensProdutos = request.getParameter("itensProdutos");
            String[] produtos = itensProdutos.split(";");
            String itensQuantidades = request.getParameter("itensQuantidades");
            String[] quantidades = itensQuantidades.split(";");
            String itensPrecos = request.getParameter("itensPrecos");
            String[] precos = itensPrecos.split(";");
            Float valorTotal = Float.parseFloat(request.getParameter("valorTotal"));

            Venda venda = new Venda();
            venda.setFuncionario(funcionario);
            venda.setDataVenda(new Date());
            venda.setValorTotal(valorTotal);

            for (int i = 0; i < produtos.length; i++) {
                Produto produto = Produto.obterProduto(Integer.parseInt(produtos[i]));
                ItemVenda item = new ItemVenda(produto, Float.parseFloat(quantidades[i]), Float.parseFloat(precos[i]));
                venda.adicionarItem(item);
            }

            int num_venda = venda.gravar();
            response.getWriter().println(num_venda);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EfetuarPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EfetuarPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EfetuarPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
