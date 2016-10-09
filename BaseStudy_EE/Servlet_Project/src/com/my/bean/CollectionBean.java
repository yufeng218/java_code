package com.my.bean;

public class CollectionBean
{
    /*
     * CREATE TABLE `collectiontb` ( 
     *   `id` int(11) NOT NULL AUTO_INCREMENT,
     *   `url`varchar(500) DEFAULT NULL,
     *   `name` varchar(50) DEFAULT NULL, 
     *   PRIMARY KEY (`id`) 
     *  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
     */

    private int id;
    private String url;
    private String name;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
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
