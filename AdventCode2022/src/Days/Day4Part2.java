package Days;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * --- Part Two ---
It seems like there is still quite a bit of duplicate work planned. Instead, the Elves would like to know the number of pairs that overlap at all.

In the above example, the first two pairs (2-4,6-8 and 2-3,4-5) don't overlap, while the remaining four pairs (5-7,7-9, 2-8,3-7, 6-6,4-6, and 2-6,4-8) do overlap:

5-7,7-9 overlaps in a single section, 7.
2-8,3-7 overlaps all of the sections 3 through 7.
6-6,4-6 overlaps in a single section, 6.
2-6,4-8 overlaps in sections 4, 5, and 6.
So, in this example, the number of overlapping assignment pairs is 4.

In how many assignment pairs do the ranges overlap?
859
 */
public class Day4Part2 {
	public static void main(String[] args) throws IOException {
		pairsContained();

	}

	private static void pairsContained() throws IOException {
		String relativePath = "../AdventCode2022/src/Inputs/InputDay4.txt";
		Path path = Paths.get(relativePath);
		int pairsOverlapped = 0;
		List<String> lines = Files.readAllLines(path);
		//se lee cada linea

		for (String line : lines) {
		//String line = "1-84,8-83";
			String pair1 = line.split(",")[0];
			String pair2 = line.split(",")[1];
			int d1 = Integer.parseInt(pair1.split("-")[0]);
			int d2 = Integer.parseInt(pair1.split("-")[1]);
			int d3 = Integer.parseInt(pair2.split("-")[0]);
			int d4 = Integer.parseInt(pair2.split("-")[1]);
			
			if(d1 >= d3 && d1 <= d4 || d2 >= d3 && d2 <= d4 || d3 >= d1 && d4 <= d1 || d3 >= d2 && d4 <= d2 || d1 >= d3 && d2 <= d4 || d1 <= d3 && d2 >= d4)
			{
				pairsOverlapped++;
			}
			
		}
		System.out.println(pairsOverlapped);
	}
}

