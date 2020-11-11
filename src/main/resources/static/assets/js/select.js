(function($,window,document,undefined){ //用一个自调用匿名函数把插架代码包裹起来，防止代码污染
    $.fn.mySelect = function (options) {
        var defaults = {          //defaults 使我们设置的默认参数。
            Event : "click",      //触发响应事件
            msg : "请选择!"   //显示内容
        };
        var options = $.extend(defaults, options);    //将传入参数和默认参数合并
        var $this = $(this);      //当然响应事件对象
        // $this.live(options.Event, function (e) {   //功能代码部分，绑定事件
        //     alert(options.msg);
        // });
       //生成option-item并追加展示
        var html = '';
 		html += '<div class="select-picker-search">';
 		html += '<div class="select-picker-search-checked">请选择</div>';
 		html += '</div>';
 		html += '<div class="select-picker-options-wrp">';
 		html += '<div class="select-picker-options-serch">';
 		html += '<input type="text" placeholder="">';
 		html += '</div>';
 		html += '<div class="select-picker-options-list">';

 		$this.find("option").each(function(){ 
 			let _this = $(this);
 			html += '<div class="select-picker-options-list-item">';
 			html += '<b id='+_this.val()+' class="duihao duihao-nocheck"></b>';
 			html += '<span>'+_this.text()+'</span>';
 			html += '</div>';
 		})

 		html += '</div>';
 		html += '</div>'; 
	 	$this.append(html);
	 	// 下拉显示隐藏
	 	$this.on('click',".select-picker-search", function (e) {   //功能代码部分，绑定事件
           	$(this).next('.select-picker-options-wrp').toggle();
	 	 	$(this).next('.select-picker-options-wrp').find('.select-picker-options-serch input').focus();
        }); 
        // 点击选中或不选
 		$this.on('click',".select-picker-options-list-item",function(){ 
 			let _this = $(this);
 			if(_this.find('.duihao-nocheck').length > 0){
				_this.find('.duihao').removeClass('duihao-nocheck').addClass('duihao-checked');
 			}else{
				_this.find('.duihao').addClass('duihao-nocheck').removeClass('duihao-checked');
 			}
 			// 循环遍历options中选中的项添加到选项栏中
 			var checkedArr = [];
			$this.find(".select-picker-options-list-item").each(function(){ 
				let _this = $(this); 
				if(_this.find('.duihao-checked').length > 0){ 
					checkedArr.push($.trim(_this.text()))
				}
			})
			if (checkedArr.length > 0) {
			    $this.find('.select-picker-search-checked').text(checkedArr.join(','));
			    // $this.find('.select-picker-search-checked').text(checkedArr.join(',')).css('color', '#fff');
			} else {
			    $this.find('.select-picker-search-checked').text('请选择').css('color', '#757575');
			}
 		})
 		// 前端实现下拉搜索 
 		$this.on('keyup',".select-picker-options-serch input",function(){  
 			var text = $(this).val();
 			var html = '';
 			$this.find("option").each(function(){ 
	 			let _this = $(this);
	 			if(_this.text().indexOf(text) != -1){
		 			html += '<div class="select-picker-options-list-item">';
		 			html += '<b class="duihao duihao-nocheck"></b>';
		 			html += '<span>'+_this.text()+'</span>';
		 			html += '</div>';
	 			}
	 		})
	 		if(html == ''){
	 			html += '<p style="text-align:center;">没有相关内容</p>';
	 		}
	 		$this.find(".select-picker-options-list").html('').append(html);
 		})
    }
    // 点击document任意地方 下拉消失
  $(document).click(function (event) {
    var _con = $('.select-picker-options-wrp'); // 设置目标区域
    var _con2 = $('.select-picker-search-checked'); // 设置目标区域
    if (!_con2.is(event.target) && !_con.is(event.target) && _con.has(event.target).length === 0) {
      $('.select-picker-options-wrp').hide(); //淡出消失
    }
  });
})(jQuery,window,document); 

  
 
 		