export function obtenerDisponibles() {
    return [
        { nombre: "Diseño Web", descripcion: "Sitios modernos y responsive", precio: "$500" },
        { nombre: "SEO", descripcion: "Posicionamiento en buscadores", precio: "$300" },
        { nombre: "Marketing", descripcion: "Estrategias digitales", precio: "$400" }
    ];
}

const contenedor = document.getElementById("catalogo");

const productos = obtenerDisponibles();

contenedor.innerHTML = productos.map(p => `
    <div class="card">
        <h3>${p.nombre}</h3>
        <p>${p.descripcion}</p>
        <span>${p.precio}</span>
    </div>
`).join("");