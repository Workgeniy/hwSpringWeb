package org.example.hwspringweb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserDto, Long> {
	List<UserDto> findByEmail(String email);
}