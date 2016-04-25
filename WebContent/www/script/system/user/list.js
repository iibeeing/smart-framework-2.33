/*$(function() {
    $('.ext-user-delete').click(function() {
        var $tr = $(this).closest('tr');
        var customerId = $tr.data('id');
        var customerName = $tr.data('name');
        if (confirm('您想删除用户 [' + customerName + ']?')) {
            $.ajax({
                type: 'delete',
                url: BASE + '/user/' + customerId,
                success: function(result) {
                    if (result.success) {
                        $tr.remove();
                        alert("用户：" + customerName + "删除成功！");
                    }
                }
            });
        }
    });
});*/

$(function() {
    // 清空会话存储
    window.sessionStorage.removeItem('user.id');

    // 定义对象
    var userTable = new UserTable();

    // 查看
/*    $(document).on('click', '.ext-product-view', function() {
        var $tr = $(this).closest('tr');
        var productId = $tr.data('id');
        window.sessionStorage.setItem('product.id', productId);
        location.href = 'product_view.html';
    });*/

    // 编辑
/*    $(document).on('click', '.ext-product-edit', function() {
        var $tr = $(this).closest('tr');
        var productId = $tr.data('id');
        window.sessionStorage.setItem('product.id', productId);
        location.href = 'product_edit.html';
    });*/

    // 删除
    $('.ext-user-delete').click(function() {
        var $tr = $(this).closest('tr');
        var customerId = $tr.data('id');
        var customerName = $tr.data('name');
        if (confirm('您想删除用户 [' + customerName + ']?')) {
            $.ajax({
                type: 'delete',
                url: BASE + '/user/' + customerId,
                success: function(result) {
                    if (result.success) {
                        $tr.remove();
                        alert("用户：" + customerName + "删除成功！");
                    }
                }
            });
        }
    });

    // 查询
    $('#user_search_form').submit(function() {
    	userTable.load(1);
        return false;
    });
});

var UserTable = function() {
    // 定义对象
    var pager = new Pager('user_pager', this);
    var renderer = new Renderer();

    // 初始化
    (function() {
        $.ajax({
            type: 'get',
            url: BASE + '/users',
            success: function(result) {
                render(result);
            }
        });
    })();

    // 加载
    this.load = function(pageNumber) {
        $.ajax({
            type: 'post',
            url: BASE + '/user/search',
            data: {
                'pageNumber': pageNumber,
                'pageSize': $.trim($('#user_pager').find('.ext-pager-ps').val()),
                'queryString': 'userName:' + $.trim($('#user_name').val())
            },
            success: function(result) {
                render(result);
            }
        });
    };

    // 渲染
    var render = function(result) {
        if (result.success) {
            var data = result.data;
            renderTable(data);
            renderPager(data);
        }
    };

    // 渲染表格
    var renderTable = function(data) {
        var template = $('#user_table_template').html();
        var tableHTML = '';
        $.each(data.recordList, function(i, user) {
            tableHTML += renderer.render(template, user);
        });
        $('#user_table').find('tbody').html(tableHTML);
    };

    // 渲染分页
    var renderPager = function(data) {
        pager.render(data);
    };
};