package com.training.tests.pack2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.training.MyStack;
import com.training.exceptions.EmptyMyStackException;

public class MyStackTest {
	
	MyStack<String> stack;
	
	@BeforeEach
	public void setUp() {
		stack = new MyStack<>();
	}
 
	@Test
	public void should_Increase_Size_By_One_WhenAnElementIsPushedIntoStack() {
		
		stack.push("One");
		stack.push("Two");
		
		assertEquals(2, stack.size());
	}
	
	@Test
	public void should_Decrease_Size_By_One_WhenAnElementIsPoppedFromStack_And_AlsoReturnsIt() throws EmptyMyStackException {
	
		stack.push("One");
		stack.push("Two");
		
		String removedElement = stack.pop();
		
		assertEquals(1, stack.size());
		assertEquals("Two", removedElement);		
	}
	
	@Test
	public void should_Throw_EmptyMyStackException_WhenPopAnElementFromEmptyStack() {
		
        // Executable ex = () -> stack.pop();
		
		assertThrows(EmptyMyStackException.class, () -> stack.pop());
	}
	
	@Test
	public void peek_Should_Return_TopmostElement_WithoutRemovingIt() throws EmptyMyStackException {
		
		stack.push("One");
		stack.push("Two");
		stack.push("Three");
		
		String topElement = stack.peek();
		
		assertEquals("Three", topElement);
		assertEquals(3, stack.size());		
	}
	
	@Test
	public void peek_Should_Throw_EmptyMyStackException_WhenStackIsEmpty() {
		
		assertThrows(EmptyMyStackException.class, () -> stack.peek());
	}
	
	@Test
	public void isEmpty_Should_Return_True_IfStackIsEmpty() {
	
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void isEmpty_Should_Return_False_IfStackIsNotEmpty() {
			
		stack.push("One");
		stack.push("Two");
		
		assertFalse(stack.isEmpty());
	}
	
	
	@AfterEach
	public void tearDown() {
		stack = null;
	}
}























