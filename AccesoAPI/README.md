# AccesoAPI - Cliente FUMBBL con MongoDB y MySQL

## Descripción
Aplicación Java que consume la API pública de FUMBBL (Fantasy Universal Monster Blood Bowl League) para importar equipos y jugadores, almacenarlos en MongoDB y migrarlos a MySQL.

## Tecnologías
- **Java 21**
- **Maven**
- **MongoDB** (driver 4.11.1)
- **MySQL** (connector 8.2.0)
- **Gson** (2.13.2) - Serialización JSON
- **Swing** - Interfaz gráfica

## Estructura del Proyecto
```
AccesoAPI/
├── src/main/java/org/example/
│   ├── dao/
│   │   ├── PlayerDAO.java      # DAO MongoDB para jugadores
│   │   └── TeamDAO.java        # DAO MongoDB para equipos
│   ├── interfaz/
│   │   └── VentanaImportarEquipo.java  # GUI Swing
│   ├── model/dto/
│   │   ├── Coach.java
│   │   ├── Player.java
│   │   ├── PlayerRecord.java
│   │   ├── Record.java
│   │   ├── Roster.java
│   │   └── Team.java
│   ├── service/
│   │   └── FumbblApi.java      # Cliente API FUMBBL
│   ├── util/
│   │   ├── DatabaseCreator.java
│   │   ├── MigraMongoASLQ.java # Migración MongoDB → MySQL
│   │   ├── MongoConnection.java
│   │   ├── MySQLConnection.java
│   │   └── MySQLCreadorTablas.java
│   └── Main.java
└── pom.xml
```

## Funcionalidades
1. **Consumo de API FUMBBL** - Obtiene datos de equipos por ID
2. **Almacenamiento en MongoDB** - Guarda equipos y jugadores
3. **Consultas de agregación** - Top goleadores, conteo por posición
4. **Migración a MySQL** - Exporta datos de MongoDB a MySQL
5. **Interfaz gráfica** - Buscar e importar equipos visualmente

## Configuración

### MongoDB
```
URL: mongodb://localhost:27017/
Base de datos: FUMBBL
Colecciones: teams, players
```

### MySQL
```
URL: jdbc:mysql://localhost:3306/FUMBBL
Usuario: admin
Contraseña: (vacía)
```

## Uso

### Interfaz Gráfica
```bash
mvn compile exec:java -Dexec.mainClass="org.example.interfaz.VentanaImportarEquipo"
```

### Migración completa
```bash
mvn compile exec:java -Dexec.mainClass="org.example.Main"
```

## API FUMBBL
- **Endpoint**: `https://fumbbl.com/api/team/get/{teamId}`
- Devuelve información completa del equipo incluyendo jugadores
