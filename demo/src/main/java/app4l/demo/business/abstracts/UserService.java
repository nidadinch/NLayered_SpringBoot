package app4l.demo.business.abstracts;

import java.util.List;
import java.util.Optional;

import app4l.demo.entities.concretes.User;

public interface UserService {

	List<User> getAll();
	Optional<User> getById(Long id);
}
