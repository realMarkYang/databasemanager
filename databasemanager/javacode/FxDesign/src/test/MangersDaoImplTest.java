package test;

import dao.IMangersDao;
import dao.impl.MangersDaoImpl;
import model.Mangers;
import org.junit.Test;

import java.util.List;


public class MangersDaoImplTest {
    private IMangersDao dao = new MangersDaoImpl();
    @Test
    public void mangerLogin() {
        List<Mangers> list = dao.mangerLogin("1915925001");
        Mangers mangers = list.get(0);
        System.out.println(mangers.getPassword()+"  "+ mangers.getName()+list.size());
    }
}