package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamControllerPost {
	
	@GetMapping("/input")
	public String input() {
		// HTMLテンプレートにwelcome-spring.htmlを指定
		return "input";
	}

	@PostMapping("/post-param")
	//greetingをgreetingという変数で受け取る
	public String postParam(@RequestParam String greeting,
			//  gをgreetingで受け取る
			//	public String getParam(@RequestParam(name="g") String greeting,
			//	public String getParam(@RequestParam(required=false) String greeting,
			//	public String getParam(@RequestParam(defaultValue="(未設定)") String greeting,
			Model model) {

		// 引数で受け取ったgreetingをmGreetingという属性名でModelに格納
		model.addAttribute("mGreeting", greeting);

		// HTMLテンプレートにdisplay.htmlを指定
		return "display";
	}
}
