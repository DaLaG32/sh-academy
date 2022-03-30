package cz.cvut.sh.reactiveworld;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.util.ArrayUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

@Slf4j
@RestController
@SpringBootApplication
public class ReactiveWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveWorldApplication.class, args);
	}

	@GetMapping("/hello-world")
	public Flux<Character> helloWordReactive(){
		return Mono.just("Hello reactive world!")
				.doOnNext(log::info)
				.map(s1 -> s1.chars().mapToObj(c -> (char)c).toArray(Character[]::new))
				.flatMapMany(Flux::fromArray);
	}
}
