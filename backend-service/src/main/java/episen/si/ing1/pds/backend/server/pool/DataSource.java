package episen.si.ing1.pds.backend.server.pool;

import episen.si.ing1.pds.backend.server.pool.JDBCConnectionPool;

import java.sql.Connection;

public class DataSource {
    private static JDBCConnectionPool jdbcConnectionPool ;

    public DataSource(int nbConnection){
        jdbcConnectionPool = PoolSingleton.Instance.getInstance(nbConnection);
    }

    public Connection receiveConnection() {
        return jdbcConnectionPool.getConnection();
    }

    public boolean putConnection(Connection connection) {
        return jdbcConnectionPool.addConnection(connection);
    }

    public void closePool() {
        jdbcConnectionPool.closeConnection();
    }

    public int getNbConnection(){
        return jdbcConnectionPool.getSizeArrayConnection();
    }

    public JDBCConnectionPool getJdbcConnectionPool (){
        return jdbcConnectionPool;
    }
}