package com.jh.app.board.notice;

import org.apache.ibatis.annotations.Mapper;

import com.jh.app.board.BoardMapper;

//실제로 사용하기 떄문에 어노테이션 Mapper
@Mapper
public interface NoticeMapper extends BoardMapper{

}
