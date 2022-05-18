package Basics.Reactive_Programming.services;

import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoServices {
    public Flux<String> fruitsFlux(){
        return Flux.fromIterable(List.of("Mango","Banana","Grapes")).log();

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
