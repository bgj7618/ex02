package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTests {
	private static final Logger logger = LoggerFactory.getLogger(MemberMapperTests.class);
	
	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void testInsert() {
		MemberDTO member = new MemberDTO();
		member.setId("id");
		member.setPassword("password");
		member.setBirth("birth");
		member.setGender("gender");
		member.setEmail("email");
		member.setMobile("mobile");
	}
}
