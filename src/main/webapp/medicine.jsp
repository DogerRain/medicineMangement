<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
     <c:if test="${empty user}"> 
     　<%response.sendRedirect("http://localhost:8080/med/login.html"); %> 
     </c:if>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<!-- 先引入 jquery的 js -->
	<script type="text/javascript" src="easyui/js/jquery-1.8.0.min.js">
	</script>
	<!-- 引入 easyui的js -->
	<script type="text/javascript" src="easyui/js/jquery.easyui.min.js"></script>
	<!-- 引入国际化 js -->
	<script type="text/javascript" src="easyui/js/locale/easyui-lang-zh_CN.js"></script>
	<!-- 引入 默认样式 css -->
	<link rel="stylesheet" type="text/css" href="easyui/js/themes/default/easyui.css" />
	<!-- 引入 icon图标 css  -->
	<link rel="stylesheet" type="text/css" href="easyui/js/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="easyui/ztree/zTreeStyle.css" />
	<link rel="stylesheet" type="text/css" href="css/bg-img.css" />
	<script type="text/javascript" src="easyui/ztree/jquery.ztree.all-3.5.js"></script>
	<link rel="icon" type="image/x-icon" href="./images/bitbug_favicon.ico" />
	<link rel="icon" type="image/x-icon" href="./images/药.png" />
	<title>药品库存管理系统</title>
	<style type="text/css">
	.outlogin {
    position: absolute;
    right: 30px;
    top: 5px;
}
	
	</style>
</head>

<body class="easyui-layout">
	<div id="updateWin" class="easyui-window" title="Update" data-options="iconCls:'icon-save',modal:true" closed="true" maximizable="false"
	 style="width:400px;height:500px" collapsible="false" minimizable="false">
		
	</div>
	<div id="win" class="easyui-window" title="My Window" data-options="iconCls:'icon-save',modal:true" closed="true" maximizable="false"
	 style="width:400px;height:500px" collapsible="false" minimizable="false">
		
	</div>
	<div data-options="region:'north',title:'周院长医院药品库存管理系统',split:true" style="height:0;" id="titlediv">
		<div class="outlogin">
			欢迎您   &nbsp;  &nbsp; :   &nbsp;    ${user.zgmc }&nbsp;  &nbsp; &nbsp;
			<a href="outLogin">退出系统</a>
		</div>
	</div>
	<!-- <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
	<div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div> -->
	<div data-options="region:'west',title:'功能列表',split:true" style="width:200px;">
		<!-- 折叠面板  -->
		<!-- fit属性，使当前div大小占满父容器  -->
		<div class="easyui-accordion" data-options="fit:true">
			<!-- 通过iconCls 设置图标，找 icon.css中 类定义 -->
			<!-- <div data-options="title:'基本功能',iconCls:'icon-mini-add'">面板一</div>
			这里每个div就是一个面板
			<div data-options="title:'高级功能'">面板二</div> -->
			<div data-options="title:'管理员功能'">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
		</div>
	</div>
	<div data-options="region:'center'">
		<!-- 选项卡面板 -->
		<div class="easyui-tabs" data-options="fit:true" id="tt">
			<!-- <div data-options="title:'选项卡一',closable:true">
				<div region="center" style="height:400px">
					<form action="http://www.baidu.com" method="post" id="delForm" style="height:400px">
						<table id="dg" class="easyui-datagrid"></table>
					</form>
				</div> -->
				<div style="text-align: center; width: 100%;height:100%; display: table;border: green solid 1px;">
					<span style="display: table-cell; vertical-align: middle; ">
					<img alt="" src="./img/bg.png" style="display: inline-block;" />
					</span>
				</div>
				 
				<!-- <img src="./img/医院.png" class="bg-icon"> -->
			
			<!-- 这里每个div 就是一个选项卡 -->
			<!-- closeable 可关闭 -->
		<!-- 	<div data-options="title:'选项卡二',closable:true">内容二</div>
			<div data-options="title:'选项卡三',closable:true">内容三</div> -->
		</div>
	</div>
</body>
<script>
	function doSearch() {
		$('#dg').datagrid('load', {
			good: '11'
		});
	}
	function doDelete() {
		// 先判断 用户是否选择
		var array = $('#dg').datagrid('getSelections');
		if(array==null||array.length==0)
				return;
		$("#delForm").submit();
	}
	var editrow = undefined;
	$('#dg').datagrid({
		fit: true,
		url: 'data.json',
		pagePosition: "bottom",
		border: false,
		rownumbers: true,
		columns: [[
			{
				field: 'code',
				title: 'Code',
				checkbox: true,
				width: 100
			},
			{
				field: 'name',
				title: 'Name',
				width: 100,
				editor: {
					type: 'validatebox', // 编辑器类型
					options: { // 编辑器属性
						required: true
					}
				}
			},
			{
				field: 'price',
				title: 'Price',
				width: 100,
				editor: {
					type: 'validatebox', // 编辑器类型
					options: { // 编辑器属性
						required: true
					}
				}
			},
			{
				field: 'dead',
				title: 'dead',
				width: 100,
				formatter: function (value, row, index) {
					if (row.dead == 1) {
						return 'yes';
					} else {
						return 'no';
					}
				}
			},
			{
				field: 'child',
				title: 'child',
				width: 100,
				editor: {
					type: 'combobox',
					options: { data: [{ id: 1, name: "math" }, { id: 2, name: "english" }], valueField: "id", textField: "name" }
				},
				formatter: function (value, row, index) {
					return row.child.name;
				}
			}
		]],
		queryParams: {
			name: 'easyui',
			subject: 'datagrid'
		},
		toolbar: [{
		// 	iconCls: 'icon-edit',
		// 	handler: function () { alert('edit') }
		// }, {
			iconCls: 'icon-add',
			handler: function () {
				$("#win").window('open')
			}
		}, {
			iconCls: 'icon-save',
			handler: function () {
				//	alert(editrow)
				// 索引1 代表第二行
				var rs = $('#dg').datagrid('getRows');
				var array = [{ id: 1, name: "math" }, { id: 2, name: "english" }];
				for (var i = 0; i < array.length; ++i)
					if (array[i].id == rs[editrow].child) {
						rs[editrow].child = array[i];
						break;
					}
				$('#dg').datagrid('endEdit', editrow);
				alert(rs[editrow].code + " " + rs[editrow].name + " " + rs[editrow].child);
				editrow = undefined;
			}
		}, {
			iconCls: 'icon-cancel',
			handler: function () {
				doDelete();
			}
		}, {
			iconCls: 'icon-search',
			handler: function () {
				alert("dd")
				doSearch();
				alert('www')
			}
		}],
		pageList: [5, 6],
		idField: "code",
		pagination: true,
		onDblClickRow: function (rowIndex, rowData) {
			$("#updateWin").window('open');
			console.log(rowData)
			console.log(rowData.name)
			$('#name').val(rowData.name)
			$('#price').val(rowData.price)
			$('#dead').val(rowData.dead)
		//	$('#child').val(rowData.child.id)
			$('#child').combobox('select',rowData.child.id);

		}
	});
</script>
<script type="text/javascript">
	var x = 1;
	var oc = function (event, treeId, treeNode, clickFlag) {
		console.log(treeNode)
		var content = '<div style="width:100%;height:100%;overflow:hidden;">'
			+ '<iframe src="'
			+ treeNode.uu
			+ '" scrolling="auto" style="width:100%;height:100%;border:0;" ></iframe></div>';
		$('#tt').tabs('add', {
			title: treeNode.name,
			content: content,
			closable: true,
			tools: [{
				iconCls: 'icon-mini-refresh',
				handler: function () {
					alert('refresh');
				}
			}]
		});
	}
	var setting = {
		data: {
			simpleData: {
				enable: true,
				pIdKey: "pId"
			},
		},
		callback: {
			beforeClick: null,
			onClick: oc
		}
	};
	var treeNodes = [
		{ "id": 1, "pId": 0, "name": "药品库存信息","icon": "./easyui/ztree/img/diy/2.png","click": true,"uu": "http://localhost:8080/med/ypkcxx.html" },
		{ "id": 2, "pId": 0, "name": "药品入库信息" ,"icon": "./easyui/ztree/img/diy/2.png","uu": "http://localhost:8080/med/rkxx.html"},
		{ "id": 4, "pId": 0, "name": "药品出库信息","icon": "./easyui/ztree/img/diy/2.png","uu": "http://localhost:8080/med/ckxx.html" },
		{"id:": 5, "pid": 0, "name": "采购订单信息","icon": "./easyui/ztree/img/diy/2.png","uu": "http://localhost:8080/med/cgdd.html"},
		{ "id": 6, "pId": 0, "name": "供应商信息","icon": "./easyui/ztree/img/diy/2.png","uu": "http://localhost:8080/med/gys.html" },
		{ "id": 7, "pId": 0, "name": "职工信息", "icon": "./easyui/ztree/img/diy/2.png", "click": true,"uu": "http://localhost:8080/med/zgxx.html" },
	
		{ "id": 8, "pId": 0, "name": "药品报废信息", "icon": "./easyui/ztree/img/diy/2.png", "click": true,"uu": "http://localhost:8080/med/ypbf.html" },
		{"id:": 9, "pid": 0, "name": "药品过期信息","icon": "./easyui/ztree/img/diy/2.png","uu": "http://localhost:8080/med/ypgq.html"}

	];
	$(document).ready(function () {
		$.fn.zTree.init($("#treeDemo"), setting, treeNodes);
	});
</script>

</html>