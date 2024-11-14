<?php
/**
  * 分页链接生成函数
  * @param int $page URL传递的page值
  * @param int $max_page 最大页码值
  */
function makePageHtml($page, $max_page) {
    // 删除GET参数中的page
    unset($_GET['page']);
    // 重新生成URL中的GET参数
    $params = http_build_query($_GET);
    if ($params) {
        $params .= '&';
    }
    // 计算下一页
    $next_page = $page + 1;
    // 判断下一页的页码是否大于最大页码值，如果大于则把最大页码值赋值给它
    if ($next_page > $max_page) {
        $next_page =  $max_page;
    }
    // 计算上一页
    $prev_page = $page - 1;
    // 判断上一页的页码是否小于1，如果小于则把1赋值给它
    if ($prev_page < 1) {
        $prev_page = 1;
    }
    // 重新拼接分页链接的html代码
    $page_html = '<a href="?' . $params . 'page=1">首页</a>';
    $page_html .= '<a href="?' . $params . 'page=' . $prev_page . '">上一页</a>';
    $page_html .= '<a href="?' . $params . 'page=' . $next_page . '">下一页</a>';
    $page_html .= '<a href="?' . $params . 'page=' . $max_page . '">尾页</a>';
    // 返回分页链接
    return $page_html;
}
