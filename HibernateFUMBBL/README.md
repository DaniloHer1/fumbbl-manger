# HibernateFUMBBL - Acceso a datos con Hibernate/JPA

## Descripción
Aplicación Java EE que utiliza Hibernate ORM para gestionar datos de equipos y jugadores de FUMBBL almacenados en MySQL.

## Tecnologías
- **Java 11**
- **Maven**
- **Hibernate ORM 6.0.2**
- **Jakarta EE 9+** (JPA 3.0, JAX-RS 3.0, CDI 3.0)
- **MySQL** (connector 8.2.0)
- **JUnit 5** (testing)

## Estructura del Proyecto
```
HibernateFUMBBL/
├── src/main/java/
│   ├── DAO/
│   │   ├── PlayerDAO.java      # Operaciones CRUD jugadores
│   │   └── TeamDAO.java        # Operaciones CRUD equipos
│   ├── Entidades/
│   │   ├── PlayersEntity.java  # Entidad JPA jugadores
│   │   └── TeamsEntity.java    # Entidad JPA equipos
│   ├── util/
│   │   └── HibernateUtil.java  # Factory EntityManager
│   ├── com/example/hibernatefumbbl/
│   │   ├── HelloApplication.java  # JAX-RS Application
│   │   └── HelloResource.java     # Endpoint REST
│   └── Main.java
├── src/main/resources/META-INF/
│   ├── persistence.xml         # Configuración JPA
│   └── beans.xml               # Configuración CDI
└── pom.xml
```

## Entidades

### TeamsEntity
| Campo | Tipo | Descripción |
|-------|------|-------------|
| id | int | ID del equipo (PK) |
| name | String | Nombre del equipo |
| coachId | Integer | ID del entrenador |
| coachName | String | Nombre del entrenador |
| rosterId | Integer | ID del roster |
| teamValue | Integer | Valor del equipo |
| wins/ties/losses | Integer | Estadísticas |

### PlayersEntity
| Campo | Tipo | Descripción |
|-------|------|-------------|
| id | int | ID del jugador (PK) |
| teamId | int | ID del equipo (FK) |
| name | String | Nombre del jugador |
| position | String | Posición |
| touchdowns | Integer | Touchdowns anotados |
| skills | String | Habilidades |

## Configuración

### persistence.xml
```xml
<property name="hibernate.connection.url" value="jdbc:mysql://localhost:3306/FUMBBL"/>
<property name="hibernate.connection.username" value="admin"/>
```

## Operaciones DAO

### TeamDAO
- `buscarPorId(Integer id)` - Buscar equipo por ID
- `listarEquipos()` - Listar todos los equipos
- `buscarPorNombre(String nombre)` - Buscar por nombre (LIKE)
- `guardarEquipo(TeamsEntity)` - Insertar equipo
- `actualizarEquipo(TeamsEntity)` - Actualizar equipo
- `borrarEquipo(Integer id)` - Eliminar equipo

### PlayerDAO
- `buscarPorIdEquipo(int teamId)` - Jugadores de un equipo
- `maximosGoleadores(int limite)` - Top N goleadores
- `buscarPorPosicion(String position)` - Filtrar por posición

## Uso

### Compilar
```bash
./mvnw clean compile
```

### Ejecutar Main
```bash
./mvnw exec:java -Dexec.mainClass="Main"
```

### Empaquetar WAR
```bash
./mvnw package
```

## Ejemplo de Salida
```
=== 1. BUSCAR TEAM POR ID ===
Team encontrado: [Nombre]
Valor: 1000000

=== 4. TOP 5 GOLEADORES ===
1. Jugador A - 15 TDs
2. Jugador B - 12 TDs
...
```
