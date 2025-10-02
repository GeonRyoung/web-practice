package com.example.tmdb_project;

import com.example.tmdb_project.service.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TmdbProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmdbProjectApplication.class, args);
	}

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner loadData(MovieService movieService){
        return (args) -> {
            /*Movie movie1 = new Movie();
            movie1.setId(1L);
            movie1.setTitle("쇼생크 탈출");
            movie1.setOverview("부패한 교도소에서의 희망과 우정 이야기");
            movie1.setReleaseYear(1994);
            movie1.setPosterPath("/path/to/shawshank_poster.jpg");
            repository.save(movie1);

            Movie movie2 = new Movie();
            movie2.setId(2L);
            movie2.setTitle("대부");
            movie2.setOverview("마피아 가문의 흥망성쇠를 그린 대서사시");
            movie2.setReleaseYear(1974);
            movie2.setPosterPath("/path/to/godfather_poster.jpg");
            repository.save(movie2);*/
            System.out.println("======= TMDB에서 인기 영화 목록을 가져옵니다... =======");
            movieService.fetchPopularMoviesAndSave();
            System.out.println("======= 영화 목록 저장 완료! =======");
        };
    }
}
