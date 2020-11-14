package com.turkey.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkey.business.Turkey;
import com.turkey.db.TurkeyRepo;

@CrossOrigin
@RestController
@RequestMapping("/turkeys")
public class TurkeyController {
	/*
	 * A controller will implement 5 CRUD methods: 1) GET ALL 2) GET BY ID 3) POST -
	 * Insert 4) PUT - Update 5) DELETE - delete
	 */

	@Autowired
	private TurkeyRepo turkeyRepo;

	@GetMapping("/")
	public List<Turkey> getAll() {
		return turkeyRepo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Turkey> getById(@PathVariable int id) {
		return turkeyRepo.findById(id);
	}

	// Add a turkey
	@PostMapping("/")
	public Turkey addturkey(@RequestBody Turkey t) {
		t = turkeyRepo.save(t);
		return t;
	}

	// Update a turkey
	@PutMapping("/")
	public Turkey updateturkey(@RequestBody Turkey t) {
		t = turkeyRepo.save(t);
		return t;
	}

	// Delete a turkey
	@DeleteMapping("/{id}")
	public Turkey deleteturkey(@PathVariable int id) {
		//Optional type will wrap a turkey
		Optional <Turkey> t = turkeyRepo.findById(id);
		//isPresent() will return true if a turkey was found
		if (t.isPresent()) {
		turkeyRepo.deleteById(id);
		}else {
			System.out.println("Error - turkey not found for id " +id);
		}return t.get();
		
	}

	
}
