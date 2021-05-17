package app4l.demo.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app4l.demo.business.abstracts.UserService;
import app4l.demo.dataAccess.abstracts.UserDao;
import app4l.demo.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getAll() {
		List<User> user = userDao.findAll();
		return user;
	}

	@Override
	public Optional<User> getById(Long id) {
		
		return userDao.findById(id);
		
	}
	

}
