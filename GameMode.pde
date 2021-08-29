//class for GameModes 
class GameMode{  
void gameIntro(){
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
void character(){
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
void instructionss(){
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
void startGame(){
time+=  0.0166666667 ; // if draw repeats itself 60 times per second 1/60 x 60 is 1 second so 1/60 = 0.0166666667
text(floor(time), 10, 10);
if (health.life == 0) {
 gameScreen = 4;
 Characters.i=0;
 CharacterChosen =ALEX;
 HighScore();}
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
void finishGame() {
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
