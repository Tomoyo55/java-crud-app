package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.ReviewRegistForm;

@Controller
public class ReviewController {
	
	@GetMapping("/show-review-form")
	public String showReviewForm(@ModelAttribute ReviewRegistForm form) {
		// HTMLテンプレートにshow-review-form.htmlを指定
		return "regist-review";
	}
	
	@PostMapping("/show-review-form-ret")
	public String showReviewFormRet(@ModelAttribute ReviewRegistForm form) {
		// HTMLテンプレートにshow-review-form.htmlを指定
		return "regist-review";
	}

	//入力画面のPostRequestをつけとることを示している
	@PostMapping("/regist-review")
	//formの引数で受け取り、ReviewRegistFormという名前で自動的にモデルに格納する
	//@ValidatedがあることでValidationをしてその結果も含めてモデルに格納する
	public String registReview(@Validated @ModelAttribute ReviewRegistForm form, BindingResult result) {
		//中身を確認、自動的にtoStringになる。@DataでtoStringがされる
		System.out.println(form);

		//入力エラーがある場合にはレビュー登録画面に戻る
		if(result.hasErrors()) {
			// HTMLテンプレートにshow-review-form.htmlを指定
			return "regist-review";
		}
		// HTMLテンプレートにcomfirm-regist-review.htmlを指定
		return "confirm-regist-review";
	}
	
	//登録確認画面より
	@PostMapping("/confirm-regist-review")
	//formの引数で受け取り、ReviewRegistFormという名前で自動的にモデルに格納する
	public String confirmRegistReview(@Validated ReviewRegistForm form, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			// HTMLテンプレートにshow-review-form.htmlを指定
			return "regist-review";
		}
		
		//
		// *** ここで from 内容で DB登録処理を行う ***
		//
		model.addAttribute("msg", "レビュー登録が完了しました。");

		// HTMLテンプレートにcomplete-regist-review.htmlを指定
		return "complete-regist-review";
	}
}
