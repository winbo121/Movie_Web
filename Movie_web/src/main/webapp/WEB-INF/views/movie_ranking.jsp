<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script type="text/javascript">

	var i=0;
	var arr = new Array();
	var day1=new Date();
	var real1="";
	var realArray=new Array(); 
	
	if(Number(day1.getMonth()+1)<10 &&  Number(day1.getDate()-1)<10){
	
	var day2=day1.getFullYear()+"0"+(day1.getMonth()+1)+"0"+(day1.getDate()-1);
	}
	else if(Number(day1.getMonth()+1)>9 &&  Number(day1.getDate()-1)<10){
		
		var day2=day1.getFullYear()+""+(day1.getMonth()+1)+"0"+(day1.getDate()-1);
	}
	else if(Number(day1.getMonth()+1)<10 &&  Number(day1.getDate()-1)>9){
		
		var day2=day1.getFullYear()+"0"+(day1.getMonth()+1)+""+(day1.getDate()-1);
	}
	else{
		var day2=day1.getFullYear()+""+(day1.getMonth()+1)+""+(day1.getDate()-1);
	}
	
	$.ajax({
		type:"get",
		url:"https://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=03327beb2f3ba87dc62d9427fc7f89f0&targetDt="+day2,
		dataType : "xml",
		data:{
		
		},		
		success:function(xml){
						
			$(xml).find("dailyBoxOffice").each(function() {
				// 각 개별 요소에 속해 있는 텍스트 데이터 추출
				
				var title = $(this).find("movieNm").text();
				var time = $(this).find("openDt").text();
				var people= $(this).find("audiAcc").text();							
				var div = $("<div>").attr("id", "movie");
							
		$.ajax({					
					type:"get",
					url:"https://api.themoviedb.org/3/search/movie?api_key=9ad6e90979035c5eda25f7a40305c3dd&language=ko-KR&query="+title+"&page=1",
					dataType:"json",
					data:JSON.stringify({
						
						
					}),
					success:function(result){
						
						$(result).each(function () {
							$(this.results).each(function () {
								var datePath1 = (JSON.stringify(this.release_date).replace(/"/g, ""));
								var realYear1="";
								for(var i=0; i<datePath1.length; i++){
									if(datePath1[i]=="-"){
										
									}
									else{
									realYear1=realYear1+datePath1[i] 
									}
								}
								
								realArray.push(Number(realYear1));
								
								
								
							})
							
						})
						realArray.sort();
						
						
						
						
						
						
						$(result).each(function () {
						
						
						$(this.results).each(function () {
						
							var date1= new Date();
							var realYear="";
							var datePath = (JSON.stringify(this.release_date).replace(/"/g, ""));
							
							for(var i=0; i<datePath.length; i++){
								if(datePath[i]=="-"){
									
								}
								else{
								realYear=realYear+datePath[i] 
								}
							}
							if(Number(realArray[(realArray.length-1)])==Number(realYear)){	
							realArray=new Array(); 
							var img = (JSON.stringify(this.poster_path)).replace(/"/g, "");
							var title = JSON.stringify(this.title).replace(/"/g, "");
							var original_title = JSON.stringify(this.original_title).replace(/"/g, "");
							var content = JSON.stringify(this.overview).replace(/"/g, "");
							
							var id = JSON.stringify(this.id);
							
							
							
							
							
						$.ajax({
								
								type:"get",
								url:"https://api.themoviedb.org/3/movie/"+id+"/videos?api_key=9ad6e90979035c5eda25f7a40305c3dd",
								dataType:"json",
								data:JSON.stringify({
									
									
								}),
								success:function(result){
								
														
									$(result).each(function () {
									
									
									$(this.results[0]).each(function () {
									
										
										
										var key = (JSON.stringify(this.key)).replace(/"/g, "");
										var trailer = $("<div>").html("<iframe src='https://www.youtube.com/embed/"+key+"'></iframe>").addClass("movie__Trailer");
										div.append(trailer);
										
										});
									
									});
								}
							
							})
							
							
							
							var movie = $("<div>").attr("class", "movie__Column").html("<img src='https://image.tmdb.org/t/p/w500"+img+"'alt="+title+" title="
								     +title+" class='movie__Poster'>");
						var movie1 = $("<div>").html("<h1>"+title+"</h1>"+"<div class='movie__Time'>"+time+"</div>"+"<div class='movie__Entitle'>"+
								original_title+"</div>"+"<div class='movie__Entitle'>"+
								"누적관객수:"+people+"</div>"+"<div class='movie__Synopsis'>"+content+"</div>").addClass("movie__Column");
							
							div.append(movie).append(movie1);
								
							}
							
							
							});
						
						});
					}
					
				})
				
		$(".App").append(div);
			});
		}
			
	});
	
</script>

<div class="App"></div>
