package tn.tcon.tenancy.mongo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.tcon.tenancy.mongo.domain.User;

@Repository
public interface TestDao extends CrudRepository<User, String> {

	User findUserByName(String name);
}
