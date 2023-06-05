package dao;

import model.Question;

import java.util.List;

public interface IQuestionDao {
    /**
     * 获取试卷
     * @param Object 学科
     * @return 返回一个List集合
     */
    public List<Question> getPaper(String Object);

    /**
     * 获取信息
     * @return 返回一个集合
     */
    public List<Question> getInformation();

    /**
     * 删除学科
     * @param name 学科名
     * @return 返回一个int类型的数字
     */
    public int deleteObject(String name);
    /**
     * 更新题库
     * @param object 学科
     * @param content 内容
     * @return 返回int类型的字符串
     */
    public int updateQuestion(String object,String content);
}
