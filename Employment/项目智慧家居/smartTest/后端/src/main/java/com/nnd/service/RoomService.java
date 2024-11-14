package com.nnd.service;

import com.nnd.pojo.Room;

import java.util.List;

public interface RoomService {
    public List<Room> queryAllRooms ();
    public Room queryRoomById(int roomId);
    public boolean addRoom(Room room);
    public boolean deleteRoomById(int roomId);
    public boolean updateRoom(Room room);
}
