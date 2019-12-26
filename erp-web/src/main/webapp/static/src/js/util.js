

function iCheck(){

        if ($("input.flat")[0]) {
                $('input.flat').iCheck({
                    checkboxClass: 'icheckbox_flat-green',
                    radioClass: 'iradio_flat-green'
                });
        }

    // if ($("input.switch")[0]) {
    //     $('input.switch').iCheck({
    //         checkboxClass: 'js-switch',
    //         radioClass: 'js-switch'
    //     });
    // }
// Table
    $('table input').on('ifChecked', function () {
        checkState = '';
        $(this).parent().parent().parent().addClass('selected');
        countChecked();
    });
    $('table input').on('ifUnchecked', function () {
        checkState = '';
        $(this).parent().parent().parent().removeClass('selected');
        countChecked();
    });

    var checkState = '';

    $('.bulk_action input').on('ifChecked', function () {
        checkState = '';
        $(this).parent().parent().parent().addClass('selected');
        countChecked();
    });
    $('.bulk_action input').on('ifUnchecked', function () {
        checkState = '';
        $(this).parent().parent().parent().removeClass('selected');
        countChecked();
    });
    $('.bulk_action input#check-all').on('ifChecked', function () {
        checkState = 'all';
        countChecked();
    });
    $('.bulk_action input#check-all').on('ifUnchecked', function () {
        checkState = 'none';
        countChecked();
    });

    function countChecked() {
        if (checkState === 'all') {
            $(".bulk_action input[name='table_records']").iCheck('check');
        }
        if (checkState === 'none') {
            $(".bulk_action input[name='table_records']").iCheck('uncheck');
        }
    }

}

function button (data) {
    return "<button type=\"button\" class=\"btn btn-success btn-xs\" data-toggle=\"modal\" data-target=\"#myModal\"><i class=\"fa fa-th-list\"></i>详情</button>" +
        "<button type=\"button\" class=\"btn btn-info btn-xs\"><i class=\"fa fa-pencil\"></i>修改</button>"
}

function dateToStr(date,rex) {
    return date==null?"": new Date(date).toString(rex);
}

function check() {
    return " <input type=\"checkbox\" class=\"flat\" name=\"table_records\"> "
}

function date(){
    $('#single_cal1').daterangepicker({
        singleDatePicker: true,
        singleClasses: "picker_1"
    }, function(start, end, label) {
        console.log(start.toISOString(), end.toISOString(), label);
    });
}


