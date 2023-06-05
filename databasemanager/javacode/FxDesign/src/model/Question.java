package model;


public class Question {
    private String name;
    private String content;
    private String title;
    private String  answer;

    public Question() {
    }

    public Question(String name, String content, String title, String answer) {
        this.name = name;
        this.content = content;
        this.title = title;
        this.answer = answer;
    }

    @Override
    public int hashCode() {
        String thisTitle = this.title.substring(0, this.title.indexOf("<br>"));
        return thisTitle.hashCode();
    }

    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj instanceof  Question){
            Question anotherQuestion = (Question) obj;
            String thisTitle = this.title.substring(0,this.title.indexOf("<br>"));
            String anotherTitle = anotherQuestion.title.substring(0,anotherQuestion.title.indexOf("<br>"));
            if (thisTitle == anotherTitle){
                return true;
            }
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Question{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
