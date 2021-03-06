package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

@RestController
@RequestMapping("sample")
public class Samplecontroller {
	private static final Logger logger = LoggerFactory.getLogger(Samplecontroller.class);
	// "안녕하세요"와 같은 단순문자열은 produces="text/plain; charset=UTF-8" 처리
	@GetMapping(value="/getText", produces="text/plain; charset=utf-8")
	public String getText() {
		logger.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);		
		return "안녕하세요";
	}
	// JSON, XML과 같은 데이터는 produces=MediaType.APPLICATION_JSON_UTF8_VALUE,
	// produces=MediaType.APPLICATION_XML_VALUE 처리
	@GetMapping(value="/getSample", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	@GetMapping(value="/getList")
	public List<SampleVO> getList(){
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i+"First", i+"Last")).collect(Collectors.toList());
		
	}
	@GetMapping(value="/check", params= {"height","weight"})
	public ResponseEntity<SampleVO> check(double height, double weight){
		SampleVO vo = new SampleVO(0, "" + height, "" + weight);
		ResponseEntity<SampleVO> result=null;
		if(height<150) {
			result=ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);		
		} else {
			result=ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	@GetMapping("product/{cat}/{pid}")
	public String[] getPath(
			@PathVariable("cat") String cat,
			@PathVariable("pid") int pid) {
		// String[] kin = new String [] {"category : " + cat, "Productid : " + pid};
		// return kind; 위 두분장을 아래 한문장으로 표현할 수 있음
		return new String[] {"category : " + cat, "productid : " + pid};
	}
	@PostMapping("ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		logger.info("covert.......ticket" + ticket);
		return ticket;
	}
	
	
}
