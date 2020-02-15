package tech.coderhub.green;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("tech.coderhub.green");

        noClasses()
            .that()
                .resideInAnyPackage("tech.coderhub.green.service..")
            .or()
                .resideInAnyPackage("tech.coderhub.green.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..tech.coderhub.green.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
