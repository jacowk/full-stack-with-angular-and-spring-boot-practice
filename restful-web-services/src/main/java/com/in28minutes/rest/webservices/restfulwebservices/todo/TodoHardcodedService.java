package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service //Add this because we want springboot to manage dependencies. Use @Autowired to inject an instance in TodoResource.
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList<>(); //Initially act as a database
	private static long idCounter = 0;
	
	
	static {
		todos.add(new Todo(++idCounter, "in28minutes", "Learn to Dance", new Date(), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Learn about Microservices", new Date(), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Learn about Angular", new Date(), false));
	}
	
	public List<Todo> findAll() {
		return todos;
	}
	
	public Todo save(Todo todo) {
		System.out.printf("Todo Save Id: %d\n", todo.getId());
		if (todo.getId() == -1 || todo.getId() == 0) {
			System.out.println("Inserting");
			//Insert new Todo
			todo.setId(++idCounter);
			todos.add(todo);
		}
		else {
			//Update existing Todo
			System.out.println("Updating");
			todos.remove(todo);
			todos.add(todo);
		}
		return todo;
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
