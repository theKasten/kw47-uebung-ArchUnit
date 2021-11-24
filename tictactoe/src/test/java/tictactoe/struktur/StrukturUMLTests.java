//package tictactoe.struktur;
//
//import com.tngtech.archunit.junit.ArchTest;
//import com.tngtech.archunit.lang.ArchRule;
//
//import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
//import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.Configurations.consideringOnlyDependenciesInDiagram;
//import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.adhereToPlantUmlDiagram;
//
//public class StrukturUMLTests {
//
//  @ArchTest
//  static ArchRule rule1 = classes()
//          .should(adhereToPlantUmlDiagram(ArchUnit.class.getResource("architecture.uml")),
//                  consideringOnlyDependenciesInDiagram());
//}
