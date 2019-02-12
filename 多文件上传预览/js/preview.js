function multiplePrivew(docObj) {

    var files = docObj.files;
    if (files) {
        $('#img_ul').find('li').remove();
        for (var i = 0; i < files.length; i++) {
            var img_ul = $('#img_ul');
            img_ul.append('<li><img src id="' + 'img_li' + i + '"/></li>');

            var img_li = $('#img_li' + i);
            //var img_li = document.getElementById('#img_li'+i);
            //火狐下，直接设img属性
            img_li.css('display', 'block').css('width', '300px').css('height', '200px');

            //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
            var fileUrl = window.URL.createObjectURL(files[i]);
            img_li.attr('src', fileUrl);
            img_li.attr('title', files[i].name);
        }
    } else {
        //IE下，使用滤镜
        docObj.select();
        var fileUrl = document.selection.createRange().text;

        var img_ul = document.getElementById('img_ul');

        var removeImgLi = document.getElementById('img_li0');

        if (removeImgLi != null) {
            img_ul.removeChild(removeImgLi);
        }

        var img_li = document.createElement('li');
        img_li.id = 'img_li0';
        var img = document.createElement('img');

        //必须设置初始大小
        img.style.width = '300px';
        img.style.height = '200px';
        img_ul.appendChild(img_li);
        img_li.appendChild(img)

        //图片异常的捕捉，防止用户修改后缀来伪造图片
        var imgLi = document.getElementById('img_li0');
        try {
            imgLi.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            imgLi.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = fileUrl;

        } catch (e) {
            alert("您上传的图片格式不正确，请重新选择!");
            alert(e);
            return false;
        }
        // imgLi.style.display = 'none';
        //  document.selection.empty();
    }
    return true;

}
