package tn.tcon.tenancy.config.data;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
//@EnableMongoRepositories(basePackages = "tn.tcon.tenancy.mongo.dao")
@ImportResource(value = "classpath:spring.xml")
public class MongoConfig {

//	@Bean
//	public MongoDbFactory mongoDbFactory() throws Exception {
//		return new SimpleMongoDbFactory(new MongoClient("127.0.0.1", 27017), "dbtcon");
//	}
//
//	@Bean
//	public MongoTemplate mongoTemplate() throws Exception {
//
//		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
//
//		return mongoTemplate;
//
//	}
//
//	@Override
//	public Mongo mongo() throws Exception {
//		return new MongoClient("127.0.0.1", 27017);
//	}
//
//	@Override
//	protected String getMappingBasePackage() {
//		return "tn.tcon.tenancy.mongo.dao";
//	}
//
//	@Override
//	protected String getDatabaseName() {
//		return "dbtcon";
//	}

}