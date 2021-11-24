package tictactoe.struktur;

import annotations.AggregateRoot;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tictactoe.TictactoeApplication;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class StrukturTests {

  private final JavaClasses klassen =
          new ClassFileImporter().importPackagesOf(TictactoeApplication.class);

  @Test
  @DisplayName("Testet ob alles Private ist, das nicht mit aggregate root deklariert wurde")
  public void test_1() {
    ArchRule rule = classes()
            .that()
            .areNotAnnotatedWith(AggregateRoot.class)
            .and()
            .resideInAnyPackage("..game..")
            .should()
            .notBePublic()
            .because("Die implementierung eines Aggregates sollte versteckt sein");
    System.out.println(klassen);
    rule.check(klassen);
  }

  @Disabled("Test funktioniert nicht")
  @Test
  @DisplayName("Testet ob alles Public ist, was mit aggregate root deklariert wurde")
  public void test_2() {
    ArchRule rule = classes()
            .that()
            .areAnnotatedWith(AggregateRoot.class)
            .and()
            .resideInAnyPackage("..game..")
            .should()
            .bePublic()
            .because("Aggregate Root sollte public sein");
    rule.check(klassen);
  }
}
