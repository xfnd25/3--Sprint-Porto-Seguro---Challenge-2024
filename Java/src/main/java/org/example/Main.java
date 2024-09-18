package org.example;
import org.example.dao.ClienteDao;
import org.example.dao.ClienteDaoImplementada;
import org.example.dao.UsuarioDao;
import org.example.dao.UsuarioDaoImplementada;
import org.example.entities.*;
import org.example.enums.*;


import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

    public static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    public static final String USER = "rm554945";
    public static final String PASS = "020797";

    public static void main(String[] args) throws SQLException {

        // TESTANDO O CRUD na classe Usuario:

        Usuario usuario1 = new Usuario(10L, "Steticar Automotiva", "@hotmail.com", "3320-4467", "Rua Jaraguá") {
            @Override
            public Long getId() {
                return super.getId();
            }

            @Override
            public void adicionarVeiculo(Veiculo veiculo) {
                //TODO
            }

            @Override
            public void removerVeiculo(Veiculo veiculo) {
                //TODO
            }
        };

        DatabaseConfig db = new DatabaseConfig(URL, USER, PASS);

        UsuarioDao usuarioDao = new UsuarioDaoImplementada(db);
        usuarioDao.create(usuario1);
        System.out.println("Usuário {STETICAR} inserido com sucesso!");

        // Lendo todos os usuario do banco de dados
        List<Usuario> usuarios = usuarioDao.read();
        for (Usuario usuario : usuarios) {
            System.out.println("Usuário: " + usuario.getNome() + ", Email: " + usuario.getEmail());
        }

        // UPDATE - Atualizando os dados do usuario
        usuario1.setEmail("joao.silva@email.com");
        usuarioDao.update(usuario1);
        System.out.println("Cliente atualizado com sucesso!");

        // READ - Conferindo atualização
        System.out.println("Usuário após atualização:");
        usuarioDao.read().forEach(System.out::println);

        // DELETE - Removendo o usuário
        usuarioDao.delete(usuario1.getId());
        System.out.println("Usuário deletado com sucesso!");


        // TESTES SPRINTS 1 E 2:

        // Criando clientes
        Cliente clienteMaria = new Cliente(1L,"Maria", "maria@example.com", "123456789", "Rua A", 72L, Genero.MULHER_CIS, "02702798729");
        Cliente clienteJesus = new Cliente(2L,"João", "joao@example.com", "987654321", "Rua B",50L, Genero.HOMEM_CIS, "12345678900");

        // Criando veículos
        Veiculo veiculo1 = new Veiculo("1", "TVT35672" , "Fiat", "Uno", TipoCombustivel.GASOLINA, Cambio.MANUAL);
        Veiculo veiculo2 = new Veiculo( "2","ACA78298", "Volkswagen", "Golf", TipoCombustivel.FLEX, Cambio.AUTOMATICO);

        // Associando veículos aos clientes
        clienteMaria.adicionarVeiculo(veiculo1);
        clienteJesus.adicionarVeiculo(veiculo2);

        // Criando oficina
        Oficina oficina = new Oficina(1L,"Steticar Automotiva", "steticar@exemplo.com", "8233204467", "Rua jaraguá");

        // Criando orçamento
        Orcamento orcamento = new Orcamento(ServicoAuto.ALINHAMENTO_DIRECAO, 100.0, 50.0);

        // Criando agenda de serviço
        AgendaServico agendaServico = new AgendaServico(clienteMaria, veiculo1, new Date(), oficina, ServicoAuto.ALINHAMENTO_DIRECAO, orcamento);

        // Testando métodos
        agendaServico.adicionarServico(ServicoAuto.BATERIA);
        agendaServico.consultarServico();

        // Exibindo informações dos clientes e veículos
        System.out.println("Cliente Maria:");
        System.out.println("Nome: " + clienteMaria.getNome());
        System.out.println("Email: " + clienteMaria.getEmail());
        System.out.println("Veículos de Maria: ");
        for (Veiculo veiculo : clienteMaria.getVeiculos()) {
            System.out.println(veiculo);
        }

        System.out.println("\nCliente Jesus:");
        System.out.println("Nome: " + clienteJesus.getNome());
        System.out.println("Email: " + clienteJesus.getEmail());
        System.out.println("Veículos de Jesus: ");
        for (Veiculo veiculo : clienteJesus.getVeiculos()) {
            System.out.println(veiculo);
        }

        // Exibindo informações da oficina
        System.out.println("\nOficina:");
        System.out.println("Nome: " + oficina.getNome());
        System.out.println("Endereço: " + oficina.getEndereco());
        System.out.println("Razão social: " + oficina.getRazaoSocial());
        System.out.println("CNPJ: " + oficina.getCnpj());


        // Exibindo informações do orçamento
        System.out.println("\nOrçamento:");
        System.out.println("Serviço: " + orcamento.getServicoAuto());
        System.out.println("Preço do Serviço: " + orcamento.getPrecoServico());
        System.out.println("Preço da Peça: " + orcamento.getPrecoPeca());

        // Exibindo informações da agenda de serviço
        System.out.println("\nAgenda de Serviço:");
        System.out.println("Cliente: " + agendaServico.getCliente().getNome());
        System.out.println("Veículo: " + agendaServico.getVeiculo().getModelo());
        System.out.println("Data: " + agendaServico.getData());
        System.out.println("Oficina: " + agendaServico.getOficina().getNome());
        System.out.println("Serviço: " + agendaServico.getServicoAuto());
        System.out.println("Orçamento: ");
        System.out.println("  Serviço: " + agendaServico.getOrcamento().getServicoAuto());
        System.out.println("  Preço do Serviço: " + agendaServico.getOrcamento().getPrecoServico());
        System.out.println("  Preço da Peça: " + agendaServico.getOrcamento().getPrecoPeca());
    }
}