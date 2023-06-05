package service;

import model.Question;

import java.util.HashSet;
import java.util.List;

public interface IQuestionService {
    /**
     * 获取试卷
     * @param Object 学科
     * @return 返回一个HanhSet集合
     */
    public HashSet<Question> getPaper(String Object);

    /**
     * 获取信息
     * @return
     */
    public List<Question> getInformation();

    /**
     * 删除题库信息
     * @param name 学科名
     * @return 返回一个字符串
     */
    public String deleteObject(String name);

    /**
     * 更新题库
     * @param object 学科
     * @param content 内容
     * @return 返回String类型的字符串
     */
    public String updateQuestion(String object,String content);
}
