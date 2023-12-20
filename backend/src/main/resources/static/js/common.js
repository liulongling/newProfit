/**
 * 渲染表格要用到的常用代码封装
 */



// 初始化表格
function initTable(node, url, pageList, queryParams, columns, toolbar = '#toolbar') {
    node.bootstrapTable("destroy");         // 先销毁用来的表格再构造新的表格
    node.bootstrapTable({
        toolbar: toolbar,                   // 工具按钮用哪个容器
        method: 'get',                      // 请求方式
        url: url,                           // 请求路径
        dataType: "json",                   // 服务器返回的数据类型
        contentType: "application/json",    // 发送到服务器的数据编码类型
        striped: true,                     // 是否显示行间隔色
        cache: false,                      // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                  // 是否显示分页（*）
        sortable: false,                   // 是否启用排序
        sortOrder: "asc",                   // 排序方式
        sidePagination: "server",           // 分页方式：client客户端分页，server服务端分页（*）
        queryParamsType: "limit",           // 设置为 ‘limit’ 则会发送符合 RESTFul 格式的参数
        pageNumber: 1,                      // 初始化加载第一页，默认第一页
        pageSize: 15,                       // 每页的记录行数（*）
        pageList: pageList,                 // 可供选择的每页的行数（*）
        showColumns: true,                 // 是否显示所有的列
        showRefresh: true,                 // 是否显示刷新按钮
        minimumCountColumns: 2,             // 最少允许的列数
        clickToSelect: false,               // 是否启用点击选中行
        showToggle:true,                   // 是否显示详细视图和列表视图的切换按钮
        cardView: false,                   // 是否显示详细视图
        detailView: false,                 // 是否显示父子表
        uniqueId: "id",                     // 每一行的唯一标识，一般为主键列
        dataField: "rows",                  // 这是返回的json数组的key.默认好像是"rows".这里只要前后端约定好就行
        queryParams: queryParams,
        responseHandler: result => {
            if (result.success === false) {
                switch (result.code) {
                    case 9001: swal("错误", "数据库错误", "error");   break;
                    case 9002: swal("错误", "参数错误", "error");     break;
                    case 9999: swal("错误", "系统错误", "error");     break;
                }
                return null;
            } else {
                return { total: result.total, rows: result.rows, };
            }
        },
        columns: columns,
        rowStyle: function (row, index) {
            let classesArr = ['info', '#ffffff'];
            let strClass = "";
            if (index % 2 === 0) {  // 偶数行
                strClass = classesArr[0];
            } else {    // 奇数行
                strClass = classesArr[1];
            }
            return { classes: strClass };
        }// 隔行变色
    });
}

// 弹出框
function dialog(message, callback) {
    swal(message, {
        buttons: {
            true: "确定",
            cancel: "取消"
        },
    }).then((value) => {
        switch (value) {
            case "true":
                callback();
                break;
            default:
                break;
        }
    });
}

// 修改提示框样式
function changeToolTip() {
    $(function() {
        $( document ).tooltip({
            position: {
                my: "center bottom-20",
                at: "center top",
                using: function( position, feedback ) {
                    $( this ).css( position );
                    $( "<div>" )
                        .addClass( "arrow" )
                        .addClass( feedback.vertical )
                        .addClass( feedback.horizontal )
                        .appendTo( this );
                }
            },
            show: {
                effect: "slideDown",
                delay: 250
            },
            hide: {
                effect: "explode",
                delay: 250
            }
        });

        $("select").on("select2:close", () => $("[role=tooltip]").remove());
    });
}

// 有参数请求
function parameterPostRequest(url, data, callback, method = "POST") {
    $.ajax({
        type: method,
        url: url,
        dataType: "json",
        data: JSON.stringify(data),
        traditional: true,
        contentType : "application/json",
        success: function (result) {
            if (result.success === false) {
                switch (result.code) {
                    case 9001: swal("错误", "数据库错误", "error");   break;
                    case 9002: swal("错误", "参数错误", "error");     break;
                    case 9999: swal("错误", "系统错误", "error");     break;
                }
            } else {
                callback(result);
            }
        },
        error: function () {
            swal("错误", "404", "error");
        }
    });
}

// 有参数请求
function echartsParameterPostRequest(url, data, callback, method = "POST") {
    $.ajax({
        type: method,
        url: url,
        dataType: "json",
        data: JSON.stringify(data),
        traditional: true,
        contentType : "application/json",
        success: function (result) {
            if (result.success === false) {
                switch (result.code) {
                    case 9001: swal("错误", "数据库错误", "error");   break;
                    case 9002: swal("错误", "参数错误", "error");     break;
                    case 9999: swal("错误", "系统错误", "error");     break;
                }
            } else {
                option = {
                      title: {
                        text: result.module.text
                      },
                      tooltip: {
                        trigger: 'axis'
                      },
                      legend: {
                        data: result.module.legend
                      },
                      grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                      },
                      toolbox: {
                        feature: {
                          saveAsImage: {}
                        }
                      },
                      xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: result.module.xaxis
                      },
                      yAxis: {
                        type: 'value'
                      },
                      series: result.module.series
                    };
                callback(option);
            }
        },
        error: function () {
            swal("错误", "404", "error");
        }
    });
}


// 有参数请求
function parameterGetRequest(url, data, callback, method = "GET") {
    $.ajax({
        type: method,
        url: url,
        dataType: "json",
        data: JSON.stringify(data),
        traditional: true,
        contentType : "application/json",
        success: function (result) {
            if (result.success === false) {
                switch (result.code) {
                    case 9001: swal("错误", "数据库错误", "error");   break;
                    case 9002: swal("错误", "参数错误", "error");     break;
                    case 9999: swal("错误", "系统错误", "error");     break;
                }
            } else {
                callback(result);
            }
        },
        error: function () {
            swal("错误", "404", "error");
        }
    });
}

// UTC时间格式转换
function addZero(num) {
    return num < 10 ? '0' + num : num;
}
function formatDateTime(date) {
    let time = new Date(Date.parse(date));
    let Y = time.getFullYear() + '-';
    let M = this.addZero(time.getMonth() + 1) + '-';
    let D = this.addZero(time.getDate()) + ' ';
    let h = this.addZero(time.getHours()) + ':';
    let m = this.addZero(time.getMinutes()) + ':';
    let s = this.addZero(time.getSeconds());
    return Y + M + D + h + m + s;
}

// 普通数据处理
function stringFormatter(value) {
    return null === value ? "" : '<span title="'+ value +'">' + value +'</span>';
}

// 时间数据处理
function dateFormatter(value) {
    return null === value ? "" : '<span title="'+ formatDateTime(value) +'">' + formatDateTime(value) +'</span>';
}