//class for one of the collectables that adds 1 to the score each time its collected 
class Coin extends Collectables {   
// Variables are inherited from the parent.
 int i = 0;
 PImage g1, g2, g3, g4, g5, g6;
 Coin(float x_, float y_, float speedX_){
super(x_,y_,speedX_);
g1 = loadImage("g1.png");
g2 = loadImage("g2.png");   
g3 = loadImage("g3.png");   
g4 = loadImage("g4.png");  
g5 = loadImage("g5.png");   
g6 = loadImage("g6.png");   }   
void move() {
  super.move();}
//Inherits move from parent class(COLLECTABLES)         
void effect(){
Score +=1;
print("coin");}
//Effect that occurs when the Player collides with Collectable[Coin] 
void display() {
if(i>=0 && i<10)
 {image(g1,x,y);}
else if(i>=10 && i<20)
 {image(g2,x,y);}
else if(i>=20 && i<30)
 {image(g3,x,y);}
else if(i>=30 && i<40)
 {image(g4,x,y);}
else if(i>=40 && i<50)
 {image(g5,x,y);}
else if(i==50)
{image(g6,x,y);
i=0;}
i++;}
//Coin overwrites display and effect  from the parent 
}
   
