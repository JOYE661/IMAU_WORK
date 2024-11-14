<?php
class People
{
    public static $name = 'People';
    public static function showName()
    {
        echo self::$name;		// 静态绑定
        echo static::$name;		// 静态延迟绑定
    }
}

class Man extends People
{
    public static $name = 'Man';
}

People::showName();				// People People
Man::showName();				// People Man
