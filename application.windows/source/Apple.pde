//class for one of the collectables that adds 1 to the players speed each time its collected 
class Apple extends Collectables {
// Variables are inherited from the parent.
 private int i = 0;
 PImage apple;
 Apple(float x_, float y_, float speedX_){
super(x_,y_,speedX_);
apple = loadImage("apple1.png");}
void move() {
   super.move();}
//Inherits move from parent class(COLLECTABLES) 
void effect(){
print("apple");
Characters.speedX +=1;
Characters.speedY +=1;}
//Effect that occurs when the Player collides with Collectable[Apple] 
void display() {
if(i>=0 && i<10){
image(apple,x,y);
i=0;
i++;}
 }
//Apple overwrites display and effect from the parent 
}
