package dao;


import model.Mangers;

import java.util.List;

public interface IMangersDao {
    /**
     * 管理员登录操作
     * @return 返回一个集合
     */
    public List<Mangers> mangerLogin(String number);
}
