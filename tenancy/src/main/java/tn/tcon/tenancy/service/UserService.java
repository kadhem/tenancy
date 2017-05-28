package tn.tcon.tenancy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.tcon.tenancy.bean.UserBean;
import tn.tcon.tenancy.dao.UserDao;
import tn.tcon.tenancy.domain.User;

@Service("userService")
public class UserService implements UserDetailsService {

	@Autowired
	UserDao userDao;

	public UserService() {
		super();
	}

	public void findAll() {
		List<User> users = userDao.findAll();
		for (User user : users) {
			System.out.println(user.getName());
		}
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// User user = userDao.findUserByName(arg0);
		System.out.println("test user service");
		if (arg0.equals("kadhem")) {
			return new UserBean("kadhem", "kacem", true, true, true, true, getAuthorities(), 1l, "kadhem", "dbtcon1");
		} else {
			return new UserBean("kacem", "kadhem", true, true, true, true, getAuthorities(), 2l, "kacem", "dbtcon");
		}

	}

	private List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new java.util.ArrayList<GrantedAuthority>();
		auths.add(new SimpleGrantedAuthority("ROLE_USER"));
		return auths;
	}

}
