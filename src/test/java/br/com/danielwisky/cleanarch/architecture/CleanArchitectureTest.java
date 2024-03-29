package br.com.danielwisky.cleanarch.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import br.com.danielwisky.cleanarch.CleanArchApplication;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(
    packagesOf = CleanArchApplication.class,
    importOptions = ImportOption.DoNotIncludeTests.class
)
public class CleanArchitectureTest {

  private static final String CONFIG = "Config";
  private static final String[] CONFIG_PACKAGES = {"..configs..", "..configurations.."};
  private static final String CONTROLLER = "Controller";
  public static final String[] CONTROLLER_PACKAGES = {"..controllers..", "..http.."};
  private static final String DOMAIN = "Domain";
  private static final String DOMAIN_PACKAGE = "..domains..";
  private static final String GATEWAY = "Gateway";
  private static final String GATEWAY_PACKAGE = "..gateways..";
  private static final String REPOSITORY = "Repository";
  private static final String REPOSITORY_PACKAGE = "..repositories..";
  private static final String USE_CASE = "UseCase";
  private static final String USE_CASE_PACKAGE = "..usecases..";

  @ArchTest
  static final ArchRule layerRule = layeredArchitecture()
      .consideringOnlyDependenciesInLayers()
      .layer(CONFIG).definedBy(CONFIG_PACKAGES)
      .layer(CONTROLLER).definedBy(CONTROLLER_PACKAGES)
      .layer(DOMAIN).definedBy(DOMAIN_PACKAGE)
      .layer(GATEWAY).definedBy(GATEWAY_PACKAGE)
      .layer(REPOSITORY).definedBy(REPOSITORY_PACKAGE)
      .layer(USE_CASE).definedBy(USE_CASE_PACKAGE)
      .whereLayer(CONFIG).mayOnlyBeAccessedByLayers(GATEWAY)
      .whereLayer(CONTROLLER).mayOnlyBeAccessedByLayers(GATEWAY)
      .whereLayer(DOMAIN).mayOnlyBeAccessedByLayers(USE_CASE, GATEWAY, CONTROLLER)
      .whereLayer(GATEWAY).mayOnlyBeAccessedByLayers(USE_CASE, CONTROLLER, CONFIG)
      .whereLayer(REPOSITORY).mayOnlyBeAccessedByLayers(GATEWAY)
      .whereLayer(USE_CASE).mayOnlyBeAccessedByLayers(CONTROLLER, GATEWAY);

  @ArchTest
  static final ArchRule controllerRule = classes()
      .that()
      .haveSimpleNameEndingWith(CONTROLLER)
      .should()
      .resideInAnyPackage(CONTROLLER_PACKAGES);

  @ArchTest
  static final ArchRule repositoryRule = classes()
      .that()
      .haveSimpleNameEndingWith(REPOSITORY)
      .should()
      .resideInAnyPackage(REPOSITORY_PACKAGE);

  @ArchTest
  static final ArchRule gatewayRule = classes()
      .that()
      .haveSimpleNameEndingWith(GATEWAY)
      .should()
      .resideInAnyPackage(GATEWAY_PACKAGE);

}
