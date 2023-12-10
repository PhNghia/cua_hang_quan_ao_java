package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.ConnectionDB;
import DTO.NhaCungCap;

public class NhaCungCapNewShortDAO {
    public NhaCungCap getNccByTenFromDB (String tenNcc) {
        String sql = String.format("select * from nha_cung_cap where ten_ncc = '%s'", tenNcc);
        ConnectionDB con = new ConnectionDB();
        ResultSet rs = con.executeQuery(sql);
        try {
            if (rs.next()) {
                return new NhaCungCap(
                    rs.getInt("ma_ncc"),
                    rs.getString("ten_ncc")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
