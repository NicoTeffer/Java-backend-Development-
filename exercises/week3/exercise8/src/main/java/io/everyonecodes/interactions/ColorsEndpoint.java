package io.everyonecodes.interactions;

import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/colors")
public class ColorsEndpoint {

    private final Set<String> colors;

    public ColorsEndpoint(Set<String> colors) {  // <-----  DON'T FORGET THE CONSTRUCTOR!!!
        this.colors = colors;
    }

    // TODO: Has the get mapping that returns all the available colors.
    @GetMapping
    Set<String> getColors() {
        return colors;
    }

    //TODO: Has the “/{name}” get mapping that returns the color with that name if it’s available,
    // otherwise the message: The color is not available in the app.
    @GetMapping("/{name}")
    String getName(@PathVariable String name) {
        var result = colors.stream()
                .filter(x -> x.equals(name))
                .findFirst();
        if (result.isEmpty()) {
            return "The color is not available in the app!";
        }
        return result.get();
    }

    //TODO: Has the post mapping that receives a String and adds it to the available colors and returns it.
    @PostMapping
    String post(@RequestBody String color) {
        colors.add(color);
        return color;
    }

    //TODO: Has the “/{target}” put mapping that receives a String and replaces the target color
    // with the received String and returns it.
    @PutMapping("/{target}")
    String put(@PathVariable String target, @RequestBody String replacement) {
        colors.remove(target);
        colors.add(replacement);
        return replacement;
    }

    //TODO: Has the delete mapping that deletes all available colors
    @DeleteMapping
    void deleteAll(){
        colors.clear();
    }

    //TODO: Has the “/{name}” delete mapping that deletes the color with the provided name.
    @DeleteMapping("/{name}")
    void deleteOne(@PathVariable String name){
        colors.remove(name);
    }
}
