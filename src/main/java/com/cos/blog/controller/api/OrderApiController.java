package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class OrderApiController {
	
	@Autowired
	OrderService orderService;
	
	// 장바구니 상품 주문
	@PostMapping("/order/orderCart/new")
	public ResponseDto<Integer> orderCart(@RequestBody JsonNode requestData, @AuthenticationPrincipal PrincipalDetail principal){
		orderService.장바구니상품주문(requestData, principal);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	// 단일상품 주문
	@PostMapping("/order/orderItem/new")
	public ResponseDto<Integer> orderItem(@RequestBody JsonNode requestData, @AuthenticationPrincipal PrincipalDetail principal){
		orderService.단일상품주문(requestData, principal);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

}