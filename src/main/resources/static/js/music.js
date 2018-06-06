var titles = new Array();
var mp3s = new Array();

function getJson() {
    getTitles(titles, mp3s);
    var json = "[";
    for(var i=0; i<titles.length; i++){
        json += '{"mp3":"'+mp3s[i]+'" , "title":"'+titles[i]+'"},'
    }
    return json;
};

function getTitles(titles, mp3s) {
    $.getJSON("/FMusic/json/list.json", function (data) {
        $.each(data, function (infoIndex, info) {
            titles[infoIndex] = info["title"];
            mp3s[infoIndex] = info["mp3"];
        })
    })
};

$(function(){
    getTitles(titles, mp3s);
    setTimeout(function () {
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
    }, 500);
});