package com.jh.app.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jh.app.member.MemberDTO;
import com.jh.app.product.ProductDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart/*")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("list")
	public void list() throws Exception {}
	
	@GetMapping("cartlist")
	public void list(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		List<ProductDTO> ar = cartService.list(memberDTO);
		model.addAttribute("list", ar);
	}

	@PostMapping("create")
	public String create(HttpSession session, CartDTO cartDTO, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		cartDTO.setUsername(memberDTO.getUsername());

		int result = cartService.create(cartDTO);

		model.addAttribute("result", result);

		return "commons/ajaxResult";
	}

	@PostMapping("delete")
	public String delete(HttpSession session, CartDTO cartDTO, Model model) throws Exception {
		System.out.println(cartDTO.getProductNum());
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		cartDTO.setUsername(memberDTO.getUsername());
		int result = cartService.delete(cartDTO);
		model.addAttribute("result", 1);

		return "commons/ajaxResult";
	}

}