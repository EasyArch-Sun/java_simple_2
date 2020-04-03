package sun.springjdbc;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HikariCP_demo {

    public static void main(String[] args) throws SQLException {

        long start=System.currentTimeMillis();

        HikariConfig hikariConfig=new HikariConfig();

        hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("root");

        hikariConfig.addDataSourceProperty("cachePrepStmts","true");
        hikariConfig.addDataSourceProperty("prepStmtCachesize","200");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit","2048");

        HikariDataSource hds=new HikariDataSource(hikariConfig);

        long end=System.currentTimeMillis();
        System.out.println("HikariCP建立连接耗时："+(end-start));

        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;

        try {
            conn=hds.getConnection();
            st=conn.createStatement();
            rs=st.executeQuery("select * from test1");

            while (rs.next()){
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("birthday"));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            rs.close();
            st.close();
            conn.close();
        }



    }
}
