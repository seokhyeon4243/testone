package test.spring.repository;

import org.springframework.stereotype.Repository;

import test.spring.component.SampleDTO;

@Repository("kakao")
public class KakaoMemberDAOImpl implements MemberDAO {

	@Override
	public boolean loginCheck(String id , String pw) {
		return false;
	}
	
	@Override
	public void memberInput(SampleDTO dto) {
		
	}
}
