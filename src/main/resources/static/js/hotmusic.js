var titles = new Array();
var mp3s = new Array();
//读取json文件
function getTitles () {
    $.getJSON("/FMusic/json/list.json", function (data) {
        $.each(data, function (infoIndex, info) {
            titles[infoIndex] = info["title"];
            mp3s[infoIndex] = info["mp3"];
        })
    })
};

//初始化数组
function getJson() {
    getTitles();
    alert("1");
    var json = "[";
    for(var i=0; i<titles.length; i++){
        json += '{"mp3":"'+mp3s[i]+'" , "title":"'+titles[i]+'"},'
    }
    //返回初始化的json字符串
    return json;
};

$(document).ready(function(){
    var json = getJson();
    //截掉json字符串的最后一位字符
    json = json.substr(0, json.length - 1);
    json = json + "]";
    //将json字符串转化为json对象
    json = JSON.parse(json);
    var description = 'Welcome FMusic';
    $('body').ttwMusicPlayer(json, {
        autoPlay:false,
        description:description,
        jPlayer:{
            swfPath: '/js/jplayer'
        }
    });
});
