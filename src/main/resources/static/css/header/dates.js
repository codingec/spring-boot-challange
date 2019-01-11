$(document).ready(function() {
	$('#startDate, #stopDate').datetimepicker({
    	format: 'Y-m-d H:i'
    });

$('.selectpicker').selectpicker();
$('.selectpicker').selectpicker({
      style: 'btn-info',
      size: 4
  });
});



$('#startDate').datetimepicker({
    format: 'Y-m-d H:i'
});

$('#endDate').datetimepicker({
    format: 'Y-m-d H:i'
});
