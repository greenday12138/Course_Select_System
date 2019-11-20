$(function(){
    var user=JSON.parse(sessionStorage.setItem("user"));
    $("#username").text(user.name);
    $("name").text(user.name);
    $("id").text(user.id);

    $.post("url",user,page_render(data));

    $("#submit").click(function(){

    })
})

function page_render(data) {
    //data format
    // {
    //     gender:
    //     univerrsity:
    //     college:
    //     department:
    //     interest:
    //     personal_web:
    //     office:
    //     tel:
    //     email:
    //     intro:
    //     honor: [
    //     ***,
    //     ****,
    //     ]
    // }
    if (data.gender == "male") {
        $("#gender_male").show();
        $("#gender_female").hide();
    }
    else {
        $("#gender_female").show();
        $("#gender_male").hide();
    }
    $("#name").text($("#username").text());
    $("#university").text(data.university);
    $("#college").text(data.college);
    $("#department").text(data.department);
    $("#interest").text(data.interest);
    $("#personal_web").text(data.personal_web);
    $("#office").text(data.office);
    $("#tel").text(data.tel);
    $("#email").text(data.email);
    $("#intro").text(data.intro);
    var str="";
    for(i in data.honor){
        str+=data.honor[i];
    }
    $("#honor").text(str);
}
