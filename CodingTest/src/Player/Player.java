package Player;

import Utils.NumberEnum;

public class Player {
    public int hp = NumberEnum.PLAYER_HP.getAmount();
    public int attackPower = NumberEnum.PLAYER_ATTACK_POWER.getAmount();
    public int magicPower = NumberEnum.PLAYER_MAGIC_POWER.getAmount();

    public void addPoint(int hp, int attackPower, int magicPower) {
        this.hp += 3 * hp;
        this.attackPower += attackPower;
        this.magicPower += magicPower;
    }

    public void decreaseHp(int damage){
        this.hp -= damage;
        if(this.hp < 0) this.hp = 0;
    }

    public void increaseHp(int hp){
        this.hp += hp;
    }
}
