package ua.danit.servlet;

import ua.danit.servlet.dao.UsersDAO;
import ua.danit.servlet.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/users")
public class HelloWorldServlet extends HttpServlet {

    private static Boolean choice;
    private UsersDAO usersDAO = new UsersDAO();
    private int currentUserIndex = 0;

    public void setUsersDAO(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }
//    @Override //init - ne ponyal READ!
//    public void init() throws ServletException {
//
//
//    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        User user = usersDAO.getUserByIndex(currentUserIndex);
        writer.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>PRACTICE</title>\n" +
                "    <style>\n" +
                "        h1 {\n" +
                "            color: red;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>" + user.getName() + "</h1> <img width=\"300\" src= '"+ user.getPhoto()+"'>\n" +
                "<br><br>\n" +
                "<form method='POST' action='/users'>\n" +
                "    <!--<input name='message' type='text'>-->\n" +
                "    <button name=\"choice\"value=\"yes\">Yes</button>\n" +
                "    <button name=\"choice\"value=\"no\">No</button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");

                currentUserIndex++;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userChoice = req.getParameter("choice");  //wrote it to save smth on the server side, but i'm not sure...

        if("yes".equals(userChoice)){
            choice = true;
        } else {
            choice = false;
        }
         doGet(req,resp); //vizivaem html-ku (дугетовскую)
//        resp.sendRedirect("/users"); //mi emu govorim -"Pizdui na /users".

    }
}
