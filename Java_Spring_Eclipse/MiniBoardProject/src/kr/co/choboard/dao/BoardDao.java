package kr.co.choboard.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
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

	public String getBoardName(int board_info_idx) {
		return boardMapper.getBoardName(board_info_idx);
	}
	
	public List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds){
		return boardMapper.getContentList(board_info_idx,rowBounds);
	}
	
	public ContentBean getContent(int content_idx) {
		return boardMapper.getContent(content_idx);
	}
	
	public void updateContent(ContentBean updateContentBean) {
		boardMapper.updateContent(updateContentBean);
	}
	
	public void deleteContent(int content_idx) {
		boardMapper.deleteContent(content_idx);
	}
	
	public int getContentCnt(int content_board_idx) {
		return boardMapper.getContentCnt(content_board_idx);
	}
}
