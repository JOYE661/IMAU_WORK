package com.nnd.dao;

import com.nnd.pojo.Room;

import java.util.List;

public interface RoomDao {
    public List<Room>queryAllRooms ();
    public Room queryRoomById(int roomId);
    public int addRoom(Room room);
    public int deleteRoomById(int roomId);
    public int updateRoom(Room room);
}
