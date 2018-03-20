package pl.mateusz.bootcamp;

import java.util.Optional;

public class StringUtils {

    Optional<String> getFirstLetterUppercase(String word){
        if (word==null || word.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(word.substring(0,1).toUpperCase());
    }

    String getFirestLatterUppercaseNotOptional(String word){
        if(word == null || word.isEmpty()){
            return null;
        }
        return word.substring(0,1).toUpperCase();
    }
}
