package service;

import model.Mangers;


public interface IMangersService {
    /**
     * 管理员登录操作
     * @return 返回一个字符串
     */
    public String mangerLogin(String number,String password);
}
