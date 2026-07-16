console.log("------1 agregarProducto()-------")
const productos1 = ["manzana", "leche", "pan"];

const productosActualizado = [...productos1, "huevos"];

console.log(productos1);
console.log(productosActualizado);

console.log("-------2 formatearProducto()------")
const producto2 = { nombre: "Manzana", precio: 100, categoria: "fruta" };

function formatearProducto({ nombre, precio, categoria }) {
    return `- ${nombre} \n- $${precio} \n- ${categoria}`;
}

console.log(formatearProducto(producto2));

console.log("-------3 obtenerDisponibles()------")
const productos3 = [
    { nombre: "Manzana", precio: 100, stock: 5 },
    { nombre: "Leche",   precio: 200, stock: 0 },
    { nombre: "Pan",     precio: 150, stock: 3 },
    { nombre: "Huevos",  precio: 80,  stock: 0 },
];

function obtenerDisponibles(productos3) {
    return productos3.filter(producto3 => producto3.stock > 0);
}

console.log(obtenerDisponibles(productos3));

console.log("-------4 calcularValorInventario()------")
const productos4 = [
    { nombre: "Manzana", precio: 100, stock: 5 },
    { nombre: "Leche",   precio: 200, stock: 3 },
    { nombre: "Pan",     precio: 150, stock: 0 },
    { nombre: "Huevos",  precio: 80,  stock: 10 },
];

function calcularValorInventario(productos4) {
    return productos4.reduce((total, producto4) => {
        return total + (producto4.precio * producto4.stock);
    }, 0);
}

console.log(calcularValorInventario(productos4));

console.log("---------5 obtenerNombres()----------");
const productos5 = [
    { nombre: "Manzana", precio: 100, stock: 5 },
    { nombre: "Leche",   precio: 200, stock: 3 },
    { nombre: "Pan",     precio: 150, stock: 0 },
    { nombre: "Huevos",  precio: 80,  stock: 10 },
];

function obtenerNombres(productos5) {
    return productos5.map(producto5 => producto5.nombre);
}

console.log(obtenerNombres(productos5));

console.log("------6 simularFetchProductos()")

function simularFetchProductos() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            const exito = true; // cambiá a false para probar el error

            if (exito) {
                resolve([
                    { nombre: "Manzana", precio: 100, stock: 5 },
                    { nombre: "Leche",   precio: 200, stock: 3 },
                ]);
            } else {
                reject(new Error("No se pudieron cargar los productos"));
            }
        }, 1000);
    });
}

// Consumimos la Promise con async/await
async function cargarProductos() {
    try {
        console.log("Cargando productos...");
        const productos = await simularFetchProductos();
        console.log("Productos recibidos:", productos);
    } catch (error) {
        console.error("Error:", error.message);
    }
}

cargarProductos();
