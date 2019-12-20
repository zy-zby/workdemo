package jxnu.chisha.web;

import com.google.gson.Gson;
import jxnu.chisha.domain.FoodDomain;
import jxnu.chisha.service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: chisha
 * @ClassName FoodController
 * @description: TODO
 * @author: zy
 * @create: 2019-12-01 11:18
 * @Version 1.0
 **/
@WebServlet("/food")
public class FoodController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        String type = req.getParameter("type");
        if(("getcatagory").equals(type)){
            getcatagory(req,resp);
        }
        if(("getfood").equals(type)){
            getfood(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        doGet(req,resp);
    }

    private void getcatagory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        FoodService foodService=new FoodService();
        List<FoodDomain> foodDomainList = foodService.getType();
        ArrayList<String> list = new ArrayList<String>();
        list.add("全部");
        for(FoodDomain foodDomain:foodDomainList){
            //System.out.println(foodDomain.getFoodCategory());
            list.add(foodDomain.getFoodCategory());
        }
        modelMap.put("typelistObject", foodDomainList);
        modelMap.put("typelist", list);
        //out.println(new Gson().toJson(modelMap));
        out.println(new Gson().toJson(list));
    }
    private void getfood(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String foodtype=req.getParameter("foodtype");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        FoodService foodService=new FoodService();
        List<FoodDomain> foodDomainList = foodService.getFoodByType(foodtype);
        out.println(new Gson().toJson(foodDomainList));
    }
}
