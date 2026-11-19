package cl.duoc.educacional;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registros")
public class RegistroController {

    private final RegistroRepository repository;

    public RegistroController(RegistroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Registro> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registro> obtenerPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Registro> crear(@Valid @RequestBody Registro registro) {
        registro.setId(null);
        Registro guardado = repository.save(registro);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registro> actualizar(@PathVariable Long id, @Valid @RequestBody Registro datos) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setTitulo(datos.getTitulo());
                    existente.setDescripcion(datos.getDescripcion());
                    return ResponseEntity.ok(repository.save(existente));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}