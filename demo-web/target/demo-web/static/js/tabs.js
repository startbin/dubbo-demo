/* 打开一个标签 */
function OpenTab(title, url, icon) {
	/**
	 * 如果这个标题的标签存在，则选择该标签 否则添加一个标签到标签组
	 */
	if ($("#tabs").tabs('exists', title)) {
		$("#tabs").tabs('select', title);
	} else {
		$("#tabs").tabs('add', {
			title : title,
			content : createTabContent(url),
			closable : true,
			icon : icon
		}).bind('contextmenu', function(e) {
			if ($($('#tabs').tabs('getSelected').panel('options').content)[0] != undefined) {// 过滤 第一个tabs
				e.preventDefault();
				/* 选中当前触发事件的选项卡 */
				var subtitle = $(this).text();
				$('#tabs').tabs('select', subtitle);

				// 显示快捷菜单
				$('#menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
				return false;
			}
		});
	}
	// 关闭panel滚动条
	$('iframe').parent().css('overflow', 'hidden');
}

/* 生成标签内容 */
function createTabContent(url) {
	return '<iframe style="width:100%;height:100%;" scrolling="auto" frameborder="0" src="' + url + '"></iframe>';
}

$(function() {

	// 刷新
	$("#m-refresh").click(function() {
		var currTab = $('#tabs').tabs('getSelected'); // 获取选中的标签项
		var url = $(currTab.panel('options').content).attr('src'); // 获取该选项卡中内容标签（iframe）的 src 属性
		/* 重新设置该标签 */
		$('#tabs').tabs('update', {
			tab : currTab,
			options : {
				content : createTabContent(url)
			}
		})
	});

	// 关闭所有
	$("#m-closeall").click(function() {
		$(".tabs li").each(function(i, n) {
			if (i != 0) {// 保留第一个tabs
				var title = $(n).text();
				$('#tabs').tabs('close', title);
			}
		});
	});

	// 除当前之外关闭所有
	$("#m-closeother").click(function() {
		var currTab = $('#tabs').tabs('getSelected');
		currTitle = currTab.panel('options').title;

		$(".tabs li").each(function(i, n) {
			if (i != 0) {// 保留第一个tabs
				var title = $(n).text();
				if (currTitle != title) {
					$('#tabs').tabs('close', title);
				}
			}
		});
	});

	// 关闭当前
	$("#m-close").click(function() {
		var currTab = $('#tabs').tabs('getSelected');
		currTitle = currTab.panel('options').title;
		$('#tabs').tabs('close', currTitle);
	});
});
