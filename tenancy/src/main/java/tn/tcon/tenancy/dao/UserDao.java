package tn.tcon.tenancy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.tcon.tenancy.domain.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

	User findUserByName(String name);
}
