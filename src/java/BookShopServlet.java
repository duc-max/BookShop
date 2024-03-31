/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author tranm
 */
public class BookShopServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookShopServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookShopServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        request.getRequestDispatcher("book.jsp").forward(request, response);
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
        String op = request.getParameter("op");
        String amount_raw = request.getParameter("amount");
        double pricePerBook = 0.0;
        try {
            pricePerBook = Price.getPrice(op).getPriceValue();
        } catch (Exception e) {
            System.out.println(e);
        }
        int amount = 0;
        try {
            amount = Integer.parseInt(amount_raw);

        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        // Tính tổng tiền
        double totalBill = amount * pricePerBook;
        
        request.setAttribute("op", op);
        request.setAttribute("amount", amount);
        request.setAttribute("pricePerBook", pricePerBook);
        request.setAttribute("totalBill", totalBill);
        request.getRequestDispatcher("cart.jsp").forward(request, response);

    }


    public enum Price {
        Ajax, Harry, Animals, Plants;

        public double getPriceValue() {
            switch (this) {
                case Ajax:
                    return 10000.0;
                case Harry:
                    return 20000.0;
                case Animals:
                    return 30000.0;
                case Plants:
                    return 40000.0;
            }

            throw new IndexOutOfBoundsException("Invalid value!");
        }

        public static Price getPrice(String type) throws Exception {
            switch (type) {
                case "Ajax":
                    return Ajax;
                case "Harry":
                    return Harry;
                case "Animals":
                    return Animals;
                case "Plants":
                    return Plants;
                default:
                    throw new Exception("Book not available");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
