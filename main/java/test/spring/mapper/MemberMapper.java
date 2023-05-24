package test.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import test.spring.component.SampleDTO;

public interface MemberMapper {
	public List<SampleDTO> sampleList();
	
	@Select("select * from sample where")	// Mapper.xml 이 필요가 없어짐
	public List<SampleDTO> sampleList2();
	
	@Select("select * from sample where id=#{id} and pw=#{pw}")
	public List<SampleDTO> sampleList3(String id , String pw);
	
	@Select("select * from sample where id=#{id} and pw=#{pw}")
	public List<SampleDTO> sampleList4(SampleDTO dto);
}
