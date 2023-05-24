package test.spring.repository;

import test.spring.component.SampleDTO;

public interface MemberDAO {
	public boolean loginCheck(String id , String pw);
	public void memberInput(SampleDTO dto);
}
