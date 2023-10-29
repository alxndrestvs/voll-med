package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoExcpetion;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;

public class ValidadorMedicoAtivo {

    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        // escolha do medico opcional
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoExcpetion("Uma consulta não pode ser agendada com um médico excluído!");
        }
    }

}
