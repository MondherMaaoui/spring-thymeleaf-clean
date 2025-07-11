package com.mondher.ams.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@RequestMapping("/welcome")
	String info() {
		return "article/info";
	}

}
