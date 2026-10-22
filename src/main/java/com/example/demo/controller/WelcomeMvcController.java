package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeMvcController {

	@GetMapping("/welcome-m")
	//引数にModelを指定するとSpringがModelオブジェクトを渡してくれる
	public String welcomeM(Model model) {
		
		//モデルのメソッドでデータを格納
		//greetingという属性名でHelloという文字列を格納
		model.addAttribute("greeting", "Hello");
		//welcomeという属性名でWelcome MVC(Model)という文字列を格納
		model.addAttribute("welcome", "Welcome MVC (Model)");
		
		// HTMLテンプレートにwelcome-mvc.htmlを指定
		//Stringで文字列を返すとスプリングがそれを認識して処理する
		return "welcome-mvc";
	}
	

}
