package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoExcpetion;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoExcpetion("Uma consulta não pode ser agendada com um paciente excluído!");
        }
    }
}
