### 프로젝트 구조
```
src
│  Main.java
│  
├─Enemy
│      Enemy.java
│      EnemyAction.java
│      
├─Game
│      Game.java
│      
├─Player
│      Player.java
│      PlayerAction.java
│      
└─Utils
      Logger.java
      NumberEnum.java
```
<br>

### 챌린지 과제
- [X] 클래스 5개 이상으로 구성되도록 클래스 나누기
- [X] 패키지 3개 이상으로 구성되도록 패키지 나누기
- [X] 모든 수치값들 하나의 ENUM 클래스에 정의하여 사용하기
- [X] 모든 출력문들을 다른 클래스에 정의하여 사용하기

<br>

### 출력 예시

![title](https://github.com/user-attachments/assets/3a882e05-a5b3-40a8-a061-1963f5c721f4)


- 스테이터스 입력에서 음수 입력, 문자 입력, 합이 13이 아닌 경우 예외 처리
- 명세서에 따라 플레이어가 죽을 경우 리스트에서 삭제했지만 그에 따라 플레이어의 인덱스가 하나씩 앞당겨짐. 예를 들어, 1번 플레이어가 죽을 경우 기존의 2번 플레이어가 1번 플레이어가 되는 케이스 발생
