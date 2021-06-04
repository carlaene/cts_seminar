package ro.ase.csie.cts.tema4.teste;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(TestPrincipal.class)
@SuiteClasses({Cerinta1.class})
public class Cerinta4SuiteNotAllClasses {

}
