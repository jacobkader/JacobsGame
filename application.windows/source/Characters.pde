//Class for the Characters Alex and Lucy
class Characters{  
int x;
int y;
int speedX ;
int speedY ;
int i = 0;
int gameOver = 0;
public int health = 100;
public int damage = 10;
PImage alex1, alex2, alex3, alex4, alex5, alex6, alex7, alex8, lucy1, lucy2, lucy3, lucy4, lucy5, lucy6;
Characters(int x, int y, int speedX, int speedY){
this.x = x;
this.y = y;
this.speedX = speedX;
this.speedY = speedY;
//Images for Alex              
alex1 = loadImage("c0.png");
alex2 = loadImage("c1.png");
alex3 = loadImage("c2.png");
alex4 = loadImage("c3.png");
alex5 = loadImage("c4.png");
alex6 = loadImage("c5.png");
alex7 = loadImage("c6.png");
alex8 = loadImage("c7.png");
//Images for Lucy            
lucy1 = loadImage("ly1.png");
lucy2 = loadImage("ly2.png");
lucy3 = loadImage("ly3.png");
lucy4 = loadImage("ly4.png");
lucy5 = loadImage("ly5.png");
lucy6 = loadImage("ly6.png");}        
void render(){
//Score bar that appears when GameMode = GamePlaying
fill(255);
rectMode(CENTER);
rect(width-70, height-570 , 100, 20, 7);
fill(0);
textAlign(CENTER);
text("your score: " + Score ,width-70, height-565); 
//Switch statement for chracter selection
switch(CharacterChosen){
case 0:
renderAlex();
case 1:
renderLucy();}      
}    
void renderAlex(){
switch(CharacterChosen){
case 0:
if(i>=0 && i<6)
 {image(alex1,this.x,this.y);}
else if(i>=6 && i<12)
 {image(alex2,this.x,this.y);}
else if(i>=12 && i<18)
 {image(alex3,this.x,this.y);}
else if(i>=18 && i<24)
 {image(alex4,this.x,this.y);}
else if(i>=24 && i<30)
 {image(alex5,this.x,this.y);}
else if(i>=30 && i<36)
 {image(alex6,this.x,this.y);}
else if(i>=36 && i<42)
 {image(alex7,this.x,this.y);}
else if(i>=42 && i<48)
 {image(alex8,this.x,this.y);}
else if (i ==48)
 {i = 0;}
  i++;}
}//void render is used for the animations to load since its a gif file that was converted to PNG
void renderLucy(){ 
switch(CharacterChosen){
case 1:
if(i>=0 && i<6)
 {image(lucy1,this.x,this.y);}
else if(i>=6 && i<12)
 {image(lucy2,this.x,this.y);}
else if(i>=12 && i<18)
 {image(lucy3,this.x,this.y);}
else if(i>=18 && i<24)
 {image(lucy4,this.x,this.y);}
else if(i>=24 && i<30)
 {image(lucy5,this.x,this.y);}
else if(i>=30 && i<36)
 {image(lucy6,this.x,this.y);}
else if (i ==36)
 {i = 0;} 
  i++;}
}//void render is used for the animations to load since its a gif file that was converted to PNG      
boolean crash(Collectables Collectables)
{return (abs(this.x - Collectables.x) < 45 && abs(this.y - Collectables.y) < 45);}
boolean crash(Enemy Enemy)
{return (abs(this.x - Enemy.x) < 50 && abs(this.y - Enemy.y) < 40);}
}//Code used to collide Player with Collectables and Enemies 
