<!doctype html>
<html>
<head>
<title>制作年历</title>
<style>
  body { text-align: center; }
  .box { margin: 0 auto; width: 880px; }
  table { height: 200px; width: 200px; font-size: 12px; text-align: center; float: left; margin: 10px; font-family: arial; }
  table tr:first-child { background: #ccc; }
</style>
</head>
<body>
<?php
function calendar($y)
{
    $w = date('w', strtotime("$y-1-1"));
    $html = '<div class="box">';
    // 输出12个月份的表格
    for ($m = 1; $m <= 12; ++$m) {
        $html .= '<table>';
        $html .= '<tr><th colspan="7">' . $y . ' 年 ' . $m . ' 月</th></tr>';
        $html .= '<tr><td>日</td><td>一</td><td>二</td><td>三</td><td>四</td>
                    <td>五</td><td>六</td></tr>';
        // 获取当前月份$m共有多少天
        $max = date('t', strtotime("$y-$m"));
        $html .= '<tr>';                		// 开始<tr>标签
        for ($d = 1; $d <= $max; ++$d) {
            if ($w && $d == 1) {        		// 如果该月的第1天不是星期日，则填充空白
                $html .= "<td colspan=\"$w\"> </td>";
            }
            $html .= "<td>$d</td>";
            if ($w == 6 && $d != $max) { 	    // 如果星期六不是该月的最后一天，则换行
                $html .= '</tr><tr>';
            } elseif ($d == $max) {     		// 该月的最后一天，闭合<tr>标签
                $html .= '</tr>';
            }
            $w = ($w + 1 > 6) ? 0 : $w + 1;
        }
        $html .= '</table>';
    }
    $html .= '</div>';
    return $html;
}
echo calendar('2021');
?>
</body>
</html>