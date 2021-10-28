package database;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        DBconnection connection = new DBconnection();
        int returnresult = connection.insert(222, "김나나","222222","ㄴㄴ과");
        System.out.println("returnresult = " + returnresult);
    }
}
