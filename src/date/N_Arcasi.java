package date;

import java.util.ArrayList;
import java.util.List;

import GUI.GUI;

public class N_Arcasi {

	public static void main(String args[]) {
		
		int k = 12, n = 12, w = 12;   // dimensiune tabla, numar arcasi si lungime zbor sageata
		
		List<List<Integer>> tabla = new ArrayList<List<Integer>>();
		for (int i = 0; i < k; i++) {
			List<Integer> rows = new ArrayList<>();
			for (int j = 0; j < k; j++) {
				rows.add(0);
			}
			tabla.add(rows);
		}
		
		List<List<Integer>> tabla_solutie = Cautare_DFS.cautare_DFS(tabla, k, n, w);
//		List<List<Integer>> tabla_solutie = Cautare_BFS.cautare_BFS(tabla, k, n, w);
		
		GUI.GUI_init(tabla_solutie);	
	}
	
}
