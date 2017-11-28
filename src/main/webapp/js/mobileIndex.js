getUserList(1);
ip=commonIp;
	/*$("#uploadButton").click(function(){
		var form=new  FormData(document.getElementById("uploadForm"));
        var fun;
        fun=setInterval(function () {
            $.ajax({
                type: "get",
                url: "uploadState",
                success: function (response) {
                    var data=JSON.parse( response);
                    console.log(data)
                    if(data.have==1){
                        $("#progressBar").attr("style","width: "+(data.now/data.max*100)+"%");
                        console.log($("#progressBar").attr("style" ));
                        if(data.now==data.max){
                        	clearInterval(fun);
                        }
                    }
                }
                
            });

        },2000) 
        $.ajax({  
		     url : "upload",  
		     type : "POST",  
		     data:form,
             processData:false,
             contentType:false, 
		     success : function(data) {  
                alert("yes");
                $("#progressBar").attr("style","width: "+100+"%");
                $("#mylogo").attr({
                	"src":"/upload/"+username+".png?id="+Math.random()
                })
                clearInterval(fun)
		     },  
		     error : function(data) {  
                 alert("no");
                 $("#progressBar").attr("style","width: "+0+"%");
                 clearInterval(fun);
		     }  
        }); 
        
	})
						*/
							



var websocket = null;
function buildHtml(id, obj) {
       var source = $(id).html();
    var template = Handlebars.compile(source);

    var html = template(obj)
    
    return html;
}
function getUserList(index) {
    $.ajax({
        type: "get",
        url: 'getUserListByUserId',
        data: 'userId=' + $("#findInput").val() + '&index=' + index + '&len=8',
        success: function (response) {
            var data = JSON.parse(response);
            var ul = data.userlist;
            console.log(data);
            $("#ul").html("");
            for (var i = 0; i < ul.length; ++i)
                $("#ul").append(buildHtml('#useritem', ul[i]));
            $("#now").html("第" + data.now + "页");
            $("#sum").html("共" + data.sum + "页");
            $("#last").attr("da", data.now - 1);
            $("#next").attr("da", data.now + 1);

        }
    });
}
$("#searchButton").click(function (e) {
    e.preventDefault();
    var value = $("#findInput").val();
    getUserList(1);
});
$("#last").click(function (params) {
    getUserList($(this).attr('da'));
})
$("#next").click(function (params) {
    getUserList($(this).attr('da'));
})
$("#go").click(function (e) {
    e.preventDefault();
    getUserList($("#jump").val());
});

$.ajax({
    type: "get",
    url: 'loginByJson',
    data: 'username=' + username + '&password=' + password,
    success: function (response) {
        var data = JSON.parse(response);
        console.log(data)
        if (data.status != 'ok') return;
        $("#friendul").html("");
        var friendlist = data.friendlist;
        for (var i = 0; i < friendlist.length; ++i)
            $("#friendul").append(buildHtml("#frienditem", friendlist[i]));
        $("#msglist").html("");
        var message = data.userCustom.messages;
        console.log(message)
        for (var i = 0; i < message.length; ++i){
        	message[i]['createDate1']=new Date(message[i].createDate.time).toString()
        	$("#msglist").append(buildHtml("#msgtype" + message[i].type, message[i]));
        }
        function connect(){ 
	        websocket = new WebSocket("ws://"+ip+"/ssmws/websocketMsg?username=" + username);
	        websocket.onopen = function (params) {
	            console.log("success");
	        }
	        websocket.onclose=function (params) {
	            console.log("close")
	        }
	        websocket.onerror=function (params) {
	            console.log("error")
	        }
	        websocket.onmessage=function(res){
	            var data=res.data;
	            data=JSON.parse(data);
	            console.log(data);
	            if(data.type==22||data.type==2){
	                if(data.type==2){
	                    data['cc']="同意了你";
	                    data['createDate1']=new Date(data.createDate.time).toString()
	                    $("#msglist").append(buildHtml("#msgtype3", data));
	                }
	                $.ajax({
	                  url: 'getFridendListJSON',
	                  data:'userA=' +username,
	                  type:'get',
	                  success: function (res) {
	                    var data=JSON.parse(res);
	                    data=data.userids;
	                    $("#friendul").html("");
	                    for(var i=0;i<data.length;++i)
	                        $("#friendul").append(buildHtml("#frienditem",data[i]));
	                    
	                    console.log(data)
	                  },
	                  error:function(){
	                    console.log('error')
	                  }
	                });
	            }
	            else if(data.type==3||data.type==1){
	                data['cc']="拒绝了你";
	                data['createDate1']=new Date(data.createDate.time).toString()
	                $("#msglist").append(buildHtml("#msgtype" + data.type, data));
	            }
	        }
	        websocket.onclose=function(){
	        	alert("websocket reconnects");
	        	
	        }
        }
        connect();
        setInterval(function(){
        	if(websocket.readyState==3)
        		connect();
        }, 2000);
       
    },
    error: function () {
        console.log("error")
    }
});

$("body").on('click','.removeMsg1', function () {
    var msgId=$(this).attr('da');
    var ob={
        type:0,
        msgId:msgId
      }
      websocket.send(JSON.stringify(ob));
      $(this).parent().parent().parent().remove();
});
$("body").on('click','.acceptMsg1',function(){
    var to=$(this).attr("from");
    var da=$(this).attr("da");
    var ob = {
        msgId:da,
        type:2,
        to:to
      }
      websocket.send(JSON.stringify(ob));
      $(this).parent().parent().parent().remove();
      
})
$("body").on('click','.refuseMsg1',function(){
    var to=$(this).attr("from");
    var da=$(this).attr("da");
    var ob = {
        msgId:da,
        type:3,
        to:to
      }
      websocket.send(JSON.stringify(ob));
      $(this).parent().parent().parent().remove();
      
})
$("body").on('click','button[work=add]',function(){
    var da=$(this).attr('da');
    var ob={
        to:da,
        type:1
    };
    websocket.send(JSON.stringify(ob));
    alert("加友请求已发送")
})
$("body").on('click','button[work=del]',function(){
    var da=$(this).attr("da");
    var p=$(this).parent().parent().parent();
    $.ajax({
        type: "get",
        url: 'deleteRelationship',
        data: 'userA='+username+'&userB='+da,
        success: function (response) {
            p.remove();
        }
    });
})
