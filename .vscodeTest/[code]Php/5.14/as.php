<?php
trait t1
{
    public function sleep()
    {
        echo 'sleep';
    }
}
class Person
{
    use t1 {
        sleep as private s;
    }
}
$person = new Person();

$person->sleep(); 	// sleep

$person->s();		// Fatal error: Uncaught Error:Call to private...

