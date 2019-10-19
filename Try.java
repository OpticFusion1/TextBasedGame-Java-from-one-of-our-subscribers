/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;

import java.util.Random;

/**
 *
 * @author LENOVO
 */
public class Try {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Random gen = new Random();
        
        System.out.println(gen.nextInt(4) +1);
        
        System.out.println((int).2);
        
        
         double tmp_pmana =40 ;
                double tmp_phealth = 100.0;
                
                //regenerate mana
                double y = (double)40 + ((double)100 + (double)40) * .25;
                int x = (int) y;
                
                
              System.out.println(x);
        
    }
    
}
