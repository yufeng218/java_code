package com.my.bean;

public class Question
{
    /*
     * create table questionTable (
            id int(11) not null auto_increment,
            createTime varchar(20) default null,
            systemMemberId int(11) default null,
            questionTypeId int(11) default null,
            questionKey varchar(20) default null,
            content varchar(200) default null,
            answerCount int(11) default null,
            primary key (id)
        )
     */
    private Integer id;
    private String createTime;
    private String questionKey;
    private String content;
    private Integer answerCount;

    private SystemMember sm;
    private QuestionType qt;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public String getQuestionKey()
    {
        return questionKey;
    }

    public void setQuestionKey(String questionKey)
    {
        this.questionKey = questionKey;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Integer getAnswerCount()
    {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount)
    {
        this.answerCount = answerCount;
    }

    public SystemMember getSm()
    {
        return sm;
    }

    public void setSm(SystemMember sm)
    {
        this.sm = sm;
    }

    public QuestionType getQt()
    {
        return qt;
    }

    public void setQt(QuestionType qt)
    {
        this.qt = qt;
    }

}
