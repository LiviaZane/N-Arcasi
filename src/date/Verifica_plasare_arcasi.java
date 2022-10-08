package date;

import java.util.List;

public class Verifica_plasare_arcasi {

	// Verifica daca un arcas poate fi plasat
			static boolean plasare_arcas(List<List<Integer>> tabla, int row, int col, int k, int w)
			{
				
				// daca exista un zid in celula row/col, returneaza false
				if(tabla.get(row).get(col).intValue() == 2)
					return false;
				
				int i, j;    // indecsi linie/coloana
				int ii;      // contor pentru w .... incrementeaza doar cat este w
			
				// Verifica pe linie .....la dreapta
				for (i = col, ii = 0; i >= 0 && ii < w ; i--, ii++) {
					if (tabla.get(row).get(i).intValue() == 2)	   // daca se intalneste un zid,			
						break;      // se inceteaza cautarea, deoarece nu intereseaza arcasii de
									             // dupa zid, pentru ca nu se mai ataca intre ei
					if (tabla.get(row).get(i).intValue() == 1)				
						return false;
						
				}
				
				// Verifica pe linie .....la stanga 
				for (i = col, ii = 0; i < k && ii < w; i++, ii++) {
					if (tabla.get(row).get(i).intValue() == 2)				
						break;
					if (tabla.get(row).get(i).intValue() == 1)				
						return false;
				}
				
				
				// Verifica pe coloana ..... in jos 
				for (i = row, ii = 0; i >= 0 && ii < w; i--, ii++) {
					if (tabla.get(i).get(col).intValue() == 2)				
						break;
					if (tabla.get(i).get(col).intValue() == 1)				
						return false;
				}
				// Verifica pe coloana ..... in sus
				for (i = row, ii = 0; i < k && ii < w; i++, ii++) {
					if (tabla.get(i).get(col).intValue() == 2)				
						break;
					if (tabla.get(i).get(col).intValue() == 1)				
						return false;
				}
				
				// Verifica diagonala principala....in sus
				for (i = row, j = col, ii = 0; i >= 0 && j >= 0 && ii < w; i--, j--, ii++) {
					if (tabla.get(i).get(j).intValue() == 2)				
						break;
					if (tabla.get(i).get(j).intValue() == 1)
						return false;
				}

				// Verifica diagonala principala ...in jos
				for (i = row, j = col, ii = 0; j < k && i < k && ii < w; i++, j++, ii++){
					if (tabla.get(i).get(j).intValue() == 2)				
						break;
					if (tabla.get(i).get(j).intValue() == 1)
						return false;
				}

				// Verifica diagonala secundara....in sus
				for (i = row, j = col, ii = 0; i >= 0 && j < k && ii < w; i--, j++, ii++){
					if (tabla.get(i).get(j).intValue() == 2)				
						break;
					if (tabla.get(i).get(j).intValue() == 1)
						return false;
				}

				// Verifica diagonala secundara ...in jos
				for (i = row, j = col, ii = 0; j >= 0 && i < k && ii < w; i++, j--, ii++){
					if (tabla.get(i).get(j).intValue() == 2)				
						break;
					if (tabla.get(i).get(j).intValue() == 1)
						return false;
				}
				
				return true;       // daca poate fi plasat arcasul in patratelul row/col
			}

		
	}
