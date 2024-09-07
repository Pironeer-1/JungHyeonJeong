package Utils;

public enum NumberEnum {
    PLAYER_HP(50),
    PLAYER_ATTACK_POWER(10),
    PLAYER_MAGIC_POWER(5),
    ENEMY_HP(100),
    ENEMY_ATTACK_POWER(25),
    ENEMY_DEFENSE_POWER(7),
    ENEMY_MAGIC_DEFENSE(7);


    private final int amount;
    NumberEnum(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }
}
