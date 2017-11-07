package servlets;

import dao.ManufacturerDAO;
import dao.ProductDAO;
import models.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddProductServlet extends HttpServlet {
    ManufacturerDAO manufacturerDAO = new ManufacturerDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/add_product.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset = utf-8");

        try{
            ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
            List<Manufacturer> manufacturerList = manufacturerDAO.getAll();

            String productName = request.getParameter("productName");
            Long manufacturerId = Long.parseLong(request.getParameter("manufactureId"));

            ProductDAO productDAO = new ProductDAO();
            productDAO.create(productName, manufacturerId);

        }catch (Exception e){
            response.getWriter().print("Ошибка ввода товара");
        }
    }
}
