# 🏈 FUMBBL Blood Bowl Manager

Aplicación Java completa para gestión de equipos de Blood Bowl.

## 📂 Estructura del Proyecto

Este repositorio contiene **2 proyectos Java**:

### 1️⃣ AccesoAPI (MongoDB)
Proyecto principal con:
- ✅ Consumo API REST FUMBBL
- ✅ Persistencia MongoDB
- ✅ Consultas de agregación
- ✅ Interfaz gráfica Swing
- ✅ Migración a MySQL

📁 Ver [AccesoAPI/README.md](./AccesoAPI/README.md)

### 2️⃣ HibernateFUMBBL
Proyecto ORM con:
- ✅ Hibernate/JPA
- ✅ Entidades mapeadas
- ✅ Relaciones @OneToMany/@ManyToOne
- ✅ Consultas HQL

📁 Ver [HibernateFUMBBL/README.md](./HibernateFUMBBL/README.md)

## 🚀 Instalación Rápida
```bash
# Clonar repositorio
git clone https://github.com/TU_USUARIO/fumbbl-bloodbowl-manager.git
cd fumbbl-bloodbowl-manager

# Proyecto 1: MongoDB
cd AccesoAPI
mvn clean install
mvn exec:java -Dexec.mainClass="org.example.interfaz.VentanaImportarEquipo"

# Proyecto 2: Hibernate
cd ../HibernateFUMBBL
mvn clean install
mvn exec:java -Dexec.mainClass="Main"
```

## 📋 Requisitos

- ☕ Java 21+
- 📦 Maven 3.x
- 🍃 MongoDB 7.x
- 🐬 MySQL 8.x

## 👥 Autor

**Daniel Hernando** - DAM 2º - IES Comercio, Logroño
