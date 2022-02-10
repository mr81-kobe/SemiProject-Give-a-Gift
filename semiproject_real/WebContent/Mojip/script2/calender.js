var month = document.querySelector("#month");

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
    
    
 
    calendar.setCalendars([
    	  {
    	    id: '0',
    	    name: '전공 필수',
    	    color: '#ffffff',
    	    bgColor: '#f02025',
    	    dragBgColor: '#ff5583',
    	    borderColor: '#ff5583'
    	  },
    	  {
    	    id: '1',
    	    name: '전공 선택',
    	    color: '#ffffff',
    	    bgColor: '#6dab6a',
    	    dragBgColor: '#ffbb3b',
    	    borderColor: '#ffbb3b'
    	  },
    	  {
    	    id: '2',
    	    name: '일반 교양',
    	    color: '#ffffff',
    	    bgColor: '#118a0b',
    	    dragBgColor: '#03bd9e',
    	    borderColor: '#03bd9e'
    	  }, 
    	  {
      	    id: '3',
      	    name: '전공 필수',
      	    color: '#ffffff',
      	    bgColor: '#ff5583',
      	    dragBgColor: '#ff5583',
      	    borderColor: '#ff5583'
      	  },
      	  {
      	    id: '4',
      	    name: '전공 선택',
      	    color: '#ffffff',
      	    bgColor: '#ffbb3b',
      	    dragBgColor: '#ffbb3b',
      	    borderColor: '#ffbb3b'
      	  },
      	  {
      	    id: '5',
      	    name: '일반 교양',
      	    color: '#ffffff',
      	    bgColor: '#03bd9e',
      	    dragBgColor: '#03bd9e',
      	    borderColor: '#03bd9e'
      	  },
      	  {
        	    id: '6',
        	    name: '전공 필수',
        	    color: '#ffffff',
        	    bgColor: '#ff5583',
        	    dragBgColor: '#ff5583',
        	    borderColor: '#ff5583'
        	  },
        	  {
        	    id: '7',
        	    name: '전공 선택',
        	    color: '#ffffff',
        	    bgColor: '#b51974',
        	    dragBgColor: '#ffbb3b',
        	    borderColor: '#ffbb3b'
        	  },
        	  {
        	    id: '8',
        	    name: '일반 교양',
        	    color: '#ffffff',
        	    bgColor: '#2626de',
        	    dragBgColor: '#03bd9e',
        	    borderColor: '#03bd9e'
        	  }, {
        	    id: '9',
        	    name: '일반 교양',
        	    color: '#ffffff',
        	    bgColor: '#edea13',
        	    dragBgColor: '#03bd9e',
        	    borderColor: '#03bd9e'
        	  }
    	]);
    
    
    
    function make_Time(date_trans,time,title){
    	var date_list=date_trans.split("/");
    	var time_=time.split("~");
    	
    	var r=	Math.floor(Math.random() * 10);
    	console.log(r);
    	for(var i=0; i<date_list.length; i++){
    	
    		calendar.createSchedules([
    	 {
    	    id: 'sch',
    	    calendarId:String(r),
    	    title: title,
    	    category: 'allday',              // 일반 일정
    	    start: date_list[i],
    	    end: date_list[i]
    	  }
    	]);
    
    	}
    	
    
    }
    
    
    
  
    
    
 
    
    
    