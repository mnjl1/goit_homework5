package servlets;

import dao.ManufacturerDAO;
import models.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ManufacturerServlet extends HttpServlet {
    ManufacturerDAO manufacturerDAO = new ManufacturerDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("starting...");
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        Long manufactureId = Long.parseLong(request.getParameter("id"));
        Manufacturer manufacturer = getById(manufactureId);
        writer.println(
                "<html>" +
                        "<head>" +
                        "</head>" +
                        "<body>" +
                        "<h1>Manufacturer:</h1>" +
                        "<br/>" +
                        "ID:" + manufacturer.getId() +
                        "<br/>" +
                        "Name:" + manufacturer.getManufacturerName() +
                        "<br/>" +
                        "</body>" +
                        "</html>");
    }

    public Manufacturer getById(Long id){
        return this.manufacturerDAO.getById(id);
    }
}
