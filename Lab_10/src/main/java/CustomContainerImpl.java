import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import Exceptions.*;

public class CustomContainerImpl implements CustomContainer {

    Map<String, Object> hashMap = new HashMap<>();
    Map<String, Function> functionMap = new HashMap<>();

    @Override
    public <T> boolean addInstance(T instance) {
        if(instance == null){
            throw new NullParameterException();
        }
        addInstance(instance, instance.getClass().getName());
        return true;
    }

    @Override
    public <T> boolean addInstance(T instance, String customName) {
        if(instance == null || customName == null){
            throw new NullParameterException();
        }
        if(hashMap.containsKey(customName)){
            throw new NameAlreadyAddedException();
        }
        hashMap.put(customName, instance);
        return true;
    }

    @Override
    public <T> T getInstance(Class<T> type) {
        if(type == null){
            throw new NullParameterException();
        }
        if(!hashMap.containsKey(type.getName()) && !functionMap.containsKey(type.getName())){
            throw new CannotProvideInstanceException();
        }

        if(hashMap.containsKey(type.getName())){
            return (T) hashMap.get(type.getName());
        }

        if(functionMap.containsKey(type.getName())){
            try{
                Object object = functionMap.get(type.getName()).apply(this);
                hashMap.put(type.getName(), object);
                return (T) object;
            }catch (ClassCastException ignored){}
        }

        return null;
    }

    @Override
    public <T> T getInstance(Class<T> type, String customName) {
        if(type == null || customName == null){
            throw new NullParameterException();
        }
        if(!hashMap.containsKey(customName) && !functionMap.containsKey(customName)){
            throw new CannotProvideInstanceException();
        }

        Object o = null;
        if(hashMap.containsKey(customName)){
            o = hashMap.get(customName);
        }
        else
        if(functionMap.containsKey(customName)){
            try{
                o = functionMap.get(customName).apply(this);
                hashMap.put(customName, o);
            }catch (ClassCastException ignored){}
        }

        if(o.getClass()!=type) {
            throw new InvalidTypeException();
        }

        return (T) o;
    }

    @Override
    public <T> boolean addFactoryMethod(Class<T> type, Function<CustomContainer, T> factoryMethod) {
        if(type == null || factoryMethod == null){
            throw new NullParameterException();
        }
        if(functionMap.containsKey(type.getName())){
            throw new NameAlreadyAddedException();
        }
        functionMap.put(type.getName(), factoryMethod);
        return true;
    }

    @Override
    public <T> T create(Class<T> type) {
        if(type == null){
            throw new NullParameterException();
        }
        if(!functionMap.containsKey(type.getName())){
            throw new CannotProvideInstanceException();
        }

        try{
            Object object = functionMap.get(type.getName()).apply(this);
            return (T) object;
        }catch (ClassCastException ignored){
            throw new CannotProvideInstanceException();
        }
    }

    @Override
    public <T> T create(Class<T> type, Map<String, Object> parameters) {
        if(type == null){
            throw new NullParameterException();
        }
        if(!functionMap.containsKey(type.getName())){
            throw new CannotProvideInstanceException();
        }

        try(CustomContainerImpl customContainer = new CustomContainerImpl()){
            for (Entry<String, Object> entry : parameters.entrySet()) {
                customContainer.addInstance(entry.getValue(), entry.getKey());
            }
            Object object = functionMap.get(type.getName()).apply(customContainer);
            return (T) object;
        }catch (ClassCastException ignored){
            throw new CannotProvideInstanceException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        for (Object value : hashMap.values()) {
            if(value instanceof Closeable){
                ((Closeable)value).close();
            }
        }
        for (Object value : functionMap.values()) {
            if(value instanceof Closeable){
                ((Closeable)value).close();
            }
        }
    }
}
