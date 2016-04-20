$(function() {
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
});