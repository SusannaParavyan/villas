<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file='header.html' %>

<meta http-equiv="content-language" content="ru">
<title>Eva Villas</title>
<meta name="keywords"
      content="evavillas, evaphuket, eva, villas, villa, phuket, thailand, booking, about, Ева, виллы, пхукет, таиланд, забронировать, отдых, отпуск">
<meta name="description" content="Роскошные виллы на тихом побережье моря на острове Пхукет">
<meta name="robots" content="all">
<meta name="author" content="Codekomilfo.com">
<meta property=”og:title” content=”Eva_Villas”/>
<meta property=”og:type” content=”company”/>
<meta property=”og:description” content=”Роскошные_виллы_на_тихом_побережье_моря_на_острове_Пхукет“/>
<meta property=”og:image” content=”/images/logo.png”/>
<meta property=”og:url” content=”http://evaphuket.com”/>
<meta property=”og:site_name” content=”Eva_Villas”/>

<!-- подключение выбора дат -->
<link href="/css/smoothness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
<script src="/js/jquery-ui-1.10.3.custom.js"></script>

<style type="text/css">
    .dp-highlight .ui-state-default {
        background: #484;
        color: #FFF;
    }
</style>

<script>
    $(function () {
        var date1 = new Date;
        date1.setHours(0, 0, 0, 0);
        date1.setDate(10);
        var date2 = new Date;
        date2.setHours(0, 0, 0, 0);
        date2.setDate(23);
        $(".datepicker").datepicker({
            inline: true,
            dateFormat: "dd-mm-yy",

            beforeShowDay: function (date) {
                return [date.getDay() < 5, date >= date1 && date <= date2 ? "dp-highlight" : ""];
            }
        });
    });
</script>
<!-- конец - подключение выбора дат -->


</head>
<body>
<%@ include file='left.html' %>


<div id="booking" class="transition-medium">
    <hr class="line-left" align="left" size="1" color="#84bcff">
    <h2>Бронирование</h2>
    <hr class="line-right" align="right" size="1" color="#84bcff">
    <form action="/pay" method="get">
        <div class="input-div">
            <div class="left-input-div">
                <label>Выбор даты</label>
            </div>
            <div class="right-input-div">
                <input name="start-date" id="start-date" class="main-input datepicker" type="text"
                       onchange="countFromValues()" s><br>
            </div>
            <div class="right-input-div">
                <input name="finish-date" id="finish-date" class="main-input dates datepicker" type="text"
                       onchange="countFromValues()" s><br>
            </div>
        </div>

        <div id="input-guests" class="input-div">
            <div class="left-input-div">
                <%--@declare id="name"--%><label for="name">ФИО</label>

            </div>
            <div class="right-input-div">
                <input name="name" class="main-input" type="text">
            </div>
        </div>
        <div class="input-div">
            <div class="left-input-div">
                <%--@declare id="e-mail"--%><label for="e-mail">Эл.почта</label>
            </div>
            <div class="right-input-div">
                <input name="e-mail" class="main-input" type="text">
            </div>
        </div>


        <div class="input-div">
            <div class="left-input-div">
                <%--@declare id="guest-count"--%><label for="guest-count">Кол-во гостей</label>
            </div>
            <div class="right-select-div">
                <select name="guest-count" class="main-select">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>6</option>
                    <option>7</option>
                    <option>8</option>
                    <option>9</option>
                    <option>10</option>
                    <option>11</option>
                    <option>12</option>
                    <option>13</option>
                    <option>14</option>
                    <option>15</option>
                    <option>16</option>
                    <option>17</option>
                    <option>18</option>
                    <option>19</option>
                    <option>20</option>
                    <option>> 20</option>
                </select><br>
            </div>
        </div>

        <div class="input-div" id="input-children">
            <div class="left-input-div">
                <%--@declare id="children-count"--%><label for="children-count">Дети</label>
            </div>
            <div class="right-select-div">
                <select name="children-count" class="main-select">
                    <option>нет</option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>> 5</option>
                </select><br>
            </div>
        </div>

        <div class="input-div">
            <div class="left-input-div">
                <%--@declare id="promo-code"--%><label for="promo-code">Промо-код</label>
            </div>
            <div class="right-input-div">
                <input name="promo-code" class="main-input" type="text">
            </div>
        </div>

        <div class="input-div sum-div">
            <div class="sum-name">
                Стоимость:
            </div>
            <div>
                <input type="text" readonly="readonly" class="right-sum" name="full-price" id="full-price" value="0">
            </div>
        </div>

        <div class="input-div sum-div">
            <div class="sum-name">
                Предоплата:
            </div>
            <div>
                <input type="text" readonly="readonly" name="price" id="price" class="right-sum" value="0">
            </div>
        </div>

        <div class="input-div">
            <%--@declare id="date-out"--%><label id="label-center" for="date-out">Способ оплаты:</label>

            <div class="radio-button">
                <input type="radio" name="mode" id="card" value="card"><label for="card" class="radio"><img
                    src="images/pay.png"></label>
            </div>
            <div class="radio-button">
                <input type="radio" name="mode" id="payment" value="payment"><label for="payment" class="radio">Банковский
                перевод</label>
            </div>

        </div>

        <input type="submit" id="main-button" value="Забронировать">

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

<script type="text/javascript">

    //Функция преобразования строки в дату
    function stringToDate(str) {
        if (typeof (str) == Date) return str;
        else {
            var date = new Date(str.replace(/(\d+).(\d+).(\d+)/, '$3/$2/$1'));
            return date;
        }
    }

    //функция определения какой период
    function getPeriodName(date) {
        var month = date.getMonth()
        var period;
        switch (month) {
            case 0:
            case 11:
                period = 'high';
                break;
            case 1:
            case 2:
            case 10:
                period = 'spring';
                break;
            case 3:
            case 6:
            case 7:
            case 8:
            case 9:
                period = 'green';
                break;
            case 4:
            case 5:
                period = 'low';
                break;
        }
        return period;
    }

    //Функция определения количество дней между датами
    function getDaysAmount(startDate, finishDate) {
        var days = Math.floor((finishDate - startDate) / (1000 * 60 * 60 * 24));
        return days;
    }

    function getPriceForDay(period) {
        var price;
        switch (period) {
            case 'low':
                price = 17970;
                break;
            case 'green':
                price = 21240;
                break;
            case 'spring':
                price = 24510;
                break;
            case 'high':
                price = 32670;
                break;
        }
        return price;
    }
    function getPriceForWeek(period) {
        var price;
        switch (period) {
            case 'low':
                price = 107820;
                break;
            case 'green':
                price = 127440;
                break;
            case 'spring':
                price = 147060;
                break;
            case 'high':
                price = 196020;
                break;
        }
        return price;
    }
    function getPriceForMonth(period) {
        var price;
        switch (period) {
            case 'low':
                price = 323460;
                break;
            case 'green':
                price = 382320;
                break;
            case 'spring':
                price = 441180;
                break;
            case 'high':
                price = 588060;
                break;
        }
        return price;
    }
    function getPriceForYear() {
        var price = 150000;
        return price * 12;
    }


    function countFromValues() {
        var startDate = $("#start-date").val();
        var finishDate = $("#finish-date").val();
        var fullPrice = 0;

        var date = stringToDate(startDate);
        var end = stringToDate(finishDate);

        var daysCount = getDaysAmount(date, end);
        while (date < end) {
            var period = getPeriodName(date);
            fullPrice += getPriceForDay(period);
            date = new Date(date.valueOf() + 24 * 60 * 60 * 1000);
        }
        document.getElementById('full-price').value = fullPrice;
        document.getElementById('price').value = fullPrice / 2;

    }

</script>
</body>
</html>