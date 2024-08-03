import java.util.Arrays;
public class EntityRegistry {
    private Player[] playerRegistry = new Player[256];
    private Monster[] monsterRegistry = new Monster[256];
    public int registerPlayer(Player player){
        for (short i = 0; i <= 256; i++){
            if (playerRegistry[i] == null){
                playerRegistry[i] = player;
                return i;
            }
        }
        return -1;
    }

    public int registerMonster(Monster monster){
        for (short i = 0; i <= 256; i++){
            if (monsterRegistry[i] == null){
                monsterRegistry[i] = monster;
                return i;
            }
        }
        return -1;
    }

    public void deregisterMonster(int id){
        monsterRegistry[id] = null;
    }

    public void deregisterPlayer(int id){
        playerRegistry[id] = null;
    }

    public Monster[] getMonsterRegistry(){
        return monsterRegistry;
    }

    public Player[] getPlayerRegistry(){
        return playerRegistry;
    }
}
