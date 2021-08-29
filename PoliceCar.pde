//class for one of the Enemies that takes 100% health each time it bumps into player
class PoliceCar extends Enemy{
// Variables are inherited from the parent.
  int x7;
  int i = 0;
  PImage pc1, pc2, pc3, pc4, pc5, pc6, pc7, pc8;
  PoliceCar(float x_, float y_, float speedX_, float speedY_){
super(x_,y_,speedX_,speedY_);
pc1 = loadImage("car1.png");
pc2 = loadImage("car2.png");
pc3 = loadImage("car3.png");
pc4 = loadImage("car4.png");
pc5 = loadImage("car5.png");
pc6 = loadImage("car6.png");
pc7 = loadImage("car7.png");
pc8 = loadImage("car8.png");}
void atack() {
  super.atack();}  
//Inherits atack from parent class(ENEMY) 
void effect(){
health.life= 0;
print("busted");
if (health.life <= 0  )
{currentGameMode = gameFinished;}
}
//Effect that occurs when the Player bumps into Enemy[PoliceCar]) 
void display(){    
if(i>=0 && i<10)
 {image(pc1,x,y);}
else if(i>=10 && i<20)
 {image(pc2,x,y);}
else if(i>=20 && i<30)
 {image(pc3,x,y);}
else if(i>=30 && i<40)
 {image(pc4,x,y);}
else if(i>=40 && i<50)
 {image(pc5,x,y);}
else if(i>=50 && i<60)
 {image(pc6,x,y);}
else if(i>=60 && i<70)
 {image(pc7,x,y);}
else if(i>70 && i<80)
 {image(pc8,x,y);
  i = 0;}
  i++;}
}
//Policecar overwrites display and effect  from the parent 
