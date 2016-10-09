package com.my.bean;

public class QuestionType
{
    /*
     * create table questionTypeTable (
            id int(11) not null auto_increment,
            name varchar(20) default null,
            primary key (id)
        )
     */
    
    private Integer id;
    private String name;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
