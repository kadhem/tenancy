//package tn.tcon.tenancy.mongo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import tn.tcon.tenancy.mongo.dao.TestDao;
//import tn.tcon.tenancy.mongo.domain.User;
//
//@Service
//public class UserMongoService {
//
//	@Autowired
//	TestDao userMongoDao;
//
//	public void addMongoUser() {
//		User user = new User("1","concord","tcon","dbtcon1");
//		if (userMongoDao.findOne(user.getId()) == null)
//			userMongoDao.save(user);
//	}
//
//
//}
