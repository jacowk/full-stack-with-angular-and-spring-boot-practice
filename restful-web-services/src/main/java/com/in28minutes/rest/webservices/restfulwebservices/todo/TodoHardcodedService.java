package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service //Add this because we want springboot to manage dependencies. Use @Autowired to inject an instance in TodoResource.
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList<>(); //Initially act as a database
	private static int idCounter = 0;
	
	
	static {
		todos.add(new Todo(++idCounter, "in28minutes", "Learn to Dance", new Date(), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Learn about Microservices", new Date(), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Learn about Angular", new Date(), false));
	}
	
	public List<Todo> findAll() {
		return todos;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todo == null) return null;
		if (todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	public Todo findById(long id) {
		for (Todo todo: todos)
		{
			if (todo.getId() == id)
			{
				return todo;
			}
		}
		return null;
	}
	
	
	
}
