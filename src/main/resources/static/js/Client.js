$('document').ready(function() {

	$('#editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(client, status){
			$('#txtIdEdit').val(client.id);
			$('#txtNameEdit').val(client.name);
			$('#txtSurnameEdit').val(client.surname);
			$('#txtEmailEdit').val(client.email);
			$('#ddlLocationEdit').val(client.locationid);
			$('#txtPhoneEdit').val(client.phone);
			$('#txtDetailsEdit').val(client.details);
		});
		$('#editModal').modal();
	});

//	$('.table #detailsButton').on('click',function(event) {
//		event.preventDefault();
//		var href= $(this).attr('href');
//		$.get(href, function(jobTitle, status){
//			$('#idDetails').val(jobTitle.id);
//			$('#descriptionDetails').val(jobTitle.description);
//			$('#detailsDetails').val(jobTitle.details);
////			$('#lastModifiedByDetails').val(country.lastModifiedBy);
////			$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
//		});
//		$('#detailsModal').modal();
//	});

	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();
	});
});