/**
 * 
 */
$(document).ready(function(){
	var bno = $("#bno").val()
	//alert(bno);
	
	// {bno:bno}는 JSON 타입이다 | function(arr)는 callback
	$.getJSON("getAttachList",{bno:bno}, function(arr){
		//console.log(arr);
		var str="";
		$(arr).each(function(i, attach){		// i와 attach은 변수명이다.
			// 첨부파일이 이미지이면, get.jsp에서 id가 replyList인 div.ul 아래에 넣는다.
			if(attach.filetype){
				var fileCallPath = encodeURIComponent(attach.uploadpath + "/s_" + attach.uuid + "_" + attach.filename);
				
				str += "<li data-path='"+attach.uploadpath+"' data-uuid='"+attach.uuid+"' data-filename='"+attach.filename+"' data-type='"+attach.filetype+"'><div>";
				str += "<img src='/display?filename="+fileCallPath+"'></div></li>";
				//alert(fileCallPath);
			} else { // 첨부파일이 이미지가 아니면
				str += "<li data-path='"+attach.uploadpath+"' data-uuid='"+attach.uuid+"' data-filename='"+attach.filename+"' data-type='"+attach.filetype+"'><div>";
				str += "<span> " + attach.filename + "</span><br><img src='/resources/img/attach.png'></div></li>";
			}			
		}); // each END
		
		$(".uploadResult ul").html(str);
	});	// getJSON END
	
	
	
	
})	// document END