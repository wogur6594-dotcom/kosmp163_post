package com.jh.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jh.app.pager.Pager;
import com.jh.app.review.ReviewDTO;
import com.jh.app.review.ReviewService;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ReviewService reviewService;

	@Value("${app.product}")
	private String name;

	@ModelAttribute("name")
	public String getName() {
		return this.name;
	}

	@GetMapping("list")
	public void list(Pager pager, Model model) throws Exception {
		List<ProductDTO> list = productService.list(pager);
		model.addAttribute("list", list);
	}

	@GetMapping("detail")
	public String detail(ProductDTO productDTO, ReviewDTO reviewDTO, Model model) throws Exception {

		ProductDTO dto = productService.detail(productDTO);

		reviewDTO.setProductNum(productDTO.getProductNum());

		List<ReviewDTO> list = reviewService.list(reviewDTO);

		model.addAttribute("dto", dto);
		model.addAttribute("list", list);

		return "product/detail";
	}

	@GetMapping("create")
	public void create() throws Exception {
	}

	@PostMapping("create")
	public String create(ProductDTO productDTO, @RequestParam("attach") MultipartFile attach) throws Exception {
		int result = productService.create(productDTO, attach);

		return "redirect:./list";
	}

}