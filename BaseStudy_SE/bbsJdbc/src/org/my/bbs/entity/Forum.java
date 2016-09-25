package org.my.bbs.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Forum implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String description;
	private int order;
	private Category category;// 所属的父板块
	private int topicCount;
	private int articleCount;
	private Date lastArticlePostTime;
	private Topic lastTopic;
	private Set<Topic> topics = new HashSet<Topic>(); //板块中的帖子
	
	public Topic getLastTopic()
	{
		return lastTopic;
	}

	public void setLastTopic(Topic lastTopic)
	{
		this.lastTopic = lastTopic;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getOrder()
	{
		return order;
	}

	public void setOrder(int order)
	{
		this.order = order;
	}

	public Category getCategory()
	{
		return category;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}

	public int getTopicCount()
	{
		return topicCount;
	}

	public void setTopicCount(int topicCount)
	{
		this.topicCount = topicCount;
	}

	public int getArticleCount()
	{
		return articleCount;
	}

	public void setArticleCount(int articleCount)
	{
		this.articleCount = articleCount;
	}

	public Date getLastArticlePostTime()
	{
		return lastArticlePostTime;
	}

	public void setLastArticlePostTime(Date lastArticlePostTime)
	{
		this.lastArticlePostTime = lastArticlePostTime;
	}

	public Set<Topic> getTopics()
	{
		return topics;
	}

	public void setTopics(Set<Topic> topics)
	{
		this.topics = topics;
	}
	
	
}
