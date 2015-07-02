$('.dropdown-button').dropdown({
    inDuration: 300,
    outDuration: 225,
    constrain_width: false, // Does not change width of dropdown to that of the activator
    hover: true, // Activate on hover
    gutter: 0, // Spacing from edge
    belowOrigin: false // Displays dropdown below the button
  }
)
function deleteallitems(){
	var curUser = $("#curUser").html();
	var x = confirm('Are you sure you want to delete all Products? ');
	if (x == true)
	{
	$.ajax({
        type: "GET",
        url: "cartDeleteAll",
        contentType : 'application/json; charset=utf-8',
        data: { "curUser" : curUser
          }, 
        success :function(result) {
        	location.reload();
       }
    });
	}
	
}
function deleteitem(id){
	var x = confirm('Are you sure you want to delete this Product? ');
	if (x == true)
	{
	$.ajax({
        type: "GET",
        url: "cartProductDelete",
        contentType : 'application/json; charset=utf-8',
        data: { "id" : id
          }, 
        success :function(result) {
        	location.reload();
       }
    });
	}
}
 $(document).ready(function() {
		    $('select').material_select();
		    $('.modal-trigger').leanModal();
		    $('.datepicker').pickadate({
		        selectMonths: true, // Creates a dropdown to control month
		        selectYears: 15 // Creates a dropdown of 15 years to control year
		      });
		  });