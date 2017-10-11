package com.junran.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.junran.util.ResponseUtil;
import com.junran.vo.Food;

@Controller
@RequestMapping(value="test")
public class TestController {
	
	@RequestMapping(value="getFood", method=RequestMethod.GET)
	public String showFood(@RequestParam("foodId") Integer id, 
			 HttpServletRequest request, HttpServletResponse response) throws IOException{
		LoggerFactory.getLogger(TestController.class).info(request.getRemoteHost() + " showFood " + id);
		Food food = new Food();
		food.setId(id == null ? 0 : id);
		food.setName("红烧肉");
		food.setCount((int)(Math.random() * 10));
		String json = JSON.toJSONString(food);
		ResponseUtil.writeMessage(json, request, response);
		return null;
	}
	
}
