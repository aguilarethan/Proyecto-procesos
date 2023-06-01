package com.uv.parkingcity.data.dao.daoimplement;

import com.uv.parkingcity.data.dao.daointerface.ParkingSpaceDao;
import com.uv.parkingcity.data.database.Database;
import com.uv.parkingcity.data.entities.ParkingSpace;
import com.uv.parkingcity.data.entities.enums.ParkingSpaceStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParkingSpaceDaoImp implements ParkingSpaceDao {

    Database database = new Database();
    @Override
    public ArrayList<ParkingSpace> getParkingSpacesByAreaId (String areaId) throws SQLException {

        ArrayList<ParkingSpace> parkingSpaces = new ArrayList<>();
        String query = "SELECT * FROM CajonEstacionamiento WHERE AreaID = ?";

        Connection connection = database.getConnection();
        PreparedStatement getParkingSpacesStatement = connection.prepareStatement(query);
        getParkingSpacesStatement.setString(1, areaId);
        ResultSet resultSet = getParkingSpacesStatement.executeQuery();

        while (resultSet.next()) {
            int parkingSpaceID = resultSet.getInt("CajonEstacionamientoID");
            ParkingSpaceStatus parkingSpaceStatus = ParkingSpaceStatus.valueOf(resultSet.getString("EstadoCajon"));
            String areaID = resultSet.getString("AreaID");

            ParkingSpace parkingSpace = new ParkingSpace(parkingSpaceID, parkingSpaceStatus, areaID);
            parkingSpaces.add(parkingSpace);
        }

        return parkingSpaces;

    }

    @Override
    public int updateParkingSpaceStatus(ParkingSpace parkingSpace) throws SQLException {
        int result = 0;

        String query = "UPDATE CajonEstacionamiento SET EstadoCajon = ? WHERE CajonEstacionamientoID = ?";
        Connection connection = database.getConnection();
        PreparedStatement updateParkingSpaceStatusStatement = connection.prepareStatement(query);

        updateParkingSpaceStatusStatement.setString(1, String.valueOf(parkingSpace.getParkingSpaceStatus()));
        updateParkingSpaceStatusStatement.setInt(2, parkingSpace.getParkingSpaceId());

        result = updateParkingSpaceStatusStatement.executeUpdate();
        connection.close();
        return result;
    }

    @Override
    public ParkingSpace getParkingSpaceById(int parkingSpaceId) throws SQLException {
        ParkingSpace parkingSpace = new ParkingSpace();
        String query = "SELECT * FROM CajonEstacionamiento WHERE CajonEstacionamientoID = ?";

        Connection connection = database.getConnection();
        PreparedStatement getParkingSpaceByIdStatement = connection.prepareStatement(query);
        getParkingSpaceByIdStatement.setInt(1, parkingSpaceId);
        ResultSet resultSet = getParkingSpaceByIdStatement.executeQuery();

        while (resultSet.next()) {
            int parkingSpaceID = resultSet.getInt("CajonEstacionamientoID");
            ParkingSpaceStatus parkingSpaceStatus = ParkingSpaceStatus.valueOf(resultSet.getString("EstadoCajon"));
            String areaID = resultSet.getString("AreaID");

            parkingSpace = new ParkingSpace(parkingSpaceID, parkingSpaceStatus, areaID);
        }

        return parkingSpace;
    }
}
