# 🎬 나만의 영화 정보 및 리뷰 웹 애플리케이션

Spring Boot와 JPA를 사용하여 영화 정보를 조회하고, JWT 기반 인증을 통해 사용자들이 리뷰를 남길 수 있는 RESTful API 서버 및 웹 애플리케이션입니다.

<br>

## ✨ 주요 기능

- **영화 정보**: TMDB API와 연동하여 인기 영화 목록을 동적으로 가져와 표시합니다.
- **영화 검색 및 상세 조회**: 제목으로 영화를 검색하고, 특정 영화의 상세 정보를 조회할 수 있습니다.
- **회원 관리**: JWT 기반의 로그인/회원가입 기능을 제공합니다.
- **리뷰 (댓글)**: 로그인한 사용자만 특정 영화에 대한 리뷰를 작성하고 조회할 수 있습니다.
- **프론트엔드**: Bootstrap과 Vanilla JavaScript를 사용하여 모든 백엔드 기능을 실제로 사용하고 테스트할 수 있는 UI를 제공합니다.

<br>

## 🖼️ 실행 화면

**메인 페이지**
![메인 페이지 스크린샷](URL_링크)

**상세 및 리뷰 페이지**
![상세 페이지 스크린샷](URL_링크)

<br>

## 🛠️ 기술 스택

**Backend**
- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Data JPA

**Database**
- MySQL

**Frontend**
- HTML, CSS, JavaScript
- Bootstrap 5

**DevOps & Tools**
- Git, GitHub
- IntelliJ IDEA
- Postman

<br>

## 🚀 시작하기

### 전제 조건
- Java 17
- Gradle 8.x
- MySQL

### 실행 방법
1. Git 저장소를 클론합니다.
   ```bash
   git clone [https://github.com/your-username/your-repo.git](https://github.com/your-username/your-repo.git)
   ```
2. `application.properties` 파일을 설정합니다.
   `src/main/resources/` 경로에 `application.properties` 파일을 생성하고 아래 내용을 채워주세요.
   ```properties
   # Database
   spring.datasource.url=jdbc:mysql://localhost:3306/tmdb_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   
   # JWT
   jwt.secret.key=your_super_secret_key
   jwt.token.expiration=86400000
   
   # TMDB API
   tmdb.api.key=your_tmdb_api_key
   ```
3. 애플리케이션을 실행합니다.

<br>

## 📖 API 명세

| Method | URL                                 | 설명                    | 인증 필요 |
| ------ | ----------------------------------- | ----------------------- | --------- |
| POST   | `/api/auth/signup`                  | 회원가입                | X         |
| POST   | `/api/auth/login`                   | 로그인 (JWT 발급)       | X         |
| GET    | `/api/movies`                       | 전체 영화 목록 조회     | O         |
| GET    | `/api/movies/{id}`                  | 특정 영화 상세 조회     | O         |
| GET    | `/api/movies/search?title={title}`  | 영화 제목으로 검색      | O         |
| POST   | `/api/movies/{movieId}/reviews`     | 특정 영화에 리뷰 작성   | O         |
| GET    | `/api/movies/{movieId}/reviews`     | 특정 영화의 리뷰 목록 조회| O         |

<br>

## 📊 ERD (데이터베이스 관계 다이어그램)

![ERD 이미지](URL_링크)

<br>

## 🤯 트러블슈팅 / 배운 점

- **문제**: Spring Security 적용 후 토큰 없이 API 요청 시 `200 OK`가 반환되는 문제.
  - **원인**: `JwtAuthenticationFilter`에서 `filterChain.doFilter()`가 `if`문 안쪽에 있어, 토큰이 없는 요청이 다음 필터로 전달되지 않고 그냥 종료되었음.
  - **해결**: `filterChain.doFilter()`를 `if`문 바깥으로 이동시켜 모든 요청이 필터 체인을 통과하도록 수정.
- **학습**: JWT 인증 필터의 동작 원리와 `SecurityFilterChain`의 흐름을 깊이 이해하게 됨. `Optional`, Java Stream API 등 Java 최신 문법을 실제 프로젝트에 적용하며 체득함.
