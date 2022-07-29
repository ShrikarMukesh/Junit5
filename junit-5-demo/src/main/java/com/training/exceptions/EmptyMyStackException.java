package com.training.exceptions;

public class EmptyMyStackException extends Exception {
	
	public EmptyMyStackException() { }
	
	public EmptyMyStackException(String message) {
		super(message);
	}
}
