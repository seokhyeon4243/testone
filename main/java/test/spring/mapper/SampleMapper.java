package test.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import test.spring.component.SampleDTO;

public interface SampleMapper {
	public List<SampleDTO> sampleList();
	
	public List<String> idList();
	
	public String pwFind(String id);
	
	public int loginCheck(@Param("id") String id ,
						  @Param("pw") String pw);	// �Ű������� 1�� �̻��ϋ��� DTO�� @Param�� ����Ѵ�
	
	public void insert(SampleDTO dto);
}
