//Parent class for all the Enemies PoliceOfficer and Policecar
class Enemy{
int i =0;
float x;
float y;
float speedX;
float speedY;    
  Enemy(float x_, float y_, float speedX_, float speedY_){
x = x_;
y= y_;
speedX = speedX_;
speedY = speedY_;}
void update(){
atack();
display();}
void atack() {
x -= random(2, 5);
y += random(-2, 3);}
// This will be overridden in the child classes.
void display() {
point(x,y); 
point(x,y);}
// This will be overridden in the child classes.
void effect(){}
// This will be overridden in the child classes.
}
