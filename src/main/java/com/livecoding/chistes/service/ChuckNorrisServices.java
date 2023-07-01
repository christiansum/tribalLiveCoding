package com.livecoding.chistes.service;

import com.livecoding.chistes.dto.ChuckNorrisJokeDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ChuckNorrisServices {
	public List<ChuckNorrisJokeDTO> getAll(){
		String url = "https://api.chucknorris.io/jokes/random";
		WebClient webClient = WebClient.create(url);

		Flux<ChuckNorrisJokeDTO> listChistes = Flux.range(0, 25)
				.flatMap(i -> webClient.get()
						.retrieve()
						.bodyToMono(ChuckNorrisJokeDTO.class))
				.distinct(ChuckNorrisJokeDTO::getId)
				.take(25)
				.timeout(Duration.ofSeconds(3));
		return listChistes.collectList().block();
	}
}
