package cl.duoc.educacional;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registros")
public class RegistroController {

    private final RegistroService service;

    public RegistroController(RegistroService service) {
        this.service = service;
    }

    // READ: listar todos los registros
    @GetMapping
    public List<Registro> listar() {
        return service.listarTodos();
    }

    // READ: obtener un registro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Registro> obtenerPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // CREATE: crear un registro
    @PostMapping
    public ResponseEntity<Registro> crear(
            @Valid @RequestBody Registro registro) {

        Registro guardado = service.crear(registro);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(guardado);
    }

    // UPDATE: actualizar un registro
    @PutMapping("/{id}")
    public ResponseEntity<Registro> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Registro datos) {

        return service.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE: eliminar un registro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        boolean eliminado = service.eliminar(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
