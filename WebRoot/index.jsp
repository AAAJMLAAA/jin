<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <style>
.vid-wrapper{
    width:100%;
    position:relative;
    padding-bottom:56.25%;    /*需要用padding来维持16:9比例,也就是9除以16*/
    height: 0;
}
.vid-wrapper video{
    position: absolute;
    top:0;
    left: 0;
    width: 100%;
    height: 100%
}
</style>
  
  <body>
   <form action="text">
     <input type="submit">
   </form>
 <!--   <a href="http://127.0.0.1:8080/text/1.txt">点击</a>
   <br> -->
  <!--   <a href="http://127.0.0.1:8080/text/2.txt">txt</a>
    <br>
    <a href="http://127.0.0.1:8080/text/1.docx">docx</a>
             这种不行
    <br>
    <a href="http://127.0.0.1:8080/text/1.pdf">pdf</a>
    <br>
    <a href="http://127.0.0.1:8080/text/1.png">png</a>
      <br> -->
      <div style="width:900px;height:600px;background-image: url('http://127.0.0.1:8080/text/5.jpg');">
      <video controls="controls" style="width:900px;height:600px;">
         <source src="http://127.0.0.1:8080/text/1.mp4" type="video/mp4" style="width:900px;height:500px"></source>
      </video>
      </div>
  </body>
</html>
