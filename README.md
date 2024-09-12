# Manual de API  `Prueba`

Este documento describe cómo interactuar con la API de **Prueba** usando diferentes endpoints categorizados bajo `category` y `product`. Todos los ejemplos aquí descritos se basan en una configuración de servidor local (`localhost:8080`) y la API sigue el formato JSON.

## Información General

- **Base URL:** `http://localhost:8080`

El proyecto esta en Sprint boot java 18  , es necesario tener una base de datos con el nombre de **pruebadb** , verificar los datos de conexión en el archivo **application.properties**

Run: Una vez que se tenga todo listo, se ejecuta el archivo **PruebaApplication**

Herramientas utilizadas:

Postman | Laragon - MySQl | IntelliJ IDEA Community Edition
---

## Endpoints de `Category`

### 1. Crear Categoría (`POST /api/category`)

Este endpoint permite crear una nueva categoría.

- **Método:** `POST`
- **URL:** `http://localhost:8080/api/category`
- **Body:** 

#### Ejemplo de uso:
```json
{
    "name": "utiles",
    "description": ""
}
```
### 2. Actualizar Categoría (`PUT /api/category`)

Este endpoint permite actualizar una categoría existente.

- **Método:** `PUT`
- **URL:** `http://localhost:8080/api/category`
- **Body:**
#### Ejemplo de uso:
```json
{
    "id": 1,
    "name": "juguetes",
    "description": "para menores"
}
```
### 3. Eliminar Categoría (`DELETE /api/category/{id}`)

Este endpoint elimina una categoría por su `id` de forma lógica.

- **Método:** `DELETE`
- **URL:** `http://localhost:8080/api/category/{id}`

#### Ejemplo de uso:

```bash
curl -X DELETE http://localhost:8080/api/category/2
```

### 4. Obtener Categoría por ID (GET /api/category/{id})

Este endpoint devuelve los detalles de una categoría específica mediante su id.

- **Método:** `GET`
- **URL:** `http://localhost:8080/api/category/{id}`

### Ejemplo de uso:

```bash
curl -X GET http://localhost:8080/api/category/1

```
```json
{
    "id": 1,
    "name": "juguetes",
    "description": "para menores"
}
```
### 5. Buscar Categorías (GET /api/category/search?q={query})

Este endpoint permite buscar categorías, puede o no enviar el query param.

- **Método:** `GET`
- **URL:** `http://localhost:8080/api/category/search`

### Ejemplo de uso:

```bash
curl -X GET http://localhost:8080/api/category/search?q=hola
```
---

## Endpoints de `Product`

### 1. Crear Producto (`POST /api/product`)

Este endpoint permite crear un nuevo producto.

- **Método:** `POST`
- **URL:** `http://localhost:8080/api/product`
- **Body:** 

#### Ejemplo de uso:
```json
{
    "name": "camion X500",
    "description": "",
    "quantity": 6,
    "categoryId": 1
}
```
### 2. Actualizar Producto (`PUT /api/product`)

Este endpoint permite actualizar un producto existente.

- **Método:** `PUT`
- **URL:** `http://localhost:8080/api/product`
- **Body:**
#### Ejemplo de uso:
```json
{   
    "id": 1,
    "name": "camion YX500",
    "description": "",
    "quantity": 10,
    "categoryId": 1
}
```
### 3. Eliminar Producto (`DELETE /api/product/{id}`)

Este endpoint elimina un producto por su `id` de forma lógica.

- **Método:** `DELETE`
- **URL:** `http://localhost:8080/api/product/{id}`

#### Ejemplo de uso:

```bash
curl -X DELETE http://localhost:8080/api/product/2
```
### 4. Obtener Producto por ID (GET /api/product/{id})

Este endpoint devuelve los detalles de un producto específica mediante su id.

- **Método:** `GET`
- **URL:** `http://localhost:8080/api/product/{id}`

### Ejemplo de uso:

```bash
curl -X GET http://localhost:8080/api/product/2
```
```json
{
    "id": 2,
    "name": "camion X5000",
    "description": "",
    "quantity": 6.0,
    "category": {
        "id": 1,
        "name": "tecnologia",
        "description": ""
    }
}
```

### 5. Buscar Productos (GET /api/product/search?q={query})

Este endpoint permite buscar productos, puede o no enviar el query param.

- **Método:** `GET`
- **URL:** `http://localhost:8080/api/product/search`

### Ejemplo de uso:

```bash
curl -X GET http://localhost:8080/api/product/search?q=juguetes

```
```json
[
    {
        "id": 8,
        "name": "camion X5sss1",
        "description": "",
        "quantity": 6.0,
        "category": {
            "id": 1,
            "name": "juguetes",
            "description": ""
        }
    },
    {
        "id": 6,
        "name": "camion X5sss0",
        "description": "",
        "quantity": 6.0,
        "category": {
            "id": 1,
            "name": "juguetes",
            "description": ""
        }
    },
    {
        "id": 5,
        "name": "camion X5sss0",
        "description": "",
        "quantity": 6.0,
        "category": {
            "id": 1,
            "name": "juguetes",
            "description": ""
        }
    },
    {
        "id": 4,
        "name": "camion X5sss0",
        "description": "",
        "quantity": 6.0,
        "category": {
            "id": 1,
            "name": "juguetes",
            "description": ""
        }
    },
    {
        "id": 3,
        "name": "camion X5sss0",
        "description": "",
        "quantity": 6.0,
        "category": {
            "id": 1,
            "name": "juguetes",
            "description": ""
        }
    },
    {
        "id": 2,
        "name": "camion X5sss0",
        "description": "",
        "quantity": 6.0,
        "category": {
            "id": 1,
            "name": "juguetes",
            "description": ""
        }
    },
    {
        "id": 1,
        "name": "camion X5sss0",
        "description": "",
        "quantity": 6.0,
        "category": {
            "id": 1,
            "name": "juguetes",
            "description": ""
        }
    }
]
```