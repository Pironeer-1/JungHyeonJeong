## 컨벤션

```
week3
│  Week3Application.java
│
├─board
│  ├─controller
│  │      BoardController.java
│  │
│  ├─dto
│  │  ├─request
│  │  │      BoardCreateRequest.java
│  │  │      BoardUpdateRequest.java
│  │  │
│  │  └─response
│  │          BoardResponse.java
│  │
│  ├─entity
│  │      Board.java
│  │
│  ├─mapper
│  │      BoardMapper.java
│  │
│  ├─repository
│  │      BoardMemoryRepository.java
│  │      BoardRepository.java
│  │
│  └─service
│          BoardService.java
│
├─global
│  ├─config
│  │      OpenApiConfig.java
│  │
│  ├─dto
│  │  └─response
│  │      │  ErrorResponse.java
│  │      │  JwtTokenSet.java
│  │      │  SuccessResponse.java
│  │      │
│  │      └─result
│  │              ExceptionResult.java
│  │              ListResult.java
│  │              ResponseState.java
│  │              SingleResult.java
│  │
│  ├─exception
│  │      CustomException.java
│  │      ErrorCode.java
│  │      ExceptionAdvice.java
│  │
│  ├─jwt
│  │      JwtInterceptor.java
│  │      JwtUtil.java
│  │
│  └─service
│          AuthService.java
│          ResponseService.java
│
└─member
    ├─controller
    │      MemberController.java
    │
    ├─dto
    │  ├─request
    │  │      MemberCreateRequest.java
    │  │      MemberLoginRequest.java
    │  │
    │  └─response
    ├─entity
    │      Member.java
    │
    ├─mapper
    │      MemberMapper.java
    │
    ├─repository
    │      MemberMemoryRepository.java
    │      MemberRepository.java
    │
    └─service
            MemberService.java
```
- 도메인형 디렉토리 구조 사용

  이전 과제에서 추가로 member 도메인 개발을 하면서 여러 컨트롤러가 한 패키지에 있고 DTO도 한 패키지에 있어 복잡하다고 느꼈음. 도메인형 구조를 사용해서 조금 더 깔끔하게 정리함
- 응답 규격화

  응답 객체를 크게 List와 Single result로 나누어서 SingleResult와 ListResult로 감쌌음
  그리고 응답을 error와 success로 나누어서 일정한 형식에 담아 응답을 반환함
  </br>

## 프로그래머스 SQL 10문제
<img width="611" alt="프로그래머스 인증" src="https://github.com/user-attachments/assets/8334bdea-df69-454f-9c46-1fd65c293a1d">