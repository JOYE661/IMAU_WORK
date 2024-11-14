<?php
echo nl2br("123\n456", false);
echo '<br>';

$html = <<<'EOD'
<ul><li>苹果</li><li>香蕉</li></ul>
<test>橘子</test><aaa>草莓
EOD;
echo strip_tags($html);
echo '<br>';

$html = "123<br>4'56";
$html = htmlspecialchars($html, ENT_QUOTES | ENT_HTML5);
echo "转换后:" . $html, "\n";
echo '<br>';

$str = htmlspecialchars_decode($html, ENT_QUOTES | ENT_HTML5);
echo "还原后:" . $str;
echo '<br>';

$name = 'A&B C';
$name = urlencode($name);
echo "编码后:" . "http://localhost/test.php?name=$name", "\n";
echo '<br>';

echo "解码后:" . urldecode($name);

$params = [
    'name' => 'test',
    'hobby' => ['reading', 'running']
];
$query = http_build_query($params);
echo "http://localhost/test.php?$query";
