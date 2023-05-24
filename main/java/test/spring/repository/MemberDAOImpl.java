package test.spring.repository;

import org.springframework.stereotype.Repository;

import test.spring.component.SampleDTO;

@Repository("member")
public class MemberDAOImpl implements MemberDAO {
	
	@Override
	public boolean loginCheck(String id , String pw) {
		return false;
	}
	
	@Override
	public void memberInput(SampleDTO dto) {
		
	}
}
