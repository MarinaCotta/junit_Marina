package carrinho;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

class CarrinhoTest {
	Carrinho carrinho = new Carrinho();
	Produto item1;
	Produto item2;

	@BeforeEach
	public void inicializa() {
		item1 = new Produto("Chocolate", 10.0);
		item2 = new Produto("Bolo de pote", 15.0);
		carrinho.addItem(item1);
		carrinho.addItem(item2);
	}
	
	@DisplayName("Testa a função adicionar itens")
	@Test
	public void testAddItem() {
		carrinho.addItem(item1);
		carrinho.addItem(item2);
		Assertions.assertEquals(4, carrinho.getQtdeItems());	
	}
	
	@DisplayName("Testa a quantidade de itens")
	@Test
	public void getQtdeItems() {
		int quant_itens = carrinho.getQtdeItems();
		Assertions.assertEquals(2,quant_itens);
	}
	
	@DisplayName("Testa a função valor total")
	@Test
	public void getValorTotal() {
		double valorTotal = carrinho.getValorTotal();		
		Assertions.assertEquals(25, valorTotal);	
	}
	
	@DisplayName("Testa a função remover itens")
	@Test public void testRemoveItem() throws ProdutoNaoEncontradoException {
		carrinho.removeItem(item1); 
		carrinho.removeItem(item2);
		Assertions.assertEquals(0, carrinho.getQtdeItems()); 
	}	 

}
