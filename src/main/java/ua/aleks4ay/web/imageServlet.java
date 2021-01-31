package ua.aleks4ay.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@WebServlet("/img2")
public class imageServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("image/jpg");

//        String pathFile = "/img/logo1.1.jpg";
        String pathFile = "J:\\1_Project\\JavaTohaProject\\src\\main\\webapp\\res\\fakeimage.jpg";
        byte[] rb = new byte[3000];
        int read = 0;
        try {
            InputStream readImg = new FileInputStream(pathFile);
            OutputStream os = response.getOutputStream();
            while ((read = readImg.read(rb)) != -1) {
                os.write(rb,0,read);
            }
            os.flush();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
