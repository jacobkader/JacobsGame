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

void setup() {
  size(600,600);
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
  void draw() {
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
void restart() {
currentGameMode = gamePlaying;      
gameScreen = 3;
time = 0;
textSize(12);
Score=0;}
void mainMenu() {
currentGameMode = gamePlaying; 
gameScreen = 0;
time = 0;
Score=0;
 textSize(12);}
void chooseCharacter(){
currentGameMode = gamePlaying;      
gameScreen = 1;
time = 0;
background(CC);
GameMode.character();
textSize(12);}
void instructions(){
currentGameMode = gamePlaying;      
gameScreen = 2;
time = 0;
background(INSTRUCTION);
textSize(12);}
void HighScore(){
if(Score>= BestScore){
  BestScore = Score;}
}
//KeyPressed is used for the character to move up,down,left and right
void keyPressed() {
   if( keyCode == UP && Characters.y > 5)
   {Characters.y -= Characters.speedY;}
   else if( keyCode == DOWN && Characters.y < height - 50)
   {Characters.y += Characters.speedY;}
   else if( keyCode == LEFT && Characters.x > 0)
   {Characters.x -= Characters.speedX;}
   else if( keyCode == RIGHT && Characters.x < width - 50)
   {Characters.x += Characters.speedX;}
}
