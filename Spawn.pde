class spawn{
void sp(){   
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
