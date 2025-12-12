function commentsvote_up(comment_id,nonce) {
 
    jQuery.ajax({
        type: 'POST',
        url: votecommentajax.ajaxurl,
        data: {
            action: 'commentsvote_up_ajaxhandler',
            commentid: comment_id,
            nonce: nonce
        },
        success: function(data, textStatus, XMLHttpRequest) {
            var linkofcomment1 = '#thiscomment-' + comment_id + '-best';
            var linkofcomment2 = '#thiscomment-' + comment_id;
            var votecount1 = linkofcomment1 + ' .votecount';
            var votecount2 = linkofcomment2 + ' .votecount';
            var votelinks1 = linkofcomment1 + ' .votebtn';
            var votelinks2 = linkofcomment2 + ' .votebtn';
            var thevote = '';
            if (data > 0) {
                thevote = "+"+data;
            }else if (data < 0){
                thevote = data;
            }else{
                thevote = "0";
            }
            jQuery(votecount1).html('');
            jQuery(votecount2).html('');
            jQuery(votecount1).append(thevote)
            jQuery(votecount2).append(thevote);
            jQuery(votelinks1).addClass('disabled').removeAttr('onclick');
            jQuery(votelinks2).addClass('disabled').removeAttr('onclick');
        },
        error: function(MLHttpRequest, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
 
}

function commentsvote_down(comment_id,nonce) {
 
    jQuery.ajax({
        type: 'POST',
        url: votecommentajax.ajaxurl,
        data: {
            action: 'commentsvote_down_ajaxhandler',
            commentid: comment_id,
            nonce: nonce
        },
        success: function(data, textStatus, XMLHttpRequest) {
            var linkofcomment1 = '#thiscomment-' + comment_id + '-best';
            var linkofcomment2 = '#thiscomment-' + comment_id;
            var votecount1 = linkofcomment1 + ' .votecount';
            var votecount2 = linkofcomment2 + ' .votecount';
            var votelinks1 = linkofcomment1 + ' .votebtn';
            var votelinks2 = linkofcomment2 + ' .votebtn';
            var thevote = '';
            if (data > 0) {
                thevote = "+"+data;
            }else if (data < 0){
                thevote = data;
            }else{
                thevote = "0";
            }
            jQuery(votecount1).html('');
            jQuery(votecount2).html('');
            jQuery(votecount1).append(thevote);
            jQuery(votecount2).append(thevote);
            jQuery(votelinks1).addClass('disabled').removeAttr('onclick');
            jQuery(votelinks2).addClass('disabled').removeAttr('onclick');
        },
        error: function(MLHttpRequest, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
 
}