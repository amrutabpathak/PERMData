package perm.dao;

import perm.model.Agent;
import perm.model.ReshareAgentEmployer;

import java.sql.*;


public class ReshareEmployerAgentDao {
    private static ReshareEmployerAgentDao singletonInstance = null;

    private ConnectionManager connectionManager;

    private ReshareEmployerAgentDao() {
        connectionManager = new ConnectionManager();
    }

    public synchronized static ReshareEmployerAgentDao getInstance() {
        if(singletonInstance == null) {
            return new ReshareEmployerAgentDao();
        } else {
            return singletonInstance;
        }
    }

    public ReshareAgentEmployer create(ReshareAgentEmployer reshare) throws SQLException {
        String insert = "INSERT INTO ReshareAgentEmployer(AgentFirmName, EmployerName)" +
                "values(?,?);";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = connectionManager.getConnection();
            ReshareAgentEmployer temp = getReshareByName(reshare.getAgentName(),reshare.getEmployerName());
            if(temp == null) {
                statement = connection.prepareStatement(insert);
                statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1,reshare.getAgentName());
                statement.setString(2,reshare.getEmployerName());
                statement.executeUpdate();

                resultSet = statement.getGeneratedKeys();
                int id = -1;
                if(resultSet.next()) {
                    id = resultSet.getInt(1);
                } else {
                    throw new SQLException("Unable to retrieve auto-generated key.");
                }
                reshare.setId(id);
            } else {
                reshare = temp;
            }

//            System.out.println("~~~~~");
//            System.out.println("agent"+reshare.getAgentName());
//            System.out.println("employer"+reshare.getEmployerName());
            return reshare;
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


    public ReshareAgentEmployer getReshareByName(String agentName, String employerName) throws SQLException {
        String select = "select ReshareID, AgentFirmName, EmployerName " +
                "from ReshareAgentEmployer " +
                "where AgentFirmName = ? and EmployerName = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(select);
            statement.setString(1,agentName);
            statement.setString(2,employerName);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("ReshareID"));
                String agentFirmName = resultSet.getString("AgentFirmName");
                String employerName1 = resultSet.getString("EmployerName");

                return new ReshareAgentEmployer(id,employerName1,agentFirmName);
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

    public ReshareAgentEmployer updateReshare(ReshareAgentEmployer reshare, String agent) throws SQLException {
        delete(reshare);
        System.out.println("~~~~1111");
        System.out.println("agent:"+agent);
        System.out.println("emp:"+reshare.getEmployerName());
        return create(new ReshareAgentEmployer(agent,reshare.getEmployerName()));
    }

    public ReshareAgentEmployer delete(ReshareAgentEmployer reshare) throws SQLException {
        String deleteStatement = "DELETE FROM ReshareAgentEmployer WHERE AgentFirmName =? and EmployerName = ?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deleteStatement);
            deleteStmt.setString(1, reshare.getAgentName());
            deleteStmt.setString(2, reshare.getEmployerName());
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
