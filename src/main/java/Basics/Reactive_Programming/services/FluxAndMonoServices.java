package Basics.Reactive_Programming.services;

import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoServices {
    public Flux<String> fruitsFlux(){
        return Flux.fromIterable(List.of("Mango","Banana","Grapes")).log();

    }

    public Flux<String> fruitsFluxMap(){
        return Flux.fromIterable(List.of("Mango","Banana","Grapes")).map(String::toUpperCase);

    }

    public Flux<String> fruitsFluxFilter(int number){
        return Flux.fromIterable(List.of("Mango","Banana","Grapes")).filter(s -> s.length()>number);

    }

    public Flux<String> fruitsFluxFilterMap(int number){
        return Flux.fromIterable(List.of("Mango","Banana","Grapes")).filter(s -> s.length()>number).map(String::toUpperCase);

    }

    public Mono<String> fruitsMono(){
        return Mono.just("Mango").log();
    }

    public static void main(String[] args) {
        FluxAndMonoServices fluxAndMonoServices
                = new FluxAndMonoServices();

        fluxAndMonoServices.fruitsFlux().subscribe(s->{
            System.out.println(" s = "+s);

        });
        fluxAndMonoServices.fruitsMono().subscribe(s->{
            System.out.println(" s -> Mono = "+s);

        });

    }
}
