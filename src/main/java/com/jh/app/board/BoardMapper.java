package com.jh.app.board;

import java.util.List;

public interface BoardMapper {
	
	//CRUD
	
	//R - read
	//list
	public List<BoardDTO> list()throws Exception;
	
	//detail
	public BoardDTO detail(BoardDTO boardDTO)throws Exception;
	
	
	
}
