$('#shipEndDate').daterangepicker({
    singleDatePicker: true,
    singleClasses: "picker_3",
    autoUpdateInput:false,
    locale: {
        format: "YYYY-MM-DD",
        separator: " - ",
        daysOfWeek: ["日","一","二","三","四","五","六"],
        monthNames: ["1","2","3","4","5","6","7","8","9","10","11","12"]
    }

});
