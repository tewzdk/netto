$(document).ready(function(){
    $("#search-input").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#schedule-table-body tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });

        $("#schedule-table-caption").text($("#schedule-table-body").children(":visible").length + " skema(er) matcher din søgning");

        if($("#schedule-table-body").children(":visible").length === 0){
            $("#no-search-results").show();
            $(".no-search-results").hide();
        } else {
            $("#no-search-results").hide();
            $(".no-search-results").show();
        }
        if (value.length == 0)
        {
            $("#schedule-table-caption").text("Liste over alle skemaer");
        }
    });
});