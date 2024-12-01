package org.example.hwspringweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserDtoRepository repo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserDto addUser(UserDto user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repo.save(user);
	}

	public UserDto findUser(Long id) {
		Optional<UserDto> user = repo.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	public UserDto findByEmail(String email) {
		return repo.findOneByEmail(email);
	}

}