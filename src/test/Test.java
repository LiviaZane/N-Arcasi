package test;

import java.util.ArrayList;
import java.util.List;


public class Test {
	
	public static void main(String args[]){
		
		long noduriDFS[] = {0};         // matrici, pentru ca sunt stocate ca variabile locale
		long noduriBFS[] = {0};         // si sunt updatate in functiile Cautare_DSF/BSF
		
		long timpDFS, timpBFS, t0DFS, t0BFS; // timpii procesor [nano secunde]
		
		int k = 6, n = 7, w = 6, z = 1; // patratele, arcasi, lungime sageata, ziduri
		int x = 0, y = 0;
		
		List<List<Integer>> tablaDFS = new ArrayList<List<Integer>>();
		List<List<Integer>> tablaBFS = new ArrayList<List<Integer>>();
		
		// Setul 1, tabla 4 sau 5, arcasi la fel sau -1 si ziduri la fel sau +1
		for (int i = 0; i < 10; i++) {
			noduriDFS[0] = 0;
			noduriBFS[0] = 0;
			k = (int)(Math.random() * (5 - 4 + 1) + 4);    // alegem k
			w = k;
			
			for (int i1 = 0; i1 < k; i1++) {              // construim tabla goala
				List<Integer> rows = new ArrayList<>();
				List<Integer> rowss = new ArrayList<>();
				for (int j = 0; j < k; j++) {
					rows.add(0);
					rowss.add(0);
				}
				tablaDFS.add(rows);
				tablaBFS.add(rowss);
			}	
			
			if (i % 2 == 0) {
				n = k;
				z = 0;
			} else {
				n = k - 1;
				z = 1;
				x = (int) (Math.random() * (3 - 0 + 1) + 0);
				if (x<0)
					x = 0;
				y = (int) (Math.random() * (3 - 0 + 1) + 0);
				if(y<0)
					y = 0;
				tablaDFS.get(x).set(y, 2);           // punem un zid in DFS
				tablaBFS.get(x).set(y, 2);           // punem acelasi zid in BFS
				if (i == 9) {
					if (k<5)
						k = 5;
					tablaDFS.get(y).set(x, 2);           // mai punem un zid in DFS
					tablaBFS.get(y).set(x, 2);           // punem acelasi zid in BFS
					n = n + 2;
					z++;
				}
			}
			
			
			t0DFS = System.nanoTime();
			List<List<Integer>> tabla_solutieDFS = Cautare_DFS.cautare_DFS(tablaDFS, k, n, w, noduriDFS);
			timpDFS = System.nanoTime() - t0DFS;
			boolean comparareDFS = false;	
			for (int iii = 0; iii < k; iii++) {
				for (int j = 0; j < k; j++) {
					if(tablaDFS.get(iii).get(j).intValue() != tabla_solutieDFS.get(iii).get(j).intValue()) {
						comparareDFS = true;
					}
				}
			}	
			if (comparareDFS) {
				Afisare.afisare_solutie(tabla_solutieDFS, k);
				System.out.print("Test " + i + ",    Patratele = " + k + "x" + k + ",    "
						+ "Arcasi = " + n +
						",    Lung.sageata = " + w + "    Nr.ziduri = " + z);
				System.out.print(",    Noduri DFS - " + noduriDFS[0]);
				System.out.println(",    Timp DFS [nanosec] = " + timpDFS);
			} else {
				System.out.println("Test " + i + ",   Nu exista solutie");
				System.out.print("Patratele = " + k + "x" + k + ",    Arcasi = " + n +
						",    Lung.sageata = " + w + "    Nr.ziduri = " + z);
				System.out.print(",    Noduri DFS - " + noduriDFS[0]);
				System.out.println(",   Timp DFS [nanosec] = " + timpDFS);
			}
			
			t0BFS = System.nanoTime();
			List<List<Integer>> tabla_solutieBFS = Cautare_BFS.cautare_BFS(tablaBFS, k, n, w, noduriBFS);
			timpBFS = System.nanoTime() - t0BFS;
			boolean comparareBFS = false;	
			for (int iii = 0; iii < k; iii++) {
				for (int j = 0; j < k; j++) {
					if(tablaBFS.get(iii).get(j).intValue() != tabla_solutieBFS.get(iii).get(j).intValue()) {
						comparareBFS = true;
					}
				}
			}
			if (comparareBFS) {
				Afisare.afisare_solutie(tabla_solutieBFS, k);
				System.out.print("Test " + i + ",   Patratele = " + k + "x" + k + ",    Arcasi = " + n +
						",    Lung.sageata = " + w + "    Nr.ziduri = " + z);
				System.out.print(",    Noduri BFS - " + noduriBFS[0]);
				System.out.println(",    Timp BFS [nanosec] = " + timpBFS);
			} else {
				System.out.println("Test " + i + ",   Nu exista solutie");
				System.out.print("Patratele = " + k + "x" + k + ",    Arcasi = " + n +
						",    Lung.sageata = " + w + "    Nr.ziduri = " + z);
				System.out.print(",    Noduri BFS - " + noduriBFS[0]);
				System.out.println(",    Timp BFS [nanosec] = " + timpBFS);
			}
			
			tablaDFS.clear();
			tablaBFS.clear();
			tabla_solutieDFS.clear();
			tabla_solutieBFS.clear();
		}
		
		
		// Setul 2, tabla 6 sau 7, arcasi la fel sau -1 si ziduri +1 sau +2
		for (int i = 0; i < 10; i++) {
			noduriDFS[0] = 0;
			noduriBFS[0] = 0;
			k = (int)(Math.random() * (7 - 6 + 1) + 6);    // alegem k
			w = k;
			
			for (int i1 = 0; i1 < k; i1++) {              // construim tabla goala
				List<Integer> rows = new ArrayList<>();
				List<Integer> rowss = new ArrayList<>();
				for (int j = 0; j < k; j++) {
					rows.add(0);
					rowss.add(0);
				}
				tablaDFS.add(rows);
				tablaBFS.add(rowss);
			}
			
			if (k % 2 == 0) {
				n = k;
				z = 0;
				x = (int) (Math.random() * (5 - 0 + 1) + 0);
				if (x<0)
					x = 0;
				y = (int) (Math.random() * (5 - 0 + 1) + 0);
				if(y<0)
					y = 0;
				tablaDFS.get(x).set(y, 2);           // punem un zid in DFS
				tablaBFS.get(x).set(y, 2);           // punem acelasi zid in BFS
			} else {
				n = k - 1;
				z = 1;
				x = (int) (Math.random() * (5 - 0 + 1) + 0);
				if (x<0)
					x = 0;
				y = (int) (Math.random() * (5 - 0 + 1) + 0);
				if(y<0)
					y = 0;
				tablaDFS.get(x).set(y, 2);           // punem un zid in DFS
				tablaBFS.get(x).set(y, 2);           // punem acelasi zid in BFS
				x = (int) (Math.random() * (4 - 0 + 1) + 1);
				if (x<0)
					x = 0;
				y = (int) (Math.random() * (4 - 0 + 1) + 1);
				if(y<0)
					y = 0;
				tablaDFS.get(x).set(y, 2);           // punem un zid in DFS
				tablaBFS.get(x).set(y, 2);           // punem acelasi zid in BFS
				if (i == 9) {
					tablaDFS.get(y).set(x, 2);           // mai punem un zid in DFS
					tablaBFS.get(y).set(x, 2);           // punem acelasi zid in BFS
					n = n + 2;
					z = 3;
					if (k<7)
						k = 7;
				}
			}
			
			
			t0DFS = System.nanoTime();
			List<List<Integer>> tabla_solutieDFS = Cautare_DFS.cautare_DFS(tablaDFS, k, n, w, noduriDFS);
			timpDFS = System.nanoTime() - t0DFS;
			boolean comparareDFS = false;	
			for (int iii = 0; iii < k; iii++) {
				for (int j = 0; j < k; j++) {
					if(tablaDFS.get(iii).get(j).intValue() != tabla_solutieDFS.get(iii).get(j).intValue()) {
						comparareDFS = true;
					}
				}
			}	
			if (comparareDFS) {
				Afisare.afisare_solutie(tabla_solutieDFS, k);
				System.out.print("Test " + i + ",    Patratele = " + k + "x" + k + ",    "
						+ "Arcasi = " + n +
						",    Lung.sageata = " + w + "    Nr.ziduri = " + z);
				System.out.print(",    Noduri DFS - " + noduriDFS[0]);
				System.out.println(",    Timp DFS [nanosec] = " + timpDFS);
			} else {
				System.out.println("Test " + i + ",   Nu exista solutie");
				System.out.print("Patratele = " + k + "x" + k + ",    Arcasi = " + n +
						",    Lung.sageata = " + w + "    Nr.ziduri = " + z);
				System.out.print(",    Noduri DFS - " + noduriDFS[0]);
				System.out.println(",   Timp DFS [nanosec] = " + timpDFS);
			}
			
			t0BFS = System.nanoTime();
			List<List<Integer>> tabla_solutieBFS = Cautare_BFS.cautare_BFS(tablaBFS, k, n, w, noduriBFS);
			timpBFS = System.nanoTime() - t0BFS;
			boolean comparareBFS = false;	
			for (int iii = 0; iii < k; iii++) {
				for (int j = 0; j < k; j++) {
					if(tablaBFS.get(iii).get(j).intValue() != tabla_solutieBFS.get(iii).get(j).intValue()) {
						comparareBFS = true;
					}
				}
			}
			if (comparareBFS) {
				Afisare.afisare_solutie(tabla_solutieBFS, k);
				System.out.print("Test " + i + ",   Patratele = " + k + "x" + k + ",    Arcasi = " + n +
						",    Lung.sageata = " + w + "    Nr.ziduri = " + z);
				System.out.print(",    Noduri BFS - " + noduriBFS[0]);
				System.out.println(",    Timp BFS [nanosec] = " + timpBFS);
			} else {
				System.out.println("Test " + i + ",   Nu exista solutie");
				System.out.print("Patratele = " + k + "x" + k + ",    Arcasi = " + n +
						",    Lung.sageata = " + w + "    Nr.ziduri = " + z);
				System.out.print(",    Noduri BFS - " + noduriBFS[0]);
				System.out.println(",    Timp BFS [nanosec] = " + timpBFS);
			}
			
			tablaDFS.clear();
			tablaBFS.clear();
			tabla_solutieDFS.clear();
			tabla_solutieBFS.clear();
		}

		
		// Setul 3, tabla 8 sau 9, arcasi 0 sau -1 si ziduri 1 sau 2, sageata 0 sau -1
				for (int i = 0; i < 10; i++) {
					noduriDFS[0] = 0;
					k = (int)(Math.random() * (9 - 8 + 1) + 8);    // alegem k
					w = k;
					
					for (int i1 = 0; i1 < k; i1++) {              // construim tabla goala
						List<Integer> rows = new ArrayList<>();
						List<Integer> rowss = new ArrayList<>();
						for (int j = 0; j < k; j++) {
							rows.add(0);
							rowss.add(0);
						}
						tablaDFS.add(rows);
					}
					
					if (k % 2 == 0) {
						n = k;
						z = 1;
						x = (int) (Math.random() * (8 - 0 + 1) + 0);
						if (x<0)
							x = 0;
						y = (int) (Math.random() * (8 - 0 + 1) + 0);
						if(y<0)
							y = 0;
						tablaDFS.get(x).set(y, 2);           // punem un zid in DFS
					} else {
						n = k - 1;
						z = 2;
						x = (int) (Math.random() * (8 - 0 + 1) + 0);
						if (x<0)
							x = 0;
						y = (int) (Math.random() * (8 - 0 + 1) + 0);
						if(y<0)
							y = 0;
						tablaDFS.get(x).set(y, 2);           // punem un zid in DFS
						x = (int) (Math.random() * (6 - 0 + 1) + 0);
						if (x<0)
							x = 0;
						y = (int) (Math.random() * (6 - 0 + 1) + 0);
						if(y<0)
							y = 0;
						tablaDFS.get(x).set(y, 2);           // punem un zid in DFS
						if (i == 9) {
							tablaDFS.get(y).set(x, 2);           // mai punem un zid in DFS
							k = 9;
							n = k - 1;
							z = 3;
							
						}
					}
					
					
					t0DFS = System.nanoTime();
					List<List<Integer>> tabla_solutieDFS = Cautare_DFS.cautare_DFS(tablaDFS, k, n, w, noduriDFS);
					timpDFS = System.nanoTime() - t0DFS;
					boolean comparareDFS = false;	
					for (int iii = 0; iii < k; iii++) {
						for (int j = 0; j < k; j++) {
							if(tablaDFS.get(iii).get(j).intValue() != tabla_solutieDFS.get(iii).get(j).intValue()) {
								comparareDFS = true;
							}
						}
					}	
					if (comparareDFS) {
						Afisare.afisare_solutie(tabla_solutieDFS, k);
						System.out.print("Test " + i + ",    Patratele = " + k + "x" + k + ",    "
								+ "Arcasi = " + n +
								",    Lung.sageata = " + w + "    Nr.ziduri = " + z);
						System.out.print(",    Noduri DFS - " + noduriDFS[0]);
						System.out.println(",    Timp DFS [nanosec] = " + timpDFS);
					} else {
						System.out.println("Test " + i + ",   Nu exista solutie");
						System.out.print("Patratele = " + k + "x" + k + ",    Arcasi = " + n +
								",    Lung.sageata = " + w + "    Nr.ziduri = " + z);
						System.out.print(",    Noduri DFS - " + noduriDFS[0]);
						System.out.println(",   Timp DFS [nanosec] = " + timpDFS);
					}
					
					tablaDFS.clear();
					tabla_solutieDFS.clear();
				}

				
				// Setul 4, tabla 10 sau 11, arcasi 0 sau +1 si ziduri 1, 2 sau 3, sageata 0
				for (int i = 0; i < 10; i++) {
					noduriDFS[0] = 0;
					k = (int)(Math.random() * (11 - 10 + 1) + 10);    // alegem k
					k = 10;
					w = k;
					
					for (int i1 = 0; i1 < k; i1++) {              // construim tabla goala
						List<Integer> rows = new ArrayList<>();
						List<Integer> rowss = new ArrayList<>();
						for (int j = 0; j < k; j++) {
							rows.add(0);
							rowss.add(0);
						}
						tablaDFS.add(rows);
					}
					
					if (k % 2 == 0) {
						n = k;
						z = 1;
						x = (int) (Math.random() * (9 - 0 + 1) + 0);
						if (x<0)
							x = 0;
						y = (int) (Math.random() * (9 - 0 + 1) + 0);
						if(y<0)
							y = 0;
						tablaDFS.get(x).set(y, 2);           // punem un zid in DFS
						if (k%4 == 0) {
							x = (int) (Math.random() * (9 - 0 + 1) + 0);
							if (x<0)
								x = 0;
							y = (int) (Math.random() * (9 - 0 + 1) + 0);
							if(y<0)
								y = 0;
							tablaDFS.get(x).set(y, 2);           // mai punem un zid in DFS
							z++;
						}
					} else {
						n = k + 1;
						z = 2;
						x = (int) (Math.random() * (9 - 0 + 1) + 0);
						if (x<0)
							x = 0;
						y = (int) (Math.random() * (9 - 0 + 1) + 0);
						if(y<0)
							y = 0;
						tablaDFS.get(x).set(y, 2);           // punem un zid in DFS
						x = (int) (Math.random() * (9 - 0 + 1) + 0);
						if (x<0)
							x = 0;
						y = (int) (Math.random() * (9 - 0 + 1) + 0);
						if(y<0)
							y = 0;
						tablaDFS.get(x).set(y, 2);           // mai punem un zid in DFS
						if (i%3 == 0) {
							x = (int) (Math.random() * (9 - 0 + 1) + 0);
							if (x<0)
								x = 0;
							y = (int) (Math.random() * (9 - 0 + 1) + 0);
							if(y<0)
								y = 0;
							tablaDFS.get(x).set(y, 2);           // mai punem un zid in DFS
							z++;
						}
						if (i == 9) {
							k = 11;
							n = k+2;
							x = (int) (Math.random() * (9 - 0 + 1) + 0);
							if (x<0)
								x = 0;
							y = (int) (Math.random() * (9 - 0 + 1) + 0);
							if(y<0)
								y = 0;
							tablaDFS.get(x).set(y, 2);           // mai punem un zid in DFS
							z++;
						}
					}
					
					
					t0DFS = System.nanoTime();
					List<List<Integer>> tabla_solutieDFS = Cautare_DFS.cautare_DFS(tablaDFS, k, n, w, noduriDFS);
					timpDFS = System.nanoTime() - t0DFS;
					boolean comparareDFS = false;	
					for (int iii = 0; iii < k; iii++) {
						for (int j = 0; j < k; j++) {
							if(tablaDFS.get(iii).get(j).intValue() != tabla_solutieDFS.get(iii).get(j).intValue()) {
								comparareDFS = true;
							}
						}
					}	
					if (comparareDFS) {
						Afisare.afisare_solutie(tabla_solutieDFS, k);
						System.out.print("Test " + i + ",    Patratele = " + k + "x" + k + ",    "
								+ "Arcasi = " + n +
								",    Lung.sageata = " + w + "    Nr.ziduri = " + z);
						System.out.print(",    Noduri DFS - " + noduriDFS[0]);
						System.out.println(",    Timp DFS [nanosec] = " + timpDFS);
					} else {
						System.out.println("Test " + i + ",   Nu exista solutie");
						System.out.print("Patratele = " + k + "x" + k + ",    Arcasi = " + n +
								",    Lung.sageata = " + w + "    Nr.ziduri = " + z);
						System.out.print(",    Noduri DFS - " + noduriDFS[0]);
						System.out.println(",   Timp DFS [nanosec] = " + timpDFS);
					}
					
					tablaDFS.clear();
					tabla_solutieDFS.clear();
				}
	
		
/*		
           // Test unic .....trebuie modificati k, w, n si z, conform modelului care trebuie testat
			noduriDFS[0] = 0;
			k = 8;    // alegem k
			w = k;
			n = 9;
			z = 4;
			
			for (int i1 = 0; i1 < k; i1++) {              // construim tabla goala
				List<Integer> rows = new ArrayList<>();
				List<Integer> rowss = new ArrayList<>();
				for (int j = 0; j < k; j++) {
					rows.add(0);
					rowss.add(0);
				}
				tablaDFS.add(rows);
			}
			
			tablaDFS.get(2).set(0, 2);           // punem un zid in DFS
			tablaDFS.get(4).set(5, 2);           // punem un zid in DFS
			tablaDFS.get(6).set(3, 2);           // punem un zid in DFS
			tablaDFS.get(7).set(7, 2);           // mai punem un zid in DFS
			
			
			t0DFS = System.nanoTime();
			List<List<Integer>> tabla_solutieDFS = Cautare_DFS.cautare_DFS(tablaDFS, k, n, w, noduriDFS);
			timpDFS = System.nanoTime() - t0DFS;
			boolean comparareDFS = false;	
			for (int iii = 0; iii < k; iii++) {
				for (int j = 0; j < k; j++) {
					if(tablaDFS.get(iii).get(j).intValue() != tabla_solutieDFS.get(iii).get(j).intValue()) {
						comparareDFS = true;
					}
				}
			}	
			if (comparareDFS) {
				Afisare.afisare_solutie(tabla_solutieDFS, k);
				System.out.print("Test " + 1 + ",    Patratele = " + k + "x" + k + ",    "
						+ "Arcasi = " + n +
						",    Lung.sageata = " + w + "    Nr.ziduri = " + z);
				System.out.print(",    Noduri DFS - " + noduriDFS[0]);
				System.out.println(",    Timp DFS [nanosec] = " + timpDFS);
			} else {
				System.out.println("Test " + 1 + ",   Nu exista solutie");
				System.out.print("Patratele = " + k + "x" + k + ",    Arcasi = " + n +
						",    Lung.sageata = " + w + "    Nr.ziduri = " + z);
				System.out.print(",    Noduri DFS - " + noduriDFS[0]);
				System.out.println(",   Timp DFS [nanosec] = " + timpDFS);
			}
			
			tablaDFS.clear();
			tabla_solutieDFS.clear();
*/		
		
	}
}
