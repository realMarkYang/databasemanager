package service.impl;


import dao.IQuestionDao;
import dao.impl.QuestionDaoImpl;
import model.Question;
import service.IQuestionService;

import java.util.HashSet;
import java.util.List;

public class QuestionServiceImpl implements IQuestionService {
    private IQuestionDao dao = new QuestionDaoImpl();
    private Question question = null;
    private String result = "失败";

    /**
     * 获取试卷
     *
     * @param Object 学科
     * @return 返回一个HanhSet集合
     */
    @Override
    public HashSet<Question> getPaper(String Object) {
        HashSet<Question> set = new HashSet<Question>();
        List<Question> list = dao.getPaper(Object);
        if (list.size() > 0) {
            for (Question q : list) {
                String name = q.getName();
                String content = q.getContent();
                String[] split = content.split("~");
                for (int i = 0; i < split.length; i++) {
                    String[] values = split[i].split("#");
                    question = new Question(name, null, values[0], values[1]);
                    set.add(question);
                }
            }
        }
        return set;
    }

    /**
     * 获取信息
     *
     * @return
     */
    @Override
    public List<Question> getInformation() {
        return dao.getInformation();
    }

    /**
     * 删除题库信息
     *
     * @param name 学科名
     * @return 返回一个字符串
     */
    @Override
    public String deleteObject(String name) {
        int i = dao.deleteObject(name);
        if (i > 0) {
            result = "成功";
        }
        return result;
    }

    /**
     * 更新题库
     *
     * @param object  学科
     * @param content 内容
     * @return 返回String类型的字符串
     */
    @Override
    public String updateQuestion(String object, String content) {
        int i = dao.updateQuestion(object, content);
        if (i>0){
            result = "成功";
        }
        return result;
    }
}
