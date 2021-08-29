//class for one of the collectables that adds 25% to the Health each time its collected 
class Hearts extends Collectables {
// Variables are inherited from the parent.
 public int i = 0;
 PImage l1;
 Hearts(float x_, float y_, float speedX_){
super(x_,y_,speedX_);
l1 = loadImage("l1.png");}
void move() {
 super.move();}  
//Inherits move from parent class(COLLECTABLES) 
void effect(){
health.life += 25;
print("Heart");
if (health.life >= 100)
{health.life=100;}}
//Effect that occurs when the Player collides with Collectable[Hearts] 
void display() {
if(i>=0 && i<10)
{image(l1,x,y);
i=0;
i++;}}
//Heart overwrites display and effect from the parent 
}
