package handler;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface IResultSetHandler<T> {
    T Handler(ResultSet res) throws SQLException;
}
