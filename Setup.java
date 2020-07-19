package snakegame;

import java.util.ArrayList;

import processing.core.PApplet;

public class Setup extends PApplet {

	ArrayList<Integer> X_pos=new ArrayList<Integer>();
	ArrayList<Integer> Y_pos=new ArrayList<Integer>();
	int hgt=24,widt=24;
	int block=20;
	int dir=2;
	int [] x_dir= {0,0,1,-1};
	int [] y_dir= {1,-1,0,0};
	int f_x=14;
	int f_y=14;
	boolean gameStatus=false;
	int speed=10;
	
	 public void setup() {
		 size(500,500);
		 X_pos.add(4);
		 Y_pos.add(15);
	 }
	 public void draw() {
		 background(0);
		 fill(255);
		 
		 for(int i=0;i<X_pos.size();i++) {
			 rect(X_pos.get(i)*block,Y_pos.get(i)*block,block,block);
		 }
		 if(!gameStatus) {
			 fill(255);
			 rect(f_x*block,f_y*block,block,block);
			 textAlign(LEFT);
			 textSize(25);
			 fill(255);
			 text("Score:"+X_pos.size(),0,20);
		
		 if(frameCount%speed==0) { 
			 X_pos.add(0,X_pos.get(0)+x_dir[dir]);
		     Y_pos.add(0,Y_pos.get(0)+y_dir[dir]);
		     if(X_pos.get(0)<=0 || Y_pos.get(0)<=0 || X_pos.get(0)>widt || Y_pos.get(0)>hgt) {
				 gameStatus=true;
			 }
			 for(int i=1;i<X_pos.size();i++) {
				 if(X_pos.get(0)==X_pos.get(i) && Y_pos.get(0)==Y_pos.get(i)) {
					 gameStatus=true;
				 }
			 }
		     
		     if(X_pos.get(0)==f_x && Y_pos.get(0)==f_y) {
		    	  if(X_pos.size()%2==0 && speed>=2) {
					 speed=speed-1;
				 }
				 f_x=(int)random(0,widt);
		    	 f_y=(int)random(0,hgt);
		     }
		 
		     else {
		        X_pos.remove(X_pos.size()-1); 
		        Y_pos.remove(Y_pos.size()-1);
		     }
		 }
		 }    else {
		    	 fill(222,9,12);
		    	 textAlign(CENTER);
		    	 textSize(30);
		    	 text("Game Over \n Score:" + X_pos.size()+ "\n Press Enter",500/2,500/2);
		    	 if(keyCode==ENTER) {
		    		 X_pos.clear();
		    		 Y_pos.clear();
		    		 X_pos.add(4);
		    		 Y_pos.add(15);
		    		 dir=2;
		    		 speed=10;
		    		 gameStatus=false;
		    	 }
		    }
	 }
	
	  public void keyPressed() { 
		  int new_dir=keyCode; 
		  if(keyCode==DOWN) {new_dir=0; }
		  else if(keyCode==UP) { new_dir=1; } 
		  else if(keyCode==RIGHT) { new_dir=2; }
		  else if(keyCode==LEFT) { new_dir=3; }
		  else { new_dir=-1; }
	  if(new_dir!=-1) 
	  { dir=new_dir; }
	  
	  
	  }
	 

}
