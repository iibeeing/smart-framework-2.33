$(function() {
/*    var validator = new Validator();

    $('#user_create_form').ajaxForm({
        type: 'post',
        url: BASE + '/user/create',
        beforeSubmit: function() {
            return validator.required('user_create_form');
        },
        success: function(result) {
            if (result.success) {
                location.href = BASE + '/user';
            }
        }
    });
*/
    $('#cancel').click(function() {
        location.href = BASE + '/users';
    });
});