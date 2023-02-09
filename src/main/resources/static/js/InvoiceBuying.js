$('document').ready(function() {

	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(invoiceBuying, status){
			$('#idEdit').val(invoiceBuying.id);

			var invoiceDate=invoiceBuying.invoiceDate.substr(0,10);
			$('#dateEdit').val(invoiceDate);
//			$('#txtSupplierEdit').val(invoiceBuying.supplier.fullName);
			$('#supplierEdit').val(invoiceBuying.supplierid);
			$('#statusEdit').val(invoiceBuying.invoicestatusid);
			$('#specialRemarksEdit').val(invoiceBuying.specialRemarks);
			$('#totalCostEdit').val(invoiceBuying.totalCost);
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(invoiceBuying, status){
				$('#idDetails').val(invoiceBuying.id);
            	$('#specialRemarkDetails').val(invoiceBuying.specialRemarks);
           		$('#totalCostDetails').val(invoiceBuying.totalCost);
            	$('#supplierFullNameDetails').val(invoiceBuying.supplier.fullName);
            	$('#companyNameDetails').val(invoiceBuying.supplier.companyName);
            	$('#phoneDetails').val(invoiceBuying.supplier.phone);
            	$('#cityDetails').val(invoiceBuying.supplier.location.city);
            	$('#addressDetails').val(invoiceBuying.supplier.location.address);
            	$('#regionDetails').val(invoiceBuying.supplier.location.country.name);
//			$('#lastModifiedByDetails').val(country.lastModifiedBy);
//			$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
		});
		$('#detailsModal').modal();
	});
//
//	$('.table #deleteButton').on('click',function(event) {
//		event.preventDefault();
//		var href = $(this).attr('href');
//		$('#confirmDeleteButton').attr('href', href);
//		$('#deleteModal').modal();
//	});
});