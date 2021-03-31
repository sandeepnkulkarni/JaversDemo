package local.snk;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.javers.core.diff.changetype.ValueChange;

public class JaversDemo {
    public static void main(String[] args) {
        Person personOld = PersonBuilder.Person(1,"Sandeep")
                .withLogin("sandeep@abc.com")
                .withPosition(Position.Developer)
                .build();

        System.out.println(personOld);

        Person personNew = PersonBuilder.Person(1, "Sandip")
                .withLogin("sandip@abc.com")
                .withPosition(Position.Assistant)
                .build();

        System.out.println(personNew);

        Javers javers = JaversBuilder.javers().build();
        Diff diffResult = javers.compare(personOld, personNew);

        System.out.println("Diff result: \n" + diffResult.prettyPrint());

        StringBuilder personDiff = new StringBuilder();
        diffResult.getChangesByType(ValueChange.class).forEach((diff -> {
            personDiff.append( String.format("Field: %s, OldValue: %s, NewValue: %s %n", diff.getPropertyName(), diff.getLeft(), diff.getRight()));
        }));

        System.out.println("Custom diff result: \n" + personDiff.toString());
    }
}
