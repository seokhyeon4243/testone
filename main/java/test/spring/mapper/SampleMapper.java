package test.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import test.spring.component.SampleDTO;

public interface SampleMapper {
	public List<SampleDTO> sampleList();
	
	public List<String> idList();
	
	public String pwFind(String id);
	
	public int loginCheck(@Param("id") String id ,
						  @Param("pw") String pw);	// 매개변수가 1개 이상일떄는 DTO나 @Param을 사용한다
	
	public void insert(SampleDTO dto);
}
