package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class Cautare_BFS {

	static public List<List<Integer>> cautare_BFS(List<List<Integer>> tabla, int k, int n, int w, long noduriBFS[])
	{
		long contor = 0;
		
		Set<String> noduri_vizitate = new HashSet<>();
		Vector<List<List<Integer>>> lista_noduri = new Vector<>();
		lista_noduri.add(tabla);
		
		while(lista_noduri.size() != 0) {
			List<List<Integer>> curent = copie(lista_noduri.elementAt(0));
			if (nr_arcasi(curent) == n) {
				tabla = copie(curent); // copiaza solutia in tabla
				noduriBFS[0] = contor;
				return tabla;
			}
			String s=hash(curent);
			lista_noduri.remove(0);
			if (!noduri_vizitate.contains(s)) {
				noduri_vizitate.add(s);
				for (int i = 0; i < k; i++) {   // se genereaza toti copii si se adauga la stack
					for (int j = 0; j < k; j++) {
						if (Verifica_plasare_arcasi.plasare_arcas(curent, i, j, k, w)) {
							List<List<Integer>> copil = copie(curent);
							copil.get(i).set(j, 1);
							lista_noduri.add(copil);
							contor++;
						}
					}
				}
			}
		}
		noduriBFS[0] = contor;
		return tabla;      // tabla nemodificata
	}

	 public static String hash(List<List<Integer>> list){
	        StringBuilder str = new StringBuilder();
	        for(int i=0; i<list.get(0).size(); i++){
	            for(int j=0; j<list.get(0).size(); j++){
	                str.append(list.get(i).get(j).intValue()+",");
	            }
	        }
	        return str.toString();
	    }
	
	 public static int nr_arcasi(List<List<Integer>> list){
		 int count = 0;
	     for(int i=0; i<list.get(0).size(); i++){
	    	 for(int j=0; j<list.get(0).size() ;j++){
	                if(list.get(i).get(j).intValue() == 1)
	                	count++;
	         }
	     }
	        return count;
	    }

	 public static List<List<Integer>> copie(List<List<Integer>> list){
	    	int r=list.get(0).size();
	        int c=list.get(0).size();
	        List<List<Integer>> copie_tabla = new ArrayList<List<Integer>>();
	        for(int i=0; i<r; i++){
	        	List<Integer> rows = new ArrayList<>();
	            for(int j=0; j<c; j++){
	            	rows.add(list.get(i).get(j).intValue());
	            }
	            copie_tabla.add(rows);
	        }
	        return copie_tabla;
	    }
	 
}
