package kr.co.choboard.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.choboard.beans.ContentBean;
import kr.co.choboard.mapper.BoardMapper;

@Repository
public class BoardDao {

	@Autowired
	private BoardMapper boardMapper;
	
	public void addContentInfo(ContentBean createContentBean) {
		boardMapper.addContentInfo(createContentBean);
	}

}
