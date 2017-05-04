<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<!--[if lt IE 7 ]><html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]><html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]><html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]><html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html lang="en" class="no-js"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<meta name="author" content="ThemeFuse">
<meta name="keywords" content="">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Arctic Sunset | Index</title>

<!-- main JS libs -->
<script src="js/libs/modernizr.min.js"></script>
<script src="js/libs/jquery-1.10.0.js"></script>
<script src="js/libs/jquery-ui.min.js"></script>
<script src="js/libs/bootstrap.min.js"></script>

<!-- Style CSS -->
<link href="css/bootstrap.css" media="screen" rel="stylesheet">
<link href="style.css" media="screen" rel="stylesheet">

<!-- scripts -->
<script src="js/general.js"></script>
<!-- styled select -->
<link rel="stylesheet" href="css/cusel.css">
<script src="js/cusel-min.js"></script>
<!-- custom input -->
<script src="js/jquery.customInput.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
<!-- Placeholders -->
<script type="text/javascript" src="js/jquery.powerful-placeholder.min.js"></script>
<!-- Progress Bars -->
<script src="js/progressbar.js"></script>
<!-- Calendar -->
<link href="css/jquery-ui-1.8.20.custom.css" rel="stylesheet">
<script src="js/jquery-ui.multidatespicker.js"></script>
<!-- Graph Builder -->
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/excanvas.min.js"></script><![endif]-->
<script type="text/javascript" src="js/jquery.flot.js"></script>
<script type="text/javascript" src="js/jquery.flot.resize.js"></script>
<script type="text/javascript">
    $(function() {
        var graphwidth = $('.widget_graph .inner').width();
        $('.widget_graph .graph').css('height', parseInt(graphwidth/1.7));
        $(window).resize(function() {
            graphwidth = $('.widget_graph .inner').width();
            $('.widget_graph .graph').css('height', parseInt(graphwidth/1.7));
        });

        var d1 = [[0, 9], [1, 23], [1.8, 7], [2.2, 24], [2.8, 18], [4, 36]];
        var graphholder = $("#graph");
        var plot = $.plot(graphholder, [d1], {
            colors: ["#de2a19", "#afd8f8", "#cb4b4b", "#4da74d", "#9440ed"],
            xaxis: {
                min: null,
                max: null
            },
            yaxis: {
                autoscaleMargin: 0.02
            },
            series: {
                lines: {
                    show: true,
                    lineWidth: 3,
                    fill: true,
                    fillColor: "rgba(185,185,185,0.23)"
                },
                points: {
                    show: true,
                    radius: 5,
                    lineWidth: 2,
                }
            },
            grid: {
                hoverable: true,
                clickable: true,
                margin: 12,
                color: "#aaa",
                borderColor: "#dfdcd6"
            }
        });

        function showTooltip(x, y, contents) {
            $("<div id='graph-tooltip'>" + contents + "</div>").css({top: y - 40, left: x - 20}).appendTo("body").fadeIn(200);
        };

        var previousPoint = null;
        $("#graph").bind("plothover", function (event, pos, item) {

            if (item) {
                if (previousPoint != item.dataIndex) {

                    previousPoint = item.dataIndex;

                    $("#graph-tooltip").remove();
                    var x = item.datapoint[0].toFixed(2),
                        y = item.datapoint[1].toFixed(2);

                    showTooltip(item.pageX, item.pageY, '$' + y*100);
                }
            } else {
                $("#graph-tooltip").remove();
                previousPoint = null;
            }
        });
    });
</script>

<!-- range sliders -->
<script src="js/jquery.slider.bundle.js"></script>
<script src="js/jquery.slider.js"></script>
<link rel="stylesheet" href="css/jslider.css">
<!-- Visual Text Editor -->
<script src="js/nicEdit.js"></script>
<!-- Volume, Balance -->
<script type="text/javascript" src="js/knobRot-0.2.2.js"></script>
<!-- Video Player -->
<link href="css/video-js.css" rel="stylesheet">
<script src="js/video.js"></script>
<!-- Audio Player -->
<link href="css/jplayer.css" rel="stylesheet">
<script src="js/jquery.jplayer.min.js"></script>
<script src="js/jplayer.playlist.min.js"></script>
<script type="text/javascript">
    //<![CDATA[
    $(document).ready(function(){
        var $ = jQuery;
        new jPlayerPlaylist({
            jPlayer: "#jquery_jplayer_1",
            cssSelectorAncestor: "#jp_container_1"
        }, [
            {
                title:"<div  class='title'><img src='images/temp/music-player1.png' alt='' /><div><strong>Fall Out Boy</strong><span>Dance, Dance</span></div></div>",
                mp3:"http://www.jplayer.org/audio/mp3/TSP-05-Your_face.mp3",
                oga:"http://www.jplayer.org/audio/ogg/TSP-05-Your_face.ogg"
            },
            {
                title:"<div  class='title'><img src='images/temp/music-player2.png' alt='' /><div><strong>Backstreet Boys</strong><span>Dance</span></div></div>",
                mp3:"http://www.jplayer.org/audio/mp3/TSP-07-Cybersonnet.mp3",
                oga:"http://www.jplayer.org/audio/ogg/TSP-07-Cybersonnet.ogg"
            },
            {
                title:"<div  class='title'><img src='images/temp/music-player3.png' alt='' /><div><strong>Pet Shop Boys</strong><span>Dance, Dance, Dance</span></div></div>",
                mp3:"http://www.jplayer.org/audio/mp3/Miaow-07-Bubble.mp3",
                oga:"http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg"
            }
        ], {
            swfPath: "js",
            supplied: "oga, mp3",
            wmode: "window",
            smoothPlayBar: false,
            keyEnabled: false
        });
    });
    //]]>
</script>

<!-- Scroll Bars -->
<script src="js/jquery.mousewheel.js"></script>
<script src="js/jquery.jscrollpane.min.js"></script>
<script type="text/javascript">
	jQuery(function()
	{
		jQuery('.scrollbar').jScrollPane({
			verticalDragMaxHeight: 25,
			verticalDragMinHeight:25
		});

		jQuery('.scrollbar.style2').jScrollPane({
			verticalDragMaxHeight: 39,
			verticalDragMinHeight:39
		});

		jQuery('.scrollbar.style3').jScrollPane({
			verticalDragMaxHeight: 19,
			verticalDragMinHeight:19
		});

		jQuery('.scrollbar.style4').jScrollPane({
			verticalDragMaxHeight: 37,
			verticalDragMinHeight:37
		});
	});
</script>

<!-- Multiselect -->
<link rel="stylesheet" href="css/chosen.css">
<script src="js/jquery.chosen.min.js" type="text/javascript"></script>
<script type="text/javascript">
    jQuery(document).ready(function() {
        jQuery('#contact_name').chosen({ width: "100%" });
    });
</script>

<!--[if lt IE 9]><script src="js/respond.min.js"></script><![endif]-->
<!--[if gte IE 9]>
<style type="text/css">
    .gradient {filter: none !important;}
</style>
<![endif]-->
</head>

<body>

<div class="container">
    <!-- content -->
    <div class="content " role="main">

        <!-- row -->
        <div class="row">
            <div class="col-sm-12">
                <h6 class="foo">Website Menu with dropdown submenu</h6>

                <!-- Website Menu -->
                <div class="dropdown-wrap">
                    <ul class="dropdown clearfix">
                        <li class="menu-level-0"><a href="#"><span>Home</span></a></li>
                        <li class="menu-level-0"><a href="#"><span>About</span></a>
                            <ul class="submenu-1">
                                <li class="menu-level-1"><a href="#">Privacy Policy</a></li>
                                <li class="menu-level-1"><a href="#">Copyright</a></li>
                                <li class="menu-level-1"><a href="#">Terms of Service</a>
                                    <ul class="submenu-2">
                                        <li class="menu-level-2"><a href="#">Gallery images</a></li>
                                        <li class="menu-level-2"><a href="#">OneByOne Slider</a></li>
                                        <li class="menu-level-2"><a href="#">Video in header</a></li>
                                        <li class="menu-level-2"><a href="#">Image &amp; Video Slider</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li class="menu-level-0"><a href="#"><span>Blog</span></a></li>
                        <li class="menu-level-0"><a href="#"><span>Team</span></a></li>
                        <li class="menu-level-0"><a href="#"><span>Portfolio</span></a></li>
                        <li class="menu-level-0"><a href="#"><span>Services</span></a>
                            <ul class="submenu-1">
                                <li class="menu-level-1"><a href="#">Privacy Policy</a></li>
                                <li class="menu-level-1"><a href="#">Copyright</a></li>
                                <li class="menu-level-1"><a href="#">Terms of Service</a>
                                    <ul class="submenu-2">
                                        <li class="menu-level-2"><a href="#">Gallery images</a></li>
                                        <li class="menu-level-2"><a href="#">OneByOne Slider</a></li>
                                        <li class="menu-level-2"><a href="#">Video in header</a></li>
                                        <li class="menu-level-2"><a href="#">Image &amp; Video Slider</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li class="menu-level-0"><a href="#"><span>Contact</span></a></li>
                        <li class="menu-level-0"><a href="#"><span>Shopp</span></a>
                            <ul class="submenu-1">
                                <li class="menu-level-1"><a href="#">Privacy Policy</a></li>
                                <li class="menu-level-1"><a href="#">Copyright</a></li>
                                <li class="menu-level-1"><a href="#">Terms of Service</a>
                            </ul>
                        </li>
                        <li class="menu-level-0"><a href="#"><span>Sport</span></a></li>
                    </ul>
                </div>
                <!--/ Website Menu -->
            </div>
        </div>
        <!--/ row -->

        <!-- row -->
        <div class="row">
            <div class="col-sm-3 col-sm-offset-4">
                <h6 class="foo">Dropdown Menu</h6>

                <!-- Dropdown Menu -->
                <select class="select_styled select_styled_red" name="contact_subject" id="contact_subject">
                    <option value="">What is it about?</option>
                    <option value="">Pre purchase question</option>
                    <option value="">Submit theme to showcase</option>
                    <option value="">Issues with the account</option>
                </select>
                <!--/ Dropdown Menu -->
            </div>

            <div class="col-sm-4 col-sm-offset-1">
                <h6 class="foo">Search Box</h6>

                <!-- search widget -->
                <div class="widget-container widget_search boxed">
                    <div class="inner">
                        <form method="get" id="searchform2" action="#">
                            <div class="clearfix">
                                <span class="btn"><input type="submit" id="searchsubmit2" value="Search" /></span>
                                <div class="input_wrap"><span class="input_icon"></span><input class="inputField" name="s" id="s2" placeholder="Type word here"  value="" type="text" /></div>
                            </div>
                        </form>
                    </div>
                </div>
                <!--/ search widget -->
            </div>
        </div>
        <!--/ row -->

        <!-- row -->
        <div class="row">
            <div class="col-sm-4">
                <h6 class="foo">Volume & Balance controls</h6>

                <!-- Volume control -->
                <div class="widget-knob widget-volume">
                    <input type="text" value="77"  autocomplete="off" id="volume" />
                    <script type="text/javascript">
                        $(document).ready(function() {
                            $('#volume').knobRot({
                                'classes': ['volume'],
                                'dragVertical': false,
                                'frameCount': 47,
                                'frameWidth': 114,
                                'frameHeight': 114,
                                'detent': true,
                                'detentThreshold': 5,
                                'minimumValue': 0,
                                'maximumValue': 100,
                                'hideInput': true
                            });
                        });
                    </script>
                </div>
                <!--/ Volume control -->

                <!-- Balance control -->
                <div class="widget-knob widget-balance">
                    <input type="text" value="36" autocomplete="off" id="balance" />
                    <script type="text/javascript">
                        $(document).ready(function() {
                            $('#balance').knobRot({
                                'classes': ['balance'],
                                'dragVertical': false,
                                'frameCount': 27,
                                'frameWidth': 104,
                                'frameHeight': 117,
                                'detent': true,
                                'detentThreshold': 2,
                                'minimumValue': -50,
                                'maximumValue': 50,
                                'hideInput': false
                            });
                        });
                    </script>
                </div>
                <!--/ Balance control -->

                <h6 class="foo">Scroll Bars</h6>

                <div class="scrollbars clearfix">
                    <!-- ScrollBars -->
                    <div class="scrollbar">
                        <p>These examples show very basic functionality and exist so that I can test that any changes to jScrollPane work cross browser and don't cause any new problems. Note that these examples aren't meant to look pretty, they merely highlight different bits of functionaity which are available. If you want examples of jScrollPane looking good then check out the themes.</p>
                    </div>
                    <div class="scrollbar style2">
                        <p>These examples show very basic functionality and exist so that I can test that any changes to jScrollPane work cross browser and don't cause any new problems. Note that these examples aren't meant to look pretty, they merely highlight different bits of functionaity which are available. If you want examples of jScrollPane looking good then check out the themes.</p>
                    </div>
                    <div class="scrollbar style3">
                        <p>These examples show very basic functionality and exist so that I can test that any changes to jScrollPane work cross browser and don't cause any new problems. Note that these examples aren't meant to look pretty, they merely highlight different bits of functionaity which are available. If you want examples of jScrollPane looking good then check out the themes.</p>
                    </div>
                    <div class="scrollbar style4">
                        <p>These examples show very basic functionality and exist so that I can test that any changes to jScrollPane work cross browser and don't cause any new problems. Note that these examples aren't meant to look pretty, they merely highlight different bits of functionaity which are available. If you want examples of jScrollPane looking good then check out the themes.</p>
                    </div>
                    <!--/ ScrollBars -->
                </div>

            </div>

            <div class="col-sm-3">
                <h6 class="foo">Audio Player</h6>

                <!-- Widget Audio Player -->
                <div class="widget-container widget-audio boxed">
                    <div class="inner">
                        <div id="jquery_jplayer_1" class="jp-jplayer"></div>
                        <div id="jp_container_1" class="jp-audio">
                            <div class="jp-type-playlist">
                                <div class="jp-playlist">
                                    <ul>
                                        <li></li>
                                    </ul>
                                </div>
                                <div class="jp-gui jp-interface">
                                    <div class="jp-progress">
                                        <div class="jp-seek-bar">
                                            <div class="jp-play-bar"></div>
                                        </div>
                                    </div>
                                    <ul class="jp-controls">
                                        <li><a href="javascript:;" class="jp-previous disabled" tabindex="1">previous</a></li>
                                        <li><a href="javascript:;" class="jp-play" tabindex="1">play</a></li>
                                        <li><a href="javascript:;" class="jp-pause" tabindex="1">pause</a></li>
                                        <li><a href="javascript:;" class="jp-next" tabindex="1">next</a></li>
                                        <li><a href="javascript:;" class="jp-stop" tabindex="1">stop</a></li>
                                        <li><a href="javascript:;" class="jp-mute" tabindex="1" title="mute">mute</a></li>
                                        <li><a href="javascript:;" class="jp-unmute" tabindex="1" title="unmute">unmute</a></li>
                                        <li><a href="javascript:;" class="jp-volume-max" tabindex="1" title="max volume">max volume</a></li>
                                    </ul>
                                    <div class="jp-volume-bar">
                                        <div class="jp-volume-bar-value"></div>
                                    </div>
                                    <div class="jp-current-time"></div>
                                    <div class="jp-duration"></div>
                                    <ul class="jp-toggles">
                                        <li><a href="javascript:;" class="jp-shuffle" tabindex="1" title="shuffle">shuffle</a></li>
                                        <li><a href="javascript:;" class="jp-shuffle-off" tabindex="1" title="shuffle off">shuffle off</a></li>
                                        <li><a href="javascript:;" class="jp-repeat" tabindex="1" title="repeat">repeat</a></li>
                                        <li><a href="javascript:;" class="jp-repeat-off" tabindex="1" title="repeat off">repeat off</a></li>
                                    </ul>
                                </div>
                                <div class="jp-no-solution">
                                    <span>Update Required</span>
                                    To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Widget Audio Player -->
            </div>

            <div class="col-sm-3 col-sm-offset-1">
                <h6 class="foo">Avatar Placeholder</h6>

                <!-- Avatar Placeholder -->
                <div class="widget-container widget_avatar boxed">
                    <div class="inner">
                        <h5>Gabrielle Shanon</h5>
                        <span class="subtitle">Comedy actors</span>
                        <div class="avatar"><img src="images/temp/avatar.png" alt="" /></div>
                        <div class="followers">
                            <span class="counter">1489</span>
                            <span>followers</span>
                        </div>
                        <div class="follow">
                            <a href="#" class="btn btn-red"><span><i class="plus"></i>Follow</span></a>
                        </div>
                    </div>
                </div>
                <!--/ Avatar Placeholder -->

                <h6 class="foo">Rating Stars</h6>

                <!-- Rating Stars -->
                <div class="rating clearfix">
                    <span class="star on"><input type="hidden" value="1"></span>
                    <span class="star on"><input type="hidden" value="2"></span>
                    <span class="star on"><input type="hidden" value="3"></span>
                    <span class="star off"><input type="hidden" value="4"></span>
                    <span class="star off"><input type="hidden" value="5"></span>
                </div>
                <!--/ Rating Stars -->
            </div>
        </div>
        <!--/ row -->

        <!-- row -->
        <div class="row">

            <div class="col-sm-7">
                <!-- row level 2 -->
                <div class="row">
                    <div class="col-sm-9">
                        <h6 class="foo">Contact Form</h6>

                        <!-- comment form -->
                        <div class="add-comment styled boxed" id="addcomments">
                            <div class="add-comment-title"><h3></h3></div>
                            <div class="comment-form">
                                <script type="text/javascript">
                                    bkLib.onDomLoaded(function() {
                                        var myNicEditor = new nicEditor({
                                            buttonList : [
                                                'bold',
                                                'italic',
                                                'underline',
                                                'forecolor',
                                                'left',
                                                'center',
                                                'right',
                                                'justify'
                                            ]
                                        });
                                        myNicEditor.setPanel('edit_buttons');
                                        myNicEditor.addInstance('styled_message');
                                    });
                                    setTimeout(function () {
                                        var nic_width = $('.nicEdit-panel').width();
                                        $('.nicEdit-container').css('width', nic_width);
                                        $('.nicEdit-main').css('width', nic_width-24);
                                    }, 2000);
                                    $(window).resize(function() {
                                        var nic_width = $('.nicEdit-panel').width();
                                        $('.nicEdit-container').css('width', nic_width);
                                        $('.nicEdit-main').css('width', nic_width-24);
                                    });
                                </script>
                                <form action="#" method="post" id="commentForm" class="ajax_form">
                                    <div class="form-inner">
                                        <div class="field_select">
                                            <label for="contact_name" class="label_title">Name:</label>
                                            <select name="contact_name" id="contact_name" multiple data-placeholder="Your Selection">
                                                <option value='example1@gmail.com'>Black Sabbath</option>
                                                <option value='example2@gmail.com'>Lana Ray</option>
                                                <option value='example3@gmail.com'>Toby Lightman</option>
                                                <option value='example4@gmail.com'>Lene Marlin</option>
                                                <option value='example5@gmail.com'>Deep Purple</option>
                                            </select>
                                        </div>
                                        <div class="field_text">
                                            <label for="subject" class="label_title">Subject:</label>
                                            <input type="text" name="subject" id="subject" value="" placeholder="Wireframe" class="inputtext input_middle required" />
                                        </div>
                                        <div class="clear"></div>
                                        <div class="field_text field_textarea">
                                            <div id="edit_buttons" class="edit_buttons"></div>
                                            <label for="styled_message" class="label_title">Message:</label>
                                            <textarea cols="30" rows="10" name="styled_message" id="styled_message" class="textarea textarea_middle"></textarea>
                                        </div>
                                        <div class="clear"></div>
                                    </div>

                                    <div class="rowSubmit">
                                        <a onclick="document.getElementById('commentForm').reset();return false" href="#" class="link-reset btn"><span>Discard</span></a>
                                        <span class="btn btn-red"><input type="submit" id="send" value="Send Message" /></span>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!--/ comment form -->
                    </div>

                    <div class="col-sm-3">
                        <div class="checkbox-controls">
                            <h6 class="foo">Controls</h6>

                            <div class="input_styled checklist pull-left"><div class="rowCheckbox"><input name="signup" type="checkbox" id="signup" value="signup"><label for="signup"></label></div></div>
                            <div class="input_styled inlinelist pull-left"><div class="rowRadio"><input type="radio" name="signup3" value="radio_v1" id="radio_v1"><label for="radio_v1"></label></div></div>
                            <div class="clear"></div>
                            <div class="input_styled checklist pull-left"><div class="rowCheckbox"><input name="signup2" checked type="checkbox" id="signup2" value="signup2"><label for="signup2"></label></div></div>
                            <div class="input_styled inlinelist pull-left"><div class="rowRadio"><input type="radio" name="signup3" value="radio_v2" id="radio_v2" checked><label for="radio_v2"></label></div></div>
                            <div class="clear"></div>
                            <div class="input_styled checklist"><div class="rowCheckbox checkbox-large"><input name="invoice" type="checkbox" checked id="invoice" value="invoice"><label for="invoice"></label></div></div>
                            <div class="input_styled checklist"><div class="rowCheckbox checkbox-large"><input name="invoice2" type="checkbox" id="invoice2" value="invoice2"><label for="invoice2"></label></div></div>
                        </div>
                    </div>
                </div>
                <!--/ row level 2 -->

                <h6 class="foo">Simple Message Field</h6>

                <!-- post comments -->
                <div class="comment-list clearfix" id="comments">
                    <ol>
                        <li class="comment">
                            <div class="comment-body">
                                <div class="comment-arrow"></div>
                                <div class="comment-avatar">
                                    <div class="avatar"><img src="images/temp/avatar1.png" alt="" /></div>
                                </div>
                                <div class="comment-text">
                                    <div class="comment-author clearfix">
                                        <a href="#" class="link-author">Brad Pit</a> <span class="comment-date">June 28, 2012</span> | <a href="#addcomments" class="link-reply anchor">Reply</a>
                                    </div>
                                    <div class="comment-entry">
                                        William Bradley "Brad" Pitt is an American actor and film producer. Pitt has received four Academy nominations and five Award nominations.
                                    </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </li>
                    </ol>
                </div>
                <!--/ post comments -->
            </div>

            <div class="col-sm-5">
                <h6 class="foo">Video Player</h6>

                <!-- Video Player -->
                <div class="video_player">
                    <div class="inner">
                        <video id="my_video_1" class="video-js vjs-default-skin" controls loop
                               preload="auto" poster="images/temp/vjs_poster2.png"
                               data-setup="{}">
                            <source src="http://test.themefuse.com/artiom/galapagos.mp4" type='video/mp4'>
                        </video>
                        <script>
                            _V_("my_video_1").ready(function(){
                                var myPlayer = this;
                                var aspectRatio = 192/380;
                                var width = document.getElementById(myPlayer.id).parentElement.offsetWidth;
                                myPlayer.width(width).height( width * aspectRatio );

                                function resizeVideoJS(){
                                    var width = document.getElementById(myPlayer.id).parentElement.offsetWidth;
                                    myPlayer.width(width).height( width * aspectRatio );
                                }
                                resizeVideoJS();
                                window.onresize = resizeVideoJS;
                            });
                        </script>
                    </div>
                </div>
                <!--/ Video Player -->

                <div class="progressbars">
                    <h6 class="foo">Progress Bars</h6>

                    <!-- Progress Bar -->
                    <div id="progressBar1" class="progressbar">
                        <span class="mark-left">0%</span>
                        <span class="mark-right">100%</span>
                        <div class="percent"></div>
                        <div class="pbar"></div>
                        <div class="elapsed"></div>
                        <div class="remained"></div>
                    </div>
                    <script type="text/javascript">
                        $(document).ready(function() {
                            $('#progressBar1').anim_progressbar({
                                totaltime: 120
                            });
                        });
                    </script>
                    <!--/ Progress Bar -->

                    <!-- Range slider -->
                    <div class="range-slider">
                        <input id="price_range" type="text" name="price_range" value="270;800">
                    </div>
                    <script type="text/javascript" >
                        jQuery(document).ready(function($) {
                            // Price Range Input
                            $("#price_range").rangeslider({
                                from: 50,
                                to: 1000,
                                limits: false,
                                scale: ['$50', '$1000'],
                                heterogeneity: ['50/500'],
                                step: 10,
                                smooth: true,
                                dimension: '$'
                            });
                        });
                    </script>
                    <!-- Range slider -->

                    <!-- Progress Bar with download Bar -->
                    <div id="progressBar2" class="progressbar style2">
                        <span class="mark-left">0%</span>
                        <span class="mark-right">100%</span>
                        <div class="percent"></div>
                        <div class="pbar">
                            <div id="downloadBar" class="downloadbar">
                                <div class="pbar"></div>
                            </div>
                        </div>
                        <div class="elapsed"></div>
                        <div class="remained"></div>

                    </div>
                    <script type="text/javascript">
                        $(document).ready(function() {
                            $('#progressBar2').anim_progressbar({
                                totaltime: 180
                            });
                            $('#downloadBar').anim_progressbar({
                                totaltime: 120
                            });
                        });
                    </script>
                    <!--/ Progress Bar with download Bar -->
                </div>
            </div>
        </div>
        <!--/ row -->

        <!-- row -->
        <div class="row">
            <div class="col-sm-8">
                <h6 class="foo">Image Slider</h6>

                <!-- Image Slider -->
                <div class="widget-container widget_gallery boxed">
                    <div class="inner">
                        <div id="myCarousel" class="carousel slide" data-interval="20000">
                            <!-- Carousel items -->
                            <div class="carousel-inner">
                                <div class="active item">
                                    <img src="images/temp/top-slider-5.jpg" alt="" />
                                    <div class="carousel-title"><h6>Brave animated series</h6><p>Disney Pixar</p></div>
                                </div>
                                <div class="item">
                                    <img src="images/temp/top-slider-2.jpg" alt="" />
                                    <div class="carousel-title"><h6>Horton</h6><p>Change your fate</p></div>
                                </div>
                                <div class="item">
                                    <img src="images/temp/top-slider-3.jpg" alt="" />
                                    <div class="carousel-title"><h6>Surf up</h6><p>Change your fate</p></div>
                                </div>
                                <div class="item">
                                    <img src="images/temp/top-slider-4.jpg" alt="" />
                                    <div class="carousel-title"><h6>Wall-e</h6><p>Disney Pixar</p></div>
                                </div>
                                <div class="item">
                                    <img src="images/temp/top-slider-1.jpg" alt="" />
                                    <div class="carousel-title"><h6>Ice Age</h6><p>Change your fate</p></div>
                                </div>
                            </div>
                            <!-- Carousel indicators -->
                            <ol class="carousel-indicators">
                                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                <li data-target="#myCarousel" data-slide-to="1"></li>
                                <li data-target="#myCarousel" data-slide-to="2"></li>
                                <li data-target="#myCarousel" data-slide-to="3"></li>
                                <li data-target="#myCarousel" data-slide-to="4"></li>
                            </ol>
                            <!-- Carousel nav -->
                            <a class="carousel-control left" href="#myCarousel" data-slide="prev"></a>
                            <a class="carousel-control right" href="#myCarousel" data-slide="next"></a>
                        </div>
                    </div>
                </div>
                <!--/ Image Slider -->
            </div>

            <div class="col-sm-4">
                <h6 class="foo">Simple Graph</h6>

                <!-- Simple Graph -->
                <div class="widget-container widget_graph boxed">
                    <div class="inner">
                        <div id="graph" class="graph"></div>
                    </div>
                </div>
                <!--/ Simple Graph -->

                <h6 class="foo">Tags</h6>

                <!-- tags -->
                <div class="tagcloud margin-30">
                    <a href="#" class="tag-link-1" title="2 topics"><span>Design</span></a>
                    <a href="#" class="tag-link-2" title="3 topics"><span>Fashion</span></a>
                    <a href="#" class="tag-link-7" title="6 topics"><span>Web</span></a>
                    <a href="#" class="tag-link-3" title="5 topics"><span>Electricity</span></a>
                    <a href="#" class="tag-link-4" title="8 topics"><span>Kitchen</span></a>
                    <a href="#" class="tag-link-8" title="8 topics"><span>Cooking</span></a>
                    <a href="#" class="tag-link-5" title="9 topics"><span>Cinema</span></a>
                    <a href="#" class="tag-link-6" title="3 topics"><span>Anniversaries</span></a>
                    <a href="#" class="tag-link-9" title="9 topics"><span>Print</span></a>
                </div>
                <!--/ tags -->
            </div>
        </div>
        <!--/ row -->


        <!-- row -->
        <div class="row">
            <div class="col-sm-6">
                <h6 class="foo">Buttons</h6>

                <div class="buttons-wrap">
                    <div class="buttons">
                        <a href="#" class="btn btn-left"><span>Right</span></a>
                        <a href="#" class="btn btn-pagination"><span>Download all files</span></a>
                        <a href="#" class="btn btn-right"><span>&nbsp;Left&nbsp;</span></a>
                    </div>

                    <div class="buttons">
                        <a href="#" class="btn btn-left btn-acute"><span>Right</span></a>
                        <a href="#" class="btn btn-acute"><span>Download all files</span></a>
                        <a href="#" class="btn btn-right btn-acute"><span>&nbsp;Left&nbsp;</span></a>
                    </div>

                    <div class="buttons">
                        <a href="#" class="btn btn-round"><span>Normal</span></a>
                        <a href="#" class="btn btn-round hover"><span>Hover</span></a>
                        <a href="#" class="btn btn-round active"><span>Pressed</span></a>
                    </div>

                </div>
            </div>

            <div class="col-sm-6">
                <h6 class="foo">Tabs</h6>

                <!-- tabs -->
                <div class="tabs_framed styled">
                    <div class="inner">
                        <ul class="tabs clearfix active_bookmark1">
                            <li class="active"><a href="#events" data-toggle="tab">Events</a></li>
                            <li><a href="#reminders" data-toggle="tab"><sup class="note">5</sup>Reminders</a></li>
                            <li><a href="#starred" data-toggle="tab">Starred</a></li>
                            <li><a href="#archive" data-toggle="tab">Archive</a></li>
                        </ul>

                        <div class="tab-content clearfix">
                            <div class="tab-pane fade in active" id="events">
                                <div class="tab_image"><img src="images/temp/tabimage5.png" alt="" /></div>
                                <h4>It was a matter of time</h4>
                                <p>He made his film debut with a mirror part in Black to the Future Part II</p>
                                <a href="#" class="see-more"><span>See more</span></a>
                            </div>
                            <div class="tab-pane fade" id="reminders">
                                <div class="tab_image"><img src="images/temp/tabimage6.png" alt="" /></div>
                                <h4>5 November</h4>
                                <p>He made his film debut with a mirror part in Black to the Future Part II</p>
                                <a href="#" class="see-more"><span>See more</span></a>
                            </div>
                            <div class="tab-pane fade" id="starred">
                                <div class="tab_image"><img src="images/temp/tabimage7.png" alt="" /></div>
                                <h4>11 October</h4>
                                <p>He made his film debut with a mirror part in Black to the Future Part II</p>
                                <a href="#" class="see-more"><span>See more</span></a>
                            </div>
                            <div class="tab-pane fade" id="archive">
                                <div class="tab_image"><img src="images/temp/tabimage5.png" alt="" /></div>
                                <h4>14 September</h4>
                                <p>He made his film debut with a mirror part in Black to the Future Part II</p>
                                <a href="#" class="see-more"><span>See more</span></a>
                            </div>
                        </div>
                    </div>
                </div>
                <!--/ tabs -->
            </div>
        </div>
        <!--/ row -->

        <!-- row -->
        <div class="row">
            <div class="col-sm-8">
                <!-- row level 2 -->
                <div class="row">
                    <div class="col-sm-5">
                        <h6 class="foo">Badges</h6>

                        <div class="badges">
                            <!-- Badges -->
                            <div class="badge badge-try"></div>
                            <div class="badge badge-popular"></div>
                            <div class="badge badge-discount"></div>
                            <!--/ Badges -->
                        </div>
                    </div>

                    <div class="col-sm-5 col-sm-offset-1">
                        <h6 class="foo">Ribbons</h6>

                        <div class="ribbons">
                            <!-- Ribbons -->
                            <div class="ribbon ribbon-yellow"><span></span></div>
                            <div class="ribbon ribbon-green"><span></span></div>
                            <div class="ribbon ribbon-blue"><span></span></div>
                            <!--/ Ribbons -->
                        </div>
                    </div>
                </div>
                <!--/ row level 2 -->

                <h6 class="foo">Pricing Tables/Boxes</h6>

                <!-- pricing -->
                <div class="pricing_box price_style1 clearfix">
                    <ul>

                        <li class="price_col">
                            <!--pricing item-->
                            <div class="price_item">
                                <div class="inner">
                                    <div class="badge"></div>
                                    <div class="price_col_head">
                                        <span class="price"><em>$</em>5<sup>99</sup><span>month</span></span>
                                    </div>
                                    <div class="price_col_body clearfix">
                                        <div class="price_body_inner">
                                            <div class="price_body_top">
                                                <strong>Basic</strong>
                                                <span>All important futures for work</span>
                                            </div>
                                            <ul>
                                                <li>250 SKU’s</li>
                                                <li>1 GB Storage</li>
                                                <li>3,5% transaction fee</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="price_col_foot">
                                        <div class="sign_up"><a href="#" class="btn btn-large"><span>Try a Week</span></a></div>
                                    </div>
                                </div>
                            </div>
                            <!--/ pricing-item -->
                        </li>

                        <li class="price_col price_col_green col_active">
                            <!--pricing item-->
                            <div class="price_item">
                                <div class="inner">
                                    <div class="badge"></div>
                                    <div class="price_col_head">
                                        <span class="price"><em>$</em>2<sup>99</sup><span>month</span></span>
                                    </div>
                                    <div class="price_col_body clearfix">
                                        <div class="price_body_inner">
                                            <div class="price_body_top">
                                                <strong>Premium</strong>
                                                <span>Lots of clients  & users</span>
                                            </div>
                                            <ul>
                                                <li>2,500 SKU’s</li>
                                                <li>5 GB Storage</li>
                                                <li>1,5% transaction fee</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="price_col_foot">
                                        <div class="sign_up"><a href="#" class="btn btn-red btn-large"><span>BUY NOW</span></a></div>
                                    </div>
                                </div>
                            </div>
                            <!--/ pricing-item -->
                        </li>

                        <li class="price_col price_col_blue">
                            <!--pricing item-->
                            <div class="price_item">
                                <div class="badge"></div>
                                <div class="inner">
                                    <div class="price_col_head">
                                        <span class="price"><em>$</em>8<sup>99</sup><span>month</span></span>
                                    </div>
                                    <div class="price_col_body clearfix">
                                        <div class="price_body_inner">
                                            <div class="price_body_top">
                                                <strong>Ultimate</strong>
                                                <span>All important futures for work</span>
                                            </div>
                                            <ul>
                                                <li>Unlimited SKU’s</li>
                                                <li>20 GB Storage</li>
                                                <li>1% transaction fee</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="price_col_foot">
                                        <div class="sign_up"><a href="#" class="btn btn-large"><span>Subscribe</span></a></div>
                                    </div>
                                </div>
                            </div>
                            <!--/ pricing-item -->
                        </li>

                    </ul>
                </div>
                <!--/ pricing -->
            </div>

            <div class="col-sm-4">
                <h6 class="foo">Calendar</h6>

                <!-- widget calendar-->
                <div class="widget-container widget_calendar boxed">
                    <div class="inner">
                        <input type="text" name="date_departure" class="inputField" value="" id="date_departure">
                        <script>
                            // <![CDATA[
                            jQuery(document).ready(function($) {
                                var daysRange = 5;

                                function assignCalendar(id){
                                    $('<div class="calendar" />')
                                            .insertAfter( $(id) )
                                            .multiDatesPicker({
                                                dateFormat: 'yy-mm-dd',
                                                minDate: new Date(),
                                                maxDate: '+1y',
                                                altField: id,
                                                firstDay: 1,
                                                showOtherMonths: true
                                            }).prev().hide();
                                }

                                assignCalendar('#date_departure');
                            });
                            // ]]>
                        </script>
                    </div>
                </div>
                <!--/ widget calendar-->
            </div>
        </div>
        <!--/ row -->

    </div>
    <!--/ content -->
</div>
<!--/ container -->

</body>
</html>