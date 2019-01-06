package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Post;
import com.example.repository.PostRepository;

@RestController
public class PostController {
	@Autowired
	private PostRepository repository;
	
	@RequestMapping(value="/createPost", method = RequestMethod.POST)
	public Post createPost(@Valid @RequestBody Post post) {
		post.set_id(ObjectId.get().toHexString());
		repository.save(post);
		return post;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Post getPost(@PathVariable("id") String id) {
		return repository.findBy_id(id);
	}
	
	@RequestMapping(value="/getAllPost", method = RequestMethod.GET)
	public List<Post> getAll(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") String id, @Valid @RequestBody Post post) {
		post.set_id(id);
		repository.save(post);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		repository.delete(repository.findBy_id(id));
	}
	
	@RequestMapping("/deleteAll")
	public void deleteAll() {
		repository.deleteAll();
	}
}
