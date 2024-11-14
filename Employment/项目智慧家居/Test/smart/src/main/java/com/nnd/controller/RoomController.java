package com.nnd.controller;

import com.nnd.pojo.Room;
import com.nnd.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping
    public List<Room>queryAllRooms(){
        return roomService.queryAllRooms();
    }
    @GetMapping("/{roomId}")
    public Room queryRoomById(@PathVariable("roomId") int roomId){
        return roomService.queryRoomById(roomId);
    }
    @PostMapping
    public boolean addRoom( Room room){
        return roomService.addRoom(room);
    }
    @DeleteMapping("/{roomId}")
    public boolean deleteRoomById(@PathVariable("roomId") int roomId){
        return roomService.deleteRoomById(roomId);
    }
    @PutMapping
    public boolean updateRoom( Room room){
        return roomService.updateRoom(room);
    }
}
