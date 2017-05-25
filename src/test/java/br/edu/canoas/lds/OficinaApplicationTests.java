package br.edu.canoas.lds;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Wait
public class OficinaApplicationTests extends FluentTest {

	@Value("${local.server.port}")
	int port;

	String getUrl(String file) {
		return "http://localhost:" + port + "/bootstrap/" + file + ".html";
	}
	
	@Test
	public void internacionalizationTeste() {
		goTo(getUrl("index"));
		assertThat(window().title()).isEqualTo("Reparação automotiva JR");
		$("#ukIndex").click();
		assertThat($("#ukTxt")).hasText("CAR REPAIR JR");
		$("#brIndex").click();
		assertThat($("#brTxt")).hasText("REPARAÇÃO AUTOMOTIVA JR");		
	}
	

	@Test
	public void loginTeste() {
		goTo(getUrl("login"));
		assertThat(window().title()).isEqualTo("Reparação automotiva JR");
		$("#usuario").fill().with("Ricardo");
		$("#senha").fill().with("123456");
		$("#entrar").submit();
	}
	
	@Test
	public void estoqueTeste() {
		goTo(getUrl("estoque"));
		assertThat(window().title()).isEqualTo("Reparação automotiva JR");
		$("#inserir").click();
		$("#codigo").fill().with("123456");
		$("#fabricante").fill().with("Toyota");
		$("#modelo").fill().with("Etios");
		$("#ano").fill().with("2017");
		$("#descricao").fill().with("Amortecedor");
		$("#selectComp").fill().with("Par");
		$("#localizacao").fill().with("X10");
		$("#fornecedor").fill().with("Ancora");
		$("#valor").fill().with("1234,56");
		$("#quantidade").fill().with("11");
		$("#inserir").click();
	}
	
	@Test
	public void visualizarTeste() {
		goTo(getUrl("estoque"));
		assertThat(window().title()).isEqualTo("Reparação automotiva JR");
		$("#visualizar").click();
		assertThat(window().title()).isEqualTo("Reparação automotiva JR");
		assertThat($("#codigo").text()).contains("20002");
		assertThat($("#fabricante").text()).contains("Wolkswagem");
		assertThat($("#modelo").text()).contains("Gol");
		assertThat($("#fabricacao").text()).contains("2001");
		assertThat($("#descricao").text()).contains("Amortecedor");
		assertThat($("#composicao").text()).contains("Par");
		assertThat($("#posicao").text()).contains("C2");
		assertThat($("#fornecedor").text()).contains("Ancora");
		assertThat($("#valor").text()).contains("780,00");
		assertThat($("#quantidade").text()).contains("4");		
		$("#voltar").click();
	}
	
	@Test
	public void editarTeste() {
		goTo(getUrl("estoque"));
		assertThat(window().title()).isEqualTo("Reparação automotiva JR");
		$("#editar").click();
		assertThat(window().title()).isEqualTo("Reparação automotiva JR");
//		assertThat($("#codigo").text()).contains("20002");
//		assertThat($("#fabricante").text()).contains("Wolkswagem");
//		assertThat($("#modelo").text()).contains("Gol");
//		assertThat($("#fabricacao").text()).contains("2001");
//		assertThat($("#descricao").text()).contains("Amortecedor");
//		assertThat($("#composicao").text()).contains("Par");
//		assertThat($("#posicao").text()).contains("C2");
//		assertThat($("#fornecedor").text()).contains("Ancora");
//		assertThat($("#valor").text()).contains("780,00");
//		assertThat($("#quantidade").text()).contains("4");		
		$("#salvar").click();
	}
	
	@Test
	public void apagarTeste() {
		goTo(getUrl("estoque"));
		assertThat(window().title()).isEqualTo("Reparação automotiva JR");
		$("#apagar").click();
//		assertThat(window().title()).isEqualTo("Reparação automotiva JR");
//		assertThat($("#codigo").text()).contains("20002");
//		assertThat($("#fabricante").text()).contains("Wolkswagem");
//		assertThat($("#modelo").text()).contains("Gol");
//		assertThat($("#fabricacao").text()).contains("2001");
//		assertThat($("#descricao").text()).contains("Amortecedor");
//		assertThat($("#composicao").text()).contains("Par");
//		assertThat($("#posicao").text()).contains("C2");
//		assertThat($("#fornecedor").text()).contains("Ancora");
//		assertThat($("#valor").text()).contains("780,00");
//		assertThat($("#quantidade").text()).contains("4");		
		
	}
	
	

}
