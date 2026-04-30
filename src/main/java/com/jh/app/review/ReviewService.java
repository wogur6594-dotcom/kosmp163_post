package com.jh.app.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ReviewService {

	@Autowired
	private ReviewMapper reviewMapper;

	public List<ReviewDTO> list(ReviewDTO reviewDTO) throws Exception {

		return reviewMapper.list(reviewDTO);
	}

	public int create(ReviewDTO reviewDTO) throws Exception {
		return reviewMapper.create(reviewDTO);
	}

	public int update(ReviewDTO reviewDTO) throws Exception {
		return reviewMapper.update(reviewDTO);
	}

	public int delete(ReviewDTO reviewDTO) throws Exception {
		return reviewMapper.delete(reviewDTO);
	}

}
