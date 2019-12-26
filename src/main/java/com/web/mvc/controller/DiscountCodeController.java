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
@RequestMapping("/discount_code")
public class DiscountCodeController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String queryDiscountCode(Model model) {
        String sql = "SELECT * FROM Discount_Code";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        model.addAttribute("list", list);
        model.addAttribute("page", "discount_code");
        model.addAttribute("_method", "POST");
        return model.asMap().get("page").toString();
    }
    
    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public String getDiscountCode(@PathVariable("code") String code, Model model) {
        String sql = "SELECT * FROM Discount_Code";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        Map<String, Object> map = list.stream().filter(m -> m.get("DISCOUNT_CODE").equals(code)).findFirst().get();
        model.addAttribute("list", list);
        model.addAttribute("map", map);
        model.addAttribute("page", "discount_code");
        model.addAttribute("_method", "PUT");
        return model.asMap().get("page").toString();
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postDiscountCode(@RequestParam Map map) {
        String sql = "INSERT INTO Discount_Code(DISCOUNT_CODE, RATE) VALUES(?, ?)";
        jdbcTemplate.update(sql, map.get("discount_code"), map.get("rate"));
        return "redirect: ./";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String putDiscountCode(@RequestParam Map map) {
        String sql = "UPDATE Discount_Code SET RATE = ? WHERE DISCOUNT_CODE = ?";
        jdbcTemplate.update(sql, map.get("rate"), map.get("discount_code"));
        return "redirect: ./";
    }
    
    @RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
    public String deleteDiscountCode(@PathVariable("code") String code) {
        String sql = "DELETE FROM Discount_Code WHERE DISCOUNT_CODE = ?";
        jdbcTemplate.update(sql, code);
        return "redirect: ./";
    }
    
    
}
