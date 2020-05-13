package kr.co.choboard.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.choboard.beans.ContentBean;
import kr.co.choboard.beans.PageBean;
import kr.co.choboard.beans.UserBean;
import kr.co.choboard.dao.BoardDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

	@Value("${path.upload}")
	private String path_upload;
	
	@Value("${page.listcnt}")
	private int page_listcnt;
	
	@Value("${page.paginationcnt}")
	private int page_paginationcnt;
	
	@Autowired
	private BoardDao boardDao;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	private String saveUploadFile(MultipartFile upload_file) {
		String file_name = System.currentTimeMillis() + "_" + upload_file.getOriginalFilename();
		try {
			upload_file.transferTo(new File(path_upload + "/" + file_name));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return file_name;
	}
	
	public void addContentInfo(ContentBean createContentBean) {
		MultipartFile upload_file = createContentBean.getUpload_file();
		if(upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			createContentBean.setContent_file(file_name);
		}
		createContentBean.setContent_writer_idx(loginUserBean.getUser_idx());
		
		boardDao.addContentInfo(createContentBean);
	}
	
	public String getBoardName(int board_info_idx) {
		return boardDao.getBoardName(board_info_idx);
	}
	
	public List<ContentBean> getContentList(int board_info_idx, int page){
		
		int start = (page-1) * page_listcnt;
		// start부터 page_listcnt개수만큼 범위 설정
		RowBounds rowBounds = new RowBounds(start,page_listcnt); 
		
		return boardDao.getContentList(board_info_idx, rowBounds);
	}
	
	public ContentBean getContent(int content_idx) {
		return boardDao.getContent(content_idx);
	}
	
	public void updateContent(ContentBean updateContentBean) {
		
		MultipartFile upload_file = updateContentBean.getUpload_file();
		if(upload_file.getSize()>0) {
			String file_name = saveUploadFile(upload_file);
			updateContentBean.setContent_file(file_name);
		}
		
		boardDao.updateContent(updateContentBean);
	}
	
	public void deleteContent(int content_idx) {
		boardDao.deleteContent(content_idx);
	}
	
	public PageBean getContentCnt(int content_board_idx, int currentPage) {
		int content_cnt = boardDao.getContentCnt(content_board_idx);
		PageBean pageBean = new PageBean(content_cnt, currentPage, page_listcnt, page_paginationcnt);
		return pageBean;
	}
}
