package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.cos.blog.model.Item;
import com.cos.blog.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	// 상품 페이지
	@GetMapping("/item")
	public String itemForm(Model model,
			@PageableDefault(size = 8, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("items", itemService.글목록(pageable));
		return "item/itemForm";
	}
	
	// 상품 등록 페이지
	@GetMapping("/seller/new")
	public String itemSaveForm(Item item) {
		return "seller/itemSaveForm";
	}

	// 상품 수정 페이지
	@GetMapping("/seller/update/{id}")
	public String itemUpdateForm(@PathVariable int id, Model model) {
		model.addAttribute("item", itemService.상품불러오기(id));
		return "seller/itemUpdateForm";
	}
	
	// 상품 상세 페이지
	@GetMapping("/item/{id}")
	public String itemViewForm(Model model, @PathVariable("id") int id) {
		model.addAttribute("item", itemService.상품불러오기(id));
		return "item/detail";
	}
}
