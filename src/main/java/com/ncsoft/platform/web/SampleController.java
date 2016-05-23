package com.ncsoft.platform.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncsoft.platform.domain.ProductVO;

@Controller
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doA")
	public void doA() {
		
		logger.info("doA called");		
	}
	
	@RequestMapping("doB")
	public void doB() {
		
		logger.info("doB called");		
	}
	
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg) {
		
		logger.info("doC called");
		
		return "result";
	}
	
	@RequestMapping("doD")
	public String doD(Model model) {
		
		ProductVO product = new ProductVO("sample product", 10000);
		
		logger.info("doD called");
		
		model.addAttribute(product);
		
		return "productDetail";
	}
	
	@RequestMapping("doE")
	public String doE(RedirectAttributes attrs) {
		
		logger.info("doE called");
		
		attrs.addFlashAttribute("msg", "this is message with redirected");
		
		return "redirect:/doF";
	}
	
	@RequestMapping("doF")
	public void doF(String msg) {
		
		logger.info("doF called .... " + msg);
	}
	
	@RequestMapping("/doJson")
	public @ResponseBody ProductVO doJson() {
		
		ProductVO product = new ProductVO("sample", 100);
		
		return product;
	}
}
