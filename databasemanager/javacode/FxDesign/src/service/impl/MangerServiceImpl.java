package service.impl;

import dao.IMangersDao;
import dao.impl.MangersDaoImpl;
import model.Mangers;
import service.IMangersService;

import java.util.List;

public class MangerServiceImpl implements IMangersService {
    private String result = "管理员不存在";
    private IMangersDao dao = new MangersDaoImpl();
    /**
     * 管理员登录操作
     *
     * @param number 账号
     * @param password 密码
     * @return 返回一个字符串
     */
    @Override
    public String mangerLogin(String number,String password) {
        List<Mangers> list = dao.mangerLogin(number);
        if (list.size() > 0){
            Mangers mangers = list.get(0);
            if (password.equals(mangers.getPassword())){
                result = "管理员存在";
            }
        }
        return result;
    }
}
