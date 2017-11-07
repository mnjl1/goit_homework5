package servlets;

import dao.ManufacturerDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateManufacturerServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/jsp/update_manufacturer.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset = utf-8");

        try{
            Long manufacturerId = Long.parseLong(request.getParameter("manufacturerId"));
            String manufacturerName = request.getParameter("manufacturerName");
            ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
            manufacturerDAO.update(manufacturerName, manufacturerId);
            response.getWriter().print("Производитель изменен.");
        }catch (Exception e){
            response.getWriter().print("Ошибка");
        }
    }
}
