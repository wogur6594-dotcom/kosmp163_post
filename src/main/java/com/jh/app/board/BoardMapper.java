package com.jh.app.board;

import java.util.List;

public interface BoardMapper {
	
	//CRUD
	
	//R - read
	//list
	public List<BoardDTO> list()throws Exception;
	
	//detail
	public BoardDTO detail(BoardDTO boardDTO)throws Exception;
	
	//create
	public int create(BoardDTO boardDTO)throws Exception;
	
	//update
	public int update(BoardDTO boardDTO)throws Exception;
	
	//delete
	public int delete(BoardDTO boardDTO)throws Exception;
	
}
