package com.jh.app.cart;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jh.app.member.MemberDTO;
import com.jh.app.product.ProductDTO;

@Mapper
public interface CartMapper {
	
	public int delete(List<CartDTO> ar)throws Exception;
	
	public int create(CartDTO cartDTO) throws Exception;
	
	public List<ProductDTO> list (MemberDTO memberDTO)throws Exception;

}
