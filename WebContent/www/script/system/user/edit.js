$(function() {
    var validator = new Validator();

    $('#user_edit_form').ajaxForm({
        type: 'put',
        url: BASE + '/user/' + $('#id').val(),
        beforeSubmit: function() {
            return validator.required('user_edit_form');
        },
        success: function(result) {
            console.log(result);
            if (result.success) {
                location.href = BASE + '/users';
            }
        }
    });

    $('#cancel').click(function() {
        location.href = BASE + '/users';
    });
});