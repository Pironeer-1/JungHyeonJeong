package Enemy;

import Utils.Logger;
import Player.Player;

import java.util.Random;

public class EnemyAction {
    Logger logger = new Logger();
    Random random = new Random();
    int healingAmount = 7;

    public void enemyInit(Enemy enemy, int len){
        enemy.init(len);
    }

    private void basicAttack(Player player, Enemy enemy, int idx){
        int damage = enemy.attackPower;
        player.decreaseHp(damage);
        logger.printEnemyAttack(idx, damage, player.hp);
    }

    private void heal(Enemy enemy){
        if(enemy.hp + healingAmount > enemy.maxHp){
            enemy.increaseHp(enemy.maxHp - enemy.hp);
            logger.printEnemyHpIsFull();
        }
        else{
            enemy.increaseHp(healingAmount);
            logger.printEnemyHp(enemy.hp);
        }
    }

    public void attack(Player player, Enemy enemy, int idx){
        logger.dividingLine();
        logger.printEnemyTurn();
        int randomInt = random.nextInt(10) + 1;

        if(randomInt == 1){
            logger.printEnemyDoNothing();
        }
        else if(randomInt >= 2 && randomInt <= 8){
            basicAttack(player, enemy, idx);
        }
        else{
            heal(enemy);
        }
    }
}
