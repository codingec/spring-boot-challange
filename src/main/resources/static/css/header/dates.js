$(document).ready(function() {
	$('#startDate, #stopDate').datetimepicker({
    	format: 'd-m-Y H:i'
    });

$('.selectpicker').selectpicker();
$('.selectpicker').selectpicker({
      style: 'btn-info',
      size: 4
  });
});



$('#startDate').datetimepicker({
    format: 'd-m-Y H:i'
});

$('#endDate').datetimepicker({
    format: 'd-m-Y H:i'
});
