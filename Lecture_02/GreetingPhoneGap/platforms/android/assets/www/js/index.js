var app = {
    initialize: function () {
        var self = this;
        $( "#greeting" ).click(function() {
            var name = $('#name').val() ? $('#name').val() : 'John Doe';
            self.showAlert('Hi, ' + name + ' :)', null);
        });
    },

    showAlert: function (message, title) {
        alert(title ? (title + ": " + message) : message);
    }
};
