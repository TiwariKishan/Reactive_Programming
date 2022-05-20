package Basics.Reactive_Programming.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class FluxAndMonoServicesTest {
    FluxAndMonoServices fluxAndMonoServices
            = new FluxAndMonoServices();
    @Test
    void fruitsFlux() {
        var fruitsFlux = fluxAndMonoServices.fruitsFlux();
        StepVerifier.create(fruitsFlux)
                .expectNext("Mango","Banana","Grapes").verifyComplete();

    }

    @Test
    void fruitsMono() {
        var fruitsMono = fluxAndMonoServices.fruitsMono();
        StepVerifier.create(fruitsMono)
                .expectNext("Mango").verifyComplete();
    }

    @Test
    void fruitsFluxMap() {
        var fruitsFluxMap = fluxAndMonoServices.fruitsFluxMap();
        StepVerifier.create(fruitsFluxMap)
                    .expectNext("MANGO","BANANA","GRAPES").verifyComplete();
    }

    @Test
    void fruitsFluxFilter() {
        var fruitsFluxFilter = fluxAndMonoServices.fruitsFluxFilter(5).log();
        StepVerifier.create(fruitsFluxFilter)
                    .expectNext("Banana","Grapes").verifyComplete();
    }

    @Test
    void fruitsFluxFilterMap() {
        var fruitsFluxFilterMap = fluxAndMonoServices.fruitsFluxFilterMap(5).log();
        StepVerifier.create(fruitsFluxFilterMap)
                    .expectNext("BANANA","GRAPES").verifyComplete();
    }
}