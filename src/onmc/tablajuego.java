/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onmc;
import java.util.Random;

public class tablajuego {
    private final int[][] PANTANO=new int [5][5];
    private int personas=7;
    private int cazadores=2;

    public void pantanoPersonas(int p, int c){	
		//Colocacion de personas en el Pantano
		Random rnd=new Random();
		
		for (int i=0; i<p; i++){				//Bañistas aleatorios
			int x=rnd.nextInt(PANTANO.length);
			int y=rnd.nextInt(PANTANO[0].length);
			PANTANO[x][y]=1;
		}
		
		for (int i=0; i<c; i++){				//Cazadores aleatorios
			int x=rnd.nextInt(PANTANO.length);
			int y=rnd.nextInt(PANTANO[0].length);
			if (PANTANO[x][y]!=1)
				PANTANO[x][y]=2;
		}
    }
}