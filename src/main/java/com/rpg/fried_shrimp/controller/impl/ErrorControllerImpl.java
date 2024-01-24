package com.rpg.fried_shrimp.controller.impl;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorControllerImpl implements ErrorController {

	@RequestMapping("/error")
	public String handleError() {
		// カスタムエラーページのビュー名を返す
		return "error";
	}

	public String getErrorPath() {
		// エラーパスを返す
		return "/error";
	}
}
