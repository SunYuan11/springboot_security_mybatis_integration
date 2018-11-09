package com.sb_ss_myb.frame.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sb_ss_myb.frame.service.MenuService;

@Controller
public class HomeController {
	
	@Autowired
	MenuService menuService;

	@RequestMapping(value = {"/index","/"})
	public String index(HttpServletRequest request) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails user = (UserDetails)authentication.getPrincipal();
		
		JSONArray menu = menuService.queryUserMenuByUsername(user.getUsername());
		request.getSession().setAttribute("menu", menu);
		return "index";
	}

	@RequestMapping("/login")
    public  String login(){
		
        return "login";
    }
	
	@RequestMapping("/viewmsg")
	public String viewmsg(Model model) {
		
		model.addAttribute("msg", "Hello");
		return "index";
	}
	
	@RequestMapping("/delmsg")
	public String delmsg(Model model) {
		
		model.addAttribute("msg", "Delete message successfully!");
		return "index";
	}
	
	@RequestMapping("/403")
	public String v403(Model model) {
		
		return "403";
	}
}
