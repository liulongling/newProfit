/**
 * 修改模态框的操作
 */

// 修改模态框显示位置
function changeModalDialogLocation(node) {
    node.on('show.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        let modalHeight=$(window).height() / 2 - node.find('.modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
}

// 设置模态框可拖动
function dragTheModalDialog() {
    $(".modal").each((index, element) => changeModalDialogLocation($(element)));

    // 在模态框出现后添加可拖拽功能
    $(document).on("show.bs.modal", ".modal", function() {
        // draggable 属性规定元素是否可拖动
        $(this).draggable({
            handle: ".modal-header", // 只能点击头部拖动
            cursor: 'move' // 光标呈现为指示链接的指针（一只手）,
        });
        $(this).css("overflow", "hidden"); // 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
    });
}