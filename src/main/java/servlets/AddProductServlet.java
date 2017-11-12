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
    ProductDAO productDAO = new ProductDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
        List<Manufacturer> manufacturerList = manufacturerDAO.getAll();
        request.setAttribute("list", manufacturerList);

        request.getRequestDispatcher("/jsp/add_product.jsp").forward(request, response);

        try{

            String productName = request.getParameter("productName");

            Long manufacturerId = Long.parseLong(request.getParameter("manufacturerId"));

            productDAO.create(productName, manufacturerId);
            response.getWriter().print("Товар добавлен.");

        }catch (Exception e){
            response.getWriter().print("Ошибка ввода товара");
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
