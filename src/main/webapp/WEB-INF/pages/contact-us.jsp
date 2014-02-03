<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file='header.html' %>

<meta http-equiv="content-language" content="ru">
		<title>Контакты | Eva Villas</title>		
		<meta name="keywords" content="evavillas, evaphuket, eva, villas, villa, phuket, thailand, booking, about, Ева, виллы, пхукет, таиланд, забронировать, отдых, отпуск, контакты, позвонить, связаться">
		<meta name="description" content="Контакты Eva Villas">
		<meta name="robots" content="all">
		<meta name="author" content="Codekomilfo.com">
		<meta property=”og:title” content=”Eva_Villas”/>
		<meta property=”og:type” content=”company”/>
		<meta property=”og:description” content=”Контакты_Eva_Villas“/>
		<meta property=”og:image” content=”/images/logo.png”/>
		<meta property=”og:url” content=”http://evaphuket.com”/>
		<meta property=”og:site_name” content=”Eva_Villas”/>
	</head>
	<body>
	
	<%@ include file='left.html'%>


	<div id="about">
			<hr class="line-left-about" align="left" size="1" color="#84bcff">
			<h1>Контакты</h1>
			<hr class="line-right-about" align="right" size="1" color="#84bcff">
			
			<div id="about-text">
				<br><br><br>
				<div class="contact">
				<img src="/images/home.png">
				<p>Пхукет, Раваи, Eva Beach</p>
				</div>
				
				<div class="contact">
				<img src="/images/envelope.png">
				<p>info@evaphuket.com</p>
				</div>

				<div class="contact">
				<img src="/images/phone.png">
				<p>+66 90 123 4567</p>
				</div>

				<div class="contact">
				<img src="/images/skype.png">
				<p>artem-kolomoets</p>
				</div>

			</div>
	</div>
		
	
		<!-- фон слайдер -->
		<script src="/js/jquery.backstretch.min.js"></script>
		<script type="text/javascript">
			  $.backstretch([
			    "/images/bgslider/4.jpg",
			    "/images/bgslider/3.jpg",
			    "/images/bgslider/2.jpg",
			    "/images/bgslider/1.jpg",
			  ], {duration: 4000, fade: 800});
		</script>
		<!-- конец - фон слайдер -->
	</body>
</html>