package com.uv.parkingcity.data.dao.daointerface;

import com.uv.parkingcity.data.entities.ParkingSpace;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ParkingSpaceDao {

    ArrayList<ParkingSpace> getParkingSpacesByAreaId (String areaId) throws SQLException;
    int updateParkingSpaceStatus(ParkingSpace parkingSpace) throws SQLException;
    ParkingSpace getParkingSpaceById (int parkingSpaceId) throws SQLException;

}
