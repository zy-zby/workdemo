package jxnu.chisha.web.shopcarcontroller;

import com.google.gson.Gson;
import jxnu.chisha.domain.CustomerDomain;
import jxnu.chisha.domain.FoodDomain;
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
 * @ClassName ShopCarController
 * @description: TODO
 * @author: zy
 * @create: 2019-12-17 08:12
 * @Version 1.0
 **/
@WebServlet("/cust/foodcar")
public class ShopCarController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        String type = req.getParameter("type");
        if (("add").equals(type)){
            addshopcar(req,resp);
        }
        if (("getall").equals(type)){
            getshopcar(req,resp);
        }
        if (("remove").equals(type)){
            removeshopcar(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        doGet(req,resp);
    }
    private void getshopcar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
    private void addshopcar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int qty = Integer.parseInt(req.getParameter("qty"));
        int foodId = Integer.parseInt(req.getParameter("foodId"));
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        ShopcarService shopcarService = new ShopcarService();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        ShopcarDomain s = new ShopcarDomain();
        CustomerDomain c = new CustomerDomain();
        FoodDomain f = new FoodDomain();
        f.setFoodId(foodId);
        c.setCustId(1);
        s.setFoodByFoodId(f);
        s.setCustomerByCustId(c);
        try {
            modelMap.put("return", shopcarService.addFood(s, qty));
            modelMap.put("qty",shopcarService.getQty(1,foodId));
            out.println(new Gson().toJson(modelMap));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void removeshopcar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int foodId = Integer.parseInt(req.getParameter("foodId"));
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        ShopcarService shopcarService = new ShopcarService();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            modelMap.put("return",shopcarService.removeFood(1,foodId));
            out.println(new Gson().toJson(modelMap));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
