import java.util.Timer;
import java.util.TimerTask;
public class Monster {
    private Sprite monster;
    private int registryId;
    public int xPosition;
    public int yPosition;
    public int displayXPosition;
    public int displayYPosition;
    private GameRegistry registry;
    private short damage = 3;
    private short health = 60;
    Monster(byte screenX, byte screenY, GameRegistry registry){
        if (screenX >= 16 || screenY >= 16){
            return;
        }
        this.displayXPosition = screenX;
        this.displayYPosition = screenY;
        this.registry = registry;
        registry.occupySpace(this, screenX, screenY);
        Assets assets = new Assets();
        Sprite monster = new Sprite(screenX, screenY, assets.monster, registry.getWindow());
        registryId = registry.registerMonster(this);
        this.monster = monster;
        Timer timer = new Timer();
        TimerTask moveToPlayer = new TimerTask(){
            public void run(){
                moveToPlayer();
            }
        };
        timer.schedule(moveToPlayer, 0, 200);
    }
    private Player findNearestPlayer(){
        Player[] players = registry.getPlayerRegistry();
        Player currentClosest = players[0];
        int currentClosestDistance = -1;
        for (short i = 0; i < 256; i++){
            if (players[i] != null){
                if (currentClosestDistance == -1){
                    currentClosest = players[i];
                    currentClosestDistance = (int) Math.sqrt((players[i].displayXPosition-this.displayXPosition)*(players[i].displayXPosition-this.displayXPosition) + (players[i].displayYPosition-this.displayYPosition)*players[i].displayYPosition-this.displayYPosition);
                } else {
                    int thisDistance = (int) Math.sqrt((players[i].displayXPosition-this.displayXPosition)*(players[i].displayXPosition-this.displayXPosition) + (players[i].displayYPosition-this.displayYPosition)*players[i].displayYPosition-this.displayYPosition);
                    if (thisDistance < currentClosestDistance){
                        currentClosestDistance = thisDistance;
                        currentClosest = players[i];
                    }
                }
            }
        }
        return currentClosest;
    }
    private void moveToPlayer(){
        Player closestPlayer = findNearestPlayer();
        byte tempDisplayX = (byte) displayXPosition;
        byte tempDisplayY = (byte) displayYPosition;
        if (Math.abs(closestPlayer.displayXPosition-this.displayXPosition) == 0 && Math.abs(closestPlayer.displayXPosition-this.displayXPosition) > 1){
            if (closestPlayer.displayYPosition-this.displayYPosition < 0) {
                this.displayYPosition -= 1;
            } else {
                this.displayYPosition += 1;
            }
        }
        double r = Math.random();
        if (r >= 0.5){
            if (Math.abs(closestPlayer.displayXPosition-this.displayXPosition) > 1){
                if (closestPlayer.displayXPosition-this.displayXPosition < 0) {
                    changeDisplayPosition((byte) -1,(byte) 0);
                } else {
                    changeDisplayPosition((byte) 1,(byte) 0);
                }
            } else if (Math.abs(closestPlayer.displayYPosition-this.displayYPosition) > 1){
                if (closestPlayer.displayYPosition-this.displayYPosition < 0) {
                    changeDisplayPosition((byte) 0,(byte) -1);
                } else {
                    changeDisplayPosition((byte) 0,(byte) 1);
                }

            } else if (Math.abs(closestPlayer.displayXPosition-this.displayXPosition) == 1){
                if (closestPlayer.displayXPosition-this.displayXPosition < 0) {
                    changeDisplayPosition((byte) -1,(byte) 0);
                } else {
                    changeDisplayPosition((byte) 1,(byte) 0);
                }
            } else {
                attackPlayer(closestPlayer);
            }
        } else {
            if (Math.abs(closestPlayer.displayYPosition-this.displayYPosition) > 1){
                if (closestPlayer.displayYPosition-this.displayYPosition < 0) {
                    changeDisplayPosition((byte) 0,(byte) -1);
                } else {
                    changeDisplayPosition((byte) 0,(byte) 1);
                }
            } else if (Math.abs(closestPlayer.displayXPosition-this.displayXPosition) > 1){
                if (closestPlayer.displayXPosition-this.displayXPosition < 0) {
                    changeDisplayPosition((byte) -1,(byte) 0);
                } else {
                    changeDisplayPosition((byte) 1,(byte) 0);
                }
            } else if (Math.abs(closestPlayer.displayYPosition-this.displayYPosition) == 1){
                if (closestPlayer.displayYPosition-this.displayYPosition < 0) {
                    changeDisplayPosition((byte) 0,(byte) -1);
                } else {
                    changeDisplayPosition((byte) 0,(byte) 1);
                }
            } else {
                attackPlayer(closestPlayer);
            }
        }
    }
    public Sprite getMonster(){
        return this.monster;
    }
    public void changeDisplayPosition(byte changeX, byte changeY){
        byte tempDisplayX = (byte) this.displayXPosition;
        byte tempDisplayY = (byte) this.displayYPosition;
        byte tempToX;
        byte tempToY;
        if (!(this.displayXPosition + changeX < 16 && this.displayXPosition + changeX >= 0)){
            tempToX = (byte) this.displayXPosition;
        } else {
            tempToX = (byte) (this.displayXPosition + changeX);
        }
        if (!(this.displayYPosition + changeY < 16 && this.displayYPosition + changeY >= 0)){
            tempToY = (byte) this.displayYPosition;
        } else {
            tempToY = (byte) (this.displayYPosition + changeY);
        }
        if (registry.findInSpace(tempToX, tempToY) != null){
            return;
        }
        registry.moveItemInSpace(tempDisplayX, tempDisplayY, tempToX, tempToY);
        this.xPosition += changeX;
        this.yPosition += changeY;
        this.displayXPosition = tempToX;
        this.displayYPosition = tempToY;
        monster.changePos((byte) displayXPosition, (byte) displayYPosition);
    }
    public void attackPlayer(Player player){
        player.changeHealth((short) -damage);
    }
}
