/* autogenerated by Processing revision 1276 on 2021-08-27 */
import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class JacobsGame extends PApplet {

final int gamePlaying = 2;
final int gameFinished = 3;
final int gameSplash = 0;
public int gameScreen = 0 ;
int currentGameMode = gamePlaying;
// All the images used in the game
PImage INTRO,CC,INSTRUCTION,LEVEL1,LEVEL2,LEVEL3,LEVEL4,LEVEL5,OUTRO;
int bgX = 0;
int Score = 0;
int BestScore= 0;
//variables for the  buttons used in GameMode
int bx1 = 20;
int bx2 = 120;
int bx3 = 115;
int bx4 = 405;
int bx6 = 260;
int xsize = 80;
int x2size = 120;
int x3size = 60;
int by1 = 20;
int by2 = 300;
int ysize = 35;
int y2size = 25;
int e = 7;
//variables used for Characters
int LUCY =1;
int ALEX =0;
public int CharacterChosen = ALEX;
//variables used for the arraylists and the the collectbles/enemies 
public int spawnSpeed = 60;
int collectablesSpawnTimer = 0;
int enemysSpawnTimer = 0;
ArrayList<Collectables> Collectableslist = new ArrayList<Collectables>();
ArrayList<Enemy> Enemylist = new ArrayList<Enemy>();

Enemy Enemy;
Collectables collectables;
Coin Coin;
Characters Characters;
spawn Spawn;
hearts1 health;
GameMode GameMode;
Background background;

 public void setup() {
  /* size commented out by preprocessor */;
  INTRO  = loadImage("introo.png");
  CC = loadImage("CC.png");
  INSTRUCTION = loadImage("CC3.png");
  LEVEL1  = loadImage("road.png");
  LEVEL2 = loadImage("road2.png");
  LEVEL3 = loadImage("road3.png");
  LEVEL4 = loadImage("road4.png");
  LEVEL5 = loadImage("road5.png");
  OUTRO = loadImage("CC25.png");
  Characters = new Characters(10,250, 20,20);
  health = new hearts1( 20, 20);
  background = new Background();
  GameMode = new GameMode();
  Spawn = new spawn();
}
// draw function continuously executes the lines of code contained inside its block until the program is stopped
   public void draw() {
switch(gameScreen){
case 0:
GameMode.gameIntro();
break;
case 1:
GameMode.character();
break;
case 2:
GameMode.instructionss(); 
break;
case 3:
background.drawBackground();
Characters.render();
health.render();
Spawn.sp();
AllLevels();
GameMode.startGame();
break;
case 4:
GameMode.finishGame();
break;
}
}
 public void restart() {
currentGameMode = gamePlaying;      
gameScreen = 3;
time = 0;
textSize(12);
Score=0;}
 public void mainMenu() {
currentGameMode = gamePlaying; 
gameScreen = 0;
time = 0;
Score=0;
 textSize(12);}
 public void chooseCharacter(){
currentGameMode = gamePlaying;      
gameScreen = 1;
time = 0;
background(CC);
GameMode.character();
textSize(12);}
 public void instructions(){
currentGameMode = gamePlaying;      
gameScreen = 2;
time = 0;
background(INSTRUCTION);
textSize(12);}
 public void HighScore(){
if(Score>= BestScore){
  BestScore = Score;}
}
//KeyPressed is used for the character to move up,down,left and right
 public void keyPressed() {
   if( keyCode == UP && Characters.y > 5)
   {Characters.y -= Characters.speedY;}
   else if( keyCode == DOWN && Characters.y < height - 50)
   {Characters.y += Characters.speedY;}
   else if( keyCode == LEFT && Characters.x > 0)
   {Characters.x -= Characters.speedX;}
   else if( keyCode == RIGHT && Characters.x < width - 50)
   {Characters.x += Characters.speedX;}
}
//class for one of the collectables that adds 1 to the players speed each time its collected 
class Apple extends Collectables {
// Variables are inherited from the parent.
 private int i = 0;
 PImage apple;
 Apple(float x_, float y_, float speedX_){
super(x_,y_,speedX_);
apple = loadImage("apple1.png");}
 public void move() {
   super.move();}
//Inherits move from parent class(COLLECTABLES) 
 public void effect(){
print("apple");
Characters.speedX +=1;
Characters.speedY +=1;}
//Effect that occurs when the Player collides with Collectable[Apple] 
 public void display() {
if(i>=0 && i<10){
image(apple,x,y);
i=0;
i++;}
 }
//Apple overwrites display and effect from the parent 
}
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
 public void render(){
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
 public void renderAlex(){
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
 public void renderLucy(){ 
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
 public boolean crash(Collectables Collectables)
{return (abs(this.x - Collectables.x) < 45 && abs(this.y - Collectables.y) < 45);}
 public boolean crash(Enemy Enemy)
{return (abs(this.x - Enemy.x) < 50 && abs(this.y - Enemy.y) < 40);}
}//Code used to collide Player with Collectables and Enemies 
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
 public void move() {
  super.move();}
//Inherits move from parent class(COLLECTABLES)         
 public void effect(){
Score +=1;
print("coin");}
//Effect that occurs when the Player collides with Collectable[Coin] 
 public void display() {
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
   
//Parent class for all the collectables Coin,Apple and Hearts
class Collectables {
float x;
float y;
float speedX; 
  Collectables(float x_, float y_, float speedX_){
x = x_;
y= y_;
speedX = speedX_;}

 public void update(){
move();
display();}
// This will be overridden in the child classes.
 public void move() {
x -= 2;}
// This will be overridden in the child classes.
 public void display() {
point(x,y); 
point(x,y);}
 public void effect(){}
// This will be overridden in the child classes.
}
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
 public void update(){
atack();
display();}
 public void atack() {
x -= random(2, 5);
y += random(-2, 3);}
// This will be overridden in the child classes.
 public void display() {
point(x,y); 
point(x,y);}
// This will be overridden in the child classes.
 public void effect(){}
// This will be overridden in the child classes.
}
//class for GameModes 
class GameMode{  
 public void gameIntro(){
textSize(12);
background(INTRO); 
textAlign(CENTER);
if(mouseX>bx1 && mouseY>by1 && mouseX<bx1 + xsize && mouseY<by1 + ysize  && mousePressed==true && gameScreen ==0 ){
 gameScreen=3;}//Code for the buttons 
else if(mouseX>bx1 && mouseY>by1 && mouseX<bx1 + xsize && mouseY<by1 + ysize){
 fill(153,76,0);
 rect(bx1,by1,xsize,ysize,e);}//code for the buttons to change colour when mouse hovers 
else{
 fill(255,153,51);
 rect(bx1,by1,xsize,ysize,e);}
 fill(0);
 text("Start Game!", 62, 40);
if(mouseX>bx2 && mouseY>by1 && mouseX<bx2 + x2size && mouseY<by1 + ysize  && mousePressed==true && gameScreen ==0  ){
 chooseCharacter();
 rectMode(CORNER);}//Code for the buttons 
else if(mouseX>bx2 && mouseY>by1 && mouseX<bx2 + x2size && mouseY<by1 + ysize){
 fill(153,76,0);
 rect(bx2,by1,x2size,ysize,e);
 fill(0);
 text("Change Character", 182, 40);}//code for the buttons to change colour when mouse hovers 
else{
 fill(255,153,51);
 rect(bx2,by1,x2size,ysize,e);
 fill(0);
 text("Change Character", 182, 40);} 
if(mouseX>bx6 && mouseY>by1 && mouseX<bx6 + x2size && mouseY<by1 + ysize  && mousePressed==true && gameScreen ==0 && gameScreen != 3 ){
 instructions();
 rectMode(CORNER);}//Code for the buttons 
else if(mouseX>bx6 && mouseY>by1 && mouseX<bx6 + x2size && mouseY<by1 + ysize && gameScreen != 1){
 fill(153,76,0);
 rect(bx6,by1,x2size,ysize,e);
 fill(0);
 text("Instructions", 320, 40);}//code for the buttons to change colour when mouse hovers 
else if ( gameScreen != 1){
 fill(255,153,51);
 rect(bx6,by1,x2size,ysize,e);
 fill(0);
 text("Instructions", 320, 40);}
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 public void character(){
textSize(12);
if(mouseX>bx3 && mouseY>by2 && mouseX<bx3 + x3size && mouseY<by2 + y2size  && mousePressed==true && gameScreen ==1 ){
 CharacterChosen = ALEX ;
 mainMenu();
 gameIntro();
 rectMode(CORNER);}//Code for the buttons 
else if(mouseX>bx3 && mouseY>by2 && mouseX<bx3 + x3size && mouseY<by2 + y2size){
 fill(76,0,153);
 rect(bx3,by2,x3size,y2size);}//code for the buttons to change colour when mouse hovers 
else{
 fill(153,51,255);
 rect(bx3,by2,x3size,y2size);}
 fill(0);
 text("Alex", 147, 317);  
if(mouseX>bx4 && mouseY>by2 && mouseX<bx4 + x3size && mouseY<by2 + y2size  && mousePressed==true && gameScreen ==1 ){
 CharacterChosen = LUCY;
 mainMenu();
 gameIntro();
 setup();
 rectMode(CORNER);}//Code for the buttons 
else if(mouseX>bx4 && mouseY>by2 && mouseX<bx4 + x3size && mouseY<by2 + y2size){
 fill(76,0,153);
 rect(bx4,by2,x3size,y2size);}//code for the buttons to change colour when mouse hovers 
else{
 fill(153,51,255);
 rect(bx4,by2,x3size,y2size);}
 fill(0);
 text("lucy", 147 + 290 , 317);
 }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 public void instructionss(){
textSize(12);
if(mouseX>bx1 && mouseY>by1 && mouseX<bx1 + xsize && mouseY<by1 + ysize  && mousePressed==true && gameScreen ==2 ){
 mainMenu();
 setup();
 rectMode(CORNER);}//Code for the buttons 
else if(mouseX>bx1 && mouseY>by1 && mouseX<bx1 + xsize && mouseY<by1 + ysize){
 fill(76,0,153);
 rect(bx1,by1,xsize,ysize);}//code for the buttons to change colour when mouse hovers 
else{
 fill(153,51,255);
 rect(bx1,by1,xsize,ysize);}
 fill(0);
 text("Main menu", 62, 40);}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 public void startGame(){
time+=  0.0166666667f ; // if draw repeats itself 60 times per second 1/60 x 60 is 1 second so 1/60 = 0.0166666667
text(floor(time), 10, 10);
if (health.life == 0) {
 gameScreen = 4;
 Characters.i=0;
 CharacterChosen =ALEX;
 HighScore();}
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 public void finishGame() {
textSize(12);
imageMode(CORNER);
image(OUTRO,0,0);
textAlign(CENTER);
rectMode(CORNER);
rect(bx2,by1,xsize,ysize);
textAlign(CENTER);
if(mouseX>bx1 && mouseY>by1 && mouseX<bx1 + xsize && mouseY<by1 + ysize  && mousePressed==true && gameScreen ==4 ){
 restart();
 startGame();
 setup();
 Spawn.sp();}//Code for the buttons 
else if(mouseX>bx1 && mouseY>by1 && mouseX<bx1 + xsize && mouseY<by1 + ysize){
 fill(76,0,153);
 rect(bx1,by1,xsize,ysize);}//code for the buttons to change colour when mouse hovers 
else{
 fill(153,51,255);
 rect(bx1,by1,xsize,ysize);}
 fill(0);
 text("Play Again!", 62, 40);  
if(mouseX>bx2 && mouseY>by1 && mouseX<bx2 + xsize && mouseY<by1 + ysize  && mousePressed==true && gameScreen ==4 ){
 mainMenu();
 setup();
 Spawn.sp();
 rectMode(CORNER); }//Code for the buttons 
else if(mouseX>bx2 && mouseY>by1 && mouseX<bx2 + xsize && mouseY<by1 + ysize && gameScreen !=3){
 fill(76,0,153);
 rect(bx2,by1,xsize,ysize);
 fill(240,217,19);
 textSize(36);
 text(Score, 408,401);
 text(BestScore, 408,460);}//code for the buttons to change colour when mouse hovers 
else if( gameScreen !=3){
 fill(153,51,255);
 rect(bx2,by1,xsize,ysize);
 fill(240,217,19);
 textSize(36);
 text(Score, 408,401);
 text(BestScore, 408,460);}
 textSize(12);
 fill(0);
 text("Main menu", 162, 40);
}
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//class for one of the collectables that adds 25% to the Health each time its collected 
class Hearts extends Collectables {
// Variables are inherited from the parent.
 public int i = 0;
 PImage l1;
 Hearts(float x_, float y_, float speedX_){
super(x_,y_,speedX_);
l1 = loadImage("l1.png");}
 public void move() {
 super.move();}  
//Inherits move from parent class(COLLECTABLES) 
 public void effect(){
health.life += 25;
print("Heart");
if (health.life >= 100)
{health.life=100;}}
//Effect that occurs when the Player collides with Collectable[Hearts] 
 public void display() {
if(i>=0 && i<10)
{image(l1,x,y);
i=0;
i++;}}
//Heart overwrites display and effect from the parent 
}
//code for all the levels 
public float time;
int level;
public void AllLevels(){
textAlign(CENTER);
if (time >= 0 && time <8 )
 {spawnSpeed = 60;
 level = 1 ;
 text("Level 1" ,width/2 , 20);}
if (time >= 10 && time <20 )
 {spawnSpeed = 50;
 level = 2;
 text("Level 2" ,width/2 , 20);}
if (time >= 20 && time <30 )
 {spawnSpeed = 40;
 level = 3;
 text("Level 3" ,width/2 , 20);}
if (time >=30 && time <40 )
 {spawnSpeed = 30;;
 level = 4;
 text("Level 4" ,width/2 , 20);}
if (time >=40 && time <50 )
 {spawnSpeed = 20;
 level = 5;
 text("Level 5" ,width/2 , 20);}
if (time >=50)
 {spawnSpeed = 10;
 level = 6;
 text("FINAL LEVEL \n HOW LONG CAN YOU SURVIVE?" ,width/2 , 20);}
if (time >=61)
{health.life =0;}
}
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
 public void atack() {
  super.atack();}  
//Inherits atack from parent class(ENEMY) 
 public void effect(){
health.life= 0;
print("busted");
if (health.life <= 0  )
{currentGameMode = gameFinished;}
}
//Effect that occurs when the Player bumps into Enemy[PoliceCar]) 
 public void display(){    
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
 public void effect() {
health.life-=25;
print("busted");
if (health.life <= 0  )
{currentGameMode = gameFinished;}}  
//Effect that occurs when the Player collides with Enemy[PoliceOfficer]
 public void atack() {
  super.atack();}
//Inherits atack from parent class(ENEMY)   
 public void display(){      
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
    
    
    
class spawn{
 public void sp(){   
 collectablesSpawnTimer++;
if (collectablesSpawnTimer % 50 == 0) {
 Collectableslist.add( new Coin( width+ random(600),  random(600), 3));}
if (collectablesSpawnTimer % 180 == 0)  {
 Collectableslist.add( new Apple( width+ random(600),  random(600), 3));}
if (collectablesSpawnTimer % 180 == 0)  {
 Collectableslist.add( new Hearts( width+ random(600),  random(600), 3));}
for (int i = 0; i < Collectableslist.size(); i++) {
 Collectables Collectables =Collectableslist.get(i);
 Collectables.update();
if(Characters.crash(Collectables)) 
 {Collectableslist.remove(i);
  Collectables.effect();}
}
enemysSpawnTimer++;
if (enemysSpawnTimer % spawnSpeed == 0) {
  Enemylist.add( new PoliceOfficer (width+(int) random(600), (int) random(600), 3, 3));} 
if (enemysSpawnTimer % 120 == 0)  
{Enemylist.add( new PoliceCar( width+(int) random(600), (int) random(600), 3, 3));}
for (int i = 0; i < Enemylist.size(); i++) {
 Enemy Enemy = Enemylist.get(i);
 Enemy.update();
if(Characters.crash(Enemy)) 
 {Enemylist.remove(i);
  Enemy.effect();}}}
}
// This is all the code used to Spawn the Collectables aswell as the Enemies and also cause then to dissapear when they collide with the character 
class Background{
 public void drawBackground(){
if (level == 1){
 image(LEVEL1, bgX, 0); 
 image(LEVEL1, bgX+LEVEL1.width, 0);
 bgX -= 2;
if(bgX == -LEVEL1.width)
 bgX = 0;}
if (level == 2){
 image(LEVEL2, bgX, 0); 
 image(LEVEL2, bgX+LEVEL2.width, 0);
 bgX -= 2;
if(bgX == -LEVEL2.width)
 bgX = 0;}
if (level == 3){
 image(LEVEL3, bgX, 0); 
 image(LEVEL3, bgX+LEVEL3.width, 0);
 bgX -= 2;
if(bgX == -LEVEL3.width)
 bgX = 0;}
if (level == 4){
 image(LEVEL4, bgX, 0); 
 image(LEVEL4, bgX+LEVEL4.width, 0);
 bgX -= 2;
if(bgX == -LEVEL4.width)
 bgX = 0;}
if (level == 5){
 image(LEVEL5, bgX, 0); 
 image(LEVEL5, bgX+LEVEL5.width, 0);
 bgX -= 2;
if(bgX == -LEVEL5.width)
 bgX = 0;}
if (level == 6){
 image(LEVEL1, bgX, 0); 
 image(LEVEL1, bgX+LEVEL1.width, 0);
 bgX -= 2;
if(bgX == -LEVEL1.width)
 bgX = 0;}}
}
//code used to change background for each level whilst its still moving 
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
 public void render(){     
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


  public void settings() { size(600, 600); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "JacobsGame" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
