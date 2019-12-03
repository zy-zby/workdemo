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
@WebServlet("/food/gettype")
public class FoodController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        doGet(req,resp);
    }
}
