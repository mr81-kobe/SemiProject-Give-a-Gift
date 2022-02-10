var Calendar = tui.Calendar;
    var calendar = new Calendar('#calendar', {
  defaultView: 'month',
  taskView: true,
  template: {
    monthDayname: function(dayname) {
      return '<span class="calendar-week-dayname-name">' + dayname.label + '</span>';
    }, 
    useCreationPopup: true,
    useDetailPopup: true

  }
}); 
    var prevBtn = document.querySelector("#prevBtn"); 
    prevBtn.addEventListener('click', () => {
    	  calendar.prev();                          // 현재 뷰 기준으로 이전 뷰로 이동
    	});
    
    
    
    var nextBtn =document.querySelector("#nextBtn"); 
    nextBtn.onclick=function () {
    	
    	  calendar.next();     
    	
    };  
  
  

    
    function make_Time(title,stdate,eddate){
    	
    	calendar.createSchedules([
    	 {
    	    id: '2',
    	    calendarId: 'Major Subject',
    	    title: title,
    	    category: 'allday',              // 일반 일정
    	    start: stdate,
    	    end: eddate
    	  }
    	]);
    } 
    
    var info = new Object(); 
    info.teacher = $('#teacher').val(); 
    info.title = $('#title').val();
    info.student = $('#student').val(); 
    info.startdate = $('#startdate').val();  
    info.enddate = $('#enddate').val();  
    info.week = $('#week').val(); 
    var jsoninfo =JSON.stringify(info);  
    
    alert( $('#startdate').val()+"!!!!!")
    
  $('#butt').click( function(){
   alert("시발!!!!!!!!")
	  $.ajax({

        type : "POST",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType : "json",

        url : "http://localhost:8081/semiproject_real/sche",

        data : {

               json : jsoninfo

        },

        success : function(data) {

               // data는 서버로부터 전송받은 결과(JSON)이므로 바로 사용한다

             if(data.over_title!=""){
            	
            	 $("#modalhead").text("Warning");
            		$("#modal_text").text(data.over_title +"과 중복되는 일정입니다.");
            	 $("#modal").show();
            	 
             }else{
            	 
            
            	
            	 $("#modalhead").text("Warning");
            		$("#modal_text").text(data.mes);
            	 $("#modal").show();
             
            	 
             }

        },

        error : function(e) {

               alert('서버 연결 도중 에러가 났습니다. 다시 시도해 주십시오.');

        }

});



    });
    
    function closeModal() {
    	$('.searchModal').hide();
    	};

    $("#update").click(function (){
    	
    	location.href="mojip?command=update_form&title="+$("#title").val();
    	
    	
    	
    }) 
$("#delete").click(function (){
    	
    	location.href="mojip?command=delete&title="+$("#title").val();
    	
    	
    	
    }) 