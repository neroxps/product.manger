$(document).ready(function () {
    $("#user-manger-node-1").addClass("active");
    $("#user-manger-node-2").addClass("active");
    $("#user-manger-node-3").addClass("active");
    $("#user-manger-node-li-1").addClass("active");
    $("#sex").select2({multiple: false});
    $("#role").select2({multiple: false});
    var baseUrl = $("#baseUrl").val();
    var phoneNumber = $("#phoneNumber").val();
    $.ajax({
        type: "POST",
        url: baseUrl + "/user/manger/detail",
        dataType: "json",
        data: {
            "phoneNumber": phoneNumber
        }, error: function (req, status, err) {
            console.log('Failed reason: ' + err);
        }, success: function (data) {
            console.log(JSON.stringify(data));
            $("#email").val(data.data.email);
            $("#username").val(data.data.username);
            $("#sex").val(data.data.sex === 0 ? "girl" : "boy").trigger("change");
            $("#role").val(data.data.role).trigger("change");
        }
    });
    $("#submit").click(function () {
        var formData = new FormData($("#form")[0]);
        $.ajax({
            type: "POST",
            url: baseUrl + "/user/manger/modify",
            data: formData,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                console.log("==============");
            }
        });
    });
});