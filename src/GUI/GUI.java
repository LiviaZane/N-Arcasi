package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import date.Cautare_DFS;


public class GUI {

	protected static JFrame frame;
	protected static JPanel panel;
	protected static int dim_puzz;
	protected static JComboBox<Integer> cmb;
	protected static JButton btn1;
	protected static List<List<Integer>> tabla;
	
	
	public static void GUI_init(List<List<Integer>> tab){
		JComboBox<Integer> cmb_arcasi;
		JComboBox<Integer> cmb_sageata;
		tabla = new ArrayList<List<Integer>>();
		dim_puzz = tab.get(0).size(); 
		
		for (int i = 0; i < dim_puzz; i++) {
			List<Integer> rows = new ArrayList<>();
			for (int j = 0; j < dim_puzz; j++) {
				rows.add(tab.get(i).get(j).intValue());
			}
			tabla.add(rows);
		}
		
	    frame = new JFrame("Problema N-Arcasi");
	    frame.setSize(1100, 740);
	    frame.setLayout(null);
	    panel = new JPanel();                         // un container in care vom pune butoanele puzzle
	    panel.setLayout(null);
	    panel.setBounds(0, 0, 700, 700);
	    frame.add(panel);
	    
		JLabel  label_dim = new JLabel("Dimensiune Tabla : ");  
	    label_dim.setBounds(700, 20, 120, 30);  
	    frame.add(label_dim); 
		
		Integer cmb_list[] = {4, 5, 6, 7, 8, 9, 10, 11, 12};
		cmb = new JComboBox<Integer>(cmb_list);
		cmb.setMaximumRowCount(5);
		cmb.setBounds(820, 25, 50, 20);
		cmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dim_puzz = (int)cmb.getSelectedItem();
				tabla.clear();
				for (int i = 0; i < dim_puzz; i++) {
					List<Integer> rows = new ArrayList<>();
					for (int j = 0; j < dim_puzz; j++) {
						rows.add(0);
					}
					tabla.add(rows);
				}
				btn1.setEnabled(true);
				update(tabla);
			}
		});
		frame.add(cmb);
		
		JLabel  label_arcasi = new JLabel("Numar arcasi : ");  
	    label_arcasi.setBounds(780, 75, 120, 30);  
	    frame.add(label_arcasi); 
		
		Integer cmb_list_arcasi[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		cmb_arcasi = new JComboBox<Integer>(cmb_list_arcasi);
		cmb_arcasi.setMaximumRowCount(5);
		cmb_arcasi.setBounds(878, 80, 50, 20);
		frame.add(cmb_arcasi);
		
		JLabel  label_sageata = new JLabel("Lungime sageata : ");  
	    label_sageata.setBounds(840, 130, 120, 30);  
	    frame.add(label_sageata); 
	    
		cmb_sageata = new JComboBox<Integer>(cmb_list_arcasi);
		cmb_sageata.setMaximumRowCount(5);
		cmb_sageata.setBounds(958, 135, 50, 20);
		frame.add(cmb_sageata);
		
		JTextArea  label_info = new JTextArea("Pentru activare buton RESTART, "
				+ "schimbati dimensiunea tablei, dupa care, se pot pune ziduri, "
				+ "apasand butoanele din partea stanga.");  
	    label_info.setBounds(700, 240, 363, 60);
	    label_info.setFont(new Font("Helvetica Neue", Font.ITALIC, 14));
	    label_info.setBackground(Color.lightGray);
	    label_info.setDisabledTextColor(Color.BLUE);
	    label_info.setLineWrap(true);
	    label_info.setEnabled(false);
	    frame.add(label_info); 
	    
		btn1 = new JButton("RESTART");
		btn1.setBounds(780, 380, 200, 60);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				List<List<Integer>> tabla_solutie = Cautare_DFS.cautare_DFS(tabla, dim_puzz, 
						(int)cmb_arcasi.getSelectedItem(), (int)cmb_sageata.getSelectedItem()+1);
				boolean comparare = false;	
				for (int i = 0; i < dim_puzz; i++) {
					for (int j = 0; j < dim_puzz; j++) {
						if(tabla.get(i).get(j).intValue() != tabla_solutie.get(i).get(j).intValue()) {
							comparare = true;
							}
						}
					}
				
				if (comparare) {
					for (int i = 0; i < dim_puzz; i++) {
						for (int j = 0; j < dim_puzz; j++) {
							tabla.get(i).set(j, tabla_solutie.get(i).get(j).intValue());
						}
					}
					update(tabla);
					frame.repaint();
				} else {
					JOptionPane.showMessageDialog(null, "Nu exista solutie !");
				}
				btn1.setEnabled(false);
			}
		});
		btn1.setEnabled(false);
		frame.add(btn1);
		update(tabla);			
	    frame.setVisible(true);
	}
	
	
	
	
	public static void update(List<List<Integer>> tabla) {
		// creare dim*dim JButoane pentru Puzzle
		panel.removeAll();
				for (int z = 0; z < dim_puzz; z++) {
					for(int zz = 0; zz < dim_puzz; zz++) {
						int a = tabla.get(z).get(zz).intValue();
						JButton b = new JButton();
						ImageIcon icon = new ImageIcon("img/" + a + ".png");
						Image im = icon.getImage();
			    		Image im2 = im.getScaledInstance(650/dim_puzz, 650/dim_puzz, Image.SCALE_SMOOTH);
			    		b.setIcon(new ImageIcon(im2));		    		
			    		b.setBounds(zz*650/dim_puzz, z*650/dim_puzz, 650/dim_puzz, 650/dim_puzz); //x, y, l, h
			    		b.setMargin(new Insets(0, 0, 0, 0));
			    		b.setName(Integer.toString(z*dim_puzz+zz));               // numele .... btn
			    		b.addActionListener(new ActionListener() {
			    			public void actionPerformed(ActionEvent e) {
			    				if (tabla.get(Integer.parseInt(b.getName())/dim_puzz).get(Integer.parseInt(b.getName())%dim_puzz).intValue() == 2) {
			    					tabla.get(Integer.parseInt(b.getName())/dim_puzz).set(Integer.parseInt(b.getName())%dim_puzz, 0);
			    				} else if (tabla.get(Integer.parseInt(b.getName())/dim_puzz).get(Integer.parseInt(b.getName())%dim_puzz).intValue() == 0) {
			    					tabla.get(Integer.parseInt(b.getName())/dim_puzz).set(Integer.parseInt(b.getName())%dim_puzz, 2);
			    				}
			    				update(tabla);	    				
			    				frame.repaint();
			    			}
			    		});
			    		panel.add(b);
					}
				}
		frame.repaint();
	}

	
}