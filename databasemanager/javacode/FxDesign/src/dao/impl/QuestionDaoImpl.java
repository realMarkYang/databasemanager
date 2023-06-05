package dao.impl;

import dao.IQuestionDao;
import handler.IResultSetHandler;
import model.Question;
import utils.JDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class QuestionDaoImpl implements IQuestionDao {

    /**
     * 获取试卷
     *
     * @param Object 学科
     * @return 返回一个List集合
     */
    @Override
    public List<Question> getPaper(String Object) {
        return JDBCTemplate.query("select * from question where name = ?",
                new QuestionResultSetHandler(),Object);
    }

    /**
     * 获取信息
     *
     * @return 返回一个集合
     */
    @Override
    public List<Question> getInformation() {
        return JDBCTemplate.query("select * from question",
                new QuestionResultSetHandler());
    }

    /**
     * 删除学科
     *
     * @param name 学科名
     * @return 返回一个int类型的数字
     */
    @Override
    public int deleteObject(String name) {
        return JDBCTemplate.updateData("delete from question where name = ?",name);
    }

    /**
     * 更新题库
     *
     * @param object  学科
     * @param content 内容
     * @return 返回int类型的字符串
     */
    @Override
    public int updateQuestion(String object, String content) {
        return JDBCTemplate.updateData("update question set content = ? Where name = ?",content,object);
    }
}
class QuestionResultSetHandler implements IResultSetHandler<List<Question>>{

    @Override
    public List<Question> Handler(ResultSet res) throws SQLException {
        List<Question> list = new LinkedList<Question>();
        while (res.next()){
            String namne = res.getString("name");
            String content = res.getString("content");
            Question question = new Question(namne,content,null,null);
            list.add(question);
        }
        return list;
    }
}
