package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.MovieDatabase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 12/23/19.
 */
@Component
public class BootStrapData implements CommandLineRunner {



    @Override
    public void run(String... args) throws Exception {

            try {
                MovieDatabase originalObject = new MovieDatabase(); // Default Constructor call
                originalObject.getData(); // External API call
                System.out.println("originalObject: " + originalObject);
                System.out.println("*******************************************************");
                MovieDatabase clonedObject = originalObject.clone(); // Object creation using Cloning
                clonedObject.getRatings().remove(2); // change in mutable rating field which is deep cloned
                clonedObject.getGenre().add("SuperHero"); // change in genre which is shallow cloned
                System.out.println("clonedObject: " + clonedObject); // clonedObject shows all above changes
                System.out.println("*******************************************************");
                System.out.println("originalObject: " + originalObject); // Original Object shows changes in    //only genre as it was shallow cloned. Changes in rating will not occur in original onject as it is deep //cloned.
                System.out.println("*******************************************************");

            } catch (CloneNotSupportedException e) {

                e.printStackTrace();
            }

        }
    }


