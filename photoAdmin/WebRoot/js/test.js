$("#testForm").html5Validate(function() {
	alert("全部通过！");
	//this.submit();	
}, {
	// novalidate: false	
});
// 拖选
var mousedownleft, btnmarginleft, flagFollow = false;
$(".bar_btn").bind({
	"mousedown": function(e) {
		mousedownleft = e.pageX;
		btnmarginleft = parseInt($(this).css("marginLeft")) || 0;
		flagFollow = $(this);
	}	
});
$(document).bind({
	"mousemove": function(e) {
		var nowmouseleft = e.pageX, finalposleft = nowmouseleft - mousedownleft + btnmarginleft;
		if (flagFollow) {
			if (finalposleft > 190) {
				finalposleft = 190;
			} else if (finalposleft < -10) {
				finalposleft = -10;
			}
			var score = Math.round((finalposleft + 10) / 40);
			flagFollow.css("marginLeft", finalposleft).attr("data-content", score);
			$("#" + flagFollow.attr("data-rel")).val(score);
		}
	},
	"mouseup": function() {
		flagFollow = false;
	}
});