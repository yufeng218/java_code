package com.my.bean;

public class Answer
{
    /*
     * create table answerTable (
            id int(11) not null auto_increment,
            createTime varchar(20) default null,
            systemMemberId int(11) default null,
            questionId int(11) default null,
            content varchar(200) default null,
            primary key (id)
        )
     */

    private Integer id;
    private String createTime;
    private String content;

    private SystemMember sm;
    private Question q;

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

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public SystemMember getSm()
    {
        return sm;
    }

    public void setSm(SystemMember sm)
    {
        this.sm = sm;
    }

    public Question getQ()
    {
        return q;
    }

    public void setQ(Question q)
    {
        this.q = q;
    }

}
