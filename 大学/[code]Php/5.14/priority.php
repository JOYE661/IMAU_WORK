<?php
trait Eat
{
    public function eat()
    {
        echo 'Eat::eat';
    }
}
class Human
{
    public function eat()
    {
        echo 'Human::eat';
    }
}
class Man extends Human
{
    use Eat; 
    public function eat()
    {
        echo 'Man::eat';
    }
}
$man = new Man();
$man->eat();			// Man::eat
