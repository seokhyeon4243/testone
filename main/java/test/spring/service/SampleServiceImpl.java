package test.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.spring.component.SampleDTO;
import test.spring.mapper.SampleMapper;

@Service
public class SampleServiceImpl implements SampleService {
	
	@Autowired
	private SampleMapper mapper;
	
	@Override
	public List<SampleDTO> all(){
		return mapper.sampleList();
	}
	
	@Override
	public List<String> idList(){
		return mapper.idList();
	}
	
	@Override
	public String pwFind(String id) {
		return mapper.pwFind(id);
	}
	
	@Override
	public int loginCheck(String id , String pw) {
		return mapper.loginCheck(id,pw);
	}
	
	@Override
	public void insert(SampleDTO dto) {
		mapper.insert(dto);
	}

}
