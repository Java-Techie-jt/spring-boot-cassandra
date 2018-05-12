package com.javatechie.spring.cassandra.api.rpository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.javatechie.spring.cassandra.api.model.User;

public interface UserRepository extends CassandraRepository<User, Integer> {

	@AllowFiltering
	List<User> findByAgeGreaterThan(int age);

}
