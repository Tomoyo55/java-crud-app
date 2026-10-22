package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.ReviewRegistForm;

@Controller
public class ReviewController {
	
	@GetMapping("/show-review-form")
	public String showReviewForm() {
		// HTMLテンプレートにshow-review-form.htmlを指定
		return "regist-review";
	}

	//入力画面のPostRequestをつけとることを示している
	@PostMapping("/regist-review")
	//formの引数で受け取り、ReviewRegistFormという名前で自動的にモデルに格納する
	public String registReview(@ModelAttribute ReviewRegistForm form) {
		//中身を確認、自動的にtoStringになる。@DataでtoStringがされる
		System.out.println(form);

		// HTMLテンプレートにregist-review.htmlを指定
		return "confirm-regist-review";
	}
}
