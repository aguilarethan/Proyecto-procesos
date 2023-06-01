package com.uv.parkingcity.logic.manager;

import com.uv.parkingcity.data.dao.daoimplement.ParkingSpaceDaoImp;
import com.uv.parkingcity.data.entities.ParkingSpace;

import java.sql.SQLException;
import java.util.ArrayList;

public class ParkingSpaceManager {

    ParkingSpaceDaoImp parkingSpaceDaoImp = new ParkingSpaceDaoImp();
    public ArrayList<ParkingSpace> getParkingSpacesByAreaId (String areaId) throws SQLException {
        return parkingSpaceDaoImp.getParkingSpacesByAreaId(areaId);
    }

    public int updateParkingSpaceStatus (ParkingSpace parkingSpace) throws SQLException {
        return parkingSpaceDaoImp.updateParkingSpaceStatus(parkingSpace);
    }

}
