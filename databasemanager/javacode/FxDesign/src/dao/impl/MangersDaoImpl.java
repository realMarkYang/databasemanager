package dao.impl;

import dao.IMangersDao;
import handler.IResultSetHandler;
import model.Mangers;
import utils.JDBCTemplate;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MangersDaoImpl implements IMangersDao {

    /**
     * 管理员登录操作
     *
     * @param number
     * @return 返回一个字符串
     */
    @Override
    public List<Mangers> mangerLogin(String number) {
        List<Mangers> list = JDBCTemplate.query("select * from manger where number = ?",
                new MangerResultSetHandler(),
                number);
        return list;
    }
}
class MangerResultSetHandler implements IResultSetHandler<List<Mangers>>{

    @Override
    public List<Mangers> Handler(ResultSet res) throws SQLException {
        List<Mangers> list = new LinkedList<Mangers>();
        while (res.next()){
            String number = res.getString("number");
            String password = res.getString("password");
            String name = res.getString("name");
            Mangers manger = new Mangers(number,password,name);
            list.add(manger);
        }
        return list;
    }
}
