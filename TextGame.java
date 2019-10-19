/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class TextGame {
//continue , try catch, attack rage 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ///
        Scanner inp = new Scanner(System.in);
        Random generator = new Random();
        HashMap<Integer,String> used = new HashMap<>();
        int[] a = new int[] {1,4}; // for normal
        int[] b = new int[] {1,2,4}; // for 3rd turn
        
        
        used.put(1,"Normal");
        used.put(2,"Skill");
        used.put(3,"Special");
        used.put(4,"Regen");
        ///
        
        
       boolean gameover = false;
        
        ///
        int p_health = 100;
        int cpu_health = 100;
        
        int p_mana = 100;
        int cpu_mana = 100;
        ///
        
        ///
        int p_damage;
        int cpu_damage;
        
        int p_manacost;
        int cpu_manacost;
        
        ///
        
        
        
        int count = 1; //loop
        
        try{
        while(!gameover)
        {
            System.out.println("Player");
            System.out.println("Life " + p_health);
            System.out.println("Mana: "+p_mana);
            
            System.out.println();
            
            System.out.println("CPU");
            System.out.println("Life "+cpu_health);
            System.out.println("Mana: "+cpu_mana);
            
            System.out.println();
            
            System.out.println("Turn Count: " + count);
            System.out.print("Input attack: ");
            int p_attack = inp.nextInt();
            
            //Just checking for range
             if(p_attack < 1 || p_attack > 4)
            {
                System.out.println("System: Input out of Range\n\n");
                System.out.println("===============================");
                continue; //ignore what's next and continue
            }
            
            
            
            
            ///check for the attacks
            if( (p_attack == 2) && (count % 3 != 0) )
            {
             System.out.println();
             System.out.println("System: Skill attack only happens every 3rd turn!\n");
             System.out.println("===============================");
             //System.out.print("Input again: ");
             continue;
             
             
            }else if( (p_attack == 3) && (count % 6 != 0))
            {
             System.out.println();   
             System.out.println("System: Skill attack only happens every 6th turn!\n");
             System.out.println("===============================");
             continue;
            
             
            }
            
            ///initially for every loop/turn , To know if it's 3rd or 6th turn
            int cpu_attack= a[generator.nextInt(a.length)];
            //reason cause what ever turn will be set to what it is
            
            if( (count % 6 == 0)) // for 6th turns
            {
             //for 6th turn also means 3rd turn     
                 /*no need for a condition to check both 3rd and 6th counts
                 cause for every 6 count is also a 3rd count or turn */
                cpu_attack = generator.nextInt(4) + 1; //generate random number from 1-4
              
            }else if (count % 3 == 0) // for 3rd turns
            {
                //take note you can use Math class
             cpu_attack = b[generator.nextInt(b.length)];
            }
            ////
            
            
            
         //Process things here
         //PLAYER   
            //you can do this in if else but switch case i a lot more nicer and neat
            switch(p_attack)
            {
                case 1:
                    
                    p_damage = 8;
                    
                    //ATTACK RAGE
                    if(p_health < 20)
                    {
                        double tmp_damage = (double)p_damage;
                        tmp_damage = tmp_damage + (tmp_damage * 0.5);
                        
                        p_damage = (int) tmp_damage;
                        
                    }
                    ///
                    
                    p_manacost = 0;//why did i include this if it's zero lang naman? trip ko lang para di lang malula, it's just my thing
                    
                    cpu_health = cpu_health - p_damage;// this is the attack part
                    p_mana = p_mana - p_manacost;
                break;
                
                case 2:
                    p_damage = 14;
                    p_manacost = 15;
                    
                   //ATTACK RAGE
                    if(p_health < 20)
                    {
                        double tmp_damage = (double)p_damage;
                        tmp_damage = tmp_damage + (tmp_damage * 0.5);
                        
                        p_damage = (int) tmp_damage;
                        
                    }
                    ///
                   
                    cpu_health = cpu_health - p_damage;
                    p_mana = p_mana - p_manacost;
                break;
                
                case 3:
                    p_damage = 30;
                    p_manacost = 30;
                    
                    
                    //ATTACK RAGE
                    if(p_health < 20)
                    {
                        double tmp_damage = (double)p_damage;
                        tmp_damage = tmp_damage + (tmp_damage * 0.5);
                        
                        p_damage = (int) tmp_damage;
                        
                    }
                    ///
                    
                    
                    cpu_health = cpu_health - p_damage;
                    p_mana = p_mana - p_manacost;
                break;
                
                case 4:
                    
                    p_manacost = 5;
                    
                    p_mana = p_mana - p_manacost;
                    
                   double pcurrent_health = (double) p_health;
                   
                  //ADDS HEALTH FOR REGEN 
                  pcurrent_health = pcurrent_health + (pcurrent_health * 0.2 );
                  p_health = (int) pcurrent_health;
                    
                break;
                
                default:
                    
                break;
            }
            ///
            
            
            // CPU
            switch(cpu_attack)
            {
                case 1:
                
                    cpu_damage = 8;
                    cpu_manacost = 0;
                    
                    //ATTACK RAGE
                    if(cpu_health < 20)
                    {
                        double tmpcpu_damage = (double)cpu_damage;
                        tmpcpu_damage = tmpcpu_damage + (tmpcpu_damage * 0.5);
                        
                        cpu_damage = (int) tmpcpu_damage;
                        
                    }
                    ///
                    
                    
                    
                    p_health = p_health - cpu_damage;
                    cpu_mana = cpu_mana - cpu_manacost;
                    
                break;
                
                case 2:
                    
                    cpu_damage = 14;
                    cpu_manacost = 15;
                    
                       //ATTACK RAGE
                    if(cpu_health < 20)
                    {
                        double tmpcpu_damage = (double)cpu_damage;
                        tmpcpu_damage = tmpcpu_damage + (tmpcpu_damage * 0.5);
                        
                        cpu_damage = (int) tmpcpu_damage;
                        
                    }
                    ///
                    
                    
                    
                    p_health = p_health - cpu_damage;
                    cpu_mana = cpu_mana - cpu_manacost;
                    
                break;
                
                case 3:
                    cpu_damage = 30;
                    cpu_manacost = 30;
                    
                       //ATTACK RAGE
                    if(cpu_health < 20)
                    {
                        double tmpcpu_damage = (double)cpu_damage;
                        tmpcpu_damage = tmpcpu_damage + (tmpcpu_damage * 0.5);
                        
                        cpu_damage = (int) tmpcpu_damage;
                        
                    }
                    ///

                    p_health = p_health - cpu_damage;
                    cpu_mana = cpu_mana - cpu_manacost;
                break;
                
                
                case 4:
                     cpu_manacost = 5;
                    
                    cpu_mana = cpu_mana - cpu_manacost;
                    
                   double cpucurrent_health = (double) cpu_health;
                    
                  cpucurrent_health = cpucurrent_health + (cpucurrent_health * 0.2 );
                  cpu_health = (int) cpucurrent_health;
                break;
                
                default:
                     
                break;
            }
            
            //Mana regeneration
            
            if(p_mana < 50)
            {
                double tmp_pmana = (double) p_mana;
                double tmp_phealth = (double) p_health;
                
                //regenerate mana
                tmp_pmana = tmp_pmana + (tmp_phealth + tmp_pmana) * .25;
                
                p_mana = (int)tmp_pmana;
                
                
            }
            
            if(cpu_mana < 50)
            {
                 double tmp_cpumana = (double) cpu_mana;
                double tmp_cpuhealth = (double) cpu_health;
                
                //regenerate mana
                tmp_cpumana = tmp_cpumana + (tmp_cpuhealth + tmp_cpumana) * .25;
                
                cpu_mana = (int)tmp_cpumana;
            }
            
            
          
            
            
            ///
            
            System.out.println();
            
            System.out.println("Player used: "+used.get(p_attack));
            System.out.println("CPU used: "+used.get(cpu_attack));
            System.out.println("===============================");
            System.out.println();
            System.out.println();
            
            count++;// Turn count
            
            
              ///check the winner
              if(p_health <=0)
              {
               p_health =0;
               System.out.println("\n\nCPU WON THE GAME!"); 
               System.out.println(); 
               System.out.println("Player HP: "+p_health);
               System.out.println("CPU HP: "+cpu_health);
               gameover = true;
              }else if(cpu_health <=0)
              {
                cpu_health = 0;
                System.out.println("\n\nPLAYER WON THE GAME!"); 
                System.out.println(); 
                System.out.println("Player HP: "+p_health);
                System.out.println("CPU HP: "+cpu_health);
                gameover= true;
              }
            ///
            
           
        }//while loop bracket
        
         }catch(InputMismatchException ex){// try catch breacket
                System.out.println("\nIncorrect type of Input");
            }
        
    }
    
}
