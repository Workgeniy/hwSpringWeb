package org.example.hwspringweb;

import org.springframework.data.repository.CrudRepository;

public interface UserDtoRepository extends CrudRepository<UserDto, Long> {

    UserDto findOneByEmail(String email);

}
