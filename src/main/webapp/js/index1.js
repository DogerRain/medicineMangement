function daojishi(){
	var t=30;
	var timer=window.setInterval(function () {
		t--;
		$("#time").text("Time Remaning:"+t);
		if(t==0){
			
			var message = new Object();
			message['type'] = 9;
			message['to'] = (A == username ? B : A);
			message['x'] = -1;
			message['y'] = -1;
			message = JSON.stringify(message);
			if(username==turn)
				websocket.send(message);
			window.clearInterval(timer);
		}
		
	}, 1000);
	return timer;
	
}