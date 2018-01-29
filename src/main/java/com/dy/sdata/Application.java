package com.dy.sdata;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.MongoDbFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		MongoDbFactory factory = context.getBean(MongoDbFactory.class);
		DB db = factory.getLegacyDb();
		DBCollection collection = db.getCollection("book");
		collection.insert(new BasicDBObject().append("title", "Oslo snow!"));
	}
	
}
