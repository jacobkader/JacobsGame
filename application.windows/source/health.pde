//class for the health of the player 
class hearts1
{
  PImage l1 = loadImage("l1.png");
  PImage l2 = loadImage("l2.png");
  PImage l3 = loadImage("l3.png");
  PImage l4 = loadImage("l4.png");
  PImage l5 = loadImage("l5.png"); 
  int x4;
  int y4;
  int life = 100;   
 hearts1(int x4, int y4){
  this.x4 = x4;
  this.y4 = y4;}
void render(){     
      if(life == 100){
    image(l1, x4,y4);}
      if(life == 75){
    image(l2, x4,y4);}
     if(life == 50){
    image(l3, x4,y4);}
     if(life == 25){
    image(l4, x4,y4);}
     if(life == 0){
    image(l5, x4,y4);}
    if(life > 100)
    {life = 100;}
    } 
}
