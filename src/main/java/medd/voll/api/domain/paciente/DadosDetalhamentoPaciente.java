package medd.voll.api.domain.paciente;

public record DadosDetalhamentoPaciente<Endereco>(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {

    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), (Endereco) paciente.getEndereco());
    }
}
