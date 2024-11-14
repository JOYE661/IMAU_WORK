<?php
class SessionDB implements SessionHandlerInterface
{
    private $link;
    
    public function __construct()
    {
        session_set_save_handler($this);
    }
   
    public function open($savePath, $sessionName)
    {
        $this->link = new mysqli('localhost', 'root', '123456', 'mydb');
        return (bool) $this->link;
    }

    public function close()
    {
        return $this->link->close();
    }
   
    public function write($id, $data)
    {
        $expires = time() + 3600;
        $sql = 'REPLACE INTO `session`  SET `id` = ?, `expires` =?, `data` = ?';
        $stmt = $this->link->prepare($sql);
        $stmt->bind_param('sis', $id, $expires, $data);
        return (bool) $stmt->execute();
    }

    public function read($id)
    {
        $now = time();
        $sql = "SELECT `data` FROM `session` WHERE `id` = '$id'  AND `expires` > $now";
        return (string) $this->link->query($sql)->fetch_assoc()['data'];
    }
   
    public function destroy($id)
    {
        $sql = "DELETE FROM `session` WHERE `id` = $id";
        return (bool) $this->link->query($sql);
    }
   
    public function gc($maxlifetime)
    {
        $sql = "DELETE FROM `session` WHERE (`expires` + $maxlifetime ) < $maxlifetime)";
        $result = $this->link->query($sql);
        return (bool) $result;
    }
}
