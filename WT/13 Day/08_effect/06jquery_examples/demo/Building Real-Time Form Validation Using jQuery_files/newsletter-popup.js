jQuery(document).ready(function($){
    var wd1_nlpopup_expires = $("#wd1_nlpopup").data("expires");
    var wd1_nlpopup_delay = $("#wd1_nlpopup").data("delay") * 1000;

    $('#wd1_nlpopup_close').on('click', function(e){
        $.cookie('wd1_nlpopup', 'closed', { expires: wd1_nlpopup_expires, path: '/' });
        $('#wd1_nlpopup,#wd1_nlpopup_overlay').fadeOut(200);
        e.preventDefault();
    });

    if($.cookie('wd1_nlpopup') != 'closed' ){
        setTimeout(wd1_open_nlpopup, wd1_nlpopup_delay);
    }

    function wd1_open_nlpopup(){
        var topoffset = $(document).scrollTop(),
            viewportHeight = $(window).height(),
            $popup = $('#wd1_nlpopup');
        var calculatedOffset = (topoffset + (Math.round(viewportHeight/2))) - (Math.round($popup.outerHeight()/2));

        if(calculatedOffset <= 40){
            calculatedOffset = 40;
        }

        $popup.css('top', calculatedOffset);
        $('#wd1_nlpopup,#wd1_nlpopup_overlay').fadeIn(500);
    }

});



/* jQuery Cookie Plugin v1.3.1 */
(function(a){if(typeof define==="function"&&define.amd){define(["jquery"],a);}else{a(jQuery);}}(function(e){var a=/\+/g;function d(g){return g;}function b(g){return decodeURIComponent(g.replace(a," "));}function f(g){if(g.indexOf('"')===0){g=g.slice(1,-1).replace(/\\"/g,'"').replace(/\\\\/g,"\\");}try{return c.json?JSON.parse(g):g;}catch(h){}}var c=e.cookie=function(p,o,u){if(o!==undefined){u=e.extend({},c.defaults,u);if(typeof u.expires==="number"){var q=u.expires,s=u.expires=new Date();s.setDate(s.getDate()+q);}o=c.json?JSON.stringify(o):String(o);return(document.cookie=[c.raw?p:encodeURIComponent(p),"=",c.raw?o:encodeURIComponent(o),u.expires?"; expires="+u.expires.toUTCString():"",u.path?"; path="+u.path:"",u.domain?"; domain="+u.domain:"",u.secure?"; secure":""].join(""));}var g=c.raw?d:b;var r=document.cookie.split("; ");var v=p?undefined:{};for(var n=0,k=r.length;n<k;n++){var m=r[n].split("=");var h=g(m.shift());var j=g(m.join("="));if(p&&p===h){v=f(j);break;}if(!p){v[h]=f(j);}}return v;};c.defaults={};e.removeCookie=function(h,g){if(e.cookie(h)!==undefined){e.cookie(h,"",e.extend(g,{expires:-1}));return true;}return false;};}));