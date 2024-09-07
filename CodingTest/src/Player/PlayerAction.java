package Player;

import Enemy.Enemy;
import Utils.Logger;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PlayerAction {
    Logger logger = new Logger();
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    private final int point = 13;

    //플레이어의 스테이터스를 설정
    public void setStatus(Player player){
        logger.dividingLine();
        logger.printSetStatus(this.point);

        while(true){
            int a, b, c;
            while(true){
                try{
                    a = sc.nextInt();
                    b = sc.nextInt();
                    c = sc.nextInt();
                    sc.nextLine(); //개행문자 제거
                    if(a < 0 || b < 0 || c < 0){
                        logger.printSetStatusNegativeError();
                        continue;
                    }
                    break;
                }
                catch(InputMismatchException err){
                    //입력값이 정수가 아닌 경우
                    logger.printSetStatusTypeError();
                    sc.nextLine();
                    continue;
                }
            }

            int sum = a + b + c;
            //입력값의 합이 point가 아닌 경우
            if(sum != point){
                logger.printSetStatusSumError(this.point);
                continue;
            }
            else{
                player.addPoint(a, b, c);
                break;
            }
        }

    }

    //스테이터스 확인
    //플레이어와 적의 현재 스테이터스 출력하고 적에게 일반 공격
    private void checkStatus(Player player, Enemy enemy){
        //스테이터스 출력
        logger.printPlayerInfo(player);
        logger.printEnemyInfo(enemy);

        //일반 공격
        int damage = player.attackPower - enemy.defense;
        enemy.decreaseHp(damage);

        logger.printBasicDamage(damage);
    }

    //일반 공격
    private void basicAttack(Player player, Enemy enemy){
        int randomInt = random.nextInt(10) + 1;

        if(randomInt > 2){
            int damage = player.attackPower - enemy.defense;
            enemy.decreaseHp(damage);
            logger.printBasicDamage(damage);
        }
        else{
            int damage = (player.attackPower - enemy.defense) * 2;
            enemy.decreaseHp(damage);
            logger.printCriticalDamage(damage);
        }
    }

    //마법 공격
    private void magicAttack(Player player, Enemy enemy){
        int damage = player.magicPower * 2 - enemy.magicDefense;
        enemy.decreaseHp(damage);
        logger.printMagicDamage(damage);
    }

    //체력 회복
    private void heal(Player player){
        int randomInt = random.nextInt(6) + 5;
        player.increaseHp(randomInt);
        logger.printPlayerHp(player.hp);
    }

    //공격 수행
    public void attack(Player player, Enemy enemy, int idx){
        int inputKey;
        while(true){
            try{
                logger.dividingLine();
                logger.printPlayerChoice(idx);
                String input = sc.nextLine();

                if(input.equals("exit")){
                    logger.printEnd();
                    System.exit(0);
                }
                else{
                    inputKey = Integer.parseInt(input);

                    if(inputKey < 1 || inputKey > 4){
                        logger.printPlayerChoiceError();
                        continue;
                    }
                    break;
                }
            }
            catch(NumberFormatException err){
                //입력값이 정수가 아닌 경우
                logger.printTypeError();
                continue;
            }
        }

        if(inputKey == 1){
            checkStatus(player, enemy);
        }
        else if(inputKey == 2){
            basicAttack(player, enemy);
        }
        else if(inputKey == 3){
            magicAttack(player, enemy);
        }
        else if(inputKey == 4){
            heal(player);
        }
    }
}
