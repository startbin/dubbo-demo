package com.dongao.data.demo.web.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
public class IndexController extends BaseController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/welcome")
	public String welcome(Model model, HttpSession session) {
		JSONArray array = new JSONArray();
		Enumeration<String> attributeNames = session.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String key = (String) attributeNames.nextElement();
			Object value = session.getAttribute(key);
			JSONObject json = new JSONObject();
			json.put(key, value);
			array.add(json);
		}
		model.addAttribute("sessionAttribute", array.toString());
		return "welcome";
	}

}
