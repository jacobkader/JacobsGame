//Parent class for all the collectables Coin,Apple and Hearts
class Collectables {
float x;
float y;
float speedX; 
  Collectables(float x_, float y_, float speedX_){
x = x_;
y= y_;
speedX = speedX_;}

void update(){
move();
display();}
// This will be overridden in the child classes.
void move() {
x -= 2;}
// This will be overridden in the child classes.
void display() {
point(x,y); 
point(x,y);}
void effect(){}
// This will be overridden in the child classes.
}
