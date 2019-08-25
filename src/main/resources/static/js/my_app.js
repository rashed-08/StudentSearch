$(document).ready(function() {
	var table = $('#my_table').DataTable({
		"sAjaxSource" : "/json/show/all",
		"sAjaxDataProp" : "",
		"dataSrc": "",
		"order" : [ [ 0, "asc" ] ],
		"aoColumns" : [ {
			"mData" : "username",
			"render": function(data, type, row) {
				var str = '';
				str += '<a href="/show/profile/' + data + '" class="btn btn-info btn-sm">'+data+'</a>';
				return str;
			}
		}, {
			"mData" : "firstName"
		}, {
			"mData" : "lastName"
		}, {
			"mData" : "email"
		} ]
	});

	var table = $('#promo-code').DataTable({
		"sAjaxSource" : "/list/promo/code",
		"sAjaxDataProp" : "",
		"dataSrc": "",
		"order" : [ [ 0, "asc" ] ],
		"aoColumns" : [ {
			"mData" : "id"
		}, {
			"mData" : "promoCodeName"
		} ]
	});

	var table = $('#runningStudent').DataTable({
		"sAjaxSource" : "/json/active/student",
		"sAjaxDataProp" : "",
		"dataSrc": "",
		"order" : [ [ 0, "asc" ] ],
		"aoColumns" : [ {
			"mData" : "username"
		}, {
			"mData" : "firstName"
		}, {
			"mData" : "lastName"
		}, {
			"mData" : "email"
		}, {
			"render": function(data, type, row) {
				var str = '';
				str += '<a href="/suspend/student/' + row.username + '" class="btn btn-info btn-sm">Suspend</a>';
				return str;
			}
		} ]
	});

	var table = $('#suspendStudent').DataTable({
		"sAjaxSource" : "/json/inactive/student",
		"sAjaxDataProp" : "",
		"dataSrc": "",
		"order" : [ [ 0, "asc" ] ],
		"aoColumns" : [ {
			"mData" : "username"
		}, {
			"mData" : "firstName"
		}, {
			"mData" : "lastName"
		}, {
			"mData" : "email"
		}, {
			"render": function(data, type, row) {
				var str = '';
				str += '<a href="/activate/student/' + row.username + '" class="btn btn-info btn-sm">Activate</a>';
				return str;
			}
		} ]
	});
	
	var table = $('#adminTable').DataTable({
		"sAjaxSource" : "/json/show/all",
		"sAjaxDataProp" : "",
		"dataSrc": "",
		"order" : [ [ 0, "asc" ] ],
		"aoColumns" : [ {
			"mData" : "username"
		}, {
			"mData" : "firstName"
		}, {
			"mData" : "lastName"
		}, {
			"mData" : "email"
		}, {
			"mData" : "promoCode"
		}, {
			"render": function(data, type, row) {
				var str = '';
				str += '<a href="/update/student/' + row.username + '" class="btn btn-info btn-sm">';
				str += 'Update';
				str += '</a>';
				return str;
			}
		} ]
	});
	
	$(".js-example-basic-single").select2({
		theme: "classic"
	});
	
	$('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
	
	//Sweetalert2
	/*$(document).on('click', '#update', function(e) {
		swal(
			'Success',
			'success'
		)
	});*/
	
	$("#alert").fadeIn(3000).fadeOut(4000);
});