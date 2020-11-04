# jsp

maven 프로젝트 설정

basic servlet 생성

servlet life cycle

HTTP 메소드

실습
TimesTablesServlet

jsp 프로젝트 git 연동 준비
gitignore

jsp 탄생배경
 : basic.jsp
 
 url 처리 과정
  servlet-mapping
  default-servlet
  jsp-servlet

jsp 처리과정 (servlet 변환과정)

request 객체 주요 메소드

header 정보

request parameter
 . getRequestView.jsp, getRequestResponse.jsp
 . 파라미터 인코딩 설정(GET, POST)

 실습
timesTables.jsp

라디오 버튼을 이용한 requset method 변경

서버, 클라이언트 사이드 변수 값 할당 주의점

response 객체

요청위임
 . redirect
 . dispatcher

요청위임
 . redirect
 . dispatcher

웹 어플리케이션 스코프와 속성

웹 어플리케이션 디렉토리 구조와 URL 매핑

maven build encoding 설정

deploy sh 생성

maven
 build cycle

배포 자동화

로깅 라이브러리
 . 로깅 레벨
 . 문자열 결합 주의
 
 jsp 기본객체
 application
 pageContext
 out (rangers 실습 포함)

scope 객체
 request, session, application

단위 테스트 코드
 rangerServiceTest

실습
 scope
 
 페이지 모듈화
. 정적 include
. 동적 include

웹 어플리케이션 에러 페이지 설정
. web.xml
  . 응답 코드별
  . 예외 타입별
  
  cookie 값 조회하기
  
  Cookie
 . client side
 . server side

Session

Login 기능 추가

MemberService, Dao

db
 . jdbc
 . connection pool
 . jndi
 . mybatis 연동
 
service, dao 객체 생성 성능 개선

EL
 . 속성
 . 파라미터
 . cookie

JSTL(JSP Standard Tag Library
 . core
   . set, remove
   . if, choose
   . forEach

실습
 . main.jsp  사용자 정보 jstl 로직 적용하기
 . timesTablesJstl.jsp
 . memberList.jsp 구현
 . 공통 레이아웃 분리
   (main, memberList, jobs)

EL
 pageContext, contextPath 대체하기
 
실습
 . forEach를 통한 페이지 내비게이션 생성
 . 트랜잭션처리
 . 테스트코드 수정
 
실습
 . pages 속성을 통해 페이지 내비게이션 생성 작업
 . pageSize 파라미터 처리하기

JSTL
 . 국제화 - bundle, message, setBundle

실습
 . select box 변경시 언어 변경
 
JSTL
 . 국제화 - formatNumber, parseNumber
                 formatDate, parseDate
    설명-timezone
    
Filter
 . requestCounterFilter, requestCount.jsp
 . LoginCheckFilter
Filter
 . 전처리, 후처리
Filter
 . wrapper 클래스를 이용한 파라미터 추가
Listener
 . 리스너 종류
 . SessionListener,  SessionAttributeListener 등록
 . userMap.jsp
 . ServletContextListener 등록
fileUpload
 . contentType
 . multipart
실습
 . 사용자 상세조회
실습
 . 사용자 프로필 이미지 처리 서블릿
실습
 . 사용자 신규 등록 처리
 . 파일 확장자 추출
 . 사용자 정보수정
