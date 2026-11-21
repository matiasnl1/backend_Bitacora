
package cl.duoc.educacional;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroService {

    private final RegistroRepository repository;

    public RegistroService(RegistroRepository repository) {
        this.repository = repository;
    }

    // READ: listar todos los registros
    public List<Registro> listarTodos() {
        return repository.findAll();
    }

    // READ: buscar un registro por su ID
    public Optional<Registro> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // CREATE: guardar un nuevo registro
    public Registro crear(Registro registro) {
        registro.setId(null);
        return repository.save(registro);
    }

    // UPDATE: actualizar un registro existente
    public Optional<Registro> actualizar(Long id, Registro datos) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setTitulo(datos.getTitulo());
                    existente.setDescripcion(datos.getDescripcion());
                    return repository.save(existente);
                });
    }

    // DELETE: eliminar un registro
    public boolean eliminar(Long id) {
        return repository.findById(id)
                .map(registro -> {
                    repository.delete(registro);
                    return true;
                })
                .orElse(false);
    }
}
