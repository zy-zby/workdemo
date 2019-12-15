package jxnu.chisha.web;

import com.google.gson.Gson;
import jxnu.chisha.domain.ShopcarDomain;
import jxnu.chisha.service.ShopcarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: chisha
 * @ClassName ShopcarController
 * @description: TODO
 * @author: zy
 * @create: 2019-12-11 10:12
 * @Version 1.0
 **/
@WebServlet("/cust/getshopcar")
public class ShopcarController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        ShopcarService shopcarService = new ShopcarService();
        List<ShopcarDomain> shopcarDomains = null;
        try {
            shopcarDomains = shopcarService.getshopcar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println(new Gson().toJson(shopcarDomains));
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        doGet(req,resp);
    }
}
