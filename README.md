# 소개
* `KOMORANRestAPIServer`는 [KOMORAN 3.0](https://github.com/shin285/KOMORAN) 의 간단한 RESTful API Server입니다.<br />
* [Spring Boot](http://projects.spring.io/spring-boot/) 기반으로 제작하였습니다.<br />

# 빠른 실행
* `git clone` 후, 다음의 명령어를 이용하여 실행합니다.
```shell
./gradlew bootRun
```

# 간단한 사용법
* Web Browser를 열어, `localhost:8080/api`에 접근합니다.
* 이 때, `GET` Method로 분석하고자 하는 문장(`query`)과 사전 모델의 종류(`model_type`: `full`, `light`)를 입력합니다.
* 예1. `Full Model`을 이용하여 `바람과 함께 사라지다를 봤어.`라는 문장을 분석하고 싶을 경우
```
/*
 * 호출 URL: http://localhost:8080/api?query=바람과 함께 사라지다를 봤어.&model_type=full
 */
/* 
 * 결과:
 *  {
 *    "queryString":"바람과 함께 사라지다를 봤어.",
 *    "useModelSizeFull":true,
 *    "queryResult":[
 *       {"first":"바람과 함께 사라지다","second":"NNP"},
 *       {"first":"를","second":"JKO"},
 *       {"first":"보","second":"VV"},
 *       {"first":"았","second":"EP"},
 *       {"first":"어","second":"EF"},
 *       {"first":".","second":"SF"}
 *    ]
 *  }
 */
```
 * 예2. `Light Model`을 이용하여 `바람과 함께 사라지다를 봤어.`라는 문장을 분석하고 싶을 경우
```
/*
 * 호출 URL: http://localhost:8080/api?query=바람과 함께 사라지다를 봤어.&model_type=light
 */
/* 
 * 결과:
 *  {
 *    "queryString":"바람과 함께 사라지다를 봤어.",
 *    "useModelSizeFull":false,
 *    "queryResult":[
 *        {"first":"바람","second":"NNG"},
 *        {"first":"과","second":"JC"},
 *        {"first":"함께","second":"MAG"},
 *        {"first":"사라지","second":"VV"},
 *        {"first":"다","second":"EC"},
 *        {"first":"를","second":"JKO"},
 *        {"first":"보","second":"VV"},
 *        {"first":"았","second":"EP"},
 *        {"first":"어","second":"EF"},
 *        {"first":".","second":"SF"}
 *    ]
 *  }
 */
```

