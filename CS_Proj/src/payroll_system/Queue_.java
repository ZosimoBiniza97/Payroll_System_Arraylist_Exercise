package payroll_system;

import java.util.Queue;
import java.util.Stack;

public class Queue_ {
	public static void Queue_(Queue<list_model> queue,Stack<list_model> stack)
	{
		//Just transfers the stack elements to the queue
		while(!stack.isEmpty()) {
		      queue.add(stack.pop());
		  }
		
	}

}
