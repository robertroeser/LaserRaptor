package laser.raptor.core.server.server_functions;

import rx.Observable;

@FunctionalInterface
public interface ServerFunction<I,O> {
    Observable<O> apply(Observable<I> iObservable);
}
