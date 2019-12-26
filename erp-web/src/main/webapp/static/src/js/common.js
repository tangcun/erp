/**
 2  * JS/CSS文件导入
 3  * @param filePath　文件路径
 4  * @param fileType　文件类型（js、css）
 5  * @return
 6  */
function loadJsOrCssFile(filePath) {

    var isJsFile = /js$/i.test(filePath);
    var fileType = isJsFile ? "js" : "css";

    if (isIncludeFile(filePath, isJsFile)) {
        return;
    }

    if (fileType == "js") {

        var fileRef = document.createElement('script')
        fileRef.setAttribute("type", "text/javascript")
        fileRef.setAttribute("src", filePath)
    } else if (fileType == "css") {

        var fileRef = document.createElement("link")
        fileRef.setAttribute("rel", "stylesheet")
        fileRef.setAttribute("type", "text/css")
        fileRef.setAttribute("href", filePath)
    }

    if (typeof fileRef != "undefined") {

        document.getElementsByTagName("head")[0].appendChild(fileRef)
    }
  //  document.getElementsByTagName("head")[0].appendChild(fileRef)
}

/**
 * 判断JS/CSS文件是否导入
 * @param fileName　文件名
 * @return 是否导入
 */
function isIncludeFile(fileName, isJsFile) {

    var fileRefArray = document.getElementsByTagName(isJsFile ? 'script' : 'link');
    for (var i = 0, len = fileRefArray.length; i < len; i++) {
        if (fileRefArray[i][isJsFile ? 'src' : 'href'].indexOf(fileName) != -1) return true;
    }
    return false;
}

// // 基础路径（绝对路径）
// var basePath = "/smilenursecare/view/";
// // JS文件存放路径（绝对路径）
// var basePathJs = "/smilenursecare/view/js/";
// // CSS文件存放路径（绝对路径）
// var basePathCss = "/smilenursecare/view/css/";


// <!-- Bootstrap -->
// <script src="/static/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
//     <!-- bootstrap-progressbar -->
//     <script src="/static/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
//     <!-- Custom Theme Scripts -->
//     <script src="/static/build/js/custom.min.js"></script>
//     <!-- FastClick -->
//     <script src="/static/vendors/fastclick/lib/fastclick.js"></script>
//     <!-- NProgress -->
//     <script src="/static/vendors/nprogress/nprogress.js"></script>
//     <!-- Chart.js -->
//     <script src="/static/vendors/Chart.js/dist/Chart.min.js"></script>
//     <!-- gauge.js -->
//     <script src="/static/vendors/gauge.js/dist/gauge.min.js"></script>
//     <!-- iCheck -->
//     <script src="/static/vendors/iCheck/icheck.min.js"></script>
//     <!-- Skycons -->
//     <script src="/static/vendors/skycons/skycons.js"></script>
//     <!-- Flot -->
//     <script src="/static/vendors/Flot/jquery.flot.js"></script>
//     <script src="/static/vendors/Flot/jquery.flot.pie.js"></script>
//     <script src="/static/vendors/Flot/jquery.flot.time.js"></script>
//     <script src="/static/vendors/Flot/jquery.flot.stack.js"></script>
//     <script src="/static/vendors/Flot/jquery.flot.resize.js"></script>
//     <!-- Flot plugins -->
//     <script src="/static/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
//     <script src="/static/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
//     <script src="/static/vendors/flot.curvedlines/curvedLines.js"></script>
//     <!-- DateJS -->
//     <script src="/static/vendors/DateJS/build/date.js"></script>
//     <!-- JQVMap -->
//     <script src="/static/vendors/jqvmap/dist/jquery.vmap.js"></script>
//     <script src="/static/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
//     <script src="/static/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
//     <!-- bootstrap-daterangepicker -->
//     <script src="/static/vendors/moment/min/moment.min.js"></script>
//     <script src="/static/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

// 导入选项卡相关的JS和CSS
function loadTabsFile() {
    loadJsOrCssFile( "/static/vendors/jquery/dist/jquery.min.js");
    <!-- Bootstrap -->
    loadJsOrCssFile( "/static/vendors/bootstrap/dist/js/bootstrap.min.js");
        <!-- bootstrap-progressbar -->
    loadJsOrCssFile( "/static/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js");
        <!-- Custom Theme Scripts -->
    loadJsOrCssFile( "/static/build/js/custom.min.js");
        <!-- FastClick -->
    loadJsOrCssFile( "/static/vendors/fastclick/lib/fastclick.js");
        <!-- NProgress -->
    loadJsOrCssFile( "/static/vendors/nprogress/nprogress.js");
        <!-- Chart.js -->
    loadJsOrCssFile( "/static/vendors/Chart.js/dist/Chart.min.js");
        <!-- gauge.js -->
    loadJsOrCssFile( "/static/vendors/gauge.js/dist/gauge.min.js");
        <!-- iCheck -->
    loadJsOrCssFile( "/static/vendors/iCheck/icheck.min.js");
        <!-- Skycons -->
    loadJsOrCssFile( "/static/vendors/skycons/skycons.js");
        <!-- Flot -->
    loadJsOrCssFile( "/static/vendors/Flot/jquery.flot.js");
    loadJsOrCssFile( "/static/vendors/Flot/jquery.flot.pie.js");
    loadJsOrCssFile( "/static/vendors/Flot/jquery.flot.time.js");
    loadJsOrCssFile( "/static/vendors/Flot/jquery.flot.stack.js");
    loadJsOrCssFile( "/static/vendors/Flot/jquery.flot.resize.js");
        <!-- Flot plugins -->
    loadJsOrCssFile( "/static/vendors/flot.orderbars/js/jquery.flot.orderBars.js");
    loadJsOrCssFile( "/static/vendors/flot-spline/js/jquery.flot.spline.min.js");
    loadJsOrCssFile( "/static/vendors/flot.curvedlines/curvedLines.js");
        <!-- DateJS -->
    loadJsOrCssFile( "/static/vendors/DateJS/build/date.js");
        <!-- JQVMap -->
    loadJsOrCssFile( "/static/vendors/jqvmap/dist/jquery.vmap.js");
    loadJsOrCssFile( "/static/vendors/jqvmap/dist/maps/jquery.vmap.world.js");
    loadJsOrCssFile( "/static/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js");
        <!-- bootstrap-daterangepicker -->
    loadJsOrCssFile( "/static/vendors/moment/min/moment.min.js");
    loadJsOrCssFile( "/static/vendors/bootstrap-daterangepicker/daterangepicker.js");
}
