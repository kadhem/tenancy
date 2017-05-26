package tn.tcon.tenancy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.tcon.tenancy.dao.UserDao;
import tn.tcon.tenancy.domain.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public void findAll(){
		List<User> users = userDao.findAll();
		for (User user : users) {
			System.out.println(user.getName());
		}
	}
	
}
