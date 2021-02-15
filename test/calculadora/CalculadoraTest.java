package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@DisplayName("Testa a multiplicação de dois números")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(3, 4);
		assertTrue(multiplicacao == 12);
	}
	
	@DisplayName("Testa a somatoria")
	@Test
	public void testSomatoria() {
		int somatoria = calc.somatoria(4);
		assertTrue(somatoria == 10);
	}
	
	@DisplayName("Testa se o numero é positivo")
	@Test
	public void testEhPositivo() {
		boolean ehPositivo = calc.ehPositivo(10);
		assertTrue(ehPositivo);
	}
	
	@DisplayName("Testa a comparacao entre dois numeros")
	@Test
	public void testComparaDoisNumeros() {
		int compara1  = calc.compara(4,4);
		assertTrue(compara1==0);
		int compara2  = calc.compara(4,3);
		assertTrue(compara2== 1);
		int compara3  = calc.compara(3,4);
		assertTrue(compara3== -1);	
	
	}
}
