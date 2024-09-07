package Utils;

import Enemy.Enemy;
import Player.Player;

public class Logger {
    public void dividingLine(){
        System.out.println("------------------------------------------------------------------------------");
    }

    public void printSetStatus(int point){
        System.out.println(point + "만큼의 스테이터스를 추가합니다. 체력, 공격력, 마법력 순으로 입력하세요\n(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)");
        System.out.println("플레이어의 기본 스탯은 체력: 50, 공격력: 10, 마법력: 5입니다.");
    }

    public void printSetStatusTypeError(){
        System.out.println("체력, 공격력, 마법력은 정수로 입력해야 합니다. 다시 입력해주세요.");
    }

    public void printSetStatusSumError(int point){
        System.out.println("입력한 능력치의 총합이 " + point + "과(와) 같아야 합니다. 다시 입력해주세요.");
    }

    public void printSetStatusNegativeError(){
        System.out.println("체력, 공격력, 마법력은 음수가 될 수 없습니다. 다시 입력해주세요.");
    }

    public void printPlayerInfo(Player player){
        System.out.println("현재 유저 : 체력 " + player.hp + ", 공격력 " + player.attackPower + ", 마법력 " + player.magicPower);
    }

    public void printEnemyInfo(Enemy enemy){
        System.out.println("적 : 체력 " + enemy.hp + ", 공격력 " + enemy.attackPower + ", 방어력 " + enemy.defense + ", 마법방어력 " + enemy.magicDefense);
    }

    public void printBasicDamage(int damage){
        System.out.println("일반 공격으로 " + damage + "의 데미지를 주었습니다");
    }

    public void printCriticalDamage(int damage){
        System.out.println("치명타가 적용되어 " + damage + "의 데미지를 주었습니다.");
    }

    public void printMagicDamage(int damage){
        System.out.println("마법 공격으로 " + damage + "의 데미지를 주었습니다.");
    }

    public void printPlayerHp(int hp){
        System.out.println("체력을 회복합니다. 현재 hp는 " + hp + "입니다.");
    }

    public void printPlayerChoice(int idx){
        idx += 1;
        System.out.println(idx + "번 플레이어의 차례입니다. 행동을 선택하세요. (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복, exit: 종료)");
    }

    public void printEnd(){
        System.out.println("프로그램을 종료합니다.");
    }

    public void printPlayerChoiceError(){
        System.out.println("1~4 사이의 정수를 입력해주세요.");
    }

    public void printTypeError(){
        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
    }

    public void printEnemyAttack(int idx, int damage, int hp){
        idx += 1;
        System.out.println(idx + "번 유저에게 " + damage + "의 데미지. 적의 공격으로 현재 남은 체력은 " + hp + "입니다.");
    }

    public void printEnemyHp(int hp){
        System.out.println("적의 회복으로 현재 적의 체력은 " + hp + "입니다.");
    }

    public void printEnemyHpIsFull(){
        System.out.println("적이 회복했습니다. 현재 적은 최대 체력입니다.");
    }

    public void printEnemyTurn(){
        System.out.println("적의 차례입니다.");
    }

    public void printEnemyDoNothing(){
        System.out.println("적은 섣불리 움직이지 못하고 있습니다.");
    }

    public void printGameInput(){
        System.out.print("플레이어 인원을 정하세요 : ");
    }

    public void printGameInputRangeError(){
        System.out.println("플레이어 인원은 1 이상이어야 합니다.");
    }

    public void printEnemyLose(){
        System.out.println("축하합니다! 승리하셨습니다!");
    }

    public void printEnemyWin(){
        System.out.println("아쉽지만 패배하셨습니다ㅠㅠ");
    }
}
