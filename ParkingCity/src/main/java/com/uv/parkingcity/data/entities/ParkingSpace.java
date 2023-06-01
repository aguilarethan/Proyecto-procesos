package com.uv.parkingcity.data.entities;

import com.uv.parkingcity.data.entities.enums.ParkingSpaceStatus;

public class ParkingSpace {

    private int parkingSpaceId;
    private ParkingSpaceStatus parkingSpaceStatus;
    private String areaId;

    public ParkingSpace() {
    }

    public ParkingSpace(int parkingSpaceId, ParkingSpaceStatus parkingSpaceStatus, String areaId) {
        this.parkingSpaceId = parkingSpaceId;
        this.parkingSpaceStatus = parkingSpaceStatus;
        this.areaId = areaId;
    }

    public int getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void setParkingSpaceId(int parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }

    public ParkingSpaceStatus getParkingSpaceStatus() {
        return parkingSpaceStatus;
    }

    public void setParkingSpaceStatus(ParkingSpaceStatus parkingSpaceStatus) {
        this.parkingSpaceStatus = parkingSpaceStatus;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
}
