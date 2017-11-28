$('button[name=statebutton]').click(function(event) {
	$('button[name=statebutton]').attr('class',"list-group-item");
	$(this).attr('class',"list-group-item disabled");
});

/*a[name=orderitem]*/
$('a[name=orderitem]').click(function(event) {
	$('a[name=orderitem]').attr('class',"list-group-item");
	$(this).attr('class',"list-group-item active");
});