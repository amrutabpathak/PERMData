package perm.dao;

import perm.model.Agent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AgentDao {
    private static AgentDao singletonInstance = null;

    private ConnectionManager connectionManager;

    private AgentDao() {
        connectionManager = new ConnectionManager();
    }

    public synchronized static AgentDao getInstance() {
        if(singletonInstance == null) {
            return new AgentDao();
        } else {
            return singletonInstance;
        }
    }

    public Agent create(Agent agent) throws SQLException {
        String insert = "INSERT INTO Agent(FirmName, City, State)" +
                "values(?,?,?);";
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(insert);
            statement.setString(1,agent.getFirmName());
            statement.setString(2,agent.getCity());
            statement.setString(3,agent.getState());

            statement.executeUpdate();
            return agent;
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


    public Agent getAgentByName(String agentName) throws SQLException {
        String select = "select FirmName, City, State " +
                "from Agent " +
                "where FirmName = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(select);
            statement.setString(1,agentName);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                String name = resultSet.getString("FirmName");
                String city = resultSet.getString("City");
                String state = resultSet.getString("State");

                return new Agent(name,city,state);
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

    public Agent updateAgent(Agent agent, String city) throws SQLException {
        String update = "update Agent set city = ? where FirmName =?;";
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(update);
            statement.setString(1,city);
            statement.setString(2,agent.getFirmName());
            statement.executeUpdate();
            agent.setCity(city);
            return agent;
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
    public Agent delete(Agent agent) throws SQLException {
        String deleteStatement = "DELETE FROM Agent WHERE FirmName=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deleteStatement);
            deleteStmt.setString(1, agent.getFirmName());
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
