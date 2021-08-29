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
