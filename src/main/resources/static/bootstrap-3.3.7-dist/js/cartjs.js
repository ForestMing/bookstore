//修改图书购物车数量
$(function() {
    $(".btn-default").click(function () {
        var userid = /*[[${currentCus.customerid}]]*/ 'null';
        var bookid = $(this).parent().parent().find('input:eq(0)').val();
        var price = $(this).parent().parent().find('td:eq(3)').text();
        var ispaid = 'no' ;
        //暴力获取更改数量
        var tr = $(this).parent().parent();
        var td = tr.find('td:eq(5)');
        var div = td.find('div:eq(0)');
        //获取数量框修改后数量
        var n = div.find('input:eq(1)').val();

        var json = {
            'customerid':userid,
            'bookid':bookid,
            'ordermount':n,
            'price':price,
            'ispaid':ispaid
        };

        console.log(json) ;

        //封装成json对象
        var postdata = JSON.stringify(json);
        console.log(postdata);

        $.ajax({
            url: "chngNum",
            data: postdata,
            type: "POST",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                if(data == "changeSuccess"){
                    location.reload();
                }
                if(data == "changeFail"){
                    alert("操作错误");
                }
            },
            error:function(error){alert(error);}
        });

    }) ;
});

//数量选择框事件
$(function () {

    $(".add").click(function () {
        // $(this).prev() 就是当前元素的前一个元素，即 text_box
        $(this).prev().val(parseInt($(this).prev().val()) + 1);
        setTotal($(this).prev().val());
    });

    $(".min").click(function () {
        // $(this).next() 就是当前元素的下一个元素，即 text_box
        if($(this).next().val() == 0 ){
            $(this).next().val(0);
        }else{
            $(this).next().val(parseInt($(this).next().val()) - 1);
        }
        setTotal($(this).next().val());
    });

});

//全选反选按钮事件
$(function () {
    //实现全选反选
    $("#checkAll").on('click', function () {
        $("tbody input:checkbox").prop("checked", $(this).prop('checked'));
    })
    $("tbody input:checkbox").on('click', function () {
        //当选中的长度等于checkbox的长度的时候,就让控制全选反选的checkbox设置为选中,否则就为未选中
        if ($("tbody input:checkbox").length === $("tbody input:checked").length) {
            $("#checkAll").prop("checked", true);
        } else {
            $("#checkAll").prop("checked", false);
        }
    })
});

//删除所选项
$(function(){
    $("#deleteSelct").click(function () {
        var userid = /*[[${currentCus.customerid}]]*/ 'null';
        var v2 = $("input[type='checkbox'][name='test']:checked").closest('tr').find('td:eq(2)').map(function(){return this.innerHTML}).get().join();
        //   var v2 = $("input[type='checkbox'][name='test']:checked").closest('tr').find('input:eq(0)').val() ;
        console.log(typeof v2) ; // string
        //   var v = $("input[type='checkbox'][name='test']:checked").closest('tr').find('td:eq(2)').map(function(){return this.innerHTML}).get();
        //    console.log(typeof v ); // object
        //   var v3 = "StandarkString";
        //   console.log(typeof v3) ;
        //  for(key in v ){
        //       console.log(key+":"+v[key]);
        //  }

        var str = "";
        str = JSON.stringify(v2);
        console.log(str);

        $.ajax({
            url: "deletecart",
            data: {"linked": str ,"cusid":userid},
            type: "POST",
            success: function (data) {
                if(data == "ok"){
                    location.reload();
                }else if(data == "noSelect"){

                }
            },
            error:function(error){alert(error);}
        });

    }) ;
});

