package database;
import java.sql.*;

public class DBconnection {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBconnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/study", "root", "1234");
            st = con.createStatement();
        }
        catch(Exception e) {
            System.out.println("데이터베이스 연결 오류 : " + e.getMessage());
        }
    }


    public int insert(int ID, String Name, String BirthDay, String Major) throws SQLException {
        String sql = "insert into students values(?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,ID);
        pst.setString(2,Name);
        pst.setString(3,BirthDay);
        pst.setString(4,Major);

        int result = pst.executeUpdate(); // 실패하면 0을반환해 그리고 성공하면 insert된 행의 개수가 반환됨

        con.close(); // 연결끊어줌
        st.close();
        return result;
    }

    public int update(int ID, String Name, String BirthDay, String Major) throws SQLException {
        String sql = "update students set Name = ?, BirthDay = ?, Major =? where id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,Name);
        pst.setString(2,BirthDay);
        pst.setString(3,Major);
        pst.setInt(4,ID);

        int result = pst.executeUpdate(); // 실패하면 0을반환해 그리고 성공하면 update된 행의 개수가 반환됨

        con.close(); // 연결끊어줌
        st.close();
        return result;
    }

    public int delete(int ID) throws SQLException {
        String sql = "delete from students where id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,ID);

        int result = pst.executeUpdate(); // 실패하면 0을반환해 그리고 성공하면 delete된 행의 개수가 반환됨

        con.close(); // 연결끊어줌
        st.close();
        return result;
    }

    public Info select(int Id) throws SQLException{
        String sql = "select * from students where id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,Id);
        ResultSet rs = pst.executeQuery();
        Info info = new Info();

        while (rs.next()){
            // ResultSet 으로 DB값 갖고옴
            //
            info.setID(rs.getInt("ID"));
            info.setName(rs.getString("Name"));
            info.setBirth(rs.getString("BirthDay"));
            info.setMajor(rs.getString("Major"));
        }

        return info;
    }
}
