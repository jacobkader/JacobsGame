class Background{
void drawBackground(){
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
