package Days;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * --- Part Two ---
As you watch the crane operator expertly rearrange the crates, you notice the process isn't following your prediction.

Some mud was covering the writing on the side of the crane, and you quickly wipe it away. 
The crane isn't a CrateMover 9000 - it's a CrateMover 9001.

The CrateMover 9001 is notable for many new and exciting features: air conditioning, leather seats, an extra cup holder, 
and the ability to pick up and move multiple crates at once.

Again considering the example above, the crates begin in the same configuration:

    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 
Moving a single crate from stack 2 to stack 1 behaves the same as before:

[D]        
[N] [C]    
[Z] [M] [P]
 1   2   3 
However, the action of moving three crates from stack 1 to stack 3 means that those three moved crates stay in the same order, resulting in this new configuration:

        [D]
        [N]
    [C] [Z]
    [M] [P]
 1   2   3
Next, as both crates are moved from stack 2 to stack 1, they retain their order as well:

        [D]
        [N]
[C]     [Z]
[M]     [P]
 1   2   3
Finally, a single crate is still moved from stack 1 to stack 2, but now it's crate C that gets moved:

        [D]
        [N]
        [Z]
[M] [C] [P]
 1   2   3
In this example, the CrateMover 9001 has put the crates in a totally different order: MCD.

Before the rearrangement process finishes, update your simulation so that the Elves know where they should stand to be ready to unload the final supplies. 
After the rearrangement procedure completes, what crate ends up on top of each stack?

 */
public class Day5Part2 {

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
		Stack<String> aux = new Stack<>();
		while (nPops > 0)
		{
			if (iStack == 1)
				aux.push(stack1.pop());
			else if (iStack == 2)
				aux.push(stack2.pop());
			else if (iStack == 3)
				aux.push(stack3.pop());
			else if (iStack == 4)
				aux.push(stack4.pop());
			else if (iStack == 5)
				aux.push(stack5.pop());
			else if (iStack == 6)
				aux.push(stack6.pop());
			else if (iStack == 7)
				aux.push(stack7.pop());
			else if (iStack == 8)
				aux.push(stack8.pop());
			else 
				aux.push(stack9.pop());
			nPops--;
		}
		while (!aux.isEmpty())
		{
			if (fStack == 1)
				stack1.push(aux.pop());
			else if (fStack == 2)
				stack2.push(aux.pop());
			else if (fStack == 3)
				stack3.push(aux.pop());
			else if (fStack == 4)
				stack4.push(aux.pop());
			else if (fStack == 5)
				stack5.push(aux.pop());
			else if (fStack == 6)
				stack6.push(aux.pop());
			else if (fStack == 7)
				stack7.push(aux.pop());
			else if (fStack == 8)
				stack8.push(aux.pop());
			else 
				stack9.push(aux.pop());
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
