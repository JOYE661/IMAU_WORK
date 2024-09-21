package com.nnd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private int roomId;
    private String roomName;
    private String roomIcon;
    private int sensorNum;
    private int temperature;
    private int humidity;
    private int brightness;
}
