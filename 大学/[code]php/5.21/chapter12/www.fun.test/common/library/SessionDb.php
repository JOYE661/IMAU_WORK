<?php

class SessionDb implements SessionHandlerInterface
{

    private $db;

    public function __construct($db)
    {
        $this->db = $db;
        session_set_save_handler($this, true);
    }

    public function open($save_path, $name)
    {
        return (bool) $this->db;
    }

    public function close()
    {
        return true;
    }

    public function read($id)
    {
        return (string) $this->db->fetchRow("SELECT `data` FROM __SESSION__ WHERE `id`='$id' AND `expires` > " . time())['data'];
    }

    public function write($id, $data)
    {
        $expires = time() + (int) ini_get('session.gc_maxlifetime');
        return (bool) $this->db->query("REPLACE INTO __SESSION__ SET `id`=?, `expires`=?, `data`=?", 'sis', [$id, $expires, $data]);
    }

    public function destroy($id)
    {
        return (bool) $this->db->query("DELETE FROM __SESSION__ WHERE `id`='$id'");
    }

    public function gc($maxlifetime)
    {
        return (bool) $this->db->query("DELETE FROM __SESSION__ WHERE (`expires` + $maxlifetime) < $maxlifetime");
    }
}
