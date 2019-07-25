package perm.dao;

import perm.model.Employer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployerDao {
    private static EmployerDao singletonInstance = null;

    private ConnectionManager connectionManager;

    private EmployerDao() {
        connectionManager = new ConnectionManager();
    }

    public synchronized static EmployerDao getInstance() {
        if(singletonInstance == null) {
            return new EmployerDao();
        } else {
            return singletonInstance;
        }
    }

    public Employer create(Employer employer) throws SQLException {
        String insert = "INSERT INTO Employer(EmployerName, Address1, Address2, City, State, Country, PostalCode, Phone, PhoneExt, NumOfEmployee, EstablisedYear, FwOwnershipInterest)" +
                "values(?,?,?,?,?,?,?,?,?,?,?,?);";
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(insert);
            statement.setString(1,employer.getName());
            statement.setString(2,employer.getAddress1());
            statement.setString(3,employer.getAddress2());
            statement.setString(4,employer.getCity());
            statement.setString(5,employer.getState());
            statement.setString(6,employer.getCountry());
            statement.setInt(7,employer.getPostalCode());
            statement.setString(8,employer.getPhone());
            statement.setInt(9,employer.getPhoneExt());
            statement.setInt(10,employer.getNumOfEmployee());
            statement.setInt(11,employer.getEstablishedYear());
            statement.setBoolean(12,employer.isFwOwnershipInterest());

            statement.executeUpdate();
            return employer;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
        }
    }


    public Employer getEmployerByName(String employerName) throws SQLException {
        String select = "select EmployerName, Address1, Address2, City, State, Country, PostalCode, Phone, PhoneExt, NumOfEmployee, EstablisedYear, FwOwnershipInterest " +
                "from Employer " +
                "where EmployerName = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(select);
            statement.setString(1,employerName);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                String name = resultSet.getString("EmployerName");
                String address1 = resultSet.getString("Address1");
                String address2 = resultSet.getString("Address2");
                String city = resultSet.getString("City");
                String state = resultSet.getString("State");
                String country = resultSet.getString("Country");
                int postalCode = resultSet.getInt("PostalCode");
                String phone = resultSet.getString("Phone");
                int phoneExt = resultSet.getInt("PhoneExt");
                int numOfEmployee = resultSet.getInt("NumOfEmployee");
                int establishedYear = resultSet.getInt("EstablisedYear");
                boolean fwOwnership = resultSet.getBoolean("FwOwnershipInterest");
                return new Employer(name,address1,address2,city,state,country,postalCode,phone,phoneExt,numOfEmployee,establishedYear,fwOwnership);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(resultSet != null) {
                resultSet.close();
            }
        }
        return null;
    }

    public Employer updateEmployer(Employer employer, int numOfEmployee) throws SQLException {
        String update = "update Employer set NumOfEmployee = ? where EmployerName =?;";
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(update);
            statement.setInt(1,numOfEmployee);
            statement.setString(2,employer.getName());
            statement.executeUpdate();
            employer.setNumOfEmployee(numOfEmployee);
            return employer;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
        }
    }
    public Employer delete(Employer employer) throws SQLException {
        String deleteStatement = "DELETE FROM Employer WHERE EmployerName=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deleteStatement);
            deleteStmt.setString(1, employer.getName());
            deleteStmt.executeUpdate();

            // Return null so the caller can no longer operate on the Persons instance.
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(deleteStmt != null) {
                deleteStmt.close();
            }
        }
    }

}
