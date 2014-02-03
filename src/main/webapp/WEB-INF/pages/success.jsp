<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file='header.html' %>

<meta http-equiv="content-language" content="ru">
<title>Eva Villas</title>
<meta name="keywords" content="evavillas, evaphuket, eva, villas, villa, phuket, thailand, booking, about, Ева, виллы, пхукет, таиланд, забронировать, отдых, отпуск">
<meta name="description" content="Роскошные виллы на тихом побережье моря на острове Пхукет">
<meta name="robots" content="all">
<meta name="author" content="Codekomilfo.com">
<meta property=”og:title” content=”Eva_Villas”/>
<meta property=”og:type” content=”company”/>
<meta property=”og:description” content=”Роскошные_виллы_на_тихом_побережье_моря_на_острове_Пхукет“/>
<meta property=”og:image” content=”/images/logo.png”/>
<meta property=”og:url” content=”http://evaphuket.com”/>
<meta property=”og:site_name” content=”Eva_Villas”/>

<!-- подключение выбора дат  -->
<link href="/css/smoothness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
<script src="/js/jquery-ui-1.10.3.custom.js"></script>
<script>
    $(function() {
        $( ".datepicker" ).datepicker({
            inline: true,
            dateFormat: "dd-mm-yy"
        });
    });
</script>
<!-- конец - подключение выбора дат  -->

</head>
<body>

<%@ include file ='left.html' %>


<div id="booking" class="transition-medium">
    <hr class="line-left" align="left" size="1" color="#84bcff">
    <h2>Проверка</h2>
    <hr class="line-right" align="right" size="1" color="#84bcff">

    <p id="conf">Вы успешно оплатили бронь виллы!</p>
    <form method="post">

        <div class="input-div sum-div">
            <div class="sum-name">
                Оплачено:
            </div>
            <div class="right-sum">
                 <c:out value="${price}"/>
            </div>
        </div>
    </form>
</div>




<!-- фон слайдер -->
<script src="/js/jquery.backstretch.min.js"></script>
<script type="text/javascript">
    $.backstretch([
        "/images/bgslider/1.jpg",
        "/images/bgslider/2.jpg",
        "/images/bgslider/3.jpg",
        "/images/bgslider/4.jpg"
    ], {duration: 4000, fade: 800});
</script>
<!-- конец - фон слайдер -->
</body>
</html>