# 🧪 TP Integrador Final - Desarrollo de APIs en Java con Spring Boot

Este proyecto fue desarrollado como trabajo integrador final para el curso **"Desarrollo de APIs en Java con Spring Boot"** de [TodoCode Academy](https://todocodeacademy.com/).  
El objetivo es aplicar los conocimientos adquiridos para construir una API RESTful en Java usando Spring Boot, orientada a la gestión de un bazar.

## 🧭 Objetivo

Automatizar la gestión de productos, clientes y ventas de un bazar mediante el desarrollo de una API que pueda ser consumida por aplicaciones web y mobile.

## 🧱 Modelo de Datos

### 📦 Producto
- `Long codigo_producto`
- `String nombre`
- `String marca`
- `Double costo`
- `Double cantidad_disponible`

### 🧾 Venta
- `Long codigo_venta`
- `LocalDate fecha_venta`
- `Double total`
- `List<Producto> listaProductos`
- `Cliente unCliente`

### 🧍 Cliente
- `Long id_cliente`
- `String nombre`
- `String apellido`
- `String dni`

## 🔁 Funcionalidades

### 📌 CRUD de Productos
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST   | `/productos/crear` | Crear producto |
| GET    | `/productos` | Listar productos |
| GET    | `/productos/{codigo_producto}` | Obtener producto por ID |
| DELETE | `/productos/eliminar/{codigo_producto}` | Eliminar producto |
| PUT    | `/productos/editar/{codigo_producto}` | Editar producto |

---

### 📌 CRUD de Clientes
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST   | `/clientes/crear` | Crear cliente |
| GET    | `/clientes` | Listar clientes |
| GET    | `/clientes/{id_cliente}` | Obtener cliente por ID |
| DELETE | `/clientes/eliminar/{id_cliente}` | Eliminar cliente |
| PUT    | `/clientes/editar/{id_cliente}` | Editar cliente |

---

### 📌 CRUD de Ventas
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST   | `/ventas/crear` | Crear venta |
| GET    | `/ventas` | Listar ventas |
| GET    | `/ventas/{codigo_venta}` | Obtener venta por ID |
| DELETE | `/ventas/eliminar/{codigo_venta}` | Eliminar venta |
| PUT    | `/ventas/editar/{codigo_venta}` | Editar venta |

---

### 📌 Endpoints adicionales

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/productos/falta_stock` | Listar productos con stock menor a 5 |
| GET | `/ventas/productos/{codigo_venta}` | Listar productos de una venta |
| GET | `/ventas/{fecha_venta}` | Total y cantidad de ventas en una fecha |
| GET | `/ventas/mayor_venta` | Obtener venta con el monto más alto (usa patrón DTO) |

---
## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/wexeljose/Proyecto-Bazar-Tecnologico
   cd Proyecto-Bazar-Tecnologico
