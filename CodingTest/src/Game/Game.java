package Game;

import Enemy.*;
import Player.*;
import Utils.Logger;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> playerList = new ArrayList<>();
    private Enemy enemy = new Enemy();
    Logger logger = new Logger();
    Scanner sc = new Scanner(System.in);
    PlayerAction playerAction = new PlayerAction();
    EnemyAction enemyAction = new EnemyAction();
    Random random = new Random();

    private void setPlayers(){
        int listLen;
        while(true){
            try{
                logger.printGameInput();
                listLen = sc.nextInt();
                sc.nextLine();
                if(listLen <= 0){
                    logger.printGameInputRangeError();
                    continue;
                }
                break;
            }
            catch(InputMismatchException err){
                //입력값이 정수가 아닌 경우
                logger.printTypeError();
                continue;
            }
        }

        for(int i = 0; i < listLen; i++){
            Player player = new Player();

            playerAction.setStatus(player);
            playerList.add(player);
        }
    }

    private void setEnemy(){
        enemyAction.enemyInit(this.enemy, playerList.size());
    }

    private boolean turnCheck(){
        for(int i = 0; i < playerList.size(); i++){
            if(playerList.get(i).hp <= 0) playerList.remove(i);
        }

        if(playerList.size() == 0 || enemy.hp == 0){
            return false;
        }
        else return true;
    }

    private Player selectTargetPlayer(){
        int randomInt = random.nextInt(playerList.size());
        return playerList.get(randomInt);
    }

    public void game(){
        setPlayers();
        setEnemy();

        while(turnCheck()){
            //플레이어의 공격부터 시작
            for(int i = 0; i < playerList.size(); i++){
                Player player = playerList.get(i);
                playerAction.attack(player, enemy, i);

                if(enemy.hp == 0) break;
            }

            //적의 반격
            Player targetPlayer = selectTargetPlayer();
            int targetIdx = playerList.indexOf(targetPlayer);
            enemyAction.attack(targetPlayer, enemy, targetIdx);
        }

        if(enemy.hp <= 0){
            logger.printEnemyLose();
        }
        else{
            logger.printEnemyWin();
        }
    }
}
