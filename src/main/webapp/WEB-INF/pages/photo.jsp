<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file='header.html' %>


<meta http-equiv="content-language" content="ru">
		<title>Фотогалерея | Eva Villas</title>		
		<meta name="keywords" content="evavillas, evaphuket, eva, villas, villa, phuket, thailand, booking, about, Ева, виллы, пхукет, таиланд, забронировать, отдых, отпуск, фотографии, фото, фотогалерея, photo, gallery">
		<meta name="description" content="Фотогалерея вилл на Eva Villas">
		<meta name="robots" content="all">
		<meta name="author" content="Codekomilfo.com">
		<meta property=”og:title” content=”Eva_Villas”/>
		<meta property=”og:type” content=”company”/>
		<meta property=”og:description” content=”Фотогалерея_вилл_на_Eva_Villas“/>
		<meta property=”og:image” content=”/images/logo.png”/>
		<meta property=”og:url” content=”http://evaphuket.com”/>
		<meta property=”og:site_name” content=”Eva_Villas”/>
		
		<!-- слайды -->
		<link rel="stylesheet" href="/css/supersized.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="/theme/supersized.shutter.css" type="text/css" media="screen" />
		<script type="text/javascript" src="/js/jquery.easing.min.js"></script>
		
		<script type="text/javascript" src="/js/supersized.3.2.7.min.js"></script>
		<script type="text/javascript" src="/theme/supersized.shutter.min.js"></script>
		<script type="text/javascript">
			
			jQuery(function($){
				
				$.supersized({
				
					// Functionality
					slideshow               :   1,			// Slideshow on/off
					autoplay				:	1,			// Slideshow starts playing automatically
					start_slide             :   1,			// Start slide (0 is random)
					stop_loop				:	0,			// Pauses slideshow on last slide
					random					: 	0,			// Randomize slide order (Ignores start slide)
					slide_interval          :   6000,		// Length between transitions
					transition              :   6, 			// 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
					transition_speed		:	1000,		// Speed of transition
					new_window				:	1,			// Image links open in new window/tab
					pause_hover             :   0,			// Pause slideshow on hover
					keyboard_nav            :   1,			// Keyboard navigation on/off
					performance				:	1,			// 0-Normal, 1-Hybrid speed/quality, 2-Optimizes image quality, 3-Optimizes transition speed // (Only works for Firefox/IE, not Webkit)
					image_protect			:	1,			// Disables image dragging and right click with Javascript
															   
					// Size & Position						   
					min_width		        :   0,			// Min width allowed (in pixels)
					min_height		        :   0,			// Min height allowed (in pixels)
					vertical_center         :   1,			// Vertically center background
					horizontal_center       :   1,			// Horizontally center background
					fit_always				:	0,			// Image will never exceed browser width or height (Ignores min. dimensions)
					fit_portrait         	:   1,			// Portrait images will not exceed browser height
					fit_landscape			:   0,			// Landscape images will not exceed browser width
															   
					// Components							
					slide_links				:	'blank',	// Individual links for each slide (Options: false, 'num', 'name', 'blank')
					thumb_links				:	1,			// Individual thumb links for each slide
					thumbnail_navigation    :   1,			// Thumbnail navigation
					slides 					:  	[			// Slideshow Images
														{image : 'images/bgslider/1.jpg', title: 'Вид с верхнего этажа виллы на море'},
														{image : 'images/bgslider/2.jpg'},
														{image : 'images/bgslider/3.jpg'},
														{image : 'images/bgslider/4.jpg'},
														{image : 'images/bgslider/5.jpg'},
												],
												
					// Theme Options			   
					progress_bar			:	0,			// Timer for each slide							
					mouse_scrub				:	0
					
				});
		    });
		    
		</script>
		<!-- слайды - конец -->
			
	</head>
	<body>
	<%@ include file='left.html' %>
	

	<!--Thumbnail Navigation-->
	<div id="prevthumb"></div>
	<div id="nextthumb"></div>
	
		<!--Control Bar-->
	<div id="controls-wrapper" class="load-item">
		<div id="controls">
			
			<a id="play-button"><img id="pauseplay" src="img/pause.png"/></a>
	<!--Arrow Navigation-->
	<a id="prevslide" class="load-item"></a>
	<a id="nextslide" class="load-item"></a>
		
			<!--Slide counter-->
			<div id="slidecounter">
				<span class="slidenumber"></span> / <span class="totalslides"></span>
			</div>
			
			<!--Slide captions displayed here-->
			<div id="slidecaption"></div>
			
		</div>
	</div>
		
	</body>
</html>