/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cargo;
import model.Despesa;
import model.Funcionario;
import model.TipoDespesa;

public class ManterDespesaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("funcionarios", Funcionario.obterFuncionarios());
            request.setAttribute("tipoDespesas", TipoDespesa.obterTipoDespesas());
            if (!operacao.equals("Incluir")) {
                int idDespesa = Integer.parseInt(request.getParameter("idDespesa"));
                Despesa despesa = Despesa.obterDespesa(idDespesa);
                request.setAttribute("despesa", despesa);
            }
            RequestDispatcher view = request.getRequestDispatcher("/telaDespesa.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String operacao = request.getParameter("operacao");
        int idDespesa = Integer.parseInt(request.getParameter("idDespesa"));
        float valorDespesa = Float.parseFloat(request.getParameter("valorDespesa"));
        float valorPago = Float.parseFloat(request.getParameter("valorPago"));
        String dataVencimento = request.getParameter("dataVencimento");
        String dataPagamento = request.getParameter("dataPagamento");
        int idFuncionario = Integer.parseInt(request.getParameter("Funcionario_idFuncionario"));
        int idTipoDespesa = Integer.parseInt(request.getParameter("TipoDespesa_idTipoDespesa"));
        try {
            Funcionario funcionario = null;
             if (idFuncionario != 0 ) {
             funcionario = Funcionario.obterFuncionario(idFuncionario);
             }
             TipoDespesa tipoDespesa = null;
             if (idTipoDespesa != 0 ) {
             tipoDespesa = TipoDespesa.obterTipoDespesa(idTipoDespesa);
             }
             
             Despesa despesa = new Despesa(idDespesa,valorDespesa, valorPago, dataVencimento, dataPagamento, funcionario, tipoDespesa);
            if (operacao.equals("Incluir")) {
                despesa.gravar();
                } else {
                  if (operacao.equals("Editar")) {
                      despesa.alterar();
               }
                  else {
                  if (operacao.equals("Excluir")) {
                        despesa.excluir();
                    }
                  }
            
             }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaDespesaController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
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
