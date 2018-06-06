var titles = new Array();
var mp3s = new Array();
function getTitles () {
    $.getJSON("/FMusic/json/list.json", function (data) {
        $.each(data, function (infoIndex, info) {
            titles[infoIndex] = info["title"];
            mp3s[infoIndex] = info["mp3"];
            return info;
        })
    })
};

function getJson() {
    getTitles();
    alert("1");
    debugger;
    var json = "[";
    for(var i=0; i<titles.length; i++){
        json += '{"mp3":"'+mp3s[i]+'" , "title":"'+titles[i]+'"},'
    }
    return json;
};

$(function(){
    var json = getJson();
    json = json.substr(0, json.length - 1);
    json = json + "]";
    //将json字符串转化为json对象
    json = JSON.parse(json);

    new jPlayerPlaylist({
        jPlayer: "#jquery_jplayer_1",
        cssSelectorAncestor: "#jp_container_1"
    }, json, {
        /*swfPath: "../../dist/jplayer",*/
    swfPath: "/js/jplayer",
        supplied: "oga, mp3",
        wmode: "window",
        useStateClassSkin: true,
        autoBlur: false,
        smoothPlayBar: true,
        keyEnabled: true
    });
});