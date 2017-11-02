package servlets;

import dao.ManufacturerDAO;
import models.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddManufacturerServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/add_manufacturer.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset = utf-8");

        try {
            String name = request.getParameter("manufacturerName");
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setManufacturerName(name);
            ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
            manufacturerDAO.create();

            response.getWriter().print("Производитель добавлен.");
        }catch (Exception e){
            response.getWriter().print("Ошибка!");
        }
    }


}
