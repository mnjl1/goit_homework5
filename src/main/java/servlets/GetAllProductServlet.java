package servlets;

import dao.ManufacturerDAO;
import dao.ProductDAO;
import models.Manufacturer;
import models.Product;
import org.postgresql.core.Query;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class GetAllProductServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ProductDAO productDAO = new ProductDAO();
        List <Product> productList = productDAO.getAll();

        for (Product product: productList){

            Long id = product.getId();
            String name = product.getProductName();
            BigDecimal price = product.getPrice();

            response.getWriter().println(id +": " +", " +name +", " +price +", ");

        }
    }
}
