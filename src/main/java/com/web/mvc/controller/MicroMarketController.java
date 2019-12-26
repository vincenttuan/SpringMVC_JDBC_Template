package com.web.mvc.controller;

import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.annotation.RequestParameterMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/micro_market")
public class MicroMarketController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @RequestMapping("/")
    public String queryMicroMarket(Model model) {
        String sql = "select * from MICRO_MARKET";
        model.addAttribute("json", new Gson().toJson(jdbcTemplate.queryForList(sql)));
        model.addAttribute("page", "micro_market");
        return model.asMap().get("page").toString();
    }
    
    
}
