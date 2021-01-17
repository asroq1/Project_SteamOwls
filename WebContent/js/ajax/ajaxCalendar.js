
	var isChecked = false;

	function initCheckDate() {
		isChecked = false;
	} //ajax 프론트엔드 백엔드로 넘기면 백엔드 화면으로 안넘어가고 계속실행

	function checkDate() { //아이디중복체크
		initCheckDate();
        var date = $('#date');
        var time = $('#time');
        var people = $('#people');
		$.ajax({
            //주소넣기 
			url : "/주소넣기 ",
			type : "post",
			dataType : "json",
			data : {
                date : date.val(),
                time : time.val(),
                people : people.val()
			//보낼 데이터
			},
			error : function() {
				alert("통신실패");
			},
			success : function(data, time, people) {
				//alert(data.msg);//common.jsp에서 넘겨준것은 사용안함
                if (data.isTrue == 'true' &&
                    time.isTrue == 'true' &&
                    people.isTrue == 'ture'
                 ) {
                //      해당되는 섹션의 스타일에 적용.
                    // filter: opacity(0.5);
                    // pointer-events: none;
					isChecked = false; //사용할수 없는것이니 false
				} else {
					isChecked = true;
				}
			}
		});
	}
