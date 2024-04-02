package task1;

import java.util.Optional;

public final class MyOptional<T> {

    private final Optional<T> value;
    private MyOptional(T newValue){
        value = Optional.ofNullable(newValue);
    }

    public static <T> MyOptional<T>of(T value){
        return new MyOptional<>(value);
    }

    public boolean isPresent(){
        return value.isPresent();
    }

    public T get(){
        return value.get();
    }

}
