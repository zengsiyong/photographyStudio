
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>



<div id="slideshow-wrapper">
  <div id="slideshow-pattern" class="subheader-pattern-dot"></div>
  <div id="slideshow-border-top">
    <div id="gallery-slider-wrapper">
      <div id="gallery-slider">
        <div id="slider-controls">
          <a href="javascript: void(0)" id="slider-control-left">left</a>
          <a href="javascript: void(0)" id="slider-control-right">right</a>
        </div>
        <div id="slider-images-wrapper">
          <ul id="slider-main-ul">
            <li>
              <ul>
                <li class="type-3">
                  <a class="image-icon" title="杨璇璇-欧美电影" href="http://www.17sucai.com/">
										<span>
											<div class="icon"></div>
											<strong>杨璇璇-欧美电影</strong>知天使介绍：杨璇璇生于 1990-04-12  武汉  星座 白羊座
											<em class="more">详情 »</em>
										</span>
                    <img height="298" width="318" src="img/carousel/001.jpg" alt="">
                  </a>
                </li>
                <li class="type-1">
                  <a class="image-icon"  title="吴悠-篮球" href="http://www.17sucai.com/">
										<span>
											<div class="icon"></div>
											<strong>吴悠-篮球</strong>知天使介绍：吴悠生于 1985-08-26 北京  星座 处女座
											<em class="more">详情 »</em>
										</span>
                    <img height="148" width="158" src="img/carousel/002.jpg" alt="">
                  </a>
                </li>
                <li class="type-1">
                  <a class="video-icon"  title="高齐-凤凰网" href="http://www.17sucai.com/">
										<span>
											<div class="icon"></div>
											<strong>高齐-凤凰网</strong>
											知天使介绍：高齐生于	1979-11-22 北京 星座	天蝎座
											<em class="more">详情 »</em>
										</span>
                    <img height="148" width="158" src="img/carousel/003.jpg"  alt="">
                  </a>
                </li>
              </ul>
            </li>
          </ul>
        </div>
        <div id="slider-bottom-controls">
          <a id="slider-scroll-left" href="javascript: void(0);" title="Scroll left">left</a>
          <div id="slider-scroll">
            <div class="knob"></div>
          </div>
          <a id="slider-scroll-right" href="javascript: void(0);" title="Scroll right">right</a>
        </div>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
  var dtSlideshow = new dtSliderGallery({
    container:$("gallery-slider"),
    arrowControls:1,
    description:1,
    transitionDuration:1000,
    transitionInterval:5000
  });
</script>