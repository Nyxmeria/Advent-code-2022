package Days;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * --- Day 5: Supply Stacks ---
The expedition can depart as soon as the final supplies have been unloaded from the ships. Supplies are stored in stacks of marked crates, 
but because the needed supplies are buried under many other crates, the crates need to be rearranged.

The ship has a giant cargo crane capable of moving crates between stacks. To ensure none of the crates get crushed or fall over, 
the crane operator will rearrange them in a series of carefully-planned steps. After the crates are rearranged, the desired crates will be at the top of each stack.

The Elves don't want to interrupt the crane operator during this delicate procedure, but they forgot to ask her which crate will end up where, 
and they want to be ready to unload them as soon as possible so they can embark.

They do, however, have a drawing of the starting stacks of crates and the rearrangement procedure (your puzzle input). For example:

    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
In this example, there are three stacks of crates. Stack 1 contains two crates: crate Z is on the bottom, and crate N is on top. Stack 2 contains three crates; 
from bottom to top, they are crates M, C, and D. Finally, stack 3 contains a single crate, P.

Then, the rearrangement procedure is given. In each step of the procedure, a quantity of crates is moved from one stack to a different stack. 
In the first step of the above rearrangement procedure, one crate is moved from stack 2 to stack 1, resulting in this configuration:

[D]        
[N] [C]    
[Z] [M] [P]
 1   2   3 
In the second step, three crates are moved from stack 1 to stack 3. Crates are moved one at a time, so the first crate to be moved (D) ends up below the second and third crates:

        [Z]
        [N]
    [C] [D]
    [M] [P]
 1   2   3
Then, both crates are moved from stack 2 to stack 1. Again, because crates are moved one at a time, crate C ends up below crate M:

        [Z]
        [N]
[M]     [D]
[C]     [P]
 1   2   3
Finally, one crate is moved from stack 1 to stack 2:

        [Z]
        [N]
        [D]
[C] [M] [P]
 1   2   3
The Elves just need to know which crate will end up on top of each stack; in this example, the top crates are C in stack 1, M in stack 2, and Z in stack 3, 
so you should combine these together and give the Elves the message CMZ.

After the rearrangement procedure completes, what crate ends up on top of each stack?
CWMTGHBDW
 */
public class Day5 {

	static Stack<String> stack1 = new Stack<>();
	static Stack<String> stack2 = new Stack<>();
	static Stack<String> stack3 = new Stack<>();
	static Stack<String> stack4 = new Stack<>();
	static Stack<String> stack5 = new Stack<>();
	static Stack<String> stack6 = new Stack<>();
	static Stack<String> stack7 = new Stack<>();
	static Stack<String> stack8 = new Stack<>();
	static Stack<String> stack9 = new Stack<>();
	public static void main(String[] args) throws IOException {
		getMessageOnTop();

	}

	private static void getMessageOnTop() throws IOException {
		String relativePath = "../AdventCode2022/src/Inputs/InputDay5.txt";
		Path path = Paths.get(relativePath);
		List<String> lines = Files.readAllLines(path);
		fillStacks(path);
		moveStacks(lines);
		
	}

	private static void moveStacks(List<String> lines) {
		for (int i = 10; i < lines.size();i++)
		{
			int nPops = Integer.parseInt(lines.get(i).split(" ")[1]);
			int iStack = Integer.parseInt(lines.get(i).split(" ")[3]);
			int fStack = Integer.parseInt(lines.get(i).split(" ")[5]);
			operateStacks(nPops, iStack, fStack);
		

			
		}
		System.out.println("********************************************************************");
		System.out.println(stack1);
		System.out.println(stack2);
		System.out.println(stack3);
		System.out.println(stack4);
		System.out.println(stack5);
		System.out.println(stack6);
		System.out.println(stack7);
		System.out.println(stack8);
		System.out.println(stack9);
		System.out.println("********************************************************************");
	}

	private static void operateStacks(int nPops, int iStack, int fStack) {
		Queue<String> aux = new ArrayDeque<String>();
		while (nPops > 0)
		{
			if (iStack == 1)
				aux.add(stack1.pop());
			else if (iStack == 2)
				aux.add(stack2.pop());
			else if (iStack == 3)
				aux.add(stack3.pop());
			else if (iStack == 4)
				aux.add(stack4.pop());
			else if (iStack == 5)
				aux.add(stack5.pop());
			else if (iStack == 6)
				aux.add(stack6.pop());
			else if (iStack == 7)
				aux.add(stack7.pop());
			else if (iStack == 8)
				aux.add(stack8.pop());
			else 
				aux.add(stack9.pop());
			nPops--;
		}
		while (!aux.isEmpty())
		{
			if (fStack == 1)
				stack1.push(aux.remove());
			else if (fStack == 2)
				stack2.push(aux.remove());
			else if (fStack == 3)
				stack3.push(aux.remove());
			else if (fStack == 4)
				stack4.push(aux.remove());
			else if (fStack == 5)
				stack5.push(aux.remove());
			else if (fStack == 6)
				stack6.push(aux.remove());
			else if (fStack == 7)
				stack7.push(aux.remove());
			else if (fStack == 8)
				stack8.push(aux.remove());
			else 
				stack9.push(aux.remove());
		}	
	}

	private static void fillStacks(Path path) throws IOException {
		BufferedReader br = Files.newBufferedReader(path);
		List<String> lines = new ArrayList();
		String line;
		while (!(line = br.readLine()).isBlank())
		{
			lines.add(line);//.split("[ \\[\\]]+"));
		}
		for (String l:lines)
		{
			System.out.println(l);
		}
		int z = 1;
		//mientras no nos pasemos de pila
		while (z<lines.get(lines.size()-1).length()) {
			//System.out.println(lines.get(lines.size()-1).charAt(z));
			//j indica en que pila estamos
			String j = lines.get(lines.size()-1).substring(z, z+1);
			//System.out.println(z);
			//System.out.println(j);
			//por cada plato en la pila desde abajo
			for (int i = lines.size()-2; i >= 0; i--)
			{
				//System.out.println(i);
				//si es la primera pila
				if (j.equals("1"))
				{
					if (!lines.get(i).substring(z, z+1).equals(" "))
						stack1.push(lines.get(i).substring(z, z+1));
					else
						break;
				}
				else if (j.equals("2"))
				{
					if (!lines.get(i).substring(z, z+1).equals(" "))
						stack2.push(lines.get(i).substring(z, z+1));
					else
						break;
				}
				else if (j.equals("3"))
				{
					if (!lines.get(i).substring(z, z+1).equals(" "))
						stack3.push(lines.get(i).substring(z, z+1));
					else
						break;
				}
				else if (j.equals("4"))
				{
					if (!lines.get(i).substring(z, z+1).equals(" "))
						stack4.push(lines.get(i).substring(z, z+1));
					else
						break;
				}
				else if (j.equals("5"))
				{
					if (!lines.get(i).substring(z, z+1).equals(" "))
						stack5.push(lines.get(i).substring(z, z+1));
					else
						break;
				}
				else if (j.equals("6"))
				{
					if (!lines.get(i).substring(z, z+1).equals(" "))
						stack6.push(lines.get(i).substring(z, z+1));
					else
						break;
				}
				else if (j.equals("7"))
				{
					if (!lines.get(i).substring(z, z+1).equals(" "))
						stack7.push(lines.get(i).substring(z, z+1));
					else
						break;
				}
				else if (j.equals("8"))
				{
					if (!lines.get(i).substring(z, z+1).equals(" "))
						stack8.push(lines.get(i).substring(z, z+1));
					else
						break;
				}
				else if (j.equals("9"))
				{
					if (!lines.get(i).substring(z, z+1).equals(" "))
						stack9.push(lines.get(i).substring(z, z+1));
					else
						break;
				}
			}
			z+=4;
		}
		System.out.println(stack1);
		System.out.println(stack2);
		System.out.println(stack3);
		System.out.println(stack4);
		System.out.println(stack5);
		System.out.println(stack6);
		System.out.println(stack7);
		System.out.println(stack8);
		System.out.println(stack9);
	}

}
