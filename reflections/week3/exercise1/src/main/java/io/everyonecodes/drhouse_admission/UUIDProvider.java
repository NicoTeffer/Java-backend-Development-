package io.everyonecodes.drhouse_admission;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UUIDProvider {

    private final List<String> cache;

    public UUIDProvider(List<String> cache) {
        this.cache = cache;
    }

    // AFTER STARTING 3 Times over because INTELLIJ somehow removed maven dependencies I could not finish this part here anymore
    // since I had to upload this from my PC to my LAPTOP to make the GitHub push, but I hope it shows that i at least tried.
    // This was a horrible experience with INTELLIJ, I might need to rollback too *sigh*

    public void provideUUID(Patient patient) {
    }

    public List<String> getCacheSnapshot(){
        return new ArrayList<>(cache);
    }

    public String findUUID(String name){
       return "";
    }
}
