package test;

import java.util.List;

public class Afisare {

		static public void afisare_solutie(List<List<Integer>> tabla, int k){
				for (int i = 0; i < k; i++) {
					for (int j = 0; j < k; j++)
						System.out.print(" " + tabla.get(i).get(j).intValue()
										+ " ");
					System.out.println();
				}
			}

}
