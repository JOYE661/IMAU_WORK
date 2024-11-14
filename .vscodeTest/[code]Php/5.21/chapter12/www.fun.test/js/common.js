/* 侧边栏跟随 */
(function(){
    var doc = $(document), slide = $('.js-slide');
    $(window).scroll(function(){
        if ((doc.height() > slide.height() + 200) && doc.scrollTop() >= 175) {slide.addClass('wp-r-fixed');} else {slide.removeClass('wp-r-fixed');}
        if ($(this).height() < slide.height() && (doc.scrollTop() >= doc.height() - $(this).height() - 80)) {slide.addClass('wp-r-fixed-bottom');} else {slide.removeClass('wp-r-fixed-bottom');}
    });
})();
/* 发布内容 增加、删除 */
(function(){
    $('.js-post-add').click(function(){
        var li = $(this).parents('li'), obj = li.clone(true), lim = parseInt($('input[name=atch_max]').val());
        if (li.siblings().length + 1 >= lim) { alert('最多只能添加' + lim + '个。'); } else { obj.find('input').val(''); li.after(obj); }
    });
    $('.js-post-del').click(function(){
        if ($(this).parents('ul').find('li').length > 1) {
            $(this).parents('li').remove();
        } else {
            alert('已经是最后一个了。');
        }
    });
    $('.js-post-ck').click(function(){
        var obj = $(this).parents('li');
        if ($(this).is(':checked')) {obj.addClass('curr');} else {obj.removeClass('curr');}
    });
    $('.js-post-confirm').click(function(){
        return confirm('您确认要执行此操作？');
    });
})();
/* 栏目管理 */
(function(){
    $('.js-cate-disable').click(function(){
        var obj = $(this).parents('tr');
        var checked = $(this).is(':checked');
        obj.find('input[name^=save]').prop('disabled', checked);
        obj.find('.js-cate-ck').prop('checked', checked).prop('disabled', checked);
        checked ? obj.find('.edit-cate-file').addClass('curr') : obj.find('.edit-cate-file').removeClass('curr');
    });
    var newid = 1;
    $('.js-cate-add').click(function(){
        var obj = $('.js-cate-new').clone();
        obj.removeClass('hide js-cate-new');
        obj.html(obj.html().replace(/_ID_/g, newid++));
        obj.find('.js-cate-cancel').click(function(){
            $(this).parents('tr').remove();
        });
        obj.find('input[name^=add]').removeAttr('disabled');
        $(this).parents('tr').before(obj);
    });
    $('.js-cate-ck').change(function(){
        var obj = $(this).parents('td');
        if ($(this).is(':checked')) {obj.addClass('curr');} else {obj.removeClass('curr');}
    });
})();
/* 登录与注册 */
(function(){
    /* 两次输入密码判断 */
    $('#js-regform').submit(function(event){
        if ($('#js-pw1').val() !== $('#js-pw2').val()) {
            alert('两次输入密码不一致！');
            event.preventDefault();
        }
    });
    /* 验证码单击切换 */
    var captcha = $('.js-captcha'),src = captcha.attr('src');
    captcha.click(function(){
        $(this).attr('src', src + '?_=' + Math.random());
    });
})();