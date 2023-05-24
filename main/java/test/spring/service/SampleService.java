package test.spring.service;

import java.util.List;

import test.spring.component.SampleDTO;

public interface SampleService {
	public List<SampleDTO> all();
	
	public List<String> idList();
	
	public String pwFind(String id);
	
	public int loginCheck(String id , String pw);
	
	public void insert(SampleDTO dto);
}
