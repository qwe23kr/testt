<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
원본언어 : 
<select id="source" >
   <option value="ko">한국어</option>
   <option value="en">영어</option>
   <option value="ja">일본어</option>
   <option value="zh-CN">중국어 간체</option>
   <option value="zh-TW">중국어 번체</option>
   <option value="vi">베트남어</option>
   <option value="id">인도네시아어</option>
   <option value="th">태국어</option>
   <option value="de">독일어</option>
   <option value="ru">러시아어</option>
   <option value="es">스페인어</option>
   <option value="it">이탈리아어</option>
   <option value="fr">프랑스어</option>
</select>
번역할단어 : <input type="text" id="text">
번역언어 : 
<select id="target" >
   <option value="ko">한국어</option>
   <option value="en">영어</option>
   <option value="ja">일본어</option>
   <option value="zh-CN">중국어 간체</option>
   <option value="zh-TW">중국어 번체</option>
   <option value="vi">베트남어</option>
   <option value="id">인도네시아어</option>
   <option value="th">태국어</option>
   <option value="de">독일어</option>
   <option value="ru">러시아어</option>
   <option value="es">스페인어</option>
   <option value="it">이탈리아어</option>
   <option value="fr">프랑스어</option>
</select>
번역된단어 : <input type="text" id="translateText">
<button onclick="doTranslate()">번역</button>
<script>
function doTranslate(){
	var source = document.querySelector('#source').value;
	var target = document.querySelector('#target').value;
	var text = document.querySelector('#text').value;
	var url='/papago?source=' +source+'&target='+target+'&text='+text;
	var xhr =new XMLHttpRequest();
	xhr.open('GET',url);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==xhr.DONE){
			if(xhr.status==200){
				document.querySelector('#translateText').value=xhr.responseText;
			}
		}
	}
	xhr.send();
}
</script>
</body>
</html>