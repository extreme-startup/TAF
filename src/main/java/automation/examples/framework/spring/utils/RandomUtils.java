package automation.examples.framework.spring.utils;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

public final class RandomUtils {

    private RandomUtils() {
    }

    public static <T> T getRandomFromCollection(final Collection<T> collection) {
        final Collection<T> notNullCollection = Optional.ofNullable(collection).orElseGet(Collections::emptyList);
        final int size = notNullCollection.size();
        if (size == 0) {
            throw new IllegalArgumentException("Source collection is either null or empty");
        }
        final int index = new SecureRandom().nextInt(size);
        final Optional<T> result = notNullCollection.stream().skip(index).limit(1).findAny();
        return result.orElseThrow(() -> new IllegalStateException("Can not get element from collection"));
    }

    public static long getTimeStamp(){
        return new Date().getTime();
    }

}
