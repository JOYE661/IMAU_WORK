package com.nnd.service.impl;

import com.nnd.dao.RoomDao;
import com.nnd.pojo.Room;
import com.nnd.pojo.User;
import com.nnd.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;

    @Override
    public List<Room> queryAllRooms() {
        return roomDao.queryAllRooms();
    }

    @Override
    public Room queryRoomById(int roomId) {
        return roomDao.queryRoomById(roomId);
    }

    @Override
    public boolean addRoom(Room room) {
        int row = roomDao.addRoom(room);
        if (row > 0) {
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteRoomById(int roomId) {
        int row = roomDao.deleteRoomById(roomId);
        if (row > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRoom(Room room) {
        int row = roomDao.updateRoom(room);
        if (row > 0) {
            return true;
        }

        return false;
    }
}
