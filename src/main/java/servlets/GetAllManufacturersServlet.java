package servlets;

import dao.ManufacturerDAO;
import models.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

public class GetAllManufacturersServlet extends HttpServlet {
    ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
        List<Manufacturer> manufacturerList = manufacturerDAO.getAll();

        for (Manufacturer manufacturer: manufacturerList
             ) {
            Long id = manufacturer.getId();
            String manText = manufacturer.getManufacturerName();
            response.getWriter().println(
                    "<html>"+
                            "<body>"
                    +id +": " +manText +
                            "</body>"

            +"</html>");


        }
    }
}
