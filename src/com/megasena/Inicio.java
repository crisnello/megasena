package com.megasena;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.Vector;

public class Inicio {
	
	public static void main(String[] args) 
	{
		ArrayList l1 = new ArrayList();
		ArrayList l2 = new ArrayList();
		ArrayList l3 = new ArrayList();
		ArrayList l4 = new ArrayList();
		ArrayList l5 = new ArrayList();
		ArrayList l6 = new ArrayList();
		for(int j=0;j<=60;j++){
			l1.add(j, new Integer(0));
			l2.add(j, new Integer(0));
			l3.add(j, new Integer(0));
			l4.add(j, new Integer(0));
			l5.add(j, new Integer(0));
			l6.add(j, new Integer(0));
		}
		
		Vector ret = carga();
		if(ret != null){
			Iterator ite = ret.iterator();
			while(ite.hasNext()){
				ArrayList al = (ArrayList)ite.next();
				for(int x=0;x<6;x++){
					Integer tmp = (Integer) al.get(x);
					if(x == 0){
						Integer integ = ((Integer)l1.get(tmp.intValue()))+1;
						l1.set(tmp.intValue(), integ);
					}
					else if(x == 1){
						Integer integ = ((Integer)l2.get(tmp.intValue()))+1;
						l2.set(tmp.intValue(), integ);
					}else if(x == 2){
						Integer integ = ((Integer)l3.get(tmp.intValue()))+1;
						l3.set(tmp.intValue(), integ);
					}else if(x == 3){
						Integer integ = ((Integer)l4.get(tmp.intValue()))+1;
						l4.set(tmp.intValue(), integ);
					}else if(x == 4){
						Integer integ = ((Integer)l5.get(tmp.intValue()))+1;
						l5.set(tmp.intValue(), integ);
					}else if(x == 5){
						Integer integ = ((Integer)l6.get(tmp.intValue()))+1;
						l6.set(tmp.intValue(), integ);
					}
				}
				
				
			}
			
			ArrayList bigNumber = new ArrayList();
			for(int j=0;j<=6;j++){
				bigNumber.add(j, new Integer(0));
			}
			
			int j1,j2,j3,j4,j5,j6;
			j1 = j2 = j3 = j4 = j5 = j6 =0;
			
			for(int z=0;z<=60;z++){
				System.out.println(z+" : "+l1.get(z)+" "+l2.get(z)+" "+l3.get(z)+" "+l4.get(z)+" "+l5.get(z)+" "+l6.get(z));
				if(((Integer) l1.get(z)).intValue() > ((Integer) bigNumber.get(0)).intValue()){
					bigNumber.set(new Integer(0),l1.get(z));
					j1 = z;
				}
				if(((Integer) l2.get(z)).intValue() > ((Integer) bigNumber.get(1)).intValue()){
					bigNumber.set(new Integer(1),l2.get(z));
					j2 = z;
				}
				if(((Integer) l3.get(z)).intValue() > ((Integer) bigNumber.get(2)).intValue()){
					bigNumber.set(new Integer(2),l3.get(z));
					j3 = z;
				}
				if(((Integer) l4.get(z)).intValue() > ((Integer) bigNumber.get(3)).intValue()){
					bigNumber.set(new Integer(3),l4.get(z));
					j4 = z;
				}
				if(((Integer) l5.get(z)).intValue() > ((Integer) bigNumber.get(4)).intValue()){
					bigNumber.set(new Integer(4),l5.get(z));
					j5 = z;
				}
				if(((Integer) l6.get(z)).intValue() > ((Integer) bigNumber.get(5)).intValue()){
					bigNumber.set(new Integer(5),l6.get(z));
					j6 = z;
				}
			}
			System.out.println("JOGAR :"+j1+" - "+j2+" - "+j3+" - "+j4+" - "+j5+" - "+j6);
			
			
		}
	}
	
	public static Vector carga(){
		
		String fileName = "/home/crisnello/Downloads/d_mega.csv";
		try{
			FileReader fileArq = new FileReader(fileName);
			BufferedReader lerArq = new BufferedReader(fileArq);
			String linha = lerArq.readLine();
			Vector pos = new Vector();
			int posicao = 0;
			boolean lastError;
			while (linha != null) {
		        //System.out.println(linha);
				StringTokenizer st = new StringTokenizer(linha,",");
				ArrayList al = new ArrayList();
				lastError = false;
				try{
					st.nextToken();
					st.nextToken();
					
					for(int i=0;i<6;i++){
						Integer integer = new Integer(st.nextToken());
						al.add(i, integer);
						
						System.out.print(" - "+integer.intValue()+" - ");					
					}
				}catch(NoSuchElementException nsee){
					lastError = true;
				}
				
				if(!lastError){
					System.out.println("");
					pos.add(al);
				}
				posicao++;
				linha = lerArq.readLine(); 
		    }
			lerArq.close();
			return pos;
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}

	}
}
