//class for one of the Enemies that takes 25% health each time it bumps into player   
class PoliceOfficer extends Enemy{
// Variables are inherited from the parent.
 int i = 0;
 PImage p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12;
 PoliceOfficer(float x_, float y_, float speedX_, float speedY_){
super(x_,y_,speedX_,speedY_);
p1 = loadImage("p00.png");
p2 = loadImage("p01.png");
p3 = loadImage("p02.png");
p4 = loadImage("p03.png");
p5 = loadImage("p04.png");
p6 = loadImage("p05.png");
p7 = loadImage("p06.png");
p8 = loadImage("p07.png");
p9 = loadImage("p08.png");
p10 = loadImage("p09.png");
p11 = loadImage("p10.png");
p12 = loadImage("p11.png");}
void effect() {
health.life-=25;
print("busted");
if (health.life <= 0  )
{currentGameMode = gameFinished;}}  
//Effect that occurs when the Player collides with Enemy[PoliceOfficer]
void atack() {
  super.atack();}
//Inherits atack from parent class(ENEMY)   
void display(){      
if(i>=0 && i<10)
 {image(p1,x,y);}
else if(i>=10 && i<20)
 {image(p2,x,y);}
else if(i>=20 && i<30)
 {image(p3,x,y);}
else if(i>=30 && i<40)
 {image(p4,x,y);}
else if(i>=40 && i<50)
 {image(p5,x,y);}
else if(i>=50 && i<60)
 {image(p6,x,y);}
else if(i>=60 && i<70)
 {image(p7,x,y);}
else if(i>=70 && i<80)
 {image(p8,x,y);}
else if(i>=80 && i<90)
 {image(p9,x,y);}
else if(i>=90 && i<100)
 {image(p10,x,y);}
else if(i>=100 && i<110)
 {image(p11,x,y);}
else if(i ==110)
{image(p12,x,y);
 i = 0;}
 i++;}
}
//PoliceOfficer overwrites display and effect  from the parent 
    
    
    
