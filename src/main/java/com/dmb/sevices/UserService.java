package com.dmb.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.User;
import com.dmb.repository.UserDAO;
import com.dmb.sevices.interfaces.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserDAO dao;
	
	@Override
	public List<User> getAllUser() {
		return dao.findAll();
	}

	@Override
	public Optional<User> getOneUser(Long id) {
		return dao.findById(id);
	}

	@Override
	public User createUser(User entity) {
		return dao.save(entity);
	}

	@Override
	public User updateUser(User entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteUser(Long id) {
		dao.deleteById(id);
	}

}
