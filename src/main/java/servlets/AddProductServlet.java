package servlets;

import dao.ManufacturerDAO;
import dao.ProductDAO;
import models.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class AddProductServlet extends HttpServlet {
    ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
    ProductDAO productDAO = new ProductDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("/jsp/add_product.jsp").forward(request, response);


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html; charset = utf-8");
        try{

            String productName = request.getParameter("product_name");

            Long manufacturerId = Long.parseLong(request.getParameter("manufacturerid"));

            BigDecimal price = new BigDecimal(request.getParameter("price"));
            productDAO.create(productName, manufacturerId, price);

            response.getWriter().print("Товар добавлен.");

        }catch (Exception e){
            response.getWriter().print(e);
        }

    }
}