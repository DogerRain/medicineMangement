/*!
 * jquery.confirm
 *
 * @version 2.3.1
 *
 * @author My C-Labs
 * @author Matthieu Napoli <matthieu@mnapoli.fr>
 * @author Russel Vela
 * @author Marcus Schwarz <msspamfang@gmx.de>
 *
 * @license MIT
 * @url http://myclabs.github.io/jquery.confirm/
 */
(function ($) {

    /**
     * Confirm a link or a button
     * @param [options] {{title, text, confirm, cancel, confirmButton, cancelButton, post, confirmButtonClass}}
     */
    $.fn.confirm = function (options) {
        if (typeof options === 'undefined') {
            options = {};
        }

        this.click(function (e) {
            e.preventDefault();

            var newOptions = $.extend({
                button: $(this)
            }, options);

            $.confirm(newOptions, e);
        });

        return this;
    };    

    /**
     * Show a confirmation dialog
     * @param [options] {{title, text, confirm, cancel, confirmButton, cancelButton, post, confirmButtonClass}}
     * @param [e] {Event}
     */
    $.confirm = function (options, e) {
        // Do nothing when active confirm modal.
        if ($('.confirmation-modal').length > 0) {
            $('.confirmation-modal').remove();
        }

        // Parse options defined with "data-" attributes
        var dataOptions = {};
        if (options.button) {
            var dataOptionsMapping = {
                'title': 'title',
                'text': 'text',
                'confirm-button': 'confirmButton',
                'cancel-button': 'cancelButton',
                'confirm-button-class': 'confirmButtonClass',
                'cancel-button-class': 'cancelButtonClass'
            };
            $.each(dataOptionsMapping, function(attributeName, optionName) {
                var value = options.button.data(attributeName);
                if (value) {
                    dataOptions[optionName] = value;
                }
            });
        }

        // Default options
        var settings = $.extend({}, $.confirm.options, {
            confirm: function () {
                if (options.post) {
                    var url = e && (('string' === typeof e && e) || (e.currentTarget && e.currentTarget.attributes['href'] && e.currentTarget.attributes['href'].value));
                    if (url) {
                        if (options.post) {
                            var form = $('<form method="post" class="hide" action="' + url + '"></form>');
                            $(parent.document.body).append(form);
                            form.submit();
                        } else {
                            window.location = url;
                        }
                    }
                }
            },
            cancel: function (o) {
            },
            button: null
        }, dataOptions, options);

        // Modal
        var modalHeader = '';
        if (options.title != null) {
            modalHeader =
                '<div class=modal-header>' +
                    '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' +
                    '<h4 class="modal-title">' + settings.title+'</h4>' +
                '</div>';
        }

        var modalHTML =
                '<div class="confirmation-modal modal fade" tabindex="-1" role="dialog">' +
                    '<div class="modal-dialog" style="z-index:inherit;">' +
                        '<div class="modal-content">' + 
                            modalHeader +
                            '<div class="modal-body">' + settings.text + '</div>' +
                            '<div class="modal-footer">' +
                                '<button class="confirm btn ' + settings.confirmButtonClass + '" type="button" data-dismiss="modal" style="width:50px;">' +
                                    settings.confirmButton +
                                '</button>';

        if (options.cancelButton != null) {
            modalHTML += '<button class="cancel btn ' + settings.cancelButtonClass + '" type="button" data-dismiss="modal" style="width:50px;">' + settings.cancelButton + '</button>';
        }

        modalHTML += '</div></div></div></div>';

        var modal = $(modalHTML);

        modal.on('shown.bs.modal', function () {
            if ($(parent.document.body).find("#myAlert").length > 0) {
                $(parent.document.body).find("#myAlert").remove();
            }
        });
        modal.on('hidden.bs.modal', function () {
            if ($(parent.document.body).find("#myAlert").length > 0) {
                $(parent.document.body).find("#myAlert").remove();
            }
            modal.remove();
        });
        modal.find(".confirm").click(function () {
            settings.confirm(settings.button);
        });
        modal.find(".cancel").click(function () {
            settings.cancel(settings.button);
        });
        
        // Show the modal
        $(parent.document.body).append(modal);

        if (options.confirm != null)
            modal.modal({ backdrop: 'static', keyboard: false });           //点击确认框以外部分，确认框不会隐藏
        else
            modal.modal('show');                                            //点击提示框以外部分，提示框隐藏
    };

    /**
     * Globally definable rules
     */
    $.confirm.options = {
        text: "Are you sure?",
        title: "提示",
        confirmButton: "确定",
        cancelButton: "取消",
        post: false,
        confirmButtonClass: "btn-primary",
        cancelButtonClass: "btn-default"
    }


    var o_html = '<div id="myAlert" hidden="hidden"></div>';
    var o_alert = null;

    myAlert = function (message, title) {
        InitAlert();

        if (o_alert.length > 0) {
            o_alert.confirm({
                text: message,
                title: title,
                confirmButton: "确定",
                confirmButtonClass: "btn-primary",
            });

            o_alert.click();
        }
    };

    myAlertSuccess = function (message, callback, title) {
        InitAlert();

        if (o_alert.length > 0) {
            o_alert.confirm({
                text: message,
                title: title,
                confirm: function (button) {
                    callback();
                },
                confirmButton: "确定",
                confirmButtonClass: "btn-primary",
            });

            o_alert.click();
        }
    };

    myConfirm = function (message, callback, title) {
        InitAlert();

        if (o_alert.length > 0) {
            o_alert.confirm({
                text: message,
                title: title,
                confirm: function (button) {
                    callback();
                },
                confirmButton: "确定",
                cancelButton: "取消",
                confirmButtonClass: "btn-primary",
                cancelButtonClass: "btn-default"
            });

            o_alert.click();
        }
    };

    function InitAlert() {
        if ($(parent.document.body).find("#myAlert").length < 1) {
            $(parent.document.body).append($(o_html));
        }
        o_alert = $(parent.document.body).find("#myAlert");
    };
})(jQuery);