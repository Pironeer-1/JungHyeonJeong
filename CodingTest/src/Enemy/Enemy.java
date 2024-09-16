package Enemy;

import Utils.NumberEnum;

public class Enemy {
    public int hp = NumberEnum.ENEMY_HP.getAmount();
    public int attackPower = NumberEnum.ENEMY_ATTACK_POWER.getAmount();
    public int defense = NumberEnum.ENEMY_DEFENSE_POWER.getAmount();
    public int magicDefense = NumberEnum.ENEMY_MAGIC_DEFENSE.getAmount();
    public int maxHp = NumberEnum.ENEMY_HP.getAmount();

    public void init(int len) {
        this.hp *= len;
        this.maxHp *= len;
    }

    public void decreaseHp(int damage){
        this.hp -= damage;
        if(this.hp < 0) this.hp = 0;
    }

    public void increaseHp(int hp){
        this.hp += hp;
    }
}
