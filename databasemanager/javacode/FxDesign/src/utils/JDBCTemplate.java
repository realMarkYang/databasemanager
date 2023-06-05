package utils;

import handler.IResultSetHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTemplate {
    /**
     * DML操作
     *
     * @param sql    sql语句
     * @param params 参数个数
     * @return 返回一个ine类型的数字
     */
    public static int updateData(String sql, Object... params) {
        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = JDBCUtils.getConnection();
            pstmt = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            result = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(null, pstmt, con);
        }
        return result;
    }

    /**
     * DDL操作
     *
     * @param sql    SQL语句
     * @param rsh    接口
     * @param params 参数个数
     * @param <T>    泛型
     * @return 返回一个T类型的集合或者T类型的对象
     */
    public static <T> T query(String sql, IResultSetHandler<T> rsh, Object... params) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        try {
            con = JDBCUtils.getConnection();
            pstmt = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            res = pstmt.executeQuery();
            return rsh.Handler(res);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstmt, con);
        }
        return null;
    }
}
