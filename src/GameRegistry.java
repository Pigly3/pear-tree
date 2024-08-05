public class GameRegistry {
    private EntityRegistry entityRegistry;
    private OccupiedSpaceController occupiedSpace;
    private Assets assets;
    private GameWindow window;
    GameRegistry(GameWindow window){
        entityRegistry = new EntityRegistry();
        occupiedSpace = new OccupiedSpaceController();
        assets = new Assets();
        this.window = window;
    }
    public int registerMonster(Monster monster){
        return entityRegistry.registerMonster(monster);
    }
    public int registerPlayer(Player player){
        return entityRegistry.registerPlayer(player);
    }
    public void occupySpace(Object entity,byte displayX, byte displayY){
        occupiedSpace.occupySpace(entity, displayX, displayY);
    }
    public void occupySpace(byte displayX, byte displayY){
        occupiedSpace.deoccupySpace(displayX, displayY);
    }
    public Player[] getPlayerRegistry(){
        return entityRegistry.getPlayerRegistry();
    }
    public Monster[] getMonsterRegistry(){
        return entityRegistry.getMonsterRegistry();
    }
    public void moveItemInSpace(byte fromX, byte fromY, byte toX, byte toY){
        occupiedSpace.moveItemInSpace(fromX, fromY, toX, toY);
    }
    public GameWindow getWindow(){
        return window;
    }
    public Object findInSpace(byte x, byte y){
        return occupiedSpace.find(x, y);
    }
}