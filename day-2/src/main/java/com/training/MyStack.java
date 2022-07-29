package com.training;

import java.util.LinkedList;

import com.training.exceptions.EmptyMyStackException;

public class MyStack<T> {
	
	private LinkedList<T> data = new LinkedList<>();

	public void push(T element) {		
		data.addLast(element);		
	}

	public int size() {
		return data.size();
	}

	public T pop() throws EmptyMyStackException  {
		if (isEmpty())
			throw new EmptyMyStackException("Can't remove an element because stack is empty.");
		return data.removeLast();
	}	
	
	public boolean isEmpty() {
		return data.isEmpty();
	}

	public T peek() throws EmptyMyStackException {
		if (isEmpty())
			throw new EmptyMyStackException("Can't read an element because stack is empty.");
		return data.getLast();
	}
}















