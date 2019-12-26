
var max_tab_len=5;

//选择菜单
$(".page_url").click(function () {
    var url=$(this).attr("url");
    var tab_pane_len=$(".tab-pane").length;
    var last_url=$("#myTab >.active > a").attr("url");

    var addTable=tab_restore(url);

    if(tab_pane_len>=5 && addTable){
        alert("最多"+max_tab_len+"个标签页");
        tab_restore(last_url);
        return;
    }
    if(addTable){
        addIfrme(this);
    }
});

//删除tab
function x(ele) {
    var id=$(ele).prev().attr("href");
    var tab_pane_len=$("#myTab >li >a").length;
    var last_table=false;
    $("#myTab >li").each(function () {
        if($(this).find("a").attr("href")==id){
            if("#"+tab_pane_len==id){
                last_table=true;
            }
            $(this).remove();
            return false;
        }
    });

    $("#myTabContent >div").each(function () {
        if(("#"+$(this).attr("id")==id)){
            $(this).remove();
            return false
        }
    });
    if(last_table){
        var tab_pane_len=$("#myTab >li >a").length;
        var   tab_pan =$("#myTab >li >a");
        var elel=tab_pan.eq(tab_pane_len-1);
        tab_restore($(elel).attr("url"));
    }
}


//选择复位
function  tab_restore(url) {
    var addTable=true;
    var index="#0";
    $("#myTab >li").each(function () {
        if($(this).find("a").attr("url")==url){
           addTable=false;
           index=$(this).find("a").attr("href");
            $(this).attr("class","active")
        }else {
            $(this).attr("class","")
        }
    });
    $("#myTabContent >div").each(function () {
        if("#"+$(this).attr("id")==index){
            $(this).attr("class","tab-pane fade active in")
        }else {
            $(this).attr("class","tab-pane fade")
        }
    });

    return addTable;
}

function  addIfrme(ele) {
    var pingao=$(".left_col").height();
    var tougao=$(".nav_menu").height();
    var pingmu=pingao-tougao-60;
    var tab_pane_len=$(".tab-pane").length;
    tab_pane_len+=1;
    var url=$(ele).attr("url");
    var name=$(ele).text();
    var li='<li role="presentation" class="active"><a href="#'+tab_pane_len+'" url="'+url+'" role="tab"  data-toggle="tab" aria-expanded="false">'+name+'</a><em onclick="x(this)">x</em>' +
        '          </li>';
    var div='<div role="tabpanel" class="tab-pane fade active in" id="'+tab_pane_len+'" aria-labelledby="profile-tab">' +
        '            <div class="right_col" role="main">' +
        '              <iframe width="100%" frameborder="0"  src="/page.do?url='+url+'" style="min-height: '+pingmu+'px;"></iframe>' +
        '            </div>' +
        '          </div>';

    $("#myTab").append(li);
    $("#myTabContent").append(div);
}


