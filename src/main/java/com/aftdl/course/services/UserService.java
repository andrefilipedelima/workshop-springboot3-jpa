package com.aftdl.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.aftdl.course.entities.User;
import com.aftdl.course.repositories.UserRepository;
import com.aftdl.course.services.exceptions.DatabaseException;
import com.aftdl.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User user) {
		return repository.save(user);
	}

	public void delete(Long id) {
		try {
			if (!repository.existsById(id)) {
				throw new ResourceNotFoundException(id);
			}	
			repository.deleteById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}

	public User update(Long id, User user) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, user);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}

}
