package kr.co.choboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import kr.co.choboard.beans.ContentBean;

public interface BoardMapper {

	@SelectKey(statement = "select content_seq.nextval from dual", keyProperty = "content_idx", before=true, resultType=int.class)
	
	@Insert("insert into content_table(content_idx, content_subject, content_text, " + 
			"content_file, content_writer_idx, content_board_idx, content_date) " + 
			"values (#{content_idx}, #{content_subject}, #{content_text}, #{content_file, jdbcType=VARCHAR}, " + 
			"#{content_writer_idx}, #{content_board_idx}, sysdate)")
	void addContentInfo(ContentBean createContentBean);
	
	@Select("select board_info_name " + 
			"from board_info_table " + 
			"where board_info_idx = #{board_info_idx}")
	String getBoardName(int board_info_idx);
	
	@Select("select C.content_idx, C.content_subject, U.user_nickname as content_writer_name, " + 
			"to_char(C.content_date, 'YYYY-MM-DD') as content_date " + 
			"from content_table C, user_table U " + 
			"where C.content_writer_idx = U.user_idx and C.content_board_idx = #{board_info_idx} " + 
			"order by C.content_idx desc")
	List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds);
	
	@Select("select U.user_nickname as content_writer_name, " +
			"	to_char(C.content_date, 'YYYY-MM-DD') as content_date, " + 
			"	C.content_subject, C.content_text, C.content_file, C.content_writer_idx " + 
			"from content_table C, user_table U " + 
			"where C.content_writer_idx = U.user_idx " + 
			"	and C.content_idx = #{content_idx}")
	ContentBean getContent(int content_idx);
	
	@Update("update content_table " + 
			"set content_subject=#{content_subject}, content_text=#{content_text}, " +
			"content_file=#{content_file,jdbcType=VARCHAR} " + 
			"where content_idx=#{content_idx}")
	void updateContent(ContentBean updateContentBean);
	
	@Delete("delete from content_table " + 
			"where content_idx=#{content_idx}")
	void deleteContent(int content_idx);
	
	@Select("select count(*) " + 
			"from content_table " + 
			"where content_board_idx=${content_board_idx}")
	int getContentCnt(int content_board_idx);
}
