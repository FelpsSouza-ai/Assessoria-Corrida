package assessoria.controller;
import assessoria.model.Aluno;
import assessoria.util.InputHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import assessoria.dao.AlunoDAO;
import assessoria.view.*;

public class AlunoController {

    private final Map<String, Aluno> mapAlunos = new LinkedHashMap<>();;
    private final AlunoDAO alunoDAO = new AlunoDAO();
    private final MensagemView mensagemView = new MensagemView();

    private Aluno criarAluno(int id) {
        String nome = pegarNome();
        String email = pegarEmail();
        String cpf = pegarCpf();
        int idade = pegarIdade();
        String telefone = pegarTelefone();
         return new Aluno(id, nome, email, cpf, idade, telefone);
    }

    public void adicionarAluno() {
        int idAluno = pegarMapAlunos().size() + 1;
        AlunoView.mostrarMenuCadastrarAluno();
        mapAlunos.put("K" + idAluno, criarAluno(idAluno));
        alunoDAO.inserirAlunoNoArquivo(pegarMapAlunos());
        mensagemView.mostrarSucesso("Aluno adicionado!!");
    }

//    private int pegarId() {
//        int id = 0;
//        for(Map.Entry<String,Aluno> entry : mapAlunos.entrySet()) {
//            id = entry.getValue().getId();
//        }
//        return id;
//    }

    private String pegarNome() {
       return InputHelper.lerString("Digite o nome completo: ");
    }

    private int pegarIdade() {
        return InputHelper.lerInt("Digite a idade: ");
    }

    private String pegarEmail() {
        return InputHelper.lerEmail("Digite o email (Ex: user@gmail.com): ");
    }

    private String pegarCpf() {
        return InputHelper.lerCpf("Digite o CPF (xxx.xxx.xxx-xx) : ");
    }

    private String pegarTelefone() {
        return InputHelper.lerString("Digite o telefone ((DDD)9xxxx-xxxx): ");
    }

    public Map<String,Aluno> pegarMapAlunos() {
        return new LinkedHashMap<>(mapAlunos);
    }

}
