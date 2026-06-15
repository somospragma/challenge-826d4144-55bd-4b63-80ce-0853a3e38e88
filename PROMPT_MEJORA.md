# Prompt para Mejorar el Codigo Base

Copia y pega el siguiente contenido completo en un asistente de IA (Claude, ChatGPT, etc.)
para obtener un ZIP con el proyecto corregido y listo para compilar.

---

```
Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación o descripciones sin código, genera los archivos
correspondientes sin aplicar análisis de compilación
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:
package com.pragma.projectmanagement.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TeamPPBehavior {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String behavior;

    public TeamPPBehavior() {}

    public TeamPPBehavior(String behavior) {
        this.behavior = behavior;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }
}
// === ARCHIVO: src/main/java/com/pragma/projectmanagement/domain/model/TeamPPBehavior.java ===

package com.pragma.projectmanagement.application.service;

import com.pragma.projectmanagement.domain.model.TeamPPBehavior;
import com.pragma.projectmanagement.infrastructure.persistence.TeamPPRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TeamPPService {
    private final TeamPPRepository teamPPRepository;

    public TeamPPService(TeamPPRepository teamPPRepository) {
        this.teamPPRepository = teamPPRepository;
    }

    public Flux<TeamPPBehavior> getAllBehaviors() {
        return teamPPRepository.findAll();
    }

    public Mono<TeamPPBehavior> getBehaviorById(Long id) {
        return teamPPRepository.findById(id);
    }

    public Mono<TeamPPBehavior> saveBehavior(TeamPPBehavior behavior) {
        return teamPPRepository.save(behavior);
    }

    public Mono<Void> deleteBehavior(Long id) {
        return teamPPRepository.deleteById(id);
    }
}
// === ARCHIVO: src/main/java/com/pragma/projectmanagement/application/service/TeamPPService.java ===

package com.pragma.projectmanagement.infrastructure.persistence;

import com.pragma.projectmanagement.domain.model.TeamPPBehavior;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TeamPPRepository extends JpaRepository<TeamPPBehavior, Long> {
    Flux<TeamPPBehavior> findAll();
    Mono<TeamPPBehavior> findById(Long id);
    Mono<TeamPPBehavior> save(TeamPPBehavior behavior);
    Mono<Void> deleteById(Long id);
}
// === ARCHIVO: src/main/java/com/pragma/projectmanagement/infrastructure/persistence/TeamPPRepository.java ===

server:
  port: 8080

spring:
  datasource:
    url: jdbc:h2:mem:testdb
    username: sa
    password:
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.H2Dialect
// === ARCHIVO: src/main/resources/config/application.yml ===

package com.pragma.projectmanagement.infrastructure.controller;

import com.pragma.projectmanagement.application.service.TeamPPService;
import com.pragma.projectmanagement.domain.model.TeamPPBehavior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/teampp")
public class TeamPPController {
    @Autowired
    private TeamPPService teamPPService;

    @GetMapping
    public Flux<TeamPPBehavior> getAllBehaviors() {
        return teamPPService.getAllBehaviors();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<TeamPPBehavior>> getBehaviorById(@PathVariable Long id) {
        return teamPPService.getBehaviorById(id)
               .map(behavior -> ResponseEntity.ok().body(behavior))
               .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<TeamPPBehavior> saveBehavior(@RequestBody TeamPPBehavior behavior) {
        return teamPPService.saveBehavior(behavior);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteBehavior(@PathVariable Long id) {
        return teamPPService.deleteBehavior(id)
               .thenReturn(ResponseEntity.ok().<Void>build());
    }
}
// === ARCHIVO: src/main/java/com/pragma/projectmanagement/infrastructure/controller/TeamPPController.java ===

package com.pragma.projectmanagement.application.service;

import com.pragma.projectmanagement.domain.model.TeamPPBehavior;
import com.pragma.projectmanagement.infrastructure.persistence.TeamPPRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class TeamPPServiceTest {

    @Mock
    private TeamPPRepository teamPPRepository;

    @InjectMocks
    private TeamPPService teamPPService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllBehaviors() {
        TeamPPBehavior behavior = new TeamPPBehavior("Behavior 1");
        when(teamPPRepository.findAll()).thenReturn(Flux.just(behavior));
        StepVerifier.create(teamPPService.getAllBehaviors()).expectNext(behavior).verifyComplete();
    }

    @Test
    void getBehaviorById() {
        Long id = 1L;
        TeamPPBehavior behavior = new TeamPPBehavior("Behavior 1");
        when(teamPPRepository.findById(id)).thenReturn(Mono.just(behavior));
        StepVerifier.create(teamPPService.getBehaviorById(id)).expectNext(behavior).verifyComplete();
    }

    @Test
    void saveBehavior() {
        TeamPPBehavior behavior = new TeamPPBehavior("Behavior 1");
        when(teamPPRepository.save(behavior)).thenReturn(Mono.just(behavior));
        StepVerifier.create(teamPPService.saveBehavior(behavior)).expectNext(behavior).verifyComplete();
    }

    @Test
    void deleteBehavior() {
        Long id = 1L;
        when(teamPPRepository.deleteById(id)).thenReturn(Mono.empty());
        StepVerifier.create(teamPPService.deleteBehavior(id)).verifyComplete();
    }
}
// === ARCHIVO: src/test/java/com/pragma/projectmanagement/application/service/TeamPPServiceTest.java ===

```
