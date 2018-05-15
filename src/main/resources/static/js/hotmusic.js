$(document).ready(function(){

    var description = 'Welcome FMusic';
    var myPlaylist = [
        {
            mp3:'auto/we.mp3',
            title:'我们-陈奕迅',
            artist:'FMusic',
            rating:4,
            buy:'#',
            duration:'2:30',
            cover:'auto/1.png'
        },
        {
            mp3:'auto/zdqc.mp3',
            title:'纸短情长',
            artist:'FMusic',
            rating:4,
            buy:'#',
            duration:'2:31',
            cover:'auto/1.png'
        },
        {
            mp3:'auto/qxzc.mp3',
            title:'裙下之臣-陈奕迅',
            artist:'FMusic',
            rating:4,
            buy:'#',
            duration:'2:10',
            cover:'auto/1.png'
        },
    ];

    $('body').ttwMusicPlayer(myPlaylist, {
        autoPlay:false,
        description:description,
        jPlayer:{
            swfPath: '/js/jplayer'
        }
    });
});
